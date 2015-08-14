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
    public String getGrammarFileName() { return "InternalBug381381TestLanguage.g"; }


     
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
    // InternalBug381381TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug381381TestLanguage.g:61:1: ( ruleModel EOF )
            // InternalBug381381TestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug381381TestLanguage.g:69:1: ruleModel : ( ( rule__Model__StmtAssignment ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:73:2: ( ( ( rule__Model__StmtAssignment ) ) )
            // InternalBug381381TestLanguage.g:74:1: ( ( rule__Model__StmtAssignment ) )
            {
            // InternalBug381381TestLanguage.g:74:1: ( ( rule__Model__StmtAssignment ) )
            // InternalBug381381TestLanguage.g:75:1: ( rule__Model__StmtAssignment )
            {
             before(grammarAccess.getModelAccess().getStmtAssignment()); 
            // InternalBug381381TestLanguage.g:76:1: ( rule__Model__StmtAssignment )
            // InternalBug381381TestLanguage.g:76:2: rule__Model__StmtAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:88:1: entryRuleCopyFieldNameToVariableStmt : ruleCopyFieldNameToVariableStmt EOF ;
    public final void entryRuleCopyFieldNameToVariableStmt() throws RecognitionException {
        try {
            // InternalBug381381TestLanguage.g:89:1: ( ruleCopyFieldNameToVariableStmt EOF )
            // InternalBug381381TestLanguage.g:90:1: ruleCopyFieldNameToVariableStmt EOF
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCopyFieldNameToVariableStmt();

            state._fsp--;

             after(grammarAccess.getCopyFieldNameToVariableStmtRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug381381TestLanguage.g:97:1: ruleCopyFieldNameToVariableStmt : ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) ) ;
    public final void ruleCopyFieldNameToVariableStmt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:101:2: ( ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) ) )
            // InternalBug381381TestLanguage.g:102:1: ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) )
            {
            // InternalBug381381TestLanguage.g:102:1: ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) )
            // InternalBug381381TestLanguage.g:103:1: ( rule__CopyFieldNameToVariableStmt__Group__0 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup()); 
            // InternalBug381381TestLanguage.g:104:1: ( rule__CopyFieldNameToVariableStmt__Group__0 )
            // InternalBug381381TestLanguage.g:104:2: rule__CopyFieldNameToVariableStmt__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:118:1: rule__CopyFieldNameToVariableStmt__Group__0 : rule__CopyFieldNameToVariableStmt__Group__0__Impl rule__CopyFieldNameToVariableStmt__Group__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:122:1: ( rule__CopyFieldNameToVariableStmt__Group__0__Impl rule__CopyFieldNameToVariableStmt__Group__1 )
            // InternalBug381381TestLanguage.g:123:2: rule__CopyFieldNameToVariableStmt__Group__0__Impl rule__CopyFieldNameToVariableStmt__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__CopyFieldNameToVariableStmt__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:130:1: rule__CopyFieldNameToVariableStmt__Group__0__Impl : ( 'FIELD-NAME-TO-VARIABLE' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:134:1: ( ( 'FIELD-NAME-TO-VARIABLE' ) )
            // InternalBug381381TestLanguage.g:135:1: ( 'FIELD-NAME-TO-VARIABLE' )
            {
            // InternalBug381381TestLanguage.g:135:1: ( 'FIELD-NAME-TO-VARIABLE' )
            // InternalBug381381TestLanguage.g:136:1: 'FIELD-NAME-TO-VARIABLE'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getFIELDNAMETOVARIABLEKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:149:1: rule__CopyFieldNameToVariableStmt__Group__1 : rule__CopyFieldNameToVariableStmt__Group__1__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:153:1: ( rule__CopyFieldNameToVariableStmt__Group__1__Impl )
            // InternalBug381381TestLanguage.g:154:2: rule__CopyFieldNameToVariableStmt__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:160:1: rule__CopyFieldNameToVariableStmt__Group__1__Impl : ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:164:1: ( ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) ) )
            // InternalBug381381TestLanguage.g:165:1: ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) )
            {
            // InternalBug381381TestLanguage.g:165:1: ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) )
            // InternalBug381381TestLanguage.g:166:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1()); 
            // InternalBug381381TestLanguage.g:167:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 )
            // InternalBug381381TestLanguage.g:167:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:181:1: rule__CopyFieldNameToVariableStmt__Group_1_0__0 : rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:185:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__1 )
            // InternalBug381381TestLanguage.g:186:2: rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:193:1: rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:197:1: ( ( ',' ) )
            // InternalBug381381TestLanguage.g:198:1: ( ',' )
            {
            // InternalBug381381TestLanguage.g:198:1: ( ',' )
            // InternalBug381381TestLanguage.g:199:1: ','
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_0_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:212:1: rule__CopyFieldNameToVariableStmt__Group_1_0__1 : rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__2 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:216:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__2 )
            // InternalBug381381TestLanguage.g:217:2: rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:224:1: rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl : ( 'SCREEN' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:228:1: ( ( 'SCREEN' ) )
            // InternalBug381381TestLanguage.g:229:1: ( 'SCREEN' )
            {
            // InternalBug381381TestLanguage.g:229:1: ( 'SCREEN' )
            // InternalBug381381TestLanguage.g:230:1: 'SCREEN'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getSCREENKeyword_1_0_1()); 
            match(input,13,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:243:1: rule__CopyFieldNameToVariableStmt__Group_1_0__2 : rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__3 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:247:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__3 )
            // InternalBug381381TestLanguage.g:248:2: rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:255:1: rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl : ( '=' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:259:1: ( ( '=' ) )
            // InternalBug381381TestLanguage.g:260:1: ( '=' )
            {
            // InternalBug381381TestLanguage.g:260:1: ( '=' )
            // InternalBug381381TestLanguage.g:261:1: '='
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_0_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:274:1: rule__CopyFieldNameToVariableStmt__Group_1_0__3 : rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__4 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:278:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__4 )
            // InternalBug381381TestLanguage.g:279:2: rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__4
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:286:1: rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl : ( '(' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:290:1: ( ( '(' ) )
            // InternalBug381381TestLanguage.g:291:1: ( '(' )
            {
            // InternalBug381381TestLanguage.g:291:1: ( '(' )
            // InternalBug381381TestLanguage.g:292:1: '('
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLeftParenthesisKeyword_1_0_3()); 
            match(input,15,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:305:1: rule__CopyFieldNameToVariableStmt__Group_1_0__4 : rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__5 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:309:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__5 )
            // InternalBug381381TestLanguage.g:310:2: rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__5
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:317:1: rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl : ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:321:1: ( ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) ) )
            // InternalBug381381TestLanguage.g:322:1: ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) )
            {
            // InternalBug381381TestLanguage.g:322:1: ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) )
            // InternalBug381381TestLanguage.g:323:1: ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLineAssignment_1_0_4()); 
            // InternalBug381381TestLanguage.g:324:1: ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 )
            // InternalBug381381TestLanguage.g:324:2: rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:334:1: rule__CopyFieldNameToVariableStmt__Group_1_0__5 : rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__6 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:338:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__6 )
            // InternalBug381381TestLanguage.g:339:2: rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__6
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:346:1: rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:350:1: ( ( ',' ) )
            // InternalBug381381TestLanguage.g:351:1: ( ',' )
            {
            // InternalBug381381TestLanguage.g:351:1: ( ',' )
            // InternalBug381381TestLanguage.g:352:1: ','
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_0_5()); 
            match(input,12,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:365:1: rule__CopyFieldNameToVariableStmt__Group_1_0__6 : rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__7 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:369:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__7 )
            // InternalBug381381TestLanguage.g:370:2: rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__7
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:377:1: rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl : ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:381:1: ( ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) ) )
            // InternalBug381381TestLanguage.g:382:1: ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) )
            {
            // InternalBug381381TestLanguage.g:382:1: ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) )
            // InternalBug381381TestLanguage.g:383:1: ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getColumnAssignment_1_0_6()); 
            // InternalBug381381TestLanguage.g:384:1: ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 )
            // InternalBug381381TestLanguage.g:384:2: rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:394:1: rule__CopyFieldNameToVariableStmt__Group_1_0__7 : rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:398:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl )
            // InternalBug381381TestLanguage.g:399:2: rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:405:1: rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl : ( ')' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:409:1: ( ( ')' ) )
            // InternalBug381381TestLanguage.g:410:1: ( ')' )
            {
            // InternalBug381381TestLanguage.g:410:1: ( ')' )
            // InternalBug381381TestLanguage.g:411:1: ')'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getRightParenthesisKeyword_1_0_7()); 
            match(input,16,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:440:1: rule__CopyFieldNameToVariableStmt__Group_1_1__0 : rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:444:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__1 )
            // InternalBug381381TestLanguage.g:445:2: rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:452:1: rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:456:1: ( ( ',' ) )
            // InternalBug381381TestLanguage.g:457:1: ( ',' )
            {
            // InternalBug381381TestLanguage.g:457:1: ( ',' )
            // InternalBug381381TestLanguage.g:458:1: ','
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:471:1: rule__CopyFieldNameToVariableStmt__Group_1_1__1 : rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__2 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:475:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__2 )
            // InternalBug381381TestLanguage.g:476:2: rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:483:1: rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl : ( 'VAR' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:487:1: ( ( 'VAR' ) )
            // InternalBug381381TestLanguage.g:488:1: ( 'VAR' )
            {
            // InternalBug381381TestLanguage.g:488:1: ( 'VAR' )
            // InternalBug381381TestLanguage.g:489:1: 'VAR'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getVARKeyword_1_1_1()); 
            match(input,17,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:502:1: rule__CopyFieldNameToVariableStmt__Group_1_1__2 : rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__3 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:506:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__3 )
            // InternalBug381381TestLanguage.g:507:2: rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:514:1: rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl : ( '=' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:518:1: ( ( '=' ) )
            // InternalBug381381TestLanguage.g:519:1: ( '=' )
            {
            // InternalBug381381TestLanguage.g:519:1: ( '=' )
            // InternalBug381381TestLanguage.g:520:1: '='
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_1_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:533:1: rule__CopyFieldNameToVariableStmt__Group_1_1__3 : rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:537:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl )
            // InternalBug381381TestLanguage.g:538:2: rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:544:1: rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl : ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:548:1: ( ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) ) )
            // InternalBug381381TestLanguage.g:549:1: ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) )
            {
            // InternalBug381381TestLanguage.g:549:1: ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) )
            // InternalBug381381TestLanguage.g:550:1: ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getNameAssignment_1_1_3()); 
            // InternalBug381381TestLanguage.g:551:1: ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 )
            // InternalBug381381TestLanguage.g:551:2: rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:569:1: rule__CopyFieldNameToVariableStmt__Group_1_2__0 : rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:573:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__1 )
            // InternalBug381381TestLanguage.g:574:2: rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:581:1: rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:585:1: ( ( ',' ) )
            // InternalBug381381TestLanguage.g:586:1: ( ',' )
            {
            // InternalBug381381TestLanguage.g:586:1: ( ',' )
            // InternalBug381381TestLanguage.g:587:1: ','
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getCommaKeyword_1_2_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:600:1: rule__CopyFieldNameToVariableStmt__Group_1_2__1 : rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__2 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:604:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__2 )
            // InternalBug381381TestLanguage.g:605:2: rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:612:1: rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl : ( 'TYPE' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:616:1: ( ( 'TYPE' ) )
            // InternalBug381381TestLanguage.g:617:1: ( 'TYPE' )
            {
            // InternalBug381381TestLanguage.g:617:1: ( 'TYPE' )
            // InternalBug381381TestLanguage.g:618:1: 'TYPE'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getTYPEKeyword_1_2_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:631:1: rule__CopyFieldNameToVariableStmt__Group_1_2__2 : rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__3 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:635:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__3 )
            // InternalBug381381TestLanguage.g:636:2: rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__3
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:643:1: rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl : ( '=' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:647:1: ( ( '=' ) )
            // InternalBug381381TestLanguage.g:648:1: ( '=' )
            {
            // InternalBug381381TestLanguage.g:648:1: ( '=' )
            // InternalBug381381TestLanguage.g:649:1: '='
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getEqualsSignKeyword_1_2_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:662:1: rule__CopyFieldNameToVariableStmt__Group_1_2__3 : rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:666:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl )
            // InternalBug381381TestLanguage.g:667:2: rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:673:1: rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl : ( 'REPLACE' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:677:1: ( ( 'REPLACE' ) )
            // InternalBug381381TestLanguage.g:678:1: ( 'REPLACE' )
            {
            // InternalBug381381TestLanguage.g:678:1: ( 'REPLACE' )
            // InternalBug381381TestLanguage.g:679:1: 'REPLACE'
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getREPLACEKeyword_1_2_3()); 
            match(input,19,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:701:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 {...}?;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1());
            
        try {
            // InternalBug381381TestLanguage.g:706:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 {...}?)
            // InternalBug381381TestLanguage.g:707:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:718:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // InternalBug381381TestLanguage.g:723:1: ( ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) ) )
            // InternalBug381381TestLanguage.g:724:3: ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) )
            {
            // InternalBug381381TestLanguage.g:724:3: ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( LA1_0 == 12 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) ) {
                int LA1_1 = input.LA(2);

                if ( LA1_1 == 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) ) {
                    alt1=1;
                }
                else if ( LA1_1 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) ) {
                    alt1=2;
                }
                else if ( LA1_1 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) {
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
                    // InternalBug381381TestLanguage.g:726:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) )
                    {
                    // InternalBug381381TestLanguage.g:726:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) )
                    // InternalBug381381TestLanguage.g:727:5: {...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0)");
                    }
                    // InternalBug381381TestLanguage.g:727:124: ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) )
                    // InternalBug381381TestLanguage.g:728:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // InternalBug381381TestLanguage.g:734:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) )
                    // InternalBug381381TestLanguage.g:736:7: ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 )
                    {
                     before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_0()); 
                    // InternalBug381381TestLanguage.g:737:7: ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 )
                    // InternalBug381381TestLanguage.g:737:8: rule__CopyFieldNameToVariableStmt__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalBug381381TestLanguage.g:743:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) )
                    {
                    // InternalBug381381TestLanguage.g:743:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) )
                    // InternalBug381381TestLanguage.g:744:5: {...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1)");
                    }
                    // InternalBug381381TestLanguage.g:744:124: ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) )
                    // InternalBug381381TestLanguage.g:745:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // InternalBug381381TestLanguage.g:751:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) )
                    // InternalBug381381TestLanguage.g:753:7: ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 )
                    {
                     before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_1()); 
                    // InternalBug381381TestLanguage.g:754:7: ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 )
                    // InternalBug381381TestLanguage.g:754:8: rule__CopyFieldNameToVariableStmt__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalBug381381TestLanguage.g:760:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) )
                    {
                    // InternalBug381381TestLanguage.g:760:4: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) )
                    // InternalBug381381TestLanguage.g:761:5: {...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2)");
                    }
                    // InternalBug381381TestLanguage.g:761:124: ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) )
                    // InternalBug381381TestLanguage.g:762:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // InternalBug381381TestLanguage.g:768:6: ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) )
                    // InternalBug381381TestLanguage.g:770:7: ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 )
                    {
                     before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_2()); 
                    // InternalBug381381TestLanguage.g:771:7: ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 )
                    // InternalBug381381TestLanguage.g:771:8: rule__CopyFieldNameToVariableStmt__Group_1_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:786:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )? ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:790:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )? )
            // InternalBug381381TestLanguage.g:791:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalBug381381TestLanguage.g:792:2: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( LA2_0 == 12 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug381381TestLanguage.g:792:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:799:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )? ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:803:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )? )
            // InternalBug381381TestLanguage.g:804:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalBug381381TestLanguage.g:805:2: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( LA3_0 == 12 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug381381TestLanguage.g:805:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:812:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:816:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl )
            // InternalBug381381TestLanguage.g:817:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:830:1: rule__Model__StmtAssignment : ( ruleCopyFieldNameToVariableStmt ) ;
    public final void rule__Model__StmtAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:834:1: ( ( ruleCopyFieldNameToVariableStmt ) )
            // InternalBug381381TestLanguage.g:835:1: ( ruleCopyFieldNameToVariableStmt )
            {
            // InternalBug381381TestLanguage.g:835:1: ( ruleCopyFieldNameToVariableStmt )
            // InternalBug381381TestLanguage.g:836:1: ruleCopyFieldNameToVariableStmt
            {
             before(grammarAccess.getModelAccess().getStmtCopyFieldNameToVariableStmtParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug381381TestLanguage.g:845:1: rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 : ( RULE_INT ) ;
    public final void rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:849:1: ( ( RULE_INT ) )
            // InternalBug381381TestLanguage.g:850:1: ( RULE_INT )
            {
            // InternalBug381381TestLanguage.g:850:1: ( RULE_INT )
            // InternalBug381381TestLanguage.g:851:1: RULE_INT
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLineINTTerminalRuleCall_1_0_4_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:860:1: rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 : ( RULE_INT ) ;
    public final void rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:864:1: ( ( RULE_INT ) )
            // InternalBug381381TestLanguage.g:865:1: ( RULE_INT )
            {
            // InternalBug381381TestLanguage.g:865:1: ( RULE_INT )
            // InternalBug381381TestLanguage.g:866:1: RULE_INT
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getColumnINTTerminalRuleCall_1_0_6_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
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
    // InternalBug381381TestLanguage.g:875:1: rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 : ( RULE_ID ) ;
    public final void rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug381381TestLanguage.g:879:1: ( ( RULE_ID ) )
            // InternalBug381381TestLanguage.g:880:1: ( RULE_ID )
            {
            // InternalBug381381TestLanguage.g:880:1: ( RULE_ID )
            // InternalBug381381TestLanguage.g:881:1: RULE_ID
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getNameIDTerminalRuleCall_1_1_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000001002L});
    }


}
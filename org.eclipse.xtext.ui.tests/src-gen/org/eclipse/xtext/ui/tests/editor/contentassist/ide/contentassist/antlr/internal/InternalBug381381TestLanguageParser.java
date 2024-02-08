package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug381381TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalBug381381TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'FIELD-NAME-TO-VARIABLE'", "','", "'SCREEN'", "'='", "'('", "')'", "'VAR'", "'TYPE'", "'REPLACE'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
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
    // InternalBug381381TestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug381381TestLanguage.g:59:1: ( ruleModel EOF )
            // InternalBug381381TestLanguage.g:60:1: ruleModel EOF
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
    // InternalBug381381TestLanguage.g:67:1: ruleModel : ( ( rule__Model__StmtAssignment ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:71:2: ( ( ( rule__Model__StmtAssignment ) ) )
            // InternalBug381381TestLanguage.g:72:2: ( ( rule__Model__StmtAssignment ) )
            {
            // InternalBug381381TestLanguage.g:72:2: ( ( rule__Model__StmtAssignment ) )
            // InternalBug381381TestLanguage.g:73:3: ( rule__Model__StmtAssignment )
            {
             before(grammarAccess.getModelAccess().getStmtAssignment()); 
            // InternalBug381381TestLanguage.g:74:3: ( rule__Model__StmtAssignment )
            // InternalBug381381TestLanguage.g:74:4: rule__Model__StmtAssignment
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
    // InternalBug381381TestLanguage.g:83:1: entryRuleCopyFieldNameToVariableStmt : ruleCopyFieldNameToVariableStmt EOF ;
    public final void entryRuleCopyFieldNameToVariableStmt() throws RecognitionException {
        try {
            // InternalBug381381TestLanguage.g:84:1: ( ruleCopyFieldNameToVariableStmt EOF )
            // InternalBug381381TestLanguage.g:85:1: ruleCopyFieldNameToVariableStmt EOF
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
    // InternalBug381381TestLanguage.g:92:1: ruleCopyFieldNameToVariableStmt : ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) ) ;
    public final void ruleCopyFieldNameToVariableStmt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:96:2: ( ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) ) )
            // InternalBug381381TestLanguage.g:97:2: ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) )
            {
            // InternalBug381381TestLanguage.g:97:2: ( ( rule__CopyFieldNameToVariableStmt__Group__0 ) )
            // InternalBug381381TestLanguage.g:98:3: ( rule__CopyFieldNameToVariableStmt__Group__0 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup()); 
            // InternalBug381381TestLanguage.g:99:3: ( rule__CopyFieldNameToVariableStmt__Group__0 )
            // InternalBug381381TestLanguage.g:99:4: rule__CopyFieldNameToVariableStmt__Group__0
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
    // InternalBug381381TestLanguage.g:107:1: rule__CopyFieldNameToVariableStmt__Group__0 : rule__CopyFieldNameToVariableStmt__Group__0__Impl rule__CopyFieldNameToVariableStmt__Group__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:111:1: ( rule__CopyFieldNameToVariableStmt__Group__0__Impl rule__CopyFieldNameToVariableStmt__Group__1 )
            // InternalBug381381TestLanguage.g:112:2: rule__CopyFieldNameToVariableStmt__Group__0__Impl rule__CopyFieldNameToVariableStmt__Group__1
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
    // InternalBug381381TestLanguage.g:119:1: rule__CopyFieldNameToVariableStmt__Group__0__Impl : ( 'FIELD-NAME-TO-VARIABLE' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:123:1: ( ( 'FIELD-NAME-TO-VARIABLE' ) )
            // InternalBug381381TestLanguage.g:124:1: ( 'FIELD-NAME-TO-VARIABLE' )
            {
            // InternalBug381381TestLanguage.g:124:1: ( 'FIELD-NAME-TO-VARIABLE' )
            // InternalBug381381TestLanguage.g:125:2: 'FIELD-NAME-TO-VARIABLE'
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
    // InternalBug381381TestLanguage.g:134:1: rule__CopyFieldNameToVariableStmt__Group__1 : rule__CopyFieldNameToVariableStmt__Group__1__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:138:1: ( rule__CopyFieldNameToVariableStmt__Group__1__Impl )
            // InternalBug381381TestLanguage.g:139:2: rule__CopyFieldNameToVariableStmt__Group__1__Impl
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
    // InternalBug381381TestLanguage.g:145:1: rule__CopyFieldNameToVariableStmt__Group__1__Impl : ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:149:1: ( ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) ) )
            // InternalBug381381TestLanguage.g:150:1: ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) )
            {
            // InternalBug381381TestLanguage.g:150:1: ( ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 ) )
            // InternalBug381381TestLanguage.g:151:2: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1()); 
            // InternalBug381381TestLanguage.g:152:2: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 )
            // InternalBug381381TestLanguage.g:152:3: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1
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
    // InternalBug381381TestLanguage.g:161:1: rule__CopyFieldNameToVariableStmt__Group_1_0__0 : rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:165:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__1 )
            // InternalBug381381TestLanguage.g:166:2: rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__1
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
    // InternalBug381381TestLanguage.g:173:1: rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:177:1: ( ( ',' ) )
            // InternalBug381381TestLanguage.g:178:1: ( ',' )
            {
            // InternalBug381381TestLanguage.g:178:1: ( ',' )
            // InternalBug381381TestLanguage.g:179:2: ','
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
    // InternalBug381381TestLanguage.g:188:1: rule__CopyFieldNameToVariableStmt__Group_1_0__1 : rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__2 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:192:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__2 )
            // InternalBug381381TestLanguage.g:193:2: rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__2
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
    // InternalBug381381TestLanguage.g:200:1: rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl : ( 'SCREEN' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:204:1: ( ( 'SCREEN' ) )
            // InternalBug381381TestLanguage.g:205:1: ( 'SCREEN' )
            {
            // InternalBug381381TestLanguage.g:205:1: ( 'SCREEN' )
            // InternalBug381381TestLanguage.g:206:2: 'SCREEN'
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
    // InternalBug381381TestLanguage.g:215:1: rule__CopyFieldNameToVariableStmt__Group_1_0__2 : rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__3 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:219:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__3 )
            // InternalBug381381TestLanguage.g:220:2: rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__3
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
    // InternalBug381381TestLanguage.g:227:1: rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl : ( '=' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:231:1: ( ( '=' ) )
            // InternalBug381381TestLanguage.g:232:1: ( '=' )
            {
            // InternalBug381381TestLanguage.g:232:1: ( '=' )
            // InternalBug381381TestLanguage.g:233:2: '='
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
    // InternalBug381381TestLanguage.g:242:1: rule__CopyFieldNameToVariableStmt__Group_1_0__3 : rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__4 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:246:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__4 )
            // InternalBug381381TestLanguage.g:247:2: rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__4
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
    // InternalBug381381TestLanguage.g:254:1: rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl : ( '(' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:258:1: ( ( '(' ) )
            // InternalBug381381TestLanguage.g:259:1: ( '(' )
            {
            // InternalBug381381TestLanguage.g:259:1: ( '(' )
            // InternalBug381381TestLanguage.g:260:2: '('
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
    // InternalBug381381TestLanguage.g:269:1: rule__CopyFieldNameToVariableStmt__Group_1_0__4 : rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__5 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:273:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__5 )
            // InternalBug381381TestLanguage.g:274:2: rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__5
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
    // InternalBug381381TestLanguage.g:281:1: rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl : ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:285:1: ( ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) ) )
            // InternalBug381381TestLanguage.g:286:1: ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) )
            {
            // InternalBug381381TestLanguage.g:286:1: ( ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 ) )
            // InternalBug381381TestLanguage.g:287:2: ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLineAssignment_1_0_4()); 
            // InternalBug381381TestLanguage.g:288:2: ( rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 )
            // InternalBug381381TestLanguage.g:288:3: rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4
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
    // InternalBug381381TestLanguage.g:296:1: rule__CopyFieldNameToVariableStmt__Group_1_0__5 : rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__6 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:300:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__6 )
            // InternalBug381381TestLanguage.g:301:2: rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__6
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
    // InternalBug381381TestLanguage.g:308:1: rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:312:1: ( ( ',' ) )
            // InternalBug381381TestLanguage.g:313:1: ( ',' )
            {
            // InternalBug381381TestLanguage.g:313:1: ( ',' )
            // InternalBug381381TestLanguage.g:314:2: ','
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
    // InternalBug381381TestLanguage.g:323:1: rule__CopyFieldNameToVariableStmt__Group_1_0__6 : rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__7 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:327:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__7 )
            // InternalBug381381TestLanguage.g:328:2: rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl rule__CopyFieldNameToVariableStmt__Group_1_0__7
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
    // InternalBug381381TestLanguage.g:335:1: rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl : ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:339:1: ( ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) ) )
            // InternalBug381381TestLanguage.g:340:1: ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) )
            {
            // InternalBug381381TestLanguage.g:340:1: ( ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 ) )
            // InternalBug381381TestLanguage.g:341:2: ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getColumnAssignment_1_0_6()); 
            // InternalBug381381TestLanguage.g:342:2: ( rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 )
            // InternalBug381381TestLanguage.g:342:3: rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6
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
    // InternalBug381381TestLanguage.g:350:1: rule__CopyFieldNameToVariableStmt__Group_1_0__7 : rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:354:1: ( rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl )
            // InternalBug381381TestLanguage.g:355:2: rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl
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
    // InternalBug381381TestLanguage.g:361:1: rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl : ( ')' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_0__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:365:1: ( ( ')' ) )
            // InternalBug381381TestLanguage.g:366:1: ( ')' )
            {
            // InternalBug381381TestLanguage.g:366:1: ( ')' )
            // InternalBug381381TestLanguage.g:367:2: ')'
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
    // InternalBug381381TestLanguage.g:377:1: rule__CopyFieldNameToVariableStmt__Group_1_1__0 : rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:381:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__1 )
            // InternalBug381381TestLanguage.g:382:2: rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__1
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
    // InternalBug381381TestLanguage.g:389:1: rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:393:1: ( ( ',' ) )
            // InternalBug381381TestLanguage.g:394:1: ( ',' )
            {
            // InternalBug381381TestLanguage.g:394:1: ( ',' )
            // InternalBug381381TestLanguage.g:395:2: ','
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
    // InternalBug381381TestLanguage.g:404:1: rule__CopyFieldNameToVariableStmt__Group_1_1__1 : rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__2 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:408:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__2 )
            // InternalBug381381TestLanguage.g:409:2: rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__2
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
    // InternalBug381381TestLanguage.g:416:1: rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl : ( 'VAR' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:420:1: ( ( 'VAR' ) )
            // InternalBug381381TestLanguage.g:421:1: ( 'VAR' )
            {
            // InternalBug381381TestLanguage.g:421:1: ( 'VAR' )
            // InternalBug381381TestLanguage.g:422:2: 'VAR'
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
    // InternalBug381381TestLanguage.g:431:1: rule__CopyFieldNameToVariableStmt__Group_1_1__2 : rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__3 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:435:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__3 )
            // InternalBug381381TestLanguage.g:436:2: rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_1__3
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
    // InternalBug381381TestLanguage.g:443:1: rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl : ( '=' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:447:1: ( ( '=' ) )
            // InternalBug381381TestLanguage.g:448:1: ( '=' )
            {
            // InternalBug381381TestLanguage.g:448:1: ( '=' )
            // InternalBug381381TestLanguage.g:449:2: '='
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
    // InternalBug381381TestLanguage.g:458:1: rule__CopyFieldNameToVariableStmt__Group_1_1__3 : rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:462:1: ( rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl )
            // InternalBug381381TestLanguage.g:463:2: rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl
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
    // InternalBug381381TestLanguage.g:469:1: rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl : ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:473:1: ( ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) ) )
            // InternalBug381381TestLanguage.g:474:1: ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) )
            {
            // InternalBug381381TestLanguage.g:474:1: ( ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 ) )
            // InternalBug381381TestLanguage.g:475:2: ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 )
            {
             before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getNameAssignment_1_1_3()); 
            // InternalBug381381TestLanguage.g:476:2: ( rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 )
            // InternalBug381381TestLanguage.g:476:3: rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3
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
    // InternalBug381381TestLanguage.g:485:1: rule__CopyFieldNameToVariableStmt__Group_1_2__0 : rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__1 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:489:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__1 )
            // InternalBug381381TestLanguage.g:490:2: rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__1
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
    // InternalBug381381TestLanguage.g:497:1: rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:501:1: ( ( ',' ) )
            // InternalBug381381TestLanguage.g:502:1: ( ',' )
            {
            // InternalBug381381TestLanguage.g:502:1: ( ',' )
            // InternalBug381381TestLanguage.g:503:2: ','
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
    // InternalBug381381TestLanguage.g:512:1: rule__CopyFieldNameToVariableStmt__Group_1_2__1 : rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__2 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:516:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__2 )
            // InternalBug381381TestLanguage.g:517:2: rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__2
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
    // InternalBug381381TestLanguage.g:524:1: rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl : ( 'TYPE' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:528:1: ( ( 'TYPE' ) )
            // InternalBug381381TestLanguage.g:529:1: ( 'TYPE' )
            {
            // InternalBug381381TestLanguage.g:529:1: ( 'TYPE' )
            // InternalBug381381TestLanguage.g:530:2: 'TYPE'
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
    // InternalBug381381TestLanguage.g:539:1: rule__CopyFieldNameToVariableStmt__Group_1_2__2 : rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__3 ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:543:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__3 )
            // InternalBug381381TestLanguage.g:544:2: rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl rule__CopyFieldNameToVariableStmt__Group_1_2__3
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
    // InternalBug381381TestLanguage.g:551:1: rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl : ( '=' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:555:1: ( ( '=' ) )
            // InternalBug381381TestLanguage.g:556:1: ( '=' )
            {
            // InternalBug381381TestLanguage.g:556:1: ( '=' )
            // InternalBug381381TestLanguage.g:557:2: '='
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
    // InternalBug381381TestLanguage.g:566:1: rule__CopyFieldNameToVariableStmt__Group_1_2__3 : rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:570:1: ( rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl )
            // InternalBug381381TestLanguage.g:571:2: rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl
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
    // InternalBug381381TestLanguage.g:577:1: rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl : ( 'REPLACE' ) ;
    public final void rule__CopyFieldNameToVariableStmt__Group_1_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:581:1: ( ( 'REPLACE' ) )
            // InternalBug381381TestLanguage.g:582:1: ( 'REPLACE' )
            {
            // InternalBug381381TestLanguage.g:582:1: ( 'REPLACE' )
            // InternalBug381381TestLanguage.g:583:2: 'REPLACE'
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
    // InternalBug381381TestLanguage.g:593:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 {...}?;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1());
        	
        try {
            // InternalBug381381TestLanguage.g:598:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 {...}?)
            // InternalBug381381TestLanguage.g:599:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 {...}?
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
    // InternalBug381381TestLanguage.g:607:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) ) ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug381381TestLanguage.g:612:1: ( ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) ) )
            // InternalBug381381TestLanguage.g:613:3: ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) )
            {
            // InternalBug381381TestLanguage.g:613:3: ( ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) ) )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( LA1_0 == 12 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) ) {
                int LA1_1 = input.LA(2);

                if ( LA1_1 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) ) {
                    alt1=2;
                }
                else if ( LA1_1 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) {
                    alt1=3;
                }
                else if ( LA1_1 == 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) ) {
                    alt1=1;
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
                    // InternalBug381381TestLanguage.g:614:3: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) )
                    {
                    // InternalBug381381TestLanguage.g:614:3: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) ) )
                    // InternalBug381381TestLanguage.g:615:4: {...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0)");
                    }
                    // InternalBug381381TestLanguage.g:615:123: ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) ) )
                    // InternalBug381381TestLanguage.g:616:5: ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0);
                    				

                    					selected = true;
                    				
                    // InternalBug381381TestLanguage.g:622:5: ( ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 ) )
                    // InternalBug381381TestLanguage.g:623:6: ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 )
                    {
                     before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_0()); 
                    // InternalBug381381TestLanguage.g:624:6: ( rule__CopyFieldNameToVariableStmt__Group_1_0__0 )
                    // InternalBug381381TestLanguage.g:624:7: rule__CopyFieldNameToVariableStmt__Group_1_0__0
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
                    // InternalBug381381TestLanguage.g:629:3: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) )
                    {
                    // InternalBug381381TestLanguage.g:629:3: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) ) )
                    // InternalBug381381TestLanguage.g:630:4: {...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1)");
                    }
                    // InternalBug381381TestLanguage.g:630:123: ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) ) )
                    // InternalBug381381TestLanguage.g:631:5: ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1);
                    				

                    					selected = true;
                    				
                    // InternalBug381381TestLanguage.g:637:5: ( ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 ) )
                    // InternalBug381381TestLanguage.g:638:6: ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 )
                    {
                     before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_1()); 
                    // InternalBug381381TestLanguage.g:639:6: ( rule__CopyFieldNameToVariableStmt__Group_1_1__0 )
                    // InternalBug381381TestLanguage.g:639:7: rule__CopyFieldNameToVariableStmt__Group_1_1__0
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
                    // InternalBug381381TestLanguage.g:644:3: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) )
                    {
                    // InternalBug381381TestLanguage.g:644:3: ({...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) ) )
                    // InternalBug381381TestLanguage.g:645:4: {...}? => ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2)");
                    }
                    // InternalBug381381TestLanguage.g:645:123: ( ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) ) )
                    // InternalBug381381TestLanguage.g:646:5: ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2);
                    				

                    					selected = true;
                    				
                    // InternalBug381381TestLanguage.g:652:5: ( ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 ) )
                    // InternalBug381381TestLanguage.g:653:6: ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 )
                    {
                     before(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_2()); 
                    // InternalBug381381TestLanguage.g:654:6: ( rule__CopyFieldNameToVariableStmt__Group_1_2__0 )
                    // InternalBug381381TestLanguage.g:654:7: rule__CopyFieldNameToVariableStmt__Group_1_2__0
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
    // InternalBug381381TestLanguage.g:667:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )? ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:671:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )? )
            // InternalBug381381TestLanguage.g:672:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalBug381381TestLanguage.g:673:2: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( LA2_0 == 12 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug381381TestLanguage.g:673:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1
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
    // InternalBug381381TestLanguage.g:679:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )? ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:683:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )? )
            // InternalBug381381TestLanguage.g:684:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalBug381381TestLanguage.g:685:2: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( LA3_0 == 12 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 0) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), 2) ) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug381381TestLanguage.g:685:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2
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
    // InternalBug381381TestLanguage.g:691:1: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2 : rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl ;
    public final void rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:695:1: ( rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl )
            // InternalBug381381TestLanguage.g:696:2: rule__CopyFieldNameToVariableStmt__UnorderedGroup_1__Impl
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
    // InternalBug381381TestLanguage.g:703:1: rule__Model__StmtAssignment : ( ruleCopyFieldNameToVariableStmt ) ;
    public final void rule__Model__StmtAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:707:1: ( ( ruleCopyFieldNameToVariableStmt ) )
            // InternalBug381381TestLanguage.g:708:2: ( ruleCopyFieldNameToVariableStmt )
            {
            // InternalBug381381TestLanguage.g:708:2: ( ruleCopyFieldNameToVariableStmt )
            // InternalBug381381TestLanguage.g:709:3: ruleCopyFieldNameToVariableStmt
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
    // InternalBug381381TestLanguage.g:718:1: rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4 : ( RULE_INT ) ;
    public final void rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:722:1: ( ( RULE_INT ) )
            // InternalBug381381TestLanguage.g:723:2: ( RULE_INT )
            {
            // InternalBug381381TestLanguage.g:723:2: ( RULE_INT )
            // InternalBug381381TestLanguage.g:724:3: RULE_INT
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
    // InternalBug381381TestLanguage.g:733:1: rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6 : ( RULE_INT ) ;
    public final void rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:737:1: ( ( RULE_INT ) )
            // InternalBug381381TestLanguage.g:738:2: ( RULE_INT )
            {
            // InternalBug381381TestLanguage.g:738:2: ( RULE_INT )
            // InternalBug381381TestLanguage.g:739:3: RULE_INT
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
    // InternalBug381381TestLanguage.g:748:1: rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3 : ( RULE_ID ) ;
    public final void rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug381381TestLanguage.g:752:1: ( ( RULE_ID ) )
            // InternalBug381381TestLanguage.g:753:2: ( RULE_ID )
            {
            // InternalBug381381TestLanguage.g:753:2: ( RULE_ID )
            // InternalBug381381TestLanguage.g:754:3: RULE_ID
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
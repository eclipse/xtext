package org.eclipse.xtext.testlanguages.nestedRefs.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.testlanguages.nestedRefs.services.NestedRefsTestLanguageGrammarAccess;



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
public class InternalNestedRefsTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'decl'", "'end'", "';'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalNestedRefsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalNestedRefsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalNestedRefsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalNestedRefsTestLanguage.g"; }


    	private NestedRefsTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(NestedRefsTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleDoc"
    // InternalNestedRefsTestLanguage.g:58:1: entryRuleDoc : ruleDoc EOF ;
    public final void entryRuleDoc() throws RecognitionException {
        try {
            // InternalNestedRefsTestLanguage.g:59:1: ( ruleDoc EOF )
            // InternalNestedRefsTestLanguage.g:60:1: ruleDoc EOF
            {
             before(grammarAccess.getDocRule()); 
            pushFollow(FOLLOW_1);
            ruleDoc();

            state._fsp--;

             after(grammarAccess.getDocRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDoc"


    // $ANTLR start "ruleDoc"
    // InternalNestedRefsTestLanguage.g:67:1: ruleDoc : ( ( rule__Doc__DeclarationsAssignment )* ) ;
    public final void ruleDoc() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:71:2: ( ( ( rule__Doc__DeclarationsAssignment )* ) )
            // InternalNestedRefsTestLanguage.g:72:2: ( ( rule__Doc__DeclarationsAssignment )* )
            {
            // InternalNestedRefsTestLanguage.g:72:2: ( ( rule__Doc__DeclarationsAssignment )* )
            // InternalNestedRefsTestLanguage.g:73:3: ( rule__Doc__DeclarationsAssignment )*
            {
             before(grammarAccess.getDocAccess().getDeclarationsAssignment()); 
            // InternalNestedRefsTestLanguage.g:74:3: ( rule__Doc__DeclarationsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalNestedRefsTestLanguage.g:74:4: rule__Doc__DeclarationsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Doc__DeclarationsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getDocAccess().getDeclarationsAssignment()); 

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
    // $ANTLR end "ruleDoc"


    // $ANTLR start "entryRuleSelfReferingDecl"
    // InternalNestedRefsTestLanguage.g:83:1: entryRuleSelfReferingDecl : ruleSelfReferingDecl EOF ;
    public final void entryRuleSelfReferingDecl() throws RecognitionException {
        try {
            // InternalNestedRefsTestLanguage.g:84:1: ( ruleSelfReferingDecl EOF )
            // InternalNestedRefsTestLanguage.g:85:1: ruleSelfReferingDecl EOF
            {
             before(grammarAccess.getSelfReferingDeclRule()); 
            pushFollow(FOLLOW_1);
            ruleSelfReferingDecl();

            state._fsp--;

             after(grammarAccess.getSelfReferingDeclRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSelfReferingDecl"


    // $ANTLR start "ruleSelfReferingDecl"
    // InternalNestedRefsTestLanguage.g:92:1: ruleSelfReferingDecl : ( ( rule__SelfReferingDecl__Group__0 ) ) ;
    public final void ruleSelfReferingDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:96:2: ( ( ( rule__SelfReferingDecl__Group__0 ) ) )
            // InternalNestedRefsTestLanguage.g:97:2: ( ( rule__SelfReferingDecl__Group__0 ) )
            {
            // InternalNestedRefsTestLanguage.g:97:2: ( ( rule__SelfReferingDecl__Group__0 ) )
            // InternalNestedRefsTestLanguage.g:98:3: ( rule__SelfReferingDecl__Group__0 )
            {
             before(grammarAccess.getSelfReferingDeclAccess().getGroup()); 
            // InternalNestedRefsTestLanguage.g:99:3: ( rule__SelfReferingDecl__Group__0 )
            // InternalNestedRefsTestLanguage.g:99:4: rule__SelfReferingDecl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SelfReferingDecl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelfReferingDeclAccess().getGroup()); 

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
    // $ANTLR end "ruleSelfReferingDecl"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalNestedRefsTestLanguage.g:108:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalNestedRefsTestLanguage.g:109:1: ( ruleQualifiedName EOF )
            // InternalNestedRefsTestLanguage.g:110:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalNestedRefsTestLanguage.g:117:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:121:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalNestedRefsTestLanguage.g:122:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalNestedRefsTestLanguage.g:122:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalNestedRefsTestLanguage.g:123:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalNestedRefsTestLanguage.g:124:3: ( rule__QualifiedName__Group__0 )
            // InternalNestedRefsTestLanguage.g:124:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "rule__SelfReferingDecl__Group__0"
    // InternalNestedRefsTestLanguage.g:132:1: rule__SelfReferingDecl__Group__0 : rule__SelfReferingDecl__Group__0__Impl rule__SelfReferingDecl__Group__1 ;
    public final void rule__SelfReferingDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:136:1: ( rule__SelfReferingDecl__Group__0__Impl rule__SelfReferingDecl__Group__1 )
            // InternalNestedRefsTestLanguage.g:137:2: rule__SelfReferingDecl__Group__0__Impl rule__SelfReferingDecl__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__SelfReferingDecl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SelfReferingDecl__Group__1();

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
    // $ANTLR end "rule__SelfReferingDecl__Group__0"


    // $ANTLR start "rule__SelfReferingDecl__Group__0__Impl"
    // InternalNestedRefsTestLanguage.g:144:1: rule__SelfReferingDecl__Group__0__Impl : ( 'decl' ) ;
    public final void rule__SelfReferingDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:148:1: ( ( 'decl' ) )
            // InternalNestedRefsTestLanguage.g:149:1: ( 'decl' )
            {
            // InternalNestedRefsTestLanguage.g:149:1: ( 'decl' )
            // InternalNestedRefsTestLanguage.g:150:2: 'decl'
            {
             before(grammarAccess.getSelfReferingDeclAccess().getDeclKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getSelfReferingDeclAccess().getDeclKeyword_0()); 

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
    // $ANTLR end "rule__SelfReferingDecl__Group__0__Impl"


    // $ANTLR start "rule__SelfReferingDecl__Group__1"
    // InternalNestedRefsTestLanguage.g:159:1: rule__SelfReferingDecl__Group__1 : rule__SelfReferingDecl__Group__1__Impl rule__SelfReferingDecl__Group__2 ;
    public final void rule__SelfReferingDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:163:1: ( rule__SelfReferingDecl__Group__1__Impl rule__SelfReferingDecl__Group__2 )
            // InternalNestedRefsTestLanguage.g:164:2: rule__SelfReferingDecl__Group__1__Impl rule__SelfReferingDecl__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__SelfReferingDecl__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SelfReferingDecl__Group__2();

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
    // $ANTLR end "rule__SelfReferingDecl__Group__1"


    // $ANTLR start "rule__SelfReferingDecl__Group__1__Impl"
    // InternalNestedRefsTestLanguage.g:171:1: rule__SelfReferingDecl__Group__1__Impl : ( ( rule__SelfReferingDecl__NameAssignment_1 ) ) ;
    public final void rule__SelfReferingDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:175:1: ( ( ( rule__SelfReferingDecl__NameAssignment_1 ) ) )
            // InternalNestedRefsTestLanguage.g:176:1: ( ( rule__SelfReferingDecl__NameAssignment_1 ) )
            {
            // InternalNestedRefsTestLanguage.g:176:1: ( ( rule__SelfReferingDecl__NameAssignment_1 ) )
            // InternalNestedRefsTestLanguage.g:177:2: ( rule__SelfReferingDecl__NameAssignment_1 )
            {
             before(grammarAccess.getSelfReferingDeclAccess().getNameAssignment_1()); 
            // InternalNestedRefsTestLanguage.g:178:2: ( rule__SelfReferingDecl__NameAssignment_1 )
            // InternalNestedRefsTestLanguage.g:178:3: rule__SelfReferingDecl__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SelfReferingDecl__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSelfReferingDeclAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__SelfReferingDecl__Group__1__Impl"


    // $ANTLR start "rule__SelfReferingDecl__Group__2"
    // InternalNestedRefsTestLanguage.g:186:1: rule__SelfReferingDecl__Group__2 : rule__SelfReferingDecl__Group__2__Impl rule__SelfReferingDecl__Group__3 ;
    public final void rule__SelfReferingDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:190:1: ( rule__SelfReferingDecl__Group__2__Impl rule__SelfReferingDecl__Group__3 )
            // InternalNestedRefsTestLanguage.g:191:2: rule__SelfReferingDecl__Group__2__Impl rule__SelfReferingDecl__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__SelfReferingDecl__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SelfReferingDecl__Group__3();

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
    // $ANTLR end "rule__SelfReferingDecl__Group__2"


    // $ANTLR start "rule__SelfReferingDecl__Group__2__Impl"
    // InternalNestedRefsTestLanguage.g:198:1: rule__SelfReferingDecl__Group__2__Impl : ( 'end' ) ;
    public final void rule__SelfReferingDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:202:1: ( ( 'end' ) )
            // InternalNestedRefsTestLanguage.g:203:1: ( 'end' )
            {
            // InternalNestedRefsTestLanguage.g:203:1: ( 'end' )
            // InternalNestedRefsTestLanguage.g:204:2: 'end'
            {
             before(grammarAccess.getSelfReferingDeclAccess().getEndKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getSelfReferingDeclAccess().getEndKeyword_2()); 

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
    // $ANTLR end "rule__SelfReferingDecl__Group__2__Impl"


    // $ANTLR start "rule__SelfReferingDecl__Group__3"
    // InternalNestedRefsTestLanguage.g:213:1: rule__SelfReferingDecl__Group__3 : rule__SelfReferingDecl__Group__3__Impl rule__SelfReferingDecl__Group__4 ;
    public final void rule__SelfReferingDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:217:1: ( rule__SelfReferingDecl__Group__3__Impl rule__SelfReferingDecl__Group__4 )
            // InternalNestedRefsTestLanguage.g:218:2: rule__SelfReferingDecl__Group__3__Impl rule__SelfReferingDecl__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__SelfReferingDecl__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SelfReferingDecl__Group__4();

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
    // $ANTLR end "rule__SelfReferingDecl__Group__3"


    // $ANTLR start "rule__SelfReferingDecl__Group__3__Impl"
    // InternalNestedRefsTestLanguage.g:225:1: rule__SelfReferingDecl__Group__3__Impl : ( ( rule__SelfReferingDecl__SelfRefAssignment_3 ) ) ;
    public final void rule__SelfReferingDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:229:1: ( ( ( rule__SelfReferingDecl__SelfRefAssignment_3 ) ) )
            // InternalNestedRefsTestLanguage.g:230:1: ( ( rule__SelfReferingDecl__SelfRefAssignment_3 ) )
            {
            // InternalNestedRefsTestLanguage.g:230:1: ( ( rule__SelfReferingDecl__SelfRefAssignment_3 ) )
            // InternalNestedRefsTestLanguage.g:231:2: ( rule__SelfReferingDecl__SelfRefAssignment_3 )
            {
             before(grammarAccess.getSelfReferingDeclAccess().getSelfRefAssignment_3()); 
            // InternalNestedRefsTestLanguage.g:232:2: ( rule__SelfReferingDecl__SelfRefAssignment_3 )
            // InternalNestedRefsTestLanguage.g:232:3: rule__SelfReferingDecl__SelfRefAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__SelfReferingDecl__SelfRefAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSelfReferingDeclAccess().getSelfRefAssignment_3()); 

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
    // $ANTLR end "rule__SelfReferingDecl__Group__3__Impl"


    // $ANTLR start "rule__SelfReferingDecl__Group__4"
    // InternalNestedRefsTestLanguage.g:240:1: rule__SelfReferingDecl__Group__4 : rule__SelfReferingDecl__Group__4__Impl ;
    public final void rule__SelfReferingDecl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:244:1: ( rule__SelfReferingDecl__Group__4__Impl )
            // InternalNestedRefsTestLanguage.g:245:2: rule__SelfReferingDecl__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelfReferingDecl__Group__4__Impl();

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
    // $ANTLR end "rule__SelfReferingDecl__Group__4"


    // $ANTLR start "rule__SelfReferingDecl__Group__4__Impl"
    // InternalNestedRefsTestLanguage.g:251:1: rule__SelfReferingDecl__Group__4__Impl : ( ';' ) ;
    public final void rule__SelfReferingDecl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:255:1: ( ( ';' ) )
            // InternalNestedRefsTestLanguage.g:256:1: ( ';' )
            {
            // InternalNestedRefsTestLanguage.g:256:1: ( ';' )
            // InternalNestedRefsTestLanguage.g:257:2: ';'
            {
             before(grammarAccess.getSelfReferingDeclAccess().getSemicolonKeyword_4()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getSelfReferingDeclAccess().getSemicolonKeyword_4()); 

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
    // $ANTLR end "rule__SelfReferingDecl__Group__4__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalNestedRefsTestLanguage.g:267:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:271:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalNestedRefsTestLanguage.g:272:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

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
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalNestedRefsTestLanguage.g:279:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:283:1: ( ( RULE_ID ) )
            // InternalNestedRefsTestLanguage.g:284:1: ( RULE_ID )
            {
            // InternalNestedRefsTestLanguage.g:284:1: ( RULE_ID )
            // InternalNestedRefsTestLanguage.g:285:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalNestedRefsTestLanguage.g:294:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:298:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalNestedRefsTestLanguage.g:299:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalNestedRefsTestLanguage.g:305:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:309:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalNestedRefsTestLanguage.g:310:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalNestedRefsTestLanguage.g:310:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalNestedRefsTestLanguage.g:311:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalNestedRefsTestLanguage.g:312:2: ( rule__QualifiedName__Group_1__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalNestedRefsTestLanguage.g:312:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

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
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalNestedRefsTestLanguage.g:321:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:325:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalNestedRefsTestLanguage.g:326:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

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
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalNestedRefsTestLanguage.g:333:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:337:1: ( ( '.' ) )
            // InternalNestedRefsTestLanguage.g:338:1: ( '.' )
            {
            // InternalNestedRefsTestLanguage.g:338:1: ( '.' )
            // InternalNestedRefsTestLanguage.g:339:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalNestedRefsTestLanguage.g:348:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:352:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalNestedRefsTestLanguage.g:353:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalNestedRefsTestLanguage.g:359:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:363:1: ( ( RULE_ID ) )
            // InternalNestedRefsTestLanguage.g:364:1: ( RULE_ID )
            {
            // InternalNestedRefsTestLanguage.g:364:1: ( RULE_ID )
            // InternalNestedRefsTestLanguage.g:365:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

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
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Doc__DeclarationsAssignment"
    // InternalNestedRefsTestLanguage.g:375:1: rule__Doc__DeclarationsAssignment : ( ruleSelfReferingDecl ) ;
    public final void rule__Doc__DeclarationsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:379:1: ( ( ruleSelfReferingDecl ) )
            // InternalNestedRefsTestLanguage.g:380:2: ( ruleSelfReferingDecl )
            {
            // InternalNestedRefsTestLanguage.g:380:2: ( ruleSelfReferingDecl )
            // InternalNestedRefsTestLanguage.g:381:3: ruleSelfReferingDecl
            {
             before(grammarAccess.getDocAccess().getDeclarationsSelfReferingDeclParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleSelfReferingDecl();

            state._fsp--;

             after(grammarAccess.getDocAccess().getDeclarationsSelfReferingDeclParserRuleCall_0()); 

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
    // $ANTLR end "rule__Doc__DeclarationsAssignment"


    // $ANTLR start "rule__SelfReferingDecl__NameAssignment_1"
    // InternalNestedRefsTestLanguage.g:390:1: rule__SelfReferingDecl__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__SelfReferingDecl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:394:1: ( ( ruleQualifiedName ) )
            // InternalNestedRefsTestLanguage.g:395:2: ( ruleQualifiedName )
            {
            // InternalNestedRefsTestLanguage.g:395:2: ( ruleQualifiedName )
            // InternalNestedRefsTestLanguage.g:396:3: ruleQualifiedName
            {
             before(grammarAccess.getSelfReferingDeclAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSelfReferingDeclAccess().getNameQualifiedNameParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__SelfReferingDecl__NameAssignment_1"


    // $ANTLR start "rule__SelfReferingDecl__SelfRefAssignment_3"
    // InternalNestedRefsTestLanguage.g:405:1: rule__SelfReferingDecl__SelfRefAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SelfReferingDecl__SelfRefAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalNestedRefsTestLanguage.g:409:1: ( ( ( ruleQualifiedName ) ) )
            // InternalNestedRefsTestLanguage.g:410:2: ( ( ruleQualifiedName ) )
            {
            // InternalNestedRefsTestLanguage.g:410:2: ( ( ruleQualifiedName ) )
            // InternalNestedRefsTestLanguage.g:411:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getSelfReferingDeclAccess().getSelfRefSelfReferingDeclCrossReference_3_0()); 
            // InternalNestedRefsTestLanguage.g:412:3: ( ruleQualifiedName )
            // InternalNestedRefsTestLanguage.g:413:4: ruleQualifiedName
            {
             before(grammarAccess.getSelfReferingDeclAccess().getSelfRefSelfReferingDeclQualifiedNameParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSelfReferingDeclAccess().getSelfRefSelfReferingDeclQualifiedNameParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getSelfReferingDeclAccess().getSelfRefSelfReferingDeclCrossReference_3_0()); 

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
    // $ANTLR end "rule__SelfReferingDecl__SelfRefAssignment_3"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004002L});

}
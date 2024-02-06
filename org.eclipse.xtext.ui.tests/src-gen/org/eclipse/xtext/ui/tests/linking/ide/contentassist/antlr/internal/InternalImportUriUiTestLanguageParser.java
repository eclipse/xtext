package org.eclipse.xtext.ui.tests.linking.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.linking.services.ImportUriUiTestLanguageGrammarAccess;



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
public class InternalImportUriUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'extends'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalImportUriUiTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalImportUriUiTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalImportUriUiTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalImportUriUiTestLanguage.g"; }


    	private ImportUriUiTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(ImportUriUiTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleMain"
    // InternalImportUriUiTestLanguage.g:58:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // InternalImportUriUiTestLanguage.g:59:1: ( ruleMain EOF )
            // InternalImportUriUiTestLanguage.g:60:1: ruleMain EOF
            {
             before(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMain();

            state._fsp--;

             after(grammarAccess.getMainRule()); 
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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // InternalImportUriUiTestLanguage.g:67:1: ruleMain : ( ( rule__Main__Group__0 ) ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:71:2: ( ( ( rule__Main__Group__0 ) ) )
            // InternalImportUriUiTestLanguage.g:72:2: ( ( rule__Main__Group__0 ) )
            {
            // InternalImportUriUiTestLanguage.g:72:2: ( ( rule__Main__Group__0 ) )
            // InternalImportUriUiTestLanguage.g:73:3: ( rule__Main__Group__0 )
            {
             before(grammarAccess.getMainAccess().getGroup()); 
            // InternalImportUriUiTestLanguage.g:74:3: ( rule__Main__Group__0 )
            // InternalImportUriUiTestLanguage.g:74:4: rule__Main__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Main__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMainAccess().getGroup()); 

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
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleImport"
    // InternalImportUriUiTestLanguage.g:83:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalImportUriUiTestLanguage.g:84:1: ( ruleImport EOF )
            // InternalImportUriUiTestLanguage.g:85:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalImportUriUiTestLanguage.g:92:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:96:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalImportUriUiTestLanguage.g:97:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalImportUriUiTestLanguage.g:97:2: ( ( rule__Import__Group__0 ) )
            // InternalImportUriUiTestLanguage.g:98:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalImportUriUiTestLanguage.g:99:3: ( rule__Import__Group__0 )
            // InternalImportUriUiTestLanguage.g:99:4: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleType"
    // InternalImportUriUiTestLanguage.g:108:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalImportUriUiTestLanguage.g:109:1: ( ruleType EOF )
            // InternalImportUriUiTestLanguage.g:110:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalImportUriUiTestLanguage.g:117:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:121:2: ( ( ( rule__Type__Group__0 ) ) )
            // InternalImportUriUiTestLanguage.g:122:2: ( ( rule__Type__Group__0 ) )
            {
            // InternalImportUriUiTestLanguage.g:122:2: ( ( rule__Type__Group__0 ) )
            // InternalImportUriUiTestLanguage.g:123:3: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // InternalImportUriUiTestLanguage.g:124:3: ( rule__Type__Group__0 )
            // InternalImportUriUiTestLanguage.g:124:4: rule__Type__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getGroup()); 

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
    // $ANTLR end "ruleType"


    // $ANTLR start "rule__Main__Group__0"
    // InternalImportUriUiTestLanguage.g:132:1: rule__Main__Group__0 : rule__Main__Group__0__Impl rule__Main__Group__1 ;
    public final void rule__Main__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:136:1: ( rule__Main__Group__0__Impl rule__Main__Group__1 )
            // InternalImportUriUiTestLanguage.g:137:2: rule__Main__Group__0__Impl rule__Main__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Main__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Main__Group__1();

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
    // $ANTLR end "rule__Main__Group__0"


    // $ANTLR start "rule__Main__Group__0__Impl"
    // InternalImportUriUiTestLanguage.g:144:1: rule__Main__Group__0__Impl : ( ( rule__Main__ImportsAssignment_0 )* ) ;
    public final void rule__Main__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:148:1: ( ( ( rule__Main__ImportsAssignment_0 )* ) )
            // InternalImportUriUiTestLanguage.g:149:1: ( ( rule__Main__ImportsAssignment_0 )* )
            {
            // InternalImportUriUiTestLanguage.g:149:1: ( ( rule__Main__ImportsAssignment_0 )* )
            // InternalImportUriUiTestLanguage.g:150:2: ( rule__Main__ImportsAssignment_0 )*
            {
             before(grammarAccess.getMainAccess().getImportsAssignment_0()); 
            // InternalImportUriUiTestLanguage.g:151:2: ( rule__Main__ImportsAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalImportUriUiTestLanguage.g:151:3: rule__Main__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Main__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getImportsAssignment_0()); 

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
    // $ANTLR end "rule__Main__Group__0__Impl"


    // $ANTLR start "rule__Main__Group__1"
    // InternalImportUriUiTestLanguage.g:159:1: rule__Main__Group__1 : rule__Main__Group__1__Impl ;
    public final void rule__Main__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:163:1: ( rule__Main__Group__1__Impl )
            // InternalImportUriUiTestLanguage.g:164:2: rule__Main__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Main__Group__1__Impl();

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
    // $ANTLR end "rule__Main__Group__1"


    // $ANTLR start "rule__Main__Group__1__Impl"
    // InternalImportUriUiTestLanguage.g:170:1: rule__Main__Group__1__Impl : ( ( rule__Main__TypesAssignment_1 )* ) ;
    public final void rule__Main__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:174:1: ( ( ( rule__Main__TypesAssignment_1 )* ) )
            // InternalImportUriUiTestLanguage.g:175:1: ( ( rule__Main__TypesAssignment_1 )* )
            {
            // InternalImportUriUiTestLanguage.g:175:1: ( ( rule__Main__TypesAssignment_1 )* )
            // InternalImportUriUiTestLanguage.g:176:2: ( rule__Main__TypesAssignment_1 )*
            {
             before(grammarAccess.getMainAccess().getTypesAssignment_1()); 
            // InternalImportUriUiTestLanguage.g:177:2: ( rule__Main__TypesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalImportUriUiTestLanguage.g:177:3: rule__Main__TypesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Main__TypesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getTypesAssignment_1()); 

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
    // $ANTLR end "rule__Main__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalImportUriUiTestLanguage.g:186:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:190:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalImportUriUiTestLanguage.g:191:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__Group__1();

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
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalImportUriUiTestLanguage.g:198:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:202:1: ( ( 'import' ) )
            // InternalImportUriUiTestLanguage.g:203:1: ( 'import' )
            {
            // InternalImportUriUiTestLanguage.g:203:1: ( 'import' )
            // InternalImportUriUiTestLanguage.g:204:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

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
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalImportUriUiTestLanguage.g:213:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:217:1: ( rule__Import__Group__1__Impl )
            // InternalImportUriUiTestLanguage.g:218:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__Group__1__Impl();

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
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalImportUriUiTestLanguage.g:224:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:228:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // InternalImportUriUiTestLanguage.g:229:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // InternalImportUriUiTestLanguage.g:229:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // InternalImportUriUiTestLanguage.g:230:2: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // InternalImportUriUiTestLanguage.g:231:2: ( rule__Import__ImportURIAssignment_1 )
            // InternalImportUriUiTestLanguage.g:231:3: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

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
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Type__Group__0"
    // InternalImportUriUiTestLanguage.g:240:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:244:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // InternalImportUriUiTestLanguage.g:245:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Type__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__1();

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
    // $ANTLR end "rule__Type__Group__0"


    // $ANTLR start "rule__Type__Group__0__Impl"
    // InternalImportUriUiTestLanguage.g:252:1: rule__Type__Group__0__Impl : ( 'type' ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:256:1: ( ( 'type' ) )
            // InternalImportUriUiTestLanguage.g:257:1: ( 'type' )
            {
            // InternalImportUriUiTestLanguage.g:257:1: ( 'type' )
            // InternalImportUriUiTestLanguage.g:258:2: 'type'
            {
             before(grammarAccess.getTypeAccess().getTypeKeyword_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getTypeKeyword_0()); 

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
    // $ANTLR end "rule__Type__Group__0__Impl"


    // $ANTLR start "rule__Type__Group__1"
    // InternalImportUriUiTestLanguage.g:267:1: rule__Type__Group__1 : rule__Type__Group__1__Impl rule__Type__Group__2 ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:271:1: ( rule__Type__Group__1__Impl rule__Type__Group__2 )
            // InternalImportUriUiTestLanguage.g:272:2: rule__Type__Group__1__Impl rule__Type__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Type__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__2();

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
    // $ANTLR end "rule__Type__Group__1"


    // $ANTLR start "rule__Type__Group__1__Impl"
    // InternalImportUriUiTestLanguage.g:279:1: rule__Type__Group__1__Impl : ( ( rule__Type__NameAssignment_1 ) ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:283:1: ( ( ( rule__Type__NameAssignment_1 ) ) )
            // InternalImportUriUiTestLanguage.g:284:1: ( ( rule__Type__NameAssignment_1 ) )
            {
            // InternalImportUriUiTestLanguage.g:284:1: ( ( rule__Type__NameAssignment_1 ) )
            // InternalImportUriUiTestLanguage.g:285:2: ( rule__Type__NameAssignment_1 )
            {
             before(grammarAccess.getTypeAccess().getNameAssignment_1()); 
            // InternalImportUriUiTestLanguage.g:286:2: ( rule__Type__NameAssignment_1 )
            // InternalImportUriUiTestLanguage.g:286:3: rule__Type__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Type__Group__1__Impl"


    // $ANTLR start "rule__Type__Group__2"
    // InternalImportUriUiTestLanguage.g:294:1: rule__Type__Group__2 : rule__Type__Group__2__Impl rule__Type__Group__3 ;
    public final void rule__Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:298:1: ( rule__Type__Group__2__Impl rule__Type__Group__3 )
            // InternalImportUriUiTestLanguage.g:299:2: rule__Type__Group__2__Impl rule__Type__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Type__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__3();

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
    // $ANTLR end "rule__Type__Group__2"


    // $ANTLR start "rule__Type__Group__2__Impl"
    // InternalImportUriUiTestLanguage.g:306:1: rule__Type__Group__2__Impl : ( 'extends' ) ;
    public final void rule__Type__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:310:1: ( ( 'extends' ) )
            // InternalImportUriUiTestLanguage.g:311:1: ( 'extends' )
            {
            // InternalImportUriUiTestLanguage.g:311:1: ( 'extends' )
            // InternalImportUriUiTestLanguage.g:312:2: 'extends'
            {
             before(grammarAccess.getTypeAccess().getExtendsKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getExtendsKeyword_2()); 

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
    // $ANTLR end "rule__Type__Group__2__Impl"


    // $ANTLR start "rule__Type__Group__3"
    // InternalImportUriUiTestLanguage.g:321:1: rule__Type__Group__3 : rule__Type__Group__3__Impl ;
    public final void rule__Type__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:325:1: ( rule__Type__Group__3__Impl )
            // InternalImportUriUiTestLanguage.g:326:2: rule__Type__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__3__Impl();

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
    // $ANTLR end "rule__Type__Group__3"


    // $ANTLR start "rule__Type__Group__3__Impl"
    // InternalImportUriUiTestLanguage.g:332:1: rule__Type__Group__3__Impl : ( ( rule__Type__ExtendsAssignment_3 ) ) ;
    public final void rule__Type__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:336:1: ( ( ( rule__Type__ExtendsAssignment_3 ) ) )
            // InternalImportUriUiTestLanguage.g:337:1: ( ( rule__Type__ExtendsAssignment_3 ) )
            {
            // InternalImportUriUiTestLanguage.g:337:1: ( ( rule__Type__ExtendsAssignment_3 ) )
            // InternalImportUriUiTestLanguage.g:338:2: ( rule__Type__ExtendsAssignment_3 )
            {
             before(grammarAccess.getTypeAccess().getExtendsAssignment_3()); 
            // InternalImportUriUiTestLanguage.g:339:2: ( rule__Type__ExtendsAssignment_3 )
            // InternalImportUriUiTestLanguage.g:339:3: rule__Type__ExtendsAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__ExtendsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getExtendsAssignment_3()); 

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
    // $ANTLR end "rule__Type__Group__3__Impl"


    // $ANTLR start "rule__Main__ImportsAssignment_0"
    // InternalImportUriUiTestLanguage.g:348:1: rule__Main__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Main__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:352:1: ( ( ruleImport ) )
            // InternalImportUriUiTestLanguage.g:353:2: ( ruleImport )
            {
            // InternalImportUriUiTestLanguage.g:353:2: ( ruleImport )
            // InternalImportUriUiTestLanguage.g:354:3: ruleImport
            {
             before(grammarAccess.getMainAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getMainAccess().getImportsImportParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Main__ImportsAssignment_0"


    // $ANTLR start "rule__Main__TypesAssignment_1"
    // InternalImportUriUiTestLanguage.g:363:1: rule__Main__TypesAssignment_1 : ( ruleType ) ;
    public final void rule__Main__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:367:1: ( ( ruleType ) )
            // InternalImportUriUiTestLanguage.g:368:2: ( ruleType )
            {
            // InternalImportUriUiTestLanguage.g:368:2: ( ruleType )
            // InternalImportUriUiTestLanguage.g:369:3: ruleType
            {
             before(grammarAccess.getMainAccess().getTypesTypeParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getMainAccess().getTypesTypeParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Main__TypesAssignment_1"


    // $ANTLR start "rule__Import__ImportURIAssignment_1"
    // InternalImportUriUiTestLanguage.g:378:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:382:1: ( ( RULE_STRING ) )
            // InternalImportUriUiTestLanguage.g:383:2: ( RULE_STRING )
            {
            // InternalImportUriUiTestLanguage.g:383:2: ( RULE_STRING )
            // InternalImportUriUiTestLanguage.g:384:3: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Import__ImportURIAssignment_1"


    // $ANTLR start "rule__Type__NameAssignment_1"
    // InternalImportUriUiTestLanguage.g:393:1: rule__Type__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Type__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:397:1: ( ( RULE_ID ) )
            // InternalImportUriUiTestLanguage.g:398:2: ( RULE_ID )
            {
            // InternalImportUriUiTestLanguage.g:398:2: ( RULE_ID )
            // InternalImportUriUiTestLanguage.g:399:3: RULE_ID
            {
             before(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Type__NameAssignment_1"


    // $ANTLR start "rule__Type__ExtendsAssignment_3"
    // InternalImportUriUiTestLanguage.g:408:1: rule__Type__ExtendsAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Type__ExtendsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:412:1: ( ( ( RULE_ID ) ) )
            // InternalImportUriUiTestLanguage.g:413:2: ( ( RULE_ID ) )
            {
            // InternalImportUriUiTestLanguage.g:413:2: ( ( RULE_ID ) )
            // InternalImportUriUiTestLanguage.g:414:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0()); 
            // InternalImportUriUiTestLanguage.g:415:3: ( RULE_ID )
            // InternalImportUriUiTestLanguage.g:416:4: RULE_ID
            {
             before(grammarAccess.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0()); 

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
    // $ANTLR end "rule__Type__ExtendsAssignment_3"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
    }


}
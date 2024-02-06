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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistCustomizingTestLanguageGrammarAccess;



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
public class InternalContentAssistCustomizingTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'extends'", "'.'", "'FQN'"
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


        public InternalContentAssistCustomizingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistCustomizingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistCustomizingTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistCustomizingTestLanguage.g"; }


    	private ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess) {
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
    // InternalContentAssistCustomizingTestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalContentAssistCustomizingTestLanguage.g:59:1: ( ruleModel EOF )
            // InternalContentAssistCustomizingTestLanguage.g:60:1: ruleModel EOF
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
    // InternalContentAssistCustomizingTestLanguage.g:67:1: ruleModel : ( ( rule__Model__TypesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:71:2: ( ( ( rule__Model__TypesAssignment )* ) )
            // InternalContentAssistCustomizingTestLanguage.g:72:2: ( ( rule__Model__TypesAssignment )* )
            {
            // InternalContentAssistCustomizingTestLanguage.g:72:2: ( ( rule__Model__TypesAssignment )* )
            // InternalContentAssistCustomizingTestLanguage.g:73:3: ( rule__Model__TypesAssignment )*
            {
             before(grammarAccess.getModelAccess().getTypesAssignment()); 
            // InternalContentAssistCustomizingTestLanguage.g:74:3: ( rule__Model__TypesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContentAssistCustomizingTestLanguage.g:74:4: rule__Model__TypesAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Model__TypesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getTypesAssignment()); 

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


    // $ANTLR start "entryRuleType"
    // InternalContentAssistCustomizingTestLanguage.g:83:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalContentAssistCustomizingTestLanguage.g:84:1: ( ruleType EOF )
            // InternalContentAssistCustomizingTestLanguage.g:85:1: ruleType EOF
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
    // InternalContentAssistCustomizingTestLanguage.g:92:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:96:2: ( ( ( rule__Type__Group__0 ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:97:2: ( ( rule__Type__Group__0 ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:97:2: ( ( rule__Type__Group__0 ) )
            // InternalContentAssistCustomizingTestLanguage.g:98:3: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // InternalContentAssistCustomizingTestLanguage.g:99:3: ( rule__Type__Group__0 )
            // InternalContentAssistCustomizingTestLanguage.g:99:4: rule__Type__Group__0
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


    // $ANTLR start "entryRuleTypeRef"
    // InternalContentAssistCustomizingTestLanguage.g:108:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalContentAssistCustomizingTestLanguage.g:109:1: ( ruleTypeRef EOF )
            // InternalContentAssistCustomizingTestLanguage.g:110:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTypeRefRule()); 
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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalContentAssistCustomizingTestLanguage.g:117:1: ruleTypeRef : ( ( rule__TypeRef__TypeAssignment ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:121:2: ( ( ( rule__TypeRef__TypeAssignment ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:122:2: ( ( rule__TypeRef__TypeAssignment ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:122:2: ( ( rule__TypeRef__TypeAssignment ) )
            // InternalContentAssistCustomizingTestLanguage.g:123:3: ( rule__TypeRef__TypeAssignment )
            {
             before(grammarAccess.getTypeRefAccess().getTypeAssignment()); 
            // InternalContentAssistCustomizingTestLanguage.g:124:3: ( rule__TypeRef__TypeAssignment )
            // InternalContentAssistCustomizingTestLanguage.g:124:4: rule__TypeRef__TypeAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__TypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getTypeAssignment()); 

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
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleFQN"
    // InternalContentAssistCustomizingTestLanguage.g:133:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalContentAssistCustomizingTestLanguage.g:134:1: ( ruleFQN EOF )
            // InternalContentAssistCustomizingTestLanguage.g:135:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalContentAssistCustomizingTestLanguage.g:142:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:146:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:147:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:147:2: ( ( rule__FQN__Group__0 ) )
            // InternalContentAssistCustomizingTestLanguage.g:148:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalContentAssistCustomizingTestLanguage.g:149:3: ( rule__FQN__Group__0 )
            // InternalContentAssistCustomizingTestLanguage.g:149:4: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "rule__Type__Alternatives_0"
    // InternalContentAssistCustomizingTestLanguage.g:157:1: rule__Type__Alternatives_0 : ( ( ( rule__Type__NameAssignment_0_0 ) ) | ( ( rule__Type__NameAssignment_0_1 ) ) );
    public final void rule__Type__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:161:1: ( ( ( rule__Type__NameAssignment_0_0 ) ) | ( ( rule__Type__NameAssignment_0_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalContentAssistCustomizingTestLanguage.g:162:2: ( ( rule__Type__NameAssignment_0_0 ) )
                    {
                    // InternalContentAssistCustomizingTestLanguage.g:162:2: ( ( rule__Type__NameAssignment_0_0 ) )
                    // InternalContentAssistCustomizingTestLanguage.g:163:3: ( rule__Type__NameAssignment_0_0 )
                    {
                     before(grammarAccess.getTypeAccess().getNameAssignment_0_0()); 
                    // InternalContentAssistCustomizingTestLanguage.g:164:3: ( rule__Type__NameAssignment_0_0 )
                    // InternalContentAssistCustomizingTestLanguage.g:164:4: rule__Type__NameAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Type__NameAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeAccess().getNameAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalContentAssistCustomizingTestLanguage.g:168:2: ( ( rule__Type__NameAssignment_0_1 ) )
                    {
                    // InternalContentAssistCustomizingTestLanguage.g:168:2: ( ( rule__Type__NameAssignment_0_1 ) )
                    // InternalContentAssistCustomizingTestLanguage.g:169:3: ( rule__Type__NameAssignment_0_1 )
                    {
                     before(grammarAccess.getTypeAccess().getNameAssignment_0_1()); 
                    // InternalContentAssistCustomizingTestLanguage.g:170:3: ( rule__Type__NameAssignment_0_1 )
                    // InternalContentAssistCustomizingTestLanguage.g:170:4: rule__Type__NameAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Type__NameAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeAccess().getNameAssignment_0_1()); 

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
    // $ANTLR end "rule__Type__Alternatives_0"


    // $ANTLR start "rule__Type__Group__0"
    // InternalContentAssistCustomizingTestLanguage.g:178:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:182:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // InternalContentAssistCustomizingTestLanguage.g:183:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
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
    // InternalContentAssistCustomizingTestLanguage.g:190:1: rule__Type__Group__0__Impl : ( ( rule__Type__Alternatives_0 ) ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:194:1: ( ( ( rule__Type__Alternatives_0 ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:195:1: ( ( rule__Type__Alternatives_0 ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:195:1: ( ( rule__Type__Alternatives_0 ) )
            // InternalContentAssistCustomizingTestLanguage.g:196:2: ( rule__Type__Alternatives_0 )
            {
             before(grammarAccess.getTypeAccess().getAlternatives_0()); 
            // InternalContentAssistCustomizingTestLanguage.g:197:2: ( rule__Type__Alternatives_0 )
            // InternalContentAssistCustomizingTestLanguage.g:197:3: rule__Type__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives_0()); 

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
    // InternalContentAssistCustomizingTestLanguage.g:205:1: rule__Type__Group__1 : rule__Type__Group__1__Impl rule__Type__Group__2 ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:209:1: ( rule__Type__Group__1__Impl rule__Type__Group__2 )
            // InternalContentAssistCustomizingTestLanguage.g:210:2: rule__Type__Group__1__Impl rule__Type__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
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
    // InternalContentAssistCustomizingTestLanguage.g:217:1: rule__Type__Group__1__Impl : ( ( rule__Type__Group_1__0 )? ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:221:1: ( ( ( rule__Type__Group_1__0 )? ) )
            // InternalContentAssistCustomizingTestLanguage.g:222:1: ( ( rule__Type__Group_1__0 )? )
            {
            // InternalContentAssistCustomizingTestLanguage.g:222:1: ( ( rule__Type__Group_1__0 )? )
            // InternalContentAssistCustomizingTestLanguage.g:223:2: ( rule__Type__Group_1__0 )?
            {
             before(grammarAccess.getTypeAccess().getGroup_1()); 
            // InternalContentAssistCustomizingTestLanguage.g:224:2: ( rule__Type__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalContentAssistCustomizingTestLanguage.g:224:3: rule__Type__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Type__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeAccess().getGroup_1()); 

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
    // InternalContentAssistCustomizingTestLanguage.g:232:1: rule__Type__Group__2 : rule__Type__Group__2__Impl ;
    public final void rule__Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:236:1: ( rule__Type__Group__2__Impl )
            // InternalContentAssistCustomizingTestLanguage.g:237:2: rule__Type__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__2__Impl();

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
    // InternalContentAssistCustomizingTestLanguage.g:243:1: rule__Type__Group__2__Impl : ( ';' ) ;
    public final void rule__Type__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:247:1: ( ( ';' ) )
            // InternalContentAssistCustomizingTestLanguage.g:248:1: ( ';' )
            {
            // InternalContentAssistCustomizingTestLanguage.g:248:1: ( ';' )
            // InternalContentAssistCustomizingTestLanguage.g:249:2: ';'
            {
             before(grammarAccess.getTypeAccess().getSemicolonKeyword_2()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getSemicolonKeyword_2()); 

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


    // $ANTLR start "rule__Type__Group_1__0"
    // InternalContentAssistCustomizingTestLanguage.g:259:1: rule__Type__Group_1__0 : rule__Type__Group_1__0__Impl rule__Type__Group_1__1 ;
    public final void rule__Type__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:263:1: ( rule__Type__Group_1__0__Impl rule__Type__Group_1__1 )
            // InternalContentAssistCustomizingTestLanguage.g:264:2: rule__Type__Group_1__0__Impl rule__Type__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Type__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group_1__1();

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
    // $ANTLR end "rule__Type__Group_1__0"


    // $ANTLR start "rule__Type__Group_1__0__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:271:1: rule__Type__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__Type__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:275:1: ( ( 'extends' ) )
            // InternalContentAssistCustomizingTestLanguage.g:276:1: ( 'extends' )
            {
            // InternalContentAssistCustomizingTestLanguage.g:276:1: ( 'extends' )
            // InternalContentAssistCustomizingTestLanguage.g:277:2: 'extends'
            {
             before(grammarAccess.getTypeAccess().getExtendsKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getExtendsKeyword_1_0()); 

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
    // $ANTLR end "rule__Type__Group_1__0__Impl"


    // $ANTLR start "rule__Type__Group_1__1"
    // InternalContentAssistCustomizingTestLanguage.g:286:1: rule__Type__Group_1__1 : rule__Type__Group_1__1__Impl ;
    public final void rule__Type__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:290:1: ( rule__Type__Group_1__1__Impl )
            // InternalContentAssistCustomizingTestLanguage.g:291:2: rule__Type__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group_1__1__Impl();

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
    // $ANTLR end "rule__Type__Group_1__1"


    // $ANTLR start "rule__Type__Group_1__1__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:297:1: rule__Type__Group_1__1__Impl : ( ( rule__Type__SuperTypeAssignment_1_1 ) ) ;
    public final void rule__Type__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:301:1: ( ( ( rule__Type__SuperTypeAssignment_1_1 ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:302:1: ( ( rule__Type__SuperTypeAssignment_1_1 ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:302:1: ( ( rule__Type__SuperTypeAssignment_1_1 ) )
            // InternalContentAssistCustomizingTestLanguage.g:303:2: ( rule__Type__SuperTypeAssignment_1_1 )
            {
             before(grammarAccess.getTypeAccess().getSuperTypeAssignment_1_1()); 
            // InternalContentAssistCustomizingTestLanguage.g:304:2: ( rule__Type__SuperTypeAssignment_1_1 )
            // InternalContentAssistCustomizingTestLanguage.g:304:3: rule__Type__SuperTypeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__SuperTypeAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getSuperTypeAssignment_1_1()); 

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
    // $ANTLR end "rule__Type__Group_1__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalContentAssistCustomizingTestLanguage.g:313:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:317:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalContentAssistCustomizingTestLanguage.g:318:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group__1();

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
    // $ANTLR end "rule__FQN__Group__0"


    // $ANTLR start "rule__FQN__Group__0__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:325:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:329:1: ( ( RULE_ID ) )
            // InternalContentAssistCustomizingTestLanguage.g:330:1: ( RULE_ID )
            {
            // InternalContentAssistCustomizingTestLanguage.g:330:1: ( RULE_ID )
            // InternalContentAssistCustomizingTestLanguage.g:331:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // InternalContentAssistCustomizingTestLanguage.g:340:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:344:1: ( rule__FQN__Group__1__Impl )
            // InternalContentAssistCustomizingTestLanguage.g:345:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group__1__Impl();

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
    // $ANTLR end "rule__FQN__Group__1"


    // $ANTLR start "rule__FQN__Group__1__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:351:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:355:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalContentAssistCustomizingTestLanguage.g:356:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalContentAssistCustomizingTestLanguage.g:356:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalContentAssistCustomizingTestLanguage.g:357:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalContentAssistCustomizingTestLanguage.g:358:2: ( rule__FQN__Group_1__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalContentAssistCustomizingTestLanguage.g:358:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

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
    // $ANTLR end "rule__FQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // InternalContentAssistCustomizingTestLanguage.g:367:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:371:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalContentAssistCustomizingTestLanguage.g:372:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__1();

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
    // $ANTLR end "rule__FQN__Group_1__0"


    // $ANTLR start "rule__FQN__Group_1__0__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:379:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:383:1: ( ( '.' ) )
            // InternalContentAssistCustomizingTestLanguage.g:384:1: ( '.' )
            {
            // InternalContentAssistCustomizingTestLanguage.g:384:1: ( '.' )
            // InternalContentAssistCustomizingTestLanguage.g:385:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // InternalContentAssistCustomizingTestLanguage.g:394:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:398:1: ( rule__FQN__Group_1__1__Impl )
            // InternalContentAssistCustomizingTestLanguage.g:399:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__1__Impl();

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
    // $ANTLR end "rule__FQN__Group_1__1"


    // $ANTLR start "rule__FQN__Group_1__1__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:405:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:409:1: ( ( RULE_ID ) )
            // InternalContentAssistCustomizingTestLanguage.g:410:1: ( RULE_ID )
            {
            // InternalContentAssistCustomizingTestLanguage.g:410:1: ( RULE_ID )
            // InternalContentAssistCustomizingTestLanguage.g:411:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

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
    // $ANTLR end "rule__FQN__Group_1__1__Impl"


    // $ANTLR start "rule__Model__TypesAssignment"
    // InternalContentAssistCustomizingTestLanguage.g:421:1: rule__Model__TypesAssignment : ( ruleType ) ;
    public final void rule__Model__TypesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:425:1: ( ( ruleType ) )
            // InternalContentAssistCustomizingTestLanguage.g:426:2: ( ruleType )
            {
            // InternalContentAssistCustomizingTestLanguage.g:426:2: ( ruleType )
            // InternalContentAssistCustomizingTestLanguage.g:427:3: ruleType
            {
             before(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__TypesAssignment"


    // $ANTLR start "rule__Type__NameAssignment_0_0"
    // InternalContentAssistCustomizingTestLanguage.g:436:1: rule__Type__NameAssignment_0_0 : ( ruleFQN ) ;
    public final void rule__Type__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:440:1: ( ( ruleFQN ) )
            // InternalContentAssistCustomizingTestLanguage.g:441:2: ( ruleFQN )
            {
            // InternalContentAssistCustomizingTestLanguage.g:441:2: ( ruleFQN )
            // InternalContentAssistCustomizingTestLanguage.g:442:3: ruleFQN
            {
             before(grammarAccess.getTypeAccess().getNameFQNParserRuleCall_0_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getNameFQNParserRuleCall_0_0_0()); 

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
    // $ANTLR end "rule__Type__NameAssignment_0_0"


    // $ANTLR start "rule__Type__NameAssignment_0_1"
    // InternalContentAssistCustomizingTestLanguage.g:451:1: rule__Type__NameAssignment_0_1 : ( ( 'FQN' ) ) ;
    public final void rule__Type__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:455:1: ( ( ( 'FQN' ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:456:2: ( ( 'FQN' ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:456:2: ( ( 'FQN' ) )
            // InternalContentAssistCustomizingTestLanguage.g:457:3: ( 'FQN' )
            {
             before(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 
            // InternalContentAssistCustomizingTestLanguage.g:458:3: ( 'FQN' )
            // InternalContentAssistCustomizingTestLanguage.g:459:4: 'FQN'
            {
             before(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 

            }

             after(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 

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
    // $ANTLR end "rule__Type__NameAssignment_0_1"


    // $ANTLR start "rule__Type__SuperTypeAssignment_1_1"
    // InternalContentAssistCustomizingTestLanguage.g:470:1: rule__Type__SuperTypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__Type__SuperTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:474:1: ( ( ruleTypeRef ) )
            // InternalContentAssistCustomizingTestLanguage.g:475:2: ( ruleTypeRef )
            {
            // InternalContentAssistCustomizingTestLanguage.g:475:2: ( ruleTypeRef )
            // InternalContentAssistCustomizingTestLanguage.g:476:3: ruleTypeRef
            {
             before(grammarAccess.getTypeAccess().getSuperTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getSuperTypeTypeRefParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Type__SuperTypeAssignment_1_1"


    // $ANTLR start "rule__TypeRef__TypeAssignment"
    // InternalContentAssistCustomizingTestLanguage.g:485:1: rule__TypeRef__TypeAssignment : ( ( ruleFQN ) ) ;
    public final void rule__TypeRef__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:489:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:490:2: ( ( ruleFQN ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:490:2: ( ( ruleFQN ) )
            // InternalContentAssistCustomizingTestLanguage.g:491:3: ( ruleFQN )
            {
             before(grammarAccess.getTypeRefAccess().getTypeTypeCrossReference_0()); 
            // InternalContentAssistCustomizingTestLanguage.g:492:3: ( ruleFQN )
            // InternalContentAssistCustomizingTestLanguage.g:493:4: ruleFQN
            {
             before(grammarAccess.getTypeRefAccess().getTypeTypeFQNParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getTypeRefAccess().getTypeTypeFQNParserRuleCall_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getTypeTypeCrossReference_0()); 

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
    // $ANTLR end "rule__TypeRef__TypeAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002002L});
    }


}
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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug291022TestLanguageGrammarAccess;



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
public class InternalBug291022TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'{'", "'}'", "':'", "'='"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug291022TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug291022TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug291022TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug291022TestLanguage.g"; }


    	private Bug291022TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug291022TestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleRootModel"
    // InternalBug291022TestLanguage.g:58:1: entryRuleRootModel : ruleRootModel EOF ;
    public final void entryRuleRootModel() throws RecognitionException {
        try {
            // InternalBug291022TestLanguage.g:59:1: ( ruleRootModel EOF )
            // InternalBug291022TestLanguage.g:60:1: ruleRootModel EOF
            {
             before(grammarAccess.getRootModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRootModel();

            state._fsp--;

             after(grammarAccess.getRootModelRule()); 
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
    // $ANTLR end "entryRuleRootModel"


    // $ANTLR start "ruleRootModel"
    // InternalBug291022TestLanguage.g:67:1: ruleRootModel : ( ( rule__RootModel__Group__0 )? ) ;
    public final void ruleRootModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:71:2: ( ( ( rule__RootModel__Group__0 )? ) )
            // InternalBug291022TestLanguage.g:72:2: ( ( rule__RootModel__Group__0 )? )
            {
            // InternalBug291022TestLanguage.g:72:2: ( ( rule__RootModel__Group__0 )? )
            // InternalBug291022TestLanguage.g:73:3: ( rule__RootModel__Group__0 )?
            {
             before(grammarAccess.getRootModelAccess().getGroup()); 
            // InternalBug291022TestLanguage.g:74:3: ( rule__RootModel__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug291022TestLanguage.g:74:4: rule__RootModel__Group__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RootModel__Group__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootModelAccess().getGroup()); 

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
    // $ANTLR end "ruleRootModel"


    // $ANTLR start "entryRuleModelElement"
    // InternalBug291022TestLanguage.g:83:1: entryRuleModelElement : ruleModelElement EOF ;
    public final void entryRuleModelElement() throws RecognitionException {
        try {
            // InternalBug291022TestLanguage.g:84:1: ( ruleModelElement EOF )
            // InternalBug291022TestLanguage.g:85:1: ruleModelElement EOF
            {
             before(grammarAccess.getModelElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModelElement();

            state._fsp--;

             after(grammarAccess.getModelElementRule()); 
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
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // InternalBug291022TestLanguage.g:92:1: ruleModelElement : ( ( rule__ModelElement__Group__0 ) ) ;
    public final void ruleModelElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:96:2: ( ( ( rule__ModelElement__Group__0 ) ) )
            // InternalBug291022TestLanguage.g:97:2: ( ( rule__ModelElement__Group__0 ) )
            {
            // InternalBug291022TestLanguage.g:97:2: ( ( rule__ModelElement__Group__0 ) )
            // InternalBug291022TestLanguage.g:98:3: ( rule__ModelElement__Group__0 )
            {
             before(grammarAccess.getModelElementAccess().getGroup()); 
            // InternalBug291022TestLanguage.g:99:3: ( rule__ModelElement__Group__0 )
            // InternalBug291022TestLanguage.g:99:4: rule__ModelElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getGroup()); 

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
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleModelAttribute"
    // InternalBug291022TestLanguage.g:108:1: entryRuleModelAttribute : ruleModelAttribute EOF ;
    public final void entryRuleModelAttribute() throws RecognitionException {
        try {
            // InternalBug291022TestLanguage.g:109:1: ( ruleModelAttribute EOF )
            // InternalBug291022TestLanguage.g:110:1: ruleModelAttribute EOF
            {
             before(grammarAccess.getModelAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModelAttribute();

            state._fsp--;

             after(grammarAccess.getModelAttributeRule()); 
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
    // $ANTLR end "entryRuleModelAttribute"


    // $ANTLR start "ruleModelAttribute"
    // InternalBug291022TestLanguage.g:117:1: ruleModelAttribute : ( ( rule__ModelAttribute__Alternatives ) ) ;
    public final void ruleModelAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:121:2: ( ( ( rule__ModelAttribute__Alternatives ) ) )
            // InternalBug291022TestLanguage.g:122:2: ( ( rule__ModelAttribute__Alternatives ) )
            {
            // InternalBug291022TestLanguage.g:122:2: ( ( rule__ModelAttribute__Alternatives ) )
            // InternalBug291022TestLanguage.g:123:3: ( rule__ModelAttribute__Alternatives )
            {
             before(grammarAccess.getModelAttributeAccess().getAlternatives()); 
            // InternalBug291022TestLanguage.g:124:3: ( rule__ModelAttribute__Alternatives )
            // InternalBug291022TestLanguage.g:124:4: rule__ModelAttribute__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelAttribute__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelAttributeAccess().getAlternatives()); 

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
    // $ANTLR end "ruleModelAttribute"


    // $ANTLR start "entryRuleAttribute"
    // InternalBug291022TestLanguage.g:133:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalBug291022TestLanguage.g:134:1: ( ruleAttribute EOF )
            // InternalBug291022TestLanguage.g:135:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalBug291022TestLanguage.g:142:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:146:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalBug291022TestLanguage.g:147:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalBug291022TestLanguage.g:147:2: ( ( rule__Attribute__Group__0 ) )
            // InternalBug291022TestLanguage.g:148:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalBug291022TestLanguage.g:149:3: ( rule__Attribute__Group__0 )
            // InternalBug291022TestLanguage.g:149:4: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "rule__ModelElement__Alternatives_3"
    // InternalBug291022TestLanguage.g:157:1: rule__ModelElement__Alternatives_3 : ( ( ';' ) | ( ( rule__ModelElement__Group_3_1__0 ) ) );
    public final void rule__ModelElement__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:161:1: ( ( ';' ) | ( ( rule__ModelElement__Group_3_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug291022TestLanguage.g:162:2: ( ';' )
                    {
                    // InternalBug291022TestLanguage.g:162:2: ( ';' )
                    // InternalBug291022TestLanguage.g:163:3: ';'
                    {
                     before(grammarAccess.getModelElementAccess().getSemicolonKeyword_3_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getModelElementAccess().getSemicolonKeyword_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug291022TestLanguage.g:168:2: ( ( rule__ModelElement__Group_3_1__0 ) )
                    {
                    // InternalBug291022TestLanguage.g:168:2: ( ( rule__ModelElement__Group_3_1__0 ) )
                    // InternalBug291022TestLanguage.g:169:3: ( rule__ModelElement__Group_3_1__0 )
                    {
                     before(grammarAccess.getModelElementAccess().getGroup_3_1()); 
                    // InternalBug291022TestLanguage.g:170:3: ( rule__ModelElement__Group_3_1__0 )
                    // InternalBug291022TestLanguage.g:170:4: rule__ModelElement__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ModelElement__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelElementAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__ModelElement__Alternatives_3"


    // $ANTLR start "rule__ModelAttribute__Alternatives"
    // InternalBug291022TestLanguage.g:178:1: rule__ModelAttribute__Alternatives : ( ( ruleModelElement ) | ( ruleAttribute ) );
    public final void rule__ModelAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:182:1: ( ( ruleModelElement ) | ( ruleAttribute ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==RULE_ID||(LA3_1>=11 && LA3_1<=12)||LA3_1==14) ) {
                    alt3=1;
                }
                else if ( (LA3_1==15) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug291022TestLanguage.g:183:2: ( ruleModelElement )
                    {
                    // InternalBug291022TestLanguage.g:183:2: ( ruleModelElement )
                    // InternalBug291022TestLanguage.g:184:3: ruleModelElement
                    {
                     before(grammarAccess.getModelAttributeAccess().getModelElementParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleModelElement();

                    state._fsp--;

                     after(grammarAccess.getModelAttributeAccess().getModelElementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug291022TestLanguage.g:189:2: ( ruleAttribute )
                    {
                    // InternalBug291022TestLanguage.g:189:2: ( ruleAttribute )
                    // InternalBug291022TestLanguage.g:190:3: ruleAttribute
                    {
                     before(grammarAccess.getModelAttributeAccess().getAttributeParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAttribute();

                    state._fsp--;

                     after(grammarAccess.getModelAttributeAccess().getAttributeParserRuleCall_1()); 

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
    // $ANTLR end "rule__ModelAttribute__Alternatives"


    // $ANTLR start "rule__RootModel__Group__0"
    // InternalBug291022TestLanguage.g:199:1: rule__RootModel__Group__0 : rule__RootModel__Group__0__Impl rule__RootModel__Group__1 ;
    public final void rule__RootModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:203:1: ( rule__RootModel__Group__0__Impl rule__RootModel__Group__1 )
            // InternalBug291022TestLanguage.g:204:2: rule__RootModel__Group__0__Impl rule__RootModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__RootModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group__1();

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
    // $ANTLR end "rule__RootModel__Group__0"


    // $ANTLR start "rule__RootModel__Group__0__Impl"
    // InternalBug291022TestLanguage.g:211:1: rule__RootModel__Group__0__Impl : ( () ) ;
    public final void rule__RootModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:215:1: ( ( () ) )
            // InternalBug291022TestLanguage.g:216:1: ( () )
            {
            // InternalBug291022TestLanguage.g:216:1: ( () )
            // InternalBug291022TestLanguage.g:217:2: ()
            {
             before(grammarAccess.getRootModelAccess().getRootModelAction_0()); 
            // InternalBug291022TestLanguage.g:218:2: ()
            // InternalBug291022TestLanguage.g:218:3: 
            {
            }

             after(grammarAccess.getRootModelAccess().getRootModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootModel__Group__0__Impl"


    // $ANTLR start "rule__RootModel__Group__1"
    // InternalBug291022TestLanguage.g:226:1: rule__RootModel__Group__1 : rule__RootModel__Group__1__Impl rule__RootModel__Group__2 ;
    public final void rule__RootModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:230:1: ( rule__RootModel__Group__1__Impl rule__RootModel__Group__2 )
            // InternalBug291022TestLanguage.g:231:2: rule__RootModel__Group__1__Impl rule__RootModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__RootModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group__2();

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
    // $ANTLR end "rule__RootModel__Group__1"


    // $ANTLR start "rule__RootModel__Group__1__Impl"
    // InternalBug291022TestLanguage.g:238:1: rule__RootModel__Group__1__Impl : ( ( rule__RootModel__NameAssignment_1 ) ) ;
    public final void rule__RootModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:242:1: ( ( ( rule__RootModel__NameAssignment_1 ) ) )
            // InternalBug291022TestLanguage.g:243:1: ( ( rule__RootModel__NameAssignment_1 ) )
            {
            // InternalBug291022TestLanguage.g:243:1: ( ( rule__RootModel__NameAssignment_1 ) )
            // InternalBug291022TestLanguage.g:244:2: ( rule__RootModel__NameAssignment_1 )
            {
             before(grammarAccess.getRootModelAccess().getNameAssignment_1()); 
            // InternalBug291022TestLanguage.g:245:2: ( rule__RootModel__NameAssignment_1 )
            // InternalBug291022TestLanguage.g:245:3: rule__RootModel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRootModelAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__RootModel__Group__1__Impl"


    // $ANTLR start "rule__RootModel__Group__2"
    // InternalBug291022TestLanguage.g:253:1: rule__RootModel__Group__2 : rule__RootModel__Group__2__Impl rule__RootModel__Group__3 ;
    public final void rule__RootModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:257:1: ( rule__RootModel__Group__2__Impl rule__RootModel__Group__3 )
            // InternalBug291022TestLanguage.g:258:2: rule__RootModel__Group__2__Impl rule__RootModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__RootModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group__3();

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
    // $ANTLR end "rule__RootModel__Group__2"


    // $ANTLR start "rule__RootModel__Group__2__Impl"
    // InternalBug291022TestLanguage.g:265:1: rule__RootModel__Group__2__Impl : ( ( rule__RootModel__TypeAssignment_2 )? ) ;
    public final void rule__RootModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:269:1: ( ( ( rule__RootModel__TypeAssignment_2 )? ) )
            // InternalBug291022TestLanguage.g:270:1: ( ( rule__RootModel__TypeAssignment_2 )? )
            {
            // InternalBug291022TestLanguage.g:270:1: ( ( rule__RootModel__TypeAssignment_2 )? )
            // InternalBug291022TestLanguage.g:271:2: ( rule__RootModel__TypeAssignment_2 )?
            {
             before(grammarAccess.getRootModelAccess().getTypeAssignment_2()); 
            // InternalBug291022TestLanguage.g:272:2: ( rule__RootModel__TypeAssignment_2 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug291022TestLanguage.g:272:3: rule__RootModel__TypeAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RootModel__TypeAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootModelAccess().getTypeAssignment_2()); 

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
    // $ANTLR end "rule__RootModel__Group__2__Impl"


    // $ANTLR start "rule__RootModel__Group__3"
    // InternalBug291022TestLanguage.g:280:1: rule__RootModel__Group__3 : rule__RootModel__Group__3__Impl ;
    public final void rule__RootModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:284:1: ( rule__RootModel__Group__3__Impl )
            // InternalBug291022TestLanguage.g:285:2: rule__RootModel__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group__3__Impl();

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
    // $ANTLR end "rule__RootModel__Group__3"


    // $ANTLR start "rule__RootModel__Group__3__Impl"
    // InternalBug291022TestLanguage.g:291:1: rule__RootModel__Group__3__Impl : ( ( rule__RootModel__Group_3__0 )? ) ;
    public final void rule__RootModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:295:1: ( ( ( rule__RootModel__Group_3__0 )? ) )
            // InternalBug291022TestLanguage.g:296:1: ( ( rule__RootModel__Group_3__0 )? )
            {
            // InternalBug291022TestLanguage.g:296:1: ( ( rule__RootModel__Group_3__0 )? )
            // InternalBug291022TestLanguage.g:297:2: ( rule__RootModel__Group_3__0 )?
            {
             before(grammarAccess.getRootModelAccess().getGroup_3()); 
            // InternalBug291022TestLanguage.g:298:2: ( rule__RootModel__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBug291022TestLanguage.g:298:3: rule__RootModel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RootModel__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootModelAccess().getGroup_3()); 

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
    // $ANTLR end "rule__RootModel__Group__3__Impl"


    // $ANTLR start "rule__RootModel__Group_3__0"
    // InternalBug291022TestLanguage.g:307:1: rule__RootModel__Group_3__0 : rule__RootModel__Group_3__0__Impl rule__RootModel__Group_3__1 ;
    public final void rule__RootModel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:311:1: ( rule__RootModel__Group_3__0__Impl rule__RootModel__Group_3__1 )
            // InternalBug291022TestLanguage.g:312:2: rule__RootModel__Group_3__0__Impl rule__RootModel__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__RootModel__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group_3__1();

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
    // $ANTLR end "rule__RootModel__Group_3__0"


    // $ANTLR start "rule__RootModel__Group_3__0__Impl"
    // InternalBug291022TestLanguage.g:319:1: rule__RootModel__Group_3__0__Impl : ( '{' ) ;
    public final void rule__RootModel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:323:1: ( ( '{' ) )
            // InternalBug291022TestLanguage.g:324:1: ( '{' )
            {
            // InternalBug291022TestLanguage.g:324:1: ( '{' )
            // InternalBug291022TestLanguage.g:325:2: '{'
            {
             before(grammarAccess.getRootModelAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootModelAccess().getLeftCurlyBracketKeyword_3_0()); 

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
    // $ANTLR end "rule__RootModel__Group_3__0__Impl"


    // $ANTLR start "rule__RootModel__Group_3__1"
    // InternalBug291022TestLanguage.g:334:1: rule__RootModel__Group_3__1 : rule__RootModel__Group_3__1__Impl rule__RootModel__Group_3__2 ;
    public final void rule__RootModel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:338:1: ( rule__RootModel__Group_3__1__Impl rule__RootModel__Group_3__2 )
            // InternalBug291022TestLanguage.g:339:2: rule__RootModel__Group_3__1__Impl rule__RootModel__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__RootModel__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group_3__2();

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
    // $ANTLR end "rule__RootModel__Group_3__1"


    // $ANTLR start "rule__RootModel__Group_3__1__Impl"
    // InternalBug291022TestLanguage.g:346:1: rule__RootModel__Group_3__1__Impl : ( ( rule__RootModel__ElementsAssignment_3_1 )* ) ;
    public final void rule__RootModel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:350:1: ( ( ( rule__RootModel__ElementsAssignment_3_1 )* ) )
            // InternalBug291022TestLanguage.g:351:1: ( ( rule__RootModel__ElementsAssignment_3_1 )* )
            {
            // InternalBug291022TestLanguage.g:351:1: ( ( rule__RootModel__ElementsAssignment_3_1 )* )
            // InternalBug291022TestLanguage.g:352:2: ( rule__RootModel__ElementsAssignment_3_1 )*
            {
             before(grammarAccess.getRootModelAccess().getElementsAssignment_3_1()); 
            // InternalBug291022TestLanguage.g:353:2: ( rule__RootModel__ElementsAssignment_3_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBug291022TestLanguage.g:353:3: rule__RootModel__ElementsAssignment_3_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    rule__RootModel__ElementsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRootModelAccess().getElementsAssignment_3_1()); 

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
    // $ANTLR end "rule__RootModel__Group_3__1__Impl"


    // $ANTLR start "rule__RootModel__Group_3__2"
    // InternalBug291022TestLanguage.g:361:1: rule__RootModel__Group_3__2 : rule__RootModel__Group_3__2__Impl ;
    public final void rule__RootModel__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:365:1: ( rule__RootModel__Group_3__2__Impl )
            // InternalBug291022TestLanguage.g:366:2: rule__RootModel__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RootModel__Group_3__2__Impl();

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
    // $ANTLR end "rule__RootModel__Group_3__2"


    // $ANTLR start "rule__RootModel__Group_3__2__Impl"
    // InternalBug291022TestLanguage.g:372:1: rule__RootModel__Group_3__2__Impl : ( '}' ) ;
    public final void rule__RootModel__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:376:1: ( ( '}' ) )
            // InternalBug291022TestLanguage.g:377:1: ( '}' )
            {
            // InternalBug291022TestLanguage.g:377:1: ( '}' )
            // InternalBug291022TestLanguage.g:378:2: '}'
            {
             before(grammarAccess.getRootModelAccess().getRightCurlyBracketKeyword_3_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootModelAccess().getRightCurlyBracketKeyword_3_2()); 

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
    // $ANTLR end "rule__RootModel__Group_3__2__Impl"


    // $ANTLR start "rule__ModelElement__Group__0"
    // InternalBug291022TestLanguage.g:388:1: rule__ModelElement__Group__0 : rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1 ;
    public final void rule__ModelElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:392:1: ( rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1 )
            // InternalBug291022TestLanguage.g:393:2: rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__ModelElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group__1();

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
    // $ANTLR end "rule__ModelElement__Group__0"


    // $ANTLR start "rule__ModelElement__Group__0__Impl"
    // InternalBug291022TestLanguage.g:400:1: rule__ModelElement__Group__0__Impl : ( ( rule__ModelElement__FirstReferenceAssignment_0 ) ) ;
    public final void rule__ModelElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:404:1: ( ( ( rule__ModelElement__FirstReferenceAssignment_0 ) ) )
            // InternalBug291022TestLanguage.g:405:1: ( ( rule__ModelElement__FirstReferenceAssignment_0 ) )
            {
            // InternalBug291022TestLanguage.g:405:1: ( ( rule__ModelElement__FirstReferenceAssignment_0 ) )
            // InternalBug291022TestLanguage.g:406:2: ( rule__ModelElement__FirstReferenceAssignment_0 )
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceAssignment_0()); 
            // InternalBug291022TestLanguage.g:407:2: ( rule__ModelElement__FirstReferenceAssignment_0 )
            // InternalBug291022TestLanguage.g:407:3: rule__ModelElement__FirstReferenceAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__FirstReferenceAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getFirstReferenceAssignment_0()); 

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
    // $ANTLR end "rule__ModelElement__Group__0__Impl"


    // $ANTLR start "rule__ModelElement__Group__1"
    // InternalBug291022TestLanguage.g:415:1: rule__ModelElement__Group__1 : rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2 ;
    public final void rule__ModelElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:419:1: ( rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2 )
            // InternalBug291022TestLanguage.g:420:2: rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__ModelElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group__2();

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
    // $ANTLR end "rule__ModelElement__Group__1"


    // $ANTLR start "rule__ModelElement__Group__1__Impl"
    // InternalBug291022TestLanguage.g:427:1: rule__ModelElement__Group__1__Impl : ( ( rule__ModelElement__Group_1__0 )? ) ;
    public final void rule__ModelElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:431:1: ( ( ( rule__ModelElement__Group_1__0 )? ) )
            // InternalBug291022TestLanguage.g:432:1: ( ( rule__ModelElement__Group_1__0 )? )
            {
            // InternalBug291022TestLanguage.g:432:1: ( ( rule__ModelElement__Group_1__0 )? )
            // InternalBug291022TestLanguage.g:433:2: ( rule__ModelElement__Group_1__0 )?
            {
             before(grammarAccess.getModelElementAccess().getGroup_1()); 
            // InternalBug291022TestLanguage.g:434:2: ( rule__ModelElement__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalBug291022TestLanguage.g:434:3: rule__ModelElement__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ModelElement__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelElementAccess().getGroup_1()); 

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
    // $ANTLR end "rule__ModelElement__Group__1__Impl"


    // $ANTLR start "rule__ModelElement__Group__2"
    // InternalBug291022TestLanguage.g:442:1: rule__ModelElement__Group__2 : rule__ModelElement__Group__2__Impl rule__ModelElement__Group__3 ;
    public final void rule__ModelElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:446:1: ( rule__ModelElement__Group__2__Impl rule__ModelElement__Group__3 )
            // InternalBug291022TestLanguage.g:447:2: rule__ModelElement__Group__2__Impl rule__ModelElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__ModelElement__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group__3();

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
    // $ANTLR end "rule__ModelElement__Group__2"


    // $ANTLR start "rule__ModelElement__Group__2__Impl"
    // InternalBug291022TestLanguage.g:454:1: rule__ModelElement__Group__2__Impl : ( ( rule__ModelElement__SecondReferenceAssignment_2 )? ) ;
    public final void rule__ModelElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:458:1: ( ( ( rule__ModelElement__SecondReferenceAssignment_2 )? ) )
            // InternalBug291022TestLanguage.g:459:1: ( ( rule__ModelElement__SecondReferenceAssignment_2 )? )
            {
            // InternalBug291022TestLanguage.g:459:1: ( ( rule__ModelElement__SecondReferenceAssignment_2 )? )
            // InternalBug291022TestLanguage.g:460:2: ( rule__ModelElement__SecondReferenceAssignment_2 )?
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceAssignment_2()); 
            // InternalBug291022TestLanguage.g:461:2: ( rule__ModelElement__SecondReferenceAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug291022TestLanguage.g:461:3: rule__ModelElement__SecondReferenceAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ModelElement__SecondReferenceAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelElementAccess().getSecondReferenceAssignment_2()); 

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
    // $ANTLR end "rule__ModelElement__Group__2__Impl"


    // $ANTLR start "rule__ModelElement__Group__3"
    // InternalBug291022TestLanguage.g:469:1: rule__ModelElement__Group__3 : rule__ModelElement__Group__3__Impl ;
    public final void rule__ModelElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:473:1: ( rule__ModelElement__Group__3__Impl )
            // InternalBug291022TestLanguage.g:474:2: rule__ModelElement__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group__3__Impl();

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
    // $ANTLR end "rule__ModelElement__Group__3"


    // $ANTLR start "rule__ModelElement__Group__3__Impl"
    // InternalBug291022TestLanguage.g:480:1: rule__ModelElement__Group__3__Impl : ( ( rule__ModelElement__Alternatives_3 ) ) ;
    public final void rule__ModelElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:484:1: ( ( ( rule__ModelElement__Alternatives_3 ) ) )
            // InternalBug291022TestLanguage.g:485:1: ( ( rule__ModelElement__Alternatives_3 ) )
            {
            // InternalBug291022TestLanguage.g:485:1: ( ( rule__ModelElement__Alternatives_3 ) )
            // InternalBug291022TestLanguage.g:486:2: ( rule__ModelElement__Alternatives_3 )
            {
             before(grammarAccess.getModelElementAccess().getAlternatives_3()); 
            // InternalBug291022TestLanguage.g:487:2: ( rule__ModelElement__Alternatives_3 )
            // InternalBug291022TestLanguage.g:487:3: rule__ModelElement__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getAlternatives_3()); 

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
    // $ANTLR end "rule__ModelElement__Group__3__Impl"


    // $ANTLR start "rule__ModelElement__Group_1__0"
    // InternalBug291022TestLanguage.g:496:1: rule__ModelElement__Group_1__0 : rule__ModelElement__Group_1__0__Impl rule__ModelElement__Group_1__1 ;
    public final void rule__ModelElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:500:1: ( rule__ModelElement__Group_1__0__Impl rule__ModelElement__Group_1__1 )
            // InternalBug291022TestLanguage.g:501:2: rule__ModelElement__Group_1__0__Impl rule__ModelElement__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__ModelElement__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group_1__1();

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
    // $ANTLR end "rule__ModelElement__Group_1__0"


    // $ANTLR start "rule__ModelElement__Group_1__0__Impl"
    // InternalBug291022TestLanguage.g:508:1: rule__ModelElement__Group_1__0__Impl : ( ':' ) ;
    public final void rule__ModelElement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:512:1: ( ( ':' ) )
            // InternalBug291022TestLanguage.g:513:1: ( ':' )
            {
            // InternalBug291022TestLanguage.g:513:1: ( ':' )
            // InternalBug291022TestLanguage.g:514:2: ':'
            {
             before(grammarAccess.getModelElementAccess().getColonKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getColonKeyword_1_0()); 

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
    // $ANTLR end "rule__ModelElement__Group_1__0__Impl"


    // $ANTLR start "rule__ModelElement__Group_1__1"
    // InternalBug291022TestLanguage.g:523:1: rule__ModelElement__Group_1__1 : rule__ModelElement__Group_1__1__Impl ;
    public final void rule__ModelElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:527:1: ( rule__ModelElement__Group_1__1__Impl )
            // InternalBug291022TestLanguage.g:528:2: rule__ModelElement__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group_1__1__Impl();

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
    // $ANTLR end "rule__ModelElement__Group_1__1"


    // $ANTLR start "rule__ModelElement__Group_1__1__Impl"
    // InternalBug291022TestLanguage.g:534:1: rule__ModelElement__Group_1__1__Impl : ( ( rule__ModelElement__NameAssignment_1_1 ) ) ;
    public final void rule__ModelElement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:538:1: ( ( ( rule__ModelElement__NameAssignment_1_1 ) ) )
            // InternalBug291022TestLanguage.g:539:1: ( ( rule__ModelElement__NameAssignment_1_1 ) )
            {
            // InternalBug291022TestLanguage.g:539:1: ( ( rule__ModelElement__NameAssignment_1_1 ) )
            // InternalBug291022TestLanguage.g:540:2: ( rule__ModelElement__NameAssignment_1_1 )
            {
             before(grammarAccess.getModelElementAccess().getNameAssignment_1_1()); 
            // InternalBug291022TestLanguage.g:541:2: ( rule__ModelElement__NameAssignment_1_1 )
            // InternalBug291022TestLanguage.g:541:3: rule__ModelElement__NameAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getNameAssignment_1_1()); 

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
    // $ANTLR end "rule__ModelElement__Group_1__1__Impl"


    // $ANTLR start "rule__ModelElement__Group_3_1__0"
    // InternalBug291022TestLanguage.g:550:1: rule__ModelElement__Group_3_1__0 : rule__ModelElement__Group_3_1__0__Impl rule__ModelElement__Group_3_1__1 ;
    public final void rule__ModelElement__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:554:1: ( rule__ModelElement__Group_3_1__0__Impl rule__ModelElement__Group_3_1__1 )
            // InternalBug291022TestLanguage.g:555:2: rule__ModelElement__Group_3_1__0__Impl rule__ModelElement__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ModelElement__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group_3_1__1();

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
    // $ANTLR end "rule__ModelElement__Group_3_1__0"


    // $ANTLR start "rule__ModelElement__Group_3_1__0__Impl"
    // InternalBug291022TestLanguage.g:562:1: rule__ModelElement__Group_3_1__0__Impl : ( '{' ) ;
    public final void rule__ModelElement__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:566:1: ( ( '{' ) )
            // InternalBug291022TestLanguage.g:567:1: ( '{' )
            {
            // InternalBug291022TestLanguage.g:567:1: ( '{' )
            // InternalBug291022TestLanguage.g:568:2: '{'
            {
             before(grammarAccess.getModelElementAccess().getLeftCurlyBracketKeyword_3_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getLeftCurlyBracketKeyword_3_1_0()); 

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
    // $ANTLR end "rule__ModelElement__Group_3_1__0__Impl"


    // $ANTLR start "rule__ModelElement__Group_3_1__1"
    // InternalBug291022TestLanguage.g:577:1: rule__ModelElement__Group_3_1__1 : rule__ModelElement__Group_3_1__1__Impl rule__ModelElement__Group_3_1__2 ;
    public final void rule__ModelElement__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:581:1: ( rule__ModelElement__Group_3_1__1__Impl rule__ModelElement__Group_3_1__2 )
            // InternalBug291022TestLanguage.g:582:2: rule__ModelElement__Group_3_1__1__Impl rule__ModelElement__Group_3_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ModelElement__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group_3_1__2();

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
    // $ANTLR end "rule__ModelElement__Group_3_1__1"


    // $ANTLR start "rule__ModelElement__Group_3_1__1__Impl"
    // InternalBug291022TestLanguage.g:589:1: rule__ModelElement__Group_3_1__1__Impl : ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* ) ;
    public final void rule__ModelElement__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:593:1: ( ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* ) )
            // InternalBug291022TestLanguage.g:594:1: ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* )
            {
            // InternalBug291022TestLanguage.g:594:1: ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* )
            // InternalBug291022TestLanguage.g:595:2: ( rule__ModelElement__ElementsAssignment_3_1_1 )*
            {
             before(grammarAccess.getModelElementAccess().getElementsAssignment_3_1_1()); 
            // InternalBug291022TestLanguage.g:596:2: ( rule__ModelElement__ElementsAssignment_3_1_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBug291022TestLanguage.g:596:3: rule__ModelElement__ElementsAssignment_3_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    rule__ModelElement__ElementsAssignment_3_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModelElementAccess().getElementsAssignment_3_1_1()); 

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
    // $ANTLR end "rule__ModelElement__Group_3_1__1__Impl"


    // $ANTLR start "rule__ModelElement__Group_3_1__2"
    // InternalBug291022TestLanguage.g:604:1: rule__ModelElement__Group_3_1__2 : rule__ModelElement__Group_3_1__2__Impl ;
    public final void rule__ModelElement__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:608:1: ( rule__ModelElement__Group_3_1__2__Impl )
            // InternalBug291022TestLanguage.g:609:2: rule__ModelElement__Group_3_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ModelElement__Group_3_1__2__Impl();

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
    // $ANTLR end "rule__ModelElement__Group_3_1__2"


    // $ANTLR start "rule__ModelElement__Group_3_1__2__Impl"
    // InternalBug291022TestLanguage.g:615:1: rule__ModelElement__Group_3_1__2__Impl : ( '}' ) ;
    public final void rule__ModelElement__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:619:1: ( ( '}' ) )
            // InternalBug291022TestLanguage.g:620:1: ( '}' )
            {
            // InternalBug291022TestLanguage.g:620:1: ( '}' )
            // InternalBug291022TestLanguage.g:621:2: '}'
            {
             before(grammarAccess.getModelElementAccess().getRightCurlyBracketKeyword_3_1_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getRightCurlyBracketKeyword_3_1_2()); 

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
    // $ANTLR end "rule__ModelElement__Group_3_1__2__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalBug291022TestLanguage.g:631:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:635:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalBug291022TestLanguage.g:636:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__1();

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
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalBug291022TestLanguage.g:643:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__FeatureAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:647:1: ( ( ( rule__Attribute__FeatureAssignment_0 ) ) )
            // InternalBug291022TestLanguage.g:648:1: ( ( rule__Attribute__FeatureAssignment_0 ) )
            {
            // InternalBug291022TestLanguage.g:648:1: ( ( rule__Attribute__FeatureAssignment_0 ) )
            // InternalBug291022TestLanguage.g:649:2: ( rule__Attribute__FeatureAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getFeatureAssignment_0()); 
            // InternalBug291022TestLanguage.g:650:2: ( rule__Attribute__FeatureAssignment_0 )
            // InternalBug291022TestLanguage.g:650:3: rule__Attribute__FeatureAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__FeatureAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getFeatureAssignment_0()); 

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
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalBug291022TestLanguage.g:658:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:662:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalBug291022TestLanguage.g:663:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__2();

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
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalBug291022TestLanguage.g:670:1: rule__Attribute__Group__1__Impl : ( '=' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:674:1: ( ( '=' ) )
            // InternalBug291022TestLanguage.g:675:1: ( '=' )
            {
            // InternalBug291022TestLanguage.g:675:1: ( '=' )
            // InternalBug291022TestLanguage.g:676:2: '='
            {
             before(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); 

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
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalBug291022TestLanguage.g:685:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:689:1: ( rule__Attribute__Group__2__Impl )
            // InternalBug291022TestLanguage.g:690:2: rule__Attribute__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__2__Impl();

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
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // InternalBug291022TestLanguage.g:696:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ValueAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:700:1: ( ( ( rule__Attribute__ValueAssignment_2 ) ) )
            // InternalBug291022TestLanguage.g:701:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            {
            // InternalBug291022TestLanguage.g:701:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            // InternalBug291022TestLanguage.g:702:2: ( rule__Attribute__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment_2()); 
            // InternalBug291022TestLanguage.g:703:2: ( rule__Attribute__ValueAssignment_2 )
            // InternalBug291022TestLanguage.g:703:3: rule__Attribute__ValueAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getValueAssignment_2()); 

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
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__RootModel__NameAssignment_1"
    // InternalBug291022TestLanguage.g:712:1: rule__RootModel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RootModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:716:1: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:717:2: ( RULE_ID )
            {
            // InternalBug291022TestLanguage.g:717:2: ( RULE_ID )
            // InternalBug291022TestLanguage.g:718:3: RULE_ID
            {
             before(grammarAccess.getRootModelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootModelAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__RootModel__NameAssignment_1"


    // $ANTLR start "rule__RootModel__TypeAssignment_2"
    // InternalBug291022TestLanguage.g:727:1: rule__RootModel__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__RootModel__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:731:1: ( ( ( RULE_ID ) ) )
            // InternalBug291022TestLanguage.g:732:2: ( ( RULE_ID ) )
            {
            // InternalBug291022TestLanguage.g:732:2: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:733:3: ( RULE_ID )
            {
             before(grammarAccess.getRootModelAccess().getTypeModelElementCrossReference_2_0()); 
            // InternalBug291022TestLanguage.g:734:3: ( RULE_ID )
            // InternalBug291022TestLanguage.g:735:4: RULE_ID
            {
             before(grammarAccess.getRootModelAccess().getTypeModelElementIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootModelAccess().getTypeModelElementIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getRootModelAccess().getTypeModelElementCrossReference_2_0()); 

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
    // $ANTLR end "rule__RootModel__TypeAssignment_2"


    // $ANTLR start "rule__RootModel__ElementsAssignment_3_1"
    // InternalBug291022TestLanguage.g:746:1: rule__RootModel__ElementsAssignment_3_1 : ( ruleModelAttribute ) ;
    public final void rule__RootModel__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:750:1: ( ( ruleModelAttribute ) )
            // InternalBug291022TestLanguage.g:751:2: ( ruleModelAttribute )
            {
            // InternalBug291022TestLanguage.g:751:2: ( ruleModelAttribute )
            // InternalBug291022TestLanguage.g:752:3: ruleModelAttribute
            {
             before(grammarAccess.getRootModelAccess().getElementsModelAttributeParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleModelAttribute();

            state._fsp--;

             after(grammarAccess.getRootModelAccess().getElementsModelAttributeParserRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__RootModel__ElementsAssignment_3_1"


    // $ANTLR start "rule__ModelElement__FirstReferenceAssignment_0"
    // InternalBug291022TestLanguage.g:761:1: rule__ModelElement__FirstReferenceAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ModelElement__FirstReferenceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:765:1: ( ( ( RULE_ID ) ) )
            // InternalBug291022TestLanguage.g:766:2: ( ( RULE_ID ) )
            {
            // InternalBug291022TestLanguage.g:766:2: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:767:3: ( RULE_ID )
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceModelElementCrossReference_0_0()); 
            // InternalBug291022TestLanguage.g:768:3: ( RULE_ID )
            // InternalBug291022TestLanguage.g:769:4: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceModelElementIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getFirstReferenceModelElementIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getModelElementAccess().getFirstReferenceModelElementCrossReference_0_0()); 

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
    // $ANTLR end "rule__ModelElement__FirstReferenceAssignment_0"


    // $ANTLR start "rule__ModelElement__NameAssignment_1_1"
    // InternalBug291022TestLanguage.g:780:1: rule__ModelElement__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ModelElement__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:784:1: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:785:2: ( RULE_ID )
            {
            // InternalBug291022TestLanguage.g:785:2: ( RULE_ID )
            // InternalBug291022TestLanguage.g:786:3: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getNameIDTerminalRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__ModelElement__NameAssignment_1_1"


    // $ANTLR start "rule__ModelElement__SecondReferenceAssignment_2"
    // InternalBug291022TestLanguage.g:795:1: rule__ModelElement__SecondReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ModelElement__SecondReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:799:1: ( ( ( RULE_ID ) ) )
            // InternalBug291022TestLanguage.g:800:2: ( ( RULE_ID ) )
            {
            // InternalBug291022TestLanguage.g:800:2: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:801:3: ( RULE_ID )
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceModelElementCrossReference_2_0()); 
            // InternalBug291022TestLanguage.g:802:3: ( RULE_ID )
            // InternalBug291022TestLanguage.g:803:4: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceModelElementIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getSecondReferenceModelElementIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getModelElementAccess().getSecondReferenceModelElementCrossReference_2_0()); 

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
    // $ANTLR end "rule__ModelElement__SecondReferenceAssignment_2"


    // $ANTLR start "rule__ModelElement__ElementsAssignment_3_1_1"
    // InternalBug291022TestLanguage.g:814:1: rule__ModelElement__ElementsAssignment_3_1_1 : ( ruleModelAttribute ) ;
    public final void rule__ModelElement__ElementsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:818:1: ( ( ruleModelAttribute ) )
            // InternalBug291022TestLanguage.g:819:2: ( ruleModelAttribute )
            {
            // InternalBug291022TestLanguage.g:819:2: ( ruleModelAttribute )
            // InternalBug291022TestLanguage.g:820:3: ruleModelAttribute
            {
             before(grammarAccess.getModelElementAccess().getElementsModelAttributeParserRuleCall_3_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleModelAttribute();

            state._fsp--;

             after(grammarAccess.getModelElementAccess().getElementsModelAttributeParserRuleCall_3_1_1_0()); 

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
    // $ANTLR end "rule__ModelElement__ElementsAssignment_3_1_1"


    // $ANTLR start "rule__Attribute__FeatureAssignment_0"
    // InternalBug291022TestLanguage.g:829:1: rule__Attribute__FeatureAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:833:1: ( ( ( RULE_ID ) ) )
            // InternalBug291022TestLanguage.g:834:2: ( ( RULE_ID ) )
            {
            // InternalBug291022TestLanguage.g:834:2: ( ( RULE_ID ) )
            // InternalBug291022TestLanguage.g:835:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getFeatureModelElementCrossReference_0_0()); 
            // InternalBug291022TestLanguage.g:836:3: ( RULE_ID )
            // InternalBug291022TestLanguage.g:837:4: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getFeatureModelElementIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getFeatureModelElementIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getFeatureModelElementCrossReference_0_0()); 

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
    // $ANTLR end "rule__Attribute__FeatureAssignment_0"


    // $ANTLR start "rule__Attribute__ValueAssignment_2"
    // InternalBug291022TestLanguage.g:848:1: rule__Attribute__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Attribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug291022TestLanguage.g:852:1: ( ( RULE_STRING ) )
            // InternalBug291022TestLanguage.g:853:2: ( RULE_STRING )
            {
            // InternalBug291022TestLanguage.g:853:2: ( RULE_STRING )
            // InternalBug291022TestLanguage.g:854:3: RULE_STRING
            {
             before(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Attribute__ValueAssignment_2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000005810L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    }


}
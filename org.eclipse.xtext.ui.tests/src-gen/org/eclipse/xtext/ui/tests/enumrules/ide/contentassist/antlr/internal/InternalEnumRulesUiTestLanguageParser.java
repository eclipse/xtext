package org.eclipse.xtext.ui.tests.enumrules.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.enumrules.services.EnumRulesUiTestLanguageGrammarAccess;



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
public class InternalEnumRulesUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'SameName'", "'overridden'", "'DifferentLiteral'", "'existing'", "'generated'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalEnumRulesUiTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEnumRulesUiTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEnumRulesUiTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEnumRulesUiTestLanguage.g"; }


    	private EnumRulesUiTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(EnumRulesUiTestLanguageGrammarAccess grammarAccess) {
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
    // InternalEnumRulesUiTestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalEnumRulesUiTestLanguage.g:59:1: ( ruleModel EOF )
            // InternalEnumRulesUiTestLanguage.g:60:1: ruleModel EOF
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
    // InternalEnumRulesUiTestLanguage.g:67:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:71:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalEnumRulesUiTestLanguage.g:72:2: ( ( rule__Model__Alternatives ) )
            {
            // InternalEnumRulesUiTestLanguage.g:72:2: ( ( rule__Model__Alternatives ) )
            // InternalEnumRulesUiTestLanguage.g:73:3: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalEnumRulesUiTestLanguage.g:74:3: ( rule__Model__Alternatives )
            // InternalEnumRulesUiTestLanguage.g:74:4: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

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


    // $ANTLR start "ruleExistingEnum"
    // InternalEnumRulesUiTestLanguage.g:83:1: ruleExistingEnum : ( ( rule__ExistingEnum__Alternatives ) ) ;
    public final void ruleExistingEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:87:1: ( ( ( rule__ExistingEnum__Alternatives ) ) )
            // InternalEnumRulesUiTestLanguage.g:88:2: ( ( rule__ExistingEnum__Alternatives ) )
            {
            // InternalEnumRulesUiTestLanguage.g:88:2: ( ( rule__ExistingEnum__Alternatives ) )
            // InternalEnumRulesUiTestLanguage.g:89:3: ( rule__ExistingEnum__Alternatives )
            {
             before(grammarAccess.getExistingEnumAccess().getAlternatives()); 
            // InternalEnumRulesUiTestLanguage.g:90:3: ( rule__ExistingEnum__Alternatives )
            // InternalEnumRulesUiTestLanguage.g:90:4: rule__ExistingEnum__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ExistingEnum__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExistingEnumAccess().getAlternatives()); 

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
    // $ANTLR end "ruleExistingEnum"


    // $ANTLR start "ruleGeneratedEnum"
    // InternalEnumRulesUiTestLanguage.g:99:1: ruleGeneratedEnum : ( ( rule__GeneratedEnum__Alternatives ) ) ;
    public final void ruleGeneratedEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:103:1: ( ( ( rule__GeneratedEnum__Alternatives ) ) )
            // InternalEnumRulesUiTestLanguage.g:104:2: ( ( rule__GeneratedEnum__Alternatives ) )
            {
            // InternalEnumRulesUiTestLanguage.g:104:2: ( ( rule__GeneratedEnum__Alternatives ) )
            // InternalEnumRulesUiTestLanguage.g:105:3: ( rule__GeneratedEnum__Alternatives )
            {
             before(grammarAccess.getGeneratedEnumAccess().getAlternatives()); 
            // InternalEnumRulesUiTestLanguage.g:106:3: ( rule__GeneratedEnum__Alternatives )
            // InternalEnumRulesUiTestLanguage.g:106:4: rule__GeneratedEnum__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedEnum__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getGeneratedEnumAccess().getAlternatives()); 

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
    // $ANTLR end "ruleGeneratedEnum"


    // $ANTLR start "rule__Model__Alternatives"
    // InternalEnumRulesUiTestLanguage.g:114:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:118:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalEnumRulesUiTestLanguage.g:119:2: ( ( rule__Model__Group_0__0 ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:119:2: ( ( rule__Model__Group_0__0 ) )
                    // InternalEnumRulesUiTestLanguage.g:120:3: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // InternalEnumRulesUiTestLanguage.g:121:3: ( rule__Model__Group_0__0 )
                    // InternalEnumRulesUiTestLanguage.g:121:4: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEnumRulesUiTestLanguage.g:125:2: ( ( rule__Model__Group_1__0 ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:125:2: ( ( rule__Model__Group_1__0 ) )
                    // InternalEnumRulesUiTestLanguage.g:126:3: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // InternalEnumRulesUiTestLanguage.g:127:3: ( rule__Model__Group_1__0 )
                    // InternalEnumRulesUiTestLanguage.g:127:4: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Model__Alternatives"


    // $ANTLR start "rule__ExistingEnum__Alternatives"
    // InternalEnumRulesUiTestLanguage.g:135:1: rule__ExistingEnum__Alternatives : ( ( ( 'SameName' ) ) | ( ( 'overridden' ) ) | ( ( 'DifferentLiteral' ) ) );
    public final void rule__ExistingEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:139:1: ( ( ( 'SameName' ) ) | ( ( 'overridden' ) ) | ( ( 'DifferentLiteral' ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalEnumRulesUiTestLanguage.g:140:2: ( ( 'SameName' ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:140:2: ( ( 'SameName' ) )
                    // InternalEnumRulesUiTestLanguage.g:141:3: ( 'SameName' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0()); 
                    // InternalEnumRulesUiTestLanguage.g:142:3: ( 'SameName' )
                    // InternalEnumRulesUiTestLanguage.g:142:4: 'SameName'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEnumRulesUiTestLanguage.g:146:2: ( ( 'overridden' ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:146:2: ( ( 'overridden' ) )
                    // InternalEnumRulesUiTestLanguage.g:147:3: ( 'overridden' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1()); 
                    // InternalEnumRulesUiTestLanguage.g:148:3: ( 'overridden' )
                    // InternalEnumRulesUiTestLanguage.g:148:4: 'overridden'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalEnumRulesUiTestLanguage.g:152:2: ( ( 'DifferentLiteral' ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:152:2: ( ( 'DifferentLiteral' ) )
                    // InternalEnumRulesUiTestLanguage.g:153:3: ( 'DifferentLiteral' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2()); 
                    // InternalEnumRulesUiTestLanguage.g:154:3: ( 'DifferentLiteral' )
                    // InternalEnumRulesUiTestLanguage.g:154:4: 'DifferentLiteral'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__ExistingEnum__Alternatives"


    // $ANTLR start "rule__GeneratedEnum__Alternatives"
    // InternalEnumRulesUiTestLanguage.g:162:1: rule__GeneratedEnum__Alternatives : ( ( ( 'SameName' ) ) | ( ( 'DifferentLiteral' ) ) );
    public final void rule__GeneratedEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:166:1: ( ( ( 'SameName' ) ) | ( ( 'DifferentLiteral' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalEnumRulesUiTestLanguage.g:167:2: ( ( 'SameName' ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:167:2: ( ( 'SameName' ) )
                    // InternalEnumRulesUiTestLanguage.g:168:3: ( 'SameName' )
                    {
                     before(grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0()); 
                    // InternalEnumRulesUiTestLanguage.g:169:3: ( 'SameName' )
                    // InternalEnumRulesUiTestLanguage.g:169:4: 'SameName'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEnumRulesUiTestLanguage.g:173:2: ( ( 'DifferentLiteral' ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:173:2: ( ( 'DifferentLiteral' ) )
                    // InternalEnumRulesUiTestLanguage.g:174:3: ( 'DifferentLiteral' )
                    {
                     before(grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1()); 
                    // InternalEnumRulesUiTestLanguage.g:175:3: ( 'DifferentLiteral' )
                    // InternalEnumRulesUiTestLanguage.g:175:4: 'DifferentLiteral'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__GeneratedEnum__Alternatives"


    // $ANTLR start "rule__Model__Group_0__0"
    // InternalEnumRulesUiTestLanguage.g:183:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:187:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // InternalEnumRulesUiTestLanguage.g:188:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__1();

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
    // $ANTLR end "rule__Model__Group_0__0"


    // $ANTLR start "rule__Model__Group_0__0__Impl"
    // InternalEnumRulesUiTestLanguage.g:195:1: rule__Model__Group_0__0__Impl : ( 'existing' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:199:1: ( ( 'existing' ) )
            // InternalEnumRulesUiTestLanguage.g:200:1: ( 'existing' )
            {
            // InternalEnumRulesUiTestLanguage.g:200:1: ( 'existing' )
            // InternalEnumRulesUiTestLanguage.g:201:2: 'existing'
            {
             before(grammarAccess.getModelAccess().getExistingKeyword_0_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelAccess().getExistingKeyword_0_0()); 

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
    // $ANTLR end "rule__Model__Group_0__0__Impl"


    // $ANTLR start "rule__Model__Group_0__1"
    // InternalEnumRulesUiTestLanguage.g:210:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl rule__Model__Group_0__2 ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:214:1: ( rule__Model__Group_0__1__Impl rule__Model__Group_0__2 )
            // InternalEnumRulesUiTestLanguage.g:215:2: rule__Model__Group_0__1__Impl rule__Model__Group_0__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Model__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__2();

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
    // $ANTLR end "rule__Model__Group_0__1"


    // $ANTLR start "rule__Model__Group_0__1__Impl"
    // InternalEnumRulesUiTestLanguage.g:222:1: rule__Model__Group_0__1__Impl : ( ( rule__Model__ExistingAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:226:1: ( ( ( rule__Model__ExistingAssignment_0_1 ) ) )
            // InternalEnumRulesUiTestLanguage.g:227:1: ( ( rule__Model__ExistingAssignment_0_1 ) )
            {
            // InternalEnumRulesUiTestLanguage.g:227:1: ( ( rule__Model__ExistingAssignment_0_1 ) )
            // InternalEnumRulesUiTestLanguage.g:228:2: ( rule__Model__ExistingAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getExistingAssignment_0_1()); 
            // InternalEnumRulesUiTestLanguage.g:229:2: ( rule__Model__ExistingAssignment_0_1 )
            // InternalEnumRulesUiTestLanguage.g:229:3: rule__Model__ExistingAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__ExistingAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getExistingAssignment_0_1()); 

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
    // $ANTLR end "rule__Model__Group_0__1__Impl"


    // $ANTLR start "rule__Model__Group_0__2"
    // InternalEnumRulesUiTestLanguage.g:237:1: rule__Model__Group_0__2 : rule__Model__Group_0__2__Impl ;
    public final void rule__Model__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:241:1: ( rule__Model__Group_0__2__Impl )
            // InternalEnumRulesUiTestLanguage.g:242:2: rule__Model__Group_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__2__Impl();

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
    // $ANTLR end "rule__Model__Group_0__2"


    // $ANTLR start "rule__Model__Group_0__2__Impl"
    // InternalEnumRulesUiTestLanguage.g:248:1: rule__Model__Group_0__2__Impl : ( ( rule__Model__Group_0_2__0 )? ) ;
    public final void rule__Model__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:252:1: ( ( ( rule__Model__Group_0_2__0 )? ) )
            // InternalEnumRulesUiTestLanguage.g:253:1: ( ( rule__Model__Group_0_2__0 )? )
            {
            // InternalEnumRulesUiTestLanguage.g:253:1: ( ( rule__Model__Group_0_2__0 )? )
            // InternalEnumRulesUiTestLanguage.g:254:2: ( rule__Model__Group_0_2__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_0_2()); 
            // InternalEnumRulesUiTestLanguage.g:255:2: ( rule__Model__Group_0_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalEnumRulesUiTestLanguage.g:255:3: rule__Model__Group_0_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_0_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_0_2()); 

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
    // $ANTLR end "rule__Model__Group_0__2__Impl"


    // $ANTLR start "rule__Model__Group_0_2__0"
    // InternalEnumRulesUiTestLanguage.g:264:1: rule__Model__Group_0_2__0 : rule__Model__Group_0_2__0__Impl rule__Model__Group_0_2__1 ;
    public final void rule__Model__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:268:1: ( rule__Model__Group_0_2__0__Impl rule__Model__Group_0_2__1 )
            // InternalEnumRulesUiTestLanguage.g:269:2: rule__Model__Group_0_2__0__Impl rule__Model__Group_0_2__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Model__Group_0_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0_2__1();

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
    // $ANTLR end "rule__Model__Group_0_2__0"


    // $ANTLR start "rule__Model__Group_0_2__0__Impl"
    // InternalEnumRulesUiTestLanguage.g:276:1: rule__Model__Group_0_2__0__Impl : ( 'generated' ) ;
    public final void rule__Model__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:280:1: ( ( 'generated' ) )
            // InternalEnumRulesUiTestLanguage.g:281:1: ( 'generated' )
            {
            // InternalEnumRulesUiTestLanguage.g:281:1: ( 'generated' )
            // InternalEnumRulesUiTestLanguage.g:282:2: 'generated'
            {
             before(grammarAccess.getModelAccess().getGeneratedKeyword_0_2_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelAccess().getGeneratedKeyword_0_2_0()); 

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
    // $ANTLR end "rule__Model__Group_0_2__0__Impl"


    // $ANTLR start "rule__Model__Group_0_2__1"
    // InternalEnumRulesUiTestLanguage.g:291:1: rule__Model__Group_0_2__1 : rule__Model__Group_0_2__1__Impl ;
    public final void rule__Model__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:295:1: ( rule__Model__Group_0_2__1__Impl )
            // InternalEnumRulesUiTestLanguage.g:296:2: rule__Model__Group_0_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0_2__1__Impl();

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
    // $ANTLR end "rule__Model__Group_0_2__1"


    // $ANTLR start "rule__Model__Group_0_2__1__Impl"
    // InternalEnumRulesUiTestLanguage.g:302:1: rule__Model__Group_0_2__1__Impl : ( ( rule__Model__GeneratedAssignment_0_2_1 ) ) ;
    public final void rule__Model__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:306:1: ( ( ( rule__Model__GeneratedAssignment_0_2_1 ) ) )
            // InternalEnumRulesUiTestLanguage.g:307:1: ( ( rule__Model__GeneratedAssignment_0_2_1 ) )
            {
            // InternalEnumRulesUiTestLanguage.g:307:1: ( ( rule__Model__GeneratedAssignment_0_2_1 ) )
            // InternalEnumRulesUiTestLanguage.g:308:2: ( rule__Model__GeneratedAssignment_0_2_1 )
            {
             before(grammarAccess.getModelAccess().getGeneratedAssignment_0_2_1()); 
            // InternalEnumRulesUiTestLanguage.g:309:2: ( rule__Model__GeneratedAssignment_0_2_1 )
            // InternalEnumRulesUiTestLanguage.g:309:3: rule__Model__GeneratedAssignment_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__GeneratedAssignment_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGeneratedAssignment_0_2_1()); 

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
    // $ANTLR end "rule__Model__Group_0_2__1__Impl"


    // $ANTLR start "rule__Model__Group_1__0"
    // InternalEnumRulesUiTestLanguage.g:318:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:322:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // InternalEnumRulesUiTestLanguage.g:323:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_1__1();

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
    // $ANTLR end "rule__Model__Group_1__0"


    // $ANTLR start "rule__Model__Group_1__0__Impl"
    // InternalEnumRulesUiTestLanguage.g:330:1: rule__Model__Group_1__0__Impl : ( 'generated' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:334:1: ( ( 'generated' ) )
            // InternalEnumRulesUiTestLanguage.g:335:1: ( 'generated' )
            {
            // InternalEnumRulesUiTestLanguage.g:335:1: ( 'generated' )
            // InternalEnumRulesUiTestLanguage.g:336:2: 'generated'
            {
             before(grammarAccess.getModelAccess().getGeneratedKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelAccess().getGeneratedKeyword_1_0()); 

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
    // $ANTLR end "rule__Model__Group_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1__1"
    // InternalEnumRulesUiTestLanguage.g:345:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:349:1: ( rule__Model__Group_1__1__Impl )
            // InternalEnumRulesUiTestLanguage.g:350:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_1__1__Impl();

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
    // $ANTLR end "rule__Model__Group_1__1"


    // $ANTLR start "rule__Model__Group_1__1__Impl"
    // InternalEnumRulesUiTestLanguage.g:356:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__GeneratedAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:360:1: ( ( ( rule__Model__GeneratedAssignment_1_1 ) ) )
            // InternalEnumRulesUiTestLanguage.g:361:1: ( ( rule__Model__GeneratedAssignment_1_1 ) )
            {
            // InternalEnumRulesUiTestLanguage.g:361:1: ( ( rule__Model__GeneratedAssignment_1_1 ) )
            // InternalEnumRulesUiTestLanguage.g:362:2: ( rule__Model__GeneratedAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getGeneratedAssignment_1_1()); 
            // InternalEnumRulesUiTestLanguage.g:363:2: ( rule__Model__GeneratedAssignment_1_1 )
            // InternalEnumRulesUiTestLanguage.g:363:3: rule__Model__GeneratedAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__GeneratedAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGeneratedAssignment_1_1()); 

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
    // $ANTLR end "rule__Model__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ExistingAssignment_0_1"
    // InternalEnumRulesUiTestLanguage.g:372:1: rule__Model__ExistingAssignment_0_1 : ( ruleExistingEnum ) ;
    public final void rule__Model__ExistingAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:376:1: ( ( ruleExistingEnum ) )
            // InternalEnumRulesUiTestLanguage.g:377:2: ( ruleExistingEnum )
            {
            // InternalEnumRulesUiTestLanguage.g:377:2: ( ruleExistingEnum )
            // InternalEnumRulesUiTestLanguage.g:378:3: ruleExistingEnum
            {
             before(grammarAccess.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleExistingEnum();

            state._fsp--;

             after(grammarAccess.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0()); 

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
    // $ANTLR end "rule__Model__ExistingAssignment_0_1"


    // $ANTLR start "rule__Model__GeneratedAssignment_0_2_1"
    // InternalEnumRulesUiTestLanguage.g:387:1: rule__Model__GeneratedAssignment_0_2_1 : ( ruleGeneratedEnum ) ;
    public final void rule__Model__GeneratedAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:391:1: ( ( ruleGeneratedEnum ) )
            // InternalEnumRulesUiTestLanguage.g:392:2: ( ruleGeneratedEnum )
            {
            // InternalEnumRulesUiTestLanguage.g:392:2: ( ruleGeneratedEnum )
            // InternalEnumRulesUiTestLanguage.g:393:3: ruleGeneratedEnum
            {
             before(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_0_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGeneratedEnum();

            state._fsp--;

             after(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_0_2_1_0()); 

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
    // $ANTLR end "rule__Model__GeneratedAssignment_0_2_1"


    // $ANTLR start "rule__Model__GeneratedAssignment_1_1"
    // InternalEnumRulesUiTestLanguage.g:402:1: rule__Model__GeneratedAssignment_1_1 : ( ruleGeneratedEnum ) ;
    public final void rule__Model__GeneratedAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:406:1: ( ( ruleGeneratedEnum ) )
            // InternalEnumRulesUiTestLanguage.g:407:2: ( ruleGeneratedEnum )
            {
            // InternalEnumRulesUiTestLanguage.g:407:2: ( ruleGeneratedEnum )
            // InternalEnumRulesUiTestLanguage.g:408:3: ruleGeneratedEnum
            {
             before(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGeneratedEnum();

            state._fsp--;

             after(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Model__GeneratedAssignment_1_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002800L});
    }


}
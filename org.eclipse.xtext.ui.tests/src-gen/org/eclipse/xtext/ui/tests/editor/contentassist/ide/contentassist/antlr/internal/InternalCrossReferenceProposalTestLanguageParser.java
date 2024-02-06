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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;



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
public class InternalCrossReferenceProposalTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'<-'", "'::'", "'Object'"
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


        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCrossReferenceProposalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCrossReferenceProposalTestLanguage.g"; }


    	private CrossReferenceProposalTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(CrossReferenceProposalTestLanguageGrammarAccess grammarAccess) {
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
    // InternalCrossReferenceProposalTestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalCrossReferenceProposalTestLanguage.g:59:1: ( ruleModel EOF )
            // InternalCrossReferenceProposalTestLanguage.g:60:1: ruleModel EOF
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
    // InternalCrossReferenceProposalTestLanguage.g:67:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:71:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalCrossReferenceProposalTestLanguage.g:72:2: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalCrossReferenceProposalTestLanguage.g:72:2: ( ( rule__Model__ElementsAssignment )* )
            // InternalCrossReferenceProposalTestLanguage.g:73:3: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalCrossReferenceProposalTestLanguage.g:74:3: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=14 && LA1_0<=15)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCrossReferenceProposalTestLanguage.g:74:4: rule__Model__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Model__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment()); 

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


    // $ANTLR start "entryRuleClass"
    // InternalCrossReferenceProposalTestLanguage.g:83:1: entryRuleClass : ruleClass EOF ;
    public final void entryRuleClass() throws RecognitionException {
        try {
            // InternalCrossReferenceProposalTestLanguage.g:84:1: ( ruleClass EOF )
            // InternalCrossReferenceProposalTestLanguage.g:85:1: ruleClass EOF
            {
             before(grammarAccess.getClassRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getClassRule()); 
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
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalCrossReferenceProposalTestLanguage.g:92:1: ruleClass : ( ( rule__Class__Group__0 ) ) ;
    public final void ruleClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:96:2: ( ( ( rule__Class__Group__0 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:97:2: ( ( rule__Class__Group__0 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:97:2: ( ( rule__Class__Group__0 ) )
            // InternalCrossReferenceProposalTestLanguage.g:98:3: ( rule__Class__Group__0 )
            {
             before(grammarAccess.getClassAccess().getGroup()); 
            // InternalCrossReferenceProposalTestLanguage.g:99:3: ( rule__Class__Group__0 )
            // InternalCrossReferenceProposalTestLanguage.g:99:4: rule__Class__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getGroup()); 

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
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleComplexName"
    // InternalCrossReferenceProposalTestLanguage.g:108:1: entryRuleComplexName : ruleComplexName EOF ;
    public final void entryRuleComplexName() throws RecognitionException {
        try {
            // InternalCrossReferenceProposalTestLanguage.g:109:1: ( ruleComplexName EOF )
            // InternalCrossReferenceProposalTestLanguage.g:110:1: ruleComplexName EOF
            {
             before(grammarAccess.getComplexNameRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleComplexName();

            state._fsp--;

             after(grammarAccess.getComplexNameRule()); 
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
    // $ANTLR end "entryRuleComplexName"


    // $ANTLR start "ruleComplexName"
    // InternalCrossReferenceProposalTestLanguage.g:117:1: ruleComplexName : ( ( rule__ComplexName__Group__0 ) ) ;
    public final void ruleComplexName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:121:2: ( ( ( rule__ComplexName__Group__0 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:122:2: ( ( rule__ComplexName__Group__0 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:122:2: ( ( rule__ComplexName__Group__0 ) )
            // InternalCrossReferenceProposalTestLanguage.g:123:3: ( rule__ComplexName__Group__0 )
            {
             before(grammarAccess.getComplexNameAccess().getGroup()); 
            // InternalCrossReferenceProposalTestLanguage.g:124:3: ( rule__ComplexName__Group__0 )
            // InternalCrossReferenceProposalTestLanguage.g:124:4: rule__ComplexName__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ComplexName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComplexNameAccess().getGroup()); 

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
    // $ANTLR end "ruleComplexName"


    // $ANTLR start "rule__Class__Alternatives_0_0"
    // InternalCrossReferenceProposalTestLanguage.g:132:1: rule__Class__Alternatives_0_0 : ( ( ( rule__Class__SuperClassAssignment_0_0_0 ) ) | ( ( rule__Class__SuperClassAssignment_0_0_1 ) ) | ( ( rule__Class__SuperClassAssignment_0_0_2 ) ) );
    public final void rule__Class__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:136:1: ( ( ( rule__Class__SuperClassAssignment_0_0_0 ) ) | ( ( rule__Class__SuperClassAssignment_0_0_1 ) ) | ( ( rule__Class__SuperClassAssignment_0_0_2 ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                alt2=2;
                }
                break;
            case 14:
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
                    // InternalCrossReferenceProposalTestLanguage.g:137:2: ( ( rule__Class__SuperClassAssignment_0_0_0 ) )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:137:2: ( ( rule__Class__SuperClassAssignment_0_0_0 ) )
                    // InternalCrossReferenceProposalTestLanguage.g:138:3: ( rule__Class__SuperClassAssignment_0_0_0 )
                    {
                     before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_0()); 
                    // InternalCrossReferenceProposalTestLanguage.g:139:3: ( rule__Class__SuperClassAssignment_0_0_0 )
                    // InternalCrossReferenceProposalTestLanguage.g:139:4: rule__Class__SuperClassAssignment_0_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__SuperClassAssignment_0_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCrossReferenceProposalTestLanguage.g:143:2: ( ( rule__Class__SuperClassAssignment_0_0_1 ) )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:143:2: ( ( rule__Class__SuperClassAssignment_0_0_1 ) )
                    // InternalCrossReferenceProposalTestLanguage.g:144:3: ( rule__Class__SuperClassAssignment_0_0_1 )
                    {
                     before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_1()); 
                    // InternalCrossReferenceProposalTestLanguage.g:145:3: ( rule__Class__SuperClassAssignment_0_0_1 )
                    // InternalCrossReferenceProposalTestLanguage.g:145:4: rule__Class__SuperClassAssignment_0_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__SuperClassAssignment_0_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalCrossReferenceProposalTestLanguage.g:149:2: ( ( rule__Class__SuperClassAssignment_0_0_2 ) )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:149:2: ( ( rule__Class__SuperClassAssignment_0_0_2 ) )
                    // InternalCrossReferenceProposalTestLanguage.g:150:3: ( rule__Class__SuperClassAssignment_0_0_2 )
                    {
                     before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_2()); 
                    // InternalCrossReferenceProposalTestLanguage.g:151:3: ( rule__Class__SuperClassAssignment_0_0_2 )
                    // InternalCrossReferenceProposalTestLanguage.g:151:4: rule__Class__SuperClassAssignment_0_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__SuperClassAssignment_0_0_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_2()); 

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
    // $ANTLR end "rule__Class__Alternatives_0_0"


    // $ANTLR start "rule__Class__NameAlternatives_1_0"
    // InternalCrossReferenceProposalTestLanguage.g:159:1: rule__Class__NameAlternatives_1_0 : ( ( RULE_ID ) | ( ruleComplexName ) );
    public final void rule__Class__NameAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:163:1: ( ( RULE_ID ) | ( ruleComplexName ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalCrossReferenceProposalTestLanguage.g:164:2: ( RULE_ID )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:164:2: ( RULE_ID )
                    // InternalCrossReferenceProposalTestLanguage.g:165:3: RULE_ID
                    {
                     before(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0_0()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCrossReferenceProposalTestLanguage.g:170:2: ( ruleComplexName )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:170:2: ( ruleComplexName )
                    // InternalCrossReferenceProposalTestLanguage.g:171:3: ruleComplexName
                    {
                     before(grammarAccess.getClassAccess().getNameComplexNameParserRuleCall_1_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleComplexName();

                    state._fsp--;

                     after(grammarAccess.getClassAccess().getNameComplexNameParserRuleCall_1_0_1()); 

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
    // $ANTLR end "rule__Class__NameAlternatives_1_0"


    // $ANTLR start "rule__Class__Group__0"
    // InternalCrossReferenceProposalTestLanguage.g:180:1: rule__Class__Group__0 : rule__Class__Group__0__Impl rule__Class__Group__1 ;
    public final void rule__Class__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:184:1: ( rule__Class__Group__0__Impl rule__Class__Group__1 )
            // InternalCrossReferenceProposalTestLanguage.g:185:2: rule__Class__Group__0__Impl rule__Class__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Class__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__1();

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
    // $ANTLR end "rule__Class__Group__0"


    // $ANTLR start "rule__Class__Group__0__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:192:1: rule__Class__Group__0__Impl : ( ( rule__Class__Group_0__0 )? ) ;
    public final void rule__Class__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:196:1: ( ( ( rule__Class__Group_0__0 )? ) )
            // InternalCrossReferenceProposalTestLanguage.g:197:1: ( ( rule__Class__Group_0__0 )? )
            {
            // InternalCrossReferenceProposalTestLanguage.g:197:1: ( ( rule__Class__Group_0__0 )? )
            // InternalCrossReferenceProposalTestLanguage.g:198:2: ( rule__Class__Group_0__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:199:2: ( rule__Class__Group_0__0 )?
            int alt4=2;
            switch ( input.LA(1) ) {
                case 15:
                    {
                    alt4=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==13) ) {
                        alt4=1;
                    }
                    }
                    break;
                case 14:
                    {
                    int LA4_3 = input.LA(2);

                    if ( (LA4_3==RULE_ID) ) {
                        int LA4_5 = input.LA(3);

                        if ( (LA4_5==13) ) {
                            alt4=1;
                        }
                    }
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // InternalCrossReferenceProposalTestLanguage.g:199:3: rule__Class__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_0()); 

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
    // $ANTLR end "rule__Class__Group__0__Impl"


    // $ANTLR start "rule__Class__Group__1"
    // InternalCrossReferenceProposalTestLanguage.g:207:1: rule__Class__Group__1 : rule__Class__Group__1__Impl rule__Class__Group__2 ;
    public final void rule__Class__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:211:1: ( rule__Class__Group__1__Impl rule__Class__Group__2 )
            // InternalCrossReferenceProposalTestLanguage.g:212:2: rule__Class__Group__1__Impl rule__Class__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Class__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__2();

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
    // $ANTLR end "rule__Class__Group__1"


    // $ANTLR start "rule__Class__Group__1__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:219:1: rule__Class__Group__1__Impl : ( ( rule__Class__NameAssignment_1 ) ) ;
    public final void rule__Class__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:223:1: ( ( ( rule__Class__NameAssignment_1 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:224:1: ( ( rule__Class__NameAssignment_1 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:224:1: ( ( rule__Class__NameAssignment_1 ) )
            // InternalCrossReferenceProposalTestLanguage.g:225:2: ( rule__Class__NameAssignment_1 )
            {
             before(grammarAccess.getClassAccess().getNameAssignment_1()); 
            // InternalCrossReferenceProposalTestLanguage.g:226:2: ( rule__Class__NameAssignment_1 )
            // InternalCrossReferenceProposalTestLanguage.g:226:3: rule__Class__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Class__Group__1__Impl"


    // $ANTLR start "rule__Class__Group__2"
    // InternalCrossReferenceProposalTestLanguage.g:234:1: rule__Class__Group__2 : rule__Class__Group__2__Impl rule__Class__Group__3 ;
    public final void rule__Class__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:238:1: ( rule__Class__Group__2__Impl rule__Class__Group__3 )
            // InternalCrossReferenceProposalTestLanguage.g:239:2: rule__Class__Group__2__Impl rule__Class__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Class__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__3();

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
    // $ANTLR end "rule__Class__Group__2"


    // $ANTLR start "rule__Class__Group__2__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:246:1: rule__Class__Group__2__Impl : ( '{' ) ;
    public final void rule__Class__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:250:1: ( ( '{' ) )
            // InternalCrossReferenceProposalTestLanguage.g:251:1: ( '{' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:251:1: ( '{' )
            // InternalCrossReferenceProposalTestLanguage.g:252:2: '{'
            {
             before(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2()); 

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
    // $ANTLR end "rule__Class__Group__2__Impl"


    // $ANTLR start "rule__Class__Group__3"
    // InternalCrossReferenceProposalTestLanguage.g:261:1: rule__Class__Group__3 : rule__Class__Group__3__Impl ;
    public final void rule__Class__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:265:1: ( rule__Class__Group__3__Impl )
            // InternalCrossReferenceProposalTestLanguage.g:266:2: rule__Class__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__3__Impl();

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
    // $ANTLR end "rule__Class__Group__3"


    // $ANTLR start "rule__Class__Group__3__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:272:1: rule__Class__Group__3__Impl : ( '}' ) ;
    public final void rule__Class__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:276:1: ( ( '}' ) )
            // InternalCrossReferenceProposalTestLanguage.g:277:1: ( '}' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:277:1: ( '}' )
            // InternalCrossReferenceProposalTestLanguage.g:278:2: '}'
            {
             before(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3()); 

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
    // $ANTLR end "rule__Class__Group__3__Impl"


    // $ANTLR start "rule__Class__Group_0__0"
    // InternalCrossReferenceProposalTestLanguage.g:288:1: rule__Class__Group_0__0 : rule__Class__Group_0__0__Impl rule__Class__Group_0__1 ;
    public final void rule__Class__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:292:1: ( rule__Class__Group_0__0__Impl rule__Class__Group_0__1 )
            // InternalCrossReferenceProposalTestLanguage.g:293:2: rule__Class__Group_0__0__Impl rule__Class__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Class__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_0__1();

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
    // $ANTLR end "rule__Class__Group_0__0"


    // $ANTLR start "rule__Class__Group_0__0__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:300:1: rule__Class__Group_0__0__Impl : ( ( rule__Class__Alternatives_0_0 ) ) ;
    public final void rule__Class__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:304:1: ( ( ( rule__Class__Alternatives_0_0 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:305:1: ( ( rule__Class__Alternatives_0_0 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:305:1: ( ( rule__Class__Alternatives_0_0 ) )
            // InternalCrossReferenceProposalTestLanguage.g:306:2: ( rule__Class__Alternatives_0_0 )
            {
             before(grammarAccess.getClassAccess().getAlternatives_0_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:307:2: ( rule__Class__Alternatives_0_0 )
            // InternalCrossReferenceProposalTestLanguage.g:307:3: rule__Class__Alternatives_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Alternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getAlternatives_0_0()); 

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
    // $ANTLR end "rule__Class__Group_0__0__Impl"


    // $ANTLR start "rule__Class__Group_0__1"
    // InternalCrossReferenceProposalTestLanguage.g:315:1: rule__Class__Group_0__1 : rule__Class__Group_0__1__Impl ;
    public final void rule__Class__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:319:1: ( rule__Class__Group_0__1__Impl )
            // InternalCrossReferenceProposalTestLanguage.g:320:2: rule__Class__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_0__1__Impl();

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
    // $ANTLR end "rule__Class__Group_0__1"


    // $ANTLR start "rule__Class__Group_0__1__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:326:1: rule__Class__Group_0__1__Impl : ( '<-' ) ;
    public final void rule__Class__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:330:1: ( ( '<-' ) )
            // InternalCrossReferenceProposalTestLanguage.g:331:1: ( '<-' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:331:1: ( '<-' )
            // InternalCrossReferenceProposalTestLanguage.g:332:2: '<-'
            {
             before(grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1()); 

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
    // $ANTLR end "rule__Class__Group_0__1__Impl"


    // $ANTLR start "rule__ComplexName__Group__0"
    // InternalCrossReferenceProposalTestLanguage.g:342:1: rule__ComplexName__Group__0 : rule__ComplexName__Group__0__Impl rule__ComplexName__Group__1 ;
    public final void rule__ComplexName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:346:1: ( rule__ComplexName__Group__0__Impl rule__ComplexName__Group__1 )
            // InternalCrossReferenceProposalTestLanguage.g:347:2: rule__ComplexName__Group__0__Impl rule__ComplexName__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__ComplexName__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ComplexName__Group__1();

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
    // $ANTLR end "rule__ComplexName__Group__0"


    // $ANTLR start "rule__ComplexName__Group__0__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:354:1: rule__ComplexName__Group__0__Impl : ( '::' ) ;
    public final void rule__ComplexName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:358:1: ( ( '::' ) )
            // InternalCrossReferenceProposalTestLanguage.g:359:1: ( '::' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:359:1: ( '::' )
            // InternalCrossReferenceProposalTestLanguage.g:360:2: '::'
            {
             before(grammarAccess.getComplexNameAccess().getColonColonKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getComplexNameAccess().getColonColonKeyword_0()); 

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
    // $ANTLR end "rule__ComplexName__Group__0__Impl"


    // $ANTLR start "rule__ComplexName__Group__1"
    // InternalCrossReferenceProposalTestLanguage.g:369:1: rule__ComplexName__Group__1 : rule__ComplexName__Group__1__Impl ;
    public final void rule__ComplexName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:373:1: ( rule__ComplexName__Group__1__Impl )
            // InternalCrossReferenceProposalTestLanguage.g:374:2: rule__ComplexName__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ComplexName__Group__1__Impl();

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
    // $ANTLR end "rule__ComplexName__Group__1"


    // $ANTLR start "rule__ComplexName__Group__1__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:380:1: rule__ComplexName__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__ComplexName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:384:1: ( ( RULE_ID ) )
            // InternalCrossReferenceProposalTestLanguage.g:385:1: ( RULE_ID )
            {
            // InternalCrossReferenceProposalTestLanguage.g:385:1: ( RULE_ID )
            // InternalCrossReferenceProposalTestLanguage.g:386:2: RULE_ID
            {
             before(grammarAccess.getComplexNameAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getComplexNameAccess().getIDTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__ComplexName__Group__1__Impl"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalCrossReferenceProposalTestLanguage.g:396:1: rule__Model__ElementsAssignment : ( ruleClass ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:400:1: ( ( ruleClass ) )
            // InternalCrossReferenceProposalTestLanguage.g:401:2: ( ruleClass )
            {
            // InternalCrossReferenceProposalTestLanguage.g:401:2: ( ruleClass )
            // InternalCrossReferenceProposalTestLanguage.g:402:3: ruleClass
            {
             before(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__ElementsAssignment"


    // $ANTLR start "rule__Class__SuperClassAssignment_0_0_0"
    // InternalCrossReferenceProposalTestLanguage.g:411:1: rule__Class__SuperClassAssignment_0_0_0 : ( ( 'Object' ) ) ;
    public final void rule__Class__SuperClassAssignment_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:415:1: ( ( ( 'Object' ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:416:2: ( ( 'Object' ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:416:2: ( ( 'Object' ) )
            // InternalCrossReferenceProposalTestLanguage.g:417:3: ( 'Object' )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:418:3: ( 'Object' )
            // InternalCrossReferenceProposalTestLanguage.g:419:4: 'Object'
            {
             before(grammarAccess.getClassAccess().getSuperClassClassObjectKeyword_0_0_0_0_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getSuperClassClassObjectKeyword_0_0_0_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0_0()); 

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
    // $ANTLR end "rule__Class__SuperClassAssignment_0_0_0"


    // $ANTLR start "rule__Class__SuperClassAssignment_0_0_1"
    // InternalCrossReferenceProposalTestLanguage.g:430:1: rule__Class__SuperClassAssignment_0_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Class__SuperClassAssignment_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:434:1: ( ( ( RULE_ID ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:435:2: ( ( RULE_ID ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:435:2: ( ( RULE_ID ) )
            // InternalCrossReferenceProposalTestLanguage.g:436:3: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_1_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:437:3: ( RULE_ID )
            // InternalCrossReferenceProposalTestLanguage.g:438:4: RULE_ID
            {
             before(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_0_0_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_0_0_1_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_1_0()); 

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
    // $ANTLR end "rule__Class__SuperClassAssignment_0_0_1"


    // $ANTLR start "rule__Class__SuperClassAssignment_0_0_2"
    // InternalCrossReferenceProposalTestLanguage.g:449:1: rule__Class__SuperClassAssignment_0_0_2 : ( ( ruleComplexName ) ) ;
    public final void rule__Class__SuperClassAssignment_0_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:453:1: ( ( ( ruleComplexName ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:454:2: ( ( ruleComplexName ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:454:2: ( ( ruleComplexName ) )
            // InternalCrossReferenceProposalTestLanguage.g:455:3: ( ruleComplexName )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_2_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:456:3: ( ruleComplexName )
            // InternalCrossReferenceProposalTestLanguage.g:457:4: ruleComplexName
            {
             before(grammarAccess.getClassAccess().getSuperClassClassComplexNameParserRuleCall_0_0_2_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleComplexName();

            state._fsp--;

             after(grammarAccess.getClassAccess().getSuperClassClassComplexNameParserRuleCall_0_0_2_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_2_0()); 

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
    // $ANTLR end "rule__Class__SuperClassAssignment_0_0_2"


    // $ANTLR start "rule__Class__NameAssignment_1"
    // InternalCrossReferenceProposalTestLanguage.g:468:1: rule__Class__NameAssignment_1 : ( ( rule__Class__NameAlternatives_1_0 ) ) ;
    public final void rule__Class__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:472:1: ( ( ( rule__Class__NameAlternatives_1_0 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:473:2: ( ( rule__Class__NameAlternatives_1_0 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:473:2: ( ( rule__Class__NameAlternatives_1_0 ) )
            // InternalCrossReferenceProposalTestLanguage.g:474:3: ( rule__Class__NameAlternatives_1_0 )
            {
             before(grammarAccess.getClassAccess().getNameAlternatives_1_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:475:3: ( rule__Class__NameAlternatives_1_0 )
            // InternalCrossReferenceProposalTestLanguage.g:475:4: rule__Class__NameAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__NameAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getNameAlternatives_1_0()); 

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
    // $ANTLR end "rule__Class__NameAssignment_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000C012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000C010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    }


}
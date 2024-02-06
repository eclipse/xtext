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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.GH341TestLanguageGrammarAccess;



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
public class InternalGH341TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'stream'", "'define'", "'works'", "';'", "'.'", "'X'", "'broken'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalGH341TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGH341TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGH341TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGH341TestLanguage.g"; }


    	private GH341TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(GH341TestLanguageGrammarAccess grammarAccess) {
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
    // InternalGH341TestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalGH341TestLanguage.g:59:1: ( ruleModel EOF )
            // InternalGH341TestLanguage.g:60:1: ruleModel EOF
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
    // InternalGH341TestLanguage.g:67:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:71:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalGH341TestLanguage.g:72:2: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalGH341TestLanguage.g:72:2: ( ( rule__Model__ElementsAssignment )* )
            // InternalGH341TestLanguage.g:73:3: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalGH341TestLanguage.g:74:3: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)||LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:74:4: rule__Model__ElementsAssignment
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


    // $ANTLR start "entryRuleWorks"
    // InternalGH341TestLanguage.g:83:1: entryRuleWorks : ruleWorks EOF ;
    public final void entryRuleWorks() throws RecognitionException {
        try {
            // InternalGH341TestLanguage.g:84:1: ( ruleWorks EOF )
            // InternalGH341TestLanguage.g:85:1: ruleWorks EOF
            {
             before(grammarAccess.getWorksRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWorks();

            state._fsp--;

             after(grammarAccess.getWorksRule()); 
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
    // $ANTLR end "entryRuleWorks"


    // $ANTLR start "ruleWorks"
    // InternalGH341TestLanguage.g:92:1: ruleWorks : ( ( rule__Works__Group__0 ) ) ;
    public final void ruleWorks() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:96:2: ( ( ( rule__Works__Group__0 ) ) )
            // InternalGH341TestLanguage.g:97:2: ( ( rule__Works__Group__0 ) )
            {
            // InternalGH341TestLanguage.g:97:2: ( ( rule__Works__Group__0 ) )
            // InternalGH341TestLanguage.g:98:3: ( rule__Works__Group__0 )
            {
             before(grammarAccess.getWorksAccess().getGroup()); 
            // InternalGH341TestLanguage.g:99:3: ( rule__Works__Group__0 )
            // InternalGH341TestLanguage.g:99:4: rule__Works__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getGroup()); 

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
    // $ANTLR end "ruleWorks"


    // $ANTLR start "entryRuleBroken"
    // InternalGH341TestLanguage.g:108:1: entryRuleBroken : ruleBroken EOF ;
    public final void entryRuleBroken() throws RecognitionException {
        try {
            // InternalGH341TestLanguage.g:109:1: ( ruleBroken EOF )
            // InternalGH341TestLanguage.g:110:1: ruleBroken EOF
            {
             before(grammarAccess.getBrokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBroken();

            state._fsp--;

             after(grammarAccess.getBrokenRule()); 
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
    // $ANTLR end "entryRuleBroken"


    // $ANTLR start "ruleBroken"
    // InternalGH341TestLanguage.g:117:1: ruleBroken : ( ( rule__Broken__Group__0 ) ) ;
    public final void ruleBroken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:121:2: ( ( ( rule__Broken__Group__0 ) ) )
            // InternalGH341TestLanguage.g:122:2: ( ( rule__Broken__Group__0 ) )
            {
            // InternalGH341TestLanguage.g:122:2: ( ( rule__Broken__Group__0 ) )
            // InternalGH341TestLanguage.g:123:3: ( rule__Broken__Group__0 )
            {
             before(grammarAccess.getBrokenAccess().getGroup()); 
            // InternalGH341TestLanguage.g:124:3: ( rule__Broken__Group__0 )
            // InternalGH341TestLanguage.g:124:4: rule__Broken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBrokenAccess().getGroup()); 

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
    // $ANTLR end "ruleBroken"


    // $ANTLR start "entryRuleThird"
    // InternalGH341TestLanguage.g:133:1: entryRuleThird : ruleThird EOF ;
    public final void entryRuleThird() throws RecognitionException {
        try {
            // InternalGH341TestLanguage.g:134:1: ( ruleThird EOF )
            // InternalGH341TestLanguage.g:135:1: ruleThird EOF
            {
             before(grammarAccess.getThirdRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleThird();

            state._fsp--;

             after(grammarAccess.getThirdRule()); 
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
    // $ANTLR end "entryRuleThird"


    // $ANTLR start "ruleThird"
    // InternalGH341TestLanguage.g:142:1: ruleThird : ( ( rule__Third__Group__0 ) ) ;
    public final void ruleThird() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:146:2: ( ( ( rule__Third__Group__0 ) ) )
            // InternalGH341TestLanguage.g:147:2: ( ( rule__Third__Group__0 ) )
            {
            // InternalGH341TestLanguage.g:147:2: ( ( rule__Third__Group__0 ) )
            // InternalGH341TestLanguage.g:148:3: ( rule__Third__Group__0 )
            {
             before(grammarAccess.getThirdAccess().getGroup()); 
            // InternalGH341TestLanguage.g:149:3: ( rule__Third__Group__0 )
            // InternalGH341TestLanguage.g:149:4: rule__Third__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Third__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThirdAccess().getGroup()); 

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
    // $ANTLR end "ruleThird"


    // $ANTLR start "ruleSTREAM"
    // InternalGH341TestLanguage.g:159:1: ruleSTREAM : ( 'stream' ) ;
    public final void ruleSTREAM() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:163:2: ( ( 'stream' ) )
            // InternalGH341TestLanguage.g:164:2: ( 'stream' )
            {
            // InternalGH341TestLanguage.g:164:2: ( 'stream' )
            // InternalGH341TestLanguage.g:165:3: 'stream'
            {
             before(grammarAccess.getSTREAMAccess().getStreamKeyword()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSTREAMAccess().getStreamKeyword()); 

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
    // $ANTLR end "ruleSTREAM"


    // $ANTLR start "ruleDEFINE"
    // InternalGH341TestLanguage.g:176:1: ruleDEFINE : ( 'define' ) ;
    public final void ruleDEFINE() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:180:2: ( ( 'define' ) )
            // InternalGH341TestLanguage.g:181:2: ( 'define' )
            {
            // InternalGH341TestLanguage.g:181:2: ( 'define' )
            // InternalGH341TestLanguage.g:182:3: 'define'
            {
             before(grammarAccess.getDEFINEAccess().getDefineKeyword()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getDEFINEAccess().getDefineKeyword()); 

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
    // $ANTLR end "ruleDEFINE"


    // $ANTLR start "ruleFragment"
    // InternalGH341TestLanguage.g:193:1: ruleFragment : ( ( rule__Fragment__Group__0 )* ) ;
    public final void ruleFragment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:197:2: ( ( ( rule__Fragment__Group__0 )* ) )
            // InternalGH341TestLanguage.g:198:2: ( ( rule__Fragment__Group__0 )* )
            {
            // InternalGH341TestLanguage.g:198:2: ( ( rule__Fragment__Group__0 )* )
            // InternalGH341TestLanguage.g:199:3: ( rule__Fragment__Group__0 )*
            {
             before(grammarAccess.getFragmentAccess().getGroup()); 
            // InternalGH341TestLanguage.g:200:3: ( rule__Fragment__Group__0 )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:200:4: rule__Fragment__Group__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Fragment__Group__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getFragmentAccess().getGroup()); 

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
    // $ANTLR end "ruleFragment"


    // $ANTLR start "rule__Model__ElementsAlternatives_0"
    // InternalGH341TestLanguage.g:208:1: rule__Model__ElementsAlternatives_0 : ( ( ruleWorks ) | ( ruleBroken ) | ( ruleThird ) );
    public final void rule__Model__ElementsAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:212:1: ( ( ruleWorks ) | ( ruleBroken ) | ( ruleThird ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 17:
                {
                alt3=2;
                }
                break;
            case 12:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalGH341TestLanguage.g:213:2: ( ruleWorks )
                    {
                    // InternalGH341TestLanguage.g:213:2: ( ruleWorks )
                    // InternalGH341TestLanguage.g:214:3: ruleWorks
                    {
                     before(grammarAccess.getModelAccess().getElementsWorksParserRuleCall_0_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWorks();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsWorksParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGH341TestLanguage.g:219:2: ( ruleBroken )
                    {
                    // InternalGH341TestLanguage.g:219:2: ( ruleBroken )
                    // InternalGH341TestLanguage.g:220:3: ruleBroken
                    {
                     before(grammarAccess.getModelAccess().getElementsBrokenParserRuleCall_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleBroken();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsBrokenParserRuleCall_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGH341TestLanguage.g:225:2: ( ruleThird )
                    {
                    // InternalGH341TestLanguage.g:225:2: ( ruleThird )
                    // InternalGH341TestLanguage.g:226:3: ruleThird
                    {
                     before(grammarAccess.getModelAccess().getElementsThirdParserRuleCall_0_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleThird();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsThirdParserRuleCall_0_2()); 

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
    // $ANTLR end "rule__Model__ElementsAlternatives_0"


    // $ANTLR start "rule__Works__Group__0"
    // InternalGH341TestLanguage.g:235:1: rule__Works__Group__0 : rule__Works__Group__0__Impl rule__Works__Group__1 ;
    public final void rule__Works__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:239:1: ( rule__Works__Group__0__Impl rule__Works__Group__1 )
            // InternalGH341TestLanguage.g:240:2: rule__Works__Group__0__Impl rule__Works__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Works__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group__1();

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
    // $ANTLR end "rule__Works__Group__0"


    // $ANTLR start "rule__Works__Group__0__Impl"
    // InternalGH341TestLanguage.g:247:1: rule__Works__Group__0__Impl : ( 'works' ) ;
    public final void rule__Works__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:251:1: ( ( 'works' ) )
            // InternalGH341TestLanguage.g:252:1: ( 'works' )
            {
            // InternalGH341TestLanguage.g:252:1: ( 'works' )
            // InternalGH341TestLanguage.g:253:2: 'works'
            {
             before(grammarAccess.getWorksAccess().getWorksKeyword_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getWorksKeyword_0()); 

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
    // $ANTLR end "rule__Works__Group__0__Impl"


    // $ANTLR start "rule__Works__Group__1"
    // InternalGH341TestLanguage.g:262:1: rule__Works__Group__1 : rule__Works__Group__1__Impl rule__Works__Group__2 ;
    public final void rule__Works__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:266:1: ( rule__Works__Group__1__Impl rule__Works__Group__2 )
            // InternalGH341TestLanguage.g:267:2: rule__Works__Group__1__Impl rule__Works__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Works__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group__2();

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
    // $ANTLR end "rule__Works__Group__1"


    // $ANTLR start "rule__Works__Group__1__Impl"
    // InternalGH341TestLanguage.g:274:1: rule__Works__Group__1__Impl : ( ( rule__Works__NameAssignment_1 ) ) ;
    public final void rule__Works__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:278:1: ( ( ( rule__Works__NameAssignment_1 ) ) )
            // InternalGH341TestLanguage.g:279:1: ( ( rule__Works__NameAssignment_1 ) )
            {
            // InternalGH341TestLanguage.g:279:1: ( ( rule__Works__NameAssignment_1 ) )
            // InternalGH341TestLanguage.g:280:2: ( rule__Works__NameAssignment_1 )
            {
             before(grammarAccess.getWorksAccess().getNameAssignment_1()); 
            // InternalGH341TestLanguage.g:281:2: ( rule__Works__NameAssignment_1 )
            // InternalGH341TestLanguage.g:281:3: rule__Works__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Works__Group__1__Impl"


    // $ANTLR start "rule__Works__Group__2"
    // InternalGH341TestLanguage.g:289:1: rule__Works__Group__2 : rule__Works__Group__2__Impl rule__Works__Group__3 ;
    public final void rule__Works__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:293:1: ( rule__Works__Group__2__Impl rule__Works__Group__3 )
            // InternalGH341TestLanguage.g:294:2: rule__Works__Group__2__Impl rule__Works__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Works__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group__3();

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
    // $ANTLR end "rule__Works__Group__2"


    // $ANTLR start "rule__Works__Group__2__Impl"
    // InternalGH341TestLanguage.g:301:1: rule__Works__Group__2__Impl : ( ( rule__Works__Group_2__0 )* ) ;
    public final void rule__Works__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:305:1: ( ( ( rule__Works__Group_2__0 )* ) )
            // InternalGH341TestLanguage.g:306:1: ( ( rule__Works__Group_2__0 )* )
            {
            // InternalGH341TestLanguage.g:306:1: ( ( rule__Works__Group_2__0 )* )
            // InternalGH341TestLanguage.g:307:2: ( rule__Works__Group_2__0 )*
            {
             before(grammarAccess.getWorksAccess().getGroup_2()); 
            // InternalGH341TestLanguage.g:308:2: ( rule__Works__Group_2__0 )*
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:308:3: rule__Works__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Works__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getWorksAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Works__Group__2__Impl"


    // $ANTLR start "rule__Works__Group__3"
    // InternalGH341TestLanguage.g:316:1: rule__Works__Group__3 : rule__Works__Group__3__Impl ;
    public final void rule__Works__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:320:1: ( rule__Works__Group__3__Impl )
            // InternalGH341TestLanguage.g:321:2: rule__Works__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group__3__Impl();

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
    // $ANTLR end "rule__Works__Group__3"


    // $ANTLR start "rule__Works__Group__3__Impl"
    // InternalGH341TestLanguage.g:327:1: rule__Works__Group__3__Impl : ( ( rule__Works__Group_3__0 )* ) ;
    public final void rule__Works__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:331:1: ( ( ( rule__Works__Group_3__0 )* ) )
            // InternalGH341TestLanguage.g:332:1: ( ( rule__Works__Group_3__0 )* )
            {
            // InternalGH341TestLanguage.g:332:1: ( ( rule__Works__Group_3__0 )* )
            // InternalGH341TestLanguage.g:333:2: ( rule__Works__Group_3__0 )*
            {
             before(grammarAccess.getWorksAccess().getGroup_3()); 
            // InternalGH341TestLanguage.g:334:2: ( rule__Works__Group_3__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:334:3: rule__Works__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Works__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getWorksAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Works__Group__3__Impl"


    // $ANTLR start "rule__Works__Group_2__0"
    // InternalGH341TestLanguage.g:343:1: rule__Works__Group_2__0 : rule__Works__Group_2__0__Impl rule__Works__Group_2__1 ;
    public final void rule__Works__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:347:1: ( rule__Works__Group_2__0__Impl rule__Works__Group_2__1 )
            // InternalGH341TestLanguage.g:348:2: rule__Works__Group_2__0__Impl rule__Works__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Works__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_2__1();

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
    // $ANTLR end "rule__Works__Group_2__0"


    // $ANTLR start "rule__Works__Group_2__0__Impl"
    // InternalGH341TestLanguage.g:355:1: rule__Works__Group_2__0__Impl : ( ( rule__Works__IdsAssignment_2_0 ) ) ;
    public final void rule__Works__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:359:1: ( ( ( rule__Works__IdsAssignment_2_0 ) ) )
            // InternalGH341TestLanguage.g:360:1: ( ( rule__Works__IdsAssignment_2_0 ) )
            {
            // InternalGH341TestLanguage.g:360:1: ( ( rule__Works__IdsAssignment_2_0 ) )
            // InternalGH341TestLanguage.g:361:2: ( rule__Works__IdsAssignment_2_0 )
            {
             before(grammarAccess.getWorksAccess().getIdsAssignment_2_0()); 
            // InternalGH341TestLanguage.g:362:2: ( rule__Works__IdsAssignment_2_0 )
            // InternalGH341TestLanguage.g:362:3: rule__Works__IdsAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__IdsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getIdsAssignment_2_0()); 

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
    // $ANTLR end "rule__Works__Group_2__0__Impl"


    // $ANTLR start "rule__Works__Group_2__1"
    // InternalGH341TestLanguage.g:370:1: rule__Works__Group_2__1 : rule__Works__Group_2__1__Impl rule__Works__Group_2__2 ;
    public final void rule__Works__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:374:1: ( rule__Works__Group_2__1__Impl rule__Works__Group_2__2 )
            // InternalGH341TestLanguage.g:375:2: rule__Works__Group_2__1__Impl rule__Works__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Works__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_2__2();

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
    // $ANTLR end "rule__Works__Group_2__1"


    // $ANTLR start "rule__Works__Group_2__1__Impl"
    // InternalGH341TestLanguage.g:382:1: rule__Works__Group_2__1__Impl : ( ( rule__Works__Group_2_1__0 )* ) ;
    public final void rule__Works__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:386:1: ( ( ( rule__Works__Group_2_1__0 )* ) )
            // InternalGH341TestLanguage.g:387:1: ( ( rule__Works__Group_2_1__0 )* )
            {
            // InternalGH341TestLanguage.g:387:1: ( ( rule__Works__Group_2_1__0 )* )
            // InternalGH341TestLanguage.g:388:2: ( rule__Works__Group_2_1__0 )*
            {
             before(grammarAccess.getWorksAccess().getGroup_2_1()); 
            // InternalGH341TestLanguage.g:389:2: ( rule__Works__Group_2_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:389:3: rule__Works__Group_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Works__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getWorksAccess().getGroup_2_1()); 

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
    // $ANTLR end "rule__Works__Group_2__1__Impl"


    // $ANTLR start "rule__Works__Group_2__2"
    // InternalGH341TestLanguage.g:397:1: rule__Works__Group_2__2 : rule__Works__Group_2__2__Impl ;
    public final void rule__Works__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:401:1: ( rule__Works__Group_2__2__Impl )
            // InternalGH341TestLanguage.g:402:2: rule__Works__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_2__2__Impl();

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
    // $ANTLR end "rule__Works__Group_2__2"


    // $ANTLR start "rule__Works__Group_2__2__Impl"
    // InternalGH341TestLanguage.g:408:1: rule__Works__Group_2__2__Impl : ( ';' ) ;
    public final void rule__Works__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:412:1: ( ( ';' ) )
            // InternalGH341TestLanguage.g:413:1: ( ';' )
            {
            // InternalGH341TestLanguage.g:413:1: ( ';' )
            // InternalGH341TestLanguage.g:414:2: ';'
            {
             before(grammarAccess.getWorksAccess().getSemicolonKeyword_2_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getSemicolonKeyword_2_2()); 

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
    // $ANTLR end "rule__Works__Group_2__2__Impl"


    // $ANTLR start "rule__Works__Group_2_1__0"
    // InternalGH341TestLanguage.g:424:1: rule__Works__Group_2_1__0 : rule__Works__Group_2_1__0__Impl rule__Works__Group_2_1__1 ;
    public final void rule__Works__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:428:1: ( rule__Works__Group_2_1__0__Impl rule__Works__Group_2_1__1 )
            // InternalGH341TestLanguage.g:429:2: rule__Works__Group_2_1__0__Impl rule__Works__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Works__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_2_1__1();

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
    // $ANTLR end "rule__Works__Group_2_1__0"


    // $ANTLR start "rule__Works__Group_2_1__0__Impl"
    // InternalGH341TestLanguage.g:436:1: rule__Works__Group_2_1__0__Impl : ( '.' ) ;
    public final void rule__Works__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:440:1: ( ( '.' ) )
            // InternalGH341TestLanguage.g:441:1: ( '.' )
            {
            // InternalGH341TestLanguage.g:441:1: ( '.' )
            // InternalGH341TestLanguage.g:442:2: '.'
            {
             before(grammarAccess.getWorksAccess().getFullStopKeyword_2_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getFullStopKeyword_2_1_0()); 

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
    // $ANTLR end "rule__Works__Group_2_1__0__Impl"


    // $ANTLR start "rule__Works__Group_2_1__1"
    // InternalGH341TestLanguage.g:451:1: rule__Works__Group_2_1__1 : rule__Works__Group_2_1__1__Impl ;
    public final void rule__Works__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:455:1: ( rule__Works__Group_2_1__1__Impl )
            // InternalGH341TestLanguage.g:456:2: rule__Works__Group_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_2_1__1__Impl();

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
    // $ANTLR end "rule__Works__Group_2_1__1"


    // $ANTLR start "rule__Works__Group_2_1__1__Impl"
    // InternalGH341TestLanguage.g:462:1: rule__Works__Group_2_1__1__Impl : ( ( rule__Works__IdsAssignment_2_1_1 ) ) ;
    public final void rule__Works__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:466:1: ( ( ( rule__Works__IdsAssignment_2_1_1 ) ) )
            // InternalGH341TestLanguage.g:467:1: ( ( rule__Works__IdsAssignment_2_1_1 ) )
            {
            // InternalGH341TestLanguage.g:467:1: ( ( rule__Works__IdsAssignment_2_1_1 ) )
            // InternalGH341TestLanguage.g:468:2: ( rule__Works__IdsAssignment_2_1_1 )
            {
             before(grammarAccess.getWorksAccess().getIdsAssignment_2_1_1()); 
            // InternalGH341TestLanguage.g:469:2: ( rule__Works__IdsAssignment_2_1_1 )
            // InternalGH341TestLanguage.g:469:3: rule__Works__IdsAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__IdsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getIdsAssignment_2_1_1()); 

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
    // $ANTLR end "rule__Works__Group_2_1__1__Impl"


    // $ANTLR start "rule__Works__Group_3__0"
    // InternalGH341TestLanguage.g:478:1: rule__Works__Group_3__0 : rule__Works__Group_3__0__Impl rule__Works__Group_3__1 ;
    public final void rule__Works__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:482:1: ( rule__Works__Group_3__0__Impl rule__Works__Group_3__1 )
            // InternalGH341TestLanguage.g:483:2: rule__Works__Group_3__0__Impl rule__Works__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Works__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3__1();

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
    // $ANTLR end "rule__Works__Group_3__0"


    // $ANTLR start "rule__Works__Group_3__0__Impl"
    // InternalGH341TestLanguage.g:490:1: rule__Works__Group_3__0__Impl : ( ( rule__Works__RefsAssignment_3_0 ) ) ;
    public final void rule__Works__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:494:1: ( ( ( rule__Works__RefsAssignment_3_0 ) ) )
            // InternalGH341TestLanguage.g:495:1: ( ( rule__Works__RefsAssignment_3_0 ) )
            {
            // InternalGH341TestLanguage.g:495:1: ( ( rule__Works__RefsAssignment_3_0 ) )
            // InternalGH341TestLanguage.g:496:2: ( rule__Works__RefsAssignment_3_0 )
            {
             before(grammarAccess.getWorksAccess().getRefsAssignment_3_0()); 
            // InternalGH341TestLanguage.g:497:2: ( rule__Works__RefsAssignment_3_0 )
            // InternalGH341TestLanguage.g:497:3: rule__Works__RefsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__RefsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getRefsAssignment_3_0()); 

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
    // $ANTLR end "rule__Works__Group_3__0__Impl"


    // $ANTLR start "rule__Works__Group_3__1"
    // InternalGH341TestLanguage.g:505:1: rule__Works__Group_3__1 : rule__Works__Group_3__1__Impl rule__Works__Group_3__2 ;
    public final void rule__Works__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:509:1: ( rule__Works__Group_3__1__Impl rule__Works__Group_3__2 )
            // InternalGH341TestLanguage.g:510:2: rule__Works__Group_3__1__Impl rule__Works__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Works__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3__2();

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
    // $ANTLR end "rule__Works__Group_3__1"


    // $ANTLR start "rule__Works__Group_3__1__Impl"
    // InternalGH341TestLanguage.g:517:1: rule__Works__Group_3__1__Impl : ( ( rule__Works__Group_3_1__0 )* ) ;
    public final void rule__Works__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:521:1: ( ( ( rule__Works__Group_3_1__0 )* ) )
            // InternalGH341TestLanguage.g:522:1: ( ( rule__Works__Group_3_1__0 )* )
            {
            // InternalGH341TestLanguage.g:522:1: ( ( rule__Works__Group_3_1__0 )* )
            // InternalGH341TestLanguage.g:523:2: ( rule__Works__Group_3_1__0 )*
            {
             before(grammarAccess.getWorksAccess().getGroup_3_1()); 
            // InternalGH341TestLanguage.g:524:2: ( rule__Works__Group_3_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==15) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:524:3: rule__Works__Group_3_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Works__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getWorksAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__Works__Group_3__1__Impl"


    // $ANTLR start "rule__Works__Group_3__2"
    // InternalGH341TestLanguage.g:532:1: rule__Works__Group_3__2 : rule__Works__Group_3__2__Impl rule__Works__Group_3__3 ;
    public final void rule__Works__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:536:1: ( rule__Works__Group_3__2__Impl rule__Works__Group_3__3 )
            // InternalGH341TestLanguage.g:537:2: rule__Works__Group_3__2__Impl rule__Works__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Works__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3__3();

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
    // $ANTLR end "rule__Works__Group_3__2"


    // $ANTLR start "rule__Works__Group_3__2__Impl"
    // InternalGH341TestLanguage.g:544:1: rule__Works__Group_3__2__Impl : ( 'X' ) ;
    public final void rule__Works__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:548:1: ( ( 'X' ) )
            // InternalGH341TestLanguage.g:549:1: ( 'X' )
            {
            // InternalGH341TestLanguage.g:549:1: ( 'X' )
            // InternalGH341TestLanguage.g:550:2: 'X'
            {
             before(grammarAccess.getWorksAccess().getXKeyword_3_2()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getXKeyword_3_2()); 

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
    // $ANTLR end "rule__Works__Group_3__2__Impl"


    // $ANTLR start "rule__Works__Group_3__3"
    // InternalGH341TestLanguage.g:559:1: rule__Works__Group_3__3 : rule__Works__Group_3__3__Impl ;
    public final void rule__Works__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:563:1: ( rule__Works__Group_3__3__Impl )
            // InternalGH341TestLanguage.g:564:2: rule__Works__Group_3__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3__3__Impl();

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
    // $ANTLR end "rule__Works__Group_3__3"


    // $ANTLR start "rule__Works__Group_3__3__Impl"
    // InternalGH341TestLanguage.g:570:1: rule__Works__Group_3__3__Impl : ( ';' ) ;
    public final void rule__Works__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:574:1: ( ( ';' ) )
            // InternalGH341TestLanguage.g:575:1: ( ';' )
            {
            // InternalGH341TestLanguage.g:575:1: ( ';' )
            // InternalGH341TestLanguage.g:576:2: ';'
            {
             before(grammarAccess.getWorksAccess().getSemicolonKeyword_3_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getSemicolonKeyword_3_3()); 

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
    // $ANTLR end "rule__Works__Group_3__3__Impl"


    // $ANTLR start "rule__Works__Group_3_1__0"
    // InternalGH341TestLanguage.g:586:1: rule__Works__Group_3_1__0 : rule__Works__Group_3_1__0__Impl rule__Works__Group_3_1__1 ;
    public final void rule__Works__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:590:1: ( rule__Works__Group_3_1__0__Impl rule__Works__Group_3_1__1 )
            // InternalGH341TestLanguage.g:591:2: rule__Works__Group_3_1__0__Impl rule__Works__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Works__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3_1__1();

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
    // $ANTLR end "rule__Works__Group_3_1__0"


    // $ANTLR start "rule__Works__Group_3_1__0__Impl"
    // InternalGH341TestLanguage.g:598:1: rule__Works__Group_3_1__0__Impl : ( '.' ) ;
    public final void rule__Works__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:602:1: ( ( '.' ) )
            // InternalGH341TestLanguage.g:603:1: ( '.' )
            {
            // InternalGH341TestLanguage.g:603:1: ( '.' )
            // InternalGH341TestLanguage.g:604:2: '.'
            {
             before(grammarAccess.getWorksAccess().getFullStopKeyword_3_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getFullStopKeyword_3_1_0()); 

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
    // $ANTLR end "rule__Works__Group_3_1__0__Impl"


    // $ANTLR start "rule__Works__Group_3_1__1"
    // InternalGH341TestLanguage.g:613:1: rule__Works__Group_3_1__1 : rule__Works__Group_3_1__1__Impl ;
    public final void rule__Works__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:617:1: ( rule__Works__Group_3_1__1__Impl )
            // InternalGH341TestLanguage.g:618:2: rule__Works__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__Works__Group_3_1__1"


    // $ANTLR start "rule__Works__Group_3_1__1__Impl"
    // InternalGH341TestLanguage.g:624:1: rule__Works__Group_3_1__1__Impl : ( ( rule__Works__RefsAssignment_3_1_1 ) ) ;
    public final void rule__Works__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:628:1: ( ( ( rule__Works__RefsAssignment_3_1_1 ) ) )
            // InternalGH341TestLanguage.g:629:1: ( ( rule__Works__RefsAssignment_3_1_1 ) )
            {
            // InternalGH341TestLanguage.g:629:1: ( ( rule__Works__RefsAssignment_3_1_1 ) )
            // InternalGH341TestLanguage.g:630:2: ( rule__Works__RefsAssignment_3_1_1 )
            {
             before(grammarAccess.getWorksAccess().getRefsAssignment_3_1_1()); 
            // InternalGH341TestLanguage.g:631:2: ( rule__Works__RefsAssignment_3_1_1 )
            // InternalGH341TestLanguage.g:631:3: rule__Works__RefsAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__RefsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getRefsAssignment_3_1_1()); 

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
    // $ANTLR end "rule__Works__Group_3_1__1__Impl"


    // $ANTLR start "rule__Broken__Group__0"
    // InternalGH341TestLanguage.g:640:1: rule__Broken__Group__0 : rule__Broken__Group__0__Impl rule__Broken__Group__1 ;
    public final void rule__Broken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:644:1: ( rule__Broken__Group__0__Impl rule__Broken__Group__1 )
            // InternalGH341TestLanguage.g:645:2: rule__Broken__Group__0__Impl rule__Broken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Broken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group__1();

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
    // $ANTLR end "rule__Broken__Group__0"


    // $ANTLR start "rule__Broken__Group__0__Impl"
    // InternalGH341TestLanguage.g:652:1: rule__Broken__Group__0__Impl : ( 'broken' ) ;
    public final void rule__Broken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:656:1: ( ( 'broken' ) )
            // InternalGH341TestLanguage.g:657:1: ( 'broken' )
            {
            // InternalGH341TestLanguage.g:657:1: ( 'broken' )
            // InternalGH341TestLanguage.g:658:2: 'broken'
            {
             before(grammarAccess.getBrokenAccess().getBrokenKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getBrokenKeyword_0()); 

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
    // $ANTLR end "rule__Broken__Group__0__Impl"


    // $ANTLR start "rule__Broken__Group__1"
    // InternalGH341TestLanguage.g:667:1: rule__Broken__Group__1 : rule__Broken__Group__1__Impl rule__Broken__Group__2 ;
    public final void rule__Broken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:671:1: ( rule__Broken__Group__1__Impl rule__Broken__Group__2 )
            // InternalGH341TestLanguage.g:672:2: rule__Broken__Group__1__Impl rule__Broken__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Broken__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group__2();

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
    // $ANTLR end "rule__Broken__Group__1"


    // $ANTLR start "rule__Broken__Group__1__Impl"
    // InternalGH341TestLanguage.g:679:1: rule__Broken__Group__1__Impl : ( ( rule__Broken__NameAssignment_1 ) ) ;
    public final void rule__Broken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:683:1: ( ( ( rule__Broken__NameAssignment_1 ) ) )
            // InternalGH341TestLanguage.g:684:1: ( ( rule__Broken__NameAssignment_1 ) )
            {
            // InternalGH341TestLanguage.g:684:1: ( ( rule__Broken__NameAssignment_1 ) )
            // InternalGH341TestLanguage.g:685:2: ( rule__Broken__NameAssignment_1 )
            {
             before(grammarAccess.getBrokenAccess().getNameAssignment_1()); 
            // InternalGH341TestLanguage.g:686:2: ( rule__Broken__NameAssignment_1 )
            // InternalGH341TestLanguage.g:686:3: rule__Broken__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBrokenAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Broken__Group__1__Impl"


    // $ANTLR start "rule__Broken__Group__2"
    // InternalGH341TestLanguage.g:694:1: rule__Broken__Group__2 : rule__Broken__Group__2__Impl rule__Broken__Group__3 ;
    public final void rule__Broken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:698:1: ( rule__Broken__Group__2__Impl rule__Broken__Group__3 )
            // InternalGH341TestLanguage.g:699:2: rule__Broken__Group__2__Impl rule__Broken__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Broken__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group__3();

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
    // $ANTLR end "rule__Broken__Group__2"


    // $ANTLR start "rule__Broken__Group__2__Impl"
    // InternalGH341TestLanguage.g:706:1: rule__Broken__Group__2__Impl : ( ruleFragment ) ;
    public final void rule__Broken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:710:1: ( ( ruleFragment ) )
            // InternalGH341TestLanguage.g:711:1: ( ruleFragment )
            {
            // InternalGH341TestLanguage.g:711:1: ( ruleFragment )
            // InternalGH341TestLanguage.g:712:2: ruleFragment
            {
             before(grammarAccess.getBrokenAccess().getFragmentParserRuleCall_2()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFragment();

            state._fsp--;

             after(grammarAccess.getBrokenAccess().getFragmentParserRuleCall_2()); 

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
    // $ANTLR end "rule__Broken__Group__2__Impl"


    // $ANTLR start "rule__Broken__Group__3"
    // InternalGH341TestLanguage.g:721:1: rule__Broken__Group__3 : rule__Broken__Group__3__Impl ;
    public final void rule__Broken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:725:1: ( rule__Broken__Group__3__Impl )
            // InternalGH341TestLanguage.g:726:2: rule__Broken__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group__3__Impl();

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
    // $ANTLR end "rule__Broken__Group__3"


    // $ANTLR start "rule__Broken__Group__3__Impl"
    // InternalGH341TestLanguage.g:732:1: rule__Broken__Group__3__Impl : ( ( rule__Broken__Group_3__0 )* ) ;
    public final void rule__Broken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:736:1: ( ( ( rule__Broken__Group_3__0 )* ) )
            // InternalGH341TestLanguage.g:737:1: ( ( rule__Broken__Group_3__0 )* )
            {
            // InternalGH341TestLanguage.g:737:1: ( ( rule__Broken__Group_3__0 )* )
            // InternalGH341TestLanguage.g:738:2: ( rule__Broken__Group_3__0 )*
            {
             before(grammarAccess.getBrokenAccess().getGroup_3()); 
            // InternalGH341TestLanguage.g:739:2: ( rule__Broken__Group_3__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:739:3: rule__Broken__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Broken__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getBrokenAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Broken__Group__3__Impl"


    // $ANTLR start "rule__Broken__Group_3__0"
    // InternalGH341TestLanguage.g:748:1: rule__Broken__Group_3__0 : rule__Broken__Group_3__0__Impl rule__Broken__Group_3__1 ;
    public final void rule__Broken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:752:1: ( rule__Broken__Group_3__0__Impl rule__Broken__Group_3__1 )
            // InternalGH341TestLanguage.g:753:2: rule__Broken__Group_3__0__Impl rule__Broken__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Broken__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3__1();

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
    // $ANTLR end "rule__Broken__Group_3__0"


    // $ANTLR start "rule__Broken__Group_3__0__Impl"
    // InternalGH341TestLanguage.g:760:1: rule__Broken__Group_3__0__Impl : ( ( rule__Broken__RefsAssignment_3_0 ) ) ;
    public final void rule__Broken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:764:1: ( ( ( rule__Broken__RefsAssignment_3_0 ) ) )
            // InternalGH341TestLanguage.g:765:1: ( ( rule__Broken__RefsAssignment_3_0 ) )
            {
            // InternalGH341TestLanguage.g:765:1: ( ( rule__Broken__RefsAssignment_3_0 ) )
            // InternalGH341TestLanguage.g:766:2: ( rule__Broken__RefsAssignment_3_0 )
            {
             before(grammarAccess.getBrokenAccess().getRefsAssignment_3_0()); 
            // InternalGH341TestLanguage.g:767:2: ( rule__Broken__RefsAssignment_3_0 )
            // InternalGH341TestLanguage.g:767:3: rule__Broken__RefsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__RefsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getBrokenAccess().getRefsAssignment_3_0()); 

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
    // $ANTLR end "rule__Broken__Group_3__0__Impl"


    // $ANTLR start "rule__Broken__Group_3__1"
    // InternalGH341TestLanguage.g:775:1: rule__Broken__Group_3__1 : rule__Broken__Group_3__1__Impl rule__Broken__Group_3__2 ;
    public final void rule__Broken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:779:1: ( rule__Broken__Group_3__1__Impl rule__Broken__Group_3__2 )
            // InternalGH341TestLanguage.g:780:2: rule__Broken__Group_3__1__Impl rule__Broken__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Broken__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3__2();

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
    // $ANTLR end "rule__Broken__Group_3__1"


    // $ANTLR start "rule__Broken__Group_3__1__Impl"
    // InternalGH341TestLanguage.g:787:1: rule__Broken__Group_3__1__Impl : ( ( rule__Broken__Group_3_1__0 )* ) ;
    public final void rule__Broken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:791:1: ( ( ( rule__Broken__Group_3_1__0 )* ) )
            // InternalGH341TestLanguage.g:792:1: ( ( rule__Broken__Group_3_1__0 )* )
            {
            // InternalGH341TestLanguage.g:792:1: ( ( rule__Broken__Group_3_1__0 )* )
            // InternalGH341TestLanguage.g:793:2: ( rule__Broken__Group_3_1__0 )*
            {
             before(grammarAccess.getBrokenAccess().getGroup_3_1()); 
            // InternalGH341TestLanguage.g:794:2: ( rule__Broken__Group_3_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:794:3: rule__Broken__Group_3_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Broken__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getBrokenAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__Broken__Group_3__1__Impl"


    // $ANTLR start "rule__Broken__Group_3__2"
    // InternalGH341TestLanguage.g:802:1: rule__Broken__Group_3__2 : rule__Broken__Group_3__2__Impl rule__Broken__Group_3__3 ;
    public final void rule__Broken__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:806:1: ( rule__Broken__Group_3__2__Impl rule__Broken__Group_3__3 )
            // InternalGH341TestLanguage.g:807:2: rule__Broken__Group_3__2__Impl rule__Broken__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Broken__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3__3();

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
    // $ANTLR end "rule__Broken__Group_3__2"


    // $ANTLR start "rule__Broken__Group_3__2__Impl"
    // InternalGH341TestLanguage.g:814:1: rule__Broken__Group_3__2__Impl : ( 'X' ) ;
    public final void rule__Broken__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:818:1: ( ( 'X' ) )
            // InternalGH341TestLanguage.g:819:1: ( 'X' )
            {
            // InternalGH341TestLanguage.g:819:1: ( 'X' )
            // InternalGH341TestLanguage.g:820:2: 'X'
            {
             before(grammarAccess.getBrokenAccess().getXKeyword_3_2()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getXKeyword_3_2()); 

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
    // $ANTLR end "rule__Broken__Group_3__2__Impl"


    // $ANTLR start "rule__Broken__Group_3__3"
    // InternalGH341TestLanguage.g:829:1: rule__Broken__Group_3__3 : rule__Broken__Group_3__3__Impl ;
    public final void rule__Broken__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:833:1: ( rule__Broken__Group_3__3__Impl )
            // InternalGH341TestLanguage.g:834:2: rule__Broken__Group_3__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3__3__Impl();

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
    // $ANTLR end "rule__Broken__Group_3__3"


    // $ANTLR start "rule__Broken__Group_3__3__Impl"
    // InternalGH341TestLanguage.g:840:1: rule__Broken__Group_3__3__Impl : ( ';' ) ;
    public final void rule__Broken__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:844:1: ( ( ';' ) )
            // InternalGH341TestLanguage.g:845:1: ( ';' )
            {
            // InternalGH341TestLanguage.g:845:1: ( ';' )
            // InternalGH341TestLanguage.g:846:2: ';'
            {
             before(grammarAccess.getBrokenAccess().getSemicolonKeyword_3_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getSemicolonKeyword_3_3()); 

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
    // $ANTLR end "rule__Broken__Group_3__3__Impl"


    // $ANTLR start "rule__Broken__Group_3_1__0"
    // InternalGH341TestLanguage.g:856:1: rule__Broken__Group_3_1__0 : rule__Broken__Group_3_1__0__Impl rule__Broken__Group_3_1__1 ;
    public final void rule__Broken__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:860:1: ( rule__Broken__Group_3_1__0__Impl rule__Broken__Group_3_1__1 )
            // InternalGH341TestLanguage.g:861:2: rule__Broken__Group_3_1__0__Impl rule__Broken__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Broken__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3_1__1();

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
    // $ANTLR end "rule__Broken__Group_3_1__0"


    // $ANTLR start "rule__Broken__Group_3_1__0__Impl"
    // InternalGH341TestLanguage.g:868:1: rule__Broken__Group_3_1__0__Impl : ( '.' ) ;
    public final void rule__Broken__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:872:1: ( ( '.' ) )
            // InternalGH341TestLanguage.g:873:1: ( '.' )
            {
            // InternalGH341TestLanguage.g:873:1: ( '.' )
            // InternalGH341TestLanguage.g:874:2: '.'
            {
             before(grammarAccess.getBrokenAccess().getFullStopKeyword_3_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getFullStopKeyword_3_1_0()); 

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
    // $ANTLR end "rule__Broken__Group_3_1__0__Impl"


    // $ANTLR start "rule__Broken__Group_3_1__1"
    // InternalGH341TestLanguage.g:883:1: rule__Broken__Group_3_1__1 : rule__Broken__Group_3_1__1__Impl ;
    public final void rule__Broken__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:887:1: ( rule__Broken__Group_3_1__1__Impl )
            // InternalGH341TestLanguage.g:888:2: rule__Broken__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__Broken__Group_3_1__1"


    // $ANTLR start "rule__Broken__Group_3_1__1__Impl"
    // InternalGH341TestLanguage.g:894:1: rule__Broken__Group_3_1__1__Impl : ( ( rule__Broken__RefsAssignment_3_1_1 ) ) ;
    public final void rule__Broken__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:898:1: ( ( ( rule__Broken__RefsAssignment_3_1_1 ) ) )
            // InternalGH341TestLanguage.g:899:1: ( ( rule__Broken__RefsAssignment_3_1_1 ) )
            {
            // InternalGH341TestLanguage.g:899:1: ( ( rule__Broken__RefsAssignment_3_1_1 ) )
            // InternalGH341TestLanguage.g:900:2: ( rule__Broken__RefsAssignment_3_1_1 )
            {
             before(grammarAccess.getBrokenAccess().getRefsAssignment_3_1_1()); 
            // InternalGH341TestLanguage.g:901:2: ( rule__Broken__RefsAssignment_3_1_1 )
            // InternalGH341TestLanguage.g:901:3: rule__Broken__RefsAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__RefsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getBrokenAccess().getRefsAssignment_3_1_1()); 

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
    // $ANTLR end "rule__Broken__Group_3_1__1__Impl"


    // $ANTLR start "rule__Third__Group__0"
    // InternalGH341TestLanguage.g:910:1: rule__Third__Group__0 : rule__Third__Group__0__Impl rule__Third__Group__1 ;
    public final void rule__Third__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:914:1: ( rule__Third__Group__0__Impl rule__Third__Group__1 )
            // InternalGH341TestLanguage.g:915:2: rule__Third__Group__0__Impl rule__Third__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Third__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Third__Group__1();

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
    // $ANTLR end "rule__Third__Group__0"


    // $ANTLR start "rule__Third__Group__0__Impl"
    // InternalGH341TestLanguage.g:922:1: rule__Third__Group__0__Impl : ( ruleDEFINE ) ;
    public final void rule__Third__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:926:1: ( ( ruleDEFINE ) )
            // InternalGH341TestLanguage.g:927:1: ( ruleDEFINE )
            {
            // InternalGH341TestLanguage.g:927:1: ( ruleDEFINE )
            // InternalGH341TestLanguage.g:928:2: ruleDEFINE
            {
             before(grammarAccess.getThirdAccess().getDEFINEParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDEFINE();

            state._fsp--;

             after(grammarAccess.getThirdAccess().getDEFINEParserRuleCall_0()); 

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
    // $ANTLR end "rule__Third__Group__0__Impl"


    // $ANTLR start "rule__Third__Group__1"
    // InternalGH341TestLanguage.g:937:1: rule__Third__Group__1 : rule__Third__Group__1__Impl rule__Third__Group__2 ;
    public final void rule__Third__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:941:1: ( rule__Third__Group__1__Impl rule__Third__Group__2 )
            // InternalGH341TestLanguage.g:942:2: rule__Third__Group__1__Impl rule__Third__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Third__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Third__Group__2();

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
    // $ANTLR end "rule__Third__Group__1"


    // $ANTLR start "rule__Third__Group__1__Impl"
    // InternalGH341TestLanguage.g:949:1: rule__Third__Group__1__Impl : ( ruleSTREAM ) ;
    public final void rule__Third__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:953:1: ( ( ruleSTREAM ) )
            // InternalGH341TestLanguage.g:954:1: ( ruleSTREAM )
            {
            // InternalGH341TestLanguage.g:954:1: ( ruleSTREAM )
            // InternalGH341TestLanguage.g:955:2: ruleSTREAM
            {
             before(grammarAccess.getThirdAccess().getSTREAMParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSTREAM();

            state._fsp--;

             after(grammarAccess.getThirdAccess().getSTREAMParserRuleCall_1()); 

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
    // $ANTLR end "rule__Third__Group__1__Impl"


    // $ANTLR start "rule__Third__Group__2"
    // InternalGH341TestLanguage.g:964:1: rule__Third__Group__2 : rule__Third__Group__2__Impl ;
    public final void rule__Third__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:968:1: ( rule__Third__Group__2__Impl )
            // InternalGH341TestLanguage.g:969:2: rule__Third__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Third__Group__2__Impl();

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
    // $ANTLR end "rule__Third__Group__2"


    // $ANTLR start "rule__Third__Group__2__Impl"
    // InternalGH341TestLanguage.g:975:1: rule__Third__Group__2__Impl : ( ( rule__Third__NameAssignment_2 ) ) ;
    public final void rule__Third__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:979:1: ( ( ( rule__Third__NameAssignment_2 ) ) )
            // InternalGH341TestLanguage.g:980:1: ( ( rule__Third__NameAssignment_2 ) )
            {
            // InternalGH341TestLanguage.g:980:1: ( ( rule__Third__NameAssignment_2 ) )
            // InternalGH341TestLanguage.g:981:2: ( rule__Third__NameAssignment_2 )
            {
             before(grammarAccess.getThirdAccess().getNameAssignment_2()); 
            // InternalGH341TestLanguage.g:982:2: ( rule__Third__NameAssignment_2 )
            // InternalGH341TestLanguage.g:982:3: rule__Third__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Third__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getThirdAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__Third__Group__2__Impl"


    // $ANTLR start "rule__Fragment__Group__0"
    // InternalGH341TestLanguage.g:991:1: rule__Fragment__Group__0 : rule__Fragment__Group__0__Impl rule__Fragment__Group__1 ;
    public final void rule__Fragment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:995:1: ( rule__Fragment__Group__0__Impl rule__Fragment__Group__1 )
            // InternalGH341TestLanguage.g:996:2: rule__Fragment__Group__0__Impl rule__Fragment__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Fragment__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__Group__1();

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
    // $ANTLR end "rule__Fragment__Group__0"


    // $ANTLR start "rule__Fragment__Group__0__Impl"
    // InternalGH341TestLanguage.g:1003:1: rule__Fragment__Group__0__Impl : ( ( rule__Fragment__IdsAssignment_0 ) ) ;
    public final void rule__Fragment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1007:1: ( ( ( rule__Fragment__IdsAssignment_0 ) ) )
            // InternalGH341TestLanguage.g:1008:1: ( ( rule__Fragment__IdsAssignment_0 ) )
            {
            // InternalGH341TestLanguage.g:1008:1: ( ( rule__Fragment__IdsAssignment_0 ) )
            // InternalGH341TestLanguage.g:1009:2: ( rule__Fragment__IdsAssignment_0 )
            {
             before(grammarAccess.getFragmentAccess().getIdsAssignment_0()); 
            // InternalGH341TestLanguage.g:1010:2: ( rule__Fragment__IdsAssignment_0 )
            // InternalGH341TestLanguage.g:1010:3: rule__Fragment__IdsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__IdsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFragmentAccess().getIdsAssignment_0()); 

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
    // $ANTLR end "rule__Fragment__Group__0__Impl"


    // $ANTLR start "rule__Fragment__Group__1"
    // InternalGH341TestLanguage.g:1018:1: rule__Fragment__Group__1 : rule__Fragment__Group__1__Impl rule__Fragment__Group__2 ;
    public final void rule__Fragment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1022:1: ( rule__Fragment__Group__1__Impl rule__Fragment__Group__2 )
            // InternalGH341TestLanguage.g:1023:2: rule__Fragment__Group__1__Impl rule__Fragment__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Fragment__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__Group__2();

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
    // $ANTLR end "rule__Fragment__Group__1"


    // $ANTLR start "rule__Fragment__Group__1__Impl"
    // InternalGH341TestLanguage.g:1030:1: rule__Fragment__Group__1__Impl : ( ( rule__Fragment__Group_1__0 )* ) ;
    public final void rule__Fragment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1034:1: ( ( ( rule__Fragment__Group_1__0 )* ) )
            // InternalGH341TestLanguage.g:1035:1: ( ( rule__Fragment__Group_1__0 )* )
            {
            // InternalGH341TestLanguage.g:1035:1: ( ( rule__Fragment__Group_1__0 )* )
            // InternalGH341TestLanguage.g:1036:2: ( rule__Fragment__Group_1__0 )*
            {
             before(grammarAccess.getFragmentAccess().getGroup_1()); 
            // InternalGH341TestLanguage.g:1037:2: ( rule__Fragment__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:1037:3: rule__Fragment__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Fragment__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getFragmentAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Fragment__Group__1__Impl"


    // $ANTLR start "rule__Fragment__Group__2"
    // InternalGH341TestLanguage.g:1045:1: rule__Fragment__Group__2 : rule__Fragment__Group__2__Impl ;
    public final void rule__Fragment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1049:1: ( rule__Fragment__Group__2__Impl )
            // InternalGH341TestLanguage.g:1050:2: rule__Fragment__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__Group__2__Impl();

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
    // $ANTLR end "rule__Fragment__Group__2"


    // $ANTLR start "rule__Fragment__Group__2__Impl"
    // InternalGH341TestLanguage.g:1056:1: rule__Fragment__Group__2__Impl : ( ';' ) ;
    public final void rule__Fragment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1060:1: ( ( ';' ) )
            // InternalGH341TestLanguage.g:1061:1: ( ';' )
            {
            // InternalGH341TestLanguage.g:1061:1: ( ';' )
            // InternalGH341TestLanguage.g:1062:2: ';'
            {
             before(grammarAccess.getFragmentAccess().getSemicolonKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFragmentAccess().getSemicolonKeyword_2()); 

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
    // $ANTLR end "rule__Fragment__Group__2__Impl"


    // $ANTLR start "rule__Fragment__Group_1__0"
    // InternalGH341TestLanguage.g:1072:1: rule__Fragment__Group_1__0 : rule__Fragment__Group_1__0__Impl rule__Fragment__Group_1__1 ;
    public final void rule__Fragment__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1076:1: ( rule__Fragment__Group_1__0__Impl rule__Fragment__Group_1__1 )
            // InternalGH341TestLanguage.g:1077:2: rule__Fragment__Group_1__0__Impl rule__Fragment__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Fragment__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__Group_1__1();

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
    // $ANTLR end "rule__Fragment__Group_1__0"


    // $ANTLR start "rule__Fragment__Group_1__0__Impl"
    // InternalGH341TestLanguage.g:1084:1: rule__Fragment__Group_1__0__Impl : ( '.' ) ;
    public final void rule__Fragment__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1088:1: ( ( '.' ) )
            // InternalGH341TestLanguage.g:1089:1: ( '.' )
            {
            // InternalGH341TestLanguage.g:1089:1: ( '.' )
            // InternalGH341TestLanguage.g:1090:2: '.'
            {
             before(grammarAccess.getFragmentAccess().getFullStopKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFragmentAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end "rule__Fragment__Group_1__0__Impl"


    // $ANTLR start "rule__Fragment__Group_1__1"
    // InternalGH341TestLanguage.g:1099:1: rule__Fragment__Group_1__1 : rule__Fragment__Group_1__1__Impl ;
    public final void rule__Fragment__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1103:1: ( rule__Fragment__Group_1__1__Impl )
            // InternalGH341TestLanguage.g:1104:2: rule__Fragment__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__Group_1__1__Impl();

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
    // $ANTLR end "rule__Fragment__Group_1__1"


    // $ANTLR start "rule__Fragment__Group_1__1__Impl"
    // InternalGH341TestLanguage.g:1110:1: rule__Fragment__Group_1__1__Impl : ( ( rule__Fragment__IdsAssignment_1_1 ) ) ;
    public final void rule__Fragment__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1114:1: ( ( ( rule__Fragment__IdsAssignment_1_1 ) ) )
            // InternalGH341TestLanguage.g:1115:1: ( ( rule__Fragment__IdsAssignment_1_1 ) )
            {
            // InternalGH341TestLanguage.g:1115:1: ( ( rule__Fragment__IdsAssignment_1_1 ) )
            // InternalGH341TestLanguage.g:1116:2: ( rule__Fragment__IdsAssignment_1_1 )
            {
             before(grammarAccess.getFragmentAccess().getIdsAssignment_1_1()); 
            // InternalGH341TestLanguage.g:1117:2: ( rule__Fragment__IdsAssignment_1_1 )
            // InternalGH341TestLanguage.g:1117:3: rule__Fragment__IdsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__IdsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFragmentAccess().getIdsAssignment_1_1()); 

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
    // $ANTLR end "rule__Fragment__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalGH341TestLanguage.g:1126:1: rule__Model__ElementsAssignment : ( ( rule__Model__ElementsAlternatives_0 ) ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1130:1: ( ( ( rule__Model__ElementsAlternatives_0 ) ) )
            // InternalGH341TestLanguage.g:1131:2: ( ( rule__Model__ElementsAlternatives_0 ) )
            {
            // InternalGH341TestLanguage.g:1131:2: ( ( rule__Model__ElementsAlternatives_0 ) )
            // InternalGH341TestLanguage.g:1132:3: ( rule__Model__ElementsAlternatives_0 )
            {
             before(grammarAccess.getModelAccess().getElementsAlternatives_0()); 
            // InternalGH341TestLanguage.g:1133:3: ( rule__Model__ElementsAlternatives_0 )
            // InternalGH341TestLanguage.g:1133:4: rule__Model__ElementsAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__ElementsAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getElementsAlternatives_0()); 

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


    // $ANTLR start "rule__Works__NameAssignment_1"
    // InternalGH341TestLanguage.g:1141:1: rule__Works__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Works__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1145:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1146:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1146:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1147:3: RULE_ID
            {
             before(grammarAccess.getWorksAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Works__NameAssignment_1"


    // $ANTLR start "rule__Works__IdsAssignment_2_0"
    // InternalGH341TestLanguage.g:1156:1: rule__Works__IdsAssignment_2_0 : ( RULE_ID ) ;
    public final void rule__Works__IdsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1160:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1161:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1161:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1162:3: RULE_ID
            {
             before(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_0_0()); 

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
    // $ANTLR end "rule__Works__IdsAssignment_2_0"


    // $ANTLR start "rule__Works__IdsAssignment_2_1_1"
    // InternalGH341TestLanguage.g:1171:1: rule__Works__IdsAssignment_2_1_1 : ( RULE_ID ) ;
    public final void rule__Works__IdsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1175:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1176:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1176:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1177:3: RULE_ID
            {
             before(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_1_1_0()); 

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
    // $ANTLR end "rule__Works__IdsAssignment_2_1_1"


    // $ANTLR start "rule__Works__RefsAssignment_3_0"
    // InternalGH341TestLanguage.g:1186:1: rule__Works__RefsAssignment_3_0 : ( ( RULE_ID ) ) ;
    public final void rule__Works__RefsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1190:1: ( ( ( RULE_ID ) ) )
            // InternalGH341TestLanguage.g:1191:2: ( ( RULE_ID ) )
            {
            // InternalGH341TestLanguage.g:1191:2: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1192:3: ( RULE_ID )
            {
             before(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_0_0()); 
            // InternalGH341TestLanguage.g:1193:3: ( RULE_ID )
            // InternalGH341TestLanguage.g:1194:4: RULE_ID
            {
             before(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_0_0_1()); 

            }

             after(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_0_0()); 

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
    // $ANTLR end "rule__Works__RefsAssignment_3_0"


    // $ANTLR start "rule__Works__RefsAssignment_3_1_1"
    // InternalGH341TestLanguage.g:1205:1: rule__Works__RefsAssignment_3_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Works__RefsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1209:1: ( ( ( RULE_ID ) ) )
            // InternalGH341TestLanguage.g:1210:2: ( ( RULE_ID ) )
            {
            // InternalGH341TestLanguage.g:1210:2: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1211:3: ( RULE_ID )
            {
             before(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_1_1_0()); 
            // InternalGH341TestLanguage.g:1212:3: ( RULE_ID )
            // InternalGH341TestLanguage.g:1213:4: RULE_ID
            {
             before(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_1_1_0_1()); 

            }

             after(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_1_1_0()); 

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
    // $ANTLR end "rule__Works__RefsAssignment_3_1_1"


    // $ANTLR start "rule__Broken__NameAssignment_1"
    // InternalGH341TestLanguage.g:1224:1: rule__Broken__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Broken__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1228:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1229:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1229:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1230:3: RULE_ID
            {
             before(grammarAccess.getBrokenAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Broken__NameAssignment_1"


    // $ANTLR start "rule__Broken__RefsAssignment_3_0"
    // InternalGH341TestLanguage.g:1239:1: rule__Broken__RefsAssignment_3_0 : ( ( RULE_ID ) ) ;
    public final void rule__Broken__RefsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1243:1: ( ( ( RULE_ID ) ) )
            // InternalGH341TestLanguage.g:1244:2: ( ( RULE_ID ) )
            {
            // InternalGH341TestLanguage.g:1244:2: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1245:3: ( RULE_ID )
            {
             before(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_0_0()); 
            // InternalGH341TestLanguage.g:1246:3: ( RULE_ID )
            // InternalGH341TestLanguage.g:1247:4: RULE_ID
            {
             before(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_0_0_1()); 

            }

             after(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_0_0()); 

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
    // $ANTLR end "rule__Broken__RefsAssignment_3_0"


    // $ANTLR start "rule__Broken__RefsAssignment_3_1_1"
    // InternalGH341TestLanguage.g:1258:1: rule__Broken__RefsAssignment_3_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Broken__RefsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1262:1: ( ( ( RULE_ID ) ) )
            // InternalGH341TestLanguage.g:1263:2: ( ( RULE_ID ) )
            {
            // InternalGH341TestLanguage.g:1263:2: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1264:3: ( RULE_ID )
            {
             before(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_1_1_0()); 
            // InternalGH341TestLanguage.g:1265:3: ( RULE_ID )
            // InternalGH341TestLanguage.g:1266:4: RULE_ID
            {
             before(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_1_1_0_1()); 

            }

             after(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_1_1_0()); 

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
    // $ANTLR end "rule__Broken__RefsAssignment_3_1_1"


    // $ANTLR start "rule__Third__NameAssignment_2"
    // InternalGH341TestLanguage.g:1277:1: rule__Third__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Third__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1281:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1282:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1282:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1283:3: RULE_ID
            {
             before(grammarAccess.getThirdAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Third__NameAssignment_2"


    // $ANTLR start "rule__Fragment__IdsAssignment_0"
    // InternalGH341TestLanguage.g:1292:1: rule__Fragment__IdsAssignment_0 : ( RULE_ID ) ;
    public final void rule__Fragment__IdsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1296:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1297:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1297:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1298:3: RULE_ID
            {
             before(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__Fragment__IdsAssignment_0"


    // $ANTLR start "rule__Fragment__IdsAssignment_1_1"
    // InternalGH341TestLanguage.g:1307:1: rule__Fragment__IdsAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Fragment__IdsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1311:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1312:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1312:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1313:3: RULE_ID
            {
             before(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Fragment__IdsAssignment_1_1"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    static final String dfa_1s = "\6\uffff";
    static final String dfa_2s = "\1\2\5\uffff";
    static final String dfa_3s = "\1\4\1\16\1\uffff\1\4\1\uffff\1\16";
    static final String dfa_4s = "\1\21\1\20\1\uffff\1\4\1\uffff\1\20";
    static final String dfa_5s = "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String dfa_6s = "\6\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\7\uffff\2\2\3\uffff\1\2",
            "\1\4\1\3\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\3\1\2"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 200:3: ( rule__Fragment__Group__0 )*";
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 308:2: ( rule__Works__Group_2__0 )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000023002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000800L});
    }


}
package org.eclipse.xtext.xtext.ui.ecore2xtext.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.xtext.ui.ecore2xtext.services.Ecore2XtextTestGrammarAccess;



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
public class InternalEcore2XtextTestParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'INT'", "'Root'", "'{'", "'}'", "'classes'", "','", "'concrete0'", "'Concrete0'", "'Concrete1'", "'DiamondInheritance'"
    };
    public static final int RULE_STRING=4;
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
    public static final int RULE_INT=6;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;

    // delegates
    // delegators


        public InternalEcore2XtextTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEcore2XtextTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEcore2XtextTestParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEcore2XtextTest.g"; }


    	private Ecore2XtextTestGrammarAccess grammarAccess;

    	public void setGrammarAccess(Ecore2XtextTestGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleRoot"
    // InternalEcore2XtextTest.g:58:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:59:1: ( ruleRoot EOF )
            // InternalEcore2XtextTest.g:60:1: ruleRoot EOF
            {
             before(grammarAccess.getRootRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRoot();

            state._fsp--;

             after(grammarAccess.getRootRule()); 
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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // InternalEcore2XtextTest.g:67:1: ruleRoot : ( ( rule__Root__Group__0 ) ) ;
    public final void ruleRoot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:71:2: ( ( ( rule__Root__Group__0 ) ) )
            // InternalEcore2XtextTest.g:72:2: ( ( rule__Root__Group__0 ) )
            {
            // InternalEcore2XtextTest.g:72:2: ( ( rule__Root__Group__0 ) )
            // InternalEcore2XtextTest.g:73:3: ( rule__Root__Group__0 )
            {
             before(grammarAccess.getRootAccess().getGroup()); 
            // InternalEcore2XtextTest.g:74:3: ( rule__Root__Group__0 )
            // InternalEcore2XtextTest.g:74:4: rule__Root__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getGroup()); 

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleAbstract"
    // InternalEcore2XtextTest.g:83:1: entryRuleAbstract : ruleAbstract EOF ;
    public final void entryRuleAbstract() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:84:1: ( ruleAbstract EOF )
            // InternalEcore2XtextTest.g:85:1: ruleAbstract EOF
            {
             before(grammarAccess.getAbstractRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstract();

            state._fsp--;

             after(grammarAccess.getAbstractRule()); 
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
    // $ANTLR end "entryRuleAbstract"


    // $ANTLR start "ruleAbstract"
    // InternalEcore2XtextTest.g:92:1: ruleAbstract : ( ( rule__Abstract__Alternatives ) ) ;
    public final void ruleAbstract() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:96:2: ( ( ( rule__Abstract__Alternatives ) ) )
            // InternalEcore2XtextTest.g:97:2: ( ( rule__Abstract__Alternatives ) )
            {
            // InternalEcore2XtextTest.g:97:2: ( ( rule__Abstract__Alternatives ) )
            // InternalEcore2XtextTest.g:98:3: ( rule__Abstract__Alternatives )
            {
             before(grammarAccess.getAbstractAccess().getAlternatives()); 
            // InternalEcore2XtextTest.g:99:3: ( rule__Abstract__Alternatives )
            // InternalEcore2XtextTest.g:99:4: rule__Abstract__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Abstract__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractAccess().getAlternatives()); 

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
    // $ANTLR end "ruleAbstract"


    // $ANTLR start "entryRuleConcrete0"
    // InternalEcore2XtextTest.g:108:1: entryRuleConcrete0 : ruleConcrete0 EOF ;
    public final void entryRuleConcrete0() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:109:1: ( ruleConcrete0 EOF )
            // InternalEcore2XtextTest.g:110:1: ruleConcrete0 EOF
            {
             before(grammarAccess.getConcrete0Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConcrete0();

            state._fsp--;

             after(grammarAccess.getConcrete0Rule()); 
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
    // $ANTLR end "entryRuleConcrete0"


    // $ANTLR start "ruleConcrete0"
    // InternalEcore2XtextTest.g:117:1: ruleConcrete0 : ( ( rule__Concrete0__Alternatives ) ) ;
    public final void ruleConcrete0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:121:2: ( ( ( rule__Concrete0__Alternatives ) ) )
            // InternalEcore2XtextTest.g:122:2: ( ( rule__Concrete0__Alternatives ) )
            {
            // InternalEcore2XtextTest.g:122:2: ( ( rule__Concrete0__Alternatives ) )
            // InternalEcore2XtextTest.g:123:3: ( rule__Concrete0__Alternatives )
            {
             before(grammarAccess.getConcrete0Access().getAlternatives()); 
            // InternalEcore2XtextTest.g:124:3: ( rule__Concrete0__Alternatives )
            // InternalEcore2XtextTest.g:124:4: rule__Concrete0__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConcrete0Access().getAlternatives()); 

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
    // $ANTLR end "ruleConcrete0"


    // $ANTLR start "entryRuleINT0"
    // InternalEcore2XtextTest.g:133:1: entryRuleINT0 : ruleINT0 EOF ;
    public final void entryRuleINT0() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:134:1: ( ruleINT0 EOF )
            // InternalEcore2XtextTest.g:135:1: ruleINT0 EOF
            {
             before(grammarAccess.getINT0Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleINT0();

            state._fsp--;

             after(grammarAccess.getINT0Rule()); 
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
    // $ANTLR end "entryRuleINT0"


    // $ANTLR start "ruleINT0"
    // InternalEcore2XtextTest.g:142:1: ruleINT0 : ( 'INT' ) ;
    public final void ruleINT0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:146:2: ( ( 'INT' ) )
            // InternalEcore2XtextTest.g:147:2: ( 'INT' )
            {
            // InternalEcore2XtextTest.g:147:2: ( 'INT' )
            // InternalEcore2XtextTest.g:148:3: 'INT'
            {
             before(grammarAccess.getINT0Access().getINTKeyword()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getINT0Access().getINTKeyword()); 

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
    // $ANTLR end "ruleINT0"


    // $ANTLR start "entryRuleConcrete0_Impl"
    // InternalEcore2XtextTest.g:158:1: entryRuleConcrete0_Impl : ruleConcrete0_Impl EOF ;
    public final void entryRuleConcrete0_Impl() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:159:1: ( ruleConcrete0_Impl EOF )
            // InternalEcore2XtextTest.g:160:1: ruleConcrete0_Impl EOF
            {
             before(grammarAccess.getConcrete0_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConcrete0_Impl();

            state._fsp--;

             after(grammarAccess.getConcrete0_ImplRule()); 
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
    // $ANTLR end "entryRuleConcrete0_Impl"


    // $ANTLR start "ruleConcrete0_Impl"
    // InternalEcore2XtextTest.g:167:1: ruleConcrete0_Impl : ( ( rule__Concrete0_Impl__Group__0 ) ) ;
    public final void ruleConcrete0_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:171:2: ( ( ( rule__Concrete0_Impl__Group__0 ) ) )
            // InternalEcore2XtextTest.g:172:2: ( ( rule__Concrete0_Impl__Group__0 ) )
            {
            // InternalEcore2XtextTest.g:172:2: ( ( rule__Concrete0_Impl__Group__0 ) )
            // InternalEcore2XtextTest.g:173:3: ( rule__Concrete0_Impl__Group__0 )
            {
             before(grammarAccess.getConcrete0_ImplAccess().getGroup()); 
            // InternalEcore2XtextTest.g:174:3: ( rule__Concrete0_Impl__Group__0 )
            // InternalEcore2XtextTest.g:174:4: rule__Concrete0_Impl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0_Impl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConcrete0_ImplAccess().getGroup()); 

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
    // $ANTLR end "ruleConcrete0_Impl"


    // $ANTLR start "entryRuleEString"
    // InternalEcore2XtextTest.g:183:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:184:1: ( ruleEString EOF )
            // InternalEcore2XtextTest.g:185:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalEcore2XtextTest.g:192:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:196:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalEcore2XtextTest.g:197:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalEcore2XtextTest.g:197:2: ( ( rule__EString__Alternatives ) )
            // InternalEcore2XtextTest.g:198:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalEcore2XtextTest.g:199:3: ( rule__EString__Alternatives )
            // InternalEcore2XtextTest.g:199:4: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

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
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleConcrete1_Impl"
    // InternalEcore2XtextTest.g:208:1: entryRuleConcrete1_Impl : ruleConcrete1_Impl EOF ;
    public final void entryRuleConcrete1_Impl() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:209:1: ( ruleConcrete1_Impl EOF )
            // InternalEcore2XtextTest.g:210:1: ruleConcrete1_Impl EOF
            {
             before(grammarAccess.getConcrete1_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConcrete1_Impl();

            state._fsp--;

             after(grammarAccess.getConcrete1_ImplRule()); 
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
    // $ANTLR end "entryRuleConcrete1_Impl"


    // $ANTLR start "ruleConcrete1_Impl"
    // InternalEcore2XtextTest.g:217:1: ruleConcrete1_Impl : ( ( rule__Concrete1_Impl__Group__0 ) ) ;
    public final void ruleConcrete1_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:221:2: ( ( ( rule__Concrete1_Impl__Group__0 ) ) )
            // InternalEcore2XtextTest.g:222:2: ( ( rule__Concrete1_Impl__Group__0 ) )
            {
            // InternalEcore2XtextTest.g:222:2: ( ( rule__Concrete1_Impl__Group__0 ) )
            // InternalEcore2XtextTest.g:223:3: ( rule__Concrete1_Impl__Group__0 )
            {
             before(grammarAccess.getConcrete1_ImplAccess().getGroup()); 
            // InternalEcore2XtextTest.g:224:3: ( rule__Concrete1_Impl__Group__0 )
            // InternalEcore2XtextTest.g:224:4: rule__Concrete1_Impl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete1_Impl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConcrete1_ImplAccess().getGroup()); 

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
    // $ANTLR end "ruleConcrete1_Impl"


    // $ANTLR start "entryRuleDiamondInheritance"
    // InternalEcore2XtextTest.g:233:1: entryRuleDiamondInheritance : ruleDiamondInheritance EOF ;
    public final void entryRuleDiamondInheritance() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:234:1: ( ruleDiamondInheritance EOF )
            // InternalEcore2XtextTest.g:235:1: ruleDiamondInheritance EOF
            {
             before(grammarAccess.getDiamondInheritanceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDiamondInheritance();

            state._fsp--;

             after(grammarAccess.getDiamondInheritanceRule()); 
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
    // $ANTLR end "entryRuleDiamondInheritance"


    // $ANTLR start "ruleDiamondInheritance"
    // InternalEcore2XtextTest.g:242:1: ruleDiamondInheritance : ( ( rule__DiamondInheritance__Group__0 ) ) ;
    public final void ruleDiamondInheritance() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:246:2: ( ( ( rule__DiamondInheritance__Group__0 ) ) )
            // InternalEcore2XtextTest.g:247:2: ( ( rule__DiamondInheritance__Group__0 ) )
            {
            // InternalEcore2XtextTest.g:247:2: ( ( rule__DiamondInheritance__Group__0 ) )
            // InternalEcore2XtextTest.g:248:3: ( rule__DiamondInheritance__Group__0 )
            {
             before(grammarAccess.getDiamondInheritanceAccess().getGroup()); 
            // InternalEcore2XtextTest.g:249:3: ( rule__DiamondInheritance__Group__0 )
            // InternalEcore2XtextTest.g:249:4: rule__DiamondInheritance__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DiamondInheritance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDiamondInheritanceAccess().getGroup()); 

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
    // $ANTLR end "ruleDiamondInheritance"


    // $ANTLR start "rule__Abstract__Alternatives"
    // InternalEcore2XtextTest.g:257:1: rule__Abstract__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleConcrete1_Impl ) | ( ruleDiamondInheritance ) );
    public final void rule__Abstract__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:261:1: ( ( ruleConcrete0_Impl ) | ( ruleConcrete1_Impl ) | ( ruleDiamondInheritance ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt1=1;
                }
                break;
            case 19:
                {
                alt1=2;
                }
                break;
            case 20:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalEcore2XtextTest.g:262:2: ( ruleConcrete0_Impl )
                    {
                    // InternalEcore2XtextTest.g:262:2: ( ruleConcrete0_Impl )
                    // InternalEcore2XtextTest.g:263:3: ruleConcrete0_Impl
                    {
                     before(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleConcrete0_Impl();

                    state._fsp--;

                     after(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEcore2XtextTest.g:268:2: ( ruleConcrete1_Impl )
                    {
                    // InternalEcore2XtextTest.g:268:2: ( ruleConcrete1_Impl )
                    // InternalEcore2XtextTest.g:269:3: ruleConcrete1_Impl
                    {
                     before(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleConcrete1_Impl();

                    state._fsp--;

                     after(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalEcore2XtextTest.g:274:2: ( ruleDiamondInheritance )
                    {
                    // InternalEcore2XtextTest.g:274:2: ( ruleDiamondInheritance )
                    // InternalEcore2XtextTest.g:275:3: ruleDiamondInheritance
                    {
                     before(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDiamondInheritance();

                    state._fsp--;

                     after(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2()); 

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
    // $ANTLR end "rule__Abstract__Alternatives"


    // $ANTLR start "rule__Concrete0__Alternatives"
    // InternalEcore2XtextTest.g:284:1: rule__Concrete0__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleDiamondInheritance ) );
    public final void rule__Concrete0__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:288:1: ( ( ruleConcrete0_Impl ) | ( ruleDiamondInheritance ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            else if ( (LA2_0==20) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalEcore2XtextTest.g:289:2: ( ruleConcrete0_Impl )
                    {
                    // InternalEcore2XtextTest.g:289:2: ( ruleConcrete0_Impl )
                    // InternalEcore2XtextTest.g:290:3: ruleConcrete0_Impl
                    {
                     before(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleConcrete0_Impl();

                    state._fsp--;

                     after(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEcore2XtextTest.g:295:2: ( ruleDiamondInheritance )
                    {
                    // InternalEcore2XtextTest.g:295:2: ( ruleDiamondInheritance )
                    // InternalEcore2XtextTest.g:296:3: ruleDiamondInheritance
                    {
                     before(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDiamondInheritance();

                    state._fsp--;

                     after(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1()); 

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
    // $ANTLR end "rule__Concrete0__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalEcore2XtextTest.g:305:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:309:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalEcore2XtextTest.g:310:2: ( RULE_STRING )
                    {
                    // InternalEcore2XtextTest.g:310:2: ( RULE_STRING )
                    // InternalEcore2XtextTest.g:311:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEcore2XtextTest.g:316:2: ( RULE_ID )
                    {
                    // InternalEcore2XtextTest.g:316:2: ( RULE_ID )
                    // InternalEcore2XtextTest.g:317:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__Root__Group__0"
    // InternalEcore2XtextTest.g:326:1: rule__Root__Group__0 : rule__Root__Group__0__Impl rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:330:1: ( rule__Root__Group__0__Impl rule__Root__Group__1 )
            // InternalEcore2XtextTest.g:331:2: rule__Root__Group__0__Impl rule__Root__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Root__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__1();

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
    // $ANTLR end "rule__Root__Group__0"


    // $ANTLR start "rule__Root__Group__0__Impl"
    // InternalEcore2XtextTest.g:338:1: rule__Root__Group__0__Impl : ( () ) ;
    public final void rule__Root__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:342:1: ( ( () ) )
            // InternalEcore2XtextTest.g:343:1: ( () )
            {
            // InternalEcore2XtextTest.g:343:1: ( () )
            // InternalEcore2XtextTest.g:344:2: ()
            {
             before(grammarAccess.getRootAccess().getRootAction_0()); 
            // InternalEcore2XtextTest.g:345:2: ()
            // InternalEcore2XtextTest.g:345:3: 
            {
            }

             after(grammarAccess.getRootAccess().getRootAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__0__Impl"


    // $ANTLR start "rule__Root__Group__1"
    // InternalEcore2XtextTest.g:353:1: rule__Root__Group__1 : rule__Root__Group__1__Impl rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:357:1: ( rule__Root__Group__1__Impl rule__Root__Group__2 )
            // InternalEcore2XtextTest.g:358:2: rule__Root__Group__1__Impl rule__Root__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Root__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__2();

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
    // $ANTLR end "rule__Root__Group__1"


    // $ANTLR start "rule__Root__Group__1__Impl"
    // InternalEcore2XtextTest.g:365:1: rule__Root__Group__1__Impl : ( 'Root' ) ;
    public final void rule__Root__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:369:1: ( ( 'Root' ) )
            // InternalEcore2XtextTest.g:370:1: ( 'Root' )
            {
            // InternalEcore2XtextTest.g:370:1: ( 'Root' )
            // InternalEcore2XtextTest.g:371:2: 'Root'
            {
             before(grammarAccess.getRootAccess().getRootKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getRootKeyword_1()); 

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
    // $ANTLR end "rule__Root__Group__1__Impl"


    // $ANTLR start "rule__Root__Group__2"
    // InternalEcore2XtextTest.g:380:1: rule__Root__Group__2 : rule__Root__Group__2__Impl rule__Root__Group__3 ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:384:1: ( rule__Root__Group__2__Impl rule__Root__Group__3 )
            // InternalEcore2XtextTest.g:385:2: rule__Root__Group__2__Impl rule__Root__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Root__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__3();

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
    // $ANTLR end "rule__Root__Group__2"


    // $ANTLR start "rule__Root__Group__2__Impl"
    // InternalEcore2XtextTest.g:392:1: rule__Root__Group__2__Impl : ( ( rule__Root__NameAssignment_2 ) ) ;
    public final void rule__Root__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:396:1: ( ( ( rule__Root__NameAssignment_2 ) ) )
            // InternalEcore2XtextTest.g:397:1: ( ( rule__Root__NameAssignment_2 ) )
            {
            // InternalEcore2XtextTest.g:397:1: ( ( rule__Root__NameAssignment_2 ) )
            // InternalEcore2XtextTest.g:398:2: ( rule__Root__NameAssignment_2 )
            {
             before(grammarAccess.getRootAccess().getNameAssignment_2()); 
            // InternalEcore2XtextTest.g:399:2: ( rule__Root__NameAssignment_2 )
            // InternalEcore2XtextTest.g:399:3: rule__Root__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__Root__Group__2__Impl"


    // $ANTLR start "rule__Root__Group__3"
    // InternalEcore2XtextTest.g:407:1: rule__Root__Group__3 : rule__Root__Group__3__Impl rule__Root__Group__4 ;
    public final void rule__Root__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:411:1: ( rule__Root__Group__3__Impl rule__Root__Group__4 )
            // InternalEcore2XtextTest.g:412:2: rule__Root__Group__3__Impl rule__Root__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Root__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__4();

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
    // $ANTLR end "rule__Root__Group__3"


    // $ANTLR start "rule__Root__Group__3__Impl"
    // InternalEcore2XtextTest.g:419:1: rule__Root__Group__3__Impl : ( '{' ) ;
    public final void rule__Root__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:423:1: ( ( '{' ) )
            // InternalEcore2XtextTest.g:424:1: ( '{' )
            {
            // InternalEcore2XtextTest.g:424:1: ( '{' )
            // InternalEcore2XtextTest.g:425:2: '{'
            {
             before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3()); 

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
    // $ANTLR end "rule__Root__Group__3__Impl"


    // $ANTLR start "rule__Root__Group__4"
    // InternalEcore2XtextTest.g:434:1: rule__Root__Group__4 : rule__Root__Group__4__Impl rule__Root__Group__5 ;
    public final void rule__Root__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:438:1: ( rule__Root__Group__4__Impl rule__Root__Group__5 )
            // InternalEcore2XtextTest.g:439:2: rule__Root__Group__4__Impl rule__Root__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Root__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__5();

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
    // $ANTLR end "rule__Root__Group__4"


    // $ANTLR start "rule__Root__Group__4__Impl"
    // InternalEcore2XtextTest.g:446:1: rule__Root__Group__4__Impl : ( ( rule__Root__Group_4__0 )? ) ;
    public final void rule__Root__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:450:1: ( ( ( rule__Root__Group_4__0 )? ) )
            // InternalEcore2XtextTest.g:451:1: ( ( rule__Root__Group_4__0 )? )
            {
            // InternalEcore2XtextTest.g:451:1: ( ( rule__Root__Group_4__0 )? )
            // InternalEcore2XtextTest.g:452:2: ( rule__Root__Group_4__0 )?
            {
             before(grammarAccess.getRootAccess().getGroup_4()); 
            // InternalEcore2XtextTest.g:453:2: ( rule__Root__Group_4__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalEcore2XtextTest.g:453:3: rule__Root__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Root__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootAccess().getGroup_4()); 

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
    // $ANTLR end "rule__Root__Group__4__Impl"


    // $ANTLR start "rule__Root__Group__5"
    // InternalEcore2XtextTest.g:461:1: rule__Root__Group__5 : rule__Root__Group__5__Impl rule__Root__Group__6 ;
    public final void rule__Root__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:465:1: ( rule__Root__Group__5__Impl rule__Root__Group__6 )
            // InternalEcore2XtextTest.g:466:2: rule__Root__Group__5__Impl rule__Root__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Root__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__6();

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
    // $ANTLR end "rule__Root__Group__5"


    // $ANTLR start "rule__Root__Group__5__Impl"
    // InternalEcore2XtextTest.g:473:1: rule__Root__Group__5__Impl : ( ( rule__Root__Group_5__0 )? ) ;
    public final void rule__Root__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:477:1: ( ( ( rule__Root__Group_5__0 )? ) )
            // InternalEcore2XtextTest.g:478:1: ( ( rule__Root__Group_5__0 )? )
            {
            // InternalEcore2XtextTest.g:478:1: ( ( rule__Root__Group_5__0 )? )
            // InternalEcore2XtextTest.g:479:2: ( rule__Root__Group_5__0 )?
            {
             before(grammarAccess.getRootAccess().getGroup_5()); 
            // InternalEcore2XtextTest.g:480:2: ( rule__Root__Group_5__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalEcore2XtextTest.g:480:3: rule__Root__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Root__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootAccess().getGroup_5()); 

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
    // $ANTLR end "rule__Root__Group__5__Impl"


    // $ANTLR start "rule__Root__Group__6"
    // InternalEcore2XtextTest.g:488:1: rule__Root__Group__6 : rule__Root__Group__6__Impl ;
    public final void rule__Root__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:492:1: ( rule__Root__Group__6__Impl )
            // InternalEcore2XtextTest.g:493:2: rule__Root__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__6__Impl();

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
    // $ANTLR end "rule__Root__Group__6"


    // $ANTLR start "rule__Root__Group__6__Impl"
    // InternalEcore2XtextTest.g:499:1: rule__Root__Group__6__Impl : ( '}' ) ;
    public final void rule__Root__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:503:1: ( ( '}' ) )
            // InternalEcore2XtextTest.g:504:1: ( '}' )
            {
            // InternalEcore2XtextTest.g:504:1: ( '}' )
            // InternalEcore2XtextTest.g:505:2: '}'
            {
             before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__Root__Group__6__Impl"


    // $ANTLR start "rule__Root__Group_4__0"
    // InternalEcore2XtextTest.g:515:1: rule__Root__Group_4__0 : rule__Root__Group_4__0__Impl rule__Root__Group_4__1 ;
    public final void rule__Root__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:519:1: ( rule__Root__Group_4__0__Impl rule__Root__Group_4__1 )
            // InternalEcore2XtextTest.g:520:2: rule__Root__Group_4__0__Impl rule__Root__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Root__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4__1();

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
    // $ANTLR end "rule__Root__Group_4__0"


    // $ANTLR start "rule__Root__Group_4__0__Impl"
    // InternalEcore2XtextTest.g:527:1: rule__Root__Group_4__0__Impl : ( 'classes' ) ;
    public final void rule__Root__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:531:1: ( ( 'classes' ) )
            // InternalEcore2XtextTest.g:532:1: ( 'classes' )
            {
            // InternalEcore2XtextTest.g:532:1: ( 'classes' )
            // InternalEcore2XtextTest.g:533:2: 'classes'
            {
             before(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 

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
    // $ANTLR end "rule__Root__Group_4__0__Impl"


    // $ANTLR start "rule__Root__Group_4__1"
    // InternalEcore2XtextTest.g:542:1: rule__Root__Group_4__1 : rule__Root__Group_4__1__Impl rule__Root__Group_4__2 ;
    public final void rule__Root__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:546:1: ( rule__Root__Group_4__1__Impl rule__Root__Group_4__2 )
            // InternalEcore2XtextTest.g:547:2: rule__Root__Group_4__1__Impl rule__Root__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Root__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4__2();

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
    // $ANTLR end "rule__Root__Group_4__1"


    // $ANTLR start "rule__Root__Group_4__1__Impl"
    // InternalEcore2XtextTest.g:554:1: rule__Root__Group_4__1__Impl : ( '{' ) ;
    public final void rule__Root__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:558:1: ( ( '{' ) )
            // InternalEcore2XtextTest.g:559:1: ( '{' )
            {
            // InternalEcore2XtextTest.g:559:1: ( '{' )
            // InternalEcore2XtextTest.g:560:2: '{'
            {
             before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 

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
    // $ANTLR end "rule__Root__Group_4__1__Impl"


    // $ANTLR start "rule__Root__Group_4__2"
    // InternalEcore2XtextTest.g:569:1: rule__Root__Group_4__2 : rule__Root__Group_4__2__Impl rule__Root__Group_4__3 ;
    public final void rule__Root__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:573:1: ( rule__Root__Group_4__2__Impl rule__Root__Group_4__3 )
            // InternalEcore2XtextTest.g:574:2: rule__Root__Group_4__2__Impl rule__Root__Group_4__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Root__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4__3();

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
    // $ANTLR end "rule__Root__Group_4__2"


    // $ANTLR start "rule__Root__Group_4__2__Impl"
    // InternalEcore2XtextTest.g:581:1: rule__Root__Group_4__2__Impl : ( ( rule__Root__ClassesAssignment_4_2 ) ) ;
    public final void rule__Root__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:585:1: ( ( ( rule__Root__ClassesAssignment_4_2 ) ) )
            // InternalEcore2XtextTest.g:586:1: ( ( rule__Root__ClassesAssignment_4_2 ) )
            {
            // InternalEcore2XtextTest.g:586:1: ( ( rule__Root__ClassesAssignment_4_2 ) )
            // InternalEcore2XtextTest.g:587:2: ( rule__Root__ClassesAssignment_4_2 )
            {
             before(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 
            // InternalEcore2XtextTest.g:588:2: ( rule__Root__ClassesAssignment_4_2 )
            // InternalEcore2XtextTest.g:588:3: rule__Root__ClassesAssignment_4_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__ClassesAssignment_4_2();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 

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
    // $ANTLR end "rule__Root__Group_4__2__Impl"


    // $ANTLR start "rule__Root__Group_4__3"
    // InternalEcore2XtextTest.g:596:1: rule__Root__Group_4__3 : rule__Root__Group_4__3__Impl rule__Root__Group_4__4 ;
    public final void rule__Root__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:600:1: ( rule__Root__Group_4__3__Impl rule__Root__Group_4__4 )
            // InternalEcore2XtextTest.g:601:2: rule__Root__Group_4__3__Impl rule__Root__Group_4__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Root__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4__4();

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
    // $ANTLR end "rule__Root__Group_4__3"


    // $ANTLR start "rule__Root__Group_4__3__Impl"
    // InternalEcore2XtextTest.g:608:1: rule__Root__Group_4__3__Impl : ( ( rule__Root__Group_4_3__0 )* ) ;
    public final void rule__Root__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:612:1: ( ( ( rule__Root__Group_4_3__0 )* ) )
            // InternalEcore2XtextTest.g:613:1: ( ( rule__Root__Group_4_3__0 )* )
            {
            // InternalEcore2XtextTest.g:613:1: ( ( rule__Root__Group_4_3__0 )* )
            // InternalEcore2XtextTest.g:614:2: ( rule__Root__Group_4_3__0 )*
            {
             before(grammarAccess.getRootAccess().getGroup_4_3()); 
            // InternalEcore2XtextTest.g:615:2: ( rule__Root__Group_4_3__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==16) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalEcore2XtextTest.g:615:3: rule__Root__Group_4_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__Root__Group_4_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRootAccess().getGroup_4_3()); 

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
    // $ANTLR end "rule__Root__Group_4__3__Impl"


    // $ANTLR start "rule__Root__Group_4__4"
    // InternalEcore2XtextTest.g:623:1: rule__Root__Group_4__4 : rule__Root__Group_4__4__Impl ;
    public final void rule__Root__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:627:1: ( rule__Root__Group_4__4__Impl )
            // InternalEcore2XtextTest.g:628:2: rule__Root__Group_4__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4__4__Impl();

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
    // $ANTLR end "rule__Root__Group_4__4"


    // $ANTLR start "rule__Root__Group_4__4__Impl"
    // InternalEcore2XtextTest.g:634:1: rule__Root__Group_4__4__Impl : ( '}' ) ;
    public final void rule__Root__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:638:1: ( ( '}' ) )
            // InternalEcore2XtextTest.g:639:1: ( '}' )
            {
            // InternalEcore2XtextTest.g:639:1: ( '}' )
            // InternalEcore2XtextTest.g:640:2: '}'
            {
             before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4()); 

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
    // $ANTLR end "rule__Root__Group_4__4__Impl"


    // $ANTLR start "rule__Root__Group_4_3__0"
    // InternalEcore2XtextTest.g:650:1: rule__Root__Group_4_3__0 : rule__Root__Group_4_3__0__Impl rule__Root__Group_4_3__1 ;
    public final void rule__Root__Group_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:654:1: ( rule__Root__Group_4_3__0__Impl rule__Root__Group_4_3__1 )
            // InternalEcore2XtextTest.g:655:2: rule__Root__Group_4_3__0__Impl rule__Root__Group_4_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Root__Group_4_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4_3__1();

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
    // $ANTLR end "rule__Root__Group_4_3__0"


    // $ANTLR start "rule__Root__Group_4_3__0__Impl"
    // InternalEcore2XtextTest.g:662:1: rule__Root__Group_4_3__0__Impl : ( ',' ) ;
    public final void rule__Root__Group_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:666:1: ( ( ',' ) )
            // InternalEcore2XtextTest.g:667:1: ( ',' )
            {
            // InternalEcore2XtextTest.g:667:1: ( ',' )
            // InternalEcore2XtextTest.g:668:2: ','
            {
             before(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 

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
    // $ANTLR end "rule__Root__Group_4_3__0__Impl"


    // $ANTLR start "rule__Root__Group_4_3__1"
    // InternalEcore2XtextTest.g:677:1: rule__Root__Group_4_3__1 : rule__Root__Group_4_3__1__Impl ;
    public final void rule__Root__Group_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:681:1: ( rule__Root__Group_4_3__1__Impl )
            // InternalEcore2XtextTest.g:682:2: rule__Root__Group_4_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4_3__1__Impl();

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
    // $ANTLR end "rule__Root__Group_4_3__1"


    // $ANTLR start "rule__Root__Group_4_3__1__Impl"
    // InternalEcore2XtextTest.g:688:1: rule__Root__Group_4_3__1__Impl : ( ( rule__Root__ClassesAssignment_4_3_1 ) ) ;
    public final void rule__Root__Group_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:692:1: ( ( ( rule__Root__ClassesAssignment_4_3_1 ) ) )
            // InternalEcore2XtextTest.g:693:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            {
            // InternalEcore2XtextTest.g:693:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            // InternalEcore2XtextTest.g:694:2: ( rule__Root__ClassesAssignment_4_3_1 )
            {
             before(grammarAccess.getRootAccess().getClassesAssignment_4_3_1()); 
            // InternalEcore2XtextTest.g:695:2: ( rule__Root__ClassesAssignment_4_3_1 )
            // InternalEcore2XtextTest.g:695:3: rule__Root__ClassesAssignment_4_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__ClassesAssignment_4_3_1();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getClassesAssignment_4_3_1()); 

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
    // $ANTLR end "rule__Root__Group_4_3__1__Impl"


    // $ANTLR start "rule__Root__Group_5__0"
    // InternalEcore2XtextTest.g:704:1: rule__Root__Group_5__0 : rule__Root__Group_5__0__Impl rule__Root__Group_5__1 ;
    public final void rule__Root__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:708:1: ( rule__Root__Group_5__0__Impl rule__Root__Group_5__1 )
            // InternalEcore2XtextTest.g:709:2: rule__Root__Group_5__0__Impl rule__Root__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Root__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_5__1();

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
    // $ANTLR end "rule__Root__Group_5__0"


    // $ANTLR start "rule__Root__Group_5__0__Impl"
    // InternalEcore2XtextTest.g:716:1: rule__Root__Group_5__0__Impl : ( 'concrete0' ) ;
    public final void rule__Root__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:720:1: ( ( 'concrete0' ) )
            // InternalEcore2XtextTest.g:721:1: ( 'concrete0' )
            {
            // InternalEcore2XtextTest.g:721:1: ( 'concrete0' )
            // InternalEcore2XtextTest.g:722:2: 'concrete0'
            {
             before(grammarAccess.getRootAccess().getConcrete0Keyword_5_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getConcrete0Keyword_5_0()); 

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
    // $ANTLR end "rule__Root__Group_5__0__Impl"


    // $ANTLR start "rule__Root__Group_5__1"
    // InternalEcore2XtextTest.g:731:1: rule__Root__Group_5__1 : rule__Root__Group_5__1__Impl ;
    public final void rule__Root__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:735:1: ( rule__Root__Group_5__1__Impl )
            // InternalEcore2XtextTest.g:736:2: rule__Root__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_5__1__Impl();

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
    // $ANTLR end "rule__Root__Group_5__1"


    // $ANTLR start "rule__Root__Group_5__1__Impl"
    // InternalEcore2XtextTest.g:742:1: rule__Root__Group_5__1__Impl : ( ( rule__Root__Concrete0Assignment_5_1 ) ) ;
    public final void rule__Root__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:746:1: ( ( ( rule__Root__Concrete0Assignment_5_1 ) ) )
            // InternalEcore2XtextTest.g:747:1: ( ( rule__Root__Concrete0Assignment_5_1 ) )
            {
            // InternalEcore2XtextTest.g:747:1: ( ( rule__Root__Concrete0Assignment_5_1 ) )
            // InternalEcore2XtextTest.g:748:2: ( rule__Root__Concrete0Assignment_5_1 )
            {
             before(grammarAccess.getRootAccess().getConcrete0Assignment_5_1()); 
            // InternalEcore2XtextTest.g:749:2: ( rule__Root__Concrete0Assignment_5_1 )
            // InternalEcore2XtextTest.g:749:3: rule__Root__Concrete0Assignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Concrete0Assignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getConcrete0Assignment_5_1()); 

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
    // $ANTLR end "rule__Root__Group_5__1__Impl"


    // $ANTLR start "rule__Concrete0_Impl__Group__0"
    // InternalEcore2XtextTest.g:758:1: rule__Concrete0_Impl__Group__0 : rule__Concrete0_Impl__Group__0__Impl rule__Concrete0_Impl__Group__1 ;
    public final void rule__Concrete0_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:762:1: ( rule__Concrete0_Impl__Group__0__Impl rule__Concrete0_Impl__Group__1 )
            // InternalEcore2XtextTest.g:763:2: rule__Concrete0_Impl__Group__0__Impl rule__Concrete0_Impl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Concrete0_Impl__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0_Impl__Group__1();

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
    // $ANTLR end "rule__Concrete0_Impl__Group__0"


    // $ANTLR start "rule__Concrete0_Impl__Group__0__Impl"
    // InternalEcore2XtextTest.g:770:1: rule__Concrete0_Impl__Group__0__Impl : ( () ) ;
    public final void rule__Concrete0_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:774:1: ( ( () ) )
            // InternalEcore2XtextTest.g:775:1: ( () )
            {
            // InternalEcore2XtextTest.g:775:1: ( () )
            // InternalEcore2XtextTest.g:776:2: ()
            {
             before(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0()); 
            // InternalEcore2XtextTest.g:777:2: ()
            // InternalEcore2XtextTest.g:777:3: 
            {
            }

             after(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete0_Impl__Group__0__Impl"


    // $ANTLR start "rule__Concrete0_Impl__Group__1"
    // InternalEcore2XtextTest.g:785:1: rule__Concrete0_Impl__Group__1 : rule__Concrete0_Impl__Group__1__Impl rule__Concrete0_Impl__Group__2 ;
    public final void rule__Concrete0_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:789:1: ( rule__Concrete0_Impl__Group__1__Impl rule__Concrete0_Impl__Group__2 )
            // InternalEcore2XtextTest.g:790:2: rule__Concrete0_Impl__Group__1__Impl rule__Concrete0_Impl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Concrete0_Impl__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0_Impl__Group__2();

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
    // $ANTLR end "rule__Concrete0_Impl__Group__1"


    // $ANTLR start "rule__Concrete0_Impl__Group__1__Impl"
    // InternalEcore2XtextTest.g:797:1: rule__Concrete0_Impl__Group__1__Impl : ( 'Concrete0' ) ;
    public final void rule__Concrete0_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:801:1: ( ( 'Concrete0' ) )
            // InternalEcore2XtextTest.g:802:1: ( 'Concrete0' )
            {
            // InternalEcore2XtextTest.g:802:1: ( 'Concrete0' )
            // InternalEcore2XtextTest.g:803:2: 'Concrete0'
            {
             before(grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1()); 

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
    // $ANTLR end "rule__Concrete0_Impl__Group__1__Impl"


    // $ANTLR start "rule__Concrete0_Impl__Group__2"
    // InternalEcore2XtextTest.g:812:1: rule__Concrete0_Impl__Group__2 : rule__Concrete0_Impl__Group__2__Impl ;
    public final void rule__Concrete0_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:816:1: ( rule__Concrete0_Impl__Group__2__Impl )
            // InternalEcore2XtextTest.g:817:2: rule__Concrete0_Impl__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0_Impl__Group__2__Impl();

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
    // $ANTLR end "rule__Concrete0_Impl__Group__2"


    // $ANTLR start "rule__Concrete0_Impl__Group__2__Impl"
    // InternalEcore2XtextTest.g:823:1: rule__Concrete0_Impl__Group__2__Impl : ( ( rule__Concrete0_Impl__NameAssignment_2 ) ) ;
    public final void rule__Concrete0_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:827:1: ( ( ( rule__Concrete0_Impl__NameAssignment_2 ) ) )
            // InternalEcore2XtextTest.g:828:1: ( ( rule__Concrete0_Impl__NameAssignment_2 ) )
            {
            // InternalEcore2XtextTest.g:828:1: ( ( rule__Concrete0_Impl__NameAssignment_2 ) )
            // InternalEcore2XtextTest.g:829:2: ( rule__Concrete0_Impl__NameAssignment_2 )
            {
             before(grammarAccess.getConcrete0_ImplAccess().getNameAssignment_2()); 
            // InternalEcore2XtextTest.g:830:2: ( rule__Concrete0_Impl__NameAssignment_2 )
            // InternalEcore2XtextTest.g:830:3: rule__Concrete0_Impl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0_Impl__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConcrete0_ImplAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__Concrete0_Impl__Group__2__Impl"


    // $ANTLR start "rule__Concrete1_Impl__Group__0"
    // InternalEcore2XtextTest.g:839:1: rule__Concrete1_Impl__Group__0 : rule__Concrete1_Impl__Group__0__Impl rule__Concrete1_Impl__Group__1 ;
    public final void rule__Concrete1_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:843:1: ( rule__Concrete1_Impl__Group__0__Impl rule__Concrete1_Impl__Group__1 )
            // InternalEcore2XtextTest.g:844:2: rule__Concrete1_Impl__Group__0__Impl rule__Concrete1_Impl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Concrete1_Impl__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete1_Impl__Group__1();

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
    // $ANTLR end "rule__Concrete1_Impl__Group__0"


    // $ANTLR start "rule__Concrete1_Impl__Group__0__Impl"
    // InternalEcore2XtextTest.g:851:1: rule__Concrete1_Impl__Group__0__Impl : ( () ) ;
    public final void rule__Concrete1_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:855:1: ( ( () ) )
            // InternalEcore2XtextTest.g:856:1: ( () )
            {
            // InternalEcore2XtextTest.g:856:1: ( () )
            // InternalEcore2XtextTest.g:857:2: ()
            {
             before(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0()); 
            // InternalEcore2XtextTest.g:858:2: ()
            // InternalEcore2XtextTest.g:858:3: 
            {
            }

             after(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete1_Impl__Group__0__Impl"


    // $ANTLR start "rule__Concrete1_Impl__Group__1"
    // InternalEcore2XtextTest.g:866:1: rule__Concrete1_Impl__Group__1 : rule__Concrete1_Impl__Group__1__Impl rule__Concrete1_Impl__Group__2 ;
    public final void rule__Concrete1_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:870:1: ( rule__Concrete1_Impl__Group__1__Impl rule__Concrete1_Impl__Group__2 )
            // InternalEcore2XtextTest.g:871:2: rule__Concrete1_Impl__Group__1__Impl rule__Concrete1_Impl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Concrete1_Impl__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete1_Impl__Group__2();

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
    // $ANTLR end "rule__Concrete1_Impl__Group__1"


    // $ANTLR start "rule__Concrete1_Impl__Group__1__Impl"
    // InternalEcore2XtextTest.g:878:1: rule__Concrete1_Impl__Group__1__Impl : ( 'Concrete1' ) ;
    public final void rule__Concrete1_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:882:1: ( ( 'Concrete1' ) )
            // InternalEcore2XtextTest.g:883:1: ( 'Concrete1' )
            {
            // InternalEcore2XtextTest.g:883:1: ( 'Concrete1' )
            // InternalEcore2XtextTest.g:884:2: 'Concrete1'
            {
             before(grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1()); 

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
    // $ANTLR end "rule__Concrete1_Impl__Group__1__Impl"


    // $ANTLR start "rule__Concrete1_Impl__Group__2"
    // InternalEcore2XtextTest.g:893:1: rule__Concrete1_Impl__Group__2 : rule__Concrete1_Impl__Group__2__Impl ;
    public final void rule__Concrete1_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:897:1: ( rule__Concrete1_Impl__Group__2__Impl )
            // InternalEcore2XtextTest.g:898:2: rule__Concrete1_Impl__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete1_Impl__Group__2__Impl();

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
    // $ANTLR end "rule__Concrete1_Impl__Group__2"


    // $ANTLR start "rule__Concrete1_Impl__Group__2__Impl"
    // InternalEcore2XtextTest.g:904:1: rule__Concrete1_Impl__Group__2__Impl : ( ( rule__Concrete1_Impl__NameAssignment_2 ) ) ;
    public final void rule__Concrete1_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:908:1: ( ( ( rule__Concrete1_Impl__NameAssignment_2 ) ) )
            // InternalEcore2XtextTest.g:909:1: ( ( rule__Concrete1_Impl__NameAssignment_2 ) )
            {
            // InternalEcore2XtextTest.g:909:1: ( ( rule__Concrete1_Impl__NameAssignment_2 ) )
            // InternalEcore2XtextTest.g:910:2: ( rule__Concrete1_Impl__NameAssignment_2 )
            {
             before(grammarAccess.getConcrete1_ImplAccess().getNameAssignment_2()); 
            // InternalEcore2XtextTest.g:911:2: ( rule__Concrete1_Impl__NameAssignment_2 )
            // InternalEcore2XtextTest.g:911:3: rule__Concrete1_Impl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete1_Impl__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConcrete1_ImplAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__Concrete1_Impl__Group__2__Impl"


    // $ANTLR start "rule__DiamondInheritance__Group__0"
    // InternalEcore2XtextTest.g:920:1: rule__DiamondInheritance__Group__0 : rule__DiamondInheritance__Group__0__Impl rule__DiamondInheritance__Group__1 ;
    public final void rule__DiamondInheritance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:924:1: ( rule__DiamondInheritance__Group__0__Impl rule__DiamondInheritance__Group__1 )
            // InternalEcore2XtextTest.g:925:2: rule__DiamondInheritance__Group__0__Impl rule__DiamondInheritance__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__DiamondInheritance__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__DiamondInheritance__Group__1();

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
    // $ANTLR end "rule__DiamondInheritance__Group__0"


    // $ANTLR start "rule__DiamondInheritance__Group__0__Impl"
    // InternalEcore2XtextTest.g:932:1: rule__DiamondInheritance__Group__0__Impl : ( () ) ;
    public final void rule__DiamondInheritance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:936:1: ( ( () ) )
            // InternalEcore2XtextTest.g:937:1: ( () )
            {
            // InternalEcore2XtextTest.g:937:1: ( () )
            // InternalEcore2XtextTest.g:938:2: ()
            {
             before(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0()); 
            // InternalEcore2XtextTest.g:939:2: ()
            // InternalEcore2XtextTest.g:939:3: 
            {
            }

             after(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DiamondInheritance__Group__0__Impl"


    // $ANTLR start "rule__DiamondInheritance__Group__1"
    // InternalEcore2XtextTest.g:947:1: rule__DiamondInheritance__Group__1 : rule__DiamondInheritance__Group__1__Impl rule__DiamondInheritance__Group__2 ;
    public final void rule__DiamondInheritance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:951:1: ( rule__DiamondInheritance__Group__1__Impl rule__DiamondInheritance__Group__2 )
            // InternalEcore2XtextTest.g:952:2: rule__DiamondInheritance__Group__1__Impl rule__DiamondInheritance__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__DiamondInheritance__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__DiamondInheritance__Group__2();

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
    // $ANTLR end "rule__DiamondInheritance__Group__1"


    // $ANTLR start "rule__DiamondInheritance__Group__1__Impl"
    // InternalEcore2XtextTest.g:959:1: rule__DiamondInheritance__Group__1__Impl : ( 'DiamondInheritance' ) ;
    public final void rule__DiamondInheritance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:963:1: ( ( 'DiamondInheritance' ) )
            // InternalEcore2XtextTest.g:964:1: ( 'DiamondInheritance' )
            {
            // InternalEcore2XtextTest.g:964:1: ( 'DiamondInheritance' )
            // InternalEcore2XtextTest.g:965:2: 'DiamondInheritance'
            {
             before(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1()); 

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
    // $ANTLR end "rule__DiamondInheritance__Group__1__Impl"


    // $ANTLR start "rule__DiamondInheritance__Group__2"
    // InternalEcore2XtextTest.g:974:1: rule__DiamondInheritance__Group__2 : rule__DiamondInheritance__Group__2__Impl ;
    public final void rule__DiamondInheritance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:978:1: ( rule__DiamondInheritance__Group__2__Impl )
            // InternalEcore2XtextTest.g:979:2: rule__DiamondInheritance__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DiamondInheritance__Group__2__Impl();

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
    // $ANTLR end "rule__DiamondInheritance__Group__2"


    // $ANTLR start "rule__DiamondInheritance__Group__2__Impl"
    // InternalEcore2XtextTest.g:985:1: rule__DiamondInheritance__Group__2__Impl : ( ( rule__DiamondInheritance__NameAssignment_2 ) ) ;
    public final void rule__DiamondInheritance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:989:1: ( ( ( rule__DiamondInheritance__NameAssignment_2 ) ) )
            // InternalEcore2XtextTest.g:990:1: ( ( rule__DiamondInheritance__NameAssignment_2 ) )
            {
            // InternalEcore2XtextTest.g:990:1: ( ( rule__DiamondInheritance__NameAssignment_2 ) )
            // InternalEcore2XtextTest.g:991:2: ( rule__DiamondInheritance__NameAssignment_2 )
            {
             before(grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2()); 
            // InternalEcore2XtextTest.g:992:2: ( rule__DiamondInheritance__NameAssignment_2 )
            // InternalEcore2XtextTest.g:992:3: rule__DiamondInheritance__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DiamondInheritance__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__DiamondInheritance__Group__2__Impl"


    // $ANTLR start "rule__Root__NameAssignment_2"
    // InternalEcore2XtextTest.g:1001:1: rule__Root__NameAssignment_2 : ( ruleINT0 ) ;
    public final void rule__Root__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1005:1: ( ( ruleINT0 ) )
            // InternalEcore2XtextTest.g:1006:2: ( ruleINT0 )
            {
            // InternalEcore2XtextTest.g:1006:2: ( ruleINT0 )
            // InternalEcore2XtextTest.g:1007:3: ruleINT0
            {
             before(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleINT0();

            state._fsp--;

             after(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Root__NameAssignment_2"


    // $ANTLR start "rule__Root__ClassesAssignment_4_2"
    // InternalEcore2XtextTest.g:1016:1: rule__Root__ClassesAssignment_4_2 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1020:1: ( ( ruleAbstract ) )
            // InternalEcore2XtextTest.g:1021:2: ( ruleAbstract )
            {
            // InternalEcore2XtextTest.g:1021:2: ( ruleAbstract )
            // InternalEcore2XtextTest.g:1022:3: ruleAbstract
            {
             before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstract();

            state._fsp--;

             after(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 

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
    // $ANTLR end "rule__Root__ClassesAssignment_4_2"


    // $ANTLR start "rule__Root__ClassesAssignment_4_3_1"
    // InternalEcore2XtextTest.g:1031:1: rule__Root__ClassesAssignment_4_3_1 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1035:1: ( ( ruleAbstract ) )
            // InternalEcore2XtextTest.g:1036:2: ( ruleAbstract )
            {
            // InternalEcore2XtextTest.g:1036:2: ( ruleAbstract )
            // InternalEcore2XtextTest.g:1037:3: ruleAbstract
            {
             before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstract();

            state._fsp--;

             after(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 

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
    // $ANTLR end "rule__Root__ClassesAssignment_4_3_1"


    // $ANTLR start "rule__Root__Concrete0Assignment_5_1"
    // InternalEcore2XtextTest.g:1046:1: rule__Root__Concrete0Assignment_5_1 : ( ruleConcrete0 ) ;
    public final void rule__Root__Concrete0Assignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1050:1: ( ( ruleConcrete0 ) )
            // InternalEcore2XtextTest.g:1051:2: ( ruleConcrete0 )
            {
            // InternalEcore2XtextTest.g:1051:2: ( ruleConcrete0 )
            // InternalEcore2XtextTest.g:1052:3: ruleConcrete0
            {
             before(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConcrete0();

            state._fsp--;

             after(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0()); 

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
    // $ANTLR end "rule__Root__Concrete0Assignment_5_1"


    // $ANTLR start "rule__Concrete0_Impl__NameAssignment_2"
    // InternalEcore2XtextTest.g:1061:1: rule__Concrete0_Impl__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Concrete0_Impl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1065:1: ( ( ruleEString ) )
            // InternalEcore2XtextTest.g:1066:2: ( ruleEString )
            {
            // InternalEcore2XtextTest.g:1066:2: ( ruleEString )
            // InternalEcore2XtextTest.g:1067:3: ruleEString
            {
             before(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Concrete0_Impl__NameAssignment_2"


    // $ANTLR start "rule__Concrete1_Impl__NameAssignment_2"
    // InternalEcore2XtextTest.g:1076:1: rule__Concrete1_Impl__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Concrete1_Impl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1080:1: ( ( ruleEString ) )
            // InternalEcore2XtextTest.g:1081:2: ( ruleEString )
            {
            // InternalEcore2XtextTest.g:1081:2: ( ruleEString )
            // InternalEcore2XtextTest.g:1082:3: ruleEString
            {
             before(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Concrete1_Impl__NameAssignment_2"


    // $ANTLR start "rule__DiamondInheritance__NameAssignment_2"
    // InternalEcore2XtextTest.g:1091:1: rule__DiamondInheritance__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__DiamondInheritance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1095:1: ( ( ruleEString ) )
            // InternalEcore2XtextTest.g:1096:2: ( ruleEString )
            {
            // InternalEcore2XtextTest.g:1096:2: ( ruleEString )
            // InternalEcore2XtextTest.g:1097:3: ruleEString
            {
             before(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__DiamondInheritance__NameAssignment_2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000002C000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    }


}
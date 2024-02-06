package org.eclipse.xtext.ui.tests.refactoring.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.refactoring.services.ReferringTestLanguageGrammarAccess;



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
public class InternalReferringTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ref'", "'='", "'.'"
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
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalReferringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReferringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReferringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReferringTestLanguage.g"; }


    	private ReferringTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(ReferringTestLanguageGrammarAccess grammarAccess) {
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
    // InternalReferringTestLanguage.g:58:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:59:1: ( ruleMain EOF )
            // InternalReferringTestLanguage.g:60:1: ruleMain EOF
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
    // InternalReferringTestLanguage.g:67:1: ruleMain : ( ( rule__Main__ReferencedAssignment )* ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:71:2: ( ( ( rule__Main__ReferencedAssignment )* ) )
            // InternalReferringTestLanguage.g:72:2: ( ( rule__Main__ReferencedAssignment )* )
            {
            // InternalReferringTestLanguage.g:72:2: ( ( rule__Main__ReferencedAssignment )* )
            // InternalReferringTestLanguage.g:73:3: ( rule__Main__ReferencedAssignment )*
            {
             before(grammarAccess.getMainAccess().getReferencedAssignment()); 
            // InternalReferringTestLanguage.g:74:3: ( rule__Main__ReferencedAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalReferringTestLanguage.g:74:4: rule__Main__ReferencedAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Main__ReferencedAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getReferencedAssignment()); 

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


    // $ANTLR start "entryRuleAbstractReference"
    // InternalReferringTestLanguage.g:83:1: entryRuleAbstractReference : ruleAbstractReference EOF ;
    public final void entryRuleAbstractReference() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:84:1: ( ruleAbstractReference EOF )
            // InternalReferringTestLanguage.g:85:1: ruleAbstractReference EOF
            {
             before(grammarAccess.getAbstractReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractReference();

            state._fsp--;

             after(grammarAccess.getAbstractReferenceRule()); 
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
    // $ANTLR end "entryRuleAbstractReference"


    // $ANTLR start "ruleAbstractReference"
    // InternalReferringTestLanguage.g:92:1: ruleAbstractReference : ( ( rule__AbstractReference__Alternatives ) ) ;
    public final void ruleAbstractReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:96:2: ( ( ( rule__AbstractReference__Alternatives ) ) )
            // InternalReferringTestLanguage.g:97:2: ( ( rule__AbstractReference__Alternatives ) )
            {
            // InternalReferringTestLanguage.g:97:2: ( ( rule__AbstractReference__Alternatives ) )
            // InternalReferringTestLanguage.g:98:3: ( rule__AbstractReference__Alternatives )
            {
             before(grammarAccess.getAbstractReferenceAccess().getAlternatives()); 
            // InternalReferringTestLanguage.g:99:3: ( rule__AbstractReference__Alternatives )
            // InternalReferringTestLanguage.g:99:4: rule__AbstractReference__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractReference__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractReferenceAccess().getAlternatives()); 

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
    // $ANTLR end "ruleAbstractReference"


    // $ANTLR start "entryRuleReference"
    // InternalReferringTestLanguage.g:108:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:109:1: ( ruleReference EOF )
            // InternalReferringTestLanguage.g:110:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalReferringTestLanguage.g:117:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:121:2: ( ( ( rule__Reference__Group__0 ) ) )
            // InternalReferringTestLanguage.g:122:2: ( ( rule__Reference__Group__0 ) )
            {
            // InternalReferringTestLanguage.g:122:2: ( ( rule__Reference__Group__0 ) )
            // InternalReferringTestLanguage.g:123:3: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // InternalReferringTestLanguage.g:124:3: ( rule__Reference__Group__0 )
            // InternalReferringTestLanguage.g:124:4: rule__Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

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
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleReference2"
    // InternalReferringTestLanguage.g:133:1: entryRuleReference2 : ruleReference2 EOF ;
    public final void entryRuleReference2() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:134:1: ( ruleReference2 EOF )
            // InternalReferringTestLanguage.g:135:1: ruleReference2 EOF
            {
             before(grammarAccess.getReference2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReference2();

            state._fsp--;

             after(grammarAccess.getReference2Rule()); 
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
    // $ANTLR end "entryRuleReference2"


    // $ANTLR start "ruleReference2"
    // InternalReferringTestLanguage.g:142:1: ruleReference2 : ( ( rule__Reference2__Group__0 ) ) ;
    public final void ruleReference2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:146:2: ( ( ( rule__Reference2__Group__0 ) ) )
            // InternalReferringTestLanguage.g:147:2: ( ( rule__Reference2__Group__0 ) )
            {
            // InternalReferringTestLanguage.g:147:2: ( ( rule__Reference2__Group__0 ) )
            // InternalReferringTestLanguage.g:148:3: ( rule__Reference2__Group__0 )
            {
             before(grammarAccess.getReference2Access().getGroup()); 
            // InternalReferringTestLanguage.g:149:3: ( rule__Reference2__Group__0 )
            // InternalReferringTestLanguage.g:149:4: rule__Reference2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReference2Access().getGroup()); 

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
    // $ANTLR end "ruleReference2"


    // $ANTLR start "entryRuleNamed"
    // InternalReferringTestLanguage.g:158:1: entryRuleNamed : ruleNamed EOF ;
    public final void entryRuleNamed() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:159:1: ( ruleNamed EOF )
            // InternalReferringTestLanguage.g:160:1: ruleNamed EOF
            {
             before(grammarAccess.getNamedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNamed();

            state._fsp--;

             after(grammarAccess.getNamedRule()); 
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
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // InternalReferringTestLanguage.g:167:1: ruleNamed : ( ( rule__Named__NameAssignment ) ) ;
    public final void ruleNamed() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:171:2: ( ( ( rule__Named__NameAssignment ) ) )
            // InternalReferringTestLanguage.g:172:2: ( ( rule__Named__NameAssignment ) )
            {
            // InternalReferringTestLanguage.g:172:2: ( ( rule__Named__NameAssignment ) )
            // InternalReferringTestLanguage.g:173:3: ( rule__Named__NameAssignment )
            {
             before(grammarAccess.getNamedAccess().getNameAssignment()); 
            // InternalReferringTestLanguage.g:174:3: ( rule__Named__NameAssignment )
            // InternalReferringTestLanguage.g:174:4: rule__Named__NameAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Named__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getNamedAccess().getNameAssignment()); 

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
    // $ANTLR end "ruleNamed"


    // $ANTLR start "entryRuleFQN"
    // InternalReferringTestLanguage.g:183:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:184:1: ( ruleFQN EOF )
            // InternalReferringTestLanguage.g:185:1: ruleFQN EOF
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
    // InternalReferringTestLanguage.g:192:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:196:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalReferringTestLanguage.g:197:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalReferringTestLanguage.g:197:2: ( ( rule__FQN__Group__0 ) )
            // InternalReferringTestLanguage.g:198:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalReferringTestLanguage.g:199:3: ( rule__FQN__Group__0 )
            // InternalReferringTestLanguage.g:199:4: rule__FQN__Group__0
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


    // $ANTLR start "rule__AbstractReference__Alternatives"
    // InternalReferringTestLanguage.g:207:1: rule__AbstractReference__Alternatives : ( ( ruleReference ) | ( ruleReference2 ) );
    public final void rule__AbstractReference__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:211:1: ( ( ruleReference ) | ( ruleReference2 ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalReferringTestLanguage.g:212:2: ( ruleReference )
                    {
                    // InternalReferringTestLanguage.g:212:2: ( ruleReference )
                    // InternalReferringTestLanguage.g:213:3: ruleReference
                    {
                     before(grammarAccess.getAbstractReferenceAccess().getReferenceParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getAbstractReferenceAccess().getReferenceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalReferringTestLanguage.g:218:2: ( ruleReference2 )
                    {
                    // InternalReferringTestLanguage.g:218:2: ( ruleReference2 )
                    // InternalReferringTestLanguage.g:219:3: ruleReference2
                    {
                     before(grammarAccess.getAbstractReferenceAccess().getReference2ParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReference2();

                    state._fsp--;

                     after(grammarAccess.getAbstractReferenceAccess().getReference2ParserRuleCall_1()); 

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
    // $ANTLR end "rule__AbstractReference__Alternatives"


    // $ANTLR start "rule__Reference__Group__0"
    // InternalReferringTestLanguage.g:228:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:232:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // InternalReferringTestLanguage.g:233:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__1();

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
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // InternalReferringTestLanguage.g:240:1: rule__Reference__Group__0__Impl : ( 'ref' ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:244:1: ( ( 'ref' ) )
            // InternalReferringTestLanguage.g:245:1: ( 'ref' )
            {
            // InternalReferringTestLanguage.g:245:1: ( 'ref' )
            // InternalReferringTestLanguage.g:246:2: 'ref'
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getRefKeyword_0()); 

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
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // InternalReferringTestLanguage.g:255:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:259:1: ( rule__Reference__Group__1__Impl )
            // InternalReferringTestLanguage.g:260:2: rule__Reference__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__1__Impl();

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
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // InternalReferringTestLanguage.g:266:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__ReferencedAssignment_1 ) ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:270:1: ( ( ( rule__Reference__ReferencedAssignment_1 ) ) )
            // InternalReferringTestLanguage.g:271:1: ( ( rule__Reference__ReferencedAssignment_1 ) )
            {
            // InternalReferringTestLanguage.g:271:1: ( ( rule__Reference__ReferencedAssignment_1 ) )
            // InternalReferringTestLanguage.g:272:2: ( rule__Reference__ReferencedAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getReferencedAssignment_1()); 
            // InternalReferringTestLanguage.g:273:2: ( rule__Reference__ReferencedAssignment_1 )
            // InternalReferringTestLanguage.g:273:3: rule__Reference__ReferencedAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__ReferencedAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getReferencedAssignment_1()); 

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
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__Reference2__Group__0"
    // InternalReferringTestLanguage.g:282:1: rule__Reference2__Group__0 : rule__Reference2__Group__0__Impl rule__Reference2__Group__1 ;
    public final void rule__Reference2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:286:1: ( rule__Reference2__Group__0__Impl rule__Reference2__Group__1 )
            // InternalReferringTestLanguage.g:287:2: rule__Reference2__Group__0__Impl rule__Reference2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Reference2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__1();

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
    // $ANTLR end "rule__Reference2__Group__0"


    // $ANTLR start "rule__Reference2__Group__0__Impl"
    // InternalReferringTestLanguage.g:294:1: rule__Reference2__Group__0__Impl : ( ruleNamed ) ;
    public final void rule__Reference2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:298:1: ( ( ruleNamed ) )
            // InternalReferringTestLanguage.g:299:1: ( ruleNamed )
            {
            // InternalReferringTestLanguage.g:299:1: ( ruleNamed )
            // InternalReferringTestLanguage.g:300:2: ruleNamed
            {
             before(grammarAccess.getReference2Access().getNamedParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamed();

            state._fsp--;

             after(grammarAccess.getReference2Access().getNamedParserRuleCall_0()); 

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
    // $ANTLR end "rule__Reference2__Group__0__Impl"


    // $ANTLR start "rule__Reference2__Group__1"
    // InternalReferringTestLanguage.g:309:1: rule__Reference2__Group__1 : rule__Reference2__Group__1__Impl rule__Reference2__Group__2 ;
    public final void rule__Reference2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:313:1: ( rule__Reference2__Group__1__Impl rule__Reference2__Group__2 )
            // InternalReferringTestLanguage.g:314:2: rule__Reference2__Group__1__Impl rule__Reference2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Reference2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__2();

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
    // $ANTLR end "rule__Reference2__Group__1"


    // $ANTLR start "rule__Reference2__Group__1__Impl"
    // InternalReferringTestLanguage.g:321:1: rule__Reference2__Group__1__Impl : ( '=' ) ;
    public final void rule__Reference2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:325:1: ( ( '=' ) )
            // InternalReferringTestLanguage.g:326:1: ( '=' )
            {
            // InternalReferringTestLanguage.g:326:1: ( '=' )
            // InternalReferringTestLanguage.g:327:2: '='
            {
             before(grammarAccess.getReference2Access().getEqualsSignKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReference2Access().getEqualsSignKeyword_1()); 

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
    // $ANTLR end "rule__Reference2__Group__1__Impl"


    // $ANTLR start "rule__Reference2__Group__2"
    // InternalReferringTestLanguage.g:336:1: rule__Reference2__Group__2 : rule__Reference2__Group__2__Impl ;
    public final void rule__Reference2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:340:1: ( rule__Reference2__Group__2__Impl )
            // InternalReferringTestLanguage.g:341:2: rule__Reference2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__2__Impl();

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
    // $ANTLR end "rule__Reference2__Group__2"


    // $ANTLR start "rule__Reference2__Group__2__Impl"
    // InternalReferringTestLanguage.g:347:1: rule__Reference2__Group__2__Impl : ( ( rule__Reference2__ReferencedAssignment_2 ) ) ;
    public final void rule__Reference2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:351:1: ( ( ( rule__Reference2__ReferencedAssignment_2 ) ) )
            // InternalReferringTestLanguage.g:352:1: ( ( rule__Reference2__ReferencedAssignment_2 ) )
            {
            // InternalReferringTestLanguage.g:352:1: ( ( rule__Reference2__ReferencedAssignment_2 ) )
            // InternalReferringTestLanguage.g:353:2: ( rule__Reference2__ReferencedAssignment_2 )
            {
             before(grammarAccess.getReference2Access().getReferencedAssignment_2()); 
            // InternalReferringTestLanguage.g:354:2: ( rule__Reference2__ReferencedAssignment_2 )
            // InternalReferringTestLanguage.g:354:3: rule__Reference2__ReferencedAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__ReferencedAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getReference2Access().getReferencedAssignment_2()); 

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
    // $ANTLR end "rule__Reference2__Group__2__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalReferringTestLanguage.g:363:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:367:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalReferringTestLanguage.g:368:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
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
    // InternalReferringTestLanguage.g:375:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:379:1: ( ( RULE_ID ) )
            // InternalReferringTestLanguage.g:380:1: ( RULE_ID )
            {
            // InternalReferringTestLanguage.g:380:1: ( RULE_ID )
            // InternalReferringTestLanguage.g:381:2: RULE_ID
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
    // InternalReferringTestLanguage.g:390:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:394:1: ( rule__FQN__Group__1__Impl )
            // InternalReferringTestLanguage.g:395:2: rule__FQN__Group__1__Impl
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
    // InternalReferringTestLanguage.g:401:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:405:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalReferringTestLanguage.g:406:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalReferringTestLanguage.g:406:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalReferringTestLanguage.g:407:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalReferringTestLanguage.g:408:2: ( rule__FQN__Group_1__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalReferringTestLanguage.g:408:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // InternalReferringTestLanguage.g:417:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:421:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalReferringTestLanguage.g:422:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
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
    // InternalReferringTestLanguage.g:429:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:433:1: ( ( '.' ) )
            // InternalReferringTestLanguage.g:434:1: ( '.' )
            {
            // InternalReferringTestLanguage.g:434:1: ( '.' )
            // InternalReferringTestLanguage.g:435:2: '.'
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
    // InternalReferringTestLanguage.g:444:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:448:1: ( rule__FQN__Group_1__1__Impl )
            // InternalReferringTestLanguage.g:449:2: rule__FQN__Group_1__1__Impl
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
    // InternalReferringTestLanguage.g:455:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:459:1: ( ( RULE_ID ) )
            // InternalReferringTestLanguage.g:460:1: ( RULE_ID )
            {
            // InternalReferringTestLanguage.g:460:1: ( RULE_ID )
            // InternalReferringTestLanguage.g:461:2: RULE_ID
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


    // $ANTLR start "rule__Main__ReferencedAssignment"
    // InternalReferringTestLanguage.g:471:1: rule__Main__ReferencedAssignment : ( ruleAbstractReference ) ;
    public final void rule__Main__ReferencedAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:475:1: ( ( ruleAbstractReference ) )
            // InternalReferringTestLanguage.g:476:2: ( ruleAbstractReference )
            {
            // InternalReferringTestLanguage.g:476:2: ( ruleAbstractReference )
            // InternalReferringTestLanguage.g:477:3: ruleAbstractReference
            {
             before(grammarAccess.getMainAccess().getReferencedAbstractReferenceParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractReference();

            state._fsp--;

             after(grammarAccess.getMainAccess().getReferencedAbstractReferenceParserRuleCall_0()); 

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
    // $ANTLR end "rule__Main__ReferencedAssignment"


    // $ANTLR start "rule__Reference__ReferencedAssignment_1"
    // InternalReferringTestLanguage.g:486:1: rule__Reference__ReferencedAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Reference__ReferencedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:490:1: ( ( ( ruleFQN ) ) )
            // InternalReferringTestLanguage.g:491:2: ( ( ruleFQN ) )
            {
            // InternalReferringTestLanguage.g:491:2: ( ( ruleFQN ) )
            // InternalReferringTestLanguage.g:492:3: ( ruleFQN )
            {
             before(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0()); 
            // InternalReferringTestLanguage.g:493:3: ( ruleFQN )
            // InternalReferringTestLanguage.g:494:4: ruleFQN
            {
             before(grammarAccess.getReferenceAccess().getReferencedEObjectFQNParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getReferencedEObjectFQNParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0()); 

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
    // $ANTLR end "rule__Reference__ReferencedAssignment_1"


    // $ANTLR start "rule__Reference2__ReferencedAssignment_2"
    // InternalReferringTestLanguage.g:505:1: rule__Reference2__ReferencedAssignment_2 : ( ( ruleFQN ) ) ;
    public final void rule__Reference2__ReferencedAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:509:1: ( ( ( ruleFQN ) ) )
            // InternalReferringTestLanguage.g:510:2: ( ( ruleFQN ) )
            {
            // InternalReferringTestLanguage.g:510:2: ( ( ruleFQN ) )
            // InternalReferringTestLanguage.g:511:3: ( ruleFQN )
            {
             before(grammarAccess.getReference2Access().getReferencedEObjectCrossReference_2_0()); 
            // InternalReferringTestLanguage.g:512:3: ( ruleFQN )
            // InternalReferringTestLanguage.g:513:4: ruleFQN
            {
             before(grammarAccess.getReference2Access().getReferencedEObjectFQNParserRuleCall_2_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReference2Access().getReferencedEObjectFQNParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getReference2Access().getReferencedEObjectCrossReference_2_0()); 

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
    // $ANTLR end "rule__Reference2__ReferencedAssignment_2"


    // $ANTLR start "rule__Named__NameAssignment"
    // InternalReferringTestLanguage.g:524:1: rule__Named__NameAssignment : ( RULE_ID ) ;
    public final void rule__Named__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:528:1: ( ( RULE_ID ) )
            // InternalReferringTestLanguage.g:529:2: ( RULE_ID )
            {
            // InternalReferringTestLanguage.g:529:2: ( RULE_ID )
            // InternalReferringTestLanguage.g:530:3: RULE_ID
            {
             before(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__Named__NameAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002002L});
    }


}
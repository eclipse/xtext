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
import org.eclipse.xtext.ui.tests.refactoring.services.RefactoringTestLanguageGrammarAccess;



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
public class InternalRefactoringTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'{'", "'}'", "'ref'", "'.'", "'.*'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalRefactoringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRefactoringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRefactoringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRefactoringTestLanguage.g"; }


    	private RefactoringTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(RefactoringTestLanguageGrammarAccess grammarAccess) {
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
    // InternalRefactoringTestLanguage.g:58:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:59:1: ( ruleMain EOF )
            // InternalRefactoringTestLanguage.g:60:1: ruleMain EOF
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
    // InternalRefactoringTestLanguage.g:67:1: ruleMain : ( ( rule__Main__ElementsAssignment )* ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:71:2: ( ( ( rule__Main__ElementsAssignment )* ) )
            // InternalRefactoringTestLanguage.g:72:2: ( ( rule__Main__ElementsAssignment )* )
            {
            // InternalRefactoringTestLanguage.g:72:2: ( ( rule__Main__ElementsAssignment )* )
            // InternalRefactoringTestLanguage.g:73:3: ( rule__Main__ElementsAssignment )*
            {
             before(grammarAccess.getMainAccess().getElementsAssignment()); 
            // InternalRefactoringTestLanguage.g:74:3: ( rule__Main__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:74:4: rule__Main__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Main__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getElementsAssignment()); 

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


    // $ANTLR start "entryRuleAbstractElement"
    // InternalRefactoringTestLanguage.g:83:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:84:1: ( ruleAbstractElement EOF )
            // InternalRefactoringTestLanguage.g:85:1: ruleAbstractElement EOF
            {
             before(grammarAccess.getAbstractElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getAbstractElementRule()); 
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
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalRefactoringTestLanguage.g:92:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:96:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // InternalRefactoringTestLanguage.g:97:2: ( ( rule__AbstractElement__Alternatives ) )
            {
            // InternalRefactoringTestLanguage.g:97:2: ( ( rule__AbstractElement__Alternatives ) )
            // InternalRefactoringTestLanguage.g:98:3: ( rule__AbstractElement__Alternatives )
            {
             before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            // InternalRefactoringTestLanguage.g:99:3: ( rule__AbstractElement__Alternatives )
            // InternalRefactoringTestLanguage.g:99:4: rule__AbstractElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractElementAccess().getAlternatives()); 

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
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleImport"
    // InternalRefactoringTestLanguage.g:108:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:109:1: ( ruleImport EOF )
            // InternalRefactoringTestLanguage.g:110:1: ruleImport EOF
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
    // InternalRefactoringTestLanguage.g:117:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:121:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:122:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:122:2: ( ( rule__Import__Group__0 ) )
            // InternalRefactoringTestLanguage.g:123:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:124:3: ( rule__Import__Group__0 )
            // InternalRefactoringTestLanguage.g:124:4: rule__Import__Group__0
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


    // $ANTLR start "entryRuleElement"
    // InternalRefactoringTestLanguage.g:133:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:134:1: ( ruleElement EOF )
            // InternalRefactoringTestLanguage.g:135:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalRefactoringTestLanguage.g:142:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:146:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:147:2: ( ( rule__Element__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:147:2: ( ( rule__Element__Group__0 ) )
            // InternalRefactoringTestLanguage.g:148:3: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:149:3: ( rule__Element__Group__0 )
            // InternalRefactoringTestLanguage.g:149:4: rule__Element__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getGroup()); 

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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleFQN"
    // InternalRefactoringTestLanguage.g:158:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:159:1: ( ruleFQN EOF )
            // InternalRefactoringTestLanguage.g:160:1: ruleFQN EOF
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
    // InternalRefactoringTestLanguage.g:167:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:171:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:172:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:172:2: ( ( rule__FQN__Group__0 ) )
            // InternalRefactoringTestLanguage.g:173:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:174:3: ( rule__FQN__Group__0 )
            // InternalRefactoringTestLanguage.g:174:4: rule__FQN__Group__0
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


    // $ANTLR start "entryRuleFQNWithWC"
    // InternalRefactoringTestLanguage.g:183:1: entryRuleFQNWithWC : ruleFQNWithWC EOF ;
    public final void entryRuleFQNWithWC() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:184:1: ( ruleFQNWithWC EOF )
            // InternalRefactoringTestLanguage.g:185:1: ruleFQNWithWC EOF
            {
             before(grammarAccess.getFQNWithWCRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQNWithWC();

            state._fsp--;

             after(grammarAccess.getFQNWithWCRule()); 
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
    // $ANTLR end "entryRuleFQNWithWC"


    // $ANTLR start "ruleFQNWithWC"
    // InternalRefactoringTestLanguage.g:192:1: ruleFQNWithWC : ( ( rule__FQNWithWC__Group__0 ) ) ;
    public final void ruleFQNWithWC() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:196:2: ( ( ( rule__FQNWithWC__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:197:2: ( ( rule__FQNWithWC__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:197:2: ( ( rule__FQNWithWC__Group__0 ) )
            // InternalRefactoringTestLanguage.g:198:3: ( rule__FQNWithWC__Group__0 )
            {
             before(grammarAccess.getFQNWithWCAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:199:3: ( rule__FQNWithWC__Group__0 )
            // InternalRefactoringTestLanguage.g:199:4: rule__FQNWithWC__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQNWithWC__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQNWithWCAccess().getGroup()); 

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
    // $ANTLR end "ruleFQNWithWC"


    // $ANTLR start "rule__AbstractElement__Alternatives"
    // InternalRefactoringTestLanguage.g:207:1: rule__AbstractElement__Alternatives : ( ( ruleElement ) | ( ruleImport ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:211:1: ( ( ruleElement ) | ( ruleImport ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==11) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalRefactoringTestLanguage.g:212:2: ( ruleElement )
                    {
                    // InternalRefactoringTestLanguage.g:212:2: ( ruleElement )
                    // InternalRefactoringTestLanguage.g:213:3: ruleElement
                    {
                     before(grammarAccess.getAbstractElementAccess().getElementParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleElement();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getElementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRefactoringTestLanguage.g:218:2: ( ruleImport )
                    {
                    // InternalRefactoringTestLanguage.g:218:2: ( ruleImport )
                    // InternalRefactoringTestLanguage.g:219:3: ruleImport
                    {
                     before(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_1()); 

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
    // $ANTLR end "rule__AbstractElement__Alternatives"


    // $ANTLR start "rule__Element__Alternatives_1_1"
    // InternalRefactoringTestLanguage.g:228:1: rule__Element__Alternatives_1_1 : ( ( ( rule__Element__ContainedAssignment_1_1_0 ) ) | ( ( rule__Element__Group_1_1_1__0 ) ) );
    public final void rule__Element__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:232:1: ( ( ( rule__Element__ContainedAssignment_1_1_0 ) ) | ( ( rule__Element__Group_1_1_1__0 ) ) )
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
                    // InternalRefactoringTestLanguage.g:233:2: ( ( rule__Element__ContainedAssignment_1_1_0 ) )
                    {
                    // InternalRefactoringTestLanguage.g:233:2: ( ( rule__Element__ContainedAssignment_1_1_0 ) )
                    // InternalRefactoringTestLanguage.g:234:3: ( rule__Element__ContainedAssignment_1_1_0 )
                    {
                     before(grammarAccess.getElementAccess().getContainedAssignment_1_1_0()); 
                    // InternalRefactoringTestLanguage.g:235:3: ( rule__Element__ContainedAssignment_1_1_0 )
                    // InternalRefactoringTestLanguage.g:235:4: rule__Element__ContainedAssignment_1_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Element__ContainedAssignment_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getElementAccess().getContainedAssignment_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRefactoringTestLanguage.g:239:2: ( ( rule__Element__Group_1_1_1__0 ) )
                    {
                    // InternalRefactoringTestLanguage.g:239:2: ( ( rule__Element__Group_1_1_1__0 ) )
                    // InternalRefactoringTestLanguage.g:240:3: ( rule__Element__Group_1_1_1__0 )
                    {
                     before(grammarAccess.getElementAccess().getGroup_1_1_1()); 
                    // InternalRefactoringTestLanguage.g:241:3: ( rule__Element__Group_1_1_1__0 )
                    // InternalRefactoringTestLanguage.g:241:4: rule__Element__Group_1_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Element__Group_1_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getElementAccess().getGroup_1_1_1()); 

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
    // $ANTLR end "rule__Element__Alternatives_1_1"


    // $ANTLR start "rule__Import__Group__0"
    // InternalRefactoringTestLanguage.g:249:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:253:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalRefactoringTestLanguage.g:254:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
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
    // InternalRefactoringTestLanguage.g:261:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:265:1: ( ( 'import' ) )
            // InternalRefactoringTestLanguage.g:266:1: ( 'import' )
            {
            // InternalRefactoringTestLanguage.g:266:1: ( 'import' )
            // InternalRefactoringTestLanguage.g:267:2: 'import'
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
    // InternalRefactoringTestLanguage.g:276:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:280:1: ( rule__Import__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:281:2: rule__Import__Group__1__Impl
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
    // InternalRefactoringTestLanguage.g:287:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:291:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalRefactoringTestLanguage.g:292:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalRefactoringTestLanguage.g:292:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalRefactoringTestLanguage.g:293:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalRefactoringTestLanguage.g:294:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalRefactoringTestLanguage.g:294:3: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 

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


    // $ANTLR start "rule__Element__Group__0"
    // InternalRefactoringTestLanguage.g:303:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:307:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalRefactoringTestLanguage.g:308:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Element__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group__1();

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
    // $ANTLR end "rule__Element__Group__0"


    // $ANTLR start "rule__Element__Group__0__Impl"
    // InternalRefactoringTestLanguage.g:315:1: rule__Element__Group__0__Impl : ( ( rule__Element__NameAssignment_0 ) ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:319:1: ( ( ( rule__Element__NameAssignment_0 ) ) )
            // InternalRefactoringTestLanguage.g:320:1: ( ( rule__Element__NameAssignment_0 ) )
            {
            // InternalRefactoringTestLanguage.g:320:1: ( ( rule__Element__NameAssignment_0 ) )
            // InternalRefactoringTestLanguage.g:321:2: ( rule__Element__NameAssignment_0 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_0()); 
            // InternalRefactoringTestLanguage.g:322:2: ( rule__Element__NameAssignment_0 )
            // InternalRefactoringTestLanguage.g:322:3: rule__Element__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getNameAssignment_0()); 

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
    // $ANTLR end "rule__Element__Group__0__Impl"


    // $ANTLR start "rule__Element__Group__1"
    // InternalRefactoringTestLanguage.g:330:1: rule__Element__Group__1 : rule__Element__Group__1__Impl ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:334:1: ( rule__Element__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:335:2: rule__Element__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group__1__Impl();

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
    // $ANTLR end "rule__Element__Group__1"


    // $ANTLR start "rule__Element__Group__1__Impl"
    // InternalRefactoringTestLanguage.g:341:1: rule__Element__Group__1__Impl : ( ( rule__Element__Group_1__0 )? ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:345:1: ( ( ( rule__Element__Group_1__0 )? ) )
            // InternalRefactoringTestLanguage.g:346:1: ( ( rule__Element__Group_1__0 )? )
            {
            // InternalRefactoringTestLanguage.g:346:1: ( ( rule__Element__Group_1__0 )? )
            // InternalRefactoringTestLanguage.g:347:2: ( rule__Element__Group_1__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_1()); 
            // InternalRefactoringTestLanguage.g:348:2: ( rule__Element__Group_1__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRefactoringTestLanguage.g:348:3: rule__Element__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Element__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Element__Group__1__Impl"


    // $ANTLR start "rule__Element__Group_1__0"
    // InternalRefactoringTestLanguage.g:357:1: rule__Element__Group_1__0 : rule__Element__Group_1__0__Impl rule__Element__Group_1__1 ;
    public final void rule__Element__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:361:1: ( rule__Element__Group_1__0__Impl rule__Element__Group_1__1 )
            // InternalRefactoringTestLanguage.g:362:2: rule__Element__Group_1__0__Impl rule__Element__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Element__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1__1();

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
    // $ANTLR end "rule__Element__Group_1__0"


    // $ANTLR start "rule__Element__Group_1__0__Impl"
    // InternalRefactoringTestLanguage.g:369:1: rule__Element__Group_1__0__Impl : ( '{' ) ;
    public final void rule__Element__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:373:1: ( ( '{' ) )
            // InternalRefactoringTestLanguage.g:374:1: ( '{' )
            {
            // InternalRefactoringTestLanguage.g:374:1: ( '{' )
            // InternalRefactoringTestLanguage.g:375:2: '{'
            {
             before(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1_0()); 

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
    // $ANTLR end "rule__Element__Group_1__0__Impl"


    // $ANTLR start "rule__Element__Group_1__1"
    // InternalRefactoringTestLanguage.g:384:1: rule__Element__Group_1__1 : rule__Element__Group_1__1__Impl rule__Element__Group_1__2 ;
    public final void rule__Element__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:388:1: ( rule__Element__Group_1__1__Impl rule__Element__Group_1__2 )
            // InternalRefactoringTestLanguage.g:389:2: rule__Element__Group_1__1__Impl rule__Element__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Element__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1__2();

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
    // $ANTLR end "rule__Element__Group_1__1"


    // $ANTLR start "rule__Element__Group_1__1__Impl"
    // InternalRefactoringTestLanguage.g:396:1: rule__Element__Group_1__1__Impl : ( ( rule__Element__Alternatives_1_1 )* ) ;
    public final void rule__Element__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:400:1: ( ( ( rule__Element__Alternatives_1_1 )* ) )
            // InternalRefactoringTestLanguage.g:401:1: ( ( rule__Element__Alternatives_1_1 )* )
            {
            // InternalRefactoringTestLanguage.g:401:1: ( ( rule__Element__Alternatives_1_1 )* )
            // InternalRefactoringTestLanguage.g:402:2: ( rule__Element__Alternatives_1_1 )*
            {
             before(grammarAccess.getElementAccess().getAlternatives_1_1()); 
            // InternalRefactoringTestLanguage.g:403:2: ( rule__Element__Alternatives_1_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:403:3: rule__Element__Alternatives_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Element__Alternatives_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getAlternatives_1_1()); 

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
    // $ANTLR end "rule__Element__Group_1__1__Impl"


    // $ANTLR start "rule__Element__Group_1__2"
    // InternalRefactoringTestLanguage.g:411:1: rule__Element__Group_1__2 : rule__Element__Group_1__2__Impl ;
    public final void rule__Element__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:415:1: ( rule__Element__Group_1__2__Impl )
            // InternalRefactoringTestLanguage.g:416:2: rule__Element__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1__2__Impl();

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
    // $ANTLR end "rule__Element__Group_1__2"


    // $ANTLR start "rule__Element__Group_1__2__Impl"
    // InternalRefactoringTestLanguage.g:422:1: rule__Element__Group_1__2__Impl : ( '}' ) ;
    public final void rule__Element__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:426:1: ( ( '}' ) )
            // InternalRefactoringTestLanguage.g:427:1: ( '}' )
            {
            // InternalRefactoringTestLanguage.g:427:1: ( '}' )
            // InternalRefactoringTestLanguage.g:428:2: '}'
            {
             before(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_1_2()); 

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
    // $ANTLR end "rule__Element__Group_1__2__Impl"


    // $ANTLR start "rule__Element__Group_1_1_1__0"
    // InternalRefactoringTestLanguage.g:438:1: rule__Element__Group_1_1_1__0 : rule__Element__Group_1_1_1__0__Impl rule__Element__Group_1_1_1__1 ;
    public final void rule__Element__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:442:1: ( rule__Element__Group_1_1_1__0__Impl rule__Element__Group_1_1_1__1 )
            // InternalRefactoringTestLanguage.g:443:2: rule__Element__Group_1_1_1__0__Impl rule__Element__Group_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Element__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1_1_1__1();

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
    // $ANTLR end "rule__Element__Group_1_1_1__0"


    // $ANTLR start "rule__Element__Group_1_1_1__0__Impl"
    // InternalRefactoringTestLanguage.g:450:1: rule__Element__Group_1_1_1__0__Impl : ( 'ref' ) ;
    public final void rule__Element__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:454:1: ( ( 'ref' ) )
            // InternalRefactoringTestLanguage.g:455:1: ( 'ref' )
            {
            // InternalRefactoringTestLanguage.g:455:1: ( 'ref' )
            // InternalRefactoringTestLanguage.g:456:2: 'ref'
            {
             before(grammarAccess.getElementAccess().getRefKeyword_1_1_1_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRefKeyword_1_1_1_0()); 

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
    // $ANTLR end "rule__Element__Group_1_1_1__0__Impl"


    // $ANTLR start "rule__Element__Group_1_1_1__1"
    // InternalRefactoringTestLanguage.g:465:1: rule__Element__Group_1_1_1__1 : rule__Element__Group_1_1_1__1__Impl ;
    public final void rule__Element__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:469:1: ( rule__Element__Group_1_1_1__1__Impl )
            // InternalRefactoringTestLanguage.g:470:2: rule__Element__Group_1_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1_1_1__1__Impl();

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
    // $ANTLR end "rule__Element__Group_1_1_1__1"


    // $ANTLR start "rule__Element__Group_1_1_1__1__Impl"
    // InternalRefactoringTestLanguage.g:476:1: rule__Element__Group_1_1_1__1__Impl : ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) ) ;
    public final void rule__Element__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:480:1: ( ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) ) )
            // InternalRefactoringTestLanguage.g:481:1: ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) )
            {
            // InternalRefactoringTestLanguage.g:481:1: ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) )
            // InternalRefactoringTestLanguage.g:482:2: ( rule__Element__ReferencedAssignment_1_1_1_1 )
            {
             before(grammarAccess.getElementAccess().getReferencedAssignment_1_1_1_1()); 
            // InternalRefactoringTestLanguage.g:483:2: ( rule__Element__ReferencedAssignment_1_1_1_1 )
            // InternalRefactoringTestLanguage.g:483:3: rule__Element__ReferencedAssignment_1_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__ReferencedAssignment_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getReferencedAssignment_1_1_1_1()); 

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
    // $ANTLR end "rule__Element__Group_1_1_1__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalRefactoringTestLanguage.g:492:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:496:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalRefactoringTestLanguage.g:497:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
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
    // InternalRefactoringTestLanguage.g:504:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:508:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:509:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:509:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:510:2: RULE_ID
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
    // InternalRefactoringTestLanguage.g:519:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:523:1: ( rule__FQN__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:524:2: rule__FQN__Group__1__Impl
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
    // InternalRefactoringTestLanguage.g:530:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:534:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalRefactoringTestLanguage.g:535:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalRefactoringTestLanguage.g:535:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalRefactoringTestLanguage.g:536:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalRefactoringTestLanguage.g:537:2: ( rule__FQN__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:537:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // InternalRefactoringTestLanguage.g:546:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:550:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalRefactoringTestLanguage.g:551:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalRefactoringTestLanguage.g:558:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:562:1: ( ( '.' ) )
            // InternalRefactoringTestLanguage.g:563:1: ( '.' )
            {
            // InternalRefactoringTestLanguage.g:563:1: ( '.' )
            // InternalRefactoringTestLanguage.g:564:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
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
    // InternalRefactoringTestLanguage.g:573:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:577:1: ( rule__FQN__Group_1__1__Impl )
            // InternalRefactoringTestLanguage.g:578:2: rule__FQN__Group_1__1__Impl
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
    // InternalRefactoringTestLanguage.g:584:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:588:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:589:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:589:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:590:2: RULE_ID
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


    // $ANTLR start "rule__FQNWithWC__Group__0"
    // InternalRefactoringTestLanguage.g:600:1: rule__FQNWithWC__Group__0 : rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1 ;
    public final void rule__FQNWithWC__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:604:1: ( rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1 )
            // InternalRefactoringTestLanguage.g:605:2: rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__FQNWithWC__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQNWithWC__Group__1();

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
    // $ANTLR end "rule__FQNWithWC__Group__0"


    // $ANTLR start "rule__FQNWithWC__Group__0__Impl"
    // InternalRefactoringTestLanguage.g:612:1: rule__FQNWithWC__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__FQNWithWC__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:616:1: ( ( ruleFQN ) )
            // InternalRefactoringTestLanguage.g:617:1: ( ruleFQN )
            {
            // InternalRefactoringTestLanguage.g:617:1: ( ruleFQN )
            // InternalRefactoringTestLanguage.g:618:2: ruleFQN
            {
             before(grammarAccess.getFQNWithWCAccess().getFQNParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNWithWCAccess().getFQNParserRuleCall_0()); 

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
    // $ANTLR end "rule__FQNWithWC__Group__0__Impl"


    // $ANTLR start "rule__FQNWithWC__Group__1"
    // InternalRefactoringTestLanguage.g:627:1: rule__FQNWithWC__Group__1 : rule__FQNWithWC__Group__1__Impl ;
    public final void rule__FQNWithWC__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:631:1: ( rule__FQNWithWC__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:632:2: rule__FQNWithWC__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQNWithWC__Group__1__Impl();

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
    // $ANTLR end "rule__FQNWithWC__Group__1"


    // $ANTLR start "rule__FQNWithWC__Group__1__Impl"
    // InternalRefactoringTestLanguage.g:638:1: rule__FQNWithWC__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__FQNWithWC__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:642:1: ( ( ( '.*' )? ) )
            // InternalRefactoringTestLanguage.g:643:1: ( ( '.*' )? )
            {
            // InternalRefactoringTestLanguage.g:643:1: ( ( '.*' )? )
            // InternalRefactoringTestLanguage.g:644:2: ( '.*' )?
            {
             before(grammarAccess.getFQNWithWCAccess().getFullStopAsteriskKeyword_1()); 
            // InternalRefactoringTestLanguage.g:645:2: ( '.*' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalRefactoringTestLanguage.g:645:3: '.*'
                    {
                    match(input,16,FollowSets000.FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getFQNWithWCAccess().getFullStopAsteriskKeyword_1()); 

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
    // $ANTLR end "rule__FQNWithWC__Group__1__Impl"


    // $ANTLR start "rule__Main__ElementsAssignment"
    // InternalRefactoringTestLanguage.g:654:1: rule__Main__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__Main__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:658:1: ( ( ruleAbstractElement ) )
            // InternalRefactoringTestLanguage.g:659:2: ( ruleAbstractElement )
            {
            // InternalRefactoringTestLanguage.g:659:2: ( ruleAbstractElement )
            // InternalRefactoringTestLanguage.g:660:3: ruleAbstractElement
            {
             before(grammarAccess.getMainAccess().getElementsAbstractElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getMainAccess().getElementsAbstractElementParserRuleCall_0()); 

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
    // $ANTLR end "rule__Main__ElementsAssignment"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // InternalRefactoringTestLanguage.g:669:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleFQNWithWC ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:673:1: ( ( ruleFQNWithWC ) )
            // InternalRefactoringTestLanguage.g:674:2: ( ruleFQNWithWC )
            {
            // InternalRefactoringTestLanguage.g:674:2: ( ruleFQNWithWC )
            // InternalRefactoringTestLanguage.g:675:3: ruleFQNWithWC
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceFQNWithWCParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQNWithWC();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceFQNWithWCParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__Element__NameAssignment_0"
    // InternalRefactoringTestLanguage.g:684:1: rule__Element__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:688:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:689:2: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:689:2: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:690:3: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__Element__NameAssignment_0"


    // $ANTLR start "rule__Element__ContainedAssignment_1_1_0"
    // InternalRefactoringTestLanguage.g:699:1: rule__Element__ContainedAssignment_1_1_0 : ( ruleElement ) ;
    public final void rule__Element__ContainedAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:703:1: ( ( ruleElement ) )
            // InternalRefactoringTestLanguage.g:704:2: ( ruleElement )
            {
            // InternalRefactoringTestLanguage.g:704:2: ( ruleElement )
            // InternalRefactoringTestLanguage.g:705:3: ruleElement
            {
             before(grammarAccess.getElementAccess().getContainedElementParserRuleCall_1_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementAccess().getContainedElementParserRuleCall_1_1_0_0()); 

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
    // $ANTLR end "rule__Element__ContainedAssignment_1_1_0"


    // $ANTLR start "rule__Element__ReferencedAssignment_1_1_1_1"
    // InternalRefactoringTestLanguage.g:714:1: rule__Element__ReferencedAssignment_1_1_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__Element__ReferencedAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:718:1: ( ( ( ruleFQN ) ) )
            // InternalRefactoringTestLanguage.g:719:2: ( ( ruleFQN ) )
            {
            // InternalRefactoringTestLanguage.g:719:2: ( ( ruleFQN ) )
            // InternalRefactoringTestLanguage.g:720:3: ( ruleFQN )
            {
             before(grammarAccess.getElementAccess().getReferencedElementCrossReference_1_1_1_1_0()); 
            // InternalRefactoringTestLanguage.g:721:3: ( ruleFQN )
            // InternalRefactoringTestLanguage.g:722:4: ruleFQN
            {
             before(grammarAccess.getElementAccess().getReferencedElementFQNParserRuleCall_1_1_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getElementAccess().getReferencedElementFQNParserRuleCall_1_1_1_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getReferencedElementCrossReference_1_1_1_1_0()); 

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
    // $ANTLR end "rule__Element__ReferencedAssignment_1_1_1_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    }


}
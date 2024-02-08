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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug288734TestLanguageGrammarAccess;



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
public class InternalBug288734TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'constant'", "'string'", "'integer'", "'boolean'", "'@desc'"
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


        public InternalBug288734TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug288734TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug288734TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug288734TestLanguage.g"; }


    	private Bug288734TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug288734TestLanguageGrammarAccess grammarAccess) {
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
    // InternalBug288734TestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:59:1: ( ruleModel EOF )
            // InternalBug288734TestLanguage.g:60:1: ruleModel EOF
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
    // InternalBug288734TestLanguage.g:67:1: ruleModel : ( ( rule__Model__ConstantsAssignment ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:71:2: ( ( ( rule__Model__ConstantsAssignment ) ) )
            // InternalBug288734TestLanguage.g:72:2: ( ( rule__Model__ConstantsAssignment ) )
            {
            // InternalBug288734TestLanguage.g:72:2: ( ( rule__Model__ConstantsAssignment ) )
            // InternalBug288734TestLanguage.g:73:3: ( rule__Model__ConstantsAssignment )
            {
             before(grammarAccess.getModelAccess().getConstantsAssignment()); 
            // InternalBug288734TestLanguage.g:74:3: ( rule__Model__ConstantsAssignment )
            // InternalBug288734TestLanguage.g:74:4: rule__Model__ConstantsAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__ConstantsAssignment();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getConstantsAssignment()); 

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


    // $ANTLR start "entryRuleTConstant"
    // InternalBug288734TestLanguage.g:83:1: entryRuleTConstant : ruleTConstant EOF ;
    public final void entryRuleTConstant() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:84:1: ( ruleTConstant EOF )
            // InternalBug288734TestLanguage.g:85:1: ruleTConstant EOF
            {
             before(grammarAccess.getTConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTConstant();

            state._fsp--;

             after(grammarAccess.getTConstantRule()); 
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
    // $ANTLR end "entryRuleTConstant"


    // $ANTLR start "ruleTConstant"
    // InternalBug288734TestLanguage.g:92:1: ruleTConstant : ( ( rule__TConstant__Alternatives ) ) ;
    public final void ruleTConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:96:2: ( ( ( rule__TConstant__Alternatives ) ) )
            // InternalBug288734TestLanguage.g:97:2: ( ( rule__TConstant__Alternatives ) )
            {
            // InternalBug288734TestLanguage.g:97:2: ( ( rule__TConstant__Alternatives ) )
            // InternalBug288734TestLanguage.g:98:3: ( rule__TConstant__Alternatives )
            {
             before(grammarAccess.getTConstantAccess().getAlternatives()); 
            // InternalBug288734TestLanguage.g:99:3: ( rule__TConstant__Alternatives )
            // InternalBug288734TestLanguage.g:99:4: rule__TConstant__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TConstant__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTConstantAccess().getAlternatives()); 

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
    // $ANTLR end "ruleTConstant"


    // $ANTLR start "entryRuleTStringConstant"
    // InternalBug288734TestLanguage.g:108:1: entryRuleTStringConstant : ruleTStringConstant EOF ;
    public final void entryRuleTStringConstant() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:109:1: ( ruleTStringConstant EOF )
            // InternalBug288734TestLanguage.g:110:1: ruleTStringConstant EOF
            {
             before(grammarAccess.getTStringConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTStringConstant();

            state._fsp--;

             after(grammarAccess.getTStringConstantRule()); 
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
    // $ANTLR end "entryRuleTStringConstant"


    // $ANTLR start "ruleTStringConstant"
    // InternalBug288734TestLanguage.g:117:1: ruleTStringConstant : ( ( rule__TStringConstant__Group__0 ) ) ;
    public final void ruleTStringConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:121:2: ( ( ( rule__TStringConstant__Group__0 ) ) )
            // InternalBug288734TestLanguage.g:122:2: ( ( rule__TStringConstant__Group__0 ) )
            {
            // InternalBug288734TestLanguage.g:122:2: ( ( rule__TStringConstant__Group__0 ) )
            // InternalBug288734TestLanguage.g:123:3: ( rule__TStringConstant__Group__0 )
            {
             before(grammarAccess.getTStringConstantAccess().getGroup()); 
            // InternalBug288734TestLanguage.g:124:3: ( rule__TStringConstant__Group__0 )
            // InternalBug288734TestLanguage.g:124:4: rule__TStringConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTStringConstantAccess().getGroup()); 

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
    // $ANTLR end "ruleTStringConstant"


    // $ANTLR start "entryRuleTIntegerConstant"
    // InternalBug288734TestLanguage.g:133:1: entryRuleTIntegerConstant : ruleTIntegerConstant EOF ;
    public final void entryRuleTIntegerConstant() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:134:1: ( ruleTIntegerConstant EOF )
            // InternalBug288734TestLanguage.g:135:1: ruleTIntegerConstant EOF
            {
             before(grammarAccess.getTIntegerConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTIntegerConstant();

            state._fsp--;

             after(grammarAccess.getTIntegerConstantRule()); 
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
    // $ANTLR end "entryRuleTIntegerConstant"


    // $ANTLR start "ruleTIntegerConstant"
    // InternalBug288734TestLanguage.g:142:1: ruleTIntegerConstant : ( ( rule__TIntegerConstant__Group__0 ) ) ;
    public final void ruleTIntegerConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:146:2: ( ( ( rule__TIntegerConstant__Group__0 ) ) )
            // InternalBug288734TestLanguage.g:147:2: ( ( rule__TIntegerConstant__Group__0 ) )
            {
            // InternalBug288734TestLanguage.g:147:2: ( ( rule__TIntegerConstant__Group__0 ) )
            // InternalBug288734TestLanguage.g:148:3: ( rule__TIntegerConstant__Group__0 )
            {
             before(grammarAccess.getTIntegerConstantAccess().getGroup()); 
            // InternalBug288734TestLanguage.g:149:3: ( rule__TIntegerConstant__Group__0 )
            // InternalBug288734TestLanguage.g:149:4: rule__TIntegerConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTIntegerConstantAccess().getGroup()); 

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
    // $ANTLR end "ruleTIntegerConstant"


    // $ANTLR start "entryRuleTBooleanConstant"
    // InternalBug288734TestLanguage.g:158:1: entryRuleTBooleanConstant : ruleTBooleanConstant EOF ;
    public final void entryRuleTBooleanConstant() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:159:1: ( ruleTBooleanConstant EOF )
            // InternalBug288734TestLanguage.g:160:1: ruleTBooleanConstant EOF
            {
             before(grammarAccess.getTBooleanConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTBooleanConstant();

            state._fsp--;

             after(grammarAccess.getTBooleanConstantRule()); 
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
    // $ANTLR end "entryRuleTBooleanConstant"


    // $ANTLR start "ruleTBooleanConstant"
    // InternalBug288734TestLanguage.g:167:1: ruleTBooleanConstant : ( ( rule__TBooleanConstant__Group__0 ) ) ;
    public final void ruleTBooleanConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:171:2: ( ( ( rule__TBooleanConstant__Group__0 ) ) )
            // InternalBug288734TestLanguage.g:172:2: ( ( rule__TBooleanConstant__Group__0 ) )
            {
            // InternalBug288734TestLanguage.g:172:2: ( ( rule__TBooleanConstant__Group__0 ) )
            // InternalBug288734TestLanguage.g:173:3: ( rule__TBooleanConstant__Group__0 )
            {
             before(grammarAccess.getTBooleanConstantAccess().getGroup()); 
            // InternalBug288734TestLanguage.g:174:3: ( rule__TBooleanConstant__Group__0 )
            // InternalBug288734TestLanguage.g:174:4: rule__TBooleanConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTBooleanConstantAccess().getGroup()); 

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
    // $ANTLR end "ruleTBooleanConstant"


    // $ANTLR start "entryRuleTAnnotation"
    // InternalBug288734TestLanguage.g:183:1: entryRuleTAnnotation : ruleTAnnotation EOF ;
    public final void entryRuleTAnnotation() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:184:1: ( ruleTAnnotation EOF )
            // InternalBug288734TestLanguage.g:185:1: ruleTAnnotation EOF
            {
             before(grammarAccess.getTAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTAnnotation();

            state._fsp--;

             after(grammarAccess.getTAnnotationRule()); 
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
    // $ANTLR end "entryRuleTAnnotation"


    // $ANTLR start "ruleTAnnotation"
    // InternalBug288734TestLanguage.g:192:1: ruleTAnnotation : ( ( rule__TAnnotation__Group__0 ) ) ;
    public final void ruleTAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:196:2: ( ( ( rule__TAnnotation__Group__0 ) ) )
            // InternalBug288734TestLanguage.g:197:2: ( ( rule__TAnnotation__Group__0 ) )
            {
            // InternalBug288734TestLanguage.g:197:2: ( ( rule__TAnnotation__Group__0 ) )
            // InternalBug288734TestLanguage.g:198:3: ( rule__TAnnotation__Group__0 )
            {
             before(grammarAccess.getTAnnotationAccess().getGroup()); 
            // InternalBug288734TestLanguage.g:199:3: ( rule__TAnnotation__Group__0 )
            // InternalBug288734TestLanguage.g:199:4: rule__TAnnotation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TAnnotation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTAnnotationAccess().getGroup()); 

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
    // $ANTLR end "ruleTAnnotation"


    // $ANTLR start "rule__TConstant__Alternatives"
    // InternalBug288734TestLanguage.g:207:1: rule__TConstant__Alternatives : ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) );
    public final void rule__TConstant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:211:1: ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalBug288734TestLanguage.g:212:2: ( ruleTStringConstant )
                    {
                    // InternalBug288734TestLanguage.g:212:2: ( ruleTStringConstant )
                    // InternalBug288734TestLanguage.g:213:3: ruleTStringConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTStringConstant();

                    state._fsp--;

                     after(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug288734TestLanguage.g:218:2: ( ruleTIntegerConstant )
                    {
                    // InternalBug288734TestLanguage.g:218:2: ( ruleTIntegerConstant )
                    // InternalBug288734TestLanguage.g:219:3: ruleTIntegerConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTIntegerConstant();

                    state._fsp--;

                     after(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug288734TestLanguage.g:224:2: ( ruleTBooleanConstant )
                    {
                    // InternalBug288734TestLanguage.g:224:2: ( ruleTBooleanConstant )
                    // InternalBug288734TestLanguage.g:225:3: ruleTBooleanConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTBooleanConstantParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTBooleanConstant();

                    state._fsp--;

                     after(grammarAccess.getTConstantAccess().getTBooleanConstantParserRuleCall_2()); 

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
    // $ANTLR end "rule__TConstant__Alternatives"


    // $ANTLR start "rule__TStringConstant__Group__0"
    // InternalBug288734TestLanguage.g:234:1: rule__TStringConstant__Group__0 : rule__TStringConstant__Group__0__Impl rule__TStringConstant__Group__1 ;
    public final void rule__TStringConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:238:1: ( rule__TStringConstant__Group__0__Impl rule__TStringConstant__Group__1 )
            // InternalBug288734TestLanguage.g:239:2: rule__TStringConstant__Group__0__Impl rule__TStringConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TStringConstant__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__Group__1();

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
    // $ANTLR end "rule__TStringConstant__Group__0"


    // $ANTLR start "rule__TStringConstant__Group__0__Impl"
    // InternalBug288734TestLanguage.g:246:1: rule__TStringConstant__Group__0__Impl : ( ( rule__TStringConstant__AnnotationsAssignment_0 )* ) ;
    public final void rule__TStringConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:250:1: ( ( ( rule__TStringConstant__AnnotationsAssignment_0 )* ) )
            // InternalBug288734TestLanguage.g:251:1: ( ( rule__TStringConstant__AnnotationsAssignment_0 )* )
            {
            // InternalBug288734TestLanguage.g:251:1: ( ( rule__TStringConstant__AnnotationsAssignment_0 )* )
            // InternalBug288734TestLanguage.g:252:2: ( rule__TStringConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTStringConstantAccess().getAnnotationsAssignment_0()); 
            // InternalBug288734TestLanguage.g:253:2: ( rule__TStringConstant__AnnotationsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug288734TestLanguage.g:253:3: rule__TStringConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__TStringConstant__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTStringConstantAccess().getAnnotationsAssignment_0()); 

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
    // $ANTLR end "rule__TStringConstant__Group__0__Impl"


    // $ANTLR start "rule__TStringConstant__Group__1"
    // InternalBug288734TestLanguage.g:261:1: rule__TStringConstant__Group__1 : rule__TStringConstant__Group__1__Impl rule__TStringConstant__Group__2 ;
    public final void rule__TStringConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:265:1: ( rule__TStringConstant__Group__1__Impl rule__TStringConstant__Group__2 )
            // InternalBug288734TestLanguage.g:266:2: rule__TStringConstant__Group__1__Impl rule__TStringConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__TStringConstant__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__Group__2();

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
    // $ANTLR end "rule__TStringConstant__Group__1"


    // $ANTLR start "rule__TStringConstant__Group__1__Impl"
    // InternalBug288734TestLanguage.g:273:1: rule__TStringConstant__Group__1__Impl : ( 'constant' ) ;
    public final void rule__TStringConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:277:1: ( ( 'constant' ) )
            // InternalBug288734TestLanguage.g:278:1: ( 'constant' )
            {
            // InternalBug288734TestLanguage.g:278:1: ( 'constant' )
            // InternalBug288734TestLanguage.g:279:2: 'constant'
            {
             before(grammarAccess.getTStringConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTStringConstantAccess().getConstantKeyword_1()); 

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
    // $ANTLR end "rule__TStringConstant__Group__1__Impl"


    // $ANTLR start "rule__TStringConstant__Group__2"
    // InternalBug288734TestLanguage.g:288:1: rule__TStringConstant__Group__2 : rule__TStringConstant__Group__2__Impl rule__TStringConstant__Group__3 ;
    public final void rule__TStringConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:292:1: ( rule__TStringConstant__Group__2__Impl rule__TStringConstant__Group__3 )
            // InternalBug288734TestLanguage.g:293:2: rule__TStringConstant__Group__2__Impl rule__TStringConstant__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__TStringConstant__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__Group__3();

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
    // $ANTLR end "rule__TStringConstant__Group__2"


    // $ANTLR start "rule__TStringConstant__Group__2__Impl"
    // InternalBug288734TestLanguage.g:300:1: rule__TStringConstant__Group__2__Impl : ( 'string' ) ;
    public final void rule__TStringConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:304:1: ( ( 'string' ) )
            // InternalBug288734TestLanguage.g:305:1: ( 'string' )
            {
            // InternalBug288734TestLanguage.g:305:1: ( 'string' )
            // InternalBug288734TestLanguage.g:306:2: 'string'
            {
             before(grammarAccess.getTStringConstantAccess().getStringKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTStringConstantAccess().getStringKeyword_2()); 

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
    // $ANTLR end "rule__TStringConstant__Group__2__Impl"


    // $ANTLR start "rule__TStringConstant__Group__3"
    // InternalBug288734TestLanguage.g:315:1: rule__TStringConstant__Group__3 : rule__TStringConstant__Group__3__Impl ;
    public final void rule__TStringConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:319:1: ( rule__TStringConstant__Group__3__Impl )
            // InternalBug288734TestLanguage.g:320:2: rule__TStringConstant__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__Group__3__Impl();

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
    // $ANTLR end "rule__TStringConstant__Group__3"


    // $ANTLR start "rule__TStringConstant__Group__3__Impl"
    // InternalBug288734TestLanguage.g:326:1: rule__TStringConstant__Group__3__Impl : ( ( rule__TStringConstant__NameAssignment_3 ) ) ;
    public final void rule__TStringConstant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:330:1: ( ( ( rule__TStringConstant__NameAssignment_3 ) ) )
            // InternalBug288734TestLanguage.g:331:1: ( ( rule__TStringConstant__NameAssignment_3 ) )
            {
            // InternalBug288734TestLanguage.g:331:1: ( ( rule__TStringConstant__NameAssignment_3 ) )
            // InternalBug288734TestLanguage.g:332:2: ( rule__TStringConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTStringConstantAccess().getNameAssignment_3()); 
            // InternalBug288734TestLanguage.g:333:2: ( rule__TStringConstant__NameAssignment_3 )
            // InternalBug288734TestLanguage.g:333:3: rule__TStringConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTStringConstantAccess().getNameAssignment_3()); 

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
    // $ANTLR end "rule__TStringConstant__Group__3__Impl"


    // $ANTLR start "rule__TIntegerConstant__Group__0"
    // InternalBug288734TestLanguage.g:342:1: rule__TIntegerConstant__Group__0 : rule__TIntegerConstant__Group__0__Impl rule__TIntegerConstant__Group__1 ;
    public final void rule__TIntegerConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:346:1: ( rule__TIntegerConstant__Group__0__Impl rule__TIntegerConstant__Group__1 )
            // InternalBug288734TestLanguage.g:347:2: rule__TIntegerConstant__Group__0__Impl rule__TIntegerConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TIntegerConstant__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__Group__1();

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
    // $ANTLR end "rule__TIntegerConstant__Group__0"


    // $ANTLR start "rule__TIntegerConstant__Group__0__Impl"
    // InternalBug288734TestLanguage.g:354:1: rule__TIntegerConstant__Group__0__Impl : ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* ) ;
    public final void rule__TIntegerConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:358:1: ( ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* ) )
            // InternalBug288734TestLanguage.g:359:1: ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* )
            {
            // InternalBug288734TestLanguage.g:359:1: ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* )
            // InternalBug288734TestLanguage.g:360:2: ( rule__TIntegerConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTIntegerConstantAccess().getAnnotationsAssignment_0()); 
            // InternalBug288734TestLanguage.g:361:2: ( rule__TIntegerConstant__AnnotationsAssignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug288734TestLanguage.g:361:3: rule__TIntegerConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__TIntegerConstant__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getTIntegerConstantAccess().getAnnotationsAssignment_0()); 

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
    // $ANTLR end "rule__TIntegerConstant__Group__0__Impl"


    // $ANTLR start "rule__TIntegerConstant__Group__1"
    // InternalBug288734TestLanguage.g:369:1: rule__TIntegerConstant__Group__1 : rule__TIntegerConstant__Group__1__Impl rule__TIntegerConstant__Group__2 ;
    public final void rule__TIntegerConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:373:1: ( rule__TIntegerConstant__Group__1__Impl rule__TIntegerConstant__Group__2 )
            // InternalBug288734TestLanguage.g:374:2: rule__TIntegerConstant__Group__1__Impl rule__TIntegerConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__TIntegerConstant__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__Group__2();

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
    // $ANTLR end "rule__TIntegerConstant__Group__1"


    // $ANTLR start "rule__TIntegerConstant__Group__1__Impl"
    // InternalBug288734TestLanguage.g:381:1: rule__TIntegerConstant__Group__1__Impl : ( 'constant' ) ;
    public final void rule__TIntegerConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:385:1: ( ( 'constant' ) )
            // InternalBug288734TestLanguage.g:386:1: ( 'constant' )
            {
            // InternalBug288734TestLanguage.g:386:1: ( 'constant' )
            // InternalBug288734TestLanguage.g:387:2: 'constant'
            {
             before(grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1()); 

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
    // $ANTLR end "rule__TIntegerConstant__Group__1__Impl"


    // $ANTLR start "rule__TIntegerConstant__Group__2"
    // InternalBug288734TestLanguage.g:396:1: rule__TIntegerConstant__Group__2 : rule__TIntegerConstant__Group__2__Impl rule__TIntegerConstant__Group__3 ;
    public final void rule__TIntegerConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:400:1: ( rule__TIntegerConstant__Group__2__Impl rule__TIntegerConstant__Group__3 )
            // InternalBug288734TestLanguage.g:401:2: rule__TIntegerConstant__Group__2__Impl rule__TIntegerConstant__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__TIntegerConstant__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__Group__3();

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
    // $ANTLR end "rule__TIntegerConstant__Group__2"


    // $ANTLR start "rule__TIntegerConstant__Group__2__Impl"
    // InternalBug288734TestLanguage.g:408:1: rule__TIntegerConstant__Group__2__Impl : ( 'integer' ) ;
    public final void rule__TIntegerConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:412:1: ( ( 'integer' ) )
            // InternalBug288734TestLanguage.g:413:1: ( 'integer' )
            {
            // InternalBug288734TestLanguage.g:413:1: ( 'integer' )
            // InternalBug288734TestLanguage.g:414:2: 'integer'
            {
             before(grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2()); 

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
    // $ANTLR end "rule__TIntegerConstant__Group__2__Impl"


    // $ANTLR start "rule__TIntegerConstant__Group__3"
    // InternalBug288734TestLanguage.g:423:1: rule__TIntegerConstant__Group__3 : rule__TIntegerConstant__Group__3__Impl ;
    public final void rule__TIntegerConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:427:1: ( rule__TIntegerConstant__Group__3__Impl )
            // InternalBug288734TestLanguage.g:428:2: rule__TIntegerConstant__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__Group__3__Impl();

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
    // $ANTLR end "rule__TIntegerConstant__Group__3"


    // $ANTLR start "rule__TIntegerConstant__Group__3__Impl"
    // InternalBug288734TestLanguage.g:434:1: rule__TIntegerConstant__Group__3__Impl : ( ( rule__TIntegerConstant__NameAssignment_3 ) ) ;
    public final void rule__TIntegerConstant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:438:1: ( ( ( rule__TIntegerConstant__NameAssignment_3 ) ) )
            // InternalBug288734TestLanguage.g:439:1: ( ( rule__TIntegerConstant__NameAssignment_3 ) )
            {
            // InternalBug288734TestLanguage.g:439:1: ( ( rule__TIntegerConstant__NameAssignment_3 ) )
            // InternalBug288734TestLanguage.g:440:2: ( rule__TIntegerConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTIntegerConstantAccess().getNameAssignment_3()); 
            // InternalBug288734TestLanguage.g:441:2: ( rule__TIntegerConstant__NameAssignment_3 )
            // InternalBug288734TestLanguage.g:441:3: rule__TIntegerConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTIntegerConstantAccess().getNameAssignment_3()); 

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
    // $ANTLR end "rule__TIntegerConstant__Group__3__Impl"


    // $ANTLR start "rule__TBooleanConstant__Group__0"
    // InternalBug288734TestLanguage.g:450:1: rule__TBooleanConstant__Group__0 : rule__TBooleanConstant__Group__0__Impl rule__TBooleanConstant__Group__1 ;
    public final void rule__TBooleanConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:454:1: ( rule__TBooleanConstant__Group__0__Impl rule__TBooleanConstant__Group__1 )
            // InternalBug288734TestLanguage.g:455:2: rule__TBooleanConstant__Group__0__Impl rule__TBooleanConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TBooleanConstant__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__Group__1();

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
    // $ANTLR end "rule__TBooleanConstant__Group__0"


    // $ANTLR start "rule__TBooleanConstant__Group__0__Impl"
    // InternalBug288734TestLanguage.g:462:1: rule__TBooleanConstant__Group__0__Impl : ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* ) ;
    public final void rule__TBooleanConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:466:1: ( ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* ) )
            // InternalBug288734TestLanguage.g:467:1: ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* )
            {
            // InternalBug288734TestLanguage.g:467:1: ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* )
            // InternalBug288734TestLanguage.g:468:2: ( rule__TBooleanConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTBooleanConstantAccess().getAnnotationsAssignment_0()); 
            // InternalBug288734TestLanguage.g:469:2: ( rule__TBooleanConstant__AnnotationsAssignment_0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBug288734TestLanguage.g:469:3: rule__TBooleanConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__TBooleanConstant__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getTBooleanConstantAccess().getAnnotationsAssignment_0()); 

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
    // $ANTLR end "rule__TBooleanConstant__Group__0__Impl"


    // $ANTLR start "rule__TBooleanConstant__Group__1"
    // InternalBug288734TestLanguage.g:477:1: rule__TBooleanConstant__Group__1 : rule__TBooleanConstant__Group__1__Impl rule__TBooleanConstant__Group__2 ;
    public final void rule__TBooleanConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:481:1: ( rule__TBooleanConstant__Group__1__Impl rule__TBooleanConstant__Group__2 )
            // InternalBug288734TestLanguage.g:482:2: rule__TBooleanConstant__Group__1__Impl rule__TBooleanConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__TBooleanConstant__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__Group__2();

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
    // $ANTLR end "rule__TBooleanConstant__Group__1"


    // $ANTLR start "rule__TBooleanConstant__Group__1__Impl"
    // InternalBug288734TestLanguage.g:489:1: rule__TBooleanConstant__Group__1__Impl : ( 'constant' ) ;
    public final void rule__TBooleanConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:493:1: ( ( 'constant' ) )
            // InternalBug288734TestLanguage.g:494:1: ( 'constant' )
            {
            // InternalBug288734TestLanguage.g:494:1: ( 'constant' )
            // InternalBug288734TestLanguage.g:495:2: 'constant'
            {
             before(grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1()); 

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
    // $ANTLR end "rule__TBooleanConstant__Group__1__Impl"


    // $ANTLR start "rule__TBooleanConstant__Group__2"
    // InternalBug288734TestLanguage.g:504:1: rule__TBooleanConstant__Group__2 : rule__TBooleanConstant__Group__2__Impl rule__TBooleanConstant__Group__3 ;
    public final void rule__TBooleanConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:508:1: ( rule__TBooleanConstant__Group__2__Impl rule__TBooleanConstant__Group__3 )
            // InternalBug288734TestLanguage.g:509:2: rule__TBooleanConstant__Group__2__Impl rule__TBooleanConstant__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__TBooleanConstant__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__Group__3();

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
    // $ANTLR end "rule__TBooleanConstant__Group__2"


    // $ANTLR start "rule__TBooleanConstant__Group__2__Impl"
    // InternalBug288734TestLanguage.g:516:1: rule__TBooleanConstant__Group__2__Impl : ( 'boolean' ) ;
    public final void rule__TBooleanConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:520:1: ( ( 'boolean' ) )
            // InternalBug288734TestLanguage.g:521:1: ( 'boolean' )
            {
            // InternalBug288734TestLanguage.g:521:1: ( 'boolean' )
            // InternalBug288734TestLanguage.g:522:2: 'boolean'
            {
             before(grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2()); 

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
    // $ANTLR end "rule__TBooleanConstant__Group__2__Impl"


    // $ANTLR start "rule__TBooleanConstant__Group__3"
    // InternalBug288734TestLanguage.g:531:1: rule__TBooleanConstant__Group__3 : rule__TBooleanConstant__Group__3__Impl ;
    public final void rule__TBooleanConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:535:1: ( rule__TBooleanConstant__Group__3__Impl )
            // InternalBug288734TestLanguage.g:536:2: rule__TBooleanConstant__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__Group__3__Impl();

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
    // $ANTLR end "rule__TBooleanConstant__Group__3"


    // $ANTLR start "rule__TBooleanConstant__Group__3__Impl"
    // InternalBug288734TestLanguage.g:542:1: rule__TBooleanConstant__Group__3__Impl : ( ( rule__TBooleanConstant__NameAssignment_3 ) ) ;
    public final void rule__TBooleanConstant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:546:1: ( ( ( rule__TBooleanConstant__NameAssignment_3 ) ) )
            // InternalBug288734TestLanguage.g:547:1: ( ( rule__TBooleanConstant__NameAssignment_3 ) )
            {
            // InternalBug288734TestLanguage.g:547:1: ( ( rule__TBooleanConstant__NameAssignment_3 ) )
            // InternalBug288734TestLanguage.g:548:2: ( rule__TBooleanConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTBooleanConstantAccess().getNameAssignment_3()); 
            // InternalBug288734TestLanguage.g:549:2: ( rule__TBooleanConstant__NameAssignment_3 )
            // InternalBug288734TestLanguage.g:549:3: rule__TBooleanConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTBooleanConstantAccess().getNameAssignment_3()); 

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
    // $ANTLR end "rule__TBooleanConstant__Group__3__Impl"


    // $ANTLR start "rule__TAnnotation__Group__0"
    // InternalBug288734TestLanguage.g:558:1: rule__TAnnotation__Group__0 : rule__TAnnotation__Group__0__Impl rule__TAnnotation__Group__1 ;
    public final void rule__TAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:562:1: ( rule__TAnnotation__Group__0__Impl rule__TAnnotation__Group__1 )
            // InternalBug288734TestLanguage.g:563:2: rule__TAnnotation__Group__0__Impl rule__TAnnotation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__TAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TAnnotation__Group__1();

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
    // $ANTLR end "rule__TAnnotation__Group__0"


    // $ANTLR start "rule__TAnnotation__Group__0__Impl"
    // InternalBug288734TestLanguage.g:570:1: rule__TAnnotation__Group__0__Impl : ( '@desc' ) ;
    public final void rule__TAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:574:1: ( ( '@desc' ) )
            // InternalBug288734TestLanguage.g:575:1: ( '@desc' )
            {
            // InternalBug288734TestLanguage.g:575:1: ( '@desc' )
            // InternalBug288734TestLanguage.g:576:2: '@desc'
            {
             before(grammarAccess.getTAnnotationAccess().getDescKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTAnnotationAccess().getDescKeyword_0()); 

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
    // $ANTLR end "rule__TAnnotation__Group__0__Impl"


    // $ANTLR start "rule__TAnnotation__Group__1"
    // InternalBug288734TestLanguage.g:585:1: rule__TAnnotation__Group__1 : rule__TAnnotation__Group__1__Impl ;
    public final void rule__TAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:589:1: ( rule__TAnnotation__Group__1__Impl )
            // InternalBug288734TestLanguage.g:590:2: rule__TAnnotation__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TAnnotation__Group__1__Impl();

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
    // $ANTLR end "rule__TAnnotation__Group__1"


    // $ANTLR start "rule__TAnnotation__Group__1__Impl"
    // InternalBug288734TestLanguage.g:596:1: rule__TAnnotation__Group__1__Impl : ( ( rule__TAnnotation__DescriptionAssignment_1 ) ) ;
    public final void rule__TAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:600:1: ( ( ( rule__TAnnotation__DescriptionAssignment_1 ) ) )
            // InternalBug288734TestLanguage.g:601:1: ( ( rule__TAnnotation__DescriptionAssignment_1 ) )
            {
            // InternalBug288734TestLanguage.g:601:1: ( ( rule__TAnnotation__DescriptionAssignment_1 ) )
            // InternalBug288734TestLanguage.g:602:2: ( rule__TAnnotation__DescriptionAssignment_1 )
            {
             before(grammarAccess.getTAnnotationAccess().getDescriptionAssignment_1()); 
            // InternalBug288734TestLanguage.g:603:2: ( rule__TAnnotation__DescriptionAssignment_1 )
            // InternalBug288734TestLanguage.g:603:3: rule__TAnnotation__DescriptionAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TAnnotation__DescriptionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTAnnotationAccess().getDescriptionAssignment_1()); 

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
    // $ANTLR end "rule__TAnnotation__Group__1__Impl"


    // $ANTLR start "rule__Model__ConstantsAssignment"
    // InternalBug288734TestLanguage.g:612:1: rule__Model__ConstantsAssignment : ( ruleTConstant ) ;
    public final void rule__Model__ConstantsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:616:1: ( ( ruleTConstant ) )
            // InternalBug288734TestLanguage.g:617:2: ( ruleTConstant )
            {
            // InternalBug288734TestLanguage.g:617:2: ( ruleTConstant )
            // InternalBug288734TestLanguage.g:618:3: ruleTConstant
            {
             before(grammarAccess.getModelAccess().getConstantsTConstantParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTConstant();

            state._fsp--;

             after(grammarAccess.getModelAccess().getConstantsTConstantParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__ConstantsAssignment"


    // $ANTLR start "rule__TStringConstant__AnnotationsAssignment_0"
    // InternalBug288734TestLanguage.g:627:1: rule__TStringConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TStringConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:631:1: ( ( ruleTAnnotation ) )
            // InternalBug288734TestLanguage.g:632:2: ( ruleTAnnotation )
            {
            // InternalBug288734TestLanguage.g:632:2: ( ruleTAnnotation )
            // InternalBug288734TestLanguage.g:633:3: ruleTAnnotation
            {
             before(grammarAccess.getTStringConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTAnnotation();

            state._fsp--;

             after(grammarAccess.getTStringConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__TStringConstant__AnnotationsAssignment_0"


    // $ANTLR start "rule__TStringConstant__NameAssignment_3"
    // InternalBug288734TestLanguage.g:642:1: rule__TStringConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TStringConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:646:1: ( ( RULE_ID ) )
            // InternalBug288734TestLanguage.g:647:2: ( RULE_ID )
            {
            // InternalBug288734TestLanguage.g:647:2: ( RULE_ID )
            // InternalBug288734TestLanguage.g:648:3: RULE_ID
            {
             before(grammarAccess.getTStringConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTStringConstantAccess().getNameIDTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__TStringConstant__NameAssignment_3"


    // $ANTLR start "rule__TIntegerConstant__AnnotationsAssignment_0"
    // InternalBug288734TestLanguage.g:657:1: rule__TIntegerConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TIntegerConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:661:1: ( ( ruleTAnnotation ) )
            // InternalBug288734TestLanguage.g:662:2: ( ruleTAnnotation )
            {
            // InternalBug288734TestLanguage.g:662:2: ( ruleTAnnotation )
            // InternalBug288734TestLanguage.g:663:3: ruleTAnnotation
            {
             before(grammarAccess.getTIntegerConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTAnnotation();

            state._fsp--;

             after(grammarAccess.getTIntegerConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__TIntegerConstant__AnnotationsAssignment_0"


    // $ANTLR start "rule__TIntegerConstant__NameAssignment_3"
    // InternalBug288734TestLanguage.g:672:1: rule__TIntegerConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TIntegerConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:676:1: ( ( RULE_ID ) )
            // InternalBug288734TestLanguage.g:677:2: ( RULE_ID )
            {
            // InternalBug288734TestLanguage.g:677:2: ( RULE_ID )
            // InternalBug288734TestLanguage.g:678:3: RULE_ID
            {
             before(grammarAccess.getTIntegerConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTIntegerConstantAccess().getNameIDTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__TIntegerConstant__NameAssignment_3"


    // $ANTLR start "rule__TBooleanConstant__AnnotationsAssignment_0"
    // InternalBug288734TestLanguage.g:687:1: rule__TBooleanConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TBooleanConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:691:1: ( ( ruleTAnnotation ) )
            // InternalBug288734TestLanguage.g:692:2: ( ruleTAnnotation )
            {
            // InternalBug288734TestLanguage.g:692:2: ( ruleTAnnotation )
            // InternalBug288734TestLanguage.g:693:3: ruleTAnnotation
            {
             before(grammarAccess.getTBooleanConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTAnnotation();

            state._fsp--;

             after(grammarAccess.getTBooleanConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__TBooleanConstant__AnnotationsAssignment_0"


    // $ANTLR start "rule__TBooleanConstant__NameAssignment_3"
    // InternalBug288734TestLanguage.g:702:1: rule__TBooleanConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TBooleanConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:706:1: ( ( RULE_ID ) )
            // InternalBug288734TestLanguage.g:707:2: ( RULE_ID )
            {
            // InternalBug288734TestLanguage.g:707:2: ( RULE_ID )
            // InternalBug288734TestLanguage.g:708:3: RULE_ID
            {
             before(grammarAccess.getTBooleanConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTBooleanConstantAccess().getNameIDTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__TBooleanConstant__NameAssignment_3"


    // $ANTLR start "rule__TAnnotation__DescriptionAssignment_1"
    // InternalBug288734TestLanguage.g:717:1: rule__TAnnotation__DescriptionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TAnnotation__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug288734TestLanguage.g:721:1: ( ( RULE_STRING ) )
            // InternalBug288734TestLanguage.g:722:2: ( RULE_STRING )
            {
            // InternalBug288734TestLanguage.g:722:2: ( RULE_STRING )
            // InternalBug288734TestLanguage.g:723:3: RULE_STRING
            {
             before(grammarAccess.getTAnnotationAccess().getDescriptionSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTAnnotationAccess().getDescriptionSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__TAnnotation__DescriptionAssignment_1"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\13\1\5\1\14\1\13\3\uffff";
    static final String dfa_3s = "\1\17\1\5\1\16\1\17\3\uffff";
    static final String dfa_4s = "\4\uffff\1\1\1\2\1\3";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\3\uffff\1\1",
            "\1\3",
            "\1\4\1\5\1\6",
            "\1\2\3\uffff\1\1",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "207:1: rule__TConstant__Alternatives : ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    }


}
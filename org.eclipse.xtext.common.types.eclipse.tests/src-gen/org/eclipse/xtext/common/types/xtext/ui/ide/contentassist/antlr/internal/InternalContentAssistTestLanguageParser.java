package org.eclipse.xtext.common.types.xtext.ui.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.common.types.xtext.ui.services.ContentAssistTestLanguageGrammarAccess;



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
public class InternalContentAssistTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'default'", "'custom'", "'subtype'", "'generate'", "'import'", "'.*'", "'$'", "'.'"
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
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalContentAssistTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistTestLanguage.g"; }


    	private ContentAssistTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(ContentAssistTestLanguageGrammarAccess grammarAccess) {
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
    // InternalContentAssistTestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:59:1: ( ruleModel EOF )
            // InternalContentAssistTestLanguage.g:60:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalContentAssistTestLanguage.g:67:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:71:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:72:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:72:2: ( ( rule__Model__Group__0 ) )
            // InternalContentAssistTestLanguage.g:73:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:74:3: ( rule__Model__Group__0 )
            // InternalContentAssistTestLanguage.g:74:4: rule__Model__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

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


    // $ANTLR start "entryRuleReferenceHolder"
    // InternalContentAssistTestLanguage.g:83:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:84:1: ( ruleReferenceHolder EOF )
            // InternalContentAssistTestLanguage.g:85:1: ruleReferenceHolder EOF
            {
             before(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FOLLOW_1);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getReferenceHolderRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // InternalContentAssistTestLanguage.g:92:1: ruleReferenceHolder : ( ( rule__ReferenceHolder__Alternatives ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:96:2: ( ( ( rule__ReferenceHolder__Alternatives ) ) )
            // InternalContentAssistTestLanguage.g:97:2: ( ( rule__ReferenceHolder__Alternatives ) )
            {
            // InternalContentAssistTestLanguage.g:97:2: ( ( rule__ReferenceHolder__Alternatives ) )
            // InternalContentAssistTestLanguage.g:98:3: ( rule__ReferenceHolder__Alternatives )
            {
             before(grammarAccess.getReferenceHolderAccess().getAlternatives()); 
            // InternalContentAssistTestLanguage.g:99:3: ( rule__ReferenceHolder__Alternatives )
            // InternalContentAssistTestLanguage.g:99:4: rule__ReferenceHolder__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getAlternatives()); 

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
    // $ANTLR end "ruleReferenceHolder"


    // $ANTLR start "entryRuleGenerateDirective"
    // InternalContentAssistTestLanguage.g:108:1: entryRuleGenerateDirective : ruleGenerateDirective EOF ;
    public final void entryRuleGenerateDirective() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:109:1: ( ruleGenerateDirective EOF )
            // InternalContentAssistTestLanguage.g:110:1: ruleGenerateDirective EOF
            {
             before(grammarAccess.getGenerateDirectiveRule()); 
            pushFollow(FOLLOW_1);
            ruleGenerateDirective();

            state._fsp--;

             after(grammarAccess.getGenerateDirectiveRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleGenerateDirective"


    // $ANTLR start "ruleGenerateDirective"
    // InternalContentAssistTestLanguage.g:117:1: ruleGenerateDirective : ( ( rule__GenerateDirective__Group__0 ) ) ;
    public final void ruleGenerateDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:121:2: ( ( ( rule__GenerateDirective__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:122:2: ( ( rule__GenerateDirective__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:122:2: ( ( rule__GenerateDirective__Group__0 ) )
            // InternalContentAssistTestLanguage.g:123:3: ( rule__GenerateDirective__Group__0 )
            {
             before(grammarAccess.getGenerateDirectiveAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:124:3: ( rule__GenerateDirective__Group__0 )
            // InternalContentAssistTestLanguage.g:124:4: rule__GenerateDirective__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GenerateDirective__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGenerateDirectiveAccess().getGroup()); 

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
    // $ANTLR end "ruleGenerateDirective"


    // $ANTLR start "entryRuleImport"
    // InternalContentAssistTestLanguage.g:133:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:134:1: ( ruleImport EOF )
            // InternalContentAssistTestLanguage.g:135:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalContentAssistTestLanguage.g:142:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:146:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:147:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:147:2: ( ( rule__Import__Group__0 ) )
            // InternalContentAssistTestLanguage.g:148:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:149:3: ( rule__Import__Group__0 )
            // InternalContentAssistTestLanguage.g:149:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleImportedFQN"
    // InternalContentAssistTestLanguage.g:158:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:159:1: ( ruleImportedFQN EOF )
            // InternalContentAssistTestLanguage.g:160:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // InternalContentAssistTestLanguage.g:167:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:171:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:172:2: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:172:2: ( ( rule__ImportedFQN__Group__0 ) )
            // InternalContentAssistTestLanguage.g:173:3: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:174:3: ( rule__ImportedFQN__Group__0 )
            // InternalContentAssistTestLanguage.g:174:4: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportedFQNAccess().getGroup()); 

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
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleFQN"
    // InternalContentAssistTestLanguage.g:183:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:184:1: ( ruleFQN EOF )
            // InternalContentAssistTestLanguage.g:185:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalContentAssistTestLanguage.g:192:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:196:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:197:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:197:2: ( ( rule__FQN__Group__0 ) )
            // InternalContentAssistTestLanguage.g:198:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:199:3: ( rule__FQN__Group__0 )
            // InternalContentAssistTestLanguage.g:199:4: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleQN"
    // InternalContentAssistTestLanguage.g:208:1: entryRuleQN : ruleQN EOF ;
    public final void entryRuleQN() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:209:1: ( ruleQN EOF )
            // InternalContentAssistTestLanguage.g:210:1: ruleQN EOF
            {
             before(grammarAccess.getQNRule()); 
            pushFollow(FOLLOW_1);
            ruleQN();

            state._fsp--;

             after(grammarAccess.getQNRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQN"


    // $ANTLR start "ruleQN"
    // InternalContentAssistTestLanguage.g:217:1: ruleQN : ( ( rule__QN__Group__0 ) ) ;
    public final void ruleQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:221:2: ( ( ( rule__QN__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:222:2: ( ( rule__QN__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:222:2: ( ( rule__QN__Group__0 ) )
            // InternalContentAssistTestLanguage.g:223:3: ( rule__QN__Group__0 )
            {
             before(grammarAccess.getQNAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:224:3: ( rule__QN__Group__0 )
            // InternalContentAssistTestLanguage.g:224:4: rule__QN__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQNAccess().getGroup()); 

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
    // $ANTLR end "ruleQN"


    // $ANTLR start "rule__ReferenceHolder__Alternatives"
    // InternalContentAssistTestLanguage.g:232:1: rule__ReferenceHolder__Alternatives : ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) );
    public final void rule__ReferenceHolder__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:236:1: ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
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
                    // InternalContentAssistTestLanguage.g:237:2: ( ( rule__ReferenceHolder__Group_0__0 ) )
                    {
                    // InternalContentAssistTestLanguage.g:237:2: ( ( rule__ReferenceHolder__Group_0__0 ) )
                    // InternalContentAssistTestLanguage.g:238:3: ( rule__ReferenceHolder__Group_0__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_0()); 
                    // InternalContentAssistTestLanguage.g:239:3: ( rule__ReferenceHolder__Group_0__0 )
                    // InternalContentAssistTestLanguage.g:239:4: rule__ReferenceHolder__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ReferenceHolder__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalContentAssistTestLanguage.g:243:2: ( ( rule__ReferenceHolder__Group_1__0 ) )
                    {
                    // InternalContentAssistTestLanguage.g:243:2: ( ( rule__ReferenceHolder__Group_1__0 ) )
                    // InternalContentAssistTestLanguage.g:244:3: ( rule__ReferenceHolder__Group_1__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_1()); 
                    // InternalContentAssistTestLanguage.g:245:3: ( rule__ReferenceHolder__Group_1__0 )
                    // InternalContentAssistTestLanguage.g:245:4: rule__ReferenceHolder__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ReferenceHolder__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalContentAssistTestLanguage.g:249:2: ( ( rule__ReferenceHolder__Group_2__0 ) )
                    {
                    // InternalContentAssistTestLanguage.g:249:2: ( ( rule__ReferenceHolder__Group_2__0 ) )
                    // InternalContentAssistTestLanguage.g:250:3: ( rule__ReferenceHolder__Group_2__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_2()); 
                    // InternalContentAssistTestLanguage.g:251:3: ( rule__ReferenceHolder__Group_2__0 )
                    // InternalContentAssistTestLanguage.g:251:4: rule__ReferenceHolder__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ReferenceHolder__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_2()); 

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
    // $ANTLR end "rule__ReferenceHolder__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // InternalContentAssistTestLanguage.g:259:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:263:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalContentAssistTestLanguage.g:264:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

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
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:271:1: rule__Model__Group__0__Impl : ( ( rule__Model__ImportsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:275:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) )
            // InternalContentAssistTestLanguage.g:276:1: ( ( rule__Model__ImportsAssignment_0 )* )
            {
            // InternalContentAssistTestLanguage.g:276:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // InternalContentAssistTestLanguage.g:277:2: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // InternalContentAssistTestLanguage.g:278:2: ( rule__Model__ImportsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:278:3: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Model__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_0()); 

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
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalContentAssistTestLanguage.g:286:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:290:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalContentAssistTestLanguage.g:291:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__2();

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
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:298:1: rule__Model__Group__1__Impl : ( ( rule__Model__GenerateDirectiveAssignment_1 )? ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:302:1: ( ( ( rule__Model__GenerateDirectiveAssignment_1 )? ) )
            // InternalContentAssistTestLanguage.g:303:1: ( ( rule__Model__GenerateDirectiveAssignment_1 )? )
            {
            // InternalContentAssistTestLanguage.g:303:1: ( ( rule__Model__GenerateDirectiveAssignment_1 )? )
            // InternalContentAssistTestLanguage.g:304:2: ( rule__Model__GenerateDirectiveAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getGenerateDirectiveAssignment_1()); 
            // InternalContentAssistTestLanguage.g:305:2: ( rule__Model__GenerateDirectiveAssignment_1 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:305:3: rule__Model__GenerateDirectiveAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__GenerateDirectiveAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGenerateDirectiveAssignment_1()); 

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
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // InternalContentAssistTestLanguage.g:313:1: rule__Model__Group__2 : rule__Model__Group__2__Impl ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:317:1: ( rule__Model__Group__2__Impl )
            // InternalContentAssistTestLanguage.g:318:2: rule__Model__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__2__Impl();

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
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // InternalContentAssistTestLanguage.g:324:1: rule__Model__Group__2__Impl : ( ( rule__Model__ReferenceHolderAssignment_2 )? ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:328:1: ( ( ( rule__Model__ReferenceHolderAssignment_2 )? ) )
            // InternalContentAssistTestLanguage.g:329:1: ( ( rule__Model__ReferenceHolderAssignment_2 )? )
            {
            // InternalContentAssistTestLanguage.g:329:1: ( ( rule__Model__ReferenceHolderAssignment_2 )? )
            // InternalContentAssistTestLanguage.g:330:2: ( rule__Model__ReferenceHolderAssignment_2 )?
            {
             before(grammarAccess.getModelAccess().getReferenceHolderAssignment_2()); 
            // InternalContentAssistTestLanguage.g:331:2: ( rule__Model__ReferenceHolderAssignment_2 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=11 && LA4_0<=13)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:331:3: rule__Model__ReferenceHolderAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__ReferenceHolderAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getReferenceHolderAssignment_2()); 

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
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_0__0"
    // InternalContentAssistTestLanguage.g:340:1: rule__ReferenceHolder__Group_0__0 : rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1 ;
    public final void rule__ReferenceHolder__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:344:1: ( rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1 )
            // InternalContentAssistTestLanguage.g:345:2: rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1
            {
            pushFollow(FOLLOW_5);
            rule__ReferenceHolder__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_0__1();

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
    // $ANTLR end "rule__ReferenceHolder__Group_0__0"


    // $ANTLR start "rule__ReferenceHolder__Group_0__0__Impl"
    // InternalContentAssistTestLanguage.g:352:1: rule__ReferenceHolder__Group_0__0__Impl : ( 'default' ) ;
    public final void rule__ReferenceHolder__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:356:1: ( ( 'default' ) )
            // InternalContentAssistTestLanguage.g:357:1: ( 'default' )
            {
            // InternalContentAssistTestLanguage.g:357:1: ( 'default' )
            // InternalContentAssistTestLanguage.g:358:2: 'default'
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultKeyword_0_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getReferenceHolderAccess().getDefaultKeyword_0_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__Group_0__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_0__1"
    // InternalContentAssistTestLanguage.g:367:1: rule__ReferenceHolder__Group_0__1 : rule__ReferenceHolder__Group_0__1__Impl ;
    public final void rule__ReferenceHolder__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:371:1: ( rule__ReferenceHolder__Group_0__1__Impl )
            // InternalContentAssistTestLanguage.g:372:2: rule__ReferenceHolder__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_0__1__Impl();

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
    // $ANTLR end "rule__ReferenceHolder__Group_0__1"


    // $ANTLR start "rule__ReferenceHolder__Group_0__1__Impl"
    // InternalContentAssistTestLanguage.g:378:1: rule__ReferenceHolder__Group_0__1__Impl : ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) ) ;
    public final void rule__ReferenceHolder__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:382:1: ( ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) ) )
            // InternalContentAssistTestLanguage.g:383:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) )
            {
            // InternalContentAssistTestLanguage.g:383:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) )
            // InternalContentAssistTestLanguage.g:384:2: ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_0_1()); 
            // InternalContentAssistTestLanguage.g:385:2: ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 )
            // InternalContentAssistTestLanguage.g:385:3: rule__ReferenceHolder__DefaultReferenceAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__DefaultReferenceAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_0_1()); 

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
    // $ANTLR end "rule__ReferenceHolder__Group_0__1__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_1__0"
    // InternalContentAssistTestLanguage.g:394:1: rule__ReferenceHolder__Group_1__0 : rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1 ;
    public final void rule__ReferenceHolder__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:398:1: ( rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1 )
            // InternalContentAssistTestLanguage.g:399:2: rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__ReferenceHolder__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_1__1();

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
    // $ANTLR end "rule__ReferenceHolder__Group_1__0"


    // $ANTLR start "rule__ReferenceHolder__Group_1__0__Impl"
    // InternalContentAssistTestLanguage.g:406:1: rule__ReferenceHolder__Group_1__0__Impl : ( 'custom' ) ;
    public final void rule__ReferenceHolder__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:410:1: ( ( 'custom' ) )
            // InternalContentAssistTestLanguage.g:411:1: ( 'custom' )
            {
            // InternalContentAssistTestLanguage.g:411:1: ( 'custom' )
            // InternalContentAssistTestLanguage.g:412:2: 'custom'
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomKeyword_1_0()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getReferenceHolderAccess().getCustomKeyword_1_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__Group_1__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_1__1"
    // InternalContentAssistTestLanguage.g:421:1: rule__ReferenceHolder__Group_1__1 : rule__ReferenceHolder__Group_1__1__Impl ;
    public final void rule__ReferenceHolder__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:425:1: ( rule__ReferenceHolder__Group_1__1__Impl )
            // InternalContentAssistTestLanguage.g:426:2: rule__ReferenceHolder__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_1__1__Impl();

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
    // $ANTLR end "rule__ReferenceHolder__Group_1__1"


    // $ANTLR start "rule__ReferenceHolder__Group_1__1__Impl"
    // InternalContentAssistTestLanguage.g:432:1: rule__ReferenceHolder__Group_1__1__Impl : ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) ) ;
    public final void rule__ReferenceHolder__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:436:1: ( ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) ) )
            // InternalContentAssistTestLanguage.g:437:1: ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) )
            {
            // InternalContentAssistTestLanguage.g:437:1: ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) )
            // InternalContentAssistTestLanguage.g:438:2: ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceAssignment_1_1()); 
            // InternalContentAssistTestLanguage.g:439:2: ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 )
            // InternalContentAssistTestLanguage.g:439:3: rule__ReferenceHolder__CustomizedReferenceAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__CustomizedReferenceAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceAssignment_1_1()); 

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
    // $ANTLR end "rule__ReferenceHolder__Group_1__1__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_2__0"
    // InternalContentAssistTestLanguage.g:448:1: rule__ReferenceHolder__Group_2__0 : rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1 ;
    public final void rule__ReferenceHolder__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:452:1: ( rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1 )
            // InternalContentAssistTestLanguage.g:453:2: rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__ReferenceHolder__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_2__1();

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
    // $ANTLR end "rule__ReferenceHolder__Group_2__0"


    // $ANTLR start "rule__ReferenceHolder__Group_2__0__Impl"
    // InternalContentAssistTestLanguage.g:460:1: rule__ReferenceHolder__Group_2__0__Impl : ( 'subtype' ) ;
    public final void rule__ReferenceHolder__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:464:1: ( ( 'subtype' ) )
            // InternalContentAssistTestLanguage.g:465:1: ( 'subtype' )
            {
            // InternalContentAssistTestLanguage.g:465:1: ( 'subtype' )
            // InternalContentAssistTestLanguage.g:466:2: 'subtype'
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeKeyword_2_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getReferenceHolderAccess().getSubtypeKeyword_2_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__Group_2__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_2__1"
    // InternalContentAssistTestLanguage.g:475:1: rule__ReferenceHolder__Group_2__1 : rule__ReferenceHolder__Group_2__1__Impl ;
    public final void rule__ReferenceHolder__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:479:1: ( rule__ReferenceHolder__Group_2__1__Impl )
            // InternalContentAssistTestLanguage.g:480:2: rule__ReferenceHolder__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_2__1__Impl();

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
    // $ANTLR end "rule__ReferenceHolder__Group_2__1"


    // $ANTLR start "rule__ReferenceHolder__Group_2__1__Impl"
    // InternalContentAssistTestLanguage.g:486:1: rule__ReferenceHolder__Group_2__1__Impl : ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) ) ;
    public final void rule__ReferenceHolder__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:490:1: ( ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) ) )
            // InternalContentAssistTestLanguage.g:491:1: ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) )
            {
            // InternalContentAssistTestLanguage.g:491:1: ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) )
            // InternalContentAssistTestLanguage.g:492:2: ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceAssignment_2_1()); 
            // InternalContentAssistTestLanguage.g:493:2: ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 )
            // InternalContentAssistTestLanguage.g:493:3: rule__ReferenceHolder__SubtypeReferenceAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__SubtypeReferenceAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceAssignment_2_1()); 

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
    // $ANTLR end "rule__ReferenceHolder__Group_2__1__Impl"


    // $ANTLR start "rule__GenerateDirective__Group__0"
    // InternalContentAssistTestLanguage.g:502:1: rule__GenerateDirective__Group__0 : rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1 ;
    public final void rule__GenerateDirective__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:506:1: ( rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1 )
            // InternalContentAssistTestLanguage.g:507:2: rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__GenerateDirective__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GenerateDirective__Group__1();

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
    // $ANTLR end "rule__GenerateDirective__Group__0"


    // $ANTLR start "rule__GenerateDirective__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:514:1: rule__GenerateDirective__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GenerateDirective__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:518:1: ( ( 'generate' ) )
            // InternalContentAssistTestLanguage.g:519:1: ( 'generate' )
            {
            // InternalContentAssistTestLanguage.g:519:1: ( 'generate' )
            // InternalContentAssistTestLanguage.g:520:2: 'generate'
            {
             before(grammarAccess.getGenerateDirectiveAccess().getGenerateKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getGenerateDirectiveAccess().getGenerateKeyword_0()); 

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
    // $ANTLR end "rule__GenerateDirective__Group__0__Impl"


    // $ANTLR start "rule__GenerateDirective__Group__1"
    // InternalContentAssistTestLanguage.g:529:1: rule__GenerateDirective__Group__1 : rule__GenerateDirective__Group__1__Impl ;
    public final void rule__GenerateDirective__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:533:1: ( rule__GenerateDirective__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:534:2: rule__GenerateDirective__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GenerateDirective__Group__1__Impl();

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
    // $ANTLR end "rule__GenerateDirective__Group__1"


    // $ANTLR start "rule__GenerateDirective__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:540:1: rule__GenerateDirective__Group__1__Impl : ( ( rule__GenerateDirective__TypeNameAssignment_1 ) ) ;
    public final void rule__GenerateDirective__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:544:1: ( ( ( rule__GenerateDirective__TypeNameAssignment_1 ) ) )
            // InternalContentAssistTestLanguage.g:545:1: ( ( rule__GenerateDirective__TypeNameAssignment_1 ) )
            {
            // InternalContentAssistTestLanguage.g:545:1: ( ( rule__GenerateDirective__TypeNameAssignment_1 ) )
            // InternalContentAssistTestLanguage.g:546:2: ( rule__GenerateDirective__TypeNameAssignment_1 )
            {
             before(grammarAccess.getGenerateDirectiveAccess().getTypeNameAssignment_1()); 
            // InternalContentAssistTestLanguage.g:547:2: ( rule__GenerateDirective__TypeNameAssignment_1 )
            // InternalContentAssistTestLanguage.g:547:3: rule__GenerateDirective__TypeNameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GenerateDirective__TypeNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGenerateDirectiveAccess().getTypeNameAssignment_1()); 

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
    // $ANTLR end "rule__GenerateDirective__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalContentAssistTestLanguage.g:556:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:560:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalContentAssistTestLanguage.g:561:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:568:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:572:1: ( ( 'import' ) )
            // InternalContentAssistTestLanguage.g:573:1: ( 'import' )
            {
            // InternalContentAssistTestLanguage.g:573:1: ( 'import' )
            // InternalContentAssistTestLanguage.g:574:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,15,FOLLOW_2); 
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
    // InternalContentAssistTestLanguage.g:583:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:587:1: ( rule__Import__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:588:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:594:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:598:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalContentAssistTestLanguage.g:599:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalContentAssistTestLanguage.g:599:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalContentAssistTestLanguage.g:600:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalContentAssistTestLanguage.g:601:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalContentAssistTestLanguage.g:601:3: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__ImportedFQN__Group__0"
    // InternalContentAssistTestLanguage.g:610:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:614:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // InternalContentAssistTestLanguage.g:615:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group__1();

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
    // $ANTLR end "rule__ImportedFQN__Group__0"


    // $ANTLR start "rule__ImportedFQN__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:622:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:626:1: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:627:1: ( ruleFQN )
            {
            // InternalContentAssistTestLanguage.g:627:1: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:628:2: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 

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
    // $ANTLR end "rule__ImportedFQN__Group__0__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__1"
    // InternalContentAssistTestLanguage.g:637:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:641:1: ( rule__ImportedFQN__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:642:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group__1__Impl();

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
    // $ANTLR end "rule__ImportedFQN__Group__1"


    // $ANTLR start "rule__ImportedFQN__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:648:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:652:1: ( ( ( '.*' )? ) )
            // InternalContentAssistTestLanguage.g:653:1: ( ( '.*' )? )
            {
            // InternalContentAssistTestLanguage.g:653:1: ( ( '.*' )? )
            // InternalContentAssistTestLanguage.g:654:2: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // InternalContentAssistTestLanguage.g:655:2: ( '.*' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:655:3: '.*'
                    {
                    match(input,16,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 

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
    // $ANTLR end "rule__ImportedFQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalContentAssistTestLanguage.g:664:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:668:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalContentAssistTestLanguage.g:669:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:676:1: rule__FQN__Group__0__Impl : ( ruleQN ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:680:1: ( ( ruleQN ) )
            // InternalContentAssistTestLanguage.g:681:1: ( ruleQN )
            {
            // InternalContentAssistTestLanguage.g:681:1: ( ruleQN )
            // InternalContentAssistTestLanguage.g:682:2: ruleQN
            {
             before(grammarAccess.getFQNAccess().getQNParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleQN();

            state._fsp--;

             after(grammarAccess.getFQNAccess().getQNParserRuleCall_0()); 

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
    // InternalContentAssistTestLanguage.g:691:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:695:1: ( rule__FQN__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:696:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:702:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:706:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalContentAssistTestLanguage.g:707:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalContentAssistTestLanguage.g:707:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalContentAssistTestLanguage.g:708:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalContentAssistTestLanguage.g:709:2: ( rule__FQN__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:709:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_8);
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
    // InternalContentAssistTestLanguage.g:718:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:722:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalContentAssistTestLanguage.g:723:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:730:1: rule__FQN__Group_1__0__Impl : ( '$' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:734:1: ( ( '$' ) )
            // InternalContentAssistTestLanguage.g:735:1: ( '$' )
            {
            // InternalContentAssistTestLanguage.g:735:1: ( '$' )
            // InternalContentAssistTestLanguage.g:736:2: '$'
            {
             before(grammarAccess.getFQNAccess().getDollarSignKeyword_1_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getDollarSignKeyword_1_0()); 

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
    // InternalContentAssistTestLanguage.g:745:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:749:1: ( rule__FQN__Group_1__1__Impl )
            // InternalContentAssistTestLanguage.g:750:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:756:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:760:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:761:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:761:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:762:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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


    // $ANTLR start "rule__QN__Group__0"
    // InternalContentAssistTestLanguage.g:772:1: rule__QN__Group__0 : rule__QN__Group__0__Impl rule__QN__Group__1 ;
    public final void rule__QN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:776:1: ( rule__QN__Group__0__Impl rule__QN__Group__1 )
            // InternalContentAssistTestLanguage.g:777:2: rule__QN__Group__0__Impl rule__QN__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__QN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QN__Group__1();

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
    // $ANTLR end "rule__QN__Group__0"


    // $ANTLR start "rule__QN__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:784:1: rule__QN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:788:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:789:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:789:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:790:2: RULE_ID
            {
             before(grammarAccess.getQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQNAccess().getIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__QN__Group__0__Impl"


    // $ANTLR start "rule__QN__Group__1"
    // InternalContentAssistTestLanguage.g:799:1: rule__QN__Group__1 : rule__QN__Group__1__Impl ;
    public final void rule__QN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:803:1: ( rule__QN__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:804:2: rule__QN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QN__Group__1__Impl();

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
    // $ANTLR end "rule__QN__Group__1"


    // $ANTLR start "rule__QN__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:810:1: rule__QN__Group__1__Impl : ( ( rule__QN__Group_1__0 )* ) ;
    public final void rule__QN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:814:1: ( ( ( rule__QN__Group_1__0 )* ) )
            // InternalContentAssistTestLanguage.g:815:1: ( ( rule__QN__Group_1__0 )* )
            {
            // InternalContentAssistTestLanguage.g:815:1: ( ( rule__QN__Group_1__0 )* )
            // InternalContentAssistTestLanguage.g:816:2: ( rule__QN__Group_1__0 )*
            {
             before(grammarAccess.getQNAccess().getGroup_1()); 
            // InternalContentAssistTestLanguage.g:817:2: ( rule__QN__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:817:3: rule__QN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__QN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getQNAccess().getGroup_1()); 

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
    // $ANTLR end "rule__QN__Group__1__Impl"


    // $ANTLR start "rule__QN__Group_1__0"
    // InternalContentAssistTestLanguage.g:826:1: rule__QN__Group_1__0 : rule__QN__Group_1__0__Impl rule__QN__Group_1__1 ;
    public final void rule__QN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:830:1: ( rule__QN__Group_1__0__Impl rule__QN__Group_1__1 )
            // InternalContentAssistTestLanguage.g:831:2: rule__QN__Group_1__0__Impl rule__QN__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__QN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QN__Group_1__1();

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
    // $ANTLR end "rule__QN__Group_1__0"


    // $ANTLR start "rule__QN__Group_1__0__Impl"
    // InternalContentAssistTestLanguage.g:838:1: rule__QN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:842:1: ( ( '.' ) )
            // InternalContentAssistTestLanguage.g:843:1: ( '.' )
            {
            // InternalContentAssistTestLanguage.g:843:1: ( '.' )
            // InternalContentAssistTestLanguage.g:844:2: '.'
            {
             before(grammarAccess.getQNAccess().getFullStopKeyword_1_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getQNAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end "rule__QN__Group_1__0__Impl"


    // $ANTLR start "rule__QN__Group_1__1"
    // InternalContentAssistTestLanguage.g:853:1: rule__QN__Group_1__1 : rule__QN__Group_1__1__Impl ;
    public final void rule__QN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:857:1: ( rule__QN__Group_1__1__Impl )
            // InternalContentAssistTestLanguage.g:858:2: rule__QN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QN__Group_1__1__Impl();

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
    // $ANTLR end "rule__QN__Group_1__1"


    // $ANTLR start "rule__QN__Group_1__1__Impl"
    // InternalContentAssistTestLanguage.g:864:1: rule__QN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:868:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:869:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:869:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:870:2: RULE_ID
            {
             before(grammarAccess.getQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQNAccess().getIDTerminalRuleCall_1_1()); 

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
    // $ANTLR end "rule__QN__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ImportsAssignment_0"
    // InternalContentAssistTestLanguage.g:880:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:884:1: ( ( ruleImport ) )
            // InternalContentAssistTestLanguage.g:885:2: ( ruleImport )
            {
            // InternalContentAssistTestLanguage.g:885:2: ( ruleImport )
            // InternalContentAssistTestLanguage.g:886:3: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Model__ImportsAssignment_0"


    // $ANTLR start "rule__Model__GenerateDirectiveAssignment_1"
    // InternalContentAssistTestLanguage.g:895:1: rule__Model__GenerateDirectiveAssignment_1 : ( ruleGenerateDirective ) ;
    public final void rule__Model__GenerateDirectiveAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:899:1: ( ( ruleGenerateDirective ) )
            // InternalContentAssistTestLanguage.g:900:2: ( ruleGenerateDirective )
            {
            // InternalContentAssistTestLanguage.g:900:2: ( ruleGenerateDirective )
            // InternalContentAssistTestLanguage.g:901:3: ruleGenerateDirective
            {
             before(grammarAccess.getModelAccess().getGenerateDirectiveGenerateDirectiveParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGenerateDirective();

            state._fsp--;

             after(grammarAccess.getModelAccess().getGenerateDirectiveGenerateDirectiveParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Model__GenerateDirectiveAssignment_1"


    // $ANTLR start "rule__Model__ReferenceHolderAssignment_2"
    // InternalContentAssistTestLanguage.g:910:1: rule__Model__ReferenceHolderAssignment_2 : ( ruleReferenceHolder ) ;
    public final void rule__Model__ReferenceHolderAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:914:1: ( ( ruleReferenceHolder ) )
            // InternalContentAssistTestLanguage.g:915:2: ( ruleReferenceHolder )
            {
            // InternalContentAssistTestLanguage.g:915:2: ( ruleReferenceHolder )
            // InternalContentAssistTestLanguage.g:916:3: ruleReferenceHolder
            {
             before(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Model__ReferenceHolderAssignment_2"


    // $ANTLR start "rule__ReferenceHolder__DefaultReferenceAssignment_0_1"
    // InternalContentAssistTestLanguage.g:925:1: rule__ReferenceHolder__DefaultReferenceAssignment_0_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__DefaultReferenceAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:929:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistTestLanguage.g:930:2: ( ( ruleFQN ) )
            {
            // InternalContentAssistTestLanguage.g:930:2: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:931:3: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_0_1_0()); 
            // InternalContentAssistTestLanguage.g:932:3: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:933:4: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_0_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_0_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_0_1_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__DefaultReferenceAssignment_0_1"


    // $ANTLR start "rule__ReferenceHolder__CustomizedReferenceAssignment_1_1"
    // InternalContentAssistTestLanguage.g:944:1: rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__CustomizedReferenceAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:948:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistTestLanguage.g:949:2: ( ( ruleFQN ) )
            {
            // InternalContentAssistTestLanguage.g:949:2: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:950:3: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeCrossReference_1_1_0()); 
            // InternalContentAssistTestLanguage.g:951:3: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:952:4: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeFQNParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeFQNParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeCrossReference_1_1_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__CustomizedReferenceAssignment_1_1"


    // $ANTLR start "rule__ReferenceHolder__SubtypeReferenceAssignment_2_1"
    // InternalContentAssistTestLanguage.g:963:1: rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__SubtypeReferenceAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:967:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistTestLanguage.g:968:2: ( ( ruleFQN ) )
            {
            // InternalContentAssistTestLanguage.g:968:2: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:969:3: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeCrossReference_2_1_0()); 
            // InternalContentAssistTestLanguage.g:970:3: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:971:4: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeFQNParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeFQNParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeCrossReference_2_1_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__SubtypeReferenceAssignment_2_1"


    // $ANTLR start "rule__GenerateDirective__TypeNameAssignment_1"
    // InternalContentAssistTestLanguage.g:982:1: rule__GenerateDirective__TypeNameAssignment_1 : ( ruleQN ) ;
    public final void rule__GenerateDirective__TypeNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:986:1: ( ( ruleQN ) )
            // InternalContentAssistTestLanguage.g:987:2: ( ruleQN )
            {
            // InternalContentAssistTestLanguage.g:987:2: ( ruleQN )
            // InternalContentAssistTestLanguage.g:988:3: ruleQN
            {
             before(grammarAccess.getGenerateDirectiveAccess().getTypeNameQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQN();

            state._fsp--;

             after(grammarAccess.getGenerateDirectiveAccess().getTypeNameQNParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__GenerateDirective__TypeNameAssignment_1"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // InternalContentAssistTestLanguage.g:997:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:1001:1: ( ( ruleImportedFQN ) )
            // InternalContentAssistTestLanguage.g:1002:2: ( ruleImportedFQN )
            {
            // InternalContentAssistTestLanguage.g:1002:2: ( ruleImportedFQN )
            // InternalContentAssistTestLanguage.g:1003:3: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0()); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040002L});

}
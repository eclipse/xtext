package org.eclipse.xtext.builder.tests.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.builder.tests.services.BuilderTestLanguageGrammarAccess;



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
public class InternalBuilderTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'namespace'", "'{'", "'}'", "'import'", "'object'", "'references'", "'otherRefs'", "','", "'.'"
    };
    public static final int RULE_STRING=6;
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
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalBuilderTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBuilderTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBuilderTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBuilderTestLanguage.g"; }


    	private BuilderTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(BuilderTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleNamedElement"
    // InternalBuilderTestLanguage.g:58:1: entryRuleNamedElement : ruleNamedElement EOF ;
    public final void entryRuleNamedElement() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:59:1: ( ruleNamedElement EOF )
            // InternalBuilderTestLanguage.g:60:1: ruleNamedElement EOF
            {
             before(grammarAccess.getNamedElementRule()); 
            pushFollow(FOLLOW_1);
            ruleNamedElement();

            state._fsp--;

             after(grammarAccess.getNamedElementRule()); 
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
    // $ANTLR end "entryRuleNamedElement"


    // $ANTLR start "ruleNamedElement"
    // InternalBuilderTestLanguage.g:67:1: ruleNamedElement : ( ( rule__NamedElement__Alternatives ) ) ;
    public final void ruleNamedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:71:2: ( ( ( rule__NamedElement__Alternatives ) ) )
            // InternalBuilderTestLanguage.g:72:2: ( ( rule__NamedElement__Alternatives ) )
            {
            // InternalBuilderTestLanguage.g:72:2: ( ( rule__NamedElement__Alternatives ) )
            // InternalBuilderTestLanguage.g:73:3: ( rule__NamedElement__Alternatives )
            {
             before(grammarAccess.getNamedElementAccess().getAlternatives()); 
            // InternalBuilderTestLanguage.g:74:3: ( rule__NamedElement__Alternatives )
            // InternalBuilderTestLanguage.g:74:4: rule__NamedElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NamedElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNamedElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamedElement"


    // $ANTLR start "entryRuleNamespace"
    // InternalBuilderTestLanguage.g:83:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:84:1: ( ruleNamespace EOF )
            // InternalBuilderTestLanguage.g:85:1: ruleNamespace EOF
            {
             before(grammarAccess.getNamespaceRule()); 
            pushFollow(FOLLOW_1);
            ruleNamespace();

            state._fsp--;

             after(grammarAccess.getNamespaceRule()); 
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
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalBuilderTestLanguage.g:92:1: ruleNamespace : ( ( rule__Namespace__Group__0 ) ) ;
    public final void ruleNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:96:2: ( ( ( rule__Namespace__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:97:2: ( ( rule__Namespace__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:97:2: ( ( rule__Namespace__Group__0 ) )
            // InternalBuilderTestLanguage.g:98:3: ( rule__Namespace__Group__0 )
            {
             before(grammarAccess.getNamespaceAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:99:3: ( rule__Namespace__Group__0 )
            // InternalBuilderTestLanguage.g:99:4: rule__Namespace__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Namespace__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNamespaceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleImport"
    // InternalBuilderTestLanguage.g:108:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:109:1: ( ruleImport EOF )
            // InternalBuilderTestLanguage.g:110:1: ruleImport EOF
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
    // InternalBuilderTestLanguage.g:117:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:121:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:122:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:122:2: ( ( rule__Import__Group__0 ) )
            // InternalBuilderTestLanguage.g:123:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:124:3: ( rule__Import__Group__0 )
            // InternalBuilderTestLanguage.g:124:4: rule__Import__Group__0
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


    // $ANTLR start "entryRuleElement"
    // InternalBuilderTestLanguage.g:133:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:134:1: ( ruleElement EOF )
            // InternalBuilderTestLanguage.g:135:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalBuilderTestLanguage.g:142:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:146:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:147:2: ( ( rule__Element__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:147:2: ( ( rule__Element__Group__0 ) )
            // InternalBuilderTestLanguage.g:148:3: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:149:3: ( rule__Element__Group__0 )
            // InternalBuilderTestLanguage.g:149:4: rule__Element__Group__0
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleQualifiedName"
    // InternalBuilderTestLanguage.g:158:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:159:1: ( ruleQualifiedName EOF )
            // InternalBuilderTestLanguage.g:160:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalBuilderTestLanguage.g:167:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:171:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:172:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:172:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalBuilderTestLanguage.g:173:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:174:3: ( rule__QualifiedName__Group__0 )
            // InternalBuilderTestLanguage.g:174:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "rule__NamedElement__Alternatives"
    // InternalBuilderTestLanguage.g:182:1: rule__NamedElement__Alternatives : ( ( ruleNamespace ) | ( ruleElement ) );
    public final void rule__NamedElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:186:1: ( ( ruleNamespace ) | ( ruleElement ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
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
                    // InternalBuilderTestLanguage.g:187:2: ( ruleNamespace )
                    {
                    // InternalBuilderTestLanguage.g:187:2: ( ruleNamespace )
                    // InternalBuilderTestLanguage.g:188:3: ruleNamespace
                    {
                     before(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNamespace();

                    state._fsp--;

                     after(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBuilderTestLanguage.g:193:2: ( ruleElement )
                    {
                    // InternalBuilderTestLanguage.g:193:2: ( ruleElement )
                    // InternalBuilderTestLanguage.g:194:3: ruleElement
                    {
                     before(grammarAccess.getNamedElementAccess().getElementParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleElement();

                    state._fsp--;

                     after(grammarAccess.getNamedElementAccess().getElementParserRuleCall_1()); 

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
    // $ANTLR end "rule__NamedElement__Alternatives"


    // $ANTLR start "rule__Namespace__Group__0"
    // InternalBuilderTestLanguage.g:203:1: rule__Namespace__Group__0 : rule__Namespace__Group__0__Impl rule__Namespace__Group__1 ;
    public final void rule__Namespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:207:1: ( rule__Namespace__Group__0__Impl rule__Namespace__Group__1 )
            // InternalBuilderTestLanguage.g:208:2: rule__Namespace__Group__0__Impl rule__Namespace__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Namespace__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Namespace__Group__1();

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
    // $ANTLR end "rule__Namespace__Group__0"


    // $ANTLR start "rule__Namespace__Group__0__Impl"
    // InternalBuilderTestLanguage.g:215:1: rule__Namespace__Group__0__Impl : ( 'namespace' ) ;
    public final void rule__Namespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:219:1: ( ( 'namespace' ) )
            // InternalBuilderTestLanguage.g:220:1: ( 'namespace' )
            {
            // InternalBuilderTestLanguage.g:220:1: ( 'namespace' )
            // InternalBuilderTestLanguage.g:221:2: 'namespace'
            {
             before(grammarAccess.getNamespaceAccess().getNamespaceKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getNamespaceAccess().getNamespaceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Group__0__Impl"


    // $ANTLR start "rule__Namespace__Group__1"
    // InternalBuilderTestLanguage.g:230:1: rule__Namespace__Group__1 : rule__Namespace__Group__1__Impl rule__Namespace__Group__2 ;
    public final void rule__Namespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:234:1: ( rule__Namespace__Group__1__Impl rule__Namespace__Group__2 )
            // InternalBuilderTestLanguage.g:235:2: rule__Namespace__Group__1__Impl rule__Namespace__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Namespace__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Namespace__Group__2();

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
    // $ANTLR end "rule__Namespace__Group__1"


    // $ANTLR start "rule__Namespace__Group__1__Impl"
    // InternalBuilderTestLanguage.g:242:1: rule__Namespace__Group__1__Impl : ( ( rule__Namespace__NameAssignment_1 ) ) ;
    public final void rule__Namespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:246:1: ( ( ( rule__Namespace__NameAssignment_1 ) ) )
            // InternalBuilderTestLanguage.g:247:1: ( ( rule__Namespace__NameAssignment_1 ) )
            {
            // InternalBuilderTestLanguage.g:247:1: ( ( rule__Namespace__NameAssignment_1 ) )
            // InternalBuilderTestLanguage.g:248:2: ( rule__Namespace__NameAssignment_1 )
            {
             before(grammarAccess.getNamespaceAccess().getNameAssignment_1()); 
            // InternalBuilderTestLanguage.g:249:2: ( rule__Namespace__NameAssignment_1 )
            // InternalBuilderTestLanguage.g:249:3: rule__Namespace__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Namespace__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNamespaceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Group__1__Impl"


    // $ANTLR start "rule__Namespace__Group__2"
    // InternalBuilderTestLanguage.g:257:1: rule__Namespace__Group__2 : rule__Namespace__Group__2__Impl rule__Namespace__Group__3 ;
    public final void rule__Namespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:261:1: ( rule__Namespace__Group__2__Impl rule__Namespace__Group__3 )
            // InternalBuilderTestLanguage.g:262:2: rule__Namespace__Group__2__Impl rule__Namespace__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Namespace__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Namespace__Group__3();

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
    // $ANTLR end "rule__Namespace__Group__2"


    // $ANTLR start "rule__Namespace__Group__2__Impl"
    // InternalBuilderTestLanguage.g:269:1: rule__Namespace__Group__2__Impl : ( '{' ) ;
    public final void rule__Namespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:273:1: ( ( '{' ) )
            // InternalBuilderTestLanguage.g:274:1: ( '{' )
            {
            // InternalBuilderTestLanguage.g:274:1: ( '{' )
            // InternalBuilderTestLanguage.g:275:2: '{'
            {
             before(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Group__2__Impl"


    // $ANTLR start "rule__Namespace__Group__3"
    // InternalBuilderTestLanguage.g:284:1: rule__Namespace__Group__3 : rule__Namespace__Group__3__Impl rule__Namespace__Group__4 ;
    public final void rule__Namespace__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:288:1: ( rule__Namespace__Group__3__Impl rule__Namespace__Group__4 )
            // InternalBuilderTestLanguage.g:289:2: rule__Namespace__Group__3__Impl rule__Namespace__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Namespace__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Namespace__Group__4();

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
    // $ANTLR end "rule__Namespace__Group__3"


    // $ANTLR start "rule__Namespace__Group__3__Impl"
    // InternalBuilderTestLanguage.g:296:1: rule__Namespace__Group__3__Impl : ( ( rule__Namespace__ImportsAssignment_3 )* ) ;
    public final void rule__Namespace__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:300:1: ( ( ( rule__Namespace__ImportsAssignment_3 )* ) )
            // InternalBuilderTestLanguage.g:301:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            {
            // InternalBuilderTestLanguage.g:301:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            // InternalBuilderTestLanguage.g:302:2: ( rule__Namespace__ImportsAssignment_3 )*
            {
             before(grammarAccess.getNamespaceAccess().getImportsAssignment_3()); 
            // InternalBuilderTestLanguage.g:303:2: ( rule__Namespace__ImportsAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:303:3: rule__Namespace__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Namespace__ImportsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getNamespaceAccess().getImportsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Group__3__Impl"


    // $ANTLR start "rule__Namespace__Group__4"
    // InternalBuilderTestLanguage.g:311:1: rule__Namespace__Group__4 : rule__Namespace__Group__4__Impl rule__Namespace__Group__5 ;
    public final void rule__Namespace__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:315:1: ( rule__Namespace__Group__4__Impl rule__Namespace__Group__5 )
            // InternalBuilderTestLanguage.g:316:2: rule__Namespace__Group__4__Impl rule__Namespace__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__Namespace__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Namespace__Group__5();

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
    // $ANTLR end "rule__Namespace__Group__4"


    // $ANTLR start "rule__Namespace__Group__4__Impl"
    // InternalBuilderTestLanguage.g:323:1: rule__Namespace__Group__4__Impl : ( ( rule__Namespace__ElementsAssignment_4 )* ) ;
    public final void rule__Namespace__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:327:1: ( ( ( rule__Namespace__ElementsAssignment_4 )* ) )
            // InternalBuilderTestLanguage.g:328:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            {
            // InternalBuilderTestLanguage.g:328:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            // InternalBuilderTestLanguage.g:329:2: ( rule__Namespace__ElementsAssignment_4 )*
            {
             before(grammarAccess.getNamespaceAccess().getElementsAssignment_4()); 
            // InternalBuilderTestLanguage.g:330:2: ( rule__Namespace__ElementsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:330:3: rule__Namespace__ElementsAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Namespace__ElementsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getNamespaceAccess().getElementsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Group__4__Impl"


    // $ANTLR start "rule__Namespace__Group__5"
    // InternalBuilderTestLanguage.g:338:1: rule__Namespace__Group__5 : rule__Namespace__Group__5__Impl ;
    public final void rule__Namespace__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:342:1: ( rule__Namespace__Group__5__Impl )
            // InternalBuilderTestLanguage.g:343:2: rule__Namespace__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Namespace__Group__5__Impl();

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
    // $ANTLR end "rule__Namespace__Group__5"


    // $ANTLR start "rule__Namespace__Group__5__Impl"
    // InternalBuilderTestLanguage.g:349:1: rule__Namespace__Group__5__Impl : ( '}' ) ;
    public final void rule__Namespace__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:353:1: ( ( '}' ) )
            // InternalBuilderTestLanguage.g:354:1: ( '}' )
            {
            // InternalBuilderTestLanguage.g:354:1: ( '}' )
            // InternalBuilderTestLanguage.g:355:2: '}'
            {
             before(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_5()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Group__5__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalBuilderTestLanguage.g:365:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:369:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalBuilderTestLanguage.g:370:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_3);
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
    // InternalBuilderTestLanguage.g:377:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:381:1: ( ( 'import' ) )
            // InternalBuilderTestLanguage.g:382:1: ( 'import' )
            {
            // InternalBuilderTestLanguage.g:382:1: ( 'import' )
            // InternalBuilderTestLanguage.g:383:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,14,FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:392:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:396:1: ( rule__Import__Group__1__Impl )
            // InternalBuilderTestLanguage.g:397:2: rule__Import__Group__1__Impl
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
    // InternalBuilderTestLanguage.g:403:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:407:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalBuilderTestLanguage.g:408:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalBuilderTestLanguage.g:408:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalBuilderTestLanguage.g:409:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalBuilderTestLanguage.g:410:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalBuilderTestLanguage.g:410:3: rule__Import__ImportedNamespaceAssignment_1
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


    // $ANTLR start "rule__Element__Group__0"
    // InternalBuilderTestLanguage.g:419:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:423:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalBuilderTestLanguage.g:424:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Element__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:431:1: rule__Element__Group__0__Impl : ( 'object' ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:435:1: ( ( 'object' ) )
            // InternalBuilderTestLanguage.g:436:1: ( 'object' )
            {
            // InternalBuilderTestLanguage.g:436:1: ( 'object' )
            // InternalBuilderTestLanguage.g:437:2: 'object'
            {
             before(grammarAccess.getElementAccess().getObjectKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getObjectKeyword_0()); 

            }


            }

        }
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
    // InternalBuilderTestLanguage.g:446:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:450:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalBuilderTestLanguage.g:451:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Element__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__2();

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
    // InternalBuilderTestLanguage.g:458:1: rule__Element__Group__1__Impl : ( ( rule__Element__NameAssignment_1 ) ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:462:1: ( ( ( rule__Element__NameAssignment_1 ) ) )
            // InternalBuilderTestLanguage.g:463:1: ( ( rule__Element__NameAssignment_1 ) )
            {
            // InternalBuilderTestLanguage.g:463:1: ( ( rule__Element__NameAssignment_1 ) )
            // InternalBuilderTestLanguage.g:464:2: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // InternalBuilderTestLanguage.g:465:2: ( rule__Element__NameAssignment_1 )
            // InternalBuilderTestLanguage.g:465:3: rule__Element__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getNameAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Element__Group__2"
    // InternalBuilderTestLanguage.g:473:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:477:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalBuilderTestLanguage.g:478:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Element__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__3();

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
    // $ANTLR end "rule__Element__Group__2"


    // $ANTLR start "rule__Element__Group__2__Impl"
    // InternalBuilderTestLanguage.g:485:1: rule__Element__Group__2__Impl : ( ( rule__Element__Group_2__0 )? ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:489:1: ( ( ( rule__Element__Group_2__0 )? ) )
            // InternalBuilderTestLanguage.g:490:1: ( ( rule__Element__Group_2__0 )? )
            {
            // InternalBuilderTestLanguage.g:490:1: ( ( rule__Element__Group_2__0 )? )
            // InternalBuilderTestLanguage.g:491:2: ( rule__Element__Group_2__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_2()); 
            // InternalBuilderTestLanguage.g:492:2: ( rule__Element__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBuilderTestLanguage.g:492:3: rule__Element__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Element__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__2__Impl"


    // $ANTLR start "rule__Element__Group__3"
    // InternalBuilderTestLanguage.g:500:1: rule__Element__Group__3 : rule__Element__Group__3__Impl ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:504:1: ( rule__Element__Group__3__Impl )
            // InternalBuilderTestLanguage.g:505:2: rule__Element__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group__3__Impl();

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
    // $ANTLR end "rule__Element__Group__3"


    // $ANTLR start "rule__Element__Group__3__Impl"
    // InternalBuilderTestLanguage.g:511:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:515:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // InternalBuilderTestLanguage.g:516:1: ( ( rule__Element__Group_3__0 )? )
            {
            // InternalBuilderTestLanguage.g:516:1: ( ( rule__Element__Group_3__0 )? )
            // InternalBuilderTestLanguage.g:517:2: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // InternalBuilderTestLanguage.g:518:2: ( rule__Element__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBuilderTestLanguage.g:518:3: rule__Element__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Element__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__3__Impl"


    // $ANTLR start "rule__Element__Group_2__0"
    // InternalBuilderTestLanguage.g:527:1: rule__Element__Group_2__0 : rule__Element__Group_2__0__Impl rule__Element__Group_2__1 ;
    public final void rule__Element__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:531:1: ( rule__Element__Group_2__0__Impl rule__Element__Group_2__1 )
            // InternalBuilderTestLanguage.g:532:2: rule__Element__Group_2__0__Impl rule__Element__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__Element__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_2__1();

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
    // $ANTLR end "rule__Element__Group_2__0"


    // $ANTLR start "rule__Element__Group_2__0__Impl"
    // InternalBuilderTestLanguage.g:539:1: rule__Element__Group_2__0__Impl : ( 'references' ) ;
    public final void rule__Element__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:543:1: ( ( 'references' ) )
            // InternalBuilderTestLanguage.g:544:1: ( 'references' )
            {
            // InternalBuilderTestLanguage.g:544:1: ( 'references' )
            // InternalBuilderTestLanguage.g:545:2: 'references'
            {
             before(grammarAccess.getElementAccess().getReferencesKeyword_2_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getReferencesKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_2__0__Impl"


    // $ANTLR start "rule__Element__Group_2__1"
    // InternalBuilderTestLanguage.g:554:1: rule__Element__Group_2__1 : rule__Element__Group_2__1__Impl ;
    public final void rule__Element__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:558:1: ( rule__Element__Group_2__1__Impl )
            // InternalBuilderTestLanguage.g:559:2: rule__Element__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_2__1__Impl();

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
    // $ANTLR end "rule__Element__Group_2__1"


    // $ANTLR start "rule__Element__Group_2__1__Impl"
    // InternalBuilderTestLanguage.g:565:1: rule__Element__Group_2__1__Impl : ( ( rule__Element__ReferencesAssignment_2_1 ) ) ;
    public final void rule__Element__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:569:1: ( ( ( rule__Element__ReferencesAssignment_2_1 ) ) )
            // InternalBuilderTestLanguage.g:570:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            {
            // InternalBuilderTestLanguage.g:570:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            // InternalBuilderTestLanguage.g:571:2: ( rule__Element__ReferencesAssignment_2_1 )
            {
             before(grammarAccess.getElementAccess().getReferencesAssignment_2_1()); 
            // InternalBuilderTestLanguage.g:572:2: ( rule__Element__ReferencesAssignment_2_1 )
            // InternalBuilderTestLanguage.g:572:3: rule__Element__ReferencesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__ReferencesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getReferencesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_2__1__Impl"


    // $ANTLR start "rule__Element__Group_3__0"
    // InternalBuilderTestLanguage.g:581:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:585:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // InternalBuilderTestLanguage.g:586:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Element__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_3__1();

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
    // $ANTLR end "rule__Element__Group_3__0"


    // $ANTLR start "rule__Element__Group_3__0__Impl"
    // InternalBuilderTestLanguage.g:593:1: rule__Element__Group_3__0__Impl : ( 'otherRefs' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:597:1: ( ( 'otherRefs' ) )
            // InternalBuilderTestLanguage.g:598:1: ( 'otherRefs' )
            {
            // InternalBuilderTestLanguage.g:598:1: ( 'otherRefs' )
            // InternalBuilderTestLanguage.g:599:2: 'otherRefs'
            {
             before(grammarAccess.getElementAccess().getOtherRefsKeyword_3_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getOtherRefsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__0__Impl"


    // $ANTLR start "rule__Element__Group_3__1"
    // InternalBuilderTestLanguage.g:608:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl rule__Element__Group_3__2 ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:612:1: ( rule__Element__Group_3__1__Impl rule__Element__Group_3__2 )
            // InternalBuilderTestLanguage.g:613:2: rule__Element__Group_3__1__Impl rule__Element__Group_3__2
            {
            pushFollow(FOLLOW_9);
            rule__Element__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_3__2();

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
    // $ANTLR end "rule__Element__Group_3__1"


    // $ANTLR start "rule__Element__Group_3__1__Impl"
    // InternalBuilderTestLanguage.g:620:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__OtherRefsAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:624:1: ( ( ( rule__Element__OtherRefsAssignment_3_1 ) ) )
            // InternalBuilderTestLanguage.g:625:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            {
            // InternalBuilderTestLanguage.g:625:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            // InternalBuilderTestLanguage.g:626:2: ( rule__Element__OtherRefsAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1()); 
            // InternalBuilderTestLanguage.g:627:2: ( rule__Element__OtherRefsAssignment_3_1 )
            // InternalBuilderTestLanguage.g:627:3: rule__Element__OtherRefsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__OtherRefsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__1__Impl"


    // $ANTLR start "rule__Element__Group_3__2"
    // InternalBuilderTestLanguage.g:635:1: rule__Element__Group_3__2 : rule__Element__Group_3__2__Impl ;
    public final void rule__Element__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:639:1: ( rule__Element__Group_3__2__Impl )
            // InternalBuilderTestLanguage.g:640:2: rule__Element__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_3__2__Impl();

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
    // $ANTLR end "rule__Element__Group_3__2"


    // $ANTLR start "rule__Element__Group_3__2__Impl"
    // InternalBuilderTestLanguage.g:646:1: rule__Element__Group_3__2__Impl : ( ( rule__Element__Group_3_2__0 )* ) ;
    public final void rule__Element__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:650:1: ( ( ( rule__Element__Group_3_2__0 )* ) )
            // InternalBuilderTestLanguage.g:651:1: ( ( rule__Element__Group_3_2__0 )* )
            {
            // InternalBuilderTestLanguage.g:651:1: ( ( rule__Element__Group_3_2__0 )* )
            // InternalBuilderTestLanguage.g:652:2: ( rule__Element__Group_3_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_3_2()); 
            // InternalBuilderTestLanguage.g:653:2: ( rule__Element__Group_3_2__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:653:3: rule__Element__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Element__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__2__Impl"


    // $ANTLR start "rule__Element__Group_3_2__0"
    // InternalBuilderTestLanguage.g:662:1: rule__Element__Group_3_2__0 : rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1 ;
    public final void rule__Element__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:666:1: ( rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1 )
            // InternalBuilderTestLanguage.g:667:2: rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1
            {
            pushFollow(FOLLOW_3);
            rule__Element__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_3_2__1();

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
    // $ANTLR end "rule__Element__Group_3_2__0"


    // $ANTLR start "rule__Element__Group_3_2__0__Impl"
    // InternalBuilderTestLanguage.g:674:1: rule__Element__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Element__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:678:1: ( ( ',' ) )
            // InternalBuilderTestLanguage.g:679:1: ( ',' )
            {
            // InternalBuilderTestLanguage.g:679:1: ( ',' )
            // InternalBuilderTestLanguage.g:680:2: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_3_2_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getCommaKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3_2__0__Impl"


    // $ANTLR start "rule__Element__Group_3_2__1"
    // InternalBuilderTestLanguage.g:689:1: rule__Element__Group_3_2__1 : rule__Element__Group_3_2__1__Impl ;
    public final void rule__Element__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:693:1: ( rule__Element__Group_3_2__1__Impl )
            // InternalBuilderTestLanguage.g:694:2: rule__Element__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_3_2__1__Impl();

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
    // $ANTLR end "rule__Element__Group_3_2__1"


    // $ANTLR start "rule__Element__Group_3_2__1__Impl"
    // InternalBuilderTestLanguage.g:700:1: rule__Element__Group_3_2__1__Impl : ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) ;
    public final void rule__Element__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:704:1: ( ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) )
            // InternalBuilderTestLanguage.g:705:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            {
            // InternalBuilderTestLanguage.g:705:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            // InternalBuilderTestLanguage.g:706:2: ( rule__Element__OtherRefsAssignment_3_2_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_2_1()); 
            // InternalBuilderTestLanguage.g:707:2: ( rule__Element__OtherRefsAssignment_3_2_1 )
            // InternalBuilderTestLanguage.g:707:3: rule__Element__OtherRefsAssignment_3_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__OtherRefsAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getOtherRefsAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3_2__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalBuilderTestLanguage.g:716:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:720:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalBuilderTestLanguage.g:721:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

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
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalBuilderTestLanguage.g:728:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:732:1: ( ( RULE_ID ) )
            // InternalBuilderTestLanguage.g:733:1: ( RULE_ID )
            {
            // InternalBuilderTestLanguage.g:733:1: ( RULE_ID )
            // InternalBuilderTestLanguage.g:734:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalBuilderTestLanguage.g:743:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:747:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalBuilderTestLanguage.g:748:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalBuilderTestLanguage.g:754:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:758:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalBuilderTestLanguage.g:759:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalBuilderTestLanguage.g:759:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalBuilderTestLanguage.g:760:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalBuilderTestLanguage.g:761:2: ( rule__QualifiedName__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:761:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalBuilderTestLanguage.g:770:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:774:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalBuilderTestLanguage.g:775:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

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
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalBuilderTestLanguage.g:782:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:786:1: ( ( '.' ) )
            // InternalBuilderTestLanguage.g:787:1: ( '.' )
            {
            // InternalBuilderTestLanguage.g:787:1: ( '.' )
            // InternalBuilderTestLanguage.g:788:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalBuilderTestLanguage.g:797:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:801:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalBuilderTestLanguage.g:802:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalBuilderTestLanguage.g:808:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:812:1: ( ( RULE_ID ) )
            // InternalBuilderTestLanguage.g:813:1: ( RULE_ID )
            {
            // InternalBuilderTestLanguage.g:813:1: ( RULE_ID )
            // InternalBuilderTestLanguage.g:814:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Namespace__NameAssignment_1"
    // InternalBuilderTestLanguage.g:824:1: rule__Namespace__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Namespace__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:828:1: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:829:2: ( ruleQualifiedName )
            {
            // InternalBuilderTestLanguage.g:829:2: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:830:3: ruleQualifiedName
            {
             before(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__NameAssignment_1"


    // $ANTLR start "rule__Namespace__ImportsAssignment_3"
    // InternalBuilderTestLanguage.g:839:1: rule__Namespace__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__Namespace__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:843:1: ( ( ruleImport ) )
            // InternalBuilderTestLanguage.g:844:2: ( ruleImport )
            {
            // InternalBuilderTestLanguage.g:844:2: ( ruleImport )
            // InternalBuilderTestLanguage.g:845:3: ruleImport
            {
             before(grammarAccess.getNamespaceAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getNamespaceAccess().getImportsImportParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__ImportsAssignment_3"


    // $ANTLR start "rule__Namespace__ElementsAssignment_4"
    // InternalBuilderTestLanguage.g:854:1: rule__Namespace__ElementsAssignment_4 : ( ruleNamedElement ) ;
    public final void rule__Namespace__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:858:1: ( ( ruleNamedElement ) )
            // InternalBuilderTestLanguage.g:859:2: ( ruleNamedElement )
            {
            // InternalBuilderTestLanguage.g:859:2: ( ruleNamedElement )
            // InternalBuilderTestLanguage.g:860:3: ruleNamedElement
            {
             before(grammarAccess.getNamespaceAccess().getElementsNamedElementParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleNamedElement();

            state._fsp--;

             after(grammarAccess.getNamespaceAccess().getElementsNamedElementParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__ElementsAssignment_4"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // InternalBuilderTestLanguage.g:869:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:873:1: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:874:2: ( ruleQualifiedName )
            {
            // InternalBuilderTestLanguage.g:874:2: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:875:3: ruleQualifiedName
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__Element__NameAssignment_1"
    // InternalBuilderTestLanguage.g:884:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:888:1: ( ( RULE_ID ) )
            // InternalBuilderTestLanguage.g:889:2: ( RULE_ID )
            {
            // InternalBuilderTestLanguage.g:889:2: ( RULE_ID )
            // InternalBuilderTestLanguage.g:890:3: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__NameAssignment_1"


    // $ANTLR start "rule__Element__ReferencesAssignment_2_1"
    // InternalBuilderTestLanguage.g:899:1: rule__Element__ReferencesAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__ReferencesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:903:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBuilderTestLanguage.g:904:2: ( ( ruleQualifiedName ) )
            {
            // InternalBuilderTestLanguage.g:904:2: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:905:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0()); 
            // InternalBuilderTestLanguage.g:906:3: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:907:4: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getReferencesElementQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getElementAccess().getReferencesElementQualifiedNameParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__ReferencesAssignment_2_1"


    // $ANTLR start "rule__Element__OtherRefsAssignment_3_1"
    // InternalBuilderTestLanguage.g:918:1: rule__Element__OtherRefsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:922:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBuilderTestLanguage.g:923:2: ( ( ruleQualifiedName ) )
            {
            // InternalBuilderTestLanguage.g:923:2: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:924:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0()); 
            // InternalBuilderTestLanguage.g:925:3: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:926:4: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__OtherRefsAssignment_3_1"


    // $ANTLR start "rule__Element__OtherRefsAssignment_3_2_1"
    // InternalBuilderTestLanguage.g:937:1: rule__Element__OtherRefsAssignment_3_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:941:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBuilderTestLanguage.g:942:2: ( ( ruleQualifiedName ) )
            {
            // InternalBuilderTestLanguage.g:942:2: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:943:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0()); 
            // InternalBuilderTestLanguage.g:944:3: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:945:4: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_2_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__OtherRefsAssignment_3_2_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000E800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008802L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080002L});

}
package org.eclipse.xtext.testlanguages.fileAware.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.testlanguages.fileAware.services.FileAwareTestLanguageGrammarAccess;



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
public class InternalFileAwareTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'import'", "'element'", "'{'", "'}'", "'ref'", "'.'"
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


        public InternalFileAwareTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFileAwareTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFileAwareTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFileAwareTestLanguage.g"; }


    	private FileAwareTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(FileAwareTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRulePackageDeclaration"
    // InternalFileAwareTestLanguage.g:58:1: entryRulePackageDeclaration : rulePackageDeclaration EOF ;
    public final void entryRulePackageDeclaration() throws RecognitionException {
        try {
            // InternalFileAwareTestLanguage.g:59:1: ( rulePackageDeclaration EOF )
            // InternalFileAwareTestLanguage.g:60:1: rulePackageDeclaration EOF
            {
             before(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_1);
            rulePackageDeclaration();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationRule()); 
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
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // InternalFileAwareTestLanguage.g:67:1: rulePackageDeclaration : ( ( rule__PackageDeclaration__Group__0 ) ) ;
    public final void rulePackageDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:71:2: ( ( ( rule__PackageDeclaration__Group__0 ) ) )
            // InternalFileAwareTestLanguage.g:72:2: ( ( rule__PackageDeclaration__Group__0 ) )
            {
            // InternalFileAwareTestLanguage.g:72:2: ( ( rule__PackageDeclaration__Group__0 ) )
            // InternalFileAwareTestLanguage.g:73:3: ( rule__PackageDeclaration__Group__0 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getGroup()); 
            // InternalFileAwareTestLanguage.g:74:3: ( rule__PackageDeclaration__Group__0 )
            // InternalFileAwareTestLanguage.g:74:4: rule__PackageDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleImport"
    // InternalFileAwareTestLanguage.g:83:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalFileAwareTestLanguage.g:84:1: ( ruleImport EOF )
            // InternalFileAwareTestLanguage.g:85:1: ruleImport EOF
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
    // InternalFileAwareTestLanguage.g:92:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:96:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalFileAwareTestLanguage.g:97:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalFileAwareTestLanguage.g:97:2: ( ( rule__Import__Group__0 ) )
            // InternalFileAwareTestLanguage.g:98:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalFileAwareTestLanguage.g:99:3: ( rule__Import__Group__0 )
            // InternalFileAwareTestLanguage.g:99:4: rule__Import__Group__0
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
    // InternalFileAwareTestLanguage.g:108:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalFileAwareTestLanguage.g:109:1: ( ruleElement EOF )
            // InternalFileAwareTestLanguage.g:110:1: ruleElement EOF
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
    // InternalFileAwareTestLanguage.g:117:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:121:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalFileAwareTestLanguage.g:122:2: ( ( rule__Element__Group__0 ) )
            {
            // InternalFileAwareTestLanguage.g:122:2: ( ( rule__Element__Group__0 ) )
            // InternalFileAwareTestLanguage.g:123:3: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalFileAwareTestLanguage.g:124:3: ( rule__Element__Group__0 )
            // InternalFileAwareTestLanguage.g:124:4: rule__Element__Group__0
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
    // InternalFileAwareTestLanguage.g:133:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalFileAwareTestLanguage.g:134:1: ( ruleQualifiedName EOF )
            // InternalFileAwareTestLanguage.g:135:1: ruleQualifiedName EOF
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
    // InternalFileAwareTestLanguage.g:142:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:146:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalFileAwareTestLanguage.g:147:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalFileAwareTestLanguage.g:147:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalFileAwareTestLanguage.g:148:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalFileAwareTestLanguage.g:149:3: ( rule__QualifiedName__Group__0 )
            // InternalFileAwareTestLanguage.g:149:4: rule__QualifiedName__Group__0
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


    // $ANTLR start "rule__Element__Alternatives_3"
    // InternalFileAwareTestLanguage.g:157:1: rule__Element__Alternatives_3 : ( ( ( rule__Element__ContentsAssignment_3_0 ) ) | ( ( rule__Element__Group_3_1__0 ) ) );
    public final void rule__Element__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:161:1: ( ( ( rule__Element__ContentsAssignment_3_0 ) ) | ( ( rule__Element__Group_3_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==16) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalFileAwareTestLanguage.g:162:2: ( ( rule__Element__ContentsAssignment_3_0 ) )
                    {
                    // InternalFileAwareTestLanguage.g:162:2: ( ( rule__Element__ContentsAssignment_3_0 ) )
                    // InternalFileAwareTestLanguage.g:163:3: ( rule__Element__ContentsAssignment_3_0 )
                    {
                     before(grammarAccess.getElementAccess().getContentsAssignment_3_0()); 
                    // InternalFileAwareTestLanguage.g:164:3: ( rule__Element__ContentsAssignment_3_0 )
                    // InternalFileAwareTestLanguage.g:164:4: rule__Element__ContentsAssignment_3_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Element__ContentsAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getElementAccess().getContentsAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFileAwareTestLanguage.g:168:2: ( ( rule__Element__Group_3_1__0 ) )
                    {
                    // InternalFileAwareTestLanguage.g:168:2: ( ( rule__Element__Group_3_1__0 ) )
                    // InternalFileAwareTestLanguage.g:169:3: ( rule__Element__Group_3_1__0 )
                    {
                     before(grammarAccess.getElementAccess().getGroup_3_1()); 
                    // InternalFileAwareTestLanguage.g:170:3: ( rule__Element__Group_3_1__0 )
                    // InternalFileAwareTestLanguage.g:170:4: rule__Element__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Element__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getElementAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__Element__Alternatives_3"


    // $ANTLR start "rule__PackageDeclaration__Group__0"
    // InternalFileAwareTestLanguage.g:178:1: rule__PackageDeclaration__Group__0 : rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:182:1: ( rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 )
            // InternalFileAwareTestLanguage.g:183:2: rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__PackageDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__1();

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
    // $ANTLR end "rule__PackageDeclaration__Group__0"


    // $ANTLR start "rule__PackageDeclaration__Group__0__Impl"
    // InternalFileAwareTestLanguage.g:190:1: rule__PackageDeclaration__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:194:1: ( ( 'package' ) )
            // InternalFileAwareTestLanguage.g:195:1: ( 'package' )
            {
            // InternalFileAwareTestLanguage.g:195:1: ( 'package' )
            // InternalFileAwareTestLanguage.g:196:2: 'package'
            {
             before(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__0__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__1"
    // InternalFileAwareTestLanguage.g:205:1: rule__PackageDeclaration__Group__1 : rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:209:1: ( rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 )
            // InternalFileAwareTestLanguage.g:210:2: rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__PackageDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__2();

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
    // $ANTLR end "rule__PackageDeclaration__Group__1"


    // $ANTLR start "rule__PackageDeclaration__Group__1__Impl"
    // InternalFileAwareTestLanguage.g:217:1: rule__PackageDeclaration__Group__1__Impl : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) ;
    public final void rule__PackageDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:221:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) )
            // InternalFileAwareTestLanguage.g:222:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            {
            // InternalFileAwareTestLanguage.g:222:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // InternalFileAwareTestLanguage.g:223:2: ( rule__PackageDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            // InternalFileAwareTestLanguage.g:224:2: ( rule__PackageDeclaration__NameAssignment_1 )
            // InternalFileAwareTestLanguage.g:224:3: rule__PackageDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__1__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__2"
    // InternalFileAwareTestLanguage.g:232:1: rule__PackageDeclaration__Group__2 : rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 ;
    public final void rule__PackageDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:236:1: ( rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 )
            // InternalFileAwareTestLanguage.g:237:2: rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__PackageDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__3();

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
    // $ANTLR end "rule__PackageDeclaration__Group__2"


    // $ANTLR start "rule__PackageDeclaration__Group__2__Impl"
    // InternalFileAwareTestLanguage.g:244:1: rule__PackageDeclaration__Group__2__Impl : ( ( rule__PackageDeclaration__ImportsAssignment_2 )* ) ;
    public final void rule__PackageDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:248:1: ( ( ( rule__PackageDeclaration__ImportsAssignment_2 )* ) )
            // InternalFileAwareTestLanguage.g:249:1: ( ( rule__PackageDeclaration__ImportsAssignment_2 )* )
            {
            // InternalFileAwareTestLanguage.g:249:1: ( ( rule__PackageDeclaration__ImportsAssignment_2 )* )
            // InternalFileAwareTestLanguage.g:250:2: ( rule__PackageDeclaration__ImportsAssignment_2 )*
            {
             before(grammarAccess.getPackageDeclarationAccess().getImportsAssignment_2()); 
            // InternalFileAwareTestLanguage.g:251:2: ( rule__PackageDeclaration__ImportsAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:251:3: rule__PackageDeclaration__ImportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__PackageDeclaration__ImportsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getPackageDeclarationAccess().getImportsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__2__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__3"
    // InternalFileAwareTestLanguage.g:259:1: rule__PackageDeclaration__Group__3 : rule__PackageDeclaration__Group__3__Impl ;
    public final void rule__PackageDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:263:1: ( rule__PackageDeclaration__Group__3__Impl )
            // InternalFileAwareTestLanguage.g:264:2: rule__PackageDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__3__Impl();

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
    // $ANTLR end "rule__PackageDeclaration__Group__3"


    // $ANTLR start "rule__PackageDeclaration__Group__3__Impl"
    // InternalFileAwareTestLanguage.g:270:1: rule__PackageDeclaration__Group__3__Impl : ( ( rule__PackageDeclaration__ContentsAssignment_3 )* ) ;
    public final void rule__PackageDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:274:1: ( ( ( rule__PackageDeclaration__ContentsAssignment_3 )* ) )
            // InternalFileAwareTestLanguage.g:275:1: ( ( rule__PackageDeclaration__ContentsAssignment_3 )* )
            {
            // InternalFileAwareTestLanguage.g:275:1: ( ( rule__PackageDeclaration__ContentsAssignment_3 )* )
            // InternalFileAwareTestLanguage.g:276:2: ( rule__PackageDeclaration__ContentsAssignment_3 )*
            {
             before(grammarAccess.getPackageDeclarationAccess().getContentsAssignment_3()); 
            // InternalFileAwareTestLanguage.g:277:2: ( rule__PackageDeclaration__ContentsAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:277:3: rule__PackageDeclaration__ContentsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__PackageDeclaration__ContentsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getPackageDeclarationAccess().getContentsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__3__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalFileAwareTestLanguage.g:286:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:290:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalFileAwareTestLanguage.g:291:2: rule__Import__Group__0__Impl rule__Import__Group__1
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
    // InternalFileAwareTestLanguage.g:298:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:302:1: ( ( 'import' ) )
            // InternalFileAwareTestLanguage.g:303:1: ( 'import' )
            {
            // InternalFileAwareTestLanguage.g:303:1: ( 'import' )
            // InternalFileAwareTestLanguage.g:304:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,12,FOLLOW_2); 
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
    // InternalFileAwareTestLanguage.g:313:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:317:1: ( rule__Import__Group__1__Impl )
            // InternalFileAwareTestLanguage.g:318:2: rule__Import__Group__1__Impl
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
    // InternalFileAwareTestLanguage.g:324:1: rule__Import__Group__1__Impl : ( ( rule__Import__ElementAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:328:1: ( ( ( rule__Import__ElementAssignment_1 ) ) )
            // InternalFileAwareTestLanguage.g:329:1: ( ( rule__Import__ElementAssignment_1 ) )
            {
            // InternalFileAwareTestLanguage.g:329:1: ( ( rule__Import__ElementAssignment_1 ) )
            // InternalFileAwareTestLanguage.g:330:2: ( rule__Import__ElementAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getElementAssignment_1()); 
            // InternalFileAwareTestLanguage.g:331:2: ( rule__Import__ElementAssignment_1 )
            // InternalFileAwareTestLanguage.g:331:3: rule__Import__ElementAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ElementAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getElementAssignment_1()); 

            }


            }

        }
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
    // InternalFileAwareTestLanguage.g:340:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:344:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalFileAwareTestLanguage.g:345:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // InternalFileAwareTestLanguage.g:352:1: rule__Element__Group__0__Impl : ( 'element' ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:356:1: ( ( 'element' ) )
            // InternalFileAwareTestLanguage.g:357:1: ( 'element' )
            {
            // InternalFileAwareTestLanguage.g:357:1: ( 'element' )
            // InternalFileAwareTestLanguage.g:358:2: 'element'
            {
             before(grammarAccess.getElementAccess().getElementKeyword_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getElementKeyword_0()); 

            }


            }

        }
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
    // InternalFileAwareTestLanguage.g:367:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:371:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalFileAwareTestLanguage.g:372:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalFileAwareTestLanguage.g:379:1: rule__Element__Group__1__Impl : ( ( rule__Element__NameAssignment_1 ) ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:383:1: ( ( ( rule__Element__NameAssignment_1 ) ) )
            // InternalFileAwareTestLanguage.g:384:1: ( ( rule__Element__NameAssignment_1 ) )
            {
            // InternalFileAwareTestLanguage.g:384:1: ( ( rule__Element__NameAssignment_1 ) )
            // InternalFileAwareTestLanguage.g:385:2: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // InternalFileAwareTestLanguage.g:386:2: ( rule__Element__NameAssignment_1 )
            // InternalFileAwareTestLanguage.g:386:3: rule__Element__NameAssignment_1
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
    // InternalFileAwareTestLanguage.g:394:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:398:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalFileAwareTestLanguage.g:399:2: rule__Element__Group__2__Impl rule__Element__Group__3
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
    // InternalFileAwareTestLanguage.g:406:1: rule__Element__Group__2__Impl : ( '{' ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:410:1: ( ( '{' ) )
            // InternalFileAwareTestLanguage.g:411:1: ( '{' )
            {
            // InternalFileAwareTestLanguage.g:411:1: ( '{' )
            // InternalFileAwareTestLanguage.g:412:2: '{'
            {
             before(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
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
    // InternalFileAwareTestLanguage.g:421:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:425:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalFileAwareTestLanguage.g:426:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__Element__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__4();

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
    // InternalFileAwareTestLanguage.g:433:1: rule__Element__Group__3__Impl : ( ( rule__Element__Alternatives_3 )* ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:437:1: ( ( ( rule__Element__Alternatives_3 )* ) )
            // InternalFileAwareTestLanguage.g:438:1: ( ( rule__Element__Alternatives_3 )* )
            {
            // InternalFileAwareTestLanguage.g:438:1: ( ( rule__Element__Alternatives_3 )* )
            // InternalFileAwareTestLanguage.g:439:2: ( rule__Element__Alternatives_3 )*
            {
             before(grammarAccess.getElementAccess().getAlternatives_3()); 
            // InternalFileAwareTestLanguage.g:440:2: ( rule__Element__Alternatives_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13||LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:440:3: rule__Element__Alternatives_3
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Element__Alternatives_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getAlternatives_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Element__Group__4"
    // InternalFileAwareTestLanguage.g:448:1: rule__Element__Group__4 : rule__Element__Group__4__Impl ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:452:1: ( rule__Element__Group__4__Impl )
            // InternalFileAwareTestLanguage.g:453:2: rule__Element__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group__4__Impl();

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
    // $ANTLR end "rule__Element__Group__4"


    // $ANTLR start "rule__Element__Group__4__Impl"
    // InternalFileAwareTestLanguage.g:459:1: rule__Element__Group__4__Impl : ( '}' ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:463:1: ( ( '}' ) )
            // InternalFileAwareTestLanguage.g:464:1: ( '}' )
            {
            // InternalFileAwareTestLanguage.g:464:1: ( '}' )
            // InternalFileAwareTestLanguage.g:465:2: '}'
            {
             before(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_4()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__4__Impl"


    // $ANTLR start "rule__Element__Group_3_1__0"
    // InternalFileAwareTestLanguage.g:475:1: rule__Element__Group_3_1__0 : rule__Element__Group_3_1__0__Impl rule__Element__Group_3_1__1 ;
    public final void rule__Element__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:479:1: ( rule__Element__Group_3_1__0__Impl rule__Element__Group_3_1__1 )
            // InternalFileAwareTestLanguage.g:480:2: rule__Element__Group_3_1__0__Impl rule__Element__Group_3_1__1
            {
            pushFollow(FOLLOW_3);
            rule__Element__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_3_1__1();

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
    // $ANTLR end "rule__Element__Group_3_1__0"


    // $ANTLR start "rule__Element__Group_3_1__0__Impl"
    // InternalFileAwareTestLanguage.g:487:1: rule__Element__Group_3_1__0__Impl : ( 'ref' ) ;
    public final void rule__Element__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:491:1: ( ( 'ref' ) )
            // InternalFileAwareTestLanguage.g:492:1: ( 'ref' )
            {
            // InternalFileAwareTestLanguage.g:492:1: ( 'ref' )
            // InternalFileAwareTestLanguage.g:493:2: 'ref'
            {
             before(grammarAccess.getElementAccess().getRefKeyword_3_1_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRefKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3_1__0__Impl"


    // $ANTLR start "rule__Element__Group_3_1__1"
    // InternalFileAwareTestLanguage.g:502:1: rule__Element__Group_3_1__1 : rule__Element__Group_3_1__1__Impl ;
    public final void rule__Element__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:506:1: ( rule__Element__Group_3_1__1__Impl )
            // InternalFileAwareTestLanguage.g:507:2: rule__Element__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__Element__Group_3_1__1"


    // $ANTLR start "rule__Element__Group_3_1__1__Impl"
    // InternalFileAwareTestLanguage.g:513:1: rule__Element__Group_3_1__1__Impl : ( ( rule__Element__RefAssignment_3_1_1 ) ) ;
    public final void rule__Element__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:517:1: ( ( ( rule__Element__RefAssignment_3_1_1 ) ) )
            // InternalFileAwareTestLanguage.g:518:1: ( ( rule__Element__RefAssignment_3_1_1 ) )
            {
            // InternalFileAwareTestLanguage.g:518:1: ( ( rule__Element__RefAssignment_3_1_1 ) )
            // InternalFileAwareTestLanguage.g:519:2: ( rule__Element__RefAssignment_3_1_1 )
            {
             before(grammarAccess.getElementAccess().getRefAssignment_3_1_1()); 
            // InternalFileAwareTestLanguage.g:520:2: ( rule__Element__RefAssignment_3_1_1 )
            // InternalFileAwareTestLanguage.g:520:3: rule__Element__RefAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__RefAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getRefAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3_1__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalFileAwareTestLanguage.g:529:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:533:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalFileAwareTestLanguage.g:534:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalFileAwareTestLanguage.g:541:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:545:1: ( ( RULE_ID ) )
            // InternalFileAwareTestLanguage.g:546:1: ( RULE_ID )
            {
            // InternalFileAwareTestLanguage.g:546:1: ( RULE_ID )
            // InternalFileAwareTestLanguage.g:547:2: RULE_ID
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
    // InternalFileAwareTestLanguage.g:556:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:560:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalFileAwareTestLanguage.g:561:2: rule__QualifiedName__Group__1__Impl
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
    // InternalFileAwareTestLanguage.g:567:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:571:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalFileAwareTestLanguage.g:572:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalFileAwareTestLanguage.g:572:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalFileAwareTestLanguage.g:573:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalFileAwareTestLanguage.g:574:2: ( rule__QualifiedName__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:574:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // InternalFileAwareTestLanguage.g:583:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:587:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalFileAwareTestLanguage.g:588:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalFileAwareTestLanguage.g:595:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:599:1: ( ( '.' ) )
            // InternalFileAwareTestLanguage.g:600:1: ( '.' )
            {
            // InternalFileAwareTestLanguage.g:600:1: ( '.' )
            // InternalFileAwareTestLanguage.g:601:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,17,FOLLOW_2); 
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
    // InternalFileAwareTestLanguage.g:610:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:614:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalFileAwareTestLanguage.g:615:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalFileAwareTestLanguage.g:621:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:625:1: ( ( RULE_ID ) )
            // InternalFileAwareTestLanguage.g:626:1: ( RULE_ID )
            {
            // InternalFileAwareTestLanguage.g:626:1: ( RULE_ID )
            // InternalFileAwareTestLanguage.g:627:2: RULE_ID
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


    // $ANTLR start "rule__PackageDeclaration__NameAssignment_1"
    // InternalFileAwareTestLanguage.g:637:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:641:1: ( ( ruleQualifiedName ) )
            // InternalFileAwareTestLanguage.g:642:2: ( ruleQualifiedName )
            {
            // InternalFileAwareTestLanguage.g:642:2: ( ruleQualifiedName )
            // InternalFileAwareTestLanguage.g:643:3: ruleQualifiedName
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__NameAssignment_1"


    // $ANTLR start "rule__PackageDeclaration__ImportsAssignment_2"
    // InternalFileAwareTestLanguage.g:652:1: rule__PackageDeclaration__ImportsAssignment_2 : ( ruleImport ) ;
    public final void rule__PackageDeclaration__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:656:1: ( ( ruleImport ) )
            // InternalFileAwareTestLanguage.g:657:2: ( ruleImport )
            {
            // InternalFileAwareTestLanguage.g:657:2: ( ruleImport )
            // InternalFileAwareTestLanguage.g:658:3: ruleImport
            {
             before(grammarAccess.getPackageDeclarationAccess().getImportsImportParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getImportsImportParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__ImportsAssignment_2"


    // $ANTLR start "rule__PackageDeclaration__ContentsAssignment_3"
    // InternalFileAwareTestLanguage.g:667:1: rule__PackageDeclaration__ContentsAssignment_3 : ( ruleElement ) ;
    public final void rule__PackageDeclaration__ContentsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:671:1: ( ( ruleElement ) )
            // InternalFileAwareTestLanguage.g:672:2: ( ruleElement )
            {
            // InternalFileAwareTestLanguage.g:672:2: ( ruleElement )
            // InternalFileAwareTestLanguage.g:673:3: ruleElement
            {
             before(grammarAccess.getPackageDeclarationAccess().getContentsElementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getContentsElementParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__ContentsAssignment_3"


    // $ANTLR start "rule__Import__ElementAssignment_1"
    // InternalFileAwareTestLanguage.g:682:1: rule__Import__ElementAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Import__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:686:1: ( ( ( ruleQualifiedName ) ) )
            // InternalFileAwareTestLanguage.g:687:2: ( ( ruleQualifiedName ) )
            {
            // InternalFileAwareTestLanguage.g:687:2: ( ( ruleQualifiedName ) )
            // InternalFileAwareTestLanguage.g:688:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getImportAccess().getElementElementCrossReference_1_0()); 
            // InternalFileAwareTestLanguage.g:689:3: ( ruleQualifiedName )
            // InternalFileAwareTestLanguage.g:690:4: ruleQualifiedName
            {
             before(grammarAccess.getImportAccess().getElementElementQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getImportAccess().getElementElementQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getImportAccess().getElementElementCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ElementAssignment_1"


    // $ANTLR start "rule__Element__NameAssignment_1"
    // InternalFileAwareTestLanguage.g:701:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:705:1: ( ( RULE_ID ) )
            // InternalFileAwareTestLanguage.g:706:2: ( RULE_ID )
            {
            // InternalFileAwareTestLanguage.g:706:2: ( RULE_ID )
            // InternalFileAwareTestLanguage.g:707:3: RULE_ID
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


    // $ANTLR start "rule__Element__ContentsAssignment_3_0"
    // InternalFileAwareTestLanguage.g:716:1: rule__Element__ContentsAssignment_3_0 : ( ruleElement ) ;
    public final void rule__Element__ContentsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:720:1: ( ( ruleElement ) )
            // InternalFileAwareTestLanguage.g:721:2: ( ruleElement )
            {
            // InternalFileAwareTestLanguage.g:721:2: ( ruleElement )
            // InternalFileAwareTestLanguage.g:722:3: ruleElement
            {
             before(grammarAccess.getElementAccess().getContentsElementParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementAccess().getContentsElementParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__ContentsAssignment_3_0"


    // $ANTLR start "rule__Element__RefAssignment_3_1_1"
    // InternalFileAwareTestLanguage.g:731:1: rule__Element__RefAssignment_3_1_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__RefAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:735:1: ( ( ( ruleQualifiedName ) ) )
            // InternalFileAwareTestLanguage.g:736:2: ( ( ruleQualifiedName ) )
            {
            // InternalFileAwareTestLanguage.g:736:2: ( ( ruleQualifiedName ) )
            // InternalFileAwareTestLanguage.g:737:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getRefElementCrossReference_3_1_1_0()); 
            // InternalFileAwareTestLanguage.g:738:3: ( ruleQualifiedName )
            // InternalFileAwareTestLanguage.g:739:4: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getRefElementQualifiedNameParserRuleCall_3_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getElementAccess().getRefElementQualifiedNameParserRuleCall_3_1_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getRefElementCrossReference_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__RefAssignment_3_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000001A000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000012002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020002L});

}
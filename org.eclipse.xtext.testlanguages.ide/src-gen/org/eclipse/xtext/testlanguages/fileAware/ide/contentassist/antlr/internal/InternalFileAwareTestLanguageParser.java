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
    // InternalFileAwareTestLanguage.g:53:1: entryRulePackageDeclaration : rulePackageDeclaration EOF ;
    public final void entryRulePackageDeclaration() throws RecognitionException {
        try {
            // InternalFileAwareTestLanguage.g:54:1: ( rulePackageDeclaration EOF )
            // InternalFileAwareTestLanguage.g:55:1: rulePackageDeclaration EOF
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
    // InternalFileAwareTestLanguage.g:62:1: rulePackageDeclaration : ( ( rule__PackageDeclaration__Group__0 ) ) ;
    public final void rulePackageDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:66:2: ( ( ( rule__PackageDeclaration__Group__0 ) ) )
            // InternalFileAwareTestLanguage.g:67:2: ( ( rule__PackageDeclaration__Group__0 ) )
            {
            // InternalFileAwareTestLanguage.g:67:2: ( ( rule__PackageDeclaration__Group__0 ) )
            // InternalFileAwareTestLanguage.g:68:3: ( rule__PackageDeclaration__Group__0 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getGroup()); 
            // InternalFileAwareTestLanguage.g:69:3: ( rule__PackageDeclaration__Group__0 )
            // InternalFileAwareTestLanguage.g:69:4: rule__PackageDeclaration__Group__0
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
    // InternalFileAwareTestLanguage.g:78:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalFileAwareTestLanguage.g:79:1: ( ruleImport EOF )
            // InternalFileAwareTestLanguage.g:80:1: ruleImport EOF
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
    // InternalFileAwareTestLanguage.g:87:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:91:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalFileAwareTestLanguage.g:92:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalFileAwareTestLanguage.g:92:2: ( ( rule__Import__Group__0 ) )
            // InternalFileAwareTestLanguage.g:93:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalFileAwareTestLanguage.g:94:3: ( rule__Import__Group__0 )
            // InternalFileAwareTestLanguage.g:94:4: rule__Import__Group__0
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
    // InternalFileAwareTestLanguage.g:103:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalFileAwareTestLanguage.g:104:1: ( ruleElement EOF )
            // InternalFileAwareTestLanguage.g:105:1: ruleElement EOF
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
    // InternalFileAwareTestLanguage.g:112:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:116:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalFileAwareTestLanguage.g:117:2: ( ( rule__Element__Group__0 ) )
            {
            // InternalFileAwareTestLanguage.g:117:2: ( ( rule__Element__Group__0 ) )
            // InternalFileAwareTestLanguage.g:118:3: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalFileAwareTestLanguage.g:119:3: ( rule__Element__Group__0 )
            // InternalFileAwareTestLanguage.g:119:4: rule__Element__Group__0
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
    // InternalFileAwareTestLanguage.g:128:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalFileAwareTestLanguage.g:129:1: ( ruleQualifiedName EOF )
            // InternalFileAwareTestLanguage.g:130:1: ruleQualifiedName EOF
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
    // InternalFileAwareTestLanguage.g:137:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:141:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalFileAwareTestLanguage.g:142:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalFileAwareTestLanguage.g:142:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalFileAwareTestLanguage.g:143:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalFileAwareTestLanguage.g:144:3: ( rule__QualifiedName__Group__0 )
            // InternalFileAwareTestLanguage.g:144:4: rule__QualifiedName__Group__0
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
    // InternalFileAwareTestLanguage.g:152:1: rule__Element__Alternatives_3 : ( ( ( rule__Element__ContentsAssignment_3_0 ) ) | ( ( rule__Element__Group_3_1__0 ) ) );
    public final void rule__Element__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:156:1: ( ( ( rule__Element__ContentsAssignment_3_0 ) ) | ( ( rule__Element__Group_3_1__0 ) ) )
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
                    // InternalFileAwareTestLanguage.g:157:2: ( ( rule__Element__ContentsAssignment_3_0 ) )
                    {
                    // InternalFileAwareTestLanguage.g:157:2: ( ( rule__Element__ContentsAssignment_3_0 ) )
                    // InternalFileAwareTestLanguage.g:158:3: ( rule__Element__ContentsAssignment_3_0 )
                    {
                     before(grammarAccess.getElementAccess().getContentsAssignment_3_0()); 
                    // InternalFileAwareTestLanguage.g:159:3: ( rule__Element__ContentsAssignment_3_0 )
                    // InternalFileAwareTestLanguage.g:159:4: rule__Element__ContentsAssignment_3_0
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
                    // InternalFileAwareTestLanguage.g:163:2: ( ( rule__Element__Group_3_1__0 ) )
                    {
                    // InternalFileAwareTestLanguage.g:163:2: ( ( rule__Element__Group_3_1__0 ) )
                    // InternalFileAwareTestLanguage.g:164:3: ( rule__Element__Group_3_1__0 )
                    {
                     before(grammarAccess.getElementAccess().getGroup_3_1()); 
                    // InternalFileAwareTestLanguage.g:165:3: ( rule__Element__Group_3_1__0 )
                    // InternalFileAwareTestLanguage.g:165:4: rule__Element__Group_3_1__0
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
    // InternalFileAwareTestLanguage.g:173:1: rule__PackageDeclaration__Group__0 : rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:177:1: ( rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 )
            // InternalFileAwareTestLanguage.g:178:2: rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1
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
    // InternalFileAwareTestLanguage.g:185:1: rule__PackageDeclaration__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:189:1: ( ( 'package' ) )
            // InternalFileAwareTestLanguage.g:190:1: ( 'package' )
            {
            // InternalFileAwareTestLanguage.g:190:1: ( 'package' )
            // InternalFileAwareTestLanguage.g:191:2: 'package'
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
    // InternalFileAwareTestLanguage.g:200:1: rule__PackageDeclaration__Group__1 : rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:204:1: ( rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 )
            // InternalFileAwareTestLanguage.g:205:2: rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2
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
    // InternalFileAwareTestLanguage.g:212:1: rule__PackageDeclaration__Group__1__Impl : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) ;
    public final void rule__PackageDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:216:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) )
            // InternalFileAwareTestLanguage.g:217:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            {
            // InternalFileAwareTestLanguage.g:217:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // InternalFileAwareTestLanguage.g:218:2: ( rule__PackageDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            // InternalFileAwareTestLanguage.g:219:2: ( rule__PackageDeclaration__NameAssignment_1 )
            // InternalFileAwareTestLanguage.g:219:3: rule__PackageDeclaration__NameAssignment_1
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
    // InternalFileAwareTestLanguage.g:227:1: rule__PackageDeclaration__Group__2 : rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 ;
    public final void rule__PackageDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:231:1: ( rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 )
            // InternalFileAwareTestLanguage.g:232:2: rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3
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
    // InternalFileAwareTestLanguage.g:239:1: rule__PackageDeclaration__Group__2__Impl : ( ( rule__PackageDeclaration__ImportsAssignment_2 )* ) ;
    public final void rule__PackageDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:243:1: ( ( ( rule__PackageDeclaration__ImportsAssignment_2 )* ) )
            // InternalFileAwareTestLanguage.g:244:1: ( ( rule__PackageDeclaration__ImportsAssignment_2 )* )
            {
            // InternalFileAwareTestLanguage.g:244:1: ( ( rule__PackageDeclaration__ImportsAssignment_2 )* )
            // InternalFileAwareTestLanguage.g:245:2: ( rule__PackageDeclaration__ImportsAssignment_2 )*
            {
             before(grammarAccess.getPackageDeclarationAccess().getImportsAssignment_2()); 
            // InternalFileAwareTestLanguage.g:246:2: ( rule__PackageDeclaration__ImportsAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:246:3: rule__PackageDeclaration__ImportsAssignment_2
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
    // InternalFileAwareTestLanguage.g:254:1: rule__PackageDeclaration__Group__3 : rule__PackageDeclaration__Group__3__Impl ;
    public final void rule__PackageDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:258:1: ( rule__PackageDeclaration__Group__3__Impl )
            // InternalFileAwareTestLanguage.g:259:2: rule__PackageDeclaration__Group__3__Impl
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
    // InternalFileAwareTestLanguage.g:265:1: rule__PackageDeclaration__Group__3__Impl : ( ( rule__PackageDeclaration__ContentsAssignment_3 )* ) ;
    public final void rule__PackageDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:269:1: ( ( ( rule__PackageDeclaration__ContentsAssignment_3 )* ) )
            // InternalFileAwareTestLanguage.g:270:1: ( ( rule__PackageDeclaration__ContentsAssignment_3 )* )
            {
            // InternalFileAwareTestLanguage.g:270:1: ( ( rule__PackageDeclaration__ContentsAssignment_3 )* )
            // InternalFileAwareTestLanguage.g:271:2: ( rule__PackageDeclaration__ContentsAssignment_3 )*
            {
             before(grammarAccess.getPackageDeclarationAccess().getContentsAssignment_3()); 
            // InternalFileAwareTestLanguage.g:272:2: ( rule__PackageDeclaration__ContentsAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:272:3: rule__PackageDeclaration__ContentsAssignment_3
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
    // InternalFileAwareTestLanguage.g:281:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:285:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalFileAwareTestLanguage.g:286:2: rule__Import__Group__0__Impl rule__Import__Group__1
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
    // InternalFileAwareTestLanguage.g:293:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:297:1: ( ( 'import' ) )
            // InternalFileAwareTestLanguage.g:298:1: ( 'import' )
            {
            // InternalFileAwareTestLanguage.g:298:1: ( 'import' )
            // InternalFileAwareTestLanguage.g:299:2: 'import'
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
    // InternalFileAwareTestLanguage.g:308:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:312:1: ( rule__Import__Group__1__Impl )
            // InternalFileAwareTestLanguage.g:313:2: rule__Import__Group__1__Impl
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
    // InternalFileAwareTestLanguage.g:319:1: rule__Import__Group__1__Impl : ( ( rule__Import__ElementAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:323:1: ( ( ( rule__Import__ElementAssignment_1 ) ) )
            // InternalFileAwareTestLanguage.g:324:1: ( ( rule__Import__ElementAssignment_1 ) )
            {
            // InternalFileAwareTestLanguage.g:324:1: ( ( rule__Import__ElementAssignment_1 ) )
            // InternalFileAwareTestLanguage.g:325:2: ( rule__Import__ElementAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getElementAssignment_1()); 
            // InternalFileAwareTestLanguage.g:326:2: ( rule__Import__ElementAssignment_1 )
            // InternalFileAwareTestLanguage.g:326:3: rule__Import__ElementAssignment_1
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
    // InternalFileAwareTestLanguage.g:335:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:339:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalFileAwareTestLanguage.g:340:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // InternalFileAwareTestLanguage.g:347:1: rule__Element__Group__0__Impl : ( 'element' ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:351:1: ( ( 'element' ) )
            // InternalFileAwareTestLanguage.g:352:1: ( 'element' )
            {
            // InternalFileAwareTestLanguage.g:352:1: ( 'element' )
            // InternalFileAwareTestLanguage.g:353:2: 'element'
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
    // InternalFileAwareTestLanguage.g:362:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:366:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalFileAwareTestLanguage.g:367:2: rule__Element__Group__1__Impl rule__Element__Group__2
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
    // InternalFileAwareTestLanguage.g:374:1: rule__Element__Group__1__Impl : ( ( rule__Element__NameAssignment_1 ) ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:378:1: ( ( ( rule__Element__NameAssignment_1 ) ) )
            // InternalFileAwareTestLanguage.g:379:1: ( ( rule__Element__NameAssignment_1 ) )
            {
            // InternalFileAwareTestLanguage.g:379:1: ( ( rule__Element__NameAssignment_1 ) )
            // InternalFileAwareTestLanguage.g:380:2: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // InternalFileAwareTestLanguage.g:381:2: ( rule__Element__NameAssignment_1 )
            // InternalFileAwareTestLanguage.g:381:3: rule__Element__NameAssignment_1
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
    // InternalFileAwareTestLanguage.g:389:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:393:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalFileAwareTestLanguage.g:394:2: rule__Element__Group__2__Impl rule__Element__Group__3
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
    // InternalFileAwareTestLanguage.g:401:1: rule__Element__Group__2__Impl : ( '{' ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:405:1: ( ( '{' ) )
            // InternalFileAwareTestLanguage.g:406:1: ( '{' )
            {
            // InternalFileAwareTestLanguage.g:406:1: ( '{' )
            // InternalFileAwareTestLanguage.g:407:2: '{'
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
    // InternalFileAwareTestLanguage.g:416:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:420:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalFileAwareTestLanguage.g:421:2: rule__Element__Group__3__Impl rule__Element__Group__4
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
    // InternalFileAwareTestLanguage.g:428:1: rule__Element__Group__3__Impl : ( ( rule__Element__Alternatives_3 )* ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:432:1: ( ( ( rule__Element__Alternatives_3 )* ) )
            // InternalFileAwareTestLanguage.g:433:1: ( ( rule__Element__Alternatives_3 )* )
            {
            // InternalFileAwareTestLanguage.g:433:1: ( ( rule__Element__Alternatives_3 )* )
            // InternalFileAwareTestLanguage.g:434:2: ( rule__Element__Alternatives_3 )*
            {
             before(grammarAccess.getElementAccess().getAlternatives_3()); 
            // InternalFileAwareTestLanguage.g:435:2: ( rule__Element__Alternatives_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13||LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:435:3: rule__Element__Alternatives_3
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
    // InternalFileAwareTestLanguage.g:443:1: rule__Element__Group__4 : rule__Element__Group__4__Impl ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:447:1: ( rule__Element__Group__4__Impl )
            // InternalFileAwareTestLanguage.g:448:2: rule__Element__Group__4__Impl
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
    // InternalFileAwareTestLanguage.g:454:1: rule__Element__Group__4__Impl : ( '}' ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:458:1: ( ( '}' ) )
            // InternalFileAwareTestLanguage.g:459:1: ( '}' )
            {
            // InternalFileAwareTestLanguage.g:459:1: ( '}' )
            // InternalFileAwareTestLanguage.g:460:2: '}'
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
    // InternalFileAwareTestLanguage.g:470:1: rule__Element__Group_3_1__0 : rule__Element__Group_3_1__0__Impl rule__Element__Group_3_1__1 ;
    public final void rule__Element__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:474:1: ( rule__Element__Group_3_1__0__Impl rule__Element__Group_3_1__1 )
            // InternalFileAwareTestLanguage.g:475:2: rule__Element__Group_3_1__0__Impl rule__Element__Group_3_1__1
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
    // InternalFileAwareTestLanguage.g:482:1: rule__Element__Group_3_1__0__Impl : ( 'ref' ) ;
    public final void rule__Element__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:486:1: ( ( 'ref' ) )
            // InternalFileAwareTestLanguage.g:487:1: ( 'ref' )
            {
            // InternalFileAwareTestLanguage.g:487:1: ( 'ref' )
            // InternalFileAwareTestLanguage.g:488:2: 'ref'
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
    // InternalFileAwareTestLanguage.g:497:1: rule__Element__Group_3_1__1 : rule__Element__Group_3_1__1__Impl ;
    public final void rule__Element__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:501:1: ( rule__Element__Group_3_1__1__Impl )
            // InternalFileAwareTestLanguage.g:502:2: rule__Element__Group_3_1__1__Impl
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
    // InternalFileAwareTestLanguage.g:508:1: rule__Element__Group_3_1__1__Impl : ( ( rule__Element__RefAssignment_3_1_1 ) ) ;
    public final void rule__Element__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:512:1: ( ( ( rule__Element__RefAssignment_3_1_1 ) ) )
            // InternalFileAwareTestLanguage.g:513:1: ( ( rule__Element__RefAssignment_3_1_1 ) )
            {
            // InternalFileAwareTestLanguage.g:513:1: ( ( rule__Element__RefAssignment_3_1_1 ) )
            // InternalFileAwareTestLanguage.g:514:2: ( rule__Element__RefAssignment_3_1_1 )
            {
             before(grammarAccess.getElementAccess().getRefAssignment_3_1_1()); 
            // InternalFileAwareTestLanguage.g:515:2: ( rule__Element__RefAssignment_3_1_1 )
            // InternalFileAwareTestLanguage.g:515:3: rule__Element__RefAssignment_3_1_1
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
    // InternalFileAwareTestLanguage.g:524:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:528:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalFileAwareTestLanguage.g:529:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalFileAwareTestLanguage.g:536:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:540:1: ( ( RULE_ID ) )
            // InternalFileAwareTestLanguage.g:541:1: ( RULE_ID )
            {
            // InternalFileAwareTestLanguage.g:541:1: ( RULE_ID )
            // InternalFileAwareTestLanguage.g:542:2: RULE_ID
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
    // InternalFileAwareTestLanguage.g:551:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:555:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalFileAwareTestLanguage.g:556:2: rule__QualifiedName__Group__1__Impl
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
    // InternalFileAwareTestLanguage.g:562:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:566:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalFileAwareTestLanguage.g:567:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalFileAwareTestLanguage.g:567:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalFileAwareTestLanguage.g:568:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalFileAwareTestLanguage.g:569:2: ( rule__QualifiedName__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:569:3: rule__QualifiedName__Group_1__0
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
    // InternalFileAwareTestLanguage.g:578:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:582:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalFileAwareTestLanguage.g:583:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalFileAwareTestLanguage.g:590:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:594:1: ( ( '.' ) )
            // InternalFileAwareTestLanguage.g:595:1: ( '.' )
            {
            // InternalFileAwareTestLanguage.g:595:1: ( '.' )
            // InternalFileAwareTestLanguage.g:596:2: '.'
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
    // InternalFileAwareTestLanguage.g:605:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:609:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalFileAwareTestLanguage.g:610:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalFileAwareTestLanguage.g:616:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:620:1: ( ( RULE_ID ) )
            // InternalFileAwareTestLanguage.g:621:1: ( RULE_ID )
            {
            // InternalFileAwareTestLanguage.g:621:1: ( RULE_ID )
            // InternalFileAwareTestLanguage.g:622:2: RULE_ID
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
    // InternalFileAwareTestLanguage.g:632:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:636:1: ( ( ruleQualifiedName ) )
            // InternalFileAwareTestLanguage.g:637:2: ( ruleQualifiedName )
            {
            // InternalFileAwareTestLanguage.g:637:2: ( ruleQualifiedName )
            // InternalFileAwareTestLanguage.g:638:3: ruleQualifiedName
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
    // InternalFileAwareTestLanguage.g:647:1: rule__PackageDeclaration__ImportsAssignment_2 : ( ruleImport ) ;
    public final void rule__PackageDeclaration__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:651:1: ( ( ruleImport ) )
            // InternalFileAwareTestLanguage.g:652:2: ( ruleImport )
            {
            // InternalFileAwareTestLanguage.g:652:2: ( ruleImport )
            // InternalFileAwareTestLanguage.g:653:3: ruleImport
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
    // InternalFileAwareTestLanguage.g:662:1: rule__PackageDeclaration__ContentsAssignment_3 : ( ruleElement ) ;
    public final void rule__PackageDeclaration__ContentsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:666:1: ( ( ruleElement ) )
            // InternalFileAwareTestLanguage.g:667:2: ( ruleElement )
            {
            // InternalFileAwareTestLanguage.g:667:2: ( ruleElement )
            // InternalFileAwareTestLanguage.g:668:3: ruleElement
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
    // InternalFileAwareTestLanguage.g:677:1: rule__Import__ElementAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Import__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:681:1: ( ( ( ruleQualifiedName ) ) )
            // InternalFileAwareTestLanguage.g:682:2: ( ( ruleQualifiedName ) )
            {
            // InternalFileAwareTestLanguage.g:682:2: ( ( ruleQualifiedName ) )
            // InternalFileAwareTestLanguage.g:683:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getImportAccess().getElementElementCrossReference_1_0()); 
            // InternalFileAwareTestLanguage.g:684:3: ( ruleQualifiedName )
            // InternalFileAwareTestLanguage.g:685:4: ruleQualifiedName
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
    // InternalFileAwareTestLanguage.g:696:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:700:1: ( ( RULE_ID ) )
            // InternalFileAwareTestLanguage.g:701:2: ( RULE_ID )
            {
            // InternalFileAwareTestLanguage.g:701:2: ( RULE_ID )
            // InternalFileAwareTestLanguage.g:702:3: RULE_ID
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
    // InternalFileAwareTestLanguage.g:711:1: rule__Element__ContentsAssignment_3_0 : ( ruleElement ) ;
    public final void rule__Element__ContentsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:715:1: ( ( ruleElement ) )
            // InternalFileAwareTestLanguage.g:716:2: ( ruleElement )
            {
            // InternalFileAwareTestLanguage.g:716:2: ( ruleElement )
            // InternalFileAwareTestLanguage.g:717:3: ruleElement
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
    // InternalFileAwareTestLanguage.g:726:1: rule__Element__RefAssignment_3_1_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__RefAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFileAwareTestLanguage.g:730:1: ( ( ( ruleQualifiedName ) ) )
            // InternalFileAwareTestLanguage.g:731:2: ( ( ruleQualifiedName ) )
            {
            // InternalFileAwareTestLanguage.g:731:2: ( ( ruleQualifiedName ) )
            // InternalFileAwareTestLanguage.g:732:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getRefElementCrossReference_3_1_1_0()); 
            // InternalFileAwareTestLanguage.g:733:3: ( ruleQualifiedName )
            // InternalFileAwareTestLanguage.g:734:4: ruleQualifiedName
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
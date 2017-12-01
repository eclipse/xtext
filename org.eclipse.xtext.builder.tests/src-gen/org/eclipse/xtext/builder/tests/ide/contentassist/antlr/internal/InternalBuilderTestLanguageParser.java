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
    // InternalBuilderTestLanguage.g:53:1: entryRuleNamedElement : ruleNamedElement EOF ;
    public final void entryRuleNamedElement() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:54:1: ( ruleNamedElement EOF )
            // InternalBuilderTestLanguage.g:55:1: ruleNamedElement EOF
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
    // InternalBuilderTestLanguage.g:62:1: ruleNamedElement : ( ( rule__NamedElement__Alternatives ) ) ;
    public final void ruleNamedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:66:2: ( ( ( rule__NamedElement__Alternatives ) ) )
            // InternalBuilderTestLanguage.g:67:2: ( ( rule__NamedElement__Alternatives ) )
            {
            // InternalBuilderTestLanguage.g:67:2: ( ( rule__NamedElement__Alternatives ) )
            // InternalBuilderTestLanguage.g:68:3: ( rule__NamedElement__Alternatives )
            {
             before(grammarAccess.getNamedElementAccess().getAlternatives()); 
            // InternalBuilderTestLanguage.g:69:3: ( rule__NamedElement__Alternatives )
            // InternalBuilderTestLanguage.g:69:4: rule__NamedElement__Alternatives
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
    // InternalBuilderTestLanguage.g:78:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:79:1: ( ruleNamespace EOF )
            // InternalBuilderTestLanguage.g:80:1: ruleNamespace EOF
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
    // InternalBuilderTestLanguage.g:87:1: ruleNamespace : ( ( rule__Namespace__Group__0 ) ) ;
    public final void ruleNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:91:2: ( ( ( rule__Namespace__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:92:2: ( ( rule__Namespace__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:92:2: ( ( rule__Namespace__Group__0 ) )
            // InternalBuilderTestLanguage.g:93:3: ( rule__Namespace__Group__0 )
            {
             before(grammarAccess.getNamespaceAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:94:3: ( rule__Namespace__Group__0 )
            // InternalBuilderTestLanguage.g:94:4: rule__Namespace__Group__0
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
    // InternalBuilderTestLanguage.g:103:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:104:1: ( ruleImport EOF )
            // InternalBuilderTestLanguage.g:105:1: ruleImport EOF
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
    // InternalBuilderTestLanguage.g:112:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:116:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:117:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:117:2: ( ( rule__Import__Group__0 ) )
            // InternalBuilderTestLanguage.g:118:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:119:3: ( rule__Import__Group__0 )
            // InternalBuilderTestLanguage.g:119:4: rule__Import__Group__0
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
    // InternalBuilderTestLanguage.g:128:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:129:1: ( ruleElement EOF )
            // InternalBuilderTestLanguage.g:130:1: ruleElement EOF
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
    // InternalBuilderTestLanguage.g:137:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:141:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:142:2: ( ( rule__Element__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:142:2: ( ( rule__Element__Group__0 ) )
            // InternalBuilderTestLanguage.g:143:3: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:144:3: ( rule__Element__Group__0 )
            // InternalBuilderTestLanguage.g:144:4: rule__Element__Group__0
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
    // InternalBuilderTestLanguage.g:153:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:154:1: ( ruleQualifiedName EOF )
            // InternalBuilderTestLanguage.g:155:1: ruleQualifiedName EOF
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
    // InternalBuilderTestLanguage.g:162:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:166:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:167:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:167:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalBuilderTestLanguage.g:168:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:169:3: ( rule__QualifiedName__Group__0 )
            // InternalBuilderTestLanguage.g:169:4: rule__QualifiedName__Group__0
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
    // InternalBuilderTestLanguage.g:177:1: rule__NamedElement__Alternatives : ( ( ruleNamespace ) | ( ruleElement ) );
    public final void rule__NamedElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:181:1: ( ( ruleNamespace ) | ( ruleElement ) )
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
                    // InternalBuilderTestLanguage.g:182:2: ( ruleNamespace )
                    {
                    // InternalBuilderTestLanguage.g:182:2: ( ruleNamespace )
                    // InternalBuilderTestLanguage.g:183:3: ruleNamespace
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
                    // InternalBuilderTestLanguage.g:188:2: ( ruleElement )
                    {
                    // InternalBuilderTestLanguage.g:188:2: ( ruleElement )
                    // InternalBuilderTestLanguage.g:189:3: ruleElement
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
    // InternalBuilderTestLanguage.g:198:1: rule__Namespace__Group__0 : rule__Namespace__Group__0__Impl rule__Namespace__Group__1 ;
    public final void rule__Namespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:202:1: ( rule__Namespace__Group__0__Impl rule__Namespace__Group__1 )
            // InternalBuilderTestLanguage.g:203:2: rule__Namespace__Group__0__Impl rule__Namespace__Group__1
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
    // InternalBuilderTestLanguage.g:210:1: rule__Namespace__Group__0__Impl : ( 'namespace' ) ;
    public final void rule__Namespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:214:1: ( ( 'namespace' ) )
            // InternalBuilderTestLanguage.g:215:1: ( 'namespace' )
            {
            // InternalBuilderTestLanguage.g:215:1: ( 'namespace' )
            // InternalBuilderTestLanguage.g:216:2: 'namespace'
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
    // InternalBuilderTestLanguage.g:225:1: rule__Namespace__Group__1 : rule__Namespace__Group__1__Impl rule__Namespace__Group__2 ;
    public final void rule__Namespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:229:1: ( rule__Namespace__Group__1__Impl rule__Namespace__Group__2 )
            // InternalBuilderTestLanguage.g:230:2: rule__Namespace__Group__1__Impl rule__Namespace__Group__2
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
    // InternalBuilderTestLanguage.g:237:1: rule__Namespace__Group__1__Impl : ( ( rule__Namespace__NameAssignment_1 ) ) ;
    public final void rule__Namespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:241:1: ( ( ( rule__Namespace__NameAssignment_1 ) ) )
            // InternalBuilderTestLanguage.g:242:1: ( ( rule__Namespace__NameAssignment_1 ) )
            {
            // InternalBuilderTestLanguage.g:242:1: ( ( rule__Namespace__NameAssignment_1 ) )
            // InternalBuilderTestLanguage.g:243:2: ( rule__Namespace__NameAssignment_1 )
            {
             before(grammarAccess.getNamespaceAccess().getNameAssignment_1()); 
            // InternalBuilderTestLanguage.g:244:2: ( rule__Namespace__NameAssignment_1 )
            // InternalBuilderTestLanguage.g:244:3: rule__Namespace__NameAssignment_1
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
    // InternalBuilderTestLanguage.g:252:1: rule__Namespace__Group__2 : rule__Namespace__Group__2__Impl rule__Namespace__Group__3 ;
    public final void rule__Namespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:256:1: ( rule__Namespace__Group__2__Impl rule__Namespace__Group__3 )
            // InternalBuilderTestLanguage.g:257:2: rule__Namespace__Group__2__Impl rule__Namespace__Group__3
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
    // InternalBuilderTestLanguage.g:264:1: rule__Namespace__Group__2__Impl : ( '{' ) ;
    public final void rule__Namespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:268:1: ( ( '{' ) )
            // InternalBuilderTestLanguage.g:269:1: ( '{' )
            {
            // InternalBuilderTestLanguage.g:269:1: ( '{' )
            // InternalBuilderTestLanguage.g:270:2: '{'
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
    // InternalBuilderTestLanguage.g:279:1: rule__Namespace__Group__3 : rule__Namespace__Group__3__Impl rule__Namespace__Group__4 ;
    public final void rule__Namespace__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:283:1: ( rule__Namespace__Group__3__Impl rule__Namespace__Group__4 )
            // InternalBuilderTestLanguage.g:284:2: rule__Namespace__Group__3__Impl rule__Namespace__Group__4
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
    // InternalBuilderTestLanguage.g:291:1: rule__Namespace__Group__3__Impl : ( ( rule__Namespace__ImportsAssignment_3 )* ) ;
    public final void rule__Namespace__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:295:1: ( ( ( rule__Namespace__ImportsAssignment_3 )* ) )
            // InternalBuilderTestLanguage.g:296:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            {
            // InternalBuilderTestLanguage.g:296:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            // InternalBuilderTestLanguage.g:297:2: ( rule__Namespace__ImportsAssignment_3 )*
            {
             before(grammarAccess.getNamespaceAccess().getImportsAssignment_3()); 
            // InternalBuilderTestLanguage.g:298:2: ( rule__Namespace__ImportsAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:298:3: rule__Namespace__ImportsAssignment_3
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
    // InternalBuilderTestLanguage.g:306:1: rule__Namespace__Group__4 : rule__Namespace__Group__4__Impl rule__Namespace__Group__5 ;
    public final void rule__Namespace__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:310:1: ( rule__Namespace__Group__4__Impl rule__Namespace__Group__5 )
            // InternalBuilderTestLanguage.g:311:2: rule__Namespace__Group__4__Impl rule__Namespace__Group__5
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
    // InternalBuilderTestLanguage.g:318:1: rule__Namespace__Group__4__Impl : ( ( rule__Namespace__ElementsAssignment_4 )* ) ;
    public final void rule__Namespace__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:322:1: ( ( ( rule__Namespace__ElementsAssignment_4 )* ) )
            // InternalBuilderTestLanguage.g:323:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            {
            // InternalBuilderTestLanguage.g:323:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            // InternalBuilderTestLanguage.g:324:2: ( rule__Namespace__ElementsAssignment_4 )*
            {
             before(grammarAccess.getNamespaceAccess().getElementsAssignment_4()); 
            // InternalBuilderTestLanguage.g:325:2: ( rule__Namespace__ElementsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:325:3: rule__Namespace__ElementsAssignment_4
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
    // InternalBuilderTestLanguage.g:333:1: rule__Namespace__Group__5 : rule__Namespace__Group__5__Impl ;
    public final void rule__Namespace__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:337:1: ( rule__Namespace__Group__5__Impl )
            // InternalBuilderTestLanguage.g:338:2: rule__Namespace__Group__5__Impl
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
    // InternalBuilderTestLanguage.g:344:1: rule__Namespace__Group__5__Impl : ( '}' ) ;
    public final void rule__Namespace__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:348:1: ( ( '}' ) )
            // InternalBuilderTestLanguage.g:349:1: ( '}' )
            {
            // InternalBuilderTestLanguage.g:349:1: ( '}' )
            // InternalBuilderTestLanguage.g:350:2: '}'
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
    // InternalBuilderTestLanguage.g:360:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:364:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalBuilderTestLanguage.g:365:2: rule__Import__Group__0__Impl rule__Import__Group__1
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
    // InternalBuilderTestLanguage.g:372:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:376:1: ( ( 'import' ) )
            // InternalBuilderTestLanguage.g:377:1: ( 'import' )
            {
            // InternalBuilderTestLanguage.g:377:1: ( 'import' )
            // InternalBuilderTestLanguage.g:378:2: 'import'
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
    // InternalBuilderTestLanguage.g:387:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:391:1: ( rule__Import__Group__1__Impl )
            // InternalBuilderTestLanguage.g:392:2: rule__Import__Group__1__Impl
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
    // InternalBuilderTestLanguage.g:398:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:402:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalBuilderTestLanguage.g:403:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalBuilderTestLanguage.g:403:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalBuilderTestLanguage.g:404:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalBuilderTestLanguage.g:405:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalBuilderTestLanguage.g:405:3: rule__Import__ImportedNamespaceAssignment_1
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
    // InternalBuilderTestLanguage.g:414:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:418:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalBuilderTestLanguage.g:419:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // InternalBuilderTestLanguage.g:426:1: rule__Element__Group__0__Impl : ( 'object' ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:430:1: ( ( 'object' ) )
            // InternalBuilderTestLanguage.g:431:1: ( 'object' )
            {
            // InternalBuilderTestLanguage.g:431:1: ( 'object' )
            // InternalBuilderTestLanguage.g:432:2: 'object'
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
    // InternalBuilderTestLanguage.g:441:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:445:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalBuilderTestLanguage.g:446:2: rule__Element__Group__1__Impl rule__Element__Group__2
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
    // InternalBuilderTestLanguage.g:453:1: rule__Element__Group__1__Impl : ( ( rule__Element__NameAssignment_1 ) ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:457:1: ( ( ( rule__Element__NameAssignment_1 ) ) )
            // InternalBuilderTestLanguage.g:458:1: ( ( rule__Element__NameAssignment_1 ) )
            {
            // InternalBuilderTestLanguage.g:458:1: ( ( rule__Element__NameAssignment_1 ) )
            // InternalBuilderTestLanguage.g:459:2: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // InternalBuilderTestLanguage.g:460:2: ( rule__Element__NameAssignment_1 )
            // InternalBuilderTestLanguage.g:460:3: rule__Element__NameAssignment_1
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
    // InternalBuilderTestLanguage.g:468:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:472:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalBuilderTestLanguage.g:473:2: rule__Element__Group__2__Impl rule__Element__Group__3
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
    // InternalBuilderTestLanguage.g:480:1: rule__Element__Group__2__Impl : ( ( rule__Element__Group_2__0 )? ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:484:1: ( ( ( rule__Element__Group_2__0 )? ) )
            // InternalBuilderTestLanguage.g:485:1: ( ( rule__Element__Group_2__0 )? )
            {
            // InternalBuilderTestLanguage.g:485:1: ( ( rule__Element__Group_2__0 )? )
            // InternalBuilderTestLanguage.g:486:2: ( rule__Element__Group_2__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_2()); 
            // InternalBuilderTestLanguage.g:487:2: ( rule__Element__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBuilderTestLanguage.g:487:3: rule__Element__Group_2__0
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
    // InternalBuilderTestLanguage.g:495:1: rule__Element__Group__3 : rule__Element__Group__3__Impl ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:499:1: ( rule__Element__Group__3__Impl )
            // InternalBuilderTestLanguage.g:500:2: rule__Element__Group__3__Impl
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
    // InternalBuilderTestLanguage.g:506:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:510:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // InternalBuilderTestLanguage.g:511:1: ( ( rule__Element__Group_3__0 )? )
            {
            // InternalBuilderTestLanguage.g:511:1: ( ( rule__Element__Group_3__0 )? )
            // InternalBuilderTestLanguage.g:512:2: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // InternalBuilderTestLanguage.g:513:2: ( rule__Element__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBuilderTestLanguage.g:513:3: rule__Element__Group_3__0
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
    // InternalBuilderTestLanguage.g:522:1: rule__Element__Group_2__0 : rule__Element__Group_2__0__Impl rule__Element__Group_2__1 ;
    public final void rule__Element__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:526:1: ( rule__Element__Group_2__0__Impl rule__Element__Group_2__1 )
            // InternalBuilderTestLanguage.g:527:2: rule__Element__Group_2__0__Impl rule__Element__Group_2__1
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
    // InternalBuilderTestLanguage.g:534:1: rule__Element__Group_2__0__Impl : ( 'references' ) ;
    public final void rule__Element__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:538:1: ( ( 'references' ) )
            // InternalBuilderTestLanguage.g:539:1: ( 'references' )
            {
            // InternalBuilderTestLanguage.g:539:1: ( 'references' )
            // InternalBuilderTestLanguage.g:540:2: 'references'
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
    // InternalBuilderTestLanguage.g:549:1: rule__Element__Group_2__1 : rule__Element__Group_2__1__Impl ;
    public final void rule__Element__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:553:1: ( rule__Element__Group_2__1__Impl )
            // InternalBuilderTestLanguage.g:554:2: rule__Element__Group_2__1__Impl
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
    // InternalBuilderTestLanguage.g:560:1: rule__Element__Group_2__1__Impl : ( ( rule__Element__ReferencesAssignment_2_1 ) ) ;
    public final void rule__Element__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:564:1: ( ( ( rule__Element__ReferencesAssignment_2_1 ) ) )
            // InternalBuilderTestLanguage.g:565:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            {
            // InternalBuilderTestLanguage.g:565:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            // InternalBuilderTestLanguage.g:566:2: ( rule__Element__ReferencesAssignment_2_1 )
            {
             before(grammarAccess.getElementAccess().getReferencesAssignment_2_1()); 
            // InternalBuilderTestLanguage.g:567:2: ( rule__Element__ReferencesAssignment_2_1 )
            // InternalBuilderTestLanguage.g:567:3: rule__Element__ReferencesAssignment_2_1
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
    // InternalBuilderTestLanguage.g:576:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:580:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // InternalBuilderTestLanguage.g:581:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
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
    // InternalBuilderTestLanguage.g:588:1: rule__Element__Group_3__0__Impl : ( 'otherRefs' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:592:1: ( ( 'otherRefs' ) )
            // InternalBuilderTestLanguage.g:593:1: ( 'otherRefs' )
            {
            // InternalBuilderTestLanguage.g:593:1: ( 'otherRefs' )
            // InternalBuilderTestLanguage.g:594:2: 'otherRefs'
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
    // InternalBuilderTestLanguage.g:603:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl rule__Element__Group_3__2 ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:607:1: ( rule__Element__Group_3__1__Impl rule__Element__Group_3__2 )
            // InternalBuilderTestLanguage.g:608:2: rule__Element__Group_3__1__Impl rule__Element__Group_3__2
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
    // InternalBuilderTestLanguage.g:615:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__OtherRefsAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:619:1: ( ( ( rule__Element__OtherRefsAssignment_3_1 ) ) )
            // InternalBuilderTestLanguage.g:620:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            {
            // InternalBuilderTestLanguage.g:620:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            // InternalBuilderTestLanguage.g:621:2: ( rule__Element__OtherRefsAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1()); 
            // InternalBuilderTestLanguage.g:622:2: ( rule__Element__OtherRefsAssignment_3_1 )
            // InternalBuilderTestLanguage.g:622:3: rule__Element__OtherRefsAssignment_3_1
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
    // InternalBuilderTestLanguage.g:630:1: rule__Element__Group_3__2 : rule__Element__Group_3__2__Impl ;
    public final void rule__Element__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:634:1: ( rule__Element__Group_3__2__Impl )
            // InternalBuilderTestLanguage.g:635:2: rule__Element__Group_3__2__Impl
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
    // InternalBuilderTestLanguage.g:641:1: rule__Element__Group_3__2__Impl : ( ( rule__Element__Group_3_2__0 )* ) ;
    public final void rule__Element__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:645:1: ( ( ( rule__Element__Group_3_2__0 )* ) )
            // InternalBuilderTestLanguage.g:646:1: ( ( rule__Element__Group_3_2__0 )* )
            {
            // InternalBuilderTestLanguage.g:646:1: ( ( rule__Element__Group_3_2__0 )* )
            // InternalBuilderTestLanguage.g:647:2: ( rule__Element__Group_3_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_3_2()); 
            // InternalBuilderTestLanguage.g:648:2: ( rule__Element__Group_3_2__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:648:3: rule__Element__Group_3_2__0
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
    // InternalBuilderTestLanguage.g:657:1: rule__Element__Group_3_2__0 : rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1 ;
    public final void rule__Element__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:661:1: ( rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1 )
            // InternalBuilderTestLanguage.g:662:2: rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1
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
    // InternalBuilderTestLanguage.g:669:1: rule__Element__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Element__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:673:1: ( ( ',' ) )
            // InternalBuilderTestLanguage.g:674:1: ( ',' )
            {
            // InternalBuilderTestLanguage.g:674:1: ( ',' )
            // InternalBuilderTestLanguage.g:675:2: ','
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
    // InternalBuilderTestLanguage.g:684:1: rule__Element__Group_3_2__1 : rule__Element__Group_3_2__1__Impl ;
    public final void rule__Element__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:688:1: ( rule__Element__Group_3_2__1__Impl )
            // InternalBuilderTestLanguage.g:689:2: rule__Element__Group_3_2__1__Impl
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
    // InternalBuilderTestLanguage.g:695:1: rule__Element__Group_3_2__1__Impl : ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) ;
    public final void rule__Element__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:699:1: ( ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) )
            // InternalBuilderTestLanguage.g:700:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            {
            // InternalBuilderTestLanguage.g:700:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            // InternalBuilderTestLanguage.g:701:2: ( rule__Element__OtherRefsAssignment_3_2_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_2_1()); 
            // InternalBuilderTestLanguage.g:702:2: ( rule__Element__OtherRefsAssignment_3_2_1 )
            // InternalBuilderTestLanguage.g:702:3: rule__Element__OtherRefsAssignment_3_2_1
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
    // InternalBuilderTestLanguage.g:711:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:715:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalBuilderTestLanguage.g:716:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalBuilderTestLanguage.g:723:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:727:1: ( ( RULE_ID ) )
            // InternalBuilderTestLanguage.g:728:1: ( RULE_ID )
            {
            // InternalBuilderTestLanguage.g:728:1: ( RULE_ID )
            // InternalBuilderTestLanguage.g:729:2: RULE_ID
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
    // InternalBuilderTestLanguage.g:738:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:742:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalBuilderTestLanguage.g:743:2: rule__QualifiedName__Group__1__Impl
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
    // InternalBuilderTestLanguage.g:749:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:753:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalBuilderTestLanguage.g:754:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalBuilderTestLanguage.g:754:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalBuilderTestLanguage.g:755:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalBuilderTestLanguage.g:756:2: ( rule__QualifiedName__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:756:3: rule__QualifiedName__Group_1__0
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
    // InternalBuilderTestLanguage.g:765:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:769:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalBuilderTestLanguage.g:770:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalBuilderTestLanguage.g:777:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:781:1: ( ( '.' ) )
            // InternalBuilderTestLanguage.g:782:1: ( '.' )
            {
            // InternalBuilderTestLanguage.g:782:1: ( '.' )
            // InternalBuilderTestLanguage.g:783:2: '.'
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
    // InternalBuilderTestLanguage.g:792:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:796:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalBuilderTestLanguage.g:797:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalBuilderTestLanguage.g:803:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:807:1: ( ( RULE_ID ) )
            // InternalBuilderTestLanguage.g:808:1: ( RULE_ID )
            {
            // InternalBuilderTestLanguage.g:808:1: ( RULE_ID )
            // InternalBuilderTestLanguage.g:809:2: RULE_ID
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
    // InternalBuilderTestLanguage.g:819:1: rule__Namespace__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Namespace__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:823:1: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:824:2: ( ruleQualifiedName )
            {
            // InternalBuilderTestLanguage.g:824:2: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:825:3: ruleQualifiedName
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
    // InternalBuilderTestLanguage.g:834:1: rule__Namespace__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__Namespace__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:838:1: ( ( ruleImport ) )
            // InternalBuilderTestLanguage.g:839:2: ( ruleImport )
            {
            // InternalBuilderTestLanguage.g:839:2: ( ruleImport )
            // InternalBuilderTestLanguage.g:840:3: ruleImport
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
    // InternalBuilderTestLanguage.g:849:1: rule__Namespace__ElementsAssignment_4 : ( ruleNamedElement ) ;
    public final void rule__Namespace__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:853:1: ( ( ruleNamedElement ) )
            // InternalBuilderTestLanguage.g:854:2: ( ruleNamedElement )
            {
            // InternalBuilderTestLanguage.g:854:2: ( ruleNamedElement )
            // InternalBuilderTestLanguage.g:855:3: ruleNamedElement
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
    // InternalBuilderTestLanguage.g:864:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:868:1: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:869:2: ( ruleQualifiedName )
            {
            // InternalBuilderTestLanguage.g:869:2: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:870:3: ruleQualifiedName
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
    // InternalBuilderTestLanguage.g:879:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:883:1: ( ( RULE_ID ) )
            // InternalBuilderTestLanguage.g:884:2: ( RULE_ID )
            {
            // InternalBuilderTestLanguage.g:884:2: ( RULE_ID )
            // InternalBuilderTestLanguage.g:885:3: RULE_ID
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
    // InternalBuilderTestLanguage.g:894:1: rule__Element__ReferencesAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__ReferencesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:898:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBuilderTestLanguage.g:899:2: ( ( ruleQualifiedName ) )
            {
            // InternalBuilderTestLanguage.g:899:2: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:900:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0()); 
            // InternalBuilderTestLanguage.g:901:3: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:902:4: ruleQualifiedName
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
    // InternalBuilderTestLanguage.g:913:1: rule__Element__OtherRefsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:917:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBuilderTestLanguage.g:918:2: ( ( ruleQualifiedName ) )
            {
            // InternalBuilderTestLanguage.g:918:2: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:919:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0()); 
            // InternalBuilderTestLanguage.g:920:3: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:921:4: ruleQualifiedName
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
    // InternalBuilderTestLanguage.g:932:1: rule__Element__OtherRefsAssignment_3_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBuilderTestLanguage.g:936:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBuilderTestLanguage.g:937:2: ( ( ruleQualifiedName ) )
            {
            // InternalBuilderTestLanguage.g:937:2: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:938:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0()); 
            // InternalBuilderTestLanguage.g:939:3: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:940:4: ruleQualifiedName
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
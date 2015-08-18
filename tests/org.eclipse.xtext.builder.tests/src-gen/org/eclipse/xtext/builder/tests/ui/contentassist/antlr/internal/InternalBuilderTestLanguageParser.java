package org.eclipse.xtext.builder.tests.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
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
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

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
    // InternalBuilderTestLanguage.g:60:1: entryRuleNamedElement : ruleNamedElement EOF ;
    public final void entryRuleNamedElement() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:61:1: ( ruleNamedElement EOF )
            // InternalBuilderTestLanguage.g:62:1: ruleNamedElement EOF
            {
             before(grammarAccess.getNamedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNamedElement();

            state._fsp--;

             after(grammarAccess.getNamedElementRule()); 
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
    // $ANTLR end "entryRuleNamedElement"


    // $ANTLR start "ruleNamedElement"
    // InternalBuilderTestLanguage.g:69:1: ruleNamedElement : ( ( rule__NamedElement__Alternatives ) ) ;
    public final void ruleNamedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:73:2: ( ( ( rule__NamedElement__Alternatives ) ) )
            // InternalBuilderTestLanguage.g:74:1: ( ( rule__NamedElement__Alternatives ) )
            {
            // InternalBuilderTestLanguage.g:74:1: ( ( rule__NamedElement__Alternatives ) )
            // InternalBuilderTestLanguage.g:75:1: ( rule__NamedElement__Alternatives )
            {
             before(grammarAccess.getNamedElementAccess().getAlternatives()); 
            // InternalBuilderTestLanguage.g:76:1: ( rule__NamedElement__Alternatives )
            // InternalBuilderTestLanguage.g:76:2: rule__NamedElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:88:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:89:1: ( ruleNamespace EOF )
            // InternalBuilderTestLanguage.g:90:1: ruleNamespace EOF
            {
             before(grammarAccess.getNamespaceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNamespace();

            state._fsp--;

             after(grammarAccess.getNamespaceRule()); 
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
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalBuilderTestLanguage.g:97:1: ruleNamespace : ( ( rule__Namespace__Group__0 ) ) ;
    public final void ruleNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:101:2: ( ( ( rule__Namespace__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:102:1: ( ( rule__Namespace__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:102:1: ( ( rule__Namespace__Group__0 ) )
            // InternalBuilderTestLanguage.g:103:1: ( rule__Namespace__Group__0 )
            {
             before(grammarAccess.getNamespaceAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:104:1: ( rule__Namespace__Group__0 )
            // InternalBuilderTestLanguage.g:104:2: rule__Namespace__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:116:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:117:1: ( ruleImport EOF )
            // InternalBuilderTestLanguage.g:118:1: ruleImport EOF
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
    // InternalBuilderTestLanguage.g:125:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:129:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:130:1: ( ( rule__Import__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:130:1: ( ( rule__Import__Group__0 ) )
            // InternalBuilderTestLanguage.g:131:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:132:1: ( rule__Import__Group__0 )
            // InternalBuilderTestLanguage.g:132:2: rule__Import__Group__0
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
    // InternalBuilderTestLanguage.g:144:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:145:1: ( ruleElement EOF )
            // InternalBuilderTestLanguage.g:146:1: ruleElement EOF
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
    // InternalBuilderTestLanguage.g:153:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:157:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:158:1: ( ( rule__Element__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:158:1: ( ( rule__Element__Group__0 ) )
            // InternalBuilderTestLanguage.g:159:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:160:1: ( rule__Element__Group__0 )
            // InternalBuilderTestLanguage.g:160:2: rule__Element__Group__0
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


    // $ANTLR start "entryRuleQualifiedName"
    // InternalBuilderTestLanguage.g:172:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalBuilderTestLanguage.g:173:1: ( ruleQualifiedName EOF )
            // InternalBuilderTestLanguage.g:174:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalBuilderTestLanguage.g:181:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:185:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalBuilderTestLanguage.g:186:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalBuilderTestLanguage.g:186:1: ( ( rule__QualifiedName__Group__0 ) )
            // InternalBuilderTestLanguage.g:187:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalBuilderTestLanguage.g:188:1: ( rule__QualifiedName__Group__0 )
            // InternalBuilderTestLanguage.g:188:2: rule__QualifiedName__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:200:1: rule__NamedElement__Alternatives : ( ( ruleNamespace ) | ( ruleElement ) );
    public final void rule__NamedElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:204:1: ( ( ruleNamespace ) | ( ruleElement ) )
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
                    // InternalBuilderTestLanguage.g:205:1: ( ruleNamespace )
                    {
                    // InternalBuilderTestLanguage.g:205:1: ( ruleNamespace )
                    // InternalBuilderTestLanguage.g:206:1: ruleNamespace
                    {
                     before(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleNamespace();

                    state._fsp--;

                     after(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBuilderTestLanguage.g:211:6: ( ruleElement )
                    {
                    // InternalBuilderTestLanguage.g:211:6: ( ruleElement )
                    // InternalBuilderTestLanguage.g:212:1: ruleElement
                    {
                     before(grammarAccess.getNamedElementAccess().getElementParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:224:1: rule__Namespace__Group__0 : rule__Namespace__Group__0__Impl rule__Namespace__Group__1 ;
    public final void rule__Namespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:228:1: ( rule__Namespace__Group__0__Impl rule__Namespace__Group__1 )
            // InternalBuilderTestLanguage.g:229:2: rule__Namespace__Group__0__Impl rule__Namespace__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Namespace__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:236:1: rule__Namespace__Group__0__Impl : ( 'namespace' ) ;
    public final void rule__Namespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:240:1: ( ( 'namespace' ) )
            // InternalBuilderTestLanguage.g:241:1: ( 'namespace' )
            {
            // InternalBuilderTestLanguage.g:241:1: ( 'namespace' )
            // InternalBuilderTestLanguage.g:242:1: 'namespace'
            {
             before(grammarAccess.getNamespaceAccess().getNamespaceKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:255:1: rule__Namespace__Group__1 : rule__Namespace__Group__1__Impl rule__Namespace__Group__2 ;
    public final void rule__Namespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:259:1: ( rule__Namespace__Group__1__Impl rule__Namespace__Group__2 )
            // InternalBuilderTestLanguage.g:260:2: rule__Namespace__Group__1__Impl rule__Namespace__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Namespace__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:267:1: rule__Namespace__Group__1__Impl : ( ( rule__Namespace__NameAssignment_1 ) ) ;
    public final void rule__Namespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:271:1: ( ( ( rule__Namespace__NameAssignment_1 ) ) )
            // InternalBuilderTestLanguage.g:272:1: ( ( rule__Namespace__NameAssignment_1 ) )
            {
            // InternalBuilderTestLanguage.g:272:1: ( ( rule__Namespace__NameAssignment_1 ) )
            // InternalBuilderTestLanguage.g:273:1: ( rule__Namespace__NameAssignment_1 )
            {
             before(grammarAccess.getNamespaceAccess().getNameAssignment_1()); 
            // InternalBuilderTestLanguage.g:274:1: ( rule__Namespace__NameAssignment_1 )
            // InternalBuilderTestLanguage.g:274:2: rule__Namespace__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:284:1: rule__Namespace__Group__2 : rule__Namespace__Group__2__Impl rule__Namespace__Group__3 ;
    public final void rule__Namespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:288:1: ( rule__Namespace__Group__2__Impl rule__Namespace__Group__3 )
            // InternalBuilderTestLanguage.g:289:2: rule__Namespace__Group__2__Impl rule__Namespace__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Namespace__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:296:1: rule__Namespace__Group__2__Impl : ( '{' ) ;
    public final void rule__Namespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:300:1: ( ( '{' ) )
            // InternalBuilderTestLanguage.g:301:1: ( '{' )
            {
            // InternalBuilderTestLanguage.g:301:1: ( '{' )
            // InternalBuilderTestLanguage.g:302:1: '{'
            {
             before(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:315:1: rule__Namespace__Group__3 : rule__Namespace__Group__3__Impl rule__Namespace__Group__4 ;
    public final void rule__Namespace__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:319:1: ( rule__Namespace__Group__3__Impl rule__Namespace__Group__4 )
            // InternalBuilderTestLanguage.g:320:2: rule__Namespace__Group__3__Impl rule__Namespace__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Namespace__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:327:1: rule__Namespace__Group__3__Impl : ( ( rule__Namespace__ImportsAssignment_3 )* ) ;
    public final void rule__Namespace__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:331:1: ( ( ( rule__Namespace__ImportsAssignment_3 )* ) )
            // InternalBuilderTestLanguage.g:332:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            {
            // InternalBuilderTestLanguage.g:332:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            // InternalBuilderTestLanguage.g:333:1: ( rule__Namespace__ImportsAssignment_3 )*
            {
             before(grammarAccess.getNamespaceAccess().getImportsAssignment_3()); 
            // InternalBuilderTestLanguage.g:334:1: ( rule__Namespace__ImportsAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:334:2: rule__Namespace__ImportsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
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
    // InternalBuilderTestLanguage.g:344:1: rule__Namespace__Group__4 : rule__Namespace__Group__4__Impl rule__Namespace__Group__5 ;
    public final void rule__Namespace__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:348:1: ( rule__Namespace__Group__4__Impl rule__Namespace__Group__5 )
            // InternalBuilderTestLanguage.g:349:2: rule__Namespace__Group__4__Impl rule__Namespace__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Namespace__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:356:1: rule__Namespace__Group__4__Impl : ( ( rule__Namespace__ElementsAssignment_4 )* ) ;
    public final void rule__Namespace__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:360:1: ( ( ( rule__Namespace__ElementsAssignment_4 )* ) )
            // InternalBuilderTestLanguage.g:361:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            {
            // InternalBuilderTestLanguage.g:361:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            // InternalBuilderTestLanguage.g:362:1: ( rule__Namespace__ElementsAssignment_4 )*
            {
             before(grammarAccess.getNamespaceAccess().getElementsAssignment_4()); 
            // InternalBuilderTestLanguage.g:363:1: ( rule__Namespace__ElementsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:363:2: rule__Namespace__ElementsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
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
    // InternalBuilderTestLanguage.g:373:1: rule__Namespace__Group__5 : rule__Namespace__Group__5__Impl ;
    public final void rule__Namespace__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:377:1: ( rule__Namespace__Group__5__Impl )
            // InternalBuilderTestLanguage.g:378:2: rule__Namespace__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:384:1: rule__Namespace__Group__5__Impl : ( '}' ) ;
    public final void rule__Namespace__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:388:1: ( ( '}' ) )
            // InternalBuilderTestLanguage.g:389:1: ( '}' )
            {
            // InternalBuilderTestLanguage.g:389:1: ( '}' )
            // InternalBuilderTestLanguage.g:390:1: '}'
            {
             before(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_5()); 
            match(input,13,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:415:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:419:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalBuilderTestLanguage.g:420:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
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
    // InternalBuilderTestLanguage.g:427:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:431:1: ( ( 'import' ) )
            // InternalBuilderTestLanguage.g:432:1: ( 'import' )
            {
            // InternalBuilderTestLanguage.g:432:1: ( 'import' )
            // InternalBuilderTestLanguage.g:433:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:446:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:450:1: ( rule__Import__Group__1__Impl )
            // InternalBuilderTestLanguage.g:451:2: rule__Import__Group__1__Impl
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
    // InternalBuilderTestLanguage.g:457:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:461:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalBuilderTestLanguage.g:462:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalBuilderTestLanguage.g:462:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalBuilderTestLanguage.g:463:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalBuilderTestLanguage.g:464:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalBuilderTestLanguage.g:464:2: rule__Import__ImportedNamespaceAssignment_1
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
    // InternalBuilderTestLanguage.g:478:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:482:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalBuilderTestLanguage.g:483:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
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
    // InternalBuilderTestLanguage.g:490:1: rule__Element__Group__0__Impl : ( 'object' ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:494:1: ( ( 'object' ) )
            // InternalBuilderTestLanguage.g:495:1: ( 'object' )
            {
            // InternalBuilderTestLanguage.g:495:1: ( 'object' )
            // InternalBuilderTestLanguage.g:496:1: 'object'
            {
             before(grammarAccess.getElementAccess().getObjectKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:509:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:513:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalBuilderTestLanguage.g:514:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Element__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:521:1: rule__Element__Group__1__Impl : ( ( rule__Element__NameAssignment_1 ) ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:525:1: ( ( ( rule__Element__NameAssignment_1 ) ) )
            // InternalBuilderTestLanguage.g:526:1: ( ( rule__Element__NameAssignment_1 ) )
            {
            // InternalBuilderTestLanguage.g:526:1: ( ( rule__Element__NameAssignment_1 ) )
            // InternalBuilderTestLanguage.g:527:1: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // InternalBuilderTestLanguage.g:528:1: ( rule__Element__NameAssignment_1 )
            // InternalBuilderTestLanguage.g:528:2: rule__Element__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:538:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:542:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalBuilderTestLanguage.g:543:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Element__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:550:1: rule__Element__Group__2__Impl : ( ( rule__Element__Group_2__0 )? ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:554:1: ( ( ( rule__Element__Group_2__0 )? ) )
            // InternalBuilderTestLanguage.g:555:1: ( ( rule__Element__Group_2__0 )? )
            {
            // InternalBuilderTestLanguage.g:555:1: ( ( rule__Element__Group_2__0 )? )
            // InternalBuilderTestLanguage.g:556:1: ( rule__Element__Group_2__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_2()); 
            // InternalBuilderTestLanguage.g:557:1: ( rule__Element__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBuilderTestLanguage.g:557:2: rule__Element__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:567:1: rule__Element__Group__3 : rule__Element__Group__3__Impl ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:571:1: ( rule__Element__Group__3__Impl )
            // InternalBuilderTestLanguage.g:572:2: rule__Element__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:578:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:582:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // InternalBuilderTestLanguage.g:583:1: ( ( rule__Element__Group_3__0 )? )
            {
            // InternalBuilderTestLanguage.g:583:1: ( ( rule__Element__Group_3__0 )? )
            // InternalBuilderTestLanguage.g:584:1: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // InternalBuilderTestLanguage.g:585:1: ( rule__Element__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBuilderTestLanguage.g:585:2: rule__Element__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:603:1: rule__Element__Group_2__0 : rule__Element__Group_2__0__Impl rule__Element__Group_2__1 ;
    public final void rule__Element__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:607:1: ( rule__Element__Group_2__0__Impl rule__Element__Group_2__1 )
            // InternalBuilderTestLanguage.g:608:2: rule__Element__Group_2__0__Impl rule__Element__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Element__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:615:1: rule__Element__Group_2__0__Impl : ( 'references' ) ;
    public final void rule__Element__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:619:1: ( ( 'references' ) )
            // InternalBuilderTestLanguage.g:620:1: ( 'references' )
            {
            // InternalBuilderTestLanguage.g:620:1: ( 'references' )
            // InternalBuilderTestLanguage.g:621:1: 'references'
            {
             before(grammarAccess.getElementAccess().getReferencesKeyword_2_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:634:1: rule__Element__Group_2__1 : rule__Element__Group_2__1__Impl ;
    public final void rule__Element__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:638:1: ( rule__Element__Group_2__1__Impl )
            // InternalBuilderTestLanguage.g:639:2: rule__Element__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:645:1: rule__Element__Group_2__1__Impl : ( ( rule__Element__ReferencesAssignment_2_1 ) ) ;
    public final void rule__Element__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:649:1: ( ( ( rule__Element__ReferencesAssignment_2_1 ) ) )
            // InternalBuilderTestLanguage.g:650:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            {
            // InternalBuilderTestLanguage.g:650:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            // InternalBuilderTestLanguage.g:651:1: ( rule__Element__ReferencesAssignment_2_1 )
            {
             before(grammarAccess.getElementAccess().getReferencesAssignment_2_1()); 
            // InternalBuilderTestLanguage.g:652:1: ( rule__Element__ReferencesAssignment_2_1 )
            // InternalBuilderTestLanguage.g:652:2: rule__Element__ReferencesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:666:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:670:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // InternalBuilderTestLanguage.g:671:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Element__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:678:1: rule__Element__Group_3__0__Impl : ( 'otherRefs' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:682:1: ( ( 'otherRefs' ) )
            // InternalBuilderTestLanguage.g:683:1: ( 'otherRefs' )
            {
            // InternalBuilderTestLanguage.g:683:1: ( 'otherRefs' )
            // InternalBuilderTestLanguage.g:684:1: 'otherRefs'
            {
             before(grammarAccess.getElementAccess().getOtherRefsKeyword_3_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:697:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl rule__Element__Group_3__2 ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:701:1: ( rule__Element__Group_3__1__Impl rule__Element__Group_3__2 )
            // InternalBuilderTestLanguage.g:702:2: rule__Element__Group_3__1__Impl rule__Element__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Element__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:709:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__OtherRefsAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:713:1: ( ( ( rule__Element__OtherRefsAssignment_3_1 ) ) )
            // InternalBuilderTestLanguage.g:714:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            {
            // InternalBuilderTestLanguage.g:714:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            // InternalBuilderTestLanguage.g:715:1: ( rule__Element__OtherRefsAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1()); 
            // InternalBuilderTestLanguage.g:716:1: ( rule__Element__OtherRefsAssignment_3_1 )
            // InternalBuilderTestLanguage.g:716:2: rule__Element__OtherRefsAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:726:1: rule__Element__Group_3__2 : rule__Element__Group_3__2__Impl ;
    public final void rule__Element__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:730:1: ( rule__Element__Group_3__2__Impl )
            // InternalBuilderTestLanguage.g:731:2: rule__Element__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:737:1: rule__Element__Group_3__2__Impl : ( ( rule__Element__Group_3_2__0 )* ) ;
    public final void rule__Element__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:741:1: ( ( ( rule__Element__Group_3_2__0 )* ) )
            // InternalBuilderTestLanguage.g:742:1: ( ( rule__Element__Group_3_2__0 )* )
            {
            // InternalBuilderTestLanguage.g:742:1: ( ( rule__Element__Group_3_2__0 )* )
            // InternalBuilderTestLanguage.g:743:1: ( rule__Element__Group_3_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_3_2()); 
            // InternalBuilderTestLanguage.g:744:1: ( rule__Element__Group_3_2__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:744:2: rule__Element__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_10);
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
    // InternalBuilderTestLanguage.g:760:1: rule__Element__Group_3_2__0 : rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1 ;
    public final void rule__Element__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:764:1: ( rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1 )
            // InternalBuilderTestLanguage.g:765:2: rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Element__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:772:1: rule__Element__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Element__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:776:1: ( ( ',' ) )
            // InternalBuilderTestLanguage.g:777:1: ( ',' )
            {
            // InternalBuilderTestLanguage.g:777:1: ( ',' )
            // InternalBuilderTestLanguage.g:778:1: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_3_2_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:791:1: rule__Element__Group_3_2__1 : rule__Element__Group_3_2__1__Impl ;
    public final void rule__Element__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:795:1: ( rule__Element__Group_3_2__1__Impl )
            // InternalBuilderTestLanguage.g:796:2: rule__Element__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:802:1: rule__Element__Group_3_2__1__Impl : ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) ;
    public final void rule__Element__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:806:1: ( ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) )
            // InternalBuilderTestLanguage.g:807:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            {
            // InternalBuilderTestLanguage.g:807:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            // InternalBuilderTestLanguage.g:808:1: ( rule__Element__OtherRefsAssignment_3_2_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_2_1()); 
            // InternalBuilderTestLanguage.g:809:1: ( rule__Element__OtherRefsAssignment_3_2_1 )
            // InternalBuilderTestLanguage.g:809:2: rule__Element__OtherRefsAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:823:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:827:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalBuilderTestLanguage.g:828:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:835:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:839:1: ( ( RULE_ID ) )
            // InternalBuilderTestLanguage.g:840:1: ( RULE_ID )
            {
            // InternalBuilderTestLanguage.g:840:1: ( RULE_ID )
            // InternalBuilderTestLanguage.g:841:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:852:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:856:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalBuilderTestLanguage.g:857:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:863:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:867:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalBuilderTestLanguage.g:868:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalBuilderTestLanguage.g:868:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalBuilderTestLanguage.g:869:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalBuilderTestLanguage.g:870:1: ( rule__QualifiedName__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBuilderTestLanguage.g:870:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_12);
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
    // InternalBuilderTestLanguage.g:884:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:888:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalBuilderTestLanguage.g:889:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:896:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:900:1: ( ( '.' ) )
            // InternalBuilderTestLanguage.g:901:1: ( '.' )
            {
            // InternalBuilderTestLanguage.g:901:1: ( '.' )
            // InternalBuilderTestLanguage.g:902:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,19,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:915:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:919:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalBuilderTestLanguage.g:920:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:926:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:930:1: ( ( RULE_ID ) )
            // InternalBuilderTestLanguage.g:931:1: ( RULE_ID )
            {
            // InternalBuilderTestLanguage.g:931:1: ( RULE_ID )
            // InternalBuilderTestLanguage.g:932:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:948:1: rule__Namespace__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Namespace__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:952:1: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:953:1: ( ruleQualifiedName )
            {
            // InternalBuilderTestLanguage.g:953:1: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:954:1: ruleQualifiedName
            {
             before(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:963:1: rule__Namespace__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__Namespace__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:967:1: ( ( ruleImport ) )
            // InternalBuilderTestLanguage.g:968:1: ( ruleImport )
            {
            // InternalBuilderTestLanguage.g:968:1: ( ruleImport )
            // InternalBuilderTestLanguage.g:969:1: ruleImport
            {
             before(grammarAccess.getNamespaceAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:978:1: rule__Namespace__ElementsAssignment_4 : ( ruleNamedElement ) ;
    public final void rule__Namespace__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:982:1: ( ( ruleNamedElement ) )
            // InternalBuilderTestLanguage.g:983:1: ( ruleNamedElement )
            {
            // InternalBuilderTestLanguage.g:983:1: ( ruleNamedElement )
            // InternalBuilderTestLanguage.g:984:1: ruleNamedElement
            {
             before(grammarAccess.getNamespaceAccess().getElementsNamedElementParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:993:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:997:1: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:998:1: ( ruleQualifiedName )
            {
            // InternalBuilderTestLanguage.g:998:1: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:999:1: ruleQualifiedName
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:1008:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:1012:1: ( ( RULE_ID ) )
            // InternalBuilderTestLanguage.g:1013:1: ( RULE_ID )
            {
            // InternalBuilderTestLanguage.g:1013:1: ( RULE_ID )
            // InternalBuilderTestLanguage.g:1014:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalBuilderTestLanguage.g:1023:1: rule__Element__ReferencesAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__ReferencesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:1027:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBuilderTestLanguage.g:1028:1: ( ( ruleQualifiedName ) )
            {
            // InternalBuilderTestLanguage.g:1028:1: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:1029:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0()); 
            // InternalBuilderTestLanguage.g:1030:1: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:1031:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getReferencesElementQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:1042:1: rule__Element__OtherRefsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:1046:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBuilderTestLanguage.g:1047:1: ( ( ruleQualifiedName ) )
            {
            // InternalBuilderTestLanguage.g:1047:1: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:1048:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0()); 
            // InternalBuilderTestLanguage.g:1049:1: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:1050:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBuilderTestLanguage.g:1061:1: rule__Element__OtherRefsAssignment_3_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBuilderTestLanguage.g:1065:1: ( ( ( ruleQualifiedName ) ) )
            // InternalBuilderTestLanguage.g:1066:1: ( ( ruleQualifiedName ) )
            {
            // InternalBuilderTestLanguage.g:1066:1: ( ( ruleQualifiedName ) )
            // InternalBuilderTestLanguage.g:1067:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0()); 
            // InternalBuilderTestLanguage.g:1068:1: ( ruleQualifiedName )
            // InternalBuilderTestLanguage.g:1069:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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


 

    
    private static class FollowSets000 {
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


}
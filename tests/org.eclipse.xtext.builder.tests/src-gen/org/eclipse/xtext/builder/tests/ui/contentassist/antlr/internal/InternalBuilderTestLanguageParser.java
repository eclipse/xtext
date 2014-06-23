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
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:60:1: entryRuleNamedElement : ruleNamedElement EOF ;
    public final void entryRuleNamedElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:61:1: ( ruleNamedElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:62:1: ruleNamedElement EOF
            {
             before(grammarAccess.getNamedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_entryRuleNamedElement61);
            ruleNamedElement();

            state._fsp--;

             after(grammarAccess.getNamedElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedElement68); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:69:1: ruleNamedElement : ( ( rule__NamedElement__Alternatives ) ) ;
    public final void ruleNamedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:73:2: ( ( ( rule__NamedElement__Alternatives ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:74:1: ( ( rule__NamedElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:74:1: ( ( rule__NamedElement__Alternatives ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:75:1: ( rule__NamedElement__Alternatives )
            {
             before(grammarAccess.getNamedElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:76:1: ( rule__NamedElement__Alternatives )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:76:2: rule__NamedElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__NamedElement__Alternatives_in_ruleNamedElement94);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:88:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:89:1: ( ruleNamespace EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:90:1: ruleNamespace EOF
            {
             before(grammarAccess.getNamespaceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_entryRuleNamespace121);
            ruleNamespace();

            state._fsp--;

             after(grammarAccess.getNamespaceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamespace128); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:97:1: ruleNamespace : ( ( rule__Namespace__Group__0 ) ) ;
    public final void ruleNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:101:2: ( ( ( rule__Namespace__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:102:1: ( ( rule__Namespace__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:102:1: ( ( rule__Namespace__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:103:1: ( rule__Namespace__Group__0 )
            {
             before(grammarAccess.getNamespaceAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:104:1: ( rule__Namespace__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:104:2: rule__Namespace__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__0_in_ruleNamespace154);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:116:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:117:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:118:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport181);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport188); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:125:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:129:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:130:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:130:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:131:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:132:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:132:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0_in_ruleImport214);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:144:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:145:1: ( ruleElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:146:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement241);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement248); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:153:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:157:2: ( ( ( rule__Element__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:158:1: ( ( rule__Element__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:158:1: ( ( rule__Element__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:159:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:160:1: ( rule__Element__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:160:2: rule__Element__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0_in_ruleElement274);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:172:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:173:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:174:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName301);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName308); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:181:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:185:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:186:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:186:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:187:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:188:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:188:2: rule__QualifiedName__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName334);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:200:1: rule__NamedElement__Alternatives : ( ( ruleNamespace ) | ( ruleElement ) );
    public final void rule__NamedElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:204:1: ( ( ruleNamespace ) | ( ruleElement ) )
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
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:205:1: ( ruleNamespace )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:205:1: ( ruleNamespace )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:206:1: ruleNamespace
                    {
                     before(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_rule__NamedElement__Alternatives370);
                    ruleNamespace();

                    state._fsp--;

                     after(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:211:6: ( ruleElement )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:211:6: ( ruleElement )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:212:1: ruleElement
                    {
                     before(grammarAccess.getNamedElementAccess().getElementParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__NamedElement__Alternatives387);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:224:1: rule__Namespace__Group__0 : rule__Namespace__Group__0__Impl rule__Namespace__Group__1 ;
    public final void rule__Namespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:228:1: ( rule__Namespace__Group__0__Impl rule__Namespace__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:229:2: rule__Namespace__Group__0__Impl rule__Namespace__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__0__Impl_in_rule__Namespace__Group__0417);
            rule__Namespace__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__1_in_rule__Namespace__Group__0420);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:236:1: rule__Namespace__Group__0__Impl : ( 'namespace' ) ;
    public final void rule__Namespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:240:1: ( ( 'namespace' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:241:1: ( 'namespace' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:241:1: ( 'namespace' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:242:1: 'namespace'
            {
             before(grammarAccess.getNamespaceAccess().getNamespaceKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Namespace__Group__0__Impl448); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:255:1: rule__Namespace__Group__1 : rule__Namespace__Group__1__Impl rule__Namespace__Group__2 ;
    public final void rule__Namespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:259:1: ( rule__Namespace__Group__1__Impl rule__Namespace__Group__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:260:2: rule__Namespace__Group__1__Impl rule__Namespace__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__1__Impl_in_rule__Namespace__Group__1479);
            rule__Namespace__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__2_in_rule__Namespace__Group__1482);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:267:1: rule__Namespace__Group__1__Impl : ( ( rule__Namespace__NameAssignment_1 ) ) ;
    public final void rule__Namespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:271:1: ( ( ( rule__Namespace__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:272:1: ( ( rule__Namespace__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:272:1: ( ( rule__Namespace__NameAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:273:1: ( rule__Namespace__NameAssignment_1 )
            {
             before(grammarAccess.getNamespaceAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:274:1: ( rule__Namespace__NameAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:274:2: rule__Namespace__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__NameAssignment_1_in_rule__Namespace__Group__1__Impl509);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:284:1: rule__Namespace__Group__2 : rule__Namespace__Group__2__Impl rule__Namespace__Group__3 ;
    public final void rule__Namespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:288:1: ( rule__Namespace__Group__2__Impl rule__Namespace__Group__3 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:289:2: rule__Namespace__Group__2__Impl rule__Namespace__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__2__Impl_in_rule__Namespace__Group__2539);
            rule__Namespace__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__3_in_rule__Namespace__Group__2542);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:296:1: rule__Namespace__Group__2__Impl : ( '{' ) ;
    public final void rule__Namespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:300:1: ( ( '{' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:301:1: ( '{' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:301:1: ( '{' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:302:1: '{'
            {
             before(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Namespace__Group__2__Impl570); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:315:1: rule__Namespace__Group__3 : rule__Namespace__Group__3__Impl rule__Namespace__Group__4 ;
    public final void rule__Namespace__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:319:1: ( rule__Namespace__Group__3__Impl rule__Namespace__Group__4 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:320:2: rule__Namespace__Group__3__Impl rule__Namespace__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__3__Impl_in_rule__Namespace__Group__3601);
            rule__Namespace__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__4_in_rule__Namespace__Group__3604);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:327:1: rule__Namespace__Group__3__Impl : ( ( rule__Namespace__ImportsAssignment_3 )* ) ;
    public final void rule__Namespace__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:331:1: ( ( ( rule__Namespace__ImportsAssignment_3 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:332:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:332:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:333:1: ( rule__Namespace__ImportsAssignment_3 )*
            {
             before(grammarAccess.getNamespaceAccess().getImportsAssignment_3()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:334:1: ( rule__Namespace__ImportsAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:334:2: rule__Namespace__ImportsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Namespace__ImportsAssignment_3_in_rule__Namespace__Group__3__Impl631);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:344:1: rule__Namespace__Group__4 : rule__Namespace__Group__4__Impl rule__Namespace__Group__5 ;
    public final void rule__Namespace__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:348:1: ( rule__Namespace__Group__4__Impl rule__Namespace__Group__5 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:349:2: rule__Namespace__Group__4__Impl rule__Namespace__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__4__Impl_in_rule__Namespace__Group__4662);
            rule__Namespace__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__5_in_rule__Namespace__Group__4665);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:356:1: rule__Namespace__Group__4__Impl : ( ( rule__Namespace__ElementsAssignment_4 )* ) ;
    public final void rule__Namespace__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:360:1: ( ( ( rule__Namespace__ElementsAssignment_4 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:361:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:361:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:362:1: ( rule__Namespace__ElementsAssignment_4 )*
            {
             before(grammarAccess.getNamespaceAccess().getElementsAssignment_4()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:363:1: ( rule__Namespace__ElementsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:363:2: rule__Namespace__ElementsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Namespace__ElementsAssignment_4_in_rule__Namespace__Group__4__Impl692);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:373:1: rule__Namespace__Group__5 : rule__Namespace__Group__5__Impl ;
    public final void rule__Namespace__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:377:1: ( rule__Namespace__Group__5__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:378:2: rule__Namespace__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__5__Impl_in_rule__Namespace__Group__5723);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:384:1: rule__Namespace__Group__5__Impl : ( '}' ) ;
    public final void rule__Namespace__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:388:1: ( ( '}' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:389:1: ( '}' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:389:1: ( '}' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:390:1: '}'
            {
             before(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Namespace__Group__5__Impl751); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:415:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:419:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:420:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0794);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0797);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:427:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:431:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:432:1: ( 'import' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:432:1: ( 'import' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:433:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Import__Group__0__Impl825); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:446:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:450:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:451:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1856);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:457:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:461:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:462:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:462:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:463:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:464:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:464:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl883);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:478:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:482:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:483:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__0917);
            rule__Element__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0920);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:490:1: rule__Element__Group__0__Impl : ( 'object' ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:494:1: ( ( 'object' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:495:1: ( 'object' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:495:1: ( 'object' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:496:1: 'object'
            {
             before(grammarAccess.getElementAccess().getObjectKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Element__Group__0__Impl948); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:509:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:513:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:514:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1979);
            rule__Element__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1982);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:521:1: rule__Element__Group__1__Impl : ( ( rule__Element__NameAssignment_1 ) ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:525:1: ( ( ( rule__Element__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:526:1: ( ( rule__Element__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:526:1: ( ( rule__Element__NameAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:527:1: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:528:1: ( rule__Element__NameAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:528:2: rule__Element__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__NameAssignment_1_in_rule__Element__Group__1__Impl1009);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:538:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:542:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:543:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__21039);
            rule__Element__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3_in_rule__Element__Group__21042);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:550:1: rule__Element__Group__2__Impl : ( ( rule__Element__Group_2__0 )? ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:554:1: ( ( ( rule__Element__Group_2__0 )? ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:555:1: ( ( rule__Element__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:555:1: ( ( rule__Element__Group_2__0 )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:556:1: ( rule__Element__Group_2__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_2()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:557:1: ( rule__Element__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:557:2: rule__Element__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__0_in_rule__Element__Group__2__Impl1069);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:567:1: rule__Element__Group__3 : rule__Element__Group__3__Impl ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:571:1: ( rule__Element__Group__3__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:572:2: rule__Element__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3__Impl_in_rule__Element__Group__31100);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:578:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:582:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:583:1: ( ( rule__Element__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:583:1: ( ( rule__Element__Group_3__0 )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:584:1: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:585:1: ( rule__Element__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:585:2: rule__Element__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3__Impl1127);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:603:1: rule__Element__Group_2__0 : rule__Element__Group_2__0__Impl rule__Element__Group_2__1 ;
    public final void rule__Element__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:607:1: ( rule__Element__Group_2__0__Impl rule__Element__Group_2__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:608:2: rule__Element__Group_2__0__Impl rule__Element__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__0__Impl_in_rule__Element__Group_2__01166);
            rule__Element__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__1_in_rule__Element__Group_2__01169);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:615:1: rule__Element__Group_2__0__Impl : ( 'references' ) ;
    public final void rule__Element__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:619:1: ( ( 'references' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:620:1: ( 'references' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:620:1: ( 'references' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:621:1: 'references'
            {
             before(grammarAccess.getElementAccess().getReferencesKeyword_2_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Element__Group_2__0__Impl1197); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:634:1: rule__Element__Group_2__1 : rule__Element__Group_2__1__Impl ;
    public final void rule__Element__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:638:1: ( rule__Element__Group_2__1__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:639:2: rule__Element__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__1__Impl_in_rule__Element__Group_2__11228);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:645:1: rule__Element__Group_2__1__Impl : ( ( rule__Element__ReferencesAssignment_2_1 ) ) ;
    public final void rule__Element__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:649:1: ( ( ( rule__Element__ReferencesAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:650:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:650:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:651:1: ( rule__Element__ReferencesAssignment_2_1 )
            {
             before(grammarAccess.getElementAccess().getReferencesAssignment_2_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:652:1: ( rule__Element__ReferencesAssignment_2_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:652:2: rule__Element__ReferencesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__ReferencesAssignment_2_1_in_rule__Element__Group_2__1__Impl1255);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:666:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:670:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:671:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0__Impl_in_rule__Element__Group_3__01289);
            rule__Element__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__01292);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:678:1: rule__Element__Group_3__0__Impl : ( 'otherRefs' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:682:1: ( ( 'otherRefs' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:683:1: ( 'otherRefs' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:683:1: ( 'otherRefs' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:684:1: 'otherRefs'
            {
             before(grammarAccess.getElementAccess().getOtherRefsKeyword_3_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Element__Group_3__0__Impl1320); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:697:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl rule__Element__Group_3__2 ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:701:1: ( rule__Element__Group_3__1__Impl rule__Element__Group_3__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:702:2: rule__Element__Group_3__1__Impl rule__Element__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1__Impl_in_rule__Element__Group_3__11351);
            rule__Element__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__2_in_rule__Element__Group_3__11354);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:709:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__OtherRefsAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:713:1: ( ( ( rule__Element__OtherRefsAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:714:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:714:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:715:1: ( rule__Element__OtherRefsAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:716:1: ( rule__Element__OtherRefsAssignment_3_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:716:2: rule__Element__OtherRefsAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__OtherRefsAssignment_3_1_in_rule__Element__Group_3__1__Impl1381);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:726:1: rule__Element__Group_3__2 : rule__Element__Group_3__2__Impl ;
    public final void rule__Element__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:730:1: ( rule__Element__Group_3__2__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:731:2: rule__Element__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__2__Impl_in_rule__Element__Group_3__21411);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:737:1: rule__Element__Group_3__2__Impl : ( ( rule__Element__Group_3_2__0 )* ) ;
    public final void rule__Element__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:741:1: ( ( ( rule__Element__Group_3_2__0 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:742:1: ( ( rule__Element__Group_3_2__0 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:742:1: ( ( rule__Element__Group_3_2__0 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:743:1: ( rule__Element__Group_3_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_3_2()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:744:1: ( rule__Element__Group_3_2__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:744:2: rule__Element__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__0_in_rule__Element__Group_3__2__Impl1438);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:760:1: rule__Element__Group_3_2__0 : rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1 ;
    public final void rule__Element__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:764:1: ( rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:765:2: rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__0__Impl_in_rule__Element__Group_3_2__01475);
            rule__Element__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__1_in_rule__Element__Group_3_2__01478);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:772:1: rule__Element__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Element__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:776:1: ( ( ',' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:777:1: ( ',' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:777:1: ( ',' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:778:1: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_3_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Element__Group_3_2__0__Impl1506); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:791:1: rule__Element__Group_3_2__1 : rule__Element__Group_3_2__1__Impl ;
    public final void rule__Element__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:795:1: ( rule__Element__Group_3_2__1__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:796:2: rule__Element__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__1__Impl_in_rule__Element__Group_3_2__11537);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:802:1: rule__Element__Group_3_2__1__Impl : ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) ;
    public final void rule__Element__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:806:1: ( ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:807:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:807:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:808:1: ( rule__Element__OtherRefsAssignment_3_2_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_2_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:809:1: ( rule__Element__OtherRefsAssignment_3_2_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:809:2: rule__Element__OtherRefsAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__OtherRefsAssignment_3_2_1_in_rule__Element__Group_3_2__1__Impl1564);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:823:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:827:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:828:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01598);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01601);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:835:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:839:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:840:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:840:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:841:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl1628); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:852:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:856:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:857:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11657);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:863:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:867:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:868:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:868:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:869:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:870:1: ( rule__QualifiedName__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:870:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl1684);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:884:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:888:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:889:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__01719);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01722);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:896:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:900:1: ( ( '.' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:901:1: ( '.' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:901:1: ( '.' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:902:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__QualifiedName__Group_1__0__Impl1750); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:915:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:919:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:920:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__11781);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:926:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:930:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:931:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:931:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:932:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl1808); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:948:1: rule__Namespace__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Namespace__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:952:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:953:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:953:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:954:1: ruleQualifiedName
            {
             before(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Namespace__NameAssignment_11846);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:963:1: rule__Namespace__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__Namespace__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:967:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:968:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:968:1: ( ruleImport )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:969:1: ruleImport
            {
             before(grammarAccess.getNamespaceAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__Namespace__ImportsAssignment_31877);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:978:1: rule__Namespace__ElementsAssignment_4 : ( ruleNamedElement ) ;
    public final void rule__Namespace__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:982:1: ( ( ruleNamedElement ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:983:1: ( ruleNamedElement )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:983:1: ( ruleNamedElement )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:984:1: ruleNamedElement
            {
             before(grammarAccess.getNamespaceAccess().getElementsNamedElementParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_rule__Namespace__ElementsAssignment_41908);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:993:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:997:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:998:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:998:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:999:1: ruleQualifiedName
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Import__ImportedNamespaceAssignment_11939);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1008:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1012:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1013:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1013:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1014:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__NameAssignment_11970); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1023:1: rule__Element__ReferencesAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__ReferencesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1027:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1028:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1028:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1029:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1030:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1031:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getReferencesElementQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__ReferencesAssignment_2_12005);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1042:1: rule__Element__OtherRefsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1046:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1047:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1047:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1048:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1049:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1050:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_12044);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1061:1: rule__Element__OtherRefsAssignment_3_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1065:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1066:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1066:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1067:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1068:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1069:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_2_12083);
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
        public static final BitSet FOLLOW_ruleNamedElement_in_entryRuleNamedElement61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedElement68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NamedElement__Alternatives_in_ruleNamedElement94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamespace128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__Group__0_in_ruleNamespace154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0_in_ruleElement274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespace_in_rule__NamedElement__Alternatives370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__NamedElement__Alternatives387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__Group__0__Impl_in_rule__Namespace__Group__0417 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Namespace__Group__1_in_rule__Namespace__Group__0420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Namespace__Group__0__Impl448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__Group__1__Impl_in_rule__Namespace__Group__1479 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Namespace__Group__2_in_rule__Namespace__Group__1482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__NameAssignment_1_in_rule__Namespace__Group__1__Impl509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__Group__2__Impl_in_rule__Namespace__Group__2539 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_rule__Namespace__Group__3_in_rule__Namespace__Group__2542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Namespace__Group__2__Impl570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__Group__3__Impl_in_rule__Namespace__Group__3601 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_rule__Namespace__Group__4_in_rule__Namespace__Group__3604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__ImportsAssignment_3_in_rule__Namespace__Group__3__Impl631 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__Namespace__Group__4__Impl_in_rule__Namespace__Group__4662 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_rule__Namespace__Group__5_in_rule__Namespace__Group__4665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__ElementsAssignment_4_in_rule__Namespace__Group__4__Impl692 = new BitSet(new long[]{0x0000000000008802L});
        public static final BitSet FOLLOW_rule__Namespace__Group__5__Impl_in_rule__Namespace__Group__5723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Namespace__Group__5__Impl751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0794 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Import__Group__0__Impl825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__0917 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Element__Group__0__Impl948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1979 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__NameAssignment_1_in_rule__Element__Group__1__Impl1009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__21039 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_rule__Element__Group__3_in_rule__Element__Group__21042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_2__0_in_rule__Element__Group__2__Impl1069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__3__Impl_in_rule__Element__Group__31100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3__Impl1127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_2__0__Impl_in_rule__Element__Group_2__01166 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_2__1_in_rule__Element__Group_2__01169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Element__Group_2__0__Impl1197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_2__1__Impl_in_rule__Element__Group_2__11228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__ReferencesAssignment_2_1_in_rule__Element__Group_2__1__Impl1255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__0__Impl_in_rule__Element__Group_3__01289 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__01292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Element__Group_3__0__Impl1320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__1__Impl_in_rule__Element__Group_3__11351 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Element__Group_3__2_in_rule__Element__Group_3__11354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__OtherRefsAssignment_3_1_in_rule__Element__Group_3__1__Impl1381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__2__Impl_in_rule__Element__Group_3__21411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__0_in_rule__Element__Group_3__2__Impl1438 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__0__Impl_in_rule__Element__Group_3_2__01475 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__1_in_rule__Element__Group_3_2__01478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Element__Group_3_2__0__Impl1506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__1__Impl_in_rule__Element__Group_3_2__11537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__OtherRefsAssignment_3_2_1_in_rule__Element__Group_3_2__1__Impl1564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01598 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl1628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl1684 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__01719 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__QualifiedName__Group_1__0__Impl1750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__11781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl1808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Namespace__NameAssignment_11846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__Namespace__ImportsAssignment_31877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamedElement_in_rule__Namespace__ElementsAssignment_41908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Import__ImportedNamespaceAssignment_11939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__NameAssignment_11970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Element__ReferencesAssignment_2_12005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_12044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_2_12083 = new BitSet(new long[]{0x0000000000000002L});
    }


}
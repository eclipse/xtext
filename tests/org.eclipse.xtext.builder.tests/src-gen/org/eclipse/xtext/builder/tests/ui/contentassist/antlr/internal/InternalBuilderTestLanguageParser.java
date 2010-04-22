package org.eclipse.xtext.builder.tests.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
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

public class InternalBuilderTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'namespace'", "'{'", "'}'", "'import'", "'object'", "'references'", "'otherRefs'", "','", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBuilderTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
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




    // $ANTLR start entryRuleNamedElement
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:61:1: entryRuleNamedElement : ruleNamedElement EOF ;
    public final void entryRuleNamedElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:62:1: ( ruleNamedElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:63:1: ruleNamedElement EOF
            {
             before(grammarAccess.getNamedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_entryRuleNamedElement61);
            ruleNamedElement();
            _fsp--;

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
    // $ANTLR end entryRuleNamedElement


    // $ANTLR start ruleNamedElement
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:70:1: ruleNamedElement : ( ( rule__NamedElement__Alternatives ) ) ;
    public final void ruleNamedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:74:2: ( ( ( rule__NamedElement__Alternatives ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:75:1: ( ( rule__NamedElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:75:1: ( ( rule__NamedElement__Alternatives ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:76:1: ( rule__NamedElement__Alternatives )
            {
             before(grammarAccess.getNamedElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:77:1: ( rule__NamedElement__Alternatives )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:77:2: rule__NamedElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__NamedElement__Alternatives_in_ruleNamedElement94);
            rule__NamedElement__Alternatives();
            _fsp--;


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
    // $ANTLR end ruleNamedElement


    // $ANTLR start entryRuleNamespace
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:89:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:90:1: ( ruleNamespace EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:91:1: ruleNamespace EOF
            {
             before(grammarAccess.getNamespaceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_entryRuleNamespace121);
            ruleNamespace();
            _fsp--;

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
    // $ANTLR end entryRuleNamespace


    // $ANTLR start ruleNamespace
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:98:1: ruleNamespace : ( ( rule__Namespace__Group__0 ) ) ;
    public final void ruleNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:102:2: ( ( ( rule__Namespace__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:103:1: ( ( rule__Namespace__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:103:1: ( ( rule__Namespace__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:104:1: ( rule__Namespace__Group__0 )
            {
             before(grammarAccess.getNamespaceAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:105:1: ( rule__Namespace__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:105:2: rule__Namespace__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__0_in_ruleNamespace154);
            rule__Namespace__Group__0();
            _fsp--;


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
    // $ANTLR end ruleNamespace


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:117:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:118:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:119:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport181);
            ruleImport();
            _fsp--;

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:126:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:130:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:131:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:131:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:132:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:133:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:133:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0_in_ruleImport214);
            rule__Import__Group__0();
            _fsp--;


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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleElement
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:145:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:146:1: ( ruleElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:147:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement241);
            ruleElement();
            _fsp--;

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
    // $ANTLR end entryRuleElement


    // $ANTLR start ruleElement
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:154:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:158:2: ( ( ( rule__Element__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:159:1: ( ( rule__Element__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:159:1: ( ( rule__Element__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:160:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:161:1: ( rule__Element__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:161:2: rule__Element__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0_in_ruleElement274);
            rule__Element__Group__0();
            _fsp--;


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
    // $ANTLR end ruleElement


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:173:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:174:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:175:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName301);
            ruleQualifiedName();
            _fsp--;

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
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:182:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:186:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:187:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:187:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:188:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:189:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:189:2: rule__QualifiedName__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName334);
            rule__QualifiedName__Group__0();
            _fsp--;


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
    // $ANTLR end ruleQualifiedName


    // $ANTLR start rule__NamedElement__Alternatives
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:201:1: rule__NamedElement__Alternatives : ( ( ruleNamespace ) | ( ruleElement ) );
    public final void rule__NamedElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:205:1: ( ( ruleNamespace ) | ( ruleElement ) )
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
                    new NoViableAltException("201:1: rule__NamedElement__Alternatives : ( ( ruleNamespace ) | ( ruleElement ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:206:1: ( ruleNamespace )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:206:1: ( ruleNamespace )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:207:1: ruleNamespace
                    {
                     before(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_rule__NamedElement__Alternatives370);
                    ruleNamespace();
                    _fsp--;

                     after(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:212:6: ( ruleElement )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:212:6: ( ruleElement )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:213:1: ruleElement
                    {
                     before(grammarAccess.getNamedElementAccess().getElementParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__NamedElement__Alternatives387);
                    ruleElement();
                    _fsp--;

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
    // $ANTLR end rule__NamedElement__Alternatives


    // $ANTLR start rule__Namespace__Group__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:225:1: rule__Namespace__Group__0 : rule__Namespace__Group__0__Impl rule__Namespace__Group__1 ;
    public final void rule__Namespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:229:1: ( rule__Namespace__Group__0__Impl rule__Namespace__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:230:2: rule__Namespace__Group__0__Impl rule__Namespace__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__0__Impl_in_rule__Namespace__Group__0417);
            rule__Namespace__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__1_in_rule__Namespace__Group__0420);
            rule__Namespace__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Namespace__Group__0


    // $ANTLR start rule__Namespace__Group__0__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:237:1: rule__Namespace__Group__0__Impl : ( 'namespace' ) ;
    public final void rule__Namespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:241:1: ( ( 'namespace' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:242:1: ( 'namespace' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:242:1: ( 'namespace' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:243:1: 'namespace'
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
    // $ANTLR end rule__Namespace__Group__0__Impl


    // $ANTLR start rule__Namespace__Group__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:256:1: rule__Namespace__Group__1 : rule__Namespace__Group__1__Impl rule__Namespace__Group__2 ;
    public final void rule__Namespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:260:1: ( rule__Namespace__Group__1__Impl rule__Namespace__Group__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:261:2: rule__Namespace__Group__1__Impl rule__Namespace__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__1__Impl_in_rule__Namespace__Group__1479);
            rule__Namespace__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__2_in_rule__Namespace__Group__1482);
            rule__Namespace__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Namespace__Group__1


    // $ANTLR start rule__Namespace__Group__1__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:268:1: rule__Namespace__Group__1__Impl : ( ( rule__Namespace__NameAssignment_1 ) ) ;
    public final void rule__Namespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:272:1: ( ( ( rule__Namespace__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:273:1: ( ( rule__Namespace__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:273:1: ( ( rule__Namespace__NameAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:274:1: ( rule__Namespace__NameAssignment_1 )
            {
             before(grammarAccess.getNamespaceAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:275:1: ( rule__Namespace__NameAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:275:2: rule__Namespace__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__NameAssignment_1_in_rule__Namespace__Group__1__Impl509);
            rule__Namespace__NameAssignment_1();
            _fsp--;


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
    // $ANTLR end rule__Namespace__Group__1__Impl


    // $ANTLR start rule__Namespace__Group__2
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:285:1: rule__Namespace__Group__2 : rule__Namespace__Group__2__Impl rule__Namespace__Group__3 ;
    public final void rule__Namespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:289:1: ( rule__Namespace__Group__2__Impl rule__Namespace__Group__3 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:290:2: rule__Namespace__Group__2__Impl rule__Namespace__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__2__Impl_in_rule__Namespace__Group__2539);
            rule__Namespace__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__3_in_rule__Namespace__Group__2542);
            rule__Namespace__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Namespace__Group__2


    // $ANTLR start rule__Namespace__Group__2__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:297:1: rule__Namespace__Group__2__Impl : ( '{' ) ;
    public final void rule__Namespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:301:1: ( ( '{' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:302:1: ( '{' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:302:1: ( '{' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:303:1: '{'
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
    // $ANTLR end rule__Namespace__Group__2__Impl


    // $ANTLR start rule__Namespace__Group__3
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:316:1: rule__Namespace__Group__3 : rule__Namespace__Group__3__Impl rule__Namespace__Group__4 ;
    public final void rule__Namespace__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:320:1: ( rule__Namespace__Group__3__Impl rule__Namespace__Group__4 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:321:2: rule__Namespace__Group__3__Impl rule__Namespace__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__3__Impl_in_rule__Namespace__Group__3601);
            rule__Namespace__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__4_in_rule__Namespace__Group__3604);
            rule__Namespace__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Namespace__Group__3


    // $ANTLR start rule__Namespace__Group__3__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:328:1: rule__Namespace__Group__3__Impl : ( ( rule__Namespace__ImportsAssignment_3 )* ) ;
    public final void rule__Namespace__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:332:1: ( ( ( rule__Namespace__ImportsAssignment_3 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:333:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:333:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:334:1: ( rule__Namespace__ImportsAssignment_3 )*
            {
             before(grammarAccess.getNamespaceAccess().getImportsAssignment_3()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:335:1: ( rule__Namespace__ImportsAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:335:2: rule__Namespace__ImportsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Namespace__ImportsAssignment_3_in_rule__Namespace__Group__3__Impl631);
            	    rule__Namespace__ImportsAssignment_3();
            	    _fsp--;


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
    // $ANTLR end rule__Namespace__Group__3__Impl


    // $ANTLR start rule__Namespace__Group__4
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:345:1: rule__Namespace__Group__4 : rule__Namespace__Group__4__Impl rule__Namespace__Group__5 ;
    public final void rule__Namespace__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:349:1: ( rule__Namespace__Group__4__Impl rule__Namespace__Group__5 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:350:2: rule__Namespace__Group__4__Impl rule__Namespace__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__4__Impl_in_rule__Namespace__Group__4662);
            rule__Namespace__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__5_in_rule__Namespace__Group__4665);
            rule__Namespace__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Namespace__Group__4


    // $ANTLR start rule__Namespace__Group__4__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:357:1: rule__Namespace__Group__4__Impl : ( ( rule__Namespace__ElementsAssignment_4 )* ) ;
    public final void rule__Namespace__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:361:1: ( ( ( rule__Namespace__ElementsAssignment_4 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:362:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:362:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:363:1: ( rule__Namespace__ElementsAssignment_4 )*
            {
             before(grammarAccess.getNamespaceAccess().getElementsAssignment_4()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:364:1: ( rule__Namespace__ElementsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:364:2: rule__Namespace__ElementsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Namespace__ElementsAssignment_4_in_rule__Namespace__Group__4__Impl692);
            	    rule__Namespace__ElementsAssignment_4();
            	    _fsp--;


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
    // $ANTLR end rule__Namespace__Group__4__Impl


    // $ANTLR start rule__Namespace__Group__5
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:374:1: rule__Namespace__Group__5 : rule__Namespace__Group__5__Impl ;
    public final void rule__Namespace__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:378:1: ( rule__Namespace__Group__5__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:379:2: rule__Namespace__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__5__Impl_in_rule__Namespace__Group__5723);
            rule__Namespace__Group__5__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Namespace__Group__5


    // $ANTLR start rule__Namespace__Group__5__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:385:1: rule__Namespace__Group__5__Impl : ( '}' ) ;
    public final void rule__Namespace__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:389:1: ( ( '}' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:390:1: ( '}' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:390:1: ( '}' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:391:1: '}'
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
    // $ANTLR end rule__Namespace__Group__5__Impl


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:416:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:420:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:421:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0794);
            rule__Import__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0797);
            rule__Import__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__0


    // $ANTLR start rule__Import__Group__0__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:428:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:432:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:433:1: ( 'import' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:433:1: ( 'import' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:434:1: 'import'
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
    // $ANTLR end rule__Import__Group__0__Impl


    // $ANTLR start rule__Import__Group__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:447:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:451:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:452:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1856);
            rule__Import__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__Import__Group__1__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:458:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:462:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:463:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:463:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:464:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:465:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:465:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl883);
            rule__Import__ImportedNamespaceAssignment_1();
            _fsp--;


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
    // $ANTLR end rule__Import__Group__1__Impl


    // $ANTLR start rule__Element__Group__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:479:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:483:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:484:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__0917);
            rule__Element__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0920);
            rule__Element__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group__0


    // $ANTLR start rule__Element__Group__0__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:491:1: rule__Element__Group__0__Impl : ( 'object' ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:495:1: ( ( 'object' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:496:1: ( 'object' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:496:1: ( 'object' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:497:1: 'object'
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
    // $ANTLR end rule__Element__Group__0__Impl


    // $ANTLR start rule__Element__Group__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:510:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:514:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:515:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1979);
            rule__Element__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1982);
            rule__Element__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group__1


    // $ANTLR start rule__Element__Group__1__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:522:1: rule__Element__Group__1__Impl : ( ( rule__Element__NameAssignment_1 ) ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:526:1: ( ( ( rule__Element__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:527:1: ( ( rule__Element__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:527:1: ( ( rule__Element__NameAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:528:1: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:529:1: ( rule__Element__NameAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:529:2: rule__Element__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__NameAssignment_1_in_rule__Element__Group__1__Impl1009);
            rule__Element__NameAssignment_1();
            _fsp--;


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
    // $ANTLR end rule__Element__Group__1__Impl


    // $ANTLR start rule__Element__Group__2
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:539:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:543:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:544:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__21039);
            rule__Element__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3_in_rule__Element__Group__21042);
            rule__Element__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group__2


    // $ANTLR start rule__Element__Group__2__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:551:1: rule__Element__Group__2__Impl : ( ( rule__Element__Group_2__0 )? ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:555:1: ( ( ( rule__Element__Group_2__0 )? ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:556:1: ( ( rule__Element__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:556:1: ( ( rule__Element__Group_2__0 )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:557:1: ( rule__Element__Group_2__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_2()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:558:1: ( rule__Element__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:558:2: rule__Element__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__0_in_rule__Element__Group__2__Impl1069);
                    rule__Element__Group_2__0();
                    _fsp--;


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
    // $ANTLR end rule__Element__Group__2__Impl


    // $ANTLR start rule__Element__Group__3
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:568:1: rule__Element__Group__3 : rule__Element__Group__3__Impl ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:572:1: ( rule__Element__Group__3__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:573:2: rule__Element__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3__Impl_in_rule__Element__Group__31100);
            rule__Element__Group__3__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group__3


    // $ANTLR start rule__Element__Group__3__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:579:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:583:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:584:1: ( ( rule__Element__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:584:1: ( ( rule__Element__Group_3__0 )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:585:1: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:586:1: ( rule__Element__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:586:2: rule__Element__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3__Impl1127);
                    rule__Element__Group_3__0();
                    _fsp--;


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
    // $ANTLR end rule__Element__Group__3__Impl


    // $ANTLR start rule__Element__Group_2__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:604:1: rule__Element__Group_2__0 : rule__Element__Group_2__0__Impl rule__Element__Group_2__1 ;
    public final void rule__Element__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:608:1: ( rule__Element__Group_2__0__Impl rule__Element__Group_2__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:609:2: rule__Element__Group_2__0__Impl rule__Element__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__0__Impl_in_rule__Element__Group_2__01166);
            rule__Element__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__1_in_rule__Element__Group_2__01169);
            rule__Element__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group_2__0


    // $ANTLR start rule__Element__Group_2__0__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:616:1: rule__Element__Group_2__0__Impl : ( 'references' ) ;
    public final void rule__Element__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:620:1: ( ( 'references' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:621:1: ( 'references' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:621:1: ( 'references' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:622:1: 'references'
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
    // $ANTLR end rule__Element__Group_2__0__Impl


    // $ANTLR start rule__Element__Group_2__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:635:1: rule__Element__Group_2__1 : rule__Element__Group_2__1__Impl ;
    public final void rule__Element__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:639:1: ( rule__Element__Group_2__1__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:640:2: rule__Element__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__1__Impl_in_rule__Element__Group_2__11228);
            rule__Element__Group_2__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group_2__1


    // $ANTLR start rule__Element__Group_2__1__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:646:1: rule__Element__Group_2__1__Impl : ( ( rule__Element__ReferencesAssignment_2_1 ) ) ;
    public final void rule__Element__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:650:1: ( ( ( rule__Element__ReferencesAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:651:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:651:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:652:1: ( rule__Element__ReferencesAssignment_2_1 )
            {
             before(grammarAccess.getElementAccess().getReferencesAssignment_2_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:653:1: ( rule__Element__ReferencesAssignment_2_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:653:2: rule__Element__ReferencesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__ReferencesAssignment_2_1_in_rule__Element__Group_2__1__Impl1255);
            rule__Element__ReferencesAssignment_2_1();
            _fsp--;


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
    // $ANTLR end rule__Element__Group_2__1__Impl


    // $ANTLR start rule__Element__Group_3__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:667:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:671:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:672:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0__Impl_in_rule__Element__Group_3__01289);
            rule__Element__Group_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__01292);
            rule__Element__Group_3__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group_3__0


    // $ANTLR start rule__Element__Group_3__0__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:679:1: rule__Element__Group_3__0__Impl : ( 'otherRefs' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:683:1: ( ( 'otherRefs' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:684:1: ( 'otherRefs' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:684:1: ( 'otherRefs' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:685:1: 'otherRefs'
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
    // $ANTLR end rule__Element__Group_3__0__Impl


    // $ANTLR start rule__Element__Group_3__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:698:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl rule__Element__Group_3__2 ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:702:1: ( rule__Element__Group_3__1__Impl rule__Element__Group_3__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:703:2: rule__Element__Group_3__1__Impl rule__Element__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1__Impl_in_rule__Element__Group_3__11351);
            rule__Element__Group_3__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__2_in_rule__Element__Group_3__11354);
            rule__Element__Group_3__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group_3__1


    // $ANTLR start rule__Element__Group_3__1__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:710:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__OtherRefsAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:714:1: ( ( ( rule__Element__OtherRefsAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:715:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:715:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:716:1: ( rule__Element__OtherRefsAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:717:1: ( rule__Element__OtherRefsAssignment_3_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:717:2: rule__Element__OtherRefsAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__OtherRefsAssignment_3_1_in_rule__Element__Group_3__1__Impl1381);
            rule__Element__OtherRefsAssignment_3_1();
            _fsp--;


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
    // $ANTLR end rule__Element__Group_3__1__Impl


    // $ANTLR start rule__Element__Group_3__2
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:727:1: rule__Element__Group_3__2 : rule__Element__Group_3__2__Impl ;
    public final void rule__Element__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:731:1: ( rule__Element__Group_3__2__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:732:2: rule__Element__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__2__Impl_in_rule__Element__Group_3__21411);
            rule__Element__Group_3__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group_3__2


    // $ANTLR start rule__Element__Group_3__2__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:738:1: rule__Element__Group_3__2__Impl : ( ( rule__Element__Group_3_2__0 )* ) ;
    public final void rule__Element__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:742:1: ( ( ( rule__Element__Group_3_2__0 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:743:1: ( ( rule__Element__Group_3_2__0 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:743:1: ( ( rule__Element__Group_3_2__0 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:744:1: ( rule__Element__Group_3_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_3_2()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:745:1: ( rule__Element__Group_3_2__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:745:2: rule__Element__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__0_in_rule__Element__Group_3__2__Impl1438);
            	    rule__Element__Group_3_2__0();
            	    _fsp--;


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
    // $ANTLR end rule__Element__Group_3__2__Impl


    // $ANTLR start rule__Element__Group_3_2__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:761:1: rule__Element__Group_3_2__0 : rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1 ;
    public final void rule__Element__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:765:1: ( rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:766:2: rule__Element__Group_3_2__0__Impl rule__Element__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__0__Impl_in_rule__Element__Group_3_2__01475);
            rule__Element__Group_3_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__1_in_rule__Element__Group_3_2__01478);
            rule__Element__Group_3_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group_3_2__0


    // $ANTLR start rule__Element__Group_3_2__0__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:773:1: rule__Element__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Element__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:777:1: ( ( ',' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:778:1: ( ',' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:778:1: ( ',' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:779:1: ','
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
    // $ANTLR end rule__Element__Group_3_2__0__Impl


    // $ANTLR start rule__Element__Group_3_2__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:792:1: rule__Element__Group_3_2__1 : rule__Element__Group_3_2__1__Impl ;
    public final void rule__Element__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:796:1: ( rule__Element__Group_3_2__1__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:797:2: rule__Element__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__1__Impl_in_rule__Element__Group_3_2__11537);
            rule__Element__Group_3_2__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Element__Group_3_2__1


    // $ANTLR start rule__Element__Group_3_2__1__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:803:1: rule__Element__Group_3_2__1__Impl : ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) ;
    public final void rule__Element__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:807:1: ( ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:808:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:808:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:809:1: ( rule__Element__OtherRefsAssignment_3_2_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_2_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:810:1: ( rule__Element__OtherRefsAssignment_3_2_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:810:2: rule__Element__OtherRefsAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__OtherRefsAssignment_3_2_1_in_rule__Element__Group_3_2__1__Impl1564);
            rule__Element__OtherRefsAssignment_3_2_1();
            _fsp--;


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
    // $ANTLR end rule__Element__Group_3_2__1__Impl


    // $ANTLR start rule__QualifiedName__Group__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:824:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:828:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:829:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01598);
            rule__QualifiedName__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01601);
            rule__QualifiedName__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QualifiedName__Group__0


    // $ANTLR start rule__QualifiedName__Group__0__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:836:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:840:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:841:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:841:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:842:1: RULE_ID
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
    // $ANTLR end rule__QualifiedName__Group__0__Impl


    // $ANTLR start rule__QualifiedName__Group__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:853:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:857:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:858:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11657);
            rule__QualifiedName__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QualifiedName__Group__1


    // $ANTLR start rule__QualifiedName__Group__1__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:864:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:868:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:869:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:869:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:870:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:871:1: ( rule__QualifiedName__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:871:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl1684);
            	    rule__QualifiedName__Group_1__0();
            	    _fsp--;


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
    // $ANTLR end rule__QualifiedName__Group__1__Impl


    // $ANTLR start rule__QualifiedName__Group_1__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:885:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:889:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:890:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__01719);
            rule__QualifiedName__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01722);
            rule__QualifiedName__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QualifiedName__Group_1__0


    // $ANTLR start rule__QualifiedName__Group_1__0__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:897:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:901:1: ( ( '.' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:902:1: ( '.' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:902:1: ( '.' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:903:1: '.'
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
    // $ANTLR end rule__QualifiedName__Group_1__0__Impl


    // $ANTLR start rule__QualifiedName__Group_1__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:916:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:920:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:921:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__11781);
            rule__QualifiedName__Group_1__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QualifiedName__Group_1__1


    // $ANTLR start rule__QualifiedName__Group_1__1__Impl
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:927:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:931:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:932:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:932:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:933:1: RULE_ID
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
    // $ANTLR end rule__QualifiedName__Group_1__1__Impl


    // $ANTLR start rule__Namespace__NameAssignment_1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:949:1: rule__Namespace__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Namespace__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:953:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:954:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:954:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:955:1: ruleQualifiedName
            {
             before(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Namespace__NameAssignment_11846);
            ruleQualifiedName();
            _fsp--;

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
    // $ANTLR end rule__Namespace__NameAssignment_1


    // $ANTLR start rule__Namespace__ImportsAssignment_3
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:964:1: rule__Namespace__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__Namespace__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:968:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:969:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:969:1: ( ruleImport )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:970:1: ruleImport
            {
             before(grammarAccess.getNamespaceAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__Namespace__ImportsAssignment_31877);
            ruleImport();
            _fsp--;

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
    // $ANTLR end rule__Namespace__ImportsAssignment_3


    // $ANTLR start rule__Namespace__ElementsAssignment_4
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:979:1: rule__Namespace__ElementsAssignment_4 : ( ruleNamedElement ) ;
    public final void rule__Namespace__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:983:1: ( ( ruleNamedElement ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:984:1: ( ruleNamedElement )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:984:1: ( ruleNamedElement )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:985:1: ruleNamedElement
            {
             before(grammarAccess.getNamespaceAccess().getElementsNamedElementParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_rule__Namespace__ElementsAssignment_41908);
            ruleNamedElement();
            _fsp--;

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
    // $ANTLR end rule__Namespace__ElementsAssignment_4


    // $ANTLR start rule__Import__ImportedNamespaceAssignment_1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:994:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:998:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:999:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:999:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1000:1: ruleQualifiedName
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Import__ImportedNamespaceAssignment_11939);
            ruleQualifiedName();
            _fsp--;

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
    // $ANTLR end rule__Import__ImportedNamespaceAssignment_1


    // $ANTLR start rule__Element__NameAssignment_1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1009:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1013:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1014:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1014:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1015:1: RULE_ID
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
    // $ANTLR end rule__Element__NameAssignment_1


    // $ANTLR start rule__Element__ReferencesAssignment_2_1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1024:1: rule__Element__ReferencesAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__ReferencesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1028:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1029:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1029:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1030:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1031:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1032:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getReferencesElementQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__ReferencesAssignment_2_12005);
            ruleQualifiedName();
            _fsp--;

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
    // $ANTLR end rule__Element__ReferencesAssignment_2_1


    // $ANTLR start rule__Element__OtherRefsAssignment_3_1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1043:1: rule__Element__OtherRefsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1047:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1048:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1048:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1049:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1050:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1051:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_12044);
            ruleQualifiedName();
            _fsp--;

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
    // $ANTLR end rule__Element__OtherRefsAssignment_3_1


    // $ANTLR start rule__Element__OtherRefsAssignment_3_2_1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1062:1: rule__Element__OtherRefsAssignment_3_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1066:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1067:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1067:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1068:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1069:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/ui/contentassist/antlr/internal/InternalBuilderTestLanguage.g:1070:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_2_12083);
            ruleQualifiedName();
            _fsp--;

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
    // $ANTLR end rule__Element__OtherRefsAssignment_3_2_1


 

    
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
        public static final BitSet FOLLOW_rule__Namespace__Group__3__Impl_in_rule__Namespace__Group__3601 = new BitSet(new long[]{0x000000000000A800L});
        public static final BitSet FOLLOW_rule__Namespace__Group__4_in_rule__Namespace__Group__3604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__ImportsAssignment_3_in_rule__Namespace__Group__3__Impl631 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__Namespace__Group__4__Impl_in_rule__Namespace__Group__4662 = new BitSet(new long[]{0x0000000000002000L});
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
        public static final BitSet FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1979 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__NameAssignment_1_in_rule__Element__Group__1__Impl1009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__21039 = new BitSet(new long[]{0x0000000000020002L});
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
        public static final BitSet FOLLOW_rule__Element__Group_3__1__Impl_in_rule__Element__Group_3__11351 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__2_in_rule__Element__Group_3__11354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__OtherRefsAssignment_3_1_in_rule__Element__Group_3__1__Impl1381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__2__Impl_in_rule__Element__Group_3__21411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__0_in_rule__Element__Group_3__2__Impl1438 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__0__Impl_in_rule__Element__Group_3_2__01475 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__1_in_rule__Element__Group_3_2__01478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Element__Group_3_2__0__Impl1506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__1__Impl_in_rule__Element__Group_3_2__11537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__OtherRefsAssignment_3_2_1_in_rule__Element__Group_3_2__1__Impl1564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01598 = new BitSet(new long[]{0x0000000000080002L});
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
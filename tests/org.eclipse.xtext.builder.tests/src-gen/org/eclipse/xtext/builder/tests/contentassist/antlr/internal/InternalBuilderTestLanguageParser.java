package org.eclipse.xtext.builder.tests.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:60:1: entryRuleNamedElement : ruleNamedElement EOF ;
    public final void entryRuleNamedElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:60:23: ( ruleNamedElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:61:1: ruleNamedElement EOF
            {
             before(grammarAccess.getNamedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_entryRuleNamedElement60);
            ruleNamedElement();
            _fsp--;

             after(grammarAccess.getNamedElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedElement67); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:68:1: ruleNamedElement : ( ( rule__NamedElement__Alternatives ) ) ;
    public final void ruleNamedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:72:2: ( ( ( rule__NamedElement__Alternatives ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:73:1: ( ( rule__NamedElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:73:1: ( ( rule__NamedElement__Alternatives ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:74:1: ( rule__NamedElement__Alternatives )
            {
             before(grammarAccess.getNamedElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:75:1: ( rule__NamedElement__Alternatives )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:75:2: rule__NamedElement__Alternatives
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:87:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:87:20: ( ruleNamespace EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:88:1: ruleNamespace EOF
            {
             before(grammarAccess.getNamespaceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_entryRuleNamespace120);
            ruleNamespace();
            _fsp--;

             after(grammarAccess.getNamespaceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamespace127); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:95:1: ruleNamespace : ( ( rule__Namespace__Group__0 ) ) ;
    public final void ruleNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:99:2: ( ( ( rule__Namespace__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:100:1: ( ( rule__Namespace__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:100:1: ( ( rule__Namespace__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:101:1: ( rule__Namespace__Group__0 )
            {
             before(grammarAccess.getNamespaceAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:102:1: ( rule__Namespace__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:102:2: rule__Namespace__Group__0
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:114:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:114:17: ( ruleImport EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:115:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport180);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport187); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:122:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:126:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:127:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:127:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:128:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:129:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:129:2: rule__Import__Group__0
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:141:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:141:18: ( ruleElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:142:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement240);
            ruleElement();
            _fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement247); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:149:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:153:2: ( ( ( rule__Element__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:154:1: ( ( rule__Element__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:154:1: ( ( rule__Element__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:155:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:156:1: ( rule__Element__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:156:2: rule__Element__Group__0
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:168:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:168:24: ( ruleQualifiedName EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:169:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName300);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName307); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:176:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:180:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:181:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:181:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:182:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:183:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:183:2: rule__QualifiedName__Group__0
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:195:1: rule__NamedElement__Alternatives : ( ( ruleNamespace ) | ( ruleElement ) );
    public final void rule__NamedElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:199:1: ( ( ruleNamespace ) | ( ruleElement ) )
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
                    new NoViableAltException("195:1: rule__NamedElement__Alternatives : ( ( ruleNamespace ) | ( ruleElement ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:200:1: ( ruleNamespace )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:200:1: ( ruleNamespace )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:201:1: ruleNamespace
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
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:206:6: ( ruleElement )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:206:6: ( ruleElement )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:207:1: ruleElement
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:219:1: rule__Namespace__Group__0 : ( 'namespace' ) rule__Namespace__Group__1 ;
    public final void rule__Namespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:223:1: ( ( 'namespace' ) rule__Namespace__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:224:1: ( 'namespace' ) rule__Namespace__Group__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:224:1: ( 'namespace' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:225:1: 'namespace'
            {
             before(grammarAccess.getNamespaceAccess().getNamespaceKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Namespace__Group__0422); 
             after(grammarAccess.getNamespaceAccess().getNamespaceKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__1_in_rule__Namespace__Group__0432);
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


    // $ANTLR start rule__Namespace__Group__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:239:1: rule__Namespace__Group__1 : ( ( rule__Namespace__NameAssignment_1 ) ) rule__Namespace__Group__2 ;
    public final void rule__Namespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:243:1: ( ( ( rule__Namespace__NameAssignment_1 ) ) rule__Namespace__Group__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:244:1: ( ( rule__Namespace__NameAssignment_1 ) ) rule__Namespace__Group__2
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:244:1: ( ( rule__Namespace__NameAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:245:1: ( rule__Namespace__NameAssignment_1 )
            {
             before(grammarAccess.getNamespaceAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:246:1: ( rule__Namespace__NameAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:246:2: rule__Namespace__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__NameAssignment_1_in_rule__Namespace__Group__1460);
            rule__Namespace__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getNamespaceAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__2_in_rule__Namespace__Group__1469);
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


    // $ANTLR start rule__Namespace__Group__2
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:257:1: rule__Namespace__Group__2 : ( '{' ) rule__Namespace__Group__3 ;
    public final void rule__Namespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:261:1: ( ( '{' ) rule__Namespace__Group__3 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:262:1: ( '{' ) rule__Namespace__Group__3
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:262:1: ( '{' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:263:1: '{'
            {
             before(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Namespace__Group__2498); 
             after(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__3_in_rule__Namespace__Group__2508);
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


    // $ANTLR start rule__Namespace__Group__3
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:277:1: rule__Namespace__Group__3 : ( ( rule__Namespace__ImportsAssignment_3 )* ) rule__Namespace__Group__4 ;
    public final void rule__Namespace__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:281:1: ( ( ( rule__Namespace__ImportsAssignment_3 )* ) rule__Namespace__Group__4 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:282:1: ( ( rule__Namespace__ImportsAssignment_3 )* ) rule__Namespace__Group__4
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:282:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:283:1: ( rule__Namespace__ImportsAssignment_3 )*
            {
             before(grammarAccess.getNamespaceAccess().getImportsAssignment_3()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:284:1: ( rule__Namespace__ImportsAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:284:2: rule__Namespace__ImportsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Namespace__ImportsAssignment_3_in_rule__Namespace__Group__3536);
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

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__4_in_rule__Namespace__Group__3546);
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


    // $ANTLR start rule__Namespace__Group__4
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:295:1: rule__Namespace__Group__4 : ( ( rule__Namespace__ElementsAssignment_4 )* ) rule__Namespace__Group__5 ;
    public final void rule__Namespace__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:299:1: ( ( ( rule__Namespace__ElementsAssignment_4 )* ) rule__Namespace__Group__5 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:300:1: ( ( rule__Namespace__ElementsAssignment_4 )* ) rule__Namespace__Group__5
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:300:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:301:1: ( rule__Namespace__ElementsAssignment_4 )*
            {
             before(grammarAccess.getNamespaceAccess().getElementsAssignment_4()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:302:1: ( rule__Namespace__ElementsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:302:2: rule__Namespace__ElementsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Namespace__ElementsAssignment_4_in_rule__Namespace__Group__4574);
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

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__5_in_rule__Namespace__Group__4584);
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


    // $ANTLR start rule__Namespace__Group__5
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:313:1: rule__Namespace__Group__5 : ( '}' ) ;
    public final void rule__Namespace__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:317:1: ( ( '}' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:318:1: ( '}' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:318:1: ( '}' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:319:1: '}'
            {
             before(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Namespace__Group__5613); 
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
    // $ANTLR end rule__Namespace__Group__5


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:344:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:348:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:349:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:349:1: ( 'import' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:350:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Import__Group__0661); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0671);
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


    // $ANTLR start rule__Import__Group__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:364:1: rule__Import__Group__1 : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:368:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:369:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:369:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:370:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:371:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:371:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1699);
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
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__Element__Group__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:385:1: rule__Element__Group__0 : ( 'object' ) rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:389:1: ( ( 'object' ) rule__Element__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:390:1: ( 'object' ) rule__Element__Group__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:390:1: ( 'object' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:391:1: 'object'
            {
             before(grammarAccess.getElementAccess().getObjectKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Element__Group__0738); 
             after(grammarAccess.getElementAccess().getObjectKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0748);
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


    // $ANTLR start rule__Element__Group__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:405:1: rule__Element__Group__1 : ( ( rule__Element__NameAssignment_1 ) ) rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:409:1: ( ( ( rule__Element__NameAssignment_1 ) ) rule__Element__Group__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:410:1: ( ( rule__Element__NameAssignment_1 ) ) rule__Element__Group__2
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:410:1: ( ( rule__Element__NameAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:411:1: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:412:1: ( rule__Element__NameAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:412:2: rule__Element__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__NameAssignment_1_in_rule__Element__Group__1776);
            rule__Element__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getElementAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1785);
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


    // $ANTLR start rule__Element__Group__2
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:423:1: rule__Element__Group__2 : ( ( rule__Element__Group_2__0 )? ) rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:427:1: ( ( ( rule__Element__Group_2__0 )? ) rule__Element__Group__3 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:428:1: ( ( rule__Element__Group_2__0 )? ) rule__Element__Group__3
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:428:1: ( ( rule__Element__Group_2__0 )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:429:1: ( rule__Element__Group_2__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_2()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:430:1: ( rule__Element__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:430:2: rule__Element__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__0_in_rule__Element__Group__2813);
                    rule__Element__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2823);
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


    // $ANTLR start rule__Element__Group__3
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:441:1: rule__Element__Group__3 : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:445:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:446:1: ( ( rule__Element__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:446:1: ( ( rule__Element__Group_3__0 )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:447:1: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:448:1: ( rule__Element__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:448:2: rule__Element__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3851);
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
    // $ANTLR end rule__Element__Group__3


    // $ANTLR start rule__Element__Group_2__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:466:1: rule__Element__Group_2__0 : ( 'references' ) rule__Element__Group_2__1 ;
    public final void rule__Element__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:470:1: ( ( 'references' ) rule__Element__Group_2__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:471:1: ( 'references' ) rule__Element__Group_2__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:471:1: ( 'references' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:472:1: 'references'
            {
             before(grammarAccess.getElementAccess().getReferencesKeyword_2_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Element__Group_2__0895); 
             after(grammarAccess.getElementAccess().getReferencesKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__1_in_rule__Element__Group_2__0905);
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


    // $ANTLR start rule__Element__Group_2__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:486:1: rule__Element__Group_2__1 : ( ( rule__Element__ReferencesAssignment_2_1 ) ) ;
    public final void rule__Element__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:490:1: ( ( ( rule__Element__ReferencesAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:491:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:491:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:492:1: ( rule__Element__ReferencesAssignment_2_1 )
            {
             before(grammarAccess.getElementAccess().getReferencesAssignment_2_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:493:1: ( rule__Element__ReferencesAssignment_2_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:493:2: rule__Element__ReferencesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__ReferencesAssignment_2_1_in_rule__Element__Group_2__1933);
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
    // $ANTLR end rule__Element__Group_2__1


    // $ANTLR start rule__Element__Group_3__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:507:1: rule__Element__Group_3__0 : ( 'otherRefs' ) rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:511:1: ( ( 'otherRefs' ) rule__Element__Group_3__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:512:1: ( 'otherRefs' ) rule__Element__Group_3__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:512:1: ( 'otherRefs' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:513:1: 'otherRefs'
            {
             before(grammarAccess.getElementAccess().getOtherRefsKeyword_3_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Element__Group_3__0972); 
             after(grammarAccess.getElementAccess().getOtherRefsKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__0982);
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


    // $ANTLR start rule__Element__Group_3__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:527:1: rule__Element__Group_3__1 : ( ( rule__Element__OtherRefsAssignment_3_1 ) ) rule__Element__Group_3__2 ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:531:1: ( ( ( rule__Element__OtherRefsAssignment_3_1 ) ) rule__Element__Group_3__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:532:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) ) rule__Element__Group_3__2
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:532:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:533:1: ( rule__Element__OtherRefsAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:534:1: ( rule__Element__OtherRefsAssignment_3_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:534:2: rule__Element__OtherRefsAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__OtherRefsAssignment_3_1_in_rule__Element__Group_3__11010);
            rule__Element__OtherRefsAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__2_in_rule__Element__Group_3__11019);
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


    // $ANTLR start rule__Element__Group_3__2
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:545:1: rule__Element__Group_3__2 : ( ( rule__Element__Group_3_2__0 )* ) ;
    public final void rule__Element__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:549:1: ( ( ( rule__Element__Group_3_2__0 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:550:1: ( ( rule__Element__Group_3_2__0 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:550:1: ( ( rule__Element__Group_3_2__0 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:551:1: ( rule__Element__Group_3_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_3_2()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:552:1: ( rule__Element__Group_3_2__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:552:2: rule__Element__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__0_in_rule__Element__Group_3__21047);
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
    // $ANTLR end rule__Element__Group_3__2


    // $ANTLR start rule__Element__Group_3_2__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:568:1: rule__Element__Group_3_2__0 : ( ',' ) rule__Element__Group_3_2__1 ;
    public final void rule__Element__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:572:1: ( ( ',' ) rule__Element__Group_3_2__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:573:1: ( ',' ) rule__Element__Group_3_2__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:573:1: ( ',' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:574:1: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_3_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Element__Group_3_2__01089); 
             after(grammarAccess.getElementAccess().getCommaKeyword_3_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__1_in_rule__Element__Group_3_2__01099);
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


    // $ANTLR start rule__Element__Group_3_2__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:588:1: rule__Element__Group_3_2__1 : ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) ;
    public final void rule__Element__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:592:1: ( ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:593:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:593:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:594:1: ( rule__Element__OtherRefsAssignment_3_2_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_2_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:595:1: ( rule__Element__OtherRefsAssignment_3_2_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:595:2: rule__Element__OtherRefsAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__OtherRefsAssignment_3_2_1_in_rule__Element__Group_3_2__11127);
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
    // $ANTLR end rule__Element__Group_3_2__1


    // $ANTLR start rule__QualifiedName__Group__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:609:1: rule__QualifiedName__Group__0 : ( RULE_ID ) rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:613:1: ( ( RULE_ID ) rule__QualifiedName__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:614:1: ( RULE_ID ) rule__QualifiedName__Group__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:614:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:615:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QualifiedName__Group__01165); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01173);
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


    // $ANTLR start rule__QualifiedName__Group__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:627:1: rule__QualifiedName__Group__1 : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:631:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:632:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:632:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:633:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:634:1: ( rule__QualifiedName__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:634:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__11201);
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
    // $ANTLR end rule__QualifiedName__Group__1


    // $ANTLR start rule__QualifiedName__Group_1__0
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:648:1: rule__QualifiedName__Group_1__0 : ( '.' ) rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:652:1: ( ( '.' ) rule__QualifiedName__Group_1__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:653:1: ( '.' ) rule__QualifiedName__Group_1__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:653:1: ( '.' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:654:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__QualifiedName__Group_1__01241); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01251);
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


    // $ANTLR start rule__QualifiedName__Group_1__1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:668:1: rule__QualifiedName__Group_1__1 : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:672:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:673:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:673:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:674:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__11279); 
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
    // $ANTLR end rule__QualifiedName__Group_1__1


    // $ANTLR start rule__Namespace__NameAssignment_1
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:689:1: rule__Namespace__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Namespace__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:693:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:694:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:694:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:695:1: ruleQualifiedName
            {
             before(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Namespace__NameAssignment_11316);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:704:1: rule__Namespace__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__Namespace__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:708:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:709:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:709:1: ( ruleImport )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:710:1: ruleImport
            {
             before(grammarAccess.getNamespaceAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__Namespace__ImportsAssignment_31347);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:719:1: rule__Namespace__ElementsAssignment_4 : ( ruleNamedElement ) ;
    public final void rule__Namespace__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:723:1: ( ( ruleNamedElement ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:724:1: ( ruleNamedElement )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:724:1: ( ruleNamedElement )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:725:1: ruleNamedElement
            {
             before(grammarAccess.getNamespaceAccess().getElementsNamedElementParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_rule__Namespace__ElementsAssignment_41378);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:734:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:738:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:739:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:739:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:740:1: ruleQualifiedName
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Import__ImportedNamespaceAssignment_11409);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:749:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:753:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:754:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:754:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:755:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__NameAssignment_11440); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:764:1: rule__Element__ReferencesAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__ReferencesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:768:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:769:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:769:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:770:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:771:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:772:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getReferencesElementQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__ReferencesAssignment_2_11475);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:783:1: rule__Element__OtherRefsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:787:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:788:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:788:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:789:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:790:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:791:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_11514);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:802:1: rule__Element__OtherRefsAssignment_3_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:806:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:807:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:807:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:808:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:809:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:810:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_2_11553);
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
        public static final BitSet FOLLOW_ruleNamedElement_in_entryRuleNamedElement60 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedElement67 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NamedElement__Alternatives_in_ruleNamedElement94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamespace127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__Group__0_in_ruleNamespace154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport180 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0_in_ruleElement274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName300 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespace_in_rule__NamedElement__Alternatives370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__NamedElement__Alternatives387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Namespace__Group__0422 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Namespace__Group__1_in_rule__Namespace__Group__0432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__NameAssignment_1_in_rule__Namespace__Group__1460 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Namespace__Group__2_in_rule__Namespace__Group__1469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Namespace__Group__2498 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_rule__Namespace__Group__3_in_rule__Namespace__Group__2508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__ImportsAssignment_3_in_rule__Namespace__Group__3536 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_rule__Namespace__Group__4_in_rule__Namespace__Group__3546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__ElementsAssignment_4_in_rule__Namespace__Group__4574 = new BitSet(new long[]{0x000000000000A800L});
        public static final BitSet FOLLOW_rule__Namespace__Group__5_in_rule__Namespace__Group__4584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Namespace__Group__5613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Import__Group__0661 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Element__Group__0738 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__NameAssignment_1_in_rule__Element__Group__1776 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_2__0_in_rule__Element__Group__2813 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Element__Group_2__0895 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_2__1_in_rule__Element__Group_2__0905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__ReferencesAssignment_2_1_in_rule__Element__Group_2__1933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Element__Group_3__0972 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__0982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__OtherRefsAssignment_3_1_in_rule__Element__Group_3__11010 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__2_in_rule__Element__Group_3__11019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__0_in_rule__Element__Group_3__21047 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_rule__Element__Group_3_2__01089 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__1_in_rule__Element__Group_3_2__01099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__OtherRefsAssignment_3_2_1_in_rule__Element__Group_3_2__11127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__01165 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__11201 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_rule__QualifiedName__Group_1__01241 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__11279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Namespace__NameAssignment_11316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__Namespace__ImportsAssignment_31347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamedElement_in_rule__Namespace__ElementsAssignment_41378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Import__ImportedNamespaceAssignment_11409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__NameAssignment_11440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Element__ReferencesAssignment_2_11475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_11514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_2_11553 = new BitSet(new long[]{0x0000000000000002L});
    }


}
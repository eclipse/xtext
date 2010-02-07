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
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
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
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:61:1: ( ruleNamedElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:62:1: ruleNamedElement EOF
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:69:1: ruleNamedElement : ( ( rule__NamedElement__Alternatives ) ) ;
    public final void ruleNamedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:73:2: ( ( ( rule__NamedElement__Alternatives ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:74:1: ( ( rule__NamedElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:74:1: ( ( rule__NamedElement__Alternatives ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:75:1: ( rule__NamedElement__Alternatives )
            {
             before(grammarAccess.getNamedElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:76:1: ( rule__NamedElement__Alternatives )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:76:2: rule__NamedElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__NamedElement__Alternatives_in_ruleNamedElement95);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:88:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:89:1: ( ruleNamespace EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:90:1: ruleNamespace EOF
            {
             before(grammarAccess.getNamespaceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_entryRuleNamespace122);
            ruleNamespace();
            _fsp--;

             after(grammarAccess.getNamespaceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamespace129); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:97:1: ruleNamespace : ( ( rule__Namespace__Group__0 ) ) ;
    public final void ruleNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:101:2: ( ( ( rule__Namespace__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:102:1: ( ( rule__Namespace__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:102:1: ( ( rule__Namespace__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:103:1: ( rule__Namespace__Group__0 )
            {
             before(grammarAccess.getNamespaceAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:104:1: ( rule__Namespace__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:104:2: rule__Namespace__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__0_in_ruleNamespace156);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:116:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:117:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:118:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport183);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport190); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:125:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:129:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:130:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:130:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:131:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:132:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:132:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0_in_ruleImport217);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:144:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:145:1: ( ruleElement EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:146:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement244);
            ruleElement();
            _fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement251); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:153:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:157:2: ( ( ( rule__Element__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:158:1: ( ( rule__Element__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:158:1: ( ( rule__Element__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:159:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:160:1: ( rule__Element__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:160:2: rule__Element__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0_in_ruleElement278);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:172:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:173:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:174:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName305);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName312); 

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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:181:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:185:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:186:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:186:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:187:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:188:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:188:2: rule__QualifiedName__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName339);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:200:1: rule__NamedElement__Alternatives : ( ( ruleNamespace ) | ( ruleElement ) );
    public final void rule__NamedElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:204:1: ( ( ruleNamespace ) | ( ruleElement ) )
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
                    new NoViableAltException("200:1: rule__NamedElement__Alternatives : ( ( ruleNamespace ) | ( ruleElement ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:205:1: ( ruleNamespace )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:205:1: ( ruleNamespace )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:206:1: ruleNamespace
                    {
                     before(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNamespace_in_rule__NamedElement__Alternatives375);
                    ruleNamespace();
                    _fsp--;

                     after(grammarAccess.getNamedElementAccess().getNamespaceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:211:6: ( ruleElement )
                    {
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:211:6: ( ruleElement )
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:212:1: ruleElement
                    {
                     before(grammarAccess.getNamedElementAccess().getElementParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__NamedElement__Alternatives392);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:224:1: rule__Namespace__Group__0 : ( 'namespace' ) rule__Namespace__Group__1 ;
    public final void rule__Namespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:228:1: ( ( 'namespace' ) rule__Namespace__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:229:1: ( 'namespace' ) rule__Namespace__Group__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:229:1: ( 'namespace' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:230:1: 'namespace'
            {
             before(grammarAccess.getNamespaceAccess().getNamespaceKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Namespace__Group__0427); 
             after(grammarAccess.getNamespaceAccess().getNamespaceKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__1_in_rule__Namespace__Group__0437);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:244:1: rule__Namespace__Group__1 : ( ( rule__Namespace__NameAssignment_1 ) ) rule__Namespace__Group__2 ;
    public final void rule__Namespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:248:1: ( ( ( rule__Namespace__NameAssignment_1 ) ) rule__Namespace__Group__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:249:1: ( ( rule__Namespace__NameAssignment_1 ) ) rule__Namespace__Group__2
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:249:1: ( ( rule__Namespace__NameAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:250:1: ( rule__Namespace__NameAssignment_1 )
            {
             before(grammarAccess.getNamespaceAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:251:1: ( rule__Namespace__NameAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:251:2: rule__Namespace__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Namespace__NameAssignment_1_in_rule__Namespace__Group__1465);
            rule__Namespace__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getNamespaceAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__2_in_rule__Namespace__Group__1474);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:262:1: rule__Namespace__Group__2 : ( '{' ) rule__Namespace__Group__3 ;
    public final void rule__Namespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:266:1: ( ( '{' ) rule__Namespace__Group__3 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:267:1: ( '{' ) rule__Namespace__Group__3
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:267:1: ( '{' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:268:1: '{'
            {
             before(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Namespace__Group__2503); 
             after(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__3_in_rule__Namespace__Group__2513);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:282:1: rule__Namespace__Group__3 : ( ( rule__Namespace__ImportsAssignment_3 )* ) rule__Namespace__Group__4 ;
    public final void rule__Namespace__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:286:1: ( ( ( rule__Namespace__ImportsAssignment_3 )* ) rule__Namespace__Group__4 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:287:1: ( ( rule__Namespace__ImportsAssignment_3 )* ) rule__Namespace__Group__4
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:287:1: ( ( rule__Namespace__ImportsAssignment_3 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:288:1: ( rule__Namespace__ImportsAssignment_3 )*
            {
             before(grammarAccess.getNamespaceAccess().getImportsAssignment_3()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:289:1: ( rule__Namespace__ImportsAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:289:2: rule__Namespace__ImportsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Namespace__ImportsAssignment_3_in_rule__Namespace__Group__3541);
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

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__4_in_rule__Namespace__Group__3551);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:300:1: rule__Namespace__Group__4 : ( ( rule__Namespace__ElementsAssignment_4 )* ) rule__Namespace__Group__5 ;
    public final void rule__Namespace__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:304:1: ( ( ( rule__Namespace__ElementsAssignment_4 )* ) rule__Namespace__Group__5 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:305:1: ( ( rule__Namespace__ElementsAssignment_4 )* ) rule__Namespace__Group__5
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:305:1: ( ( rule__Namespace__ElementsAssignment_4 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:306:1: ( rule__Namespace__ElementsAssignment_4 )*
            {
             before(grammarAccess.getNamespaceAccess().getElementsAssignment_4()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:307:1: ( rule__Namespace__ElementsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:307:2: rule__Namespace__ElementsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Namespace__ElementsAssignment_4_in_rule__Namespace__Group__4579);
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

            pushFollow(FollowSets000.FOLLOW_rule__Namespace__Group__5_in_rule__Namespace__Group__4589);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:318:1: rule__Namespace__Group__5 : ( '}' ) ;
    public final void rule__Namespace__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:322:1: ( ( '}' ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:323:1: ( '}' )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:323:1: ( '}' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:324:1: '}'
            {
             before(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Namespace__Group__5618); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:349:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:353:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:354:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:354:1: ( 'import' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:355:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Import__Group__0666); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0676);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:369:1: rule__Import__Group__1 : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:373:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:374:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:374:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:375:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:376:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:376:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1704);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:390:1: rule__Element__Group__0 : ( 'object' ) rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:394:1: ( ( 'object' ) rule__Element__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:395:1: ( 'object' ) rule__Element__Group__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:395:1: ( 'object' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:396:1: 'object'
            {
             before(grammarAccess.getElementAccess().getObjectKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Element__Group__0743); 
             after(grammarAccess.getElementAccess().getObjectKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0753);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:410:1: rule__Element__Group__1 : ( ( rule__Element__NameAssignment_1 ) ) rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:414:1: ( ( ( rule__Element__NameAssignment_1 ) ) rule__Element__Group__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:415:1: ( ( rule__Element__NameAssignment_1 ) ) rule__Element__Group__2
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:415:1: ( ( rule__Element__NameAssignment_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:416:1: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:417:1: ( rule__Element__NameAssignment_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:417:2: rule__Element__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__NameAssignment_1_in_rule__Element__Group__1781);
            rule__Element__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getElementAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1790);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:428:1: rule__Element__Group__2 : ( ( rule__Element__Group_2__0 )? ) rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:432:1: ( ( ( rule__Element__Group_2__0 )? ) rule__Element__Group__3 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:433:1: ( ( rule__Element__Group_2__0 )? ) rule__Element__Group__3
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:433:1: ( ( rule__Element__Group_2__0 )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:434:1: ( rule__Element__Group_2__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_2()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:435:1: ( rule__Element__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:435:2: rule__Element__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__0_in_rule__Element__Group__2818);
                    rule__Element__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2828);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:446:1: rule__Element__Group__3 : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:450:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:451:1: ( ( rule__Element__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:451:1: ( ( rule__Element__Group_3__0 )? )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:452:1: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:453:1: ( rule__Element__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:453:2: rule__Element__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3856);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:471:1: rule__Element__Group_2__0 : ( 'references' ) rule__Element__Group_2__1 ;
    public final void rule__Element__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:475:1: ( ( 'references' ) rule__Element__Group_2__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:476:1: ( 'references' ) rule__Element__Group_2__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:476:1: ( 'references' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:477:1: 'references'
            {
             before(grammarAccess.getElementAccess().getReferencesKeyword_2_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Element__Group_2__0900); 
             after(grammarAccess.getElementAccess().getReferencesKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_2__1_in_rule__Element__Group_2__0910);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:491:1: rule__Element__Group_2__1 : ( ( rule__Element__ReferencesAssignment_2_1 ) ) ;
    public final void rule__Element__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:495:1: ( ( ( rule__Element__ReferencesAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:496:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:496:1: ( ( rule__Element__ReferencesAssignment_2_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:497:1: ( rule__Element__ReferencesAssignment_2_1 )
            {
             before(grammarAccess.getElementAccess().getReferencesAssignment_2_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:498:1: ( rule__Element__ReferencesAssignment_2_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:498:2: rule__Element__ReferencesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__ReferencesAssignment_2_1_in_rule__Element__Group_2__1938);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:512:1: rule__Element__Group_3__0 : ( 'otherRefs' ) rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:516:1: ( ( 'otherRefs' ) rule__Element__Group_3__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:517:1: ( 'otherRefs' ) rule__Element__Group_3__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:517:1: ( 'otherRefs' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:518:1: 'otherRefs'
            {
             before(grammarAccess.getElementAccess().getOtherRefsKeyword_3_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Element__Group_3__0977); 
             after(grammarAccess.getElementAccess().getOtherRefsKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__0987);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:532:1: rule__Element__Group_3__1 : ( ( rule__Element__OtherRefsAssignment_3_1 ) ) rule__Element__Group_3__2 ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:536:1: ( ( ( rule__Element__OtherRefsAssignment_3_1 ) ) rule__Element__Group_3__2 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:537:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) ) rule__Element__Group_3__2
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:537:1: ( ( rule__Element__OtherRefsAssignment_3_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:538:1: ( rule__Element__OtherRefsAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:539:1: ( rule__Element__OtherRefsAssignment_3_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:539:2: rule__Element__OtherRefsAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__OtherRefsAssignment_3_1_in_rule__Element__Group_3__11015);
            rule__Element__OtherRefsAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getElementAccess().getOtherRefsAssignment_3_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__2_in_rule__Element__Group_3__11024);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:550:1: rule__Element__Group_3__2 : ( ( rule__Element__Group_3_2__0 )* ) ;
    public final void rule__Element__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:554:1: ( ( ( rule__Element__Group_3_2__0 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:555:1: ( ( rule__Element__Group_3_2__0 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:555:1: ( ( rule__Element__Group_3_2__0 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:556:1: ( rule__Element__Group_3_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_3_2()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:557:1: ( rule__Element__Group_3_2__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:557:2: rule__Element__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__0_in_rule__Element__Group_3__21052);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:573:1: rule__Element__Group_3_2__0 : ( ',' ) rule__Element__Group_3_2__1 ;
    public final void rule__Element__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:577:1: ( ( ',' ) rule__Element__Group_3_2__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:578:1: ( ',' ) rule__Element__Group_3_2__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:578:1: ( ',' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:579:1: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_3_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Element__Group_3_2__01094); 
             after(grammarAccess.getElementAccess().getCommaKeyword_3_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3_2__1_in_rule__Element__Group_3_2__01104);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:593:1: rule__Element__Group_3_2__1 : ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) ;
    public final void rule__Element__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:597:1: ( ( ( rule__Element__OtherRefsAssignment_3_2_1 ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:598:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:598:1: ( ( rule__Element__OtherRefsAssignment_3_2_1 ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:599:1: ( rule__Element__OtherRefsAssignment_3_2_1 )
            {
             before(grammarAccess.getElementAccess().getOtherRefsAssignment_3_2_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:600:1: ( rule__Element__OtherRefsAssignment_3_2_1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:600:2: rule__Element__OtherRefsAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__OtherRefsAssignment_3_2_1_in_rule__Element__Group_3_2__11132);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:614:1: rule__QualifiedName__Group__0 : ( RULE_ID ) rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:618:1: ( ( RULE_ID ) rule__QualifiedName__Group__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:619:1: ( RULE_ID ) rule__QualifiedName__Group__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:619:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:620:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QualifiedName__Group__01170); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01178);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:632:1: rule__QualifiedName__Group__1 : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:636:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:637:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:637:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:638:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:639:1: ( rule__QualifiedName__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:639:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__11206);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:653:1: rule__QualifiedName__Group_1__0 : ( '.' ) rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:657:1: ( ( '.' ) rule__QualifiedName__Group_1__1 )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:658:1: ( '.' ) rule__QualifiedName__Group_1__1
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:658:1: ( '.' )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:659:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__QualifiedName__Group_1__01246); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01256);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:673:1: rule__QualifiedName__Group_1__1 : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:677:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:678:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:678:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:679:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__11284); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:695:1: rule__Namespace__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Namespace__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:699:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:700:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:700:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:701:1: ruleQualifiedName
            {
             before(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Namespace__NameAssignment_11322);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:710:1: rule__Namespace__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__Namespace__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:714:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:715:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:715:1: ( ruleImport )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:716:1: ruleImport
            {
             before(grammarAccess.getNamespaceAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__Namespace__ImportsAssignment_31353);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:725:1: rule__Namespace__ElementsAssignment_4 : ( ruleNamedElement ) ;
    public final void rule__Namespace__ElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:729:1: ( ( ruleNamedElement ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:730:1: ( ruleNamedElement )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:730:1: ( ruleNamedElement )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:731:1: ruleNamedElement
            {
             before(grammarAccess.getNamespaceAccess().getElementsNamedElementParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedElement_in_rule__Namespace__ElementsAssignment_41384);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:740:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:744:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:745:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:745:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:746:1: ruleQualifiedName
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Import__ImportedNamespaceAssignment_11415);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:755:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:759:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:760:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:760:1: ( RULE_ID )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:761:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__NameAssignment_11446); 
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:770:1: rule__Element__ReferencesAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__ReferencesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:774:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:775:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:775:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:776:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getReferencesElementCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:777:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:778:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getReferencesElementQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__ReferencesAssignment_2_11481);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:789:1: rule__Element__OtherRefsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:793:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:794:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:794:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:795:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:796:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:797:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_11520);
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
    // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:808:1: rule__Element__OtherRefsAssignment_3_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Element__OtherRefsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:812:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:813:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:813:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:814:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementCrossReference_3_2_1_0()); 
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:815:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.builder.tests/src-gen/org/eclipse/xtext/builder/tests/contentassist/antlr/internal/InternalBuilderTestLanguage.g:816:1: ruleQualifiedName
            {
             before(grammarAccess.getElementAccess().getOtherRefsElementQualifiedNameParserRuleCall_3_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_2_11559);
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
        public static final BitSet FOLLOW_rule__NamedElement__Alternatives_in_ruleNamedElement95 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamespace129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__Group__0_in_ruleNamespace156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement244 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0_in_ruleElement278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName305 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamespace_in_rule__NamedElement__Alternatives375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__NamedElement__Alternatives392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Namespace__Group__0427 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Namespace__Group__1_in_rule__Namespace__Group__0437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__NameAssignment_1_in_rule__Namespace__Group__1465 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Namespace__Group__2_in_rule__Namespace__Group__1474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Namespace__Group__2503 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_rule__Namespace__Group__3_in_rule__Namespace__Group__2513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__ImportsAssignment_3_in_rule__Namespace__Group__3541 = new BitSet(new long[]{0x000000000000E800L});
        public static final BitSet FOLLOW_rule__Namespace__Group__4_in_rule__Namespace__Group__3551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Namespace__ElementsAssignment_4_in_rule__Namespace__Group__4579 = new BitSet(new long[]{0x000000000000A800L});
        public static final BitSet FOLLOW_rule__Namespace__Group__5_in_rule__Namespace__Group__4589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Namespace__Group__5618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Import__Group__0666 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Element__Group__0743 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__NameAssignment_1_in_rule__Element__Group__1781 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_2__0_in_rule__Element__Group__2818 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Element__Group_2__0900 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_2__1_in_rule__Element__Group_2__0910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__ReferencesAssignment_2_1_in_rule__Element__Group_2__1938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Element__Group_3__0977 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__0987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__OtherRefsAssignment_3_1_in_rule__Element__Group_3__11015 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__2_in_rule__Element__Group_3__11024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__0_in_rule__Element__Group_3__21052 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_rule__Element__Group_3_2__01094 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_3_2__1_in_rule__Element__Group_3_2__01104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__OtherRefsAssignment_3_2_1_in_rule__Element__Group_3_2__11132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__01170 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__11206 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_rule__QualifiedName__Group_1__01246 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__11284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Namespace__NameAssignment_11322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__Namespace__ImportsAssignment_31353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamedElement_in_rule__Namespace__ElementsAssignment_41384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Import__ImportedNamespaceAssignment_11415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__NameAssignment_11446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Element__ReferencesAssignment_2_11481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_11520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Element__OtherRefsAssignment_3_2_11559 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.example.contentassist.antlr.internal; 

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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalDomainmodelParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'public'", "'private'", "'protected'", "'import'", "'package'", "'{'", "'}'", "'datatype'", "'entity'", "'extends'", "'attr'", "':'", "'ref'", "'opposite'", "'op'", "'('", "')'", "','", "'.*'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalDomainmodelParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[124+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g"; }


     
     	private DomainmodelGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(DomainmodelGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:61:16: ( ruleModel EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:62:1: ruleModel EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel66);
            ruleModel();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel73); if (failed) return ;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:69:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:73:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:74:1: ( ( rule__Model__ElementsAssignment )* )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:74:1: ( ( rule__Model__ElementsAssignment )* )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:75:1: ( rule__Model__ElementsAssignment )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getElementsAssignment()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:76:1: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=14 && LA1_0<=15)||(LA1_0>=18 && LA1_0<=19)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:76:2: rule__Model__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ElementsAssignment_in_ruleModel100);
            	    rule__Model__ElementsAssignment();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getModelAccess().getElementsAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleAbstractElement
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:88:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:88:26: ( ruleAbstractElement EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:89:1: ruleAbstractElement EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAbstractElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement127);
            ruleAbstractElement();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAbstractElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractElement134); if (failed) return ;

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
    // $ANTLR end entryRuleAbstractElement


    // $ANTLR start ruleAbstractElement
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:96:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:100:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:101:1: ( ( rule__AbstractElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:101:1: ( ( rule__AbstractElement__Alternatives ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:102:1: ( rule__AbstractElement__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:103:1: ( rule__AbstractElement__Alternatives )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:103:2: rule__AbstractElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractElement__Alternatives_in_ruleAbstractElement161);
            rule__AbstractElement__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAbstractElement


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:115:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:115:17: ( ruleImport EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:116:1: ruleImport EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getImportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport187);
            ruleImport();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getImportRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport194); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:123:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:127:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:128:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:128:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:129:1: ( rule__Import__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getImportAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:130:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:130:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0_in_ruleImport221);
            rule__Import__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getImportAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start entryRulePackageDeclaration
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:142:1: entryRulePackageDeclaration : rulePackageDeclaration EOF ;
    public final void entryRulePackageDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:142:29: ( rulePackageDeclaration EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:143:1: rulePackageDeclaration EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration247);
            rulePackageDeclaration();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDeclaration254); if (failed) return ;

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
    // $ANTLR end entryRulePackageDeclaration


    // $ANTLR start rulePackageDeclaration
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:150:1: rulePackageDeclaration : ( ( rule__PackageDeclaration__Group__0 ) ) ;
    public final void rulePackageDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:154:2: ( ( ( rule__PackageDeclaration__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:155:1: ( ( rule__PackageDeclaration__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:155:1: ( ( rule__PackageDeclaration__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:156:1: ( rule__PackageDeclaration__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:157:1: ( rule__PackageDeclaration__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:157:2: rule__PackageDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__0_in_rulePackageDeclaration281);
            rule__PackageDeclaration__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rulePackageDeclaration


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:169:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:169:15: ( ruleType EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:170:1: ruleType EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType307);
            ruleType();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType314); if (failed) return ;

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:177:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:181:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:182:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:182:1: ( ( rule__Type__Alternatives ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:183:1: ( rule__Type__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:184:1: ( rule__Type__Alternatives )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:184:2: rule__Type__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Alternatives_in_ruleType341);
            rule__Type__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleType


    // $ANTLR start entryRuleDataType
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:196:1: entryRuleDataType : ruleDataType EOF ;
    public final void entryRuleDataType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:196:19: ( ruleDataType EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:197:1: ruleDataType EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDataTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataType_in_entryRuleDataType367);
            ruleDataType();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getDataTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataType374); if (failed) return ;

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
    // $ANTLR end entryRuleDataType


    // $ANTLR start ruleDataType
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:204:1: ruleDataType : ( ( rule__DataType__Group__0 ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:208:2: ( ( ( rule__DataType__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:209:1: ( ( rule__DataType__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:209:1: ( ( rule__DataType__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:210:1: ( rule__DataType__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDataTypeAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:211:1: ( rule__DataType__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:211:2: rule__DataType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__DataType__Group__0_in_ruleDataType401);
            rule__DataType__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getDataTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleDataType


    // $ANTLR start entryRuleEntity
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:223:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:223:17: ( ruleEntity EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:224:1: ruleEntity EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEntity_in_entryRuleEntity427);
            ruleEntity();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntity434); if (failed) return ;

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
    // $ANTLR end entryRuleEntity


    // $ANTLR start ruleEntity
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:231:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:235:2: ( ( ( rule__Entity__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:236:1: ( ( rule__Entity__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:236:1: ( ( rule__Entity__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:237:1: ( rule__Entity__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:238:1: ( rule__Entity__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:238:2: rule__Entity__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__0_in_ruleEntity461);
            rule__Entity__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEntity


    // $ANTLR start entryRuleFeature
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:250:1: entryRuleFeature : ruleFeature EOF ;
    public final void entryRuleFeature() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:250:18: ( ruleFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:251:1: ruleFeature EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature487);
            ruleFeature();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getFeatureRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature494); if (failed) return ;

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
    // $ANTLR end entryRuleFeature


    // $ANTLR start ruleFeature
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:258:1: ruleFeature : ( ( rule__Feature__Alternatives ) ) ;
    public final void ruleFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:262:2: ( ( ( rule__Feature__Alternatives ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:263:1: ( ( rule__Feature__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:263:1: ( ( rule__Feature__Alternatives ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:264:1: ( rule__Feature__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFeatureAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:265:1: ( rule__Feature__Alternatives )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:265:2: rule__Feature__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Feature__Alternatives_in_ruleFeature521);
            rule__Feature__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getFeatureAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleFeature


    // $ANTLR start entryRuleStructuralFeature
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:277:1: entryRuleStructuralFeature : ruleStructuralFeature EOF ;
    public final void entryRuleStructuralFeature() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:277:28: ( ruleStructuralFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:278:1: ruleStructuralFeature EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStructuralFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature547);
            ruleStructuralFeature();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getStructuralFeatureRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStructuralFeature554); if (failed) return ;

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
    // $ANTLR end entryRuleStructuralFeature


    // $ANTLR start ruleStructuralFeature
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:285:1: ruleStructuralFeature : ( ( rule__StructuralFeature__Alternatives ) ) ;
    public final void ruleStructuralFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:289:2: ( ( ( rule__StructuralFeature__Alternatives ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:290:1: ( ( rule__StructuralFeature__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:290:1: ( ( rule__StructuralFeature__Alternatives ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:291:1: ( rule__StructuralFeature__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStructuralFeatureAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:292:1: ( rule__StructuralFeature__Alternatives )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:292:2: rule__StructuralFeature__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__StructuralFeature__Alternatives_in_ruleStructuralFeature581);
            rule__StructuralFeature__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStructuralFeatureAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStructuralFeature


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:304:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:304:20: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:305:1: ruleAttribute EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute607);
            ruleAttribute();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute614); if (failed) return ;

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
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:312:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:316:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:317:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:317:1: ( ( rule__Attribute__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:318:1: ( rule__Attribute__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:319:1: ( rule__Attribute__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:319:2: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0_in_ruleAttribute641);
            rule__Attribute__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleReference
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:331:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:331:20: ( ruleReference EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:332:1: ruleReference EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference667);
            ruleReference();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference674); if (failed) return ;

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
    // $ANTLR end entryRuleReference


    // $ANTLR start ruleReference
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:339:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:343:2: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:344:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:344:1: ( ( rule__Reference__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:345:1: ( rule__Reference__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:346:1: ( rule__Reference__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:346:2: rule__Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__0_in_ruleReference701);
            rule__Reference__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleReference


    // $ANTLR start entryRuleOperation
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:358:1: entryRuleOperation : ruleOperation EOF ;
    public final void entryRuleOperation() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:358:20: ( ruleOperation EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:359:1: ruleOperation EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOperation_in_entryRuleOperation727);
            ruleOperation();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation734); if (failed) return ;

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
    // $ANTLR end entryRuleOperation


    // $ANTLR start ruleOperation
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:366:1: ruleOperation : ( ( rule__Operation__Group__0 ) ) ;
    public final void ruleOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:370:2: ( ( ( rule__Operation__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:371:1: ( ( rule__Operation__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:371:1: ( ( rule__Operation__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:372:1: ( rule__Operation__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:373:1: ( rule__Operation__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:373:2: rule__Operation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__0_in_ruleOperation761);
            rule__Operation__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleOperation


    // $ANTLR start entryRuleParameter
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:385:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:385:20: ( ruleParameter EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:386:1: ruleParameter EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter787);
            ruleParameter();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParameterRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter794); if (failed) return ;

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
    // $ANTLR end entryRuleParameter


    // $ANTLR start ruleParameter
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:393:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:397:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:398:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:398:1: ( ( rule__Parameter__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:399:1: ( rule__Parameter__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:400:1: ( rule__Parameter__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:400:2: rule__Parameter__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0_in_ruleParameter821);
            rule__Parameter__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleParameter


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:414:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:414:18: ( ruleTypeRef EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:415:1: ruleTypeRef EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef849);
            ruleTypeRef();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getTypeRefRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRef856); if (failed) return ;

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
    // $ANTLR end entryRuleTypeRef


    // $ANTLR start ruleTypeRef
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:422:1: ruleTypeRef : ( ( rule__TypeRef__ReferencedAssignment ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:426:2: ( ( ( rule__TypeRef__ReferencedAssignment ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:427:1: ( ( rule__TypeRef__ReferencedAssignment ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:427:1: ( ( rule__TypeRef__ReferencedAssignment ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:428:1: ( rule__TypeRef__ReferencedAssignment )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getReferencedAssignment()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:429:1: ( rule__TypeRef__ReferencedAssignment )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:429:2: rule__TypeRef__ReferencedAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__ReferencedAssignment_in_ruleTypeRef883);
            rule__TypeRef__ReferencedAssignment();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getReferencedAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleQualifiedNameWithWildCard
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:441:1: entryRuleQualifiedNameWithWildCard : ruleQualifiedNameWithWildCard EOF ;
    public final void entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:441:36: ( ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:442:1: ruleQualifiedNameWithWildCard EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard909);
            ruleQualifiedNameWithWildCard();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard916); if (failed) return ;

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
    // $ANTLR end entryRuleQualifiedNameWithWildCard


    // $ANTLR start ruleQualifiedNameWithWildCard
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:449:1: ruleQualifiedNameWithWildCard : ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildCard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:453:2: ( ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:454:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:454:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:455:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:456:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:456:2: rule__QualifiedNameWithWildCard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedNameWithWildCard__Group__0_in_ruleQualifiedNameWithWildCard943);
            rule__QualifiedNameWithWildCard__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleQualifiedNameWithWildCard


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:468:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:468:24: ( ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:469:1: ruleQualifiedName EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName969);
            ruleQualifiedName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName976); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:476:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:480:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:481:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:481:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:482:1: ( rule__QualifiedName__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:483:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:483:2: rule__QualifiedName__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName1003);
            rule__QualifiedName__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start ruleVisibility
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:496:1: ruleVisibility : ( ( rule__Visibility__Alternatives ) ) ;
    public final void ruleVisibility() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:500:1: ( ( ( rule__Visibility__Alternatives ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:501:1: ( ( rule__Visibility__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:501:1: ( ( rule__Visibility__Alternatives ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:502:1: ( rule__Visibility__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getVisibilityAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:503:1: ( rule__Visibility__Alternatives )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:503:2: rule__Visibility__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Visibility__Alternatives_in_ruleVisibility1040);
            rule__Visibility__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getVisibilityAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleVisibility


    // $ANTLR start rule__AbstractElement__Alternatives
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:514:1: rule__AbstractElement__Alternatives : ( ( rulePackageDeclaration ) | ( ruleType ) | ( ruleImport ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:518:1: ( ( rulePackageDeclaration ) | ( ruleType ) | ( ruleImport ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt2=1;
                }
                break;
            case 18:
            case 19:
                {
                alt2=2;
                }
                break;
            case 14:
                {
                alt2=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("514:1: rule__AbstractElement__Alternatives : ( ( rulePackageDeclaration ) | ( ruleType ) | ( ruleImport ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:519:1: ( rulePackageDeclaration )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:519:1: ( rulePackageDeclaration )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:520:1: rulePackageDeclaration
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePackageDeclaration_in_rule__AbstractElement__Alternatives1075);
                    rulePackageDeclaration();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:525:6: ( ruleType )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:525:6: ( ruleType )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:526:1: ruleType
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAbstractElementAccess().getTypeParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleType_in_rule__AbstractElement__Alternatives1092);
                    ruleType();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getAbstractElementAccess().getTypeParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:531:6: ( ruleImport )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:531:6: ( ruleImport )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:532:1: ruleImport
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__AbstractElement__Alternatives1109);
                    ruleImport();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_2()); 
                    }

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
    // $ANTLR end rule__AbstractElement__Alternatives


    // $ANTLR start rule__Type__Alternatives
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:542:1: rule__Type__Alternatives : ( ( ruleEntity ) | ( ruleDataType ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:546:1: ( ( ruleEntity ) | ( ruleDataType ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("542:1: rule__Type__Alternatives : ( ( ruleEntity ) | ( ruleDataType ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:547:1: ( ruleEntity )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:547:1: ( ruleEntity )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:548:1: ruleEntity
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getEntityParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEntity_in_rule__Type__Alternatives1141);
                    ruleEntity();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getEntityParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:553:6: ( ruleDataType )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:553:6: ( ruleDataType )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:554:1: ruleDataType
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getDataTypeParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDataType_in_rule__Type__Alternatives1158);
                    ruleDataType();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getDataTypeParserRuleCall_1()); 
                    }

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
    // $ANTLR end rule__Type__Alternatives


    // $ANTLR start rule__Feature__Alternatives
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:564:1: rule__Feature__Alternatives : ( ( ruleStructuralFeature ) | ( ruleOperation ) );
    public final void rule__Feature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:568:1: ( ( ruleStructuralFeature ) | ( ruleOperation ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21||LA4_0==23) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=11 && LA4_0<=13)||LA4_0==25) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("564:1: rule__Feature__Alternatives : ( ( ruleStructuralFeature ) | ( ruleOperation ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:569:1: ( ruleStructuralFeature )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:569:1: ( ruleStructuralFeature )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:570:1: ruleStructuralFeature
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getFeatureAccess().getStructuralFeatureParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStructuralFeature_in_rule__Feature__Alternatives1190);
                    ruleStructuralFeature();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getFeatureAccess().getStructuralFeatureParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:575:6: ( ruleOperation )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:575:6: ( ruleOperation )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:576:1: ruleOperation
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getFeatureAccess().getOperationParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOperation_in_rule__Feature__Alternatives1207);
                    ruleOperation();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getFeatureAccess().getOperationParserRuleCall_1()); 
                    }

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
    // $ANTLR end rule__Feature__Alternatives


    // $ANTLR start rule__StructuralFeature__Alternatives
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:586:1: rule__StructuralFeature__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );
    public final void rule__StructuralFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:590:1: ( ( ruleAttribute ) | ( ruleReference ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            else if ( (LA5_0==23) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("586:1: rule__StructuralFeature__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:591:1: ( ruleAttribute )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:591:1: ( ruleAttribute )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:592:1: ruleAttribute
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getStructuralFeatureAccess().getAttributeParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__StructuralFeature__Alternatives1239);
                    ruleAttribute();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getStructuralFeatureAccess().getAttributeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:597:6: ( ruleReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:597:6: ( ruleReference )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:598:1: ruleReference
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getStructuralFeatureAccess().getReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReference_in_rule__StructuralFeature__Alternatives1256);
                    ruleReference();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getStructuralFeatureAccess().getReferenceParserRuleCall_1()); 
                    }

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
    // $ANTLR end rule__StructuralFeature__Alternatives


    // $ANTLR start rule__Visibility__Alternatives
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:609:1: rule__Visibility__Alternatives : ( ( ( 'public' ) ) | ( ( 'private' ) ) | ( ( 'protected' ) ) );
    public final void rule__Visibility__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:613:1: ( ( ( 'public' ) ) | ( ( 'private' ) ) | ( ( 'protected' ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt6=1;
                }
                break;
            case 12:
                {
                alt6=2;
                }
                break;
            case 13:
                {
                alt6=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("609:1: rule__Visibility__Alternatives : ( ( ( 'public' ) ) | ( ( 'private' ) ) | ( ( 'protected' ) ) );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:614:1: ( ( 'public' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:614:1: ( ( 'public' ) )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:615:1: ( 'public' )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getVisibilityAccess().getPublicEnumLiteralDeclaration_0()); 
                    }
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:616:1: ( 'public' )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:616:3: 'public'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Visibility__Alternatives1290); if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getVisibilityAccess().getPublicEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:621:6: ( ( 'private' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:621:6: ( ( 'private' ) )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:622:1: ( 'private' )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getVisibilityAccess().getPrivateEnumLiteralDeclaration_1()); 
                    }
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:623:1: ( 'private' )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:623:3: 'private'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Visibility__Alternatives1311); if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getVisibilityAccess().getPrivateEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:628:6: ( ( 'protected' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:628:6: ( ( 'protected' ) )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:629:1: ( 'protected' )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getVisibilityAccess().getProtectedEnumLiteralDeclaration_2()); 
                    }
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:630:1: ( 'protected' )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:630:3: 'protected'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__Visibility__Alternatives1332); if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getVisibilityAccess().getProtectedEnumLiteralDeclaration_2()); 
                    }

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
    // $ANTLR end rule__Visibility__Alternatives


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:642:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:646:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:647:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:647:1: ( 'import' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:648:1: 'import'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Import__Group__01370); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__01380);
            rule__Import__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:662:1: rule__Import__Group__1 : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:666:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:667:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:667:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:668:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:669:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:669:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__11408);
            rule__Import__ImportedNamespaceAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            }

            }


            }

        }
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


    // $ANTLR start rule__PackageDeclaration__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:683:1: rule__PackageDeclaration__Group__0 : ( 'package' ) rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:687:1: ( ( 'package' ) rule__PackageDeclaration__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:688:1: ( 'package' ) rule__PackageDeclaration__Group__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:688:1: ( 'package' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:689:1: 'package'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__PackageDeclaration__Group__01447); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__01457);
            rule__PackageDeclaration__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDeclaration__Group__0


    // $ANTLR start rule__PackageDeclaration__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:703:1: rule__PackageDeclaration__Group__1 : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) rule__PackageDeclaration__Group__2 ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:707:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) rule__PackageDeclaration__Group__2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:708:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) ) rule__PackageDeclaration__Group__2
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:708:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:709:1: ( rule__PackageDeclaration__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:710:1: ( rule__PackageDeclaration__NameAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:710:2: rule__PackageDeclaration__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__11485);
            rule__PackageDeclaration__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__11494);
            rule__PackageDeclaration__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDeclaration__Group__1


    // $ANTLR start rule__PackageDeclaration__Group__2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:721:1: rule__PackageDeclaration__Group__2 : ( '{' ) rule__PackageDeclaration__Group__3 ;
    public final void rule__PackageDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:725:1: ( ( '{' ) rule__PackageDeclaration__Group__3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:726:1: ( '{' ) rule__PackageDeclaration__Group__3
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:726:1: ( '{' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:727:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__PackageDeclaration__Group__21523); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__3_in_rule__PackageDeclaration__Group__21533);
            rule__PackageDeclaration__Group__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDeclaration__Group__2


    // $ANTLR start rule__PackageDeclaration__Group__3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:741:1: rule__PackageDeclaration__Group__3 : ( ( rule__PackageDeclaration__ElementsAssignment_3 )* ) rule__PackageDeclaration__Group__4 ;
    public final void rule__PackageDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:745:1: ( ( ( rule__PackageDeclaration__ElementsAssignment_3 )* ) rule__PackageDeclaration__Group__4 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:746:1: ( ( rule__PackageDeclaration__ElementsAssignment_3 )* ) rule__PackageDeclaration__Group__4
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:746:1: ( ( rule__PackageDeclaration__ElementsAssignment_3 )* )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:747:1: ( rule__PackageDeclaration__ElementsAssignment_3 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getElementsAssignment_3()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:748:1: ( rule__PackageDeclaration__ElementsAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=14 && LA7_0<=15)||(LA7_0>=18 && LA7_0<=19)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:748:2: rule__PackageDeclaration__ElementsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__ElementsAssignment_3_in_rule__PackageDeclaration__Group__31561);
            	    rule__PackageDeclaration__ElementsAssignment_3();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getElementsAssignment_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__4_in_rule__PackageDeclaration__Group__31571);
            rule__PackageDeclaration__Group__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDeclaration__Group__3


    // $ANTLR start rule__PackageDeclaration__Group__4
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:759:1: rule__PackageDeclaration__Group__4 : ( '}' ) ;
    public final void rule__PackageDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:763:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:764:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:764:1: ( '}' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:765:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__PackageDeclaration__Group__41600); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDeclaration__Group__4


    // $ANTLR start rule__DataType__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:788:1: rule__DataType__Group__0 : ( 'datatype' ) rule__DataType__Group__1 ;
    public final void rule__DataType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:792:1: ( ( 'datatype' ) rule__DataType__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:793:1: ( 'datatype' ) rule__DataType__Group__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:793:1: ( 'datatype' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:794:1: 'datatype'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDataTypeAccess().getDatatypeKeyword_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__DataType__Group__01646); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getDataTypeAccess().getDatatypeKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__DataType__Group__1_in_rule__DataType__Group__01656);
            rule__DataType__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DataType__Group__0


    // $ANTLR start rule__DataType__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:808:1: rule__DataType__Group__1 : ( ( rule__DataType__NameAssignment_1 ) ) ;
    public final void rule__DataType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:812:1: ( ( ( rule__DataType__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:813:1: ( ( rule__DataType__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:813:1: ( ( rule__DataType__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:814:1: ( rule__DataType__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDataTypeAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:815:1: ( rule__DataType__NameAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:815:2: rule__DataType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DataType__NameAssignment_1_in_rule__DataType__Group__11684);
            rule__DataType__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getDataTypeAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DataType__Group__1


    // $ANTLR start rule__Entity__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:829:1: rule__Entity__Group__0 : ( 'entity' ) rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:833:1: ( ( 'entity' ) rule__Entity__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:834:1: ( 'entity' ) rule__Entity__Group__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:834:1: ( 'entity' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:835:1: 'entity'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Entity__Group__01723); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__01733);
            rule__Entity__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__0


    // $ANTLR start rule__Entity__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:849:1: rule__Entity__Group__1 : ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:853:1: ( ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:854:1: ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:854:1: ( ( rule__Entity__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:855:1: ( rule__Entity__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:856:1: ( rule__Entity__NameAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:856:2: rule__Entity__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__11761);
            rule__Entity__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__11770);
            rule__Entity__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__1


    // $ANTLR start rule__Entity__Group__2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:867:1: rule__Entity__Group__2 : ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:871:1: ( ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:872:1: ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:872:1: ( ( rule__Entity__Group_2__0 )? )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:873:1: ( rule__Entity__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getGroup_2()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:874:1: ( rule__Entity__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:874:2: rule__Entity__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__21798);
                    rule__Entity__Group_2__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getGroup_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__21808);
            rule__Entity__Group__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__2


    // $ANTLR start rule__Entity__Group__3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:885:1: rule__Entity__Group__3 : ( '{' ) rule__Entity__Group__4 ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:889:1: ( ( '{' ) rule__Entity__Group__4 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:890:1: ( '{' ) rule__Entity__Group__4
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:890:1: ( '{' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:891:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Entity__Group__31837); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__31847);
            rule__Entity__Group__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__3


    // $ANTLR start rule__Entity__Group__4
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:905:1: rule__Entity__Group__4 : ( ( rule__Entity__FeaturesAssignment_4 )* ) rule__Entity__Group__5 ;
    public final void rule__Entity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:909:1: ( ( ( rule__Entity__FeaturesAssignment_4 )* ) rule__Entity__Group__5 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:910:1: ( ( rule__Entity__FeaturesAssignment_4 )* ) rule__Entity__Group__5
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:910:1: ( ( rule__Entity__FeaturesAssignment_4 )* )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:911:1: ( rule__Entity__FeaturesAssignment_4 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getFeaturesAssignment_4()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:912:1: ( rule__Entity__FeaturesAssignment_4 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=11 && LA9_0<=13)||LA9_0==21||LA9_0==23||LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:912:2: rule__Entity__FeaturesAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Entity__FeaturesAssignment_4_in_rule__Entity__Group__41875);
            	    rule__Entity__FeaturesAssignment_4();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getFeaturesAssignment_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__41885);
            rule__Entity__Group__5();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__4


    // $ANTLR start rule__Entity__Group__5
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:923:1: rule__Entity__Group__5 : ( '}' ) ;
    public final void rule__Entity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:927:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:928:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:928:1: ( '}' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:929:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Entity__Group__51914); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__5


    // $ANTLR start rule__Entity__Group_2__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:954:1: rule__Entity__Group_2__0 : ( 'extends' ) rule__Entity__Group_2__1 ;
    public final void rule__Entity__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:958:1: ( ( 'extends' ) rule__Entity__Group_2__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:959:1: ( 'extends' ) rule__Entity__Group_2__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:959:1: ( 'extends' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:960:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Entity__Group_2__01962); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__01972);
            rule__Entity__Group_2__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group_2__0


    // $ANTLR start rule__Entity__Group_2__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:974:1: rule__Entity__Group_2__1 : ( ( rule__Entity__SuperTypeAssignment_2_1 ) ) ;
    public final void rule__Entity__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:978:1: ( ( ( rule__Entity__SuperTypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:979:1: ( ( rule__Entity__SuperTypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:979:1: ( ( rule__Entity__SuperTypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:980:1: ( rule__Entity__SuperTypeAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getSuperTypeAssignment_2_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:981:1: ( rule__Entity__SuperTypeAssignment_2_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:981:2: rule__Entity__SuperTypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__SuperTypeAssignment_2_1_in_rule__Entity__Group_2__12000);
            rule__Entity__SuperTypeAssignment_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getSuperTypeAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group_2__1


    // $ANTLR start rule__Attribute__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:995:1: rule__Attribute__Group__0 : ( 'attr' ) rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:999:1: ( ( 'attr' ) rule__Attribute__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1000:1: ( 'attr' ) rule__Attribute__Group__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1000:1: ( 'attr' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1001:1: 'attr'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getAttrKeyword_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Attribute__Group__02039); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getAttrKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__02049);
            rule__Attribute__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group__0


    // $ANTLR start rule__Attribute__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1015:1: rule__Attribute__Group__1 : ( ( rule__Attribute__NameAssignment_1 ) ) rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1019:1: ( ( ( rule__Attribute__NameAssignment_1 ) ) rule__Attribute__Group__2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1020:1: ( ( rule__Attribute__NameAssignment_1 ) ) rule__Attribute__Group__2
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1020:1: ( ( rule__Attribute__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1021:1: ( rule__Attribute__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1022:1: ( rule__Attribute__NameAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1022:2: rule__Attribute__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__NameAssignment_1_in_rule__Attribute__Group__12077);
            rule__Attribute__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__12086);
            rule__Attribute__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group__1


    // $ANTLR start rule__Attribute__Group__2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1033:1: rule__Attribute__Group__2 : ( ':' ) rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1037:1: ( ( ':' ) rule__Attribute__Group__3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1038:1: ( ':' ) rule__Attribute__Group__3
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1038:1: ( ':' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1039:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getColonKeyword_2()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Attribute__Group__22115); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getColonKeyword_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__3_in_rule__Attribute__Group__22125);
            rule__Attribute__Group__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group__2


    // $ANTLR start rule__Attribute__Group__3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1053:1: rule__Attribute__Group__3 : ( ( rule__Attribute__TypeAssignment_3 ) ) ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1057:1: ( ( ( rule__Attribute__TypeAssignment_3 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1058:1: ( ( rule__Attribute__TypeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1058:1: ( ( rule__Attribute__TypeAssignment_3 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1059:1: ( rule__Attribute__TypeAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getTypeAssignment_3()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1060:1: ( rule__Attribute__TypeAssignment_3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1060:2: rule__Attribute__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__TypeAssignment_3_in_rule__Attribute__Group__32153);
            rule__Attribute__TypeAssignment_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getTypeAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group__3


    // $ANTLR start rule__Reference__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1078:1: rule__Reference__Group__0 : ( 'ref' ) rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1082:1: ( ( 'ref' ) rule__Reference__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1083:1: ( 'ref' ) rule__Reference__Group__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1083:1: ( 'ref' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1084:1: 'ref'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Reference__Group__02196); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__02206);
            rule__Reference__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group__0


    // $ANTLR start rule__Reference__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1098:1: rule__Reference__Group__1 : ( ( rule__Reference__NameAssignment_1 ) ) rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1102:1: ( ( ( rule__Reference__NameAssignment_1 ) ) rule__Reference__Group__2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1103:1: ( ( rule__Reference__NameAssignment_1 ) ) rule__Reference__Group__2
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1103:1: ( ( rule__Reference__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1104:1: ( rule__Reference__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1105:1: ( rule__Reference__NameAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1105:2: rule__Reference__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__NameAssignment_1_in_rule__Reference__Group__12234);
            rule__Reference__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__12243);
            rule__Reference__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group__1


    // $ANTLR start rule__Reference__Group__2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1116:1: rule__Reference__Group__2 : ( ':' ) rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1120:1: ( ( ':' ) rule__Reference__Group__3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1121:1: ( ':' ) rule__Reference__Group__3
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1121:1: ( ':' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1122:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getColonKeyword_2()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Reference__Group__22272); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getColonKeyword_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__22282);
            rule__Reference__Group__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group__2


    // $ANTLR start rule__Reference__Group__3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1136:1: rule__Reference__Group__3 : ( ( rule__Reference__TypeAssignment_3 ) ) rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1140:1: ( ( ( rule__Reference__TypeAssignment_3 ) ) rule__Reference__Group__4 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1141:1: ( ( rule__Reference__TypeAssignment_3 ) ) rule__Reference__Group__4
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1141:1: ( ( rule__Reference__TypeAssignment_3 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1142:1: ( rule__Reference__TypeAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1143:1: ( rule__Reference__TypeAssignment_3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1143:2: rule__Reference__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__TypeAssignment_3_in_rule__Reference__Group__32310);
            rule__Reference__TypeAssignment_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__32319);
            rule__Reference__Group__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group__3


    // $ANTLR start rule__Reference__Group__4
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1154:1: rule__Reference__Group__4 : ( ( rule__Reference__Group_4__0 )? ) ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1158:1: ( ( ( rule__Reference__Group_4__0 )? ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1159:1: ( ( rule__Reference__Group_4__0 )? )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1159:1: ( ( rule__Reference__Group_4__0 )? )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1160:1: ( rule__Reference__Group_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getGroup_4()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1161:1: ( rule__Reference__Group_4__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1161:2: rule__Reference__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4__0_in_rule__Reference__Group__42347);
                    rule__Reference__Group_4__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group__4


    // $ANTLR start rule__Reference__Group_4__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1181:1: rule__Reference__Group_4__0 : ( 'opposite' ) rule__Reference__Group_4__1 ;
    public final void rule__Reference__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1185:1: ( ( 'opposite' ) rule__Reference__Group_4__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1186:1: ( 'opposite' ) rule__Reference__Group_4__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1186:1: ( 'opposite' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1187:1: 'opposite'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getOppositeKeyword_4_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Reference__Group_4__02393); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getOppositeKeyword_4_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4__1_in_rule__Reference__Group_4__02403);
            rule__Reference__Group_4__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group_4__0


    // $ANTLR start rule__Reference__Group_4__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1201:1: rule__Reference__Group_4__1 : ( ( rule__Reference__OppositeAssignment_4_1 ) ) ;
    public final void rule__Reference__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1205:1: ( ( ( rule__Reference__OppositeAssignment_4_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1206:1: ( ( rule__Reference__OppositeAssignment_4_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1206:1: ( ( rule__Reference__OppositeAssignment_4_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1207:1: ( rule__Reference__OppositeAssignment_4_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getOppositeAssignment_4_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1208:1: ( rule__Reference__OppositeAssignment_4_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1208:2: rule__Reference__OppositeAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__OppositeAssignment_4_1_in_rule__Reference__Group_4__12431);
            rule__Reference__OppositeAssignment_4_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getOppositeAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group_4__1


    // $ANTLR start rule__Operation__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1222:1: rule__Operation__Group__0 : ( ( rule__Operation__VisibilityAssignment_0 )? ) rule__Operation__Group__1 ;
    public final void rule__Operation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1226:1: ( ( ( rule__Operation__VisibilityAssignment_0 )? ) rule__Operation__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1227:1: ( ( rule__Operation__VisibilityAssignment_0 )? ) rule__Operation__Group__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1227:1: ( ( rule__Operation__VisibilityAssignment_0 )? )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1228:1: ( rule__Operation__VisibilityAssignment_0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getVisibilityAssignment_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1229:1: ( rule__Operation__VisibilityAssignment_0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=11 && LA11_0<=13)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1229:2: rule__Operation__VisibilityAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Operation__VisibilityAssignment_0_in_rule__Operation__Group__02469);
                    rule__Operation__VisibilityAssignment_0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getVisibilityAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__1_in_rule__Operation__Group__02479);
            rule__Operation__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__0


    // $ANTLR start rule__Operation__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1240:1: rule__Operation__Group__1 : ( 'op' ) rule__Operation__Group__2 ;
    public final void rule__Operation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1244:1: ( ( 'op' ) rule__Operation__Group__2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1245:1: ( 'op' ) rule__Operation__Group__2
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1245:1: ( 'op' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1246:1: 'op'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getOpKeyword_1()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Operation__Group__12508); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getOpKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__2_in_rule__Operation__Group__12518);
            rule__Operation__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__1


    // $ANTLR start rule__Operation__Group__2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1260:1: rule__Operation__Group__2 : ( ( rule__Operation__NameAssignment_2 ) ) rule__Operation__Group__3 ;
    public final void rule__Operation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1264:1: ( ( ( rule__Operation__NameAssignment_2 ) ) rule__Operation__Group__3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1265:1: ( ( rule__Operation__NameAssignment_2 ) ) rule__Operation__Group__3
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1265:1: ( ( rule__Operation__NameAssignment_2 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1266:1: ( rule__Operation__NameAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1267:1: ( rule__Operation__NameAssignment_2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1267:2: rule__Operation__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__NameAssignment_2_in_rule__Operation__Group__22546);
            rule__Operation__NameAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getNameAssignment_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__3_in_rule__Operation__Group__22555);
            rule__Operation__Group__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__2


    // $ANTLR start rule__Operation__Group__3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1278:1: rule__Operation__Group__3 : ( '(' ) rule__Operation__Group__4 ;
    public final void rule__Operation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1282:1: ( ( '(' ) rule__Operation__Group__4 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1283:1: ( '(' ) rule__Operation__Group__4
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1283:1: ( '(' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1284:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Operation__Group__32584); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__4_in_rule__Operation__Group__32594);
            rule__Operation__Group__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__3


    // $ANTLR start rule__Operation__Group__4
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1298:1: rule__Operation__Group__4 : ( ( rule__Operation__Group_4__0 )? ) rule__Operation__Group__5 ;
    public final void rule__Operation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1302:1: ( ( ( rule__Operation__Group_4__0 )? ) rule__Operation__Group__5 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1303:1: ( ( rule__Operation__Group_4__0 )? ) rule__Operation__Group__5
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1303:1: ( ( rule__Operation__Group_4__0 )? )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1304:1: ( rule__Operation__Group_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getGroup_4()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1305:1: ( rule__Operation__Group_4__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1305:2: rule__Operation__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4__0_in_rule__Operation__Group__42622);
                    rule__Operation__Group_4__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getGroup_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__5_in_rule__Operation__Group__42632);
            rule__Operation__Group__5();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__4


    // $ANTLR start rule__Operation__Group__5
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1316:1: rule__Operation__Group__5 : ( ')' ) rule__Operation__Group__6 ;
    public final void rule__Operation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1320:1: ( ( ')' ) rule__Operation__Group__6 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1321:1: ( ')' ) rule__Operation__Group__6
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1321:1: ( ')' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1322:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Operation__Group__52661); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__6_in_rule__Operation__Group__52671);
            rule__Operation__Group__6();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__5


    // $ANTLR start rule__Operation__Group__6
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1336:1: rule__Operation__Group__6 : ( ':' ) rule__Operation__Group__7 ;
    public final void rule__Operation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1340:1: ( ( ':' ) rule__Operation__Group__7 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1341:1: ( ':' ) rule__Operation__Group__7
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1341:1: ( ':' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1342:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getColonKeyword_6()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Operation__Group__62700); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getColonKeyword_6()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__7_in_rule__Operation__Group__62710);
            rule__Operation__Group__7();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__6


    // $ANTLR start rule__Operation__Group__7
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1356:1: rule__Operation__Group__7 : ( ( rule__Operation__TypeAssignment_7 ) ) ;
    public final void rule__Operation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1360:1: ( ( ( rule__Operation__TypeAssignment_7 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1361:1: ( ( rule__Operation__TypeAssignment_7 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1361:1: ( ( rule__Operation__TypeAssignment_7 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1362:1: ( rule__Operation__TypeAssignment_7 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getTypeAssignment_7()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1363:1: ( rule__Operation__TypeAssignment_7 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1363:2: rule__Operation__TypeAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__TypeAssignment_7_in_rule__Operation__Group__72738);
            rule__Operation__TypeAssignment_7();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getTypeAssignment_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__7


    // $ANTLR start rule__Operation__Group_4__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1389:1: rule__Operation__Group_4__0 : ( ( rule__Operation__ParamsAssignment_4_0 ) ) rule__Operation__Group_4__1 ;
    public final void rule__Operation__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1393:1: ( ( ( rule__Operation__ParamsAssignment_4_0 ) ) rule__Operation__Group_4__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1394:1: ( ( rule__Operation__ParamsAssignment_4_0 ) ) rule__Operation__Group_4__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1394:1: ( ( rule__Operation__ParamsAssignment_4_0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1395:1: ( rule__Operation__ParamsAssignment_4_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getParamsAssignment_4_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1396:1: ( rule__Operation__ParamsAssignment_4_0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1396:2: rule__Operation__ParamsAssignment_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__ParamsAssignment_4_0_in_rule__Operation__Group_4__02788);
            rule__Operation__ParamsAssignment_4_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getParamsAssignment_4_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4__1_in_rule__Operation__Group_4__02797);
            rule__Operation__Group_4__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group_4__0


    // $ANTLR start rule__Operation__Group_4__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1407:1: rule__Operation__Group_4__1 : ( ( rule__Operation__Group_4_1__0 )* ) ;
    public final void rule__Operation__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1411:1: ( ( ( rule__Operation__Group_4_1__0 )* ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1412:1: ( ( rule__Operation__Group_4_1__0 )* )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1412:1: ( ( rule__Operation__Group_4_1__0 )* )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1413:1: ( rule__Operation__Group_4_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getGroup_4_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1414:1: ( rule__Operation__Group_4_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1414:2: rule__Operation__Group_4_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4_1__0_in_rule__Operation__Group_4__12825);
            	    rule__Operation__Group_4_1__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getGroup_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group_4__1


    // $ANTLR start rule__Operation__Group_4_1__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1428:1: rule__Operation__Group_4_1__0 : ( ',' ) rule__Operation__Group_4_1__1 ;
    public final void rule__Operation__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1432:1: ( ( ',' ) rule__Operation__Group_4_1__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1433:1: ( ',' ) rule__Operation__Group_4_1__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1433:1: ( ',' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1434:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__Operation__Group_4_1__02865); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4_1__1_in_rule__Operation__Group_4_1__02875);
            rule__Operation__Group_4_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group_4_1__0


    // $ANTLR start rule__Operation__Group_4_1__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1448:1: rule__Operation__Group_4_1__1 : ( ( rule__Operation__ParamsAssignment_4_1_1 ) ) ;
    public final void rule__Operation__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1452:1: ( ( ( rule__Operation__ParamsAssignment_4_1_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1453:1: ( ( rule__Operation__ParamsAssignment_4_1_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1453:1: ( ( rule__Operation__ParamsAssignment_4_1_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1454:1: ( rule__Operation__ParamsAssignment_4_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getParamsAssignment_4_1_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1455:1: ( rule__Operation__ParamsAssignment_4_1_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1455:2: rule__Operation__ParamsAssignment_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__ParamsAssignment_4_1_1_in_rule__Operation__Group_4_1__12903);
            rule__Operation__ParamsAssignment_4_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getParamsAssignment_4_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group_4_1__1


    // $ANTLR start rule__Parameter__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1469:1: rule__Parameter__Group__0 : ( ( rule__Parameter__NameAssignment_0 ) ) rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1473:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) rule__Parameter__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1474:1: ( ( rule__Parameter__NameAssignment_0 ) ) rule__Parameter__Group__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1474:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1475:1: ( rule__Parameter__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1476:1: ( rule__Parameter__NameAssignment_0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1476:2: rule__Parameter__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__02941);
            rule__Parameter__NameAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__02950);
            rule__Parameter__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameter__Group__0


    // $ANTLR start rule__Parameter__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1487:1: rule__Parameter__Group__1 : ( ( rule__Parameter__TypeAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1491:1: ( ( ( rule__Parameter__TypeAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1492:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1492:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1493:1: ( rule__Parameter__TypeAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1494:1: ( rule__Parameter__TypeAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1494:2: rule__Parameter__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__12978);
            rule__Parameter__TypeAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameter__Group__1


    // $ANTLR start rule__QualifiedNameWithWildCard__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1508:1: rule__QualifiedNameWithWildCard__Group__0 : ( ruleQualifiedName ) rule__QualifiedNameWithWildCard__Group__1 ;
    public final void rule__QualifiedNameWithWildCard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1512:1: ( ( ruleQualifiedName ) rule__QualifiedNameWithWildCard__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1513:1: ( ruleQualifiedName ) rule__QualifiedNameWithWildCard__Group__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1513:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1514:1: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__03016);
            ruleQualifiedName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__03024);
            rule__QualifiedNameWithWildCard__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QualifiedNameWithWildCard__Group__0


    // $ANTLR start rule__QualifiedNameWithWildCard__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1526:1: rule__QualifiedNameWithWildCard__Group__1 : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildCard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1530:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1531:1: ( ( '.*' )? )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1531:1: ( ( '.*' )? )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1532:1: ( '.*' )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1533:1: ( '.*' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==29) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1534:2: '.*'
                    {
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__QualifiedNameWithWildCard__Group__13054); if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QualifiedNameWithWildCard__Group__1


    // $ANTLR start rule__QualifiedName__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1549:1: rule__QualifiedName__Group__0 : ( RULE_ID ) rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1553:1: ( ( RULE_ID ) rule__QualifiedName__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1554:1: ( RULE_ID ) rule__QualifiedName__Group__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1554:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1555:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QualifiedName__Group__03095); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03103);
            rule__QualifiedName__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1567:1: rule__QualifiedName__Group__1 : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1571:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1572:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1572:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1573:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1574:1: ( rule__QualifiedName__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==30) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1574:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__13131);
            	    rule__QualifiedName__Group_1__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }

            }


            }

        }
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1588:1: rule__QualifiedName__Group_1__0 : ( '.' ) rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1592:1: ( ( '.' ) rule__QualifiedName__Group_1__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1593:1: ( '.' ) rule__QualifiedName__Group_1__1
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1593:1: ( '.' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1594:1: '.'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__QualifiedName__Group_1__03171); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03181);
            rule__QualifiedName__Group_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1608:1: rule__QualifiedName__Group_1__1 : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1612:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1613:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1613:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1614:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__13209); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }

            }


            }

        }
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


    // $ANTLR start rule__Model__ElementsAssignment
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1629:1: rule__Model__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1633:1: ( ( ruleAbstractElement ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1634:1: ( ruleAbstractElement )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1634:1: ( ruleAbstractElement )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1635:1: ruleAbstractElement
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstractElement_in_rule__Model__ElementsAssignment3246);
            ruleAbstractElement();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ElementsAssignment


    // $ANTLR start rule__Import__ImportedNamespaceAssignment_1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1644:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildCard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1648:1: ( ( ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1649:1: ( ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1649:1: ( ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1650:1: ruleQualifiedNameWithWildCard
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_13277);
            ruleQualifiedNameWithWildCard();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            }

            }


            }

        }
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


    // $ANTLR start rule__PackageDeclaration__NameAssignment_1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1659:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1663:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1664:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1664:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1665:1: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_13308);
            ruleQualifiedName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDeclaration__NameAssignment_1


    // $ANTLR start rule__PackageDeclaration__ElementsAssignment_3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1674:1: rule__PackageDeclaration__ElementsAssignment_3 : ( ruleAbstractElement ) ;
    public final void rule__PackageDeclaration__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1678:1: ( ( ruleAbstractElement ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1679:1: ( ruleAbstractElement )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1679:1: ( ruleAbstractElement )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1680:1: ruleAbstractElement
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstractElement_in_rule__PackageDeclaration__ElementsAssignment_33339);
            ruleAbstractElement();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDeclaration__ElementsAssignment_3


    // $ANTLR start rule__DataType__NameAssignment_1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1689:1: rule__DataType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1693:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1694:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1694:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1695:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__DataType__NameAssignment_13370); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DataType__NameAssignment_1


    // $ANTLR start rule__Entity__NameAssignment_1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1704:1: rule__Entity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1708:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1709:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1709:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1710:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_13401); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__NameAssignment_1


    // $ANTLR start rule__Entity__SuperTypeAssignment_2_1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1719:1: rule__Entity__SuperTypeAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Entity__SuperTypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1723:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1724:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1724:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1725:1: ( ruleQualifiedName )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getSuperTypeEntityCrossReference_2_1_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1726:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1727:1: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getSuperTypeEntityQualifiedNameParserRuleCall_2_1_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Entity__SuperTypeAssignment_2_13436);
            ruleQualifiedName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getSuperTypeEntityQualifiedNameParserRuleCall_2_1_0_1()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getSuperTypeEntityCrossReference_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__SuperTypeAssignment_2_1


    // $ANTLR start rule__Entity__FeaturesAssignment_4
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1738:1: rule__Entity__FeaturesAssignment_4 : ( ruleFeature ) ;
    public final void rule__Entity__FeaturesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1742:1: ( ( ruleFeature ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1743:1: ( ruleFeature )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1743:1: ( ruleFeature )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1744:1: ruleFeature
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getFeaturesFeatureParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_rule__Entity__FeaturesAssignment_43471);
            ruleFeature();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getFeaturesFeatureParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__FeaturesAssignment_4


    // $ANTLR start rule__Attribute__NameAssignment_1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1753:1: rule__Attribute__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1757:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1758:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1758:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1759:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_13502); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__NameAssignment_1


    // $ANTLR start rule__Attribute__TypeAssignment_3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1768:1: rule__Attribute__TypeAssignment_3 : ( ruleTypeRef ) ;
    public final void rule__Attribute__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1772:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1773:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1773:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1774:1: ruleTypeRef
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getTypeTypeRefParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Attribute__TypeAssignment_33533);
            ruleTypeRef();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getTypeTypeRefParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__TypeAssignment_3


    // $ANTLR start rule__Reference__NameAssignment_1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1783:1: rule__Reference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Reference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1787:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1788:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1788:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1789:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_13564); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__NameAssignment_1


    // $ANTLR start rule__Reference__TypeAssignment_3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1798:1: rule__Reference__TypeAssignment_3 : ( ruleTypeRef ) ;
    public final void rule__Reference__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1802:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1803:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1803:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1804:1: ruleTypeRef
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getTypeTypeRefParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Reference__TypeAssignment_33595);
            ruleTypeRef();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getTypeTypeRefParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__TypeAssignment_3


    // $ANTLR start rule__Reference__OppositeAssignment_4_1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1813:1: rule__Reference__OppositeAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__OppositeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1817:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1818:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1818:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1819:1: ( RULE_ID )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getOppositeReferenceCrossReference_4_1_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1820:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1821:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getOppositeReferenceIDTerminalRuleCall_4_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Reference__OppositeAssignment_4_13630); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getOppositeReferenceIDTerminalRuleCall_4_1_0_1()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getOppositeReferenceCrossReference_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__OppositeAssignment_4_1


    // $ANTLR start rule__Operation__VisibilityAssignment_0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1832:1: rule__Operation__VisibilityAssignment_0 : ( ruleVisibility ) ;
    public final void rule__Operation__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1836:1: ( ( ruleVisibility ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1837:1: ( ruleVisibility )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1837:1: ( ruleVisibility )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1838:1: ruleVisibility
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVisibility_in_rule__Operation__VisibilityAssignment_03665);
            ruleVisibility();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__VisibilityAssignment_0


    // $ANTLR start rule__Operation__NameAssignment_2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1847:1: rule__Operation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1851:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1852:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1852:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1853:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Operation__NameAssignment_23696); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__NameAssignment_2


    // $ANTLR start rule__Operation__ParamsAssignment_4_0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1862:1: rule__Operation__ParamsAssignment_4_0 : ( ruleParameter ) ;
    public final void rule__Operation__ParamsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1866:1: ( ( ruleParameter ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1867:1: ( ruleParameter )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1867:1: ( ruleParameter )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1868:1: ruleParameter
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__Operation__ParamsAssignment_4_03727);
            ruleParameter();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__ParamsAssignment_4_0


    // $ANTLR start rule__Operation__ParamsAssignment_4_1_1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1877:1: rule__Operation__ParamsAssignment_4_1_1 : ( ruleParameter ) ;
    public final void rule__Operation__ParamsAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1881:1: ( ( ruleParameter ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1882:1: ( ruleParameter )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1882:1: ( ruleParameter )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1883:1: ruleParameter
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__Operation__ParamsAssignment_4_1_13758);
            ruleParameter();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__ParamsAssignment_4_1_1


    // $ANTLR start rule__Operation__TypeAssignment_7
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1892:1: rule__Operation__TypeAssignment_7 : ( ruleTypeRef ) ;
    public final void rule__Operation__TypeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1896:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1897:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1897:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1898:1: ruleTypeRef
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getTypeTypeRefParserRuleCall_7_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Operation__TypeAssignment_73789);
            ruleTypeRef();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getTypeTypeRefParserRuleCall_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__TypeAssignment_7


    // $ANTLR start rule__Parameter__NameAssignment_0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1907:1: rule__Parameter__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1911:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1912:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1912:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1913:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_03820); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameter__NameAssignment_0


    // $ANTLR start rule__Parameter__TypeAssignment_1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1922:1: rule__Parameter__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Parameter__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1926:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1927:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1927:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1928:1: ruleTypeRef
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeTypeRefParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Parameter__TypeAssignment_13851);
            ruleTypeRef();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeTypeRefParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameter__TypeAssignment_1


    // $ANTLR start rule__TypeRef__ReferencedAssignment
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1937:1: rule__TypeRef__ReferencedAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__TypeRef__ReferencedAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1941:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1942:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1942:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1943:1: ( ruleQualifiedName )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getReferencedTypeCrossReference_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1944:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1945:1: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getReferencedTypeQualifiedNameParserRuleCall_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__TypeRef__ReferencedAssignment3886);
            ruleQualifiedName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getReferencedTypeQualifiedNameParserRuleCall_0_1()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getTypeRefAccess().getReferencedTypeCrossReference_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TypeRef__ReferencedAssignment


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel66 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ElementsAssignment_in_ruleModel100 = new BitSet(new long[]{0x00000000000CC002L});
        public static final BitSet FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement127 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractElement134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractElement__Alternatives_in_ruleAbstractElement161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport187 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration247 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0_in_rulePackageDeclaration281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType307 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataType374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DataType__Group__0_in_ruleDataType401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntity434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group__0_in_ruleEntity461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature487 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Feature__Alternatives_in_ruleFeature521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStructuralFeature554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StructuralFeature__Alternatives_in_ruleStructuralFeature581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute607 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation727 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__0_in_ruleOperation761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter787 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef849 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__ReferencedAssignment_in_ruleTypeRef883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard909 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__0_in_ruleQualifiedNameWithWildCard943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName969 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName1003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Visibility__Alternatives_in_ruleVisibility1040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDeclaration_in_rule__AbstractElement__Alternatives1075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_rule__AbstractElement__Alternatives1092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__AbstractElement__Alternatives1109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEntity_in_rule__Type__Alternatives1141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataType_in_rule__Type__Alternatives1158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStructuralFeature_in_rule__Feature__Alternatives1190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_in_rule__Feature__Alternatives1207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__StructuralFeature__Alternatives1239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_rule__StructuralFeature__Alternatives1256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Visibility__Alternatives1290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Visibility__Alternatives1311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Visibility__Alternatives1332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Import__Group__01370 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__01380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__11408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__PackageDeclaration__Group__01447 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__01457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__11485 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__11494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__PackageDeclaration__Group__21523 = new BitSet(new long[]{0x00000000000EC000L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__3_in_rule__PackageDeclaration__Group__21533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__ElementsAssignment_3_in_rule__PackageDeclaration__Group__31561 = new BitSet(new long[]{0x00000000000EC000L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__4_in_rule__PackageDeclaration__Group__31571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__PackageDeclaration__Group__41600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__DataType__Group__01646 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__DataType__Group__1_in_rule__DataType__Group__01656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DataType__NameAssignment_1_in_rule__DataType__Group__11684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Entity__Group__01723 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__01733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__11761 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__11770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__21798 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__21808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Entity__Group__31837 = new BitSet(new long[]{0x0000000002A23800L});
        public static final BitSet FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__31847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__FeaturesAssignment_4_in_rule__Entity__Group__41875 = new BitSet(new long[]{0x0000000002A23800L});
        public static final BitSet FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__41885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Entity__Group__51914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Entity__Group_2__01962 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__01972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__SuperTypeAssignment_2_1_in_rule__Entity__Group_2__12000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Attribute__Group__02039 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__02049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__NameAssignment_1_in_rule__Attribute__Group__12077 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__12086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Attribute__Group__22115 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute__Group__3_in_rule__Attribute__Group__22125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__TypeAssignment_3_in_rule__Attribute__Group__32153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Reference__Group__02196 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__02206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__NameAssignment_1_in_rule__Reference__Group__12234 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__12243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Reference__Group__22272 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__22282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__TypeAssignment_3_in_rule__Reference__Group__32310 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__32319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group_4__0_in_rule__Reference__Group__42347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Reference__Group_4__02393 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group_4__1_in_rule__Reference__Group_4__02403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__OppositeAssignment_4_1_in_rule__Reference__Group_4__12431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__VisibilityAssignment_0_in_rule__Operation__Group__02469 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Operation__Group__1_in_rule__Operation__Group__02479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Operation__Group__12508 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation__Group__2_in_rule__Operation__Group__12518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__NameAssignment_2_in_rule__Operation__Group__22546 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Operation__Group__3_in_rule__Operation__Group__22555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Operation__Group__32584 = new BitSet(new long[]{0x0000000008000010L});
        public static final BitSet FOLLOW_rule__Operation__Group__4_in_rule__Operation__Group__32594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group_4__0_in_rule__Operation__Group__42622 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__Operation__Group__5_in_rule__Operation__Group__42632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Operation__Group__52661 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Operation__Group__6_in_rule__Operation__Group__52671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Operation__Group__62700 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation__Group__7_in_rule__Operation__Group__62710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__TypeAssignment_7_in_rule__Operation__Group__72738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__ParamsAssignment_4_0_in_rule__Operation__Group_4__02788 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_rule__Operation__Group_4__1_in_rule__Operation__Group_4__02797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group_4_1__0_in_rule__Operation__Group_4__12825 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_rule__Operation__Group_4_1__02865 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation__Group_4_1__1_in_rule__Operation__Group_4_1__02875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__ParamsAssignment_4_1_1_in_rule__Operation__Group_4_1__12903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__02941 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__02950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__12978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__03016 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__03024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__QualifiedNameWithWildCard__Group__13054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__03095 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__13131 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__QualifiedName__Group_1__03171 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__13209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractElement_in_rule__Model__ElementsAssignment3246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_13277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_13308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractElement_in_rule__PackageDeclaration__ElementsAssignment_33339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__DataType__NameAssignment_13370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_13401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Entity__SuperTypeAssignment_2_13436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_rule__Entity__FeaturesAssignment_43471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_13502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Attribute__TypeAssignment_33533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_13564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Reference__TypeAssignment_33595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__OppositeAssignment_4_13630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVisibility_in_rule__Operation__VisibilityAssignment_03665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Operation__NameAssignment_23696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__Operation__ParamsAssignment_4_03727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__Operation__ParamsAssignment_4_1_13758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Operation__TypeAssignment_73789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_03820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Parameter__TypeAssignment_13851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRef__ReferencedAssignment3886 = new BitSet(new long[]{0x0000000000000002L});
    }


}
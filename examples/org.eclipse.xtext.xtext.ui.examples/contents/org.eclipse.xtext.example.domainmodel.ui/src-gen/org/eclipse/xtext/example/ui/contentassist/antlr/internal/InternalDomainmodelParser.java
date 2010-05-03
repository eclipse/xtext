package org.eclipse.xtext.example.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
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
            ruleMemo = new HashMap[172+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g"; }


     
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:62:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:63:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:64:1: ruleModel EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel67);
            ruleModel();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel74); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:71:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:75:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:76:1: ( ( rule__Model__ElementsAssignment )* )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:76:1: ( ( rule__Model__ElementsAssignment )* )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:77:1: ( rule__Model__ElementsAssignment )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getElementsAssignment()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:78:1: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=14 && LA1_0<=15)||(LA1_0>=18 && LA1_0<=19)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:78:2: rule__Model__ElementsAssignment
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:90:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:91:1: ( ruleAbstractElement EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:92:1: ruleAbstractElement EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAbstractElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement128);
            ruleAbstractElement();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAbstractElementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractElement135); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:99:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:103:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:104:1: ( ( rule__AbstractElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:104:1: ( ( rule__AbstractElement__Alternatives ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:105:1: ( rule__AbstractElement__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:106:1: ( rule__AbstractElement__Alternatives )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:106:2: rule__AbstractElement__Alternatives
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:118:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:119:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:120:1: ruleImport EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getImportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport188);
            ruleImport();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getImportRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport195); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:127:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:131:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:132:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:132:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:133:1: ( rule__Import__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getImportAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:134:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:134:2: rule__Import__Group__0
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:146:1: entryRulePackageDeclaration : rulePackageDeclaration EOF ;
    public final void entryRulePackageDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:147:1: ( rulePackageDeclaration EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:148:1: rulePackageDeclaration EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration248);
            rulePackageDeclaration();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDeclaration255); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:155:1: rulePackageDeclaration : ( ( rule__PackageDeclaration__Group__0 ) ) ;
    public final void rulePackageDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:159:2: ( ( ( rule__PackageDeclaration__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:160:1: ( ( rule__PackageDeclaration__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:160:1: ( ( rule__PackageDeclaration__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:161:1: ( rule__PackageDeclaration__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:162:1: ( rule__PackageDeclaration__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:162:2: rule__PackageDeclaration__Group__0
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:174:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:175:1: ( ruleType EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:176:1: ruleType EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType308);
            ruleType();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType315); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:183:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:187:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:188:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:188:1: ( ( rule__Type__Alternatives ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:189:1: ( rule__Type__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:190:1: ( rule__Type__Alternatives )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:190:2: rule__Type__Alternatives
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:202:1: entryRuleDataType : ruleDataType EOF ;
    public final void entryRuleDataType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:203:1: ( ruleDataType EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:204:1: ruleDataType EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDataTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataType_in_entryRuleDataType368);
            ruleDataType();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getDataTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataType375); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:211:1: ruleDataType : ( ( rule__DataType__Group__0 ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:215:2: ( ( ( rule__DataType__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:216:1: ( ( rule__DataType__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:216:1: ( ( rule__DataType__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:217:1: ( rule__DataType__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDataTypeAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:218:1: ( rule__DataType__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:218:2: rule__DataType__Group__0
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:230:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:231:1: ( ruleEntity EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:232:1: ruleEntity EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEntity_in_entryRuleEntity428);
            ruleEntity();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntity435); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:239:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:243:2: ( ( ( rule__Entity__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:244:1: ( ( rule__Entity__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:244:1: ( ( rule__Entity__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:245:1: ( rule__Entity__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:246:1: ( rule__Entity__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:246:2: rule__Entity__Group__0
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:258:1: entryRuleFeature : ruleFeature EOF ;
    public final void entryRuleFeature() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:259:1: ( ruleFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:260:1: ruleFeature EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature488);
            ruleFeature();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getFeatureRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature495); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:267:1: ruleFeature : ( ( rule__Feature__Alternatives ) ) ;
    public final void ruleFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:271:2: ( ( ( rule__Feature__Alternatives ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:272:1: ( ( rule__Feature__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:272:1: ( ( rule__Feature__Alternatives ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:273:1: ( rule__Feature__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFeatureAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:274:1: ( rule__Feature__Alternatives )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:274:2: rule__Feature__Alternatives
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:286:1: entryRuleStructuralFeature : ruleStructuralFeature EOF ;
    public final void entryRuleStructuralFeature() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:287:1: ( ruleStructuralFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:288:1: ruleStructuralFeature EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStructuralFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature548);
            ruleStructuralFeature();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getStructuralFeatureRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStructuralFeature555); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:295:1: ruleStructuralFeature : ( ( rule__StructuralFeature__Alternatives ) ) ;
    public final void ruleStructuralFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:299:2: ( ( ( rule__StructuralFeature__Alternatives ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:300:1: ( ( rule__StructuralFeature__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:300:1: ( ( rule__StructuralFeature__Alternatives ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:301:1: ( rule__StructuralFeature__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStructuralFeatureAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:302:1: ( rule__StructuralFeature__Alternatives )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:302:2: rule__StructuralFeature__Alternatives
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:314:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:315:1: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:316:1: ruleAttribute EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute608);
            ruleAttribute();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute615); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:323:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:327:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:328:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:328:1: ( ( rule__Attribute__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:329:1: ( rule__Attribute__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:330:1: ( rule__Attribute__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:330:2: rule__Attribute__Group__0
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:342:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:343:1: ( ruleReference EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:344:1: ruleReference EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference668);
            ruleReference();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference675); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:351:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:355:2: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:356:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:356:1: ( ( rule__Reference__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:357:1: ( rule__Reference__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:358:1: ( rule__Reference__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:358:2: rule__Reference__Group__0
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:370:1: entryRuleOperation : ruleOperation EOF ;
    public final void entryRuleOperation() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:371:1: ( ruleOperation EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:372:1: ruleOperation EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOperation_in_entryRuleOperation728);
            ruleOperation();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation735); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:379:1: ruleOperation : ( ( rule__Operation__Group__0 ) ) ;
    public final void ruleOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:383:2: ( ( ( rule__Operation__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:384:1: ( ( rule__Operation__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:384:1: ( ( rule__Operation__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:385:1: ( rule__Operation__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:386:1: ( rule__Operation__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:386:2: rule__Operation__Group__0
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:398:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:399:1: ( ruleParameter EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:400:1: ruleParameter EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter788);
            ruleParameter();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParameterRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter795); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:407:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:411:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:412:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:412:1: ( ( rule__Parameter__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:413:1: ( rule__Parameter__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:414:1: ( rule__Parameter__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:414:2: rule__Parameter__Group__0
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:428:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:429:1: ( ruleTypeRef EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:430:1: ruleTypeRef EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef850);
            ruleTypeRef();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getTypeRefRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRef857); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:437:1: ruleTypeRef : ( ( rule__TypeRef__ReferencedAssignment ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:441:2: ( ( ( rule__TypeRef__ReferencedAssignment ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:442:1: ( ( rule__TypeRef__ReferencedAssignment ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:442:1: ( ( rule__TypeRef__ReferencedAssignment ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:443:1: ( rule__TypeRef__ReferencedAssignment )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getReferencedAssignment()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:444:1: ( rule__TypeRef__ReferencedAssignment )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:444:2: rule__TypeRef__ReferencedAssignment
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:456:1: entryRuleQualifiedNameWithWildCard : ruleQualifiedNameWithWildCard EOF ;
    public final void entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:457:1: ( ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:458:1: ruleQualifiedNameWithWildCard EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard910);
            ruleQualifiedNameWithWildCard();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard917); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:465:1: ruleQualifiedNameWithWildCard : ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildCard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:469:2: ( ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:470:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:470:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:471:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:472:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:472:2: rule__QualifiedNameWithWildCard__Group__0
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:484:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:485:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:486:1: ruleQualifiedName EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName970);
            ruleQualifiedName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName977); if (failed) return ;

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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:493:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:497:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:498:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:498:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:499:1: ( rule__QualifiedName__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:500:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:500:2: rule__QualifiedName__Group__0
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:513:1: ruleVisibility : ( ( rule__Visibility__Alternatives ) ) ;
    public final void ruleVisibility() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:517:1: ( ( ( rule__Visibility__Alternatives ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:518:1: ( ( rule__Visibility__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:518:1: ( ( rule__Visibility__Alternatives ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:519:1: ( rule__Visibility__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getVisibilityAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:520:1: ( rule__Visibility__Alternatives )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:520:2: rule__Visibility__Alternatives
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:531:1: rule__AbstractElement__Alternatives : ( ( rulePackageDeclaration ) | ( ruleType ) | ( ruleImport ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:535:1: ( ( rulePackageDeclaration ) | ( ruleType ) | ( ruleImport ) )
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
                    new NoViableAltException("531:1: rule__AbstractElement__Alternatives : ( ( rulePackageDeclaration ) | ( ruleType ) | ( ruleImport ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:536:1: ( rulePackageDeclaration )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:536:1: ( rulePackageDeclaration )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:537:1: rulePackageDeclaration
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
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:542:6: ( ruleType )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:542:6: ( ruleType )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:543:1: ruleType
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
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:548:6: ( ruleImport )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:548:6: ( ruleImport )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:549:1: ruleImport
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:559:1: rule__Type__Alternatives : ( ( ruleEntity ) | ( ruleDataType ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:563:1: ( ( ruleEntity ) | ( ruleDataType ) )
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
                    new NoViableAltException("559:1: rule__Type__Alternatives : ( ( ruleEntity ) | ( ruleDataType ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:564:1: ( ruleEntity )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:564:1: ( ruleEntity )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:565:1: ruleEntity
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
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:570:6: ( ruleDataType )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:570:6: ( ruleDataType )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:571:1: ruleDataType
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:581:1: rule__Feature__Alternatives : ( ( ruleStructuralFeature ) | ( ruleOperation ) );
    public final void rule__Feature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:585:1: ( ( ruleStructuralFeature ) | ( ruleOperation ) )
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
                    new NoViableAltException("581:1: rule__Feature__Alternatives : ( ( ruleStructuralFeature ) | ( ruleOperation ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:586:1: ( ruleStructuralFeature )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:586:1: ( ruleStructuralFeature )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:587:1: ruleStructuralFeature
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
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:592:6: ( ruleOperation )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:592:6: ( ruleOperation )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:593:1: ruleOperation
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:603:1: rule__StructuralFeature__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );
    public final void rule__StructuralFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:607:1: ( ( ruleAttribute ) | ( ruleReference ) )
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
                    new NoViableAltException("603:1: rule__StructuralFeature__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:608:1: ( ruleAttribute )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:608:1: ( ruleAttribute )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:609:1: ruleAttribute
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
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:614:6: ( ruleReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:614:6: ( ruleReference )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:615:1: ruleReference
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:626:1: rule__Visibility__Alternatives : ( ( ( 'public' ) ) | ( ( 'private' ) ) | ( ( 'protected' ) ) );
    public final void rule__Visibility__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:630:1: ( ( ( 'public' ) ) | ( ( 'private' ) ) | ( ( 'protected' ) ) )
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
                    new NoViableAltException("626:1: rule__Visibility__Alternatives : ( ( ( 'public' ) ) | ( ( 'private' ) ) | ( ( 'protected' ) ) );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:631:1: ( ( 'public' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:631:1: ( ( 'public' ) )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:632:1: ( 'public' )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getVisibilityAccess().getPublicEnumLiteralDeclaration_0()); 
                    }
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:633:1: ( 'public' )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:633:3: 'public'
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
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:638:6: ( ( 'private' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:638:6: ( ( 'private' ) )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:639:1: ( 'private' )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getVisibilityAccess().getPrivateEnumLiteralDeclaration_1()); 
                    }
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:640:1: ( 'private' )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:640:3: 'private'
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
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:645:6: ( ( 'protected' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:645:6: ( ( 'protected' ) )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:646:1: ( 'protected' )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getVisibilityAccess().getProtectedEnumLiteralDeclaration_2()); 
                    }
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:647:1: ( 'protected' )
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:647:3: 'protected'
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:659:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:663:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:664:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__01365);
            rule__Import__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__01368);
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


    // $ANTLR start rule__Import__Group__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:671:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:675:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:676:1: ( 'import' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:676:1: ( 'import' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:677:1: 'import'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Import__Group__0__Impl1396); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getImportAccess().getImportKeyword_0()); 
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
    // $ANTLR end rule__Import__Group__0__Impl


    // $ANTLR start rule__Import__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:690:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:694:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:695:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__11427);
            rule__Import__Group__1__Impl();
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
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__Import__Group__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:701:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:705:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:706:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:706:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:707:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:708:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:708:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl1454);
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
    // $ANTLR end rule__Import__Group__1__Impl


    // $ANTLR start rule__PackageDeclaration__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:722:1: rule__PackageDeclaration__Group__0 : rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:726:1: ( rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:727:2: rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__01488);
            rule__PackageDeclaration__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__01491);
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


    // $ANTLR start rule__PackageDeclaration__Group__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:734:1: rule__PackageDeclaration__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:738:1: ( ( 'package' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:739:1: ( 'package' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:739:1: ( 'package' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:740:1: 'package'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__PackageDeclaration__Group__0__Impl1519); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
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
    // $ANTLR end rule__PackageDeclaration__Group__0__Impl


    // $ANTLR start rule__PackageDeclaration__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:753:1: rule__PackageDeclaration__Group__1 : rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:757:1: ( rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:758:2: rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__11550);
            rule__PackageDeclaration__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__11553);
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


    // $ANTLR start rule__PackageDeclaration__Group__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:765:1: rule__PackageDeclaration__Group__1__Impl : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) ;
    public final void rule__PackageDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:769:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:770:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:770:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:771:1: ( rule__PackageDeclaration__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:772:1: ( rule__PackageDeclaration__NameAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:772:2: rule__PackageDeclaration__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl1580);
            rule__PackageDeclaration__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
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
    // $ANTLR end rule__PackageDeclaration__Group__1__Impl


    // $ANTLR start rule__PackageDeclaration__Group__2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:782:1: rule__PackageDeclaration__Group__2 : rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 ;
    public final void rule__PackageDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:786:1: ( rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:787:2: rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__2__Impl_in_rule__PackageDeclaration__Group__21610);
            rule__PackageDeclaration__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__3_in_rule__PackageDeclaration__Group__21613);
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


    // $ANTLR start rule__PackageDeclaration__Group__2__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:794:1: rule__PackageDeclaration__Group__2__Impl : ( '{' ) ;
    public final void rule__PackageDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:798:1: ( ( '{' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:799:1: ( '{' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:799:1: ( '{' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:800:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__PackageDeclaration__Group__2__Impl1641); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2()); 
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
    // $ANTLR end rule__PackageDeclaration__Group__2__Impl


    // $ANTLR start rule__PackageDeclaration__Group__3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:813:1: rule__PackageDeclaration__Group__3 : rule__PackageDeclaration__Group__3__Impl rule__PackageDeclaration__Group__4 ;
    public final void rule__PackageDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:817:1: ( rule__PackageDeclaration__Group__3__Impl rule__PackageDeclaration__Group__4 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:818:2: rule__PackageDeclaration__Group__3__Impl rule__PackageDeclaration__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__3__Impl_in_rule__PackageDeclaration__Group__31672);
            rule__PackageDeclaration__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__4_in_rule__PackageDeclaration__Group__31675);
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


    // $ANTLR start rule__PackageDeclaration__Group__3__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:825:1: rule__PackageDeclaration__Group__3__Impl : ( ( rule__PackageDeclaration__ElementsAssignment_3 )* ) ;
    public final void rule__PackageDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:829:1: ( ( ( rule__PackageDeclaration__ElementsAssignment_3 )* ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:830:1: ( ( rule__PackageDeclaration__ElementsAssignment_3 )* )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:830:1: ( ( rule__PackageDeclaration__ElementsAssignment_3 )* )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:831:1: ( rule__PackageDeclaration__ElementsAssignment_3 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getElementsAssignment_3()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:832:1: ( rule__PackageDeclaration__ElementsAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=14 && LA7_0<=15)||(LA7_0>=18 && LA7_0<=19)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:832:2: rule__PackageDeclaration__ElementsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__ElementsAssignment_3_in_rule__PackageDeclaration__Group__3__Impl1702);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDeclaration__Group__3__Impl


    // $ANTLR start rule__PackageDeclaration__Group__4
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:842:1: rule__PackageDeclaration__Group__4 : rule__PackageDeclaration__Group__4__Impl ;
    public final void rule__PackageDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:846:1: ( rule__PackageDeclaration__Group__4__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:847:2: rule__PackageDeclaration__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDeclaration__Group__4__Impl_in_rule__PackageDeclaration__Group__41733);
            rule__PackageDeclaration__Group__4__Impl();
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
    // $ANTLR end rule__PackageDeclaration__Group__4


    // $ANTLR start rule__PackageDeclaration__Group__4__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:853:1: rule__PackageDeclaration__Group__4__Impl : ( '}' ) ;
    public final void rule__PackageDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:857:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:858:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:858:1: ( '}' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:859:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__PackageDeclaration__Group__4__Impl1761); if (failed) return ;
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
    // $ANTLR end rule__PackageDeclaration__Group__4__Impl


    // $ANTLR start rule__DataType__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:882:1: rule__DataType__Group__0 : rule__DataType__Group__0__Impl rule__DataType__Group__1 ;
    public final void rule__DataType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:886:1: ( rule__DataType__Group__0__Impl rule__DataType__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:887:2: rule__DataType__Group__0__Impl rule__DataType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DataType__Group__0__Impl_in_rule__DataType__Group__01802);
            rule__DataType__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DataType__Group__1_in_rule__DataType__Group__01805);
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


    // $ANTLR start rule__DataType__Group__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:894:1: rule__DataType__Group__0__Impl : ( 'datatype' ) ;
    public final void rule__DataType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:898:1: ( ( 'datatype' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:899:1: ( 'datatype' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:899:1: ( 'datatype' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:900:1: 'datatype'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDataTypeAccess().getDatatypeKeyword_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__DataType__Group__0__Impl1833); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getDataTypeAccess().getDatatypeKeyword_0()); 
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
    // $ANTLR end rule__DataType__Group__0__Impl


    // $ANTLR start rule__DataType__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:913:1: rule__DataType__Group__1 : rule__DataType__Group__1__Impl ;
    public final void rule__DataType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:917:1: ( rule__DataType__Group__1__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:918:2: rule__DataType__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__DataType__Group__1__Impl_in_rule__DataType__Group__11864);
            rule__DataType__Group__1__Impl();
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
    // $ANTLR end rule__DataType__Group__1


    // $ANTLR start rule__DataType__Group__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:924:1: rule__DataType__Group__1__Impl : ( ( rule__DataType__NameAssignment_1 ) ) ;
    public final void rule__DataType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:928:1: ( ( ( rule__DataType__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:929:1: ( ( rule__DataType__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:929:1: ( ( rule__DataType__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:930:1: ( rule__DataType__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDataTypeAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:931:1: ( rule__DataType__NameAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:931:2: rule__DataType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DataType__NameAssignment_1_in_rule__DataType__Group__1__Impl1891);
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
    // $ANTLR end rule__DataType__Group__1__Impl


    // $ANTLR start rule__Entity__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:945:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:949:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:950:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__0__Impl_in_rule__Entity__Group__01925);
            rule__Entity__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__01928);
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


    // $ANTLR start rule__Entity__Group__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:957:1: rule__Entity__Group__0__Impl : ( 'entity' ) ;
    public final void rule__Entity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:961:1: ( ( 'entity' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:962:1: ( 'entity' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:962:1: ( 'entity' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:963:1: 'entity'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Entity__Group__0__Impl1956); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
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
    // $ANTLR end rule__Entity__Group__0__Impl


    // $ANTLR start rule__Entity__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:976:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:980:1: ( rule__Entity__Group__1__Impl rule__Entity__Group__2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:981:2: rule__Entity__Group__1__Impl rule__Entity__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__1__Impl_in_rule__Entity__Group__11987);
            rule__Entity__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__11990);
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


    // $ANTLR start rule__Entity__Group__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:988:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__NameAssignment_1 ) ) ;
    public final void rule__Entity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:992:1: ( ( ( rule__Entity__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:993:1: ( ( rule__Entity__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:993:1: ( ( rule__Entity__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:994:1: ( rule__Entity__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:995:1: ( rule__Entity__NameAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:995:2: rule__Entity__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1__Impl2017);
            rule__Entity__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getNameAssignment_1()); 
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
    // $ANTLR end rule__Entity__Group__1__Impl


    // $ANTLR start rule__Entity__Group__2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1005:1: rule__Entity__Group__2 : rule__Entity__Group__2__Impl rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1009:1: ( rule__Entity__Group__2__Impl rule__Entity__Group__3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1010:2: rule__Entity__Group__2__Impl rule__Entity__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__2__Impl_in_rule__Entity__Group__22047);
            rule__Entity__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__22050);
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


    // $ANTLR start rule__Entity__Group__2__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1017:1: rule__Entity__Group__2__Impl : ( ( rule__Entity__Group_2__0 )? ) ;
    public final void rule__Entity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1021:1: ( ( ( rule__Entity__Group_2__0 )? ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1022:1: ( ( rule__Entity__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1022:1: ( ( rule__Entity__Group_2__0 )? )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1023:1: ( rule__Entity__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getGroup_2()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1024:1: ( rule__Entity__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1024:2: rule__Entity__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__2__Impl2077);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__2__Impl


    // $ANTLR start rule__Entity__Group__3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1034:1: rule__Entity__Group__3 : rule__Entity__Group__3__Impl rule__Entity__Group__4 ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1038:1: ( rule__Entity__Group__3__Impl rule__Entity__Group__4 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1039:2: rule__Entity__Group__3__Impl rule__Entity__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__3__Impl_in_rule__Entity__Group__32108);
            rule__Entity__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__32111);
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


    // $ANTLR start rule__Entity__Group__3__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1046:1: rule__Entity__Group__3__Impl : ( '{' ) ;
    public final void rule__Entity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1050:1: ( ( '{' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1051:1: ( '{' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1051:1: ( '{' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1052:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Entity__Group__3__Impl2139); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end rule__Entity__Group__3__Impl


    // $ANTLR start rule__Entity__Group__4
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1065:1: rule__Entity__Group__4 : rule__Entity__Group__4__Impl rule__Entity__Group__5 ;
    public final void rule__Entity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1069:1: ( rule__Entity__Group__4__Impl rule__Entity__Group__5 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1070:2: rule__Entity__Group__4__Impl rule__Entity__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__4__Impl_in_rule__Entity__Group__42170);
            rule__Entity__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__42173);
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


    // $ANTLR start rule__Entity__Group__4__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1077:1: rule__Entity__Group__4__Impl : ( ( rule__Entity__FeaturesAssignment_4 )* ) ;
    public final void rule__Entity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1081:1: ( ( ( rule__Entity__FeaturesAssignment_4 )* ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1082:1: ( ( rule__Entity__FeaturesAssignment_4 )* )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1082:1: ( ( rule__Entity__FeaturesAssignment_4 )* )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1083:1: ( rule__Entity__FeaturesAssignment_4 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getFeaturesAssignment_4()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1084:1: ( rule__Entity__FeaturesAssignment_4 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=11 && LA9_0<=13)||LA9_0==21||LA9_0==23||LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1084:2: rule__Entity__FeaturesAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Entity__FeaturesAssignment_4_in_rule__Entity__Group__4__Impl2200);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__4__Impl


    // $ANTLR start rule__Entity__Group__5
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1094:1: rule__Entity__Group__5 : rule__Entity__Group__5__Impl ;
    public final void rule__Entity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1098:1: ( rule__Entity__Group__5__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1099:2: rule__Entity__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group__5__Impl_in_rule__Entity__Group__52231);
            rule__Entity__Group__5__Impl();
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
    // $ANTLR end rule__Entity__Group__5


    // $ANTLR start rule__Entity__Group__5__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1105:1: rule__Entity__Group__5__Impl : ( '}' ) ;
    public final void rule__Entity__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1109:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1110:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1110:1: ( '}' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1111:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Entity__Group__5__Impl2259); if (failed) return ;
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
    // $ANTLR end rule__Entity__Group__5__Impl


    // $ANTLR start rule__Entity__Group_2__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1136:1: rule__Entity__Group_2__0 : rule__Entity__Group_2__0__Impl rule__Entity__Group_2__1 ;
    public final void rule__Entity__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1140:1: ( rule__Entity__Group_2__0__Impl rule__Entity__Group_2__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1141:2: rule__Entity__Group_2__0__Impl rule__Entity__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group_2__0__Impl_in_rule__Entity__Group_2__02302);
            rule__Entity__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__02305);
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


    // $ANTLR start rule__Entity__Group_2__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1148:1: rule__Entity__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__Entity__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1152:1: ( ( 'extends' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1153:1: ( 'extends' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1153:1: ( 'extends' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1154:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Entity__Group_2__0__Impl2333); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 
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
    // $ANTLR end rule__Entity__Group_2__0__Impl


    // $ANTLR start rule__Entity__Group_2__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1167:1: rule__Entity__Group_2__1 : rule__Entity__Group_2__1__Impl ;
    public final void rule__Entity__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1171:1: ( rule__Entity__Group_2__1__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1172:2: rule__Entity__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__Group_2__1__Impl_in_rule__Entity__Group_2__12364);
            rule__Entity__Group_2__1__Impl();
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
    // $ANTLR end rule__Entity__Group_2__1


    // $ANTLR start rule__Entity__Group_2__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1178:1: rule__Entity__Group_2__1__Impl : ( ( rule__Entity__SuperTypeAssignment_2_1 ) ) ;
    public final void rule__Entity__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1182:1: ( ( ( rule__Entity__SuperTypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1183:1: ( ( rule__Entity__SuperTypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1183:1: ( ( rule__Entity__SuperTypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1184:1: ( rule__Entity__SuperTypeAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getSuperTypeAssignment_2_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1185:1: ( rule__Entity__SuperTypeAssignment_2_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1185:2: rule__Entity__SuperTypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Entity__SuperTypeAssignment_2_1_in_rule__Entity__Group_2__1__Impl2391);
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
    // $ANTLR end rule__Entity__Group_2__1__Impl


    // $ANTLR start rule__Attribute__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1199:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1203:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1204:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__02425);
            rule__Attribute__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__02428);
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


    // $ANTLR start rule__Attribute__Group__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1211:1: rule__Attribute__Group__0__Impl : ( 'attr' ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1215:1: ( ( 'attr' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1216:1: ( 'attr' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1216:1: ( 'attr' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1217:1: 'attr'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getAttrKeyword_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Attribute__Group__0__Impl2456); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getAttrKeyword_0()); 
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
    // $ANTLR end rule__Attribute__Group__0__Impl


    // $ANTLR start rule__Attribute__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1230:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1234:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1235:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__12487);
            rule__Attribute__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__12490);
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


    // $ANTLR start rule__Attribute__Group__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1242:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__NameAssignment_1 ) ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1246:1: ( ( ( rule__Attribute__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1247:1: ( ( rule__Attribute__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1247:1: ( ( rule__Attribute__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1248:1: ( rule__Attribute__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1249:1: ( rule__Attribute__NameAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1249:2: rule__Attribute__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__NameAssignment_1_in_rule__Attribute__Group__1__Impl2517);
            rule__Attribute__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getNameAssignment_1()); 
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
    // $ANTLR end rule__Attribute__Group__1__Impl


    // $ANTLR start rule__Attribute__Group__2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1259:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1263:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1264:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__22547);
            rule__Attribute__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__3_in_rule__Attribute__Group__22550);
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


    // $ANTLR start rule__Attribute__Group__2__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1271:1: rule__Attribute__Group__2__Impl : ( ':' ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1275:1: ( ( ':' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1276:1: ( ':' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1276:1: ( ':' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1277:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getColonKeyword_2()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Attribute__Group__2__Impl2578); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getColonKeyword_2()); 
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
    // $ANTLR end rule__Attribute__Group__2__Impl


    // $ANTLR start rule__Attribute__Group__3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1290:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1294:1: ( rule__Attribute__Group__3__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1295:2: rule__Attribute__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__3__Impl_in_rule__Attribute__Group__32609);
            rule__Attribute__Group__3__Impl();
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
    // $ANTLR end rule__Attribute__Group__3


    // $ANTLR start rule__Attribute__Group__3__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1301:1: rule__Attribute__Group__3__Impl : ( ( rule__Attribute__TypeAssignment_3 ) ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1305:1: ( ( ( rule__Attribute__TypeAssignment_3 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1306:1: ( ( rule__Attribute__TypeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1306:1: ( ( rule__Attribute__TypeAssignment_3 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1307:1: ( rule__Attribute__TypeAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getTypeAssignment_3()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1308:1: ( rule__Attribute__TypeAssignment_3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1308:2: rule__Attribute__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__TypeAssignment_3_in_rule__Attribute__Group__3__Impl2636);
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
    // $ANTLR end rule__Attribute__Group__3__Impl


    // $ANTLR start rule__Reference__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1326:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1330:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1331:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__02674);
            rule__Reference__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__02677);
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


    // $ANTLR start rule__Reference__Group__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1338:1: rule__Reference__Group__0__Impl : ( 'ref' ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1342:1: ( ( 'ref' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1343:1: ( 'ref' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1343:1: ( 'ref' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1344:1: 'ref'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Reference__Group__0__Impl2705); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
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
    // $ANTLR end rule__Reference__Group__0__Impl


    // $ANTLR start rule__Reference__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1357:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1361:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1362:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__12736);
            rule__Reference__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__12739);
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


    // $ANTLR start rule__Reference__Group__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1369:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__NameAssignment_1 ) ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1373:1: ( ( ( rule__Reference__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1374:1: ( ( rule__Reference__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1374:1: ( ( rule__Reference__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1375:1: ( rule__Reference__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1376:1: ( rule__Reference__NameAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1376:2: rule__Reference__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__NameAssignment_1_in_rule__Reference__Group__1__Impl2766);
            rule__Reference__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getNameAssignment_1()); 
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
    // $ANTLR end rule__Reference__Group__1__Impl


    // $ANTLR start rule__Reference__Group__2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1386:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1390:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1391:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__22796);
            rule__Reference__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__22799);
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


    // $ANTLR start rule__Reference__Group__2__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1398:1: rule__Reference__Group__2__Impl : ( ':' ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1402:1: ( ( ':' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1403:1: ( ':' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1403:1: ( ':' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1404:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getColonKeyword_2()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Reference__Group__2__Impl2827); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getColonKeyword_2()); 
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
    // $ANTLR end rule__Reference__Group__2__Impl


    // $ANTLR start rule__Reference__Group__3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1417:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1421:1: ( rule__Reference__Group__3__Impl rule__Reference__Group__4 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1422:2: rule__Reference__Group__3__Impl rule__Reference__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__32858);
            rule__Reference__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__32861);
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


    // $ANTLR start rule__Reference__Group__3__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1429:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__TypeAssignment_3 ) ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1433:1: ( ( ( rule__Reference__TypeAssignment_3 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1434:1: ( ( rule__Reference__TypeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1434:1: ( ( rule__Reference__TypeAssignment_3 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1435:1: ( rule__Reference__TypeAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1436:1: ( rule__Reference__TypeAssignment_3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1436:2: rule__Reference__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__TypeAssignment_3_in_rule__Reference__Group__3__Impl2888);
            rule__Reference__TypeAssignment_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 
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
    // $ANTLR end rule__Reference__Group__3__Impl


    // $ANTLR start rule__Reference__Group__4
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1446:1: rule__Reference__Group__4 : rule__Reference__Group__4__Impl ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1450:1: ( rule__Reference__Group__4__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1451:2: rule__Reference__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__42918);
            rule__Reference__Group__4__Impl();
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
    // $ANTLR end rule__Reference__Group__4


    // $ANTLR start rule__Reference__Group__4__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1457:1: rule__Reference__Group__4__Impl : ( ( rule__Reference__Group_4__0 )? ) ;
    public final void rule__Reference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1461:1: ( ( ( rule__Reference__Group_4__0 )? ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1462:1: ( ( rule__Reference__Group_4__0 )? )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1462:1: ( ( rule__Reference__Group_4__0 )? )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1463:1: ( rule__Reference__Group_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getGroup_4()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1464:1: ( rule__Reference__Group_4__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1464:2: rule__Reference__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4__0_in_rule__Reference__Group__4__Impl2945);
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
    // $ANTLR end rule__Reference__Group__4__Impl


    // $ANTLR start rule__Reference__Group_4__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1484:1: rule__Reference__Group_4__0 : rule__Reference__Group_4__0__Impl rule__Reference__Group_4__1 ;
    public final void rule__Reference__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1488:1: ( rule__Reference__Group_4__0__Impl rule__Reference__Group_4__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1489:2: rule__Reference__Group_4__0__Impl rule__Reference__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4__0__Impl_in_rule__Reference__Group_4__02986);
            rule__Reference__Group_4__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4__1_in_rule__Reference__Group_4__02989);
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


    // $ANTLR start rule__Reference__Group_4__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1496:1: rule__Reference__Group_4__0__Impl : ( 'opposite' ) ;
    public final void rule__Reference__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1500:1: ( ( 'opposite' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1501:1: ( 'opposite' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1501:1: ( 'opposite' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1502:1: 'opposite'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getOppositeKeyword_4_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Reference__Group_4__0__Impl3017); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getOppositeKeyword_4_0()); 
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
    // $ANTLR end rule__Reference__Group_4__0__Impl


    // $ANTLR start rule__Reference__Group_4__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1515:1: rule__Reference__Group_4__1 : rule__Reference__Group_4__1__Impl ;
    public final void rule__Reference__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1519:1: ( rule__Reference__Group_4__1__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1520:2: rule__Reference__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4__1__Impl_in_rule__Reference__Group_4__13048);
            rule__Reference__Group_4__1__Impl();
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
    // $ANTLR end rule__Reference__Group_4__1


    // $ANTLR start rule__Reference__Group_4__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1526:1: rule__Reference__Group_4__1__Impl : ( ( rule__Reference__OppositeAssignment_4_1 ) ) ;
    public final void rule__Reference__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1530:1: ( ( ( rule__Reference__OppositeAssignment_4_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1531:1: ( ( rule__Reference__OppositeAssignment_4_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1531:1: ( ( rule__Reference__OppositeAssignment_4_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1532:1: ( rule__Reference__OppositeAssignment_4_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getOppositeAssignment_4_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1533:1: ( rule__Reference__OppositeAssignment_4_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1533:2: rule__Reference__OppositeAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__OppositeAssignment_4_1_in_rule__Reference__Group_4__1__Impl3075);
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
    // $ANTLR end rule__Reference__Group_4__1__Impl


    // $ANTLR start rule__Operation__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1547:1: rule__Operation__Group__0 : rule__Operation__Group__0__Impl rule__Operation__Group__1 ;
    public final void rule__Operation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1551:1: ( rule__Operation__Group__0__Impl rule__Operation__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1552:2: rule__Operation__Group__0__Impl rule__Operation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__0__Impl_in_rule__Operation__Group__03109);
            rule__Operation__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__1_in_rule__Operation__Group__03112);
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


    // $ANTLR start rule__Operation__Group__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1559:1: rule__Operation__Group__0__Impl : ( ( rule__Operation__VisibilityAssignment_0 )? ) ;
    public final void rule__Operation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1563:1: ( ( ( rule__Operation__VisibilityAssignment_0 )? ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1564:1: ( ( rule__Operation__VisibilityAssignment_0 )? )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1564:1: ( ( rule__Operation__VisibilityAssignment_0 )? )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1565:1: ( rule__Operation__VisibilityAssignment_0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getVisibilityAssignment_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1566:1: ( rule__Operation__VisibilityAssignment_0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=11 && LA11_0<=13)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1566:2: rule__Operation__VisibilityAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Operation__VisibilityAssignment_0_in_rule__Operation__Group__0__Impl3139);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__0__Impl


    // $ANTLR start rule__Operation__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1576:1: rule__Operation__Group__1 : rule__Operation__Group__1__Impl rule__Operation__Group__2 ;
    public final void rule__Operation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1580:1: ( rule__Operation__Group__1__Impl rule__Operation__Group__2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1581:2: rule__Operation__Group__1__Impl rule__Operation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__1__Impl_in_rule__Operation__Group__13170);
            rule__Operation__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__2_in_rule__Operation__Group__13173);
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


    // $ANTLR start rule__Operation__Group__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1588:1: rule__Operation__Group__1__Impl : ( 'op' ) ;
    public final void rule__Operation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1592:1: ( ( 'op' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1593:1: ( 'op' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1593:1: ( 'op' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1594:1: 'op'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getOpKeyword_1()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Operation__Group__1__Impl3201); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getOpKeyword_1()); 
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
    // $ANTLR end rule__Operation__Group__1__Impl


    // $ANTLR start rule__Operation__Group__2
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1607:1: rule__Operation__Group__2 : rule__Operation__Group__2__Impl rule__Operation__Group__3 ;
    public final void rule__Operation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1611:1: ( rule__Operation__Group__2__Impl rule__Operation__Group__3 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1612:2: rule__Operation__Group__2__Impl rule__Operation__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__2__Impl_in_rule__Operation__Group__23232);
            rule__Operation__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__3_in_rule__Operation__Group__23235);
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


    // $ANTLR start rule__Operation__Group__2__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1619:1: rule__Operation__Group__2__Impl : ( ( rule__Operation__NameAssignment_2 ) ) ;
    public final void rule__Operation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1623:1: ( ( ( rule__Operation__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1624:1: ( ( rule__Operation__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1624:1: ( ( rule__Operation__NameAssignment_2 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1625:1: ( rule__Operation__NameAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1626:1: ( rule__Operation__NameAssignment_2 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1626:2: rule__Operation__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__NameAssignment_2_in_rule__Operation__Group__2__Impl3262);
            rule__Operation__NameAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getNameAssignment_2()); 
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
    // $ANTLR end rule__Operation__Group__2__Impl


    // $ANTLR start rule__Operation__Group__3
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1636:1: rule__Operation__Group__3 : rule__Operation__Group__3__Impl rule__Operation__Group__4 ;
    public final void rule__Operation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1640:1: ( rule__Operation__Group__3__Impl rule__Operation__Group__4 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1641:2: rule__Operation__Group__3__Impl rule__Operation__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__3__Impl_in_rule__Operation__Group__33292);
            rule__Operation__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__4_in_rule__Operation__Group__33295);
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


    // $ANTLR start rule__Operation__Group__3__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1648:1: rule__Operation__Group__3__Impl : ( '(' ) ;
    public final void rule__Operation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1652:1: ( ( '(' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1653:1: ( '(' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1653:1: ( '(' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1654:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Operation__Group__3__Impl3323); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3()); 
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
    // $ANTLR end rule__Operation__Group__3__Impl


    // $ANTLR start rule__Operation__Group__4
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1667:1: rule__Operation__Group__4 : rule__Operation__Group__4__Impl rule__Operation__Group__5 ;
    public final void rule__Operation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1671:1: ( rule__Operation__Group__4__Impl rule__Operation__Group__5 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1672:2: rule__Operation__Group__4__Impl rule__Operation__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__4__Impl_in_rule__Operation__Group__43354);
            rule__Operation__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__5_in_rule__Operation__Group__43357);
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


    // $ANTLR start rule__Operation__Group__4__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1679:1: rule__Operation__Group__4__Impl : ( ( rule__Operation__Group_4__0 )? ) ;
    public final void rule__Operation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1683:1: ( ( ( rule__Operation__Group_4__0 )? ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1684:1: ( ( rule__Operation__Group_4__0 )? )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1684:1: ( ( rule__Operation__Group_4__0 )? )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1685:1: ( rule__Operation__Group_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getGroup_4()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1686:1: ( rule__Operation__Group_4__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1686:2: rule__Operation__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4__0_in_rule__Operation__Group__4__Impl3384);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Operation__Group__4__Impl


    // $ANTLR start rule__Operation__Group__5
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1696:1: rule__Operation__Group__5 : rule__Operation__Group__5__Impl rule__Operation__Group__6 ;
    public final void rule__Operation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1700:1: ( rule__Operation__Group__5__Impl rule__Operation__Group__6 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1701:2: rule__Operation__Group__5__Impl rule__Operation__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__5__Impl_in_rule__Operation__Group__53415);
            rule__Operation__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__6_in_rule__Operation__Group__53418);
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


    // $ANTLR start rule__Operation__Group__5__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1708:1: rule__Operation__Group__5__Impl : ( ')' ) ;
    public final void rule__Operation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1712:1: ( ( ')' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1713:1: ( ')' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1713:1: ( ')' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1714:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Operation__Group__5__Impl3446); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5()); 
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
    // $ANTLR end rule__Operation__Group__5__Impl


    // $ANTLR start rule__Operation__Group__6
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1727:1: rule__Operation__Group__6 : rule__Operation__Group__6__Impl rule__Operation__Group__7 ;
    public final void rule__Operation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1731:1: ( rule__Operation__Group__6__Impl rule__Operation__Group__7 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1732:2: rule__Operation__Group__6__Impl rule__Operation__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__6__Impl_in_rule__Operation__Group__63477);
            rule__Operation__Group__6__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__7_in_rule__Operation__Group__63480);
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


    // $ANTLR start rule__Operation__Group__6__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1739:1: rule__Operation__Group__6__Impl : ( ':' ) ;
    public final void rule__Operation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1743:1: ( ( ':' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1744:1: ( ':' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1744:1: ( ':' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1745:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getColonKeyword_6()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Operation__Group__6__Impl3508); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getColonKeyword_6()); 
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
    // $ANTLR end rule__Operation__Group__6__Impl


    // $ANTLR start rule__Operation__Group__7
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1758:1: rule__Operation__Group__7 : rule__Operation__Group__7__Impl ;
    public final void rule__Operation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1762:1: ( rule__Operation__Group__7__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1763:2: rule__Operation__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group__7__Impl_in_rule__Operation__Group__73539);
            rule__Operation__Group__7__Impl();
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
    // $ANTLR end rule__Operation__Group__7


    // $ANTLR start rule__Operation__Group__7__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1769:1: rule__Operation__Group__7__Impl : ( ( rule__Operation__TypeAssignment_7 ) ) ;
    public final void rule__Operation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1773:1: ( ( ( rule__Operation__TypeAssignment_7 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1774:1: ( ( rule__Operation__TypeAssignment_7 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1774:1: ( ( rule__Operation__TypeAssignment_7 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1775:1: ( rule__Operation__TypeAssignment_7 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getTypeAssignment_7()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1776:1: ( rule__Operation__TypeAssignment_7 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1776:2: rule__Operation__TypeAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__TypeAssignment_7_in_rule__Operation__Group__7__Impl3566);
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
    // $ANTLR end rule__Operation__Group__7__Impl


    // $ANTLR start rule__Operation__Group_4__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1802:1: rule__Operation__Group_4__0 : rule__Operation__Group_4__0__Impl rule__Operation__Group_4__1 ;
    public final void rule__Operation__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1806:1: ( rule__Operation__Group_4__0__Impl rule__Operation__Group_4__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1807:2: rule__Operation__Group_4__0__Impl rule__Operation__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4__0__Impl_in_rule__Operation__Group_4__03612);
            rule__Operation__Group_4__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4__1_in_rule__Operation__Group_4__03615);
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


    // $ANTLR start rule__Operation__Group_4__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1814:1: rule__Operation__Group_4__0__Impl : ( ( rule__Operation__ParamsAssignment_4_0 ) ) ;
    public final void rule__Operation__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1818:1: ( ( ( rule__Operation__ParamsAssignment_4_0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1819:1: ( ( rule__Operation__ParamsAssignment_4_0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1819:1: ( ( rule__Operation__ParamsAssignment_4_0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1820:1: ( rule__Operation__ParamsAssignment_4_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getParamsAssignment_4_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1821:1: ( rule__Operation__ParamsAssignment_4_0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1821:2: rule__Operation__ParamsAssignment_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__ParamsAssignment_4_0_in_rule__Operation__Group_4__0__Impl3642);
            rule__Operation__ParamsAssignment_4_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getParamsAssignment_4_0()); 
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
    // $ANTLR end rule__Operation__Group_4__0__Impl


    // $ANTLR start rule__Operation__Group_4__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1831:1: rule__Operation__Group_4__1 : rule__Operation__Group_4__1__Impl ;
    public final void rule__Operation__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1835:1: ( rule__Operation__Group_4__1__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1836:2: rule__Operation__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4__1__Impl_in_rule__Operation__Group_4__13672);
            rule__Operation__Group_4__1__Impl();
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
    // $ANTLR end rule__Operation__Group_4__1


    // $ANTLR start rule__Operation__Group_4__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1842:1: rule__Operation__Group_4__1__Impl : ( ( rule__Operation__Group_4_1__0 )* ) ;
    public final void rule__Operation__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1846:1: ( ( ( rule__Operation__Group_4_1__0 )* ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1847:1: ( ( rule__Operation__Group_4_1__0 )* )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1847:1: ( ( rule__Operation__Group_4_1__0 )* )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1848:1: ( rule__Operation__Group_4_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getGroup_4_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1849:1: ( rule__Operation__Group_4_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1849:2: rule__Operation__Group_4_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4_1__0_in_rule__Operation__Group_4__1__Impl3699);
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
    // $ANTLR end rule__Operation__Group_4__1__Impl


    // $ANTLR start rule__Operation__Group_4_1__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1863:1: rule__Operation__Group_4_1__0 : rule__Operation__Group_4_1__0__Impl rule__Operation__Group_4_1__1 ;
    public final void rule__Operation__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1867:1: ( rule__Operation__Group_4_1__0__Impl rule__Operation__Group_4_1__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1868:2: rule__Operation__Group_4_1__0__Impl rule__Operation__Group_4_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4_1__0__Impl_in_rule__Operation__Group_4_1__03734);
            rule__Operation__Group_4_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4_1__1_in_rule__Operation__Group_4_1__03737);
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


    // $ANTLR start rule__Operation__Group_4_1__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1875:1: rule__Operation__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__Operation__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1879:1: ( ( ',' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1880:1: ( ',' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1880:1: ( ',' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1881:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__Operation__Group_4_1__0__Impl3765); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0()); 
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
    // $ANTLR end rule__Operation__Group_4_1__0__Impl


    // $ANTLR start rule__Operation__Group_4_1__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1894:1: rule__Operation__Group_4_1__1 : rule__Operation__Group_4_1__1__Impl ;
    public final void rule__Operation__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1898:1: ( rule__Operation__Group_4_1__1__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1899:2: rule__Operation__Group_4_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__Group_4_1__1__Impl_in_rule__Operation__Group_4_1__13796);
            rule__Operation__Group_4_1__1__Impl();
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
    // $ANTLR end rule__Operation__Group_4_1__1


    // $ANTLR start rule__Operation__Group_4_1__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1905:1: rule__Operation__Group_4_1__1__Impl : ( ( rule__Operation__ParamsAssignment_4_1_1 ) ) ;
    public final void rule__Operation__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1909:1: ( ( ( rule__Operation__ParamsAssignment_4_1_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1910:1: ( ( rule__Operation__ParamsAssignment_4_1_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1910:1: ( ( rule__Operation__ParamsAssignment_4_1_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1911:1: ( rule__Operation__ParamsAssignment_4_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getParamsAssignment_4_1_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1912:1: ( rule__Operation__ParamsAssignment_4_1_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1912:2: rule__Operation__ParamsAssignment_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operation__ParamsAssignment_4_1_1_in_rule__Operation__Group_4_1__1__Impl3823);
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
    // $ANTLR end rule__Operation__Group_4_1__1__Impl


    // $ANTLR start rule__Parameter__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1926:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1930:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1931:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__03857);
            rule__Parameter__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__03860);
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


    // $ANTLR start rule__Parameter__Group__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1938:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1942:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1943:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1943:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1944:1: ( rule__Parameter__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1945:1: ( rule__Parameter__NameAssignment_0 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1945:2: rule__Parameter__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl3887);
            rule__Parameter__NameAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getNameAssignment_0()); 
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
    // $ANTLR end rule__Parameter__Group__0__Impl


    // $ANTLR start rule__Parameter__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1955:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1959:1: ( rule__Parameter__Group__1__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1960:2: rule__Parameter__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__13917);
            rule__Parameter__Group__1__Impl();
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
    // $ANTLR end rule__Parameter__Group__1


    // $ANTLR start rule__Parameter__Group__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1966:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__TypeAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1970:1: ( ( ( rule__Parameter__TypeAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1971:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1971:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1972:1: ( rule__Parameter__TypeAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeAssignment_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1973:1: ( rule__Parameter__TypeAssignment_1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1973:2: rule__Parameter__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl3944);
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
    // $ANTLR end rule__Parameter__Group__1__Impl


    // $ANTLR start rule__QualifiedNameWithWildCard__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1987:1: rule__QualifiedNameWithWildCard__Group__0 : rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 ;
    public final void rule__QualifiedNameWithWildCard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1991:1: ( rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1992:2: rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedNameWithWildCard__Group__0__Impl_in_rule__QualifiedNameWithWildCard__Group__03978);
            rule__QualifiedNameWithWildCard__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__03981);
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


    // $ANTLR start rule__QualifiedNameWithWildCard__Group__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:1999:1: rule__QualifiedNameWithWildCard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildCard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2003:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2004:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2004:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2005:1: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__0__Impl4008);
            ruleQualifiedName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
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
    // $ANTLR end rule__QualifiedNameWithWildCard__Group__0__Impl


    // $ANTLR start rule__QualifiedNameWithWildCard__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2016:1: rule__QualifiedNameWithWildCard__Group__1 : rule__QualifiedNameWithWildCard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2020:1: ( rule__QualifiedNameWithWildCard__Group__1__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2021:2: rule__QualifiedNameWithWildCard__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedNameWithWildCard__Group__1__Impl_in_rule__QualifiedNameWithWildCard__Group__14037);
            rule__QualifiedNameWithWildCard__Group__1__Impl();
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
    // $ANTLR end rule__QualifiedNameWithWildCard__Group__1


    // $ANTLR start rule__QualifiedNameWithWildCard__Group__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2027:1: rule__QualifiedNameWithWildCard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildCard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2031:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2032:1: ( ( '.*' )? )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2032:1: ( ( '.*' )? )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2033:1: ( '.*' )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2034:1: ( '.*' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==29) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2035:2: '.*'
                    {
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__QualifiedNameWithWildCard__Group__1__Impl4066); if (failed) return ;

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
    // $ANTLR end rule__QualifiedNameWithWildCard__Group__1__Impl


    // $ANTLR start rule__QualifiedName__Group__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2050:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2054:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2055:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__04103);
            rule__QualifiedName__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__04106);
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


    // $ANTLR start rule__QualifiedName__Group__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2062:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2066:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2067:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2067:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2068:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl4133); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
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
    // $ANTLR end rule__QualifiedName__Group__0__Impl


    // $ANTLR start rule__QualifiedName__Group__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2079:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2083:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2084:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__14162);
            rule__QualifiedName__Group__1__Impl();
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
    // $ANTLR end rule__QualifiedName__Group__1


    // $ANTLR start rule__QualifiedName__Group__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2090:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2094:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2095:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2095:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2096:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2097:1: ( rule__QualifiedName__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==30) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2097:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl4189);
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
    // $ANTLR end rule__QualifiedName__Group__1__Impl


    // $ANTLR start rule__QualifiedName__Group_1__0
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2111:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2115:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2116:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__04224);
            rule__QualifiedName__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__04227);
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


    // $ANTLR start rule__QualifiedName__Group_1__0__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2123:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2127:1: ( ( '.' ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2128:1: ( '.' )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2128:1: ( '.' )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2129:1: '.'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__QualifiedName__Group_1__0__Impl4255); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
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
    // $ANTLR end rule__QualifiedName__Group_1__0__Impl


    // $ANTLR start rule__QualifiedName__Group_1__1
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2142:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2146:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2147:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__14286);
            rule__QualifiedName__Group_1__1__Impl();
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
    // $ANTLR end rule__QualifiedName__Group_1__1


    // $ANTLR start rule__QualifiedName__Group_1__1__Impl
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2153:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2157:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2158:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2158:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2159:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl4313); if (failed) return ;
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
    // $ANTLR end rule__QualifiedName__Group_1__1__Impl


    // $ANTLR start rule__Model__ElementsAssignment
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2175:1: rule__Model__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2179:1: ( ( ruleAbstractElement ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2180:1: ( ruleAbstractElement )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2180:1: ( ruleAbstractElement )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2181:1: ruleAbstractElement
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstractElement_in_rule__Model__ElementsAssignment4351);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2190:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildCard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2194:1: ( ( ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2195:1: ( ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2195:1: ( ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2196:1: ruleQualifiedNameWithWildCard
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_14382);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2205:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2209:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2210:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2210:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2211:1: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_14413);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2220:1: rule__PackageDeclaration__ElementsAssignment_3 : ( ruleAbstractElement ) ;
    public final void rule__PackageDeclaration__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2224:1: ( ( ruleAbstractElement ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2225:1: ( ruleAbstractElement )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2225:1: ( ruleAbstractElement )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2226:1: ruleAbstractElement
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstractElement_in_rule__PackageDeclaration__ElementsAssignment_34444);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2235:1: rule__DataType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2239:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2240:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2240:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2241:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__DataType__NameAssignment_14475); if (failed) return ;
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2250:1: rule__Entity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2254:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2255:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2255:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2256:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_14506); if (failed) return ;
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2265:1: rule__Entity__SuperTypeAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Entity__SuperTypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2269:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2270:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2270:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2271:1: ( ruleQualifiedName )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getSuperTypeEntityCrossReference_2_1_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2272:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2273:1: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getSuperTypeEntityQualifiedNameParserRuleCall_2_1_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__Entity__SuperTypeAssignment_2_14541);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2284:1: rule__Entity__FeaturesAssignment_4 : ( ruleFeature ) ;
    public final void rule__Entity__FeaturesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2288:1: ( ( ruleFeature ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2289:1: ( ruleFeature )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2289:1: ( ruleFeature )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2290:1: ruleFeature
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getEntityAccess().getFeaturesFeatureParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_rule__Entity__FeaturesAssignment_44576);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2299:1: rule__Attribute__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2303:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2304:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2304:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2305:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_14607); if (failed) return ;
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2314:1: rule__Attribute__TypeAssignment_3 : ( ruleTypeRef ) ;
    public final void rule__Attribute__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2318:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2319:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2319:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2320:1: ruleTypeRef
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getTypeTypeRefParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Attribute__TypeAssignment_34638);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2329:1: rule__Reference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Reference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2333:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2334:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2334:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2335:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_14669); if (failed) return ;
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2344:1: rule__Reference__TypeAssignment_3 : ( ruleTypeRef ) ;
    public final void rule__Reference__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2348:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2349:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2349:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2350:1: ruleTypeRef
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getTypeTypeRefParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Reference__TypeAssignment_34700);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2359:1: rule__Reference__OppositeAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__OppositeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2363:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2364:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2364:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2365:1: ( RULE_ID )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getOppositeReferenceCrossReference_4_1_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2366:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2367:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getOppositeReferenceIDTerminalRuleCall_4_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Reference__OppositeAssignment_4_14735); if (failed) return ;
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2378:1: rule__Operation__VisibilityAssignment_0 : ( ruleVisibility ) ;
    public final void rule__Operation__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2382:1: ( ( ruleVisibility ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2383:1: ( ruleVisibility )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2383:1: ( ruleVisibility )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2384:1: ruleVisibility
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVisibility_in_rule__Operation__VisibilityAssignment_04770);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2393:1: rule__Operation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2397:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2398:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2398:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2399:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Operation__NameAssignment_24801); if (failed) return ;
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2408:1: rule__Operation__ParamsAssignment_4_0 : ( ruleParameter ) ;
    public final void rule__Operation__ParamsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2412:1: ( ( ruleParameter ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2413:1: ( ruleParameter )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2413:1: ( ruleParameter )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2414:1: ruleParameter
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__Operation__ParamsAssignment_4_04832);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2423:1: rule__Operation__ParamsAssignment_4_1_1 : ( ruleParameter ) ;
    public final void rule__Operation__ParamsAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2427:1: ( ( ruleParameter ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2428:1: ( ruleParameter )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2428:1: ( ruleParameter )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2429:1: ruleParameter
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__Operation__ParamsAssignment_4_1_14863);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2438:1: rule__Operation__TypeAssignment_7 : ( ruleTypeRef ) ;
    public final void rule__Operation__TypeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2442:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2443:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2443:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2444:1: ruleTypeRef
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOperationAccess().getTypeTypeRefParserRuleCall_7_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Operation__TypeAssignment_74894);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2453:1: rule__Parameter__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2457:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2458:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2458:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2459:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_04925); if (failed) return ;
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2468:1: rule__Parameter__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Parameter__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2472:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2473:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2473:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2474:1: ruleTypeRef
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeTypeRefParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Parameter__TypeAssignment_14956);
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
    // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2483:1: rule__TypeRef__ReferencedAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__TypeRef__ReferencedAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2487:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2488:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2488:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2489:1: ( ruleQualifiedName )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getReferencedTypeCrossReference_0()); 
            }
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2490:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/ui/contentassist/antlr/internal/InternalDomainmodel.g:2491:1: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getTypeRefAccess().getReferencedTypeQualifiedNameParserRuleCall_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rule__TypeRef__ReferencedAssignment4991);
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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ElementsAssignment_in_ruleModel100 = new BitSet(new long[]{0x00000000000CC002L});
        public static final BitSet FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement128 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractElement135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractElement__Alternatives_in_ruleAbstractElement161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport188 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration248 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0_in_rulePackageDeclaration281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType308 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType368 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataType375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DataType__Group__0_in_ruleDataType401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity428 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntity435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group__0_in_ruleEntity461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Feature__Alternatives_in_ruleFeature521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature548 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStructuralFeature555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StructuralFeature__Alternatives_in_ruleStructuralFeature581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute608 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference668 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation728 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__0_in_ruleOperation761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter788 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef850 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__ReferencedAssignment_in_ruleTypeRef883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard910 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__0_in_ruleQualifiedNameWithWildCard943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName970 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName977 = new BitSet(new long[]{0x0000000000000002L});
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
        public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__01365 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__01368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Import__Group__0__Impl1396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__11427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl1454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__01488 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__01491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__PackageDeclaration__Group__0__Impl1519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__11550 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__11553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl1580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2__Impl_in_rule__PackageDeclaration__Group__21610 = new BitSet(new long[]{0x00000000000EC000L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__3_in_rule__PackageDeclaration__Group__21613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__PackageDeclaration__Group__2__Impl1641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__3__Impl_in_rule__PackageDeclaration__Group__31672 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__4_in_rule__PackageDeclaration__Group__31675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__ElementsAssignment_3_in_rule__PackageDeclaration__Group__3__Impl1702 = new BitSet(new long[]{0x00000000000CC002L});
        public static final BitSet FOLLOW_rule__PackageDeclaration__Group__4__Impl_in_rule__PackageDeclaration__Group__41733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__PackageDeclaration__Group__4__Impl1761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DataType__Group__0__Impl_in_rule__DataType__Group__01802 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__DataType__Group__1_in_rule__DataType__Group__01805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__DataType__Group__0__Impl1833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DataType__Group__1__Impl_in_rule__DataType__Group__11864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DataType__NameAssignment_1_in_rule__DataType__Group__1__Impl1891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group__0__Impl_in_rule__Entity__Group__01925 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__01928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Entity__Group__0__Impl1956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group__1__Impl_in_rule__Entity__Group__11987 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__11990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1__Impl2017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group__2__Impl_in_rule__Entity__Group__22047 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__22050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__2__Impl2077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group__3__Impl_in_rule__Entity__Group__32108 = new BitSet(new long[]{0x0000000002A23800L});
        public static final BitSet FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__32111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Entity__Group__3__Impl2139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group__4__Impl_in_rule__Entity__Group__42170 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__42173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__FeaturesAssignment_4_in_rule__Entity__Group__4__Impl2200 = new BitSet(new long[]{0x0000000002A03802L});
        public static final BitSet FOLLOW_rule__Entity__Group__5__Impl_in_rule__Entity__Group__52231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Entity__Group__5__Impl2259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group_2__0__Impl_in_rule__Entity__Group_2__02302 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__02305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Entity__Group_2__0__Impl2333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__Group_2__1__Impl_in_rule__Entity__Group_2__12364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Entity__SuperTypeAssignment_2_1_in_rule__Entity__Group_2__1__Impl2391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__02425 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__02428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Attribute__Group__0__Impl2456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__12487 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__12490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__NameAssignment_1_in_rule__Attribute__Group__1__Impl2517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__22547 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute__Group__3_in_rule__Attribute__Group__22550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Attribute__Group__2__Impl2578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__3__Impl_in_rule__Attribute__Group__32609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__TypeAssignment_3_in_rule__Attribute__Group__3__Impl2636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__02674 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__02677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Reference__Group__0__Impl2705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__12736 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__12739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__NameAssignment_1_in_rule__Reference__Group__1__Impl2766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__22796 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__22799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Reference__Group__2__Impl2827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__32858 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__32861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__TypeAssignment_3_in_rule__Reference__Group__3__Impl2888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__42918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group_4__0_in_rule__Reference__Group__4__Impl2945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group_4__0__Impl_in_rule__Reference__Group_4__02986 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group_4__1_in_rule__Reference__Group_4__02989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Reference__Group_4__0__Impl3017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group_4__1__Impl_in_rule__Reference__Group_4__13048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__OppositeAssignment_4_1_in_rule__Reference__Group_4__1__Impl3075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__0__Impl_in_rule__Operation__Group__03109 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Operation__Group__1_in_rule__Operation__Group__03112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__VisibilityAssignment_0_in_rule__Operation__Group__0__Impl3139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__1__Impl_in_rule__Operation__Group__13170 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation__Group__2_in_rule__Operation__Group__13173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Operation__Group__1__Impl3201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__2__Impl_in_rule__Operation__Group__23232 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Operation__Group__3_in_rule__Operation__Group__23235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__NameAssignment_2_in_rule__Operation__Group__2__Impl3262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__3__Impl_in_rule__Operation__Group__33292 = new BitSet(new long[]{0x0000000008000010L});
        public static final BitSet FOLLOW_rule__Operation__Group__4_in_rule__Operation__Group__33295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Operation__Group__3__Impl3323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__4__Impl_in_rule__Operation__Group__43354 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__Operation__Group__5_in_rule__Operation__Group__43357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group_4__0_in_rule__Operation__Group__4__Impl3384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__5__Impl_in_rule__Operation__Group__53415 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Operation__Group__6_in_rule__Operation__Group__53418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Operation__Group__5__Impl3446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__6__Impl_in_rule__Operation__Group__63477 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation__Group__7_in_rule__Operation__Group__63480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Operation__Group__6__Impl3508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group__7__Impl_in_rule__Operation__Group__73539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__TypeAssignment_7_in_rule__Operation__Group__7__Impl3566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group_4__0__Impl_in_rule__Operation__Group_4__03612 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_rule__Operation__Group_4__1_in_rule__Operation__Group_4__03615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__ParamsAssignment_4_0_in_rule__Operation__Group_4__0__Impl3642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group_4__1__Impl_in_rule__Operation__Group_4__13672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group_4_1__0_in_rule__Operation__Group_4__1__Impl3699 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_rule__Operation__Group_4_1__0__Impl_in_rule__Operation__Group_4_1__03734 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Operation__Group_4_1__1_in_rule__Operation__Group_4_1__03737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__Operation__Group_4_1__0__Impl3765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__Group_4_1__1__Impl_in_rule__Operation__Group_4_1__13796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operation__ParamsAssignment_4_1_1_in_rule__Operation__Group_4_1__1__Impl3823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__03857 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__03860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl3887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__13917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl3944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__0__Impl_in_rule__QualifiedNameWithWildCard__Group__03978 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__03981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__0__Impl4008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1__Impl_in_rule__QualifiedNameWithWildCard__Group__14037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__QualifiedNameWithWildCard__Group__1__Impl4066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__04103 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__04106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl4133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__14162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl4189 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__04224 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__04227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__QualifiedName__Group_1__0__Impl4255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__14286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl4313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractElement_in_rule__Model__ElementsAssignment4351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_14382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_14413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractElement_in_rule__PackageDeclaration__ElementsAssignment_34444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__DataType__NameAssignment_14475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_14506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Entity__SuperTypeAssignment_2_14541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_rule__Entity__FeaturesAssignment_44576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_14607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Attribute__TypeAssignment_34638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_14669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Reference__TypeAssignment_34700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__OppositeAssignment_4_14735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVisibility_in_rule__Operation__VisibilityAssignment_04770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Operation__NameAssignment_24801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__Operation__ParamsAssignment_4_04832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__Operation__ParamsAssignment_4_1_14863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Operation__TypeAssignment_74894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_04925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Parameter__TypeAssignment_14956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRef__ReferencedAssignment4991 = new BitSet(new long[]{0x0000000000000002L});
    }


}
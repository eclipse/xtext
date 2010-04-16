package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug304681TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug304681TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'1'", "'2'", "'package'", "'object'", "'{'", "'}'", "'extends'", "'shortDescription'", "'longDescription'", "'serialUID'", "'before'", "'after'", "'optionalLoop'", "'mandatoryLoop'", "'Attribute'", "'Reference'", "'constraint'", "'parameters'", "'message'", "'enabled'", "'abstract'", "'cloneable'", "'*'", "'required'", "'technical'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug304681TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g"; }


     
     	private Bug304681TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug304681TestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:63:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel68); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:70:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:74:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:75:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:75:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:76:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:77:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:77:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel94);
            rule__Model__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start entryRulePackageDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:89:1: entryRulePackageDefinition : rulePackageDefinition EOF ;
    public final void entryRulePackageDefinition() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:90:1: ( rulePackageDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:91:1: rulePackageDefinition EOF
            {
             before(grammarAccess.getPackageDefinitionRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition121);
            rulePackageDefinition();
            _fsp--;

             after(grammarAccess.getPackageDefinitionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDefinition128); 

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
    // $ANTLR end entryRulePackageDefinition


    // $ANTLR start rulePackageDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:98:1: rulePackageDefinition : ( ( rule__PackageDefinition__Group__0 ) ) ;
    public final void rulePackageDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:102:2: ( ( ( rule__PackageDefinition__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:103:1: ( ( rule__PackageDefinition__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:103:1: ( ( rule__PackageDefinition__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:104:1: ( rule__PackageDefinition__Group__0 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:105:1: ( rule__PackageDefinition__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:105:2: rule__PackageDefinition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__Group__0_in_rulePackageDefinition154);
            rule__PackageDefinition__Group__0();
            _fsp--;


            }

             after(grammarAccess.getPackageDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rulePackageDefinition


    // $ANTLR start entryRuleObject
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:117:1: entryRuleObject : ruleObject EOF ;
    public final void entryRuleObject() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:118:1: ( ruleObject EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:119:1: ruleObject EOF
            {
             before(grammarAccess.getObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObject_in_entryRuleObject181);
            ruleObject();
            _fsp--;

             after(grammarAccess.getObjectRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObject188); 

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
    // $ANTLR end entryRuleObject


    // $ANTLR start ruleObject
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:126:1: ruleObject : ( ( rule__Object__Group__0 ) ) ;
    public final void ruleObject() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:130:2: ( ( ( rule__Object__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:131:1: ( ( rule__Object__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:131:1: ( ( rule__Object__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:132:1: ( rule__Object__Group__0 )
            {
             before(grammarAccess.getObjectAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:133:1: ( rule__Object__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:133:2: rule__Object__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__0_in_ruleObject214);
            rule__Object__Group__0();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleObject


    // $ANTLR start entryRuleFeature
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:145:1: entryRuleFeature : ruleFeature EOF ;
    public final void entryRuleFeature() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:146:1: ( ruleFeature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:147:1: ruleFeature EOF
            {
             before(grammarAccess.getFeatureRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature241);
            ruleFeature();
            _fsp--;

             after(grammarAccess.getFeatureRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature248); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:154:1: ruleFeature : ( ( rule__Feature__Alternatives ) ) ;
    public final void ruleFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:158:2: ( ( ( rule__Feature__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:159:1: ( ( rule__Feature__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:159:1: ( ( rule__Feature__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:160:1: ( rule__Feature__Alternatives )
            {
             before(grammarAccess.getFeatureAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:161:1: ( rule__Feature__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:161:2: rule__Feature__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Feature__Alternatives_in_ruleFeature274);
            rule__Feature__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getFeatureAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:173:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:174:1: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:175:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute301);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute308); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:182:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:186:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:187:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:187:1: ( ( rule__Attribute__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:188:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:189:1: ( rule__Attribute__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:189:2: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0_in_ruleAttribute334);
            rule__Attribute__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:201:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:202:1: ( ruleReference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:203:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference361);
            ruleReference();
            _fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference368); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:210:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:214:2: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:215:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:215:1: ( ( rule__Reference__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:216:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:217:1: ( rule__Reference__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:217:2: rule__Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__0_in_ruleReference394);
            rule__Reference__Group__0();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start entryRulePackageDefinition2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:229:1: entryRulePackageDefinition2 : rulePackageDefinition2 EOF ;
    public final void entryRulePackageDefinition2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:230:1: ( rulePackageDefinition2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:231:1: rulePackageDefinition2 EOF
            {
             before(grammarAccess.getPackageDefinition2Rule()); 
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition2_in_entryRulePackageDefinition2421);
            rulePackageDefinition2();
            _fsp--;

             after(grammarAccess.getPackageDefinition2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDefinition2428); 

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
    // $ANTLR end entryRulePackageDefinition2


    // $ANTLR start rulePackageDefinition2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:238:1: rulePackageDefinition2 : ( ( rule__PackageDefinition2__Group__0 ) ) ;
    public final void rulePackageDefinition2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:242:2: ( ( ( rule__PackageDefinition2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:243:1: ( ( rule__PackageDefinition2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:243:1: ( ( rule__PackageDefinition2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:244:1: ( rule__PackageDefinition2__Group__0 )
            {
             before(grammarAccess.getPackageDefinition2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:245:1: ( rule__PackageDefinition2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:245:2: rule__PackageDefinition2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition2__Group__0_in_rulePackageDefinition2454);
            rule__PackageDefinition2__Group__0();
            _fsp--;


            }

             after(grammarAccess.getPackageDefinition2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rulePackageDefinition2


    // $ANTLR start entryRuleObject2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:257:1: entryRuleObject2 : ruleObject2 EOF ;
    public final void entryRuleObject2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:258:1: ( ruleObject2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:259:1: ruleObject2 EOF
            {
             before(grammarAccess.getObject2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObject2_in_entryRuleObject2481);
            ruleObject2();
            _fsp--;

             after(grammarAccess.getObject2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObject2488); 

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
    // $ANTLR end entryRuleObject2


    // $ANTLR start ruleObject2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:266:1: ruleObject2 : ( ( rule__Object2__Group__0 ) ) ;
    public final void ruleObject2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:270:2: ( ( ( rule__Object2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:271:1: ( ( rule__Object2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:271:1: ( ( rule__Object2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:272:1: ( rule__Object2__Group__0 )
            {
             before(grammarAccess.getObject2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:273:1: ( rule__Object2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:273:2: rule__Object2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group__0_in_ruleObject2514);
            rule__Object2__Group__0();
            _fsp--;


            }

             after(grammarAccess.getObject2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleObject2


    // $ANTLR start entryRuleFeature2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:285:1: entryRuleFeature2 : ruleFeature2 EOF ;
    public final void entryRuleFeature2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:286:1: ( ruleFeature2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:287:1: ruleFeature2 EOF
            {
             before(grammarAccess.getFeature2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_entryRuleFeature2541);
            ruleFeature2();
            _fsp--;

             after(grammarAccess.getFeature2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature2548); 

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
    // $ANTLR end entryRuleFeature2


    // $ANTLR start ruleFeature2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:294:1: ruleFeature2 : ( ( rule__Feature2__Alternatives ) ) ;
    public final void ruleFeature2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:298:2: ( ( ( rule__Feature2__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:299:1: ( ( rule__Feature2__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:299:1: ( ( rule__Feature2__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:300:1: ( rule__Feature2__Alternatives )
            {
             before(grammarAccess.getFeature2Access().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:301:1: ( rule__Feature2__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:301:2: rule__Feature2__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Feature2__Alternatives_in_ruleFeature2574);
            rule__Feature2__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getFeature2Access().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleFeature2


    // $ANTLR start entryRuleAttribute2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:313:1: entryRuleAttribute2 : ruleAttribute2 EOF ;
    public final void entryRuleAttribute2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:314:1: ( ruleAttribute2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:315:1: ruleAttribute2 EOF
            {
             before(grammarAccess.getAttribute2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute2_in_entryRuleAttribute2601);
            ruleAttribute2();
            _fsp--;

             after(grammarAccess.getAttribute2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute2608); 

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
    // $ANTLR end entryRuleAttribute2


    // $ANTLR start ruleAttribute2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:322:1: ruleAttribute2 : ( ( rule__Attribute2__Group__0 ) ) ;
    public final void ruleAttribute2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:326:2: ( ( ( rule__Attribute2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:327:1: ( ( rule__Attribute2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:327:1: ( ( rule__Attribute2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:328:1: ( rule__Attribute2__Group__0 )
            {
             before(grammarAccess.getAttribute2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:329:1: ( rule__Attribute2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:329:2: rule__Attribute2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group__0_in_ruleAttribute2634);
            rule__Attribute2__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAttribute2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAttribute2


    // $ANTLR start entryRuleReference2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:341:1: entryRuleReference2 : ruleReference2 EOF ;
    public final void entryRuleReference2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:342:1: ( ruleReference2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:343:1: ruleReference2 EOF
            {
             before(grammarAccess.getReference2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReference2_in_entryRuleReference2661);
            ruleReference2();
            _fsp--;

             after(grammarAccess.getReference2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference2668); 

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
    // $ANTLR end entryRuleReference2


    // $ANTLR start ruleReference2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:350:1: ruleReference2 : ( ( rule__Reference2__Group__0 ) ) ;
    public final void ruleReference2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:354:2: ( ( ( rule__Reference2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:355:1: ( ( rule__Reference2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:355:1: ( ( rule__Reference2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:356:1: ( rule__Reference2__Group__0 )
            {
             before(grammarAccess.getReference2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:357:1: ( rule__Reference2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:357:2: rule__Reference2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group__0_in_ruleReference2694);
            rule__Reference2__Group__0();
            _fsp--;


            }

             after(grammarAccess.getReference2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleReference2


    // $ANTLR start entryRuleConstraintDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:369:1: entryRuleConstraintDefinition : ruleConstraintDefinition EOF ;
    public final void entryRuleConstraintDefinition() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:370:1: ( ruleConstraintDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:371:1: ruleConstraintDefinition EOF
            {
             before(grammarAccess.getConstraintDefinitionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_entryRuleConstraintDefinition721);
            ruleConstraintDefinition();
            _fsp--;

             after(grammarAccess.getConstraintDefinitionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstraintDefinition728); 

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
    // $ANTLR end entryRuleConstraintDefinition


    // $ANTLR start ruleConstraintDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:378:1: ruleConstraintDefinition : ( ( rule__ConstraintDefinition__Group__0 ) ) ;
    public final void ruleConstraintDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:382:2: ( ( ( rule__ConstraintDefinition__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:383:1: ( ( rule__ConstraintDefinition__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:383:1: ( ( rule__ConstraintDefinition__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:384:1: ( rule__ConstraintDefinition__Group__0 )
            {
             before(grammarAccess.getConstraintDefinitionAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:385:1: ( rule__ConstraintDefinition__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:385:2: rule__ConstraintDefinition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group__0_in_ruleConstraintDefinition754);
            rule__ConstraintDefinition__Group__0();
            _fsp--;


            }

             after(grammarAccess.getConstraintDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleConstraintDefinition


    // $ANTLR start rule__Model__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:397:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:401:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("397:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:402:1: ( ( rule__Model__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:402:1: ( ( rule__Model__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:403:1: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:404:1: ( rule__Model__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:404:2: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives790);
                    rule__Model__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:408:6: ( ( rule__Model__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:408:6: ( ( rule__Model__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:409:1: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:410:1: ( rule__Model__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:410:2: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives808);
                    rule__Model__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

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
    // $ANTLR end rule__Model__Alternatives


    // $ANTLR start rule__Object__Alternatives_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:419:1: rule__Object__Alternatives_0 : ( ( ( rule__Object__EnabledAssignment_0_0 ) ) | ( ( rule__Object__AbstractAssignment_0_1 ) ) );
    public final void rule__Object__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:423:1: ( ( ( rule__Object__EnabledAssignment_0_0 ) ) | ( ( rule__Object__AbstractAssignment_0_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==31) ) {
                alt2=1;
            }
            else if ( (LA2_0==32) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("419:1: rule__Object__Alternatives_0 : ( ( ( rule__Object__EnabledAssignment_0_0 ) ) | ( ( rule__Object__AbstractAssignment_0_1 ) ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:424:1: ( ( rule__Object__EnabledAssignment_0_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:424:1: ( ( rule__Object__EnabledAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:425:1: ( rule__Object__EnabledAssignment_0_0 )
                    {
                     before(grammarAccess.getObjectAccess().getEnabledAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:426:1: ( rule__Object__EnabledAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:426:2: rule__Object__EnabledAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__EnabledAssignment_0_0_in_rule__Object__Alternatives_0841);
                    rule__Object__EnabledAssignment_0_0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getEnabledAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:430:6: ( ( rule__Object__AbstractAssignment_0_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:430:6: ( ( rule__Object__AbstractAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:431:1: ( rule__Object__AbstractAssignment_0_1 )
                    {
                     before(grammarAccess.getObjectAccess().getAbstractAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:432:1: ( rule__Object__AbstractAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:432:2: rule__Object__AbstractAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__AbstractAssignment_0_1_in_rule__Object__Alternatives_0859);
                    rule__Object__AbstractAssignment_0_1();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getAbstractAssignment_0_1()); 

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
    // $ANTLR end rule__Object__Alternatives_0


    // $ANTLR start rule__Feature__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:441:1: rule__Feature__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );
    public final void rule__Feature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:445:1: ( ( ruleAttribute ) | ( ruleReference ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==26) ) {
                alt3=1;
            }
            else if ( (LA3_0==27) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("441:1: rule__Feature__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:446:1: ( ruleAttribute )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:446:1: ( ruleAttribute )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:447:1: ruleAttribute
                    {
                     before(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__Feature__Alternatives892);
                    ruleAttribute();
                    _fsp--;

                     after(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:452:6: ( ruleReference )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:452:6: ( ruleReference )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:453:1: ruleReference
                    {
                     before(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleReference_in_rule__Feature__Alternatives909);
                    ruleReference();
                    _fsp--;

                     after(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1()); 

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


    // $ANTLR start rule__Reference__Alternatives_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:463:1: rule__Reference__Alternatives_4 : ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ';' ) );
    public final void rule__Reference__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:467:1: ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ';' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==11) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("463:1: rule__Reference__Alternatives_4 : ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ';' ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:468:1: ( ( rule__Reference__Group_4_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:468:1: ( ( rule__Reference__Group_4_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:469:1: ( rule__Reference__Group_4_0__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:470:1: ( rule__Reference__Group_4_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:470:2: rule__Reference__Group_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_4941);
                    rule__Reference__Group_4_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:474:6: ( ';' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:474:6: ( ';' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:475:1: ';'
                    {
                     before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_1()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Reference__Alternatives_4960); 
                     after(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_1()); 

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
    // $ANTLR end rule__Reference__Alternatives_4


    // $ANTLR start rule__Object2__Alternatives_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:487:1: rule__Object2__Alternatives_0 : ( ( ( rule__Object2__EnabledAssignment_0_0 ) ) | ( ( rule__Object2__AbstractAssignment_0_1 ) ) );
    public final void rule__Object2__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:491:1: ( ( ( rule__Object2__EnabledAssignment_0_0 ) ) | ( ( rule__Object2__AbstractAssignment_0_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==31) ) {
                alt5=1;
            }
            else if ( (LA5_0==32) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("487:1: rule__Object2__Alternatives_0 : ( ( ( rule__Object2__EnabledAssignment_0_0 ) ) | ( ( rule__Object2__AbstractAssignment_0_1 ) ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:492:1: ( ( rule__Object2__EnabledAssignment_0_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:492:1: ( ( rule__Object2__EnabledAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:493:1: ( rule__Object2__EnabledAssignment_0_0 )
                    {
                     before(grammarAccess.getObject2Access().getEnabledAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:494:1: ( rule__Object2__EnabledAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:494:2: rule__Object2__EnabledAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__EnabledAssignment_0_0_in_rule__Object2__Alternatives_0994);
                    rule__Object2__EnabledAssignment_0_0();
                    _fsp--;


                    }

                     after(grammarAccess.getObject2Access().getEnabledAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:498:6: ( ( rule__Object2__AbstractAssignment_0_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:498:6: ( ( rule__Object2__AbstractAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:499:1: ( rule__Object2__AbstractAssignment_0_1 )
                    {
                     before(grammarAccess.getObject2Access().getAbstractAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:500:1: ( rule__Object2__AbstractAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:500:2: rule__Object2__AbstractAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__AbstractAssignment_0_1_in_rule__Object2__Alternatives_01012);
                    rule__Object2__AbstractAssignment_0_1();
                    _fsp--;


                    }

                     after(grammarAccess.getObject2Access().getAbstractAssignment_0_1()); 

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
    // $ANTLR end rule__Object2__Alternatives_0


    // $ANTLR start rule__Feature2__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:509:1: rule__Feature2__Alternatives : ( ( ruleAttribute2 ) | ( ruleReference2 ) );
    public final void rule__Feature2__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:513:1: ( ( ruleAttribute2 ) | ( ruleReference2 ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            else if ( (LA6_0==27) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("509:1: rule__Feature2__Alternatives : ( ( ruleAttribute2 ) | ( ruleReference2 ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:514:1: ( ruleAttribute2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:514:1: ( ruleAttribute2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:515:1: ruleAttribute2
                    {
                     before(grammarAccess.getFeature2Access().getAttribute2ParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute2_in_rule__Feature2__Alternatives1045);
                    ruleAttribute2();
                    _fsp--;

                     after(grammarAccess.getFeature2Access().getAttribute2ParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:520:6: ( ruleReference2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:520:6: ( ruleReference2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:521:1: ruleReference2
                    {
                     before(grammarAccess.getFeature2Access().getReference2ParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleReference2_in_rule__Feature2__Alternatives1062);
                    ruleReference2();
                    _fsp--;

                     after(grammarAccess.getFeature2Access().getReference2ParserRuleCall_1()); 

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
    // $ANTLR end rule__Feature2__Alternatives


    // $ANTLR start rule__Attribute2__Alternatives_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:531:1: rule__Attribute2__Alternatives_3 : ( ( ( rule__Attribute2__Group_3_0__0 ) ) | ( ';' ) );
    public final void rule__Attribute2__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:535:1: ( ( ( rule__Attribute2__Group_3_0__0 ) ) | ( ';' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            else if ( (LA7_0==11) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("531:1: rule__Attribute2__Alternatives_3 : ( ( ( rule__Attribute2__Group_3_0__0 ) ) | ( ';' ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:536:1: ( ( rule__Attribute2__Group_3_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:536:1: ( ( rule__Attribute2__Group_3_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:537:1: ( rule__Attribute2__Group_3_0__0 )
                    {
                     before(grammarAccess.getAttribute2Access().getGroup_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:538:1: ( rule__Attribute2__Group_3_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:538:2: rule__Attribute2__Group_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0__0_in_rule__Attribute2__Alternatives_31094);
                    rule__Attribute2__Group_3_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getAttribute2Access().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:542:6: ( ';' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:542:6: ( ';' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:543:1: ';'
                    {
                     before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_1()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Attribute2__Alternatives_31113); 
                     after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_1()); 

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
    // $ANTLR end rule__Attribute2__Alternatives_3


    // $ANTLR start rule__Reference2__Alternatives_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:555:1: rule__Reference2__Alternatives_4 : ( ( ( rule__Reference2__Group_4_0__0 ) ) | ( ';' ) );
    public final void rule__Reference2__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:559:1: ( ( ( rule__Reference2__Group_4_0__0 ) ) | ( ';' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            else if ( (LA8_0==11) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("555:1: rule__Reference2__Alternatives_4 : ( ( ( rule__Reference2__Group_4_0__0 ) ) | ( ';' ) );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:560:1: ( ( rule__Reference2__Group_4_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:560:1: ( ( rule__Reference2__Group_4_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:561:1: ( rule__Reference2__Group_4_0__0 )
                    {
                     before(grammarAccess.getReference2Access().getGroup_4_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:562:1: ( rule__Reference2__Group_4_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:562:2: rule__Reference2__Group_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group_4_0__0_in_rule__Reference2__Alternatives_41147);
                    rule__Reference2__Group_4_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReference2Access().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:566:6: ( ';' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:566:6: ( ';' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:567:1: ';'
                    {
                     before(grammarAccess.getReference2Access().getSemicolonKeyword_4_1()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Reference2__Alternatives_41166); 
                     after(grammarAccess.getReference2Access().getSemicolonKeyword_4_1()); 

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
    // $ANTLR end rule__Reference2__Alternatives_4


    // $ANTLR start rule__Model__Group_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:581:1: rule__Model__Group_0__0 : ( '1' ) rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:585:1: ( ( '1' ) rule__Model__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:586:1: ( '1' ) rule__Model__Group_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:586:1: ( '1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:587:1: '1'
            {
             before(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_0__01203); 
             after(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__01213);
            rule__Model__Group_0__1();
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
    // $ANTLR end rule__Model__Group_0__0


    // $ANTLR start rule__Model__Group_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:601:1: rule__Model__Group_0__1 : ( ( rule__Model__DefinitionAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:605:1: ( ( ( rule__Model__DefinitionAssignment_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:606:1: ( ( rule__Model__DefinitionAssignment_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:606:1: ( ( rule__Model__DefinitionAssignment_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:607:1: ( rule__Model__DefinitionAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getDefinitionAssignment_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:608:1: ( rule__Model__DefinitionAssignment_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:608:2: rule__Model__DefinitionAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__DefinitionAssignment_0_1_in_rule__Model__Group_0__11241);
            rule__Model__DefinitionAssignment_0_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getDefinitionAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_0__1


    // $ANTLR start rule__Model__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:622:1: rule__Model__Group_1__0 : ( '2' ) rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:626:1: ( ( '2' ) rule__Model__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:627:1: ( '2' ) rule__Model__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:627:1: ( '2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:628:1: '2'
            {
             before(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1__01280); 
             after(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01290);
            rule__Model__Group_1__1();
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
    // $ANTLR end rule__Model__Group_1__0


    // $ANTLR start rule__Model__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:642:1: rule__Model__Group_1__1 : ( ( rule__Model__DefinitionAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:646:1: ( ( ( rule__Model__DefinitionAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:647:1: ( ( rule__Model__DefinitionAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:647:1: ( ( rule__Model__DefinitionAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:648:1: ( rule__Model__DefinitionAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getDefinitionAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:649:1: ( rule__Model__DefinitionAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:649:2: rule__Model__DefinitionAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__DefinitionAssignment_1_1_in_rule__Model__Group_1__11318);
            rule__Model__DefinitionAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getDefinitionAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_1__1


    // $ANTLR start rule__PackageDefinition__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:663:1: rule__PackageDefinition__Group__0 : ( () ) rule__PackageDefinition__Group__1 ;
    public final void rule__PackageDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:667:1: ( ( () ) rule__PackageDefinition__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:668:1: ( () ) rule__PackageDefinition__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:668:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:669:1: ()
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:670:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:672:1: 
            {
            }

             after(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__01366);
            rule__PackageDefinition__Group__1();
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
    // $ANTLR end rule__PackageDefinition__Group__0


    // $ANTLR start rule__PackageDefinition__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:683:1: rule__PackageDefinition__Group__1 : ( 'package' ) rule__PackageDefinition__Group__2 ;
    public final void rule__PackageDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:687:1: ( ( 'package' ) rule__PackageDefinition__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:688:1: ( 'package' ) rule__PackageDefinition__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:688:1: ( 'package' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:689:1: 'package'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__PackageDefinition__Group__11395); 
             after(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__11405);
            rule__PackageDefinition__Group__2();
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
    // $ANTLR end rule__PackageDefinition__Group__1


    // $ANTLR start rule__PackageDefinition__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:703:1: rule__PackageDefinition__Group__2 : ( ( rule__PackageDefinition__NamespaceAssignment_2 ) ) rule__PackageDefinition__Group__3 ;
    public final void rule__PackageDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:707:1: ( ( ( rule__PackageDefinition__NamespaceAssignment_2 ) ) rule__PackageDefinition__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:708:1: ( ( rule__PackageDefinition__NamespaceAssignment_2 ) ) rule__PackageDefinition__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:708:1: ( ( rule__PackageDefinition__NamespaceAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:709:1: ( rule__PackageDefinition__NamespaceAssignment_2 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getNamespaceAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:710:1: ( rule__PackageDefinition__NamespaceAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:710:2: rule__PackageDefinition__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__NamespaceAssignment_2_in_rule__PackageDefinition__Group__21433);
            rule__PackageDefinition__NamespaceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getPackageDefinitionAccess().getNamespaceAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__21442);
            rule__PackageDefinition__Group__3();
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
    // $ANTLR end rule__PackageDefinition__Group__2


    // $ANTLR start rule__PackageDefinition__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:721:1: rule__PackageDefinition__Group__3 : ( ';' ) rule__PackageDefinition__Group__4 ;
    public final void rule__PackageDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:725:1: ( ( ';' ) rule__PackageDefinition__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:726:1: ( ';' ) rule__PackageDefinition__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:726:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:727:1: ';'
            {
             before(grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__PackageDefinition__Group__31471); 
             after(grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__31481);
            rule__PackageDefinition__Group__4();
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
    // $ANTLR end rule__PackageDefinition__Group__3


    // $ANTLR start rule__PackageDefinition__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:741:1: rule__PackageDefinition__Group__4 : ( ( rule__PackageDefinition__ContentsAssignment_4 )* ) ;
    public final void rule__PackageDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:745:1: ( ( ( rule__PackageDefinition__ContentsAssignment_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:746:1: ( ( rule__PackageDefinition__ContentsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:746:1: ( ( rule__PackageDefinition__ContentsAssignment_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:747:1: ( rule__PackageDefinition__ContentsAssignment_4 )*
            {
             before(grammarAccess.getPackageDefinitionAccess().getContentsAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:748:1: ( rule__PackageDefinition__ContentsAssignment_4 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15||(LA9_0>=31 && LA9_0<=32)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:748:2: rule__PackageDefinition__ContentsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__ContentsAssignment_4_in_rule__PackageDefinition__Group__41509);
            	    rule__PackageDefinition__ContentsAssignment_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getPackageDefinitionAccess().getContentsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDefinition__Group__4


    // $ANTLR start rule__Object__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:768:1: rule__Object__Group__0 : ( ( rule__Object__Alternatives_0 )? ) rule__Object__Group__1 ;
    public final void rule__Object__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:772:1: ( ( ( rule__Object__Alternatives_0 )? ) rule__Object__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:773:1: ( ( rule__Object__Alternatives_0 )? ) rule__Object__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:773:1: ( ( rule__Object__Alternatives_0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:774:1: ( rule__Object__Alternatives_0 )?
            {
             before(grammarAccess.getObjectAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:775:1: ( rule__Object__Alternatives_0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=31 && LA10_0<=32)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:775:2: rule__Object__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Alternatives_0_in_rule__Object__Group__01554);
                    rule__Object__Alternatives_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjectAccess().getAlternatives_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__1_in_rule__Object__Group__01564);
            rule__Object__Group__1();
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
    // $ANTLR end rule__Object__Group__0


    // $ANTLR start rule__Object__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:786:1: rule__Object__Group__1 : ( 'object' ) rule__Object__Group__2 ;
    public final void rule__Object__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:790:1: ( ( 'object' ) rule__Object__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:791:1: ( 'object' ) rule__Object__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:791:1: ( 'object' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:792:1: 'object'
            {
             before(grammarAccess.getObjectAccess().getObjectKeyword_1()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Object__Group__11593); 
             after(grammarAccess.getObjectAccess().getObjectKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__2_in_rule__Object__Group__11603);
            rule__Object__Group__2();
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
    // $ANTLR end rule__Object__Group__1


    // $ANTLR start rule__Object__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:806:1: rule__Object__Group__2 : ( ( rule__Object__NameAssignment_2 ) ) rule__Object__Group__3 ;
    public final void rule__Object__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:810:1: ( ( ( rule__Object__NameAssignment_2 ) ) rule__Object__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:811:1: ( ( rule__Object__NameAssignment_2 ) ) rule__Object__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:811:1: ( ( rule__Object__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:812:1: ( rule__Object__NameAssignment_2 )
            {
             before(grammarAccess.getObjectAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:813:1: ( rule__Object__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:813:2: rule__Object__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__NameAssignment_2_in_rule__Object__Group__21631);
            rule__Object__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__3_in_rule__Object__Group__21640);
            rule__Object__Group__3();
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
    // $ANTLR end rule__Object__Group__2


    // $ANTLR start rule__Object__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:824:1: rule__Object__Group__3 : ( ( rule__Object__Group_3__0 )? ) rule__Object__Group__4 ;
    public final void rule__Object__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:828:1: ( ( ( rule__Object__Group_3__0 )? ) rule__Object__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:829:1: ( ( rule__Object__Group_3__0 )? ) rule__Object__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:829:1: ( ( rule__Object__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:830:1: ( rule__Object__Group_3__0 )?
            {
             before(grammarAccess.getObjectAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:831:1: ( rule__Object__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:831:2: rule__Object__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_3__0_in_rule__Object__Group__31668);
                    rule__Object__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjectAccess().getGroup_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__4_in_rule__Object__Group__31678);
            rule__Object__Group__4();
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
    // $ANTLR end rule__Object__Group__3


    // $ANTLR start rule__Object__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:842:1: rule__Object__Group__4 : ( '{' ) rule__Object__Group__5 ;
    public final void rule__Object__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:846:1: ( ( '{' ) rule__Object__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:847:1: ( '{' ) rule__Object__Group__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:847:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:848:1: '{'
            {
             before(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Object__Group__41707); 
             after(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__5_in_rule__Object__Group__41717);
            rule__Object__Group__5();
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
    // $ANTLR end rule__Object__Group__4


    // $ANTLR start rule__Object__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:862:1: rule__Object__Group__5 : ( ( rule__Object__UnorderedGroup_5 ) ) rule__Object__Group__6 ;
    public final void rule__Object__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:866:1: ( ( ( rule__Object__UnorderedGroup_5 ) ) rule__Object__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:867:1: ( ( rule__Object__UnorderedGroup_5 ) ) rule__Object__Group__6
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:867:1: ( ( rule__Object__UnorderedGroup_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:868:1: ( rule__Object__UnorderedGroup_5 )
            {
             before(grammarAccess.getObjectAccess().getUnorderedGroup_5()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:869:1: ( rule__Object__UnorderedGroup_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:869:2: rule__Object__UnorderedGroup_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5_in_rule__Object__Group__51745);
            rule__Object__UnorderedGroup_5();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getUnorderedGroup_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__6_in_rule__Object__Group__51754);
            rule__Object__Group__6();
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
    // $ANTLR end rule__Object__Group__5


    // $ANTLR start rule__Object__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:880:1: rule__Object__Group__6 : ( '}' ) ;
    public final void rule__Object__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:884:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:885:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:885:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:886:1: '}'
            {
             before(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_6()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Object__Group__61783); 
             after(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__Group__6


    // $ANTLR start rule__Object__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:913:1: rule__Object__Group_3__0 : ( 'extends' ) rule__Object__Group_3__1 ;
    public final void rule__Object__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:917:1: ( ( 'extends' ) rule__Object__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:918:1: ( 'extends' ) rule__Object__Group_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:918:1: ( 'extends' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:919:1: 'extends'
            {
             before(grammarAccess.getObjectAccess().getExtendsKeyword_3_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Object__Group_3__01833); 
             after(grammarAccess.getObjectAccess().getExtendsKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_3__1_in_rule__Object__Group_3__01843);
            rule__Object__Group_3__1();
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
    // $ANTLR end rule__Object__Group_3__0


    // $ANTLR start rule__Object__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:933:1: rule__Object__Group_3__1 : ( ( rule__Object__ParentAssignment_3_1 ) ) ;
    public final void rule__Object__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:937:1: ( ( ( rule__Object__ParentAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:938:1: ( ( rule__Object__ParentAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:938:1: ( ( rule__Object__ParentAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:939:1: ( rule__Object__ParentAssignment_3_1 )
            {
             before(grammarAccess.getObjectAccess().getParentAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:940:1: ( rule__Object__ParentAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:940:2: rule__Object__ParentAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__ParentAssignment_3_1_in_rule__Object__Group_3__11871);
            rule__Object__ParentAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getParentAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__Group_3__1


    // $ANTLR start rule__Object__Group_5_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:954:1: rule__Object__Group_5_0__0 : ( 'shortDescription' ) rule__Object__Group_5_0__1 ;
    public final void rule__Object__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:958:1: ( ( 'shortDescription' ) rule__Object__Group_5_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:959:1: ( 'shortDescription' ) rule__Object__Group_5_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:959:1: ( 'shortDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:960:1: 'shortDescription'
            {
             before(grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Object__Group_5_0__01910); 
             after(grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_0__1_in_rule__Object__Group_5_0__01920);
            rule__Object__Group_5_0__1();
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
    // $ANTLR end rule__Object__Group_5_0__0


    // $ANTLR start rule__Object__Group_5_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:974:1: rule__Object__Group_5_0__1 : ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) ) rule__Object__Group_5_0__2 ;
    public final void rule__Object__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:978:1: ( ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) ) rule__Object__Group_5_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:979:1: ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) ) rule__Object__Group_5_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:979:1: ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:980:1: ( rule__Object__ShortDescriptionAssignment_5_0_1 )
            {
             before(grammarAccess.getObjectAccess().getShortDescriptionAssignment_5_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:981:1: ( rule__Object__ShortDescriptionAssignment_5_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:981:2: rule__Object__ShortDescriptionAssignment_5_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__ShortDescriptionAssignment_5_0_1_in_rule__Object__Group_5_0__11948);
            rule__Object__ShortDescriptionAssignment_5_0_1();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getShortDescriptionAssignment_5_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_0__2_in_rule__Object__Group_5_0__11957);
            rule__Object__Group_5_0__2();
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
    // $ANTLR end rule__Object__Group_5_0__1


    // $ANTLR start rule__Object__Group_5_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:992:1: rule__Object__Group_5_0__2 : ( ';' ) ;
    public final void rule__Object__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:996:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:997:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:997:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:998:1: ';'
            {
             before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object__Group_5_0__21986); 
             after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__Group_5_0__2


    // $ANTLR start rule__Object__Group_5_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1017:1: rule__Object__Group_5_1__0 : ( 'longDescription' ) rule__Object__Group_5_1__1 ;
    public final void rule__Object__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1021:1: ( ( 'longDescription' ) rule__Object__Group_5_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1022:1: ( 'longDescription' ) rule__Object__Group_5_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1022:1: ( 'longDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1023:1: 'longDescription'
            {
             before(grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Object__Group_5_1__02028); 
             after(grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_1__1_in_rule__Object__Group_5_1__02038);
            rule__Object__Group_5_1__1();
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
    // $ANTLR end rule__Object__Group_5_1__0


    // $ANTLR start rule__Object__Group_5_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1037:1: rule__Object__Group_5_1__1 : ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) ) rule__Object__Group_5_1__2 ;
    public final void rule__Object__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1041:1: ( ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) ) rule__Object__Group_5_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1042:1: ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) ) rule__Object__Group_5_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1042:1: ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1043:1: ( rule__Object__LongDescriptionAssignment_5_1_1 )
            {
             before(grammarAccess.getObjectAccess().getLongDescriptionAssignment_5_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1044:1: ( rule__Object__LongDescriptionAssignment_5_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1044:2: rule__Object__LongDescriptionAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__LongDescriptionAssignment_5_1_1_in_rule__Object__Group_5_1__12066);
            rule__Object__LongDescriptionAssignment_5_1_1();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getLongDescriptionAssignment_5_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_1__2_in_rule__Object__Group_5_1__12075);
            rule__Object__Group_5_1__2();
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
    // $ANTLR end rule__Object__Group_5_1__1


    // $ANTLR start rule__Object__Group_5_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1055:1: rule__Object__Group_5_1__2 : ( ';' ) ;
    public final void rule__Object__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1059:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1060:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1060:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1061:1: ';'
            {
             before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object__Group_5_1__22104); 
             after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__Group_5_1__2


    // $ANTLR start rule__Object__Group_5_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1080:1: rule__Object__Group_5_2__0 : ( 'serialUID' ) rule__Object__Group_5_2__1 ;
    public final void rule__Object__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1084:1: ( ( 'serialUID' ) rule__Object__Group_5_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1085:1: ( 'serialUID' ) rule__Object__Group_5_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1085:1: ( 'serialUID' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1086:1: 'serialUID'
            {
             before(grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Object__Group_5_2__02146); 
             after(grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_2__1_in_rule__Object__Group_5_2__02156);
            rule__Object__Group_5_2__1();
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
    // $ANTLR end rule__Object__Group_5_2__0


    // $ANTLR start rule__Object__Group_5_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1100:1: rule__Object__Group_5_2__1 : ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) ) rule__Object__Group_5_2__2 ;
    public final void rule__Object__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1104:1: ( ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) ) rule__Object__Group_5_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1105:1: ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) ) rule__Object__Group_5_2__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1105:1: ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1106:1: ( rule__Object__SerialVersionUIDAssignment_5_2_1 )
            {
             before(grammarAccess.getObjectAccess().getSerialVersionUIDAssignment_5_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1107:1: ( rule__Object__SerialVersionUIDAssignment_5_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1107:2: rule__Object__SerialVersionUIDAssignment_5_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__SerialVersionUIDAssignment_5_2_1_in_rule__Object__Group_5_2__12184);
            rule__Object__SerialVersionUIDAssignment_5_2_1();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getSerialVersionUIDAssignment_5_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_2__2_in_rule__Object__Group_5_2__12193);
            rule__Object__Group_5_2__2();
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
    // $ANTLR end rule__Object__Group_5_2__1


    // $ANTLR start rule__Object__Group_5_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1118:1: rule__Object__Group_5_2__2 : ( ';' ) ;
    public final void rule__Object__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1122:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1123:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1123:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1124:1: ';'
            {
             before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object__Group_5_2__22222); 
             after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__Group_5_2__2


    // $ANTLR start rule__Object__Group_5_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1143:1: rule__Object__Group_5_3__0 : ( ( rule__Object__CloneableAssignment_5_3_0 ) ) rule__Object__Group_5_3__1 ;
    public final void rule__Object__Group_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1147:1: ( ( ( rule__Object__CloneableAssignment_5_3_0 ) ) rule__Object__Group_5_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1148:1: ( ( rule__Object__CloneableAssignment_5_3_0 ) ) rule__Object__Group_5_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1148:1: ( ( rule__Object__CloneableAssignment_5_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1149:1: ( rule__Object__CloneableAssignment_5_3_0 )
            {
             before(grammarAccess.getObjectAccess().getCloneableAssignment_5_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1150:1: ( rule__Object__CloneableAssignment_5_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1150:2: rule__Object__CloneableAssignment_5_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__CloneableAssignment_5_3_0_in_rule__Object__Group_5_3__02263);
            rule__Object__CloneableAssignment_5_3_0();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getCloneableAssignment_5_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_3__1_in_rule__Object__Group_5_3__02272);
            rule__Object__Group_5_3__1();
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
    // $ANTLR end rule__Object__Group_5_3__0


    // $ANTLR start rule__Object__Group_5_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1161:1: rule__Object__Group_5_3__1 : ( ';' ) ;
    public final void rule__Object__Group_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1165:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1166:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1166:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1167:1: ';'
            {
             before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object__Group_5_3__12301); 
             after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__Group_5_3__1


    // $ANTLR start rule__Object__Group_5_5__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1184:1: rule__Object__Group_5_5__0 : ( 'before' ) rule__Object__Group_5_5__1 ;
    public final void rule__Object__Group_5_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1188:1: ( ( 'before' ) rule__Object__Group_5_5__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1189:1: ( 'before' ) rule__Object__Group_5_5__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1189:1: ( 'before' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1190:1: 'before'
            {
             before(grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Object__Group_5_5__02341); 
             after(grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_5__1_in_rule__Object__Group_5_5__02351);
            rule__Object__Group_5_5__1();
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
    // $ANTLR end rule__Object__Group_5_5__0


    // $ANTLR start rule__Object__Group_5_5__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1204:1: rule__Object__Group_5_5__1 : ( ( rule__Object__FeaturesAssignment_5_5_1 )* ) rule__Object__Group_5_5__2 ;
    public final void rule__Object__Group_5_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1208:1: ( ( ( rule__Object__FeaturesAssignment_5_5_1 )* ) rule__Object__Group_5_5__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1209:1: ( ( rule__Object__FeaturesAssignment_5_5_1 )* ) rule__Object__Group_5_5__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1209:1: ( ( rule__Object__FeaturesAssignment_5_5_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1210:1: ( rule__Object__FeaturesAssignment_5_5_1 )*
            {
             before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_5_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1211:1: ( rule__Object__FeaturesAssignment_5_5_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=26 && LA12_0<=27)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1211:2: rule__Object__FeaturesAssignment_5_5_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_5_1_in_rule__Object__Group_5_5__12379);
            	    rule__Object__FeaturesAssignment_5_5_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_5_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_5__2_in_rule__Object__Group_5_5__12389);
            rule__Object__Group_5_5__2();
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
    // $ANTLR end rule__Object__Group_5_5__1


    // $ANTLR start rule__Object__Group_5_5__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1222:1: rule__Object__Group_5_5__2 : ( 'after' ) ;
    public final void rule__Object__Group_5_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1226:1: ( ( 'after' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1227:1: ( 'after' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1227:1: ( 'after' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1228:1: 'after'
            {
             before(grammarAccess.getObjectAccess().getAfterKeyword_5_5_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Object__Group_5_5__22418); 
             after(grammarAccess.getObjectAccess().getAfterKeyword_5_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__Group_5_5__2


    // $ANTLR start rule__Object__Group_5_6__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1247:1: rule__Object__Group_5_6__0 : ( 'optionalLoop' ) rule__Object__Group_5_6__1 ;
    public final void rule__Object__Group_5_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1251:1: ( ( 'optionalLoop' ) rule__Object__Group_5_6__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1252:1: ( 'optionalLoop' ) rule__Object__Group_5_6__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1252:1: ( 'optionalLoop' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1253:1: 'optionalLoop'
            {
             before(grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Object__Group_5_6__02460); 
             after(grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_6__1_in_rule__Object__Group_5_6__02470);
            rule__Object__Group_5_6__1();
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
    // $ANTLR end rule__Object__Group_5_6__0


    // $ANTLR start rule__Object__Group_5_6__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1267:1: rule__Object__Group_5_6__1 : ( ( rule__Object__FeaturesAssignment_5_6_1 )* ) ;
    public final void rule__Object__Group_5_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1271:1: ( ( ( rule__Object__FeaturesAssignment_5_6_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1272:1: ( ( rule__Object__FeaturesAssignment_5_6_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1272:1: ( ( rule__Object__FeaturesAssignment_5_6_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1273:1: ( rule__Object__FeaturesAssignment_5_6_1 )*
            {
             before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_6_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1274:1: ( rule__Object__FeaturesAssignment_5_6_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    int LA13_5 = input.LA(2);

                    if ( (LA13_5==RULE_ID) ) {
                        int LA13_11 = input.LA(3);

                        if ( (LA13_11==RULE_ID) ) {
                            int LA13_13 = input.LA(4);

                            if ( (LA13_13==11) ) {
                                int LA13_16 = input.LA(5);

                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                    alt13=1;
                                }


                            }


                        }


                    }


                }
                else if ( (LA13_0==27) ) {
                    int LA13_6 = input.LA(2);

                    if ( (LA13_6==RULE_ID) ) {
                        int LA13_12 = input.LA(3);

                        if ( (LA13_12==34) ) {
                            int LA13_14 = input.LA(4);

                            if ( (LA13_14==RULE_ID) ) {
                                int LA13_15 = input.LA(5);

                                if ( (LA13_15==16) ) {
                                    switch ( input.LA(6) ) {
                                    case 19:
                                        {
                                        int LA13_20 = input.LA(7);

                                        if ( (LA13_20==RULE_STRING) ) {
                                            int LA13_23 = input.LA(8);

                                            if ( (LA13_23==11) ) {
                                                switch ( input.LA(9) ) {
                                                case 19:
                                                    {
                                                    int LA13_27 = input.LA(10);

                                                    if ( (LA13_27==RULE_STRING) ) {
                                                        int LA13_31 = input.LA(11);

                                                        if ( (LA13_31==11) ) {
                                                            int LA13_33 = input.LA(12);

                                                            if ( (LA13_33==17) ) {
                                                                int LA13_35 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt13=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 20:
                                                    {
                                                    int LA13_28 = input.LA(10);

                                                    if ( (LA13_28==RULE_STRING) ) {
                                                        int LA13_32 = input.LA(11);

                                                        if ( (LA13_32==11) ) {
                                                            int LA13_34 = input.LA(12);

                                                            if ( (LA13_34==17) ) {
                                                                int LA13_36 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt13=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 17:
                                                    {
                                                    int LA13_29 = input.LA(10);

                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                        alt13=1;
                                                    }


                                                    }
                                                    break;

                                                }

                                            }


                                        }


                                        }
                                        break;
                                    case 20:
                                        {
                                        int LA13_21 = input.LA(7);

                                        if ( (LA13_21==RULE_STRING) ) {
                                            int LA13_24 = input.LA(8);

                                            if ( (LA13_24==11) ) {
                                                switch ( input.LA(9) ) {
                                                case 19:
                                                    {
                                                    int LA13_27 = input.LA(10);

                                                    if ( (LA13_27==RULE_STRING) ) {
                                                        int LA13_31 = input.LA(11);

                                                        if ( (LA13_31==11) ) {
                                                            int LA13_33 = input.LA(12);

                                                            if ( (LA13_33==17) ) {
                                                                int LA13_35 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt13=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 20:
                                                    {
                                                    int LA13_28 = input.LA(10);

                                                    if ( (LA13_28==RULE_STRING) ) {
                                                        int LA13_32 = input.LA(11);

                                                        if ( (LA13_32==11) ) {
                                                            int LA13_34 = input.LA(12);

                                                            if ( (LA13_34==17) ) {
                                                                int LA13_36 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt13=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 17:
                                                    {
                                                    int LA13_30 = input.LA(10);

                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                        alt13=1;
                                                    }


                                                    }
                                                    break;

                                                }

                                            }


                                        }


                                        }
                                        break;
                                    case 17:
                                        {
                                        int LA13_22 = input.LA(7);

                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                            alt13=1;
                                        }


                                        }
                                        break;

                                    }

                                }
                                else if ( (LA13_15==11) ) {
                                    int LA13_18 = input.LA(6);

                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                        alt13=1;
                                    }


                                }


                            }


                        }
                        else if ( (LA13_12==RULE_ID) ) {
                            int LA13_15 = input.LA(4);

                            if ( (LA13_15==16) ) {
                                switch ( input.LA(5) ) {
                                case 19:
                                    {
                                    int LA13_20 = input.LA(6);

                                    if ( (LA13_20==RULE_STRING) ) {
                                        int LA13_23 = input.LA(7);

                                        if ( (LA13_23==11) ) {
                                            switch ( input.LA(8) ) {
                                            case 19:
                                                {
                                                int LA13_27 = input.LA(9);

                                                if ( (LA13_27==RULE_STRING) ) {
                                                    int LA13_31 = input.LA(10);

                                                    if ( (LA13_31==11) ) {
                                                        int LA13_33 = input.LA(11);

                                                        if ( (LA13_33==17) ) {
                                                            int LA13_35 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt13=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 20:
                                                {
                                                int LA13_28 = input.LA(9);

                                                if ( (LA13_28==RULE_STRING) ) {
                                                    int LA13_32 = input.LA(10);

                                                    if ( (LA13_32==11) ) {
                                                        int LA13_34 = input.LA(11);

                                                        if ( (LA13_34==17) ) {
                                                            int LA13_36 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt13=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 17:
                                                {
                                                int LA13_29 = input.LA(9);

                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                    alt13=1;
                                                }


                                                }
                                                break;

                                            }

                                        }


                                    }


                                    }
                                    break;
                                case 20:
                                    {
                                    int LA13_21 = input.LA(6);

                                    if ( (LA13_21==RULE_STRING) ) {
                                        int LA13_24 = input.LA(7);

                                        if ( (LA13_24==11) ) {
                                            switch ( input.LA(8) ) {
                                            case 19:
                                                {
                                                int LA13_27 = input.LA(9);

                                                if ( (LA13_27==RULE_STRING) ) {
                                                    int LA13_31 = input.LA(10);

                                                    if ( (LA13_31==11) ) {
                                                        int LA13_33 = input.LA(11);

                                                        if ( (LA13_33==17) ) {
                                                            int LA13_35 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt13=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 20:
                                                {
                                                int LA13_28 = input.LA(9);

                                                if ( (LA13_28==RULE_STRING) ) {
                                                    int LA13_32 = input.LA(10);

                                                    if ( (LA13_32==11) ) {
                                                        int LA13_34 = input.LA(11);

                                                        if ( (LA13_34==17) ) {
                                                            int LA13_36 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt13=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 17:
                                                {
                                                int LA13_30 = input.LA(9);

                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                    alt13=1;
                                                }


                                                }
                                                break;

                                            }

                                        }


                                    }


                                    }
                                    break;
                                case 17:
                                    {
                                    int LA13_22 = input.LA(6);

                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                        alt13=1;
                                    }


                                    }
                                    break;

                                }

                            }
                            else if ( (LA13_15==11) ) {
                                int LA13_18 = input.LA(5);

                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                    alt13=1;
                                }


                            }


                        }


                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1274:2: rule__Object__FeaturesAssignment_5_6_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_6_1_in_rule__Object__Group_5_6__12498);
            	    rule__Object__FeaturesAssignment_5_6_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__Group_5_6__1


    // $ANTLR start rule__Object__Group_5_7__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1288:1: rule__Object__Group_5_7__0 : ( 'mandatoryLoop' ) rule__Object__Group_5_7__1 ;
    public final void rule__Object__Group_5_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1292:1: ( ( 'mandatoryLoop' ) rule__Object__Group_5_7__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1293:1: ( 'mandatoryLoop' ) rule__Object__Group_5_7__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1293:1: ( 'mandatoryLoop' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1294:1: 'mandatoryLoop'
            {
             before(grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Object__Group_5_7__02538); 
             after(grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_7__1_in_rule__Object__Group_5_7__02548);
            rule__Object__Group_5_7__1();
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
    // $ANTLR end rule__Object__Group_5_7__0


    // $ANTLR start rule__Object__Group_5_7__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1308:1: rule__Object__Group_5_7__1 : ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) ) ;
    public final void rule__Object__Group_5_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1312:1: ( ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1313:1: ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1313:1: ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1314:1: ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1314:1: ( ( rule__Object__FeaturesAssignment_5_7_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1315:1: ( rule__Object__FeaturesAssignment_5_7_1 )
            {
             before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1316:1: ( rule__Object__FeaturesAssignment_5_7_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1316:2: rule__Object__FeaturesAssignment_5_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_7_1_in_rule__Object__Group_5_7__12578);
            rule__Object__FeaturesAssignment_5_7_1();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1319:1: ( ( rule__Object__FeaturesAssignment_5_7_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1320:1: ( rule__Object__FeaturesAssignment_5_7_1 )*
            {
             before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1321:1: ( rule__Object__FeaturesAssignment_5_7_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==26) ) {
                    int LA14_5 = input.LA(2);

                    if ( (LA14_5==RULE_ID) ) {
                        int LA14_11 = input.LA(3);

                        if ( (LA14_11==RULE_ID) ) {
                            int LA14_13 = input.LA(4);

                            if ( (LA14_13==11) ) {
                                int LA14_16 = input.LA(5);

                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                    alt14=1;
                                }


                            }


                        }


                    }


                }
                else if ( (LA14_0==27) ) {
                    int LA14_6 = input.LA(2);

                    if ( (LA14_6==RULE_ID) ) {
                        int LA14_12 = input.LA(3);

                        if ( (LA14_12==34) ) {
                            int LA14_14 = input.LA(4);

                            if ( (LA14_14==RULE_ID) ) {
                                int LA14_15 = input.LA(5);

                                if ( (LA14_15==16) ) {
                                    switch ( input.LA(6) ) {
                                    case 19:
                                        {
                                        int LA14_20 = input.LA(7);

                                        if ( (LA14_20==RULE_STRING) ) {
                                            int LA14_23 = input.LA(8);

                                            if ( (LA14_23==11) ) {
                                                switch ( input.LA(9) ) {
                                                case 19:
                                                    {
                                                    int LA14_27 = input.LA(10);

                                                    if ( (LA14_27==RULE_STRING) ) {
                                                        int LA14_31 = input.LA(11);

                                                        if ( (LA14_31==11) ) {
                                                            int LA14_33 = input.LA(12);

                                                            if ( (LA14_33==17) ) {
                                                                int LA14_35 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt14=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 20:
                                                    {
                                                    int LA14_28 = input.LA(10);

                                                    if ( (LA14_28==RULE_STRING) ) {
                                                        int LA14_32 = input.LA(11);

                                                        if ( (LA14_32==11) ) {
                                                            int LA14_34 = input.LA(12);

                                                            if ( (LA14_34==17) ) {
                                                                int LA14_36 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt14=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 17:
                                                    {
                                                    int LA14_29 = input.LA(10);

                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                        alt14=1;
                                                    }


                                                    }
                                                    break;

                                                }

                                            }


                                        }


                                        }
                                        break;
                                    case 20:
                                        {
                                        int LA14_21 = input.LA(7);

                                        if ( (LA14_21==RULE_STRING) ) {
                                            int LA14_24 = input.LA(8);

                                            if ( (LA14_24==11) ) {
                                                switch ( input.LA(9) ) {
                                                case 19:
                                                    {
                                                    int LA14_27 = input.LA(10);

                                                    if ( (LA14_27==RULE_STRING) ) {
                                                        int LA14_31 = input.LA(11);

                                                        if ( (LA14_31==11) ) {
                                                            int LA14_33 = input.LA(12);

                                                            if ( (LA14_33==17) ) {
                                                                int LA14_35 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt14=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 20:
                                                    {
                                                    int LA14_28 = input.LA(10);

                                                    if ( (LA14_28==RULE_STRING) ) {
                                                        int LA14_32 = input.LA(11);

                                                        if ( (LA14_32==11) ) {
                                                            int LA14_34 = input.LA(12);

                                                            if ( (LA14_34==17) ) {
                                                                int LA14_36 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt14=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 17:
                                                    {
                                                    int LA14_30 = input.LA(10);

                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                        alt14=1;
                                                    }


                                                    }
                                                    break;

                                                }

                                            }


                                        }


                                        }
                                        break;
                                    case 17:
                                        {
                                        int LA14_22 = input.LA(7);

                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                            alt14=1;
                                        }


                                        }
                                        break;

                                    }

                                }
                                else if ( (LA14_15==11) ) {
                                    int LA14_18 = input.LA(6);

                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                        alt14=1;
                                    }


                                }


                            }


                        }
                        else if ( (LA14_12==RULE_ID) ) {
                            int LA14_15 = input.LA(4);

                            if ( (LA14_15==16) ) {
                                switch ( input.LA(5) ) {
                                case 19:
                                    {
                                    int LA14_20 = input.LA(6);

                                    if ( (LA14_20==RULE_STRING) ) {
                                        int LA14_23 = input.LA(7);

                                        if ( (LA14_23==11) ) {
                                            switch ( input.LA(8) ) {
                                            case 19:
                                                {
                                                int LA14_27 = input.LA(9);

                                                if ( (LA14_27==RULE_STRING) ) {
                                                    int LA14_31 = input.LA(10);

                                                    if ( (LA14_31==11) ) {
                                                        int LA14_33 = input.LA(11);

                                                        if ( (LA14_33==17) ) {
                                                            int LA14_35 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt14=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 20:
                                                {
                                                int LA14_28 = input.LA(9);

                                                if ( (LA14_28==RULE_STRING) ) {
                                                    int LA14_32 = input.LA(10);

                                                    if ( (LA14_32==11) ) {
                                                        int LA14_34 = input.LA(11);

                                                        if ( (LA14_34==17) ) {
                                                            int LA14_36 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt14=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 17:
                                                {
                                                int LA14_29 = input.LA(9);

                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                    alt14=1;
                                                }


                                                }
                                                break;

                                            }

                                        }


                                    }


                                    }
                                    break;
                                case 20:
                                    {
                                    int LA14_21 = input.LA(6);

                                    if ( (LA14_21==RULE_STRING) ) {
                                        int LA14_24 = input.LA(7);

                                        if ( (LA14_24==11) ) {
                                            switch ( input.LA(8) ) {
                                            case 19:
                                                {
                                                int LA14_27 = input.LA(9);

                                                if ( (LA14_27==RULE_STRING) ) {
                                                    int LA14_31 = input.LA(10);

                                                    if ( (LA14_31==11) ) {
                                                        int LA14_33 = input.LA(11);

                                                        if ( (LA14_33==17) ) {
                                                            int LA14_35 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt14=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 20:
                                                {
                                                int LA14_28 = input.LA(9);

                                                if ( (LA14_28==RULE_STRING) ) {
                                                    int LA14_32 = input.LA(10);

                                                    if ( (LA14_32==11) ) {
                                                        int LA14_34 = input.LA(11);

                                                        if ( (LA14_34==17) ) {
                                                            int LA14_36 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt14=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 17:
                                                {
                                                int LA14_30 = input.LA(9);

                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                    alt14=1;
                                                }


                                                }
                                                break;

                                            }

                                        }


                                    }


                                    }
                                    break;
                                case 17:
                                    {
                                    int LA14_22 = input.LA(6);

                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                        alt14=1;
                                    }


                                    }
                                    break;

                                }

                            }
                            else if ( (LA14_15==11) ) {
                                int LA14_18 = input.LA(5);

                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                    alt14=1;
                                }


                            }


                        }


                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1321:2: rule__Object__FeaturesAssignment_5_7_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_7_1_in_rule__Object__Group_5_7__12590);
            	    rule__Object__FeaturesAssignment_5_7_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 

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
    // $ANTLR end rule__Object__Group_5_7__1


    // $ANTLR start rule__Attribute__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1336:1: rule__Attribute__Group__0 : ( 'Attribute' ) rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1340:1: ( ( 'Attribute' ) rule__Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1341:1: ( 'Attribute' ) rule__Attribute__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1341:1: ( 'Attribute' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1342:1: 'Attribute'
            {
             before(grammarAccess.getAttributeAccess().getAttributeKeyword_0()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Attribute__Group__02632); 
             after(grammarAccess.getAttributeAccess().getAttributeKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__02642);
            rule__Attribute__Group__1();
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
    // $ANTLR end rule__Attribute__Group__0


    // $ANTLR start rule__Attribute__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1356:1: rule__Attribute__Group__1 : ( ( rule__Attribute__TypeAssignment_1 ) ) rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1360:1: ( ( ( rule__Attribute__TypeAssignment_1 ) ) rule__Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1361:1: ( ( rule__Attribute__TypeAssignment_1 ) ) rule__Attribute__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1361:1: ( ( rule__Attribute__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1362:1: ( rule__Attribute__TypeAssignment_1 )
            {
             before(grammarAccess.getAttributeAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1363:1: ( rule__Attribute__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1363:2: rule__Attribute__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__TypeAssignment_1_in_rule__Attribute__Group__12670);
            rule__Attribute__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__12679);
            rule__Attribute__Group__2();
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
    // $ANTLR end rule__Attribute__Group__1


    // $ANTLR start rule__Attribute__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1374:1: rule__Attribute__Group__2 : ( ( rule__Attribute__NameAssignment_2 ) ) rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1378:1: ( ( ( rule__Attribute__NameAssignment_2 ) ) rule__Attribute__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1379:1: ( ( rule__Attribute__NameAssignment_2 ) ) rule__Attribute__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1379:1: ( ( rule__Attribute__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1380:1: ( rule__Attribute__NameAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1381:1: ( rule__Attribute__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1381:2: rule__Attribute__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__NameAssignment_2_in_rule__Attribute__Group__22707);
            rule__Attribute__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__3_in_rule__Attribute__Group__22716);
            rule__Attribute__Group__3();
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
    // $ANTLR end rule__Attribute__Group__2


    // $ANTLR start rule__Attribute__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1392:1: rule__Attribute__Group__3 : ( ';' ) ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1396:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1397:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1397:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1398:1: ';'
            {
             before(grammarAccess.getAttributeAccess().getSemicolonKeyword_3()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Attribute__Group__32745); 
             after(grammarAccess.getAttributeAccess().getSemicolonKeyword_3()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1419:1: rule__Reference__Group__0 : ( 'Reference' ) rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1423:1: ( ( 'Reference' ) rule__Reference__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1424:1: ( 'Reference' ) rule__Reference__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1424:1: ( 'Reference' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1425:1: 'Reference'
            {
             before(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Reference__Group__02789); 
             after(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__02799);
            rule__Reference__Group__1();
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
    // $ANTLR end rule__Reference__Group__0


    // $ANTLR start rule__Reference__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1439:1: rule__Reference__Group__1 : ( ( rule__Reference__TypeAssignment_1 ) ) rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1443:1: ( ( ( rule__Reference__TypeAssignment_1 ) ) rule__Reference__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1444:1: ( ( rule__Reference__TypeAssignment_1 ) ) rule__Reference__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1444:1: ( ( rule__Reference__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1445:1: ( rule__Reference__TypeAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1446:1: ( rule__Reference__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1446:2: rule__Reference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__TypeAssignment_1_in_rule__Reference__Group__12827);
            rule__Reference__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__12836);
            rule__Reference__Group__2();
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
    // $ANTLR end rule__Reference__Group__1


    // $ANTLR start rule__Reference__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1457:1: rule__Reference__Group__2 : ( ( rule__Reference__ManyAssignment_2 )? ) rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1461:1: ( ( ( rule__Reference__ManyAssignment_2 )? ) rule__Reference__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1462:1: ( ( rule__Reference__ManyAssignment_2 )? ) rule__Reference__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1462:1: ( ( rule__Reference__ManyAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1463:1: ( rule__Reference__ManyAssignment_2 )?
            {
             before(grammarAccess.getReferenceAccess().getManyAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1464:1: ( rule__Reference__ManyAssignment_2 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1464:2: rule__Reference__ManyAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__ManyAssignment_2_in_rule__Reference__Group__22864);
                    rule__Reference__ManyAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferenceAccess().getManyAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__22874);
            rule__Reference__Group__3();
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
    // $ANTLR end rule__Reference__Group__2


    // $ANTLR start rule__Reference__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1475:1: rule__Reference__Group__3 : ( ( rule__Reference__NameAssignment_3 ) ) rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1479:1: ( ( ( rule__Reference__NameAssignment_3 ) ) rule__Reference__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1480:1: ( ( rule__Reference__NameAssignment_3 ) ) rule__Reference__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1480:1: ( ( rule__Reference__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1481:1: ( rule__Reference__NameAssignment_3 )
            {
             before(grammarAccess.getReferenceAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1482:1: ( rule__Reference__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1482:2: rule__Reference__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__NameAssignment_3_in_rule__Reference__Group__32902);
            rule__Reference__NameAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getNameAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__32911);
            rule__Reference__Group__4();
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
    // $ANTLR end rule__Reference__Group__3


    // $ANTLR start rule__Reference__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1493:1: rule__Reference__Group__4 : ( ( rule__Reference__Alternatives_4 ) ) ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1497:1: ( ( ( rule__Reference__Alternatives_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1498:1: ( ( rule__Reference__Alternatives_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1498:1: ( ( rule__Reference__Alternatives_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1499:1: ( rule__Reference__Alternatives_4 )
            {
             before(grammarAccess.getReferenceAccess().getAlternatives_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1500:1: ( rule__Reference__Alternatives_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1500:2: rule__Reference__Alternatives_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__42939);
            rule__Reference__Alternatives_4();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getAlternatives_4()); 

            }


            }

        }
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


    // $ANTLR start rule__Reference__Group_4_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1520:1: rule__Reference__Group_4_0__0 : ( '{' ) rule__Reference__Group_4_0__1 ;
    public final void rule__Reference__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1524:1: ( ( '{' ) rule__Reference__Group_4_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1525:1: ( '{' ) rule__Reference__Group_4_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1525:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1526:1: '{'
            {
             before(grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Reference__Group_4_0__02984); 
             after(grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__02994);
            rule__Reference__Group_4_0__1();
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
    // $ANTLR end rule__Reference__Group_4_0__0


    // $ANTLR start rule__Reference__Group_4_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1540:1: rule__Reference__Group_4_0__1 : ( ( rule__Reference__UnorderedGroup_4_0_1 ) ) rule__Reference__Group_4_0__2 ;
    public final void rule__Reference__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1544:1: ( ( ( rule__Reference__UnorderedGroup_4_0_1 ) ) rule__Reference__Group_4_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1545:1: ( ( rule__Reference__UnorderedGroup_4_0_1 ) ) rule__Reference__Group_4_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1545:1: ( ( rule__Reference__UnorderedGroup_4_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1546:1: ( rule__Reference__UnorderedGroup_4_0_1 )
            {
             before(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1547:1: ( rule__Reference__UnorderedGroup_4_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1547:2: rule__Reference__UnorderedGroup_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__UnorderedGroup_4_0_1_in_rule__Reference__Group_4_0__13022);
            rule__Reference__UnorderedGroup_4_0_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0__2_in_rule__Reference__Group_4_0__13031);
            rule__Reference__Group_4_0__2();
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
    // $ANTLR end rule__Reference__Group_4_0__1


    // $ANTLR start rule__Reference__Group_4_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1558:1: rule__Reference__Group_4_0__2 : ( '}' ) ;
    public final void rule__Reference__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1562:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1563:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1563:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1564:1: '}'
            {
             before(grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Reference__Group_4_0__23060); 
             after(grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group_4_0__2


    // $ANTLR start rule__Reference__Group_4_0_1_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1583:1: rule__Reference__Group_4_0_1_0__0 : ( 'shortDescription' ) rule__Reference__Group_4_0_1_0__1 ;
    public final void rule__Reference__Group_4_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1587:1: ( ( 'shortDescription' ) rule__Reference__Group_4_0_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1588:1: ( 'shortDescription' ) rule__Reference__Group_4_0_1_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1588:1: ( 'shortDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1589:1: 'shortDescription'
            {
             before(grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Reference__Group_4_0_1_0__03102); 
             after(grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_0__1_in_rule__Reference__Group_4_0_1_0__03112);
            rule__Reference__Group_4_0_1_0__1();
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
    // $ANTLR end rule__Reference__Group_4_0_1_0__0


    // $ANTLR start rule__Reference__Group_4_0_1_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1603:1: rule__Reference__Group_4_0_1_0__1 : ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) ) rule__Reference__Group_4_0_1_0__2 ;
    public final void rule__Reference__Group_4_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1607:1: ( ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) ) rule__Reference__Group_4_0_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1608:1: ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) ) rule__Reference__Group_4_0_1_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1608:1: ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1609:1: ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 )
            {
             before(grammarAccess.getReferenceAccess().getShortDescriptionAssignment_4_0_1_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1610:1: ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1610:2: rule__Reference__ShortDescriptionAssignment_4_0_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__ShortDescriptionAssignment_4_0_1_0_1_in_rule__Reference__Group_4_0_1_0__13140);
            rule__Reference__ShortDescriptionAssignment_4_0_1_0_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getShortDescriptionAssignment_4_0_1_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_0__2_in_rule__Reference__Group_4_0_1_0__13149);
            rule__Reference__Group_4_0_1_0__2();
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
    // $ANTLR end rule__Reference__Group_4_0_1_0__1


    // $ANTLR start rule__Reference__Group_4_0_1_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1621:1: rule__Reference__Group_4_0_1_0__2 : ( ';' ) ;
    public final void rule__Reference__Group_4_0_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1625:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1626:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1626:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1627:1: ';'
            {
             before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Reference__Group_4_0_1_0__23178); 
             after(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group_4_0_1_0__2


    // $ANTLR start rule__Reference__Group_4_0_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1646:1: rule__Reference__Group_4_0_1_1__0 : ( 'longDescription' ) rule__Reference__Group_4_0_1_1__1 ;
    public final void rule__Reference__Group_4_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1650:1: ( ( 'longDescription' ) rule__Reference__Group_4_0_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1651:1: ( 'longDescription' ) rule__Reference__Group_4_0_1_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1651:1: ( 'longDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1652:1: 'longDescription'
            {
             before(grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Reference__Group_4_0_1_1__03220); 
             after(grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_1__1_in_rule__Reference__Group_4_0_1_1__03230);
            rule__Reference__Group_4_0_1_1__1();
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
    // $ANTLR end rule__Reference__Group_4_0_1_1__0


    // $ANTLR start rule__Reference__Group_4_0_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1666:1: rule__Reference__Group_4_0_1_1__1 : ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) ) rule__Reference__Group_4_0_1_1__2 ;
    public final void rule__Reference__Group_4_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1670:1: ( ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) ) rule__Reference__Group_4_0_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1671:1: ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) ) rule__Reference__Group_4_0_1_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1671:1: ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1672:1: ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 )
            {
             before(grammarAccess.getReferenceAccess().getLongDescriptionAssignment_4_0_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1673:1: ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1673:2: rule__Reference__LongDescriptionAssignment_4_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__LongDescriptionAssignment_4_0_1_1_1_in_rule__Reference__Group_4_0_1_1__13258);
            rule__Reference__LongDescriptionAssignment_4_0_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getLongDescriptionAssignment_4_0_1_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_1__2_in_rule__Reference__Group_4_0_1_1__13267);
            rule__Reference__Group_4_0_1_1__2();
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
    // $ANTLR end rule__Reference__Group_4_0_1_1__1


    // $ANTLR start rule__Reference__Group_4_0_1_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1684:1: rule__Reference__Group_4_0_1_1__2 : ( ';' ) ;
    public final void rule__Reference__Group_4_0_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1688:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1689:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1689:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1690:1: ';'
            {
             before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Reference__Group_4_0_1_1__23296); 
             after(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group_4_0_1_1__2


    // $ANTLR start rule__PackageDefinition2__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1709:1: rule__PackageDefinition2__Group__0 : ( () ) rule__PackageDefinition2__Group__1 ;
    public final void rule__PackageDefinition2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1713:1: ( ( () ) rule__PackageDefinition2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1714:1: ( () ) rule__PackageDefinition2__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1714:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1715:1: ()
            {
             before(grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1716:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1718:1: 
            {
            }

             after(grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition2__Group__1_in_rule__PackageDefinition2__Group__03347);
            rule__PackageDefinition2__Group__1();
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
    // $ANTLR end rule__PackageDefinition2__Group__0


    // $ANTLR start rule__PackageDefinition2__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1729:1: rule__PackageDefinition2__Group__1 : ( 'package' ) rule__PackageDefinition2__Group__2 ;
    public final void rule__PackageDefinition2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1733:1: ( ( 'package' ) rule__PackageDefinition2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1734:1: ( 'package' ) rule__PackageDefinition2__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1734:1: ( 'package' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1735:1: 'package'
            {
             before(grammarAccess.getPackageDefinition2Access().getPackageKeyword_1()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__PackageDefinition2__Group__13376); 
             after(grammarAccess.getPackageDefinition2Access().getPackageKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition2__Group__2_in_rule__PackageDefinition2__Group__13386);
            rule__PackageDefinition2__Group__2();
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
    // $ANTLR end rule__PackageDefinition2__Group__1


    // $ANTLR start rule__PackageDefinition2__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1749:1: rule__PackageDefinition2__Group__2 : ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) ) rule__PackageDefinition2__Group__3 ;
    public final void rule__PackageDefinition2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1753:1: ( ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) ) rule__PackageDefinition2__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1754:1: ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) ) rule__PackageDefinition2__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1754:1: ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1755:1: ( rule__PackageDefinition2__NamespaceAssignment_2 )
            {
             before(grammarAccess.getPackageDefinition2Access().getNamespaceAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1756:1: ( rule__PackageDefinition2__NamespaceAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1756:2: rule__PackageDefinition2__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition2__NamespaceAssignment_2_in_rule__PackageDefinition2__Group__23414);
            rule__PackageDefinition2__NamespaceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getPackageDefinition2Access().getNamespaceAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition2__Group__3_in_rule__PackageDefinition2__Group__23423);
            rule__PackageDefinition2__Group__3();
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
    // $ANTLR end rule__PackageDefinition2__Group__2


    // $ANTLR start rule__PackageDefinition2__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1767:1: rule__PackageDefinition2__Group__3 : ( ';' ) rule__PackageDefinition2__Group__4 ;
    public final void rule__PackageDefinition2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1771:1: ( ( ';' ) rule__PackageDefinition2__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1772:1: ( ';' ) rule__PackageDefinition2__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1772:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1773:1: ';'
            {
             before(grammarAccess.getPackageDefinition2Access().getSemicolonKeyword_3()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__PackageDefinition2__Group__33452); 
             after(grammarAccess.getPackageDefinition2Access().getSemicolonKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition2__Group__4_in_rule__PackageDefinition2__Group__33462);
            rule__PackageDefinition2__Group__4();
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
    // $ANTLR end rule__PackageDefinition2__Group__3


    // $ANTLR start rule__PackageDefinition2__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1787:1: rule__PackageDefinition2__Group__4 : ( ( rule__PackageDefinition2__ContentsAssignment_4 )* ) ;
    public final void rule__PackageDefinition2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1791:1: ( ( ( rule__PackageDefinition2__ContentsAssignment_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1792:1: ( ( rule__PackageDefinition2__ContentsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1792:1: ( ( rule__PackageDefinition2__ContentsAssignment_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1793:1: ( rule__PackageDefinition2__ContentsAssignment_4 )*
            {
             before(grammarAccess.getPackageDefinition2Access().getContentsAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1794:1: ( rule__PackageDefinition2__ContentsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==15||(LA16_0>=31 && LA16_0<=32)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1794:2: rule__PackageDefinition2__ContentsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition2__ContentsAssignment_4_in_rule__PackageDefinition2__Group__43490);
            	    rule__PackageDefinition2__ContentsAssignment_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getPackageDefinition2Access().getContentsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDefinition2__Group__4


    // $ANTLR start rule__Object2__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1814:1: rule__Object2__Group__0 : ( ( rule__Object2__Alternatives_0 )? ) rule__Object2__Group__1 ;
    public final void rule__Object2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1818:1: ( ( ( rule__Object2__Alternatives_0 )? ) rule__Object2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1819:1: ( ( rule__Object2__Alternatives_0 )? ) rule__Object2__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1819:1: ( ( rule__Object2__Alternatives_0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1820:1: ( rule__Object2__Alternatives_0 )?
            {
             before(grammarAccess.getObject2Access().getAlternatives_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1821:1: ( rule__Object2__Alternatives_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=31 && LA17_0<=32)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1821:2: rule__Object2__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__Alternatives_0_in_rule__Object2__Group__03535);
                    rule__Object2__Alternatives_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObject2Access().getAlternatives_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group__1_in_rule__Object2__Group__03545);
            rule__Object2__Group__1();
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
    // $ANTLR end rule__Object2__Group__0


    // $ANTLR start rule__Object2__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1832:1: rule__Object2__Group__1 : ( 'object' ) rule__Object2__Group__2 ;
    public final void rule__Object2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1836:1: ( ( 'object' ) rule__Object2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1837:1: ( 'object' ) rule__Object2__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1837:1: ( 'object' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1838:1: 'object'
            {
             before(grammarAccess.getObject2Access().getObjectKeyword_1()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Object2__Group__13574); 
             after(grammarAccess.getObject2Access().getObjectKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group__2_in_rule__Object2__Group__13584);
            rule__Object2__Group__2();
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
    // $ANTLR end rule__Object2__Group__1


    // $ANTLR start rule__Object2__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1852:1: rule__Object2__Group__2 : ( ( rule__Object2__NameAssignment_2 ) ) rule__Object2__Group__3 ;
    public final void rule__Object2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1856:1: ( ( ( rule__Object2__NameAssignment_2 ) ) rule__Object2__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1857:1: ( ( rule__Object2__NameAssignment_2 ) ) rule__Object2__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1857:1: ( ( rule__Object2__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1858:1: ( rule__Object2__NameAssignment_2 )
            {
             before(grammarAccess.getObject2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1859:1: ( rule__Object2__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1859:2: rule__Object2__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__NameAssignment_2_in_rule__Object2__Group__23612);
            rule__Object2__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getObject2Access().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group__3_in_rule__Object2__Group__23621);
            rule__Object2__Group__3();
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
    // $ANTLR end rule__Object2__Group__2


    // $ANTLR start rule__Object2__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1870:1: rule__Object2__Group__3 : ( ( rule__Object2__Group_3__0 )? ) rule__Object2__Group__4 ;
    public final void rule__Object2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1874:1: ( ( ( rule__Object2__Group_3__0 )? ) rule__Object2__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1875:1: ( ( rule__Object2__Group_3__0 )? ) rule__Object2__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1875:1: ( ( rule__Object2__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1876:1: ( rule__Object2__Group_3__0 )?
            {
             before(grammarAccess.getObject2Access().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1877:1: ( rule__Object2__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1877:2: rule__Object2__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_3__0_in_rule__Object2__Group__33649);
                    rule__Object2__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObject2Access().getGroup_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group__4_in_rule__Object2__Group__33659);
            rule__Object2__Group__4();
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
    // $ANTLR end rule__Object2__Group__3


    // $ANTLR start rule__Object2__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1888:1: rule__Object2__Group__4 : ( '{' ) rule__Object2__Group__5 ;
    public final void rule__Object2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1892:1: ( ( '{' ) rule__Object2__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1893:1: ( '{' ) rule__Object2__Group__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1893:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1894:1: '{'
            {
             before(grammarAccess.getObject2Access().getLeftCurlyBracketKeyword_4()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Object2__Group__43688); 
             after(grammarAccess.getObject2Access().getLeftCurlyBracketKeyword_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group__5_in_rule__Object2__Group__43698);
            rule__Object2__Group__5();
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
    // $ANTLR end rule__Object2__Group__4


    // $ANTLR start rule__Object2__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1908:1: rule__Object2__Group__5 : ( ( rule__Object2__UnorderedGroup_5 ) ) rule__Object2__Group__6 ;
    public final void rule__Object2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1912:1: ( ( ( rule__Object2__UnorderedGroup_5 ) ) rule__Object2__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1913:1: ( ( rule__Object2__UnorderedGroup_5 ) ) rule__Object2__Group__6
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1913:1: ( ( rule__Object2__UnorderedGroup_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1914:1: ( rule__Object2__UnorderedGroup_5 )
            {
             before(grammarAccess.getObject2Access().getUnorderedGroup_5()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1915:1: ( rule__Object2__UnorderedGroup_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1915:2: rule__Object2__UnorderedGroup_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5_in_rule__Object2__Group__53726);
            rule__Object2__UnorderedGroup_5();
            _fsp--;


            }

             after(grammarAccess.getObject2Access().getUnorderedGroup_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group__6_in_rule__Object2__Group__53735);
            rule__Object2__Group__6();
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
    // $ANTLR end rule__Object2__Group__5


    // $ANTLR start rule__Object2__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1926:1: rule__Object2__Group__6 : ( '}' ) ;
    public final void rule__Object2__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1930:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1931:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1931:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1932:1: '}'
            {
             before(grammarAccess.getObject2Access().getRightCurlyBracketKeyword_6()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Object2__Group__63764); 
             after(grammarAccess.getObject2Access().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__Group__6


    // $ANTLR start rule__Object2__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1959:1: rule__Object2__Group_3__0 : ( 'extends' ) rule__Object2__Group_3__1 ;
    public final void rule__Object2__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1963:1: ( ( 'extends' ) rule__Object2__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1964:1: ( 'extends' ) rule__Object2__Group_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1964:1: ( 'extends' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1965:1: 'extends'
            {
             before(grammarAccess.getObject2Access().getExtendsKeyword_3_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Object2__Group_3__03814); 
             after(grammarAccess.getObject2Access().getExtendsKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_3__1_in_rule__Object2__Group_3__03824);
            rule__Object2__Group_3__1();
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
    // $ANTLR end rule__Object2__Group_3__0


    // $ANTLR start rule__Object2__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1979:1: rule__Object2__Group_3__1 : ( ( rule__Object2__ParentAssignment_3_1 ) ) ;
    public final void rule__Object2__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1983:1: ( ( ( rule__Object2__ParentAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1984:1: ( ( rule__Object2__ParentAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1984:1: ( ( rule__Object2__ParentAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1985:1: ( rule__Object2__ParentAssignment_3_1 )
            {
             before(grammarAccess.getObject2Access().getParentAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1986:1: ( rule__Object2__ParentAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1986:2: rule__Object2__ParentAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__ParentAssignment_3_1_in_rule__Object2__Group_3__13852);
            rule__Object2__ParentAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getObject2Access().getParentAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__Group_3__1


    // $ANTLR start rule__Object2__Group_5_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2000:1: rule__Object2__Group_5_0__0 : ( 'shortDescription' ) rule__Object2__Group_5_0__1 ;
    public final void rule__Object2__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2004:1: ( ( 'shortDescription' ) rule__Object2__Group_5_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2005:1: ( 'shortDescription' ) rule__Object2__Group_5_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2005:1: ( 'shortDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2006:1: 'shortDescription'
            {
             before(grammarAccess.getObject2Access().getShortDescriptionKeyword_5_0_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Object2__Group_5_0__03891); 
             after(grammarAccess.getObject2Access().getShortDescriptionKeyword_5_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_0__1_in_rule__Object2__Group_5_0__03901);
            rule__Object2__Group_5_0__1();
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
    // $ANTLR end rule__Object2__Group_5_0__0


    // $ANTLR start rule__Object2__Group_5_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2020:1: rule__Object2__Group_5_0__1 : ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) ) rule__Object2__Group_5_0__2 ;
    public final void rule__Object2__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2024:1: ( ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) ) rule__Object2__Group_5_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2025:1: ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) ) rule__Object2__Group_5_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2025:1: ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2026:1: ( rule__Object2__ShortDescriptionAssignment_5_0_1 )
            {
             before(grammarAccess.getObject2Access().getShortDescriptionAssignment_5_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2027:1: ( rule__Object2__ShortDescriptionAssignment_5_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2027:2: rule__Object2__ShortDescriptionAssignment_5_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__ShortDescriptionAssignment_5_0_1_in_rule__Object2__Group_5_0__13929);
            rule__Object2__ShortDescriptionAssignment_5_0_1();
            _fsp--;


            }

             after(grammarAccess.getObject2Access().getShortDescriptionAssignment_5_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_0__2_in_rule__Object2__Group_5_0__13938);
            rule__Object2__Group_5_0__2();
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
    // $ANTLR end rule__Object2__Group_5_0__1


    // $ANTLR start rule__Object2__Group_5_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2038:1: rule__Object2__Group_5_0__2 : ( ';' ) ;
    public final void rule__Object2__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2042:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2043:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2043:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2044:1: ';'
            {
             before(grammarAccess.getObject2Access().getSemicolonKeyword_5_0_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object2__Group_5_0__23967); 
             after(grammarAccess.getObject2Access().getSemicolonKeyword_5_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__Group_5_0__2


    // $ANTLR start rule__Object2__Group_5_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2063:1: rule__Object2__Group_5_1__0 : ( 'longDescription' ) rule__Object2__Group_5_1__1 ;
    public final void rule__Object2__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2067:1: ( ( 'longDescription' ) rule__Object2__Group_5_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2068:1: ( 'longDescription' ) rule__Object2__Group_5_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2068:1: ( 'longDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2069:1: 'longDescription'
            {
             before(grammarAccess.getObject2Access().getLongDescriptionKeyword_5_1_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Object2__Group_5_1__04009); 
             after(grammarAccess.getObject2Access().getLongDescriptionKeyword_5_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_1__1_in_rule__Object2__Group_5_1__04019);
            rule__Object2__Group_5_1__1();
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
    // $ANTLR end rule__Object2__Group_5_1__0


    // $ANTLR start rule__Object2__Group_5_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2083:1: rule__Object2__Group_5_1__1 : ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) ) rule__Object2__Group_5_1__2 ;
    public final void rule__Object2__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2087:1: ( ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) ) rule__Object2__Group_5_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2088:1: ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) ) rule__Object2__Group_5_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2088:1: ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2089:1: ( rule__Object2__LongDescriptionAssignment_5_1_1 )
            {
             before(grammarAccess.getObject2Access().getLongDescriptionAssignment_5_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2090:1: ( rule__Object2__LongDescriptionAssignment_5_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2090:2: rule__Object2__LongDescriptionAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__LongDescriptionAssignment_5_1_1_in_rule__Object2__Group_5_1__14047);
            rule__Object2__LongDescriptionAssignment_5_1_1();
            _fsp--;


            }

             after(grammarAccess.getObject2Access().getLongDescriptionAssignment_5_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_1__2_in_rule__Object2__Group_5_1__14056);
            rule__Object2__Group_5_1__2();
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
    // $ANTLR end rule__Object2__Group_5_1__1


    // $ANTLR start rule__Object2__Group_5_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2101:1: rule__Object2__Group_5_1__2 : ( ';' ) ;
    public final void rule__Object2__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2105:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2106:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2106:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2107:1: ';'
            {
             before(grammarAccess.getObject2Access().getSemicolonKeyword_5_1_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object2__Group_5_1__24085); 
             after(grammarAccess.getObject2Access().getSemicolonKeyword_5_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__Group_5_1__2


    // $ANTLR start rule__Object2__Group_5_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2126:1: rule__Object2__Group_5_2__0 : ( 'serialUID' ) rule__Object2__Group_5_2__1 ;
    public final void rule__Object2__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2130:1: ( ( 'serialUID' ) rule__Object2__Group_5_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2131:1: ( 'serialUID' ) rule__Object2__Group_5_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2131:1: ( 'serialUID' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2132:1: 'serialUID'
            {
             before(grammarAccess.getObject2Access().getSerialUIDKeyword_5_2_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Object2__Group_5_2__04127); 
             after(grammarAccess.getObject2Access().getSerialUIDKeyword_5_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_2__1_in_rule__Object2__Group_5_2__04137);
            rule__Object2__Group_5_2__1();
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
    // $ANTLR end rule__Object2__Group_5_2__0


    // $ANTLR start rule__Object2__Group_5_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2146:1: rule__Object2__Group_5_2__1 : ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) ) rule__Object2__Group_5_2__2 ;
    public final void rule__Object2__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2150:1: ( ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) ) rule__Object2__Group_5_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2151:1: ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) ) rule__Object2__Group_5_2__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2151:1: ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2152:1: ( rule__Object2__SerialVersionUIDAssignment_5_2_1 )
            {
             before(grammarAccess.getObject2Access().getSerialVersionUIDAssignment_5_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2153:1: ( rule__Object2__SerialVersionUIDAssignment_5_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2153:2: rule__Object2__SerialVersionUIDAssignment_5_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__SerialVersionUIDAssignment_5_2_1_in_rule__Object2__Group_5_2__14165);
            rule__Object2__SerialVersionUIDAssignment_5_2_1();
            _fsp--;


            }

             after(grammarAccess.getObject2Access().getSerialVersionUIDAssignment_5_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_2__2_in_rule__Object2__Group_5_2__14174);
            rule__Object2__Group_5_2__2();
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
    // $ANTLR end rule__Object2__Group_5_2__1


    // $ANTLR start rule__Object2__Group_5_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2164:1: rule__Object2__Group_5_2__2 : ( ';' ) ;
    public final void rule__Object2__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2168:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2169:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2169:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2170:1: ';'
            {
             before(grammarAccess.getObject2Access().getSemicolonKeyword_5_2_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object2__Group_5_2__24203); 
             after(grammarAccess.getObject2Access().getSemicolonKeyword_5_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__Group_5_2__2


    // $ANTLR start rule__Object2__Group_5_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2189:1: rule__Object2__Group_5_3__0 : ( ( rule__Object2__CloneableAssignment_5_3_0 ) ) rule__Object2__Group_5_3__1 ;
    public final void rule__Object2__Group_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2193:1: ( ( ( rule__Object2__CloneableAssignment_5_3_0 ) ) rule__Object2__Group_5_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2194:1: ( ( rule__Object2__CloneableAssignment_5_3_0 ) ) rule__Object2__Group_5_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2194:1: ( ( rule__Object2__CloneableAssignment_5_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2195:1: ( rule__Object2__CloneableAssignment_5_3_0 )
            {
             before(grammarAccess.getObject2Access().getCloneableAssignment_5_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2196:1: ( rule__Object2__CloneableAssignment_5_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2196:2: rule__Object2__CloneableAssignment_5_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__CloneableAssignment_5_3_0_in_rule__Object2__Group_5_3__04244);
            rule__Object2__CloneableAssignment_5_3_0();
            _fsp--;


            }

             after(grammarAccess.getObject2Access().getCloneableAssignment_5_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_3__1_in_rule__Object2__Group_5_3__04253);
            rule__Object2__Group_5_3__1();
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
    // $ANTLR end rule__Object2__Group_5_3__0


    // $ANTLR start rule__Object2__Group_5_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2207:1: rule__Object2__Group_5_3__1 : ( ';' ) ;
    public final void rule__Object2__Group_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2211:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2212:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2212:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2213:1: ';'
            {
             before(grammarAccess.getObject2Access().getSemicolonKeyword_5_3_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object2__Group_5_3__14282); 
             after(grammarAccess.getObject2Access().getSemicolonKeyword_5_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__Group_5_3__1


    // $ANTLR start rule__Attribute2__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2230:1: rule__Attribute2__Group__0 : ( 'Attribute' ) rule__Attribute2__Group__1 ;
    public final void rule__Attribute2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2234:1: ( ( 'Attribute' ) rule__Attribute2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2235:1: ( 'Attribute' ) rule__Attribute2__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2235:1: ( 'Attribute' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2236:1: 'Attribute'
            {
             before(grammarAccess.getAttribute2Access().getAttributeKeyword_0()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Attribute2__Group__04322); 
             after(grammarAccess.getAttribute2Access().getAttributeKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group__1_in_rule__Attribute2__Group__04332);
            rule__Attribute2__Group__1();
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
    // $ANTLR end rule__Attribute2__Group__0


    // $ANTLR start rule__Attribute2__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2250:1: rule__Attribute2__Group__1 : ( ( rule__Attribute2__TypeAssignment_1 ) ) rule__Attribute2__Group__2 ;
    public final void rule__Attribute2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2254:1: ( ( ( rule__Attribute2__TypeAssignment_1 ) ) rule__Attribute2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2255:1: ( ( rule__Attribute2__TypeAssignment_1 ) ) rule__Attribute2__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2255:1: ( ( rule__Attribute2__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2256:1: ( rule__Attribute2__TypeAssignment_1 )
            {
             before(grammarAccess.getAttribute2Access().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2257:1: ( rule__Attribute2__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2257:2: rule__Attribute2__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__TypeAssignment_1_in_rule__Attribute2__Group__14360);
            rule__Attribute2__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getAttribute2Access().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group__2_in_rule__Attribute2__Group__14369);
            rule__Attribute2__Group__2();
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
    // $ANTLR end rule__Attribute2__Group__1


    // $ANTLR start rule__Attribute2__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2268:1: rule__Attribute2__Group__2 : ( ( rule__Attribute2__NameAssignment_2 ) ) rule__Attribute2__Group__3 ;
    public final void rule__Attribute2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2272:1: ( ( ( rule__Attribute2__NameAssignment_2 ) ) rule__Attribute2__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2273:1: ( ( rule__Attribute2__NameAssignment_2 ) ) rule__Attribute2__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2273:1: ( ( rule__Attribute2__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2274:1: ( rule__Attribute2__NameAssignment_2 )
            {
             before(grammarAccess.getAttribute2Access().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2275:1: ( rule__Attribute2__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2275:2: rule__Attribute2__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__NameAssignment_2_in_rule__Attribute2__Group__24397);
            rule__Attribute2__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getAttribute2Access().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group__3_in_rule__Attribute2__Group__24406);
            rule__Attribute2__Group__3();
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
    // $ANTLR end rule__Attribute2__Group__2


    // $ANTLR start rule__Attribute2__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2286:1: rule__Attribute2__Group__3 : ( ( rule__Attribute2__Alternatives_3 ) ) ;
    public final void rule__Attribute2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2290:1: ( ( ( rule__Attribute2__Alternatives_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2291:1: ( ( rule__Attribute2__Alternatives_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2291:1: ( ( rule__Attribute2__Alternatives_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2292:1: ( rule__Attribute2__Alternatives_3 )
            {
             before(grammarAccess.getAttribute2Access().getAlternatives_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2293:1: ( rule__Attribute2__Alternatives_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2293:2: rule__Attribute2__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Alternatives_3_in_rule__Attribute2__Group__34434);
            rule__Attribute2__Alternatives_3();
            _fsp--;


            }

             after(grammarAccess.getAttribute2Access().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__Group__3


    // $ANTLR start rule__Attribute2__Group_3_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2311:1: rule__Attribute2__Group_3_0__0 : ( '{' ) rule__Attribute2__Group_3_0__1 ;
    public final void rule__Attribute2__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2315:1: ( ( '{' ) rule__Attribute2__Group_3_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2316:1: ( '{' ) rule__Attribute2__Group_3_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2316:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2317:1: '{'
            {
             before(grammarAccess.getAttribute2Access().getLeftCurlyBracketKeyword_3_0_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Attribute2__Group_3_0__04477); 
             after(grammarAccess.getAttribute2Access().getLeftCurlyBracketKeyword_3_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0__1_in_rule__Attribute2__Group_3_0__04487);
            rule__Attribute2__Group_3_0__1();
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
    // $ANTLR end rule__Attribute2__Group_3_0__0


    // $ANTLR start rule__Attribute2__Group_3_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2331:1: rule__Attribute2__Group_3_0__1 : ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) ) rule__Attribute2__Group_3_0__2 ;
    public final void rule__Attribute2__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2335:1: ( ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) ) rule__Attribute2__Group_3_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2336:1: ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) ) rule__Attribute2__Group_3_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2336:1: ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2337:1: ( rule__Attribute2__UnorderedGroup_3_0_1 )
            {
             before(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2338:1: ( rule__Attribute2__UnorderedGroup_3_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2338:2: rule__Attribute2__UnorderedGroup_3_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1_in_rule__Attribute2__Group_3_0__14515);
            rule__Attribute2__UnorderedGroup_3_0_1();
            _fsp--;


            }

             after(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0__2_in_rule__Attribute2__Group_3_0__14524);
            rule__Attribute2__Group_3_0__2();
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
    // $ANTLR end rule__Attribute2__Group_3_0__1


    // $ANTLR start rule__Attribute2__Group_3_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2349:1: rule__Attribute2__Group_3_0__2 : ( '}' ) ;
    public final void rule__Attribute2__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2353:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2354:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2354:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2355:1: '}'
            {
             before(grammarAccess.getAttribute2Access().getRightCurlyBracketKeyword_3_0_2()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Attribute2__Group_3_0__24553); 
             after(grammarAccess.getAttribute2Access().getRightCurlyBracketKeyword_3_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__Group_3_0__2


    // $ANTLR start rule__Attribute2__Group_3_0_1_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2374:1: rule__Attribute2__Group_3_0_1_0__0 : ( 'shortDescription' ) rule__Attribute2__Group_3_0_1_0__1 ;
    public final void rule__Attribute2__Group_3_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2378:1: ( ( 'shortDescription' ) rule__Attribute2__Group_3_0_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2379:1: ( 'shortDescription' ) rule__Attribute2__Group_3_0_1_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2379:1: ( 'shortDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2380:1: 'shortDescription'
            {
             before(grammarAccess.getAttribute2Access().getShortDescriptionKeyword_3_0_1_0_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Attribute2__Group_3_0_1_0__04595); 
             after(grammarAccess.getAttribute2Access().getShortDescriptionKeyword_3_0_1_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0_1_0__1_in_rule__Attribute2__Group_3_0_1_0__04605);
            rule__Attribute2__Group_3_0_1_0__1();
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
    // $ANTLR end rule__Attribute2__Group_3_0_1_0__0


    // $ANTLR start rule__Attribute2__Group_3_0_1_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2394:1: rule__Attribute2__Group_3_0_1_0__1 : ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) ) rule__Attribute2__Group_3_0_1_0__2 ;
    public final void rule__Attribute2__Group_3_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2398:1: ( ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) ) rule__Attribute2__Group_3_0_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2399:1: ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) ) rule__Attribute2__Group_3_0_1_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2399:1: ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2400:1: ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 )
            {
             before(grammarAccess.getAttribute2Access().getShortDescriptionAssignment_3_0_1_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2401:1: ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2401:2: rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1_in_rule__Attribute2__Group_3_0_1_0__14633);
            rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1();
            _fsp--;


            }

             after(grammarAccess.getAttribute2Access().getShortDescriptionAssignment_3_0_1_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0_1_0__2_in_rule__Attribute2__Group_3_0_1_0__14642);
            rule__Attribute2__Group_3_0_1_0__2();
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
    // $ANTLR end rule__Attribute2__Group_3_0_1_0__1


    // $ANTLR start rule__Attribute2__Group_3_0_1_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2412:1: rule__Attribute2__Group_3_0_1_0__2 : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2416:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2417:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2417:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2418:1: ';'
            {
             before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_0_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Attribute2__Group_3_0_1_0__24671); 
             after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__Group_3_0_1_0__2


    // $ANTLR start rule__Attribute2__Group_3_0_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2437:1: rule__Attribute2__Group_3_0_1_1__0 : ( 'longDescription' ) rule__Attribute2__Group_3_0_1_1__1 ;
    public final void rule__Attribute2__Group_3_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2441:1: ( ( 'longDescription' ) rule__Attribute2__Group_3_0_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2442:1: ( 'longDescription' ) rule__Attribute2__Group_3_0_1_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2442:1: ( 'longDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2443:1: 'longDescription'
            {
             before(grammarAccess.getAttribute2Access().getLongDescriptionKeyword_3_0_1_1_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Attribute2__Group_3_0_1_1__04713); 
             after(grammarAccess.getAttribute2Access().getLongDescriptionKeyword_3_0_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0_1_1__1_in_rule__Attribute2__Group_3_0_1_1__04723);
            rule__Attribute2__Group_3_0_1_1__1();
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
    // $ANTLR end rule__Attribute2__Group_3_0_1_1__0


    // $ANTLR start rule__Attribute2__Group_3_0_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2457:1: rule__Attribute2__Group_3_0_1_1__1 : ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) ) rule__Attribute2__Group_3_0_1_1__2 ;
    public final void rule__Attribute2__Group_3_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2461:1: ( ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) ) rule__Attribute2__Group_3_0_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2462:1: ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) ) rule__Attribute2__Group_3_0_1_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2462:1: ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2463:1: ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 )
            {
             before(grammarAccess.getAttribute2Access().getLongDescriptionAssignment_3_0_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2464:1: ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2464:2: rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1_in_rule__Attribute2__Group_3_0_1_1__14751);
            rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getAttribute2Access().getLongDescriptionAssignment_3_0_1_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0_1_1__2_in_rule__Attribute2__Group_3_0_1_1__14760);
            rule__Attribute2__Group_3_0_1_1__2();
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
    // $ANTLR end rule__Attribute2__Group_3_0_1_1__1


    // $ANTLR start rule__Attribute2__Group_3_0_1_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2475:1: rule__Attribute2__Group_3_0_1_1__2 : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2479:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2480:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2480:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2481:1: ';'
            {
             before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_1_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Attribute2__Group_3_0_1_1__24789); 
             after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__Group_3_0_1_1__2


    // $ANTLR start rule__Attribute2__Group_3_0_1_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2500:1: rule__Attribute2__Group_3_0_1_3__0 : ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) ) rule__Attribute2__Group_3_0_1_3__1 ;
    public final void rule__Attribute2__Group_3_0_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2504:1: ( ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) ) rule__Attribute2__Group_3_0_1_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2505:1: ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) ) rule__Attribute2__Group_3_0_1_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2505:1: ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2506:1: ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 )
            {
             before(grammarAccess.getAttribute2Access().getRequiredAssignment_3_0_1_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2507:1: ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2507:2: rule__Attribute2__RequiredAssignment_3_0_1_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__RequiredAssignment_3_0_1_3_0_in_rule__Attribute2__Group_3_0_1_3__04830);
            rule__Attribute2__RequiredAssignment_3_0_1_3_0();
            _fsp--;


            }

             after(grammarAccess.getAttribute2Access().getRequiredAssignment_3_0_1_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0_1_3__1_in_rule__Attribute2__Group_3_0_1_3__04839);
            rule__Attribute2__Group_3_0_1_3__1();
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
    // $ANTLR end rule__Attribute2__Group_3_0_1_3__0


    // $ANTLR start rule__Attribute2__Group_3_0_1_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2518:1: rule__Attribute2__Group_3_0_1_3__1 : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2522:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2523:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2523:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2524:1: ';'
            {
             before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_3_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Attribute2__Group_3_0_1_3__14868); 
             after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__Group_3_0_1_3__1


    // $ANTLR start rule__Attribute2__Group_3_0_1_4__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2541:1: rule__Attribute2__Group_3_0_1_4__0 : ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) ) rule__Attribute2__Group_3_0_1_4__1 ;
    public final void rule__Attribute2__Group_3_0_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2545:1: ( ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) ) rule__Attribute2__Group_3_0_1_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2546:1: ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) ) rule__Attribute2__Group_3_0_1_4__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2546:1: ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2547:1: ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 )
            {
             before(grammarAccess.getAttribute2Access().getTechnicalAssignment_3_0_1_4_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2548:1: ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2548:2: rule__Attribute2__TechnicalAssignment_3_0_1_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__TechnicalAssignment_3_0_1_4_0_in_rule__Attribute2__Group_3_0_1_4__04907);
            rule__Attribute2__TechnicalAssignment_3_0_1_4_0();
            _fsp--;


            }

             after(grammarAccess.getAttribute2Access().getTechnicalAssignment_3_0_1_4_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0_1_4__1_in_rule__Attribute2__Group_3_0_1_4__04916);
            rule__Attribute2__Group_3_0_1_4__1();
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
    // $ANTLR end rule__Attribute2__Group_3_0_1_4__0


    // $ANTLR start rule__Attribute2__Group_3_0_1_4__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2559:1: rule__Attribute2__Group_3_0_1_4__1 : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2563:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2564:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2564:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2565:1: ';'
            {
             before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_4_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Attribute2__Group_3_0_1_4__14945); 
             after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__Group_3_0_1_4__1


    // $ANTLR start rule__Reference2__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2582:1: rule__Reference2__Group__0 : ( 'Reference' ) rule__Reference2__Group__1 ;
    public final void rule__Reference2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2586:1: ( ( 'Reference' ) rule__Reference2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2587:1: ( 'Reference' ) rule__Reference2__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2587:1: ( 'Reference' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2588:1: 'Reference'
            {
             before(grammarAccess.getReference2Access().getReferenceKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Reference2__Group__04985); 
             after(grammarAccess.getReference2Access().getReferenceKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group__1_in_rule__Reference2__Group__04995);
            rule__Reference2__Group__1();
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
    // $ANTLR end rule__Reference2__Group__0


    // $ANTLR start rule__Reference2__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2602:1: rule__Reference2__Group__1 : ( ( rule__Reference2__TypeAssignment_1 ) ) rule__Reference2__Group__2 ;
    public final void rule__Reference2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2606:1: ( ( ( rule__Reference2__TypeAssignment_1 ) ) rule__Reference2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2607:1: ( ( rule__Reference2__TypeAssignment_1 ) ) rule__Reference2__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2607:1: ( ( rule__Reference2__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2608:1: ( rule__Reference2__TypeAssignment_1 )
            {
             before(grammarAccess.getReference2Access().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2609:1: ( rule__Reference2__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2609:2: rule__Reference2__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference2__TypeAssignment_1_in_rule__Reference2__Group__15023);
            rule__Reference2__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getReference2Access().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group__2_in_rule__Reference2__Group__15032);
            rule__Reference2__Group__2();
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
    // $ANTLR end rule__Reference2__Group__1


    // $ANTLR start rule__Reference2__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2620:1: rule__Reference2__Group__2 : ( ( rule__Reference2__ManyAssignment_2 )? ) rule__Reference2__Group__3 ;
    public final void rule__Reference2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2624:1: ( ( ( rule__Reference2__ManyAssignment_2 )? ) rule__Reference2__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2625:1: ( ( rule__Reference2__ManyAssignment_2 )? ) rule__Reference2__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2625:1: ( ( rule__Reference2__ManyAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2626:1: ( rule__Reference2__ManyAssignment_2 )?
            {
             before(grammarAccess.getReference2Access().getManyAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2627:1: ( rule__Reference2__ManyAssignment_2 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==34) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2627:2: rule__Reference2__ManyAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference2__ManyAssignment_2_in_rule__Reference2__Group__25060);
                    rule__Reference2__ManyAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReference2Access().getManyAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group__3_in_rule__Reference2__Group__25070);
            rule__Reference2__Group__3();
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
    // $ANTLR end rule__Reference2__Group__2


    // $ANTLR start rule__Reference2__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2638:1: rule__Reference2__Group__3 : ( ( rule__Reference2__NameAssignment_3 ) ) rule__Reference2__Group__4 ;
    public final void rule__Reference2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2642:1: ( ( ( rule__Reference2__NameAssignment_3 ) ) rule__Reference2__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2643:1: ( ( rule__Reference2__NameAssignment_3 ) ) rule__Reference2__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2643:1: ( ( rule__Reference2__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2644:1: ( rule__Reference2__NameAssignment_3 )
            {
             before(grammarAccess.getReference2Access().getNameAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2645:1: ( rule__Reference2__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2645:2: rule__Reference2__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference2__NameAssignment_3_in_rule__Reference2__Group__35098);
            rule__Reference2__NameAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getReference2Access().getNameAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group__4_in_rule__Reference2__Group__35107);
            rule__Reference2__Group__4();
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
    // $ANTLR end rule__Reference2__Group__3


    // $ANTLR start rule__Reference2__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2656:1: rule__Reference2__Group__4 : ( ( rule__Reference2__Alternatives_4 ) ) ;
    public final void rule__Reference2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2660:1: ( ( ( rule__Reference2__Alternatives_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2661:1: ( ( rule__Reference2__Alternatives_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2661:1: ( ( rule__Reference2__Alternatives_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2662:1: ( rule__Reference2__Alternatives_4 )
            {
             before(grammarAccess.getReference2Access().getAlternatives_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2663:1: ( rule__Reference2__Alternatives_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2663:2: rule__Reference2__Alternatives_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Alternatives_4_in_rule__Reference2__Group__45135);
            rule__Reference2__Alternatives_4();
            _fsp--;


            }

             after(grammarAccess.getReference2Access().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__Group__4


    // $ANTLR start rule__Reference2__Group_4_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2683:1: rule__Reference2__Group_4_0__0 : ( '{' ) rule__Reference2__Group_4_0__1 ;
    public final void rule__Reference2__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2687:1: ( ( '{' ) rule__Reference2__Group_4_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2688:1: ( '{' ) rule__Reference2__Group_4_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2688:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2689:1: '{'
            {
             before(grammarAccess.getReference2Access().getLeftCurlyBracketKeyword_4_0_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Reference2__Group_4_0__05180); 
             after(grammarAccess.getReference2Access().getLeftCurlyBracketKeyword_4_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group_4_0__1_in_rule__Reference2__Group_4_0__05190);
            rule__Reference2__Group_4_0__1();
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
    // $ANTLR end rule__Reference2__Group_4_0__0


    // $ANTLR start rule__Reference2__Group_4_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2703:1: rule__Reference2__Group_4_0__1 : ( ( rule__Reference2__UnorderedGroup_4_0_1 ) ) rule__Reference2__Group_4_0__2 ;
    public final void rule__Reference2__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2707:1: ( ( ( rule__Reference2__UnorderedGroup_4_0_1 ) ) rule__Reference2__Group_4_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2708:1: ( ( rule__Reference2__UnorderedGroup_4_0_1 ) ) rule__Reference2__Group_4_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2708:1: ( ( rule__Reference2__UnorderedGroup_4_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2709:1: ( rule__Reference2__UnorderedGroup_4_0_1 )
            {
             before(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2710:1: ( rule__Reference2__UnorderedGroup_4_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2710:2: rule__Reference2__UnorderedGroup_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference2__UnorderedGroup_4_0_1_in_rule__Reference2__Group_4_0__15218);
            rule__Reference2__UnorderedGroup_4_0_1();
            _fsp--;


            }

             after(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group_4_0__2_in_rule__Reference2__Group_4_0__15227);
            rule__Reference2__Group_4_0__2();
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
    // $ANTLR end rule__Reference2__Group_4_0__1


    // $ANTLR start rule__Reference2__Group_4_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2721:1: rule__Reference2__Group_4_0__2 : ( '}' ) ;
    public final void rule__Reference2__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2725:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2726:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2726:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2727:1: '}'
            {
             before(grammarAccess.getReference2Access().getRightCurlyBracketKeyword_4_0_2()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Reference2__Group_4_0__25256); 
             after(grammarAccess.getReference2Access().getRightCurlyBracketKeyword_4_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__Group_4_0__2


    // $ANTLR start rule__Reference2__Group_4_0_1_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2746:1: rule__Reference2__Group_4_0_1_0__0 : ( 'shortDescription' ) rule__Reference2__Group_4_0_1_0__1 ;
    public final void rule__Reference2__Group_4_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2750:1: ( ( 'shortDescription' ) rule__Reference2__Group_4_0_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2751:1: ( 'shortDescription' ) rule__Reference2__Group_4_0_1_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2751:1: ( 'shortDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2752:1: 'shortDescription'
            {
             before(grammarAccess.getReference2Access().getShortDescriptionKeyword_4_0_1_0_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Reference2__Group_4_0_1_0__05298); 
             after(grammarAccess.getReference2Access().getShortDescriptionKeyword_4_0_1_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group_4_0_1_0__1_in_rule__Reference2__Group_4_0_1_0__05308);
            rule__Reference2__Group_4_0_1_0__1();
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
    // $ANTLR end rule__Reference2__Group_4_0_1_0__0


    // $ANTLR start rule__Reference2__Group_4_0_1_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2766:1: rule__Reference2__Group_4_0_1_0__1 : ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) ) rule__Reference2__Group_4_0_1_0__2 ;
    public final void rule__Reference2__Group_4_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2770:1: ( ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) ) rule__Reference2__Group_4_0_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2771:1: ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) ) rule__Reference2__Group_4_0_1_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2771:1: ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2772:1: ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 )
            {
             before(grammarAccess.getReference2Access().getShortDescriptionAssignment_4_0_1_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2773:1: ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2773:2: rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1_in_rule__Reference2__Group_4_0_1_0__15336);
            rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1();
            _fsp--;


            }

             after(grammarAccess.getReference2Access().getShortDescriptionAssignment_4_0_1_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group_4_0_1_0__2_in_rule__Reference2__Group_4_0_1_0__15345);
            rule__Reference2__Group_4_0_1_0__2();
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
    // $ANTLR end rule__Reference2__Group_4_0_1_0__1


    // $ANTLR start rule__Reference2__Group_4_0_1_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2784:1: rule__Reference2__Group_4_0_1_0__2 : ( ';' ) ;
    public final void rule__Reference2__Group_4_0_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2788:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2789:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2789:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2790:1: ';'
            {
             before(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_0_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Reference2__Group_4_0_1_0__25374); 
             after(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__Group_4_0_1_0__2


    // $ANTLR start rule__Reference2__Group_4_0_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2809:1: rule__Reference2__Group_4_0_1_1__0 : ( 'longDescription' ) rule__Reference2__Group_4_0_1_1__1 ;
    public final void rule__Reference2__Group_4_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2813:1: ( ( 'longDescription' ) rule__Reference2__Group_4_0_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2814:1: ( 'longDescription' ) rule__Reference2__Group_4_0_1_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2814:1: ( 'longDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2815:1: 'longDescription'
            {
             before(grammarAccess.getReference2Access().getLongDescriptionKeyword_4_0_1_1_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Reference2__Group_4_0_1_1__05416); 
             after(grammarAccess.getReference2Access().getLongDescriptionKeyword_4_0_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group_4_0_1_1__1_in_rule__Reference2__Group_4_0_1_1__05426);
            rule__Reference2__Group_4_0_1_1__1();
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
    // $ANTLR end rule__Reference2__Group_4_0_1_1__0


    // $ANTLR start rule__Reference2__Group_4_0_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2829:1: rule__Reference2__Group_4_0_1_1__1 : ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) ) rule__Reference2__Group_4_0_1_1__2 ;
    public final void rule__Reference2__Group_4_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2833:1: ( ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) ) rule__Reference2__Group_4_0_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2834:1: ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) ) rule__Reference2__Group_4_0_1_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2834:1: ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2835:1: ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 )
            {
             before(grammarAccess.getReference2Access().getLongDescriptionAssignment_4_0_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2836:1: ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2836:2: rule__Reference2__LongDescriptionAssignment_4_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference2__LongDescriptionAssignment_4_0_1_1_1_in_rule__Reference2__Group_4_0_1_1__15454);
            rule__Reference2__LongDescriptionAssignment_4_0_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getReference2Access().getLongDescriptionAssignment_4_0_1_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group_4_0_1_1__2_in_rule__Reference2__Group_4_0_1_1__15463);
            rule__Reference2__Group_4_0_1_1__2();
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
    // $ANTLR end rule__Reference2__Group_4_0_1_1__1


    // $ANTLR start rule__Reference2__Group_4_0_1_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2847:1: rule__Reference2__Group_4_0_1_1__2 : ( ';' ) ;
    public final void rule__Reference2__Group_4_0_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2851:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2852:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2852:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2853:1: ';'
            {
             before(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_1_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Reference2__Group_4_0_1_1__25492); 
             after(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__Group_4_0_1_1__2


    // $ANTLR start rule__ConstraintDefinition__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2872:1: rule__ConstraintDefinition__Group__0 : ( 'constraint' ) rule__ConstraintDefinition__Group__1 ;
    public final void rule__ConstraintDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2876:1: ( ( 'constraint' ) rule__ConstraintDefinition__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2877:1: ( 'constraint' ) rule__ConstraintDefinition__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2877:1: ( 'constraint' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2878:1: 'constraint'
            {
             before(grammarAccess.getConstraintDefinitionAccess().getConstraintKeyword_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__ConstraintDefinition__Group__05534); 
             after(grammarAccess.getConstraintDefinitionAccess().getConstraintKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group__1_in_rule__ConstraintDefinition__Group__05544);
            rule__ConstraintDefinition__Group__1();
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
    // $ANTLR end rule__ConstraintDefinition__Group__0


    // $ANTLR start rule__ConstraintDefinition__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2892:1: rule__ConstraintDefinition__Group__1 : ( ( rule__ConstraintDefinition__TypeAssignment_1 ) ) rule__ConstraintDefinition__Group__2 ;
    public final void rule__ConstraintDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2896:1: ( ( ( rule__ConstraintDefinition__TypeAssignment_1 ) ) rule__ConstraintDefinition__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2897:1: ( ( rule__ConstraintDefinition__TypeAssignment_1 ) ) rule__ConstraintDefinition__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2897:1: ( ( rule__ConstraintDefinition__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2898:1: ( rule__ConstraintDefinition__TypeAssignment_1 )
            {
             before(grammarAccess.getConstraintDefinitionAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2899:1: ( rule__ConstraintDefinition__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2899:2: rule__ConstraintDefinition__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__TypeAssignment_1_in_rule__ConstraintDefinition__Group__15572);
            rule__ConstraintDefinition__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getConstraintDefinitionAccess().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group__2_in_rule__ConstraintDefinition__Group__15581);
            rule__ConstraintDefinition__Group__2();
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
    // $ANTLR end rule__ConstraintDefinition__Group__1


    // $ANTLR start rule__ConstraintDefinition__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2910:1: rule__ConstraintDefinition__Group__2 : ( '{' ) rule__ConstraintDefinition__Group__3 ;
    public final void rule__ConstraintDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2914:1: ( ( '{' ) rule__ConstraintDefinition__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2915:1: ( '{' ) rule__ConstraintDefinition__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2915:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2916:1: '{'
            {
             before(grammarAccess.getConstraintDefinitionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__ConstraintDefinition__Group__25610); 
             after(grammarAccess.getConstraintDefinitionAccess().getLeftCurlyBracketKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group__3_in_rule__ConstraintDefinition__Group__25620);
            rule__ConstraintDefinition__Group__3();
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
    // $ANTLR end rule__ConstraintDefinition__Group__2


    // $ANTLR start rule__ConstraintDefinition__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2930:1: rule__ConstraintDefinition__Group__3 : ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) ) rule__ConstraintDefinition__Group__4 ;
    public final void rule__ConstraintDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2934:1: ( ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) ) rule__ConstraintDefinition__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2935:1: ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) ) rule__ConstraintDefinition__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2935:1: ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2936:1: ( rule__ConstraintDefinition__UnorderedGroup_3 )
            {
             before(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2937:1: ( rule__ConstraintDefinition__UnorderedGroup_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2937:2: rule__ConstraintDefinition__UnorderedGroup_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__UnorderedGroup_3_in_rule__ConstraintDefinition__Group__35648);
            rule__ConstraintDefinition__UnorderedGroup_3();
            _fsp--;


            }

             after(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group__4_in_rule__ConstraintDefinition__Group__35657);
            rule__ConstraintDefinition__Group__4();
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
    // $ANTLR end rule__ConstraintDefinition__Group__3


    // $ANTLR start rule__ConstraintDefinition__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2948:1: rule__ConstraintDefinition__Group__4 : ( '}' ) ;
    public final void rule__ConstraintDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2952:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2953:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2953:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2954:1: '}'
            {
             before(grammarAccess.getConstraintDefinitionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__ConstraintDefinition__Group__45686); 
             after(grammarAccess.getConstraintDefinitionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConstraintDefinition__Group__4


    // $ANTLR start rule__ConstraintDefinition__Group_3_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2977:1: rule__ConstraintDefinition__Group_3_0__0 : ( 'parameters' ) rule__ConstraintDefinition__Group_3_0__1 ;
    public final void rule__ConstraintDefinition__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2981:1: ( ( 'parameters' ) rule__ConstraintDefinition__Group_3_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2982:1: ( 'parameters' ) rule__ConstraintDefinition__Group_3_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2982:1: ( 'parameters' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2983:1: 'parameters'
            {
             before(grammarAccess.getConstraintDefinitionAccess().getParametersKeyword_3_0_0()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__ConstraintDefinition__Group_3_0__05732); 
             after(grammarAccess.getConstraintDefinitionAccess().getParametersKeyword_3_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group_3_0__1_in_rule__ConstraintDefinition__Group_3_0__05742);
            rule__ConstraintDefinition__Group_3_0__1();
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
    // $ANTLR end rule__ConstraintDefinition__Group_3_0__0


    // $ANTLR start rule__ConstraintDefinition__Group_3_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2997:1: rule__ConstraintDefinition__Group_3_0__1 : ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* ) rule__ConstraintDefinition__Group_3_0__2 ;
    public final void rule__ConstraintDefinition__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3001:1: ( ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* ) rule__ConstraintDefinition__Group_3_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3002:1: ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* ) rule__ConstraintDefinition__Group_3_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3002:1: ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3003:1: ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )*
            {
             before(grammarAccess.getConstraintDefinitionAccess().getParametersAssignment_3_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3004:1: ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_STRING) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3004:2: rule__ConstraintDefinition__ParametersAssignment_3_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__ParametersAssignment_3_0_1_in_rule__ConstraintDefinition__Group_3_0__15770);
            	    rule__ConstraintDefinition__ParametersAssignment_3_0_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getConstraintDefinitionAccess().getParametersAssignment_3_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group_3_0__2_in_rule__ConstraintDefinition__Group_3_0__15780);
            rule__ConstraintDefinition__Group_3_0__2();
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
    // $ANTLR end rule__ConstraintDefinition__Group_3_0__1


    // $ANTLR start rule__ConstraintDefinition__Group_3_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3015:1: rule__ConstraintDefinition__Group_3_0__2 : ( ';' ) ;
    public final void rule__ConstraintDefinition__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3019:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3020:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3020:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3021:1: ';'
            {
             before(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_0_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__ConstraintDefinition__Group_3_0__25809); 
             after(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConstraintDefinition__Group_3_0__2


    // $ANTLR start rule__ConstraintDefinition__Group_3_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3040:1: rule__ConstraintDefinition__Group_3_1__0 : ( 'message' ) rule__ConstraintDefinition__Group_3_1__1 ;
    public final void rule__ConstraintDefinition__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3044:1: ( ( 'message' ) rule__ConstraintDefinition__Group_3_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3045:1: ( 'message' ) rule__ConstraintDefinition__Group_3_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3045:1: ( 'message' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3046:1: 'message'
            {
             before(grammarAccess.getConstraintDefinitionAccess().getMessageKeyword_3_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__ConstraintDefinition__Group_3_1__05851); 
             after(grammarAccess.getConstraintDefinitionAccess().getMessageKeyword_3_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group_3_1__1_in_rule__ConstraintDefinition__Group_3_1__05861);
            rule__ConstraintDefinition__Group_3_1__1();
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
    // $ANTLR end rule__ConstraintDefinition__Group_3_1__0


    // $ANTLR start rule__ConstraintDefinition__Group_3_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3060:1: rule__ConstraintDefinition__Group_3_1__1 : ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) ) rule__ConstraintDefinition__Group_3_1__2 ;
    public final void rule__ConstraintDefinition__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3064:1: ( ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) ) rule__ConstraintDefinition__Group_3_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3065:1: ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) ) rule__ConstraintDefinition__Group_3_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3065:1: ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3066:1: ( rule__ConstraintDefinition__MessageAssignment_3_1_1 )
            {
             before(grammarAccess.getConstraintDefinitionAccess().getMessageAssignment_3_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3067:1: ( rule__ConstraintDefinition__MessageAssignment_3_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3067:2: rule__ConstraintDefinition__MessageAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__MessageAssignment_3_1_1_in_rule__ConstraintDefinition__Group_3_1__15889);
            rule__ConstraintDefinition__MessageAssignment_3_1_1();
            _fsp--;


            }

             after(grammarAccess.getConstraintDefinitionAccess().getMessageAssignment_3_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group_3_1__2_in_rule__ConstraintDefinition__Group_3_1__15898);
            rule__ConstraintDefinition__Group_3_1__2();
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
    // $ANTLR end rule__ConstraintDefinition__Group_3_1__1


    // $ANTLR start rule__ConstraintDefinition__Group_3_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3078:1: rule__ConstraintDefinition__Group_3_1__2 : ( ';' ) ;
    public final void rule__ConstraintDefinition__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3082:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3083:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3083:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3084:1: ';'
            {
             before(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_1_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__ConstraintDefinition__Group_3_1__25927); 
             after(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConstraintDefinition__Group_3_1__2


    // $ANTLR start rule__Object__UnorderedGroup_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3104:1: rule__Object__UnorderedGroup_5 : ( rule__Object__UnorderedGroup_5__0 )? ;
    public final void rule__Object__UnorderedGroup_5() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3109:1: ( ( rule__Object__UnorderedGroup_5__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3110:2: ( rule__Object__UnorderedGroup_5__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3110:2: ( rule__Object__UnorderedGroup_5__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt21=1;
            }
            else if ( (LA21_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt21=1;
            }
            else if ( (LA21_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt21=1;
            }
            else if ( (LA21_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt21=1;
            }
            else if ( ((LA21_0>=26 && LA21_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt21=1;
            }
            else if ( (LA21_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt21=1;
            }
            else if ( (LA21_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt21=1;
            }
            else if ( (LA21_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3110:2: rule__Object__UnorderedGroup_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__0_in_rule__Object__UnorderedGroup_55965);
                    rule__Object__UnorderedGroup_5__0();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__UnorderedGroup_5


    // $ANTLR start rule__Object__UnorderedGroup_5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3120:1: rule__Object__UnorderedGroup_5__Impl : ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) ) ;
    public final void rule__Object__UnorderedGroup_5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3125:1: ( ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3126:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3126:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )
            int alt23=8;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt23=1;
            }
            else if ( (LA23_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt23=2;
            }
            else if ( (LA23_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt23=3;
            }
            else if ( (LA23_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt23=4;
            }
            else if ( ((LA23_0>=26 && LA23_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt23=5;
            }
            else if ( (LA23_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt23=6;
            }
            else if ( (LA23_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt23=7;
            }
            else if ( (LA23_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt23=8;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3126:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3128:4: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3128:4: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3129:5: {...}? => ( ( ( rule__Object__Group_5_0__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3129:103: ( ( ( rule__Object__Group_5_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3130:6: ( ( rule__Object__Group_5_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3136:6: ( ( rule__Object__Group_5_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3138:7: ( rule__Object__Group_5_0__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3139:7: ( rule__Object__Group_5_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3139:8: rule__Object__Group_5_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_0__0_in_rule__Object__UnorderedGroup_5__Impl6052);
                    rule__Object__Group_5_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3145:4: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3145:4: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3146:5: {...}? => ( ( ( rule__Object__Group_5_1__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3146:103: ( ( ( rule__Object__Group_5_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3147:6: ( ( rule__Object__Group_5_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3153:6: ( ( rule__Object__Group_5_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3155:7: ( rule__Object__Group_5_1__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3156:7: ( rule__Object__Group_5_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3156:8: rule__Object__Group_5_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_1__0_in_rule__Object__UnorderedGroup_5__Impl6143);
                    rule__Object__Group_5_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3162:4: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3162:4: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3163:5: {...}? => ( ( ( rule__Object__Group_5_2__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3163:103: ( ( ( rule__Object__Group_5_2__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3164:6: ( ( rule__Object__Group_5_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3170:6: ( ( rule__Object__Group_5_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3172:7: ( rule__Object__Group_5_2__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3173:7: ( rule__Object__Group_5_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3173:8: rule__Object__Group_5_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_2__0_in_rule__Object__UnorderedGroup_5__Impl6234);
                    rule__Object__Group_5_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3179:4: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3179:4: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3180:5: {...}? => ( ( ( rule__Object__Group_5_3__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3180:103: ( ( ( rule__Object__Group_5_3__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3181:6: ( ( rule__Object__Group_5_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3187:6: ( ( rule__Object__Group_5_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3189:7: ( rule__Object__Group_5_3__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3190:7: ( rule__Object__Group_5_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3190:8: rule__Object__Group_5_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_3__0_in_rule__Object__UnorderedGroup_5__Impl6325);
                    rule__Object__Group_5_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3196:4: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3196:4: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3197:5: {...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3197:103: ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3198:6: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3204:6: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3205:6: ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3205:6: ( ( rule__Object__FeaturesAssignment_5_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3206:7: ( rule__Object__FeaturesAssignment_5_4 )
                    {
                     before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3207:7: ( rule__Object__FeaturesAssignment_5_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3207:8: rule__Object__FeaturesAssignment_5_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_4_in_rule__Object__UnorderedGroup_5__Impl6417);
                    rule__Object__FeaturesAssignment_5_4();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3210:6: ( ( rule__Object__FeaturesAssignment_5_4 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3211:7: ( rule__Object__FeaturesAssignment_5_4 )*
                    {
                     before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3212:7: ( rule__Object__FeaturesAssignment_5_4 )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==26) ) {
                            int LA22_5 = input.LA(2);

                            if ( (LA22_5==RULE_ID) ) {
                                int LA22_11 = input.LA(3);

                                if ( (LA22_11==RULE_ID) ) {
                                    int LA22_13 = input.LA(4);

                                    if ( (LA22_13==11) ) {
                                        int LA22_16 = input.LA(5);

                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                            alt22=1;
                                        }


                                    }


                                }


                            }


                        }
                        else if ( (LA22_0==27) ) {
                            int LA22_6 = input.LA(2);

                            if ( (LA22_6==RULE_ID) ) {
                                int LA22_12 = input.LA(3);

                                if ( (LA22_12==34) ) {
                                    int LA22_14 = input.LA(4);

                                    if ( (LA22_14==RULE_ID) ) {
                                        int LA22_15 = input.LA(5);

                                        if ( (LA22_15==16) ) {
                                            switch ( input.LA(6) ) {
                                            case 19:
                                                {
                                                int LA22_20 = input.LA(7);

                                                if ( (LA22_20==RULE_STRING) ) {
                                                    int LA22_23 = input.LA(8);

                                                    if ( (LA22_23==11) ) {
                                                        switch ( input.LA(9) ) {
                                                        case 19:
                                                            {
                                                            int LA22_27 = input.LA(10);

                                                            if ( (LA22_27==RULE_STRING) ) {
                                                                int LA22_31 = input.LA(11);

                                                                if ( (LA22_31==11) ) {
                                                                    int LA22_33 = input.LA(12);

                                                                    if ( (LA22_33==17) ) {
                                                                        int LA22_35 = input.LA(13);

                                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                            alt22=1;
                                                                        }


                                                                    }


                                                                }


                                                            }


                                                            }
                                                            break;
                                                        case 20:
                                                            {
                                                            int LA22_28 = input.LA(10);

                                                            if ( (LA22_28==RULE_STRING) ) {
                                                                int LA22_32 = input.LA(11);

                                                                if ( (LA22_32==11) ) {
                                                                    int LA22_34 = input.LA(12);

                                                                    if ( (LA22_34==17) ) {
                                                                        int LA22_36 = input.LA(13);

                                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                            alt22=1;
                                                                        }


                                                                    }


                                                                }


                                                            }


                                                            }
                                                            break;
                                                        case 17:
                                                            {
                                                            int LA22_29 = input.LA(10);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt22=1;
                                                            }


                                                            }
                                                            break;

                                                        }

                                                    }


                                                }


                                                }
                                                break;
                                            case 20:
                                                {
                                                int LA22_21 = input.LA(7);

                                                if ( (LA22_21==RULE_STRING) ) {
                                                    int LA22_24 = input.LA(8);

                                                    if ( (LA22_24==11) ) {
                                                        switch ( input.LA(9) ) {
                                                        case 19:
                                                            {
                                                            int LA22_27 = input.LA(10);

                                                            if ( (LA22_27==RULE_STRING) ) {
                                                                int LA22_31 = input.LA(11);

                                                                if ( (LA22_31==11) ) {
                                                                    int LA22_33 = input.LA(12);

                                                                    if ( (LA22_33==17) ) {
                                                                        int LA22_35 = input.LA(13);

                                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                            alt22=1;
                                                                        }


                                                                    }


                                                                }


                                                            }


                                                            }
                                                            break;
                                                        case 20:
                                                            {
                                                            int LA22_28 = input.LA(10);

                                                            if ( (LA22_28==RULE_STRING) ) {
                                                                int LA22_32 = input.LA(11);

                                                                if ( (LA22_32==11) ) {
                                                                    int LA22_34 = input.LA(12);

                                                                    if ( (LA22_34==17) ) {
                                                                        int LA22_36 = input.LA(13);

                                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                            alt22=1;
                                                                        }


                                                                    }


                                                                }


                                                            }


                                                            }
                                                            break;
                                                        case 17:
                                                            {
                                                            int LA22_30 = input.LA(10);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt22=1;
                                                            }


                                                            }
                                                            break;

                                                        }

                                                    }


                                                }


                                                }
                                                break;
                                            case 17:
                                                {
                                                int LA22_22 = input.LA(7);

                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                    alt22=1;
                                                }


                                                }
                                                break;

                                            }

                                        }
                                        else if ( (LA22_15==11) ) {
                                            int LA22_18 = input.LA(6);

                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                alt22=1;
                                            }


                                        }


                                    }


                                }
                                else if ( (LA22_12==RULE_ID) ) {
                                    int LA22_15 = input.LA(4);

                                    if ( (LA22_15==16) ) {
                                        switch ( input.LA(5) ) {
                                        case 19:
                                            {
                                            int LA22_20 = input.LA(6);

                                            if ( (LA22_20==RULE_STRING) ) {
                                                int LA22_23 = input.LA(7);

                                                if ( (LA22_23==11) ) {
                                                    switch ( input.LA(8) ) {
                                                    case 19:
                                                        {
                                                        int LA22_27 = input.LA(9);

                                                        if ( (LA22_27==RULE_STRING) ) {
                                                            int LA22_31 = input.LA(10);

                                                            if ( (LA22_31==11) ) {
                                                                int LA22_33 = input.LA(11);

                                                                if ( (LA22_33==17) ) {
                                                                    int LA22_35 = input.LA(12);

                                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                        alt22=1;
                                                                    }


                                                                }


                                                            }


                                                        }


                                                        }
                                                        break;
                                                    case 20:
                                                        {
                                                        int LA22_28 = input.LA(9);

                                                        if ( (LA22_28==RULE_STRING) ) {
                                                            int LA22_32 = input.LA(10);

                                                            if ( (LA22_32==11) ) {
                                                                int LA22_34 = input.LA(11);

                                                                if ( (LA22_34==17) ) {
                                                                    int LA22_36 = input.LA(12);

                                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                        alt22=1;
                                                                    }


                                                                }


                                                            }


                                                        }


                                                        }
                                                        break;
                                                    case 17:
                                                        {
                                                        int LA22_29 = input.LA(9);

                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                            alt22=1;
                                                        }


                                                        }
                                                        break;

                                                    }

                                                }


                                            }


                                            }
                                            break;
                                        case 20:
                                            {
                                            int LA22_21 = input.LA(6);

                                            if ( (LA22_21==RULE_STRING) ) {
                                                int LA22_24 = input.LA(7);

                                                if ( (LA22_24==11) ) {
                                                    switch ( input.LA(8) ) {
                                                    case 19:
                                                        {
                                                        int LA22_27 = input.LA(9);

                                                        if ( (LA22_27==RULE_STRING) ) {
                                                            int LA22_31 = input.LA(10);

                                                            if ( (LA22_31==11) ) {
                                                                int LA22_33 = input.LA(11);

                                                                if ( (LA22_33==17) ) {
                                                                    int LA22_35 = input.LA(12);

                                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                        alt22=1;
                                                                    }


                                                                }


                                                            }


                                                        }


                                                        }
                                                        break;
                                                    case 20:
                                                        {
                                                        int LA22_28 = input.LA(9);

                                                        if ( (LA22_28==RULE_STRING) ) {
                                                            int LA22_32 = input.LA(10);

                                                            if ( (LA22_32==11) ) {
                                                                int LA22_34 = input.LA(11);

                                                                if ( (LA22_34==17) ) {
                                                                    int LA22_36 = input.LA(12);

                                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                        alt22=1;
                                                                    }


                                                                }


                                                            }


                                                        }


                                                        }
                                                        break;
                                                    case 17:
                                                        {
                                                        int LA22_30 = input.LA(9);

                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                            alt22=1;
                                                        }


                                                        }
                                                        break;

                                                    }

                                                }


                                            }


                                            }
                                            break;
                                        case 17:
                                            {
                                            int LA22_22 = input.LA(6);

                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                alt22=1;
                                            }


                                            }
                                            break;

                                        }

                                    }
                                    else if ( (LA22_15==11) ) {
                                        int LA22_18 = input.LA(5);

                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                            alt22=1;
                                        }


                                    }


                                }


                            }


                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3212:8: rule__Object__FeaturesAssignment_5_4
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_4_in_rule__Object__UnorderedGroup_5__Impl6457);
                    	    rule__Object__FeaturesAssignment_5_4();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                     after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3218:4: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3218:4: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3219:5: {...}? => ( ( ( rule__Object__Group_5_5__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3219:103: ( ( ( rule__Object__Group_5_5__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3220:6: ( ( rule__Object__Group_5_5__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3226:6: ( ( rule__Object__Group_5_5__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3228:7: ( rule__Object__Group_5_5__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_5()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3229:7: ( rule__Object__Group_5_5__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3229:8: rule__Object__Group_5_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_5__0_in_rule__Object__UnorderedGroup_5__Impl6555);
                    rule__Object__Group_5_5__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_5()); 

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3235:4: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3235:4: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3236:5: {...}? => ( ( ( rule__Object__Group_5_6__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3236:103: ( ( ( rule__Object__Group_5_6__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3237:6: ( ( rule__Object__Group_5_6__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3243:6: ( ( rule__Object__Group_5_6__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3245:7: ( rule__Object__Group_5_6__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_6()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3246:7: ( rule__Object__Group_5_6__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3246:8: rule__Object__Group_5_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_6__0_in_rule__Object__UnorderedGroup_5__Impl6646);
                    rule__Object__Group_5_6__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_6()); 

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3252:4: ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3252:4: ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3253:5: {...}? => ( ( ( rule__Object__Group_5_7__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3253:103: ( ( ( rule__Object__Group_5_7__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3254:6: ( ( rule__Object__Group_5_7__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3260:6: ( ( rule__Object__Group_5_7__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3262:7: ( rule__Object__Group_5_7__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_7()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3263:7: ( rule__Object__Group_5_7__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3263:8: rule__Object__Group_5_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_7__0_in_rule__Object__UnorderedGroup_5__Impl6737);
                    rule__Object__Group_5_7__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_7()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__UnorderedGroup_5__Impl


    // $ANTLR start rule__Object__UnorderedGroup_5__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3278:1: rule__Object__UnorderedGroup_5__0 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )? ;
    public final void rule__Object__UnorderedGroup_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3282:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3283:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__06796);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3284:2: ( rule__Object__UnorderedGroup_5__1 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt24=1;
            }
            else if ( (LA24_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt24=1;
            }
            else if ( (LA24_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt24=1;
            }
            else if ( (LA24_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt24=1;
            }
            else if ( ((LA24_0>=26 && LA24_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt24=1;
            }
            else if ( (LA24_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt24=1;
            }
            else if ( (LA24_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt24=1;
            }
            else if ( (LA24_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3284:2: rule__Object__UnorderedGroup_5__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__1_in_rule__Object__UnorderedGroup_5__06799);
                    rule__Object__UnorderedGroup_5__1();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__UnorderedGroup_5__0


    // $ANTLR start rule__Object__UnorderedGroup_5__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3291:1: rule__Object__UnorderedGroup_5__1 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )? ;
    public final void rule__Object__UnorderedGroup_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3295:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3296:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__16824);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3297:2: ( rule__Object__UnorderedGroup_5__2 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt25=1;
            }
            else if ( (LA25_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt25=1;
            }
            else if ( (LA25_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt25=1;
            }
            else if ( (LA25_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt25=1;
            }
            else if ( ((LA25_0>=26 && LA25_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt25=1;
            }
            else if ( (LA25_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt25=1;
            }
            else if ( (LA25_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt25=1;
            }
            else if ( (LA25_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3297:2: rule__Object__UnorderedGroup_5__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__2_in_rule__Object__UnorderedGroup_5__16827);
                    rule__Object__UnorderedGroup_5__2();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__UnorderedGroup_5__1


    // $ANTLR start rule__Object__UnorderedGroup_5__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3304:1: rule__Object__UnorderedGroup_5__2 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )? ;
    public final void rule__Object__UnorderedGroup_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3308:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3309:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__26852);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3310:2: ( rule__Object__UnorderedGroup_5__3 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt26=1;
            }
            else if ( (LA26_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt26=1;
            }
            else if ( (LA26_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt26=1;
            }
            else if ( (LA26_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt26=1;
            }
            else if ( ((LA26_0>=26 && LA26_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt26=1;
            }
            else if ( (LA26_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt26=1;
            }
            else if ( (LA26_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt26=1;
            }
            else if ( (LA26_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3310:2: rule__Object__UnorderedGroup_5__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__3_in_rule__Object__UnorderedGroup_5__26855);
                    rule__Object__UnorderedGroup_5__3();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__UnorderedGroup_5__2


    // $ANTLR start rule__Object__UnorderedGroup_5__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3317:1: rule__Object__UnorderedGroup_5__3 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )? ;
    public final void rule__Object__UnorderedGroup_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3321:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3322:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__36880);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3323:2: ( rule__Object__UnorderedGroup_5__4 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt27=1;
            }
            else if ( (LA27_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt27=1;
            }
            else if ( (LA27_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt27=1;
            }
            else if ( (LA27_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt27=1;
            }
            else if ( ((LA27_0>=26 && LA27_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt27=1;
            }
            else if ( (LA27_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt27=1;
            }
            else if ( (LA27_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt27=1;
            }
            else if ( (LA27_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3323:2: rule__Object__UnorderedGroup_5__4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__4_in_rule__Object__UnorderedGroup_5__36883);
                    rule__Object__UnorderedGroup_5__4();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__UnorderedGroup_5__3


    // $ANTLR start rule__Object__UnorderedGroup_5__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3330:1: rule__Object__UnorderedGroup_5__4 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )? ;
    public final void rule__Object__UnorderedGroup_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3334:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3335:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__46908);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3336:2: ( rule__Object__UnorderedGroup_5__5 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt28=1;
            }
            else if ( (LA28_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt28=1;
            }
            else if ( (LA28_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt28=1;
            }
            else if ( (LA28_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt28=1;
            }
            else if ( ((LA28_0>=26 && LA28_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt28=1;
            }
            else if ( (LA28_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt28=1;
            }
            else if ( (LA28_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt28=1;
            }
            else if ( (LA28_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3336:2: rule__Object__UnorderedGroup_5__5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__5_in_rule__Object__UnorderedGroup_5__46911);
                    rule__Object__UnorderedGroup_5__5();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__UnorderedGroup_5__4


    // $ANTLR start rule__Object__UnorderedGroup_5__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3343:1: rule__Object__UnorderedGroup_5__5 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )? ;
    public final void rule__Object__UnorderedGroup_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3347:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3348:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__56936);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3349:2: ( rule__Object__UnorderedGroup_5__6 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt29=1;
            }
            else if ( (LA29_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt29=1;
            }
            else if ( (LA29_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt29=1;
            }
            else if ( (LA29_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt29=1;
            }
            else if ( ((LA29_0>=26 && LA29_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt29=1;
            }
            else if ( (LA29_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt29=1;
            }
            else if ( (LA29_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt29=1;
            }
            else if ( (LA29_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3349:2: rule__Object__UnorderedGroup_5__6
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__6_in_rule__Object__UnorderedGroup_5__56939);
                    rule__Object__UnorderedGroup_5__6();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__UnorderedGroup_5__5


    // $ANTLR start rule__Object__UnorderedGroup_5__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3356:1: rule__Object__UnorderedGroup_5__6 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )? ;
    public final void rule__Object__UnorderedGroup_5__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3360:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3361:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__66964);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3362:2: ( rule__Object__UnorderedGroup_5__7 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt30=1;
            }
            else if ( (LA30_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt30=1;
            }
            else if ( (LA30_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt30=1;
            }
            else if ( (LA30_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt30=1;
            }
            else if ( ((LA30_0>=26 && LA30_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt30=1;
            }
            else if ( (LA30_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt30=1;
            }
            else if ( (LA30_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt30=1;
            }
            else if ( (LA30_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3362:2: rule__Object__UnorderedGroup_5__7
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__7_in_rule__Object__UnorderedGroup_5__66967);
                    rule__Object__UnorderedGroup_5__7();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__UnorderedGroup_5__6


    // $ANTLR start rule__Object__UnorderedGroup_5__7
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3369:1: rule__Object__UnorderedGroup_5__7 : rule__Object__UnorderedGroup_5__Impl ;
    public final void rule__Object__UnorderedGroup_5__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3373:1: ( rule__Object__UnorderedGroup_5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3374:2: rule__Object__UnorderedGroup_5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__76992);
            rule__Object__UnorderedGroup_5__Impl();
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
    // $ANTLR end rule__Object__UnorderedGroup_5__7


    // $ANTLR start rule__Reference__UnorderedGroup_4_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3397:1: rule__Reference__UnorderedGroup_4_0_1 : ( rule__Reference__UnorderedGroup_4_0_1__0 )? ;
    public final void rule__Reference__UnorderedGroup_4_0_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3402:1: ( ( rule__Reference__UnorderedGroup_4_0_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3403:2: ( rule__Reference__UnorderedGroup_4_0_1__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3403:2: ( rule__Reference__UnorderedGroup_4_0_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0))) {
                alt31=1;
            }
            else if ( (LA31_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1))) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3403:2: rule__Reference__UnorderedGroup_4_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__UnorderedGroup_4_0_1__0_in_rule__Reference__UnorderedGroup_4_0_17032);
                    rule__Reference__UnorderedGroup_4_0_1__0();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__UnorderedGroup_4_0_1


    // $ANTLR start rule__Reference__UnorderedGroup_4_0_1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3413:1: rule__Reference__UnorderedGroup_4_0_1__Impl : ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) ) ;
    public final void rule__Reference__UnorderedGroup_4_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3418:1: ( ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3419:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3419:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0))) {
                alt32=1;
            }
            else if ( (LA32_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1))) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3419:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) )", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3421:4: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3421:4: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3422:5: {...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)) ) {
                        throw new FailedPredicateException(input, "rule__Reference__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3422:110: ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3423:6: ( ( rule__Reference__Group_4_0_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3429:6: ( ( rule__Reference__Group_4_0_1_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3431:7: ( rule__Reference__Group_4_0_1_0__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_0_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3432:7: ( rule__Reference__Group_4_0_1_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3432:8: rule__Reference__Group_4_0_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_0__0_in_rule__Reference__UnorderedGroup_4_0_1__Impl7119);
                    rule__Reference__Group_4_0_1_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_0_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3438:4: ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3438:4: ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3439:5: {...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)) ) {
                        throw new FailedPredicateException(input, "rule__Reference__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3439:110: ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3440:6: ( ( rule__Reference__Group_4_0_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3446:6: ( ( rule__Reference__Group_4_0_1_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3448:7: ( rule__Reference__Group_4_0_1_1__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_0_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3449:7: ( rule__Reference__Group_4_0_1_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3449:8: rule__Reference__Group_4_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_1__0_in_rule__Reference__UnorderedGroup_4_0_1__Impl7210);
                    rule__Reference__Group_4_0_1_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_0_1_1()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__UnorderedGroup_4_0_1__Impl


    // $ANTLR start rule__Reference__UnorderedGroup_4_0_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3464:1: rule__Reference__UnorderedGroup_4_0_1__0 : rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )? ;
    public final void rule__Reference__UnorderedGroup_4_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3468:1: ( rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3469:2: rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__UnorderedGroup_4_0_1__Impl_in_rule__Reference__UnorderedGroup_4_0_1__07269);
            rule__Reference__UnorderedGroup_4_0_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3470:2: ( rule__Reference__UnorderedGroup_4_0_1__1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0))) {
                alt33=1;
            }
            else if ( (LA33_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1))) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3470:2: rule__Reference__UnorderedGroup_4_0_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__UnorderedGroup_4_0_1__1_in_rule__Reference__UnorderedGroup_4_0_1__07272);
                    rule__Reference__UnorderedGroup_4_0_1__1();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__UnorderedGroup_4_0_1__0


    // $ANTLR start rule__Reference__UnorderedGroup_4_0_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3477:1: rule__Reference__UnorderedGroup_4_0_1__1 : rule__Reference__UnorderedGroup_4_0_1__Impl ;
    public final void rule__Reference__UnorderedGroup_4_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3481:1: ( rule__Reference__UnorderedGroup_4_0_1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3482:2: rule__Reference__UnorderedGroup_4_0_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__UnorderedGroup_4_0_1__Impl_in_rule__Reference__UnorderedGroup_4_0_1__17297);
            rule__Reference__UnorderedGroup_4_0_1__Impl();
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
    // $ANTLR end rule__Reference__UnorderedGroup_4_0_1__1


    // $ANTLR start rule__Object2__UnorderedGroup_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3493:1: rule__Object2__UnorderedGroup_5 : ( rule__Object2__UnorderedGroup_5__0 )? ;
    public final void rule__Object2__UnorderedGroup_5() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getObject2Access().getUnorderedGroup_5());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3498:1: ( ( rule__Object2__UnorderedGroup_5__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3499:2: ( rule__Object2__UnorderedGroup_5__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3499:2: ( rule__Object2__UnorderedGroup_5__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0))) {
                alt34=1;
            }
            else if ( (LA34_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1))) {
                alt34=1;
            }
            else if ( (LA34_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2))) {
                alt34=1;
            }
            else if ( (LA34_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3))) {
                alt34=1;
            }
            else if ( ((LA34_0>=26 && LA34_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3499:2: rule__Object2__UnorderedGroup_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5__0_in_rule__Object2__UnorderedGroup_57325);
                    rule__Object2__UnorderedGroup_5__0();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__UnorderedGroup_5


    // $ANTLR start rule__Object2__UnorderedGroup_5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3509:1: rule__Object2__UnorderedGroup_5__Impl : ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) ) ;
    public final void rule__Object2__UnorderedGroup_5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3514:1: ( ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3515:3: ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3515:3: ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) )
            int alt36=5;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0))) {
                alt36=1;
            }
            else if ( (LA36_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1))) {
                alt36=2;
            }
            else if ( (LA36_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2))) {
                alt36=3;
            }
            else if ( (LA36_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3))) {
                alt36=4;
            }
            else if ( ((LA36_0>=26 && LA36_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) {
                alt36=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3515:3: ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) )", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3517:4: ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3517:4: ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3518:5: {...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)) ) {
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3518:104: ( ( ( rule__Object2__Group_5_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3519:6: ( ( rule__Object2__Group_5_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3525:6: ( ( rule__Object2__Group_5_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3527:7: ( rule__Object2__Group_5_0__0 )
                    {
                     before(grammarAccess.getObject2Access().getGroup_5_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3528:7: ( rule__Object2__Group_5_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3528:8: rule__Object2__Group_5_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_0__0_in_rule__Object2__UnorderedGroup_5__Impl7412);
                    rule__Object2__Group_5_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObject2Access().getGroup_5_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3534:4: ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3534:4: ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3535:5: {...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)) ) {
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3535:104: ( ( ( rule__Object2__Group_5_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3536:6: ( ( rule__Object2__Group_5_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3542:6: ( ( rule__Object2__Group_5_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3544:7: ( rule__Object2__Group_5_1__0 )
                    {
                     before(grammarAccess.getObject2Access().getGroup_5_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3545:7: ( rule__Object2__Group_5_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3545:8: rule__Object2__Group_5_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_1__0_in_rule__Object2__UnorderedGroup_5__Impl7503);
                    rule__Object2__Group_5_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObject2Access().getGroup_5_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3551:4: ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3551:4: ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3552:5: {...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)) ) {
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3552:104: ( ( ( rule__Object2__Group_5_2__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3553:6: ( ( rule__Object2__Group_5_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3559:6: ( ( rule__Object2__Group_5_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3561:7: ( rule__Object2__Group_5_2__0 )
                    {
                     before(grammarAccess.getObject2Access().getGroup_5_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3562:7: ( rule__Object2__Group_5_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3562:8: rule__Object2__Group_5_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_2__0_in_rule__Object2__UnorderedGroup_5__Impl7594);
                    rule__Object2__Group_5_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObject2Access().getGroup_5_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3568:4: ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3568:4: ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3569:5: {...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)) ) {
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3569:104: ( ( ( rule__Object2__Group_5_3__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3570:6: ( ( rule__Object2__Group_5_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3576:6: ( ( rule__Object2__Group_5_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3578:7: ( rule__Object2__Group_5_3__0 )
                    {
                     before(grammarAccess.getObject2Access().getGroup_5_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3579:7: ( rule__Object2__Group_5_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3579:8: rule__Object2__Group_5_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__Group_5_3__0_in_rule__Object2__UnorderedGroup_5__Impl7685);
                    rule__Object2__Group_5_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObject2Access().getGroup_5_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3585:4: ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3585:4: ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3586:5: {...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3586:104: ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3587:6: ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3593:6: ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3594:6: ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( rule__Object2__FeaturesAssignment_5_4 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3594:6: ( ( rule__Object2__FeaturesAssignment_5_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3595:7: ( rule__Object2__FeaturesAssignment_5_4 )
                    {
                     before(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3596:7: ( rule__Object2__FeaturesAssignment_5_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3596:8: rule__Object2__FeaturesAssignment_5_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__FeaturesAssignment_5_4_in_rule__Object2__UnorderedGroup_5__Impl7777);
                    rule__Object2__FeaturesAssignment_5_4();
                    _fsp--;


                    }

                     after(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3599:6: ( ( rule__Object2__FeaturesAssignment_5_4 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3600:7: ( rule__Object2__FeaturesAssignment_5_4 )*
                    {
                     before(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3601:7: ( rule__Object2__FeaturesAssignment_5_4 )*
                    loop35:
                    do {
                        int alt35=2;
                        alt35 = dfa35.predict(input);
                        switch (alt35) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3601:8: rule__Object2__FeaturesAssignment_5_4
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__Object2__FeaturesAssignment_5_4_in_rule__Object2__UnorderedGroup_5__Impl7817);
                    	    rule__Object2__FeaturesAssignment_5_4();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);

                     after(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__UnorderedGroup_5__Impl


    // $ANTLR start rule__Object2__UnorderedGroup_5__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3616:1: rule__Object2__UnorderedGroup_5__0 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__1 )? ;
    public final void rule__Object2__UnorderedGroup_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3620:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3621:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5__Impl_in_rule__Object2__UnorderedGroup_5__07883);
            rule__Object2__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3622:2: ( rule__Object2__UnorderedGroup_5__1 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0))) {
                alt37=1;
            }
            else if ( (LA37_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1))) {
                alt37=1;
            }
            else if ( (LA37_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2))) {
                alt37=1;
            }
            else if ( (LA37_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3))) {
                alt37=1;
            }
            else if ( ((LA37_0>=26 && LA37_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3622:2: rule__Object2__UnorderedGroup_5__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5__1_in_rule__Object2__UnorderedGroup_5__07886);
                    rule__Object2__UnorderedGroup_5__1();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__UnorderedGroup_5__0


    // $ANTLR start rule__Object2__UnorderedGroup_5__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3629:1: rule__Object2__UnorderedGroup_5__1 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__2 )? ;
    public final void rule__Object2__UnorderedGroup_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3633:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3634:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5__Impl_in_rule__Object2__UnorderedGroup_5__17911);
            rule__Object2__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3635:2: ( rule__Object2__UnorderedGroup_5__2 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0))) {
                alt38=1;
            }
            else if ( (LA38_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1))) {
                alt38=1;
            }
            else if ( (LA38_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2))) {
                alt38=1;
            }
            else if ( (LA38_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3))) {
                alt38=1;
            }
            else if ( ((LA38_0>=26 && LA38_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3635:2: rule__Object2__UnorderedGroup_5__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5__2_in_rule__Object2__UnorderedGroup_5__17914);
                    rule__Object2__UnorderedGroup_5__2();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__UnorderedGroup_5__1


    // $ANTLR start rule__Object2__UnorderedGroup_5__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3642:1: rule__Object2__UnorderedGroup_5__2 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__3 )? ;
    public final void rule__Object2__UnorderedGroup_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3646:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3647:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5__Impl_in_rule__Object2__UnorderedGroup_5__27939);
            rule__Object2__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3648:2: ( rule__Object2__UnorderedGroup_5__3 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0))) {
                alt39=1;
            }
            else if ( (LA39_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1))) {
                alt39=1;
            }
            else if ( (LA39_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2))) {
                alt39=1;
            }
            else if ( (LA39_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3))) {
                alt39=1;
            }
            else if ( ((LA39_0>=26 && LA39_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3648:2: rule__Object2__UnorderedGroup_5__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5__3_in_rule__Object2__UnorderedGroup_5__27942);
                    rule__Object2__UnorderedGroup_5__3();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__UnorderedGroup_5__2


    // $ANTLR start rule__Object2__UnorderedGroup_5__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3655:1: rule__Object2__UnorderedGroup_5__3 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__4 )? ;
    public final void rule__Object2__UnorderedGroup_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3659:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__4 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3660:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5__Impl_in_rule__Object2__UnorderedGroup_5__37967);
            rule__Object2__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3661:2: ( rule__Object2__UnorderedGroup_5__4 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0))) {
                alt40=1;
            }
            else if ( (LA40_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1))) {
                alt40=1;
            }
            else if ( (LA40_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2))) {
                alt40=1;
            }
            else if ( (LA40_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3))) {
                alt40=1;
            }
            else if ( ((LA40_0>=26 && LA40_0<=27)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3661:2: rule__Object2__UnorderedGroup_5__4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5__4_in_rule__Object2__UnorderedGroup_5__37970);
                    rule__Object2__UnorderedGroup_5__4();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__UnorderedGroup_5__3


    // $ANTLR start rule__Object2__UnorderedGroup_5__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3668:1: rule__Object2__UnorderedGroup_5__4 : rule__Object2__UnorderedGroup_5__Impl ;
    public final void rule__Object2__UnorderedGroup_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3672:1: ( rule__Object2__UnorderedGroup_5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3673:2: rule__Object2__UnorderedGroup_5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object2__UnorderedGroup_5__Impl_in_rule__Object2__UnorderedGroup_5__47995);
            rule__Object2__UnorderedGroup_5__Impl();
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
    // $ANTLR end rule__Object2__UnorderedGroup_5__4


    // $ANTLR start rule__Attribute2__UnorderedGroup_3_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3690:1: rule__Attribute2__UnorderedGroup_3_0_1 : ( rule__Attribute2__UnorderedGroup_3_0_1__0 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3695:1: ( ( rule__Attribute2__UnorderedGroup_3_0_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3696:2: ( rule__Attribute2__UnorderedGroup_3_0_1__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3696:2: ( rule__Attribute2__UnorderedGroup_3_0_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0))) {
                alt41=1;
            }
            else if ( (LA41_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1))) {
                alt41=1;
            }
            else if ( (LA41_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2))) {
                alt41=1;
            }
            else if ( (LA41_0==35) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3))) {
                alt41=1;
            }
            else if ( (LA41_0==36) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4))) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3696:2: rule__Attribute2__UnorderedGroup_3_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__0_in_rule__Attribute2__UnorderedGroup_3_0_18029);
                    rule__Attribute2__UnorderedGroup_3_0_1__0();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__UnorderedGroup_3_0_1


    // $ANTLR start rule__Attribute2__UnorderedGroup_3_0_1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3706:1: rule__Attribute2__UnorderedGroup_3_0_1__Impl : ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) ) ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3711:1: ( ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3712:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3712:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) )
            int alt43=5;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0))) {
                alt43=1;
            }
            else if ( (LA43_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1))) {
                alt43=2;
            }
            else if ( (LA43_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2))) {
                alt43=3;
            }
            else if ( (LA43_0==35) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3))) {
                alt43=4;
            }
            else if ( (LA43_0==36) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4))) {
                alt43=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3712:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) )", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3714:4: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3714:4: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3715:5: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)) ) {
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3715:111: ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3716:6: ( ( rule__Attribute2__Group_3_0_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3722:6: ( ( rule__Attribute2__Group_3_0_1_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3724:7: ( rule__Attribute2__Group_3_0_1_0__0 )
                    {
                     before(grammarAccess.getAttribute2Access().getGroup_3_0_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3725:7: ( rule__Attribute2__Group_3_0_1_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3725:8: rule__Attribute2__Group_3_0_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0_1_0__0_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8116);
                    rule__Attribute2__Group_3_0_1_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getAttribute2Access().getGroup_3_0_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3731:4: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3731:4: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3732:5: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)) ) {
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3732:111: ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3733:6: ( ( rule__Attribute2__Group_3_0_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3739:6: ( ( rule__Attribute2__Group_3_0_1_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3741:7: ( rule__Attribute2__Group_3_0_1_1__0 )
                    {
                     before(grammarAccess.getAttribute2Access().getGroup_3_0_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3742:7: ( rule__Attribute2__Group_3_0_1_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3742:8: rule__Attribute2__Group_3_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0_1_1__0_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8207);
                    rule__Attribute2__Group_3_0_1_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getAttribute2Access().getGroup_3_0_1_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3748:4: ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3748:4: ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3749:5: {...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)) ) {
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3749:111: ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3750:6: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3756:6: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3757:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3757:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3758:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
                    {
                     before(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3759:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3759:8: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8299);
                    rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();
                    _fsp--;


                    }

                     after(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3762:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3763:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*
                    {
                     before(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3764:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*
                    loop42:
                    do {
                        int alt42=2;
                        alt42 = dfa42.predict(input);
                        switch (alt42) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3764:8: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8339);
                    	    rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                     after(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3770:4: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3770:4: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3771:5: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)) ) {
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3771:111: ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3772:6: ( ( rule__Attribute2__Group_3_0_1_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3778:6: ( ( rule__Attribute2__Group_3_0_1_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3780:7: ( rule__Attribute2__Group_3_0_1_3__0 )
                    {
                     before(grammarAccess.getAttribute2Access().getGroup_3_0_1_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3781:7: ( rule__Attribute2__Group_3_0_1_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3781:8: rule__Attribute2__Group_3_0_1_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0_1_3__0_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8437);
                    rule__Attribute2__Group_3_0_1_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getAttribute2Access().getGroup_3_0_1_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3787:4: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3787:4: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3788:5: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4)) ) {
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3788:111: ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3789:6: ( ( rule__Attribute2__Group_3_0_1_4__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3795:6: ( ( rule__Attribute2__Group_3_0_1_4__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3797:7: ( rule__Attribute2__Group_3_0_1_4__0 )
                    {
                     before(grammarAccess.getAttribute2Access().getGroup_3_0_1_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3798:7: ( rule__Attribute2__Group_3_0_1_4__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3798:8: rule__Attribute2__Group_3_0_1_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__Group_3_0_1_4__0_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8528);
                    rule__Attribute2__Group_3_0_1_4__0();
                    _fsp--;


                    }

                     after(grammarAccess.getAttribute2Access().getGroup_3_0_1_4()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__UnorderedGroup_3_0_1__Impl


    // $ANTLR start rule__Attribute2__UnorderedGroup_3_0_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3813:1: rule__Attribute2__UnorderedGroup_3_0_1__0 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__1 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3817:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3818:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__Impl_in_rule__Attribute2__UnorderedGroup_3_0_1__08587);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3819:2: ( rule__Attribute2__UnorderedGroup_3_0_1__1 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0))) {
                alt44=1;
            }
            else if ( (LA44_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1))) {
                alt44=1;
            }
            else if ( (LA44_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2))) {
                alt44=1;
            }
            else if ( (LA44_0==35) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3))) {
                alt44=1;
            }
            else if ( (LA44_0==36) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4))) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3819:2: rule__Attribute2__UnorderedGroup_3_0_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__1_in_rule__Attribute2__UnorderedGroup_3_0_1__08590);
                    rule__Attribute2__UnorderedGroup_3_0_1__1();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__UnorderedGroup_3_0_1__0


    // $ANTLR start rule__Attribute2__UnorderedGroup_3_0_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3826:1: rule__Attribute2__UnorderedGroup_3_0_1__1 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__2 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3830:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3831:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__Impl_in_rule__Attribute2__UnorderedGroup_3_0_1__18615);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3832:2: ( rule__Attribute2__UnorderedGroup_3_0_1__2 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0))) {
                alt45=1;
            }
            else if ( (LA45_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1))) {
                alt45=1;
            }
            else if ( (LA45_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2))) {
                alt45=1;
            }
            else if ( (LA45_0==35) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3))) {
                alt45=1;
            }
            else if ( (LA45_0==36) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4))) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3832:2: rule__Attribute2__UnorderedGroup_3_0_1__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__2_in_rule__Attribute2__UnorderedGroup_3_0_1__18618);
                    rule__Attribute2__UnorderedGroup_3_0_1__2();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__UnorderedGroup_3_0_1__1


    // $ANTLR start rule__Attribute2__UnorderedGroup_3_0_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3839:1: rule__Attribute2__UnorderedGroup_3_0_1__2 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__3 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3843:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3844:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__Impl_in_rule__Attribute2__UnorderedGroup_3_0_1__28643);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3845:2: ( rule__Attribute2__UnorderedGroup_3_0_1__3 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0))) {
                alt46=1;
            }
            else if ( (LA46_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1))) {
                alt46=1;
            }
            else if ( (LA46_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2))) {
                alt46=1;
            }
            else if ( (LA46_0==35) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3))) {
                alt46=1;
            }
            else if ( (LA46_0==36) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4))) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3845:2: rule__Attribute2__UnorderedGroup_3_0_1__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__3_in_rule__Attribute2__UnorderedGroup_3_0_1__28646);
                    rule__Attribute2__UnorderedGroup_3_0_1__3();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__UnorderedGroup_3_0_1__2


    // $ANTLR start rule__Attribute2__UnorderedGroup_3_0_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3852:1: rule__Attribute2__UnorderedGroup_3_0_1__3 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__4 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3856:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__4 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3857:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__Impl_in_rule__Attribute2__UnorderedGroup_3_0_1__38671);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3858:2: ( rule__Attribute2__UnorderedGroup_3_0_1__4 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0))) {
                alt47=1;
            }
            else if ( (LA47_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1))) {
                alt47=1;
            }
            else if ( (LA47_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2))) {
                alt47=1;
            }
            else if ( (LA47_0==35) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3))) {
                alt47=1;
            }
            else if ( (LA47_0==36) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4))) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3858:2: rule__Attribute2__UnorderedGroup_3_0_1__4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__4_in_rule__Attribute2__UnorderedGroup_3_0_1__38674);
                    rule__Attribute2__UnorderedGroup_3_0_1__4();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__UnorderedGroup_3_0_1__3


    // $ANTLR start rule__Attribute2__UnorderedGroup_3_0_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3865:1: rule__Attribute2__UnorderedGroup_3_0_1__4 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3869:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3870:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__Impl_in_rule__Attribute2__UnorderedGroup_3_0_1__48699);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();
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
    // $ANTLR end rule__Attribute2__UnorderedGroup_3_0_1__4


    // $ANTLR start rule__Reference2__UnorderedGroup_4_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3887:1: rule__Reference2__UnorderedGroup_4_0_1 : ( rule__Reference2__UnorderedGroup_4_0_1__0 )? ;
    public final void rule__Reference2__UnorderedGroup_4_0_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3892:1: ( ( rule__Reference2__UnorderedGroup_4_0_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3893:2: ( rule__Reference2__UnorderedGroup_4_0_1__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3893:2: ( rule__Reference2__UnorderedGroup_4_0_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0))) {
                alt48=1;
            }
            else if ( (LA48_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1))) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3893:2: rule__Reference2__UnorderedGroup_4_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference2__UnorderedGroup_4_0_1__0_in_rule__Reference2__UnorderedGroup_4_0_18733);
                    rule__Reference2__UnorderedGroup_4_0_1__0();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__UnorderedGroup_4_0_1


    // $ANTLR start rule__Reference2__UnorderedGroup_4_0_1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3903:1: rule__Reference2__UnorderedGroup_4_0_1__Impl : ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) ) ;
    public final void rule__Reference2__UnorderedGroup_4_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3908:1: ( ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3909:3: ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3909:3: ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0))) {
                alt49=1;
            }
            else if ( (LA49_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1))) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3909:3: ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) )", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3911:4: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3911:4: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3912:5: {...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)) ) {
                        throw new FailedPredicateException(input, "rule__Reference2__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3912:111: ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3913:6: ( ( rule__Reference2__Group_4_0_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3919:6: ( ( rule__Reference2__Group_4_0_1_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3921:7: ( rule__Reference2__Group_4_0_1_0__0 )
                    {
                     before(grammarAccess.getReference2Access().getGroup_4_0_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3922:7: ( rule__Reference2__Group_4_0_1_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3922:8: rule__Reference2__Group_4_0_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group_4_0_1_0__0_in_rule__Reference2__UnorderedGroup_4_0_1__Impl8820);
                    rule__Reference2__Group_4_0_1_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReference2Access().getGroup_4_0_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3928:4: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3928:4: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3929:5: {...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1)) ) {
                        throw new FailedPredicateException(input, "rule__Reference2__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3929:111: ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3930:6: ( ( rule__Reference2__Group_4_0_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3936:6: ( ( rule__Reference2__Group_4_0_1_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3938:7: ( rule__Reference2__Group_4_0_1_1__0 )
                    {
                     before(grammarAccess.getReference2Access().getGroup_4_0_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3939:7: ( rule__Reference2__Group_4_0_1_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3939:8: rule__Reference2__Group_4_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference2__Group_4_0_1_1__0_in_rule__Reference2__UnorderedGroup_4_0_1__Impl8911);
                    rule__Reference2__Group_4_0_1_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReference2Access().getGroup_4_0_1_1()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__UnorderedGroup_4_0_1__Impl


    // $ANTLR start rule__Reference2__UnorderedGroup_4_0_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3954:1: rule__Reference2__UnorderedGroup_4_0_1__0 : rule__Reference2__UnorderedGroup_4_0_1__Impl ( rule__Reference2__UnorderedGroup_4_0_1__1 )? ;
    public final void rule__Reference2__UnorderedGroup_4_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3958:1: ( rule__Reference2__UnorderedGroup_4_0_1__Impl ( rule__Reference2__UnorderedGroup_4_0_1__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3959:2: rule__Reference2__UnorderedGroup_4_0_1__Impl ( rule__Reference2__UnorderedGroup_4_0_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference2__UnorderedGroup_4_0_1__Impl_in_rule__Reference2__UnorderedGroup_4_0_1__08970);
            rule__Reference2__UnorderedGroup_4_0_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3960:2: ( rule__Reference2__UnorderedGroup_4_0_1__1 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0))) {
                alt50=1;
            }
            else if ( (LA50_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1))) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3960:2: rule__Reference2__UnorderedGroup_4_0_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference2__UnorderedGroup_4_0_1__1_in_rule__Reference2__UnorderedGroup_4_0_1__08973);
                    rule__Reference2__UnorderedGroup_4_0_1__1();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__UnorderedGroup_4_0_1__0


    // $ANTLR start rule__Reference2__UnorderedGroup_4_0_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3967:1: rule__Reference2__UnorderedGroup_4_0_1__1 : rule__Reference2__UnorderedGroup_4_0_1__Impl ;
    public final void rule__Reference2__UnorderedGroup_4_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3971:1: ( rule__Reference2__UnorderedGroup_4_0_1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3972:2: rule__Reference2__UnorderedGroup_4_0_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference2__UnorderedGroup_4_0_1__Impl_in_rule__Reference2__UnorderedGroup_4_0_1__18998);
            rule__Reference2__UnorderedGroup_4_0_1__Impl();
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
    // $ANTLR end rule__Reference2__UnorderedGroup_4_0_1__1


    // $ANTLR start rule__ConstraintDefinition__UnorderedGroup_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3983:1: rule__ConstraintDefinition__UnorderedGroup_3 : rule__ConstraintDefinition__UnorderedGroup_3__0 {...}?;
    public final void rule__ConstraintDefinition__UnorderedGroup_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3988:1: ( rule__ConstraintDefinition__UnorderedGroup_3__0 {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:3989:2: rule__ConstraintDefinition__UnorderedGroup_3__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__UnorderedGroup_3__0_in_rule__ConstraintDefinition__UnorderedGroup_39026);
            rule__ConstraintDefinition__UnorderedGroup_3__0();
            _fsp--;

            if ( !(getUnorderedGroupHelper().canLeave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3())) ) {
                throw new FailedPredicateException(input, "rule__ConstraintDefinition__UnorderedGroup_3", "getUnorderedGroupHelper().canLeave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConstraintDefinition__UnorderedGroup_3


    // $ANTLR start rule__ConstraintDefinition__UnorderedGroup_3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4000:1: rule__ConstraintDefinition__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) ) ;
    public final void rule__ConstraintDefinition__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4005:1: ( ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4006:3: ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4006:3: ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==29) && (getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0))) {
                alt51=1;
            }
            else if ( (LA51_0==30) && (getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1))) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4006:3: ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) )", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4008:4: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4008:4: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4009:5: {...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)) ) {
                        throw new FailedPredicateException(input, "rule__ConstraintDefinition__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4009:117: ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4010:6: ( ( rule__ConstraintDefinition__Group_3_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4016:6: ( ( rule__ConstraintDefinition__Group_3_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4018:7: ( rule__ConstraintDefinition__Group_3_0__0 )
                    {
                     before(grammarAccess.getConstraintDefinitionAccess().getGroup_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4019:7: ( rule__ConstraintDefinition__Group_3_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4019:8: rule__ConstraintDefinition__Group_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group_3_0__0_in_rule__ConstraintDefinition__UnorderedGroup_3__Impl9115);
                    rule__ConstraintDefinition__Group_3_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getConstraintDefinitionAccess().getGroup_3_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4025:4: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4025:4: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4026:5: {...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1)) ) {
                        throw new FailedPredicateException(input, "rule__ConstraintDefinition__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4026:117: ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4027:6: ( ( rule__ConstraintDefinition__Group_3_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4033:6: ( ( rule__ConstraintDefinition__Group_3_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4035:7: ( rule__ConstraintDefinition__Group_3_1__0 )
                    {
                     before(grammarAccess.getConstraintDefinitionAccess().getGroup_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4036:7: ( rule__ConstraintDefinition__Group_3_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4036:8: rule__ConstraintDefinition__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__Group_3_1__0_in_rule__ConstraintDefinition__UnorderedGroup_3__Impl9206);
                    rule__ConstraintDefinition__Group_3_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getConstraintDefinitionAccess().getGroup_3_1()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConstraintDefinition__UnorderedGroup_3__Impl


    // $ANTLR start rule__ConstraintDefinition__UnorderedGroup_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4051:1: rule__ConstraintDefinition__UnorderedGroup_3__0 : rule__ConstraintDefinition__UnorderedGroup_3__Impl ( rule__ConstraintDefinition__UnorderedGroup_3__1 )? ;
    public final void rule__ConstraintDefinition__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4055:1: ( rule__ConstraintDefinition__UnorderedGroup_3__Impl ( rule__ConstraintDefinition__UnorderedGroup_3__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4056:2: rule__ConstraintDefinition__UnorderedGroup_3__Impl ( rule__ConstraintDefinition__UnorderedGroup_3__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__UnorderedGroup_3__Impl_in_rule__ConstraintDefinition__UnorderedGroup_3__09265);
            rule__ConstraintDefinition__UnorderedGroup_3__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4057:2: ( rule__ConstraintDefinition__UnorderedGroup_3__1 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==29) && (getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0))) {
                alt52=1;
            }
            else if ( (LA52_0==30) && (getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1))) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4057:2: rule__ConstraintDefinition__UnorderedGroup_3__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__UnorderedGroup_3__1_in_rule__ConstraintDefinition__UnorderedGroup_3__09268);
                    rule__ConstraintDefinition__UnorderedGroup_3__1();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConstraintDefinition__UnorderedGroup_3__0


    // $ANTLR start rule__ConstraintDefinition__UnorderedGroup_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4064:1: rule__ConstraintDefinition__UnorderedGroup_3__1 : rule__ConstraintDefinition__UnorderedGroup_3__Impl ;
    public final void rule__ConstraintDefinition__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4068:1: ( rule__ConstraintDefinition__UnorderedGroup_3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4069:2: rule__ConstraintDefinition__UnorderedGroup_3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ConstraintDefinition__UnorderedGroup_3__Impl_in_rule__ConstraintDefinition__UnorderedGroup_3__19293);
            rule__ConstraintDefinition__UnorderedGroup_3__Impl();
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
    // $ANTLR end rule__ConstraintDefinition__UnorderedGroup_3__1


    // $ANTLR start rule__Model__DefinitionAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4080:1: rule__Model__DefinitionAssignment_0_1 : ( rulePackageDefinition ) ;
    public final void rule__Model__DefinitionAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4084:1: ( ( rulePackageDefinition ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4085:1: ( rulePackageDefinition )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4085:1: ( rulePackageDefinition )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4086:1: rulePackageDefinition
            {
             before(grammarAccess.getModelAccess().getDefinitionPackageDefinitionParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition_in_rule__Model__DefinitionAssignment_0_19325);
            rulePackageDefinition();
            _fsp--;

             after(grammarAccess.getModelAccess().getDefinitionPackageDefinitionParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__DefinitionAssignment_0_1


    // $ANTLR start rule__Model__DefinitionAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4095:1: rule__Model__DefinitionAssignment_1_1 : ( rulePackageDefinition2 ) ;
    public final void rule__Model__DefinitionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4099:1: ( ( rulePackageDefinition2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4100:1: ( rulePackageDefinition2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4100:1: ( rulePackageDefinition2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4101:1: rulePackageDefinition2
            {
             before(grammarAccess.getModelAccess().getDefinitionPackageDefinition2ParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition2_in_rule__Model__DefinitionAssignment_1_19356);
            rulePackageDefinition2();
            _fsp--;

             after(grammarAccess.getModelAccess().getDefinitionPackageDefinition2ParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__DefinitionAssignment_1_1


    // $ANTLR start rule__PackageDefinition__NamespaceAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4110:1: rule__PackageDefinition__NamespaceAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageDefinition__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4114:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4115:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4115:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4116:1: RULE_ID
            {
             before(grammarAccess.getPackageDefinitionAccess().getNamespaceIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__PackageDefinition__NamespaceAssignment_29387); 
             after(grammarAccess.getPackageDefinitionAccess().getNamespaceIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDefinition__NamespaceAssignment_2


    // $ANTLR start rule__PackageDefinition__ContentsAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4125:1: rule__PackageDefinition__ContentsAssignment_4 : ( ruleObject ) ;
    public final void rule__PackageDefinition__ContentsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4129:1: ( ( ruleObject ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4130:1: ( ruleObject )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4130:1: ( ruleObject )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4131:1: ruleObject
            {
             before(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleObject_in_rule__PackageDefinition__ContentsAssignment_49418);
            ruleObject();
            _fsp--;

             after(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDefinition__ContentsAssignment_4


    // $ANTLR start rule__Object__EnabledAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4140:1: rule__Object__EnabledAssignment_0_0 : ( ( 'enabled' ) ) ;
    public final void rule__Object__EnabledAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4144:1: ( ( ( 'enabled' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4145:1: ( ( 'enabled' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4145:1: ( ( 'enabled' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4146:1: ( 'enabled' )
            {
             before(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4147:1: ( 'enabled' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4148:1: 'enabled'
            {
             before(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__Object__EnabledAssignment_0_09454); 
             after(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 

            }

             after(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__EnabledAssignment_0_0


    // $ANTLR start rule__Object__AbstractAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4163:1: rule__Object__AbstractAssignment_0_1 : ( ( 'abstract' ) ) ;
    public final void rule__Object__AbstractAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4167:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4168:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4168:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4169:1: ( 'abstract' )
            {
             before(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4170:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4171:1: 'abstract'
            {
             before(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Object__AbstractAssignment_0_19498); 
             after(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 

            }

             after(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__AbstractAssignment_0_1


    // $ANTLR start rule__Object__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4186:1: rule__Object__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Object__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4190:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4191:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4191:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4192:1: RULE_ID
            {
             before(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Object__NameAssignment_29537); 
             after(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__NameAssignment_2


    // $ANTLR start rule__Object__ParentAssignment_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4201:1: rule__Object__ParentAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Object__ParentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4205:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4206:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4206:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4207:1: ( RULE_ID )
            {
             before(grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4208:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4209:1: RULE_ID
            {
             before(grammarAccess.getObjectAccess().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Object__ParentAssignment_3_19572); 
             after(grammarAccess.getObjectAccess().getParentObjectIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__ParentAssignment_3_1


    // $ANTLR start rule__Object__ShortDescriptionAssignment_5_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4220:1: rule__Object__ShortDescriptionAssignment_5_0_1 : ( RULE_STRING ) ;
    public final void rule__Object__ShortDescriptionAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4224:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4225:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4225:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4226:1: RULE_STRING
            {
             before(grammarAccess.getObjectAccess().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Object__ShortDescriptionAssignment_5_0_19607); 
             after(grammarAccess.getObjectAccess().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__ShortDescriptionAssignment_5_0_1


    // $ANTLR start rule__Object__LongDescriptionAssignment_5_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4235:1: rule__Object__LongDescriptionAssignment_5_1_1 : ( RULE_STRING ) ;
    public final void rule__Object__LongDescriptionAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4239:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4240:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4240:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4241:1: RULE_STRING
            {
             before(grammarAccess.getObjectAccess().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Object__LongDescriptionAssignment_5_1_19638); 
             after(grammarAccess.getObjectAccess().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__LongDescriptionAssignment_5_1_1


    // $ANTLR start rule__Object__SerialVersionUIDAssignment_5_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4250:1: rule__Object__SerialVersionUIDAssignment_5_2_1 : ( RULE_INT ) ;
    public final void rule__Object__SerialVersionUIDAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4254:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4255:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4255:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4256:1: RULE_INT
            {
             before(grammarAccess.getObjectAccess().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Object__SerialVersionUIDAssignment_5_2_19669); 
             after(grammarAccess.getObjectAccess().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__SerialVersionUIDAssignment_5_2_1


    // $ANTLR start rule__Object__CloneableAssignment_5_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4265:1: rule__Object__CloneableAssignment_5_3_0 : ( ( 'cloneable' ) ) ;
    public final void rule__Object__CloneableAssignment_5_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4269:1: ( ( ( 'cloneable' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4270:1: ( ( 'cloneable' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4270:1: ( ( 'cloneable' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4271:1: ( 'cloneable' )
            {
             before(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4272:1: ( 'cloneable' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4273:1: 'cloneable'
            {
             before(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__Object__CloneableAssignment_5_3_09705); 
             after(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 

            }

             after(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__CloneableAssignment_5_3_0


    // $ANTLR start rule__Object__FeaturesAssignment_5_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4288:1: rule__Object__FeaturesAssignment_5_4 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4292:1: ( ( ruleFeature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4293:1: ( ruleFeature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4293:1: ( ruleFeature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4294:1: ruleFeature
            {
             before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_49744);
            ruleFeature();
            _fsp--;

             after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__FeaturesAssignment_5_4


    // $ANTLR start rule__Object__FeaturesAssignment_5_5_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4303:1: rule__Object__FeaturesAssignment_5_5_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4307:1: ( ( ruleFeature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4308:1: ( ruleFeature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4308:1: ( ruleFeature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4309:1: ruleFeature
            {
             before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_5_19775);
            ruleFeature();
            _fsp--;

             after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__FeaturesAssignment_5_5_1


    // $ANTLR start rule__Object__FeaturesAssignment_5_6_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4318:1: rule__Object__FeaturesAssignment_5_6_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4322:1: ( ( ruleFeature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4323:1: ( ruleFeature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4323:1: ( ruleFeature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4324:1: ruleFeature
            {
             before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_6_19806);
            ruleFeature();
            _fsp--;

             after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__FeaturesAssignment_5_6_1


    // $ANTLR start rule__Object__FeaturesAssignment_5_7_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4333:1: rule__Object__FeaturesAssignment_5_7_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4337:1: ( ( ruleFeature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4338:1: ( ruleFeature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4338:1: ( ruleFeature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4339:1: ruleFeature
            {
             before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_7_19837);
            ruleFeature();
            _fsp--;

             after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__FeaturesAssignment_5_7_1


    // $ANTLR start rule__Attribute__TypeAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4348:1: rule__Attribute__TypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4352:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4353:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4353:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4354:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getTypeIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__TypeAssignment_19868); 
             after(grammarAccess.getAttributeAccess().getTypeIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__TypeAssignment_1


    // $ANTLR start rule__Attribute__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4363:1: rule__Attribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4367:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4368:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4368:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4369:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_29899); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__NameAssignment_2


    // $ANTLR start rule__Reference__TypeAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4378:1: rule__Reference__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4382:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4383:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4383:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4384:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4385:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4386:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Reference__TypeAssignment_19934); 
             after(grammarAccess.getReferenceAccess().getTypeObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__TypeAssignment_1


    // $ANTLR start rule__Reference__ManyAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4397:1: rule__Reference__ManyAssignment_2 : ( ( '*' ) ) ;
    public final void rule__Reference__ManyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4401:1: ( ( ( '*' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4402:1: ( ( '*' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4402:1: ( ( '*' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4403:1: ( '*' )
            {
             before(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4404:1: ( '*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4405:1: '*'
            {
             before(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__Reference__ManyAssignment_29974); 
             after(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 

            }

             after(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__ManyAssignment_2


    // $ANTLR start rule__Reference__NameAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4420:1: rule__Reference__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Reference__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4424:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4425:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4425:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4426:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_310013); 
             after(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__NameAssignment_3


    // $ANTLR start rule__Reference__ShortDescriptionAssignment_4_0_1_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4435:1: rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Reference__ShortDescriptionAssignment_4_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4439:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4440:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4440:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4441:1: RULE_STRING
            {
             before(grammarAccess.getReferenceAccess().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Reference__ShortDescriptionAssignment_4_0_1_0_110044); 
             after(grammarAccess.getReferenceAccess().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__ShortDescriptionAssignment_4_0_1_0_1


    // $ANTLR start rule__Reference__LongDescriptionAssignment_4_0_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4450:1: rule__Reference__LongDescriptionAssignment_4_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Reference__LongDescriptionAssignment_4_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4454:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4455:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4455:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4456:1: RULE_STRING
            {
             before(grammarAccess.getReferenceAccess().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Reference__LongDescriptionAssignment_4_0_1_1_110075); 
             after(grammarAccess.getReferenceAccess().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__LongDescriptionAssignment_4_0_1_1_1


    // $ANTLR start rule__PackageDefinition2__NamespaceAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4465:1: rule__PackageDefinition2__NamespaceAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageDefinition2__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4469:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4470:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4470:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4471:1: RULE_ID
            {
             before(grammarAccess.getPackageDefinition2Access().getNamespaceIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__PackageDefinition2__NamespaceAssignment_210106); 
             after(grammarAccess.getPackageDefinition2Access().getNamespaceIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDefinition2__NamespaceAssignment_2


    // $ANTLR start rule__PackageDefinition2__ContentsAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4480:1: rule__PackageDefinition2__ContentsAssignment_4 : ( ruleObject2 ) ;
    public final void rule__PackageDefinition2__ContentsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4484:1: ( ( ruleObject2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4485:1: ( ruleObject2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4485:1: ( ruleObject2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4486:1: ruleObject2
            {
             before(grammarAccess.getPackageDefinition2Access().getContentsObject2ParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleObject2_in_rule__PackageDefinition2__ContentsAssignment_410137);
            ruleObject2();
            _fsp--;

             after(grammarAccess.getPackageDefinition2Access().getContentsObject2ParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PackageDefinition2__ContentsAssignment_4


    // $ANTLR start rule__Object2__EnabledAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4495:1: rule__Object2__EnabledAssignment_0_0 : ( ( 'enabled' ) ) ;
    public final void rule__Object2__EnabledAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4499:1: ( ( ( 'enabled' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4500:1: ( ( 'enabled' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4500:1: ( ( 'enabled' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4501:1: ( 'enabled' )
            {
             before(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4502:1: ( 'enabled' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4503:1: 'enabled'
            {
             before(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__Object2__EnabledAssignment_0_010173); 
             after(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 

            }

             after(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__EnabledAssignment_0_0


    // $ANTLR start rule__Object2__AbstractAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4518:1: rule__Object2__AbstractAssignment_0_1 : ( ( 'abstract' ) ) ;
    public final void rule__Object2__AbstractAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4522:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4523:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4523:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4524:1: ( 'abstract' )
            {
             before(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4525:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4526:1: 'abstract'
            {
             before(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Object2__AbstractAssignment_0_110217); 
             after(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 

            }

             after(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__AbstractAssignment_0_1


    // $ANTLR start rule__Object2__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4541:1: rule__Object2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Object2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4545:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4546:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4546:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4547:1: RULE_ID
            {
             before(grammarAccess.getObject2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Object2__NameAssignment_210256); 
             after(grammarAccess.getObject2Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__NameAssignment_2


    // $ANTLR start rule__Object2__ParentAssignment_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4556:1: rule__Object2__ParentAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Object2__ParentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4560:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4561:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4561:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4562:1: ( RULE_ID )
            {
             before(grammarAccess.getObject2Access().getParentObjectCrossReference_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4563:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4564:1: RULE_ID
            {
             before(grammarAccess.getObject2Access().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Object2__ParentAssignment_3_110291); 
             after(grammarAccess.getObject2Access().getParentObjectIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getObject2Access().getParentObjectCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__ParentAssignment_3_1


    // $ANTLR start rule__Object2__ShortDescriptionAssignment_5_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4575:1: rule__Object2__ShortDescriptionAssignment_5_0_1 : ( RULE_STRING ) ;
    public final void rule__Object2__ShortDescriptionAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4579:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4580:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4580:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4581:1: RULE_STRING
            {
             before(grammarAccess.getObject2Access().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Object2__ShortDescriptionAssignment_5_0_110326); 
             after(grammarAccess.getObject2Access().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__ShortDescriptionAssignment_5_0_1


    // $ANTLR start rule__Object2__LongDescriptionAssignment_5_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4590:1: rule__Object2__LongDescriptionAssignment_5_1_1 : ( RULE_STRING ) ;
    public final void rule__Object2__LongDescriptionAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4594:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4595:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4595:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4596:1: RULE_STRING
            {
             before(grammarAccess.getObject2Access().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Object2__LongDescriptionAssignment_5_1_110357); 
             after(grammarAccess.getObject2Access().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__LongDescriptionAssignment_5_1_1


    // $ANTLR start rule__Object2__SerialVersionUIDAssignment_5_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4605:1: rule__Object2__SerialVersionUIDAssignment_5_2_1 : ( RULE_INT ) ;
    public final void rule__Object2__SerialVersionUIDAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4609:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4610:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4610:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4611:1: RULE_INT
            {
             before(grammarAccess.getObject2Access().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Object2__SerialVersionUIDAssignment_5_2_110388); 
             after(grammarAccess.getObject2Access().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__SerialVersionUIDAssignment_5_2_1


    // $ANTLR start rule__Object2__CloneableAssignment_5_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4620:1: rule__Object2__CloneableAssignment_5_3_0 : ( ( 'cloneable' ) ) ;
    public final void rule__Object2__CloneableAssignment_5_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4624:1: ( ( ( 'cloneable' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4625:1: ( ( 'cloneable' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4625:1: ( ( 'cloneable' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4626:1: ( 'cloneable' )
            {
             before(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4627:1: ( 'cloneable' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4628:1: 'cloneable'
            {
             before(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__Object2__CloneableAssignment_5_3_010424); 
             after(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 

            }

             after(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__CloneableAssignment_5_3_0


    // $ANTLR start rule__Object2__FeaturesAssignment_5_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4643:1: rule__Object2__FeaturesAssignment_5_4 : ( ruleFeature2 ) ;
    public final void rule__Object2__FeaturesAssignment_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4647:1: ( ( ruleFeature2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4648:1: ( ruleFeature2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4648:1: ( ruleFeature2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4649:1: ruleFeature2
            {
             before(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_rule__Object2__FeaturesAssignment_5_410463);
            ruleFeature2();
            _fsp--;

             after(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object2__FeaturesAssignment_5_4


    // $ANTLR start rule__Attribute2__TypeAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4658:1: rule__Attribute2__TypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute2__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4662:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4663:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4663:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4664:1: RULE_ID
            {
             before(grammarAccess.getAttribute2Access().getTypeIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute2__TypeAssignment_110494); 
             after(grammarAccess.getAttribute2Access().getTypeIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__TypeAssignment_1


    // $ANTLR start rule__Attribute2__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4673:1: rule__Attribute2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4677:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4678:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4678:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4679:1: RULE_ID
            {
             before(grammarAccess.getAttribute2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute2__NameAssignment_210525); 
             after(grammarAccess.getAttribute2Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__NameAssignment_2


    // $ANTLR start rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4688:1: rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4692:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4693:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4693:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4694:1: RULE_STRING
            {
             before(grammarAccess.getAttribute2Access().getShortDescriptionSTRINGTerminalRuleCall_3_0_1_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_110556); 
             after(grammarAccess.getAttribute2Access().getShortDescriptionSTRINGTerminalRuleCall_3_0_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1


    // $ANTLR start rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4703:1: rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4707:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4708:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4708:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4709:1: RULE_STRING
            {
             before(grammarAccess.getAttribute2Access().getLongDescriptionSTRINGTerminalRuleCall_3_0_1_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Attribute2__LongDescriptionAssignment_3_0_1_1_110587); 
             after(grammarAccess.getAttribute2Access().getLongDescriptionSTRINGTerminalRuleCall_3_0_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1


    // $ANTLR start rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4718:1: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 : ( ruleConstraintDefinition ) ;
    public final void rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4722:1: ( ( ruleConstraintDefinition ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4723:1: ( ruleConstraintDefinition )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4723:1: ( ruleConstraintDefinition )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4724:1: ruleConstraintDefinition
            {
             before(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_210618);
            ruleConstraintDefinition();
            _fsp--;

             after(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2


    // $ANTLR start rule__Attribute2__RequiredAssignment_3_0_1_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4733:1: rule__Attribute2__RequiredAssignment_3_0_1_3_0 : ( ( 'required' ) ) ;
    public final void rule__Attribute2__RequiredAssignment_3_0_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4737:1: ( ( ( 'required' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4738:1: ( ( 'required' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4738:1: ( ( 'required' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4739:1: ( 'required' )
            {
             before(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4740:1: ( 'required' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4741:1: 'required'
            {
             before(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__Attribute2__RequiredAssignment_3_0_1_3_010654); 
             after(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 

            }

             after(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__RequiredAssignment_3_0_1_3_0


    // $ANTLR start rule__Attribute2__TechnicalAssignment_3_0_1_4_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4756:1: rule__Attribute2__TechnicalAssignment_3_0_1_4_0 : ( ( 'technical' ) ) ;
    public final void rule__Attribute2__TechnicalAssignment_3_0_1_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4760:1: ( ( ( 'technical' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4761:1: ( ( 'technical' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4761:1: ( ( 'technical' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4762:1: ( 'technical' )
            {
             before(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4763:1: ( 'technical' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4764:1: 'technical'
            {
             before(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__Attribute2__TechnicalAssignment_3_0_1_4_010698); 
             after(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 

            }

             after(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute2__TechnicalAssignment_3_0_1_4_0


    // $ANTLR start rule__Reference2__TypeAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4779:1: rule__Reference2__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference2__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4783:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4784:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4784:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4785:1: ( RULE_ID )
            {
             before(grammarAccess.getReference2Access().getTypeObjectCrossReference_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4786:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4787:1: RULE_ID
            {
             before(grammarAccess.getReference2Access().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Reference2__TypeAssignment_110741); 
             after(grammarAccess.getReference2Access().getTypeObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReference2Access().getTypeObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__TypeAssignment_1


    // $ANTLR start rule__Reference2__ManyAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4798:1: rule__Reference2__ManyAssignment_2 : ( ( '*' ) ) ;
    public final void rule__Reference2__ManyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4802:1: ( ( ( '*' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4803:1: ( ( '*' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4803:1: ( ( '*' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4804:1: ( '*' )
            {
             before(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4805:1: ( '*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4806:1: '*'
            {
             before(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__Reference2__ManyAssignment_210781); 
             after(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 

            }

             after(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__ManyAssignment_2


    // $ANTLR start rule__Reference2__NameAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4821:1: rule__Reference2__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Reference2__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4825:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4826:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4826:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4827:1: RULE_ID
            {
             before(grammarAccess.getReference2Access().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Reference2__NameAssignment_310820); 
             after(grammarAccess.getReference2Access().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__NameAssignment_3


    // $ANTLR start rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4836:1: rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4840:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4841:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4841:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4842:1: RULE_STRING
            {
             before(grammarAccess.getReference2Access().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Reference2__ShortDescriptionAssignment_4_0_1_0_110851); 
             after(grammarAccess.getReference2Access().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1


    // $ANTLR start rule__Reference2__LongDescriptionAssignment_4_0_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4851:1: rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Reference2__LongDescriptionAssignment_4_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4855:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4856:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4856:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4857:1: RULE_STRING
            {
             before(grammarAccess.getReference2Access().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Reference2__LongDescriptionAssignment_4_0_1_1_110882); 
             after(grammarAccess.getReference2Access().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference2__LongDescriptionAssignment_4_0_1_1_1


    // $ANTLR start rule__ConstraintDefinition__TypeAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4866:1: rule__ConstraintDefinition__TypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__ConstraintDefinition__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4870:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4871:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4871:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4872:1: RULE_ID
            {
             before(grammarAccess.getConstraintDefinitionAccess().getTypeIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ConstraintDefinition__TypeAssignment_110913); 
             after(grammarAccess.getConstraintDefinitionAccess().getTypeIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConstraintDefinition__TypeAssignment_1


    // $ANTLR start rule__ConstraintDefinition__ParametersAssignment_3_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4881:1: rule__ConstraintDefinition__ParametersAssignment_3_0_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintDefinition__ParametersAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4885:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4886:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4886:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4887:1: RULE_STRING
            {
             before(grammarAccess.getConstraintDefinitionAccess().getParametersSTRINGTerminalRuleCall_3_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ConstraintDefinition__ParametersAssignment_3_0_110944); 
             after(grammarAccess.getConstraintDefinitionAccess().getParametersSTRINGTerminalRuleCall_3_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConstraintDefinition__ParametersAssignment_3_0_1


    // $ANTLR start rule__ConstraintDefinition__MessageAssignment_3_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4896:1: rule__ConstraintDefinition__MessageAssignment_3_1_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintDefinition__MessageAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4900:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4901:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4901:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:4902:1: RULE_STRING
            {
             before(grammarAccess.getConstraintDefinitionAccess().getMessageSTRINGTerminalRuleCall_3_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ConstraintDefinition__MessageAssignment_3_1_110975); 
             after(grammarAccess.getConstraintDefinitionAccess().getMessageSTRINGTerminalRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConstraintDefinition__MessageAssignment_3_1_1


    protected DFA35 dfa35 = new DFA35(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String DFA35_eotS =
        "\u0246\uffff";
    static final String DFA35_eofS =
        "\u0246\uffff";
    static final String DFA35_minS =
        "\1\21\4\uffff\2\4\1\uffff\2\4\1\13\1\4\1\13\1\21\1\0\1\21\1\0\2"+
        "\5\1\4\2\13\1\0\1\uffff\2\5\1\0\2\13\1\20\2\21\1\uffff\2\13\2\21"+
        "\1\35\2\5\1\4\2\13\2\0\2\21\2\0\2\5\2\13\1\20\2\21\2\5\2\0\1\5\1"+
        "\21\1\13\2\21\1\35\2\5\1\4\2\13\2\0\2\13\2\5\2\21\2\0\2\5\2\13\1"+
        "\20\4\21\1\5\1\21\1\13\1\4\1\0\1\5\1\21\1\13\2\21\1\35\2\5\1\4\2"+
        "\13\4\0\1\21\1\20\2\5\2\21\2\0\2\5\2\13\1\20\2\21\1\35\1\5\1\21"+
        "\1\13\1\4\1\0\1\5\1\21\1\13\2\21\1\35\2\5\1\4\2\13\2\0\2\5\1\21"+
        "\1\20\2\5\2\21\2\0\2\5\2\13\1\20\2\21\1\5\1\21\1\13\1\35\1\5\1\21"+
        "\1\13\1\4\1\0\1\5\1\21\1\13\2\21\1\35\2\0\2\5\2\21\2\5\1\21\1\20"+
        "\2\5\2\21\2\0\3\5\1\21\1\13\1\4\2\5\2\13\1\0\1\5\1\21\1\13\1\35"+
        "\1\5\1\21\1\13\1\4\1\0\1\5\1\21\1\13\1\21\1\20\2\13\2\21\2\5\2\21"+
        "\2\5\1\21\1\20\2\5\2\21\1\35\2\21\2\5\1\4\2\13\2\0\1\5\1\21\1\13"+
        "\1\4\1\0\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\1\0\2\5\2\0\2\13\1"+
        "\20\3\21\1\20\2\5\2\21\2\5\1\21\1\20\1\5\1\21\1\13\2\21\1\35\2\5"+
        "\1\4\2\13\2\0\1\35\1\5\1\21\1\13\1\4\1\0\1\5\1\21\1\13\1\35\2\5"+
        "\2\21\2\0\2\5\2\13\1\20\2\21\2\5\1\21\1\20\2\5\2\21\3\5\1\21\1\13"+
        "\1\4\2\5\2\13\1\0\1\5\1\21\1\13\2\21\1\35\2\0\1\5\1\21\1\13\1\35"+
        "\1\5\1\21\1\13\1\4\1\0\1\5\1\21\1\13\1\21\1\20\2\13\2\21\2\5\2\21"+
        "\2\0\4\5\2\21\2\5\1\21\1\20\2\5\2\21\1\35\2\21\2\5\1\4\2\13\2\0"+
        "\1\5\1\21\1\13\1\0\1\5\1\21\1\13\1\5\1\21\1\13\1\4\1\0\1\5\1\21"+
        "\1\13\1\35\1\5\1\21\1\13\1\0\2\5\2\0\2\13\1\20\3\21\2\5\3\21\1\20"+
        "\2\5\2\21\2\5\1\21\1\5\1\21\1\13\2\21\1\35\2\0\1\5\1\21\1\13\1\0"+
        "\1\35\1\5\1\21\1\13\1\4\1\0\1\5\1\21\1\13\2\5\2\21\2\0\2\5\1\21"+
        "\2\5\1\21\1\20\2\5\2\21\1\5\1\21\1\13\2\5\1\4\2\13\1\0\1\5\1\21"+
        "\1\13\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\0\1\21\2\13\1\20\2\21\2"+
        "\5\2\21\2\5\2\21\2\5\3\21\1\35\2\0\1\5\1\21\1\13\1\0\1\5\1\21\1"+
        "\13\1\4\1\0\1\5\1\21\1\13\2\0\2\5\2\21\1\20\2\5\2\21\1\5\1\21\1"+
        "\13\1\35\1\5\1\21\1\13\1\0\2\5\2\21\2\5\1\21\1\5\1\21\1\13\1\4\1"+
        "\0\1\5\1\21\1\13\1\21\1\20\2\5\2\21\1\35\1\5\1\21\1\13\1\0\2\5\1"+
        "\21\1\5\1\21\1\13\2\5\2\21\1\5\1\21\1\13\1\0\1\21";
    static final String DFA35_maxS =
        "\1\41\4\uffff\2\4\1\uffff\1\4\1\42\1\20\1\4\1\20\1\44\1\0\1\24\1"+
        "\0\2\5\1\4\2\13\1\0\1\uffff\2\5\1\0\2\13\1\20\2\44\1\uffff\2\13"+
        "\2\44\1\36\2\5\1\4\2\13\2\0\2\24\2\0\1\13\1\5\2\13\1\20\2\44\2\5"+
        "\2\0\1\13\1\36\1\13\2\44\1\36\2\5\1\4\2\13\2\0\3\13\1\5\1\44\1\36"+
        "\2\0\1\13\1\5\2\13\1\20\2\44\2\21\1\13\1\21\1\13\1\4\1\0\1\13\1"+
        "\36\1\13\2\44\1\36\2\5\1\4\2\13\4\0\1\21\1\20\1\13\1\5\1\44\1\36"+
        "\2\0\1\13\1\5\2\13\1\20\2\44\1\36\1\13\1\21\1\13\1\4\1\0\1\13\1"+
        "\36\1\13\2\44\1\36\2\5\1\4\2\13\2\0\1\13\1\5\1\21\1\20\1\13\1\5"+
        "\1\44\1\36\2\0\1\13\1\5\2\13\1\20\2\21\1\13\1\36\1\13\1\36\1\13"+
        "\1\21\1\13\1\4\1\0\1\13\1\36\1\13\2\21\1\36\2\0\1\13\1\5\1\44\1"+
        "\36\1\13\1\5\1\21\1\20\1\13\1\5\1\44\1\36\2\0\1\13\1\5\1\13\1\21"+
        "\1\13\1\4\2\5\2\13\1\0\1\13\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1"+
        "\0\1\13\1\36\1\13\1\21\1\20\2\13\2\44\1\13\1\5\1\44\1\36\1\13\1"+
        "\5\1\21\1\20\1\13\1\5\1\34\2\36\2\44\2\5\1\4\2\13\2\0\1\13\1\21"+
        "\1\13\1\4\1\0\1\13\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1\0\1\13\1"+
        "\5\2\0\2\13\1\20\2\44\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1\21"+
        "\1\20\1\13\1\36\1\13\2\44\1\36\2\5\1\4\2\13\2\0\1\36\1\13\1\21\1"+
        "\13\1\4\1\0\1\13\1\36\1\13\1\36\1\13\1\5\1\44\1\36\2\0\1\13\1\5"+
        "\2\13\1\20\2\44\1\13\1\5\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1"+
        "\13\1\21\1\13\1\4\2\5\2\13\1\0\1\13\1\36\1\13\2\44\1\36\2\0\1\13"+
        "\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1\0\1\13\1\36\1\13\1\21\1\20"+
        "\2\13\2\44\1\13\1\5\1\44\1\36\2\0\1\13\1\5\1\13\1\5\1\44\1\36\1"+
        "\13\1\5\1\21\1\20\1\13\1\5\1\34\2\36\2\44\2\5\1\4\2\13\2\0\1\13"+
        "\1\21\1\13\1\0\1\13\1\36\2\13\1\21\1\13\1\4\1\0\1\13\1\36\1\13\1"+
        "\36\1\13\1\21\1\13\1\0\1\13\1\5\2\0\2\13\1\20\2\44\1\21\1\13\1\5"+
        "\1\44\1\36\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\13\1\36"+
        "\1\13\2\44\1\36\2\0\1\13\1\21\1\13\1\0\1\36\1\13\1\21\1\13\1\4\1"+
        "\0\1\13\1\36\2\13\1\5\1\44\1\36\2\0\1\13\1\5\1\21\1\13\1\5\1\21"+
        "\1\20\1\13\1\5\1\44\1\36\1\13\1\21\1\13\2\5\1\4\2\13\1\0\1\13\1"+
        "\36\2\13\1\36\1\13\1\36\1\13\1\21\1\13\1\0\1\21\2\13\1\20\2\44\1"+
        "\13\1\5\1\44\1\36\1\13\1\5\1\44\1\36\1\13\1\5\1\21\2\44\1\36\2\0"+
        "\1\13\1\21\1\13\1\0\1\13\1\21\1\13\1\4\1\0\1\13\1\36\1\13\2\0\1"+
        "\13\1\5\2\21\1\20\1\13\1\5\1\44\1\36\1\13\1\36\1\13\1\36\1\13\1"+
        "\21\1\13\1\0\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\13\1\21\1\13\1\4"+
        "\1\0\1\13\1\36\1\13\1\21\1\20\1\13\1\5\1\44\2\36\1\13\1\21\1\13"+
        "\1\0\1\13\1\5\1\21\1\13\1\36\2\13\1\5\1\44\1\36\1\13\1\21\1\13\1"+
        "\0\1\21";
    static final String DFA35_acceptS =
        "\1\uffff\4\2\2\uffff\1\2\17\uffff\1\1\10\uffff\1\1\u0225\uffff";
    static final String DFA35_specialS =
        "\1\113\15\uffff\1\0\1\uffff\1\6\5\uffff\1\62\3\uffff\1\3\20\uffff"+
        "\1\61\1\60\2\uffff\1\57\1\56\11\uffff\1\4\1\5\13\uffff\1\63\1\64"+
        "\6\uffff\1\65\1\66\15\uffff\1\67\13\uffff\1\55\1\54\1\2\1\1\6\uffff"+
        "\1\53\1\52\14\uffff\1\51\13\uffff\1\50\1\47\10\uffff\1\46\1\45\17"+
        "\uffff\1\44\6\uffff\1\43\1\42\14\uffff\1\41\1\40\12\uffff\1\70\10"+
        "\uffff\1\71\35\uffff\1\72\1\73\4\uffff\1\74\10\uffff\1\75\2\uffff"+
        "\1\76\1\77\32\uffff\1\100\1\101\5\uffff\1\102\10\uffff\1\103\1\104"+
        "\31\uffff\1\105\6\uffff\1\106\1\107\10\uffff\1\110\15\uffff\1\111"+
        "\1\112\26\uffff\1\37\1\36\3\uffff\1\35\7\uffff\1\34\7\uffff\1\33"+
        "\2\uffff\1\32\1\31\31\uffff\1\30\1\27\3\uffff\1\26\5\uffff\1\25"+
        "\7\uffff\1\24\1\23\23\uffff\1\22\12\uffff\1\21\24\uffff\1\20\1\17"+
        "\3\uffff\1\16\4\uffff\1\15\3\uffff\1\14\1\13\20\uffff\1\12\13\uffff"+
        "\1\11\15\uffff\1\10\15\uffff\1\7\1\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\7\1\uffff\1\1\1\2\1\3\4\uffff\1\5\1\6\5\uffff\1\4",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\11",
            "",
            "\1\12",
            "\1\14\35\uffff\1\13",
            "\1\16\4\uffff\1\15",
            "\1\14",
            "\1\20\4\uffff\1\17",
            "\1\26\1\uffff\1\21\1\22\7\uffff\1\23\6\uffff\1\24\1\25",
            "\1\uffff",
            "\1\32\1\uffff\1\30\1\31",
            "\1\uffff",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\uffff",
            "",
            "\1\41",
            "\1\42",
            "\1\uffff",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\53\1\uffff\1\46\1\47\7\uffff\1\50\6\uffff\1\51\1\52",
            "\1\54\1\uffff\1\46\1\47\7\uffff\1\50\6\uffff\1\51\1\52",
            "",
            "\1\55",
            "\1\56",
            "\1\57\1\uffff\1\46\1\47\7\uffff\1\50\6\uffff\1\51\1\52",
            "\1\60\1\uffff\1\46\1\47\7\uffff\1\50\6\uffff\1\51\1\52",
            "\1\61\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\uffff",
            "\1\uffff",
            "\1\72\1\uffff\1\70\1\71",
            "\1\73\1\uffff\1\70\1\71",
            "\1\uffff",
            "\1\uffff",
            "\1\74\5\uffff\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\107\1\uffff\1\102\1\103\7\uffff\1\104\6\uffff\1\105\1\106",
            "\1\110\1\uffff\1\102\1\103\7\uffff\1\104\6\uffff\1\105\1\106",
            "\1\111",
            "\1\112",
            "\1\uffff",
            "\1\uffff",
            "\1\74\5\uffff\1\75",
            "\1\115\13\uffff\1\113\1\114",
            "\1\116",
            "\1\117\1\uffff\1\102\1\103\7\uffff\1\104\6\uffff\1\105\1\106",
            "\1\120\1\uffff\1\102\1\103\7\uffff\1\104\6\uffff\1\105\1\106",
            "\1\121\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\uffff",
            "\1\uffff",
            "\1\130",
            "\1\131",
            "\1\132\5\uffff\1\133",
            "\1\134",
            "\1\136\1\uffff\1\46\1\47\7\uffff\1\135\6\uffff\1\51\1\52",
            "\1\115\13\uffff\1\113\1\114",
            "\1\uffff",
            "\1\uffff",
            "\1\137\5\uffff\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\152\1\uffff\1\145\1\146\7\uffff\1\147\6\uffff\1\150\1\151",
            "\1\153\1\uffff\1\145\1\146\7\uffff\1\147\6\uffff\1\150\1\151",
            "\1\154",
            "\1\155",
            "\1\132\5\uffff\1\133",
            "\1\115",
            "\1\156",
            "\1\157",
            "\1\uffff",
            "\1\137\5\uffff\1\140",
            "\1\162\13\uffff\1\160\1\161",
            "\1\163",
            "\1\164\1\uffff\1\145\1\146\7\uffff\1\147\6\uffff\1\150\1\151",
            "\1\165\1\uffff\1\145\1\146\7\uffff\1\147\6\uffff\1\150\1\151",
            "\1\166\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\115",
            "\1\175",
            "\1\176\5\uffff\1\177",
            "\1\u0080",
            "\1\u0082\1\uffff\1\102\1\103\7\uffff\1\u0081\6\uffff\1\105\1"+
            "\106",
            "\1\162\13\uffff\1\160\1\161",
            "\1\uffff",
            "\1\uffff",
            "\1\u0083\5\uffff\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u008e\1\uffff\1\u0089\1\u008a\7\uffff\1\u008b\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u008f\1\uffff\1\u0089\1\u008a\7\uffff\1\u008b\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u0090\1\u0091",
            "\1\176\5\uffff\1\177",
            "\1\162",
            "\1\u0092",
            "\1\u0093",
            "\1\uffff",
            "\1\u0083\5\uffff\1\u0084",
            "\1\u0096\13\uffff\1\u0094\1\u0095",
            "\1\u0097",
            "\1\u0098\1\uffff\1\u0089\1\u008a\7\uffff\1\u008b\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u0099\1\uffff\1\u0089\1\u008a\7\uffff\1\u008b\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u009a\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\uffff",
            "\1\uffff",
            "\1\u00a1\5\uffff\1\u00a2",
            "\1\u00a3",
            "\1\162",
            "\1\u00a4",
            "\1\u00a5\5\uffff\1\u00a6",
            "\1\u00a7",
            "\1\u00a9\1\uffff\1\145\1\146\7\uffff\1\u00a8\6\uffff\1\150\1"+
            "\151",
            "\1\u0096\13\uffff\1\u0094\1\u0095",
            "\1\uffff",
            "\1\uffff",
            "\1\u00aa\5\uffff\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00a1\5\uffff\1\u00a2",
            "\1\u00b4\13\uffff\1\u00b2\1\u00b3",
            "\1\u00b5",
            "\1\u00b6\1\u00b7",
            "\1\u00a5\5\uffff\1\u00a6",
            "\1\u0096",
            "\1\u00b8",
            "\1\u00b9",
            "\1\uffff",
            "\1\u00aa\5\uffff\1\u00ab",
            "\1\u00bc\13\uffff\1\u00ba\1\u00bb",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0\1\u00c1",
            "\1\uffff",
            "\1\uffff",
            "\1\u00c2\5\uffff\1\u00c3",
            "\1\u00c4",
            "\1\u00ca\1\uffff\1\u00c6\1\u00c7\7\uffff\1\u00c5\6\uffff\1\u00c8"+
            "\1\u00c9",
            "\1\u00b4\13\uffff\1\u00b2\1\u00b3",
            "\1\u00cb\5\uffff\1\u00cc",
            "\1\u00cd",
            "\1\u0096",
            "\1\u00ce",
            "\1\u00cf\5\uffff\1\u00d0",
            "\1\u00d1",
            "\1\u00d3\1\uffff\1\u0089\1\u008a\7\uffff\1\u00d2\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u00bc\13\uffff\1\u00ba\1\u00bb",
            "\1\uffff",
            "\1\uffff",
            "\1\u00d4\5\uffff\1\u00d5",
            "\1\u00d6",
            "\1\u00c2\5\uffff\1\u00c3",
            "\1\u00b4",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\uffff",
            "\1\u00cb\5\uffff\1\u00cc",
            "\1\u00df\13\uffff\1\u00dd\1\u00de",
            "\1\u00e0",
            "\1\u00e1\1\u00e2",
            "\1\u00cf\5\uffff\1\u00d0",
            "\1\u00bc",
            "\1\u00e3",
            "\1\u00e4",
            "\1\uffff",
            "\1\u00d4\5\uffff\1\u00d5",
            "\1\u00e7\13\uffff\1\u00e5\1\u00e6",
            "\1\u00e8",
            "\1\u00b4",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00f1\1\uffff\1\u00ec\1\u00ed\7\uffff\1\u00ee\6\uffff\1\u00ef"+
            "\1\u00f0",
            "\1\u00f2\1\uffff\1\u00ec\1\u00ed\7\uffff\1\u00ee\6\uffff\1\u00ef"+
            "\1\u00f0",
            "\1\u00f3\5\uffff\1\u00f4",
            "\1\u00f5",
            "\1\u00f7\1\uffff\1\u00ec\1\u00ed\7\uffff\1\u00f6\6\uffff\1\u00ef"+
            "\1\u00f0",
            "\1\u00df\13\uffff\1\u00dd\1\u00de",
            "\1\u00f8\5\uffff\1\u00f9",
            "\1\u00fa",
            "\1\u00bc",
            "\1\u00fb",
            "\1\u00fc\5\uffff\1\u00fd",
            "\1\u00fe",
            "\1\u0100\12\uffff\1\u00ff",
            "\1\u00e7\13\uffff\1\u00e5\1\u00e6",
            "\1\u0101\1\u0102",
            "\1\u0103\1\uffff\1\u00ec\1\u00ed\7\uffff\1\u00ee\6\uffff\1\u00ef"+
            "\1\u00f0",
            "\1\u0104\1\uffff\1\u00ec\1\u00ed\7\uffff\1\u00ee\6\uffff\1\u00ef"+
            "\1\u00f0",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\uffff",
            "\1\uffff",
            "\1\u00f3\5\uffff\1\u00f4",
            "\1\u00df",
            "\1\u010a",
            "\1\u010b",
            "\1\uffff",
            "\1\u00f8\5\uffff\1\u00f9",
            "\1\u010e\13\uffff\1\u010c\1\u010d",
            "\1\u010f",
            "\1\u0110\1\u0111",
            "\1\u00fc\5\uffff\1\u00fd",
            "\1\u00e7",
            "\1\u0112",
            "\1\u0113",
            "\1\uffff",
            "\1\u0114\5\uffff\1\u0115",
            "\1\u0116",
            "\1\uffff",
            "\1\uffff",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011f\1\uffff\1\u011a\1\u011b\7\uffff\1\u011c\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u0120\1\uffff\1\u011a\1\u011b\7\uffff\1\u011c\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u00df",
            "\1\u0121",
            "\1\u0122\5\uffff\1\u0123",
            "\1\u0124",
            "\1\u0126\1\uffff\1\u011a\1\u011b\7\uffff\1\u0125\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u010e\13\uffff\1\u010c\1\u010d",
            "\1\u0127\5\uffff\1\u0128",
            "\1\u0129",
            "\1\u00e7",
            "\1\u012a",
            "\1\u0114\5\uffff\1\u0115",
            "\1\u012d\13\uffff\1\u012b\1\u012c",
            "\1\u012e",
            "\1\u012f\1\uffff\1\u011a\1\u011b\7\uffff\1\u011c\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u0130\1\uffff\1\u011a\1\u011b\7\uffff\1\u011c\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u0131\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\uffff",
            "\1\uffff",
            "\1\u0138\1\u0139",
            "\1\u0122\5\uffff\1\u0123",
            "\1\u010e",
            "\1\u013a",
            "\1\u013b",
            "\1\uffff",
            "\1\u0127\5\uffff\1\u0128",
            "\1\u013e\13\uffff\1\u013c\1\u013d",
            "\1\u013f",
            "\1\u0140\1\u0141",
            "\1\u0142\5\uffff\1\u0143",
            "\1\u0144",
            "\1\u014a\1\uffff\1\u0146\1\u0147\7\uffff\1\u0145\6\uffff\1\u0148"+
            "\1\u0149",
            "\1\u012d\13\uffff\1\u012b\1\u012c",
            "\1\uffff",
            "\1\uffff",
            "\1\u014b\5\uffff\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151\1\uffff\1\u0089\1\u008a\7\uffff\1\u008b\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u0152\1\uffff\1\u0089\1\u008a\7\uffff\1\u008b\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u0153\5\uffff\1\u0154",
            "\1\u0155",
            "\1\u010e",
            "\1\u0156",
            "\1\u0157\5\uffff\1\u0158",
            "\1\u0159",
            "\1\u015b\1\uffff\1\u0089\1\u008a\7\uffff\1\u015a\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u013e\13\uffff\1\u013c\1\u013d",
            "\1\u015c\5\uffff\1\u015d",
            "\1\u015e",
            "\1\u0142\5\uffff\1\u0143",
            "\1\u012d",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\uffff",
            "\1\u014b\5\uffff\1\u014c",
            "\1\u0167\13\uffff\1\u0165\1\u0166",
            "\1\u0168",
            "\1\u0169\1\uffff\1\u0089\1\u008a\7\uffff\1\u008b\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u016a\1\uffff\1\u0089\1\u008a\7\uffff\1\u008b\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u016b\1\u016c",
            "\1\uffff",
            "\1\uffff",
            "\1\u0153\5\uffff\1\u0154",
            "\1\u016f\13\uffff\1\u016d\1\u016e",
            "\1\u0170",
            "\1\u0171\1\u0172",
            "\1\u0157\5\uffff\1\u0158",
            "\1\u013e",
            "\1\u0173",
            "\1\u0174",
            "\1\uffff",
            "\1\u015c\5\uffff\1\u015d",
            "\1\u0177\13\uffff\1\u0175\1\u0176",
            "\1\u0178",
            "\1\u012d",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "\1\u0181\1\uffff\1\u017c\1\u017d\7\uffff\1\u017e\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u0182\1\uffff\1\u017c\1\u017d\7\uffff\1\u017e\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u0183\5\uffff\1\u0184",
            "\1\u0185",
            "\1\u0186\1\uffff\1\u011a\1\u011b\7\uffff\1\u0125\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u0167\13\uffff\1\u0165\1\u0166",
            "\1\uffff",
            "\1\uffff",
            "\1\u0187\5\uffff\1\u0188",
            "\1\u0189",
            "\1\u018a\5\uffff\1\u018b",
            "\1\u018c",
            "\1\u018e\1\uffff\1\u017c\1\u017d\7\uffff\1\u018d\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u016f\13\uffff\1\u016d\1\u016e",
            "\1\u018f\5\uffff\1\u0190",
            "\1\u0191",
            "\1\u013e",
            "\1\u0192",
            "\1\u0193\5\uffff\1\u0194",
            "\1\u0195",
            "\1\u0196\12\uffff\1\u00ff",
            "\1\u0177\13\uffff\1\u0175\1\u0176",
            "\1\u0197\1\u0198",
            "\1\u0199\1\uffff\1\u017c\1\u017d\7\uffff\1\u017e\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u019a\1\uffff\1\u017c\1\u017d\7\uffff\1\u017e\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\1\uffff",
            "\1\uffff",
            "\1\u0183\5\uffff\1\u0184",
            "\1\u0167",
            "\1\u01a0",
            "\1\uffff",
            "\1\u0187\5\uffff\1\u0188",
            "\1\u01a3\13\uffff\1\u01a1\1\u01a2",
            "\1\u01a4",
            "\1\u018a\5\uffff\1\u018b",
            "\1\u016f",
            "\1\u01a5",
            "\1\u01a6",
            "\1\uffff",
            "\1\u018f\5\uffff\1\u0190",
            "\1\u01a9\13\uffff\1\u01a7\1\u01a8",
            "\1\u01aa",
            "\1\u01ab\1\u01ac",
            "\1\u0193\5\uffff\1\u0194",
            "\1\u0177",
            "\1\u01ad",
            "\1\uffff",
            "\1\u01ae\5\uffff\1\u01af",
            "\1\u01b0",
            "\1\uffff",
            "\1\uffff",
            "\1\u01b1",
            "\1\u01b2",
            "\1\u01b3",
            "\1\u01b4\1\uffff\1\u011a\1\u011b\7\uffff\1\u011c\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u01b5\1\uffff\1\u011a\1\u011b\7\uffff\1\u011c\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u0167",
            "\1\u01b6\5\uffff\1\u01b7",
            "\1\u01b8",
            "\1\u01b9\1\uffff\1\u0089\1\u008a\7\uffff\1\u015a\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u01a3\13\uffff\1\u01a1\1\u01a2",
            "\1\u016f",
            "\1\u01ba",
            "\1\u01bb\5\uffff\1\u01bc",
            "\1\u01bd",
            "\1\u01bf\1\uffff\1\u011a\1\u011b\7\uffff\1\u01be\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u01a9\13\uffff\1\u01a7\1\u01a8",
            "\1\u01c0\5\uffff\1\u01c1",
            "\1\u01c2",
            "\1\u0177",
            "\1\u01ae\5\uffff\1\u01af",
            "\1\u01c5\13\uffff\1\u01c3\1\u01c4",
            "\1\u01c6",
            "\1\u01c7\1\uffff\1\u011a\1\u011b\7\uffff\1\u011c\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u01c8\1\uffff\1\u011a\1\u011b\7\uffff\1\u011c\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u01c9\1\u01ca",
            "\1\uffff",
            "\1\uffff",
            "\1\u01b6\5\uffff\1\u01b7",
            "\1\u01a3",
            "\1\u01cb",
            "\1\uffff",
            "\1\u01cc\1\u01cd",
            "\1\u01bb\5\uffff\1\u01bc",
            "\1\u01a9",
            "\1\u01ce",
            "\1\u01cf",
            "\1\uffff",
            "\1\u01c0\5\uffff\1\u01c1",
            "\1\u01d2\13\uffff\1\u01d0\1\u01d1",
            "\1\u01d3",
            "\1\u01d4\5\uffff\1\u01d5",
            "\1\u01d6",
            "\1\u01dc\1\uffff\1\u01d7\1\u01d8\7\uffff\1\u01d9\6\uffff\1\u01da"+
            "\1\u01db",
            "\1\u01c5\13\uffff\1\u01c3\1\u01c4",
            "\1\uffff",
            "\1\uffff",
            "\1\u01dd\5\uffff\1\u01de",
            "\1\u01df",
            "\1\u01a3",
            "\1\u01e0\5\uffff\1\u01e1",
            "\1\u01e2",
            "\1\u01a9",
            "\1\u01e3",
            "\1\u01e4\5\uffff\1\u01e5",
            "\1\u01e6",
            "\1\u01e7\1\uffff\1\u0089\1\u008a\7\uffff\1\u015a\6\uffff\1\u008c"+
            "\1\u008d",
            "\1\u01d2\13\uffff\1\u01d0\1\u01d1",
            "\1\u01d4\5\uffff\1\u01d5",
            "\1\u01c5",
            "\1\u01e8",
            "\1\u01e9",
            "\1\u01ea",
            "\1\u01eb",
            "\1\u01ec",
            "\1\u01ed",
            "\1\uffff",
            "\1\u01dd\5\uffff\1\u01de",
            "\1\u01f0\13\uffff\1\u01ee\1\u01ef",
            "\1\u01f1",
            "\1\u01e0\5\uffff\1\u01e1",
            "\1\u01f4\13\uffff\1\u01f2\1\u01f3",
            "\1\u01f5",
            "\1\u01f6\1\u01f7",
            "\1\u01e4\5\uffff\1\u01e5",
            "\1\u01d2",
            "\1\u01f8",
            "\1\uffff",
            "\1\u01c5",
            "\1\u01f9",
            "\1\u01fa",
            "\1\u01fb",
            "\1\u01fc\1\uffff\1\u017c\1\u017d\7\uffff\1\u017e\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u01fd\1\uffff\1\u017c\1\u017d\7\uffff\1\u017e\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u01fe\5\uffff\1\u01ff",
            "\1\u0200",
            "\1\u0201\1\uffff\1\u011a\1\u011b\7\uffff\1\u01be\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u01f0\13\uffff\1\u01ee\1\u01ef",
            "\1\u0202\5\uffff\1\u0203",
            "\1\u0204",
            "\1\u0206\1\uffff\1\u017c\1\u017d\7\uffff\1\u0205\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u01f4\13\uffff\1\u01f2\1\u01f3",
            "\1\u0207\5\uffff\1\u0208",
            "\1\u0209",
            "\1\u01d2",
            "\1\u020a\1\uffff\1\u017c\1\u017d\7\uffff\1\u017e\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u020b\1\uffff\1\u017c\1\u017d\7\uffff\1\u017e\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u020c\1\u020d",
            "\1\uffff",
            "\1\uffff",
            "\1\u01fe\5\uffff\1\u01ff",
            "\1\u01f0",
            "\1\u020e",
            "\1\uffff",
            "\1\u0202\5\uffff\1\u0203",
            "\1\u01f4",
            "\1\u020f",
            "\1\u0210",
            "\1\uffff",
            "\1\u0207\5\uffff\1\u0208",
            "\1\u0213\13\uffff\1\u0211\1\u0212",
            "\1\u0214",
            "\1\uffff",
            "\1\uffff",
            "\1\u0215\5\uffff\1\u0216",
            "\1\u0217",
            "\1\u01f0",
            "\1\u01f4",
            "\1\u0218",
            "\1\u0219\5\uffff\1\u021a",
            "\1\u021b",
            "\1\u021c\1\uffff\1\u011a\1\u011b\7\uffff\1\u01be\6\uffff\1\u011d"+
            "\1\u011e",
            "\1\u0213\13\uffff\1\u0211\1\u0212",
            "\1\u0215\5\uffff\1\u0216",
            "\1\u021f\13\uffff\1\u021d\1\u021e",
            "\1\u0220",
            "\1\u0221\1\u0222",
            "\1\u0219\5\uffff\1\u021a",
            "\1\u0213",
            "\1\u0223",
            "\1\uffff",
            "\1\u0224\5\uffff\1\u0225",
            "\1\u0226",
            "\1\u0228\1\uffff\1\u01d7\1\u01d8\7\uffff\1\u0227\6\uffff\1\u01da"+
            "\1\u01db",
            "\1\u021f\13\uffff\1\u021d\1\u021e",
            "\1\u0229\5\uffff\1\u022a",
            "\1\u022b",
            "\1\u0213",
            "\1\u0224\5\uffff\1\u0225",
            "\1\u021f",
            "\1\u022c",
            "\1\u022d",
            "\1\uffff",
            "\1\u0229\5\uffff\1\u022a",
            "\1\u0230\13\uffff\1\u022e\1\u022f",
            "\1\u0231",
            "\1\u021f",
            "\1\u0232",
            "\1\u0233\5\uffff\1\u0234",
            "\1\u0235",
            "\1\u0236\1\uffff\1\u017c\1\u017d\7\uffff\1\u0205\6\uffff\1\u017f"+
            "\1\u0180",
            "\1\u0230\13\uffff\1\u022e\1\u022f",
            "\1\u0237\1\u0238",
            "\1\u0233\5\uffff\1\u0234",
            "\1\u0230",
            "\1\u0239",
            "\1\uffff",
            "\1\u023a\5\uffff\1\u023b",
            "\1\u023c",
            "\1\u0230",
            "\1\u023a\5\uffff\1\u023b",
            "\1\u023f\13\uffff\1\u023d\1\u023e",
            "\1\u0240",
            "\1\u0241\5\uffff\1\u0242",
            "\1\u0243",
            "\1\u0244\1\uffff\1\u01d7\1\u01d8\7\uffff\1\u0227\6\uffff\1\u01da"+
            "\1\u01db",
            "\1\u023f\13\uffff\1\u023d\1\u023e",
            "\1\u0241\5\uffff\1\u0242",
            "\1\u023f",
            "\1\u0245",
            "\1\uffff",
            "\1\u023f"
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "()* loopback of 3601:7: ( rule__Object2__FeaturesAssignment_5_4 )*";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_14 = input.LA(1);

                         
                        int index35_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 23;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_14);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_109 = input.LA(1);

                         
                        int index35_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_109);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_108 = input.LA(1);

                         
                        int index35_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_108);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA35_26 = input.LA(1);

                         
                        int index35_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_26);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA35_58 = input.LA(1);

                         
                        int index35_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_58);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA35_59 = input.LA(1);

                         
                        int index35_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_59);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA35_16 = input.LA(1);

                         
                        int index35_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 23;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_16);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA35_580 = input.LA(1);

                         
                        int index35_580 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_580);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA35_566 = input.LA(1);

                         
                        int index35_566 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_566);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA35_552 = input.LA(1);

                         
                        int index35_552 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_552);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA35_540 = input.LA(1);

                         
                        int index35_540 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_540);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA35_523 = input.LA(1);

                         
                        int index35_523 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_523);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA35_522 = input.LA(1);

                         
                        int index35_522 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_522);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA35_518 = input.LA(1);

                         
                        int index35_518 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_518);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA35_513 = input.LA(1);

                         
                        int index35_513 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_513);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA35_509 = input.LA(1);

                         
                        int index35_509 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_509);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA35_508 = input.LA(1);

                         
                        int index35_508 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_508);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA35_487 = input.LA(1);

                         
                        int index35_487 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_487);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA35_476 = input.LA(1);

                         
                        int index35_476 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_476);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA35_456 = input.LA(1);

                         
                        int index35_456 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_456);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA35_455 = input.LA(1);

                         
                        int index35_455 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_455);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA35_447 = input.LA(1);

                         
                        int index35_447 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_447);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA35_441 = input.LA(1);

                         
                        int index35_441 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_441);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA35_437 = input.LA(1);

                         
                        int index35_437 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_437);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA35_436 = input.LA(1);

                         
                        int index35_436 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_436);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA35_410 = input.LA(1);

                         
                        int index35_410 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_410);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA35_409 = input.LA(1);

                         
                        int index35_409 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_409);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA35_406 = input.LA(1);

                         
                        int index35_406 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_406);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA35_398 = input.LA(1);

                         
                        int index35_398 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_398);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA35_390 = input.LA(1);

                         
                        int index35_390 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_390);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA35_386 = input.LA(1);

                         
                        int index35_386 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_386);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA35_385 = input.LA(1);

                         
                        int index35_385 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_385);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA35_191 = input.LA(1);

                         
                        int index35_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_191);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA35_190 = input.LA(1);

                         
                        int index35_190 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_190);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA35_177 = input.LA(1);

                         
                        int index35_177 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_177);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA35_176 = input.LA(1);

                         
                        int index35_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_176);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA35_169 = input.LA(1);

                         
                        int index35_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_169);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA35_153 = input.LA(1);

                         
                        int index35_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_153);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA35_152 = input.LA(1);

                         
                        int index35_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_152);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA35_143 = input.LA(1);

                         
                        int index35_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_143);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA35_142 = input.LA(1);

                         
                        int index35_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_142);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA35_130 = input.LA(1);

                         
                        int index35_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_130);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA35_117 = input.LA(1);

                         
                        int index35_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_117);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA35_116 = input.LA(1);

                         
                        int index35_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_116);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA35_107 = input.LA(1);

                         
                        int index35_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_107);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA35_106 = input.LA(1);

                         
                        int index35_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_106);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA35_48 = input.LA(1);

                         
                        int index35_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_48);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA35_47 = input.LA(1);

                         
                        int index35_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_47);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA35_44 = input.LA(1);

                         
                        int index35_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_44);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA35_43 = input.LA(1);

                         
                        int index35_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_43);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA35_22 = input.LA(1);

                         
                        int index35_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_22);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA35_71 = input.LA(1);

                         
                        int index35_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_71);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA35_72 = input.LA(1);

                         
                        int index35_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_72);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA35_79 = input.LA(1);

                         
                        int index35_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_79);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA35_80 = input.LA(1);

                         
                        int index35_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_80);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA35_94 = input.LA(1);

                         
                        int index35_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_94);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA35_202 = input.LA(1);

                         
                        int index35_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_202);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA35_211 = input.LA(1);

                         
                        int index35_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_211);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA35_241 = input.LA(1);

                         
                        int index35_241 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_241);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA35_242 = input.LA(1);

                         
                        int index35_242 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_242);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA35_247 = input.LA(1);

                         
                        int index35_247 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_247);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA35_256 = input.LA(1);

                         
                        int index35_256 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_256);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA35_259 = input.LA(1);

                         
                        int index35_259 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_259);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA35_260 = input.LA(1);

                         
                        int index35_260 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_260);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA35_287 = input.LA(1);

                         
                        int index35_287 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_287);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA35_288 = input.LA(1);

                         
                        int index35_288 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_288);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA35_294 = input.LA(1);

                         
                        int index35_294 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_294);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA35_303 = input.LA(1);

                         
                        int index35_303 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_303);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA35_304 = input.LA(1);

                         
                        int index35_304 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_304);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA35_330 = input.LA(1);

                         
                        int index35_330 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_330);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA35_337 = input.LA(1);

                         
                        int index35_337 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_337);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA35_338 = input.LA(1);

                         
                        int index35_338 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_338);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA35_347 = input.LA(1);

                         
                        int index35_347 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_347);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA35_361 = input.LA(1);

                         
                        int index35_361 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_361);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA35_362 = input.LA(1);

                         
                        int index35_362 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4))) ) {s = 32;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)) ) {s = 7;}

                         
                        input.seek(index35_362);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA35_0 = input.LA(1);

                         
                        int index35_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA35_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0))) {s = 1;}

                        else if ( (LA35_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1))) {s = 2;}

                        else if ( (LA35_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2))) {s = 3;}

                        else if ( (LA35_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3))) {s = 4;}

                        else if ( (LA35_0==26) ) {s = 5;}

                        else if ( (LA35_0==27) ) {s = 6;}

                        else if ( (LA35_0==17) ) {s = 7;}

                         
                        input.seek(index35_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\32\uffff";
    static final String DFA42_eofS =
        "\32\uffff";
    static final String DFA42_minS =
        "\1\21\2\uffff\1\4\3\uffff\1\20\1\35\3\5\1\21\1\13\2\5\1\0\1\21\1"+
        "\5\1\21\1\13\1\uffff\2\0\1\21\1\0";
    static final String DFA42_maxS =
        "\1\44\2\uffff\1\4\3\uffff\1\20\1\36\1\13\1\5\1\13\1\36\2\13\1\5"+
        "\1\0\1\36\1\13\1\21\1\13\1\uffff\2\0\1\21\1\0";
    static final String DFA42_acceptS =
        "\1\uffff\2\2\1\uffff\3\2\16\uffff\1\1\4\uffff";
    static final String DFA42_specialS =
        "\1\0\17\uffff\1\2\5\uffff\1\3\1\4\1\uffff\1\1}>";
    static final String[] DFA42_transitionS = {
            "\1\6\1\uffff\1\1\1\2\7\uffff\1\3\6\uffff\1\4\1\5",
            "",
            "",
            "\1\7",
            "",
            "",
            "",
            "\1\10",
            "\1\11\1\12",
            "\1\13\5\uffff\1\14",
            "\1\15",
            "\1\13\5\uffff\1\14",
            "\1\20\13\uffff\1\16\1\17",
            "\1\21",
            "\1\22\5\uffff\1\23",
            "\1\24",
            "\1\uffff",
            "\1\26\13\uffff\1\16\1\17",
            "\1\22\5\uffff\1\23",
            "\1\27",
            "\1\30",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\31",
            "\1\uffff"
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "()* loopback of 3764:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_0 = input.LA(1);

                         
                        int index42_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA42_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0))) {s = 1;}

                        else if ( (LA42_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1))) {s = 2;}

                        else if ( (LA42_0==28) ) {s = 3;}

                        else if ( (LA42_0==35) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3))) {s = 4;}

                        else if ( (LA42_0==36) && (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4))) {s = 5;}

                        else if ( (LA42_0==17) ) {s = 6;}

                         
                        input.seek(index42_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_25 = input.LA(1);

                         
                        int index42_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2))) ) {s = 21;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)) ) {s = 6;}

                         
                        input.seek(index42_25);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_16 = input.LA(1);

                         
                        int index42_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2))) ) {s = 21;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)) ) {s = 6;}

                         
                        input.seek(index42_16);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_22 = input.LA(1);

                         
                        int index42_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2))) ) {s = 21;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)) ) {s = 6;}

                         
                        input.seek(index42_22);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA42_23 = input.LA(1);

                         
                        int index42_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2))) ) {s = 21;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)) ) {s = 6;}

                         
                        input.seek(index42_23);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition__Group__0_in_rulePackageDefinition154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObject_in_entryRuleObject181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObject188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group__0_in_ruleObject214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Feature__Alternatives_in_ruleFeature274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDefinition2_in_entryRulePackageDefinition2421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition2428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition2__Group__0_in_rulePackageDefinition2454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObject2_in_entryRuleObject2481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObject2488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__Group__0_in_ruleObject2514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature2_in_entryRuleFeature2541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature2548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Feature2__Alternatives_in_ruleFeature2574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute2_in_entryRuleAttribute2601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute2608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__Group__0_in_ruleAttribute2634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference2_in_entryRuleReference2661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference2668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__Group__0_in_ruleReference2694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_entryRuleConstraintDefinition721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstraintDefinition728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group__0_in_ruleConstraintDefinition754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__EnabledAssignment_0_0_in_rule__Object__Alternatives_0841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__AbstractAssignment_0_1_in_rule__Object__Alternatives_0859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__Feature__Alternatives892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_rule__Feature__Alternatives909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_4941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Reference__Alternatives_4960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__EnabledAssignment_0_0_in_rule__Object2__Alternatives_0994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__AbstractAssignment_0_1_in_rule__Object2__Alternatives_01012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute2_in_rule__Feature2__Alternatives1045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference2_in_rule__Feature2__Alternatives1062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0__0_in_rule__Attribute2__Alternatives_31094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Attribute2__Alternatives_31113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__Group_4_0__0_in_rule__Reference2__Alternatives_41147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Reference2__Alternatives_41166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_0__01203 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__01213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__DefinitionAssignment_0_1_in_rule__Model__Group_0__11241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1__01280 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__DefinitionAssignment_1_1_in_rule__Model__Group_1__11318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__01366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__PackageDefinition__Group__11395 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__11405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition__NamespaceAssignment_2_in_rule__PackageDefinition__Group__21433 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__21442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__PackageDefinition__Group__31471 = new BitSet(new long[]{0x0000000180008002L});
        public static final BitSet FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__31481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition__ContentsAssignment_4_in_rule__PackageDefinition__Group__41509 = new BitSet(new long[]{0x0000000180008002L});
        public static final BitSet FOLLOW_rule__Object__Alternatives_0_in_rule__Object__Group__01554 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Object__Group__1_in_rule__Object__Group__01564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Object__Group__11593 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Object__Group__2_in_rule__Object__Group__11603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__NameAssignment_2_in_rule__Object__Group__21631 = new BitSet(new long[]{0x0000000000050000L});
        public static final BitSet FOLLOW_rule__Object__Group__3_in_rule__Object__Group__21640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_3__0_in_rule__Object__Group__31668 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Object__Group__4_in_rule__Object__Group__31678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Object__Group__41707 = new BitSet(new long[]{0x000000020F7A0000L});
        public static final BitSet FOLLOW_rule__Object__Group__5_in_rule__Object__Group__41717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5_in_rule__Object__Group__51745 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Object__Group__6_in_rule__Object__Group__51754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Object__Group__61783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Object__Group_3__01833 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Object__Group_3__1_in_rule__Object__Group_3__01843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__ParentAssignment_3_1_in_rule__Object__Group_3__11871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Object__Group_5_0__01910 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Object__Group_5_0__1_in_rule__Object__Group_5_0__01920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__ShortDescriptionAssignment_5_0_1_in_rule__Object__Group_5_0__11948 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object__Group_5_0__2_in_rule__Object__Group_5_0__11957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object__Group_5_0__21986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Object__Group_5_1__02028 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Object__Group_5_1__1_in_rule__Object__Group_5_1__02038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__LongDescriptionAssignment_5_1_1_in_rule__Object__Group_5_1__12066 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object__Group_5_1__2_in_rule__Object__Group_5_1__12075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object__Group_5_1__22104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Object__Group_5_2__02146 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Object__Group_5_2__1_in_rule__Object__Group_5_2__02156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__SerialVersionUIDAssignment_5_2_1_in_rule__Object__Group_5_2__12184 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object__Group_5_2__2_in_rule__Object__Group_5_2__12193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object__Group_5_2__22222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__CloneableAssignment_5_3_0_in_rule__Object__Group_5_3__02263 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object__Group_5_3__1_in_rule__Object__Group_5_3__02272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object__Group_5_3__12301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Object__Group_5_5__02341 = new BitSet(new long[]{0x000000000C800000L});
        public static final BitSet FOLLOW_rule__Object__Group_5_5__1_in_rule__Object__Group_5_5__02351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_5_1_in_rule__Object__Group_5_5__12379 = new BitSet(new long[]{0x000000000C800000L});
        public static final BitSet FOLLOW_rule__Object__Group_5_5__2_in_rule__Object__Group_5_5__12389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Object__Group_5_5__22418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Object__Group_5_6__02460 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_6__1_in_rule__Object__Group_5_6__02470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_6_1_in_rule__Object__Group_5_6__12498 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_25_in_rule__Object__Group_5_7__02538 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_rule__Object__Group_5_7__1_in_rule__Object__Group_5_7__02548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_7_1_in_rule__Object__Group_5_7__12578 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_7_1_in_rule__Object__Group_5_7__12590 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_26_in_rule__Attribute__Group__02632 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__02642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__TypeAssignment_1_in_rule__Attribute__Group__12670 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__12679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__NameAssignment_2_in_rule__Attribute__Group__22707 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Attribute__Group__3_in_rule__Attribute__Group__22716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Attribute__Group__32745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Reference__Group__02789 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__02799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__TypeAssignment_1_in_rule__Reference__Group__12827 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__12836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__ManyAssignment_2_in_rule__Reference__Group__22864 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__22874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__NameAssignment_3_in_rule__Reference__Group__32902 = new BitSet(new long[]{0x0000000000010800L});
        public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__32911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__42939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Reference__Group_4_0__02984 = new BitSet(new long[]{0x00000000001A0000L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__02994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__UnorderedGroup_4_0_1_in_rule__Reference__Group_4_0__13022 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0__2_in_rule__Reference__Group_4_0__13031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Reference__Group_4_0__23060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Reference__Group_4_0_1_0__03102 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_0__1_in_rule__Reference__Group_4_0_1_0__03112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__ShortDescriptionAssignment_4_0_1_0_1_in_rule__Reference__Group_4_0_1_0__13140 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_0__2_in_rule__Reference__Group_4_0_1_0__13149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Reference__Group_4_0_1_0__23178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Reference__Group_4_0_1_1__03220 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_1__1_in_rule__Reference__Group_4_0_1_1__03230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__LongDescriptionAssignment_4_0_1_1_1_in_rule__Reference__Group_4_0_1_1__13258 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_1__2_in_rule__Reference__Group_4_0_1_1__13267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Reference__Group_4_0_1_1__23296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition2__Group__1_in_rule__PackageDefinition2__Group__03347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__PackageDefinition2__Group__13376 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__PackageDefinition2__Group__2_in_rule__PackageDefinition2__Group__13386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition2__NamespaceAssignment_2_in_rule__PackageDefinition2__Group__23414 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__PackageDefinition2__Group__3_in_rule__PackageDefinition2__Group__23423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__PackageDefinition2__Group__33452 = new BitSet(new long[]{0x0000000180008002L});
        public static final BitSet FOLLOW_rule__PackageDefinition2__Group__4_in_rule__PackageDefinition2__Group__33462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition2__ContentsAssignment_4_in_rule__PackageDefinition2__Group__43490 = new BitSet(new long[]{0x0000000180008002L});
        public static final BitSet FOLLOW_rule__Object2__Alternatives_0_in_rule__Object2__Group__03535 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Object2__Group__1_in_rule__Object2__Group__03545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Object2__Group__13574 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Object2__Group__2_in_rule__Object2__Group__13584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__NameAssignment_2_in_rule__Object2__Group__23612 = new BitSet(new long[]{0x0000000000050000L});
        public static final BitSet FOLLOW_rule__Object2__Group__3_in_rule__Object2__Group__23621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__Group_3__0_in_rule__Object2__Group__33649 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Object2__Group__4_in_rule__Object2__Group__33659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Object2__Group__43688 = new BitSet(new long[]{0x000000020C3A0000L});
        public static final BitSet FOLLOW_rule__Object2__Group__5_in_rule__Object2__Group__43698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5_in_rule__Object2__Group__53726 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Object2__Group__6_in_rule__Object2__Group__53735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Object2__Group__63764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Object2__Group_3__03814 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Object2__Group_3__1_in_rule__Object2__Group_3__03824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__ParentAssignment_3_1_in_rule__Object2__Group_3__13852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Object2__Group_5_0__03891 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_0__1_in_rule__Object2__Group_5_0__03901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__ShortDescriptionAssignment_5_0_1_in_rule__Object2__Group_5_0__13929 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_0__2_in_rule__Object2__Group_5_0__13938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object2__Group_5_0__23967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Object2__Group_5_1__04009 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_1__1_in_rule__Object2__Group_5_1__04019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__LongDescriptionAssignment_5_1_1_in_rule__Object2__Group_5_1__14047 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_1__2_in_rule__Object2__Group_5_1__14056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object2__Group_5_1__24085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Object2__Group_5_2__04127 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_2__1_in_rule__Object2__Group_5_2__04137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__SerialVersionUIDAssignment_5_2_1_in_rule__Object2__Group_5_2__14165 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_2__2_in_rule__Object2__Group_5_2__14174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object2__Group_5_2__24203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__CloneableAssignment_5_3_0_in_rule__Object2__Group_5_3__04244 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_3__1_in_rule__Object2__Group_5_3__04253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object2__Group_5_3__14282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Attribute2__Group__04322 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute2__Group__1_in_rule__Attribute2__Group__04332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__TypeAssignment_1_in_rule__Attribute2__Group__14360 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute2__Group__2_in_rule__Attribute2__Group__14369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__NameAssignment_2_in_rule__Attribute2__Group__24397 = new BitSet(new long[]{0x0000000000010800L});
        public static final BitSet FOLLOW_rule__Attribute2__Group__3_in_rule__Attribute2__Group__24406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__Alternatives_3_in_rule__Attribute2__Group__34434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Attribute2__Group_3_0__04477 = new BitSet(new long[]{0x00000018101A0000L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0__1_in_rule__Attribute2__Group_3_0__04487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1_in_rule__Attribute2__Group_3_0__14515 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0__2_in_rule__Attribute2__Group_3_0__14524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Attribute2__Group_3_0__24553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Attribute2__Group_3_0_1_0__04595 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0_1_0__1_in_rule__Attribute2__Group_3_0_1_0__04605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1_in_rule__Attribute2__Group_3_0_1_0__14633 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0_1_0__2_in_rule__Attribute2__Group_3_0_1_0__14642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Attribute2__Group_3_0_1_0__24671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Attribute2__Group_3_0_1_1__04713 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0_1_1__1_in_rule__Attribute2__Group_3_0_1_1__04723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1_in_rule__Attribute2__Group_3_0_1_1__14751 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0_1_1__2_in_rule__Attribute2__Group_3_0_1_1__14760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Attribute2__Group_3_0_1_1__24789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__RequiredAssignment_3_0_1_3_0_in_rule__Attribute2__Group_3_0_1_3__04830 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0_1_3__1_in_rule__Attribute2__Group_3_0_1_3__04839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Attribute2__Group_3_0_1_3__14868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__TechnicalAssignment_3_0_1_4_0_in_rule__Attribute2__Group_3_0_1_4__04907 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0_1_4__1_in_rule__Attribute2__Group_3_0_1_4__04916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Attribute2__Group_3_0_1_4__14945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Reference2__Group__04985 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference2__Group__1_in_rule__Reference2__Group__04995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__TypeAssignment_1_in_rule__Reference2__Group__15023 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_rule__Reference2__Group__2_in_rule__Reference2__Group__15032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__ManyAssignment_2_in_rule__Reference2__Group__25060 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference2__Group__3_in_rule__Reference2__Group__25070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__NameAssignment_3_in_rule__Reference2__Group__35098 = new BitSet(new long[]{0x0000000000010800L});
        public static final BitSet FOLLOW_rule__Reference2__Group__4_in_rule__Reference2__Group__35107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__Alternatives_4_in_rule__Reference2__Group__45135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Reference2__Group_4_0__05180 = new BitSet(new long[]{0x00000000001A0000L});
        public static final BitSet FOLLOW_rule__Reference2__Group_4_0__1_in_rule__Reference2__Group_4_0__05190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__UnorderedGroup_4_0_1_in_rule__Reference2__Group_4_0__15218 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Reference2__Group_4_0__2_in_rule__Reference2__Group_4_0__15227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Reference2__Group_4_0__25256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Reference2__Group_4_0_1_0__05298 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Reference2__Group_4_0_1_0__1_in_rule__Reference2__Group_4_0_1_0__05308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1_in_rule__Reference2__Group_4_0_1_0__15336 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Reference2__Group_4_0_1_0__2_in_rule__Reference2__Group_4_0_1_0__15345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Reference2__Group_4_0_1_0__25374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Reference2__Group_4_0_1_1__05416 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Reference2__Group_4_0_1_1__1_in_rule__Reference2__Group_4_0_1_1__05426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__LongDescriptionAssignment_4_0_1_1_1_in_rule__Reference2__Group_4_0_1_1__15454 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Reference2__Group_4_0_1_1__2_in_rule__Reference2__Group_4_0_1_1__15463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Reference2__Group_4_0_1_1__25492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ConstraintDefinition__Group__05534 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group__1_in_rule__ConstraintDefinition__Group__05544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__TypeAssignment_1_in_rule__ConstraintDefinition__Group__15572 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group__2_in_rule__ConstraintDefinition__Group__15581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__ConstraintDefinition__Group__25610 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group__3_in_rule__ConstraintDefinition__Group__25620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__UnorderedGroup_3_in_rule__ConstraintDefinition__Group__35648 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group__4_in_rule__ConstraintDefinition__Group__35657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__ConstraintDefinition__Group__45686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ConstraintDefinition__Group_3_0__05732 = new BitSet(new long[]{0x0000000000000820L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group_3_0__1_in_rule__ConstraintDefinition__Group_3_0__05742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__ParametersAssignment_3_0_1_in_rule__ConstraintDefinition__Group_3_0__15770 = new BitSet(new long[]{0x0000000000000820L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group_3_0__2_in_rule__ConstraintDefinition__Group_3_0__15780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__ConstraintDefinition__Group_3_0__25809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ConstraintDefinition__Group_3_1__05851 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group_3_1__1_in_rule__ConstraintDefinition__Group_3_1__05861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__MessageAssignment_3_1_1_in_rule__ConstraintDefinition__Group_3_1__15889 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group_3_1__2_in_rule__ConstraintDefinition__Group_3_1__15898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__ConstraintDefinition__Group_3_1__25927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__0_in_rule__Object__UnorderedGroup_55965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_0__0_in_rule__Object__UnorderedGroup_5__Impl6052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_1__0_in_rule__Object__UnorderedGroup_5__Impl6143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_2__0_in_rule__Object__UnorderedGroup_5__Impl6234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_3__0_in_rule__Object__UnorderedGroup_5__Impl6325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_4_in_rule__Object__UnorderedGroup_5__Impl6417 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_4_in_rule__Object__UnorderedGroup_5__Impl6457 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_5__0_in_rule__Object__UnorderedGroup_5__Impl6555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_6__0_in_rule__Object__UnorderedGroup_5__Impl6646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_7__0_in_rule__Object__UnorderedGroup_5__Impl6737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__06796 = new BitSet(new long[]{0x000000020F780002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__1_in_rule__Object__UnorderedGroup_5__06799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__16824 = new BitSet(new long[]{0x000000020F780002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__2_in_rule__Object__UnorderedGroup_5__16827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__26852 = new BitSet(new long[]{0x000000020F780002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__3_in_rule__Object__UnorderedGroup_5__26855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__36880 = new BitSet(new long[]{0x000000020F780002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__4_in_rule__Object__UnorderedGroup_5__36883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__46908 = new BitSet(new long[]{0x000000020F780002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__5_in_rule__Object__UnorderedGroup_5__46911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__56936 = new BitSet(new long[]{0x000000020F780002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__6_in_rule__Object__UnorderedGroup_5__56939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__66964 = new BitSet(new long[]{0x000000020F780002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__7_in_rule__Object__UnorderedGroup_5__66967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__76992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__UnorderedGroup_4_0_1__0_in_rule__Reference__UnorderedGroup_4_0_17032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_0__0_in_rule__Reference__UnorderedGroup_4_0_1__Impl7119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_1__0_in_rule__Reference__UnorderedGroup_4_0_1__Impl7210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__UnorderedGroup_4_0_1__Impl_in_rule__Reference__UnorderedGroup_4_0_1__07269 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_rule__Reference__UnorderedGroup_4_0_1__1_in_rule__Reference__UnorderedGroup_4_0_1__07272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__UnorderedGroup_4_0_1__Impl_in_rule__Reference__UnorderedGroup_4_0_1__17297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5__0_in_rule__Object2__UnorderedGroup_57325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_0__0_in_rule__Object2__UnorderedGroup_5__Impl7412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_1__0_in_rule__Object2__UnorderedGroup_5__Impl7503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_2__0_in_rule__Object2__UnorderedGroup_5__Impl7594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__Group_5_3__0_in_rule__Object2__UnorderedGroup_5__Impl7685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__FeaturesAssignment_5_4_in_rule__Object2__UnorderedGroup_5__Impl7777 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_rule__Object2__FeaturesAssignment_5_4_in_rule__Object2__UnorderedGroup_5__Impl7817 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5__Impl_in_rule__Object2__UnorderedGroup_5__07883 = new BitSet(new long[]{0x000000020C380002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5__1_in_rule__Object2__UnorderedGroup_5__07886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5__Impl_in_rule__Object2__UnorderedGroup_5__17911 = new BitSet(new long[]{0x000000020C380002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5__2_in_rule__Object2__UnorderedGroup_5__17914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5__Impl_in_rule__Object2__UnorderedGroup_5__27939 = new BitSet(new long[]{0x000000020C380002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5__3_in_rule__Object2__UnorderedGroup_5__27942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5__Impl_in_rule__Object2__UnorderedGroup_5__37967 = new BitSet(new long[]{0x000000020C380002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5__4_in_rule__Object2__UnorderedGroup_5__37970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object2__UnorderedGroup_5__Impl_in_rule__Object2__UnorderedGroup_5__47995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__0_in_rule__Attribute2__UnorderedGroup_3_0_18029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0_1_0__0_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0_1_1__0_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8299 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8339 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0_1_3__0_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__Group_3_0_1_4__0_in_rule__Attribute2__UnorderedGroup_3_0_1__Impl8528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__Impl_in_rule__Attribute2__UnorderedGroup_3_0_1__08587 = new BitSet(new long[]{0x0000001810180002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__1_in_rule__Attribute2__UnorderedGroup_3_0_1__08590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__Impl_in_rule__Attribute2__UnorderedGroup_3_0_1__18615 = new BitSet(new long[]{0x0000001810180002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__2_in_rule__Attribute2__UnorderedGroup_3_0_1__18618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__Impl_in_rule__Attribute2__UnorderedGroup_3_0_1__28643 = new BitSet(new long[]{0x0000001810180002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__3_in_rule__Attribute2__UnorderedGroup_3_0_1__28646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__Impl_in_rule__Attribute2__UnorderedGroup_3_0_1__38671 = new BitSet(new long[]{0x0000001810180002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__4_in_rule__Attribute2__UnorderedGroup_3_0_1__38674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute2__UnorderedGroup_3_0_1__Impl_in_rule__Attribute2__UnorderedGroup_3_0_1__48699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__UnorderedGroup_4_0_1__0_in_rule__Reference2__UnorderedGroup_4_0_18733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__Group_4_0_1_0__0_in_rule__Reference2__UnorderedGroup_4_0_1__Impl8820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__Group_4_0_1_1__0_in_rule__Reference2__UnorderedGroup_4_0_1__Impl8911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__UnorderedGroup_4_0_1__Impl_in_rule__Reference2__UnorderedGroup_4_0_1__08970 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_rule__Reference2__UnorderedGroup_4_0_1__1_in_rule__Reference2__UnorderedGroup_4_0_1__08973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference2__UnorderedGroup_4_0_1__Impl_in_rule__Reference2__UnorderedGroup_4_0_1__18998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__UnorderedGroup_3__0_in_rule__ConstraintDefinition__UnorderedGroup_39026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group_3_0__0_in_rule__ConstraintDefinition__UnorderedGroup_3__Impl9115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__Group_3_1__0_in_rule__ConstraintDefinition__UnorderedGroup_3__Impl9206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__UnorderedGroup_3__Impl_in_rule__ConstraintDefinition__UnorderedGroup_3__09265 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__UnorderedGroup_3__1_in_rule__ConstraintDefinition__UnorderedGroup_3__09268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ConstraintDefinition__UnorderedGroup_3__Impl_in_rule__ConstraintDefinition__UnorderedGroup_3__19293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDefinition_in_rule__Model__DefinitionAssignment_0_19325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDefinition2_in_rule__Model__DefinitionAssignment_1_19356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__PackageDefinition__NamespaceAssignment_29387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObject_in_rule__PackageDefinition__ContentsAssignment_49418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__Object__EnabledAssignment_0_09454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Object__AbstractAssignment_0_19498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Object__NameAssignment_29537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Object__ParentAssignment_3_19572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Object__ShortDescriptionAssignment_5_0_19607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Object__LongDescriptionAssignment_5_1_19638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Object__SerialVersionUIDAssignment_5_2_19669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__Object__CloneableAssignment_5_3_09705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_49744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_5_19775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_6_19806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_7_19837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__TypeAssignment_19868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_29899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__TypeAssignment_19934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__Reference__ManyAssignment_29974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_310013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Reference__ShortDescriptionAssignment_4_0_1_0_110044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Reference__LongDescriptionAssignment_4_0_1_1_110075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__PackageDefinition2__NamespaceAssignment_210106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObject2_in_rule__PackageDefinition2__ContentsAssignment_410137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__Object2__EnabledAssignment_0_010173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Object2__AbstractAssignment_0_110217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Object2__NameAssignment_210256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Object2__ParentAssignment_3_110291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Object2__ShortDescriptionAssignment_5_0_110326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Object2__LongDescriptionAssignment_5_1_110357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Object2__SerialVersionUIDAssignment_5_2_110388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__Object2__CloneableAssignment_5_3_010424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature2_in_rule__Object2__FeaturesAssignment_5_410463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute2__TypeAssignment_110494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute2__NameAssignment_210525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_110556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Attribute2__LongDescriptionAssignment_3_0_1_1_110587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_210618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__Attribute2__RequiredAssignment_3_0_1_3_010654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__Attribute2__TechnicalAssignment_3_0_1_4_010698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Reference2__TypeAssignment_110741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__Reference2__ManyAssignment_210781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Reference2__NameAssignment_310820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Reference2__ShortDescriptionAssignment_4_0_1_0_110851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Reference2__LongDescriptionAssignment_4_0_1_1_110882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ConstraintDefinition__TypeAssignment_110913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ConstraintDefinition__ParametersAssignment_3_0_110944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ConstraintDefinition__MessageAssignment_3_1_110975 = new BitSet(new long[]{0x0000000000000002L});
    }


}
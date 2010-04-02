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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug304681TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug304681TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'package'", "'object'", "'{'", "'}'", "'extends'", "'shortDescription'", "'longDescription'", "'serialUID'", "'before'", "'after'", "'optionalLoop'", "'mandatoryLoop'", "'Attribute'", "'Reference'", "'enabled'", "'abstract'", "'cloneable'", "'*'"
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




    // $ANTLR start entryRulePackageDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:60:1: entryRulePackageDefinition : rulePackageDefinition EOF ;
    public final void entryRulePackageDefinition() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:61:1: ( rulePackageDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:62:1: rulePackageDefinition EOF
            {
             before(grammarAccess.getPackageDefinitionRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition61);
            rulePackageDefinition();
            _fsp--;

             after(grammarAccess.getPackageDefinitionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDefinition68); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:69:1: rulePackageDefinition : ( ( rule__PackageDefinition__Group__0 ) ) ;
    public final void rulePackageDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:73:2: ( ( ( rule__PackageDefinition__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:74:1: ( ( rule__PackageDefinition__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:74:1: ( ( rule__PackageDefinition__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:75:1: ( rule__PackageDefinition__Group__0 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:76:1: ( rule__PackageDefinition__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:76:2: rule__PackageDefinition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__Group__0_in_rulePackageDefinition94);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:88:1: entryRuleObject : ruleObject EOF ;
    public final void entryRuleObject() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:89:1: ( ruleObject EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:90:1: ruleObject EOF
            {
             before(grammarAccess.getObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObject_in_entryRuleObject121);
            ruleObject();
            _fsp--;

             after(grammarAccess.getObjectRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObject128); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:97:1: ruleObject : ( ( rule__Object__Group__0 ) ) ;
    public final void ruleObject() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:101:2: ( ( ( rule__Object__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:102:1: ( ( rule__Object__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:102:1: ( ( rule__Object__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:103:1: ( rule__Object__Group__0 )
            {
             before(grammarAccess.getObjectAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:104:1: ( rule__Object__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:104:2: rule__Object__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__0_in_ruleObject154);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:116:1: entryRuleFeature : ruleFeature EOF ;
    public final void entryRuleFeature() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:117:1: ( ruleFeature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:118:1: ruleFeature EOF
            {
             before(grammarAccess.getFeatureRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature181);
            ruleFeature();
            _fsp--;

             after(grammarAccess.getFeatureRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature188); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:125:1: ruleFeature : ( ( rule__Feature__Alternatives ) ) ;
    public final void ruleFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:129:2: ( ( ( rule__Feature__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:130:1: ( ( rule__Feature__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:130:1: ( ( rule__Feature__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:131:1: ( rule__Feature__Alternatives )
            {
             before(grammarAccess.getFeatureAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:132:1: ( rule__Feature__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:132:2: rule__Feature__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Feature__Alternatives_in_ruleFeature214);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:144:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:145:1: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:146:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute241);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute248); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:153:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:157:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:158:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:158:1: ( ( rule__Attribute__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:159:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:160:1: ( rule__Attribute__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:160:2: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0_in_ruleAttribute274);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:172:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:173:1: ( ruleReference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:174:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference301);
            ruleReference();
            _fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference308); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:181:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:185:2: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:186:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:186:1: ( ( rule__Reference__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:187:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:188:1: ( rule__Reference__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:188:2: rule__Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__0_in_ruleReference334);
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


    // $ANTLR start rule__Object__Alternatives_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:200:1: rule__Object__Alternatives_0 : ( ( ( rule__Object__EnabledAssignment_0_0 ) ) | ( ( rule__Object__AbstractAssignment_0_1 ) ) );
    public final void rule__Object__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:204:1: ( ( ( rule__Object__EnabledAssignment_0_0 ) ) | ( ( rule__Object__AbstractAssignment_0_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==26) ) {
                alt1=1;
            }
            else if ( (LA1_0==27) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("200:1: rule__Object__Alternatives_0 : ( ( ( rule__Object__EnabledAssignment_0_0 ) ) | ( ( rule__Object__AbstractAssignment_0_1 ) ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:205:1: ( ( rule__Object__EnabledAssignment_0_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:205:1: ( ( rule__Object__EnabledAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:206:1: ( rule__Object__EnabledAssignment_0_0 )
                    {
                     before(grammarAccess.getObjectAccess().getEnabledAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:207:1: ( rule__Object__EnabledAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:207:2: rule__Object__EnabledAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__EnabledAssignment_0_0_in_rule__Object__Alternatives_0370);
                    rule__Object__EnabledAssignment_0_0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getEnabledAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:211:6: ( ( rule__Object__AbstractAssignment_0_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:211:6: ( ( rule__Object__AbstractAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:212:1: ( rule__Object__AbstractAssignment_0_1 )
                    {
                     before(grammarAccess.getObjectAccess().getAbstractAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:213:1: ( rule__Object__AbstractAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:213:2: rule__Object__AbstractAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__AbstractAssignment_0_1_in_rule__Object__Alternatives_0388);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:222:1: rule__Feature__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );
    public final void rule__Feature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:226:1: ( ( ruleAttribute ) | ( ruleReference ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==24) ) {
                alt2=1;
            }
            else if ( (LA2_0==25) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("222:1: rule__Feature__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:227:1: ( ruleAttribute )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:227:1: ( ruleAttribute )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:228:1: ruleAttribute
                    {
                     before(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__Feature__Alternatives421);
                    ruleAttribute();
                    _fsp--;

                     after(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:233:6: ( ruleReference )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:233:6: ( ruleReference )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:234:1: ruleReference
                    {
                     before(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleReference_in_rule__Feature__Alternatives438);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:244:1: rule__Reference__Alternatives_4 : ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ';' ) );
    public final void rule__Reference__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:248:1: ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ';' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==11) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("244:1: rule__Reference__Alternatives_4 : ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ';' ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:249:1: ( ( rule__Reference__Group_4_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:249:1: ( ( rule__Reference__Group_4_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:250:1: ( rule__Reference__Group_4_0__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:251:1: ( rule__Reference__Group_4_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:251:2: rule__Reference__Group_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_4470);
                    rule__Reference__Group_4_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:255:6: ( ';' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:255:6: ( ';' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:256:1: ';'
                    {
                     before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_1()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Reference__Alternatives_4489); 
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


    // $ANTLR start rule__PackageDefinition__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:270:1: rule__PackageDefinition__Group__0 : ( () ) rule__PackageDefinition__Group__1 ;
    public final void rule__PackageDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:274:1: ( ( () ) rule__PackageDefinition__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:275:1: ( () ) rule__PackageDefinition__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:275:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:276:1: ()
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:277:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:279:1: 
            {
            }

             after(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__0535);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:290:1: rule__PackageDefinition__Group__1 : ( 'package' ) rule__PackageDefinition__Group__2 ;
    public final void rule__PackageDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:294:1: ( ( 'package' ) rule__PackageDefinition__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:295:1: ( 'package' ) rule__PackageDefinition__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:295:1: ( 'package' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:296:1: 'package'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__PackageDefinition__Group__1564); 
             after(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__1574);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:310:1: rule__PackageDefinition__Group__2 : ( ( rule__PackageDefinition__NamespaceAssignment_2 ) ) rule__PackageDefinition__Group__3 ;
    public final void rule__PackageDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:314:1: ( ( ( rule__PackageDefinition__NamespaceAssignment_2 ) ) rule__PackageDefinition__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:315:1: ( ( rule__PackageDefinition__NamespaceAssignment_2 ) ) rule__PackageDefinition__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:315:1: ( ( rule__PackageDefinition__NamespaceAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:316:1: ( rule__PackageDefinition__NamespaceAssignment_2 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getNamespaceAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:317:1: ( rule__PackageDefinition__NamespaceAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:317:2: rule__PackageDefinition__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__NamespaceAssignment_2_in_rule__PackageDefinition__Group__2602);
            rule__PackageDefinition__NamespaceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getPackageDefinitionAccess().getNamespaceAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__2611);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:328:1: rule__PackageDefinition__Group__3 : ( ';' ) rule__PackageDefinition__Group__4 ;
    public final void rule__PackageDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:332:1: ( ( ';' ) rule__PackageDefinition__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:333:1: ( ';' ) rule__PackageDefinition__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:333:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:334:1: ';'
            {
             before(grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__PackageDefinition__Group__3640); 
             after(grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__3650);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:348:1: rule__PackageDefinition__Group__4 : ( ( rule__PackageDefinition__ContentsAssignment_4 )* ) ;
    public final void rule__PackageDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:352:1: ( ( ( rule__PackageDefinition__ContentsAssignment_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:353:1: ( ( rule__PackageDefinition__ContentsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:353:1: ( ( rule__PackageDefinition__ContentsAssignment_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:354:1: ( rule__PackageDefinition__ContentsAssignment_4 )*
            {
             before(grammarAccess.getPackageDefinitionAccess().getContentsAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:355:1: ( rule__PackageDefinition__ContentsAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13||(LA4_0>=26 && LA4_0<=27)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:355:2: rule__PackageDefinition__ContentsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PackageDefinition__ContentsAssignment_4_in_rule__PackageDefinition__Group__4678);
            	    rule__PackageDefinition__ContentsAssignment_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:375:1: rule__Object__Group__0 : ( ( rule__Object__Alternatives_0 )? ) rule__Object__Group__1 ;
    public final void rule__Object__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:379:1: ( ( ( rule__Object__Alternatives_0 )? ) rule__Object__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:380:1: ( ( rule__Object__Alternatives_0 )? ) rule__Object__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:380:1: ( ( rule__Object__Alternatives_0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:381:1: ( rule__Object__Alternatives_0 )?
            {
             before(grammarAccess.getObjectAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:382:1: ( rule__Object__Alternatives_0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=26 && LA5_0<=27)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:382:2: rule__Object__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Alternatives_0_in_rule__Object__Group__0723);
                    rule__Object__Alternatives_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjectAccess().getAlternatives_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__1_in_rule__Object__Group__0733);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:393:1: rule__Object__Group__1 : ( 'object' ) rule__Object__Group__2 ;
    public final void rule__Object__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:397:1: ( ( 'object' ) rule__Object__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:398:1: ( 'object' ) rule__Object__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:398:1: ( 'object' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:399:1: 'object'
            {
             before(grammarAccess.getObjectAccess().getObjectKeyword_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Object__Group__1762); 
             after(grammarAccess.getObjectAccess().getObjectKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__2_in_rule__Object__Group__1772);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:413:1: rule__Object__Group__2 : ( ( rule__Object__NameAssignment_2 ) ) rule__Object__Group__3 ;
    public final void rule__Object__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:417:1: ( ( ( rule__Object__NameAssignment_2 ) ) rule__Object__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:418:1: ( ( rule__Object__NameAssignment_2 ) ) rule__Object__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:418:1: ( ( rule__Object__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:419:1: ( rule__Object__NameAssignment_2 )
            {
             before(grammarAccess.getObjectAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:420:1: ( rule__Object__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:420:2: rule__Object__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__NameAssignment_2_in_rule__Object__Group__2800);
            rule__Object__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__3_in_rule__Object__Group__2809);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:431:1: rule__Object__Group__3 : ( ( rule__Object__Group_3__0 )? ) rule__Object__Group__4 ;
    public final void rule__Object__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:435:1: ( ( ( rule__Object__Group_3__0 )? ) rule__Object__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:436:1: ( ( rule__Object__Group_3__0 )? ) rule__Object__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:436:1: ( ( rule__Object__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:437:1: ( rule__Object__Group_3__0 )?
            {
             before(grammarAccess.getObjectAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:438:1: ( rule__Object__Group_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:438:2: rule__Object__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_3__0_in_rule__Object__Group__3837);
                    rule__Object__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjectAccess().getGroup_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__4_in_rule__Object__Group__3847);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:449:1: rule__Object__Group__4 : ( '{' ) rule__Object__Group__5 ;
    public final void rule__Object__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:453:1: ( ( '{' ) rule__Object__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:454:1: ( '{' ) rule__Object__Group__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:454:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:455:1: '{'
            {
             before(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Object__Group__4876); 
             after(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__5_in_rule__Object__Group__4886);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:469:1: rule__Object__Group__5 : ( ( rule__Object__UnorderedGroup_5 ) ) rule__Object__Group__6 ;
    public final void rule__Object__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:473:1: ( ( ( rule__Object__UnorderedGroup_5 ) ) rule__Object__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:474:1: ( ( rule__Object__UnorderedGroup_5 ) ) rule__Object__Group__6
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:474:1: ( ( rule__Object__UnorderedGroup_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:475:1: ( rule__Object__UnorderedGroup_5 )
            {
             before(grammarAccess.getObjectAccess().getUnorderedGroup_5()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:476:1: ( rule__Object__UnorderedGroup_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:476:2: rule__Object__UnorderedGroup_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5_in_rule__Object__Group__5914);
            rule__Object__UnorderedGroup_5();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getUnorderedGroup_5()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group__6_in_rule__Object__Group__5923);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:487:1: rule__Object__Group__6 : ( '}' ) ;
    public final void rule__Object__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:491:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:492:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:492:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:493:1: '}'
            {
             before(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_6()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Object__Group__6952); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:520:1: rule__Object__Group_3__0 : ( 'extends' ) rule__Object__Group_3__1 ;
    public final void rule__Object__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:524:1: ( ( 'extends' ) rule__Object__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:525:1: ( 'extends' ) rule__Object__Group_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:525:1: ( 'extends' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:526:1: 'extends'
            {
             before(grammarAccess.getObjectAccess().getExtendsKeyword_3_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Object__Group_3__01002); 
             after(grammarAccess.getObjectAccess().getExtendsKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_3__1_in_rule__Object__Group_3__01012);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:540:1: rule__Object__Group_3__1 : ( ( rule__Object__ParentAssignment_3_1 ) ) ;
    public final void rule__Object__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:544:1: ( ( ( rule__Object__ParentAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:545:1: ( ( rule__Object__ParentAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:545:1: ( ( rule__Object__ParentAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:546:1: ( rule__Object__ParentAssignment_3_1 )
            {
             before(grammarAccess.getObjectAccess().getParentAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:547:1: ( rule__Object__ParentAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:547:2: rule__Object__ParentAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__ParentAssignment_3_1_in_rule__Object__Group_3__11040);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:561:1: rule__Object__Group_5_0__0 : ( 'shortDescription' ) rule__Object__Group_5_0__1 ;
    public final void rule__Object__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:565:1: ( ( 'shortDescription' ) rule__Object__Group_5_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:566:1: ( 'shortDescription' ) rule__Object__Group_5_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:566:1: ( 'shortDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:567:1: 'shortDescription'
            {
             before(grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Object__Group_5_0__01079); 
             after(grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_0__1_in_rule__Object__Group_5_0__01089);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:581:1: rule__Object__Group_5_0__1 : ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) ) rule__Object__Group_5_0__2 ;
    public final void rule__Object__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:585:1: ( ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) ) rule__Object__Group_5_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:586:1: ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) ) rule__Object__Group_5_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:586:1: ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:587:1: ( rule__Object__ShortDescriptionAssignment_5_0_1 )
            {
             before(grammarAccess.getObjectAccess().getShortDescriptionAssignment_5_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:588:1: ( rule__Object__ShortDescriptionAssignment_5_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:588:2: rule__Object__ShortDescriptionAssignment_5_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__ShortDescriptionAssignment_5_0_1_in_rule__Object__Group_5_0__11117);
            rule__Object__ShortDescriptionAssignment_5_0_1();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getShortDescriptionAssignment_5_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_0__2_in_rule__Object__Group_5_0__11126);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:599:1: rule__Object__Group_5_0__2 : ( ';' ) ;
    public final void rule__Object__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:603:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:604:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:604:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:605:1: ';'
            {
             before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object__Group_5_0__21155); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:624:1: rule__Object__Group_5_1__0 : ( 'longDescription' ) rule__Object__Group_5_1__1 ;
    public final void rule__Object__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:628:1: ( ( 'longDescription' ) rule__Object__Group_5_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:629:1: ( 'longDescription' ) rule__Object__Group_5_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:629:1: ( 'longDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:630:1: 'longDescription'
            {
             before(grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Object__Group_5_1__01197); 
             after(grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_1__1_in_rule__Object__Group_5_1__01207);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:644:1: rule__Object__Group_5_1__1 : ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) ) rule__Object__Group_5_1__2 ;
    public final void rule__Object__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:648:1: ( ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) ) rule__Object__Group_5_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:649:1: ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) ) rule__Object__Group_5_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:649:1: ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:650:1: ( rule__Object__LongDescriptionAssignment_5_1_1 )
            {
             before(grammarAccess.getObjectAccess().getLongDescriptionAssignment_5_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:651:1: ( rule__Object__LongDescriptionAssignment_5_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:651:2: rule__Object__LongDescriptionAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__LongDescriptionAssignment_5_1_1_in_rule__Object__Group_5_1__11235);
            rule__Object__LongDescriptionAssignment_5_1_1();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getLongDescriptionAssignment_5_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_1__2_in_rule__Object__Group_5_1__11244);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:662:1: rule__Object__Group_5_1__2 : ( ';' ) ;
    public final void rule__Object__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:666:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:667:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:667:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:668:1: ';'
            {
             before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object__Group_5_1__21273); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:687:1: rule__Object__Group_5_2__0 : ( 'serialUID' ) rule__Object__Group_5_2__1 ;
    public final void rule__Object__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:691:1: ( ( 'serialUID' ) rule__Object__Group_5_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:692:1: ( 'serialUID' ) rule__Object__Group_5_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:692:1: ( 'serialUID' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:693:1: 'serialUID'
            {
             before(grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Object__Group_5_2__01315); 
             after(grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_2__1_in_rule__Object__Group_5_2__01325);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:707:1: rule__Object__Group_5_2__1 : ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) ) rule__Object__Group_5_2__2 ;
    public final void rule__Object__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:711:1: ( ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) ) rule__Object__Group_5_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:712:1: ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) ) rule__Object__Group_5_2__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:712:1: ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:713:1: ( rule__Object__SerialVersionUIDAssignment_5_2_1 )
            {
             before(grammarAccess.getObjectAccess().getSerialVersionUIDAssignment_5_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:714:1: ( rule__Object__SerialVersionUIDAssignment_5_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:714:2: rule__Object__SerialVersionUIDAssignment_5_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__SerialVersionUIDAssignment_5_2_1_in_rule__Object__Group_5_2__11353);
            rule__Object__SerialVersionUIDAssignment_5_2_1();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getSerialVersionUIDAssignment_5_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_2__2_in_rule__Object__Group_5_2__11362);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:725:1: rule__Object__Group_5_2__2 : ( ';' ) ;
    public final void rule__Object__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:729:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:730:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:730:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:731:1: ';'
            {
             before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object__Group_5_2__21391); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:750:1: rule__Object__Group_5_3__0 : ( ( rule__Object__CloneableAssignment_5_3_0 ) ) rule__Object__Group_5_3__1 ;
    public final void rule__Object__Group_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:754:1: ( ( ( rule__Object__CloneableAssignment_5_3_0 ) ) rule__Object__Group_5_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:755:1: ( ( rule__Object__CloneableAssignment_5_3_0 ) ) rule__Object__Group_5_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:755:1: ( ( rule__Object__CloneableAssignment_5_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:756:1: ( rule__Object__CloneableAssignment_5_3_0 )
            {
             before(grammarAccess.getObjectAccess().getCloneableAssignment_5_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:757:1: ( rule__Object__CloneableAssignment_5_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:757:2: rule__Object__CloneableAssignment_5_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__CloneableAssignment_5_3_0_in_rule__Object__Group_5_3__01432);
            rule__Object__CloneableAssignment_5_3_0();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getCloneableAssignment_5_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_3__1_in_rule__Object__Group_5_3__01441);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:768:1: rule__Object__Group_5_3__1 : ( ';' ) ;
    public final void rule__Object__Group_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:772:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:773:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:773:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:774:1: ';'
            {
             before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Object__Group_5_3__11470); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:791:1: rule__Object__Group_5_5__0 : ( 'before' ) rule__Object__Group_5_5__1 ;
    public final void rule__Object__Group_5_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:795:1: ( ( 'before' ) rule__Object__Group_5_5__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:796:1: ( 'before' ) rule__Object__Group_5_5__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:796:1: ( 'before' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:797:1: 'before'
            {
             before(grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Object__Group_5_5__01510); 
             after(grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_5__1_in_rule__Object__Group_5_5__01520);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:811:1: rule__Object__Group_5_5__1 : ( ( rule__Object__FeaturesAssignment_5_5_1 )* ) rule__Object__Group_5_5__2 ;
    public final void rule__Object__Group_5_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:815:1: ( ( ( rule__Object__FeaturesAssignment_5_5_1 )* ) rule__Object__Group_5_5__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:816:1: ( ( rule__Object__FeaturesAssignment_5_5_1 )* ) rule__Object__Group_5_5__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:816:1: ( ( rule__Object__FeaturesAssignment_5_5_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:817:1: ( rule__Object__FeaturesAssignment_5_5_1 )*
            {
             before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_5_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:818:1: ( rule__Object__FeaturesAssignment_5_5_1 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=24 && LA7_0<=25)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:818:2: rule__Object__FeaturesAssignment_5_5_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_5_1_in_rule__Object__Group_5_5__11548);
            	    rule__Object__FeaturesAssignment_5_5_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_5_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_5__2_in_rule__Object__Group_5_5__11558);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:829:1: rule__Object__Group_5_5__2 : ( 'after' ) ;
    public final void rule__Object__Group_5_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:833:1: ( ( 'after' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:834:1: ( 'after' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:834:1: ( 'after' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:835:1: 'after'
            {
             before(grammarAccess.getObjectAccess().getAfterKeyword_5_5_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Object__Group_5_5__21587); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:854:1: rule__Object__Group_5_6__0 : ( 'optionalLoop' ) rule__Object__Group_5_6__1 ;
    public final void rule__Object__Group_5_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:858:1: ( ( 'optionalLoop' ) rule__Object__Group_5_6__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:859:1: ( 'optionalLoop' ) rule__Object__Group_5_6__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:859:1: ( 'optionalLoop' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:860:1: 'optionalLoop'
            {
             before(grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Object__Group_5_6__01629); 
             after(grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_6__1_in_rule__Object__Group_5_6__01639);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:874:1: rule__Object__Group_5_6__1 : ( ( rule__Object__FeaturesAssignment_5_6_1 )* ) ;
    public final void rule__Object__Group_5_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:878:1: ( ( ( rule__Object__FeaturesAssignment_5_6_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:879:1: ( ( rule__Object__FeaturesAssignment_5_6_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:879:1: ( ( rule__Object__FeaturesAssignment_5_6_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:880:1: ( rule__Object__FeaturesAssignment_5_6_1 )*
            {
             before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_6_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:881:1: ( rule__Object__FeaturesAssignment_5_6_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    int LA8_5 = input.LA(2);

                    if ( (LA8_5==RULE_ID) ) {
                        int LA8_11 = input.LA(3);

                        if ( (LA8_11==RULE_ID) ) {
                            int LA8_13 = input.LA(4);

                            if ( (LA8_13==11) ) {
                                int LA8_16 = input.LA(5);

                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                    alt8=1;
                                }


                            }


                        }


                    }


                }
                else if ( (LA8_0==25) ) {
                    int LA8_6 = input.LA(2);

                    if ( (LA8_6==RULE_ID) ) {
                        int LA8_12 = input.LA(3);

                        if ( (LA8_12==29) ) {
                            int LA8_14 = input.LA(4);

                            if ( (LA8_14==RULE_ID) ) {
                                int LA8_15 = input.LA(5);

                                if ( (LA8_15==14) ) {
                                    switch ( input.LA(6) ) {
                                    case 17:
                                        {
                                        int LA8_20 = input.LA(7);

                                        if ( (LA8_20==RULE_STRING) ) {
                                            int LA8_24 = input.LA(8);

                                            if ( (LA8_24==11) ) {
                                                switch ( input.LA(9) ) {
                                                case 17:
                                                    {
                                                    int LA8_28 = input.LA(10);

                                                    if ( (LA8_28==RULE_STRING) ) {
                                                        int LA8_32 = input.LA(11);

                                                        if ( (LA8_32==11) ) {
                                                            int LA8_34 = input.LA(12);

                                                            if ( (LA8_34==15) ) {
                                                                int LA8_36 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt8=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 18:
                                                    {
                                                    int LA8_29 = input.LA(10);

                                                    if ( (LA8_29==RULE_STRING) ) {
                                                        int LA8_33 = input.LA(11);

                                                        if ( (LA8_33==11) ) {
                                                            int LA8_35 = input.LA(12);

                                                            if ( (LA8_35==15) ) {
                                                                int LA8_37 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt8=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 15:
                                                    {
                                                    int LA8_30 = input.LA(10);

                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                        alt8=1;
                                                    }


                                                    }
                                                    break;

                                                }

                                            }


                                        }


                                        }
                                        break;
                                    case 18:
                                        {
                                        int LA8_21 = input.LA(7);

                                        if ( (LA8_21==RULE_STRING) ) {
                                            int LA8_25 = input.LA(8);

                                            if ( (LA8_25==11) ) {
                                                switch ( input.LA(9) ) {
                                                case 17:
                                                    {
                                                    int LA8_28 = input.LA(10);

                                                    if ( (LA8_28==RULE_STRING) ) {
                                                        int LA8_32 = input.LA(11);

                                                        if ( (LA8_32==11) ) {
                                                            int LA8_34 = input.LA(12);

                                                            if ( (LA8_34==15) ) {
                                                                int LA8_36 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt8=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 18:
                                                    {
                                                    int LA8_29 = input.LA(10);

                                                    if ( (LA8_29==RULE_STRING) ) {
                                                        int LA8_33 = input.LA(11);

                                                        if ( (LA8_33==11) ) {
                                                            int LA8_35 = input.LA(12);

                                                            if ( (LA8_35==15) ) {
                                                                int LA8_37 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt8=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 15:
                                                    {
                                                    int LA8_31 = input.LA(10);

                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                        alt8=1;
                                                    }


                                                    }
                                                    break;

                                                }

                                            }


                                        }


                                        }
                                        break;
                                    case 15:
                                        {
                                        int LA8_22 = input.LA(7);

                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                            alt8=1;
                                        }


                                        }
                                        break;

                                    }

                                }
                                else if ( (LA8_15==11) ) {
                                    int LA8_18 = input.LA(6);

                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                        alt8=1;
                                    }


                                }


                            }


                        }
                        else if ( (LA8_12==RULE_ID) ) {
                            int LA8_15 = input.LA(4);

                            if ( (LA8_15==14) ) {
                                switch ( input.LA(5) ) {
                                case 17:
                                    {
                                    int LA8_20 = input.LA(6);

                                    if ( (LA8_20==RULE_STRING) ) {
                                        int LA8_24 = input.LA(7);

                                        if ( (LA8_24==11) ) {
                                            switch ( input.LA(8) ) {
                                            case 17:
                                                {
                                                int LA8_28 = input.LA(9);

                                                if ( (LA8_28==RULE_STRING) ) {
                                                    int LA8_32 = input.LA(10);

                                                    if ( (LA8_32==11) ) {
                                                        int LA8_34 = input.LA(11);

                                                        if ( (LA8_34==15) ) {
                                                            int LA8_36 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt8=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 18:
                                                {
                                                int LA8_29 = input.LA(9);

                                                if ( (LA8_29==RULE_STRING) ) {
                                                    int LA8_33 = input.LA(10);

                                                    if ( (LA8_33==11) ) {
                                                        int LA8_35 = input.LA(11);

                                                        if ( (LA8_35==15) ) {
                                                            int LA8_37 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt8=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 15:
                                                {
                                                int LA8_30 = input.LA(9);

                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                    alt8=1;
                                                }


                                                }
                                                break;

                                            }

                                        }


                                    }


                                    }
                                    break;
                                case 18:
                                    {
                                    int LA8_21 = input.LA(6);

                                    if ( (LA8_21==RULE_STRING) ) {
                                        int LA8_25 = input.LA(7);

                                        if ( (LA8_25==11) ) {
                                            switch ( input.LA(8) ) {
                                            case 17:
                                                {
                                                int LA8_28 = input.LA(9);

                                                if ( (LA8_28==RULE_STRING) ) {
                                                    int LA8_32 = input.LA(10);

                                                    if ( (LA8_32==11) ) {
                                                        int LA8_34 = input.LA(11);

                                                        if ( (LA8_34==15) ) {
                                                            int LA8_36 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt8=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 18:
                                                {
                                                int LA8_29 = input.LA(9);

                                                if ( (LA8_29==RULE_STRING) ) {
                                                    int LA8_33 = input.LA(10);

                                                    if ( (LA8_33==11) ) {
                                                        int LA8_35 = input.LA(11);

                                                        if ( (LA8_35==15) ) {
                                                            int LA8_37 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt8=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 15:
                                                {
                                                int LA8_31 = input.LA(9);

                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                    alt8=1;
                                                }


                                                }
                                                break;

                                            }

                                        }


                                    }


                                    }
                                    break;
                                case 15:
                                    {
                                    int LA8_22 = input.LA(6);

                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                        alt8=1;
                                    }


                                    }
                                    break;

                                }

                            }
                            else if ( (LA8_15==11) ) {
                                int LA8_18 = input.LA(5);

                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                    alt8=1;
                                }


                            }


                        }


                    }


                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:881:2: rule__Object__FeaturesAssignment_5_6_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_6_1_in_rule__Object__Group_5_6__11667);
            	    rule__Object__FeaturesAssignment_5_6_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:895:1: rule__Object__Group_5_7__0 : ( 'mandatoryLoop' ) rule__Object__Group_5_7__1 ;
    public final void rule__Object__Group_5_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:899:1: ( ( 'mandatoryLoop' ) rule__Object__Group_5_7__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:900:1: ( 'mandatoryLoop' ) rule__Object__Group_5_7__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:900:1: ( 'mandatoryLoop' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:901:1: 'mandatoryLoop'
            {
             before(grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Object__Group_5_7__01707); 
             after(grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_7__1_in_rule__Object__Group_5_7__01717);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:915:1: rule__Object__Group_5_7__1 : ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) ) ;
    public final void rule__Object__Group_5_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:919:1: ( ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:920:1: ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:920:1: ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:921:1: ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:921:1: ( ( rule__Object__FeaturesAssignment_5_7_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:922:1: ( rule__Object__FeaturesAssignment_5_7_1 )
            {
             before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:923:1: ( rule__Object__FeaturesAssignment_5_7_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:923:2: rule__Object__FeaturesAssignment_5_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_7_1_in_rule__Object__Group_5_7__11747);
            rule__Object__FeaturesAssignment_5_7_1();
            _fsp--;


            }

             after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:926:1: ( ( rule__Object__FeaturesAssignment_5_7_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:927:1: ( rule__Object__FeaturesAssignment_5_7_1 )*
            {
             before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:928:1: ( rule__Object__FeaturesAssignment_5_7_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    int LA9_5 = input.LA(2);

                    if ( (LA9_5==RULE_ID) ) {
                        int LA9_11 = input.LA(3);

                        if ( (LA9_11==RULE_ID) ) {
                            int LA9_13 = input.LA(4);

                            if ( (LA9_13==11) ) {
                                int LA9_16 = input.LA(5);

                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                    alt9=1;
                                }


                            }


                        }


                    }


                }
                else if ( (LA9_0==25) ) {
                    int LA9_6 = input.LA(2);

                    if ( (LA9_6==RULE_ID) ) {
                        int LA9_12 = input.LA(3);

                        if ( (LA9_12==29) ) {
                            int LA9_14 = input.LA(4);

                            if ( (LA9_14==RULE_ID) ) {
                                int LA9_15 = input.LA(5);

                                if ( (LA9_15==14) ) {
                                    switch ( input.LA(6) ) {
                                    case 17:
                                        {
                                        int LA9_20 = input.LA(7);

                                        if ( (LA9_20==RULE_STRING) ) {
                                            int LA9_24 = input.LA(8);

                                            if ( (LA9_24==11) ) {
                                                switch ( input.LA(9) ) {
                                                case 17:
                                                    {
                                                    int LA9_28 = input.LA(10);

                                                    if ( (LA9_28==RULE_STRING) ) {
                                                        int LA9_32 = input.LA(11);

                                                        if ( (LA9_32==11) ) {
                                                            int LA9_34 = input.LA(12);

                                                            if ( (LA9_34==15) ) {
                                                                int LA9_36 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt9=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 18:
                                                    {
                                                    int LA9_29 = input.LA(10);

                                                    if ( (LA9_29==RULE_STRING) ) {
                                                        int LA9_33 = input.LA(11);

                                                        if ( (LA9_33==11) ) {
                                                            int LA9_35 = input.LA(12);

                                                            if ( (LA9_35==15) ) {
                                                                int LA9_37 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt9=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 15:
                                                    {
                                                    int LA9_30 = input.LA(10);

                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                        alt9=1;
                                                    }


                                                    }
                                                    break;

                                                }

                                            }


                                        }


                                        }
                                        break;
                                    case 18:
                                        {
                                        int LA9_21 = input.LA(7);

                                        if ( (LA9_21==RULE_STRING) ) {
                                            int LA9_25 = input.LA(8);

                                            if ( (LA9_25==11) ) {
                                                switch ( input.LA(9) ) {
                                                case 17:
                                                    {
                                                    int LA9_28 = input.LA(10);

                                                    if ( (LA9_28==RULE_STRING) ) {
                                                        int LA9_32 = input.LA(11);

                                                        if ( (LA9_32==11) ) {
                                                            int LA9_34 = input.LA(12);

                                                            if ( (LA9_34==15) ) {
                                                                int LA9_36 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt9=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 18:
                                                    {
                                                    int LA9_29 = input.LA(10);

                                                    if ( (LA9_29==RULE_STRING) ) {
                                                        int LA9_33 = input.LA(11);

                                                        if ( (LA9_33==11) ) {
                                                            int LA9_35 = input.LA(12);

                                                            if ( (LA9_35==15) ) {
                                                                int LA9_37 = input.LA(13);

                                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                    alt9=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                    }
                                                    break;
                                                case 15:
                                                    {
                                                    int LA9_31 = input.LA(10);

                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                        alt9=1;
                                                    }


                                                    }
                                                    break;

                                                }

                                            }


                                        }


                                        }
                                        break;
                                    case 15:
                                        {
                                        int LA9_22 = input.LA(7);

                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                            alt9=1;
                                        }


                                        }
                                        break;

                                    }

                                }
                                else if ( (LA9_15==11) ) {
                                    int LA9_18 = input.LA(6);

                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                        alt9=1;
                                    }


                                }


                            }


                        }
                        else if ( (LA9_12==RULE_ID) ) {
                            int LA9_15 = input.LA(4);

                            if ( (LA9_15==14) ) {
                                switch ( input.LA(5) ) {
                                case 17:
                                    {
                                    int LA9_20 = input.LA(6);

                                    if ( (LA9_20==RULE_STRING) ) {
                                        int LA9_24 = input.LA(7);

                                        if ( (LA9_24==11) ) {
                                            switch ( input.LA(8) ) {
                                            case 17:
                                                {
                                                int LA9_28 = input.LA(9);

                                                if ( (LA9_28==RULE_STRING) ) {
                                                    int LA9_32 = input.LA(10);

                                                    if ( (LA9_32==11) ) {
                                                        int LA9_34 = input.LA(11);

                                                        if ( (LA9_34==15) ) {
                                                            int LA9_36 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt9=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 18:
                                                {
                                                int LA9_29 = input.LA(9);

                                                if ( (LA9_29==RULE_STRING) ) {
                                                    int LA9_33 = input.LA(10);

                                                    if ( (LA9_33==11) ) {
                                                        int LA9_35 = input.LA(11);

                                                        if ( (LA9_35==15) ) {
                                                            int LA9_37 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt9=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 15:
                                                {
                                                int LA9_30 = input.LA(9);

                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                    alt9=1;
                                                }


                                                }
                                                break;

                                            }

                                        }


                                    }


                                    }
                                    break;
                                case 18:
                                    {
                                    int LA9_21 = input.LA(6);

                                    if ( (LA9_21==RULE_STRING) ) {
                                        int LA9_25 = input.LA(7);

                                        if ( (LA9_25==11) ) {
                                            switch ( input.LA(8) ) {
                                            case 17:
                                                {
                                                int LA9_28 = input.LA(9);

                                                if ( (LA9_28==RULE_STRING) ) {
                                                    int LA9_32 = input.LA(10);

                                                    if ( (LA9_32==11) ) {
                                                        int LA9_34 = input.LA(11);

                                                        if ( (LA9_34==15) ) {
                                                            int LA9_36 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt9=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 18:
                                                {
                                                int LA9_29 = input.LA(9);

                                                if ( (LA9_29==RULE_STRING) ) {
                                                    int LA9_33 = input.LA(10);

                                                    if ( (LA9_33==11) ) {
                                                        int LA9_35 = input.LA(11);

                                                        if ( (LA9_35==15) ) {
                                                            int LA9_37 = input.LA(12);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt9=1;
                                                            }


                                                        }


                                                    }


                                                }


                                                }
                                                break;
                                            case 15:
                                                {
                                                int LA9_31 = input.LA(9);

                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                    alt9=1;
                                                }


                                                }
                                                break;

                                            }

                                        }


                                    }


                                    }
                                    break;
                                case 15:
                                    {
                                    int LA9_22 = input.LA(6);

                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                        alt9=1;
                                    }


                                    }
                                    break;

                                }

                            }
                            else if ( (LA9_15==11) ) {
                                int LA9_18 = input.LA(5);

                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                    alt9=1;
                                }


                            }


                        }


                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:928:2: rule__Object__FeaturesAssignment_5_7_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_7_1_in_rule__Object__Group_5_7__11759);
            	    rule__Object__FeaturesAssignment_5_7_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:943:1: rule__Attribute__Group__0 : ( 'Attribute' ) rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:947:1: ( ( 'Attribute' ) rule__Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:948:1: ( 'Attribute' ) rule__Attribute__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:948:1: ( 'Attribute' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:949:1: 'Attribute'
            {
             before(grammarAccess.getAttributeAccess().getAttributeKeyword_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Attribute__Group__01801); 
             after(grammarAccess.getAttributeAccess().getAttributeKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__01811);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:963:1: rule__Attribute__Group__1 : ( ( rule__Attribute__TypeAssignment_1 ) ) rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:967:1: ( ( ( rule__Attribute__TypeAssignment_1 ) ) rule__Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:968:1: ( ( rule__Attribute__TypeAssignment_1 ) ) rule__Attribute__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:968:1: ( ( rule__Attribute__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:969:1: ( rule__Attribute__TypeAssignment_1 )
            {
             before(grammarAccess.getAttributeAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:970:1: ( rule__Attribute__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:970:2: rule__Attribute__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__TypeAssignment_1_in_rule__Attribute__Group__11839);
            rule__Attribute__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__11848);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:981:1: rule__Attribute__Group__2 : ( ( rule__Attribute__NameAssignment_2 ) ) rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:985:1: ( ( ( rule__Attribute__NameAssignment_2 ) ) rule__Attribute__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:986:1: ( ( rule__Attribute__NameAssignment_2 ) ) rule__Attribute__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:986:1: ( ( rule__Attribute__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:987:1: ( rule__Attribute__NameAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:988:1: ( rule__Attribute__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:988:2: rule__Attribute__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__NameAssignment_2_in_rule__Attribute__Group__21876);
            rule__Attribute__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__3_in_rule__Attribute__Group__21885);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:999:1: rule__Attribute__Group__3 : ( ';' ) ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1003:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1004:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1004:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1005:1: ';'
            {
             before(grammarAccess.getAttributeAccess().getSemicolonKeyword_3()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Attribute__Group__31914); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1026:1: rule__Reference__Group__0 : ( 'Reference' ) rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1030:1: ( ( 'Reference' ) rule__Reference__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1031:1: ( 'Reference' ) rule__Reference__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1031:1: ( 'Reference' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1032:1: 'Reference'
            {
             before(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Reference__Group__01958); 
             after(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__01968);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1046:1: rule__Reference__Group__1 : ( ( rule__Reference__TypeAssignment_1 ) ) rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1050:1: ( ( ( rule__Reference__TypeAssignment_1 ) ) rule__Reference__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1051:1: ( ( rule__Reference__TypeAssignment_1 ) ) rule__Reference__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1051:1: ( ( rule__Reference__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1052:1: ( rule__Reference__TypeAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1053:1: ( rule__Reference__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1053:2: rule__Reference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__TypeAssignment_1_in_rule__Reference__Group__11996);
            rule__Reference__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__12005);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1064:1: rule__Reference__Group__2 : ( ( rule__Reference__ManyAssignment_2 )? ) rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1068:1: ( ( ( rule__Reference__ManyAssignment_2 )? ) rule__Reference__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1069:1: ( ( rule__Reference__ManyAssignment_2 )? ) rule__Reference__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1069:1: ( ( rule__Reference__ManyAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1070:1: ( rule__Reference__ManyAssignment_2 )?
            {
             before(grammarAccess.getReferenceAccess().getManyAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1071:1: ( rule__Reference__ManyAssignment_2 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1071:2: rule__Reference__ManyAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__ManyAssignment_2_in_rule__Reference__Group__22033);
                    rule__Reference__ManyAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferenceAccess().getManyAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__22043);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1082:1: rule__Reference__Group__3 : ( ( rule__Reference__NameAssignment_3 ) ) rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1086:1: ( ( ( rule__Reference__NameAssignment_3 ) ) rule__Reference__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1087:1: ( ( rule__Reference__NameAssignment_3 ) ) rule__Reference__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1087:1: ( ( rule__Reference__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1088:1: ( rule__Reference__NameAssignment_3 )
            {
             before(grammarAccess.getReferenceAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1089:1: ( rule__Reference__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1089:2: rule__Reference__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__NameAssignment_3_in_rule__Reference__Group__32071);
            rule__Reference__NameAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getNameAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__32080);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1100:1: rule__Reference__Group__4 : ( ( rule__Reference__Alternatives_4 ) ) ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1104:1: ( ( ( rule__Reference__Alternatives_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1105:1: ( ( rule__Reference__Alternatives_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1105:1: ( ( rule__Reference__Alternatives_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1106:1: ( rule__Reference__Alternatives_4 )
            {
             before(grammarAccess.getReferenceAccess().getAlternatives_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1107:1: ( rule__Reference__Alternatives_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1107:2: rule__Reference__Alternatives_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__42108);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1127:1: rule__Reference__Group_4_0__0 : ( '{' ) rule__Reference__Group_4_0__1 ;
    public final void rule__Reference__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1131:1: ( ( '{' ) rule__Reference__Group_4_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1132:1: ( '{' ) rule__Reference__Group_4_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1132:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1133:1: '{'
            {
             before(grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Reference__Group_4_0__02153); 
             after(grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__02163);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1147:1: rule__Reference__Group_4_0__1 : ( ( rule__Reference__UnorderedGroup_4_0_1 ) ) rule__Reference__Group_4_0__2 ;
    public final void rule__Reference__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1151:1: ( ( ( rule__Reference__UnorderedGroup_4_0_1 ) ) rule__Reference__Group_4_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1152:1: ( ( rule__Reference__UnorderedGroup_4_0_1 ) ) rule__Reference__Group_4_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1152:1: ( ( rule__Reference__UnorderedGroup_4_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1153:1: ( rule__Reference__UnorderedGroup_4_0_1 )
            {
             before(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1154:1: ( rule__Reference__UnorderedGroup_4_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1154:2: rule__Reference__UnorderedGroup_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__UnorderedGroup_4_0_1_in_rule__Reference__Group_4_0__12191);
            rule__Reference__UnorderedGroup_4_0_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0__2_in_rule__Reference__Group_4_0__12200);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1165:1: rule__Reference__Group_4_0__2 : ( '}' ) ;
    public final void rule__Reference__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1169:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1170:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1170:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1171:1: '}'
            {
             before(grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Reference__Group_4_0__22229); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1190:1: rule__Reference__Group_4_0_1_0__0 : ( 'shortDescription' ) rule__Reference__Group_4_0_1_0__1 ;
    public final void rule__Reference__Group_4_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1194:1: ( ( 'shortDescription' ) rule__Reference__Group_4_0_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1195:1: ( 'shortDescription' ) rule__Reference__Group_4_0_1_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1195:1: ( 'shortDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1196:1: 'shortDescription'
            {
             before(grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Reference__Group_4_0_1_0__02271); 
             after(grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_0__1_in_rule__Reference__Group_4_0_1_0__02281);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1210:1: rule__Reference__Group_4_0_1_0__1 : ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) ) rule__Reference__Group_4_0_1_0__2 ;
    public final void rule__Reference__Group_4_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1214:1: ( ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) ) rule__Reference__Group_4_0_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1215:1: ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) ) rule__Reference__Group_4_0_1_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1215:1: ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1216:1: ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 )
            {
             before(grammarAccess.getReferenceAccess().getShortDescriptionAssignment_4_0_1_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1217:1: ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1217:2: rule__Reference__ShortDescriptionAssignment_4_0_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__ShortDescriptionAssignment_4_0_1_0_1_in_rule__Reference__Group_4_0_1_0__12309);
            rule__Reference__ShortDescriptionAssignment_4_0_1_0_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getShortDescriptionAssignment_4_0_1_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_0__2_in_rule__Reference__Group_4_0_1_0__12318);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1228:1: rule__Reference__Group_4_0_1_0__2 : ( ';' ) ;
    public final void rule__Reference__Group_4_0_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1232:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1233:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1233:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1234:1: ';'
            {
             before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Reference__Group_4_0_1_0__22347); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1253:1: rule__Reference__Group_4_0_1_1__0 : ( 'longDescription' ) rule__Reference__Group_4_0_1_1__1 ;
    public final void rule__Reference__Group_4_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1257:1: ( ( 'longDescription' ) rule__Reference__Group_4_0_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1258:1: ( 'longDescription' ) rule__Reference__Group_4_0_1_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1258:1: ( 'longDescription' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1259:1: 'longDescription'
            {
             before(grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Reference__Group_4_0_1_1__02389); 
             after(grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_1__1_in_rule__Reference__Group_4_0_1_1__02399);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1273:1: rule__Reference__Group_4_0_1_1__1 : ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) ) rule__Reference__Group_4_0_1_1__2 ;
    public final void rule__Reference__Group_4_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1277:1: ( ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) ) rule__Reference__Group_4_0_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1278:1: ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) ) rule__Reference__Group_4_0_1_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1278:1: ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1279:1: ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 )
            {
             before(grammarAccess.getReferenceAccess().getLongDescriptionAssignment_4_0_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1280:1: ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1280:2: rule__Reference__LongDescriptionAssignment_4_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__LongDescriptionAssignment_4_0_1_1_1_in_rule__Reference__Group_4_0_1_1__12427);
            rule__Reference__LongDescriptionAssignment_4_0_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getLongDescriptionAssignment_4_0_1_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_1__2_in_rule__Reference__Group_4_0_1_1__12436);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1291:1: rule__Reference__Group_4_0_1_1__2 : ( ';' ) ;
    public final void rule__Reference__Group_4_0_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1295:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1296:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1296:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1297:1: ';'
            {
             before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Reference__Group_4_0_1_1__22465); 
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


    // $ANTLR start rule__Object__UnorderedGroup_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1317:1: rule__Object__UnorderedGroup_5 : ( rule__Object__UnorderedGroup_5__0 )? ;
    public final void rule__Object__UnorderedGroup_5() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1322:1: ( ( rule__Object__UnorderedGroup_5__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1323:2: ( rule__Object__UnorderedGroup_5__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1323:2: ( rule__Object__UnorderedGroup_5__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt11=1;
            }
            else if ( (LA11_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt11=1;
            }
            else if ( (LA11_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt11=1;
            }
            else if ( (LA11_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt11=1;
            }
            else if ( ((LA11_0>=24 && LA11_0<=25)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt11=1;
            }
            else if ( (LA11_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt11=1;
            }
            else if ( (LA11_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt11=1;
            }
            else if ( (LA11_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1323:2: rule__Object__UnorderedGroup_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__0_in_rule__Object__UnorderedGroup_52503);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1333:1: rule__Object__UnorderedGroup_5__Impl : ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) ) ;
    public final void rule__Object__UnorderedGroup_5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1337:1: ( ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1338:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1338:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )
            int alt13=8;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt13=1;
            }
            else if ( (LA13_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt13=2;
            }
            else if ( (LA13_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt13=3;
            }
            else if ( (LA13_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt13=4;
            }
            else if ( ((LA13_0>=24 && LA13_0<=25)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt13=5;
            }
            else if ( (LA13_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt13=6;
            }
            else if ( (LA13_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt13=7;
            }
            else if ( (LA13_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt13=8;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1338:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1340:4: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1340:4: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1341:5: {...}? => ( ( ( rule__Object__Group_5_0__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1341:103: ( ( ( rule__Object__Group_5_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1342:6: ( ( rule__Object__Group_5_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1345:6: ( ( rule__Object__Group_5_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1348:7: ( rule__Object__Group_5_0__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1349:7: ( rule__Object__Group_5_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1349:8: rule__Object__Group_5_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_0__0_in_rule__Object__UnorderedGroup_5__Impl2588);
                    rule__Object__Group_5_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_0()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
                    	 				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1358:4: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1358:4: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1359:5: {...}? => ( ( ( rule__Object__Group_5_1__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1359:103: ( ( ( rule__Object__Group_5_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1360:6: ( ( rule__Object__Group_5_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1363:6: ( ( rule__Object__Group_5_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1366:7: ( rule__Object__Group_5_1__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1367:7: ( rule__Object__Group_5_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1367:8: rule__Object__Group_5_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_1__0_in_rule__Object__UnorderedGroup_5__Impl2684);
                    rule__Object__Group_5_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_1()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
                    	 				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1376:4: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1376:4: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1377:5: {...}? => ( ( ( rule__Object__Group_5_2__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1377:103: ( ( ( rule__Object__Group_5_2__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1378:6: ( ( rule__Object__Group_5_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1381:6: ( ( rule__Object__Group_5_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1384:7: ( rule__Object__Group_5_2__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1385:7: ( rule__Object__Group_5_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1385:8: rule__Object__Group_5_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_2__0_in_rule__Object__UnorderedGroup_5__Impl2780);
                    rule__Object__Group_5_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_2()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
                    	 				

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1394:4: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1394:4: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1395:5: {...}? => ( ( ( rule__Object__Group_5_3__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1395:103: ( ( ( rule__Object__Group_5_3__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1396:6: ( ( rule__Object__Group_5_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1399:6: ( ( rule__Object__Group_5_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1402:7: ( rule__Object__Group_5_3__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1403:7: ( rule__Object__Group_5_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1403:8: rule__Object__Group_5_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_3__0_in_rule__Object__UnorderedGroup_5__Impl2876);
                    rule__Object__Group_5_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_3()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
                    	 				

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1412:4: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1412:4: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1413:5: {...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1413:103: ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1414:6: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1417:6: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1419:6: ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( rule__Object__FeaturesAssignment_5_4 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1419:6: ( ( rule__Object__FeaturesAssignment_5_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1420:7: ( rule__Object__FeaturesAssignment_5_4 )
                    {
                     before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1421:7: ( rule__Object__FeaturesAssignment_5_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1421:8: rule__Object__FeaturesAssignment_5_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_4_in_rule__Object__UnorderedGroup_5__Impl2973);
                    rule__Object__FeaturesAssignment_5_4();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1424:6: ( ( rule__Object__FeaturesAssignment_5_4 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1425:7: ( rule__Object__FeaturesAssignment_5_4 )*
                    {
                     before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1426:7: ( rule__Object__FeaturesAssignment_5_4 )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==24) ) {
                            int LA12_5 = input.LA(2);

                            if ( (LA12_5==RULE_ID) ) {
                                int LA12_11 = input.LA(3);

                                if ( (LA12_11==RULE_ID) ) {
                                    int LA12_13 = input.LA(4);

                                    if ( (LA12_13==11) ) {
                                        int LA12_16 = input.LA(5);

                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                            alt12=1;
                                        }


                                    }


                                }


                            }


                        }
                        else if ( (LA12_0==25) ) {
                            int LA12_6 = input.LA(2);

                            if ( (LA12_6==RULE_ID) ) {
                                int LA12_12 = input.LA(3);

                                if ( (LA12_12==29) ) {
                                    int LA12_14 = input.LA(4);

                                    if ( (LA12_14==RULE_ID) ) {
                                        int LA12_15 = input.LA(5);

                                        if ( (LA12_15==14) ) {
                                            switch ( input.LA(6) ) {
                                            case 17:
                                                {
                                                int LA12_20 = input.LA(7);

                                                if ( (LA12_20==RULE_STRING) ) {
                                                    int LA12_24 = input.LA(8);

                                                    if ( (LA12_24==11) ) {
                                                        switch ( input.LA(9) ) {
                                                        case 17:
                                                            {
                                                            int LA12_28 = input.LA(10);

                                                            if ( (LA12_28==RULE_STRING) ) {
                                                                int LA12_32 = input.LA(11);

                                                                if ( (LA12_32==11) ) {
                                                                    int LA12_34 = input.LA(12);

                                                                    if ( (LA12_34==15) ) {
                                                                        int LA12_36 = input.LA(13);

                                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                            alt12=1;
                                                                        }


                                                                    }


                                                                }


                                                            }


                                                            }
                                                            break;
                                                        case 18:
                                                            {
                                                            int LA12_29 = input.LA(10);

                                                            if ( (LA12_29==RULE_STRING) ) {
                                                                int LA12_33 = input.LA(11);

                                                                if ( (LA12_33==11) ) {
                                                                    int LA12_35 = input.LA(12);

                                                                    if ( (LA12_35==15) ) {
                                                                        int LA12_37 = input.LA(13);

                                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                            alt12=1;
                                                                        }


                                                                    }


                                                                }


                                                            }


                                                            }
                                                            break;
                                                        case 15:
                                                            {
                                                            int LA12_30 = input.LA(10);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt12=1;
                                                            }


                                                            }
                                                            break;

                                                        }

                                                    }


                                                }


                                                }
                                                break;
                                            case 18:
                                                {
                                                int LA12_21 = input.LA(7);

                                                if ( (LA12_21==RULE_STRING) ) {
                                                    int LA12_25 = input.LA(8);

                                                    if ( (LA12_25==11) ) {
                                                        switch ( input.LA(9) ) {
                                                        case 17:
                                                            {
                                                            int LA12_28 = input.LA(10);

                                                            if ( (LA12_28==RULE_STRING) ) {
                                                                int LA12_32 = input.LA(11);

                                                                if ( (LA12_32==11) ) {
                                                                    int LA12_34 = input.LA(12);

                                                                    if ( (LA12_34==15) ) {
                                                                        int LA12_36 = input.LA(13);

                                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                            alt12=1;
                                                                        }


                                                                    }


                                                                }


                                                            }


                                                            }
                                                            break;
                                                        case 18:
                                                            {
                                                            int LA12_29 = input.LA(10);

                                                            if ( (LA12_29==RULE_STRING) ) {
                                                                int LA12_33 = input.LA(11);

                                                                if ( (LA12_33==11) ) {
                                                                    int LA12_35 = input.LA(12);

                                                                    if ( (LA12_35==15) ) {
                                                                        int LA12_37 = input.LA(13);

                                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                            alt12=1;
                                                                        }


                                                                    }


                                                                }


                                                            }


                                                            }
                                                            break;
                                                        case 15:
                                                            {
                                                            int LA12_31 = input.LA(10);

                                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                alt12=1;
                                                            }


                                                            }
                                                            break;

                                                        }

                                                    }


                                                }


                                                }
                                                break;
                                            case 15:
                                                {
                                                int LA12_22 = input.LA(7);

                                                if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                    alt12=1;
                                                }


                                                }
                                                break;

                                            }

                                        }
                                        else if ( (LA12_15==11) ) {
                                            int LA12_18 = input.LA(6);

                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                alt12=1;
                                            }


                                        }


                                    }


                                }
                                else if ( (LA12_12==RULE_ID) ) {
                                    int LA12_15 = input.LA(4);

                                    if ( (LA12_15==14) ) {
                                        switch ( input.LA(5) ) {
                                        case 17:
                                            {
                                            int LA12_20 = input.LA(6);

                                            if ( (LA12_20==RULE_STRING) ) {
                                                int LA12_24 = input.LA(7);

                                                if ( (LA12_24==11) ) {
                                                    switch ( input.LA(8) ) {
                                                    case 17:
                                                        {
                                                        int LA12_28 = input.LA(9);

                                                        if ( (LA12_28==RULE_STRING) ) {
                                                            int LA12_32 = input.LA(10);

                                                            if ( (LA12_32==11) ) {
                                                                int LA12_34 = input.LA(11);

                                                                if ( (LA12_34==15) ) {
                                                                    int LA12_36 = input.LA(12);

                                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                        alt12=1;
                                                                    }


                                                                }


                                                            }


                                                        }


                                                        }
                                                        break;
                                                    case 18:
                                                        {
                                                        int LA12_29 = input.LA(9);

                                                        if ( (LA12_29==RULE_STRING) ) {
                                                            int LA12_33 = input.LA(10);

                                                            if ( (LA12_33==11) ) {
                                                                int LA12_35 = input.LA(11);

                                                                if ( (LA12_35==15) ) {
                                                                    int LA12_37 = input.LA(12);

                                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                        alt12=1;
                                                                    }


                                                                }


                                                            }


                                                        }


                                                        }
                                                        break;
                                                    case 15:
                                                        {
                                                        int LA12_30 = input.LA(9);

                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                            alt12=1;
                                                        }


                                                        }
                                                        break;

                                                    }

                                                }


                                            }


                                            }
                                            break;
                                        case 18:
                                            {
                                            int LA12_21 = input.LA(6);

                                            if ( (LA12_21==RULE_STRING) ) {
                                                int LA12_25 = input.LA(7);

                                                if ( (LA12_25==11) ) {
                                                    switch ( input.LA(8) ) {
                                                    case 17:
                                                        {
                                                        int LA12_28 = input.LA(9);

                                                        if ( (LA12_28==RULE_STRING) ) {
                                                            int LA12_32 = input.LA(10);

                                                            if ( (LA12_32==11) ) {
                                                                int LA12_34 = input.LA(11);

                                                                if ( (LA12_34==15) ) {
                                                                    int LA12_36 = input.LA(12);

                                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                        alt12=1;
                                                                    }


                                                                }


                                                            }


                                                        }


                                                        }
                                                        break;
                                                    case 18:
                                                        {
                                                        int LA12_29 = input.LA(9);

                                                        if ( (LA12_29==RULE_STRING) ) {
                                                            int LA12_33 = input.LA(10);

                                                            if ( (LA12_33==11) ) {
                                                                int LA12_35 = input.LA(11);

                                                                if ( (LA12_35==15) ) {
                                                                    int LA12_37 = input.LA(12);

                                                                    if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                                        alt12=1;
                                                                    }


                                                                }


                                                            }


                                                        }


                                                        }
                                                        break;
                                                    case 15:
                                                        {
                                                        int LA12_31 = input.LA(9);

                                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                            alt12=1;
                                                        }


                                                        }
                                                        break;

                                                    }

                                                }


                                            }


                                            }
                                            break;
                                        case 15:
                                            {
                                            int LA12_22 = input.LA(6);

                                            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                                alt12=1;
                                            }


                                            }
                                            break;

                                        }

                                    }
                                    else if ( (LA12_15==11) ) {
                                        int LA12_18 = input.LA(5);

                                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
                                            alt12=1;
                                        }


                                    }


                                }


                            }


                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1426:8: rule__Object__FeaturesAssignment_5_4
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__Object__FeaturesAssignment_5_4_in_rule__Object__UnorderedGroup_5__Impl3013);
                    	    rule__Object__FeaturesAssignment_5_4();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                     after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 

                    }


                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
                    	 				

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1435:4: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1435:4: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1436:5: {...}? => ( ( ( rule__Object__Group_5_5__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1436:103: ( ( ( rule__Object__Group_5_5__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1437:6: ( ( rule__Object__Group_5_5__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1440:6: ( ( rule__Object__Group_5_5__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1443:7: ( rule__Object__Group_5_5__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_5()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1444:7: ( rule__Object__Group_5_5__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1444:8: rule__Object__Group_5_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_5__0_in_rule__Object__UnorderedGroup_5__Impl3116);
                    rule__Object__Group_5_5__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_5()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
                    	 				

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1453:4: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1453:4: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1454:5: {...}? => ( ( ( rule__Object__Group_5_6__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1454:103: ( ( ( rule__Object__Group_5_6__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1455:6: ( ( rule__Object__Group_5_6__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1458:6: ( ( rule__Object__Group_5_6__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1461:7: ( rule__Object__Group_5_6__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_6()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1462:7: ( rule__Object__Group_5_6__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1462:8: rule__Object__Group_5_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_6__0_in_rule__Object__UnorderedGroup_5__Impl3212);
                    rule__Object__Group_5_6__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_6()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
                    	 				

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1471:4: ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1471:4: ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1472:5: {...}? => ( ( ( rule__Object__Group_5_7__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)) ) {
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1472:103: ( ( ( rule__Object__Group_5_7__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1473:6: ( ( rule__Object__Group_5_7__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7);
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1476:6: ( ( rule__Object__Group_5_7__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1479:7: ( rule__Object__Group_5_7__0 )
                    {
                     before(grammarAccess.getObjectAccess().getGroup_5_7()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1480:7: ( rule__Object__Group_5_7__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1480:8: rule__Object__Group_5_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__Group_5_7__0_in_rule__Object__UnorderedGroup_5__Impl3308);
                    rule__Object__Group_5_7__0();
                    _fsp--;


                    }

                     after(grammarAccess.getObjectAccess().getGroup_5_7()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
                    	 				

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Object__UnorderedGroup_5__Impl


    // $ANTLR start rule__Object__UnorderedGroup_5__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1496:1: rule__Object__UnorderedGroup_5__0 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )? ;
    public final void rule__Object__UnorderedGroup_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1500:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1501:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__03374);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1502:2: ( rule__Object__UnorderedGroup_5__1 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt14=1;
            }
            else if ( (LA14_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt14=1;
            }
            else if ( (LA14_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt14=1;
            }
            else if ( (LA14_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt14=1;
            }
            else if ( ((LA14_0>=24 && LA14_0<=25)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt14=1;
            }
            else if ( (LA14_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt14=1;
            }
            else if ( (LA14_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt14=1;
            }
            else if ( (LA14_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1502:2: rule__Object__UnorderedGroup_5__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__1_in_rule__Object__UnorderedGroup_5__03377);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1509:1: rule__Object__UnorderedGroup_5__1 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )? ;
    public final void rule__Object__UnorderedGroup_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1513:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1514:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__13402);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1515:2: ( rule__Object__UnorderedGroup_5__2 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt15=1;
            }
            else if ( (LA15_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt15=1;
            }
            else if ( (LA15_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt15=1;
            }
            else if ( (LA15_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt15=1;
            }
            else if ( ((LA15_0>=24 && LA15_0<=25)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt15=1;
            }
            else if ( (LA15_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt15=1;
            }
            else if ( (LA15_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt15=1;
            }
            else if ( (LA15_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1515:2: rule__Object__UnorderedGroup_5__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__2_in_rule__Object__UnorderedGroup_5__13405);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1522:1: rule__Object__UnorderedGroup_5__2 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )? ;
    public final void rule__Object__UnorderedGroup_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1526:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1527:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__23430);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1528:2: ( rule__Object__UnorderedGroup_5__3 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt16=1;
            }
            else if ( (LA16_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt16=1;
            }
            else if ( (LA16_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt16=1;
            }
            else if ( (LA16_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt16=1;
            }
            else if ( ((LA16_0>=24 && LA16_0<=25)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt16=1;
            }
            else if ( (LA16_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt16=1;
            }
            else if ( (LA16_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt16=1;
            }
            else if ( (LA16_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1528:2: rule__Object__UnorderedGroup_5__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__3_in_rule__Object__UnorderedGroup_5__23433);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1535:1: rule__Object__UnorderedGroup_5__3 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )? ;
    public final void rule__Object__UnorderedGroup_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1539:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1540:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__33458);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1541:2: ( rule__Object__UnorderedGroup_5__4 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt17=1;
            }
            else if ( (LA17_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt17=1;
            }
            else if ( (LA17_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt17=1;
            }
            else if ( (LA17_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt17=1;
            }
            else if ( ((LA17_0>=24 && LA17_0<=25)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt17=1;
            }
            else if ( (LA17_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt17=1;
            }
            else if ( (LA17_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt17=1;
            }
            else if ( (LA17_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1541:2: rule__Object__UnorderedGroup_5__4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__4_in_rule__Object__UnorderedGroup_5__33461);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1548:1: rule__Object__UnorderedGroup_5__4 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )? ;
    public final void rule__Object__UnorderedGroup_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1552:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1553:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__43486);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1554:2: ( rule__Object__UnorderedGroup_5__5 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt18=1;
            }
            else if ( (LA18_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt18=1;
            }
            else if ( (LA18_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt18=1;
            }
            else if ( (LA18_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt18=1;
            }
            else if ( ((LA18_0>=24 && LA18_0<=25)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt18=1;
            }
            else if ( (LA18_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt18=1;
            }
            else if ( (LA18_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt18=1;
            }
            else if ( (LA18_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1554:2: rule__Object__UnorderedGroup_5__5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__5_in_rule__Object__UnorderedGroup_5__43489);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1561:1: rule__Object__UnorderedGroup_5__5 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )? ;
    public final void rule__Object__UnorderedGroup_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1565:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1566:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__53514);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1567:2: ( rule__Object__UnorderedGroup_5__6 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt19=1;
            }
            else if ( (LA19_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt19=1;
            }
            else if ( (LA19_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt19=1;
            }
            else if ( (LA19_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt19=1;
            }
            else if ( ((LA19_0>=24 && LA19_0<=25)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt19=1;
            }
            else if ( (LA19_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt19=1;
            }
            else if ( (LA19_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt19=1;
            }
            else if ( (LA19_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1567:2: rule__Object__UnorderedGroup_5__6
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__6_in_rule__Object__UnorderedGroup_5__53517);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1574:1: rule__Object__UnorderedGroup_5__6 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )? ;
    public final void rule__Object__UnorderedGroup_5__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1578:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1579:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__63542);
            rule__Object__UnorderedGroup_5__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1580:2: ( rule__Object__UnorderedGroup_5__7 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                alt20=1;
            }
            else if ( (LA20_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                alt20=1;
            }
            else if ( (LA20_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                alt20=1;
            }
            else if ( (LA20_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                alt20=1;
            }
            else if ( ((LA20_0>=24 && LA20_0<=25)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                alt20=1;
            }
            else if ( (LA20_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                alt20=1;
            }
            else if ( (LA20_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                alt20=1;
            }
            else if ( (LA20_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1580:2: rule__Object__UnorderedGroup_5__7
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__7_in_rule__Object__UnorderedGroup_5__63545);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1587:1: rule__Object__UnorderedGroup_5__7 : rule__Object__UnorderedGroup_5__Impl ;
    public final void rule__Object__UnorderedGroup_5__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1591:1: ( rule__Object__UnorderedGroup_5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1592:2: rule__Object__UnorderedGroup_5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__73570);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1615:1: rule__Reference__UnorderedGroup_4_0_1 : ( rule__Reference__UnorderedGroup_4_0_1__0 )? ;
    public final void rule__Reference__UnorderedGroup_4_0_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1620:1: ( ( rule__Reference__UnorderedGroup_4_0_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1621:2: ( rule__Reference__UnorderedGroup_4_0_1__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1621:2: ( rule__Reference__UnorderedGroup_4_0_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0))) {
                alt21=1;
            }
            else if ( (LA21_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1))) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1621:2: rule__Reference__UnorderedGroup_4_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__UnorderedGroup_4_0_1__0_in_rule__Reference__UnorderedGroup_4_0_13610);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1631:1: rule__Reference__UnorderedGroup_4_0_1__Impl : ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) ) ;
    public final void rule__Reference__UnorderedGroup_4_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1635:1: ( ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1636:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1636:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0))) {
                alt22=1;
            }
            else if ( (LA22_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1))) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1636:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1638:4: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1638:4: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1639:5: {...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)) ) {
                        throw new FailedPredicateException(input, "rule__Reference__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1639:110: ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1640:6: ( ( rule__Reference__Group_4_0_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1643:6: ( ( rule__Reference__Group_4_0_1_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1646:7: ( rule__Reference__Group_4_0_1_0__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_0_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1647:7: ( rule__Reference__Group_4_0_1_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1647:8: rule__Reference__Group_4_0_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_0__0_in_rule__Reference__UnorderedGroup_4_0_1__Impl3695);
                    rule__Reference__Group_4_0_1_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_0_1_0()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    	 				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1656:4: ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1656:4: ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1657:5: {...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) )
                    {
                    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)) ) {
                        throw new FailedPredicateException(input, "rule__Reference__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1657:110: ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1658:6: ( ( rule__Reference__Group_4_0_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1);
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1661:6: ( ( rule__Reference__Group_4_0_1_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1664:7: ( rule__Reference__Group_4_0_1_1__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_0_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1665:7: ( rule__Reference__Group_4_0_1_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1665:8: rule__Reference__Group_4_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__Group_4_0_1_1__0_in_rule__Reference__UnorderedGroup_4_0_1__Impl3791);
                    rule__Reference__Group_4_0_1_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_0_1_1()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    	 				

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__UnorderedGroup_4_0_1__Impl


    // $ANTLR start rule__Reference__UnorderedGroup_4_0_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1681:1: rule__Reference__UnorderedGroup_4_0_1__0 : rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )? ;
    public final void rule__Reference__UnorderedGroup_4_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1685:1: ( rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1686:2: rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__UnorderedGroup_4_0_1__Impl_in_rule__Reference__UnorderedGroup_4_0_1__03857);
            rule__Reference__UnorderedGroup_4_0_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1687:2: ( rule__Reference__UnorderedGroup_4_0_1__1 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0))) {
                alt23=1;
            }
            else if ( (LA23_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1))) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1687:2: rule__Reference__UnorderedGroup_4_0_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Reference__UnorderedGroup_4_0_1__1_in_rule__Reference__UnorderedGroup_4_0_1__03860);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1694:1: rule__Reference__UnorderedGroup_4_0_1__1 : rule__Reference__UnorderedGroup_4_0_1__Impl ;
    public final void rule__Reference__UnorderedGroup_4_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1698:1: ( rule__Reference__UnorderedGroup_4_0_1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1699:2: rule__Reference__UnorderedGroup_4_0_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__UnorderedGroup_4_0_1__Impl_in_rule__Reference__UnorderedGroup_4_0_1__13885);
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


    // $ANTLR start rule__PackageDefinition__NamespaceAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1710:1: rule__PackageDefinition__NamespaceAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageDefinition__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1714:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1715:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1715:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1716:1: RULE_ID
            {
             before(grammarAccess.getPackageDefinitionAccess().getNamespaceIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__PackageDefinition__NamespaceAssignment_23917); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1725:1: rule__PackageDefinition__ContentsAssignment_4 : ( ruleObject ) ;
    public final void rule__PackageDefinition__ContentsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1729:1: ( ( ruleObject ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1730:1: ( ruleObject )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1730:1: ( ruleObject )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1731:1: ruleObject
            {
             before(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleObject_in_rule__PackageDefinition__ContentsAssignment_43948);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1740:1: rule__Object__EnabledAssignment_0_0 : ( ( 'enabled' ) ) ;
    public final void rule__Object__EnabledAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1744:1: ( ( ( 'enabled' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1745:1: ( ( 'enabled' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1745:1: ( ( 'enabled' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1746:1: ( 'enabled' )
            {
             before(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1747:1: ( 'enabled' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1748:1: 'enabled'
            {
             before(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Object__EnabledAssignment_0_03984); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1763:1: rule__Object__AbstractAssignment_0_1 : ( ( 'abstract' ) ) ;
    public final void rule__Object__AbstractAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1767:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1768:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1768:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1769:1: ( 'abstract' )
            {
             before(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1770:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1771:1: 'abstract'
            {
             before(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Object__AbstractAssignment_0_14028); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1786:1: rule__Object__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Object__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1790:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1791:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1791:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1792:1: RULE_ID
            {
             before(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Object__NameAssignment_24067); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1801:1: rule__Object__ParentAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Object__ParentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1805:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1806:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1806:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1807:1: ( RULE_ID )
            {
             before(grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1808:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1809:1: RULE_ID
            {
             before(grammarAccess.getObjectAccess().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Object__ParentAssignment_3_14102); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1820:1: rule__Object__ShortDescriptionAssignment_5_0_1 : ( RULE_STRING ) ;
    public final void rule__Object__ShortDescriptionAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1824:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1825:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1825:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1826:1: RULE_STRING
            {
             before(grammarAccess.getObjectAccess().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Object__ShortDescriptionAssignment_5_0_14137); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1835:1: rule__Object__LongDescriptionAssignment_5_1_1 : ( RULE_STRING ) ;
    public final void rule__Object__LongDescriptionAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1839:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1840:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1840:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1841:1: RULE_STRING
            {
             before(grammarAccess.getObjectAccess().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Object__LongDescriptionAssignment_5_1_14168); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1850:1: rule__Object__SerialVersionUIDAssignment_5_2_1 : ( RULE_INT ) ;
    public final void rule__Object__SerialVersionUIDAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1854:1: ( ( RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1855:1: ( RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1855:1: ( RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1856:1: RULE_INT
            {
             before(grammarAccess.getObjectAccess().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Object__SerialVersionUIDAssignment_5_2_14199); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1865:1: rule__Object__CloneableAssignment_5_3_0 : ( ( 'cloneable' ) ) ;
    public final void rule__Object__CloneableAssignment_5_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1869:1: ( ( ( 'cloneable' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1870:1: ( ( 'cloneable' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1870:1: ( ( 'cloneable' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1871:1: ( 'cloneable' )
            {
             before(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1872:1: ( 'cloneable' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1873:1: 'cloneable'
            {
             before(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__Object__CloneableAssignment_5_3_04235); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1888:1: rule__Object__FeaturesAssignment_5_4 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1892:1: ( ( ruleFeature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1893:1: ( ruleFeature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1893:1: ( ruleFeature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1894:1: ruleFeature
            {
             before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_44274);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1903:1: rule__Object__FeaturesAssignment_5_5_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1907:1: ( ( ruleFeature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1908:1: ( ruleFeature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1908:1: ( ruleFeature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1909:1: ruleFeature
            {
             before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_5_14305);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1918:1: rule__Object__FeaturesAssignment_5_6_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1922:1: ( ( ruleFeature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1923:1: ( ruleFeature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1923:1: ( ruleFeature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1924:1: ruleFeature
            {
             before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_6_14336);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1933:1: rule__Object__FeaturesAssignment_5_7_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1937:1: ( ( ruleFeature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1938:1: ( ruleFeature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1938:1: ( ruleFeature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1939:1: ruleFeature
            {
             before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_7_14367);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1948:1: rule__Attribute__TypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1952:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1953:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1953:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1954:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getTypeIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__TypeAssignment_14398); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1963:1: rule__Attribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1967:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1968:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1968:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1969:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_24429); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1978:1: rule__Reference__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1982:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1983:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1983:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1984:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1985:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1986:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Reference__TypeAssignment_14464); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:1997:1: rule__Reference__ManyAssignment_2 : ( ( '*' ) ) ;
    public final void rule__Reference__ManyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2001:1: ( ( ( '*' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2002:1: ( ( '*' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2002:1: ( ( '*' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2003:1: ( '*' )
            {
             before(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2004:1: ( '*' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2005:1: '*'
            {
             before(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__Reference__ManyAssignment_24504); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2020:1: rule__Reference__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Reference__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2024:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2025:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2025:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2026:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_34543); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2035:1: rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Reference__ShortDescriptionAssignment_4_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2039:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2040:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2040:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2041:1: RULE_STRING
            {
             before(grammarAccess.getReferenceAccess().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Reference__ShortDescriptionAssignment_4_0_1_0_14574); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2050:1: rule__Reference__LongDescriptionAssignment_4_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Reference__LongDescriptionAssignment_4_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2054:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2055:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2055:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug304681TestLanguage.g:2056:1: RULE_STRING
            {
             before(grammarAccess.getReferenceAccess().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Reference__LongDescriptionAssignment_4_0_1_1_14605); 
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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition__Group__0_in_rulePackageDefinition94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObject_in_entryRuleObject121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObject128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group__0_in_ruleObject154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Feature__Alternatives_in_ruleFeature214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__EnabledAssignment_0_0_in_rule__Object__Alternatives_0370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__AbstractAssignment_0_1_in_rule__Object__Alternatives_0388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__Feature__Alternatives421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_rule__Feature__Alternatives438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_4470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Reference__Alternatives_4489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__0535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__PackageDefinition__Group__1564 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__1574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition__NamespaceAssignment_2_in_rule__PackageDefinition__Group__2602 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__2611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__PackageDefinition__Group__3640 = new BitSet(new long[]{0x000000000C002002L});
        public static final BitSet FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__3650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PackageDefinition__ContentsAssignment_4_in_rule__PackageDefinition__Group__4678 = new BitSet(new long[]{0x000000000C002002L});
        public static final BitSet FOLLOW_rule__Object__Alternatives_0_in_rule__Object__Group__0723 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Object__Group__1_in_rule__Object__Group__0733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Object__Group__1762 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Object__Group__2_in_rule__Object__Group__1772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__NameAssignment_2_in_rule__Object__Group__2800 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_rule__Object__Group__3_in_rule__Object__Group__2809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_3__0_in_rule__Object__Group__3837 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Object__Group__4_in_rule__Object__Group__3847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Object__Group__4876 = new BitSet(new long[]{0x0000000013DE8000L});
        public static final BitSet FOLLOW_rule__Object__Group__5_in_rule__Object__Group__4886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5_in_rule__Object__Group__5914 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Object__Group__6_in_rule__Object__Group__5923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Object__Group__6952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Object__Group_3__01002 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Object__Group_3__1_in_rule__Object__Group_3__01012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__ParentAssignment_3_1_in_rule__Object__Group_3__11040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Object__Group_5_0__01079 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Object__Group_5_0__1_in_rule__Object__Group_5_0__01089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__ShortDescriptionAssignment_5_0_1_in_rule__Object__Group_5_0__11117 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object__Group_5_0__2_in_rule__Object__Group_5_0__11126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object__Group_5_0__21155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Object__Group_5_1__01197 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Object__Group_5_1__1_in_rule__Object__Group_5_1__01207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__LongDescriptionAssignment_5_1_1_in_rule__Object__Group_5_1__11235 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object__Group_5_1__2_in_rule__Object__Group_5_1__11244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object__Group_5_1__21273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Object__Group_5_2__01315 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Object__Group_5_2__1_in_rule__Object__Group_5_2__01325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__SerialVersionUIDAssignment_5_2_1_in_rule__Object__Group_5_2__11353 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object__Group_5_2__2_in_rule__Object__Group_5_2__11362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object__Group_5_2__21391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__CloneableAssignment_5_3_0_in_rule__Object__Group_5_3__01432 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Object__Group_5_3__1_in_rule__Object__Group_5_3__01441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Object__Group_5_3__11470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Object__Group_5_5__01510 = new BitSet(new long[]{0x0000000003200000L});
        public static final BitSet FOLLOW_rule__Object__Group_5_5__1_in_rule__Object__Group_5_5__01520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_5_1_in_rule__Object__Group_5_5__11548 = new BitSet(new long[]{0x0000000003200000L});
        public static final BitSet FOLLOW_rule__Object__Group_5_5__2_in_rule__Object__Group_5_5__11558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Object__Group_5_5__21587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Object__Group_5_6__01629 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_6__1_in_rule__Object__Group_5_6__01639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_6_1_in_rule__Object__Group_5_6__11667 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_23_in_rule__Object__Group_5_7__01707 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_rule__Object__Group_5_7__1_in_rule__Object__Group_5_7__01717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_7_1_in_rule__Object__Group_5_7__11747 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_7_1_in_rule__Object__Group_5_7__11759 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_24_in_rule__Attribute__Group__01801 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__01811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__TypeAssignment_1_in_rule__Attribute__Group__11839 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__11848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__NameAssignment_2_in_rule__Attribute__Group__21876 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Attribute__Group__3_in_rule__Attribute__Group__21885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Attribute__Group__31914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Reference__Group__01958 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__01968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__TypeAssignment_1_in_rule__Reference__Group__11996 = new BitSet(new long[]{0x0000000020000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__12005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__ManyAssignment_2_in_rule__Reference__Group__22033 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__22043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__NameAssignment_3_in_rule__Reference__Group__32071 = new BitSet(new long[]{0x0000000000004800L});
        public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__32080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__42108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Reference__Group_4_0__02153 = new BitSet(new long[]{0x0000000000068000L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__02163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__UnorderedGroup_4_0_1_in_rule__Reference__Group_4_0__12191 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0__2_in_rule__Reference__Group_4_0__12200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Reference__Group_4_0__22229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Reference__Group_4_0_1_0__02271 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_0__1_in_rule__Reference__Group_4_0_1_0__02281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__ShortDescriptionAssignment_4_0_1_0_1_in_rule__Reference__Group_4_0_1_0__12309 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_0__2_in_rule__Reference__Group_4_0_1_0__12318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Reference__Group_4_0_1_0__22347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Reference__Group_4_0_1_1__02389 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_1__1_in_rule__Reference__Group_4_0_1_1__02399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__LongDescriptionAssignment_4_0_1_1_1_in_rule__Reference__Group_4_0_1_1__12427 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_1__2_in_rule__Reference__Group_4_0_1_1__12436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Reference__Group_4_0_1_1__22465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__0_in_rule__Object__UnorderedGroup_52503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_0__0_in_rule__Object__UnorderedGroup_5__Impl2588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_1__0_in_rule__Object__UnorderedGroup_5__Impl2684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_2__0_in_rule__Object__UnorderedGroup_5__Impl2780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_3__0_in_rule__Object__UnorderedGroup_5__Impl2876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_4_in_rule__Object__UnorderedGroup_5__Impl2973 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_rule__Object__FeaturesAssignment_5_4_in_rule__Object__UnorderedGroup_5__Impl3013 = new BitSet(new long[]{0x0000000003000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_5__0_in_rule__Object__UnorderedGroup_5__Impl3116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_6__0_in_rule__Object__UnorderedGroup_5__Impl3212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__Group_5_7__0_in_rule__Object__UnorderedGroup_5__Impl3308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__03374 = new BitSet(new long[]{0x0000000013DE0002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__1_in_rule__Object__UnorderedGroup_5__03377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__13402 = new BitSet(new long[]{0x0000000013DE0002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__2_in_rule__Object__UnorderedGroup_5__13405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__23430 = new BitSet(new long[]{0x0000000013DE0002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__3_in_rule__Object__UnorderedGroup_5__23433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__33458 = new BitSet(new long[]{0x0000000013DE0002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__4_in_rule__Object__UnorderedGroup_5__33461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__43486 = new BitSet(new long[]{0x0000000013DE0002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__5_in_rule__Object__UnorderedGroup_5__43489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__53514 = new BitSet(new long[]{0x0000000013DE0002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__6_in_rule__Object__UnorderedGroup_5__53517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__63542 = new BitSet(new long[]{0x0000000013DE0002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__7_in_rule__Object__UnorderedGroup_5__63545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Object__UnorderedGroup_5__Impl_in_rule__Object__UnorderedGroup_5__73570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__UnorderedGroup_4_0_1__0_in_rule__Reference__UnorderedGroup_4_0_13610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_0__0_in_rule__Reference__UnorderedGroup_4_0_1__Impl3695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group_4_0_1_1__0_in_rule__Reference__UnorderedGroup_4_0_1__Impl3791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__UnorderedGroup_4_0_1__Impl_in_rule__Reference__UnorderedGroup_4_0_1__03857 = new BitSet(new long[]{0x0000000000060002L});
        public static final BitSet FOLLOW_rule__Reference__UnorderedGroup_4_0_1__1_in_rule__Reference__UnorderedGroup_4_0_1__03860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__UnorderedGroup_4_0_1__Impl_in_rule__Reference__UnorderedGroup_4_0_1__13885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__PackageDefinition__NamespaceAssignment_23917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObject_in_rule__PackageDefinition__ContentsAssignment_43948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Object__EnabledAssignment_0_03984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Object__AbstractAssignment_0_14028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Object__NameAssignment_24067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Object__ParentAssignment_3_14102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Object__ShortDescriptionAssignment_5_0_14137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Object__LongDescriptionAssignment_5_1_14168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Object__SerialVersionUIDAssignment_5_2_14199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__Object__CloneableAssignment_5_3_04235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_44274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_5_14305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_6_14336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_rule__Object__FeaturesAssignment_5_7_14367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__TypeAssignment_14398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_24429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__TypeAssignment_14464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__Reference__ManyAssignment_24504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_34543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Reference__ShortDescriptionAssignment_4_0_1_0_14574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Reference__LongDescriptionAssignment_4_0_1_1_14605 = new BitSet(new long[]{0x0000000000000002L});
    }


}
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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.DatatypeRuleTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDatatypeRuleTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Types'", "'Type'", "';'", "'Composite'", "'base'", "'<'", "'>'", "','"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalDatatypeRuleTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g"; }


     
     	private DatatypeRuleTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(DatatypeRuleTestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:63:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:70:1: ruleModel : ( ruleTypes ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:74:2: ( ( ruleTypes ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:75:1: ( ruleTypes )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:75:1: ( ruleTypes )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:76:1: ruleTypes
            {
             before(grammarAccess.getModelAccess().getTypesParserRuleCall()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypes_in_ruleModel94);
            ruleTypes();
            _fsp--;

             after(grammarAccess.getModelAccess().getTypesParserRuleCall()); 

            }


            }

        }
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


    // $ANTLR start entryRuleTypes
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:89:1: entryRuleTypes : ruleTypes EOF ;
    public final void entryRuleTypes() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:90:1: ( ruleTypes EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:91:1: ruleTypes EOF
            {
             before(grammarAccess.getTypesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypes_in_entryRuleTypes120);
            ruleTypes();
            _fsp--;

             after(grammarAccess.getTypesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypes127); 

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
    // $ANTLR end entryRuleTypes


    // $ANTLR start ruleTypes
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:98:1: ruleTypes : ( ( rule__Types__Group__0 ) ) ;
    public final void ruleTypes() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:102:2: ( ( ( rule__Types__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:103:1: ( ( rule__Types__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:103:1: ( ( rule__Types__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:104:1: ( rule__Types__Group__0 )
            {
             before(grammarAccess.getTypesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:105:1: ( rule__Types__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:105:2: rule__Types__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Types__Group__0_in_ruleTypes153);
            rule__Types__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTypesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTypes


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:117:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:118:1: ( ruleType EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:119:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType180);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType187); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:126:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:130:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:131:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:131:1: ( ( rule__Type__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:132:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:133:1: ( rule__Type__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:133:2: rule__Type__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Alternatives_in_ruleType213);
            rule__Type__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start entryRuleSimpleType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:145:1: entryRuleSimpleType : ruleSimpleType EOF ;
    public final void entryRuleSimpleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:146:1: ( ruleSimpleType EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:147:1: ruleSimpleType EOF
            {
             before(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleType_in_entryRuleSimpleType240);
            ruleSimpleType();
            _fsp--;

             after(grammarAccess.getSimpleTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleType247); 

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
    // $ANTLR end entryRuleSimpleType


    // $ANTLR start ruleSimpleType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:154:1: ruleSimpleType : ( ( rule__SimpleType__Group__0 ) ) ;
    public final void ruleSimpleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:158:2: ( ( ( rule__SimpleType__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:159:1: ( ( rule__SimpleType__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:159:1: ( ( rule__SimpleType__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:160:1: ( rule__SimpleType__Group__0 )
            {
             before(grammarAccess.getSimpleTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:161:1: ( rule__SimpleType__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:161:2: rule__SimpleType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType273);
            rule__SimpleType__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSimpleType


    // $ANTLR start entryRuleCompositeType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:173:1: entryRuleCompositeType : ruleCompositeType EOF ;
    public final void entryRuleCompositeType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:174:1: ( ruleCompositeType EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:175:1: ruleCompositeType EOF
            {
             before(grammarAccess.getCompositeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeType_in_entryRuleCompositeType300);
            ruleCompositeType();
            _fsp--;

             after(grammarAccess.getCompositeTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompositeType307); 

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
    // $ANTLR end entryRuleCompositeType


    // $ANTLR start ruleCompositeType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:182:1: ruleCompositeType : ( ( rule__CompositeType__Group__0 ) ) ;
    public final void ruleCompositeType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:186:2: ( ( ( rule__CompositeType__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:187:1: ( ( rule__CompositeType__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:187:1: ( ( rule__CompositeType__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:188:1: ( rule__CompositeType__Group__0 )
            {
             before(grammarAccess.getCompositeTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:189:1: ( rule__CompositeType__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:189:2: rule__CompositeType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__0_in_ruleCompositeType333);
            rule__CompositeType__Group__0();
            _fsp--;


            }

             after(grammarAccess.getCompositeTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleCompositeType


    // $ANTLR start entryRuleCompositeTypeEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:201:1: entryRuleCompositeTypeEntry : ruleCompositeTypeEntry EOF ;
    public final void entryRuleCompositeTypeEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:202:1: ( ruleCompositeTypeEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:203:1: ruleCompositeTypeEntry EOF
            {
             before(grammarAccess.getCompositeTypeEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeTypeEntry_in_entryRuleCompositeTypeEntry360);
            ruleCompositeTypeEntry();
            _fsp--;

             after(grammarAccess.getCompositeTypeEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompositeTypeEntry367); 

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
    // $ANTLR end entryRuleCompositeTypeEntry


    // $ANTLR start ruleCompositeTypeEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:210:1: ruleCompositeTypeEntry : ( ( rule__CompositeTypeEntry__DataTypeAssignment ) ) ;
    public final void ruleCompositeTypeEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:214:2: ( ( ( rule__CompositeTypeEntry__DataTypeAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:215:1: ( ( rule__CompositeTypeEntry__DataTypeAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:215:1: ( ( rule__CompositeTypeEntry__DataTypeAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:216:1: ( rule__CompositeTypeEntry__DataTypeAssignment )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:217:1: ( rule__CompositeTypeEntry__DataTypeAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:217:2: rule__CompositeTypeEntry__DataTypeAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeTypeEntry__DataTypeAssignment_in_ruleCompositeTypeEntry393);
            rule__CompositeTypeEntry__DataTypeAssignment();
            _fsp--;


            }

             after(grammarAccess.getCompositeTypeEntryAccess().getDataTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleCompositeTypeEntry


    // $ANTLR start entryRuleTypeId
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:229:1: entryRuleTypeId : ruleTypeId EOF ;
    public final void entryRuleTypeId() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:230:1: ( ruleTypeId EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:231:1: ruleTypeId EOF
            {
             before(grammarAccess.getTypeIdRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeId_in_entryRuleTypeId420);
            ruleTypeId();
            _fsp--;

             after(grammarAccess.getTypeIdRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeId427); 

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
    // $ANTLR end entryRuleTypeId


    // $ANTLR start ruleTypeId
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:238:1: ruleTypeId : ( ( rule__TypeId__Group__0 ) ) ;
    public final void ruleTypeId() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:242:2: ( ( ( rule__TypeId__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:243:1: ( ( rule__TypeId__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:243:1: ( ( rule__TypeId__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:244:1: ( rule__TypeId__Group__0 )
            {
             before(grammarAccess.getTypeIdAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:245:1: ( rule__TypeId__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:245:2: rule__TypeId__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group__0_in_ruleTypeId453);
            rule__TypeId__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTypeIdAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTypeId


    // $ANTLR start rule__Type__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:257:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleCompositeType ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:261:1: ( ( ruleSimpleType ) | ( ruleCompositeType ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==14) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("257:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleCompositeType ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:262:1: ( ruleSimpleType )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:262:1: ( ruleSimpleType )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:263:1: ruleSimpleType
                    {
                     before(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleType_in_rule__Type__Alternatives489);
                    ruleSimpleType();
                    _fsp--;

                     after(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:268:6: ( ruleCompositeType )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:268:6: ( ruleCompositeType )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:269:1: ruleCompositeType
                    {
                     before(grammarAccess.getTypeAccess().getCompositeTypeParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCompositeType_in_rule__Type__Alternatives506);
                    ruleCompositeType();
                    _fsp--;

                     after(grammarAccess.getTypeAccess().getCompositeTypeParserRuleCall_1()); 

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


    // $ANTLR start rule__Types__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:281:1: rule__Types__Group__0 : rule__Types__Group__0__Impl rule__Types__Group__1 ;
    public final void rule__Types__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:285:1: ( rule__Types__Group__0__Impl rule__Types__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:286:2: rule__Types__Group__0__Impl rule__Types__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Types__Group__0__Impl_in_rule__Types__Group__0536);
            rule__Types__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Types__Group__1_in_rule__Types__Group__0539);
            rule__Types__Group__1();
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
    // $ANTLR end rule__Types__Group__0


    // $ANTLR start rule__Types__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:293:1: rule__Types__Group__0__Impl : ( 'Types' ) ;
    public final void rule__Types__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:297:1: ( ( 'Types' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:298:1: ( 'Types' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:298:1: ( 'Types' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:299:1: 'Types'
            {
             before(grammarAccess.getTypesAccess().getTypesKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Types__Group__0__Impl567); 
             after(grammarAccess.getTypesAccess().getTypesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Types__Group__0__Impl


    // $ANTLR start rule__Types__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:312:1: rule__Types__Group__1 : rule__Types__Group__1__Impl ;
    public final void rule__Types__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:316:1: ( rule__Types__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:317:2: rule__Types__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Types__Group__1__Impl_in_rule__Types__Group__1598);
            rule__Types__Group__1__Impl();
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
    // $ANTLR end rule__Types__Group__1


    // $ANTLR start rule__Types__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:323:1: rule__Types__Group__1__Impl : ( ( rule__Types__TypesAssignment_1 )* ) ;
    public final void rule__Types__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:327:1: ( ( ( rule__Types__TypesAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:328:1: ( ( rule__Types__TypesAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:328:1: ( ( rule__Types__TypesAssignment_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:329:1: ( rule__Types__TypesAssignment_1 )*
            {
             before(grammarAccess.getTypesAccess().getTypesAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:330:1: ( rule__Types__TypesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:330:2: rule__Types__TypesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Types__TypesAssignment_1_in_rule__Types__Group__1__Impl625);
            	    rule__Types__TypesAssignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTypesAccess().getTypesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Types__Group__1__Impl


    // $ANTLR start rule__SimpleType__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:344:1: rule__SimpleType__Group__0 : rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1 ;
    public final void rule__SimpleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:348:1: ( rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:349:2: rule__SimpleType__Group__0__Impl rule__SimpleType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__Group__0__Impl_in_rule__SimpleType__Group__0660);
            rule__SimpleType__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0663);
            rule__SimpleType__Group__1();
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
    // $ANTLR end rule__SimpleType__Group__0


    // $ANTLR start rule__SimpleType__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:356:1: rule__SimpleType__Group__0__Impl : ( 'Type' ) ;
    public final void rule__SimpleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:360:1: ( ( 'Type' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:361:1: ( 'Type' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:361:1: ( 'Type' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:362:1: 'Type'
            {
             before(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__SimpleType__Group__0__Impl691); 
             after(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleType__Group__0__Impl


    // $ANTLR start rule__SimpleType__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:375:1: rule__SimpleType__Group__1 : rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2 ;
    public final void rule__SimpleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:379:1: ( rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:380:2: rule__SimpleType__Group__1__Impl rule__SimpleType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__Group__1__Impl_in_rule__SimpleType__Group__1722);
            rule__SimpleType__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__Group__2_in_rule__SimpleType__Group__1725);
            rule__SimpleType__Group__2();
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
    // $ANTLR end rule__SimpleType__Group__1


    // $ANTLR start rule__SimpleType__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:387:1: rule__SimpleType__Group__1__Impl : ( ( rule__SimpleType__NameAssignment_1 ) ) ;
    public final void rule__SimpleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:391:1: ( ( ( rule__SimpleType__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:392:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:392:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:393:1: ( rule__SimpleType__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:394:1: ( rule__SimpleType__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:394:2: rule__SimpleType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1__Impl752);
            rule__SimpleType__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleType__Group__1__Impl


    // $ANTLR start rule__SimpleType__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:404:1: rule__SimpleType__Group__2 : rule__SimpleType__Group__2__Impl ;
    public final void rule__SimpleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:408:1: ( rule__SimpleType__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:409:2: rule__SimpleType__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__Group__2__Impl_in_rule__SimpleType__Group__2782);
            rule__SimpleType__Group__2__Impl();
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
    // $ANTLR end rule__SimpleType__Group__2


    // $ANTLR start rule__SimpleType__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:415:1: rule__SimpleType__Group__2__Impl : ( ';' ) ;
    public final void rule__SimpleType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:419:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:420:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:420:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:421:1: ';'
            {
             before(grammarAccess.getSimpleTypeAccess().getSemicolonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__SimpleType__Group__2__Impl810); 
             after(grammarAccess.getSimpleTypeAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleType__Group__2__Impl


    // $ANTLR start rule__CompositeType__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:440:1: rule__CompositeType__Group__0 : rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1 ;
    public final void rule__CompositeType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:444:1: ( rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:445:2: rule__CompositeType__Group__0__Impl rule__CompositeType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__0__Impl_in_rule__CompositeType__Group__0847);
            rule__CompositeType__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__1_in_rule__CompositeType__Group__0850);
            rule__CompositeType__Group__1();
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
    // $ANTLR end rule__CompositeType__Group__0


    // $ANTLR start rule__CompositeType__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:452:1: rule__CompositeType__Group__0__Impl : ( 'Composite' ) ;
    public final void rule__CompositeType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:456:1: ( ( 'Composite' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:457:1: ( 'Composite' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:457:1: ( 'Composite' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:458:1: 'Composite'
            {
             before(grammarAccess.getCompositeTypeAccess().getCompositeKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__CompositeType__Group__0__Impl878); 
             after(grammarAccess.getCompositeTypeAccess().getCompositeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CompositeType__Group__0__Impl


    // $ANTLR start rule__CompositeType__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:471:1: rule__CompositeType__Group__1 : rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2 ;
    public final void rule__CompositeType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:475:1: ( rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:476:2: rule__CompositeType__Group__1__Impl rule__CompositeType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__1__Impl_in_rule__CompositeType__Group__1909);
            rule__CompositeType__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__2_in_rule__CompositeType__Group__1912);
            rule__CompositeType__Group__2();
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
    // $ANTLR end rule__CompositeType__Group__1


    // $ANTLR start rule__CompositeType__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:483:1: rule__CompositeType__Group__1__Impl : ( ( rule__CompositeType__NameAssignment_1 ) ) ;
    public final void rule__CompositeType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:487:1: ( ( ( rule__CompositeType__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:488:1: ( ( rule__CompositeType__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:488:1: ( ( rule__CompositeType__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:489:1: ( rule__CompositeType__NameAssignment_1 )
            {
             before(grammarAccess.getCompositeTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:490:1: ( rule__CompositeType__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:490:2: rule__CompositeType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__NameAssignment_1_in_rule__CompositeType__Group__1__Impl939);
            rule__CompositeType__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getCompositeTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CompositeType__Group__1__Impl


    // $ANTLR start rule__CompositeType__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:500:1: rule__CompositeType__Group__2 : rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3 ;
    public final void rule__CompositeType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:504:1: ( rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:505:2: rule__CompositeType__Group__2__Impl rule__CompositeType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__2__Impl_in_rule__CompositeType__Group__2969);
            rule__CompositeType__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__3_in_rule__CompositeType__Group__2972);
            rule__CompositeType__Group__3();
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
    // $ANTLR end rule__CompositeType__Group__2


    // $ANTLR start rule__CompositeType__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:512:1: rule__CompositeType__Group__2__Impl : ( 'base' ) ;
    public final void rule__CompositeType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:516:1: ( ( 'base' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:517:1: ( 'base' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:517:1: ( 'base' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:518:1: 'base'
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseKeyword_2()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__CompositeType__Group__2__Impl1000); 
             after(grammarAccess.getCompositeTypeAccess().getBaseKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CompositeType__Group__2__Impl


    // $ANTLR start rule__CompositeType__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:531:1: rule__CompositeType__Group__3 : rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4 ;
    public final void rule__CompositeType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:535:1: ( rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:536:2: rule__CompositeType__Group__3__Impl rule__CompositeType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__3__Impl_in_rule__CompositeType__Group__31031);
            rule__CompositeType__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__4_in_rule__CompositeType__Group__31034);
            rule__CompositeType__Group__4();
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
    // $ANTLR end rule__CompositeType__Group__3


    // $ANTLR start rule__CompositeType__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:543:1: rule__CompositeType__Group__3__Impl : ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) ;
    public final void rule__CompositeType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:547:1: ( ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:548:1: ( ( rule__CompositeType__BaseTypeAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:548:1: ( ( rule__CompositeType__BaseTypeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:549:1: ( rule__CompositeType__BaseTypeAssignment_3 )
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:550:1: ( rule__CompositeType__BaseTypeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:550:2: rule__CompositeType__BaseTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__BaseTypeAssignment_3_in_rule__CompositeType__Group__3__Impl1061);
            rule__CompositeType__BaseTypeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CompositeType__Group__3__Impl


    // $ANTLR start rule__CompositeType__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:560:1: rule__CompositeType__Group__4 : rule__CompositeType__Group__4__Impl ;
    public final void rule__CompositeType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:564:1: ( rule__CompositeType__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:565:2: rule__CompositeType__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__4__Impl_in_rule__CompositeType__Group__41091);
            rule__CompositeType__Group__4__Impl();
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
    // $ANTLR end rule__CompositeType__Group__4


    // $ANTLR start rule__CompositeType__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:571:1: rule__CompositeType__Group__4__Impl : ( ';' ) ;
    public final void rule__CompositeType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:575:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:576:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:576:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:577:1: ';'
            {
             before(grammarAccess.getCompositeTypeAccess().getSemicolonKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__CompositeType__Group__4__Impl1119); 
             after(grammarAccess.getCompositeTypeAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CompositeType__Group__4__Impl


    // $ANTLR start rule__TypeId__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:600:1: rule__TypeId__Group__0 : rule__TypeId__Group__0__Impl rule__TypeId__Group__1 ;
    public final void rule__TypeId__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:604:1: ( rule__TypeId__Group__0__Impl rule__TypeId__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:605:2: rule__TypeId__Group__0__Impl rule__TypeId__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group__0__Impl_in_rule__TypeId__Group__01160);
            rule__TypeId__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group__1_in_rule__TypeId__Group__01163);
            rule__TypeId__Group__1();
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
    // $ANTLR end rule__TypeId__Group__0


    // $ANTLR start rule__TypeId__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:612:1: rule__TypeId__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__TypeId__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:616:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:617:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:617:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:618:1: RULE_ID
            {
             before(grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeId__Group__0__Impl1190); 
             after(grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TypeId__Group__0__Impl


    // $ANTLR start rule__TypeId__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:629:1: rule__TypeId__Group__1 : rule__TypeId__Group__1__Impl ;
    public final void rule__TypeId__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:633:1: ( rule__TypeId__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:634:2: rule__TypeId__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group__1__Impl_in_rule__TypeId__Group__11219);
            rule__TypeId__Group__1__Impl();
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
    // $ANTLR end rule__TypeId__Group__1


    // $ANTLR start rule__TypeId__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:640:1: rule__TypeId__Group__1__Impl : ( ( rule__TypeId__Group_1__0 )? ) ;
    public final void rule__TypeId__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:644:1: ( ( ( rule__TypeId__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:645:1: ( ( rule__TypeId__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:645:1: ( ( rule__TypeId__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:646:1: ( rule__TypeId__Group_1__0 )?
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:647:1: ( rule__TypeId__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:647:2: rule__TypeId__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__0_in_rule__TypeId__Group__1__Impl1246);
                    rule__TypeId__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeIdAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TypeId__Group__1__Impl


    // $ANTLR start rule__TypeId__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:661:1: rule__TypeId__Group_1__0 : rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1 ;
    public final void rule__TypeId__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:665:1: ( rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:666:2: rule__TypeId__Group_1__0__Impl rule__TypeId__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__0__Impl_in_rule__TypeId__Group_1__01281);
            rule__TypeId__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__1_in_rule__TypeId__Group_1__01284);
            rule__TypeId__Group_1__1();
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
    // $ANTLR end rule__TypeId__Group_1__0


    // $ANTLR start rule__TypeId__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:673:1: rule__TypeId__Group_1__0__Impl : ( '<' ) ;
    public final void rule__TypeId__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:677:1: ( ( '<' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:678:1: ( '<' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:678:1: ( '<' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:679:1: '<'
            {
             before(grammarAccess.getTypeIdAccess().getLessThanSignKeyword_1_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__TypeId__Group_1__0__Impl1312); 
             after(grammarAccess.getTypeIdAccess().getLessThanSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TypeId__Group_1__0__Impl


    // $ANTLR start rule__TypeId__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:692:1: rule__TypeId__Group_1__1 : rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2 ;
    public final void rule__TypeId__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:696:1: ( rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:697:2: rule__TypeId__Group_1__1__Impl rule__TypeId__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__1__Impl_in_rule__TypeId__Group_1__11343);
            rule__TypeId__Group_1__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__2_in_rule__TypeId__Group_1__11346);
            rule__TypeId__Group_1__2();
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
    // $ANTLR end rule__TypeId__Group_1__1


    // $ANTLR start rule__TypeId__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:704:1: rule__TypeId__Group_1__1__Impl : ( ruleTypeId ) ;
    public final void rule__TypeId__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:708:1: ( ( ruleTypeId ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:709:1: ( ruleTypeId )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:709:1: ( ruleTypeId )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:710:1: ruleTypeId
            {
             before(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeId_in_rule__TypeId__Group_1__1__Impl1373);
            ruleTypeId();
            _fsp--;

             after(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TypeId__Group_1__1__Impl


    // $ANTLR start rule__TypeId__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:721:1: rule__TypeId__Group_1__2 : rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3 ;
    public final void rule__TypeId__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:725:1: ( rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:726:2: rule__TypeId__Group_1__2__Impl rule__TypeId__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__2__Impl_in_rule__TypeId__Group_1__21402);
            rule__TypeId__Group_1__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__3_in_rule__TypeId__Group_1__21405);
            rule__TypeId__Group_1__3();
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
    // $ANTLR end rule__TypeId__Group_1__2


    // $ANTLR start rule__TypeId__Group_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:733:1: rule__TypeId__Group_1__2__Impl : ( ( rule__TypeId__Group_1_2__0 )* ) ;
    public final void rule__TypeId__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:737:1: ( ( ( rule__TypeId__Group_1_2__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:738:1: ( ( rule__TypeId__Group_1_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:738:1: ( ( rule__TypeId__Group_1_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:739:1: ( rule__TypeId__Group_1_2__0 )*
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:740:1: ( rule__TypeId__Group_1_2__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:740:2: rule__TypeId__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1_2__0_in_rule__TypeId__Group_1__2__Impl1432);
            	    rule__TypeId__Group_1_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getTypeIdAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TypeId__Group_1__2__Impl


    // $ANTLR start rule__TypeId__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:750:1: rule__TypeId__Group_1__3 : rule__TypeId__Group_1__3__Impl ;
    public final void rule__TypeId__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:754:1: ( rule__TypeId__Group_1__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:755:2: rule__TypeId__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__3__Impl_in_rule__TypeId__Group_1__31463);
            rule__TypeId__Group_1__3__Impl();
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
    // $ANTLR end rule__TypeId__Group_1__3


    // $ANTLR start rule__TypeId__Group_1__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:761:1: rule__TypeId__Group_1__3__Impl : ( '>' ) ;
    public final void rule__TypeId__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:765:1: ( ( '>' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:766:1: ( '>' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:766:1: ( '>' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:767:1: '>'
            {
             before(grammarAccess.getTypeIdAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__TypeId__Group_1__3__Impl1491); 
             after(grammarAccess.getTypeIdAccess().getGreaterThanSignKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TypeId__Group_1__3__Impl


    // $ANTLR start rule__TypeId__Group_1_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:788:1: rule__TypeId__Group_1_2__0 : rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1 ;
    public final void rule__TypeId__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:792:1: ( rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:793:2: rule__TypeId__Group_1_2__0__Impl rule__TypeId__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1_2__0__Impl_in_rule__TypeId__Group_1_2__01530);
            rule__TypeId__Group_1_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1_2__1_in_rule__TypeId__Group_1_2__01533);
            rule__TypeId__Group_1_2__1();
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
    // $ANTLR end rule__TypeId__Group_1_2__0


    // $ANTLR start rule__TypeId__Group_1_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:800:1: rule__TypeId__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__TypeId__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:804:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:805:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:805:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:806:1: ','
            {
             before(grammarAccess.getTypeIdAccess().getCommaKeyword_1_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__TypeId__Group_1_2__0__Impl1561); 
             after(grammarAccess.getTypeIdAccess().getCommaKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TypeId__Group_1_2__0__Impl


    // $ANTLR start rule__TypeId__Group_1_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:819:1: rule__TypeId__Group_1_2__1 : rule__TypeId__Group_1_2__1__Impl ;
    public final void rule__TypeId__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:823:1: ( rule__TypeId__Group_1_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:824:2: rule__TypeId__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1_2__1__Impl_in_rule__TypeId__Group_1_2__11592);
            rule__TypeId__Group_1_2__1__Impl();
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
    // $ANTLR end rule__TypeId__Group_1_2__1


    // $ANTLR start rule__TypeId__Group_1_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:830:1: rule__TypeId__Group_1_2__1__Impl : ( ruleTypeId ) ;
    public final void rule__TypeId__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:834:1: ( ( ruleTypeId ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:835:1: ( ruleTypeId )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:835:1: ( ruleTypeId )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:836:1: ruleTypeId
            {
             before(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_2_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeId_in_rule__TypeId__Group_1_2__1__Impl1619);
            ruleTypeId();
            _fsp--;

             after(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TypeId__Group_1_2__1__Impl


    // $ANTLR start rule__Types__TypesAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:852:1: rule__Types__TypesAssignment_1 : ( ruleType ) ;
    public final void rule__Types__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:856:1: ( ( ruleType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:857:1: ( ruleType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:857:1: ( ruleType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:858:1: ruleType
            {
             before(grammarAccess.getTypesAccess().getTypesTypeParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_rule__Types__TypesAssignment_11657);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypesAccess().getTypesTypeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Types__TypesAssignment_1


    // $ANTLR start rule__SimpleType__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:867:1: rule__SimpleType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:871:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:872:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:872:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:873:1: RULE_ID
            {
             before(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_11688); 
             after(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleType__NameAssignment_1


    // $ANTLR start rule__CompositeType__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:882:1: rule__CompositeType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CompositeType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:886:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:887:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:887:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:888:1: RULE_ID
            {
             before(grammarAccess.getCompositeTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__CompositeType__NameAssignment_11719); 
             after(grammarAccess.getCompositeTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CompositeType__NameAssignment_1


    // $ANTLR start rule__CompositeType__BaseTypeAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:897:1: rule__CompositeType__BaseTypeAssignment_3 : ( ruleCompositeTypeEntry ) ;
    public final void rule__CompositeType__BaseTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:901:1: ( ( ruleCompositeTypeEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:902:1: ( ruleCompositeTypeEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:902:1: ( ruleCompositeTypeEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:903:1: ruleCompositeTypeEntry
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseTypeCompositeTypeEntryParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeTypeEntry_in_rule__CompositeType__BaseTypeAssignment_31750);
            ruleCompositeTypeEntry();
            _fsp--;

             after(grammarAccess.getCompositeTypeAccess().getBaseTypeCompositeTypeEntryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CompositeType__BaseTypeAssignment_3


    // $ANTLR start rule__CompositeTypeEntry__DataTypeAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:912:1: rule__CompositeTypeEntry__DataTypeAssignment : ( ( ruleTypeId ) ) ;
    public final void rule__CompositeTypeEntry__DataTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:916:1: ( ( ( ruleTypeId ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:917:1: ( ( ruleTypeId ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:917:1: ( ( ruleTypeId ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:918:1: ( ruleTypeId )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:919:1: ( ruleTypeId )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:920:1: ruleTypeId
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeTypeIdParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeId_in_rule__CompositeTypeEntry__DataTypeAssignment1785);
            ruleTypeId();
            _fsp--;

             after(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeTypeIdParserRuleCall_0_1()); 

            }

             after(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CompositeTypeEntry__DataTypeAssignment


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypes_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypes_in_entryRuleTypes120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypes127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Types__Group__0_in_ruleTypes153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType180 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeType_in_entryRuleCompositeType300 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompositeType307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__0_in_ruleCompositeType333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeTypeEntry_in_entryRuleCompositeTypeEntry360 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompositeTypeEntry367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeTypeEntry__DataTypeAssignment_in_ruleCompositeTypeEntry393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeId_in_entryRuleTypeId420 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeId427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group__0_in_ruleTypeId453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleType_in_rule__Type__Alternatives489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeType_in_rule__Type__Alternatives506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Types__Group__0__Impl_in_rule__Types__Group__0536 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_rule__Types__Group__1_in_rule__Types__Group__0539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Types__Group__0__Impl567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Types__Group__1__Impl_in_rule__Types__Group__1598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Types__TypesAssignment_1_in_rule__Types__Group__1__Impl625 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_rule__SimpleType__Group__0__Impl_in_rule__SimpleType__Group__0660 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__SimpleType__Group__0__Impl691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleType__Group__1__Impl_in_rule__SimpleType__Group__1722 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__SimpleType__Group__2_in_rule__SimpleType__Group__1725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1__Impl752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleType__Group__2__Impl_in_rule__SimpleType__Group__2782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__SimpleType__Group__2__Impl810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__0__Impl_in_rule__CompositeType__Group__0847 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__1_in_rule__CompositeType__Group__0850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__CompositeType__Group__0__Impl878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__1__Impl_in_rule__CompositeType__Group__1909 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__2_in_rule__CompositeType__Group__1912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__NameAssignment_1_in_rule__CompositeType__Group__1__Impl939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__2__Impl_in_rule__CompositeType__Group__2969 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__3_in_rule__CompositeType__Group__2972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__CompositeType__Group__2__Impl1000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__3__Impl_in_rule__CompositeType__Group__31031 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__4_in_rule__CompositeType__Group__31034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__BaseTypeAssignment_3_in_rule__CompositeType__Group__3__Impl1061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__4__Impl_in_rule__CompositeType__Group__41091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__CompositeType__Group__4__Impl1119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group__0__Impl_in_rule__TypeId__Group__01160 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_rule__TypeId__Group__1_in_rule__TypeId__Group__01163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeId__Group__0__Impl1190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group__1__Impl_in_rule__TypeId__Group__11219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__0_in_rule__TypeId__Group__1__Impl1246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__0__Impl_in_rule__TypeId__Group_1__01281 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__1_in_rule__TypeId__Group_1__01284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__TypeId__Group_1__0__Impl1312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__1__Impl_in_rule__TypeId__Group_1__11343 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__2_in_rule__TypeId__Group_1__11346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeId_in_rule__TypeId__Group_1__1__Impl1373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__2__Impl_in_rule__TypeId__Group_1__21402 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__3_in_rule__TypeId__Group_1__21405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1_2__0_in_rule__TypeId__Group_1__2__Impl1432 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__3__Impl_in_rule__TypeId__Group_1__31463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__TypeId__Group_1__3__Impl1491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1_2__0__Impl_in_rule__TypeId__Group_1_2__01530 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1_2__1_in_rule__TypeId__Group_1_2__01533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__TypeId__Group_1_2__0__Impl1561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1_2__1__Impl_in_rule__TypeId__Group_1_2__11592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeId_in_rule__TypeId__Group_1_2__1__Impl1619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_rule__Types__TypesAssignment_11657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_11688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__CompositeType__NameAssignment_11719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeTypeEntry_in_rule__CompositeType__BaseTypeAssignment_31750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeId_in_rule__CompositeTypeEntry__DataTypeAssignment1785 = new BitSet(new long[]{0x0000000000000002L});
    }


}
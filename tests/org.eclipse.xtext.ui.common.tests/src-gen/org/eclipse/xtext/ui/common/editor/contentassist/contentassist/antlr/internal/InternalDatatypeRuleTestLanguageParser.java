package org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.common.editor.contentassist.services.DatatypeRuleTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDatatypeRuleTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Types'", "'Type'", "';'", "'Composite'", "'base'", "'<'", "'>'", "','"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalDatatypeRuleTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g"; }


     
     	private DatatypeRuleTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(DatatypeRuleTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:55:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:55:16: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:56:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel60);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel67); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:63:1: ruleModel : ( ruleTypes ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:67:2: ( ( ruleTypes ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:68:1: ( ruleTypes )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:68:1: ( ruleTypes )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:69:1: ruleTypes
            {
             before(grammarAccess.getModelAccess().getTypesParserRuleCall()); 
            pushFollow(FOLLOW_ruleTypes_in_ruleModel94);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:81:1: entryRuleTypes : ruleTypes EOF ;
    public final void entryRuleTypes() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:81:16: ( ruleTypes EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:82:1: ruleTypes EOF
            {
             before(grammarAccess.getTypesRule()); 
            pushFollow(FOLLOW_ruleTypes_in_entryRuleTypes118);
            ruleTypes();
            _fsp--;

             after(grammarAccess.getTypesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypes125); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:89:1: ruleTypes : ( ( rule__Types__Group ) ) ;
    public final void ruleTypes() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:93:2: ( ( ( rule__Types__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:94:1: ( ( rule__Types__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:94:1: ( ( rule__Types__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:95:1: ( rule__Types__Group )
            {
             before(grammarAccess.getTypesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:96:1: ( rule__Types__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:96:2: rule__Types__Group
            {
            pushFollow(FOLLOW_rule__Types__Group_in_ruleTypes152);
            rule__Types__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:107:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:107:15: ( ruleType EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:108:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType177);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType184); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:115:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:119:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:120:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:120:1: ( ( rule__Type__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:121:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:122:1: ( rule__Type__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:122:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_rule__Type__Alternatives_in_ruleType211);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:133:1: entryRuleSimpleType : ruleSimpleType EOF ;
    public final void entryRuleSimpleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:133:21: ( ruleSimpleType EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:134:1: ruleSimpleType EOF
            {
             before(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FOLLOW_ruleSimpleType_in_entryRuleSimpleType236);
            ruleSimpleType();
            _fsp--;

             after(grammarAccess.getSimpleTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleType243); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:141:1: ruleSimpleType : ( ( rule__SimpleType__Group ) ) ;
    public final void ruleSimpleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:145:2: ( ( ( rule__SimpleType__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:146:1: ( ( rule__SimpleType__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:146:1: ( ( rule__SimpleType__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:147:1: ( rule__SimpleType__Group )
            {
             before(grammarAccess.getSimpleTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:148:1: ( rule__SimpleType__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:148:2: rule__SimpleType__Group
            {
            pushFollow(FOLLOW_rule__SimpleType__Group_in_ruleSimpleType270);
            rule__SimpleType__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:159:1: entryRuleCompositeType : ruleCompositeType EOF ;
    public final void entryRuleCompositeType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:159:24: ( ruleCompositeType EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:160:1: ruleCompositeType EOF
            {
             before(grammarAccess.getCompositeTypeRule()); 
            pushFollow(FOLLOW_ruleCompositeType_in_entryRuleCompositeType295);
            ruleCompositeType();
            _fsp--;

             after(grammarAccess.getCompositeTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeType302); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:167:1: ruleCompositeType : ( ( rule__CompositeType__Group ) ) ;
    public final void ruleCompositeType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:171:2: ( ( ( rule__CompositeType__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:172:1: ( ( rule__CompositeType__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:172:1: ( ( rule__CompositeType__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:173:1: ( rule__CompositeType__Group )
            {
             before(grammarAccess.getCompositeTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:174:1: ( rule__CompositeType__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:174:2: rule__CompositeType__Group
            {
            pushFollow(FOLLOW_rule__CompositeType__Group_in_ruleCompositeType329);
            rule__CompositeType__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:185:1: entryRuleCompositeTypeEntry : ruleCompositeTypeEntry EOF ;
    public final void entryRuleCompositeTypeEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:185:29: ( ruleCompositeTypeEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:186:1: ruleCompositeTypeEntry EOF
            {
             before(grammarAccess.getCompositeTypeEntryRule()); 
            pushFollow(FOLLOW_ruleCompositeTypeEntry_in_entryRuleCompositeTypeEntry354);
            ruleCompositeTypeEntry();
            _fsp--;

             after(grammarAccess.getCompositeTypeEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeTypeEntry361); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:193:1: ruleCompositeTypeEntry : ( ( ( ( ruleTypeId ) ) ) ) ;
    public final void ruleCompositeTypeEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:197:2: ( ( ( ( ( ruleTypeId ) ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:198:1: ( ( ( ( ruleTypeId ) ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:198:1: ( ( ( ( ruleTypeId ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:199:1: ( ( ( ruleTypeId ) ) )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:200:1: ( ( ( ruleTypeId ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:201:1: ( ( ruleTypeId ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:201:1: ( ( ruleTypeId ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:202:1: ( ruleTypeId )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:203:1: ( ruleTypeId )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:204:1: ruleTypeId
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeTypeIdParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleTypeId_in_ruleCompositeTypeEntry399);
            ruleTypeId();
            _fsp--;

             after(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeTypeIdParserRuleCall_0_1()); 

            }

             after(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0()); 

            }


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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:221:1: entryRuleTypeId : ruleTypeId EOF ;
    public final void entryRuleTypeId() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:221:17: ( ruleTypeId EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:222:1: ruleTypeId EOF
            {
             before(grammarAccess.getTypeIdRule()); 
            pushFollow(FOLLOW_ruleTypeId_in_entryRuleTypeId434);
            ruleTypeId();
            _fsp--;

             after(grammarAccess.getTypeIdRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeId441); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:229:1: ruleTypeId : ( ( rule__TypeId__Group ) ) ;
    public final void ruleTypeId() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:233:2: ( ( ( rule__TypeId__Group ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:234:1: ( ( rule__TypeId__Group ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:234:1: ( ( rule__TypeId__Group ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:235:1: ( rule__TypeId__Group )
            {
             before(grammarAccess.getTypeIdAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:236:1: ( rule__TypeId__Group )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:236:2: rule__TypeId__Group
            {
            pushFollow(FOLLOW_rule__TypeId__Group_in_ruleTypeId468);
            rule__TypeId__Group();
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:247:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleCompositeType ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:251:1: ( ( ruleSimpleType ) | ( ruleCompositeType ) )
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
                    new NoViableAltException("247:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleCompositeType ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:252:1: ( ruleSimpleType )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:252:1: ( ruleSimpleType )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:253:1: ruleSimpleType
                    {
                     before(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleType_in_rule__Type__Alternatives503);
                    ruleSimpleType();
                    _fsp--;

                     after(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:257:6: ( ruleCompositeType )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:257:6: ( ruleCompositeType )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:258:1: ruleCompositeType
                    {
                     before(grammarAccess.getTypeAccess().getCompositeTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleCompositeType_in_rule__Type__Alternatives519);
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


    // $ANTLR start rule__Types__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:268:1: rule__Types__Group : ( 'Types' ) ( ( ( ruleType ) )* ) ;
    public final void rule__Types__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:272:1: ( ( 'Types' ) ( ( ( ruleType ) )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:273:1: ( 'Types' ) ( ( ( ruleType ) )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:273:1: ( 'Types' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:274:1: 'Types'
            {
             before(grammarAccess.getTypesAccess().getTypesKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Types__Group552); 
             after(grammarAccess.getTypesAccess().getTypesKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:279:1: ( ( ( ruleType ) )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:280:1: ( ( ruleType ) )*
            {
             before(grammarAccess.getTypesAccess().getTypesAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:281:1: ( ( ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:282:1: ( ruleType )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:282:1: ( ruleType )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:283:1: ruleType
            	    {
            	     before(grammarAccess.getTypesAccess().getTypesTypeParserRuleCall_1_0()); 
            	    pushFollow(FOLLOW_ruleType_in_rule__Types__Group571);
            	    ruleType();
            	    _fsp--;

            	     after(grammarAccess.getTypesAccess().getTypesTypeParserRuleCall_1_0()); 

            	    }


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
    // $ANTLR end rule__Types__Group


    // $ANTLR start rule__SimpleType__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:295:1: rule__SimpleType__Group : ( 'Type' ) ( ( ( RULE_ID ) ) ) ( ';' ) ;
    public final void rule__SimpleType__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:299:1: ( ( 'Type' ) ( ( ( RULE_ID ) ) ) ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:300:1: ( 'Type' ) ( ( ( RULE_ID ) ) ) ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:300:1: ( 'Type' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:301:1: 'Type'
            {
             before(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__SimpleType__Group611); 
             after(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:306:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:307:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:308:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:309:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:309:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:310:1: RULE_ID
            {
             before(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleType__Group630); 
             after(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

             after(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:316:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:317:1: ';'
            {
             before(grammarAccess.getSimpleTypeAccess().getSemicolonKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__SimpleType__Group648); 
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
    // $ANTLR end rule__SimpleType__Group


    // $ANTLR start rule__CompositeType__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:328:1: rule__CompositeType__Group : ( 'Composite' ) ( ( ( RULE_ID ) ) ) ( 'base' ) ( ( ( ruleCompositeTypeEntry ) ) ) ( ';' ) ;
    public final void rule__CompositeType__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:332:1: ( ( 'Composite' ) ( ( ( RULE_ID ) ) ) ( 'base' ) ( ( ( ruleCompositeTypeEntry ) ) ) ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:333:1: ( 'Composite' ) ( ( ( RULE_ID ) ) ) ( 'base' ) ( ( ( ruleCompositeTypeEntry ) ) ) ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:333:1: ( 'Composite' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:334:1: 'Composite'
            {
             before(grammarAccess.getCompositeTypeAccess().getCompositeKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__CompositeType__Group682); 
             after(grammarAccess.getCompositeTypeAccess().getCompositeKeyword_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:339:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:340:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getCompositeTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:341:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:342:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:342:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:343:1: RULE_ID
            {
             before(grammarAccess.getCompositeTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CompositeType__Group701); 
             after(grammarAccess.getCompositeTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

             after(grammarAccess.getCompositeTypeAccess().getNameAssignment_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:349:1: ( 'base' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:350:1: 'base'
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseKeyword_2()); 
            match(input,15,FOLLOW_15_in_rule__CompositeType__Group719); 
             after(grammarAccess.getCompositeTypeAccess().getBaseKeyword_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:355:1: ( ( ( ruleCompositeTypeEntry ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:356:1: ( ( ruleCompositeTypeEntry ) )
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:357:1: ( ( ruleCompositeTypeEntry ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:358:1: ( ruleCompositeTypeEntry )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:358:1: ( ruleCompositeTypeEntry )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:359:1: ruleCompositeTypeEntry
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseTypeCompositeTypeEntryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCompositeTypeEntry_in_rule__CompositeType__Group738);
            ruleCompositeTypeEntry();
            _fsp--;

             after(grammarAccess.getCompositeTypeAccess().getBaseTypeCompositeTypeEntryParserRuleCall_3_0()); 

            }


            }

             after(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:365:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:366:1: ';'
            {
             before(grammarAccess.getCompositeTypeAccess().getSemicolonKeyword_4()); 
            match(input,13,FOLLOW_13_in_rule__CompositeType__Group756); 
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
    // $ANTLR end rule__CompositeType__Group


    // $ANTLR start rule__TypeId__Group
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:377:1: rule__TypeId__Group : ( RULE_ID ) ( ( rule__TypeId__Group_1 )? ) ;
    public final void rule__TypeId__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:381:1: ( ( RULE_ID ) ( ( rule__TypeId__Group_1 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:382:1: ( RULE_ID ) ( ( rule__TypeId__Group_1 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:382:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:383:1: RULE_ID
            {
             before(grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeId__Group789); 
             after(grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:386:1: ( ( rule__TypeId__Group_1 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:387:1: ( rule__TypeId__Group_1 )?
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:388:1: ( rule__TypeId__Group_1 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:388:2: rule__TypeId__Group_1
                    {
                    pushFollow(FOLLOW_rule__TypeId__Group_1_in_rule__TypeId__Group799);
                    rule__TypeId__Group_1();
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
    // $ANTLR end rule__TypeId__Group


    // $ANTLR start rule__TypeId__Group_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:396:1: rule__TypeId__Group_1 : ( '<' ) ( ruleTypeId ) ( ( rule__TypeId__Group_1_2 )* ) ( '>' ) ;
    public final void rule__TypeId__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:400:1: ( ( '<' ) ( ruleTypeId ) ( ( rule__TypeId__Group_1_2 )* ) ( '>' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:401:1: ( '<' ) ( ruleTypeId ) ( ( rule__TypeId__Group_1_2 )* ) ( '>' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:401:1: ( '<' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:402:1: '<'
            {
             before(grammarAccess.getTypeIdAccess().getLessThanSignKeyword_1_0()); 
            match(input,16,FOLLOW_16_in_rule__TypeId__Group_1833); 
             after(grammarAccess.getTypeIdAccess().getLessThanSignKeyword_1_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:407:1: ( ruleTypeId )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:408:1: ruleTypeId
            {
             before(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleTypeId_in_rule__TypeId__Group_1845);
            ruleTypeId();
            _fsp--;

             after(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:411:1: ( ( rule__TypeId__Group_1_2 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:412:1: ( rule__TypeId__Group_1_2 )*
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:413:1: ( rule__TypeId__Group_1_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:413:2: rule__TypeId__Group_1_2
            	    {
            	    pushFollow(FOLLOW_rule__TypeId__Group_1_2_in_rule__TypeId__Group_1855);
            	    rule__TypeId__Group_1_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getTypeIdAccess().getGroup_1_2()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:415:1: ( '>' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:416:1: '>'
            {
             before(grammarAccess.getTypeIdAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,17,FOLLOW_17_in_rule__TypeId__Group_1868); 
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
    // $ANTLR end rule__TypeId__Group_1


    // $ANTLR start rule__TypeId__Group_1_2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:427:1: rule__TypeId__Group_1_2 : ( ',' ) ( ruleTypeId ) ;
    public final void rule__TypeId__Group_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:431:1: ( ( ',' ) ( ruleTypeId ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:432:1: ( ',' ) ( ruleTypeId )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:432:1: ( ',' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:433:1: ','
            {
             before(grammarAccess.getTypeIdAccess().getCommaKeyword_1_2_0()); 
            match(input,18,FOLLOW_18_in_rule__TypeId__Group_1_2902); 
             after(grammarAccess.getTypeIdAccess().getCommaKeyword_1_2_0()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:438:1: ( ruleTypeId )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:439:1: ruleTypeId
            {
             before(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_2_1()); 
            pushFollow(FOLLOW_ruleTypeId_in_rule__TypeId__Group_1_2914);
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
    // $ANTLR end rule__TypeId__Group_1_2


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypes_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypes_in_entryRuleTypes118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypes125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Types__Group_in_ruleTypes152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__Group_in_ruleSimpleType270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeType_in_entryRuleCompositeType295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeType302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompositeType__Group_in_ruleCompositeType329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeTypeEntry_in_entryRuleCompositeTypeEntry354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeTypeEntry361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeId_in_ruleCompositeTypeEntry399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeId_in_entryRuleTypeId434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeId441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeId__Group_in_ruleTypeId468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_rule__Type__Alternatives503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeType_in_rule__Type__Alternatives519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Types__Group552 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Types__Group571 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_12_in_rule__SimpleType__Group611 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleType__Group630 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rule__SimpleType__Group648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__CompositeType__Group682 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CompositeType__Group701 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rule__CompositeType__Group719 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCompositeTypeEntry_in_rule__CompositeType__Group738 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rule__CompositeType__Group756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeId__Group789 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__TypeId__Group_1_in_rule__TypeId__Group799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__TypeId__Group_1833 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeId_in_rule__TypeId__Group_1845 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__TypeId__Group_1_2_in_rule__TypeId__Group_1855 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_rule__TypeId__Group_1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__TypeId__Group_1_2902 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeId_in_rule__TypeId__Group_1_2914 = new BitSet(new long[]{0x0000000000000002L});

}
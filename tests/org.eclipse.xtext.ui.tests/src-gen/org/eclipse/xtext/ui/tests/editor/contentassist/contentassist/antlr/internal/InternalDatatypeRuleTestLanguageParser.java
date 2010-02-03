package org.eclipse.xtext.ui.tests.editor.contentassist.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.DatatypeRuleTestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:62:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:69:1: ruleModel : ( ruleTypes ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:73:2: ( ( ruleTypes ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:74:1: ( ruleTypes )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:74:1: ( ruleTypes )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:75:1: ruleTypes
            {
             before(grammarAccess.getModelAccess().getTypesParserRuleCall()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypes_in_ruleModel95);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:88:1: entryRuleTypes : ruleTypes EOF ;
    public final void entryRuleTypes() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:89:1: ( ruleTypes EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:90:1: ruleTypes EOF
            {
             before(grammarAccess.getTypesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypes_in_entryRuleTypes121);
            ruleTypes();
            _fsp--;

             after(grammarAccess.getTypesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypes128); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:97:1: ruleTypes : ( ( rule__Types__Group__0 ) ) ;
    public final void ruleTypes() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:101:2: ( ( ( rule__Types__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:102:1: ( ( rule__Types__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:102:1: ( ( rule__Types__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:103:1: ( rule__Types__Group__0 )
            {
             before(grammarAccess.getTypesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:104:1: ( rule__Types__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:104:2: rule__Types__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Types__Group__0_in_ruleTypes155);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:116:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:117:1: ( ruleType EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:118:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType182);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType189); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:125:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:129:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:130:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:130:1: ( ( rule__Type__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:131:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:132:1: ( rule__Type__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:132:2: rule__Type__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Alternatives_in_ruleType216);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:144:1: entryRuleSimpleType : ruleSimpleType EOF ;
    public final void entryRuleSimpleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:145:1: ( ruleSimpleType EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:146:1: ruleSimpleType EOF
            {
             before(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleType_in_entryRuleSimpleType243);
            ruleSimpleType();
            _fsp--;

             after(grammarAccess.getSimpleTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleType250); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:153:1: ruleSimpleType : ( ( rule__SimpleType__Group__0 ) ) ;
    public final void ruleSimpleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:157:2: ( ( ( rule__SimpleType__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:158:1: ( ( rule__SimpleType__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:158:1: ( ( rule__SimpleType__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:159:1: ( rule__SimpleType__Group__0 )
            {
             before(grammarAccess.getSimpleTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:160:1: ( rule__SimpleType__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:160:2: rule__SimpleType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType277);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:172:1: entryRuleCompositeType : ruleCompositeType EOF ;
    public final void entryRuleCompositeType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:173:1: ( ruleCompositeType EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:174:1: ruleCompositeType EOF
            {
             before(grammarAccess.getCompositeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeType_in_entryRuleCompositeType304);
            ruleCompositeType();
            _fsp--;

             after(grammarAccess.getCompositeTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompositeType311); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:181:1: ruleCompositeType : ( ( rule__CompositeType__Group__0 ) ) ;
    public final void ruleCompositeType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:185:2: ( ( ( rule__CompositeType__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:186:1: ( ( rule__CompositeType__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:186:1: ( ( rule__CompositeType__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:187:1: ( rule__CompositeType__Group__0 )
            {
             before(grammarAccess.getCompositeTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:188:1: ( rule__CompositeType__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:188:2: rule__CompositeType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__0_in_ruleCompositeType338);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:200:1: entryRuleCompositeTypeEntry : ruleCompositeTypeEntry EOF ;
    public final void entryRuleCompositeTypeEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:201:1: ( ruleCompositeTypeEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:202:1: ruleCompositeTypeEntry EOF
            {
             before(grammarAccess.getCompositeTypeEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeTypeEntry_in_entryRuleCompositeTypeEntry365);
            ruleCompositeTypeEntry();
            _fsp--;

             after(grammarAccess.getCompositeTypeEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompositeTypeEntry372); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:209:1: ruleCompositeTypeEntry : ( ( rule__CompositeTypeEntry__DataTypeAssignment ) ) ;
    public final void ruleCompositeTypeEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:213:2: ( ( ( rule__CompositeTypeEntry__DataTypeAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:214:1: ( ( rule__CompositeTypeEntry__DataTypeAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:214:1: ( ( rule__CompositeTypeEntry__DataTypeAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:215:1: ( rule__CompositeTypeEntry__DataTypeAssignment )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:216:1: ( rule__CompositeTypeEntry__DataTypeAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:216:2: rule__CompositeTypeEntry__DataTypeAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeTypeEntry__DataTypeAssignment_in_ruleCompositeTypeEntry399);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:228:1: entryRuleTypeId : ruleTypeId EOF ;
    public final void entryRuleTypeId() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:229:1: ( ruleTypeId EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:230:1: ruleTypeId EOF
            {
             before(grammarAccess.getTypeIdRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeId_in_entryRuleTypeId426);
            ruleTypeId();
            _fsp--;

             after(grammarAccess.getTypeIdRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeId433); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:237:1: ruleTypeId : ( ( rule__TypeId__Group__0 ) ) ;
    public final void ruleTypeId() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:241:2: ( ( ( rule__TypeId__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:242:1: ( ( rule__TypeId__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:242:1: ( ( rule__TypeId__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:243:1: ( rule__TypeId__Group__0 )
            {
             before(grammarAccess.getTypeIdAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:244:1: ( rule__TypeId__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:244:2: rule__TypeId__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group__0_in_ruleTypeId460);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:256:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleCompositeType ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:260:1: ( ( ruleSimpleType ) | ( ruleCompositeType ) )
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
                    new NoViableAltException("256:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleCompositeType ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:261:1: ( ruleSimpleType )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:261:1: ( ruleSimpleType )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:262:1: ruleSimpleType
                    {
                     before(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleType_in_rule__Type__Alternatives496);
                    ruleSimpleType();
                    _fsp--;

                     after(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:267:6: ( ruleCompositeType )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:267:6: ( ruleCompositeType )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:268:1: ruleCompositeType
                    {
                     before(grammarAccess.getTypeAccess().getCompositeTypeParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCompositeType_in_rule__Type__Alternatives513);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:280:1: rule__Types__Group__0 : ( 'Types' ) rule__Types__Group__1 ;
    public final void rule__Types__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:284:1: ( ( 'Types' ) rule__Types__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:285:1: ( 'Types' ) rule__Types__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:285:1: ( 'Types' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:286:1: 'Types'
            {
             before(grammarAccess.getTypesAccess().getTypesKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Types__Group__0548); 
             after(grammarAccess.getTypesAccess().getTypesKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Types__Group__1_in_rule__Types__Group__0558);
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


    // $ANTLR start rule__Types__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:300:1: rule__Types__Group__1 : ( ( rule__Types__TypesAssignment_1 )* ) ;
    public final void rule__Types__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:304:1: ( ( ( rule__Types__TypesAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:305:1: ( ( rule__Types__TypesAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:305:1: ( ( rule__Types__TypesAssignment_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:306:1: ( rule__Types__TypesAssignment_1 )*
            {
             before(grammarAccess.getTypesAccess().getTypesAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:307:1: ( rule__Types__TypesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:307:2: rule__Types__TypesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Types__TypesAssignment_1_in_rule__Types__Group__1586);
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
    // $ANTLR end rule__Types__Group__1


    // $ANTLR start rule__SimpleType__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:321:1: rule__SimpleType__Group__0 : ( 'Type' ) rule__SimpleType__Group__1 ;
    public final void rule__SimpleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:325:1: ( ( 'Type' ) rule__SimpleType__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:326:1: ( 'Type' ) rule__SimpleType__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:326:1: ( 'Type' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:327:1: 'Type'
            {
             before(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__SimpleType__Group__0626); 
             after(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0636);
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


    // $ANTLR start rule__SimpleType__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:341:1: rule__SimpleType__Group__1 : ( ( rule__SimpleType__NameAssignment_1 ) ) rule__SimpleType__Group__2 ;
    public final void rule__SimpleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:345:1: ( ( ( rule__SimpleType__NameAssignment_1 ) ) rule__SimpleType__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:346:1: ( ( rule__SimpleType__NameAssignment_1 ) ) rule__SimpleType__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:346:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:347:1: ( rule__SimpleType__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:348:1: ( rule__SimpleType__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:348:2: rule__SimpleType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1664);
            rule__SimpleType__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SimpleType__Group__2_in_rule__SimpleType__Group__1673);
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


    // $ANTLR start rule__SimpleType__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:359:1: rule__SimpleType__Group__2 : ( ';' ) ;
    public final void rule__SimpleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:363:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:364:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:364:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:365:1: ';'
            {
             before(grammarAccess.getSimpleTypeAccess().getSemicolonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__SimpleType__Group__2702); 
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
    // $ANTLR end rule__SimpleType__Group__2


    // $ANTLR start rule__CompositeType__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:384:1: rule__CompositeType__Group__0 : ( 'Composite' ) rule__CompositeType__Group__1 ;
    public final void rule__CompositeType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:388:1: ( ( 'Composite' ) rule__CompositeType__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:389:1: ( 'Composite' ) rule__CompositeType__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:389:1: ( 'Composite' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:390:1: 'Composite'
            {
             before(grammarAccess.getCompositeTypeAccess().getCompositeKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__CompositeType__Group__0744); 
             after(grammarAccess.getCompositeTypeAccess().getCompositeKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__1_in_rule__CompositeType__Group__0754);
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


    // $ANTLR start rule__CompositeType__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:404:1: rule__CompositeType__Group__1 : ( ( rule__CompositeType__NameAssignment_1 ) ) rule__CompositeType__Group__2 ;
    public final void rule__CompositeType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:408:1: ( ( ( rule__CompositeType__NameAssignment_1 ) ) rule__CompositeType__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:409:1: ( ( rule__CompositeType__NameAssignment_1 ) ) rule__CompositeType__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:409:1: ( ( rule__CompositeType__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:410:1: ( rule__CompositeType__NameAssignment_1 )
            {
             before(grammarAccess.getCompositeTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:411:1: ( rule__CompositeType__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:411:2: rule__CompositeType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__NameAssignment_1_in_rule__CompositeType__Group__1782);
            rule__CompositeType__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getCompositeTypeAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__2_in_rule__CompositeType__Group__1791);
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


    // $ANTLR start rule__CompositeType__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:422:1: rule__CompositeType__Group__2 : ( 'base' ) rule__CompositeType__Group__3 ;
    public final void rule__CompositeType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:426:1: ( ( 'base' ) rule__CompositeType__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:427:1: ( 'base' ) rule__CompositeType__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:427:1: ( 'base' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:428:1: 'base'
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseKeyword_2()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__CompositeType__Group__2820); 
             after(grammarAccess.getCompositeTypeAccess().getBaseKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__3_in_rule__CompositeType__Group__2830);
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


    // $ANTLR start rule__CompositeType__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:442:1: rule__CompositeType__Group__3 : ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) rule__CompositeType__Group__4 ;
    public final void rule__CompositeType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:446:1: ( ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) rule__CompositeType__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:447:1: ( ( rule__CompositeType__BaseTypeAssignment_3 ) ) rule__CompositeType__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:447:1: ( ( rule__CompositeType__BaseTypeAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:448:1: ( rule__CompositeType__BaseTypeAssignment_3 )
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:449:1: ( rule__CompositeType__BaseTypeAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:449:2: rule__CompositeType__BaseTypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__BaseTypeAssignment_3_in_rule__CompositeType__Group__3858);
            rule__CompositeType__BaseTypeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CompositeType__Group__4_in_rule__CompositeType__Group__3867);
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


    // $ANTLR start rule__CompositeType__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:460:1: rule__CompositeType__Group__4 : ( ';' ) ;
    public final void rule__CompositeType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:464:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:465:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:465:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:466:1: ';'
            {
             before(grammarAccess.getCompositeTypeAccess().getSemicolonKeyword_4()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__CompositeType__Group__4896); 
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
    // $ANTLR end rule__CompositeType__Group__4


    // $ANTLR start rule__TypeId__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:489:1: rule__TypeId__Group__0 : ( RULE_ID ) rule__TypeId__Group__1 ;
    public final void rule__TypeId__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:493:1: ( ( RULE_ID ) rule__TypeId__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:494:1: ( RULE_ID ) rule__TypeId__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:494:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:495:1: RULE_ID
            {
             before(grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeId__Group__0941); 
             after(grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group__1_in_rule__TypeId__Group__0949);
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


    // $ANTLR start rule__TypeId__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:507:1: rule__TypeId__Group__1 : ( ( rule__TypeId__Group_1__0 )? ) ;
    public final void rule__TypeId__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:511:1: ( ( ( rule__TypeId__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:512:1: ( ( rule__TypeId__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:512:1: ( ( rule__TypeId__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:513:1: ( rule__TypeId__Group_1__0 )?
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:514:1: ( rule__TypeId__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:514:2: rule__TypeId__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__0_in_rule__TypeId__Group__1977);
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
    // $ANTLR end rule__TypeId__Group__1


    // $ANTLR start rule__TypeId__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:528:1: rule__TypeId__Group_1__0 : ( '<' ) rule__TypeId__Group_1__1 ;
    public final void rule__TypeId__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:532:1: ( ( '<' ) rule__TypeId__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:533:1: ( '<' ) rule__TypeId__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:533:1: ( '<' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:534:1: '<'
            {
             before(grammarAccess.getTypeIdAccess().getLessThanSignKeyword_1_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__TypeId__Group_1__01017); 
             after(grammarAccess.getTypeIdAccess().getLessThanSignKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__1_in_rule__TypeId__Group_1__01027);
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


    // $ANTLR start rule__TypeId__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:548:1: rule__TypeId__Group_1__1 : ( ruleTypeId ) rule__TypeId__Group_1__2 ;
    public final void rule__TypeId__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:552:1: ( ( ruleTypeId ) rule__TypeId__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:553:1: ( ruleTypeId ) rule__TypeId__Group_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:553:1: ( ruleTypeId )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:554:1: ruleTypeId
            {
             before(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeId_in_rule__TypeId__Group_1__11055);
            ruleTypeId();
            _fsp--;

             after(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__2_in_rule__TypeId__Group_1__11063);
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


    // $ANTLR start rule__TypeId__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:566:1: rule__TypeId__Group_1__2 : ( ( rule__TypeId__Group_1_2__0 )* ) rule__TypeId__Group_1__3 ;
    public final void rule__TypeId__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:570:1: ( ( ( rule__TypeId__Group_1_2__0 )* ) rule__TypeId__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:571:1: ( ( rule__TypeId__Group_1_2__0 )* ) rule__TypeId__Group_1__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:571:1: ( ( rule__TypeId__Group_1_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:572:1: ( rule__TypeId__Group_1_2__0 )*
            {
             before(grammarAccess.getTypeIdAccess().getGroup_1_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:573:1: ( rule__TypeId__Group_1_2__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:573:2: rule__TypeId__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1_2__0_in_rule__TypeId__Group_1__21091);
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

            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1__3_in_rule__TypeId__Group_1__21101);
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


    // $ANTLR start rule__TypeId__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:584:1: rule__TypeId__Group_1__3 : ( '>' ) ;
    public final void rule__TypeId__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:588:1: ( ( '>' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:589:1: ( '>' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:589:1: ( '>' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:590:1: '>'
            {
             before(grammarAccess.getTypeIdAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__TypeId__Group_1__31130); 
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
    // $ANTLR end rule__TypeId__Group_1__3


    // $ANTLR start rule__TypeId__Group_1_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:611:1: rule__TypeId__Group_1_2__0 : ( ',' ) rule__TypeId__Group_1_2__1 ;
    public final void rule__TypeId__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:615:1: ( ( ',' ) rule__TypeId__Group_1_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:616:1: ( ',' ) rule__TypeId__Group_1_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:616:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:617:1: ','
            {
             before(grammarAccess.getTypeIdAccess().getCommaKeyword_1_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__TypeId__Group_1_2__01174); 
             after(grammarAccess.getTypeIdAccess().getCommaKeyword_1_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TypeId__Group_1_2__1_in_rule__TypeId__Group_1_2__01184);
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


    // $ANTLR start rule__TypeId__Group_1_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:631:1: rule__TypeId__Group_1_2__1 : ( ruleTypeId ) ;
    public final void rule__TypeId__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:635:1: ( ( ruleTypeId ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:636:1: ( ruleTypeId )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:636:1: ( ruleTypeId )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:637:1: ruleTypeId
            {
             before(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_2_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeId_in_rule__TypeId__Group_1_2__11212);
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
    // $ANTLR end rule__TypeId__Group_1_2__1


    // $ANTLR start rule__Types__TypesAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:652:1: rule__Types__TypesAssignment_1 : ( ruleType ) ;
    public final void rule__Types__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:656:1: ( ( ruleType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:657:1: ( ruleType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:657:1: ( ruleType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:658:1: ruleType
            {
             before(grammarAccess.getTypesAccess().getTypesTypeParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_rule__Types__TypesAssignment_11249);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:667:1: rule__SimpleType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:671:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:672:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:672:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:673:1: RULE_ID
            {
             before(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_11280); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:682:1: rule__CompositeType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CompositeType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:686:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:687:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:687:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:688:1: RULE_ID
            {
             before(grammarAccess.getCompositeTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__CompositeType__NameAssignment_11311); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:697:1: rule__CompositeType__BaseTypeAssignment_3 : ( ruleCompositeTypeEntry ) ;
    public final void rule__CompositeType__BaseTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:701:1: ( ( ruleCompositeTypeEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:702:1: ( ruleCompositeTypeEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:702:1: ( ruleCompositeTypeEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:703:1: ruleCompositeTypeEntry
            {
             before(grammarAccess.getCompositeTypeAccess().getBaseTypeCompositeTypeEntryParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeTypeEntry_in_rule__CompositeType__BaseTypeAssignment_31342);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:712:1: rule__CompositeTypeEntry__DataTypeAssignment : ( ( ruleTypeId ) ) ;
    public final void rule__CompositeTypeEntry__DataTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:716:1: ( ( ( ruleTypeId ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:717:1: ( ( ruleTypeId ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:717:1: ( ( ruleTypeId ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:718:1: ( ruleTypeId )
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:719:1: ( ruleTypeId )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalDatatypeRuleTestLanguage.g:720:1: ruleTypeId
            {
             before(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeTypeIdParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeId_in_rule__CompositeTypeEntry__DataTypeAssignment1377);
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
        public static final BitSet FOLLOW_ruleTypes_in_ruleModel95 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypes_in_entryRuleTypes121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypes128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Types__Group__0_in_ruleTypes155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType243 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeType_in_entryRuleCompositeType304 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompositeType311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__0_in_ruleCompositeType338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeTypeEntry_in_entryRuleCompositeTypeEntry365 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompositeTypeEntry372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeTypeEntry__DataTypeAssignment_in_ruleCompositeTypeEntry399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeId_in_entryRuleTypeId426 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeId433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group__0_in_ruleTypeId460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleType_in_rule__Type__Alternatives496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeType_in_rule__Type__Alternatives513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Types__Group__0548 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_rule__Types__Group__1_in_rule__Types__Group__0558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Types__TypesAssignment_1_in_rule__Types__Group__1586 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_12_in_rule__SimpleType__Group__0626 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1664 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__SimpleType__Group__2_in_rule__SimpleType__Group__1673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__SimpleType__Group__2702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__CompositeType__Group__0744 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__1_in_rule__CompositeType__Group__0754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__NameAssignment_1_in_rule__CompositeType__Group__1782 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__2_in_rule__CompositeType__Group__1791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__CompositeType__Group__2820 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__3_in_rule__CompositeType__Group__2830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CompositeType__BaseTypeAssignment_3_in_rule__CompositeType__Group__3858 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__CompositeType__Group__4_in_rule__CompositeType__Group__3867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__CompositeType__Group__4896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeId__Group__0941 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_rule__TypeId__Group__1_in_rule__TypeId__Group__0949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__0_in_rule__TypeId__Group__1977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__TypeId__Group_1__01017 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__1_in_rule__TypeId__Group_1__01027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeId_in_rule__TypeId__Group_1__11055 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__2_in_rule__TypeId__Group_1__11063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1_2__0_in_rule__TypeId__Group_1__21091 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1__3_in_rule__TypeId__Group_1__21101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__TypeId__Group_1__31130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__TypeId__Group_1_2__01174 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TypeId__Group_1_2__1_in_rule__TypeId__Group_1_2__01184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeId_in_rule__TypeId__Group_1_2__11212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_rule__Types__TypesAssignment_11249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_11280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__CompositeType__NameAssignment_11311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeTypeEntry_in_rule__CompositeType__BaseTypeAssignment_31342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeId_in_rule__CompositeTypeEntry__DataTypeAssignment1377 = new BitSet(new long[]{0x0000000000000002L});
    }


}
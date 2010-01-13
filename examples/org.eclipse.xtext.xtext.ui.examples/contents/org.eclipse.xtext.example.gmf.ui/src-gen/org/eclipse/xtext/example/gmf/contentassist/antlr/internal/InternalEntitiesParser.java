package org.eclipse.xtext.example.gmf.contentassist.antlr.internal; 

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
import org.eclipse.xtext.example.gmf.services.EntitiesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEntitiesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'entity'", "'{'", "'}'", "'extends'", "'property'", "':'", "'reference'", "'[]'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalEntitiesParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g"; }


     
     	private EntitiesGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EntitiesGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:76:1: ( rule__Model__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:76:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel95);
            rule__Model__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:88:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:89:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:90:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport122);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport129); 

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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:97:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:101:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:102:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:102:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:103:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:104:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:104:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport156);
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


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:116:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:117:1: ( ruleType EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:118:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType183);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType190); 

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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:125:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:129:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:130:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:130:1: ( ( rule__Type__Alternatives ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:131:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:132:1: ( rule__Type__Alternatives )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:132:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_rule__Type__Alternatives_in_ruleType217);
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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:144:1: entryRuleSimpleType : ruleSimpleType EOF ;
    public final void entryRuleSimpleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:145:1: ( ruleSimpleType EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:146:1: ruleSimpleType EOF
            {
             before(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FOLLOW_ruleSimpleType_in_entryRuleSimpleType244);
            ruleSimpleType();
            _fsp--;

             after(grammarAccess.getSimpleTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleType251); 

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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:153:1: ruleSimpleType : ( ( rule__SimpleType__Group__0 ) ) ;
    public final void ruleSimpleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:157:2: ( ( ( rule__SimpleType__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:158:1: ( ( rule__SimpleType__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:158:1: ( ( rule__SimpleType__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:159:1: ( rule__SimpleType__Group__0 )
            {
             before(grammarAccess.getSimpleTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:160:1: ( rule__SimpleType__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:160:2: rule__SimpleType__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType278);
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


    // $ANTLR start entryRuleEntity
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:172:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:173:1: ( ruleEntity EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:174:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity305);
            ruleEntity();
            _fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity312); 

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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:181:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:185:2: ( ( ( rule__Entity__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:186:1: ( ( rule__Entity__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:186:1: ( ( rule__Entity__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:187:1: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:188:1: ( rule__Entity__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:188:2: rule__Entity__Group__0
            {
            pushFollow(FOLLOW_rule__Entity__Group__0_in_ruleEntity339);
            rule__Entity__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start entryRuleProperty
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:200:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:201:1: ( ruleProperty EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:202:1: ruleProperty EOF
            {
             before(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty366);
            ruleProperty();
            _fsp--;

             after(grammarAccess.getPropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty373); 

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
    // $ANTLR end entryRuleProperty


    // $ANTLR start ruleProperty
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:209:1: ruleProperty : ( ( rule__Property__Alternatives ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:213:2: ( ( ( rule__Property__Alternatives ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:214:1: ( ( rule__Property__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:214:1: ( ( rule__Property__Alternatives ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:215:1: ( rule__Property__Alternatives )
            {
             before(grammarAccess.getPropertyAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:216:1: ( rule__Property__Alternatives )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:216:2: rule__Property__Alternatives
            {
            pushFollow(FOLLOW_rule__Property__Alternatives_in_ruleProperty400);
            rule__Property__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getPropertyAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleProperty


    // $ANTLR start entryRuleSimpleProperty
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:228:1: entryRuleSimpleProperty : ruleSimpleProperty EOF ;
    public final void entryRuleSimpleProperty() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:229:1: ( ruleSimpleProperty EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:230:1: ruleSimpleProperty EOF
            {
             before(grammarAccess.getSimplePropertyRule()); 
            pushFollow(FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty427);
            ruleSimpleProperty();
            _fsp--;

             after(grammarAccess.getSimplePropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleProperty434); 

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
    // $ANTLR end entryRuleSimpleProperty


    // $ANTLR start ruleSimpleProperty
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:237:1: ruleSimpleProperty : ( ( rule__SimpleProperty__Group__0 ) ) ;
    public final void ruleSimpleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:241:2: ( ( ( rule__SimpleProperty__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:242:1: ( ( rule__SimpleProperty__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:242:1: ( ( rule__SimpleProperty__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:243:1: ( rule__SimpleProperty__Group__0 )
            {
             before(grammarAccess.getSimplePropertyAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:244:1: ( rule__SimpleProperty__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:244:2: rule__SimpleProperty__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleProperty__Group__0_in_ruleSimpleProperty461);
            rule__SimpleProperty__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSimpleProperty


    // $ANTLR start entryRuleReference
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:256:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:257:1: ( ruleReference EOF )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:258:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference488);
            ruleReference();
            _fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference495); 

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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:265:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:269:2: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:270:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:270:1: ( ( rule__Reference__Group__0 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:271:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:272:1: ( rule__Reference__Group__0 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:272:2: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_rule__Reference__Group__0_in_ruleReference522);
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


    // $ANTLR start rule__Type__Alternatives
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:284:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleEntity ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:288:1: ( ( ruleSimpleType ) | ( ruleEntity ) )
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
                    new NoViableAltException("284:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleEntity ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:289:1: ( ruleSimpleType )
                    {
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:289:1: ( ruleSimpleType )
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:290:1: ruleSimpleType
                    {
                     before(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleType_in_rule__Type__Alternatives558);
                    ruleSimpleType();
                    _fsp--;

                     after(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:295:6: ( ruleEntity )
                    {
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:295:6: ( ruleEntity )
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:296:1: ruleEntity
                    {
                     before(grammarAccess.getTypeAccess().getEntityParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEntity_in_rule__Type__Alternatives575);
                    ruleEntity();
                    _fsp--;

                     after(grammarAccess.getTypeAccess().getEntityParserRuleCall_1()); 

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


    // $ANTLR start rule__Property__Alternatives
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:306:1: rule__Property__Alternatives : ( ( ruleSimpleProperty ) | ( ruleReference ) );
    public final void rule__Property__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:310:1: ( ( ruleSimpleProperty ) | ( ruleReference ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            else if ( (LA2_0==19) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("306:1: rule__Property__Alternatives : ( ( ruleSimpleProperty ) | ( ruleReference ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:311:1: ( ruleSimpleProperty )
                    {
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:311:1: ( ruleSimpleProperty )
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:312:1: ruleSimpleProperty
                    {
                     before(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleProperty_in_rule__Property__Alternatives607);
                    ruleSimpleProperty();
                    _fsp--;

                     after(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:317:6: ( ruleReference )
                    {
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:317:6: ( ruleReference )
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:318:1: ruleReference
                    {
                     before(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__Property__Alternatives624);
                    ruleReference();
                    _fsp--;

                     after(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1()); 

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
    // $ANTLR end rule__Property__Alternatives


    // $ANTLR start rule__Model__Group__0
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:330:1: rule__Model__Group__0 : ( () ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:334:1: ( ( () ) rule__Model__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:335:1: ( () ) rule__Model__Group__1
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:335:1: ( () )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:336:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:337:1: ()
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:339:1: 
            {
            }

             after(grammarAccess.getModelAccess().getModelAction_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0668);
            rule__Model__Group__1();
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
    // $ANTLR end rule__Model__Group__0


    // $ANTLR start rule__Model__Group__1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:350:1: rule__Model__Group__1 : ( ( rule__Model__ImportsAssignment_1 )* ) rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:354:1: ( ( ( rule__Model__ImportsAssignment_1 )* ) rule__Model__Group__2 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:355:1: ( ( rule__Model__ImportsAssignment_1 )* ) rule__Model__Group__2
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:355:1: ( ( rule__Model__ImportsAssignment_1 )* )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:356:1: ( rule__Model__ImportsAssignment_1 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:357:1: ( rule__Model__ImportsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:357:2: rule__Model__ImportsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Model__ImportsAssignment_1_in_rule__Model__Group__1696);
            	    rule__Model__ImportsAssignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1706);
            rule__Model__Group__2();
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
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Model__Group__2
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:368:1: rule__Model__Group__2 : ( ( rule__Model__ElementsAssignment_2 )* ) ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:372:1: ( ( ( rule__Model__ElementsAssignment_2 )* ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:373:1: ( ( rule__Model__ElementsAssignment_2 )* )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:373:1: ( ( rule__Model__ElementsAssignment_2 )* )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:374:1: ( rule__Model__ElementsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment_2()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:375:1: ( rule__Model__ElementsAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=12 && LA4_0<=13)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:375:2: rule__Model__ElementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__ElementsAssignment_2_in_rule__Model__Group__2734);
            	    rule__Model__ElementsAssignment_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__2


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:391:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:395:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:396:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:396:1: ( 'import' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:397:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Import__Group__0776); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0786);
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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:411:1: rule__Import__Group__1 : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:415:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:416:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:416:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:417:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:418:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:418:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1814);
            rule__Import__ImportURIAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start rule__SimpleType__Group__0
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:432:1: rule__SimpleType__Group__0 : ( 'type' ) rule__SimpleType__Group__1 ;
    public final void rule__SimpleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:436:1: ( ( 'type' ) rule__SimpleType__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:437:1: ( 'type' ) rule__SimpleType__Group__1
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:437:1: ( 'type' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:438:1: 'type'
            {
             before(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__SimpleType__Group__0853); 
             after(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0863);
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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:452:1: rule__SimpleType__Group__1 : ( ( rule__SimpleType__NameAssignment_1 ) ) ;
    public final void rule__SimpleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:456:1: ( ( ( rule__SimpleType__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:457:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:457:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:458:1: ( rule__SimpleType__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:459:1: ( rule__SimpleType__NameAssignment_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:459:2: rule__SimpleType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1891);
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
    // $ANTLR end rule__SimpleType__Group__1


    // $ANTLR start rule__Entity__Group__0
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:473:1: rule__Entity__Group__0 : ( 'entity' ) rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:477:1: ( ( 'entity' ) rule__Entity__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:478:1: ( 'entity' ) rule__Entity__Group__1
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:478:1: ( 'entity' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:479:1: 'entity'
            {
             before(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__Entity__Group__0930); 
             after(grammarAccess.getEntityAccess().getEntityKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__0940);
            rule__Entity__Group__1();
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
    // $ANTLR end rule__Entity__Group__0


    // $ANTLR start rule__Entity__Group__1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:493:1: rule__Entity__Group__1 : ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:497:1: ( ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:498:1: ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:498:1: ( ( rule__Entity__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:499:1: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:500:1: ( rule__Entity__NameAssignment_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:500:2: rule__Entity__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1968);
            rule__Entity__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__1977);
            rule__Entity__Group__2();
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
    // $ANTLR end rule__Entity__Group__1


    // $ANTLR start rule__Entity__Group__2
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:511:1: rule__Entity__Group__2 : ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:515:1: ( ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:516:1: ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:516:1: ( ( rule__Entity__Group_2__0 )? )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:517:1: ( rule__Entity__Group_2__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:518:1: ( rule__Entity__Group_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:518:2: rule__Entity__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__21005);
                    rule__Entity__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__21015);
            rule__Entity__Group__3();
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
    // $ANTLR end rule__Entity__Group__2


    // $ANTLR start rule__Entity__Group__3
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:529:1: rule__Entity__Group__3 : ( '{' ) rule__Entity__Group__4 ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:533:1: ( ( '{' ) rule__Entity__Group__4 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:534:1: ( '{' ) rule__Entity__Group__4
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:534:1: ( '{' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:535:1: '{'
            {
             before(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,14,FOLLOW_14_in_rule__Entity__Group__31044); 
             after(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__31054);
            rule__Entity__Group__4();
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
    // $ANTLR end rule__Entity__Group__3


    // $ANTLR start rule__Entity__Group__4
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:549:1: rule__Entity__Group__4 : ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5 ;
    public final void rule__Entity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:553:1: ( ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:554:1: ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:554:1: ( ( rule__Entity__PropertiesAssignment_4 )* )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:555:1: ( rule__Entity__PropertiesAssignment_4 )*
            {
             before(grammarAccess.getEntityAccess().getPropertiesAssignment_4()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:556:1: ( rule__Entity__PropertiesAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17||LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:556:2: rule__Entity__PropertiesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Entity__PropertiesAssignment_4_in_rule__Entity__Group__41082);
            	    rule__Entity__PropertiesAssignment_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getEntityAccess().getPropertiesAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__41092);
            rule__Entity__Group__5();
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
    // $ANTLR end rule__Entity__Group__4


    // $ANTLR start rule__Entity__Group__5
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:567:1: rule__Entity__Group__5 : ( '}' ) ;
    public final void rule__Entity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:571:1: ( ( '}' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:572:1: ( '}' )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:572:1: ( '}' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:573:1: '}'
            {
             before(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 
            match(input,15,FOLLOW_15_in_rule__Entity__Group__51121); 
             after(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:598:1: rule__Entity__Group_2__0 : ( 'extends' ) rule__Entity__Group_2__1 ;
    public final void rule__Entity__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:602:1: ( ( 'extends' ) rule__Entity__Group_2__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:603:1: ( 'extends' ) rule__Entity__Group_2__1
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:603:1: ( 'extends' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:604:1: 'extends'
            {
             before(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 
            match(input,16,FOLLOW_16_in_rule__Entity__Group_2__01169); 
             after(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__01179);
            rule__Entity__Group_2__1();
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
    // $ANTLR end rule__Entity__Group_2__0


    // $ANTLR start rule__Entity__Group_2__1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:618:1: rule__Entity__Group_2__1 : ( ( rule__Entity__ExtendsAssignment_2_1 ) ) ;
    public final void rule__Entity__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:622:1: ( ( ( rule__Entity__ExtendsAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:623:1: ( ( rule__Entity__ExtendsAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:623:1: ( ( rule__Entity__ExtendsAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:624:1: ( rule__Entity__ExtendsAssignment_2_1 )
            {
             before(grammarAccess.getEntityAccess().getExtendsAssignment_2_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:625:1: ( rule__Entity__ExtendsAssignment_2_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:625:2: rule__Entity__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Entity__ExtendsAssignment_2_1_in_rule__Entity__Group_2__11207);
            rule__Entity__ExtendsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getExtendsAssignment_2_1()); 

            }


            }

        }
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


    // $ANTLR start rule__SimpleProperty__Group__0
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:639:1: rule__SimpleProperty__Group__0 : ( 'property' ) rule__SimpleProperty__Group__1 ;
    public final void rule__SimpleProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:643:1: ( ( 'property' ) rule__SimpleProperty__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:644:1: ( 'property' ) rule__SimpleProperty__Group__1
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:644:1: ( 'property' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:645:1: 'property'
            {
             before(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__SimpleProperty__Group__01246); 
             after(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group__1_in_rule__SimpleProperty__Group__01256);
            rule__SimpleProperty__Group__1();
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
    // $ANTLR end rule__SimpleProperty__Group__0


    // $ANTLR start rule__SimpleProperty__Group__1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:659:1: rule__SimpleProperty__Group__1 : ( ( rule__SimpleProperty__NameAssignment_1 ) ) rule__SimpleProperty__Group__2 ;
    public final void rule__SimpleProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:663:1: ( ( ( rule__SimpleProperty__NameAssignment_1 ) ) rule__SimpleProperty__Group__2 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:664:1: ( ( rule__SimpleProperty__NameAssignment_1 ) ) rule__SimpleProperty__Group__2
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:664:1: ( ( rule__SimpleProperty__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:665:1: ( rule__SimpleProperty__NameAssignment_1 )
            {
             before(grammarAccess.getSimplePropertyAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:666:1: ( rule__SimpleProperty__NameAssignment_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:666:2: rule__SimpleProperty__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleProperty__NameAssignment_1_in_rule__SimpleProperty__Group__11284);
            rule__SimpleProperty__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group__2_in_rule__SimpleProperty__Group__11293);
            rule__SimpleProperty__Group__2();
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
    // $ANTLR end rule__SimpleProperty__Group__1


    // $ANTLR start rule__SimpleProperty__Group__2
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:677:1: rule__SimpleProperty__Group__2 : ( ( rule__SimpleProperty__Group_2__0 )? ) ;
    public final void rule__SimpleProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:681:1: ( ( ( rule__SimpleProperty__Group_2__0 )? ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:682:1: ( ( rule__SimpleProperty__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:682:1: ( ( rule__SimpleProperty__Group_2__0 )? )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:683:1: ( rule__SimpleProperty__Group_2__0 )?
            {
             before(grammarAccess.getSimplePropertyAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:684:1: ( rule__SimpleProperty__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:684:2: rule__SimpleProperty__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__SimpleProperty__Group_2__0_in_rule__SimpleProperty__Group__21321);
                    rule__SimpleProperty__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimplePropertyAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__Group__2


    // $ANTLR start rule__SimpleProperty__Group_2__0
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:700:1: rule__SimpleProperty__Group_2__0 : ( ':' ) rule__SimpleProperty__Group_2__1 ;
    public final void rule__SimpleProperty__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:704:1: ( ( ':' ) rule__SimpleProperty__Group_2__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:705:1: ( ':' ) rule__SimpleProperty__Group_2__1
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:705:1: ( ':' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:706:1: ':'
            {
             before(grammarAccess.getSimplePropertyAccess().getColonKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__SimpleProperty__Group_2__01363); 
             after(grammarAccess.getSimplePropertyAccess().getColonKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group_2__1_in_rule__SimpleProperty__Group_2__01373);
            rule__SimpleProperty__Group_2__1();
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
    // $ANTLR end rule__SimpleProperty__Group_2__0


    // $ANTLR start rule__SimpleProperty__Group_2__1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:720:1: rule__SimpleProperty__Group_2__1 : ( ( rule__SimpleProperty__TypeAssignment_2_1 ) ) rule__SimpleProperty__Group_2__2 ;
    public final void rule__SimpleProperty__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:724:1: ( ( ( rule__SimpleProperty__TypeAssignment_2_1 ) ) rule__SimpleProperty__Group_2__2 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:725:1: ( ( rule__SimpleProperty__TypeAssignment_2_1 ) ) rule__SimpleProperty__Group_2__2
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:725:1: ( ( rule__SimpleProperty__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:726:1: ( rule__SimpleProperty__TypeAssignment_2_1 )
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:727:1: ( rule__SimpleProperty__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:727:2: rule__SimpleProperty__TypeAssignment_2_1
            {
            pushFollow(FOLLOW_rule__SimpleProperty__TypeAssignment_2_1_in_rule__SimpleProperty__Group_2__11401);
            rule__SimpleProperty__TypeAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getTypeAssignment_2_1()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group_2__2_in_rule__SimpleProperty__Group_2__11410);
            rule__SimpleProperty__Group_2__2();
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
    // $ANTLR end rule__SimpleProperty__Group_2__1


    // $ANTLR start rule__SimpleProperty__Group_2__2
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:738:1: rule__SimpleProperty__Group_2__2 : ( ( rule__SimpleProperty__ManyAssignment_2_2 )? ) ;
    public final void rule__SimpleProperty__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:742:1: ( ( ( rule__SimpleProperty__ManyAssignment_2_2 )? ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:743:1: ( ( rule__SimpleProperty__ManyAssignment_2_2 )? )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:743:1: ( ( rule__SimpleProperty__ManyAssignment_2_2 )? )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:744:1: ( rule__SimpleProperty__ManyAssignment_2_2 )?
            {
             before(grammarAccess.getSimplePropertyAccess().getManyAssignment_2_2()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:745:1: ( rule__SimpleProperty__ManyAssignment_2_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:745:2: rule__SimpleProperty__ManyAssignment_2_2
                    {
                    pushFollow(FOLLOW_rule__SimpleProperty__ManyAssignment_2_2_in_rule__SimpleProperty__Group_2__21438);
                    rule__SimpleProperty__ManyAssignment_2_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimplePropertyAccess().getManyAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__Group_2__2


    // $ANTLR start rule__Reference__Group__0
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:761:1: rule__Reference__Group__0 : ( 'reference' ) rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:765:1: ( ( 'reference' ) rule__Reference__Group__1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:766:1: ( 'reference' ) rule__Reference__Group__1
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:766:1: ( 'reference' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:767:1: 'reference'
            {
             before(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__Reference__Group__01480); 
             after(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__01490);
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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:781:1: rule__Reference__Group__1 : ( ( rule__Reference__NameAssignment_1 ) ) rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:785:1: ( ( ( rule__Reference__NameAssignment_1 ) ) rule__Reference__Group__2 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:786:1: ( ( rule__Reference__NameAssignment_1 ) ) rule__Reference__Group__2
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:786:1: ( ( rule__Reference__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:787:1: ( rule__Reference__NameAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:788:1: ( rule__Reference__NameAssignment_1 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:788:2: rule__Reference__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Reference__NameAssignment_1_in_rule__Reference__Group__11518);
            rule__Reference__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__11527);
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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:799:1: rule__Reference__Group__2 : ( ':' ) rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:803:1: ( ( ':' ) rule__Reference__Group__3 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:804:1: ( ':' ) rule__Reference__Group__3
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:804:1: ( ':' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:805:1: ':'
            {
             before(grammarAccess.getReferenceAccess().getColonKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__Reference__Group__21556); 
             after(grammarAccess.getReferenceAccess().getColonKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__21566);
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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:819:1: rule__Reference__Group__3 : ( ( rule__Reference__TypeAssignment_3 ) ) rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:823:1: ( ( ( rule__Reference__TypeAssignment_3 ) ) rule__Reference__Group__4 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:824:1: ( ( rule__Reference__TypeAssignment_3 ) ) rule__Reference__Group__4
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:824:1: ( ( rule__Reference__TypeAssignment_3 ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:825:1: ( rule__Reference__TypeAssignment_3 )
            {
             before(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:826:1: ( rule__Reference__TypeAssignment_3 )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:826:2: rule__Reference__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__Reference__TypeAssignment_3_in_rule__Reference__Group__31594);
            rule__Reference__TypeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__31603);
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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:837:1: rule__Reference__Group__4 : ( ( rule__Reference__ManyAssignment_4 )? ) ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:841:1: ( ( ( rule__Reference__ManyAssignment_4 )? ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:842:1: ( ( rule__Reference__ManyAssignment_4 )? )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:842:1: ( ( rule__Reference__ManyAssignment_4 )? )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:843:1: ( rule__Reference__ManyAssignment_4 )?
            {
             before(grammarAccess.getReferenceAccess().getManyAssignment_4()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:844:1: ( rule__Reference__ManyAssignment_4 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:844:2: rule__Reference__ManyAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Reference__ManyAssignment_4_in_rule__Reference__Group__41631);
                    rule__Reference__ManyAssignment_4();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferenceAccess().getManyAssignment_4()); 

            }


            }

        }
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


    // $ANTLR start rule__Model__ImportsAssignment_1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:864:1: rule__Model__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:868:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:869:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:869:1: ( ruleImport )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:870:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_11676);
            ruleImport();
            _fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ImportsAssignment_1


    // $ANTLR start rule__Model__ElementsAssignment_2
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:879:1: rule__Model__ElementsAssignment_2 : ( ruleType ) ;
    public final void rule__Model__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:883:1: ( ( ruleType ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:884:1: ( ruleType )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:884:1: ( ruleType )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:885:1: ruleType
            {
             before(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleType_in_rule__Model__ElementsAssignment_21707);
            ruleType();
            _fsp--;

             after(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ElementsAssignment_2


    // $ANTLR start rule__Import__ImportURIAssignment_1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:894:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:898:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:899:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:899:1: ( RULE_STRING )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:900:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_11738); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__ImportURIAssignment_1


    // $ANTLR start rule__SimpleType__NameAssignment_1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:909:1: rule__SimpleType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:913:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:914:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:914:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:915:1: RULE_ID
            {
             before(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_11769); 
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


    // $ANTLR start rule__Entity__NameAssignment_1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:924:1: rule__Entity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:928:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:929:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:929:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:930:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_11800); 
             after(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
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


    // $ANTLR start rule__Entity__ExtendsAssignment_2_1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:939:1: rule__Entity__ExtendsAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Entity__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:943:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:944:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:944:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:945:1: ( RULE_ID )
            {
             before(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:946:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:947:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getExtendsEntityIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__ExtendsAssignment_2_11835); 
             after(grammarAccess.getEntityAccess().getExtendsEntityIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__ExtendsAssignment_2_1


    // $ANTLR start rule__Entity__PropertiesAssignment_4
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:958:1: rule__Entity__PropertiesAssignment_4 : ( ruleProperty ) ;
    public final void rule__Entity__PropertiesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:962:1: ( ( ruleProperty ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:963:1: ( ruleProperty )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:963:1: ( ruleProperty )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:964:1: ruleProperty
            {
             before(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_41870);
            ruleProperty();
            _fsp--;

             after(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__PropertiesAssignment_4


    // $ANTLR start rule__SimpleProperty__NameAssignment_1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:973:1: rule__SimpleProperty__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleProperty__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:977:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:978:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:978:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:979:1: RULE_ID
            {
             before(grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleProperty__NameAssignment_11901); 
             after(grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__NameAssignment_1


    // $ANTLR start rule__SimpleProperty__TypeAssignment_2_1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:988:1: rule__SimpleProperty__TypeAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__SimpleProperty__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:992:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:993:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:993:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:994:1: ( RULE_ID )
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:995:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:996:1: RULE_ID
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleProperty__TypeAssignment_2_11936); 
             after(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__TypeAssignment_2_1


    // $ANTLR start rule__SimpleProperty__ManyAssignment_2_2
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1007:1: rule__SimpleProperty__ManyAssignment_2_2 : ( ( '[]' ) ) ;
    public final void rule__SimpleProperty__ManyAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1011:1: ( ( ( '[]' ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1012:1: ( ( '[]' ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1012:1: ( ( '[]' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1013:1: ( '[]' )
            {
             before(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1014:1: ( '[]' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1015:1: '[]'
            {
             before(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 
            match(input,20,FOLLOW_20_in_rule__SimpleProperty__ManyAssignment_2_21976); 
             after(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 

            }

             after(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__ManyAssignment_2_2


    // $ANTLR start rule__Reference__NameAssignment_1
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1030:1: rule__Reference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Reference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1034:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1035:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1035:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1036:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_12015); 
             after(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1045:1: rule__Reference__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1049:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1050:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1050:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1051:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getTypeEntityCrossReference_3_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1052:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1053:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getTypeEntityIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__TypeAssignment_32050); 
             after(grammarAccess.getReferenceAccess().getTypeEntityIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getTypeEntityCrossReference_3_0()); 

            }


            }

        }
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


    // $ANTLR start rule__Reference__ManyAssignment_4
    // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1064:1: rule__Reference__ManyAssignment_4 : ( ( '[]' ) ) ;
    public final void rule__Reference__ManyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1068:1: ( ( ( '[]' ) ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1069:1: ( ( '[]' ) )
            {
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1069:1: ( ( '[]' ) )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1070:1: ( '[]' )
            {
             before(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1071:1: ( '[]' )
            // ../org.eclipse.xtext.example.gmf.ui/src-gen/org/eclipse/xtext/example/gmf/contentassist/antlr/internal/InternalEntities.g:1072:1: '[]'
            {
             before(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            match(input,20,FOLLOW_20_in_rule__Reference__ManyAssignment_42090); 
             after(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 

            }

             after(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__ManyAssignment_4


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity305 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__0_in_ruleEntity339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__Alternatives_in_ruleProperty400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleProperty434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__0_in_ruleSimpleProperty461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_rule__Type__Alternatives558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_rule__Type__Alternatives575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_rule__Property__Alternatives607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__Property__Alternatives624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ImportsAssignment_1_in_rule__Model__Group__1696 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ElementsAssignment_2_in_rule__Model__Group__2734 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_11_in_rule__Import__Group__0776 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__SimpleType__Group__0853 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Entity__Group__0930 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__0940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1968 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__21005 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__21015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Entity__Group__31044 = new BitSet(new long[]{0x00000000000A8000L});
    public static final BitSet FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__31054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__PropertiesAssignment_4_in_rule__Entity__Group__41082 = new BitSet(new long[]{0x00000000000A8000L});
    public static final BitSet FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__41092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Entity__Group__51121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Entity__Group_2__01169 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__01179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__ExtendsAssignment_2_1_in_rule__Entity__Group_2__11207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SimpleProperty__Group__01246 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__1_in_rule__SimpleProperty__Group__01256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__NameAssignment_1_in_rule__SimpleProperty__Group__11284 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__2_in_rule__SimpleProperty__Group__11293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__0_in_rule__SimpleProperty__Group__21321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__SimpleProperty__Group_2__01363 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__1_in_rule__SimpleProperty__Group_2__01373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__TypeAssignment_2_1_in_rule__SimpleProperty__Group_2__11401 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__2_in_rule__SimpleProperty__Group_2__11410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__ManyAssignment_2_2_in_rule__SimpleProperty__Group_2__21438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Reference__Group__01480 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__01490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__NameAssignment_1_in_rule__Reference__Group__11518 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__11527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Reference__Group__21556 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__21566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__TypeAssignment_3_in_rule__Reference__Group__31594 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__31603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__ManyAssignment_4_in_rule__Reference__Group__41631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_11676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Model__ElementsAssignment_21707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_11738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_11769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_11800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__ExtendsAssignment_2_11835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_41870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleProperty__NameAssignment_11901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleProperty__TypeAssignment_2_11936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SimpleProperty__ManyAssignment_2_21976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_12015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__TypeAssignment_32050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Reference__ManyAssignment_42090 = new BitSet(new long[]{0x0000000000000002L});

}
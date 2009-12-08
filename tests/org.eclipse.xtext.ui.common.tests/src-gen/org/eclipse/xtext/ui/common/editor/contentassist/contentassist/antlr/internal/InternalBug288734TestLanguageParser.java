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
import org.eclipse.xtext.ui.common.editor.contentassist.services.Bug288734TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug288734TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'constant'", "'string'", "'integer'", "'boolean'", "'@desc'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug288734TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g"; }


     
     	private Bug288734TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug288734TestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:62:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:69:1: ruleModel : ( ( rule__Model__ConstantsAssignment ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:73:2: ( ( ( rule__Model__ConstantsAssignment ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:74:1: ( ( rule__Model__ConstantsAssignment ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:74:1: ( ( rule__Model__ConstantsAssignment ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:75:1: ( rule__Model__ConstantsAssignment )
            {
             before(grammarAccess.getModelAccess().getConstantsAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:76:1: ( rule__Model__ConstantsAssignment )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:76:2: rule__Model__ConstantsAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ConstantsAssignment_in_ruleModel95);
            rule__Model__ConstantsAssignment();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getConstantsAssignment()); 

            }


            }

        }
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


    // $ANTLR start entryRuleTConstant
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:88:1: entryRuleTConstant : ruleTConstant EOF ;
    public final void entryRuleTConstant() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:89:1: ( ruleTConstant EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:90:1: ruleTConstant EOF
            {
             before(grammarAccess.getTConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTConstant_in_entryRuleTConstant122);
            ruleTConstant();
            _fsp--;

             after(grammarAccess.getTConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTConstant129); 

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
    // $ANTLR end entryRuleTConstant


    // $ANTLR start ruleTConstant
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:97:1: ruleTConstant : ( ( rule__TConstant__Alternatives ) ) ;
    public final void ruleTConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:101:2: ( ( ( rule__TConstant__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:102:1: ( ( rule__TConstant__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:102:1: ( ( rule__TConstant__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:103:1: ( rule__TConstant__Alternatives )
            {
             before(grammarAccess.getTConstantAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:104:1: ( rule__TConstant__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:104:2: rule__TConstant__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TConstant__Alternatives_in_ruleTConstant156);
            rule__TConstant__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getTConstantAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTConstant


    // $ANTLR start entryRuleTStringConstant
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:116:1: entryRuleTStringConstant : ruleTStringConstant EOF ;
    public final void entryRuleTStringConstant() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:117:1: ( ruleTStringConstant EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:118:1: ruleTStringConstant EOF
            {
             before(grammarAccess.getTStringConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTStringConstant_in_entryRuleTStringConstant183);
            ruleTStringConstant();
            _fsp--;

             after(grammarAccess.getTStringConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTStringConstant190); 

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
    // $ANTLR end entryRuleTStringConstant


    // $ANTLR start ruleTStringConstant
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:125:1: ruleTStringConstant : ( ( rule__TStringConstant__Group__0 ) ) ;
    public final void ruleTStringConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:129:2: ( ( ( rule__TStringConstant__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:130:1: ( ( rule__TStringConstant__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:130:1: ( ( rule__TStringConstant__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:131:1: ( rule__TStringConstant__Group__0 )
            {
             before(grammarAccess.getTStringConstantAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:132:1: ( rule__TStringConstant__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:132:2: rule__TStringConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__0_in_ruleTStringConstant217);
            rule__TStringConstant__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTStringConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTStringConstant


    // $ANTLR start entryRuleTIntegerConstant
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:144:1: entryRuleTIntegerConstant : ruleTIntegerConstant EOF ;
    public final void entryRuleTIntegerConstant() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:145:1: ( ruleTIntegerConstant EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:146:1: ruleTIntegerConstant EOF
            {
             before(grammarAccess.getTIntegerConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTIntegerConstant_in_entryRuleTIntegerConstant244);
            ruleTIntegerConstant();
            _fsp--;

             after(grammarAccess.getTIntegerConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTIntegerConstant251); 

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
    // $ANTLR end entryRuleTIntegerConstant


    // $ANTLR start ruleTIntegerConstant
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:153:1: ruleTIntegerConstant : ( ( rule__TIntegerConstant__Group__0 ) ) ;
    public final void ruleTIntegerConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:157:2: ( ( ( rule__TIntegerConstant__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:158:1: ( ( rule__TIntegerConstant__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:158:1: ( ( rule__TIntegerConstant__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:159:1: ( rule__TIntegerConstant__Group__0 )
            {
             before(grammarAccess.getTIntegerConstantAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:160:1: ( rule__TIntegerConstant__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:160:2: rule__TIntegerConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__0_in_ruleTIntegerConstant278);
            rule__TIntegerConstant__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTIntegerConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTIntegerConstant


    // $ANTLR start entryRuleTBooleanConstant
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:172:1: entryRuleTBooleanConstant : ruleTBooleanConstant EOF ;
    public final void entryRuleTBooleanConstant() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:173:1: ( ruleTBooleanConstant EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:174:1: ruleTBooleanConstant EOF
            {
             before(grammarAccess.getTBooleanConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTBooleanConstant_in_entryRuleTBooleanConstant305);
            ruleTBooleanConstant();
            _fsp--;

             after(grammarAccess.getTBooleanConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTBooleanConstant312); 

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
    // $ANTLR end entryRuleTBooleanConstant


    // $ANTLR start ruleTBooleanConstant
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:181:1: ruleTBooleanConstant : ( ( rule__TBooleanConstant__Group__0 ) ) ;
    public final void ruleTBooleanConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:185:2: ( ( ( rule__TBooleanConstant__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:186:1: ( ( rule__TBooleanConstant__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:186:1: ( ( rule__TBooleanConstant__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:187:1: ( rule__TBooleanConstant__Group__0 )
            {
             before(grammarAccess.getTBooleanConstantAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:188:1: ( rule__TBooleanConstant__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:188:2: rule__TBooleanConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__0_in_ruleTBooleanConstant339);
            rule__TBooleanConstant__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTBooleanConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTBooleanConstant


    // $ANTLR start entryRuleTAnnotation
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:200:1: entryRuleTAnnotation : ruleTAnnotation EOF ;
    public final void entryRuleTAnnotation() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:201:1: ( ruleTAnnotation EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:202:1: ruleTAnnotation EOF
            {
             before(grammarAccess.getTAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_entryRuleTAnnotation366);
            ruleTAnnotation();
            _fsp--;

             after(grammarAccess.getTAnnotationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTAnnotation373); 

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
    // $ANTLR end entryRuleTAnnotation


    // $ANTLR start ruleTAnnotation
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:209:1: ruleTAnnotation : ( ( rule__TAnnotation__Group__0 ) ) ;
    public final void ruleTAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:213:2: ( ( ( rule__TAnnotation__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:214:1: ( ( rule__TAnnotation__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:214:1: ( ( rule__TAnnotation__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:215:1: ( rule__TAnnotation__Group__0 )
            {
             before(grammarAccess.getTAnnotationAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:216:1: ( rule__TAnnotation__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:216:2: rule__TAnnotation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TAnnotation__Group__0_in_ruleTAnnotation400);
            rule__TAnnotation__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTAnnotationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTAnnotation


    // $ANTLR start rule__TConstant__Alternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:228:1: rule__TConstant__Alternatives : ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) );
    public final void rule__TConstant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:232:1: ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:233:1: ( ruleTStringConstant )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:233:1: ( ruleTStringConstant )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:234:1: ruleTStringConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTStringConstant_in_rule__TConstant__Alternatives436);
                    ruleTStringConstant();
                    _fsp--;

                     after(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:239:6: ( ruleTIntegerConstant )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:239:6: ( ruleTIntegerConstant )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:240:1: ruleTIntegerConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTIntegerConstant_in_rule__TConstant__Alternatives453);
                    ruleTIntegerConstant();
                    _fsp--;

                     after(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:245:6: ( ruleTBooleanConstant )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:245:6: ( ruleTBooleanConstant )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:246:1: ruleTBooleanConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTBooleanConstantParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTBooleanConstant_in_rule__TConstant__Alternatives470);
                    ruleTBooleanConstant();
                    _fsp--;

                     after(grammarAccess.getTConstantAccess().getTBooleanConstantParserRuleCall_2()); 

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
    // $ANTLR end rule__TConstant__Alternatives


    // $ANTLR start rule__TStringConstant__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:258:1: rule__TStringConstant__Group__0 : ( ( rule__TStringConstant__AnnotationsAssignment_0 )* ) rule__TStringConstant__Group__1 ;
    public final void rule__TStringConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:262:1: ( ( ( rule__TStringConstant__AnnotationsAssignment_0 )* ) rule__TStringConstant__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:263:1: ( ( rule__TStringConstant__AnnotationsAssignment_0 )* ) rule__TStringConstant__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:263:1: ( ( rule__TStringConstant__AnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:264:1: ( rule__TStringConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTStringConstantAccess().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:265:1: ( rule__TStringConstant__AnnotationsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:265:2: rule__TStringConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__AnnotationsAssignment_0_in_rule__TStringConstant__Group__0504);
            	    rule__TStringConstant__AnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTStringConstantAccess().getAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__1_in_rule__TStringConstant__Group__0514);
            rule__TStringConstant__Group__1();
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
    // $ANTLR end rule__TStringConstant__Group__0


    // $ANTLR start rule__TStringConstant__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:276:1: rule__TStringConstant__Group__1 : ( 'constant' ) rule__TStringConstant__Group__2 ;
    public final void rule__TStringConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:280:1: ( ( 'constant' ) rule__TStringConstant__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:281:1: ( 'constant' ) rule__TStringConstant__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:281:1: ( 'constant' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:282:1: 'constant'
            {
             before(grammarAccess.getTStringConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__TStringConstant__Group__1543); 
             after(grammarAccess.getTStringConstantAccess().getConstantKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__2_in_rule__TStringConstant__Group__1553);
            rule__TStringConstant__Group__2();
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
    // $ANTLR end rule__TStringConstant__Group__1


    // $ANTLR start rule__TStringConstant__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:296:1: rule__TStringConstant__Group__2 : ( 'string' ) rule__TStringConstant__Group__3 ;
    public final void rule__TStringConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:300:1: ( ( 'string' ) rule__TStringConstant__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:301:1: ( 'string' ) rule__TStringConstant__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:301:1: ( 'string' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:302:1: 'string'
            {
             before(grammarAccess.getTStringConstantAccess().getStringKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__TStringConstant__Group__2582); 
             after(grammarAccess.getTStringConstantAccess().getStringKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__3_in_rule__TStringConstant__Group__2592);
            rule__TStringConstant__Group__3();
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
    // $ANTLR end rule__TStringConstant__Group__2


    // $ANTLR start rule__TStringConstant__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:316:1: rule__TStringConstant__Group__3 : ( ( rule__TStringConstant__NameAssignment_3 ) ) ;
    public final void rule__TStringConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:320:1: ( ( ( rule__TStringConstant__NameAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:321:1: ( ( rule__TStringConstant__NameAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:321:1: ( ( rule__TStringConstant__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:322:1: ( rule__TStringConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTStringConstantAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:323:1: ( rule__TStringConstant__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:323:2: rule__TStringConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__NameAssignment_3_in_rule__TStringConstant__Group__3620);
            rule__TStringConstant__NameAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getTStringConstantAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TStringConstant__Group__3


    // $ANTLR start rule__TIntegerConstant__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:341:1: rule__TIntegerConstant__Group__0 : ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* ) rule__TIntegerConstant__Group__1 ;
    public final void rule__TIntegerConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:345:1: ( ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* ) rule__TIntegerConstant__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:346:1: ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* ) rule__TIntegerConstant__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:346:1: ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:347:1: ( rule__TIntegerConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTIntegerConstantAccess().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:348:1: ( rule__TIntegerConstant__AnnotationsAssignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:348:2: rule__TIntegerConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__AnnotationsAssignment_0_in_rule__TIntegerConstant__Group__0662);
            	    rule__TIntegerConstant__AnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getTIntegerConstantAccess().getAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__1_in_rule__TIntegerConstant__Group__0672);
            rule__TIntegerConstant__Group__1();
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
    // $ANTLR end rule__TIntegerConstant__Group__0


    // $ANTLR start rule__TIntegerConstant__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:359:1: rule__TIntegerConstant__Group__1 : ( 'constant' ) rule__TIntegerConstant__Group__2 ;
    public final void rule__TIntegerConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:363:1: ( ( 'constant' ) rule__TIntegerConstant__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:364:1: ( 'constant' ) rule__TIntegerConstant__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:364:1: ( 'constant' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:365:1: 'constant'
            {
             before(grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__TIntegerConstant__Group__1701); 
             after(grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__2_in_rule__TIntegerConstant__Group__1711);
            rule__TIntegerConstant__Group__2();
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
    // $ANTLR end rule__TIntegerConstant__Group__1


    // $ANTLR start rule__TIntegerConstant__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:379:1: rule__TIntegerConstant__Group__2 : ( 'integer' ) rule__TIntegerConstant__Group__3 ;
    public final void rule__TIntegerConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:383:1: ( ( 'integer' ) rule__TIntegerConstant__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:384:1: ( 'integer' ) rule__TIntegerConstant__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:384:1: ( 'integer' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:385:1: 'integer'
            {
             before(grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__TIntegerConstant__Group__2740); 
             after(grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__3_in_rule__TIntegerConstant__Group__2750);
            rule__TIntegerConstant__Group__3();
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
    // $ANTLR end rule__TIntegerConstant__Group__2


    // $ANTLR start rule__TIntegerConstant__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:399:1: rule__TIntegerConstant__Group__3 : ( ( rule__TIntegerConstant__NameAssignment_3 ) ) ;
    public final void rule__TIntegerConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:403:1: ( ( ( rule__TIntegerConstant__NameAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:404:1: ( ( rule__TIntegerConstant__NameAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:404:1: ( ( rule__TIntegerConstant__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:405:1: ( rule__TIntegerConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTIntegerConstantAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:406:1: ( rule__TIntegerConstant__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:406:2: rule__TIntegerConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__NameAssignment_3_in_rule__TIntegerConstant__Group__3778);
            rule__TIntegerConstant__NameAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getTIntegerConstantAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TIntegerConstant__Group__3


    // $ANTLR start rule__TBooleanConstant__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:424:1: rule__TBooleanConstant__Group__0 : ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* ) rule__TBooleanConstant__Group__1 ;
    public final void rule__TBooleanConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:428:1: ( ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* ) rule__TBooleanConstant__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:429:1: ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* ) rule__TBooleanConstant__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:429:1: ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:430:1: ( rule__TBooleanConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTBooleanConstantAccess().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:431:1: ( rule__TBooleanConstant__AnnotationsAssignment_0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:431:2: rule__TBooleanConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__AnnotationsAssignment_0_in_rule__TBooleanConstant__Group__0820);
            	    rule__TBooleanConstant__AnnotationsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getTBooleanConstantAccess().getAnnotationsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__1_in_rule__TBooleanConstant__Group__0830);
            rule__TBooleanConstant__Group__1();
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
    // $ANTLR end rule__TBooleanConstant__Group__0


    // $ANTLR start rule__TBooleanConstant__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:442:1: rule__TBooleanConstant__Group__1 : ( 'constant' ) rule__TBooleanConstant__Group__2 ;
    public final void rule__TBooleanConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:446:1: ( ( 'constant' ) rule__TBooleanConstant__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:447:1: ( 'constant' ) rule__TBooleanConstant__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:447:1: ( 'constant' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:448:1: 'constant'
            {
             before(grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__TBooleanConstant__Group__1859); 
             after(grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__2_in_rule__TBooleanConstant__Group__1869);
            rule__TBooleanConstant__Group__2();
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
    // $ANTLR end rule__TBooleanConstant__Group__1


    // $ANTLR start rule__TBooleanConstant__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:462:1: rule__TBooleanConstant__Group__2 : ( 'boolean' ) rule__TBooleanConstant__Group__3 ;
    public final void rule__TBooleanConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:466:1: ( ( 'boolean' ) rule__TBooleanConstant__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:467:1: ( 'boolean' ) rule__TBooleanConstant__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:467:1: ( 'boolean' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:468:1: 'boolean'
            {
             before(grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__TBooleanConstant__Group__2898); 
             after(grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__3_in_rule__TBooleanConstant__Group__2908);
            rule__TBooleanConstant__Group__3();
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
    // $ANTLR end rule__TBooleanConstant__Group__2


    // $ANTLR start rule__TBooleanConstant__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:482:1: rule__TBooleanConstant__Group__3 : ( ( rule__TBooleanConstant__NameAssignment_3 ) ) ;
    public final void rule__TBooleanConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:486:1: ( ( ( rule__TBooleanConstant__NameAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:487:1: ( ( rule__TBooleanConstant__NameAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:487:1: ( ( rule__TBooleanConstant__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:488:1: ( rule__TBooleanConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTBooleanConstantAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:489:1: ( rule__TBooleanConstant__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:489:2: rule__TBooleanConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__NameAssignment_3_in_rule__TBooleanConstant__Group__3936);
            rule__TBooleanConstant__NameAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getTBooleanConstantAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TBooleanConstant__Group__3


    // $ANTLR start rule__TAnnotation__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:507:1: rule__TAnnotation__Group__0 : ( '@desc' ) rule__TAnnotation__Group__1 ;
    public final void rule__TAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:511:1: ( ( '@desc' ) rule__TAnnotation__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:512:1: ( '@desc' ) rule__TAnnotation__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:512:1: ( '@desc' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:513:1: '@desc'
            {
             before(grammarAccess.getTAnnotationAccess().getDescKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__TAnnotation__Group__0979); 
             after(grammarAccess.getTAnnotationAccess().getDescKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TAnnotation__Group__1_in_rule__TAnnotation__Group__0989);
            rule__TAnnotation__Group__1();
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
    // $ANTLR end rule__TAnnotation__Group__0


    // $ANTLR start rule__TAnnotation__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:527:1: rule__TAnnotation__Group__1 : ( ( rule__TAnnotation__DescriptionAssignment_1 ) ) ;
    public final void rule__TAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:531:1: ( ( ( rule__TAnnotation__DescriptionAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:532:1: ( ( rule__TAnnotation__DescriptionAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:532:1: ( ( rule__TAnnotation__DescriptionAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:533:1: ( rule__TAnnotation__DescriptionAssignment_1 )
            {
             before(grammarAccess.getTAnnotationAccess().getDescriptionAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:534:1: ( rule__TAnnotation__DescriptionAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:534:2: rule__TAnnotation__DescriptionAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TAnnotation__DescriptionAssignment_1_in_rule__TAnnotation__Group__11017);
            rule__TAnnotation__DescriptionAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTAnnotationAccess().getDescriptionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TAnnotation__Group__1


    // $ANTLR start rule__Model__ConstantsAssignment
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:548:1: rule__Model__ConstantsAssignment : ( ruleTConstant ) ;
    public final void rule__Model__ConstantsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:552:1: ( ( ruleTConstant ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:553:1: ( ruleTConstant )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:553:1: ( ruleTConstant )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:554:1: ruleTConstant
            {
             before(grammarAccess.getModelAccess().getConstantsTConstantParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTConstant_in_rule__Model__ConstantsAssignment1055);
            ruleTConstant();
            _fsp--;

             after(grammarAccess.getModelAccess().getConstantsTConstantParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ConstantsAssignment


    // $ANTLR start rule__TStringConstant__AnnotationsAssignment_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:563:1: rule__TStringConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TStringConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:567:1: ( ( ruleTAnnotation ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:568:1: ( ruleTAnnotation )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:568:1: ( ruleTAnnotation )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:569:1: ruleTAnnotation
            {
             before(grammarAccess.getTStringConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_rule__TStringConstant__AnnotationsAssignment_01086);
            ruleTAnnotation();
            _fsp--;

             after(grammarAccess.getTStringConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TStringConstant__AnnotationsAssignment_0


    // $ANTLR start rule__TStringConstant__NameAssignment_3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:578:1: rule__TStringConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TStringConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:582:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:583:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:583:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:584:1: RULE_ID
            {
             before(grammarAccess.getTStringConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TStringConstant__NameAssignment_31117); 
             after(grammarAccess.getTStringConstantAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TStringConstant__NameAssignment_3


    // $ANTLR start rule__TIntegerConstant__AnnotationsAssignment_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:593:1: rule__TIntegerConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TIntegerConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:597:1: ( ( ruleTAnnotation ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:598:1: ( ruleTAnnotation )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:598:1: ( ruleTAnnotation )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:599:1: ruleTAnnotation
            {
             before(grammarAccess.getTIntegerConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_rule__TIntegerConstant__AnnotationsAssignment_01148);
            ruleTAnnotation();
            _fsp--;

             after(grammarAccess.getTIntegerConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TIntegerConstant__AnnotationsAssignment_0


    // $ANTLR start rule__TIntegerConstant__NameAssignment_3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:608:1: rule__TIntegerConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TIntegerConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:612:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:613:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:613:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:614:1: RULE_ID
            {
             before(grammarAccess.getTIntegerConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TIntegerConstant__NameAssignment_31179); 
             after(grammarAccess.getTIntegerConstantAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TIntegerConstant__NameAssignment_3


    // $ANTLR start rule__TBooleanConstant__AnnotationsAssignment_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:623:1: rule__TBooleanConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TBooleanConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:627:1: ( ( ruleTAnnotation ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:628:1: ( ruleTAnnotation )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:628:1: ( ruleTAnnotation )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:629:1: ruleTAnnotation
            {
             before(grammarAccess.getTBooleanConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_rule__TBooleanConstant__AnnotationsAssignment_01210);
            ruleTAnnotation();
            _fsp--;

             after(grammarAccess.getTBooleanConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TBooleanConstant__AnnotationsAssignment_0


    // $ANTLR start rule__TBooleanConstant__NameAssignment_3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:638:1: rule__TBooleanConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TBooleanConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:642:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:643:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:643:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:644:1: RULE_ID
            {
             before(grammarAccess.getTBooleanConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TBooleanConstant__NameAssignment_31241); 
             after(grammarAccess.getTBooleanConstantAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TBooleanConstant__NameAssignment_3


    // $ANTLR start rule__TAnnotation__DescriptionAssignment_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:653:1: rule__TAnnotation__DescriptionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TAnnotation__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:657:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:658:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:658:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug288734TestLanguage.g:659:1: RULE_STRING
            {
             before(grammarAccess.getTAnnotationAccess().getDescriptionSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__TAnnotation__DescriptionAssignment_11272); 
             after(grammarAccess.getTAnnotationAccess().getDescriptionSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TAnnotation__DescriptionAssignment_1


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\7\uffff";
    static final String DFA1_eofS =
        "\7\uffff";
    static final String DFA1_minS =
        "\1\13\1\5\1\14\1\13\3\uffff";
    static final String DFA1_maxS =
        "\1\17\1\5\1\16\1\17\3\uffff";
    static final String DFA1_acceptS =
        "\4\uffff\1\3\1\2\1\1";
    static final String DFA1_specialS =
        "\7\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\3\uffff\1\1",
            "\1\3",
            "\1\6\1\5\1\4",
            "\1\2\3\uffff\1\1",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "228:1: rule__TConstant__Alternatives : ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ConstantsAssignment_in_ruleModel95 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTConstant_in_entryRuleTConstant122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTConstant129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TConstant__Alternatives_in_ruleTConstant156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTStringConstant_in_entryRuleTStringConstant183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTStringConstant190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__0_in_ruleTStringConstant217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTIntegerConstant_in_entryRuleTIntegerConstant244 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTIntegerConstant251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__0_in_ruleTIntegerConstant278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTBooleanConstant_in_entryRuleTBooleanConstant305 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTBooleanConstant312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__0_in_ruleTBooleanConstant339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_entryRuleTAnnotation366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTAnnotation373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TAnnotation__Group__0_in_ruleTAnnotation400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTStringConstant_in_rule__TConstant__Alternatives436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTIntegerConstant_in_rule__TConstant__Alternatives453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTBooleanConstant_in_rule__TConstant__Alternatives470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TStringConstant__AnnotationsAssignment_0_in_rule__TStringConstant__Group__0504 = new BitSet(new long[]{0x0000000000008800L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__1_in_rule__TStringConstant__Group__0514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TStringConstant__Group__1543 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__2_in_rule__TStringConstant__Group__1553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__TStringConstant__Group__2582 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__3_in_rule__TStringConstant__Group__2592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TStringConstant__NameAssignment_3_in_rule__TStringConstant__Group__3620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__AnnotationsAssignment_0_in_rule__TIntegerConstant__Group__0662 = new BitSet(new long[]{0x0000000000008800L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__1_in_rule__TIntegerConstant__Group__0672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TIntegerConstant__Group__1701 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__2_in_rule__TIntegerConstant__Group__1711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TIntegerConstant__Group__2740 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__3_in_rule__TIntegerConstant__Group__2750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__NameAssignment_3_in_rule__TIntegerConstant__Group__3778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__AnnotationsAssignment_0_in_rule__TBooleanConstant__Group__0820 = new BitSet(new long[]{0x0000000000008800L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__1_in_rule__TBooleanConstant__Group__0830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TBooleanConstant__Group__1859 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__2_in_rule__TBooleanConstant__Group__1869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__TBooleanConstant__Group__2898 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__3_in_rule__TBooleanConstant__Group__2908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__NameAssignment_3_in_rule__TBooleanConstant__Group__3936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__TAnnotation__Group__0979 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__TAnnotation__Group__1_in_rule__TAnnotation__Group__0989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TAnnotation__DescriptionAssignment_1_in_rule__TAnnotation__Group__11017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTConstant_in_rule__Model__ConstantsAssignment1055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_rule__TStringConstant__AnnotationsAssignment_01086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TStringConstant__NameAssignment_31117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_rule__TIntegerConstant__AnnotationsAssignment_01148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TIntegerConstant__NameAssignment_31179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_rule__TBooleanConstant__AnnotationsAssignment_01210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TBooleanConstant__NameAssignment_31241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__TAnnotation__DescriptionAssignment_11272 = new BitSet(new long[]{0x0000000000000002L});
    }


}
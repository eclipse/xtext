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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug288734TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug288734TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'constant'", "'string'", "'integer'", "'boolean'", "'@desc'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalBug288734TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:63:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:70:1: ruleModel : ( ( rule__Model__ConstantsAssignment ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:74:2: ( ( ( rule__Model__ConstantsAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:75:1: ( ( rule__Model__ConstantsAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:75:1: ( ( rule__Model__ConstantsAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:76:1: ( rule__Model__ConstantsAssignment )
            {
             before(grammarAccess.getModelAccess().getConstantsAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:77:1: ( rule__Model__ConstantsAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:77:2: rule__Model__ConstantsAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ConstantsAssignment_in_ruleModel94);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:89:1: entryRuleTConstant : ruleTConstant EOF ;
    public final void entryRuleTConstant() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:90:1: ( ruleTConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:91:1: ruleTConstant EOF
            {
             before(grammarAccess.getTConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTConstant_in_entryRuleTConstant121);
            ruleTConstant();
            _fsp--;

             after(grammarAccess.getTConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTConstant128); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:98:1: ruleTConstant : ( ( rule__TConstant__Alternatives ) ) ;
    public final void ruleTConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:102:2: ( ( ( rule__TConstant__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:103:1: ( ( rule__TConstant__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:103:1: ( ( rule__TConstant__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:104:1: ( rule__TConstant__Alternatives )
            {
             before(grammarAccess.getTConstantAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:105:1: ( rule__TConstant__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:105:2: rule__TConstant__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TConstant__Alternatives_in_ruleTConstant154);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:117:1: entryRuleTStringConstant : ruleTStringConstant EOF ;
    public final void entryRuleTStringConstant() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:118:1: ( ruleTStringConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:119:1: ruleTStringConstant EOF
            {
             before(grammarAccess.getTStringConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTStringConstant_in_entryRuleTStringConstant181);
            ruleTStringConstant();
            _fsp--;

             after(grammarAccess.getTStringConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTStringConstant188); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:126:1: ruleTStringConstant : ( ( rule__TStringConstant__Group__0 ) ) ;
    public final void ruleTStringConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:130:2: ( ( ( rule__TStringConstant__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:131:1: ( ( rule__TStringConstant__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:131:1: ( ( rule__TStringConstant__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:132:1: ( rule__TStringConstant__Group__0 )
            {
             before(grammarAccess.getTStringConstantAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:133:1: ( rule__TStringConstant__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:133:2: rule__TStringConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__0_in_ruleTStringConstant214);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:145:1: entryRuleTIntegerConstant : ruleTIntegerConstant EOF ;
    public final void entryRuleTIntegerConstant() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:146:1: ( ruleTIntegerConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:147:1: ruleTIntegerConstant EOF
            {
             before(grammarAccess.getTIntegerConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTIntegerConstant_in_entryRuleTIntegerConstant241);
            ruleTIntegerConstant();
            _fsp--;

             after(grammarAccess.getTIntegerConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTIntegerConstant248); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:154:1: ruleTIntegerConstant : ( ( rule__TIntegerConstant__Group__0 ) ) ;
    public final void ruleTIntegerConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:158:2: ( ( ( rule__TIntegerConstant__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:159:1: ( ( rule__TIntegerConstant__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:159:1: ( ( rule__TIntegerConstant__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:160:1: ( rule__TIntegerConstant__Group__0 )
            {
             before(grammarAccess.getTIntegerConstantAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:161:1: ( rule__TIntegerConstant__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:161:2: rule__TIntegerConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__0_in_ruleTIntegerConstant274);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:173:1: entryRuleTBooleanConstant : ruleTBooleanConstant EOF ;
    public final void entryRuleTBooleanConstant() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:174:1: ( ruleTBooleanConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:175:1: ruleTBooleanConstant EOF
            {
             before(grammarAccess.getTBooleanConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTBooleanConstant_in_entryRuleTBooleanConstant301);
            ruleTBooleanConstant();
            _fsp--;

             after(grammarAccess.getTBooleanConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTBooleanConstant308); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:182:1: ruleTBooleanConstant : ( ( rule__TBooleanConstant__Group__0 ) ) ;
    public final void ruleTBooleanConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:186:2: ( ( ( rule__TBooleanConstant__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:187:1: ( ( rule__TBooleanConstant__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:187:1: ( ( rule__TBooleanConstant__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:188:1: ( rule__TBooleanConstant__Group__0 )
            {
             before(grammarAccess.getTBooleanConstantAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:189:1: ( rule__TBooleanConstant__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:189:2: rule__TBooleanConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__0_in_ruleTBooleanConstant334);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:201:1: entryRuleTAnnotation : ruleTAnnotation EOF ;
    public final void entryRuleTAnnotation() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:202:1: ( ruleTAnnotation EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:203:1: ruleTAnnotation EOF
            {
             before(grammarAccess.getTAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_entryRuleTAnnotation361);
            ruleTAnnotation();
            _fsp--;

             after(grammarAccess.getTAnnotationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTAnnotation368); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:210:1: ruleTAnnotation : ( ( rule__TAnnotation__Group__0 ) ) ;
    public final void ruleTAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:214:2: ( ( ( rule__TAnnotation__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:215:1: ( ( rule__TAnnotation__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:215:1: ( ( rule__TAnnotation__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:216:1: ( rule__TAnnotation__Group__0 )
            {
             before(grammarAccess.getTAnnotationAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:217:1: ( rule__TAnnotation__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:217:2: rule__TAnnotation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TAnnotation__Group__0_in_ruleTAnnotation394);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:229:1: rule__TConstant__Alternatives : ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) );
    public final void rule__TConstant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:233:1: ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:234:1: ( ruleTStringConstant )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:234:1: ( ruleTStringConstant )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:235:1: ruleTStringConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTStringConstant_in_rule__TConstant__Alternatives430);
                    ruleTStringConstant();
                    _fsp--;

                     after(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:240:6: ( ruleTIntegerConstant )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:240:6: ( ruleTIntegerConstant )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:241:1: ruleTIntegerConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTIntegerConstant_in_rule__TConstant__Alternatives447);
                    ruleTIntegerConstant();
                    _fsp--;

                     after(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:246:6: ( ruleTBooleanConstant )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:246:6: ( ruleTBooleanConstant )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:247:1: ruleTBooleanConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTBooleanConstantParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTBooleanConstant_in_rule__TConstant__Alternatives464);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:259:1: rule__TStringConstant__Group__0 : rule__TStringConstant__Group__0__Impl rule__TStringConstant__Group__1 ;
    public final void rule__TStringConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:263:1: ( rule__TStringConstant__Group__0__Impl rule__TStringConstant__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:264:2: rule__TStringConstant__Group__0__Impl rule__TStringConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__0__Impl_in_rule__TStringConstant__Group__0494);
            rule__TStringConstant__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__1_in_rule__TStringConstant__Group__0497);
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


    // $ANTLR start rule__TStringConstant__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:271:1: rule__TStringConstant__Group__0__Impl : ( ( rule__TStringConstant__AnnotationsAssignment_0 )* ) ;
    public final void rule__TStringConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:275:1: ( ( ( rule__TStringConstant__AnnotationsAssignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:276:1: ( ( rule__TStringConstant__AnnotationsAssignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:276:1: ( ( rule__TStringConstant__AnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:277:1: ( rule__TStringConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTStringConstantAccess().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:278:1: ( rule__TStringConstant__AnnotationsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:278:2: rule__TStringConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__AnnotationsAssignment_0_in_rule__TStringConstant__Group__0__Impl524);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TStringConstant__Group__0__Impl


    // $ANTLR start rule__TStringConstant__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:288:1: rule__TStringConstant__Group__1 : rule__TStringConstant__Group__1__Impl rule__TStringConstant__Group__2 ;
    public final void rule__TStringConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:292:1: ( rule__TStringConstant__Group__1__Impl rule__TStringConstant__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:293:2: rule__TStringConstant__Group__1__Impl rule__TStringConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__1__Impl_in_rule__TStringConstant__Group__1555);
            rule__TStringConstant__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__2_in_rule__TStringConstant__Group__1558);
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


    // $ANTLR start rule__TStringConstant__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:300:1: rule__TStringConstant__Group__1__Impl : ( 'constant' ) ;
    public final void rule__TStringConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:304:1: ( ( 'constant' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:305:1: ( 'constant' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:305:1: ( 'constant' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:306:1: 'constant'
            {
             before(grammarAccess.getTStringConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__TStringConstant__Group__1__Impl586); 
             after(grammarAccess.getTStringConstantAccess().getConstantKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TStringConstant__Group__1__Impl


    // $ANTLR start rule__TStringConstant__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:319:1: rule__TStringConstant__Group__2 : rule__TStringConstant__Group__2__Impl rule__TStringConstant__Group__3 ;
    public final void rule__TStringConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:323:1: ( rule__TStringConstant__Group__2__Impl rule__TStringConstant__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:324:2: rule__TStringConstant__Group__2__Impl rule__TStringConstant__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__2__Impl_in_rule__TStringConstant__Group__2617);
            rule__TStringConstant__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__3_in_rule__TStringConstant__Group__2620);
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


    // $ANTLR start rule__TStringConstant__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:331:1: rule__TStringConstant__Group__2__Impl : ( 'string' ) ;
    public final void rule__TStringConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:335:1: ( ( 'string' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:336:1: ( 'string' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:336:1: ( 'string' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:337:1: 'string'
            {
             before(grammarAccess.getTStringConstantAccess().getStringKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__TStringConstant__Group__2__Impl648); 
             after(grammarAccess.getTStringConstantAccess().getStringKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TStringConstant__Group__2__Impl


    // $ANTLR start rule__TStringConstant__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:350:1: rule__TStringConstant__Group__3 : rule__TStringConstant__Group__3__Impl ;
    public final void rule__TStringConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:354:1: ( rule__TStringConstant__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:355:2: rule__TStringConstant__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__Group__3__Impl_in_rule__TStringConstant__Group__3679);
            rule__TStringConstant__Group__3__Impl();
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
    // $ANTLR end rule__TStringConstant__Group__3


    // $ANTLR start rule__TStringConstant__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:361:1: rule__TStringConstant__Group__3__Impl : ( ( rule__TStringConstant__NameAssignment_3 ) ) ;
    public final void rule__TStringConstant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:365:1: ( ( ( rule__TStringConstant__NameAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:366:1: ( ( rule__TStringConstant__NameAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:366:1: ( ( rule__TStringConstant__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:367:1: ( rule__TStringConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTStringConstantAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:368:1: ( rule__TStringConstant__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:368:2: rule__TStringConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TStringConstant__NameAssignment_3_in_rule__TStringConstant__Group__3__Impl706);
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
    // $ANTLR end rule__TStringConstant__Group__3__Impl


    // $ANTLR start rule__TIntegerConstant__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:386:1: rule__TIntegerConstant__Group__0 : rule__TIntegerConstant__Group__0__Impl rule__TIntegerConstant__Group__1 ;
    public final void rule__TIntegerConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:390:1: ( rule__TIntegerConstant__Group__0__Impl rule__TIntegerConstant__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:391:2: rule__TIntegerConstant__Group__0__Impl rule__TIntegerConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__0__Impl_in_rule__TIntegerConstant__Group__0744);
            rule__TIntegerConstant__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__1_in_rule__TIntegerConstant__Group__0747);
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


    // $ANTLR start rule__TIntegerConstant__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:398:1: rule__TIntegerConstant__Group__0__Impl : ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* ) ;
    public final void rule__TIntegerConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:402:1: ( ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:403:1: ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:403:1: ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:404:1: ( rule__TIntegerConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTIntegerConstantAccess().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:405:1: ( rule__TIntegerConstant__AnnotationsAssignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:405:2: rule__TIntegerConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__AnnotationsAssignment_0_in_rule__TIntegerConstant__Group__0__Impl774);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TIntegerConstant__Group__0__Impl


    // $ANTLR start rule__TIntegerConstant__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:415:1: rule__TIntegerConstant__Group__1 : rule__TIntegerConstant__Group__1__Impl rule__TIntegerConstant__Group__2 ;
    public final void rule__TIntegerConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:419:1: ( rule__TIntegerConstant__Group__1__Impl rule__TIntegerConstant__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:420:2: rule__TIntegerConstant__Group__1__Impl rule__TIntegerConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__1__Impl_in_rule__TIntegerConstant__Group__1805);
            rule__TIntegerConstant__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__2_in_rule__TIntegerConstant__Group__1808);
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


    // $ANTLR start rule__TIntegerConstant__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:427:1: rule__TIntegerConstant__Group__1__Impl : ( 'constant' ) ;
    public final void rule__TIntegerConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:431:1: ( ( 'constant' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:432:1: ( 'constant' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:432:1: ( 'constant' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:433:1: 'constant'
            {
             before(grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__TIntegerConstant__Group__1__Impl836); 
             after(grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TIntegerConstant__Group__1__Impl


    // $ANTLR start rule__TIntegerConstant__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:446:1: rule__TIntegerConstant__Group__2 : rule__TIntegerConstant__Group__2__Impl rule__TIntegerConstant__Group__3 ;
    public final void rule__TIntegerConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:450:1: ( rule__TIntegerConstant__Group__2__Impl rule__TIntegerConstant__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:451:2: rule__TIntegerConstant__Group__2__Impl rule__TIntegerConstant__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__2__Impl_in_rule__TIntegerConstant__Group__2867);
            rule__TIntegerConstant__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__3_in_rule__TIntegerConstant__Group__2870);
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


    // $ANTLR start rule__TIntegerConstant__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:458:1: rule__TIntegerConstant__Group__2__Impl : ( 'integer' ) ;
    public final void rule__TIntegerConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:462:1: ( ( 'integer' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:463:1: ( 'integer' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:463:1: ( 'integer' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:464:1: 'integer'
            {
             before(grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__TIntegerConstant__Group__2__Impl898); 
             after(grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TIntegerConstant__Group__2__Impl


    // $ANTLR start rule__TIntegerConstant__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:477:1: rule__TIntegerConstant__Group__3 : rule__TIntegerConstant__Group__3__Impl ;
    public final void rule__TIntegerConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:481:1: ( rule__TIntegerConstant__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:482:2: rule__TIntegerConstant__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__Group__3__Impl_in_rule__TIntegerConstant__Group__3929);
            rule__TIntegerConstant__Group__3__Impl();
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
    // $ANTLR end rule__TIntegerConstant__Group__3


    // $ANTLR start rule__TIntegerConstant__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:488:1: rule__TIntegerConstant__Group__3__Impl : ( ( rule__TIntegerConstant__NameAssignment_3 ) ) ;
    public final void rule__TIntegerConstant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:492:1: ( ( ( rule__TIntegerConstant__NameAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:493:1: ( ( rule__TIntegerConstant__NameAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:493:1: ( ( rule__TIntegerConstant__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:494:1: ( rule__TIntegerConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTIntegerConstantAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:495:1: ( rule__TIntegerConstant__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:495:2: rule__TIntegerConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TIntegerConstant__NameAssignment_3_in_rule__TIntegerConstant__Group__3__Impl956);
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
    // $ANTLR end rule__TIntegerConstant__Group__3__Impl


    // $ANTLR start rule__TBooleanConstant__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:513:1: rule__TBooleanConstant__Group__0 : rule__TBooleanConstant__Group__0__Impl rule__TBooleanConstant__Group__1 ;
    public final void rule__TBooleanConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:517:1: ( rule__TBooleanConstant__Group__0__Impl rule__TBooleanConstant__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:518:2: rule__TBooleanConstant__Group__0__Impl rule__TBooleanConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__0__Impl_in_rule__TBooleanConstant__Group__0994);
            rule__TBooleanConstant__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__1_in_rule__TBooleanConstant__Group__0997);
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


    // $ANTLR start rule__TBooleanConstant__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:525:1: rule__TBooleanConstant__Group__0__Impl : ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* ) ;
    public final void rule__TBooleanConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:529:1: ( ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:530:1: ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:530:1: ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:531:1: ( rule__TBooleanConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTBooleanConstantAccess().getAnnotationsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:532:1: ( rule__TBooleanConstant__AnnotationsAssignment_0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:532:2: rule__TBooleanConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__AnnotationsAssignment_0_in_rule__TBooleanConstant__Group__0__Impl1024);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TBooleanConstant__Group__0__Impl


    // $ANTLR start rule__TBooleanConstant__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:542:1: rule__TBooleanConstant__Group__1 : rule__TBooleanConstant__Group__1__Impl rule__TBooleanConstant__Group__2 ;
    public final void rule__TBooleanConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:546:1: ( rule__TBooleanConstant__Group__1__Impl rule__TBooleanConstant__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:547:2: rule__TBooleanConstant__Group__1__Impl rule__TBooleanConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__1__Impl_in_rule__TBooleanConstant__Group__11055);
            rule__TBooleanConstant__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__2_in_rule__TBooleanConstant__Group__11058);
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


    // $ANTLR start rule__TBooleanConstant__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:554:1: rule__TBooleanConstant__Group__1__Impl : ( 'constant' ) ;
    public final void rule__TBooleanConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:558:1: ( ( 'constant' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:559:1: ( 'constant' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:559:1: ( 'constant' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:560:1: 'constant'
            {
             before(grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__TBooleanConstant__Group__1__Impl1086); 
             after(grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TBooleanConstant__Group__1__Impl


    // $ANTLR start rule__TBooleanConstant__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:573:1: rule__TBooleanConstant__Group__2 : rule__TBooleanConstant__Group__2__Impl rule__TBooleanConstant__Group__3 ;
    public final void rule__TBooleanConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:577:1: ( rule__TBooleanConstant__Group__2__Impl rule__TBooleanConstant__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:578:2: rule__TBooleanConstant__Group__2__Impl rule__TBooleanConstant__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__2__Impl_in_rule__TBooleanConstant__Group__21117);
            rule__TBooleanConstant__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__3_in_rule__TBooleanConstant__Group__21120);
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


    // $ANTLR start rule__TBooleanConstant__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:585:1: rule__TBooleanConstant__Group__2__Impl : ( 'boolean' ) ;
    public final void rule__TBooleanConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:589:1: ( ( 'boolean' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:590:1: ( 'boolean' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:590:1: ( 'boolean' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:591:1: 'boolean'
            {
             before(grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__TBooleanConstant__Group__2__Impl1148); 
             after(grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TBooleanConstant__Group__2__Impl


    // $ANTLR start rule__TBooleanConstant__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:604:1: rule__TBooleanConstant__Group__3 : rule__TBooleanConstant__Group__3__Impl ;
    public final void rule__TBooleanConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:608:1: ( rule__TBooleanConstant__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:609:2: rule__TBooleanConstant__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__Group__3__Impl_in_rule__TBooleanConstant__Group__31179);
            rule__TBooleanConstant__Group__3__Impl();
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
    // $ANTLR end rule__TBooleanConstant__Group__3


    // $ANTLR start rule__TBooleanConstant__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:615:1: rule__TBooleanConstant__Group__3__Impl : ( ( rule__TBooleanConstant__NameAssignment_3 ) ) ;
    public final void rule__TBooleanConstant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:619:1: ( ( ( rule__TBooleanConstant__NameAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:620:1: ( ( rule__TBooleanConstant__NameAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:620:1: ( ( rule__TBooleanConstant__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:621:1: ( rule__TBooleanConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTBooleanConstantAccess().getNameAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:622:1: ( rule__TBooleanConstant__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:622:2: rule__TBooleanConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TBooleanConstant__NameAssignment_3_in_rule__TBooleanConstant__Group__3__Impl1206);
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
    // $ANTLR end rule__TBooleanConstant__Group__3__Impl


    // $ANTLR start rule__TAnnotation__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:640:1: rule__TAnnotation__Group__0 : rule__TAnnotation__Group__0__Impl rule__TAnnotation__Group__1 ;
    public final void rule__TAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:644:1: ( rule__TAnnotation__Group__0__Impl rule__TAnnotation__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:645:2: rule__TAnnotation__Group__0__Impl rule__TAnnotation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TAnnotation__Group__0__Impl_in_rule__TAnnotation__Group__01244);
            rule__TAnnotation__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TAnnotation__Group__1_in_rule__TAnnotation__Group__01247);
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


    // $ANTLR start rule__TAnnotation__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:652:1: rule__TAnnotation__Group__0__Impl : ( '@desc' ) ;
    public final void rule__TAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:656:1: ( ( '@desc' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:657:1: ( '@desc' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:657:1: ( '@desc' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:658:1: '@desc'
            {
             before(grammarAccess.getTAnnotationAccess().getDescKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__TAnnotation__Group__0__Impl1275); 
             after(grammarAccess.getTAnnotationAccess().getDescKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TAnnotation__Group__0__Impl


    // $ANTLR start rule__TAnnotation__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:671:1: rule__TAnnotation__Group__1 : rule__TAnnotation__Group__1__Impl ;
    public final void rule__TAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:675:1: ( rule__TAnnotation__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:676:2: rule__TAnnotation__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TAnnotation__Group__1__Impl_in_rule__TAnnotation__Group__11306);
            rule__TAnnotation__Group__1__Impl();
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
    // $ANTLR end rule__TAnnotation__Group__1


    // $ANTLR start rule__TAnnotation__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:682:1: rule__TAnnotation__Group__1__Impl : ( ( rule__TAnnotation__DescriptionAssignment_1 ) ) ;
    public final void rule__TAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:686:1: ( ( ( rule__TAnnotation__DescriptionAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:687:1: ( ( rule__TAnnotation__DescriptionAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:687:1: ( ( rule__TAnnotation__DescriptionAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:688:1: ( rule__TAnnotation__DescriptionAssignment_1 )
            {
             before(grammarAccess.getTAnnotationAccess().getDescriptionAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:689:1: ( rule__TAnnotation__DescriptionAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:689:2: rule__TAnnotation__DescriptionAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TAnnotation__DescriptionAssignment_1_in_rule__TAnnotation__Group__1__Impl1333);
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
    // $ANTLR end rule__TAnnotation__Group__1__Impl


    // $ANTLR start rule__Model__ConstantsAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:704:1: rule__Model__ConstantsAssignment : ( ruleTConstant ) ;
    public final void rule__Model__ConstantsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:708:1: ( ( ruleTConstant ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:709:1: ( ruleTConstant )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:709:1: ( ruleTConstant )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:710:1: ruleTConstant
            {
             before(grammarAccess.getModelAccess().getConstantsTConstantParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTConstant_in_rule__Model__ConstantsAssignment1372);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:719:1: rule__TStringConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TStringConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:723:1: ( ( ruleTAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:724:1: ( ruleTAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:724:1: ( ruleTAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:725:1: ruleTAnnotation
            {
             before(grammarAccess.getTStringConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_rule__TStringConstant__AnnotationsAssignment_01403);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:734:1: rule__TStringConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TStringConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:738:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:739:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:739:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:740:1: RULE_ID
            {
             before(grammarAccess.getTStringConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TStringConstant__NameAssignment_31434); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:749:1: rule__TIntegerConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TIntegerConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:753:1: ( ( ruleTAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:754:1: ( ruleTAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:754:1: ( ruleTAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:755:1: ruleTAnnotation
            {
             before(grammarAccess.getTIntegerConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_rule__TIntegerConstant__AnnotationsAssignment_01465);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:764:1: rule__TIntegerConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TIntegerConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:768:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:769:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:769:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:770:1: RULE_ID
            {
             before(grammarAccess.getTIntegerConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TIntegerConstant__NameAssignment_31496); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:779:1: rule__TBooleanConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TBooleanConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:783:1: ( ( ruleTAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:784:1: ( ruleTAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:784:1: ( ruleTAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:785:1: ruleTAnnotation
            {
             before(grammarAccess.getTBooleanConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_rule__TBooleanConstant__AnnotationsAssignment_01527);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:794:1: rule__TBooleanConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TBooleanConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:798:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:799:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:799:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:800:1: RULE_ID
            {
             before(grammarAccess.getTBooleanConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TBooleanConstant__NameAssignment_31558); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:809:1: rule__TAnnotation__DescriptionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TAnnotation__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:813:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:814:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:814:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug288734TestLanguage.g:815:1: RULE_STRING
            {
             before(grammarAccess.getTAnnotationAccess().getDescriptionSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__TAnnotation__DescriptionAssignment_11589); 
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
        "\4\uffff\1\2\1\1\1\3";
    static final String DFA1_specialS =
        "\7\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\3\uffff\1\1",
            "\1\3",
            "\1\5\1\4\1\6",
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
            return "229:1: rule__TConstant__Alternatives : ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ConstantsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTConstant_in_entryRuleTConstant121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTConstant128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TConstant__Alternatives_in_ruleTConstant154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTStringConstant_in_entryRuleTStringConstant181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTStringConstant188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__0_in_ruleTStringConstant214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTIntegerConstant_in_entryRuleTIntegerConstant241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTIntegerConstant248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__0_in_ruleTIntegerConstant274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTBooleanConstant_in_entryRuleTBooleanConstant301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTBooleanConstant308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__0_in_ruleTBooleanConstant334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_entryRuleTAnnotation361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTAnnotation368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TAnnotation__Group__0_in_ruleTAnnotation394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTStringConstant_in_rule__TConstant__Alternatives430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTIntegerConstant_in_rule__TConstant__Alternatives447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTBooleanConstant_in_rule__TConstant__Alternatives464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__0__Impl_in_rule__TStringConstant__Group__0494 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__1_in_rule__TStringConstant__Group__0497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TStringConstant__AnnotationsAssignment_0_in_rule__TStringConstant__Group__0__Impl524 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__1__Impl_in_rule__TStringConstant__Group__1555 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__2_in_rule__TStringConstant__Group__1558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TStringConstant__Group__1__Impl586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__2__Impl_in_rule__TStringConstant__Group__2617 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__3_in_rule__TStringConstant__Group__2620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__TStringConstant__Group__2__Impl648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TStringConstant__Group__3__Impl_in_rule__TStringConstant__Group__3679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TStringConstant__NameAssignment_3_in_rule__TStringConstant__Group__3__Impl706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__0__Impl_in_rule__TIntegerConstant__Group__0744 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__1_in_rule__TIntegerConstant__Group__0747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__AnnotationsAssignment_0_in_rule__TIntegerConstant__Group__0__Impl774 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__1__Impl_in_rule__TIntegerConstant__Group__1805 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__2_in_rule__TIntegerConstant__Group__1808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TIntegerConstant__Group__1__Impl836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__2__Impl_in_rule__TIntegerConstant__Group__2867 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__3_in_rule__TIntegerConstant__Group__2870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TIntegerConstant__Group__2__Impl898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__Group__3__Impl_in_rule__TIntegerConstant__Group__3929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TIntegerConstant__NameAssignment_3_in_rule__TIntegerConstant__Group__3__Impl956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__0__Impl_in_rule__TBooleanConstant__Group__0994 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__1_in_rule__TBooleanConstant__Group__0997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__AnnotationsAssignment_0_in_rule__TBooleanConstant__Group__0__Impl1024 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__1__Impl_in_rule__TBooleanConstant__Group__11055 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__2_in_rule__TBooleanConstant__Group__11058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TBooleanConstant__Group__1__Impl1086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__2__Impl_in_rule__TBooleanConstant__Group__21117 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__3_in_rule__TBooleanConstant__Group__21120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__TBooleanConstant__Group__2__Impl1148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__Group__3__Impl_in_rule__TBooleanConstant__Group__31179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TBooleanConstant__NameAssignment_3_in_rule__TBooleanConstant__Group__3__Impl1206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TAnnotation__Group__0__Impl_in_rule__TAnnotation__Group__01244 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__TAnnotation__Group__1_in_rule__TAnnotation__Group__01247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__TAnnotation__Group__0__Impl1275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TAnnotation__Group__1__Impl_in_rule__TAnnotation__Group__11306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TAnnotation__DescriptionAssignment_1_in_rule__TAnnotation__Group__1__Impl1333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTConstant_in_rule__Model__ConstantsAssignment1372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_rule__TStringConstant__AnnotationsAssignment_01403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TStringConstant__NameAssignment_31434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_rule__TIntegerConstant__AnnotationsAssignment_01465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TIntegerConstant__NameAssignment_31496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_rule__TBooleanConstant__AnnotationsAssignment_01527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TBooleanConstant__NameAssignment_31558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__TAnnotation__DescriptionAssignment_11589 = new BitSet(new long[]{0x0000000000000002L});
    }


}
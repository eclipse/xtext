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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.UnorderedGroupsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalUnorderedGroupsTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'public'", "'private'", "'protected'", "'1'", "'2'", "'3'", "'4'", "'class'", "'{'", "'}'", "'static'", "'synchronized'", "'abstract'", "'final'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalUnorderedGroupsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g"; }


     
     	private UnorderedGroupsTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UnorderedGroupsTestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:62:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:69:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:73:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:75:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:76:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:76:2: rule__Model__Alternatives
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


    // $ANTLR start entryRuleSimpleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:88:1: entryRuleSimpleModel : ruleSimpleModel EOF ;
    public final void entryRuleSimpleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:89:1: ( ruleSimpleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:90:1: ruleSimpleModel EOF
            {
             before(grammarAccess.getSimpleModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel121);
            ruleSimpleModel();
            _fsp--;

             after(grammarAccess.getSimpleModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleModel128); 

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
    // $ANTLR end entryRuleSimpleModel


    // $ANTLR start ruleSimpleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:97:1: ruleSimpleModel : ( ( rule__SimpleModel__Group__0 ) ) ;
    public final void ruleSimpleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:101:2: ( ( ( rule__SimpleModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:102:1: ( ( rule__SimpleModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:102:1: ( ( rule__SimpleModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:103:1: ( rule__SimpleModel__Group__0 )
            {
             before(grammarAccess.getSimpleModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:104:1: ( rule__SimpleModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:104:2: rule__SimpleModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__0_in_ruleSimpleModel154);
            rule__SimpleModel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSimpleModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSimpleModel


    // $ANTLR start entryRuleMandatoryModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:116:1: entryRuleMandatoryModel : ruleMandatoryModel EOF ;
    public final void entryRuleMandatoryModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:117:1: ( ruleMandatoryModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:118:1: ruleMandatoryModel EOF
            {
             before(grammarAccess.getMandatoryModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel181);
            ruleMandatoryModel();
            _fsp--;

             after(grammarAccess.getMandatoryModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryModel188); 

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
    // $ANTLR end entryRuleMandatoryModel


    // $ANTLR start ruleMandatoryModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:125:1: ruleMandatoryModel : ( ( rule__MandatoryModel__Group__0 ) ) ;
    public final void ruleMandatoryModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:129:2: ( ( ( rule__MandatoryModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:130:1: ( ( rule__MandatoryModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:130:1: ( ( rule__MandatoryModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:131:1: ( rule__MandatoryModel__Group__0 )
            {
             before(grammarAccess.getMandatoryModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:132:1: ( rule__MandatoryModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:132:2: rule__MandatoryModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__0_in_ruleMandatoryModel214);
            rule__MandatoryModel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getMandatoryModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleMandatoryModel


    // $ANTLR start entryRuleLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:144:1: entryRuleLoopedModel : ruleLoopedModel EOF ;
    public final void entryRuleLoopedModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:145:1: ( ruleLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:146:1: ruleLoopedModel EOF
            {
             before(grammarAccess.getLoopedModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel241);
            ruleLoopedModel();
            _fsp--;

             after(grammarAccess.getLoopedModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedModel248); 

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
    // $ANTLR end entryRuleLoopedModel


    // $ANTLR start ruleLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:153:1: ruleLoopedModel : ( ( rule__LoopedModel__Group__0 ) ) ;
    public final void ruleLoopedModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:157:2: ( ( ( rule__LoopedModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:158:1: ( ( rule__LoopedModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:158:1: ( ( rule__LoopedModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:159:1: ( rule__LoopedModel__Group__0 )
            {
             before(grammarAccess.getLoopedModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:160:1: ( rule__LoopedModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:160:2: rule__LoopedModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__0_in_ruleLoopedModel274);
            rule__LoopedModel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getLoopedModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleLoopedModel


    // $ANTLR start entryRuleGroupLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:172:1: entryRuleGroupLoopedModel : ruleGroupLoopedModel EOF ;
    public final void entryRuleGroupLoopedModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:173:1: ( ruleGroupLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:174:1: ruleGroupLoopedModel EOF
            {
             before(grammarAccess.getGroupLoopedModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel301);
            ruleGroupLoopedModel();
            _fsp--;

             after(grammarAccess.getGroupLoopedModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupLoopedModel308); 

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
    // $ANTLR end entryRuleGroupLoopedModel


    // $ANTLR start ruleGroupLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:181:1: ruleGroupLoopedModel : ( ( rule__GroupLoopedModel__Group__0 ) ) ;
    public final void ruleGroupLoopedModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:185:2: ( ( ( rule__GroupLoopedModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:186:1: ( ( rule__GroupLoopedModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:186:1: ( ( rule__GroupLoopedModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:187:1: ( rule__GroupLoopedModel__Group__0 )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:188:1: ( rule__GroupLoopedModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:188:2: rule__GroupLoopedModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__0_in_ruleGroupLoopedModel334);
            rule__GroupLoopedModel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getGroupLoopedModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleGroupLoopedModel


    // $ANTLR start rule__Model__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:200:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:204:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 16:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("200:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:205:1: ( ( rule__Model__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:205:1: ( ( rule__Model__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:206:1: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:207:1: ( rule__Model__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:207:2: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives370);
                    rule__Model__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:211:6: ( ( rule__Model__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:211:6: ( ( rule__Model__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:212:1: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:213:1: ( rule__Model__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:213:2: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives388);
                    rule__Model__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:217:6: ( ( rule__Model__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:217:6: ( ( rule__Model__Group_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:218:1: ( rule__Model__Group_2__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:219:1: ( rule__Model__Group_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:219:2: rule__Model__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__0_in_rule__Model__Alternatives406);
                    rule__Model__Group_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:223:6: ( ( rule__Model__Group_3__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:223:6: ( ( rule__Model__Group_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:224:1: ( rule__Model__Group_3__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:225:1: ( rule__Model__Group_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:225:2: rule__Model__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__0_in_rule__Model__Alternatives424);
                    rule__Model__Group_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_3()); 

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


    // $ANTLR start rule__SimpleModel__VisibilityAlternatives_0_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:234:1: rule__SimpleModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__SimpleModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:238:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("234:1: rule__SimpleModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:239:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:239:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:240:1: 'public'
                    {
                     before(grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__SimpleModel__VisibilityAlternatives_0_0_0458); 
                     after(grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:247:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:247:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:248:1: 'private'
                    {
                     before(grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__SimpleModel__VisibilityAlternatives_0_0_0478); 
                     after(grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:255:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:255:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:256:1: 'protected'
                    {
                     before(grammarAccess.getSimpleModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__SimpleModel__VisibilityAlternatives_0_0_0498); 
                     after(grammarAccess.getSimpleModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 

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
    // $ANTLR end rule__SimpleModel__VisibilityAlternatives_0_0_0


    // $ANTLR start rule__SimpleModel__Alternatives_0_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:268:1: rule__SimpleModel__Alternatives_0_3 : ( ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__SimpleModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:272:1: ( ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==23) ) {
                alt3=1;
            }
            else if ( (LA3_0==24) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("268:1: rule__SimpleModel__Alternatives_0_3 : ( ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:273:1: ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:273:1: ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:274:1: ( rule__SimpleModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:275:1: ( rule__SimpleModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:275:2: rule__SimpleModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__AbstractAssignment_0_3_0_in_rule__SimpleModel__Alternatives_0_3532);
                    rule__SimpleModel__AbstractAssignment_0_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getSimpleModelAccess().getAbstractAssignment_0_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:279:6: ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:279:6: ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:280:1: ( rule__SimpleModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:281:1: ( rule__SimpleModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:281:2: rule__SimpleModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__FinalAssignment_0_3_1_in_rule__SimpleModel__Alternatives_0_3550);
                    rule__SimpleModel__FinalAssignment_0_3_1();
                    _fsp--;


                    }

                     after(grammarAccess.getSimpleModelAccess().getFinalAssignment_0_3_1()); 

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
    // $ANTLR end rule__SimpleModel__Alternatives_0_3


    // $ANTLR start rule__MandatoryModel__VisibilityAlternatives_0_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:290:1: rule__MandatoryModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__MandatoryModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:294:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("290:1: rule__MandatoryModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:295:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:295:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:296:1: 'public'
                    {
                     before(grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0584); 
                     after(grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:303:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:303:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:304:1: 'private'
                    {
                     before(grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0604); 
                     after(grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:311:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:311:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:312:1: 'protected'
                    {
                     before(grammarAccess.getMandatoryModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0624); 
                     after(grammarAccess.getMandatoryModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 

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
    // $ANTLR end rule__MandatoryModel__VisibilityAlternatives_0_0_0


    // $ANTLR start rule__MandatoryModel__Alternatives_0_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:324:1: rule__MandatoryModel__Alternatives_0_3 : ( ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__MandatoryModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:328:1: ( ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            else if ( (LA5_0==24) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("324:1: rule__MandatoryModel__Alternatives_0_3 : ( ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:329:1: ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:329:1: ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:330:1: ( rule__MandatoryModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:331:1: ( rule__MandatoryModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:331:2: rule__MandatoryModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__AbstractAssignment_0_3_0_in_rule__MandatoryModel__Alternatives_0_3658);
                    rule__MandatoryModel__AbstractAssignment_0_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getMandatoryModelAccess().getAbstractAssignment_0_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:335:6: ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:335:6: ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:336:1: ( rule__MandatoryModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:337:1: ( rule__MandatoryModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:337:2: rule__MandatoryModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__FinalAssignment_0_3_1_in_rule__MandatoryModel__Alternatives_0_3676);
                    rule__MandatoryModel__FinalAssignment_0_3_1();
                    _fsp--;


                    }

                     after(grammarAccess.getMandatoryModelAccess().getFinalAssignment_0_3_1()); 

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
    // $ANTLR end rule__MandatoryModel__Alternatives_0_3


    // $ANTLR start rule__LoopedModel__VisibilityAlternatives_0_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:346:1: rule__LoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__LoopedModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:350:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
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
                NoViableAltException nvae =
                    new NoViableAltException("346:1: rule__LoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:351:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:351:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:352:1: 'public'
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LoopedModel__VisibilityAlternatives_0_0_0710); 
                     after(grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:359:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:359:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:360:1: 'private'
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__LoopedModel__VisibilityAlternatives_0_0_0730); 
                     after(grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:367:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:367:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:368:1: 'protected'
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__LoopedModel__VisibilityAlternatives_0_0_0750); 
                     after(grammarAccess.getLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 

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
    // $ANTLR end rule__LoopedModel__VisibilityAlternatives_0_0_0


    // $ANTLR start rule__LoopedModel__Alternatives_0_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:380:1: rule__LoopedModel__Alternatives_0_3 : ( ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__LoopedModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:384:1: ( ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==23) ) {
                alt7=1;
            }
            else if ( (LA7_0==24) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("380:1: rule__LoopedModel__Alternatives_0_3 : ( ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:385:1: ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:385:1: ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:386:1: ( rule__LoopedModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:387:1: ( rule__LoopedModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:387:2: rule__LoopedModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__AbstractAssignment_0_3_0_in_rule__LoopedModel__Alternatives_0_3784);
                    rule__LoopedModel__AbstractAssignment_0_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getAbstractAssignment_0_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:391:6: ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:391:6: ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:392:1: ( rule__LoopedModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:393:1: ( rule__LoopedModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:393:2: rule__LoopedModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__FinalAssignment_0_3_1_in_rule__LoopedModel__Alternatives_0_3802);
                    rule__LoopedModel__FinalAssignment_0_3_1();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getFinalAssignment_0_3_1()); 

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
    // $ANTLR end rule__LoopedModel__Alternatives_0_3


    // $ANTLR start rule__GroupLoopedModel__VisibilityAlternatives_0_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:402:1: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__GroupLoopedModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:406:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt8=1;
                }
                break;
            case 12:
                {
                alt8=2;
                }
                break;
            case 13:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("402:1: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:407:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:407:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:408:1: 'public'
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0836); 
                     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:415:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:415:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:416:1: 'private'
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0856); 
                     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:423:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:423:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:424:1: 'protected'
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0876); 
                     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 

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
    // $ANTLR end rule__GroupLoopedModel__VisibilityAlternatives_0_0_0


    // $ANTLR start rule__GroupLoopedModel__Alternatives_0_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:436:1: rule__GroupLoopedModel__Alternatives_0_3 : ( ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__GroupLoopedModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:440:1: ( ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            else if ( (LA9_0==24) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("436:1: rule__GroupLoopedModel__Alternatives_0_3 : ( ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) ) );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:441:1: ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:441:1: ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:442:1: ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:443:1: ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:443:2: rule__GroupLoopedModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__AbstractAssignment_0_3_0_in_rule__GroupLoopedModel__Alternatives_0_3910);
                    rule__GroupLoopedModel__AbstractAssignment_0_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getGroupLoopedModelAccess().getAbstractAssignment_0_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:447:6: ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:447:6: ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:448:1: ( rule__GroupLoopedModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:449:1: ( rule__GroupLoopedModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:449:2: rule__GroupLoopedModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__FinalAssignment_0_3_1_in_rule__GroupLoopedModel__Alternatives_0_3928);
                    rule__GroupLoopedModel__FinalAssignment_0_3_1();
                    _fsp--;


                    }

                     after(grammarAccess.getGroupLoopedModelAccess().getFinalAssignment_0_3_1()); 

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
    // $ANTLR end rule__GroupLoopedModel__Alternatives_0_3


    // $ANTLR start rule__Model__Group_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:460:1: rule__Model__Group_0__0 : ( '1' ) rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:464:1: ( ( '1' ) rule__Model__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:465:1: ( '1' ) rule__Model__Group_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:465:1: ( '1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:466:1: '1'
            {
             before(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Model__Group_0__0964); 
             after(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__0974);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:480:1: rule__Model__Group_0__1 : ( ( rule__Model__FirstAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:484:1: ( ( ( rule__Model__FirstAssignment_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:485:1: ( ( rule__Model__FirstAssignment_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:485:1: ( ( rule__Model__FirstAssignment_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:486:1: ( rule__Model__FirstAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getFirstAssignment_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:487:1: ( rule__Model__FirstAssignment_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:487:2: rule__Model__FirstAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__FirstAssignment_0_1_in_rule__Model__Group_0__11002);
            rule__Model__FirstAssignment_0_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getFirstAssignment_0_1()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:501:1: rule__Model__Group_1__0 : ( '2' ) rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:505:1: ( ( '2' ) rule__Model__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:506:1: ( '2' ) rule__Model__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:506:1: ( '2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:507:1: '2'
            {
             before(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__Group_1__01041); 
             after(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01051);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:521:1: rule__Model__Group_1__1 : ( ( rule__Model__SecondAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:525:1: ( ( ( rule__Model__SecondAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:526:1: ( ( rule__Model__SecondAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:526:1: ( ( rule__Model__SecondAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:527:1: ( rule__Model__SecondAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getSecondAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:528:1: ( rule__Model__SecondAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:528:2: rule__Model__SecondAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__SecondAssignment_1_1_in_rule__Model__Group_1__11079);
            rule__Model__SecondAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getSecondAssignment_1_1()); 

            }


            }

        }
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


    // $ANTLR start rule__Model__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:542:1: rule__Model__Group_2__0 : ( '3' ) rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:546:1: ( ( '3' ) rule__Model__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:547:1: ( '3' ) rule__Model__Group_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:547:1: ( '3' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:548:1: '3'
            {
             before(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Model__Group_2__01118); 
             after(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__01128);
            rule__Model__Group_2__1();
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
    // $ANTLR end rule__Model__Group_2__0


    // $ANTLR start rule__Model__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:562:1: rule__Model__Group_2__1 : ( ( rule__Model__ThrirdAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:566:1: ( ( ( rule__Model__ThrirdAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:567:1: ( ( rule__Model__ThrirdAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:567:1: ( ( rule__Model__ThrirdAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:568:1: ( rule__Model__ThrirdAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getThrirdAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:569:1: ( rule__Model__ThrirdAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:569:2: rule__Model__ThrirdAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ThrirdAssignment_2_1_in_rule__Model__Group_2__11156);
            rule__Model__ThrirdAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getThrirdAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_2__1


    // $ANTLR start rule__Model__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:583:1: rule__Model__Group_3__0 : ( '4' ) rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:587:1: ( ( '4' ) rule__Model__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:588:1: ( '4' ) rule__Model__Group_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:588:1: ( '4' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:589:1: '4'
            {
             before(grammarAccess.getModelAccess().getDigitFourKeyword_3_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Model__Group_3__01195); 
             after(grammarAccess.getModelAccess().getDigitFourKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__1_in_rule__Model__Group_3__01205);
            rule__Model__Group_3__1();
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
    // $ANTLR end rule__Model__Group_3__0


    // $ANTLR start rule__Model__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:603:1: rule__Model__Group_3__1 : ( ( rule__Model__ForthAssignment_3_1 ) ) ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:607:1: ( ( ( rule__Model__ForthAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:608:1: ( ( rule__Model__ForthAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:608:1: ( ( rule__Model__ForthAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:609:1: ( rule__Model__ForthAssignment_3_1 )
            {
             before(grammarAccess.getModelAccess().getForthAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:610:1: ( rule__Model__ForthAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:610:2: rule__Model__ForthAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ForthAssignment_3_1_in_rule__Model__Group_3__11233);
            rule__Model__ForthAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getForthAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_3__1


    // $ANTLR start rule__SimpleModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:624:1: rule__SimpleModel__Group__0 : ( ( rule__SimpleModel__UnorderedGroup_0 ) ) rule__SimpleModel__Group__1 ;
    public final void rule__SimpleModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:628:1: ( ( ( rule__SimpleModel__UnorderedGroup_0 ) ) rule__SimpleModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:629:1: ( ( rule__SimpleModel__UnorderedGroup_0 ) ) rule__SimpleModel__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:629:1: ( ( rule__SimpleModel__UnorderedGroup_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:630:1: ( rule__SimpleModel__UnorderedGroup_0 )
            {
             before(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:631:1: ( rule__SimpleModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:631:2: rule__SimpleModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0_in_rule__SimpleModel__Group__01271);
            rule__SimpleModel__UnorderedGroup_0();
            _fsp--;


            }

             after(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__1_in_rule__SimpleModel__Group__01280);
            rule__SimpleModel__Group__1();
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
    // $ANTLR end rule__SimpleModel__Group__0


    // $ANTLR start rule__SimpleModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:642:1: rule__SimpleModel__Group__1 : ( 'class' ) rule__SimpleModel__Group__2 ;
    public final void rule__SimpleModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:646:1: ( ( 'class' ) rule__SimpleModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:647:1: ( 'class' ) rule__SimpleModel__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:647:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:648:1: 'class'
            {
             before(grammarAccess.getSimpleModelAccess().getClassKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__SimpleModel__Group__11309); 
             after(grammarAccess.getSimpleModelAccess().getClassKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__2_in_rule__SimpleModel__Group__11319);
            rule__SimpleModel__Group__2();
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
    // $ANTLR end rule__SimpleModel__Group__1


    // $ANTLR start rule__SimpleModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:662:1: rule__SimpleModel__Group__2 : ( ( rule__SimpleModel__NameAssignment_2 ) ) rule__SimpleModel__Group__3 ;
    public final void rule__SimpleModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:666:1: ( ( ( rule__SimpleModel__NameAssignment_2 ) ) rule__SimpleModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:667:1: ( ( rule__SimpleModel__NameAssignment_2 ) ) rule__SimpleModel__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:667:1: ( ( rule__SimpleModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:668:1: ( rule__SimpleModel__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:669:1: ( rule__SimpleModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:669:2: rule__SimpleModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__NameAssignment_2_in_rule__SimpleModel__Group__21347);
            rule__SimpleModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getSimpleModelAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__3_in_rule__SimpleModel__Group__21356);
            rule__SimpleModel__Group__3();
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
    // $ANTLR end rule__SimpleModel__Group__2


    // $ANTLR start rule__SimpleModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:680:1: rule__SimpleModel__Group__3 : ( '{' ) rule__SimpleModel__Group__4 ;
    public final void rule__SimpleModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:684:1: ( ( '{' ) rule__SimpleModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:685:1: ( '{' ) rule__SimpleModel__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:685:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:686:1: '{'
            {
             before(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__SimpleModel__Group__31385); 
             after(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__4_in_rule__SimpleModel__Group__31395);
            rule__SimpleModel__Group__4();
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
    // $ANTLR end rule__SimpleModel__Group__3


    // $ANTLR start rule__SimpleModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:700:1: rule__SimpleModel__Group__4 : ( '}' ) ;
    public final void rule__SimpleModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:704:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:705:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:705:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:706:1: '}'
            {
             before(grammarAccess.getSimpleModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__SimpleModel__Group__41424); 
             after(grammarAccess.getSimpleModelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__Group__4


    // $ANTLR start rule__MandatoryModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:729:1: rule__MandatoryModel__Group__0 : ( ( rule__MandatoryModel__UnorderedGroup_0 ) ) rule__MandatoryModel__Group__1 ;
    public final void rule__MandatoryModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:733:1: ( ( ( rule__MandatoryModel__UnorderedGroup_0 ) ) rule__MandatoryModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:734:1: ( ( rule__MandatoryModel__UnorderedGroup_0 ) ) rule__MandatoryModel__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:734:1: ( ( rule__MandatoryModel__UnorderedGroup_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:735:1: ( rule__MandatoryModel__UnorderedGroup_0 )
            {
             before(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:736:1: ( rule__MandatoryModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:736:2: rule__MandatoryModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0_in_rule__MandatoryModel__Group__01469);
            rule__MandatoryModel__UnorderedGroup_0();
            _fsp--;


            }

             after(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__1_in_rule__MandatoryModel__Group__01478);
            rule__MandatoryModel__Group__1();
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
    // $ANTLR end rule__MandatoryModel__Group__0


    // $ANTLR start rule__MandatoryModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:747:1: rule__MandatoryModel__Group__1 : ( 'class' ) rule__MandatoryModel__Group__2 ;
    public final void rule__MandatoryModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:751:1: ( ( 'class' ) rule__MandatoryModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:752:1: ( 'class' ) rule__MandatoryModel__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:752:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:753:1: 'class'
            {
             before(grammarAccess.getMandatoryModelAccess().getClassKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__MandatoryModel__Group__11507); 
             after(grammarAccess.getMandatoryModelAccess().getClassKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__2_in_rule__MandatoryModel__Group__11517);
            rule__MandatoryModel__Group__2();
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
    // $ANTLR end rule__MandatoryModel__Group__1


    // $ANTLR start rule__MandatoryModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:767:1: rule__MandatoryModel__Group__2 : ( ( rule__MandatoryModel__NameAssignment_2 ) ) rule__MandatoryModel__Group__3 ;
    public final void rule__MandatoryModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:771:1: ( ( ( rule__MandatoryModel__NameAssignment_2 ) ) rule__MandatoryModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:772:1: ( ( rule__MandatoryModel__NameAssignment_2 ) ) rule__MandatoryModel__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:772:1: ( ( rule__MandatoryModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:773:1: ( rule__MandatoryModel__NameAssignment_2 )
            {
             before(grammarAccess.getMandatoryModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:774:1: ( rule__MandatoryModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:774:2: rule__MandatoryModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__NameAssignment_2_in_rule__MandatoryModel__Group__21545);
            rule__MandatoryModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getMandatoryModelAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__3_in_rule__MandatoryModel__Group__21554);
            rule__MandatoryModel__Group__3();
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
    // $ANTLR end rule__MandatoryModel__Group__2


    // $ANTLR start rule__MandatoryModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:785:1: rule__MandatoryModel__Group__3 : ( '{' ) rule__MandatoryModel__Group__4 ;
    public final void rule__MandatoryModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:789:1: ( ( '{' ) rule__MandatoryModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:790:1: ( '{' ) rule__MandatoryModel__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:790:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:791:1: '{'
            {
             before(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__MandatoryModel__Group__31583); 
             after(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__4_in_rule__MandatoryModel__Group__31593);
            rule__MandatoryModel__Group__4();
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
    // $ANTLR end rule__MandatoryModel__Group__3


    // $ANTLR start rule__MandatoryModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:805:1: rule__MandatoryModel__Group__4 : ( '}' ) ;
    public final void rule__MandatoryModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:809:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:810:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:810:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:811:1: '}'
            {
             before(grammarAccess.getMandatoryModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__MandatoryModel__Group__41622); 
             after(grammarAccess.getMandatoryModelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__Group__4


    // $ANTLR start rule__LoopedModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:834:1: rule__LoopedModel__Group__0 : ( ( rule__LoopedModel__UnorderedGroup_0 ) ) rule__LoopedModel__Group__1 ;
    public final void rule__LoopedModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:838:1: ( ( ( rule__LoopedModel__UnorderedGroup_0 ) ) rule__LoopedModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:839:1: ( ( rule__LoopedModel__UnorderedGroup_0 ) ) rule__LoopedModel__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:839:1: ( ( rule__LoopedModel__UnorderedGroup_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:840:1: ( rule__LoopedModel__UnorderedGroup_0 )
            {
             before(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:841:1: ( rule__LoopedModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:841:2: rule__LoopedModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0_in_rule__LoopedModel__Group__01667);
            rule__LoopedModel__UnorderedGroup_0();
            _fsp--;


            }

             after(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__1_in_rule__LoopedModel__Group__01676);
            rule__LoopedModel__Group__1();
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
    // $ANTLR end rule__LoopedModel__Group__0


    // $ANTLR start rule__LoopedModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:852:1: rule__LoopedModel__Group__1 : ( 'class' ) rule__LoopedModel__Group__2 ;
    public final void rule__LoopedModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:856:1: ( ( 'class' ) rule__LoopedModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:857:1: ( 'class' ) rule__LoopedModel__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:857:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:858:1: 'class'
            {
             before(grammarAccess.getLoopedModelAccess().getClassKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__LoopedModel__Group__11705); 
             after(grammarAccess.getLoopedModelAccess().getClassKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__2_in_rule__LoopedModel__Group__11715);
            rule__LoopedModel__Group__2();
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
    // $ANTLR end rule__LoopedModel__Group__1


    // $ANTLR start rule__LoopedModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:872:1: rule__LoopedModel__Group__2 : ( ( rule__LoopedModel__NameAssignment_2 ) ) rule__LoopedModel__Group__3 ;
    public final void rule__LoopedModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:876:1: ( ( ( rule__LoopedModel__NameAssignment_2 ) ) rule__LoopedModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:877:1: ( ( rule__LoopedModel__NameAssignment_2 ) ) rule__LoopedModel__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:877:1: ( ( rule__LoopedModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:878:1: ( rule__LoopedModel__NameAssignment_2 )
            {
             before(grammarAccess.getLoopedModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:879:1: ( rule__LoopedModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:879:2: rule__LoopedModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__NameAssignment_2_in_rule__LoopedModel__Group__21743);
            rule__LoopedModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getLoopedModelAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__3_in_rule__LoopedModel__Group__21752);
            rule__LoopedModel__Group__3();
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
    // $ANTLR end rule__LoopedModel__Group__2


    // $ANTLR start rule__LoopedModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:890:1: rule__LoopedModel__Group__3 : ( '{' ) rule__LoopedModel__Group__4 ;
    public final void rule__LoopedModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:894:1: ( ( '{' ) rule__LoopedModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:895:1: ( '{' ) rule__LoopedModel__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:895:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:896:1: '{'
            {
             before(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__LoopedModel__Group__31781); 
             after(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__4_in_rule__LoopedModel__Group__31791);
            rule__LoopedModel__Group__4();
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
    // $ANTLR end rule__LoopedModel__Group__3


    // $ANTLR start rule__LoopedModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:910:1: rule__LoopedModel__Group__4 : ( '}' ) ;
    public final void rule__LoopedModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:914:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:915:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:915:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:916:1: '}'
            {
             before(grammarAccess.getLoopedModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LoopedModel__Group__41820); 
             after(grammarAccess.getLoopedModelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__Group__4


    // $ANTLR start rule__GroupLoopedModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:939:1: rule__GroupLoopedModel__Group__0 : ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* ) rule__GroupLoopedModel__Group__1 ;
    public final void rule__GroupLoopedModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:943:1: ( ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* ) rule__GroupLoopedModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:944:1: ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* ) rule__GroupLoopedModel__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:944:1: ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:945:1: ( rule__GroupLoopedModel__UnorderedGroup_0 )*
            {
             before(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:946:1: ( rule__GroupLoopedModel__UnorderedGroup_0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=11 && LA10_0<=13)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    alt10=1;
                }
                else if ( (LA10_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1))) {
                    alt10=1;
                }
                else if ( (LA10_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2))) {
                    alt10=1;
                }
                else if ( ((LA10_0>=23 && LA10_0<=24)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:946:2: rule__GroupLoopedModel__UnorderedGroup_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0_in_rule__GroupLoopedModel__Group__01865);
            	    rule__GroupLoopedModel__UnorderedGroup_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__1_in_rule__GroupLoopedModel__Group__01875);
            rule__GroupLoopedModel__Group__1();
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
    // $ANTLR end rule__GroupLoopedModel__Group__0


    // $ANTLR start rule__GroupLoopedModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:957:1: rule__GroupLoopedModel__Group__1 : ( 'class' ) rule__GroupLoopedModel__Group__2 ;
    public final void rule__GroupLoopedModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:961:1: ( ( 'class' ) rule__GroupLoopedModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:962:1: ( 'class' ) rule__GroupLoopedModel__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:962:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:963:1: 'class'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__GroupLoopedModel__Group__11904); 
             after(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__2_in_rule__GroupLoopedModel__Group__11914);
            rule__GroupLoopedModel__Group__2();
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
    // $ANTLR end rule__GroupLoopedModel__Group__1


    // $ANTLR start rule__GroupLoopedModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:977:1: rule__GroupLoopedModel__Group__2 : ( ( rule__GroupLoopedModel__NameAssignment_2 ) ) rule__GroupLoopedModel__Group__3 ;
    public final void rule__GroupLoopedModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:981:1: ( ( ( rule__GroupLoopedModel__NameAssignment_2 ) ) rule__GroupLoopedModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:982:1: ( ( rule__GroupLoopedModel__NameAssignment_2 ) ) rule__GroupLoopedModel__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:982:1: ( ( rule__GroupLoopedModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:983:1: ( rule__GroupLoopedModel__NameAssignment_2 )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:984:1: ( rule__GroupLoopedModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:984:2: rule__GroupLoopedModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__NameAssignment_2_in_rule__GroupLoopedModel__Group__21942);
            rule__GroupLoopedModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getGroupLoopedModelAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__3_in_rule__GroupLoopedModel__Group__21951);
            rule__GroupLoopedModel__Group__3();
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
    // $ANTLR end rule__GroupLoopedModel__Group__2


    // $ANTLR start rule__GroupLoopedModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:995:1: rule__GroupLoopedModel__Group__3 : ( '{' ) rule__GroupLoopedModel__Group__4 ;
    public final void rule__GroupLoopedModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:999:1: ( ( '{' ) rule__GroupLoopedModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1000:1: ( '{' ) rule__GroupLoopedModel__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1000:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1001:1: '{'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__GroupLoopedModel__Group__31980); 
             after(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__4_in_rule__GroupLoopedModel__Group__31990);
            rule__GroupLoopedModel__Group__4();
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
    // $ANTLR end rule__GroupLoopedModel__Group__3


    // $ANTLR start rule__GroupLoopedModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1015:1: rule__GroupLoopedModel__Group__4 : ( '}' ) ;
    public final void rule__GroupLoopedModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1019:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1020:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1020:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1021:1: '}'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__GroupLoopedModel__Group__42019); 
             after(grammarAccess.getGroupLoopedModelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__Group__4


    // $ANTLR start rule__SimpleModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1045:1: rule__SimpleModel__UnorderedGroup_0 : ( ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )* ) ;
    public final void rule__SimpleModel__UnorderedGroup_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1050:1: ( ( ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1051:2: ( ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1051:2: ( ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1052:3: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1052:3: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )*
            loop11:
            do {
                int alt11=5;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=11 && LA11_0<=13)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0))) {
                    alt11=1;
                }
                else if ( (LA11_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1))) {
                    alt11=2;
                }
                else if ( (LA11_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2))) {
                    alt11=3;
                }
                else if ( ((LA11_0>=23 && LA11_0<=24)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3))) {
                    alt11=4;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1054:4: ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1054:4: ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1055:5: {...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1055:108: ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1056:6: ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1059:6: ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1060:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
            	    {
            	     before(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1061:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1061:8: rule__SimpleModel__VisibilityAssignment_0_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_rule__SimpleModel__UnorderedGroup_02111);
            	    rule__SimpleModel__VisibilityAssignment_0_0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1070:4: ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1070:4: ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1071:5: {...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1071:108: ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1072:6: ( ( rule__SimpleModel__StaticAssignment_0_1 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1075:6: ( ( rule__SimpleModel__StaticAssignment_0_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1076:7: ( rule__SimpleModel__StaticAssignment_0_1 )
            	    {
            	     before(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1077:7: ( rule__SimpleModel__StaticAssignment_0_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1077:8: rule__SimpleModel__StaticAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_rule__SimpleModel__UnorderedGroup_02195);
            	    rule__SimpleModel__StaticAssignment_0_1();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1086:4: ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1086:4: ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1087:5: {...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1087:108: ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1088:6: ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1091:6: ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1092:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
            	    {
            	     before(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1093:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1093:8: rule__SimpleModel__SynchronizedAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_rule__SimpleModel__UnorderedGroup_02279);
            	    rule__SimpleModel__SynchronizedAssignment_0_2();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1102:4: ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1102:4: ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1103:5: {...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1103:108: ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1104:6: ( ( rule__SimpleModel__Alternatives_0_3 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1107:6: ( ( rule__SimpleModel__Alternatives_0_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1108:7: ( rule__SimpleModel__Alternatives_0_3 )
            	    {
            	     before(grammarAccess.getSimpleModelAccess().getAlternatives_0_3()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1109:7: ( rule__SimpleModel__Alternatives_0_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1109:8: rule__SimpleModel__Alternatives_0_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Alternatives_0_3_in_rule__SimpleModel__UnorderedGroup_02363);
            	    rule__SimpleModel__Alternatives_0_3();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getSimpleModelAccess().getAlternatives_0_3()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__UnorderedGroup_0


    // $ANTLR start rule__MandatoryModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1128:1: rule__MandatoryModel__UnorderedGroup_0 : ( ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )+ {...}?) ;
    public final void rule__MandatoryModel__UnorderedGroup_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1133:1: ( ( ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )+ {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1134:2: ( ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )+ {...}?)
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1134:2: ( ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )+ {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1135:3: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1135:3: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=5;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=11 && LA12_0<=13)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0))) {
                    alt12=1;
                }
                else if ( (LA12_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1))) {
                    alt12=2;
                }
                else if ( (LA12_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2))) {
                    alt12=3;
                }
                else if ( ((LA12_0>=23 && LA12_0<=24)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3))) {
                    alt12=4;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1137:4: ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1137:4: ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1138:5: {...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1138:111: ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1139:6: ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1142:6: ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1143:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
            	    {
            	     before(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1144:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1144:8: rule__MandatoryModel__VisibilityAssignment_0_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_rule__MandatoryModel__UnorderedGroup_02485);
            	    rule__MandatoryModel__VisibilityAssignment_0_0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1153:4: ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1153:4: ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1154:5: {...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1154:111: ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1155:6: ( ( rule__MandatoryModel__StaticAssignment_0_1 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1158:6: ( ( rule__MandatoryModel__StaticAssignment_0_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1159:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
            	    {
            	     before(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1160:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1160:8: rule__MandatoryModel__StaticAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_rule__MandatoryModel__UnorderedGroup_02569);
            	    rule__MandatoryModel__StaticAssignment_0_1();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1169:4: ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1169:4: ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1170:5: {...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1170:111: ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1171:6: ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1174:6: ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1175:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
            	    {
            	     before(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1176:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1176:8: rule__MandatoryModel__SynchronizedAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_rule__MandatoryModel__UnorderedGroup_02653);
            	    rule__MandatoryModel__SynchronizedAssignment_0_2();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1185:4: ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1185:4: ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1186:5: {...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1186:111: ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1187:6: ( ( rule__MandatoryModel__Alternatives_0_3 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1190:6: ( ( rule__MandatoryModel__Alternatives_0_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1191:7: ( rule__MandatoryModel__Alternatives_0_3 )
            	    {
            	     before(grammarAccess.getMandatoryModelAccess().getAlternatives_0_3()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1192:7: ( rule__MandatoryModel__Alternatives_0_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1192:8: rule__MandatoryModel__Alternatives_0_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Alternatives_0_3_in_rule__MandatoryModel__UnorderedGroup_02737);
            	    rule__MandatoryModel__Alternatives_0_3();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getMandatoryModelAccess().getAlternatives_0_3()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            if ( !(getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0())) ) {
                throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0())");
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__UnorderedGroup_0


    // $ANTLR start rule__LoopedModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1212:1: rule__LoopedModel__UnorderedGroup_0 : ( ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )* ) ;
    public final void rule__LoopedModel__UnorderedGroup_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1217:1: ( ( ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1218:2: ( ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1218:2: ( ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1219:3: ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1219:3: ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )*
            loop17:
            do {
                int alt17=5;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=11 && LA17_0<=13)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    alt17=1;
                }
                else if ( (LA17_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1))) {
                    alt17=2;
                }
                else if ( (LA17_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2))) {
                    alt17=3;
                }
                else if ( ((LA17_0>=23 && LA17_0<=24)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    alt17=4;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1221:4: ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1221:4: ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1222:5: {...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1222:108: ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1223:6: ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1226:6: ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1226:12: ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1226:12: ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1227:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1228:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1228:8: rule__LoopedModel__VisibilityAssignment_0_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_02871);
            	    rule__LoopedModel__VisibilityAssignment_0_0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 

            	    }

            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1231:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1232:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )*
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1233:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )*
            	    loop13:
            	    do {
            	        int alt13=2;
            	        switch ( input.LA(1) ) {
            	        case 11:
            	            {
            	            int LA13_2 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) ) {
            	                alt13=1;
            	            }


            	            }
            	            break;
            	        case 12:
            	            {
            	            int LA13_3 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) ) {
            	                alt13=1;
            	            }


            	            }
            	            break;
            	        case 13:
            	            {
            	            int LA13_4 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) ) {
            	                alt13=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt13) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1233:8: rule__LoopedModel__VisibilityAssignment_0_0
            	    	    {
            	    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_02911);
            	    	    rule__LoopedModel__VisibilityAssignment_0_0();
            	    	    _fsp--;


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop13;
            	        }
            	    } while (true);

            	     after(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1242:4: ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1242:4: ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1243:5: {...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1243:108: ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1244:6: ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1247:6: ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1247:12: ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1247:12: ( ( rule__LoopedModel__StaticAssignment_0_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1248:7: ( rule__LoopedModel__StaticAssignment_0_1 )
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1249:7: ( rule__LoopedModel__StaticAssignment_0_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1249:8: rule__LoopedModel__StaticAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_03008);
            	    rule__LoopedModel__StaticAssignment_0_1();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 

            	    }

            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1252:6: ( ( rule__LoopedModel__StaticAssignment_0_1 )* )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1253:7: ( rule__LoopedModel__StaticAssignment_0_1 )*
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1254:7: ( rule__LoopedModel__StaticAssignment_0_1 )*
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==21) ) {
            	            int LA14_3 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1))) ) {
            	                alt14=1;
            	            }


            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1254:8: rule__LoopedModel__StaticAssignment_0_1
            	    	    {
            	    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_03048);
            	    	    rule__LoopedModel__StaticAssignment_0_1();
            	    	    _fsp--;


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop14;
            	        }
            	    } while (true);

            	     after(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1263:4: ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1263:4: ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1264:5: {...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1264:108: ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1265:6: ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1268:6: ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1268:12: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1268:12: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1269:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1270:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1270:8: rule__LoopedModel__SynchronizedAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_03145);
            	    rule__LoopedModel__SynchronizedAssignment_0_2();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 

            	    }

            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1273:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1274:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )*
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1275:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )*
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==22) ) {
            	            int LA15_4 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2))) ) {
            	                alt15=1;
            	            }


            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1275:8: rule__LoopedModel__SynchronizedAssignment_0_2
            	    	    {
            	    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_03185);
            	    	    rule__LoopedModel__SynchronizedAssignment_0_2();
            	    	    _fsp--;


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop15;
            	        }
            	    } while (true);

            	     after(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1284:4: ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1284:4: ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1285:5: {...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1285:108: ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1286:6: ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1289:6: ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1289:12: ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1289:12: ( ( rule__LoopedModel__Alternatives_0_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1290:7: ( rule__LoopedModel__Alternatives_0_3 )
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1291:7: ( rule__LoopedModel__Alternatives_0_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1291:8: rule__LoopedModel__Alternatives_0_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_03282);
            	    rule__LoopedModel__Alternatives_0_3();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 

            	    }

            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1294:6: ( ( rule__LoopedModel__Alternatives_0_3 )* )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1295:7: ( rule__LoopedModel__Alternatives_0_3 )*
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1296:7: ( rule__LoopedModel__Alternatives_0_3 )*
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==23) ) {
            	            int LA16_5 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3))) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==24) ) {
            	            int LA16_6 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3))) ) {
            	                alt16=1;
            	            }


            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1296:8: rule__LoopedModel__Alternatives_0_3
            	    	    {
            	    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_03322);
            	    	    rule__LoopedModel__Alternatives_0_3();
            	    	    _fsp--;


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop16;
            	        }
            	    } while (true);

            	     after(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__UnorderedGroup_0


    // $ANTLR start rule__GroupLoopedModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1315:1: rule__GroupLoopedModel__UnorderedGroup_0 : ( ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )+ {...}?) ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1320:1: ( ( ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )+ {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1321:2: ( ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )+ {...}?)
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1321:2: ( ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )+ {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1322:3: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1322:3: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=5;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==11) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    int LA18_2 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==12) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    int LA18_3 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==13) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    int LA18_4 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1))) {
                    int LA18_5 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
                        alt18=2;
                    }


                }
                else if ( (LA18_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2))) {
                    int LA18_6 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
                        alt18=3;
                    }


                }
                else if ( (LA18_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    int LA18_7 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
                        alt18=4;
                    }


                }
                else if ( (LA18_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    int LA18_8 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
                        alt18=4;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1324:4: ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1324:4: ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1325:5: {...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1325:113: ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1326:6: ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1329:6: ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1330:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
            	    {
            	     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1331:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1331:8: rule__GroupLoopedModel__VisibilityAssignment_0_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_rule__GroupLoopedModel__UnorderedGroup_03451);
            	    rule__GroupLoopedModel__VisibilityAssignment_0_0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1340:4: ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1340:4: ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1341:5: {...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1341:113: ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1342:6: ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1345:6: ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1346:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
            	    {
            	     before(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1347:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1347:8: rule__GroupLoopedModel__StaticAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_rule__GroupLoopedModel__UnorderedGroup_03535);
            	    rule__GroupLoopedModel__StaticAssignment_0_1();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1356:4: ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1356:4: ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1357:5: {...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1357:113: ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1358:6: ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1361:6: ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1362:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
            	    {
            	     before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1363:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1363:8: rule__GroupLoopedModel__SynchronizedAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_rule__GroupLoopedModel__UnorderedGroup_03619);
            	    rule__GroupLoopedModel__SynchronizedAssignment_0_2();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1372:4: ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1372:4: ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1373:5: {...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1373:113: ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1374:6: ( ( rule__GroupLoopedModel__Alternatives_0_3 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1377:6: ( ( rule__GroupLoopedModel__Alternatives_0_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1378:7: ( rule__GroupLoopedModel__Alternatives_0_3 )
            	    {
            	     before(grammarAccess.getGroupLoopedModelAccess().getAlternatives_0_3()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1379:7: ( rule__GroupLoopedModel__Alternatives_0_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1379:8: rule__GroupLoopedModel__Alternatives_0_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Alternatives_0_3_in_rule__GroupLoopedModel__UnorderedGroup_03703);
            	    rule__GroupLoopedModel__Alternatives_0_3();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getGroupLoopedModelAccess().getAlternatives_0_3()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            if ( !(getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0())) ) {
                throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0())");
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__UnorderedGroup_0


    // $ANTLR start rule__Model__FirstAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1399:1: rule__Model__FirstAssignment_0_1 : ( ruleSimpleModel ) ;
    public final void rule__Model__FirstAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1403:1: ( ( ruleSimpleModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1404:1: ( ruleSimpleModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1404:1: ( ruleSimpleModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1405:1: ruleSimpleModel
            {
             before(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_rule__Model__FirstAssignment_0_13785);
            ruleSimpleModel();
            _fsp--;

             after(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__FirstAssignment_0_1


    // $ANTLR start rule__Model__SecondAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1414:1: rule__Model__SecondAssignment_1_1 : ( ruleMandatoryModel ) ;
    public final void rule__Model__SecondAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1418:1: ( ( ruleMandatoryModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:1: ( ruleMandatoryModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:1: ( ruleMandatoryModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1420:1: ruleMandatoryModel
            {
             before(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_rule__Model__SecondAssignment_1_13816);
            ruleMandatoryModel();
            _fsp--;

             after(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__SecondAssignment_1_1


    // $ANTLR start rule__Model__ThrirdAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1429:1: rule__Model__ThrirdAssignment_2_1 : ( ruleLoopedModel ) ;
    public final void rule__Model__ThrirdAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1433:1: ( ( ruleLoopedModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1434:1: ( ruleLoopedModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1434:1: ( ruleLoopedModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1435:1: ruleLoopedModel
            {
             before(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_rule__Model__ThrirdAssignment_2_13847);
            ruleLoopedModel();
            _fsp--;

             after(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ThrirdAssignment_2_1


    // $ANTLR start rule__Model__ForthAssignment_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1444:1: rule__Model__ForthAssignment_3_1 : ( ruleGroupLoopedModel ) ;
    public final void rule__Model__ForthAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1448:1: ( ( ruleGroupLoopedModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1449:1: ( ruleGroupLoopedModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1449:1: ( ruleGroupLoopedModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1450:1: ruleGroupLoopedModel
            {
             before(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_rule__Model__ForthAssignment_3_13878);
            ruleGroupLoopedModel();
            _fsp--;

             after(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ForthAssignment_3_1


    // $ANTLR start rule__SimpleModel__VisibilityAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1459:1: rule__SimpleModel__VisibilityAssignment_0_0 : ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__SimpleModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1463:1: ( ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1464:1: ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1464:1: ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1465:1: ( rule__SimpleModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getSimpleModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1466:1: ( rule__SimpleModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1466:2: rule__SimpleModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAlternatives_0_0_0_in_rule__SimpleModel__VisibilityAssignment_0_03909);
            rule__SimpleModel__VisibilityAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getSimpleModelAccess().getVisibilityAlternatives_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__VisibilityAssignment_0_0


    // $ANTLR start rule__SimpleModel__StaticAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1475:1: rule__SimpleModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__SimpleModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1479:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1480:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1480:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1481:1: ( 'static' )
            {
             before(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1482:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1483:1: 'static'
            {
             before(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__SimpleModel__StaticAssignment_0_13947); 
             after(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 

            }

             after(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__StaticAssignment_0_1


    // $ANTLR start rule__SimpleModel__SynchronizedAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1498:1: rule__SimpleModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__SimpleModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1502:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1503:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1503:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1504:1: ( 'synchronized' )
            {
             before(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1505:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1506:1: 'synchronized'
            {
             before(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__SimpleModel__SynchronizedAssignment_0_23991); 
             after(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }

             after(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__SynchronizedAssignment_0_2


    // $ANTLR start rule__SimpleModel__AbstractAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1521:1: rule__SimpleModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__SimpleModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1525:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1526:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1526:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1527:1: ( 'abstract' )
            {
             before(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1528:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1529:1: 'abstract'
            {
             before(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__SimpleModel__AbstractAssignment_0_3_04035); 
             after(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__AbstractAssignment_0_3_0


    // $ANTLR start rule__SimpleModel__FinalAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1544:1: rule__SimpleModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__SimpleModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1548:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1549:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1549:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1550:1: ( 'final' )
            {
             before(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1551:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1552:1: 'final'
            {
             before(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__SimpleModel__FinalAssignment_0_3_14079); 
             after(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }

             after(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__FinalAssignment_0_3_1


    // $ANTLR start rule__SimpleModel__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1567:1: rule__SimpleModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1571:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1572:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1572:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1573:1: RULE_ID
            {
             before(grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SimpleModel__NameAssignment_24118); 
             after(grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__NameAssignment_2


    // $ANTLR start rule__MandatoryModel__VisibilityAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1582:1: rule__MandatoryModel__VisibilityAssignment_0_0 : ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__MandatoryModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1586:1: ( ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1587:1: ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1587:1: ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1588:1: ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getMandatoryModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1589:1: ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1589:2: rule__MandatoryModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAlternatives_0_0_0_in_rule__MandatoryModel__VisibilityAssignment_0_04149);
            rule__MandatoryModel__VisibilityAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getMandatoryModelAccess().getVisibilityAlternatives_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__VisibilityAssignment_0_0


    // $ANTLR start rule__MandatoryModel__StaticAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1598:1: rule__MandatoryModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__MandatoryModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1602:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1603:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1603:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1604:1: ( 'static' )
            {
             before(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1605:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1606:1: 'static'
            {
             before(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__MandatoryModel__StaticAssignment_0_14187); 
             after(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 

            }

             after(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__StaticAssignment_0_1


    // $ANTLR start rule__MandatoryModel__SynchronizedAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1621:1: rule__MandatoryModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__MandatoryModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1625:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1626:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1626:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1627:1: ( 'synchronized' )
            {
             before(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1628:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1629:1: 'synchronized'
            {
             before(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__MandatoryModel__SynchronizedAssignment_0_24231); 
             after(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }

             after(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__SynchronizedAssignment_0_2


    // $ANTLR start rule__MandatoryModel__AbstractAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1644:1: rule__MandatoryModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__MandatoryModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1648:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1649:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1649:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1650:1: ( 'abstract' )
            {
             before(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1651:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1652:1: 'abstract'
            {
             before(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__MandatoryModel__AbstractAssignment_0_3_04275); 
             after(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__AbstractAssignment_0_3_0


    // $ANTLR start rule__MandatoryModel__FinalAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1667:1: rule__MandatoryModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__MandatoryModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1671:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1672:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1672:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1673:1: ( 'final' )
            {
             before(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1674:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1675:1: 'final'
            {
             before(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__MandatoryModel__FinalAssignment_0_3_14319); 
             after(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }

             after(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__FinalAssignment_0_3_1


    // $ANTLR start rule__MandatoryModel__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1690:1: rule__MandatoryModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__MandatoryModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1694:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1695:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1695:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1696:1: RULE_ID
            {
             before(grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__MandatoryModel__NameAssignment_24358); 
             after(grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__NameAssignment_2


    // $ANTLR start rule__LoopedModel__VisibilityAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1705:1: rule__LoopedModel__VisibilityAssignment_0_0 : ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__LoopedModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1709:1: ( ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1710:1: ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1710:1: ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1711:1: ( rule__LoopedModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1712:1: ( rule__LoopedModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1712:2: rule__LoopedModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAlternatives_0_0_0_in_rule__LoopedModel__VisibilityAssignment_0_04389);
            rule__LoopedModel__VisibilityAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__VisibilityAssignment_0_0


    // $ANTLR start rule__LoopedModel__StaticAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1721:1: rule__LoopedModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__LoopedModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1725:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1726:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1726:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1727:1: ( 'static' )
            {
             before(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1728:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1729:1: 'static'
            {
             before(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LoopedModel__StaticAssignment_0_14427); 
             after(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 

            }

             after(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__StaticAssignment_0_1


    // $ANTLR start rule__LoopedModel__SynchronizedAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1744:1: rule__LoopedModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__LoopedModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1748:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1749:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1749:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1750:1: ( 'synchronized' )
            {
             before(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1751:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1752:1: 'synchronized'
            {
             before(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__LoopedModel__SynchronizedAssignment_0_24471); 
             after(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }

             after(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__SynchronizedAssignment_0_2


    // $ANTLR start rule__LoopedModel__AbstractAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1767:1: rule__LoopedModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__LoopedModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1771:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1772:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1772:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1773:1: ( 'abstract' )
            {
             before(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1774:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1775:1: 'abstract'
            {
             before(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__LoopedModel__AbstractAssignment_0_3_04515); 
             after(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__AbstractAssignment_0_3_0


    // $ANTLR start rule__LoopedModel__FinalAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1790:1: rule__LoopedModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__LoopedModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1794:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1795:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1795:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1796:1: ( 'final' )
            {
             before(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1797:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1798:1: 'final'
            {
             before(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__LoopedModel__FinalAssignment_0_3_14559); 
             after(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }

             after(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__FinalAssignment_0_3_1


    // $ANTLR start rule__LoopedModel__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1813:1: rule__LoopedModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__LoopedModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1817:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1818:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1818:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1819:1: RULE_ID
            {
             before(grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LoopedModel__NameAssignment_24598); 
             after(grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__NameAssignment_2


    // $ANTLR start rule__GroupLoopedModel__VisibilityAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1828:1: rule__GroupLoopedModel__VisibilityAssignment_0_0 : ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__GroupLoopedModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1832:1: ( ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1833:1: ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1833:1: ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1834:1: ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1835:1: ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1835:2: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0_in_rule__GroupLoopedModel__VisibilityAssignment_0_04629);
            rule__GroupLoopedModel__VisibilityAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getGroupLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__VisibilityAssignment_0_0


    // $ANTLR start rule__GroupLoopedModel__StaticAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1844:1: rule__GroupLoopedModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__GroupLoopedModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1848:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1849:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1849:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1850:1: ( 'static' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1851:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1852:1: 'static'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__GroupLoopedModel__StaticAssignment_0_14667); 
             after(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 

            }

             after(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__StaticAssignment_0_1


    // $ANTLR start rule__GroupLoopedModel__SynchronizedAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1867:1: rule__GroupLoopedModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__GroupLoopedModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1871:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1872:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1872:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1873:1: ( 'synchronized' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1874:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1875:1: 'synchronized'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__GroupLoopedModel__SynchronizedAssignment_0_24711); 
             after(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }

             after(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__SynchronizedAssignment_0_2


    // $ANTLR start rule__GroupLoopedModel__AbstractAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1890:1: rule__GroupLoopedModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__GroupLoopedModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1894:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1895:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1895:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1896:1: ( 'abstract' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1897:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1898:1: 'abstract'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__GroupLoopedModel__AbstractAssignment_0_3_04755); 
             after(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__AbstractAssignment_0_3_0


    // $ANTLR start rule__GroupLoopedModel__FinalAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1913:1: rule__GroupLoopedModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__GroupLoopedModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1917:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1918:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1918:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1919:1: ( 'final' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1920:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1921:1: 'final'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__GroupLoopedModel__FinalAssignment_0_3_14799); 
             after(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }

             after(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__FinalAssignment_0_3_1


    // $ANTLR start rule__GroupLoopedModel__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1936:1: rule__GroupLoopedModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__GroupLoopedModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1940:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1941:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1941:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1942:1: RULE_ID
            {
             before(grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GroupLoopedModel__NameAssignment_24838); 
             after(grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__NameAssignment_2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleModel128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__0_in_ruleSimpleModel154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryModel188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__0_in_ruleMandatoryModel214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedModel248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__0_in_ruleLoopedModel274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupLoopedModel308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__0_in_ruleGroupLoopedModel334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_2__0_in_rule__Model__Alternatives406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_3__0_in_rule__Model__Alternatives424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__SimpleModel__VisibilityAlternatives_0_0_0458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__SimpleModel__VisibilityAlternatives_0_0_0478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__SimpleModel__VisibilityAlternatives_0_0_0498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__AbstractAssignment_0_3_0_in_rule__SimpleModel__Alternatives_0_3532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__FinalAssignment_0_3_1_in_rule__SimpleModel__Alternatives_0_3550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__AbstractAssignment_0_3_0_in_rule__MandatoryModel__Alternatives_0_3658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__FinalAssignment_0_3_1_in_rule__MandatoryModel__Alternatives_0_3676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__LoopedModel__VisibilityAlternatives_0_0_0710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__LoopedModel__VisibilityAlternatives_0_0_0730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LoopedModel__VisibilityAlternatives_0_0_0750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__AbstractAssignment_0_3_0_in_rule__LoopedModel__Alternatives_0_3784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__FinalAssignment_0_3_1_in_rule__LoopedModel__Alternatives_0_3802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__AbstractAssignment_0_3_0_in_rule__GroupLoopedModel__Alternatives_0_3910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__FinalAssignment_0_3_1_in_rule__GroupLoopedModel__Alternatives_0_3928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Model__Group_0__0964 = new BitSet(new long[]{0x0000000001E43800L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__0974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__FirstAssignment_0_1_in_rule__Model__Group_0__11002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__Group_1__01041 = new BitSet(new long[]{0x0000000001E03800L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__SecondAssignment_1_1_in_rule__Model__Group_1__11079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Model__Group_2__01118 = new BitSet(new long[]{0x0000000001E43800L});
        public static final BitSet FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__01128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ThrirdAssignment_2_1_in_rule__Model__Group_2__11156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Model__Group_3__01195 = new BitSet(new long[]{0x0000000001E43800L});
        public static final BitSet FOLLOW_rule__Model__Group_3__1_in_rule__Model__Group_3__01205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ForthAssignment_3_1_in_rule__Model__Group_3__11233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0_in_rule__SimpleModel__Group__01271 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__1_in_rule__SimpleModel__Group__01280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__SimpleModel__Group__11309 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__2_in_rule__SimpleModel__Group__11319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__NameAssignment_2_in_rule__SimpleModel__Group__21347 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__3_in_rule__SimpleModel__Group__21356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__SimpleModel__Group__31385 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__4_in_rule__SimpleModel__Group__31395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__SimpleModel__Group__41424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0_in_rule__MandatoryModel__Group__01469 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__1_in_rule__MandatoryModel__Group__01478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__MandatoryModel__Group__11507 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__2_in_rule__MandatoryModel__Group__11517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__NameAssignment_2_in_rule__MandatoryModel__Group__21545 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__3_in_rule__MandatoryModel__Group__21554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__MandatoryModel__Group__31583 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__4_in_rule__MandatoryModel__Group__31593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__MandatoryModel__Group__41622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0_in_rule__LoopedModel__Group__01667 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__1_in_rule__LoopedModel__Group__01676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__LoopedModel__Group__11705 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__2_in_rule__LoopedModel__Group__11715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__NameAssignment_2_in_rule__LoopedModel__Group__21743 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__3_in_rule__LoopedModel__Group__21752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__LoopedModel__Group__31781 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__4_in_rule__LoopedModel__Group__31791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LoopedModel__Group__41820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0_in_rule__GroupLoopedModel__Group__01865 = new BitSet(new long[]{0x0000000001E43800L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__1_in_rule__GroupLoopedModel__Group__01875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__GroupLoopedModel__Group__11904 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__2_in_rule__GroupLoopedModel__Group__11914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__NameAssignment_2_in_rule__GroupLoopedModel__Group__21942 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__3_in_rule__GroupLoopedModel__Group__21951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__GroupLoopedModel__Group__31980 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__4_in_rule__GroupLoopedModel__Group__31990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__GroupLoopedModel__Group__42019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_rule__SimpleModel__UnorderedGroup_02111 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_rule__SimpleModel__UnorderedGroup_02195 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_rule__SimpleModel__UnorderedGroup_02279 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__SimpleModel__Alternatives_0_3_in_rule__SimpleModel__UnorderedGroup_02363 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_rule__MandatoryModel__UnorderedGroup_02485 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_rule__MandatoryModel__UnorderedGroup_02569 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_rule__MandatoryModel__UnorderedGroup_02653 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Alternatives_0_3_in_rule__MandatoryModel__UnorderedGroup_02737 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_02871 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_02911 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_03008 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_03048 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_03145 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_03185 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_03282 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_03322 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_rule__GroupLoopedModel__UnorderedGroup_03451 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_rule__GroupLoopedModel__UnorderedGroup_03535 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_rule__GroupLoopedModel__UnorderedGroup_03619 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Alternatives_0_3_in_rule__GroupLoopedModel__UnorderedGroup_03703 = new BitSet(new long[]{0x0000000001E03802L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_rule__Model__FirstAssignment_0_13785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_rule__Model__SecondAssignment_1_13816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_rule__Model__ThrirdAssignment_2_13847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_rule__Model__ForthAssignment_3_13878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAlternatives_0_0_0_in_rule__SimpleModel__VisibilityAssignment_0_03909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__SimpleModel__StaticAssignment_0_13947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__SimpleModel__SynchronizedAssignment_0_23991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__SimpleModel__AbstractAssignment_0_3_04035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__SimpleModel__FinalAssignment_0_3_14079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleModel__NameAssignment_24118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAlternatives_0_0_0_in_rule__MandatoryModel__VisibilityAssignment_0_04149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__MandatoryModel__StaticAssignment_0_14187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__MandatoryModel__SynchronizedAssignment_0_24231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__MandatoryModel__AbstractAssignment_0_3_04275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__MandatoryModel__FinalAssignment_0_3_14319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__MandatoryModel__NameAssignment_24358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAlternatives_0_0_0_in_rule__LoopedModel__VisibilityAssignment_0_04389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LoopedModel__StaticAssignment_0_14427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LoopedModel__SynchronizedAssignment_0_24471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LoopedModel__AbstractAssignment_0_3_04515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LoopedModel__FinalAssignment_0_3_14559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LoopedModel__NameAssignment_24598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0_in_rule__GroupLoopedModel__VisibilityAssignment_0_04629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__GroupLoopedModel__StaticAssignment_0_14667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__GroupLoopedModel__SynchronizedAssignment_0_24711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__GroupLoopedModel__AbstractAssignment_0_3_04755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__GroupLoopedModel__FinalAssignment_0_3_14799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GroupLoopedModel__NameAssignment_24838 = new BitSet(new long[]{0x0000000000000002L});
    }


}
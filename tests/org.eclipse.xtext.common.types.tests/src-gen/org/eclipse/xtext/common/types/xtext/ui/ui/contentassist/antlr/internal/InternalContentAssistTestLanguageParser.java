package org.eclipse.xtext.common.types.xtext.ui.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.common.types.xtext.ui.services.ContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'default'", "'custom'", "'subtype'", "'import'", "'.*'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalContentAssistTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g"; }


     
     	private ContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ContentAssistTestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:63:1: ruleModel EOF
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:70:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:74:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:75:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:75:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:76:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:77:1: ( rule__Model__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:77:2: rule__Model__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__0_in_ruleModel94);
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


    // $ANTLR start entryRuleReferenceHolder
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:89:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:90:1: ( ruleReferenceHolder EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:91:1: ruleReferenceHolder EOF
            {
             before(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder121);
            ruleReferenceHolder();
            _fsp--;

             after(grammarAccess.getReferenceHolderRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceHolder128); 

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
    // $ANTLR end entryRuleReferenceHolder


    // $ANTLR start ruleReferenceHolder
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:98:1: ruleReferenceHolder : ( ( rule__ReferenceHolder__Alternatives ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:102:2: ( ( ( rule__ReferenceHolder__Alternatives ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:103:1: ( ( rule__ReferenceHolder__Alternatives ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:103:1: ( ( rule__ReferenceHolder__Alternatives ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:104:1: ( rule__ReferenceHolder__Alternatives )
            {
             before(grammarAccess.getReferenceHolderAccess().getAlternatives()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:105:1: ( rule__ReferenceHolder__Alternatives )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:105:2: rule__ReferenceHolder__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Alternatives_in_ruleReferenceHolder154);
            rule__ReferenceHolder__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleReferenceHolder


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:117:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:118:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:119:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport181);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport188); 

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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:126:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:130:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:131:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:131:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:132:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:133:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:133:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0_in_ruleImport214);
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


    // $ANTLR start entryRuleImportedFQN
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:145:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:146:1: ( ruleImportedFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:147:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN241);
            ruleImportedFQN();
            _fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImportedFQN248); 

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
    // $ANTLR end entryRuleImportedFQN


    // $ANTLR start ruleImportedFQN
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:154:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:158:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:159:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:159:1: ( ( rule__ImportedFQN__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:160:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:161:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:161:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN274);
            rule__ImportedFQN__Group__0();
            _fsp--;


            }

             after(grammarAccess.getImportedFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleImportedFQN


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:173:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:174:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:175:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN301);
            ruleFQN();
            _fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN308); 

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
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:182:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:186:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:187:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:187:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:188:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:189:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:189:2: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0_in_ruleFQN334);
            rule__FQN__Group__0();
            _fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleFQN


    // $ANTLR start rule__ReferenceHolder__Alternatives
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:201:1: rule__ReferenceHolder__Alternatives : ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) );
    public final void rule__ReferenceHolder__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:205:1: ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("201:1: rule__ReferenceHolder__Alternatives : ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:206:1: ( ( rule__ReferenceHolder__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:206:1: ( ( rule__ReferenceHolder__Group_0__0 ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:207:1: ( rule__ReferenceHolder__Group_0__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:208:1: ( rule__ReferenceHolder__Group_0__0 )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:208:2: rule__ReferenceHolder__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_0__0_in_rule__ReferenceHolder__Alternatives370);
                    rule__ReferenceHolder__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:212:6: ( ( rule__ReferenceHolder__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:212:6: ( ( rule__ReferenceHolder__Group_1__0 ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:213:1: ( rule__ReferenceHolder__Group_1__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:214:1: ( rule__ReferenceHolder__Group_1__0 )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:214:2: rule__ReferenceHolder__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_1__0_in_rule__ReferenceHolder__Alternatives388);
                    rule__ReferenceHolder__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:218:6: ( ( rule__ReferenceHolder__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:218:6: ( ( rule__ReferenceHolder__Group_2__0 ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:219:1: ( rule__ReferenceHolder__Group_2__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:220:1: ( rule__ReferenceHolder__Group_2__0 )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:220:2: rule__ReferenceHolder__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_2__0_in_rule__ReferenceHolder__Alternatives406);
                    rule__ReferenceHolder__Group_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_2()); 

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
    // $ANTLR end rule__ReferenceHolder__Alternatives


    // $ANTLR start rule__Model__Group__0
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:231:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:235:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:236:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0437);
            rule__Model__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0440);
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


    // $ANTLR start rule__Model__Group__0__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:243:1: rule__Model__Group__0__Impl : ( ( rule__Model__ImportsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:247:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:248:1: ( ( rule__Model__ImportsAssignment_0 )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:248:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:249:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:250:1: ( rule__Model__ImportsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:250:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl467);
            	    rule__Model__ImportsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__0__Impl


    // $ANTLR start rule__Model__Group__1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:260:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:264:1: ( rule__Model__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:265:2: rule__Model__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1498);
            rule__Model__Group__1__Impl();
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


    // $ANTLR start rule__Model__Group__1__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:271:1: rule__Model__Group__1__Impl : ( ( rule__Model__ReferenceHolderAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:275:1: ( ( ( rule__Model__ReferenceHolderAssignment_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:276:1: ( ( rule__Model__ReferenceHolderAssignment_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:276:1: ( ( rule__Model__ReferenceHolderAssignment_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:277:1: ( rule__Model__ReferenceHolderAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getReferenceHolderAssignment_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:278:1: ( rule__Model__ReferenceHolderAssignment_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:278:2: rule__Model__ReferenceHolderAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ReferenceHolderAssignment_1_in_rule__Model__Group__1__Impl525);
            rule__Model__ReferenceHolderAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getReferenceHolderAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__1__Impl


    // $ANTLR start rule__ReferenceHolder__Group_0__0
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:292:1: rule__ReferenceHolder__Group_0__0 : rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1 ;
    public final void rule__ReferenceHolder__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:296:1: ( rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:297:2: rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_0__0__Impl_in_rule__ReferenceHolder__Group_0__0559);
            rule__ReferenceHolder__Group_0__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_0__1_in_rule__ReferenceHolder__Group_0__0562);
            rule__ReferenceHolder__Group_0__1();
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
    // $ANTLR end rule__ReferenceHolder__Group_0__0


    // $ANTLR start rule__ReferenceHolder__Group_0__0__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:304:1: rule__ReferenceHolder__Group_0__0__Impl : ( 'default' ) ;
    public final void rule__ReferenceHolder__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:308:1: ( ( 'default' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:309:1: ( 'default' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:309:1: ( 'default' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:310:1: 'default'
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultKeyword_0_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__ReferenceHolder__Group_0__0__Impl590); 
             after(grammarAccess.getReferenceHolderAccess().getDefaultKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceHolder__Group_0__0__Impl


    // $ANTLR start rule__ReferenceHolder__Group_0__1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:323:1: rule__ReferenceHolder__Group_0__1 : rule__ReferenceHolder__Group_0__1__Impl ;
    public final void rule__ReferenceHolder__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:327:1: ( rule__ReferenceHolder__Group_0__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:328:2: rule__ReferenceHolder__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_0__1__Impl_in_rule__ReferenceHolder__Group_0__1621);
            rule__ReferenceHolder__Group_0__1__Impl();
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
    // $ANTLR end rule__ReferenceHolder__Group_0__1


    // $ANTLR start rule__ReferenceHolder__Group_0__1__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:334:1: rule__ReferenceHolder__Group_0__1__Impl : ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) ) ;
    public final void rule__ReferenceHolder__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:338:1: ( ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:339:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:339:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:340:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_0_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:341:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:341:2: rule__ReferenceHolder__DefaultReferenceAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__DefaultReferenceAssignment_0_1_in_rule__ReferenceHolder__Group_0__1__Impl648);
            rule__ReferenceHolder__DefaultReferenceAssignment_0_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceHolder__Group_0__1__Impl


    // $ANTLR start rule__ReferenceHolder__Group_1__0
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:355:1: rule__ReferenceHolder__Group_1__0 : rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1 ;
    public final void rule__ReferenceHolder__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:359:1: ( rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:360:2: rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_1__0__Impl_in_rule__ReferenceHolder__Group_1__0682);
            rule__ReferenceHolder__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_1__1_in_rule__ReferenceHolder__Group_1__0685);
            rule__ReferenceHolder__Group_1__1();
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
    // $ANTLR end rule__ReferenceHolder__Group_1__0


    // $ANTLR start rule__ReferenceHolder__Group_1__0__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:367:1: rule__ReferenceHolder__Group_1__0__Impl : ( 'custom' ) ;
    public final void rule__ReferenceHolder__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:371:1: ( ( 'custom' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:372:1: ( 'custom' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:372:1: ( 'custom' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:373:1: 'custom'
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__ReferenceHolder__Group_1__0__Impl713); 
             after(grammarAccess.getReferenceHolderAccess().getCustomKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceHolder__Group_1__0__Impl


    // $ANTLR start rule__ReferenceHolder__Group_1__1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:386:1: rule__ReferenceHolder__Group_1__1 : rule__ReferenceHolder__Group_1__1__Impl ;
    public final void rule__ReferenceHolder__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:390:1: ( rule__ReferenceHolder__Group_1__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:391:2: rule__ReferenceHolder__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_1__1__Impl_in_rule__ReferenceHolder__Group_1__1744);
            rule__ReferenceHolder__Group_1__1__Impl();
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
    // $ANTLR end rule__ReferenceHolder__Group_1__1


    // $ANTLR start rule__ReferenceHolder__Group_1__1__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:397:1: rule__ReferenceHolder__Group_1__1__Impl : ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) ) ;
    public final void rule__ReferenceHolder__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:401:1: ( ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:402:1: ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:402:1: ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:403:1: ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceAssignment_1_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:404:1: ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:404:2: rule__ReferenceHolder__CustomizedReferenceAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__CustomizedReferenceAssignment_1_1_in_rule__ReferenceHolder__Group_1__1__Impl771);
            rule__ReferenceHolder__CustomizedReferenceAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceHolder__Group_1__1__Impl


    // $ANTLR start rule__ReferenceHolder__Group_2__0
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:418:1: rule__ReferenceHolder__Group_2__0 : rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1 ;
    public final void rule__ReferenceHolder__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:422:1: ( rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:423:2: rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_2__0__Impl_in_rule__ReferenceHolder__Group_2__0805);
            rule__ReferenceHolder__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_2__1_in_rule__ReferenceHolder__Group_2__0808);
            rule__ReferenceHolder__Group_2__1();
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
    // $ANTLR end rule__ReferenceHolder__Group_2__0


    // $ANTLR start rule__ReferenceHolder__Group_2__0__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:430:1: rule__ReferenceHolder__Group_2__0__Impl : ( 'subtype' ) ;
    public final void rule__ReferenceHolder__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:434:1: ( ( 'subtype' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:435:1: ( 'subtype' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:435:1: ( 'subtype' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:436:1: 'subtype'
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeKeyword_2_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ReferenceHolder__Group_2__0__Impl836); 
             after(grammarAccess.getReferenceHolderAccess().getSubtypeKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceHolder__Group_2__0__Impl


    // $ANTLR start rule__ReferenceHolder__Group_2__1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:449:1: rule__ReferenceHolder__Group_2__1 : rule__ReferenceHolder__Group_2__1__Impl ;
    public final void rule__ReferenceHolder__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:453:1: ( rule__ReferenceHolder__Group_2__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:454:2: rule__ReferenceHolder__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_2__1__Impl_in_rule__ReferenceHolder__Group_2__1867);
            rule__ReferenceHolder__Group_2__1__Impl();
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
    // $ANTLR end rule__ReferenceHolder__Group_2__1


    // $ANTLR start rule__ReferenceHolder__Group_2__1__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:460:1: rule__ReferenceHolder__Group_2__1__Impl : ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) ) ;
    public final void rule__ReferenceHolder__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:464:1: ( ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:465:1: ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:465:1: ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:466:1: ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceAssignment_2_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:467:1: ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:467:2: rule__ReferenceHolder__SubtypeReferenceAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__SubtypeReferenceAssignment_2_1_in_rule__ReferenceHolder__Group_2__1__Impl894);
            rule__ReferenceHolder__SubtypeReferenceAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceHolder__Group_2__1__Impl


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:481:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:485:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:486:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0928);
            rule__Import__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0931);
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


    // $ANTLR start rule__Import__Group__0__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:493:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:497:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:498:1: ( 'import' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:498:1: ( 'import' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:499:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Import__Group__0__Impl959); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:512:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:516:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:517:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1990);
            rule__Import__Group__1__Impl();
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
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__Import__Group__1__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:523:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:527:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:528:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:528:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:529:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:530:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:530:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl1017);
            rule__Import__ImportedNamespaceAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start rule__ImportedFQN__Group__0
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:544:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:548:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:549:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__01051);
            rule__ImportedFQN__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__01054);
            rule__ImportedFQN__Group__1();
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
    // $ANTLR end rule__ImportedFQN__Group__0


    // $ANTLR start rule__ImportedFQN__Group__0__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:556:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:560:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:561:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:561:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:562:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl1081);
            ruleFQN();
            _fsp--;

             after(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ImportedFQN__Group__0__Impl


    // $ANTLR start rule__ImportedFQN__Group__1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:573:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:577:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:578:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__11110);
            rule__ImportedFQN__Group__1__Impl();
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
    // $ANTLR end rule__ImportedFQN__Group__1


    // $ANTLR start rule__ImportedFQN__Group__1__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:584:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:588:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:589:1: ( ( '.*' )? )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:589:1: ( ( '.*' )? )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:590:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:591:1: ( '.*' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:592:2: '.*'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__ImportedFQN__Group__1__Impl1139); 

                    }
                    break;

            }

             after(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ImportedFQN__Group__1__Impl


    // $ANTLR start rule__FQN__Group__0
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:607:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:611:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:612:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__01176);
            rule__FQN__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__01179);
            rule__FQN__Group__1();
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
    // $ANTLR end rule__FQN__Group__0


    // $ANTLR start rule__FQN__Group__0__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:619:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:623:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:624:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:624:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:625:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl1206); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group__0__Impl


    // $ANTLR start rule__FQN__Group__1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:636:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:640:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:641:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__11235);
            rule__FQN__Group__1__Impl();
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
    // $ANTLR end rule__FQN__Group__1


    // $ANTLR start rule__FQN__Group__1__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:647:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:651:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:652:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:652:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:653:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:654:1: ( rule__FQN__Group_1__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:654:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl1262);
            	    rule__FQN__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group__1__Impl


    // $ANTLR start rule__FQN__Group_1__0
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:668:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:672:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:673:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__01297);
            rule__FQN__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__01300);
            rule__FQN__Group_1__1();
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
    // $ANTLR end rule__FQN__Group_1__0


    // $ANTLR start rule__FQN__Group_1__0__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:680:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:684:1: ( ( '.' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:685:1: ( '.' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:685:1: ( '.' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:686:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__FQN__Group_1__0__Impl1328); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group_1__0__Impl


    // $ANTLR start rule__FQN__Group_1__1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:699:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:703:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:704:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__11359);
            rule__FQN__Group_1__1__Impl();
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
    // $ANTLR end rule__FQN__Group_1__1


    // $ANTLR start rule__FQN__Group_1__1__Impl
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:710:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:714:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:715:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:715:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:716:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl1386); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group_1__1__Impl


    // $ANTLR start rule__Model__ImportsAssignment_0
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:732:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:736:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:737:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:737:1: ( ruleImport )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:738:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_01424);
            ruleImport();
            _fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ImportsAssignment_0


    // $ANTLR start rule__Model__ReferenceHolderAssignment_1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:747:1: rule__Model__ReferenceHolderAssignment_1 : ( ruleReferenceHolder ) ;
    public final void rule__Model__ReferenceHolderAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:751:1: ( ( ruleReferenceHolder ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:752:1: ( ruleReferenceHolder )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:752:1: ( ruleReferenceHolder )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:753:1: ruleReferenceHolder
            {
             before(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_rule__Model__ReferenceHolderAssignment_11455);
            ruleReferenceHolder();
            _fsp--;

             after(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ReferenceHolderAssignment_1


    // $ANTLR start rule__ReferenceHolder__DefaultReferenceAssignment_0_1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:762:1: rule__ReferenceHolder__DefaultReferenceAssignment_0_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__DefaultReferenceAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:766:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:767:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:767:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:768:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_0_1_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:769:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:770:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_0_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__ReferenceHolder__DefaultReferenceAssignment_0_11490);
            ruleFQN();
            _fsp--;

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_0_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceHolder__DefaultReferenceAssignment_0_1


    // $ANTLR start rule__ReferenceHolder__CustomizedReferenceAssignment_1_1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:781:1: rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__CustomizedReferenceAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:785:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:786:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:786:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:787:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:788:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:789:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeFQNParserRuleCall_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__ReferenceHolder__CustomizedReferenceAssignment_1_11529);
            ruleFQN();
            _fsp--;

             after(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeFQNParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceHolder__CustomizedReferenceAssignment_1_1


    // $ANTLR start rule__ReferenceHolder__SubtypeReferenceAssignment_2_1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:800:1: rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__SubtypeReferenceAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:804:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:805:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:805:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:806:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:807:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:808:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeFQNParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__ReferenceHolder__SubtypeReferenceAssignment_2_11568);
            ruleFQN();
            _fsp--;

             after(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeFQNParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceHolder__SubtypeReferenceAssignment_2_1


    // $ANTLR start rule__Import__ImportedNamespaceAssignment_1
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:819:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:823:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:824:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:824:1: ( ruleImportedFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:825:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_11603);
            ruleImportedFQN();
            _fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0()); 

            }


            }

        }
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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceHolder128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Alternatives_in_ruleReferenceHolder154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_0__0_in_rule__ReferenceHolder__Alternatives370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_1__0_in_rule__ReferenceHolder__Alternatives388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_2__0_in_rule__ReferenceHolder__Alternatives406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0437 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl467 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ReferenceHolderAssignment_1_in_rule__Model__Group__1__Impl525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_0__0__Impl_in_rule__ReferenceHolder__Group_0__0559 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_0__1_in_rule__ReferenceHolder__Group_0__0562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__ReferenceHolder__Group_0__0__Impl590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_0__1__Impl_in_rule__ReferenceHolder__Group_0__1621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__DefaultReferenceAssignment_0_1_in_rule__ReferenceHolder__Group_0__1__Impl648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_1__0__Impl_in_rule__ReferenceHolder__Group_1__0682 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_1__1_in_rule__ReferenceHolder__Group_1__0685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__ReferenceHolder__Group_1__0__Impl713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_1__1__Impl_in_rule__ReferenceHolder__Group_1__1744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__CustomizedReferenceAssignment_1_1_in_rule__ReferenceHolder__Group_1__1__Impl771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_2__0__Impl_in_rule__ReferenceHolder__Group_2__0805 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_2__1_in_rule__ReferenceHolder__Group_2__0808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ReferenceHolder__Group_2__0__Impl836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_2__1__Impl_in_rule__ReferenceHolder__Group_2__1867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__SubtypeReferenceAssignment_2_1_in_rule__ReferenceHolder__Group_2__1__Impl894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0928 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Import__Group__0__Impl959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl1017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__01051 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__01054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl1081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__11110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__ImportedFQN__Group__1__Impl1139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__01176 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__01179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl1206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__11235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl1262 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__01297 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__01300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__FQN__Group_1__0__Impl1328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__11359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl1386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_01424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_rule__Model__ReferenceHolderAssignment_11455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__ReferenceHolder__DefaultReferenceAssignment_0_11490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__ReferenceHolder__CustomizedReferenceAssignment_1_11529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__ReferenceHolder__SubtypeReferenceAssignment_2_11568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_11603 = new BitSet(new long[]{0x0000000000000002L});
    }


}
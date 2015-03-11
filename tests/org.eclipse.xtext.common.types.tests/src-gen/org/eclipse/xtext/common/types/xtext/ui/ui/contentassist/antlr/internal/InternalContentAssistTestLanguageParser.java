package org.eclipse.xtext.common.types.xtext.ui.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'default'", "'custom'", "'subtype'", "'generate'", "'import'", "'.*'", "'$'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalContentAssistTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistTestLanguageParser.tokenNames; }
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




    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:76:1: ( rule__Model__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:76:2: rule__Model__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleReferenceHolder"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:88:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:89:1: ( ruleReferenceHolder EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:90:1: ruleReferenceHolder EOF
            {
             before(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder121);
            ruleReferenceHolder();

            state._fsp--;

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
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:97:1: ruleReferenceHolder : ( ( rule__ReferenceHolder__Alternatives ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:101:2: ( ( ( rule__ReferenceHolder__Alternatives ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:102:1: ( ( rule__ReferenceHolder__Alternatives ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:102:1: ( ( rule__ReferenceHolder__Alternatives ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:103:1: ( rule__ReferenceHolder__Alternatives )
            {
             before(grammarAccess.getReferenceHolderAccess().getAlternatives()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:104:1: ( rule__ReferenceHolder__Alternatives )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:104:2: rule__ReferenceHolder__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Alternatives_in_ruleReferenceHolder154);
            rule__ReferenceHolder__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleReferenceHolder"


    // $ANTLR start "entryRuleGenerateDirective"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:116:1: entryRuleGenerateDirective : ruleGenerateDirective EOF ;
    public final void entryRuleGenerateDirective() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:117:1: ( ruleGenerateDirective EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:118:1: ruleGenerateDirective EOF
            {
             before(grammarAccess.getGenerateDirectiveRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGenerateDirective_in_entryRuleGenerateDirective181);
            ruleGenerateDirective();

            state._fsp--;

             after(grammarAccess.getGenerateDirectiveRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGenerateDirective188); 

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
    // $ANTLR end "entryRuleGenerateDirective"


    // $ANTLR start "ruleGenerateDirective"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:125:1: ruleGenerateDirective : ( ( rule__GenerateDirective__Group__0 ) ) ;
    public final void ruleGenerateDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:129:2: ( ( ( rule__GenerateDirective__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:130:1: ( ( rule__GenerateDirective__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:130:1: ( ( rule__GenerateDirective__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:131:1: ( rule__GenerateDirective__Group__0 )
            {
             before(grammarAccess.getGenerateDirectiveAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:132:1: ( rule__GenerateDirective__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:132:2: rule__GenerateDirective__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GenerateDirective__Group__0_in_ruleGenerateDirective214);
            rule__GenerateDirective__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGenerateDirectiveAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGenerateDirective"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:144:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:145:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:146:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport241);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport248); 

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:153:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:157:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:158:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:158:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:159:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:160:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:160:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0_in_ruleImport274);
            rule__Import__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:172:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:173:1: ( ruleImportedFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:174:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN301);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImportedFQN308); 

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
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:181:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:185:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:186:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:186:1: ( ( rule__ImportedFQN__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:187:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:188:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:188:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN334);
            rule__ImportedFQN__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:200:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:201:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:202:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN361);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN368); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:209:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:213:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:214:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:214:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:215:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:216:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:216:2: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0_in_ruleFQN394);
            rule__FQN__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:228:1: entryRuleQN : ruleQN EOF ;
    public final void entryRuleQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:229:1: ( ruleQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:230:1: ruleQN EOF
            {
             before(grammarAccess.getQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQN_in_entryRuleQN421);
            ruleQN();

            state._fsp--;

             after(grammarAccess.getQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQN428); 

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
    // $ANTLR end "entryRuleQN"


    // $ANTLR start "ruleQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:237:1: ruleQN : ( ( rule__QN__Group__0 ) ) ;
    public final void ruleQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:241:2: ( ( ( rule__QN__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:242:1: ( ( rule__QN__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:242:1: ( ( rule__QN__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:243:1: ( rule__QN__Group__0 )
            {
             before(grammarAccess.getQNAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:244:1: ( rule__QN__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:244:2: rule__QN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__QN__Group__0_in_ruleQN454);
            rule__QN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQN"


    // $ANTLR start "rule__ReferenceHolder__Alternatives"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:256:1: rule__ReferenceHolder__Alternatives : ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) );
    public final void rule__ReferenceHolder__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:260:1: ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:261:1: ( ( rule__ReferenceHolder__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:261:1: ( ( rule__ReferenceHolder__Group_0__0 ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:262:1: ( rule__ReferenceHolder__Group_0__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:263:1: ( rule__ReferenceHolder__Group_0__0 )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:263:2: rule__ReferenceHolder__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_0__0_in_rule__ReferenceHolder__Alternatives490);
                    rule__ReferenceHolder__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:267:6: ( ( rule__ReferenceHolder__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:267:6: ( ( rule__ReferenceHolder__Group_1__0 ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:268:1: ( rule__ReferenceHolder__Group_1__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:269:1: ( rule__ReferenceHolder__Group_1__0 )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:269:2: rule__ReferenceHolder__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_1__0_in_rule__ReferenceHolder__Alternatives508);
                    rule__ReferenceHolder__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:273:6: ( ( rule__ReferenceHolder__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:273:6: ( ( rule__ReferenceHolder__Group_2__0 ) )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:274:1: ( rule__ReferenceHolder__Group_2__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:275:1: ( rule__ReferenceHolder__Group_2__0 )
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:275:2: rule__ReferenceHolder__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_2__0_in_rule__ReferenceHolder__Alternatives526);
                    rule__ReferenceHolder__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__ReferenceHolder__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:286:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:290:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:291:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0557);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0560);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:298:1: rule__Model__Group__0__Impl : ( ( rule__Model__ImportsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:302:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:303:1: ( ( rule__Model__ImportsAssignment_0 )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:303:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:304:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:305:1: ( rule__Model__ImportsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:305:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl587);
            	    rule__Model__ImportsAssignment_0();

            	    state._fsp--;


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
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:315:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:319:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:320:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1618);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1621);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:327:1: rule__Model__Group__1__Impl : ( ( rule__Model__GenerateDirectiveAssignment_1 )? ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:331:1: ( ( ( rule__Model__GenerateDirectiveAssignment_1 )? ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:332:1: ( ( rule__Model__GenerateDirectiveAssignment_1 )? )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:332:1: ( ( rule__Model__GenerateDirectiveAssignment_1 )? )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:333:1: ( rule__Model__GenerateDirectiveAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getGenerateDirectiveAssignment_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:334:1: ( rule__Model__GenerateDirectiveAssignment_1 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:334:2: rule__Model__GenerateDirectiveAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__GenerateDirectiveAssignment_1_in_rule__Model__Group__1__Impl648);
                    rule__Model__GenerateDirectiveAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGenerateDirectiveAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:344:1: rule__Model__Group__2 : rule__Model__Group__2__Impl ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:348:1: ( rule__Model__Group__2__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:349:2: rule__Model__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__2679);
            rule__Model__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:355:1: rule__Model__Group__2__Impl : ( ( rule__Model__ReferenceHolderAssignment_2 )? ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:359:1: ( ( ( rule__Model__ReferenceHolderAssignment_2 )? ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:360:1: ( ( rule__Model__ReferenceHolderAssignment_2 )? )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:360:1: ( ( rule__Model__ReferenceHolderAssignment_2 )? )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:361:1: ( rule__Model__ReferenceHolderAssignment_2 )?
            {
             before(grammarAccess.getModelAccess().getReferenceHolderAssignment_2()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:362:1: ( rule__Model__ReferenceHolderAssignment_2 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=11 && LA4_0<=13)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:362:2: rule__Model__ReferenceHolderAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__ReferenceHolderAssignment_2_in_rule__Model__Group__2__Impl706);
                    rule__Model__ReferenceHolderAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getReferenceHolderAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_0__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:378:1: rule__ReferenceHolder__Group_0__0 : rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1 ;
    public final void rule__ReferenceHolder__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:382:1: ( rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:383:2: rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_0__0__Impl_in_rule__ReferenceHolder__Group_0__0743);
            rule__ReferenceHolder__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_0__1_in_rule__ReferenceHolder__Group_0__0746);
            rule__ReferenceHolder__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_0__0"


    // $ANTLR start "rule__ReferenceHolder__Group_0__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:390:1: rule__ReferenceHolder__Group_0__0__Impl : ( 'default' ) ;
    public final void rule__ReferenceHolder__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:394:1: ( ( 'default' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:395:1: ( 'default' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:395:1: ( 'default' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:396:1: 'default'
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultKeyword_0_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__ReferenceHolder__Group_0__0__Impl774); 
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
    // $ANTLR end "rule__ReferenceHolder__Group_0__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_0__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:409:1: rule__ReferenceHolder__Group_0__1 : rule__ReferenceHolder__Group_0__1__Impl ;
    public final void rule__ReferenceHolder__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:413:1: ( rule__ReferenceHolder__Group_0__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:414:2: rule__ReferenceHolder__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_0__1__Impl_in_rule__ReferenceHolder__Group_0__1805);
            rule__ReferenceHolder__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_0__1"


    // $ANTLR start "rule__ReferenceHolder__Group_0__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:420:1: rule__ReferenceHolder__Group_0__1__Impl : ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) ) ;
    public final void rule__ReferenceHolder__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:424:1: ( ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:425:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:425:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:426:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_0_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:427:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:427:2: rule__ReferenceHolder__DefaultReferenceAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__DefaultReferenceAssignment_0_1_in_rule__ReferenceHolder__Group_0__1__Impl832);
            rule__ReferenceHolder__DefaultReferenceAssignment_0_1();

            state._fsp--;


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
    // $ANTLR end "rule__ReferenceHolder__Group_0__1__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_1__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:441:1: rule__ReferenceHolder__Group_1__0 : rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1 ;
    public final void rule__ReferenceHolder__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:445:1: ( rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:446:2: rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_1__0__Impl_in_rule__ReferenceHolder__Group_1__0866);
            rule__ReferenceHolder__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_1__1_in_rule__ReferenceHolder__Group_1__0869);
            rule__ReferenceHolder__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_1__0"


    // $ANTLR start "rule__ReferenceHolder__Group_1__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:453:1: rule__ReferenceHolder__Group_1__0__Impl : ( 'custom' ) ;
    public final void rule__ReferenceHolder__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:457:1: ( ( 'custom' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:458:1: ( 'custom' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:458:1: ( 'custom' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:459:1: 'custom'
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__ReferenceHolder__Group_1__0__Impl897); 
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
    // $ANTLR end "rule__ReferenceHolder__Group_1__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_1__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:472:1: rule__ReferenceHolder__Group_1__1 : rule__ReferenceHolder__Group_1__1__Impl ;
    public final void rule__ReferenceHolder__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:476:1: ( rule__ReferenceHolder__Group_1__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:477:2: rule__ReferenceHolder__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_1__1__Impl_in_rule__ReferenceHolder__Group_1__1928);
            rule__ReferenceHolder__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_1__1"


    // $ANTLR start "rule__ReferenceHolder__Group_1__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:483:1: rule__ReferenceHolder__Group_1__1__Impl : ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) ) ;
    public final void rule__ReferenceHolder__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:487:1: ( ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:488:1: ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:488:1: ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:489:1: ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceAssignment_1_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:490:1: ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:490:2: rule__ReferenceHolder__CustomizedReferenceAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__CustomizedReferenceAssignment_1_1_in_rule__ReferenceHolder__Group_1__1__Impl955);
            rule__ReferenceHolder__CustomizedReferenceAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__ReferenceHolder__Group_1__1__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_2__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:504:1: rule__ReferenceHolder__Group_2__0 : rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1 ;
    public final void rule__ReferenceHolder__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:508:1: ( rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:509:2: rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_2__0__Impl_in_rule__ReferenceHolder__Group_2__0989);
            rule__ReferenceHolder__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_2__1_in_rule__ReferenceHolder__Group_2__0992);
            rule__ReferenceHolder__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_2__0"


    // $ANTLR start "rule__ReferenceHolder__Group_2__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:516:1: rule__ReferenceHolder__Group_2__0__Impl : ( 'subtype' ) ;
    public final void rule__ReferenceHolder__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:520:1: ( ( 'subtype' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:521:1: ( 'subtype' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:521:1: ( 'subtype' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:522:1: 'subtype'
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeKeyword_2_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ReferenceHolder__Group_2__0__Impl1020); 
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
    // $ANTLR end "rule__ReferenceHolder__Group_2__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_2__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:535:1: rule__ReferenceHolder__Group_2__1 : rule__ReferenceHolder__Group_2__1__Impl ;
    public final void rule__ReferenceHolder__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:539:1: ( rule__ReferenceHolder__Group_2__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:540:2: rule__ReferenceHolder__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group_2__1__Impl_in_rule__ReferenceHolder__Group_2__11051);
            rule__ReferenceHolder__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_2__1"


    // $ANTLR start "rule__ReferenceHolder__Group_2__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:546:1: rule__ReferenceHolder__Group_2__1__Impl : ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) ) ;
    public final void rule__ReferenceHolder__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:550:1: ( ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:551:1: ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:551:1: ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:552:1: ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceAssignment_2_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:553:1: ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:553:2: rule__ReferenceHolder__SubtypeReferenceAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__SubtypeReferenceAssignment_2_1_in_rule__ReferenceHolder__Group_2__1__Impl1078);
            rule__ReferenceHolder__SubtypeReferenceAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__ReferenceHolder__Group_2__1__Impl"


    // $ANTLR start "rule__GenerateDirective__Group__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:567:1: rule__GenerateDirective__Group__0 : rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1 ;
    public final void rule__GenerateDirective__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:571:1: ( rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:572:2: rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GenerateDirective__Group__0__Impl_in_rule__GenerateDirective__Group__01112);
            rule__GenerateDirective__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GenerateDirective__Group__1_in_rule__GenerateDirective__Group__01115);
            rule__GenerateDirective__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerateDirective__Group__0"


    // $ANTLR start "rule__GenerateDirective__Group__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:579:1: rule__GenerateDirective__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GenerateDirective__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:583:1: ( ( 'generate' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:584:1: ( 'generate' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:584:1: ( 'generate' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:585:1: 'generate'
            {
             before(grammarAccess.getGenerateDirectiveAccess().getGenerateKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__GenerateDirective__Group__0__Impl1143); 
             after(grammarAccess.getGenerateDirectiveAccess().getGenerateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerateDirective__Group__0__Impl"


    // $ANTLR start "rule__GenerateDirective__Group__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:598:1: rule__GenerateDirective__Group__1 : rule__GenerateDirective__Group__1__Impl ;
    public final void rule__GenerateDirective__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:602:1: ( rule__GenerateDirective__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:603:2: rule__GenerateDirective__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GenerateDirective__Group__1__Impl_in_rule__GenerateDirective__Group__11174);
            rule__GenerateDirective__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerateDirective__Group__1"


    // $ANTLR start "rule__GenerateDirective__Group__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:609:1: rule__GenerateDirective__Group__1__Impl : ( ( rule__GenerateDirective__TypeNameAssignment_1 ) ) ;
    public final void rule__GenerateDirective__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:613:1: ( ( ( rule__GenerateDirective__TypeNameAssignment_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:614:1: ( ( rule__GenerateDirective__TypeNameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:614:1: ( ( rule__GenerateDirective__TypeNameAssignment_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:615:1: ( rule__GenerateDirective__TypeNameAssignment_1 )
            {
             before(grammarAccess.getGenerateDirectiveAccess().getTypeNameAssignment_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:616:1: ( rule__GenerateDirective__TypeNameAssignment_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:616:2: rule__GenerateDirective__TypeNameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GenerateDirective__TypeNameAssignment_1_in_rule__GenerateDirective__Group__1__Impl1201);
            rule__GenerateDirective__TypeNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGenerateDirectiveAccess().getTypeNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerateDirective__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:630:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:634:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:635:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__01235);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__01238);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:642:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:646:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:647:1: ( 'import' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:647:1: ( 'import' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:648:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Import__Group__0__Impl1266); 
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
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:661:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:665:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:666:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__11297);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:672:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:676:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:677:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:677:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:678:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:679:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:679:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl1324);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:693:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:697:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:698:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__01358);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__01361);
            rule__ImportedFQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__0"


    // $ANTLR start "rule__ImportedFQN__Group__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:705:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:709:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:710:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:710:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:711:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl1388);
            ruleFQN();

            state._fsp--;

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
    // $ANTLR end "rule__ImportedFQN__Group__0__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:722:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:726:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:727:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__11417);
            rule__ImportedFQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__1"


    // $ANTLR start "rule__ImportedFQN__Group__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:733:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:737:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:738:1: ( ( '.*' )? )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:738:1: ( ( '.*' )? )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:739:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:740:1: ( '.*' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:741:2: '.*'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__ImportedFQN__Group__1__Impl1446); 

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
    // $ANTLR end "rule__ImportedFQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:756:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:760:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:761:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__01483);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__01486);
            rule__FQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0"


    // $ANTLR start "rule__FQN__Group__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:768:1: rule__FQN__Group__0__Impl : ( ruleQN ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:772:1: ( ( ruleQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:773:1: ( ruleQN )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:773:1: ( ruleQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:774:1: ruleQN
            {
             before(grammarAccess.getFQNAccess().getQNParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQN_in_rule__FQN__Group__0__Impl1513);
            ruleQN();

            state._fsp--;

             after(grammarAccess.getFQNAccess().getQNParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:785:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:789:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:790:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__11542);
            rule__FQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1"


    // $ANTLR start "rule__FQN__Group__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:796:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:800:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:801:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:801:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:802:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:803:1: ( rule__FQN__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:803:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl1569);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "rule__FQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:817:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:821:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:822:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__01604);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__01607);
            rule__FQN__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0"


    // $ANTLR start "rule__FQN__Group_1__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:829:1: rule__FQN__Group_1__0__Impl : ( '$' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:833:1: ( ( '$' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:834:1: ( '$' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:834:1: ( '$' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:835:1: '$'
            {
             before(grammarAccess.getFQNAccess().getDollarSignKeyword_1_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__FQN__Group_1__0__Impl1635); 
             after(grammarAccess.getFQNAccess().getDollarSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:848:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:852:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:853:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__11666);
            rule__FQN__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1"


    // $ANTLR start "rule__FQN__Group_1__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:859:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:863:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:864:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:864:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:865:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl1693); 
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
    // $ANTLR end "rule__FQN__Group_1__1__Impl"


    // $ANTLR start "rule__QN__Group__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:880:1: rule__QN__Group__0 : rule__QN__Group__0__Impl rule__QN__Group__1 ;
    public final void rule__QN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:884:1: ( rule__QN__Group__0__Impl rule__QN__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:885:2: rule__QN__Group__0__Impl rule__QN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QN__Group__0__Impl_in_rule__QN__Group__01726);
            rule__QN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QN__Group__1_in_rule__QN__Group__01729);
            rule__QN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group__0"


    // $ANTLR start "rule__QN__Group__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:892:1: rule__QN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:896:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:897:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:897:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:898:1: RULE_ID
            {
             before(grammarAccess.getQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QN__Group__0__Impl1756); 
             after(grammarAccess.getQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group__0__Impl"


    // $ANTLR start "rule__QN__Group__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:909:1: rule__QN__Group__1 : rule__QN__Group__1__Impl ;
    public final void rule__QN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:913:1: ( rule__QN__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:914:2: rule__QN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QN__Group__1__Impl_in_rule__QN__Group__11785);
            rule__QN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group__1"


    // $ANTLR start "rule__QN__Group__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:920:1: rule__QN__Group__1__Impl : ( ( rule__QN__Group_1__0 )* ) ;
    public final void rule__QN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:924:1: ( ( ( rule__QN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:925:1: ( ( rule__QN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:925:1: ( ( rule__QN__Group_1__0 )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:926:1: ( rule__QN__Group_1__0 )*
            {
             before(grammarAccess.getQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:927:1: ( rule__QN__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:927:2: rule__QN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__QN__Group_1__0_in_rule__QN__Group__1__Impl1812);
            	    rule__QN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group__1__Impl"


    // $ANTLR start "rule__QN__Group_1__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:941:1: rule__QN__Group_1__0 : rule__QN__Group_1__0__Impl rule__QN__Group_1__1 ;
    public final void rule__QN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:945:1: ( rule__QN__Group_1__0__Impl rule__QN__Group_1__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:946:2: rule__QN__Group_1__0__Impl rule__QN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__QN__Group_1__0__Impl_in_rule__QN__Group_1__01847);
            rule__QN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__QN__Group_1__1_in_rule__QN__Group_1__01850);
            rule__QN__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group_1__0"


    // $ANTLR start "rule__QN__Group_1__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:953:1: rule__QN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:957:1: ( ( '.' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:958:1: ( '.' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:958:1: ( '.' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:959:1: '.'
            {
             before(grammarAccess.getQNAccess().getFullStopKeyword_1_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__QN__Group_1__0__Impl1878); 
             after(grammarAccess.getQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group_1__0__Impl"


    // $ANTLR start "rule__QN__Group_1__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:972:1: rule__QN__Group_1__1 : rule__QN__Group_1__1__Impl ;
    public final void rule__QN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:976:1: ( rule__QN__Group_1__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:977:2: rule__QN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__QN__Group_1__1__Impl_in_rule__QN__Group_1__11909);
            rule__QN__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group_1__1"


    // $ANTLR start "rule__QN__Group_1__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:983:1: rule__QN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:987:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:988:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:988:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:989:1: RULE_ID
            {
             before(grammarAccess.getQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__QN__Group_1__1__Impl1936); 
             after(grammarAccess.getQNAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ImportsAssignment_0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1005:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1009:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1010:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1010:1: ( ruleImport )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1011:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_01974);
            ruleImport();

            state._fsp--;

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
    // $ANTLR end "rule__Model__ImportsAssignment_0"


    // $ANTLR start "rule__Model__GenerateDirectiveAssignment_1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1020:1: rule__Model__GenerateDirectiveAssignment_1 : ( ruleGenerateDirective ) ;
    public final void rule__Model__GenerateDirectiveAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1024:1: ( ( ruleGenerateDirective ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1025:1: ( ruleGenerateDirective )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1025:1: ( ruleGenerateDirective )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1026:1: ruleGenerateDirective
            {
             before(grammarAccess.getModelAccess().getGenerateDirectiveGenerateDirectiveParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGenerateDirective_in_rule__Model__GenerateDirectiveAssignment_12005);
            ruleGenerateDirective();

            state._fsp--;

             after(grammarAccess.getModelAccess().getGenerateDirectiveGenerateDirectiveParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__GenerateDirectiveAssignment_1"


    // $ANTLR start "rule__Model__ReferenceHolderAssignment_2"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1035:1: rule__Model__ReferenceHolderAssignment_2 : ( ruleReferenceHolder ) ;
    public final void rule__Model__ReferenceHolderAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1039:1: ( ( ruleReferenceHolder ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1040:1: ( ruleReferenceHolder )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1040:1: ( ruleReferenceHolder )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1041:1: ruleReferenceHolder
            {
             before(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_rule__Model__ReferenceHolderAssignment_22036);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ReferenceHolderAssignment_2"


    // $ANTLR start "rule__ReferenceHolder__DefaultReferenceAssignment_0_1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1050:1: rule__ReferenceHolder__DefaultReferenceAssignment_0_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__DefaultReferenceAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1054:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1055:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1055:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1056:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_0_1_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1057:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1058:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_0_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__ReferenceHolder__DefaultReferenceAssignment_0_12071);
            ruleFQN();

            state._fsp--;

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
    // $ANTLR end "rule__ReferenceHolder__DefaultReferenceAssignment_0_1"


    // $ANTLR start "rule__ReferenceHolder__CustomizedReferenceAssignment_1_1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1069:1: rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__CustomizedReferenceAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1073:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1074:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1074:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1075:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1076:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1077:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeFQNParserRuleCall_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__ReferenceHolder__CustomizedReferenceAssignment_1_12110);
            ruleFQN();

            state._fsp--;

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
    // $ANTLR end "rule__ReferenceHolder__CustomizedReferenceAssignment_1_1"


    // $ANTLR start "rule__ReferenceHolder__SubtypeReferenceAssignment_2_1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1088:1: rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__SubtypeReferenceAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1092:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1093:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1093:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1094:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1095:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1096:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeFQNParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__ReferenceHolder__SubtypeReferenceAssignment_2_12149);
            ruleFQN();

            state._fsp--;

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
    // $ANTLR end "rule__ReferenceHolder__SubtypeReferenceAssignment_2_1"


    // $ANTLR start "rule__GenerateDirective__TypeNameAssignment_1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1107:1: rule__GenerateDirective__TypeNameAssignment_1 : ( ruleQN ) ;
    public final void rule__GenerateDirective__TypeNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1111:1: ( ( ruleQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1112:1: ( ruleQN )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1112:1: ( ruleQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1113:1: ruleQN
            {
             before(grammarAccess.getGenerateDirectiveAccess().getTypeNameQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleQN_in_rule__GenerateDirective__TypeNameAssignment_12184);
            ruleQN();

            state._fsp--;

             after(grammarAccess.getGenerateDirectiveAccess().getTypeNameQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerateDirective__TypeNameAssignment_1"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1122:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1126:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1127:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1127:1: ( ruleImportedFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalContentAssistTestLanguage.g:1128:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_12215);
            ruleImportedFQN();

            state._fsp--;

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
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceHolder128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Alternatives_in_ruleReferenceHolder154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenerateDirective_in_entryRuleGenerateDirective181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGenerateDirective188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GenerateDirective__Group__0_in_ruleGenerateDirective214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQN_in_entryRuleQN421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQN428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QN__Group__0_in_ruleQN454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_0__0_in_rule__ReferenceHolder__Alternatives490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_1__0_in_rule__ReferenceHolder__Alternatives508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_2__0_in_rule__ReferenceHolder__Alternatives526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0557 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl587 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1618 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__GenerateDirectiveAssignment_1_in_rule__Model__Group__1__Impl648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__2679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ReferenceHolderAssignment_2_in_rule__Model__Group__2__Impl706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_0__0__Impl_in_rule__ReferenceHolder__Group_0__0743 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_0__1_in_rule__ReferenceHolder__Group_0__0746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__ReferenceHolder__Group_0__0__Impl774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_0__1__Impl_in_rule__ReferenceHolder__Group_0__1805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__DefaultReferenceAssignment_0_1_in_rule__ReferenceHolder__Group_0__1__Impl832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_1__0__Impl_in_rule__ReferenceHolder__Group_1__0866 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_1__1_in_rule__ReferenceHolder__Group_1__0869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__ReferenceHolder__Group_1__0__Impl897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_1__1__Impl_in_rule__ReferenceHolder__Group_1__1928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__CustomizedReferenceAssignment_1_1_in_rule__ReferenceHolder__Group_1__1__Impl955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_2__0__Impl_in_rule__ReferenceHolder__Group_2__0989 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_2__1_in_rule__ReferenceHolder__Group_2__0992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ReferenceHolder__Group_2__0__Impl1020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group_2__1__Impl_in_rule__ReferenceHolder__Group_2__11051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__SubtypeReferenceAssignment_2_1_in_rule__ReferenceHolder__Group_2__1__Impl1078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GenerateDirective__Group__0__Impl_in_rule__GenerateDirective__Group__01112 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GenerateDirective__Group__1_in_rule__GenerateDirective__Group__01115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__GenerateDirective__Group__0__Impl1143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GenerateDirective__Group__1__Impl_in_rule__GenerateDirective__Group__11174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GenerateDirective__TypeNameAssignment_1_in_rule__GenerateDirective__Group__1__Impl1201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__01235 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__01238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Import__Group__0__Impl1266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__11297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl1324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__01358 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__01361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl1388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__11417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__ImportedFQN__Group__1__Impl1446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__01483 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__01486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQN_in_rule__FQN__Group__0__Impl1513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__11542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl1569 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__01604 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__01607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__FQN__Group_1__0__Impl1635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__11666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl1693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QN__Group__0__Impl_in_rule__QN__Group__01726 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__QN__Group__1_in_rule__QN__Group__01729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QN__Group__0__Impl1756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QN__Group__1__Impl_in_rule__QN__Group__11785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QN__Group_1__0_in_rule__QN__Group__1__Impl1812 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__QN__Group_1__0__Impl_in_rule__QN__Group_1__01847 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__QN__Group_1__1_in_rule__QN__Group_1__01850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__QN__Group_1__0__Impl1878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__QN__Group_1__1__Impl_in_rule__QN__Group_1__11909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__QN__Group_1__1__Impl1936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_01974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenerateDirective_in_rule__Model__GenerateDirectiveAssignment_12005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_rule__Model__ReferenceHolderAssignment_22036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__ReferenceHolder__DefaultReferenceAssignment_0_12071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__ReferenceHolder__CustomizedReferenceAssignment_1_12110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__ReferenceHolder__SubtypeReferenceAssignment_2_12149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQN_in_rule__GenerateDirective__TypeNameAssignment_12184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_12215 = new BitSet(new long[]{0x0000000000000002L});
    }


}
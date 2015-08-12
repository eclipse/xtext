package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug360834TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug360834TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'public'", "'protected'", "'private'", "'alternative'", "'unordered'", "'package'", "';'", "'.'", "'class'", "'{'", "'}'", "'var'", "'final'", "'abstract'", "'extern'"
    };
    public static final int RULE_ID=4;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalBug360834TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug360834TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug360834TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g"; }


     
     	private Bug360834TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug360834TestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:62:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:69:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:73:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:75:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:76:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:76:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel94);
            rule__Model__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAlternative"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:88:1: entryRuleAlternative : ruleAlternative EOF ;
    public final void entryRuleAlternative() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:89:1: ( ruleAlternative EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:90:1: ruleAlternative EOF
            {
             before(grammarAccess.getAlternativeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternative_in_entryRuleAlternative121);
            ruleAlternative();

            state._fsp--;

             after(grammarAccess.getAlternativeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternative128); 

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
    // $ANTLR end "entryRuleAlternative"


    // $ANTLR start "ruleAlternative"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:97:1: ruleAlternative : ( ( rule__Alternative__Group__0 ) ) ;
    public final void ruleAlternative() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:101:2: ( ( ( rule__Alternative__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:102:1: ( ( rule__Alternative__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:102:1: ( ( rule__Alternative__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:103:1: ( rule__Alternative__Group__0 )
            {
             before(grammarAccess.getAlternativeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:104:1: ( rule__Alternative__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:104:2: rule__Alternative__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternative__Group__0_in_ruleAlternative154);
            rule__Alternative__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlternative"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:116:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:117:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:118:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN181);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN188); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:125:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:129:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:130:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:130:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:131:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:132:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:132:2: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0_in_ruleFQN214);
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


    // $ANTLR start "entryRuleRecursiveClassDeclaration"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:144:1: entryRuleRecursiveClassDeclaration : ruleRecursiveClassDeclaration EOF ;
    public final void entryRuleRecursiveClassDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:145:1: ( ruleRecursiveClassDeclaration EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:146:1: ruleRecursiveClassDeclaration EOF
            {
             before(grammarAccess.getRecursiveClassDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursiveClassDeclaration_in_entryRuleRecursiveClassDeclaration241);
            ruleRecursiveClassDeclaration();

            state._fsp--;

             after(grammarAccess.getRecursiveClassDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursiveClassDeclaration248); 

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
    // $ANTLR end "entryRuleRecursiveClassDeclaration"


    // $ANTLR start "ruleRecursiveClassDeclaration"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:153:1: ruleRecursiveClassDeclaration : ( ( rule__RecursiveClassDeclaration__Group__0 ) ) ;
    public final void ruleRecursiveClassDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:157:2: ( ( ( rule__RecursiveClassDeclaration__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:158:1: ( ( rule__RecursiveClassDeclaration__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:158:1: ( ( rule__RecursiveClassDeclaration__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:159:1: ( rule__RecursiveClassDeclaration__Group__0 )
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:160:1: ( rule__RecursiveClassDeclaration__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:160:2: rule__RecursiveClassDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__0_in_ruleRecursiveClassDeclaration274);
            rule__RecursiveClassDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRecursiveClassDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRecursiveClassDeclaration"


    // $ANTLR start "entryRuleAlternativeClassModifiers"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:172:1: entryRuleAlternativeClassModifiers : ruleAlternativeClassModifiers EOF ;
    public final void entryRuleAlternativeClassModifiers() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:173:1: ( ruleAlternativeClassModifiers EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:174:1: ruleAlternativeClassModifiers EOF
            {
             before(grammarAccess.getAlternativeClassModifiersRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeClassModifiers_in_entryRuleAlternativeClassModifiers301);
            ruleAlternativeClassModifiers();

            state._fsp--;

             after(grammarAccess.getAlternativeClassModifiersRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeClassModifiers308); 

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
    // $ANTLR end "entryRuleAlternativeClassModifiers"


    // $ANTLR start "ruleAlternativeClassModifiers"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:181:1: ruleAlternativeClassModifiers : ( ( rule__AlternativeClassModifiers__Group__0 ) ) ;
    public final void ruleAlternativeClassModifiers() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:185:2: ( ( ( rule__AlternativeClassModifiers__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:186:1: ( ( rule__AlternativeClassModifiers__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:186:1: ( ( rule__AlternativeClassModifiers__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:187:1: ( rule__AlternativeClassModifiers__Group__0 )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:188:1: ( rule__AlternativeClassModifiers__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:188:2: rule__AlternativeClassModifiers__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeClassModifiers__Group__0_in_ruleAlternativeClassModifiers334);
            rule__AlternativeClassModifiers__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlternativeClassModifiers"


    // $ANTLR start "entryRuleUnordered"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:200:1: entryRuleUnordered : ruleUnordered EOF ;
    public final void entryRuleUnordered() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:201:1: ( ruleUnordered EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:202:1: ruleUnordered EOF
            {
             before(grammarAccess.getUnorderedRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnordered_in_entryRuleUnordered361);
            ruleUnordered();

            state._fsp--;

             after(grammarAccess.getUnorderedRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnordered368); 

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
    // $ANTLR end "entryRuleUnordered"


    // $ANTLR start "ruleUnordered"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:209:1: ruleUnordered : ( ( rule__Unordered__Group__0 ) ) ;
    public final void ruleUnordered() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:213:2: ( ( ( rule__Unordered__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:214:1: ( ( rule__Unordered__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:214:1: ( ( rule__Unordered__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:215:1: ( rule__Unordered__Group__0 )
            {
             before(grammarAccess.getUnorderedAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:216:1: ( rule__Unordered__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:216:2: rule__Unordered__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Unordered__Group__0_in_ruleUnordered394);
            rule__Unordered__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnordered"


    // $ANTLR start "entryRuleSimpleClassDeclaration"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:228:1: entryRuleSimpleClassDeclaration : ruleSimpleClassDeclaration EOF ;
    public final void entryRuleSimpleClassDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:229:1: ( ruleSimpleClassDeclaration EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:230:1: ruleSimpleClassDeclaration EOF
            {
             before(grammarAccess.getSimpleClassDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleClassDeclaration_in_entryRuleSimpleClassDeclaration421);
            ruleSimpleClassDeclaration();

            state._fsp--;

             after(grammarAccess.getSimpleClassDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleClassDeclaration428); 

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
    // $ANTLR end "entryRuleSimpleClassDeclaration"


    // $ANTLR start "ruleSimpleClassDeclaration"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:237:1: ruleSimpleClassDeclaration : ( ( rule__SimpleClassDeclaration__Group__0 ) ) ;
    public final void ruleSimpleClassDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:241:2: ( ( ( rule__SimpleClassDeclaration__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:242:1: ( ( rule__SimpleClassDeclaration__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:242:1: ( ( rule__SimpleClassDeclaration__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:243:1: ( rule__SimpleClassDeclaration__Group__0 )
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:244:1: ( rule__SimpleClassDeclaration__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:244:2: rule__SimpleClassDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__0_in_ruleSimpleClassDeclaration454);
            rule__SimpleClassDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleClassDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleClassDeclaration"


    // $ANTLR start "entryRuleClassMember"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:256:1: entryRuleClassMember : ruleClassMember EOF ;
    public final void entryRuleClassMember() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:257:1: ( ruleClassMember EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:258:1: ruleClassMember EOF
            {
             before(grammarAccess.getClassMemberRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleClassMember_in_entryRuleClassMember481);
            ruleClassMember();

            state._fsp--;

             after(grammarAccess.getClassMemberRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleClassMember488); 

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
    // $ANTLR end "entryRuleClassMember"


    // $ANTLR start "ruleClassMember"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:265:1: ruleClassMember : ( ( rule__ClassMember__Group__0 ) ) ;
    public final void ruleClassMember() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:269:2: ( ( ( rule__ClassMember__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:270:1: ( ( rule__ClassMember__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:270:1: ( ( rule__ClassMember__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:271:1: ( rule__ClassMember__Group__0 )
            {
             before(grammarAccess.getClassMemberAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:272:1: ( rule__ClassMember__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:272:2: rule__ClassMember__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ClassMember__Group__0_in_ruleClassMember514);
            rule__ClassMember__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassMemberAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassMember"


    // $ANTLR start "entryRuleUnorderedModifiers"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:284:1: entryRuleUnorderedModifiers : ruleUnorderedModifiers EOF ;
    public final void entryRuleUnorderedModifiers() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:285:1: ( ruleUnorderedModifiers EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:286:1: ruleUnorderedModifiers EOF
            {
             before(grammarAccess.getUnorderedModifiersRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedModifiers_in_entryRuleUnorderedModifiers541);
            ruleUnorderedModifiers();

            state._fsp--;

             after(grammarAccess.getUnorderedModifiersRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedModifiers548); 

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
    // $ANTLR end "entryRuleUnorderedModifiers"


    // $ANTLR start "ruleUnorderedModifiers"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:293:1: ruleUnorderedModifiers : ( ( rule__UnorderedModifiers__Group__0 ) ) ;
    public final void ruleUnorderedModifiers() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:297:2: ( ( ( rule__UnorderedModifiers__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:298:1: ( ( rule__UnorderedModifiers__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:298:1: ( ( rule__UnorderedModifiers__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:299:1: ( rule__UnorderedModifiers__Group__0 )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:300:1: ( rule__UnorderedModifiers__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:300:2: rule__UnorderedModifiers__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__Group__0_in_ruleUnorderedModifiers574);
            rule__UnorderedModifiers__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedModifiersAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnorderedModifiers"


    // $ANTLR start "ruleVisibility"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:313:1: ruleVisibility : ( ( rule__Visibility__Alternatives ) ) ;
    public final void ruleVisibility() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:317:1: ( ( ( rule__Visibility__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:318:1: ( ( rule__Visibility__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:318:1: ( ( rule__Visibility__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:319:1: ( rule__Visibility__Alternatives )
            {
             before(grammarAccess.getVisibilityAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:320:1: ( rule__Visibility__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:320:2: rule__Visibility__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Visibility__Alternatives_in_ruleVisibility611);
            rule__Visibility__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVisibilityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVisibility"


    // $ANTLR start "rule__Model__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:331:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:335:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:336:1: ( ( rule__Model__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:336:1: ( ( rule__Model__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:337:1: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:338:1: ( rule__Model__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:338:2: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives646);
                    rule__Model__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:342:6: ( ( rule__Model__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:342:6: ( ( rule__Model__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:343:1: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:344:1: ( rule__Model__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:344:2: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives664);
                    rule__Model__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Model__Alternatives"


    // $ANTLR start "rule__AlternativeClassModifiers__Alternatives_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:353:1: rule__AlternativeClassModifiers__Alternatives_1 : ( ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) ) | ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) ) | ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) ) | ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? ) );
    public final void rule__AlternativeClassModifiers__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:357:1: ( ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) ) | ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) ) | ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) ) | ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt3=1;
                }
                break;
            case 24:
                {
                alt3=2;
                }
                break;
            case 25:
                {
                alt3=3;
                }
                break;
            case EOF:
            case 11:
            case 12:
            case 13:
            case 19:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:358:1: ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:358:1: ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:359:1: ( rule__AlternativeClassModifiers__FinalAssignment_1_0 )
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getFinalAssignment_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:360:1: ( rule__AlternativeClassModifiers__FinalAssignment_1_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:360:2: rule__AlternativeClassModifiers__FinalAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AlternativeClassModifiers__FinalAssignment_1_0_in_rule__AlternativeClassModifiers__Alternatives_1697);
                    rule__AlternativeClassModifiers__FinalAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getFinalAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:364:6: ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:364:6: ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:365:1: ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 )
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAssignment_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:366:1: ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:366:2: rule__AlternativeClassModifiers__AbstractAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AlternativeClassModifiers__AbstractAssignment_1_1_in_rule__AlternativeClassModifiers__Alternatives_1715);
                    rule__AlternativeClassModifiers__AbstractAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:370:6: ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:370:6: ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:371:1: ( rule__AlternativeClassModifiers__ExternAssignment_1_2 )
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getExternAssignment_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:372:1: ( rule__AlternativeClassModifiers__ExternAssignment_1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:372:2: rule__AlternativeClassModifiers__ExternAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AlternativeClassModifiers__ExternAssignment_1_2_in_rule__AlternativeClassModifiers__Alternatives_1733);
                    rule__AlternativeClassModifiers__ExternAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getExternAssignment_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:376:6: ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:376:6: ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:377:1: ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )?
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityAssignment_1_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:378:1: ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( ((LA2_0>=11 && LA2_0<=13)) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:378:2: rule__AlternativeClassModifiers__VisibilityAssignment_1_3
                            {
                            pushFollow(FollowSets000.FOLLOW_rule__AlternativeClassModifiers__VisibilityAssignment_1_3_in_rule__AlternativeClassModifiers__Alternatives_1751);
                            rule__AlternativeClassModifiers__VisibilityAssignment_1_3();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityAssignment_1_3()); 

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
    // $ANTLR end "rule__AlternativeClassModifiers__Alternatives_1"


    // $ANTLR start "rule__Visibility__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:387:1: rule__Visibility__Alternatives : ( ( ( 'public' ) ) | ( ( 'protected' ) ) | ( ( 'private' ) ) );
    public final void rule__Visibility__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:391:1: ( ( ( 'public' ) ) | ( ( 'protected' ) ) | ( ( 'private' ) ) )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:392:1: ( ( 'public' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:392:1: ( ( 'public' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:393:1: ( 'public' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:394:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:394:3: 'public'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Visibility__Alternatives786); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:399:6: ( ( 'protected' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:399:6: ( ( 'protected' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:400:1: ( 'protected' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:401:1: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:401:3: 'protected'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Visibility__Alternatives807); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:406:6: ( ( 'private' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:406:6: ( ( 'private' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:407:1: ( 'private' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:408:1: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:408:3: 'private'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__Visibility__Alternatives828); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__Visibility__Alternatives"


    // $ANTLR start "rule__Model__Group_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:420:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:424:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:425:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0__Impl_in_rule__Model__Group_0__0861);
            rule__Model__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__0864);
            rule__Model__Group_0__1();

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
    // $ANTLR end "rule__Model__Group_0__0"


    // $ANTLR start "rule__Model__Group_0__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:432:1: rule__Model__Group_0__0__Impl : ( 'alternative' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:436:1: ( ( 'alternative' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:437:1: ( 'alternative' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:437:1: ( 'alternative' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:438:1: 'alternative'
            {
             before(grammarAccess.getModelAccess().getAlternativeKeyword_0_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Model__Group_0__0__Impl892); 
             after(grammarAccess.getModelAccess().getAlternativeKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0__0__Impl"


    // $ANTLR start "rule__Model__Group_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:451:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:455:1: ( rule__Model__Group_0__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:456:2: rule__Model__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1__Impl_in_rule__Model__Group_0__1923);
            rule__Model__Group_0__1__Impl();

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
    // $ANTLR end "rule__Model__Group_0__1"


    // $ANTLR start "rule__Model__Group_0__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:462:1: rule__Model__Group_0__1__Impl : ( ( rule__Model__ElementAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:466:1: ( ( ( rule__Model__ElementAssignment_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:467:1: ( ( rule__Model__ElementAssignment_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:467:1: ( ( rule__Model__ElementAssignment_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:468:1: ( rule__Model__ElementAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getElementAssignment_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:469:1: ( rule__Model__ElementAssignment_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:469:2: rule__Model__ElementAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ElementAssignment_0_1_in_rule__Model__Group_0__1__Impl950);
            rule__Model__ElementAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getElementAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0__1__Impl"


    // $ANTLR start "rule__Model__Group_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:483:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:487:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:488:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__0984);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0987);
            rule__Model__Group_1__1();

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
    // $ANTLR end "rule__Model__Group_1__0"


    // $ANTLR start "rule__Model__Group_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:495:1: rule__Model__Group_1__0__Impl : ( 'unordered' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:499:1: ( ( 'unordered' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:500:1: ( 'unordered' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:500:1: ( 'unordered' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:501:1: 'unordered'
            {
             before(grammarAccess.getModelAccess().getUnorderedKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__Group_1__0__Impl1015); 
             after(grammarAccess.getModelAccess().getUnorderedKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:514:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:518:1: ( rule__Model__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:519:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__11046);
            rule__Model__Group_1__1__Impl();

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
    // $ANTLR end "rule__Model__Group_1__1"


    // $ANTLR start "rule__Model__Group_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:525:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__ElementAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:529:1: ( ( ( rule__Model__ElementAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:530:1: ( ( rule__Model__ElementAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:530:1: ( ( rule__Model__ElementAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:531:1: ( rule__Model__ElementAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getElementAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:532:1: ( rule__Model__ElementAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:532:2: rule__Model__ElementAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ElementAssignment_1_1_in_rule__Model__Group_1__1__Impl1073);
            rule__Model__ElementAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getElementAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__1__Impl"


    // $ANTLR start "rule__Alternative__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:546:1: rule__Alternative__Group__0 : rule__Alternative__Group__0__Impl rule__Alternative__Group__1 ;
    public final void rule__Alternative__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:550:1: ( rule__Alternative__Group__0__Impl rule__Alternative__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:551:2: rule__Alternative__Group__0__Impl rule__Alternative__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternative__Group__0__Impl_in_rule__Alternative__Group__01107);
            rule__Alternative__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternative__Group__1_in_rule__Alternative__Group__01110);
            rule__Alternative__Group__1();

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
    // $ANTLR end "rule__Alternative__Group__0"


    // $ANTLR start "rule__Alternative__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:558:1: rule__Alternative__Group__0__Impl : ( 'package' ) ;
    public final void rule__Alternative__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:562:1: ( ( 'package' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:563:1: ( 'package' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:563:1: ( 'package' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:564:1: 'package'
            {
             before(grammarAccess.getAlternativeAccess().getPackageKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Alternative__Group__0__Impl1138); 
             after(grammarAccess.getAlternativeAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__0__Impl"


    // $ANTLR start "rule__Alternative__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:577:1: rule__Alternative__Group__1 : rule__Alternative__Group__1__Impl rule__Alternative__Group__2 ;
    public final void rule__Alternative__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:581:1: ( rule__Alternative__Group__1__Impl rule__Alternative__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:582:2: rule__Alternative__Group__1__Impl rule__Alternative__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternative__Group__1__Impl_in_rule__Alternative__Group__11169);
            rule__Alternative__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternative__Group__2_in_rule__Alternative__Group__11172);
            rule__Alternative__Group__2();

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
    // $ANTLR end "rule__Alternative__Group__1"


    // $ANTLR start "rule__Alternative__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:589:1: rule__Alternative__Group__1__Impl : ( ( rule__Alternative__NameAssignment_1 ) ) ;
    public final void rule__Alternative__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:593:1: ( ( ( rule__Alternative__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:594:1: ( ( rule__Alternative__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:594:1: ( ( rule__Alternative__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:595:1: ( rule__Alternative__NameAssignment_1 )
            {
             before(grammarAccess.getAlternativeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:596:1: ( rule__Alternative__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:596:2: rule__Alternative__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternative__NameAssignment_1_in_rule__Alternative__Group__1__Impl1199);
            rule__Alternative__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__1__Impl"


    // $ANTLR start "rule__Alternative__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:606:1: rule__Alternative__Group__2 : rule__Alternative__Group__2__Impl rule__Alternative__Group__3 ;
    public final void rule__Alternative__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:610:1: ( rule__Alternative__Group__2__Impl rule__Alternative__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:611:2: rule__Alternative__Group__2__Impl rule__Alternative__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternative__Group__2__Impl_in_rule__Alternative__Group__21229);
            rule__Alternative__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternative__Group__3_in_rule__Alternative__Group__21232);
            rule__Alternative__Group__3();

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
    // $ANTLR end "rule__Alternative__Group__2"


    // $ANTLR start "rule__Alternative__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:618:1: rule__Alternative__Group__2__Impl : ( ';' ) ;
    public final void rule__Alternative__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:622:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:623:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:623:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:624:1: ';'
            {
             before(grammarAccess.getAlternativeAccess().getSemicolonKeyword_2()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Alternative__Group__2__Impl1260); 
             after(grammarAccess.getAlternativeAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__2__Impl"


    // $ANTLR start "rule__Alternative__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:637:1: rule__Alternative__Group__3 : rule__Alternative__Group__3__Impl ;
    public final void rule__Alternative__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:641:1: ( rule__Alternative__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:642:2: rule__Alternative__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternative__Group__3__Impl_in_rule__Alternative__Group__31291);
            rule__Alternative__Group__3__Impl();

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
    // $ANTLR end "rule__Alternative__Group__3"


    // $ANTLR start "rule__Alternative__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:648:1: rule__Alternative__Group__3__Impl : ( ( rule__Alternative__RootDeclarationAssignment_3 ) ) ;
    public final void rule__Alternative__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:652:1: ( ( ( rule__Alternative__RootDeclarationAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:653:1: ( ( rule__Alternative__RootDeclarationAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:653:1: ( ( rule__Alternative__RootDeclarationAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:654:1: ( rule__Alternative__RootDeclarationAssignment_3 )
            {
             before(grammarAccess.getAlternativeAccess().getRootDeclarationAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:655:1: ( rule__Alternative__RootDeclarationAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:655:2: rule__Alternative__RootDeclarationAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternative__RootDeclarationAssignment_3_in_rule__Alternative__Group__3__Impl1318);
            rule__Alternative__RootDeclarationAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeAccess().getRootDeclarationAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__Group__3__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:673:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:677:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:678:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__01356);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__01359);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:685:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:689:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:690:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:690:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:691:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl1386); 
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
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:702:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:706:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:707:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__11415);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:713:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:717:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:718:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:718:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:719:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:720:1: ( rule__FQN__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:720:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl1442);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:734:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:738:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:739:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__01477);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__01480);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:746:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:750:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:751:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:751:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:752:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__FQN__Group_1__0__Impl1508); 
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
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:765:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:769:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:770:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__11539);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:776:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:780:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:781:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:781:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:782:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl1566); 
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


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:797:1: rule__RecursiveClassDeclaration__Group__0 : rule__RecursiveClassDeclaration__Group__0__Impl rule__RecursiveClassDeclaration__Group__1 ;
    public final void rule__RecursiveClassDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:801:1: ( rule__RecursiveClassDeclaration__Group__0__Impl rule__RecursiveClassDeclaration__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:802:2: rule__RecursiveClassDeclaration__Group__0__Impl rule__RecursiveClassDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__0__Impl_in_rule__RecursiveClassDeclaration__Group__01599);
            rule__RecursiveClassDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__1_in_rule__RecursiveClassDeclaration__Group__01602);
            rule__RecursiveClassDeclaration__Group__1();

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
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__0"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:809:1: rule__RecursiveClassDeclaration__Group__0__Impl : ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) ) ;
    public final void rule__RecursiveClassDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:813:1: ( ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:814:1: ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:814:1: ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:815:1: ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 )
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:816:1: ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:816:2: rule__RecursiveClassDeclaration__ModifiersAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__ModifiersAssignment_0_in_rule__RecursiveClassDeclaration__Group__0__Impl1629);
            rule__RecursiveClassDeclaration__ModifiersAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__0__Impl"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:826:1: rule__RecursiveClassDeclaration__Group__1 : rule__RecursiveClassDeclaration__Group__1__Impl rule__RecursiveClassDeclaration__Group__2 ;
    public final void rule__RecursiveClassDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:830:1: ( rule__RecursiveClassDeclaration__Group__1__Impl rule__RecursiveClassDeclaration__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:831:2: rule__RecursiveClassDeclaration__Group__1__Impl rule__RecursiveClassDeclaration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__1__Impl_in_rule__RecursiveClassDeclaration__Group__11659);
            rule__RecursiveClassDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__2_in_rule__RecursiveClassDeclaration__Group__11662);
            rule__RecursiveClassDeclaration__Group__2();

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
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__1"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:838:1: rule__RecursiveClassDeclaration__Group__1__Impl : ( 'class' ) ;
    public final void rule__RecursiveClassDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:842:1: ( ( 'class' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:843:1: ( 'class' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:843:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:844:1: 'class'
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getClassKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__RecursiveClassDeclaration__Group__1__Impl1690); 
             after(grammarAccess.getRecursiveClassDeclarationAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__1__Impl"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:857:1: rule__RecursiveClassDeclaration__Group__2 : rule__RecursiveClassDeclaration__Group__2__Impl rule__RecursiveClassDeclaration__Group__3 ;
    public final void rule__RecursiveClassDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:861:1: ( rule__RecursiveClassDeclaration__Group__2__Impl rule__RecursiveClassDeclaration__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:862:2: rule__RecursiveClassDeclaration__Group__2__Impl rule__RecursiveClassDeclaration__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__2__Impl_in_rule__RecursiveClassDeclaration__Group__21721);
            rule__RecursiveClassDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__3_in_rule__RecursiveClassDeclaration__Group__21724);
            rule__RecursiveClassDeclaration__Group__3();

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
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__2"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:869:1: rule__RecursiveClassDeclaration__Group__2__Impl : ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) ) ;
    public final void rule__RecursiveClassDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:873:1: ( ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:874:1: ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:874:1: ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:875:1: ( rule__RecursiveClassDeclaration__NameAssignment_2 )
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:876:1: ( rule__RecursiveClassDeclaration__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:876:2: rule__RecursiveClassDeclaration__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__NameAssignment_2_in_rule__RecursiveClassDeclaration__Group__2__Impl1751);
            rule__RecursiveClassDeclaration__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRecursiveClassDeclarationAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__2__Impl"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:886:1: rule__RecursiveClassDeclaration__Group__3 : rule__RecursiveClassDeclaration__Group__3__Impl rule__RecursiveClassDeclaration__Group__4 ;
    public final void rule__RecursiveClassDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:890:1: ( rule__RecursiveClassDeclaration__Group__3__Impl rule__RecursiveClassDeclaration__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:891:2: rule__RecursiveClassDeclaration__Group__3__Impl rule__RecursiveClassDeclaration__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__3__Impl_in_rule__RecursiveClassDeclaration__Group__31781);
            rule__RecursiveClassDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__4_in_rule__RecursiveClassDeclaration__Group__31784);
            rule__RecursiveClassDeclaration__Group__4();

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
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__3"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:898:1: rule__RecursiveClassDeclaration__Group__3__Impl : ( '{' ) ;
    public final void rule__RecursiveClassDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:902:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:903:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:903:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:904:1: '{'
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__RecursiveClassDeclaration__Group__3__Impl1812); 
             after(grammarAccess.getRecursiveClassDeclarationAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__3__Impl"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:917:1: rule__RecursiveClassDeclaration__Group__4 : rule__RecursiveClassDeclaration__Group__4__Impl rule__RecursiveClassDeclaration__Group__5 ;
    public final void rule__RecursiveClassDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:921:1: ( rule__RecursiveClassDeclaration__Group__4__Impl rule__RecursiveClassDeclaration__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:922:2: rule__RecursiveClassDeclaration__Group__4__Impl rule__RecursiveClassDeclaration__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__4__Impl_in_rule__RecursiveClassDeclaration__Group__41843);
            rule__RecursiveClassDeclaration__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__5_in_rule__RecursiveClassDeclaration__Group__41846);
            rule__RecursiveClassDeclaration__Group__5();

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
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__4"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:929:1: rule__RecursiveClassDeclaration__Group__4__Impl : ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* ) ;
    public final void rule__RecursiveClassDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:933:1: ( ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:934:1: ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:934:1: ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:935:1: ( rule__RecursiveClassDeclaration__MembersAssignment_4 )*
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getMembersAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:936:1: ( rule__RecursiveClassDeclaration__MembersAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==EOF||(LA6_0>=11 && LA6_0<=13)||LA6_0==19||(LA6_0>=23 && LA6_0<=25)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:936:2: rule__RecursiveClassDeclaration__MembersAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__MembersAssignment_4_in_rule__RecursiveClassDeclaration__Group__4__Impl1873);
            	    rule__RecursiveClassDeclaration__MembersAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRecursiveClassDeclarationAccess().getMembersAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__4__Impl"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:946:1: rule__RecursiveClassDeclaration__Group__5 : rule__RecursiveClassDeclaration__Group__5__Impl ;
    public final void rule__RecursiveClassDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:950:1: ( rule__RecursiveClassDeclaration__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:951:2: rule__RecursiveClassDeclaration__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecursiveClassDeclaration__Group__5__Impl_in_rule__RecursiveClassDeclaration__Group__51904);
            rule__RecursiveClassDeclaration__Group__5__Impl();

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
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__5"


    // $ANTLR start "rule__RecursiveClassDeclaration__Group__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:957:1: rule__RecursiveClassDeclaration__Group__5__Impl : ( '}' ) ;
    public final void rule__RecursiveClassDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:961:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:962:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:962:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:963:1: '}'
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__RecursiveClassDeclaration__Group__5__Impl1932); 
             after(grammarAccess.getRecursiveClassDeclarationAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__Group__5__Impl"


    // $ANTLR start "rule__AlternativeClassModifiers__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:988:1: rule__AlternativeClassModifiers__Group__0 : rule__AlternativeClassModifiers__Group__0__Impl rule__AlternativeClassModifiers__Group__1 ;
    public final void rule__AlternativeClassModifiers__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:992:1: ( rule__AlternativeClassModifiers__Group__0__Impl rule__AlternativeClassModifiers__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:993:2: rule__AlternativeClassModifiers__Group__0__Impl rule__AlternativeClassModifiers__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeClassModifiers__Group__0__Impl_in_rule__AlternativeClassModifiers__Group__01975);
            rule__AlternativeClassModifiers__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AlternativeClassModifiers__Group__1_in_rule__AlternativeClassModifiers__Group__01978);
            rule__AlternativeClassModifiers__Group__1();

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
    // $ANTLR end "rule__AlternativeClassModifiers__Group__0"


    // $ANTLR start "rule__AlternativeClassModifiers__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1000:1: rule__AlternativeClassModifiers__Group__0__Impl : ( () ) ;
    public final void rule__AlternativeClassModifiers__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1004:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1005:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1005:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1006:1: ()
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getModifiersAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1007:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1009:1: 
            {
            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getModifiersAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__Group__0__Impl"


    // $ANTLR start "rule__AlternativeClassModifiers__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1019:1: rule__AlternativeClassModifiers__Group__1 : rule__AlternativeClassModifiers__Group__1__Impl ;
    public final void rule__AlternativeClassModifiers__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1023:1: ( rule__AlternativeClassModifiers__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1024:2: rule__AlternativeClassModifiers__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeClassModifiers__Group__1__Impl_in_rule__AlternativeClassModifiers__Group__12036);
            rule__AlternativeClassModifiers__Group__1__Impl();

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
    // $ANTLR end "rule__AlternativeClassModifiers__Group__1"


    // $ANTLR start "rule__AlternativeClassModifiers__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1030:1: rule__AlternativeClassModifiers__Group__1__Impl : ( ( rule__AlternativeClassModifiers__Alternatives_1 ) ) ;
    public final void rule__AlternativeClassModifiers__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1034:1: ( ( ( rule__AlternativeClassModifiers__Alternatives_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1035:1: ( ( rule__AlternativeClassModifiers__Alternatives_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1035:1: ( ( rule__AlternativeClassModifiers__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1036:1: ( rule__AlternativeClassModifiers__Alternatives_1 )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1037:1: ( rule__AlternativeClassModifiers__Alternatives_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1037:2: rule__AlternativeClassModifiers__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeClassModifiers__Alternatives_1_in_rule__AlternativeClassModifiers__Group__1__Impl2063);
            rule__AlternativeClassModifiers__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__Group__1__Impl"


    // $ANTLR start "rule__Unordered__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1051:1: rule__Unordered__Group__0 : rule__Unordered__Group__0__Impl rule__Unordered__Group__1 ;
    public final void rule__Unordered__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1055:1: ( rule__Unordered__Group__0__Impl rule__Unordered__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1056:2: rule__Unordered__Group__0__Impl rule__Unordered__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Unordered__Group__0__Impl_in_rule__Unordered__Group__02097);
            rule__Unordered__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Unordered__Group__1_in_rule__Unordered__Group__02100);
            rule__Unordered__Group__1();

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
    // $ANTLR end "rule__Unordered__Group__0"


    // $ANTLR start "rule__Unordered__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1063:1: rule__Unordered__Group__0__Impl : ( 'package' ) ;
    public final void rule__Unordered__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1067:1: ( ( 'package' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1068:1: ( 'package' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1068:1: ( 'package' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1069:1: 'package'
            {
             before(grammarAccess.getUnorderedAccess().getPackageKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Unordered__Group__0__Impl2128); 
             after(grammarAccess.getUnorderedAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__0__Impl"


    // $ANTLR start "rule__Unordered__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1082:1: rule__Unordered__Group__1 : rule__Unordered__Group__1__Impl rule__Unordered__Group__2 ;
    public final void rule__Unordered__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1086:1: ( rule__Unordered__Group__1__Impl rule__Unordered__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1087:2: rule__Unordered__Group__1__Impl rule__Unordered__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Unordered__Group__1__Impl_in_rule__Unordered__Group__12159);
            rule__Unordered__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Unordered__Group__2_in_rule__Unordered__Group__12162);
            rule__Unordered__Group__2();

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
    // $ANTLR end "rule__Unordered__Group__1"


    // $ANTLR start "rule__Unordered__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1094:1: rule__Unordered__Group__1__Impl : ( ( rule__Unordered__NameAssignment_1 ) ) ;
    public final void rule__Unordered__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1098:1: ( ( ( rule__Unordered__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1099:1: ( ( rule__Unordered__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1099:1: ( ( rule__Unordered__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1100:1: ( rule__Unordered__NameAssignment_1 )
            {
             before(grammarAccess.getUnorderedAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1101:1: ( rule__Unordered__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1101:2: rule__Unordered__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Unordered__NameAssignment_1_in_rule__Unordered__Group__1__Impl2189);
            rule__Unordered__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__1__Impl"


    // $ANTLR start "rule__Unordered__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1111:1: rule__Unordered__Group__2 : rule__Unordered__Group__2__Impl rule__Unordered__Group__3 ;
    public final void rule__Unordered__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1115:1: ( rule__Unordered__Group__2__Impl rule__Unordered__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1116:2: rule__Unordered__Group__2__Impl rule__Unordered__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Unordered__Group__2__Impl_in_rule__Unordered__Group__22219);
            rule__Unordered__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Unordered__Group__3_in_rule__Unordered__Group__22222);
            rule__Unordered__Group__3();

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
    // $ANTLR end "rule__Unordered__Group__2"


    // $ANTLR start "rule__Unordered__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1123:1: rule__Unordered__Group__2__Impl : ( ';' ) ;
    public final void rule__Unordered__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1127:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1128:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1128:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1129:1: ';'
            {
             before(grammarAccess.getUnorderedAccess().getSemicolonKeyword_2()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Unordered__Group__2__Impl2250); 
             after(grammarAccess.getUnorderedAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__2__Impl"


    // $ANTLR start "rule__Unordered__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1142:1: rule__Unordered__Group__3 : rule__Unordered__Group__3__Impl ;
    public final void rule__Unordered__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1146:1: ( rule__Unordered__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1147:2: rule__Unordered__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Unordered__Group__3__Impl_in_rule__Unordered__Group__32281);
            rule__Unordered__Group__3__Impl();

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
    // $ANTLR end "rule__Unordered__Group__3"


    // $ANTLR start "rule__Unordered__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1153:1: rule__Unordered__Group__3__Impl : ( ( rule__Unordered__RootDeclarationAssignment_3 ) ) ;
    public final void rule__Unordered__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1157:1: ( ( ( rule__Unordered__RootDeclarationAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1158:1: ( ( rule__Unordered__RootDeclarationAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1158:1: ( ( rule__Unordered__RootDeclarationAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1159:1: ( rule__Unordered__RootDeclarationAssignment_3 )
            {
             before(grammarAccess.getUnorderedAccess().getRootDeclarationAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1160:1: ( rule__Unordered__RootDeclarationAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1160:2: rule__Unordered__RootDeclarationAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Unordered__RootDeclarationAssignment_3_in_rule__Unordered__Group__3__Impl2308);
            rule__Unordered__RootDeclarationAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedAccess().getRootDeclarationAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__Group__3__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1178:1: rule__SimpleClassDeclaration__Group__0 : rule__SimpleClassDeclaration__Group__0__Impl rule__SimpleClassDeclaration__Group__1 ;
    public final void rule__SimpleClassDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1182:1: ( rule__SimpleClassDeclaration__Group__0__Impl rule__SimpleClassDeclaration__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1183:2: rule__SimpleClassDeclaration__Group__0__Impl rule__SimpleClassDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__0__Impl_in_rule__SimpleClassDeclaration__Group__02346);
            rule__SimpleClassDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__1_in_rule__SimpleClassDeclaration__Group__02349);
            rule__SimpleClassDeclaration__Group__1();

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
    // $ANTLR end "rule__SimpleClassDeclaration__Group__0"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1190:1: rule__SimpleClassDeclaration__Group__0__Impl : ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) ) ;
    public final void rule__SimpleClassDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1194:1: ( ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1195:1: ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1195:1: ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1196:1: ( rule__SimpleClassDeclaration__ModifiersAssignment_0 )
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getModifiersAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1197:1: ( rule__SimpleClassDeclaration__ModifiersAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1197:2: rule__SimpleClassDeclaration__ModifiersAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__ModifiersAssignment_0_in_rule__SimpleClassDeclaration__Group__0__Impl2376);
            rule__SimpleClassDeclaration__ModifiersAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleClassDeclarationAccess().getModifiersAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__0__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1207:1: rule__SimpleClassDeclaration__Group__1 : rule__SimpleClassDeclaration__Group__1__Impl rule__SimpleClassDeclaration__Group__2 ;
    public final void rule__SimpleClassDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1211:1: ( rule__SimpleClassDeclaration__Group__1__Impl rule__SimpleClassDeclaration__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1212:2: rule__SimpleClassDeclaration__Group__1__Impl rule__SimpleClassDeclaration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__1__Impl_in_rule__SimpleClassDeclaration__Group__12406);
            rule__SimpleClassDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__2_in_rule__SimpleClassDeclaration__Group__12409);
            rule__SimpleClassDeclaration__Group__2();

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
    // $ANTLR end "rule__SimpleClassDeclaration__Group__1"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1219:1: rule__SimpleClassDeclaration__Group__1__Impl : ( 'class' ) ;
    public final void rule__SimpleClassDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1223:1: ( ( 'class' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1224:1: ( 'class' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1224:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1225:1: 'class'
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getClassKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__SimpleClassDeclaration__Group__1__Impl2437); 
             after(grammarAccess.getSimpleClassDeclarationAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__1__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1238:1: rule__SimpleClassDeclaration__Group__2 : rule__SimpleClassDeclaration__Group__2__Impl rule__SimpleClassDeclaration__Group__3 ;
    public final void rule__SimpleClassDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1242:1: ( rule__SimpleClassDeclaration__Group__2__Impl rule__SimpleClassDeclaration__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1243:2: rule__SimpleClassDeclaration__Group__2__Impl rule__SimpleClassDeclaration__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__2__Impl_in_rule__SimpleClassDeclaration__Group__22468);
            rule__SimpleClassDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__3_in_rule__SimpleClassDeclaration__Group__22471);
            rule__SimpleClassDeclaration__Group__3();

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
    // $ANTLR end "rule__SimpleClassDeclaration__Group__2"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1250:1: rule__SimpleClassDeclaration__Group__2__Impl : ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) ) ;
    public final void rule__SimpleClassDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1254:1: ( ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1255:1: ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1255:1: ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1256:1: ( rule__SimpleClassDeclaration__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1257:1: ( rule__SimpleClassDeclaration__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1257:2: rule__SimpleClassDeclaration__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__NameAssignment_2_in_rule__SimpleClassDeclaration__Group__2__Impl2498);
            rule__SimpleClassDeclaration__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSimpleClassDeclarationAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__2__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1267:1: rule__SimpleClassDeclaration__Group__3 : rule__SimpleClassDeclaration__Group__3__Impl rule__SimpleClassDeclaration__Group__4 ;
    public final void rule__SimpleClassDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1271:1: ( rule__SimpleClassDeclaration__Group__3__Impl rule__SimpleClassDeclaration__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1272:2: rule__SimpleClassDeclaration__Group__3__Impl rule__SimpleClassDeclaration__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__3__Impl_in_rule__SimpleClassDeclaration__Group__32528);
            rule__SimpleClassDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__4_in_rule__SimpleClassDeclaration__Group__32531);
            rule__SimpleClassDeclaration__Group__4();

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
    // $ANTLR end "rule__SimpleClassDeclaration__Group__3"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1279:1: rule__SimpleClassDeclaration__Group__3__Impl : ( '{' ) ;
    public final void rule__SimpleClassDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1283:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1284:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1284:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1285:1: '{'
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__SimpleClassDeclaration__Group__3__Impl2559); 
             after(grammarAccess.getSimpleClassDeclarationAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__3__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1298:1: rule__SimpleClassDeclaration__Group__4 : rule__SimpleClassDeclaration__Group__4__Impl rule__SimpleClassDeclaration__Group__5 ;
    public final void rule__SimpleClassDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1302:1: ( rule__SimpleClassDeclaration__Group__4__Impl rule__SimpleClassDeclaration__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1303:2: rule__SimpleClassDeclaration__Group__4__Impl rule__SimpleClassDeclaration__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__4__Impl_in_rule__SimpleClassDeclaration__Group__42590);
            rule__SimpleClassDeclaration__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__5_in_rule__SimpleClassDeclaration__Group__42593);
            rule__SimpleClassDeclaration__Group__5();

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
    // $ANTLR end "rule__SimpleClassDeclaration__Group__4"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1310:1: rule__SimpleClassDeclaration__Group__4__Impl : ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* ) ;
    public final void rule__SimpleClassDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1314:1: ( ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1315:1: ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1315:1: ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1316:1: ( rule__SimpleClassDeclaration__MembersAssignment_4 )*
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getMembersAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1317:1: ( rule__SimpleClassDeclaration__MembersAssignment_4 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==EOF||(LA7_0>=11 && LA7_0<=13)||LA7_0==19||(LA7_0>=22 && LA7_0<=25)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1317:2: rule__SimpleClassDeclaration__MembersAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__MembersAssignment_4_in_rule__SimpleClassDeclaration__Group__4__Impl2620);
            	    rule__SimpleClassDeclaration__MembersAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getSimpleClassDeclarationAccess().getMembersAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__4__Impl"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1327:1: rule__SimpleClassDeclaration__Group__5 : rule__SimpleClassDeclaration__Group__5__Impl ;
    public final void rule__SimpleClassDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1331:1: ( rule__SimpleClassDeclaration__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1332:2: rule__SimpleClassDeclaration__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleClassDeclaration__Group__5__Impl_in_rule__SimpleClassDeclaration__Group__52651);
            rule__SimpleClassDeclaration__Group__5__Impl();

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
    // $ANTLR end "rule__SimpleClassDeclaration__Group__5"


    // $ANTLR start "rule__SimpleClassDeclaration__Group__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1338:1: rule__SimpleClassDeclaration__Group__5__Impl : ( '}' ) ;
    public final void rule__SimpleClassDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1342:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1343:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1343:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1344:1: '}'
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__SimpleClassDeclaration__Group__5__Impl2679); 
             after(grammarAccess.getSimpleClassDeclarationAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__Group__5__Impl"


    // $ANTLR start "rule__ClassMember__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1369:1: rule__ClassMember__Group__0 : rule__ClassMember__Group__0__Impl rule__ClassMember__Group__1 ;
    public final void rule__ClassMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1373:1: ( rule__ClassMember__Group__0__Impl rule__ClassMember__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1374:2: rule__ClassMember__Group__0__Impl rule__ClassMember__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ClassMember__Group__0__Impl_in_rule__ClassMember__Group__02722);
            rule__ClassMember__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ClassMember__Group__1_in_rule__ClassMember__Group__02725);
            rule__ClassMember__Group__1();

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
    // $ANTLR end "rule__ClassMember__Group__0"


    // $ANTLR start "rule__ClassMember__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1381:1: rule__ClassMember__Group__0__Impl : ( ( rule__ClassMember__ModifiersAssignment_0 ) ) ;
    public final void rule__ClassMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1385:1: ( ( ( rule__ClassMember__ModifiersAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1386:1: ( ( rule__ClassMember__ModifiersAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1386:1: ( ( rule__ClassMember__ModifiersAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1387:1: ( rule__ClassMember__ModifiersAssignment_0 )
            {
             before(grammarAccess.getClassMemberAccess().getModifiersAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1388:1: ( rule__ClassMember__ModifiersAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1388:2: rule__ClassMember__ModifiersAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ClassMember__ModifiersAssignment_0_in_rule__ClassMember__Group__0__Impl2752);
            rule__ClassMember__ModifiersAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getClassMemberAccess().getModifiersAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__0__Impl"


    // $ANTLR start "rule__ClassMember__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1398:1: rule__ClassMember__Group__1 : rule__ClassMember__Group__1__Impl rule__ClassMember__Group__2 ;
    public final void rule__ClassMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1402:1: ( rule__ClassMember__Group__1__Impl rule__ClassMember__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1403:2: rule__ClassMember__Group__1__Impl rule__ClassMember__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ClassMember__Group__1__Impl_in_rule__ClassMember__Group__12782);
            rule__ClassMember__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ClassMember__Group__2_in_rule__ClassMember__Group__12785);
            rule__ClassMember__Group__2();

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
    // $ANTLR end "rule__ClassMember__Group__1"


    // $ANTLR start "rule__ClassMember__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1410:1: rule__ClassMember__Group__1__Impl : ( 'var' ) ;
    public final void rule__ClassMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1414:1: ( ( 'var' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1415:1: ( 'var' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1415:1: ( 'var' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1416:1: 'var'
            {
             before(grammarAccess.getClassMemberAccess().getVarKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__ClassMember__Group__1__Impl2813); 
             after(grammarAccess.getClassMemberAccess().getVarKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__1__Impl"


    // $ANTLR start "rule__ClassMember__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1429:1: rule__ClassMember__Group__2 : rule__ClassMember__Group__2__Impl rule__ClassMember__Group__3 ;
    public final void rule__ClassMember__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1433:1: ( rule__ClassMember__Group__2__Impl rule__ClassMember__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1434:2: rule__ClassMember__Group__2__Impl rule__ClassMember__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ClassMember__Group__2__Impl_in_rule__ClassMember__Group__22844);
            rule__ClassMember__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ClassMember__Group__3_in_rule__ClassMember__Group__22847);
            rule__ClassMember__Group__3();

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
    // $ANTLR end "rule__ClassMember__Group__2"


    // $ANTLR start "rule__ClassMember__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1441:1: rule__ClassMember__Group__2__Impl : ( ( rule__ClassMember__NameAssignment_2 ) ) ;
    public final void rule__ClassMember__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1445:1: ( ( ( rule__ClassMember__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1446:1: ( ( rule__ClassMember__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1446:1: ( ( rule__ClassMember__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1447:1: ( rule__ClassMember__NameAssignment_2 )
            {
             before(grammarAccess.getClassMemberAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1448:1: ( rule__ClassMember__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1448:2: rule__ClassMember__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ClassMember__NameAssignment_2_in_rule__ClassMember__Group__2__Impl2874);
            rule__ClassMember__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getClassMemberAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__2__Impl"


    // $ANTLR start "rule__ClassMember__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1458:1: rule__ClassMember__Group__3 : rule__ClassMember__Group__3__Impl ;
    public final void rule__ClassMember__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1462:1: ( rule__ClassMember__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1463:2: rule__ClassMember__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ClassMember__Group__3__Impl_in_rule__ClassMember__Group__32904);
            rule__ClassMember__Group__3__Impl();

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
    // $ANTLR end "rule__ClassMember__Group__3"


    // $ANTLR start "rule__ClassMember__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1469:1: rule__ClassMember__Group__3__Impl : ( ';' ) ;
    public final void rule__ClassMember__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1473:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1474:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1474:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1475:1: ';'
            {
             before(grammarAccess.getClassMemberAccess().getSemicolonKeyword_3()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__ClassMember__Group__3__Impl2932); 
             after(grammarAccess.getClassMemberAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__Group__3__Impl"


    // $ANTLR start "rule__UnorderedModifiers__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1496:1: rule__UnorderedModifiers__Group__0 : rule__UnorderedModifiers__Group__0__Impl rule__UnorderedModifiers__Group__1 ;
    public final void rule__UnorderedModifiers__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1500:1: ( rule__UnorderedModifiers__Group__0__Impl rule__UnorderedModifiers__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1501:2: rule__UnorderedModifiers__Group__0__Impl rule__UnorderedModifiers__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__Group__0__Impl_in_rule__UnorderedModifiers__Group__02971);
            rule__UnorderedModifiers__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__Group__1_in_rule__UnorderedModifiers__Group__02974);
            rule__UnorderedModifiers__Group__1();

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
    // $ANTLR end "rule__UnorderedModifiers__Group__0"


    // $ANTLR start "rule__UnorderedModifiers__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1508:1: rule__UnorderedModifiers__Group__0__Impl : ( () ) ;
    public final void rule__UnorderedModifiers__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1512:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1513:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1513:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1514:1: ()
            {
             before(grammarAccess.getUnorderedModifiersAccess().getModifiersAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1515:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1517:1: 
            {
            }

             after(grammarAccess.getUnorderedModifiersAccess().getModifiersAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__Group__0__Impl"


    // $ANTLR start "rule__UnorderedModifiers__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1527:1: rule__UnorderedModifiers__Group__1 : rule__UnorderedModifiers__Group__1__Impl ;
    public final void rule__UnorderedModifiers__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1531:1: ( rule__UnorderedModifiers__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1532:2: rule__UnorderedModifiers__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__Group__1__Impl_in_rule__UnorderedModifiers__Group__13032);
            rule__UnorderedModifiers__Group__1__Impl();

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
    // $ANTLR end "rule__UnorderedModifiers__Group__1"


    // $ANTLR start "rule__UnorderedModifiers__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1538:1: rule__UnorderedModifiers__Group__1__Impl : ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) ) ;
    public final void rule__UnorderedModifiers__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1542:1: ( ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1543:1: ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1543:1: ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1544:1: ( rule__UnorderedModifiers__UnorderedGroup_1 )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1545:1: ( rule__UnorderedModifiers__UnorderedGroup_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1545:2: rule__UnorderedModifiers__UnorderedGroup_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1_in_rule__UnorderedModifiers__Group__1__Impl3059);
            rule__UnorderedModifiers__UnorderedGroup_1();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__Group__1__Impl"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1560:1: rule__UnorderedModifiers__UnorderedGroup_1 : ( rule__UnorderedModifiers__UnorderedGroup_1__0 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1565:1: ( ( rule__UnorderedModifiers__UnorderedGroup_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1566:2: ( rule__UnorderedModifiers__UnorderedGroup_1__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1566:2: ( rule__UnorderedModifiers__UnorderedGroup_1__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                alt8=1;
            }
            else if ( LA8_0 >= 11 && LA8_0 <= 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1566:2: rule__UnorderedModifiers__UnorderedGroup_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__0_in_rule__UnorderedModifiers__UnorderedGroup_13094);
                    rule__UnorderedModifiers__UnorderedGroup_1__0();

                    state._fsp--;


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

            	getUnorderedGroupHelper().leave(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1576:1: rule__UnorderedModifiers__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) ) ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1581:1: ( ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1582:3: ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1582:3: ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) )
            int alt9=4;
            int LA9_0 = input.LA(1);

            if ( LA9_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                alt9=2;
            }
            else if ( LA9_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                alt9=3;
            }
            else if ( LA9_0 >= 11 && LA9_0 <= 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                alt9=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1584:4: ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1584:4: ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1585:5: {...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1585:115: ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1586:6: ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1592:6: ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1594:7: ( rule__UnorderedModifiers__FinalAssignment_1_0 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getFinalAssignment_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1595:7: ( rule__UnorderedModifiers__FinalAssignment_1_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1595:8: rule__UnorderedModifiers__FinalAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__FinalAssignment_1_0_in_rule__UnorderedModifiers__UnorderedGroup_1__Impl3181);
                    rule__UnorderedModifiers__FinalAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnorderedModifiersAccess().getFinalAssignment_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1601:4: ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1601:4: ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1602:5: {...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1602:115: ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1603:6: ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1609:6: ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1611:7: ( rule__UnorderedModifiers__AbstractAssignment_1_1 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getAbstractAssignment_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1612:7: ( rule__UnorderedModifiers__AbstractAssignment_1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1612:8: rule__UnorderedModifiers__AbstractAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__AbstractAssignment_1_1_in_rule__UnorderedModifiers__UnorderedGroup_1__Impl3272);
                    rule__UnorderedModifiers__AbstractAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnorderedModifiersAccess().getAbstractAssignment_1_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1618:4: ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1618:4: ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1619:5: {...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1619:115: ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1620:6: ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1626:6: ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1628:7: ( rule__UnorderedModifiers__ExternAssignment_1_2 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getExternAssignment_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1629:7: ( rule__UnorderedModifiers__ExternAssignment_1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1629:8: rule__UnorderedModifiers__ExternAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__ExternAssignment_1_2_in_rule__UnorderedModifiers__UnorderedGroup_1__Impl3363);
                    rule__UnorderedModifiers__ExternAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnorderedModifiersAccess().getExternAssignment_1_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1635:4: ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1635:4: ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1636:5: {...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1636:115: ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1637:6: ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1643:6: ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1645:7: ( rule__UnorderedModifiers__VisibilityAssignment_1_3 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getVisibilityAssignment_1_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1646:7: ( rule__UnorderedModifiers__VisibilityAssignment_1_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1646:8: rule__UnorderedModifiers__VisibilityAssignment_1_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__VisibilityAssignment_1_3_in_rule__UnorderedModifiers__UnorderedGroup_1__Impl3454);
                    rule__UnorderedModifiers__VisibilityAssignment_1_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnorderedModifiersAccess().getVisibilityAssignment_1_3()); 

                    }


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

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1__Impl"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1661:1: rule__UnorderedModifiers__UnorderedGroup_1__0 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__1 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1665:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1666:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__Impl_in_rule__UnorderedModifiers__UnorderedGroup_1__03513);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1667:2: ( rule__UnorderedModifiers__UnorderedGroup_1__1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                alt10=1;
            }
            else if ( LA10_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                alt10=1;
            }
            else if ( LA10_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                alt10=1;
            }
            else if ( LA10_0 >= 11 && LA10_0 <= 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1667:2: rule__UnorderedModifiers__UnorderedGroup_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__1_in_rule__UnorderedModifiers__UnorderedGroup_1__03516);
                    rule__UnorderedModifiers__UnorderedGroup_1__1();

                    state._fsp--;


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
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1__0"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1674:1: rule__UnorderedModifiers__UnorderedGroup_1__1 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__2 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1678:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1679:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__Impl_in_rule__UnorderedModifiers__UnorderedGroup_1__13541);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1680:2: ( rule__UnorderedModifiers__UnorderedGroup_1__2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( LA11_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                alt11=1;
            }
            else if ( LA11_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                alt11=1;
            }
            else if ( LA11_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                alt11=1;
            }
            else if ( LA11_0 >= 11 && LA11_0 <= 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1680:2: rule__UnorderedModifiers__UnorderedGroup_1__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__2_in_rule__UnorderedModifiers__UnorderedGroup_1__13544);
                    rule__UnorderedModifiers__UnorderedGroup_1__2();

                    state._fsp--;


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
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1__1"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1687:1: rule__UnorderedModifiers__UnorderedGroup_1__2 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__3 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1691:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1692:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__Impl_in_rule__UnorderedModifiers__UnorderedGroup_1__23569);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1693:2: ( rule__UnorderedModifiers__UnorderedGroup_1__3 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( LA12_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                alt12=1;
            }
            else if ( LA12_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                alt12=1;
            }
            else if ( LA12_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                alt12=1;
            }
            else if ( LA12_0 >= 11 && LA12_0 <= 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1693:2: rule__UnorderedModifiers__UnorderedGroup_1__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__3_in_rule__UnorderedModifiers__UnorderedGroup_1__23572);
                    rule__UnorderedModifiers__UnorderedGroup_1__3();

                    state._fsp--;


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
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1__2"


    // $ANTLR start "rule__UnorderedModifiers__UnorderedGroup_1__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1700:1: rule__UnorderedModifiers__UnorderedGroup_1__3 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1704:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1705:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__Impl_in_rule__UnorderedModifiers__UnorderedGroup_1__33597);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

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
    // $ANTLR end "rule__UnorderedModifiers__UnorderedGroup_1__3"


    // $ANTLR start "rule__Model__ElementAssignment_0_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1720:1: rule__Model__ElementAssignment_0_1 : ( ruleAlternative ) ;
    public final void rule__Model__ElementAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1724:1: ( ( ruleAlternative ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1725:1: ( ruleAlternative )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1725:1: ( ruleAlternative )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1726:1: ruleAlternative
            {
             before(grammarAccess.getModelAccess().getElementAlternativeParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternative_in_rule__Model__ElementAssignment_0_13633);
            ruleAlternative();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementAlternativeParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementAssignment_0_1"


    // $ANTLR start "rule__Model__ElementAssignment_1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1735:1: rule__Model__ElementAssignment_1_1 : ( ruleUnordered ) ;
    public final void rule__Model__ElementAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1739:1: ( ( ruleUnordered ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1740:1: ( ruleUnordered )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1740:1: ( ruleUnordered )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1741:1: ruleUnordered
            {
             before(grammarAccess.getModelAccess().getElementUnorderedParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnordered_in_rule__Model__ElementAssignment_1_13664);
            ruleUnordered();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementUnorderedParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementAssignment_1_1"


    // $ANTLR start "rule__Alternative__NameAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1750:1: rule__Alternative__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__Alternative__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1754:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1755:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1755:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1756:1: ruleFQN
            {
             before(grammarAccess.getAlternativeAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__Alternative__NameAssignment_13695);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getAlternativeAccess().getNameFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__NameAssignment_1"


    // $ANTLR start "rule__Alternative__RootDeclarationAssignment_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1765:1: rule__Alternative__RootDeclarationAssignment_3 : ( ruleRecursiveClassDeclaration ) ;
    public final void rule__Alternative__RootDeclarationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1769:1: ( ( ruleRecursiveClassDeclaration ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1770:1: ( ruleRecursiveClassDeclaration )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1770:1: ( ruleRecursiveClassDeclaration )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1771:1: ruleRecursiveClassDeclaration
            {
             before(grammarAccess.getAlternativeAccess().getRootDeclarationRecursiveClassDeclarationParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursiveClassDeclaration_in_rule__Alternative__RootDeclarationAssignment_33726);
            ruleRecursiveClassDeclaration();

            state._fsp--;

             after(grammarAccess.getAlternativeAccess().getRootDeclarationRecursiveClassDeclarationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternative__RootDeclarationAssignment_3"


    // $ANTLR start "rule__RecursiveClassDeclaration__ModifiersAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1780:1: rule__RecursiveClassDeclaration__ModifiersAssignment_0 : ( ruleAlternativeClassModifiers ) ;
    public final void rule__RecursiveClassDeclaration__ModifiersAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1784:1: ( ( ruleAlternativeClassModifiers ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1785:1: ( ruleAlternativeClassModifiers )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1785:1: ( ruleAlternativeClassModifiers )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1786:1: ruleAlternativeClassModifiers
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAlternativeClassModifiersParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeClassModifiers_in_rule__RecursiveClassDeclaration__ModifiersAssignment_03757);
            ruleAlternativeClassModifiers();

            state._fsp--;

             after(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAlternativeClassModifiersParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__ModifiersAssignment_0"


    // $ANTLR start "rule__RecursiveClassDeclaration__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1795:1: rule__RecursiveClassDeclaration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__RecursiveClassDeclaration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1799:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1800:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1800:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1801:1: RULE_ID
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__RecursiveClassDeclaration__NameAssignment_23788); 
             after(grammarAccess.getRecursiveClassDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__NameAssignment_2"


    // $ANTLR start "rule__RecursiveClassDeclaration__MembersAssignment_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1810:1: rule__RecursiveClassDeclaration__MembersAssignment_4 : ( ruleRecursiveClassDeclaration ) ;
    public final void rule__RecursiveClassDeclaration__MembersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1814:1: ( ( ruleRecursiveClassDeclaration ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1815:1: ( ruleRecursiveClassDeclaration )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1815:1: ( ruleRecursiveClassDeclaration )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1816:1: ruleRecursiveClassDeclaration
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getMembersRecursiveClassDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursiveClassDeclaration_in_rule__RecursiveClassDeclaration__MembersAssignment_43819);
            ruleRecursiveClassDeclaration();

            state._fsp--;

             after(grammarAccess.getRecursiveClassDeclarationAccess().getMembersRecursiveClassDeclarationParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecursiveClassDeclaration__MembersAssignment_4"


    // $ANTLR start "rule__AlternativeClassModifiers__FinalAssignment_1_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1825:1: rule__AlternativeClassModifiers__FinalAssignment_1_0 : ( ( 'final' ) ) ;
    public final void rule__AlternativeClassModifiers__FinalAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1829:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1830:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1830:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1831:1: ( 'final' )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1832:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1833:1: 'final'
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__AlternativeClassModifiers__FinalAssignment_1_03855); 
             after(grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0()); 

            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__FinalAssignment_1_0"


    // $ANTLR start "rule__AlternativeClassModifiers__AbstractAssignment_1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1848:1: rule__AlternativeClassModifiers__AbstractAssignment_1_1 : ( ( 'abstract' ) ) ;
    public final void rule__AlternativeClassModifiers__AbstractAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1852:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1853:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1853:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1854:1: ( 'abstract' )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1855:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1856:1: 'abstract'
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__AlternativeClassModifiers__AbstractAssignment_1_13899); 
             after(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 

            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__AbstractAssignment_1_1"


    // $ANTLR start "rule__AlternativeClassModifiers__ExternAssignment_1_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1871:1: rule__AlternativeClassModifiers__ExternAssignment_1_2 : ( ( 'extern' ) ) ;
    public final void rule__AlternativeClassModifiers__ExternAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1875:1: ( ( ( 'extern' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1876:1: ( ( 'extern' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1876:1: ( ( 'extern' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1877:1: ( 'extern' )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1878:1: ( 'extern' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1879:1: 'extern'
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__AlternativeClassModifiers__ExternAssignment_1_23943); 
             after(grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0()); 

            }

             after(grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__ExternAssignment_1_2"


    // $ANTLR start "rule__AlternativeClassModifiers__VisibilityAssignment_1_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1894:1: rule__AlternativeClassModifiers__VisibilityAssignment_1_3 : ( ruleVisibility ) ;
    public final void rule__AlternativeClassModifiers__VisibilityAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1898:1: ( ( ruleVisibility ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1899:1: ( ruleVisibility )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1899:1: ( ruleVisibility )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1900:1: ruleVisibility
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleVisibility_in_rule__AlternativeClassModifiers__VisibilityAssignment_1_33982);
            ruleVisibility();

            state._fsp--;

             after(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeClassModifiers__VisibilityAssignment_1_3"


    // $ANTLR start "rule__Unordered__NameAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1909:1: rule__Unordered__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__Unordered__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1913:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1914:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1914:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1915:1: ruleFQN
            {
             before(grammarAccess.getUnorderedAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__Unordered__NameAssignment_14013);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getUnorderedAccess().getNameFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__NameAssignment_1"


    // $ANTLR start "rule__Unordered__RootDeclarationAssignment_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1924:1: rule__Unordered__RootDeclarationAssignment_3 : ( ruleSimpleClassDeclaration ) ;
    public final void rule__Unordered__RootDeclarationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1928:1: ( ( ruleSimpleClassDeclaration ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1929:1: ( ruleSimpleClassDeclaration )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1929:1: ( ruleSimpleClassDeclaration )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1930:1: ruleSimpleClassDeclaration
            {
             before(grammarAccess.getUnorderedAccess().getRootDeclarationSimpleClassDeclarationParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleClassDeclaration_in_rule__Unordered__RootDeclarationAssignment_34044);
            ruleSimpleClassDeclaration();

            state._fsp--;

             after(grammarAccess.getUnorderedAccess().getRootDeclarationSimpleClassDeclarationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unordered__RootDeclarationAssignment_3"


    // $ANTLR start "rule__SimpleClassDeclaration__ModifiersAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1939:1: rule__SimpleClassDeclaration__ModifiersAssignment_0 : ( ruleUnorderedModifiers ) ;
    public final void rule__SimpleClassDeclaration__ModifiersAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1943:1: ( ( ruleUnorderedModifiers ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1944:1: ( ruleUnorderedModifiers )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1944:1: ( ruleUnorderedModifiers )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1945:1: ruleUnorderedModifiers
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getModifiersUnorderedModifiersParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedModifiers_in_rule__SimpleClassDeclaration__ModifiersAssignment_04075);
            ruleUnorderedModifiers();

            state._fsp--;

             after(grammarAccess.getSimpleClassDeclarationAccess().getModifiersUnorderedModifiersParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__ModifiersAssignment_0"


    // $ANTLR start "rule__SimpleClassDeclaration__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1954:1: rule__SimpleClassDeclaration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleClassDeclaration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1958:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1959:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1959:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1960:1: RULE_ID
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SimpleClassDeclaration__NameAssignment_24106); 
             after(grammarAccess.getSimpleClassDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__NameAssignment_2"


    // $ANTLR start "rule__SimpleClassDeclaration__MembersAssignment_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1969:1: rule__SimpleClassDeclaration__MembersAssignment_4 : ( ruleClassMember ) ;
    public final void rule__SimpleClassDeclaration__MembersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1973:1: ( ( ruleClassMember ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1974:1: ( ruleClassMember )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1974:1: ( ruleClassMember )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1975:1: ruleClassMember
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getMembersClassMemberParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleClassMember_in_rule__SimpleClassDeclaration__MembersAssignment_44137);
            ruleClassMember();

            state._fsp--;

             after(grammarAccess.getSimpleClassDeclarationAccess().getMembersClassMemberParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleClassDeclaration__MembersAssignment_4"


    // $ANTLR start "rule__ClassMember__ModifiersAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1984:1: rule__ClassMember__ModifiersAssignment_0 : ( ruleUnorderedModifiers ) ;
    public final void rule__ClassMember__ModifiersAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1988:1: ( ( ruleUnorderedModifiers ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1989:1: ( ruleUnorderedModifiers )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1989:1: ( ruleUnorderedModifiers )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1990:1: ruleUnorderedModifiers
            {
             before(grammarAccess.getClassMemberAccess().getModifiersUnorderedModifiersParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedModifiers_in_rule__ClassMember__ModifiersAssignment_04168);
            ruleUnorderedModifiers();

            state._fsp--;

             after(grammarAccess.getClassMemberAccess().getModifiersUnorderedModifiersParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__ModifiersAssignment_0"


    // $ANTLR start "rule__ClassMember__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:1999:1: rule__ClassMember__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ClassMember__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2003:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2004:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2004:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2005:1: RULE_ID
            {
             before(grammarAccess.getClassMemberAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ClassMember__NameAssignment_24199); 
             after(grammarAccess.getClassMemberAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassMember__NameAssignment_2"


    // $ANTLR start "rule__UnorderedModifiers__FinalAssignment_1_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2014:1: rule__UnorderedModifiers__FinalAssignment_1_0 : ( ( 'final' ) ) ;
    public final void rule__UnorderedModifiers__FinalAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2018:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2019:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2019:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2020:1: ( 'final' )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2021:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2022:1: 'final'
            {
             before(grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__UnorderedModifiers__FinalAssignment_1_04235); 
             after(grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0()); 

            }

             after(grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__FinalAssignment_1_0"


    // $ANTLR start "rule__UnorderedModifiers__AbstractAssignment_1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2037:1: rule__UnorderedModifiers__AbstractAssignment_1_1 : ( ( 'abstract' ) ) ;
    public final void rule__UnorderedModifiers__AbstractAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2041:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2042:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2042:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2043:1: ( 'abstract' )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2044:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2045:1: 'abstract'
            {
             before(grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__UnorderedModifiers__AbstractAssignment_1_14279); 
             after(grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 

            }

             after(grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__AbstractAssignment_1_1"


    // $ANTLR start "rule__UnorderedModifiers__ExternAssignment_1_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2060:1: rule__UnorderedModifiers__ExternAssignment_1_2 : ( ( 'extern' ) ) ;
    public final void rule__UnorderedModifiers__ExternAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2064:1: ( ( ( 'extern' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2065:1: ( ( 'extern' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2065:1: ( ( 'extern' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2066:1: ( 'extern' )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2067:1: ( 'extern' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2068:1: 'extern'
            {
             before(grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__UnorderedModifiers__ExternAssignment_1_24323); 
             after(grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0()); 

            }

             after(grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__ExternAssignment_1_2"


    // $ANTLR start "rule__UnorderedModifiers__VisibilityAssignment_1_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2083:1: rule__UnorderedModifiers__VisibilityAssignment_1_3 : ( ruleVisibility ) ;
    public final void rule__UnorderedModifiers__VisibilityAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2087:1: ( ( ruleVisibility ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2088:1: ( ruleVisibility )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2088:1: ( ruleVisibility )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug360834TestLanguage.g:2089:1: ruleVisibility
            {
             before(grammarAccess.getUnorderedModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleVisibility_in_rule__UnorderedModifiers__VisibilityAssignment_1_34362);
            ruleVisibility();

            state._fsp--;

             after(grammarAccess.getUnorderedModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedModifiers__VisibilityAssignment_1_3"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternative_in_entryRuleAlternative121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternative128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternative__Group__0_in_ruleAlternative154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursiveClassDeclaration_in_entryRuleRecursiveClassDeclaration241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursiveClassDeclaration248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__0_in_ruleRecursiveClassDeclaration274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeClassModifiers_in_entryRuleAlternativeClassModifiers301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeClassModifiers308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeClassModifiers__Group__0_in_ruleAlternativeClassModifiers334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnordered_in_entryRuleUnordered361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnordered368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Unordered__Group__0_in_ruleUnordered394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleClassDeclaration_in_entryRuleSimpleClassDeclaration421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleClassDeclaration428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__0_in_ruleSimpleClassDeclaration454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleClassMember_in_entryRuleClassMember481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleClassMember488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ClassMember__Group__0_in_ruleClassMember514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedModifiers_in_entryRuleUnorderedModifiers541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedModifiers548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__Group__0_in_ruleUnorderedModifiers574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Visibility__Alternatives_in_ruleVisibility611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeClassModifiers__FinalAssignment_1_0_in_rule__AlternativeClassModifiers__Alternatives_1697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeClassModifiers__AbstractAssignment_1_1_in_rule__AlternativeClassModifiers__Alternatives_1715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeClassModifiers__ExternAssignment_1_2_in_rule__AlternativeClassModifiers__Alternatives_1733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeClassModifiers__VisibilityAssignment_1_3_in_rule__AlternativeClassModifiers__Alternatives_1751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Visibility__Alternatives786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Visibility__Alternatives807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Visibility__Alternatives828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__0__Impl_in_rule__Model__Group_0__0861 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__0864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Model__Group_0__0__Impl892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1__Impl_in_rule__Model__Group_0__1923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ElementAssignment_0_1_in_rule__Model__Group_0__1__Impl950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__0984 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__Group_1__0__Impl1015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__11046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ElementAssignment_1_1_in_rule__Model__Group_1__1__Impl1073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternative__Group__0__Impl_in_rule__Alternative__Group__01107 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Alternative__Group__1_in_rule__Alternative__Group__01110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Alternative__Group__0__Impl1138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternative__Group__1__Impl_in_rule__Alternative__Group__11169 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Alternative__Group__2_in_rule__Alternative__Group__11172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternative__NameAssignment_1_in_rule__Alternative__Group__1__Impl1199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternative__Group__2__Impl_in_rule__Alternative__Group__21229 = new BitSet(new long[]{0x0000000003803800L});
        public static final BitSet FOLLOW_rule__Alternative__Group__3_in_rule__Alternative__Group__21232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Alternative__Group__2__Impl1260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternative__Group__3__Impl_in_rule__Alternative__Group__31291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternative__RootDeclarationAssignment_3_in_rule__Alternative__Group__3__Impl1318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__01356 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__01359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl1386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__11415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl1442 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__01477 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__01480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__FQN__Group_1__0__Impl1508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__11539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl1566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__0__Impl_in_rule__RecursiveClassDeclaration__Group__01599 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__1_in_rule__RecursiveClassDeclaration__Group__01602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__ModifiersAssignment_0_in_rule__RecursiveClassDeclaration__Group__0__Impl1629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__1__Impl_in_rule__RecursiveClassDeclaration__Group__11659 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__2_in_rule__RecursiveClassDeclaration__Group__11662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__RecursiveClassDeclaration__Group__1__Impl1690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__2__Impl_in_rule__RecursiveClassDeclaration__Group__21721 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__3_in_rule__RecursiveClassDeclaration__Group__21724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__NameAssignment_2_in_rule__RecursiveClassDeclaration__Group__2__Impl1751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__3__Impl_in_rule__RecursiveClassDeclaration__Group__31781 = new BitSet(new long[]{0x0000000003A03800L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__4_in_rule__RecursiveClassDeclaration__Group__31784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__RecursiveClassDeclaration__Group__3__Impl1812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__4__Impl_in_rule__RecursiveClassDeclaration__Group__41843 = new BitSet(new long[]{0x0000000003A03800L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__5_in_rule__RecursiveClassDeclaration__Group__41846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__MembersAssignment_4_in_rule__RecursiveClassDeclaration__Group__4__Impl1873 = new BitSet(new long[]{0x0000000003803802L});
        public static final BitSet FOLLOW_rule__RecursiveClassDeclaration__Group__5__Impl_in_rule__RecursiveClassDeclaration__Group__51904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__RecursiveClassDeclaration__Group__5__Impl1932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeClassModifiers__Group__0__Impl_in_rule__AlternativeClassModifiers__Group__01975 = new BitSet(new long[]{0x0000000003803800L});
        public static final BitSet FOLLOW_rule__AlternativeClassModifiers__Group__1_in_rule__AlternativeClassModifiers__Group__01978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeClassModifiers__Group__1__Impl_in_rule__AlternativeClassModifiers__Group__12036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeClassModifiers__Alternatives_1_in_rule__AlternativeClassModifiers__Group__1__Impl2063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Unordered__Group__0__Impl_in_rule__Unordered__Group__02097 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Unordered__Group__1_in_rule__Unordered__Group__02100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Unordered__Group__0__Impl2128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Unordered__Group__1__Impl_in_rule__Unordered__Group__12159 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Unordered__Group__2_in_rule__Unordered__Group__12162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Unordered__NameAssignment_1_in_rule__Unordered__Group__1__Impl2189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Unordered__Group__2__Impl_in_rule__Unordered__Group__22219 = new BitSet(new long[]{0x0000000003803800L});
        public static final BitSet FOLLOW_rule__Unordered__Group__3_in_rule__Unordered__Group__22222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Unordered__Group__2__Impl2250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Unordered__Group__3__Impl_in_rule__Unordered__Group__32281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Unordered__RootDeclarationAssignment_3_in_rule__Unordered__Group__3__Impl2308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__0__Impl_in_rule__SimpleClassDeclaration__Group__02346 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__1_in_rule__SimpleClassDeclaration__Group__02349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__ModifiersAssignment_0_in_rule__SimpleClassDeclaration__Group__0__Impl2376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__1__Impl_in_rule__SimpleClassDeclaration__Group__12406 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__2_in_rule__SimpleClassDeclaration__Group__12409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__SimpleClassDeclaration__Group__1__Impl2437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__2__Impl_in_rule__SimpleClassDeclaration__Group__22468 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__3_in_rule__SimpleClassDeclaration__Group__22471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__NameAssignment_2_in_rule__SimpleClassDeclaration__Group__2__Impl2498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__3__Impl_in_rule__SimpleClassDeclaration__Group__32528 = new BitSet(new long[]{0x0000000003A03800L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__4_in_rule__SimpleClassDeclaration__Group__32531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__SimpleClassDeclaration__Group__3__Impl2559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__4__Impl_in_rule__SimpleClassDeclaration__Group__42590 = new BitSet(new long[]{0x0000000003A03800L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__5_in_rule__SimpleClassDeclaration__Group__42593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__MembersAssignment_4_in_rule__SimpleClassDeclaration__Group__4__Impl2620 = new BitSet(new long[]{0x0000000003803802L});
        public static final BitSet FOLLOW_rule__SimpleClassDeclaration__Group__5__Impl_in_rule__SimpleClassDeclaration__Group__52651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__SimpleClassDeclaration__Group__5__Impl2679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ClassMember__Group__0__Impl_in_rule__ClassMember__Group__02722 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__ClassMember__Group__1_in_rule__ClassMember__Group__02725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ClassMember__ModifiersAssignment_0_in_rule__ClassMember__Group__0__Impl2752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ClassMember__Group__1__Impl_in_rule__ClassMember__Group__12782 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ClassMember__Group__2_in_rule__ClassMember__Group__12785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__ClassMember__Group__1__Impl2813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ClassMember__Group__2__Impl_in_rule__ClassMember__Group__22844 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__ClassMember__Group__3_in_rule__ClassMember__Group__22847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ClassMember__NameAssignment_2_in_rule__ClassMember__Group__2__Impl2874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ClassMember__Group__3__Impl_in_rule__ClassMember__Group__32904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__ClassMember__Group__3__Impl2932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__Group__0__Impl_in_rule__UnorderedModifiers__Group__02971 = new BitSet(new long[]{0x0000000003803800L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__Group__1_in_rule__UnorderedModifiers__Group__02974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__Group__1__Impl_in_rule__UnorderedModifiers__Group__13032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1_in_rule__UnorderedModifiers__Group__1__Impl3059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__0_in_rule__UnorderedModifiers__UnorderedGroup_13094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__FinalAssignment_1_0_in_rule__UnorderedModifiers__UnorderedGroup_1__Impl3181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__AbstractAssignment_1_1_in_rule__UnorderedModifiers__UnorderedGroup_1__Impl3272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__ExternAssignment_1_2_in_rule__UnorderedModifiers__UnorderedGroup_1__Impl3363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__VisibilityAssignment_1_3_in_rule__UnorderedModifiers__UnorderedGroup_1__Impl3454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__Impl_in_rule__UnorderedModifiers__UnorderedGroup_1__03513 = new BitSet(new long[]{0x0000000003803802L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__1_in_rule__UnorderedModifiers__UnorderedGroup_1__03516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__Impl_in_rule__UnorderedModifiers__UnorderedGroup_1__13541 = new BitSet(new long[]{0x0000000003803802L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__2_in_rule__UnorderedModifiers__UnorderedGroup_1__13544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__Impl_in_rule__UnorderedModifiers__UnorderedGroup_1__23569 = new BitSet(new long[]{0x0000000003803802L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__3_in_rule__UnorderedModifiers__UnorderedGroup_1__23572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedModifiers__UnorderedGroup_1__Impl_in_rule__UnorderedModifiers__UnorderedGroup_1__33597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternative_in_rule__Model__ElementAssignment_0_13633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnordered_in_rule__Model__ElementAssignment_1_13664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__Alternative__NameAssignment_13695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursiveClassDeclaration_in_rule__Alternative__RootDeclarationAssignment_33726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeClassModifiers_in_rule__RecursiveClassDeclaration__ModifiersAssignment_03757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__RecursiveClassDeclaration__NameAssignment_23788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursiveClassDeclaration_in_rule__RecursiveClassDeclaration__MembersAssignment_43819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__AlternativeClassModifiers__FinalAssignment_1_03855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__AlternativeClassModifiers__AbstractAssignment_1_13899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__AlternativeClassModifiers__ExternAssignment_1_23943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVisibility_in_rule__AlternativeClassModifiers__VisibilityAssignment_1_33982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__Unordered__NameAssignment_14013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleClassDeclaration_in_rule__Unordered__RootDeclarationAssignment_34044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedModifiers_in_rule__SimpleClassDeclaration__ModifiersAssignment_04075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleClassDeclaration__NameAssignment_24106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleClassMember_in_rule__SimpleClassDeclaration__MembersAssignment_44137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedModifiers_in_rule__ClassMember__ModifiersAssignment_04168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ClassMember__NameAssignment_24199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__UnorderedModifiers__FinalAssignment_1_04235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__UnorderedModifiers__AbstractAssignment_1_14279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__UnorderedModifiers__ExternAssignment_1_24323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVisibility_in_rule__UnorderedModifiers__VisibilityAssignment_1_34362 = new BitSet(new long[]{0x0000000000000002L});
    }


}
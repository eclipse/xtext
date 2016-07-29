package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
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
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalBug360834TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug360834TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug360834TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug360834TestLanguage.g"; }


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
    // InternalBug360834TestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:54:1: ( ruleModel EOF )
            // InternalBug360834TestLanguage.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug360834TestLanguage.g:62:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:66:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalBug360834TestLanguage.g:67:2: ( ( rule__Model__Alternatives ) )
            {
            // InternalBug360834TestLanguage.g:67:2: ( ( rule__Model__Alternatives ) )
            // InternalBug360834TestLanguage.g:68:3: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalBug360834TestLanguage.g:69:3: ( rule__Model__Alternatives )
            // InternalBug360834TestLanguage.g:69:4: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:78:1: entryRuleAlternative : ruleAlternative EOF ;
    public final void entryRuleAlternative() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:79:1: ( ruleAlternative EOF )
            // InternalBug360834TestLanguage.g:80:1: ruleAlternative EOF
            {
             before(grammarAccess.getAlternativeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlternative();

            state._fsp--;

             after(grammarAccess.getAlternativeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug360834TestLanguage.g:87:1: ruleAlternative : ( ( rule__Alternative__Group__0 ) ) ;
    public final void ruleAlternative() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:91:2: ( ( ( rule__Alternative__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:92:2: ( ( rule__Alternative__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:92:2: ( ( rule__Alternative__Group__0 ) )
            // InternalBug360834TestLanguage.g:93:3: ( rule__Alternative__Group__0 )
            {
             before(grammarAccess.getAlternativeAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:94:3: ( rule__Alternative__Group__0 )
            // InternalBug360834TestLanguage.g:94:4: rule__Alternative__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:103:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:104:1: ( ruleFQN EOF )
            // InternalBug360834TestLanguage.g:105:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug360834TestLanguage.g:112:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:116:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:117:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:117:2: ( ( rule__FQN__Group__0 ) )
            // InternalBug360834TestLanguage.g:118:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:119:3: ( rule__FQN__Group__0 )
            // InternalBug360834TestLanguage.g:119:4: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:128:1: entryRuleRecursiveClassDeclaration : ruleRecursiveClassDeclaration EOF ;
    public final void entryRuleRecursiveClassDeclaration() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:129:1: ( ruleRecursiveClassDeclaration EOF )
            // InternalBug360834TestLanguage.g:130:1: ruleRecursiveClassDeclaration EOF
            {
             before(grammarAccess.getRecursiveClassDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRecursiveClassDeclaration();

            state._fsp--;

             after(grammarAccess.getRecursiveClassDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug360834TestLanguage.g:137:1: ruleRecursiveClassDeclaration : ( ( rule__RecursiveClassDeclaration__Group__0 ) ) ;
    public final void ruleRecursiveClassDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:141:2: ( ( ( rule__RecursiveClassDeclaration__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:142:2: ( ( rule__RecursiveClassDeclaration__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:142:2: ( ( rule__RecursiveClassDeclaration__Group__0 ) )
            // InternalBug360834TestLanguage.g:143:3: ( rule__RecursiveClassDeclaration__Group__0 )
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:144:3: ( rule__RecursiveClassDeclaration__Group__0 )
            // InternalBug360834TestLanguage.g:144:4: rule__RecursiveClassDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:153:1: entryRuleAlternativeClassModifiers : ruleAlternativeClassModifiers EOF ;
    public final void entryRuleAlternativeClassModifiers() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:154:1: ( ruleAlternativeClassModifiers EOF )
            // InternalBug360834TestLanguage.g:155:1: ruleAlternativeClassModifiers EOF
            {
             before(grammarAccess.getAlternativeClassModifiersRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlternativeClassModifiers();

            state._fsp--;

             after(grammarAccess.getAlternativeClassModifiersRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug360834TestLanguage.g:162:1: ruleAlternativeClassModifiers : ( ( rule__AlternativeClassModifiers__Group__0 ) ) ;
    public final void ruleAlternativeClassModifiers() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:166:2: ( ( ( rule__AlternativeClassModifiers__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:167:2: ( ( rule__AlternativeClassModifiers__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:167:2: ( ( rule__AlternativeClassModifiers__Group__0 ) )
            // InternalBug360834TestLanguage.g:168:3: ( rule__AlternativeClassModifiers__Group__0 )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:169:3: ( rule__AlternativeClassModifiers__Group__0 )
            // InternalBug360834TestLanguage.g:169:4: rule__AlternativeClassModifiers__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:178:1: entryRuleUnordered : ruleUnordered EOF ;
    public final void entryRuleUnordered() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:179:1: ( ruleUnordered EOF )
            // InternalBug360834TestLanguage.g:180:1: ruleUnordered EOF
            {
             before(grammarAccess.getUnorderedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnordered();

            state._fsp--;

             after(grammarAccess.getUnorderedRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug360834TestLanguage.g:187:1: ruleUnordered : ( ( rule__Unordered__Group__0 ) ) ;
    public final void ruleUnordered() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:191:2: ( ( ( rule__Unordered__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:192:2: ( ( rule__Unordered__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:192:2: ( ( rule__Unordered__Group__0 ) )
            // InternalBug360834TestLanguage.g:193:3: ( rule__Unordered__Group__0 )
            {
             before(grammarAccess.getUnorderedAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:194:3: ( rule__Unordered__Group__0 )
            // InternalBug360834TestLanguage.g:194:4: rule__Unordered__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:203:1: entryRuleSimpleClassDeclaration : ruleSimpleClassDeclaration EOF ;
    public final void entryRuleSimpleClassDeclaration() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:204:1: ( ruleSimpleClassDeclaration EOF )
            // InternalBug360834TestLanguage.g:205:1: ruleSimpleClassDeclaration EOF
            {
             before(grammarAccess.getSimpleClassDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSimpleClassDeclaration();

            state._fsp--;

             after(grammarAccess.getSimpleClassDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug360834TestLanguage.g:212:1: ruleSimpleClassDeclaration : ( ( rule__SimpleClassDeclaration__Group__0 ) ) ;
    public final void ruleSimpleClassDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:216:2: ( ( ( rule__SimpleClassDeclaration__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:217:2: ( ( rule__SimpleClassDeclaration__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:217:2: ( ( rule__SimpleClassDeclaration__Group__0 ) )
            // InternalBug360834TestLanguage.g:218:3: ( rule__SimpleClassDeclaration__Group__0 )
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:219:3: ( rule__SimpleClassDeclaration__Group__0 )
            // InternalBug360834TestLanguage.g:219:4: rule__SimpleClassDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:228:1: entryRuleClassMember : ruleClassMember EOF ;
    public final void entryRuleClassMember() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:229:1: ( ruleClassMember EOF )
            // InternalBug360834TestLanguage.g:230:1: ruleClassMember EOF
            {
             before(grammarAccess.getClassMemberRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleClassMember();

            state._fsp--;

             after(grammarAccess.getClassMemberRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug360834TestLanguage.g:237:1: ruleClassMember : ( ( rule__ClassMember__Group__0 ) ) ;
    public final void ruleClassMember() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:241:2: ( ( ( rule__ClassMember__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:242:2: ( ( rule__ClassMember__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:242:2: ( ( rule__ClassMember__Group__0 ) )
            // InternalBug360834TestLanguage.g:243:3: ( rule__ClassMember__Group__0 )
            {
             before(grammarAccess.getClassMemberAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:244:3: ( rule__ClassMember__Group__0 )
            // InternalBug360834TestLanguage.g:244:4: rule__ClassMember__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:253:1: entryRuleUnorderedModifiers : ruleUnorderedModifiers EOF ;
    public final void entryRuleUnorderedModifiers() throws RecognitionException {
        try {
            // InternalBug360834TestLanguage.g:254:1: ( ruleUnorderedModifiers EOF )
            // InternalBug360834TestLanguage.g:255:1: ruleUnorderedModifiers EOF
            {
             before(grammarAccess.getUnorderedModifiersRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnorderedModifiers();

            state._fsp--;

             after(grammarAccess.getUnorderedModifiersRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug360834TestLanguage.g:262:1: ruleUnorderedModifiers : ( ( rule__UnorderedModifiers__Group__0 ) ) ;
    public final void ruleUnorderedModifiers() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:266:2: ( ( ( rule__UnorderedModifiers__Group__0 ) ) )
            // InternalBug360834TestLanguage.g:267:2: ( ( rule__UnorderedModifiers__Group__0 ) )
            {
            // InternalBug360834TestLanguage.g:267:2: ( ( rule__UnorderedModifiers__Group__0 ) )
            // InternalBug360834TestLanguage.g:268:3: ( rule__UnorderedModifiers__Group__0 )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getGroup()); 
            // InternalBug360834TestLanguage.g:269:3: ( rule__UnorderedModifiers__Group__0 )
            // InternalBug360834TestLanguage.g:269:4: rule__UnorderedModifiers__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:278:1: ruleVisibility : ( ( rule__Visibility__Alternatives ) ) ;
    public final void ruleVisibility() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:282:1: ( ( ( rule__Visibility__Alternatives ) ) )
            // InternalBug360834TestLanguage.g:283:2: ( ( rule__Visibility__Alternatives ) )
            {
            // InternalBug360834TestLanguage.g:283:2: ( ( rule__Visibility__Alternatives ) )
            // InternalBug360834TestLanguage.g:284:3: ( rule__Visibility__Alternatives )
            {
             before(grammarAccess.getVisibilityAccess().getAlternatives()); 
            // InternalBug360834TestLanguage.g:285:3: ( rule__Visibility__Alternatives )
            // InternalBug360834TestLanguage.g:285:4: rule__Visibility__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:293:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:297:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) )
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
                    // InternalBug360834TestLanguage.g:298:2: ( ( rule__Model__Group_0__0 ) )
                    {
                    // InternalBug360834TestLanguage.g:298:2: ( ( rule__Model__Group_0__0 ) )
                    // InternalBug360834TestLanguage.g:299:3: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // InternalBug360834TestLanguage.g:300:3: ( rule__Model__Group_0__0 )
                    // InternalBug360834TestLanguage.g:300:4: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug360834TestLanguage.g:304:2: ( ( rule__Model__Group_1__0 ) )
                    {
                    // InternalBug360834TestLanguage.g:304:2: ( ( rule__Model__Group_1__0 ) )
                    // InternalBug360834TestLanguage.g:305:3: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // InternalBug360834TestLanguage.g:306:3: ( rule__Model__Group_1__0 )
                    // InternalBug360834TestLanguage.g:306:4: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:314:1: rule__AlternativeClassModifiers__Alternatives_1 : ( ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) ) | ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) ) | ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) ) | ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? ) );
    public final void rule__AlternativeClassModifiers__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:318:1: ( ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) ) | ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) ) | ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) ) | ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? ) )
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
                    // InternalBug360834TestLanguage.g:319:2: ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) )
                    {
                    // InternalBug360834TestLanguage.g:319:2: ( ( rule__AlternativeClassModifiers__FinalAssignment_1_0 ) )
                    // InternalBug360834TestLanguage.g:320:3: ( rule__AlternativeClassModifiers__FinalAssignment_1_0 )
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getFinalAssignment_1_0()); 
                    // InternalBug360834TestLanguage.g:321:3: ( rule__AlternativeClassModifiers__FinalAssignment_1_0 )
                    // InternalBug360834TestLanguage.g:321:4: rule__AlternativeClassModifiers__FinalAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__AlternativeClassModifiers__FinalAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getFinalAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug360834TestLanguage.g:325:2: ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) )
                    {
                    // InternalBug360834TestLanguage.g:325:2: ( ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 ) )
                    // InternalBug360834TestLanguage.g:326:3: ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 )
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAssignment_1_1()); 
                    // InternalBug360834TestLanguage.g:327:3: ( rule__AlternativeClassModifiers__AbstractAssignment_1_1 )
                    // InternalBug360834TestLanguage.g:327:4: rule__AlternativeClassModifiers__AbstractAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__AlternativeClassModifiers__AbstractAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug360834TestLanguage.g:331:2: ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) )
                    {
                    // InternalBug360834TestLanguage.g:331:2: ( ( rule__AlternativeClassModifiers__ExternAssignment_1_2 ) )
                    // InternalBug360834TestLanguage.g:332:3: ( rule__AlternativeClassModifiers__ExternAssignment_1_2 )
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getExternAssignment_1_2()); 
                    // InternalBug360834TestLanguage.g:333:3: ( rule__AlternativeClassModifiers__ExternAssignment_1_2 )
                    // InternalBug360834TestLanguage.g:333:4: rule__AlternativeClassModifiers__ExternAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__AlternativeClassModifiers__ExternAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getAlternativeClassModifiersAccess().getExternAssignment_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBug360834TestLanguage.g:337:2: ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? )
                    {
                    // InternalBug360834TestLanguage.g:337:2: ( ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )? )
                    // InternalBug360834TestLanguage.g:338:3: ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )?
                    {
                     before(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityAssignment_1_3()); 
                    // InternalBug360834TestLanguage.g:339:3: ( rule__AlternativeClassModifiers__VisibilityAssignment_1_3 )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( ((LA2_0>=11 && LA2_0<=13)) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalBug360834TestLanguage.g:339:4: rule__AlternativeClassModifiers__VisibilityAssignment_1_3
                            {
                            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:347:1: rule__Visibility__Alternatives : ( ( ( 'public' ) ) | ( ( 'protected' ) ) | ( ( 'private' ) ) );
    public final void rule__Visibility__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:351:1: ( ( ( 'public' ) ) | ( ( 'protected' ) ) | ( ( 'private' ) ) )
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
                    // InternalBug360834TestLanguage.g:352:2: ( ( 'public' ) )
                    {
                    // InternalBug360834TestLanguage.g:352:2: ( ( 'public' ) )
                    // InternalBug360834TestLanguage.g:353:3: ( 'public' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0()); 
                    // InternalBug360834TestLanguage.g:354:3: ( 'public' )
                    // InternalBug360834TestLanguage.g:354:4: 'public'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug360834TestLanguage.g:358:2: ( ( 'protected' ) )
                    {
                    // InternalBug360834TestLanguage.g:358:2: ( ( 'protected' ) )
                    // InternalBug360834TestLanguage.g:359:3: ( 'protected' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 
                    // InternalBug360834TestLanguage.g:360:3: ( 'protected' )
                    // InternalBug360834TestLanguage.g:360:4: 'protected'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug360834TestLanguage.g:364:2: ( ( 'private' ) )
                    {
                    // InternalBug360834TestLanguage.g:364:2: ( ( 'private' ) )
                    // InternalBug360834TestLanguage.g:365:3: ( 'private' )
                    {
                     before(grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2()); 
                    // InternalBug360834TestLanguage.g:366:3: ( 'private' )
                    // InternalBug360834TestLanguage.g:366:4: 'private'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

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
    // InternalBug360834TestLanguage.g:374:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:378:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // InternalBug360834TestLanguage.g:379:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:386:1: rule__Model__Group_0__0__Impl : ( 'alternative' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:390:1: ( ( 'alternative' ) )
            // InternalBug360834TestLanguage.g:391:1: ( 'alternative' )
            {
            // InternalBug360834TestLanguage.g:391:1: ( 'alternative' )
            // InternalBug360834TestLanguage.g:392:2: 'alternative'
            {
             before(grammarAccess.getModelAccess().getAlternativeKeyword_0_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:401:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:405:1: ( rule__Model__Group_0__1__Impl )
            // InternalBug360834TestLanguage.g:406:2: rule__Model__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:412:1: rule__Model__Group_0__1__Impl : ( ( rule__Model__ElementAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:416:1: ( ( ( rule__Model__ElementAssignment_0_1 ) ) )
            // InternalBug360834TestLanguage.g:417:1: ( ( rule__Model__ElementAssignment_0_1 ) )
            {
            // InternalBug360834TestLanguage.g:417:1: ( ( rule__Model__ElementAssignment_0_1 ) )
            // InternalBug360834TestLanguage.g:418:2: ( rule__Model__ElementAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getElementAssignment_0_1()); 
            // InternalBug360834TestLanguage.g:419:2: ( rule__Model__ElementAssignment_0_1 )
            // InternalBug360834TestLanguage.g:419:3: rule__Model__ElementAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:428:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:432:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // InternalBug360834TestLanguage.g:433:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:440:1: rule__Model__Group_1__0__Impl : ( 'unordered' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:444:1: ( ( 'unordered' ) )
            // InternalBug360834TestLanguage.g:445:1: ( 'unordered' )
            {
            // InternalBug360834TestLanguage.g:445:1: ( 'unordered' )
            // InternalBug360834TestLanguage.g:446:2: 'unordered'
            {
             before(grammarAccess.getModelAccess().getUnorderedKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:455:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:459:1: ( rule__Model__Group_1__1__Impl )
            // InternalBug360834TestLanguage.g:460:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:466:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__ElementAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:470:1: ( ( ( rule__Model__ElementAssignment_1_1 ) ) )
            // InternalBug360834TestLanguage.g:471:1: ( ( rule__Model__ElementAssignment_1_1 ) )
            {
            // InternalBug360834TestLanguage.g:471:1: ( ( rule__Model__ElementAssignment_1_1 ) )
            // InternalBug360834TestLanguage.g:472:2: ( rule__Model__ElementAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getElementAssignment_1_1()); 
            // InternalBug360834TestLanguage.g:473:2: ( rule__Model__ElementAssignment_1_1 )
            // InternalBug360834TestLanguage.g:473:3: rule__Model__ElementAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:482:1: rule__Alternative__Group__0 : rule__Alternative__Group__0__Impl rule__Alternative__Group__1 ;
    public final void rule__Alternative__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:486:1: ( rule__Alternative__Group__0__Impl rule__Alternative__Group__1 )
            // InternalBug360834TestLanguage.g:487:2: rule__Alternative__Group__0__Impl rule__Alternative__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Alternative__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:494:1: rule__Alternative__Group__0__Impl : ( 'package' ) ;
    public final void rule__Alternative__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:498:1: ( ( 'package' ) )
            // InternalBug360834TestLanguage.g:499:1: ( 'package' )
            {
            // InternalBug360834TestLanguage.g:499:1: ( 'package' )
            // InternalBug360834TestLanguage.g:500:2: 'package'
            {
             before(grammarAccess.getAlternativeAccess().getPackageKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:509:1: rule__Alternative__Group__1 : rule__Alternative__Group__1__Impl rule__Alternative__Group__2 ;
    public final void rule__Alternative__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:513:1: ( rule__Alternative__Group__1__Impl rule__Alternative__Group__2 )
            // InternalBug360834TestLanguage.g:514:2: rule__Alternative__Group__1__Impl rule__Alternative__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Alternative__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:521:1: rule__Alternative__Group__1__Impl : ( ( rule__Alternative__NameAssignment_1 ) ) ;
    public final void rule__Alternative__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:525:1: ( ( ( rule__Alternative__NameAssignment_1 ) ) )
            // InternalBug360834TestLanguage.g:526:1: ( ( rule__Alternative__NameAssignment_1 ) )
            {
            // InternalBug360834TestLanguage.g:526:1: ( ( rule__Alternative__NameAssignment_1 ) )
            // InternalBug360834TestLanguage.g:527:2: ( rule__Alternative__NameAssignment_1 )
            {
             before(grammarAccess.getAlternativeAccess().getNameAssignment_1()); 
            // InternalBug360834TestLanguage.g:528:2: ( rule__Alternative__NameAssignment_1 )
            // InternalBug360834TestLanguage.g:528:3: rule__Alternative__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:536:1: rule__Alternative__Group__2 : rule__Alternative__Group__2__Impl rule__Alternative__Group__3 ;
    public final void rule__Alternative__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:540:1: ( rule__Alternative__Group__2__Impl rule__Alternative__Group__3 )
            // InternalBug360834TestLanguage.g:541:2: rule__Alternative__Group__2__Impl rule__Alternative__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Alternative__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:548:1: rule__Alternative__Group__2__Impl : ( ';' ) ;
    public final void rule__Alternative__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:552:1: ( ( ';' ) )
            // InternalBug360834TestLanguage.g:553:1: ( ';' )
            {
            // InternalBug360834TestLanguage.g:553:1: ( ';' )
            // InternalBug360834TestLanguage.g:554:2: ';'
            {
             before(grammarAccess.getAlternativeAccess().getSemicolonKeyword_2()); 
            match(input,17,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:563:1: rule__Alternative__Group__3 : rule__Alternative__Group__3__Impl ;
    public final void rule__Alternative__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:567:1: ( rule__Alternative__Group__3__Impl )
            // InternalBug360834TestLanguage.g:568:2: rule__Alternative__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:574:1: rule__Alternative__Group__3__Impl : ( ( rule__Alternative__RootDeclarationAssignment_3 ) ) ;
    public final void rule__Alternative__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:578:1: ( ( ( rule__Alternative__RootDeclarationAssignment_3 ) ) )
            // InternalBug360834TestLanguage.g:579:1: ( ( rule__Alternative__RootDeclarationAssignment_3 ) )
            {
            // InternalBug360834TestLanguage.g:579:1: ( ( rule__Alternative__RootDeclarationAssignment_3 ) )
            // InternalBug360834TestLanguage.g:580:2: ( rule__Alternative__RootDeclarationAssignment_3 )
            {
             before(grammarAccess.getAlternativeAccess().getRootDeclarationAssignment_3()); 
            // InternalBug360834TestLanguage.g:581:2: ( rule__Alternative__RootDeclarationAssignment_3 )
            // InternalBug360834TestLanguage.g:581:3: rule__Alternative__RootDeclarationAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:590:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:594:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalBug360834TestLanguage.g:595:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:602:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:606:1: ( ( RULE_ID ) )
            // InternalBug360834TestLanguage.g:607:1: ( RULE_ID )
            {
            // InternalBug360834TestLanguage.g:607:1: ( RULE_ID )
            // InternalBug360834TestLanguage.g:608:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:617:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:621:1: ( rule__FQN__Group__1__Impl )
            // InternalBug360834TestLanguage.g:622:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:628:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:632:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalBug360834TestLanguage.g:633:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalBug360834TestLanguage.g:633:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalBug360834TestLanguage.g:634:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalBug360834TestLanguage.g:635:2: ( rule__FQN__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBug360834TestLanguage.g:635:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
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
    // InternalBug360834TestLanguage.g:644:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:648:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalBug360834TestLanguage.g:649:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:656:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:660:1: ( ( '.' ) )
            // InternalBug360834TestLanguage.g:661:1: ( '.' )
            {
            // InternalBug360834TestLanguage.g:661:1: ( '.' )
            // InternalBug360834TestLanguage.g:662:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:671:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:675:1: ( rule__FQN__Group_1__1__Impl )
            // InternalBug360834TestLanguage.g:676:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:682:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:686:1: ( ( RULE_ID ) )
            // InternalBug360834TestLanguage.g:687:1: ( RULE_ID )
            {
            // InternalBug360834TestLanguage.g:687:1: ( RULE_ID )
            // InternalBug360834TestLanguage.g:688:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:698:1: rule__RecursiveClassDeclaration__Group__0 : rule__RecursiveClassDeclaration__Group__0__Impl rule__RecursiveClassDeclaration__Group__1 ;
    public final void rule__RecursiveClassDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:702:1: ( rule__RecursiveClassDeclaration__Group__0__Impl rule__RecursiveClassDeclaration__Group__1 )
            // InternalBug360834TestLanguage.g:703:2: rule__RecursiveClassDeclaration__Group__0__Impl rule__RecursiveClassDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__RecursiveClassDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:710:1: rule__RecursiveClassDeclaration__Group__0__Impl : ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) ) ;
    public final void rule__RecursiveClassDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:714:1: ( ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) ) )
            // InternalBug360834TestLanguage.g:715:1: ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) )
            {
            // InternalBug360834TestLanguage.g:715:1: ( ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 ) )
            // InternalBug360834TestLanguage.g:716:2: ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 )
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAssignment_0()); 
            // InternalBug360834TestLanguage.g:717:2: ( rule__RecursiveClassDeclaration__ModifiersAssignment_0 )
            // InternalBug360834TestLanguage.g:717:3: rule__RecursiveClassDeclaration__ModifiersAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:725:1: rule__RecursiveClassDeclaration__Group__1 : rule__RecursiveClassDeclaration__Group__1__Impl rule__RecursiveClassDeclaration__Group__2 ;
    public final void rule__RecursiveClassDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:729:1: ( rule__RecursiveClassDeclaration__Group__1__Impl rule__RecursiveClassDeclaration__Group__2 )
            // InternalBug360834TestLanguage.g:730:2: rule__RecursiveClassDeclaration__Group__1__Impl rule__RecursiveClassDeclaration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__RecursiveClassDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:737:1: rule__RecursiveClassDeclaration__Group__1__Impl : ( 'class' ) ;
    public final void rule__RecursiveClassDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:741:1: ( ( 'class' ) )
            // InternalBug360834TestLanguage.g:742:1: ( 'class' )
            {
            // InternalBug360834TestLanguage.g:742:1: ( 'class' )
            // InternalBug360834TestLanguage.g:743:2: 'class'
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getClassKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:752:1: rule__RecursiveClassDeclaration__Group__2 : rule__RecursiveClassDeclaration__Group__2__Impl rule__RecursiveClassDeclaration__Group__3 ;
    public final void rule__RecursiveClassDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:756:1: ( rule__RecursiveClassDeclaration__Group__2__Impl rule__RecursiveClassDeclaration__Group__3 )
            // InternalBug360834TestLanguage.g:757:2: rule__RecursiveClassDeclaration__Group__2__Impl rule__RecursiveClassDeclaration__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__RecursiveClassDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:764:1: rule__RecursiveClassDeclaration__Group__2__Impl : ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) ) ;
    public final void rule__RecursiveClassDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:768:1: ( ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) ) )
            // InternalBug360834TestLanguage.g:769:1: ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) )
            {
            // InternalBug360834TestLanguage.g:769:1: ( ( rule__RecursiveClassDeclaration__NameAssignment_2 ) )
            // InternalBug360834TestLanguage.g:770:2: ( rule__RecursiveClassDeclaration__NameAssignment_2 )
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getNameAssignment_2()); 
            // InternalBug360834TestLanguage.g:771:2: ( rule__RecursiveClassDeclaration__NameAssignment_2 )
            // InternalBug360834TestLanguage.g:771:3: rule__RecursiveClassDeclaration__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:779:1: rule__RecursiveClassDeclaration__Group__3 : rule__RecursiveClassDeclaration__Group__3__Impl rule__RecursiveClassDeclaration__Group__4 ;
    public final void rule__RecursiveClassDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:783:1: ( rule__RecursiveClassDeclaration__Group__3__Impl rule__RecursiveClassDeclaration__Group__4 )
            // InternalBug360834TestLanguage.g:784:2: rule__RecursiveClassDeclaration__Group__3__Impl rule__RecursiveClassDeclaration__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__RecursiveClassDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:791:1: rule__RecursiveClassDeclaration__Group__3__Impl : ( '{' ) ;
    public final void rule__RecursiveClassDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:795:1: ( ( '{' ) )
            // InternalBug360834TestLanguage.g:796:1: ( '{' )
            {
            // InternalBug360834TestLanguage.g:796:1: ( '{' )
            // InternalBug360834TestLanguage.g:797:2: '{'
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,20,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:806:1: rule__RecursiveClassDeclaration__Group__4 : rule__RecursiveClassDeclaration__Group__4__Impl rule__RecursiveClassDeclaration__Group__5 ;
    public final void rule__RecursiveClassDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:810:1: ( rule__RecursiveClassDeclaration__Group__4__Impl rule__RecursiveClassDeclaration__Group__5 )
            // InternalBug360834TestLanguage.g:811:2: rule__RecursiveClassDeclaration__Group__4__Impl rule__RecursiveClassDeclaration__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__RecursiveClassDeclaration__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:818:1: rule__RecursiveClassDeclaration__Group__4__Impl : ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* ) ;
    public final void rule__RecursiveClassDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:822:1: ( ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* ) )
            // InternalBug360834TestLanguage.g:823:1: ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* )
            {
            // InternalBug360834TestLanguage.g:823:1: ( ( rule__RecursiveClassDeclaration__MembersAssignment_4 )* )
            // InternalBug360834TestLanguage.g:824:2: ( rule__RecursiveClassDeclaration__MembersAssignment_4 )*
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getMembersAssignment_4()); 
            // InternalBug360834TestLanguage.g:825:2: ( rule__RecursiveClassDeclaration__MembersAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==EOF||(LA6_0>=11 && LA6_0<=13)||LA6_0==19||(LA6_0>=23 && LA6_0<=25)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBug360834TestLanguage.g:825:3: rule__RecursiveClassDeclaration__MembersAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_12);
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
    // InternalBug360834TestLanguage.g:833:1: rule__RecursiveClassDeclaration__Group__5 : rule__RecursiveClassDeclaration__Group__5__Impl ;
    public final void rule__RecursiveClassDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:837:1: ( rule__RecursiveClassDeclaration__Group__5__Impl )
            // InternalBug360834TestLanguage.g:838:2: rule__RecursiveClassDeclaration__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:844:1: rule__RecursiveClassDeclaration__Group__5__Impl : ( '}' ) ;
    public final void rule__RecursiveClassDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:848:1: ( ( '}' ) )
            // InternalBug360834TestLanguage.g:849:1: ( '}' )
            {
            // InternalBug360834TestLanguage.g:849:1: ( '}' )
            // InternalBug360834TestLanguage.g:850:2: '}'
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,21,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:860:1: rule__AlternativeClassModifiers__Group__0 : rule__AlternativeClassModifiers__Group__0__Impl rule__AlternativeClassModifiers__Group__1 ;
    public final void rule__AlternativeClassModifiers__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:864:1: ( rule__AlternativeClassModifiers__Group__0__Impl rule__AlternativeClassModifiers__Group__1 )
            // InternalBug360834TestLanguage.g:865:2: rule__AlternativeClassModifiers__Group__0__Impl rule__AlternativeClassModifiers__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__AlternativeClassModifiers__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:872:1: rule__AlternativeClassModifiers__Group__0__Impl : ( () ) ;
    public final void rule__AlternativeClassModifiers__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:876:1: ( ( () ) )
            // InternalBug360834TestLanguage.g:877:1: ( () )
            {
            // InternalBug360834TestLanguage.g:877:1: ( () )
            // InternalBug360834TestLanguage.g:878:2: ()
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getModifiersAction_0()); 
            // InternalBug360834TestLanguage.g:879:2: ()
            // InternalBug360834TestLanguage.g:879:3: 
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
    // InternalBug360834TestLanguage.g:887:1: rule__AlternativeClassModifiers__Group__1 : rule__AlternativeClassModifiers__Group__1__Impl ;
    public final void rule__AlternativeClassModifiers__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:891:1: ( rule__AlternativeClassModifiers__Group__1__Impl )
            // InternalBug360834TestLanguage.g:892:2: rule__AlternativeClassModifiers__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:898:1: rule__AlternativeClassModifiers__Group__1__Impl : ( ( rule__AlternativeClassModifiers__Alternatives_1 ) ) ;
    public final void rule__AlternativeClassModifiers__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:902:1: ( ( ( rule__AlternativeClassModifiers__Alternatives_1 ) ) )
            // InternalBug360834TestLanguage.g:903:1: ( ( rule__AlternativeClassModifiers__Alternatives_1 ) )
            {
            // InternalBug360834TestLanguage.g:903:1: ( ( rule__AlternativeClassModifiers__Alternatives_1 ) )
            // InternalBug360834TestLanguage.g:904:2: ( rule__AlternativeClassModifiers__Alternatives_1 )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getAlternatives_1()); 
            // InternalBug360834TestLanguage.g:905:2: ( rule__AlternativeClassModifiers__Alternatives_1 )
            // InternalBug360834TestLanguage.g:905:3: rule__AlternativeClassModifiers__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:914:1: rule__Unordered__Group__0 : rule__Unordered__Group__0__Impl rule__Unordered__Group__1 ;
    public final void rule__Unordered__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:918:1: ( rule__Unordered__Group__0__Impl rule__Unordered__Group__1 )
            // InternalBug360834TestLanguage.g:919:2: rule__Unordered__Group__0__Impl rule__Unordered__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Unordered__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:926:1: rule__Unordered__Group__0__Impl : ( 'package' ) ;
    public final void rule__Unordered__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:930:1: ( ( 'package' ) )
            // InternalBug360834TestLanguage.g:931:1: ( 'package' )
            {
            // InternalBug360834TestLanguage.g:931:1: ( 'package' )
            // InternalBug360834TestLanguage.g:932:2: 'package'
            {
             before(grammarAccess.getUnorderedAccess().getPackageKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:941:1: rule__Unordered__Group__1 : rule__Unordered__Group__1__Impl rule__Unordered__Group__2 ;
    public final void rule__Unordered__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:945:1: ( rule__Unordered__Group__1__Impl rule__Unordered__Group__2 )
            // InternalBug360834TestLanguage.g:946:2: rule__Unordered__Group__1__Impl rule__Unordered__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Unordered__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:953:1: rule__Unordered__Group__1__Impl : ( ( rule__Unordered__NameAssignment_1 ) ) ;
    public final void rule__Unordered__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:957:1: ( ( ( rule__Unordered__NameAssignment_1 ) ) )
            // InternalBug360834TestLanguage.g:958:1: ( ( rule__Unordered__NameAssignment_1 ) )
            {
            // InternalBug360834TestLanguage.g:958:1: ( ( rule__Unordered__NameAssignment_1 ) )
            // InternalBug360834TestLanguage.g:959:2: ( rule__Unordered__NameAssignment_1 )
            {
             before(grammarAccess.getUnorderedAccess().getNameAssignment_1()); 
            // InternalBug360834TestLanguage.g:960:2: ( rule__Unordered__NameAssignment_1 )
            // InternalBug360834TestLanguage.g:960:3: rule__Unordered__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:968:1: rule__Unordered__Group__2 : rule__Unordered__Group__2__Impl rule__Unordered__Group__3 ;
    public final void rule__Unordered__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:972:1: ( rule__Unordered__Group__2__Impl rule__Unordered__Group__3 )
            // InternalBug360834TestLanguage.g:973:2: rule__Unordered__Group__2__Impl rule__Unordered__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Unordered__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:980:1: rule__Unordered__Group__2__Impl : ( ';' ) ;
    public final void rule__Unordered__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:984:1: ( ( ';' ) )
            // InternalBug360834TestLanguage.g:985:1: ( ';' )
            {
            // InternalBug360834TestLanguage.g:985:1: ( ';' )
            // InternalBug360834TestLanguage.g:986:2: ';'
            {
             before(grammarAccess.getUnorderedAccess().getSemicolonKeyword_2()); 
            match(input,17,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:995:1: rule__Unordered__Group__3 : rule__Unordered__Group__3__Impl ;
    public final void rule__Unordered__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:999:1: ( rule__Unordered__Group__3__Impl )
            // InternalBug360834TestLanguage.g:1000:2: rule__Unordered__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1006:1: rule__Unordered__Group__3__Impl : ( ( rule__Unordered__RootDeclarationAssignment_3 ) ) ;
    public final void rule__Unordered__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1010:1: ( ( ( rule__Unordered__RootDeclarationAssignment_3 ) ) )
            // InternalBug360834TestLanguage.g:1011:1: ( ( rule__Unordered__RootDeclarationAssignment_3 ) )
            {
            // InternalBug360834TestLanguage.g:1011:1: ( ( rule__Unordered__RootDeclarationAssignment_3 ) )
            // InternalBug360834TestLanguage.g:1012:2: ( rule__Unordered__RootDeclarationAssignment_3 )
            {
             before(grammarAccess.getUnorderedAccess().getRootDeclarationAssignment_3()); 
            // InternalBug360834TestLanguage.g:1013:2: ( rule__Unordered__RootDeclarationAssignment_3 )
            // InternalBug360834TestLanguage.g:1013:3: rule__Unordered__RootDeclarationAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1022:1: rule__SimpleClassDeclaration__Group__0 : rule__SimpleClassDeclaration__Group__0__Impl rule__SimpleClassDeclaration__Group__1 ;
    public final void rule__SimpleClassDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1026:1: ( rule__SimpleClassDeclaration__Group__0__Impl rule__SimpleClassDeclaration__Group__1 )
            // InternalBug360834TestLanguage.g:1027:2: rule__SimpleClassDeclaration__Group__0__Impl rule__SimpleClassDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__SimpleClassDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1034:1: rule__SimpleClassDeclaration__Group__0__Impl : ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) ) ;
    public final void rule__SimpleClassDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1038:1: ( ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) ) )
            // InternalBug360834TestLanguage.g:1039:1: ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) )
            {
            // InternalBug360834TestLanguage.g:1039:1: ( ( rule__SimpleClassDeclaration__ModifiersAssignment_0 ) )
            // InternalBug360834TestLanguage.g:1040:2: ( rule__SimpleClassDeclaration__ModifiersAssignment_0 )
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getModifiersAssignment_0()); 
            // InternalBug360834TestLanguage.g:1041:2: ( rule__SimpleClassDeclaration__ModifiersAssignment_0 )
            // InternalBug360834TestLanguage.g:1041:3: rule__SimpleClassDeclaration__ModifiersAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1049:1: rule__SimpleClassDeclaration__Group__1 : rule__SimpleClassDeclaration__Group__1__Impl rule__SimpleClassDeclaration__Group__2 ;
    public final void rule__SimpleClassDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1053:1: ( rule__SimpleClassDeclaration__Group__1__Impl rule__SimpleClassDeclaration__Group__2 )
            // InternalBug360834TestLanguage.g:1054:2: rule__SimpleClassDeclaration__Group__1__Impl rule__SimpleClassDeclaration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__SimpleClassDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1061:1: rule__SimpleClassDeclaration__Group__1__Impl : ( 'class' ) ;
    public final void rule__SimpleClassDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1065:1: ( ( 'class' ) )
            // InternalBug360834TestLanguage.g:1066:1: ( 'class' )
            {
            // InternalBug360834TestLanguage.g:1066:1: ( 'class' )
            // InternalBug360834TestLanguage.g:1067:2: 'class'
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getClassKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1076:1: rule__SimpleClassDeclaration__Group__2 : rule__SimpleClassDeclaration__Group__2__Impl rule__SimpleClassDeclaration__Group__3 ;
    public final void rule__SimpleClassDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1080:1: ( rule__SimpleClassDeclaration__Group__2__Impl rule__SimpleClassDeclaration__Group__3 )
            // InternalBug360834TestLanguage.g:1081:2: rule__SimpleClassDeclaration__Group__2__Impl rule__SimpleClassDeclaration__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__SimpleClassDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1088:1: rule__SimpleClassDeclaration__Group__2__Impl : ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) ) ;
    public final void rule__SimpleClassDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1092:1: ( ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) ) )
            // InternalBug360834TestLanguage.g:1093:1: ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) )
            {
            // InternalBug360834TestLanguage.g:1093:1: ( ( rule__SimpleClassDeclaration__NameAssignment_2 ) )
            // InternalBug360834TestLanguage.g:1094:2: ( rule__SimpleClassDeclaration__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getNameAssignment_2()); 
            // InternalBug360834TestLanguage.g:1095:2: ( rule__SimpleClassDeclaration__NameAssignment_2 )
            // InternalBug360834TestLanguage.g:1095:3: rule__SimpleClassDeclaration__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1103:1: rule__SimpleClassDeclaration__Group__3 : rule__SimpleClassDeclaration__Group__3__Impl rule__SimpleClassDeclaration__Group__4 ;
    public final void rule__SimpleClassDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1107:1: ( rule__SimpleClassDeclaration__Group__3__Impl rule__SimpleClassDeclaration__Group__4 )
            // InternalBug360834TestLanguage.g:1108:2: rule__SimpleClassDeclaration__Group__3__Impl rule__SimpleClassDeclaration__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__SimpleClassDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1115:1: rule__SimpleClassDeclaration__Group__3__Impl : ( '{' ) ;
    public final void rule__SimpleClassDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1119:1: ( ( '{' ) )
            // InternalBug360834TestLanguage.g:1120:1: ( '{' )
            {
            // InternalBug360834TestLanguage.g:1120:1: ( '{' )
            // InternalBug360834TestLanguage.g:1121:2: '{'
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,20,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1130:1: rule__SimpleClassDeclaration__Group__4 : rule__SimpleClassDeclaration__Group__4__Impl rule__SimpleClassDeclaration__Group__5 ;
    public final void rule__SimpleClassDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1134:1: ( rule__SimpleClassDeclaration__Group__4__Impl rule__SimpleClassDeclaration__Group__5 )
            // InternalBug360834TestLanguage.g:1135:2: rule__SimpleClassDeclaration__Group__4__Impl rule__SimpleClassDeclaration__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__SimpleClassDeclaration__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1142:1: rule__SimpleClassDeclaration__Group__4__Impl : ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* ) ;
    public final void rule__SimpleClassDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1146:1: ( ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* ) )
            // InternalBug360834TestLanguage.g:1147:1: ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* )
            {
            // InternalBug360834TestLanguage.g:1147:1: ( ( rule__SimpleClassDeclaration__MembersAssignment_4 )* )
            // InternalBug360834TestLanguage.g:1148:2: ( rule__SimpleClassDeclaration__MembersAssignment_4 )*
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getMembersAssignment_4()); 
            // InternalBug360834TestLanguage.g:1149:2: ( rule__SimpleClassDeclaration__MembersAssignment_4 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==EOF||(LA7_0>=11 && LA7_0<=13)||LA7_0==19||(LA7_0>=22 && LA7_0<=25)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBug360834TestLanguage.g:1149:3: rule__SimpleClassDeclaration__MembersAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_12);
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
    // InternalBug360834TestLanguage.g:1157:1: rule__SimpleClassDeclaration__Group__5 : rule__SimpleClassDeclaration__Group__5__Impl ;
    public final void rule__SimpleClassDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1161:1: ( rule__SimpleClassDeclaration__Group__5__Impl )
            // InternalBug360834TestLanguage.g:1162:2: rule__SimpleClassDeclaration__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1168:1: rule__SimpleClassDeclaration__Group__5__Impl : ( '}' ) ;
    public final void rule__SimpleClassDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1172:1: ( ( '}' ) )
            // InternalBug360834TestLanguage.g:1173:1: ( '}' )
            {
            // InternalBug360834TestLanguage.g:1173:1: ( '}' )
            // InternalBug360834TestLanguage.g:1174:2: '}'
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,21,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1184:1: rule__ClassMember__Group__0 : rule__ClassMember__Group__0__Impl rule__ClassMember__Group__1 ;
    public final void rule__ClassMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1188:1: ( rule__ClassMember__Group__0__Impl rule__ClassMember__Group__1 )
            // InternalBug360834TestLanguage.g:1189:2: rule__ClassMember__Group__0__Impl rule__ClassMember__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__ClassMember__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1196:1: rule__ClassMember__Group__0__Impl : ( ( rule__ClassMember__ModifiersAssignment_0 ) ) ;
    public final void rule__ClassMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1200:1: ( ( ( rule__ClassMember__ModifiersAssignment_0 ) ) )
            // InternalBug360834TestLanguage.g:1201:1: ( ( rule__ClassMember__ModifiersAssignment_0 ) )
            {
            // InternalBug360834TestLanguage.g:1201:1: ( ( rule__ClassMember__ModifiersAssignment_0 ) )
            // InternalBug360834TestLanguage.g:1202:2: ( rule__ClassMember__ModifiersAssignment_0 )
            {
             before(grammarAccess.getClassMemberAccess().getModifiersAssignment_0()); 
            // InternalBug360834TestLanguage.g:1203:2: ( rule__ClassMember__ModifiersAssignment_0 )
            // InternalBug360834TestLanguage.g:1203:3: rule__ClassMember__ModifiersAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1211:1: rule__ClassMember__Group__1 : rule__ClassMember__Group__1__Impl rule__ClassMember__Group__2 ;
    public final void rule__ClassMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1215:1: ( rule__ClassMember__Group__1__Impl rule__ClassMember__Group__2 )
            // InternalBug360834TestLanguage.g:1216:2: rule__ClassMember__Group__1__Impl rule__ClassMember__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__ClassMember__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1223:1: rule__ClassMember__Group__1__Impl : ( 'var' ) ;
    public final void rule__ClassMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1227:1: ( ( 'var' ) )
            // InternalBug360834TestLanguage.g:1228:1: ( 'var' )
            {
            // InternalBug360834TestLanguage.g:1228:1: ( 'var' )
            // InternalBug360834TestLanguage.g:1229:2: 'var'
            {
             before(grammarAccess.getClassMemberAccess().getVarKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1238:1: rule__ClassMember__Group__2 : rule__ClassMember__Group__2__Impl rule__ClassMember__Group__3 ;
    public final void rule__ClassMember__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1242:1: ( rule__ClassMember__Group__2__Impl rule__ClassMember__Group__3 )
            // InternalBug360834TestLanguage.g:1243:2: rule__ClassMember__Group__2__Impl rule__ClassMember__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ClassMember__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1250:1: rule__ClassMember__Group__2__Impl : ( ( rule__ClassMember__NameAssignment_2 ) ) ;
    public final void rule__ClassMember__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1254:1: ( ( ( rule__ClassMember__NameAssignment_2 ) ) )
            // InternalBug360834TestLanguage.g:1255:1: ( ( rule__ClassMember__NameAssignment_2 ) )
            {
            // InternalBug360834TestLanguage.g:1255:1: ( ( rule__ClassMember__NameAssignment_2 ) )
            // InternalBug360834TestLanguage.g:1256:2: ( rule__ClassMember__NameAssignment_2 )
            {
             before(grammarAccess.getClassMemberAccess().getNameAssignment_2()); 
            // InternalBug360834TestLanguage.g:1257:2: ( rule__ClassMember__NameAssignment_2 )
            // InternalBug360834TestLanguage.g:1257:3: rule__ClassMember__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1265:1: rule__ClassMember__Group__3 : rule__ClassMember__Group__3__Impl ;
    public final void rule__ClassMember__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1269:1: ( rule__ClassMember__Group__3__Impl )
            // InternalBug360834TestLanguage.g:1270:2: rule__ClassMember__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1276:1: rule__ClassMember__Group__3__Impl : ( ';' ) ;
    public final void rule__ClassMember__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1280:1: ( ( ';' ) )
            // InternalBug360834TestLanguage.g:1281:1: ( ';' )
            {
            // InternalBug360834TestLanguage.g:1281:1: ( ';' )
            // InternalBug360834TestLanguage.g:1282:2: ';'
            {
             before(grammarAccess.getClassMemberAccess().getSemicolonKeyword_3()); 
            match(input,17,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1292:1: rule__UnorderedModifiers__Group__0 : rule__UnorderedModifiers__Group__0__Impl rule__UnorderedModifiers__Group__1 ;
    public final void rule__UnorderedModifiers__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1296:1: ( rule__UnorderedModifiers__Group__0__Impl rule__UnorderedModifiers__Group__1 )
            // InternalBug360834TestLanguage.g:1297:2: rule__UnorderedModifiers__Group__0__Impl rule__UnorderedModifiers__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__UnorderedModifiers__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1304:1: rule__UnorderedModifiers__Group__0__Impl : ( () ) ;
    public final void rule__UnorderedModifiers__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1308:1: ( ( () ) )
            // InternalBug360834TestLanguage.g:1309:1: ( () )
            {
            // InternalBug360834TestLanguage.g:1309:1: ( () )
            // InternalBug360834TestLanguage.g:1310:2: ()
            {
             before(grammarAccess.getUnorderedModifiersAccess().getModifiersAction_0()); 
            // InternalBug360834TestLanguage.g:1311:2: ()
            // InternalBug360834TestLanguage.g:1311:3: 
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
    // InternalBug360834TestLanguage.g:1319:1: rule__UnorderedModifiers__Group__1 : rule__UnorderedModifiers__Group__1__Impl ;
    public final void rule__UnorderedModifiers__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1323:1: ( rule__UnorderedModifiers__Group__1__Impl )
            // InternalBug360834TestLanguage.g:1324:2: rule__UnorderedModifiers__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1330:1: rule__UnorderedModifiers__Group__1__Impl : ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) ) ;
    public final void rule__UnorderedModifiers__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1334:1: ( ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) ) )
            // InternalBug360834TestLanguage.g:1335:1: ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) )
            {
            // InternalBug360834TestLanguage.g:1335:1: ( ( rule__UnorderedModifiers__UnorderedGroup_1 ) )
            // InternalBug360834TestLanguage.g:1336:2: ( rule__UnorderedModifiers__UnorderedGroup_1 )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1()); 
            // InternalBug360834TestLanguage.g:1337:2: ( rule__UnorderedModifiers__UnorderedGroup_1 )
            // InternalBug360834TestLanguage.g:1337:3: rule__UnorderedModifiers__UnorderedGroup_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1346:1: rule__UnorderedModifiers__UnorderedGroup_1 : ( rule__UnorderedModifiers__UnorderedGroup_1__0 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
        	
        try {
            // InternalBug360834TestLanguage.g:1351:1: ( ( rule__UnorderedModifiers__UnorderedGroup_1__0 )? )
            // InternalBug360834TestLanguage.g:1352:2: ( rule__UnorderedModifiers__UnorderedGroup_1__0 )?
            {
            // InternalBug360834TestLanguage.g:1352:2: ( rule__UnorderedModifiers__UnorderedGroup_1__0 )?
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
                    // InternalBug360834TestLanguage.g:1352:2: rule__UnorderedModifiers__UnorderedGroup_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1360:1: rule__UnorderedModifiers__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) ) ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug360834TestLanguage.g:1365:1: ( ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) ) )
            // InternalBug360834TestLanguage.g:1366:3: ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) )
            {
            // InternalBug360834TestLanguage.g:1366:3: ( ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) ) | ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) ) )
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
                    // InternalBug360834TestLanguage.g:1367:3: ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) )
                    {
                    // InternalBug360834TestLanguage.g:1367:3: ({...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) ) )
                    // InternalBug360834TestLanguage.g:1368:4: {...}? => ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0)");
                    }
                    // InternalBug360834TestLanguage.g:1368:114: ( ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) ) )
                    // InternalBug360834TestLanguage.g:1369:5: ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0);
                    				

                    					selected = true;
                    				
                    // InternalBug360834TestLanguage.g:1375:5: ( ( rule__UnorderedModifiers__FinalAssignment_1_0 ) )
                    // InternalBug360834TestLanguage.g:1376:6: ( rule__UnorderedModifiers__FinalAssignment_1_0 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getFinalAssignment_1_0()); 
                    // InternalBug360834TestLanguage.g:1377:6: ( rule__UnorderedModifiers__FinalAssignment_1_0 )
                    // InternalBug360834TestLanguage.g:1377:7: rule__UnorderedModifiers__FinalAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalBug360834TestLanguage.g:1382:3: ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) )
                    {
                    // InternalBug360834TestLanguage.g:1382:3: ({...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) ) )
                    // InternalBug360834TestLanguage.g:1383:4: {...}? => ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1)");
                    }
                    // InternalBug360834TestLanguage.g:1383:114: ( ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) ) )
                    // InternalBug360834TestLanguage.g:1384:5: ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1);
                    				

                    					selected = true;
                    				
                    // InternalBug360834TestLanguage.g:1390:5: ( ( rule__UnorderedModifiers__AbstractAssignment_1_1 ) )
                    // InternalBug360834TestLanguage.g:1391:6: ( rule__UnorderedModifiers__AbstractAssignment_1_1 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getAbstractAssignment_1_1()); 
                    // InternalBug360834TestLanguage.g:1392:6: ( rule__UnorderedModifiers__AbstractAssignment_1_1 )
                    // InternalBug360834TestLanguage.g:1392:7: rule__UnorderedModifiers__AbstractAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalBug360834TestLanguage.g:1397:3: ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) )
                    {
                    // InternalBug360834TestLanguage.g:1397:3: ({...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) ) )
                    // InternalBug360834TestLanguage.g:1398:4: {...}? => ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2)");
                    }
                    // InternalBug360834TestLanguage.g:1398:114: ( ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) ) )
                    // InternalBug360834TestLanguage.g:1399:5: ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2);
                    				

                    					selected = true;
                    				
                    // InternalBug360834TestLanguage.g:1405:5: ( ( rule__UnorderedModifiers__ExternAssignment_1_2 ) )
                    // InternalBug360834TestLanguage.g:1406:6: ( rule__UnorderedModifiers__ExternAssignment_1_2 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getExternAssignment_1_2()); 
                    // InternalBug360834TestLanguage.g:1407:6: ( rule__UnorderedModifiers__ExternAssignment_1_2 )
                    // InternalBug360834TestLanguage.g:1407:7: rule__UnorderedModifiers__ExternAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalBug360834TestLanguage.g:1412:3: ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) )
                    {
                    // InternalBug360834TestLanguage.g:1412:3: ({...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) ) )
                    // InternalBug360834TestLanguage.g:1413:4: {...}? => ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                        throw new FailedPredicateException(input, "rule__UnorderedModifiers__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3)");
                    }
                    // InternalBug360834TestLanguage.g:1413:114: ( ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) ) )
                    // InternalBug360834TestLanguage.g:1414:5: ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3);
                    				

                    					selected = true;
                    				
                    // InternalBug360834TestLanguage.g:1420:5: ( ( rule__UnorderedModifiers__VisibilityAssignment_1_3 ) )
                    // InternalBug360834TestLanguage.g:1421:6: ( rule__UnorderedModifiers__VisibilityAssignment_1_3 )
                    {
                     before(grammarAccess.getUnorderedModifiersAccess().getVisibilityAssignment_1_3()); 
                    // InternalBug360834TestLanguage.g:1422:6: ( rule__UnorderedModifiers__VisibilityAssignment_1_3 )
                    // InternalBug360834TestLanguage.g:1422:7: rule__UnorderedModifiers__VisibilityAssignment_1_3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1435:1: rule__UnorderedModifiers__UnorderedGroup_1__0 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__1 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1439:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__1 )? )
            // InternalBug360834TestLanguage.g:1440:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalBug360834TestLanguage.g:1441:2: ( rule__UnorderedModifiers__UnorderedGroup_1__1 )?
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
                    // InternalBug360834TestLanguage.g:1441:2: rule__UnorderedModifiers__UnorderedGroup_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1447:1: rule__UnorderedModifiers__UnorderedGroup_1__1 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__2 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1451:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__2 )? )
            // InternalBug360834TestLanguage.g:1452:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalBug360834TestLanguage.g:1453:2: ( rule__UnorderedModifiers__UnorderedGroup_1__2 )?
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
                    // InternalBug360834TestLanguage.g:1453:2: rule__UnorderedModifiers__UnorderedGroup_1__2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1459:1: rule__UnorderedModifiers__UnorderedGroup_1__2 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__3 )? ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1463:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__3 )? )
            // InternalBug360834TestLanguage.g:1464:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl ( rule__UnorderedModifiers__UnorderedGroup_1__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__UnorderedModifiers__UnorderedGroup_1__Impl();

            state._fsp--;

            // InternalBug360834TestLanguage.g:1465:2: ( rule__UnorderedModifiers__UnorderedGroup_1__3 )?
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
                    // InternalBug360834TestLanguage.g:1465:2: rule__UnorderedModifiers__UnorderedGroup_1__3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1471:1: rule__UnorderedModifiers__UnorderedGroup_1__3 : rule__UnorderedModifiers__UnorderedGroup_1__Impl ;
    public final void rule__UnorderedModifiers__UnorderedGroup_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1475:1: ( rule__UnorderedModifiers__UnorderedGroup_1__Impl )
            // InternalBug360834TestLanguage.g:1476:2: rule__UnorderedModifiers__UnorderedGroup_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1483:1: rule__Model__ElementAssignment_0_1 : ( ruleAlternative ) ;
    public final void rule__Model__ElementAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1487:1: ( ( ruleAlternative ) )
            // InternalBug360834TestLanguage.g:1488:2: ( ruleAlternative )
            {
            // InternalBug360834TestLanguage.g:1488:2: ( ruleAlternative )
            // InternalBug360834TestLanguage.g:1489:3: ruleAlternative
            {
             before(grammarAccess.getModelAccess().getElementAlternativeParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1498:1: rule__Model__ElementAssignment_1_1 : ( ruleUnordered ) ;
    public final void rule__Model__ElementAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1502:1: ( ( ruleUnordered ) )
            // InternalBug360834TestLanguage.g:1503:2: ( ruleUnordered )
            {
            // InternalBug360834TestLanguage.g:1503:2: ( ruleUnordered )
            // InternalBug360834TestLanguage.g:1504:3: ruleUnordered
            {
             before(grammarAccess.getModelAccess().getElementUnorderedParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1513:1: rule__Alternative__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__Alternative__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1517:1: ( ( ruleFQN ) )
            // InternalBug360834TestLanguage.g:1518:2: ( ruleFQN )
            {
            // InternalBug360834TestLanguage.g:1518:2: ( ruleFQN )
            // InternalBug360834TestLanguage.g:1519:3: ruleFQN
            {
             before(grammarAccess.getAlternativeAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1528:1: rule__Alternative__RootDeclarationAssignment_3 : ( ruleRecursiveClassDeclaration ) ;
    public final void rule__Alternative__RootDeclarationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1532:1: ( ( ruleRecursiveClassDeclaration ) )
            // InternalBug360834TestLanguage.g:1533:2: ( ruleRecursiveClassDeclaration )
            {
            // InternalBug360834TestLanguage.g:1533:2: ( ruleRecursiveClassDeclaration )
            // InternalBug360834TestLanguage.g:1534:3: ruleRecursiveClassDeclaration
            {
             before(grammarAccess.getAlternativeAccess().getRootDeclarationRecursiveClassDeclarationParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1543:1: rule__RecursiveClassDeclaration__ModifiersAssignment_0 : ( ruleAlternativeClassModifiers ) ;
    public final void rule__RecursiveClassDeclaration__ModifiersAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1547:1: ( ( ruleAlternativeClassModifiers ) )
            // InternalBug360834TestLanguage.g:1548:2: ( ruleAlternativeClassModifiers )
            {
            // InternalBug360834TestLanguage.g:1548:2: ( ruleAlternativeClassModifiers )
            // InternalBug360834TestLanguage.g:1549:3: ruleAlternativeClassModifiers
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAlternativeClassModifiersParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1558:1: rule__RecursiveClassDeclaration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__RecursiveClassDeclaration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1562:1: ( ( RULE_ID ) )
            // InternalBug360834TestLanguage.g:1563:2: ( RULE_ID )
            {
            // InternalBug360834TestLanguage.g:1563:2: ( RULE_ID )
            // InternalBug360834TestLanguage.g:1564:3: RULE_ID
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1573:1: rule__RecursiveClassDeclaration__MembersAssignment_4 : ( ruleRecursiveClassDeclaration ) ;
    public final void rule__RecursiveClassDeclaration__MembersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1577:1: ( ( ruleRecursiveClassDeclaration ) )
            // InternalBug360834TestLanguage.g:1578:2: ( ruleRecursiveClassDeclaration )
            {
            // InternalBug360834TestLanguage.g:1578:2: ( ruleRecursiveClassDeclaration )
            // InternalBug360834TestLanguage.g:1579:3: ruleRecursiveClassDeclaration
            {
             before(grammarAccess.getRecursiveClassDeclarationAccess().getMembersRecursiveClassDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1588:1: rule__AlternativeClassModifiers__FinalAssignment_1_0 : ( ( 'final' ) ) ;
    public final void rule__AlternativeClassModifiers__FinalAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1592:1: ( ( ( 'final' ) ) )
            // InternalBug360834TestLanguage.g:1593:2: ( ( 'final' ) )
            {
            // InternalBug360834TestLanguage.g:1593:2: ( ( 'final' ) )
            // InternalBug360834TestLanguage.g:1594:3: ( 'final' )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            // InternalBug360834TestLanguage.g:1595:3: ( 'final' )
            // InternalBug360834TestLanguage.g:1596:4: 'final'
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1607:1: rule__AlternativeClassModifiers__AbstractAssignment_1_1 : ( ( 'abstract' ) ) ;
    public final void rule__AlternativeClassModifiers__AbstractAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1611:1: ( ( ( 'abstract' ) ) )
            // InternalBug360834TestLanguage.g:1612:2: ( ( 'abstract' ) )
            {
            // InternalBug360834TestLanguage.g:1612:2: ( ( 'abstract' ) )
            // InternalBug360834TestLanguage.g:1613:3: ( 'abstract' )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            // InternalBug360834TestLanguage.g:1614:3: ( 'abstract' )
            // InternalBug360834TestLanguage.g:1615:4: 'abstract'
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1626:1: rule__AlternativeClassModifiers__ExternAssignment_1_2 : ( ( 'extern' ) ) ;
    public final void rule__AlternativeClassModifiers__ExternAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1630:1: ( ( ( 'extern' ) ) )
            // InternalBug360834TestLanguage.g:1631:2: ( ( 'extern' ) )
            {
            // InternalBug360834TestLanguage.g:1631:2: ( ( 'extern' ) )
            // InternalBug360834TestLanguage.g:1632:3: ( 'extern' )
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0()); 
            // InternalBug360834TestLanguage.g:1633:3: ( 'extern' )
            // InternalBug360834TestLanguage.g:1634:4: 'extern'
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1645:1: rule__AlternativeClassModifiers__VisibilityAssignment_1_3 : ( ruleVisibility ) ;
    public final void rule__AlternativeClassModifiers__VisibilityAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1649:1: ( ( ruleVisibility ) )
            // InternalBug360834TestLanguage.g:1650:2: ( ruleVisibility )
            {
            // InternalBug360834TestLanguage.g:1650:2: ( ruleVisibility )
            // InternalBug360834TestLanguage.g:1651:3: ruleVisibility
            {
             before(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1660:1: rule__Unordered__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__Unordered__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1664:1: ( ( ruleFQN ) )
            // InternalBug360834TestLanguage.g:1665:2: ( ruleFQN )
            {
            // InternalBug360834TestLanguage.g:1665:2: ( ruleFQN )
            // InternalBug360834TestLanguage.g:1666:3: ruleFQN
            {
             before(grammarAccess.getUnorderedAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1675:1: rule__Unordered__RootDeclarationAssignment_3 : ( ruleSimpleClassDeclaration ) ;
    public final void rule__Unordered__RootDeclarationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1679:1: ( ( ruleSimpleClassDeclaration ) )
            // InternalBug360834TestLanguage.g:1680:2: ( ruleSimpleClassDeclaration )
            {
            // InternalBug360834TestLanguage.g:1680:2: ( ruleSimpleClassDeclaration )
            // InternalBug360834TestLanguage.g:1681:3: ruleSimpleClassDeclaration
            {
             before(grammarAccess.getUnorderedAccess().getRootDeclarationSimpleClassDeclarationParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1690:1: rule__SimpleClassDeclaration__ModifiersAssignment_0 : ( ruleUnorderedModifiers ) ;
    public final void rule__SimpleClassDeclaration__ModifiersAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1694:1: ( ( ruleUnorderedModifiers ) )
            // InternalBug360834TestLanguage.g:1695:2: ( ruleUnorderedModifiers )
            {
            // InternalBug360834TestLanguage.g:1695:2: ( ruleUnorderedModifiers )
            // InternalBug360834TestLanguage.g:1696:3: ruleUnorderedModifiers
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getModifiersUnorderedModifiersParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1705:1: rule__SimpleClassDeclaration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleClassDeclaration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1709:1: ( ( RULE_ID ) )
            // InternalBug360834TestLanguage.g:1710:2: ( RULE_ID )
            {
            // InternalBug360834TestLanguage.g:1710:2: ( RULE_ID )
            // InternalBug360834TestLanguage.g:1711:3: RULE_ID
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1720:1: rule__SimpleClassDeclaration__MembersAssignment_4 : ( ruleClassMember ) ;
    public final void rule__SimpleClassDeclaration__MembersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1724:1: ( ( ruleClassMember ) )
            // InternalBug360834TestLanguage.g:1725:2: ( ruleClassMember )
            {
            // InternalBug360834TestLanguage.g:1725:2: ( ruleClassMember )
            // InternalBug360834TestLanguage.g:1726:3: ruleClassMember
            {
             before(grammarAccess.getSimpleClassDeclarationAccess().getMembersClassMemberParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1735:1: rule__ClassMember__ModifiersAssignment_0 : ( ruleUnorderedModifiers ) ;
    public final void rule__ClassMember__ModifiersAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1739:1: ( ( ruleUnorderedModifiers ) )
            // InternalBug360834TestLanguage.g:1740:2: ( ruleUnorderedModifiers )
            {
            // InternalBug360834TestLanguage.g:1740:2: ( ruleUnorderedModifiers )
            // InternalBug360834TestLanguage.g:1741:3: ruleUnorderedModifiers
            {
             before(grammarAccess.getClassMemberAccess().getModifiersUnorderedModifiersParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalBug360834TestLanguage.g:1750:1: rule__ClassMember__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ClassMember__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1754:1: ( ( RULE_ID ) )
            // InternalBug360834TestLanguage.g:1755:2: ( RULE_ID )
            {
            // InternalBug360834TestLanguage.g:1755:2: ( RULE_ID )
            // InternalBug360834TestLanguage.g:1756:3: RULE_ID
            {
             before(grammarAccess.getClassMemberAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1765:1: rule__UnorderedModifiers__FinalAssignment_1_0 : ( ( 'final' ) ) ;
    public final void rule__UnorderedModifiers__FinalAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1769:1: ( ( ( 'final' ) ) )
            // InternalBug360834TestLanguage.g:1770:2: ( ( 'final' ) )
            {
            // InternalBug360834TestLanguage.g:1770:2: ( ( 'final' ) )
            // InternalBug360834TestLanguage.g:1771:3: ( 'final' )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            // InternalBug360834TestLanguage.g:1772:3: ( 'final' )
            // InternalBug360834TestLanguage.g:1773:4: 'final'
            {
             before(grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1784:1: rule__UnorderedModifiers__AbstractAssignment_1_1 : ( ( 'abstract' ) ) ;
    public final void rule__UnorderedModifiers__AbstractAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1788:1: ( ( ( 'abstract' ) ) )
            // InternalBug360834TestLanguage.g:1789:2: ( ( 'abstract' ) )
            {
            // InternalBug360834TestLanguage.g:1789:2: ( ( 'abstract' ) )
            // InternalBug360834TestLanguage.g:1790:3: ( 'abstract' )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            // InternalBug360834TestLanguage.g:1791:3: ( 'abstract' )
            // InternalBug360834TestLanguage.g:1792:4: 'abstract'
            {
             before(grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1803:1: rule__UnorderedModifiers__ExternAssignment_1_2 : ( ( 'extern' ) ) ;
    public final void rule__UnorderedModifiers__ExternAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1807:1: ( ( ( 'extern' ) ) )
            // InternalBug360834TestLanguage.g:1808:2: ( ( 'extern' ) )
            {
            // InternalBug360834TestLanguage.g:1808:2: ( ( 'extern' ) )
            // InternalBug360834TestLanguage.g:1809:3: ( 'extern' )
            {
             before(grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0()); 
            // InternalBug360834TestLanguage.g:1810:3: ( 'extern' )
            // InternalBug360834TestLanguage.g:1811:4: 'extern'
            {
             before(grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
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
    // InternalBug360834TestLanguage.g:1822:1: rule__UnorderedModifiers__VisibilityAssignment_1_3 : ( ruleVisibility ) ;
    public final void rule__UnorderedModifiers__VisibilityAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug360834TestLanguage.g:1826:1: ( ( ruleVisibility ) )
            // InternalBug360834TestLanguage.g:1827:2: ( ruleVisibility )
            {
            // InternalBug360834TestLanguage.g:1827:2: ( ruleVisibility )
            // InternalBug360834TestLanguage.g:1828:3: ruleVisibility
            {
             before(grammarAccess.getUnorderedModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000003803800L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000003A03800L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000003803802L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    }


}
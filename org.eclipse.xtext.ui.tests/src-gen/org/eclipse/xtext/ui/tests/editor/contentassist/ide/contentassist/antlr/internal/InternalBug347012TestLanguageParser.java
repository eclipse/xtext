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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug347012TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug347012TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LT", "RULE_ID", "RULE_NUMBER", "RULE_STRING", "RULE_IDPLAINCHAR", "RULE_DIGIT", "RULE_WS", "RULE_ESCAPE", "RULE_HEX", "';'", "'.'", "'package'", "'{'", "'}'", "'public'", "'class'", "'var'", "','", "':'", "'='", "'true'", "'false'", "'private'"
    };
    public static final int RULE_HEX=12;
    public static final int RULE_STRING=7;
    public static final int RULE_IDPLAINCHAR=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ESCAPE=11;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int RULE_DIGIT=9;
    public static final int RULE_NUMBER=6;
    public static final int RULE_LT=4;
    public static final int T__26=26;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalBug347012TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug347012TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug347012TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug347012TestLanguage.g"; }


    	private Bug347012TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug347012TestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleMyProgram"
    // InternalBug347012TestLanguage.g:53:1: entryRuleMyProgram : ruleMyProgram EOF ;
    public final void entryRuleMyProgram() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:54:1: ( ruleMyProgram EOF )
            // InternalBug347012TestLanguage.g:55:1: ruleMyProgram EOF
            {
             before(grammarAccess.getMyProgramRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyProgram();

            state._fsp--;

             after(grammarAccess.getMyProgramRule()); 
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
    // $ANTLR end "entryRuleMyProgram"


    // $ANTLR start "ruleMyProgram"
    // InternalBug347012TestLanguage.g:62:1: ruleMyProgram : ( ( rule__MyProgram__Group__0 ) ) ;
    public final void ruleMyProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:66:2: ( ( ( rule__MyProgram__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:67:2: ( ( rule__MyProgram__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:67:2: ( ( rule__MyProgram__Group__0 ) )
            // InternalBug347012TestLanguage.g:68:3: ( rule__MyProgram__Group__0 )
            {
             before(grammarAccess.getMyProgramAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:69:3: ( rule__MyProgram__Group__0 )
            // InternalBug347012TestLanguage.g:69:4: rule__MyProgram__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyProgramAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyProgram"


    // $ANTLR start "entryRuleIdentifier"
    // InternalBug347012TestLanguage.g:78:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:79:1: ( ruleIdentifier EOF )
            // InternalBug347012TestLanguage.g:80:1: ruleIdentifier EOF
            {
             before(grammarAccess.getIdentifierRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getIdentifierRule()); 
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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalBug347012TestLanguage.g:87:1: ruleIdentifier : ( ( rule__Identifier__NameAssignment ) ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:91:2: ( ( ( rule__Identifier__NameAssignment ) ) )
            // InternalBug347012TestLanguage.g:92:2: ( ( rule__Identifier__NameAssignment ) )
            {
            // InternalBug347012TestLanguage.g:92:2: ( ( rule__Identifier__NameAssignment ) )
            // InternalBug347012TestLanguage.g:93:3: ( rule__Identifier__NameAssignment )
            {
             before(grammarAccess.getIdentifierAccess().getNameAssignment()); 
            // InternalBug347012TestLanguage.g:94:3: ( rule__Identifier__NameAssignment )
            // InternalBug347012TestLanguage.g:94:4: rule__Identifier__NameAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Identifier__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIdentifierAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleFQN"
    // InternalBug347012TestLanguage.g:103:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:104:1: ( ruleFQN EOF )
            // InternalBug347012TestLanguage.g:105:1: ruleFQN EOF
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
    // InternalBug347012TestLanguage.g:112:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:116:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:117:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:117:2: ( ( rule__FQN__Group__0 ) )
            // InternalBug347012TestLanguage.g:118:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:119:3: ( rule__FQN__Group__0 )
            // InternalBug347012TestLanguage.g:119:4: rule__FQN__Group__0
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


    // $ANTLR start "entryRuleVirtualSemi"
    // InternalBug347012TestLanguage.g:128:1: entryRuleVirtualSemi : ruleVirtualSemi EOF ;
    public final void entryRuleVirtualSemi() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:129:1: ( ruleVirtualSemi EOF )
            // InternalBug347012TestLanguage.g:130:1: ruleVirtualSemi EOF
            {
             before(grammarAccess.getVirtualSemiRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleVirtualSemi();

            state._fsp--;

             after(grammarAccess.getVirtualSemiRule()); 
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
    // $ANTLR end "entryRuleVirtualSemi"


    // $ANTLR start "ruleVirtualSemi"
    // InternalBug347012TestLanguage.g:137:1: ruleVirtualSemi : ( ( rule__VirtualSemi__Alternatives ) ) ;
    public final void ruleVirtualSemi() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:141:2: ( ( ( rule__VirtualSemi__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:142:2: ( ( rule__VirtualSemi__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:142:2: ( ( rule__VirtualSemi__Alternatives ) )
            // InternalBug347012TestLanguage.g:143:3: ( rule__VirtualSemi__Alternatives )
            {
             before(grammarAccess.getVirtualSemiAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:144:3: ( rule__VirtualSemi__Alternatives )
            // InternalBug347012TestLanguage.g:144:4: rule__VirtualSemi__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__VirtualSemi__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVirtualSemiAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVirtualSemi"


    // $ANTLR start "entryRuleLiteral"
    // InternalBug347012TestLanguage.g:153:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:154:1: ( ruleLiteral EOF )
            // InternalBug347012TestLanguage.g:155:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalBug347012TestLanguage.g:162:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:166:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:167:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:167:2: ( ( rule__Literal__Alternatives ) )
            // InternalBug347012TestLanguage.g:168:3: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:169:3: ( rule__Literal__Alternatives )
            // InternalBug347012TestLanguage.g:169:4: rule__Literal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Literal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleMyPrimary"
    // InternalBug347012TestLanguage.g:178:1: entryRuleMyPrimary : ruleMyPrimary EOF ;
    public final void entryRuleMyPrimary() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:179:1: ( ruleMyPrimary EOF )
            // InternalBug347012TestLanguage.g:180:1: ruleMyPrimary EOF
            {
             before(grammarAccess.getMyPrimaryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyPrimary();

            state._fsp--;

             after(grammarAccess.getMyPrimaryRule()); 
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
    // $ANTLR end "entryRuleMyPrimary"


    // $ANTLR start "ruleMyPrimary"
    // InternalBug347012TestLanguage.g:187:1: ruleMyPrimary : ( ( rule__MyPrimary__Alternatives ) ) ;
    public final void ruleMyPrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:191:2: ( ( ( rule__MyPrimary__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:192:2: ( ( rule__MyPrimary__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:192:2: ( ( rule__MyPrimary__Alternatives ) )
            // InternalBug347012TestLanguage.g:193:3: ( rule__MyPrimary__Alternatives )
            {
             before(grammarAccess.getMyPrimaryAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:194:3: ( rule__MyPrimary__Alternatives )
            // InternalBug347012TestLanguage.g:194:4: rule__MyPrimary__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPrimary__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMyPrimaryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyPrimary"


    // $ANTLR start "entryRuleMyPackage"
    // InternalBug347012TestLanguage.g:203:1: entryRuleMyPackage : ruleMyPackage EOF ;
    public final void entryRuleMyPackage() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:204:1: ( ruleMyPackage EOF )
            // InternalBug347012TestLanguage.g:205:1: ruleMyPackage EOF
            {
             before(grammarAccess.getMyPackageRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyPackage();

            state._fsp--;

             after(grammarAccess.getMyPackageRule()); 
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
    // $ANTLR end "entryRuleMyPackage"


    // $ANTLR start "ruleMyPackage"
    // InternalBug347012TestLanguage.g:212:1: ruleMyPackage : ( ( rule__MyPackage__Group__0 ) ) ;
    public final void ruleMyPackage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:216:2: ( ( ( rule__MyPackage__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:217:2: ( ( rule__MyPackage__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:217:2: ( ( rule__MyPackage__Group__0 ) )
            // InternalBug347012TestLanguage.g:218:3: ( rule__MyPackage__Group__0 )
            {
             before(grammarAccess.getMyPackageAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:219:3: ( rule__MyPackage__Group__0 )
            // InternalBug347012TestLanguage.g:219:4: rule__MyPackage__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyPackageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyPackage"


    // $ANTLR start "entryRuleMyClass"
    // InternalBug347012TestLanguage.g:228:1: entryRuleMyClass : ruleMyClass EOF ;
    public final void entryRuleMyClass() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:229:1: ( ruleMyClass EOF )
            // InternalBug347012TestLanguage.g:230:1: ruleMyClass EOF
            {
             before(grammarAccess.getMyClassRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyClass();

            state._fsp--;

             after(grammarAccess.getMyClassRule()); 
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
    // $ANTLR end "entryRuleMyClass"


    // $ANTLR start "ruleMyClass"
    // InternalBug347012TestLanguage.g:237:1: ruleMyClass : ( ( rule__MyClass__Group__0 ) ) ;
    public final void ruleMyClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:241:2: ( ( ( rule__MyClass__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:242:2: ( ( rule__MyClass__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:242:2: ( ( rule__MyClass__Group__0 ) )
            // InternalBug347012TestLanguage.g:243:3: ( rule__MyClass__Group__0 )
            {
             before(grammarAccess.getMyClassAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:244:3: ( rule__MyClass__Group__0 )
            // InternalBug347012TestLanguage.g:244:4: rule__MyClass__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyClass"


    // $ANTLR start "entryRuleMyAttribute"
    // InternalBug347012TestLanguage.g:253:1: entryRuleMyAttribute : ruleMyAttribute EOF ;
    public final void entryRuleMyAttribute() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:254:1: ( ruleMyAttribute EOF )
            // InternalBug347012TestLanguage.g:255:1: ruleMyAttribute EOF
            {
             before(grammarAccess.getMyAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyAttribute();

            state._fsp--;

             after(grammarAccess.getMyAttributeRule()); 
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
    // $ANTLR end "entryRuleMyAttribute"


    // $ANTLR start "ruleMyAttribute"
    // InternalBug347012TestLanguage.g:262:1: ruleMyAttribute : ( ( rule__MyAttribute__Alternatives ) ) ;
    public final void ruleMyAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:266:2: ( ( ( rule__MyAttribute__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:267:2: ( ( rule__MyAttribute__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:267:2: ( ( rule__MyAttribute__Alternatives ) )
            // InternalBug347012TestLanguage.g:268:3: ( rule__MyAttribute__Alternatives )
            {
             before(grammarAccess.getMyAttributeAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:269:3: ( rule__MyAttribute__Alternatives )
            // InternalBug347012TestLanguage.g:269:4: rule__MyAttribute__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyAttribute__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMyAttributeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyAttribute"


    // $ANTLR start "entryRuleMyAttributes"
    // InternalBug347012TestLanguage.g:278:1: entryRuleMyAttributes : ruleMyAttributes EOF ;
    public final void entryRuleMyAttributes() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:279:1: ( ruleMyAttributes EOF )
            // InternalBug347012TestLanguage.g:280:1: ruleMyAttributes EOF
            {
             before(grammarAccess.getMyAttributesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyAttributes();

            state._fsp--;

             after(grammarAccess.getMyAttributesRule()); 
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
    // $ANTLR end "entryRuleMyAttributes"


    // $ANTLR start "ruleMyAttributes"
    // InternalBug347012TestLanguage.g:287:1: ruleMyAttributes : ( ( rule__MyAttributes__Group__0 ) ) ;
    public final void ruleMyAttributes() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:291:2: ( ( ( rule__MyAttributes__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:292:2: ( ( rule__MyAttributes__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:292:2: ( ( rule__MyAttributes__Group__0 ) )
            // InternalBug347012TestLanguage.g:293:3: ( rule__MyAttributes__Group__0 )
            {
             before(grammarAccess.getMyAttributesAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:294:3: ( rule__MyAttributes__Group__0 )
            // InternalBug347012TestLanguage.g:294:4: rule__MyAttributes__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyAttributes__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyAttributesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyAttributes"


    // $ANTLR start "entryRuleMyField"
    // InternalBug347012TestLanguage.g:303:1: entryRuleMyField : ruleMyField EOF ;
    public final void entryRuleMyField() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:304:1: ( ruleMyField EOF )
            // InternalBug347012TestLanguage.g:305:1: ruleMyField EOF
            {
             before(grammarAccess.getMyFieldRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyField();

            state._fsp--;

             after(grammarAccess.getMyFieldRule()); 
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
    // $ANTLR end "entryRuleMyField"


    // $ANTLR start "ruleMyField"
    // InternalBug347012TestLanguage.g:312:1: ruleMyField : ( ( rule__MyField__Group__0 ) ) ;
    public final void ruleMyField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:316:2: ( ( ( rule__MyField__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:317:2: ( ( rule__MyField__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:317:2: ( ( rule__MyField__Group__0 ) )
            // InternalBug347012TestLanguage.g:318:3: ( rule__MyField__Group__0 )
            {
             before(grammarAccess.getMyFieldAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:319:3: ( rule__MyField__Group__0 )
            // InternalBug347012TestLanguage.g:319:4: rule__MyField__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyField"


    // $ANTLR start "entryRuleMyBinding"
    // InternalBug347012TestLanguage.g:328:1: entryRuleMyBinding : ruleMyBinding EOF ;
    public final void entryRuleMyBinding() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:329:1: ( ruleMyBinding EOF )
            // InternalBug347012TestLanguage.g:330:1: ruleMyBinding EOF
            {
             before(grammarAccess.getMyBindingRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMyBinding();

            state._fsp--;

             after(grammarAccess.getMyBindingRule()); 
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
    // $ANTLR end "entryRuleMyBinding"


    // $ANTLR start "ruleMyBinding"
    // InternalBug347012TestLanguage.g:337:1: ruleMyBinding : ( ( rule__MyBinding__Group__0 ) ) ;
    public final void ruleMyBinding() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:341:2: ( ( ( rule__MyBinding__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:342:2: ( ( rule__MyBinding__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:342:2: ( ( rule__MyBinding__Group__0 ) )
            // InternalBug347012TestLanguage.g:343:3: ( rule__MyBinding__Group__0 )
            {
             before(grammarAccess.getMyBindingAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:344:3: ( rule__MyBinding__Group__0 )
            // InternalBug347012TestLanguage.g:344:4: rule__MyBinding__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMyBindingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyBinding"


    // $ANTLR start "rule__VirtualSemi__Alternatives"
    // InternalBug347012TestLanguage.g:352:1: rule__VirtualSemi__Alternatives : ( ( ';' ) | ( RULE_LT ) );
    public final void rule__VirtualSemi__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:356:1: ( ( ';' ) | ( RULE_LT ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_LT) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug347012TestLanguage.g:357:2: ( ';' )
                    {
                    // InternalBug347012TestLanguage.g:357:2: ( ';' )
                    // InternalBug347012TestLanguage.g:358:3: ';'
                    {
                     before(grammarAccess.getVirtualSemiAccess().getSemicolonKeyword_0()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getVirtualSemiAccess().getSemicolonKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:363:2: ( RULE_LT )
                    {
                    // InternalBug347012TestLanguage.g:363:2: ( RULE_LT )
                    // InternalBug347012TestLanguage.g:364:3: RULE_LT
                    {
                     before(grammarAccess.getVirtualSemiAccess().getLTTerminalRuleCall_1()); 
                    match(input,RULE_LT,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getVirtualSemiAccess().getLTTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__VirtualSemi__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // InternalBug347012TestLanguage.g:373:1: rule__Literal__Alternatives : ( ( ( rule__Literal__NumAssignment_0 ) ) | ( ( rule__Literal__StrAssignment_1 ) ) | ( ( rule__Literal__BoolAssignment_2 ) ) | ( ( rule__Literal__BoolAssignment_3 ) ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:377:1: ( ( ( rule__Literal__NumAssignment_0 ) ) | ( ( rule__Literal__StrAssignment_1 ) ) | ( ( rule__Literal__BoolAssignment_2 ) ) | ( ( rule__Literal__BoolAssignment_3 ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt2=1;
                }
                break;
            case RULE_STRING:
                {
                alt2=2;
                }
                break;
            case 24:
                {
                alt2=3;
                }
                break;
            case 25:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalBug347012TestLanguage.g:378:2: ( ( rule__Literal__NumAssignment_0 ) )
                    {
                    // InternalBug347012TestLanguage.g:378:2: ( ( rule__Literal__NumAssignment_0 ) )
                    // InternalBug347012TestLanguage.g:379:3: ( rule__Literal__NumAssignment_0 )
                    {
                     before(grammarAccess.getLiteralAccess().getNumAssignment_0()); 
                    // InternalBug347012TestLanguage.g:380:3: ( rule__Literal__NumAssignment_0 )
                    // InternalBug347012TestLanguage.g:380:4: rule__Literal__NumAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Literal__NumAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getNumAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:384:2: ( ( rule__Literal__StrAssignment_1 ) )
                    {
                    // InternalBug347012TestLanguage.g:384:2: ( ( rule__Literal__StrAssignment_1 ) )
                    // InternalBug347012TestLanguage.g:385:3: ( rule__Literal__StrAssignment_1 )
                    {
                     before(grammarAccess.getLiteralAccess().getStrAssignment_1()); 
                    // InternalBug347012TestLanguage.g:386:3: ( rule__Literal__StrAssignment_1 )
                    // InternalBug347012TestLanguage.g:386:4: rule__Literal__StrAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Literal__StrAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getStrAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug347012TestLanguage.g:390:2: ( ( rule__Literal__BoolAssignment_2 ) )
                    {
                    // InternalBug347012TestLanguage.g:390:2: ( ( rule__Literal__BoolAssignment_2 ) )
                    // InternalBug347012TestLanguage.g:391:3: ( rule__Literal__BoolAssignment_2 )
                    {
                     before(grammarAccess.getLiteralAccess().getBoolAssignment_2()); 
                    // InternalBug347012TestLanguage.g:392:3: ( rule__Literal__BoolAssignment_2 )
                    // InternalBug347012TestLanguage.g:392:4: rule__Literal__BoolAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Literal__BoolAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getBoolAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBug347012TestLanguage.g:396:2: ( ( rule__Literal__BoolAssignment_3 ) )
                    {
                    // InternalBug347012TestLanguage.g:396:2: ( ( rule__Literal__BoolAssignment_3 ) )
                    // InternalBug347012TestLanguage.g:397:3: ( rule__Literal__BoolAssignment_3 )
                    {
                     before(grammarAccess.getLiteralAccess().getBoolAssignment_3()); 
                    // InternalBug347012TestLanguage.g:398:3: ( rule__Literal__BoolAssignment_3 )
                    // InternalBug347012TestLanguage.g:398:4: rule__Literal__BoolAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Literal__BoolAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getBoolAssignment_3()); 

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
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__MyPrimary__Alternatives"
    // InternalBug347012TestLanguage.g:406:1: rule__MyPrimary__Alternatives : ( ( ruleLiteral ) | ( ruleIdentifier ) );
    public final void rule__MyPrimary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:410:1: ( ( ruleLiteral ) | ( ruleIdentifier ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_NUMBER && LA3_0<=RULE_STRING)||(LA3_0>=24 && LA3_0<=25)) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug347012TestLanguage.g:411:2: ( ruleLiteral )
                    {
                    // InternalBug347012TestLanguage.g:411:2: ( ruleLiteral )
                    // InternalBug347012TestLanguage.g:412:3: ruleLiteral
                    {
                     before(grammarAccess.getMyPrimaryAccess().getLiteralParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getMyPrimaryAccess().getLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:417:2: ( ruleIdentifier )
                    {
                    // InternalBug347012TestLanguage.g:417:2: ( ruleIdentifier )
                    // InternalBug347012TestLanguage.g:418:3: ruleIdentifier
                    {
                     before(grammarAccess.getMyPrimaryAccess().getIdentifierParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleIdentifier();

                    state._fsp--;

                     after(grammarAccess.getMyPrimaryAccess().getIdentifierParserRuleCall_1()); 

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
    // $ANTLR end "rule__MyPrimary__Alternatives"


    // $ANTLR start "rule__MyAttribute__Alternatives"
    // InternalBug347012TestLanguage.g:427:1: rule__MyAttribute__Alternatives : ( ( ( rule__MyAttribute__PUBLICAssignment_0 ) ) | ( ( rule__MyAttribute__PRIVATEAssignment_1 ) ) );
    public final void rule__MyAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:431:1: ( ( ( rule__MyAttribute__PUBLICAssignment_0 ) ) | ( ( rule__MyAttribute__PRIVATEAssignment_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            else if ( (LA4_0==26) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug347012TestLanguage.g:432:2: ( ( rule__MyAttribute__PUBLICAssignment_0 ) )
                    {
                    // InternalBug347012TestLanguage.g:432:2: ( ( rule__MyAttribute__PUBLICAssignment_0 ) )
                    // InternalBug347012TestLanguage.g:433:3: ( rule__MyAttribute__PUBLICAssignment_0 )
                    {
                     before(grammarAccess.getMyAttributeAccess().getPUBLICAssignment_0()); 
                    // InternalBug347012TestLanguage.g:434:3: ( rule__MyAttribute__PUBLICAssignment_0 )
                    // InternalBug347012TestLanguage.g:434:4: rule__MyAttribute__PUBLICAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MyAttribute__PUBLICAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMyAttributeAccess().getPUBLICAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:438:2: ( ( rule__MyAttribute__PRIVATEAssignment_1 ) )
                    {
                    // InternalBug347012TestLanguage.g:438:2: ( ( rule__MyAttribute__PRIVATEAssignment_1 ) )
                    // InternalBug347012TestLanguage.g:439:3: ( rule__MyAttribute__PRIVATEAssignment_1 )
                    {
                     before(grammarAccess.getMyAttributeAccess().getPRIVATEAssignment_1()); 
                    // InternalBug347012TestLanguage.g:440:3: ( rule__MyAttribute__PRIVATEAssignment_1 )
                    // InternalBug347012TestLanguage.g:440:4: rule__MyAttribute__PRIVATEAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MyAttribute__PRIVATEAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getMyAttributeAccess().getPRIVATEAssignment_1()); 

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
    // $ANTLR end "rule__MyAttribute__Alternatives"


    // $ANTLR start "rule__MyProgram__Group__0"
    // InternalBug347012TestLanguage.g:448:1: rule__MyProgram__Group__0 : rule__MyProgram__Group__0__Impl rule__MyProgram__Group__1 ;
    public final void rule__MyProgram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:452:1: ( rule__MyProgram__Group__0__Impl rule__MyProgram__Group__1 )
            // InternalBug347012TestLanguage.g:453:2: rule__MyProgram__Group__0__Impl rule__MyProgram__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__MyProgram__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__Group__1();

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
    // $ANTLR end "rule__MyProgram__Group__0"


    // $ANTLR start "rule__MyProgram__Group__0__Impl"
    // InternalBug347012TestLanguage.g:460:1: rule__MyProgram__Group__0__Impl : ( () ) ;
    public final void rule__MyProgram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:464:1: ( ( () ) )
            // InternalBug347012TestLanguage.g:465:1: ( () )
            {
            // InternalBug347012TestLanguage.g:465:1: ( () )
            // InternalBug347012TestLanguage.g:466:2: ()
            {
             before(grammarAccess.getMyProgramAccess().getMyProgramAction_0()); 
            // InternalBug347012TestLanguage.g:467:2: ()
            // InternalBug347012TestLanguage.g:467:3: 
            {
            }

             after(grammarAccess.getMyProgramAccess().getMyProgramAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__0__Impl"


    // $ANTLR start "rule__MyProgram__Group__1"
    // InternalBug347012TestLanguage.g:475:1: rule__MyProgram__Group__1 : rule__MyProgram__Group__1__Impl rule__MyProgram__Group__2 ;
    public final void rule__MyProgram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:479:1: ( rule__MyProgram__Group__1__Impl rule__MyProgram__Group__2 )
            // InternalBug347012TestLanguage.g:480:2: rule__MyProgram__Group__1__Impl rule__MyProgram__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__MyProgram__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__Group__2();

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
    // $ANTLR end "rule__MyProgram__Group__1"


    // $ANTLR start "rule__MyProgram__Group__1__Impl"
    // InternalBug347012TestLanguage.g:487:1: rule__MyProgram__Group__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyProgram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:491:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:492:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:492:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:493:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_1()); 
            // InternalBug347012TestLanguage.g:494:2: ( RULE_LT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_LT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:494:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__1__Impl"


    // $ANTLR start "rule__MyProgram__Group__2"
    // InternalBug347012TestLanguage.g:502:1: rule__MyProgram__Group__2 : rule__MyProgram__Group__2__Impl rule__MyProgram__Group__3 ;
    public final void rule__MyProgram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:506:1: ( rule__MyProgram__Group__2__Impl rule__MyProgram__Group__3 )
            // InternalBug347012TestLanguage.g:507:2: rule__MyProgram__Group__2__Impl rule__MyProgram__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MyProgram__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__Group__3();

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
    // $ANTLR end "rule__MyProgram__Group__2"


    // $ANTLR start "rule__MyProgram__Group__2__Impl"
    // InternalBug347012TestLanguage.g:514:1: rule__MyProgram__Group__2__Impl : ( ( rule__MyProgram__PackageAssignment_2 ) ) ;
    public final void rule__MyProgram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:518:1: ( ( ( rule__MyProgram__PackageAssignment_2 ) ) )
            // InternalBug347012TestLanguage.g:519:1: ( ( rule__MyProgram__PackageAssignment_2 ) )
            {
            // InternalBug347012TestLanguage.g:519:1: ( ( rule__MyProgram__PackageAssignment_2 ) )
            // InternalBug347012TestLanguage.g:520:2: ( rule__MyProgram__PackageAssignment_2 )
            {
             before(grammarAccess.getMyProgramAccess().getPackageAssignment_2()); 
            // InternalBug347012TestLanguage.g:521:2: ( rule__MyProgram__PackageAssignment_2 )
            // InternalBug347012TestLanguage.g:521:3: rule__MyProgram__PackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__PackageAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMyProgramAccess().getPackageAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__2__Impl"


    // $ANTLR start "rule__MyProgram__Group__3"
    // InternalBug347012TestLanguage.g:529:1: rule__MyProgram__Group__3 : rule__MyProgram__Group__3__Impl ;
    public final void rule__MyProgram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:533:1: ( rule__MyProgram__Group__3__Impl )
            // InternalBug347012TestLanguage.g:534:2: rule__MyProgram__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyProgram__Group__3__Impl();

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
    // $ANTLR end "rule__MyProgram__Group__3"


    // $ANTLR start "rule__MyProgram__Group__3__Impl"
    // InternalBug347012TestLanguage.g:540:1: rule__MyProgram__Group__3__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyProgram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:544:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:545:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:545:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:546:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_3()); 
            // InternalBug347012TestLanguage.g:547:2: ( RULE_LT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_LT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:547:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__Group__3__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalBug347012TestLanguage.g:556:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:560:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalBug347012TestLanguage.g:561:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
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
    // InternalBug347012TestLanguage.g:568:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:572:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:573:1: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:573:1: ( RULE_ID )
            // InternalBug347012TestLanguage.g:574:2: RULE_ID
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
    // InternalBug347012TestLanguage.g:583:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:587:1: ( rule__FQN__Group__1__Impl )
            // InternalBug347012TestLanguage.g:588:2: rule__FQN__Group__1__Impl
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
    // InternalBug347012TestLanguage.g:594:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:598:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalBug347012TestLanguage.g:599:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalBug347012TestLanguage.g:599:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalBug347012TestLanguage.g:600:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalBug347012TestLanguage.g:601:2: ( rule__FQN__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:601:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // InternalBug347012TestLanguage.g:610:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:614:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalBug347012TestLanguage.g:615:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
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
    // InternalBug347012TestLanguage.g:622:1: rule__FQN__Group_1__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:626:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:627:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:627:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:628:2: ( RULE_LT )*
            {
             before(grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_0()); 
            // InternalBug347012TestLanguage.g:629:2: ( RULE_LT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_LT) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:629:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // InternalBug347012TestLanguage.g:637:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl rule__FQN__Group_1__2 ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:641:1: ( rule__FQN__Group_1__1__Impl rule__FQN__Group_1__2 )
            // InternalBug347012TestLanguage.g:642:2: rule__FQN__Group_1__1__Impl rule__FQN__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__FQN__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__2();

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
    // InternalBug347012TestLanguage.g:649:1: rule__FQN__Group_1__1__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:653:1: ( ( '.' ) )
            // InternalBug347012TestLanguage.g:654:1: ( '.' )
            {
            // InternalBug347012TestLanguage.g:654:1: ( '.' )
            // InternalBug347012TestLanguage.g:655:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_1()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__FQN__Group_1__2"
    // InternalBug347012TestLanguage.g:664:1: rule__FQN__Group_1__2 : rule__FQN__Group_1__2__Impl rule__FQN__Group_1__3 ;
    public final void rule__FQN__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:668:1: ( rule__FQN__Group_1__2__Impl rule__FQN__Group_1__3 )
            // InternalBug347012TestLanguage.g:669:2: rule__FQN__Group_1__2__Impl rule__FQN__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__FQN__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__3();

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
    // $ANTLR end "rule__FQN__Group_1__2"


    // $ANTLR start "rule__FQN__Group_1__2__Impl"
    // InternalBug347012TestLanguage.g:676:1: rule__FQN__Group_1__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__FQN__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:680:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:681:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:681:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:682:2: ( RULE_LT )*
            {
             before(grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_2()); 
            // InternalBug347012TestLanguage.g:683:2: ( RULE_LT )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_LT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:683:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__2__Impl"


    // $ANTLR start "rule__FQN__Group_1__3"
    // InternalBug347012TestLanguage.g:691:1: rule__FQN__Group_1__3 : rule__FQN__Group_1__3__Impl ;
    public final void rule__FQN__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:695:1: ( rule__FQN__Group_1__3__Impl )
            // InternalBug347012TestLanguage.g:696:2: rule__FQN__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__3__Impl();

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
    // $ANTLR end "rule__FQN__Group_1__3"


    // $ANTLR start "rule__FQN__Group_1__3__Impl"
    // InternalBug347012TestLanguage.g:702:1: rule__FQN__Group_1__3__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:706:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:707:1: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:707:1: ( RULE_ID )
            // InternalBug347012TestLanguage.g:708:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_3()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__3__Impl"


    // $ANTLR start "rule__MyPackage__Group__0"
    // InternalBug347012TestLanguage.g:718:1: rule__MyPackage__Group__0 : rule__MyPackage__Group__0__Impl rule__MyPackage__Group__1 ;
    public final void rule__MyPackage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:722:1: ( rule__MyPackage__Group__0__Impl rule__MyPackage__Group__1 )
            // InternalBug347012TestLanguage.g:723:2: rule__MyPackage__Group__0__Impl rule__MyPackage__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyPackage__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__1();

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
    // $ANTLR end "rule__MyPackage__Group__0"


    // $ANTLR start "rule__MyPackage__Group__0__Impl"
    // InternalBug347012TestLanguage.g:730:1: rule__MyPackage__Group__0__Impl : ( 'package' ) ;
    public final void rule__MyPackage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:734:1: ( ( 'package' ) )
            // InternalBug347012TestLanguage.g:735:1: ( 'package' )
            {
            // InternalBug347012TestLanguage.g:735:1: ( 'package' )
            // InternalBug347012TestLanguage.g:736:2: 'package'
            {
             before(grammarAccess.getMyPackageAccess().getPackageKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyPackageAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__0__Impl"


    // $ANTLR start "rule__MyPackage__Group__1"
    // InternalBug347012TestLanguage.g:745:1: rule__MyPackage__Group__1 : rule__MyPackage__Group__1__Impl rule__MyPackage__Group__2 ;
    public final void rule__MyPackage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:749:1: ( rule__MyPackage__Group__1__Impl rule__MyPackage__Group__2 )
            // InternalBug347012TestLanguage.g:750:2: rule__MyPackage__Group__1__Impl rule__MyPackage__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyPackage__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__2();

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
    // $ANTLR end "rule__MyPackage__Group__1"


    // $ANTLR start "rule__MyPackage__Group__1__Impl"
    // InternalBug347012TestLanguage.g:757:1: rule__MyPackage__Group__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:761:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:762:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:762:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:763:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_1()); 
            // InternalBug347012TestLanguage.g:764:2: ( RULE_LT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_LT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:764:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__1__Impl"


    // $ANTLR start "rule__MyPackage__Group__2"
    // InternalBug347012TestLanguage.g:772:1: rule__MyPackage__Group__2 : rule__MyPackage__Group__2__Impl rule__MyPackage__Group__3 ;
    public final void rule__MyPackage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:776:1: ( rule__MyPackage__Group__2__Impl rule__MyPackage__Group__3 )
            // InternalBug347012TestLanguage.g:777:2: rule__MyPackage__Group__2__Impl rule__MyPackage__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__MyPackage__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__3();

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
    // $ANTLR end "rule__MyPackage__Group__2"


    // $ANTLR start "rule__MyPackage__Group__2__Impl"
    // InternalBug347012TestLanguage.g:784:1: rule__MyPackage__Group__2__Impl : ( ( rule__MyPackage__NameAssignment_2 ) ) ;
    public final void rule__MyPackage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:788:1: ( ( ( rule__MyPackage__NameAssignment_2 ) ) )
            // InternalBug347012TestLanguage.g:789:1: ( ( rule__MyPackage__NameAssignment_2 ) )
            {
            // InternalBug347012TestLanguage.g:789:1: ( ( rule__MyPackage__NameAssignment_2 ) )
            // InternalBug347012TestLanguage.g:790:2: ( rule__MyPackage__NameAssignment_2 )
            {
             before(grammarAccess.getMyPackageAccess().getNameAssignment_2()); 
            // InternalBug347012TestLanguage.g:791:2: ( rule__MyPackage__NameAssignment_2 )
            // InternalBug347012TestLanguage.g:791:3: rule__MyPackage__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMyPackageAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__2__Impl"


    // $ANTLR start "rule__MyPackage__Group__3"
    // InternalBug347012TestLanguage.g:799:1: rule__MyPackage__Group__3 : rule__MyPackage__Group__3__Impl rule__MyPackage__Group__4 ;
    public final void rule__MyPackage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:803:1: ( rule__MyPackage__Group__3__Impl rule__MyPackage__Group__4 )
            // InternalBug347012TestLanguage.g:804:2: rule__MyPackage__Group__3__Impl rule__MyPackage__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__MyPackage__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__4();

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
    // $ANTLR end "rule__MyPackage__Group__3"


    // $ANTLR start "rule__MyPackage__Group__3__Impl"
    // InternalBug347012TestLanguage.g:811:1: rule__MyPackage__Group__3__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:815:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:816:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:816:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:817:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_3()); 
            // InternalBug347012TestLanguage.g:818:2: ( RULE_LT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_LT) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:818:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__3__Impl"


    // $ANTLR start "rule__MyPackage__Group__4"
    // InternalBug347012TestLanguage.g:826:1: rule__MyPackage__Group__4 : rule__MyPackage__Group__4__Impl rule__MyPackage__Group__5 ;
    public final void rule__MyPackage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:830:1: ( rule__MyPackage__Group__4__Impl rule__MyPackage__Group__5 )
            // InternalBug347012TestLanguage.g:831:2: rule__MyPackage__Group__4__Impl rule__MyPackage__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__MyPackage__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__5();

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
    // $ANTLR end "rule__MyPackage__Group__4"


    // $ANTLR start "rule__MyPackage__Group__4__Impl"
    // InternalBug347012TestLanguage.g:838:1: rule__MyPackage__Group__4__Impl : ( '{' ) ;
    public final void rule__MyPackage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:842:1: ( ( '{' ) )
            // InternalBug347012TestLanguage.g:843:1: ( '{' )
            {
            // InternalBug347012TestLanguage.g:843:1: ( '{' )
            // InternalBug347012TestLanguage.g:844:2: '{'
            {
             before(grammarAccess.getMyPackageAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyPackageAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__4__Impl"


    // $ANTLR start "rule__MyPackage__Group__5"
    // InternalBug347012TestLanguage.g:853:1: rule__MyPackage__Group__5 : rule__MyPackage__Group__5__Impl rule__MyPackage__Group__6 ;
    public final void rule__MyPackage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:857:1: ( rule__MyPackage__Group__5__Impl rule__MyPackage__Group__6 )
            // InternalBug347012TestLanguage.g:858:2: rule__MyPackage__Group__5__Impl rule__MyPackage__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__MyPackage__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__6();

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
    // $ANTLR end "rule__MyPackage__Group__5"


    // $ANTLR start "rule__MyPackage__Group__5__Impl"
    // InternalBug347012TestLanguage.g:865:1: rule__MyPackage__Group__5__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:869:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:870:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:870:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:871:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_5()); 
            // InternalBug347012TestLanguage.g:872:2: ( RULE_LT )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_LT) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:872:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__5__Impl"


    // $ANTLR start "rule__MyPackage__Group__6"
    // InternalBug347012TestLanguage.g:880:1: rule__MyPackage__Group__6 : rule__MyPackage__Group__6__Impl rule__MyPackage__Group__7 ;
    public final void rule__MyPackage__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:884:1: ( rule__MyPackage__Group__6__Impl rule__MyPackage__Group__7 )
            // InternalBug347012TestLanguage.g:885:2: rule__MyPackage__Group__6__Impl rule__MyPackage__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__MyPackage__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__7();

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
    // $ANTLR end "rule__MyPackage__Group__6"


    // $ANTLR start "rule__MyPackage__Group__6__Impl"
    // InternalBug347012TestLanguage.g:892:1: rule__MyPackage__Group__6__Impl : ( ( rule__MyPackage__Group_6__0 )* ) ;
    public final void rule__MyPackage__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:896:1: ( ( ( rule__MyPackage__Group_6__0 )* ) )
            // InternalBug347012TestLanguage.g:897:1: ( ( rule__MyPackage__Group_6__0 )* )
            {
            // InternalBug347012TestLanguage.g:897:1: ( ( rule__MyPackage__Group_6__0 )* )
            // InternalBug347012TestLanguage.g:898:2: ( rule__MyPackage__Group_6__0 )*
            {
             before(grammarAccess.getMyPackageAccess().getGroup_6()); 
            // InternalBug347012TestLanguage.g:899:2: ( rule__MyPackage__Group_6__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=18 && LA13_0<=19)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:899:3: rule__MyPackage__Group_6__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    rule__MyPackage__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getMyPackageAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__6__Impl"


    // $ANTLR start "rule__MyPackage__Group__7"
    // InternalBug347012TestLanguage.g:907:1: rule__MyPackage__Group__7 : rule__MyPackage__Group__7__Impl ;
    public final void rule__MyPackage__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:911:1: ( rule__MyPackage__Group__7__Impl )
            // InternalBug347012TestLanguage.g:912:2: rule__MyPackage__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group__7__Impl();

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
    // $ANTLR end "rule__MyPackage__Group__7"


    // $ANTLR start "rule__MyPackage__Group__7__Impl"
    // InternalBug347012TestLanguage.g:918:1: rule__MyPackage__Group__7__Impl : ( '}' ) ;
    public final void rule__MyPackage__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:922:1: ( ( '}' ) )
            // InternalBug347012TestLanguage.g:923:1: ( '}' )
            {
            // InternalBug347012TestLanguage.g:923:1: ( '}' )
            // InternalBug347012TestLanguage.g:924:2: '}'
            {
             before(grammarAccess.getMyPackageAccess().getRightCurlyBracketKeyword_7()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyPackageAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group__7__Impl"


    // $ANTLR start "rule__MyPackage__Group_6__0"
    // InternalBug347012TestLanguage.g:934:1: rule__MyPackage__Group_6__0 : rule__MyPackage__Group_6__0__Impl rule__MyPackage__Group_6__1 ;
    public final void rule__MyPackage__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:938:1: ( rule__MyPackage__Group_6__0__Impl rule__MyPackage__Group_6__1 )
            // InternalBug347012TestLanguage.g:939:2: rule__MyPackage__Group_6__0__Impl rule__MyPackage__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MyPackage__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group_6__1();

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
    // $ANTLR end "rule__MyPackage__Group_6__0"


    // $ANTLR start "rule__MyPackage__Group_6__0__Impl"
    // InternalBug347012TestLanguage.g:946:1: rule__MyPackage__Group_6__0__Impl : ( ( rule__MyPackage__DirectivesAssignment_6_0 ) ) ;
    public final void rule__MyPackage__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:950:1: ( ( ( rule__MyPackage__DirectivesAssignment_6_0 ) ) )
            // InternalBug347012TestLanguage.g:951:1: ( ( rule__MyPackage__DirectivesAssignment_6_0 ) )
            {
            // InternalBug347012TestLanguage.g:951:1: ( ( rule__MyPackage__DirectivesAssignment_6_0 ) )
            // InternalBug347012TestLanguage.g:952:2: ( rule__MyPackage__DirectivesAssignment_6_0 )
            {
             before(grammarAccess.getMyPackageAccess().getDirectivesAssignment_6_0()); 
            // InternalBug347012TestLanguage.g:953:2: ( rule__MyPackage__DirectivesAssignment_6_0 )
            // InternalBug347012TestLanguage.g:953:3: rule__MyPackage__DirectivesAssignment_6_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__DirectivesAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getMyPackageAccess().getDirectivesAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group_6__0__Impl"


    // $ANTLR start "rule__MyPackage__Group_6__1"
    // InternalBug347012TestLanguage.g:961:1: rule__MyPackage__Group_6__1 : rule__MyPackage__Group_6__1__Impl ;
    public final void rule__MyPackage__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:965:1: ( rule__MyPackage__Group_6__1__Impl )
            // InternalBug347012TestLanguage.g:966:2: rule__MyPackage__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyPackage__Group_6__1__Impl();

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
    // $ANTLR end "rule__MyPackage__Group_6__1"


    // $ANTLR start "rule__MyPackage__Group_6__1__Impl"
    // InternalBug347012TestLanguage.g:972:1: rule__MyPackage__Group_6__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:976:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:977:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:977:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:978:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_6_1()); 
            // InternalBug347012TestLanguage.g:979:2: ( RULE_LT )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_LT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:979:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__Group_6__1__Impl"


    // $ANTLR start "rule__MyClass__Group__0"
    // InternalBug347012TestLanguage.g:988:1: rule__MyClass__Group__0 : rule__MyClass__Group__0__Impl rule__MyClass__Group__1 ;
    public final void rule__MyClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:992:1: ( rule__MyClass__Group__0__Impl rule__MyClass__Group__1 )
            // InternalBug347012TestLanguage.g:993:2: rule__MyClass__Group__0__Impl rule__MyClass__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__MyClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__1();

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
    // $ANTLR end "rule__MyClass__Group__0"


    // $ANTLR start "rule__MyClass__Group__0__Impl"
    // InternalBug347012TestLanguage.g:1000:1: rule__MyClass__Group__0__Impl : ( ( 'public' )? ) ;
    public final void rule__MyClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1004:1: ( ( ( 'public' )? ) )
            // InternalBug347012TestLanguage.g:1005:1: ( ( 'public' )? )
            {
            // InternalBug347012TestLanguage.g:1005:1: ( ( 'public' )? )
            // InternalBug347012TestLanguage.g:1006:2: ( 'public' )?
            {
             before(grammarAccess.getMyClassAccess().getPublicKeyword_0()); 
            // InternalBug347012TestLanguage.g:1007:2: ( 'public' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBug347012TestLanguage.g:1007:3: 'public'
                    {
                    match(input,18,FollowSets000.FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getMyClassAccess().getPublicKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__0__Impl"


    // $ANTLR start "rule__MyClass__Group__1"
    // InternalBug347012TestLanguage.g:1015:1: rule__MyClass__Group__1 : rule__MyClass__Group__1__Impl rule__MyClass__Group__2 ;
    public final void rule__MyClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1019:1: ( rule__MyClass__Group__1__Impl rule__MyClass__Group__2 )
            // InternalBug347012TestLanguage.g:1020:2: rule__MyClass__Group__1__Impl rule__MyClass__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__2();

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
    // $ANTLR end "rule__MyClass__Group__1"


    // $ANTLR start "rule__MyClass__Group__1__Impl"
    // InternalBug347012TestLanguage.g:1027:1: rule__MyClass__Group__1__Impl : ( 'class' ) ;
    public final void rule__MyClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1031:1: ( ( 'class' ) )
            // InternalBug347012TestLanguage.g:1032:1: ( 'class' )
            {
            // InternalBug347012TestLanguage.g:1032:1: ( 'class' )
            // InternalBug347012TestLanguage.g:1033:2: 'class'
            {
             before(grammarAccess.getMyClassAccess().getClassKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyClassAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__1__Impl"


    // $ANTLR start "rule__MyClass__Group__2"
    // InternalBug347012TestLanguage.g:1042:1: rule__MyClass__Group__2 : rule__MyClass__Group__2__Impl rule__MyClass__Group__3 ;
    public final void rule__MyClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1046:1: ( rule__MyClass__Group__2__Impl rule__MyClass__Group__3 )
            // InternalBug347012TestLanguage.g:1047:2: rule__MyClass__Group__2__Impl rule__MyClass__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__3();

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
    // $ANTLR end "rule__MyClass__Group__2"


    // $ANTLR start "rule__MyClass__Group__2__Impl"
    // InternalBug347012TestLanguage.g:1054:1: rule__MyClass__Group__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1058:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1059:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1059:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1060:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_2()); 
            // InternalBug347012TestLanguage.g:1061:2: ( RULE_LT )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_LT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1061:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__2__Impl"


    // $ANTLR start "rule__MyClass__Group__3"
    // InternalBug347012TestLanguage.g:1069:1: rule__MyClass__Group__3 : rule__MyClass__Group__3__Impl rule__MyClass__Group__4 ;
    public final void rule__MyClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1073:1: ( rule__MyClass__Group__3__Impl rule__MyClass__Group__4 )
            // InternalBug347012TestLanguage.g:1074:2: rule__MyClass__Group__3__Impl rule__MyClass__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__MyClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__4();

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
    // $ANTLR end "rule__MyClass__Group__3"


    // $ANTLR start "rule__MyClass__Group__3__Impl"
    // InternalBug347012TestLanguage.g:1081:1: rule__MyClass__Group__3__Impl : ( ( rule__MyClass__NameAssignment_3 ) ) ;
    public final void rule__MyClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1085:1: ( ( ( rule__MyClass__NameAssignment_3 ) ) )
            // InternalBug347012TestLanguage.g:1086:1: ( ( rule__MyClass__NameAssignment_3 ) )
            {
            // InternalBug347012TestLanguage.g:1086:1: ( ( rule__MyClass__NameAssignment_3 ) )
            // InternalBug347012TestLanguage.g:1087:2: ( rule__MyClass__NameAssignment_3 )
            {
             before(grammarAccess.getMyClassAccess().getNameAssignment_3()); 
            // InternalBug347012TestLanguage.g:1088:2: ( rule__MyClass__NameAssignment_3 )
            // InternalBug347012TestLanguage.g:1088:3: rule__MyClass__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMyClassAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__3__Impl"


    // $ANTLR start "rule__MyClass__Group__4"
    // InternalBug347012TestLanguage.g:1096:1: rule__MyClass__Group__4 : rule__MyClass__Group__4__Impl rule__MyClass__Group__5 ;
    public final void rule__MyClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1100:1: ( rule__MyClass__Group__4__Impl rule__MyClass__Group__5 )
            // InternalBug347012TestLanguage.g:1101:2: rule__MyClass__Group__4__Impl rule__MyClass__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__MyClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__5();

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
    // $ANTLR end "rule__MyClass__Group__4"


    // $ANTLR start "rule__MyClass__Group__4__Impl"
    // InternalBug347012TestLanguage.g:1108:1: rule__MyClass__Group__4__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1112:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1113:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1113:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1114:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_4()); 
            // InternalBug347012TestLanguage.g:1115:2: ( RULE_LT )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_LT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1115:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__4__Impl"


    // $ANTLR start "rule__MyClass__Group__5"
    // InternalBug347012TestLanguage.g:1123:1: rule__MyClass__Group__5 : rule__MyClass__Group__5__Impl rule__MyClass__Group__6 ;
    public final void rule__MyClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1127:1: ( rule__MyClass__Group__5__Impl rule__MyClass__Group__6 )
            // InternalBug347012TestLanguage.g:1128:2: rule__MyClass__Group__5__Impl rule__MyClass__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MyClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__6();

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
    // $ANTLR end "rule__MyClass__Group__5"


    // $ANTLR start "rule__MyClass__Group__5__Impl"
    // InternalBug347012TestLanguage.g:1135:1: rule__MyClass__Group__5__Impl : ( '{' ) ;
    public final void rule__MyClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1139:1: ( ( '{' ) )
            // InternalBug347012TestLanguage.g:1140:1: ( '{' )
            {
            // InternalBug347012TestLanguage.g:1140:1: ( '{' )
            // InternalBug347012TestLanguage.g:1141:2: '{'
            {
             before(grammarAccess.getMyClassAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyClassAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__5__Impl"


    // $ANTLR start "rule__MyClass__Group__6"
    // InternalBug347012TestLanguage.g:1150:1: rule__MyClass__Group__6 : rule__MyClass__Group__6__Impl rule__MyClass__Group__7 ;
    public final void rule__MyClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1154:1: ( rule__MyClass__Group__6__Impl rule__MyClass__Group__7 )
            // InternalBug347012TestLanguage.g:1155:2: rule__MyClass__Group__6__Impl rule__MyClass__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MyClass__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__7();

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
    // $ANTLR end "rule__MyClass__Group__6"


    // $ANTLR start "rule__MyClass__Group__6__Impl"
    // InternalBug347012TestLanguage.g:1162:1: rule__MyClass__Group__6__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1166:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1167:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1167:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1168:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_6()); 
            // InternalBug347012TestLanguage.g:1169:2: ( RULE_LT )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_LT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1169:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__6__Impl"


    // $ANTLR start "rule__MyClass__Group__7"
    // InternalBug347012TestLanguage.g:1177:1: rule__MyClass__Group__7 : rule__MyClass__Group__7__Impl rule__MyClass__Group__8 ;
    public final void rule__MyClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1181:1: ( rule__MyClass__Group__7__Impl rule__MyClass__Group__8 )
            // InternalBug347012TestLanguage.g:1182:2: rule__MyClass__Group__7__Impl rule__MyClass__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MyClass__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__8();

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
    // $ANTLR end "rule__MyClass__Group__7"


    // $ANTLR start "rule__MyClass__Group__7__Impl"
    // InternalBug347012TestLanguage.g:1189:1: rule__MyClass__Group__7__Impl : ( ( rule__MyClass__Group_7__0 )* ) ;
    public final void rule__MyClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1193:1: ( ( ( rule__MyClass__Group_7__0 )* ) )
            // InternalBug347012TestLanguage.g:1194:1: ( ( rule__MyClass__Group_7__0 )* )
            {
            // InternalBug347012TestLanguage.g:1194:1: ( ( rule__MyClass__Group_7__0 )* )
            // InternalBug347012TestLanguage.g:1195:2: ( rule__MyClass__Group_7__0 )*
            {
             before(grammarAccess.getMyClassAccess().getGroup_7()); 
            // InternalBug347012TestLanguage.g:1196:2: ( rule__MyClass__Group_7__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==EOF||LA19_0==18||LA19_0==20||LA19_0==26) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1196:3: rule__MyClass__Group_7__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__MyClass__Group_7__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getMyClassAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__7__Impl"


    // $ANTLR start "rule__MyClass__Group__8"
    // InternalBug347012TestLanguage.g:1204:1: rule__MyClass__Group__8 : rule__MyClass__Group__8__Impl ;
    public final void rule__MyClass__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1208:1: ( rule__MyClass__Group__8__Impl )
            // InternalBug347012TestLanguage.g:1209:2: rule__MyClass__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group__8__Impl();

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
    // $ANTLR end "rule__MyClass__Group__8"


    // $ANTLR start "rule__MyClass__Group__8__Impl"
    // InternalBug347012TestLanguage.g:1215:1: rule__MyClass__Group__8__Impl : ( '}' ) ;
    public final void rule__MyClass__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1219:1: ( ( '}' ) )
            // InternalBug347012TestLanguage.g:1220:1: ( '}' )
            {
            // InternalBug347012TestLanguage.g:1220:1: ( '}' )
            // InternalBug347012TestLanguage.g:1221:2: '}'
            {
             before(grammarAccess.getMyClassAccess().getRightCurlyBracketKeyword_8()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyClassAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group__8__Impl"


    // $ANTLR start "rule__MyClass__Group_7__0"
    // InternalBug347012TestLanguage.g:1231:1: rule__MyClass__Group_7__0 : rule__MyClass__Group_7__0__Impl rule__MyClass__Group_7__1 ;
    public final void rule__MyClass__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1235:1: ( rule__MyClass__Group_7__0__Impl rule__MyClass__Group_7__1 )
            // InternalBug347012TestLanguage.g:1236:2: rule__MyClass__Group_7__0__Impl rule__MyClass__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MyClass__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group_7__1();

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
    // $ANTLR end "rule__MyClass__Group_7__0"


    // $ANTLR start "rule__MyClass__Group_7__0__Impl"
    // InternalBug347012TestLanguage.g:1243:1: rule__MyClass__Group_7__0__Impl : ( ( rule__MyClass__DirectivesAssignment_7_0 ) ) ;
    public final void rule__MyClass__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1247:1: ( ( ( rule__MyClass__DirectivesAssignment_7_0 ) ) )
            // InternalBug347012TestLanguage.g:1248:1: ( ( rule__MyClass__DirectivesAssignment_7_0 ) )
            {
            // InternalBug347012TestLanguage.g:1248:1: ( ( rule__MyClass__DirectivesAssignment_7_0 ) )
            // InternalBug347012TestLanguage.g:1249:2: ( rule__MyClass__DirectivesAssignment_7_0 )
            {
             before(grammarAccess.getMyClassAccess().getDirectivesAssignment_7_0()); 
            // InternalBug347012TestLanguage.g:1250:2: ( rule__MyClass__DirectivesAssignment_7_0 )
            // InternalBug347012TestLanguage.g:1250:3: rule__MyClass__DirectivesAssignment_7_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__DirectivesAssignment_7_0();

            state._fsp--;


            }

             after(grammarAccess.getMyClassAccess().getDirectivesAssignment_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group_7__0__Impl"


    // $ANTLR start "rule__MyClass__Group_7__1"
    // InternalBug347012TestLanguage.g:1258:1: rule__MyClass__Group_7__1 : rule__MyClass__Group_7__1__Impl ;
    public final void rule__MyClass__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1262:1: ( rule__MyClass__Group_7__1__Impl )
            // InternalBug347012TestLanguage.g:1263:2: rule__MyClass__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyClass__Group_7__1__Impl();

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
    // $ANTLR end "rule__MyClass__Group_7__1"


    // $ANTLR start "rule__MyClass__Group_7__1__Impl"
    // InternalBug347012TestLanguage.g:1269:1: rule__MyClass__Group_7__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1273:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1274:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1274:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1275:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_7_1()); 
            // InternalBug347012TestLanguage.g:1276:2: ( RULE_LT )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_LT) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1276:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__Group_7__1__Impl"


    // $ANTLR start "rule__MyAttributes__Group__0"
    // InternalBug347012TestLanguage.g:1285:1: rule__MyAttributes__Group__0 : rule__MyAttributes__Group__0__Impl rule__MyAttributes__Group__1 ;
    public final void rule__MyAttributes__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1289:1: ( rule__MyAttributes__Group__0__Impl rule__MyAttributes__Group__1 )
            // InternalBug347012TestLanguage.g:1290:2: rule__MyAttributes__Group__0__Impl rule__MyAttributes__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__MyAttributes__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyAttributes__Group__1();

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
    // $ANTLR end "rule__MyAttributes__Group__0"


    // $ANTLR start "rule__MyAttributes__Group__0__Impl"
    // InternalBug347012TestLanguage.g:1297:1: rule__MyAttributes__Group__0__Impl : ( () ) ;
    public final void rule__MyAttributes__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1301:1: ( ( () ) )
            // InternalBug347012TestLanguage.g:1302:1: ( () )
            {
            // InternalBug347012TestLanguage.g:1302:1: ( () )
            // InternalBug347012TestLanguage.g:1303:2: ()
            {
             before(grammarAccess.getMyAttributesAccess().getMyAttributesAction_0()); 
            // InternalBug347012TestLanguage.g:1304:2: ()
            // InternalBug347012TestLanguage.g:1304:3: 
            {
            }

             after(grammarAccess.getMyAttributesAccess().getMyAttributesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttributes__Group__0__Impl"


    // $ANTLR start "rule__MyAttributes__Group__1"
    // InternalBug347012TestLanguage.g:1312:1: rule__MyAttributes__Group__1 : rule__MyAttributes__Group__1__Impl ;
    public final void rule__MyAttributes__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1316:1: ( rule__MyAttributes__Group__1__Impl )
            // InternalBug347012TestLanguage.g:1317:2: rule__MyAttributes__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyAttributes__Group__1__Impl();

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
    // $ANTLR end "rule__MyAttributes__Group__1"


    // $ANTLR start "rule__MyAttributes__Group__1__Impl"
    // InternalBug347012TestLanguage.g:1323:1: rule__MyAttributes__Group__1__Impl : ( ( rule__MyAttributes__AttributesAssignment_1 )* ) ;
    public final void rule__MyAttributes__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1327:1: ( ( ( rule__MyAttributes__AttributesAssignment_1 )* ) )
            // InternalBug347012TestLanguage.g:1328:1: ( ( rule__MyAttributes__AttributesAssignment_1 )* )
            {
            // InternalBug347012TestLanguage.g:1328:1: ( ( rule__MyAttributes__AttributesAssignment_1 )* )
            // InternalBug347012TestLanguage.g:1329:2: ( rule__MyAttributes__AttributesAssignment_1 )*
            {
             before(grammarAccess.getMyAttributesAccess().getAttributesAssignment_1()); 
            // InternalBug347012TestLanguage.g:1330:2: ( rule__MyAttributes__AttributesAssignment_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==18||LA21_0==26) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1330:3: rule__MyAttributes__AttributesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__MyAttributes__AttributesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getMyAttributesAccess().getAttributesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttributes__Group__1__Impl"


    // $ANTLR start "rule__MyField__Group__0"
    // InternalBug347012TestLanguage.g:1339:1: rule__MyField__Group__0 : rule__MyField__Group__0__Impl rule__MyField__Group__1 ;
    public final void rule__MyField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1343:1: ( rule__MyField__Group__0__Impl rule__MyField__Group__1 )
            // InternalBug347012TestLanguage.g:1344:2: rule__MyField__Group__0__Impl rule__MyField__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__MyField__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__1();

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
    // $ANTLR end "rule__MyField__Group__0"


    // $ANTLR start "rule__MyField__Group__0__Impl"
    // InternalBug347012TestLanguage.g:1351:1: rule__MyField__Group__0__Impl : ( ( rule__MyField__AttrAssignment_0 ) ) ;
    public final void rule__MyField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1355:1: ( ( ( rule__MyField__AttrAssignment_0 ) ) )
            // InternalBug347012TestLanguage.g:1356:1: ( ( rule__MyField__AttrAssignment_0 ) )
            {
            // InternalBug347012TestLanguage.g:1356:1: ( ( rule__MyField__AttrAssignment_0 ) )
            // InternalBug347012TestLanguage.g:1357:2: ( rule__MyField__AttrAssignment_0 )
            {
             before(grammarAccess.getMyFieldAccess().getAttrAssignment_0()); 
            // InternalBug347012TestLanguage.g:1358:2: ( rule__MyField__AttrAssignment_0 )
            // InternalBug347012TestLanguage.g:1358:3: rule__MyField__AttrAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__AttrAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMyFieldAccess().getAttrAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__0__Impl"


    // $ANTLR start "rule__MyField__Group__1"
    // InternalBug347012TestLanguage.g:1366:1: rule__MyField__Group__1 : rule__MyField__Group__1__Impl rule__MyField__Group__2 ;
    public final void rule__MyField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1370:1: ( rule__MyField__Group__1__Impl rule__MyField__Group__2 )
            // InternalBug347012TestLanguage.g:1371:2: rule__MyField__Group__1__Impl rule__MyField__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyField__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__2();

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
    // $ANTLR end "rule__MyField__Group__1"


    // $ANTLR start "rule__MyField__Group__1__Impl"
    // InternalBug347012TestLanguage.g:1378:1: rule__MyField__Group__1__Impl : ( 'var' ) ;
    public final void rule__MyField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1382:1: ( ( 'var' ) )
            // InternalBug347012TestLanguage.g:1383:1: ( 'var' )
            {
            // InternalBug347012TestLanguage.g:1383:1: ( 'var' )
            // InternalBug347012TestLanguage.g:1384:2: 'var'
            {
             before(grammarAccess.getMyFieldAccess().getVarKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyFieldAccess().getVarKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__1__Impl"


    // $ANTLR start "rule__MyField__Group__2"
    // InternalBug347012TestLanguage.g:1393:1: rule__MyField__Group__2 : rule__MyField__Group__2__Impl rule__MyField__Group__3 ;
    public final void rule__MyField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1397:1: ( rule__MyField__Group__2__Impl rule__MyField__Group__3 )
            // InternalBug347012TestLanguage.g:1398:2: rule__MyField__Group__2__Impl rule__MyField__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyField__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__3();

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
    // $ANTLR end "rule__MyField__Group__2"


    // $ANTLR start "rule__MyField__Group__2__Impl"
    // InternalBug347012TestLanguage.g:1405:1: rule__MyField__Group__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1409:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1410:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1410:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1411:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_2()); 
            // InternalBug347012TestLanguage.g:1412:2: ( RULE_LT )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_LT) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1412:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__2__Impl"


    // $ANTLR start "rule__MyField__Group__3"
    // InternalBug347012TestLanguage.g:1420:1: rule__MyField__Group__3 : rule__MyField__Group__3__Impl rule__MyField__Group__4 ;
    public final void rule__MyField__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1424:1: ( rule__MyField__Group__3__Impl rule__MyField__Group__4 )
            // InternalBug347012TestLanguage.g:1425:2: rule__MyField__Group__3__Impl rule__MyField__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__MyField__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__4();

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
    // $ANTLR end "rule__MyField__Group__3"


    // $ANTLR start "rule__MyField__Group__3__Impl"
    // InternalBug347012TestLanguage.g:1432:1: rule__MyField__Group__3__Impl : ( ( rule__MyField__BindingsAssignment_3 ) ) ;
    public final void rule__MyField__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1436:1: ( ( ( rule__MyField__BindingsAssignment_3 ) ) )
            // InternalBug347012TestLanguage.g:1437:1: ( ( rule__MyField__BindingsAssignment_3 ) )
            {
            // InternalBug347012TestLanguage.g:1437:1: ( ( rule__MyField__BindingsAssignment_3 ) )
            // InternalBug347012TestLanguage.g:1438:2: ( rule__MyField__BindingsAssignment_3 )
            {
             before(grammarAccess.getMyFieldAccess().getBindingsAssignment_3()); 
            // InternalBug347012TestLanguage.g:1439:2: ( rule__MyField__BindingsAssignment_3 )
            // InternalBug347012TestLanguage.g:1439:3: rule__MyField__BindingsAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__BindingsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMyFieldAccess().getBindingsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__3__Impl"


    // $ANTLR start "rule__MyField__Group__4"
    // InternalBug347012TestLanguage.g:1447:1: rule__MyField__Group__4 : rule__MyField__Group__4__Impl rule__MyField__Group__5 ;
    public final void rule__MyField__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1451:1: ( rule__MyField__Group__4__Impl rule__MyField__Group__5 )
            // InternalBug347012TestLanguage.g:1452:2: rule__MyField__Group__4__Impl rule__MyField__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__MyField__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__5();

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
    // $ANTLR end "rule__MyField__Group__4"


    // $ANTLR start "rule__MyField__Group__4__Impl"
    // InternalBug347012TestLanguage.g:1459:1: rule__MyField__Group__4__Impl : ( ( rule__MyField__Group_4__0 )* ) ;
    public final void rule__MyField__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1463:1: ( ( ( rule__MyField__Group_4__0 )* ) )
            // InternalBug347012TestLanguage.g:1464:1: ( ( rule__MyField__Group_4__0 )* )
            {
            // InternalBug347012TestLanguage.g:1464:1: ( ( rule__MyField__Group_4__0 )* )
            // InternalBug347012TestLanguage.g:1465:2: ( rule__MyField__Group_4__0 )*
            {
             before(grammarAccess.getMyFieldAccess().getGroup_4()); 
            // InternalBug347012TestLanguage.g:1466:2: ( rule__MyField__Group_4__0 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1466:3: rule__MyField__Group_4__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    rule__MyField__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getMyFieldAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__4__Impl"


    // $ANTLR start "rule__MyField__Group__5"
    // InternalBug347012TestLanguage.g:1474:1: rule__MyField__Group__5 : rule__MyField__Group__5__Impl ;
    public final void rule__MyField__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1478:1: ( rule__MyField__Group__5__Impl )
            // InternalBug347012TestLanguage.g:1479:2: rule__MyField__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group__5__Impl();

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
    // $ANTLR end "rule__MyField__Group__5"


    // $ANTLR start "rule__MyField__Group__5__Impl"
    // InternalBug347012TestLanguage.g:1485:1: rule__MyField__Group__5__Impl : ( ruleVirtualSemi ) ;
    public final void rule__MyField__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1489:1: ( ( ruleVirtualSemi ) )
            // InternalBug347012TestLanguage.g:1490:1: ( ruleVirtualSemi )
            {
            // InternalBug347012TestLanguage.g:1490:1: ( ruleVirtualSemi )
            // InternalBug347012TestLanguage.g:1491:2: ruleVirtualSemi
            {
             before(grammarAccess.getMyFieldAccess().getVirtualSemiParserRuleCall_5()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleVirtualSemi();

            state._fsp--;

             after(grammarAccess.getMyFieldAccess().getVirtualSemiParserRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group__5__Impl"


    // $ANTLR start "rule__MyField__Group_4__0"
    // InternalBug347012TestLanguage.g:1501:1: rule__MyField__Group_4__0 : rule__MyField__Group_4__0__Impl rule__MyField__Group_4__1 ;
    public final void rule__MyField__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1505:1: ( rule__MyField__Group_4__0__Impl rule__MyField__Group_4__1 )
            // InternalBug347012TestLanguage.g:1506:2: rule__MyField__Group_4__0__Impl rule__MyField__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__MyField__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group_4__1();

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
    // $ANTLR end "rule__MyField__Group_4__0"


    // $ANTLR start "rule__MyField__Group_4__0__Impl"
    // InternalBug347012TestLanguage.g:1513:1: rule__MyField__Group_4__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyField__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1517:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1518:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1518:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1519:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_0()); 
            // InternalBug347012TestLanguage.g:1520:2: ( RULE_LT )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_LT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1520:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__0__Impl"


    // $ANTLR start "rule__MyField__Group_4__1"
    // InternalBug347012TestLanguage.g:1528:1: rule__MyField__Group_4__1 : rule__MyField__Group_4__1__Impl rule__MyField__Group_4__2 ;
    public final void rule__MyField__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1532:1: ( rule__MyField__Group_4__1__Impl rule__MyField__Group_4__2 )
            // InternalBug347012TestLanguage.g:1533:2: rule__MyField__Group_4__1__Impl rule__MyField__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyField__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group_4__2();

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
    // $ANTLR end "rule__MyField__Group_4__1"


    // $ANTLR start "rule__MyField__Group_4__1__Impl"
    // InternalBug347012TestLanguage.g:1540:1: rule__MyField__Group_4__1__Impl : ( ',' ) ;
    public final void rule__MyField__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1544:1: ( ( ',' ) )
            // InternalBug347012TestLanguage.g:1545:1: ( ',' )
            {
            // InternalBug347012TestLanguage.g:1545:1: ( ',' )
            // InternalBug347012TestLanguage.g:1546:2: ','
            {
             before(grammarAccess.getMyFieldAccess().getCommaKeyword_4_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyFieldAccess().getCommaKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__1__Impl"


    // $ANTLR start "rule__MyField__Group_4__2"
    // InternalBug347012TestLanguage.g:1555:1: rule__MyField__Group_4__2 : rule__MyField__Group_4__2__Impl rule__MyField__Group_4__3 ;
    public final void rule__MyField__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1559:1: ( rule__MyField__Group_4__2__Impl rule__MyField__Group_4__3 )
            // InternalBug347012TestLanguage.g:1560:2: rule__MyField__Group_4__2__Impl rule__MyField__Group_4__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyField__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group_4__3();

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
    // $ANTLR end "rule__MyField__Group_4__2"


    // $ANTLR start "rule__MyField__Group_4__2__Impl"
    // InternalBug347012TestLanguage.g:1567:1: rule__MyField__Group_4__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyField__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1571:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1572:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1572:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1573:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_2()); 
            // InternalBug347012TestLanguage.g:1574:2: ( RULE_LT )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_LT) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1574:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__2__Impl"


    // $ANTLR start "rule__MyField__Group_4__3"
    // InternalBug347012TestLanguage.g:1582:1: rule__MyField__Group_4__3 : rule__MyField__Group_4__3__Impl ;
    public final void rule__MyField__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1586:1: ( rule__MyField__Group_4__3__Impl )
            // InternalBug347012TestLanguage.g:1587:2: rule__MyField__Group_4__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__Group_4__3__Impl();

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
    // $ANTLR end "rule__MyField__Group_4__3"


    // $ANTLR start "rule__MyField__Group_4__3__Impl"
    // InternalBug347012TestLanguage.g:1593:1: rule__MyField__Group_4__3__Impl : ( ( rule__MyField__BindingsAssignment_4_3 ) ) ;
    public final void rule__MyField__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1597:1: ( ( ( rule__MyField__BindingsAssignment_4_3 ) ) )
            // InternalBug347012TestLanguage.g:1598:1: ( ( rule__MyField__BindingsAssignment_4_3 ) )
            {
            // InternalBug347012TestLanguage.g:1598:1: ( ( rule__MyField__BindingsAssignment_4_3 ) )
            // InternalBug347012TestLanguage.g:1599:2: ( rule__MyField__BindingsAssignment_4_3 )
            {
             before(grammarAccess.getMyFieldAccess().getBindingsAssignment_4_3()); 
            // InternalBug347012TestLanguage.g:1600:2: ( rule__MyField__BindingsAssignment_4_3 )
            // InternalBug347012TestLanguage.g:1600:3: rule__MyField__BindingsAssignment_4_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyField__BindingsAssignment_4_3();

            state._fsp--;


            }

             after(grammarAccess.getMyFieldAccess().getBindingsAssignment_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__Group_4__3__Impl"


    // $ANTLR start "rule__MyBinding__Group__0"
    // InternalBug347012TestLanguage.g:1609:1: rule__MyBinding__Group__0 : rule__MyBinding__Group__0__Impl rule__MyBinding__Group__1 ;
    public final void rule__MyBinding__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1613:1: ( rule__MyBinding__Group__0__Impl rule__MyBinding__Group__1 )
            // InternalBug347012TestLanguage.g:1614:2: rule__MyBinding__Group__0__Impl rule__MyBinding__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__MyBinding__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group__1();

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
    // $ANTLR end "rule__MyBinding__Group__0"


    // $ANTLR start "rule__MyBinding__Group__0__Impl"
    // InternalBug347012TestLanguage.g:1621:1: rule__MyBinding__Group__0__Impl : ( ( rule__MyBinding__NameAssignment_0 ) ) ;
    public final void rule__MyBinding__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1625:1: ( ( ( rule__MyBinding__NameAssignment_0 ) ) )
            // InternalBug347012TestLanguage.g:1626:1: ( ( rule__MyBinding__NameAssignment_0 ) )
            {
            // InternalBug347012TestLanguage.g:1626:1: ( ( rule__MyBinding__NameAssignment_0 ) )
            // InternalBug347012TestLanguage.g:1627:2: ( rule__MyBinding__NameAssignment_0 )
            {
             before(grammarAccess.getMyBindingAccess().getNameAssignment_0()); 
            // InternalBug347012TestLanguage.g:1628:2: ( rule__MyBinding__NameAssignment_0 )
            // InternalBug347012TestLanguage.g:1628:3: rule__MyBinding__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMyBindingAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group__0__Impl"


    // $ANTLR start "rule__MyBinding__Group__1"
    // InternalBug347012TestLanguage.g:1636:1: rule__MyBinding__Group__1 : rule__MyBinding__Group__1__Impl rule__MyBinding__Group__2 ;
    public final void rule__MyBinding__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1640:1: ( rule__MyBinding__Group__1__Impl rule__MyBinding__Group__2 )
            // InternalBug347012TestLanguage.g:1641:2: rule__MyBinding__Group__1__Impl rule__MyBinding__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__MyBinding__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group__2();

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
    // $ANTLR end "rule__MyBinding__Group__1"


    // $ANTLR start "rule__MyBinding__Group__1__Impl"
    // InternalBug347012TestLanguage.g:1648:1: rule__MyBinding__Group__1__Impl : ( ( rule__MyBinding__Group_1__0 )? ) ;
    public final void rule__MyBinding__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1652:1: ( ( ( rule__MyBinding__Group_1__0 )? ) )
            // InternalBug347012TestLanguage.g:1653:1: ( ( rule__MyBinding__Group_1__0 )? )
            {
            // InternalBug347012TestLanguage.g:1653:1: ( ( rule__MyBinding__Group_1__0 )? )
            // InternalBug347012TestLanguage.g:1654:2: ( rule__MyBinding__Group_1__0 )?
            {
             before(grammarAccess.getMyBindingAccess().getGroup_1()); 
            // InternalBug347012TestLanguage.g:1655:2: ( rule__MyBinding__Group_1__0 )?
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalBug347012TestLanguage.g:1655:3: rule__MyBinding__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MyBinding__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMyBindingAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group__1__Impl"


    // $ANTLR start "rule__MyBinding__Group__2"
    // InternalBug347012TestLanguage.g:1663:1: rule__MyBinding__Group__2 : rule__MyBinding__Group__2__Impl ;
    public final void rule__MyBinding__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1667:1: ( rule__MyBinding__Group__2__Impl )
            // InternalBug347012TestLanguage.g:1668:2: rule__MyBinding__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group__2__Impl();

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
    // $ANTLR end "rule__MyBinding__Group__2"


    // $ANTLR start "rule__MyBinding__Group__2__Impl"
    // InternalBug347012TestLanguage.g:1674:1: rule__MyBinding__Group__2__Impl : ( ( rule__MyBinding__Group_2__0 )? ) ;
    public final void rule__MyBinding__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1678:1: ( ( ( rule__MyBinding__Group_2__0 )? ) )
            // InternalBug347012TestLanguage.g:1679:1: ( ( rule__MyBinding__Group_2__0 )? )
            {
            // InternalBug347012TestLanguage.g:1679:1: ( ( rule__MyBinding__Group_2__0 )? )
            // InternalBug347012TestLanguage.g:1680:2: ( rule__MyBinding__Group_2__0 )?
            {
             before(grammarAccess.getMyBindingAccess().getGroup_2()); 
            // InternalBug347012TestLanguage.g:1681:2: ( rule__MyBinding__Group_2__0 )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalBug347012TestLanguage.g:1681:3: rule__MyBinding__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MyBinding__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMyBindingAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group__2__Impl"


    // $ANTLR start "rule__MyBinding__Group_1__0"
    // InternalBug347012TestLanguage.g:1690:1: rule__MyBinding__Group_1__0 : rule__MyBinding__Group_1__0__Impl rule__MyBinding__Group_1__1 ;
    public final void rule__MyBinding__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1694:1: ( rule__MyBinding__Group_1__0__Impl rule__MyBinding__Group_1__1 )
            // InternalBug347012TestLanguage.g:1695:2: rule__MyBinding__Group_1__0__Impl rule__MyBinding__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__MyBinding__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_1__1();

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
    // $ANTLR end "rule__MyBinding__Group_1__0"


    // $ANTLR start "rule__MyBinding__Group_1__0__Impl"
    // InternalBug347012TestLanguage.g:1702:1: rule__MyBinding__Group_1__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1706:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1707:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1707:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1708:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_0()); 
            // InternalBug347012TestLanguage.g:1709:2: ( RULE_LT )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_LT) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1709:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__0__Impl"


    // $ANTLR start "rule__MyBinding__Group_1__1"
    // InternalBug347012TestLanguage.g:1717:1: rule__MyBinding__Group_1__1 : rule__MyBinding__Group_1__1__Impl rule__MyBinding__Group_1__2 ;
    public final void rule__MyBinding__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1721:1: ( rule__MyBinding__Group_1__1__Impl rule__MyBinding__Group_1__2 )
            // InternalBug347012TestLanguage.g:1722:2: rule__MyBinding__Group_1__1__Impl rule__MyBinding__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyBinding__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_1__2();

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
    // $ANTLR end "rule__MyBinding__Group_1__1"


    // $ANTLR start "rule__MyBinding__Group_1__1__Impl"
    // InternalBug347012TestLanguage.g:1729:1: rule__MyBinding__Group_1__1__Impl : ( ':' ) ;
    public final void rule__MyBinding__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1733:1: ( ( ':' ) )
            // InternalBug347012TestLanguage.g:1734:1: ( ':' )
            {
            // InternalBug347012TestLanguage.g:1734:1: ( ':' )
            // InternalBug347012TestLanguage.g:1735:2: ':'
            {
             before(grammarAccess.getMyBindingAccess().getColonKeyword_1_1()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyBindingAccess().getColonKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__1__Impl"


    // $ANTLR start "rule__MyBinding__Group_1__2"
    // InternalBug347012TestLanguage.g:1744:1: rule__MyBinding__Group_1__2 : rule__MyBinding__Group_1__2__Impl rule__MyBinding__Group_1__3 ;
    public final void rule__MyBinding__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1748:1: ( rule__MyBinding__Group_1__2__Impl rule__MyBinding__Group_1__3 )
            // InternalBug347012TestLanguage.g:1749:2: rule__MyBinding__Group_1__2__Impl rule__MyBinding__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__MyBinding__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_1__3();

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
    // $ANTLR end "rule__MyBinding__Group_1__2"


    // $ANTLR start "rule__MyBinding__Group_1__2__Impl"
    // InternalBug347012TestLanguage.g:1756:1: rule__MyBinding__Group_1__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1760:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1761:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1761:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1762:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_2()); 
            // InternalBug347012TestLanguage.g:1763:2: ( RULE_LT )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_LT) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1763:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__2__Impl"


    // $ANTLR start "rule__MyBinding__Group_1__3"
    // InternalBug347012TestLanguage.g:1771:1: rule__MyBinding__Group_1__3 : rule__MyBinding__Group_1__3__Impl ;
    public final void rule__MyBinding__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1775:1: ( rule__MyBinding__Group_1__3__Impl )
            // InternalBug347012TestLanguage.g:1776:2: rule__MyBinding__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_1__3__Impl();

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
    // $ANTLR end "rule__MyBinding__Group_1__3"


    // $ANTLR start "rule__MyBinding__Group_1__3__Impl"
    // InternalBug347012TestLanguage.g:1782:1: rule__MyBinding__Group_1__3__Impl : ( ( rule__MyBinding__TypeAssignment_1_3 ) ) ;
    public final void rule__MyBinding__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1786:1: ( ( ( rule__MyBinding__TypeAssignment_1_3 ) ) )
            // InternalBug347012TestLanguage.g:1787:1: ( ( rule__MyBinding__TypeAssignment_1_3 ) )
            {
            // InternalBug347012TestLanguage.g:1787:1: ( ( rule__MyBinding__TypeAssignment_1_3 ) )
            // InternalBug347012TestLanguage.g:1788:2: ( rule__MyBinding__TypeAssignment_1_3 )
            {
             before(grammarAccess.getMyBindingAccess().getTypeAssignment_1_3()); 
            // InternalBug347012TestLanguage.g:1789:2: ( rule__MyBinding__TypeAssignment_1_3 )
            // InternalBug347012TestLanguage.g:1789:3: rule__MyBinding__TypeAssignment_1_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__TypeAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getMyBindingAccess().getTypeAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_1__3__Impl"


    // $ANTLR start "rule__MyBinding__Group_2__0"
    // InternalBug347012TestLanguage.g:1798:1: rule__MyBinding__Group_2__0 : rule__MyBinding__Group_2__0__Impl rule__MyBinding__Group_2__1 ;
    public final void rule__MyBinding__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1802:1: ( rule__MyBinding__Group_2__0__Impl rule__MyBinding__Group_2__1 )
            // InternalBug347012TestLanguage.g:1803:2: rule__MyBinding__Group_2__0__Impl rule__MyBinding__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__MyBinding__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_2__1();

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
    // $ANTLR end "rule__MyBinding__Group_2__0"


    // $ANTLR start "rule__MyBinding__Group_2__0__Impl"
    // InternalBug347012TestLanguage.g:1810:1: rule__MyBinding__Group_2__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1814:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1815:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1815:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1816:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_0()); 
            // InternalBug347012TestLanguage.g:1817:2: ( RULE_LT )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_LT) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1817:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__0__Impl"


    // $ANTLR start "rule__MyBinding__Group_2__1"
    // InternalBug347012TestLanguage.g:1825:1: rule__MyBinding__Group_2__1 : rule__MyBinding__Group_2__1__Impl rule__MyBinding__Group_2__2 ;
    public final void rule__MyBinding__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1829:1: ( rule__MyBinding__Group_2__1__Impl rule__MyBinding__Group_2__2 )
            // InternalBug347012TestLanguage.g:1830:2: rule__MyBinding__Group_2__1__Impl rule__MyBinding__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__MyBinding__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_2__2();

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
    // $ANTLR end "rule__MyBinding__Group_2__1"


    // $ANTLR start "rule__MyBinding__Group_2__1__Impl"
    // InternalBug347012TestLanguage.g:1837:1: rule__MyBinding__Group_2__1__Impl : ( '=' ) ;
    public final void rule__MyBinding__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1841:1: ( ( '=' ) )
            // InternalBug347012TestLanguage.g:1842:1: ( '=' )
            {
            // InternalBug347012TestLanguage.g:1842:1: ( '=' )
            // InternalBug347012TestLanguage.g:1843:2: '='
            {
             before(grammarAccess.getMyBindingAccess().getEqualsSignKeyword_2_1()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyBindingAccess().getEqualsSignKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__1__Impl"


    // $ANTLR start "rule__MyBinding__Group_2__2"
    // InternalBug347012TestLanguage.g:1852:1: rule__MyBinding__Group_2__2 : rule__MyBinding__Group_2__2__Impl rule__MyBinding__Group_2__3 ;
    public final void rule__MyBinding__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1856:1: ( rule__MyBinding__Group_2__2__Impl rule__MyBinding__Group_2__3 )
            // InternalBug347012TestLanguage.g:1857:2: rule__MyBinding__Group_2__2__Impl rule__MyBinding__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__MyBinding__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_2__3();

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
    // $ANTLR end "rule__MyBinding__Group_2__2"


    // $ANTLR start "rule__MyBinding__Group_2__2__Impl"
    // InternalBug347012TestLanguage.g:1864:1: rule__MyBinding__Group_2__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1868:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1869:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1869:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1870:2: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_2()); 
            // InternalBug347012TestLanguage.g:1871:2: ( RULE_LT )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_LT) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1871:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_4); 

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__2__Impl"


    // $ANTLR start "rule__MyBinding__Group_2__3"
    // InternalBug347012TestLanguage.g:1879:1: rule__MyBinding__Group_2__3 : rule__MyBinding__Group_2__3__Impl ;
    public final void rule__MyBinding__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1883:1: ( rule__MyBinding__Group_2__3__Impl )
            // InternalBug347012TestLanguage.g:1884:2: rule__MyBinding__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__Group_2__3__Impl();

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
    // $ANTLR end "rule__MyBinding__Group_2__3"


    // $ANTLR start "rule__MyBinding__Group_2__3__Impl"
    // InternalBug347012TestLanguage.g:1890:1: rule__MyBinding__Group_2__3__Impl : ( ( rule__MyBinding__ExpressionAssignment_2_3 ) ) ;
    public final void rule__MyBinding__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1894:1: ( ( ( rule__MyBinding__ExpressionAssignment_2_3 ) ) )
            // InternalBug347012TestLanguage.g:1895:1: ( ( rule__MyBinding__ExpressionAssignment_2_3 ) )
            {
            // InternalBug347012TestLanguage.g:1895:1: ( ( rule__MyBinding__ExpressionAssignment_2_3 ) )
            // InternalBug347012TestLanguage.g:1896:2: ( rule__MyBinding__ExpressionAssignment_2_3 )
            {
             before(grammarAccess.getMyBindingAccess().getExpressionAssignment_2_3()); 
            // InternalBug347012TestLanguage.g:1897:2: ( rule__MyBinding__ExpressionAssignment_2_3 )
            // InternalBug347012TestLanguage.g:1897:3: rule__MyBinding__ExpressionAssignment_2_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MyBinding__ExpressionAssignment_2_3();

            state._fsp--;


            }

             after(grammarAccess.getMyBindingAccess().getExpressionAssignment_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__Group_2__3__Impl"


    // $ANTLR start "rule__MyProgram__PackageAssignment_2"
    // InternalBug347012TestLanguage.g:1906:1: rule__MyProgram__PackageAssignment_2 : ( ruleMyPackage ) ;
    public final void rule__MyProgram__PackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1910:1: ( ( ruleMyPackage ) )
            // InternalBug347012TestLanguage.g:1911:2: ( ruleMyPackage )
            {
            // InternalBug347012TestLanguage.g:1911:2: ( ruleMyPackage )
            // InternalBug347012TestLanguage.g:1912:3: ruleMyPackage
            {
             before(grammarAccess.getMyProgramAccess().getPackageMyPackageParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyPackage();

            state._fsp--;

             after(grammarAccess.getMyProgramAccess().getPackageMyPackageParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyProgram__PackageAssignment_2"


    // $ANTLR start "rule__Identifier__NameAssignment"
    // InternalBug347012TestLanguage.g:1921:1: rule__Identifier__NameAssignment : ( RULE_ID ) ;
    public final void rule__Identifier__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1925:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:1926:2: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:1926:2: ( RULE_ID )
            // InternalBug347012TestLanguage.g:1927:3: RULE_ID
            {
             before(grammarAccess.getIdentifierAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getIdentifierAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Identifier__NameAssignment"


    // $ANTLR start "rule__Literal__NumAssignment_0"
    // InternalBug347012TestLanguage.g:1936:1: rule__Literal__NumAssignment_0 : ( RULE_NUMBER ) ;
    public final void rule__Literal__NumAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1940:1: ( ( RULE_NUMBER ) )
            // InternalBug347012TestLanguage.g:1941:2: ( RULE_NUMBER )
            {
            // InternalBug347012TestLanguage.g:1941:2: ( RULE_NUMBER )
            // InternalBug347012TestLanguage.g:1942:3: RULE_NUMBER
            {
             before(grammarAccess.getLiteralAccess().getNumNUMBERTerminalRuleCall_0_0()); 
            match(input,RULE_NUMBER,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getNumNUMBERTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__NumAssignment_0"


    // $ANTLR start "rule__Literal__StrAssignment_1"
    // InternalBug347012TestLanguage.g:1951:1: rule__Literal__StrAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Literal__StrAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1955:1: ( ( RULE_STRING ) )
            // InternalBug347012TestLanguage.g:1956:2: ( RULE_STRING )
            {
            // InternalBug347012TestLanguage.g:1956:2: ( RULE_STRING )
            // InternalBug347012TestLanguage.g:1957:3: RULE_STRING
            {
             before(grammarAccess.getLiteralAccess().getStrSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getStrSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__StrAssignment_1"


    // $ANTLR start "rule__Literal__BoolAssignment_2"
    // InternalBug347012TestLanguage.g:1966:1: rule__Literal__BoolAssignment_2 : ( ( 'true' ) ) ;
    public final void rule__Literal__BoolAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1970:1: ( ( ( 'true' ) ) )
            // InternalBug347012TestLanguage.g:1971:2: ( ( 'true' ) )
            {
            // InternalBug347012TestLanguage.g:1971:2: ( ( 'true' ) )
            // InternalBug347012TestLanguage.g:1972:3: ( 'true' )
            {
             before(grammarAccess.getLiteralAccess().getBoolTrueKeyword_2_0()); 
            // InternalBug347012TestLanguage.g:1973:3: ( 'true' )
            // InternalBug347012TestLanguage.g:1974:4: 'true'
            {
             before(grammarAccess.getLiteralAccess().getBoolTrueKeyword_2_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getBoolTrueKeyword_2_0()); 

            }

             after(grammarAccess.getLiteralAccess().getBoolTrueKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__BoolAssignment_2"


    // $ANTLR start "rule__Literal__BoolAssignment_3"
    // InternalBug347012TestLanguage.g:1985:1: rule__Literal__BoolAssignment_3 : ( ( 'false' ) ) ;
    public final void rule__Literal__BoolAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:1989:1: ( ( ( 'false' ) ) )
            // InternalBug347012TestLanguage.g:1990:2: ( ( 'false' ) )
            {
            // InternalBug347012TestLanguage.g:1990:2: ( ( 'false' ) )
            // InternalBug347012TestLanguage.g:1991:3: ( 'false' )
            {
             before(grammarAccess.getLiteralAccess().getBoolFalseKeyword_3_0()); 
            // InternalBug347012TestLanguage.g:1992:3: ( 'false' )
            // InternalBug347012TestLanguage.g:1993:4: 'false'
            {
             before(grammarAccess.getLiteralAccess().getBoolFalseKeyword_3_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getBoolFalseKeyword_3_0()); 

            }

             after(grammarAccess.getLiteralAccess().getBoolFalseKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__BoolAssignment_3"


    // $ANTLR start "rule__MyPackage__NameAssignment_2"
    // InternalBug347012TestLanguage.g:2004:1: rule__MyPackage__NameAssignment_2 : ( ruleFQN ) ;
    public final void rule__MyPackage__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2008:1: ( ( ruleFQN ) )
            // InternalBug347012TestLanguage.g:2009:2: ( ruleFQN )
            {
            // InternalBug347012TestLanguage.g:2009:2: ( ruleFQN )
            // InternalBug347012TestLanguage.g:2010:3: ruleFQN
            {
             before(grammarAccess.getMyPackageAccess().getNameFQNParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getMyPackageAccess().getNameFQNParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__NameAssignment_2"


    // $ANTLR start "rule__MyPackage__DirectivesAssignment_6_0"
    // InternalBug347012TestLanguage.g:2019:1: rule__MyPackage__DirectivesAssignment_6_0 : ( ruleMyClass ) ;
    public final void rule__MyPackage__DirectivesAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2023:1: ( ( ruleMyClass ) )
            // InternalBug347012TestLanguage.g:2024:2: ( ruleMyClass )
            {
            // InternalBug347012TestLanguage.g:2024:2: ( ruleMyClass )
            // InternalBug347012TestLanguage.g:2025:3: ruleMyClass
            {
             before(grammarAccess.getMyPackageAccess().getDirectivesMyClassParserRuleCall_6_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyClass();

            state._fsp--;

             after(grammarAccess.getMyPackageAccess().getDirectivesMyClassParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyPackage__DirectivesAssignment_6_0"


    // $ANTLR start "rule__MyClass__NameAssignment_3"
    // InternalBug347012TestLanguage.g:2034:1: rule__MyClass__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__MyClass__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2038:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:2039:2: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:2039:2: ( RULE_ID )
            // InternalBug347012TestLanguage.g:2040:3: RULE_ID
            {
             before(grammarAccess.getMyClassAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyClassAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__NameAssignment_3"


    // $ANTLR start "rule__MyClass__DirectivesAssignment_7_0"
    // InternalBug347012TestLanguage.g:2049:1: rule__MyClass__DirectivesAssignment_7_0 : ( ruleMyField ) ;
    public final void rule__MyClass__DirectivesAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2053:1: ( ( ruleMyField ) )
            // InternalBug347012TestLanguage.g:2054:2: ( ruleMyField )
            {
            // InternalBug347012TestLanguage.g:2054:2: ( ruleMyField )
            // InternalBug347012TestLanguage.g:2055:3: ruleMyField
            {
             before(grammarAccess.getMyClassAccess().getDirectivesMyFieldParserRuleCall_7_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyField();

            state._fsp--;

             after(grammarAccess.getMyClassAccess().getDirectivesMyFieldParserRuleCall_7_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyClass__DirectivesAssignment_7_0"


    // $ANTLR start "rule__MyAttribute__PUBLICAssignment_0"
    // InternalBug347012TestLanguage.g:2064:1: rule__MyAttribute__PUBLICAssignment_0 : ( ( 'public' ) ) ;
    public final void rule__MyAttribute__PUBLICAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2068:1: ( ( ( 'public' ) ) )
            // InternalBug347012TestLanguage.g:2069:2: ( ( 'public' ) )
            {
            // InternalBug347012TestLanguage.g:2069:2: ( ( 'public' ) )
            // InternalBug347012TestLanguage.g:2070:3: ( 'public' )
            {
             before(grammarAccess.getMyAttributeAccess().getPUBLICPublicKeyword_0_0()); 
            // InternalBug347012TestLanguage.g:2071:3: ( 'public' )
            // InternalBug347012TestLanguage.g:2072:4: 'public'
            {
             before(grammarAccess.getMyAttributeAccess().getPUBLICPublicKeyword_0_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyAttributeAccess().getPUBLICPublicKeyword_0_0()); 

            }

             after(grammarAccess.getMyAttributeAccess().getPUBLICPublicKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttribute__PUBLICAssignment_0"


    // $ANTLR start "rule__MyAttribute__PRIVATEAssignment_1"
    // InternalBug347012TestLanguage.g:2083:1: rule__MyAttribute__PRIVATEAssignment_1 : ( ( 'private' ) ) ;
    public final void rule__MyAttribute__PRIVATEAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2087:1: ( ( ( 'private' ) ) )
            // InternalBug347012TestLanguage.g:2088:2: ( ( 'private' ) )
            {
            // InternalBug347012TestLanguage.g:2088:2: ( ( 'private' ) )
            // InternalBug347012TestLanguage.g:2089:3: ( 'private' )
            {
             before(grammarAccess.getMyAttributeAccess().getPRIVATEPrivateKeyword_1_0()); 
            // InternalBug347012TestLanguage.g:2090:3: ( 'private' )
            // InternalBug347012TestLanguage.g:2091:4: 'private'
            {
             before(grammarAccess.getMyAttributeAccess().getPRIVATEPrivateKeyword_1_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyAttributeAccess().getPRIVATEPrivateKeyword_1_0()); 

            }

             after(grammarAccess.getMyAttributeAccess().getPRIVATEPrivateKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttribute__PRIVATEAssignment_1"


    // $ANTLR start "rule__MyAttributes__AttributesAssignment_1"
    // InternalBug347012TestLanguage.g:2102:1: rule__MyAttributes__AttributesAssignment_1 : ( ruleMyAttribute ) ;
    public final void rule__MyAttributes__AttributesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2106:1: ( ( ruleMyAttribute ) )
            // InternalBug347012TestLanguage.g:2107:2: ( ruleMyAttribute )
            {
            // InternalBug347012TestLanguage.g:2107:2: ( ruleMyAttribute )
            // InternalBug347012TestLanguage.g:2108:3: ruleMyAttribute
            {
             before(grammarAccess.getMyAttributesAccess().getAttributesMyAttributeParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyAttribute();

            state._fsp--;

             after(grammarAccess.getMyAttributesAccess().getAttributesMyAttributeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyAttributes__AttributesAssignment_1"


    // $ANTLR start "rule__MyField__AttrAssignment_0"
    // InternalBug347012TestLanguage.g:2117:1: rule__MyField__AttrAssignment_0 : ( ruleMyAttributes ) ;
    public final void rule__MyField__AttrAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2121:1: ( ( ruleMyAttributes ) )
            // InternalBug347012TestLanguage.g:2122:2: ( ruleMyAttributes )
            {
            // InternalBug347012TestLanguage.g:2122:2: ( ruleMyAttributes )
            // InternalBug347012TestLanguage.g:2123:3: ruleMyAttributes
            {
             before(grammarAccess.getMyFieldAccess().getAttrMyAttributesParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyAttributes();

            state._fsp--;

             after(grammarAccess.getMyFieldAccess().getAttrMyAttributesParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__AttrAssignment_0"


    // $ANTLR start "rule__MyField__BindingsAssignment_3"
    // InternalBug347012TestLanguage.g:2132:1: rule__MyField__BindingsAssignment_3 : ( ruleMyBinding ) ;
    public final void rule__MyField__BindingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2136:1: ( ( ruleMyBinding ) )
            // InternalBug347012TestLanguage.g:2137:2: ( ruleMyBinding )
            {
            // InternalBug347012TestLanguage.g:2137:2: ( ruleMyBinding )
            // InternalBug347012TestLanguage.g:2138:3: ruleMyBinding
            {
             before(grammarAccess.getMyFieldAccess().getBindingsMyBindingParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyBinding();

            state._fsp--;

             after(grammarAccess.getMyFieldAccess().getBindingsMyBindingParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__BindingsAssignment_3"


    // $ANTLR start "rule__MyField__BindingsAssignment_4_3"
    // InternalBug347012TestLanguage.g:2147:1: rule__MyField__BindingsAssignment_4_3 : ( ruleMyBinding ) ;
    public final void rule__MyField__BindingsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2151:1: ( ( ruleMyBinding ) )
            // InternalBug347012TestLanguage.g:2152:2: ( ruleMyBinding )
            {
            // InternalBug347012TestLanguage.g:2152:2: ( ruleMyBinding )
            // InternalBug347012TestLanguage.g:2153:3: ruleMyBinding
            {
             before(grammarAccess.getMyFieldAccess().getBindingsMyBindingParserRuleCall_4_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyBinding();

            state._fsp--;

             after(grammarAccess.getMyFieldAccess().getBindingsMyBindingParserRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyField__BindingsAssignment_4_3"


    // $ANTLR start "rule__MyBinding__NameAssignment_0"
    // InternalBug347012TestLanguage.g:2162:1: rule__MyBinding__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__MyBinding__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2166:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:2167:2: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:2167:2: ( RULE_ID )
            // InternalBug347012TestLanguage.g:2168:3: RULE_ID
            {
             before(grammarAccess.getMyBindingAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMyBindingAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__NameAssignment_0"


    // $ANTLR start "rule__MyBinding__TypeAssignment_1_3"
    // InternalBug347012TestLanguage.g:2177:1: rule__MyBinding__TypeAssignment_1_3 : ( ruleFQN ) ;
    public final void rule__MyBinding__TypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2181:1: ( ( ruleFQN ) )
            // InternalBug347012TestLanguage.g:2182:2: ( ruleFQN )
            {
            // InternalBug347012TestLanguage.g:2182:2: ( ruleFQN )
            // InternalBug347012TestLanguage.g:2183:3: ruleFQN
            {
             before(grammarAccess.getMyBindingAccess().getTypeFQNParserRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getMyBindingAccess().getTypeFQNParserRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__TypeAssignment_1_3"


    // $ANTLR start "rule__MyBinding__ExpressionAssignment_2_3"
    // InternalBug347012TestLanguage.g:2192:1: rule__MyBinding__ExpressionAssignment_2_3 : ( ruleMyPrimary ) ;
    public final void rule__MyBinding__ExpressionAssignment_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug347012TestLanguage.g:2196:1: ( ( ruleMyPrimary ) )
            // InternalBug347012TestLanguage.g:2197:2: ( ruleMyPrimary )
            {
            // InternalBug347012TestLanguage.g:2197:2: ( ruleMyPrimary )
            // InternalBug347012TestLanguage.g:2198:3: ruleMyPrimary
            {
             before(grammarAccess.getMyBindingAccess().getExpressionMyPrimaryParserRuleCall_2_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyPrimary();

            state._fsp--;

             after(grammarAccess.getMyBindingAccess().getExpressionMyPrimaryParserRuleCall_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyBinding__ExpressionAssignment_2_3"

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String dfa_1s = "\5\uffff";
    static final String dfa_2s = "\1\1\1\uffff\1\1\2\uffff";
    static final String dfa_3s = "\1\4\1\uffff\1\4\1\uffff\1\4";
    static final String dfa_4s = "\1\27\1\uffff\1\32\1\uffff\1\32";
    static final String dfa_5s = "\1\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String dfa_6s = "\5\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\10\uffff\1\1\1\3\1\uffff\1\1\4\uffff\1\1\1\uffff\1\1",
            "",
            "\1\4\11\uffff\1\3\1\uffff\3\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1",
            "",
            "\1\4\11\uffff\1\3\1\uffff\3\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 601:2: ( rule__FQN__Group_1__0 )*";
        }
    }
    static final String dfa_8s = "\2\uffff\1\1\2\uffff";
    static final String dfa_9s = "\1\25\1\uffff\1\32\1\uffff\1\32";
    static final String[] dfa_10s = {
            "\1\2\10\uffff\1\1\7\uffff\1\3",
            "",
            "\1\4\14\uffff\2\1\1\uffff\1\1\1\3\4\uffff\1\1",
            "",
            "\1\4\14\uffff\2\1\1\uffff\1\1\1\3\4\uffff\1\1"
    };
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[][] dfa_10 = unpackEncodedStringArray(dfa_10s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_1;
            this.eof = dfa_8;
            this.min = dfa_3;
            this.max = dfa_9;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_10;
        }
        public String getDescription() {
            return "()* loopback of 1466:2: ( rule__MyField__Group_4__0 )*";
        }
    }
    static final String dfa_11s = "\2\3\3\uffff";
    static final String dfa_12s = "\2\4\2\uffff\1\4";
    static final String dfa_13s = "\1\27\1\32\2\uffff\1\32";
    static final String dfa_14s = "\2\uffff\1\1\1\2\1\uffff";
    static final String[] dfa_15s = {
            "\1\1\10\uffff\1\3\7\uffff\1\3\1\2\1\3",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\2\1\3\2\uffff\1\3",
            "",
            "",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\2\1\3\2\uffff\1\3"
    };
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final char[] dfa_12 = DFA.unpackEncodedStringToUnsignedChars(dfa_12s);
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[][] dfa_15 = unpackEncodedStringArray(dfa_15s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_1;
            this.eof = dfa_11;
            this.min = dfa_12;
            this.max = dfa_13;
            this.accept = dfa_14;
            this.special = dfa_6;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "1655:2: ( rule__MyBinding__Group_1__0 )?";
        }
    }
    static final String[] dfa_16s = {
            "\1\1\10\uffff\1\3\7\uffff\1\3\1\uffff\1\2",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\uffff\1\2\2\uffff\1\3",
            "",
            "",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\uffff\1\2\2\uffff\1\3"
    };
    static final short[][] dfa_16 = unpackEncodedStringArray(dfa_16s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_1;
            this.eof = dfa_11;
            this.min = dfa_12;
            this.max = dfa_13;
            this.accept = dfa_14;
            this.special = dfa_6;
            this.transition = dfa_16;
        }
        public String getDescription() {
            return "1681:2: ( rule__MyBinding__Group_2__0 )?";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000E0010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000C0002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004060010L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004040002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004040000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000202010L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200012L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000030000F0L});
    }


}
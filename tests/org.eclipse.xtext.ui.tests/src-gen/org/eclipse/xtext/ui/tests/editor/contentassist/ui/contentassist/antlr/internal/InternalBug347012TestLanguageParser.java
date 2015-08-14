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
    public static final int RULE_ESCAPE=11;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_LT=4;
    public static final int T__19=19;
    public static final int RULE_HEX=12;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_NUMBER=6;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_IDPLAINCHAR=8;
    public static final int RULE_WS=10;
    public static final int RULE_DIGIT=9;

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
    // InternalBug347012TestLanguage.g:60:1: entryRuleMyProgram : ruleMyProgram EOF ;
    public final void entryRuleMyProgram() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:61:1: ( ruleMyProgram EOF )
            // InternalBug347012TestLanguage.g:62:1: ruleMyProgram EOF
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
    // InternalBug347012TestLanguage.g:69:1: ruleMyProgram : ( ( rule__MyProgram__Group__0 ) ) ;
    public final void ruleMyProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:73:2: ( ( ( rule__MyProgram__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:74:1: ( ( rule__MyProgram__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:74:1: ( ( rule__MyProgram__Group__0 ) )
            // InternalBug347012TestLanguage.g:75:1: ( rule__MyProgram__Group__0 )
            {
             before(grammarAccess.getMyProgramAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:76:1: ( rule__MyProgram__Group__0 )
            // InternalBug347012TestLanguage.g:76:2: rule__MyProgram__Group__0
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
    // InternalBug347012TestLanguage.g:88:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:89:1: ( ruleIdentifier EOF )
            // InternalBug347012TestLanguage.g:90:1: ruleIdentifier EOF
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
    // InternalBug347012TestLanguage.g:97:1: ruleIdentifier : ( ( rule__Identifier__NameAssignment ) ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:101:2: ( ( ( rule__Identifier__NameAssignment ) ) )
            // InternalBug347012TestLanguage.g:102:1: ( ( rule__Identifier__NameAssignment ) )
            {
            // InternalBug347012TestLanguage.g:102:1: ( ( rule__Identifier__NameAssignment ) )
            // InternalBug347012TestLanguage.g:103:1: ( rule__Identifier__NameAssignment )
            {
             before(grammarAccess.getIdentifierAccess().getNameAssignment()); 
            // InternalBug347012TestLanguage.g:104:1: ( rule__Identifier__NameAssignment )
            // InternalBug347012TestLanguage.g:104:2: rule__Identifier__NameAssignment
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
    // InternalBug347012TestLanguage.g:116:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:117:1: ( ruleFQN EOF )
            // InternalBug347012TestLanguage.g:118:1: ruleFQN EOF
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
    // InternalBug347012TestLanguage.g:125:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:129:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:130:1: ( ( rule__FQN__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:130:1: ( ( rule__FQN__Group__0 ) )
            // InternalBug347012TestLanguage.g:131:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:132:1: ( rule__FQN__Group__0 )
            // InternalBug347012TestLanguage.g:132:2: rule__FQN__Group__0
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
    // InternalBug347012TestLanguage.g:144:1: entryRuleVirtualSemi : ruleVirtualSemi EOF ;
    public final void entryRuleVirtualSemi() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:145:1: ( ruleVirtualSemi EOF )
            // InternalBug347012TestLanguage.g:146:1: ruleVirtualSemi EOF
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
    // InternalBug347012TestLanguage.g:153:1: ruleVirtualSemi : ( ( rule__VirtualSemi__Alternatives ) ) ;
    public final void ruleVirtualSemi() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:157:2: ( ( ( rule__VirtualSemi__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:158:1: ( ( rule__VirtualSemi__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:158:1: ( ( rule__VirtualSemi__Alternatives ) )
            // InternalBug347012TestLanguage.g:159:1: ( rule__VirtualSemi__Alternatives )
            {
             before(grammarAccess.getVirtualSemiAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:160:1: ( rule__VirtualSemi__Alternatives )
            // InternalBug347012TestLanguage.g:160:2: rule__VirtualSemi__Alternatives
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
    // InternalBug347012TestLanguage.g:172:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:173:1: ( ruleLiteral EOF )
            // InternalBug347012TestLanguage.g:174:1: ruleLiteral EOF
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
    // InternalBug347012TestLanguage.g:181:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:185:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:186:1: ( ( rule__Literal__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:186:1: ( ( rule__Literal__Alternatives ) )
            // InternalBug347012TestLanguage.g:187:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:188:1: ( rule__Literal__Alternatives )
            // InternalBug347012TestLanguage.g:188:2: rule__Literal__Alternatives
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
    // InternalBug347012TestLanguage.g:200:1: entryRuleMyPrimary : ruleMyPrimary EOF ;
    public final void entryRuleMyPrimary() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:201:1: ( ruleMyPrimary EOF )
            // InternalBug347012TestLanguage.g:202:1: ruleMyPrimary EOF
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
    // InternalBug347012TestLanguage.g:209:1: ruleMyPrimary : ( ( rule__MyPrimary__Alternatives ) ) ;
    public final void ruleMyPrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:213:2: ( ( ( rule__MyPrimary__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:214:1: ( ( rule__MyPrimary__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:214:1: ( ( rule__MyPrimary__Alternatives ) )
            // InternalBug347012TestLanguage.g:215:1: ( rule__MyPrimary__Alternatives )
            {
             before(grammarAccess.getMyPrimaryAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:216:1: ( rule__MyPrimary__Alternatives )
            // InternalBug347012TestLanguage.g:216:2: rule__MyPrimary__Alternatives
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
    // InternalBug347012TestLanguage.g:228:1: entryRuleMyPackage : ruleMyPackage EOF ;
    public final void entryRuleMyPackage() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:229:1: ( ruleMyPackage EOF )
            // InternalBug347012TestLanguage.g:230:1: ruleMyPackage EOF
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
    // InternalBug347012TestLanguage.g:237:1: ruleMyPackage : ( ( rule__MyPackage__Group__0 ) ) ;
    public final void ruleMyPackage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:241:2: ( ( ( rule__MyPackage__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:242:1: ( ( rule__MyPackage__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:242:1: ( ( rule__MyPackage__Group__0 ) )
            // InternalBug347012TestLanguage.g:243:1: ( rule__MyPackage__Group__0 )
            {
             before(grammarAccess.getMyPackageAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:244:1: ( rule__MyPackage__Group__0 )
            // InternalBug347012TestLanguage.g:244:2: rule__MyPackage__Group__0
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
    // InternalBug347012TestLanguage.g:256:1: entryRuleMyClass : ruleMyClass EOF ;
    public final void entryRuleMyClass() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:257:1: ( ruleMyClass EOF )
            // InternalBug347012TestLanguage.g:258:1: ruleMyClass EOF
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
    // InternalBug347012TestLanguage.g:265:1: ruleMyClass : ( ( rule__MyClass__Group__0 ) ) ;
    public final void ruleMyClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:269:2: ( ( ( rule__MyClass__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:270:1: ( ( rule__MyClass__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:270:1: ( ( rule__MyClass__Group__0 ) )
            // InternalBug347012TestLanguage.g:271:1: ( rule__MyClass__Group__0 )
            {
             before(grammarAccess.getMyClassAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:272:1: ( rule__MyClass__Group__0 )
            // InternalBug347012TestLanguage.g:272:2: rule__MyClass__Group__0
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
    // InternalBug347012TestLanguage.g:284:1: entryRuleMyAttribute : ruleMyAttribute EOF ;
    public final void entryRuleMyAttribute() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:285:1: ( ruleMyAttribute EOF )
            // InternalBug347012TestLanguage.g:286:1: ruleMyAttribute EOF
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
    // InternalBug347012TestLanguage.g:293:1: ruleMyAttribute : ( ( rule__MyAttribute__Alternatives ) ) ;
    public final void ruleMyAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:297:2: ( ( ( rule__MyAttribute__Alternatives ) ) )
            // InternalBug347012TestLanguage.g:298:1: ( ( rule__MyAttribute__Alternatives ) )
            {
            // InternalBug347012TestLanguage.g:298:1: ( ( rule__MyAttribute__Alternatives ) )
            // InternalBug347012TestLanguage.g:299:1: ( rule__MyAttribute__Alternatives )
            {
             before(grammarAccess.getMyAttributeAccess().getAlternatives()); 
            // InternalBug347012TestLanguage.g:300:1: ( rule__MyAttribute__Alternatives )
            // InternalBug347012TestLanguage.g:300:2: rule__MyAttribute__Alternatives
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
    // InternalBug347012TestLanguage.g:312:1: entryRuleMyAttributes : ruleMyAttributes EOF ;
    public final void entryRuleMyAttributes() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:313:1: ( ruleMyAttributes EOF )
            // InternalBug347012TestLanguage.g:314:1: ruleMyAttributes EOF
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
    // InternalBug347012TestLanguage.g:321:1: ruleMyAttributes : ( ( rule__MyAttributes__Group__0 ) ) ;
    public final void ruleMyAttributes() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:325:2: ( ( ( rule__MyAttributes__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:326:1: ( ( rule__MyAttributes__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:326:1: ( ( rule__MyAttributes__Group__0 ) )
            // InternalBug347012TestLanguage.g:327:1: ( rule__MyAttributes__Group__0 )
            {
             before(grammarAccess.getMyAttributesAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:328:1: ( rule__MyAttributes__Group__0 )
            // InternalBug347012TestLanguage.g:328:2: rule__MyAttributes__Group__0
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
    // InternalBug347012TestLanguage.g:340:1: entryRuleMyField : ruleMyField EOF ;
    public final void entryRuleMyField() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:341:1: ( ruleMyField EOF )
            // InternalBug347012TestLanguage.g:342:1: ruleMyField EOF
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
    // InternalBug347012TestLanguage.g:349:1: ruleMyField : ( ( rule__MyField__Group__0 ) ) ;
    public final void ruleMyField() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:353:2: ( ( ( rule__MyField__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:354:1: ( ( rule__MyField__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:354:1: ( ( rule__MyField__Group__0 ) )
            // InternalBug347012TestLanguage.g:355:1: ( rule__MyField__Group__0 )
            {
             before(grammarAccess.getMyFieldAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:356:1: ( rule__MyField__Group__0 )
            // InternalBug347012TestLanguage.g:356:2: rule__MyField__Group__0
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
    // InternalBug347012TestLanguage.g:368:1: entryRuleMyBinding : ruleMyBinding EOF ;
    public final void entryRuleMyBinding() throws RecognitionException {
        try {
            // InternalBug347012TestLanguage.g:369:1: ( ruleMyBinding EOF )
            // InternalBug347012TestLanguage.g:370:1: ruleMyBinding EOF
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
    // InternalBug347012TestLanguage.g:377:1: ruleMyBinding : ( ( rule__MyBinding__Group__0 ) ) ;
    public final void ruleMyBinding() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:381:2: ( ( ( rule__MyBinding__Group__0 ) ) )
            // InternalBug347012TestLanguage.g:382:1: ( ( rule__MyBinding__Group__0 ) )
            {
            // InternalBug347012TestLanguage.g:382:1: ( ( rule__MyBinding__Group__0 ) )
            // InternalBug347012TestLanguage.g:383:1: ( rule__MyBinding__Group__0 )
            {
             before(grammarAccess.getMyBindingAccess().getGroup()); 
            // InternalBug347012TestLanguage.g:384:1: ( rule__MyBinding__Group__0 )
            // InternalBug347012TestLanguage.g:384:2: rule__MyBinding__Group__0
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
    // InternalBug347012TestLanguage.g:396:1: rule__VirtualSemi__Alternatives : ( ( ';' ) | ( RULE_LT ) );
    public final void rule__VirtualSemi__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:400:1: ( ( ';' ) | ( RULE_LT ) )
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
                    // InternalBug347012TestLanguage.g:401:1: ( ';' )
                    {
                    // InternalBug347012TestLanguage.g:401:1: ( ';' )
                    // InternalBug347012TestLanguage.g:402:1: ';'
                    {
                     before(grammarAccess.getVirtualSemiAccess().getSemicolonKeyword_0()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getVirtualSemiAccess().getSemicolonKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug347012TestLanguage.g:409:6: ( RULE_LT )
                    {
                    // InternalBug347012TestLanguage.g:409:6: ( RULE_LT )
                    // InternalBug347012TestLanguage.g:410:1: RULE_LT
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
    // InternalBug347012TestLanguage.g:420:1: rule__Literal__Alternatives : ( ( ( rule__Literal__NumAssignment_0 ) ) | ( ( rule__Literal__StrAssignment_1 ) ) | ( ( rule__Literal__BoolAssignment_2 ) ) | ( ( rule__Literal__BoolAssignment_3 ) ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:424:1: ( ( ( rule__Literal__NumAssignment_0 ) ) | ( ( rule__Literal__StrAssignment_1 ) ) | ( ( rule__Literal__BoolAssignment_2 ) ) | ( ( rule__Literal__BoolAssignment_3 ) ) )
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
                    // InternalBug347012TestLanguage.g:425:1: ( ( rule__Literal__NumAssignment_0 ) )
                    {
                    // InternalBug347012TestLanguage.g:425:1: ( ( rule__Literal__NumAssignment_0 ) )
                    // InternalBug347012TestLanguage.g:426:1: ( rule__Literal__NumAssignment_0 )
                    {
                     before(grammarAccess.getLiteralAccess().getNumAssignment_0()); 
                    // InternalBug347012TestLanguage.g:427:1: ( rule__Literal__NumAssignment_0 )
                    // InternalBug347012TestLanguage.g:427:2: rule__Literal__NumAssignment_0
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
                    // InternalBug347012TestLanguage.g:431:6: ( ( rule__Literal__StrAssignment_1 ) )
                    {
                    // InternalBug347012TestLanguage.g:431:6: ( ( rule__Literal__StrAssignment_1 ) )
                    // InternalBug347012TestLanguage.g:432:1: ( rule__Literal__StrAssignment_1 )
                    {
                     before(grammarAccess.getLiteralAccess().getStrAssignment_1()); 
                    // InternalBug347012TestLanguage.g:433:1: ( rule__Literal__StrAssignment_1 )
                    // InternalBug347012TestLanguage.g:433:2: rule__Literal__StrAssignment_1
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
                    // InternalBug347012TestLanguage.g:437:6: ( ( rule__Literal__BoolAssignment_2 ) )
                    {
                    // InternalBug347012TestLanguage.g:437:6: ( ( rule__Literal__BoolAssignment_2 ) )
                    // InternalBug347012TestLanguage.g:438:1: ( rule__Literal__BoolAssignment_2 )
                    {
                     before(grammarAccess.getLiteralAccess().getBoolAssignment_2()); 
                    // InternalBug347012TestLanguage.g:439:1: ( rule__Literal__BoolAssignment_2 )
                    // InternalBug347012TestLanguage.g:439:2: rule__Literal__BoolAssignment_2
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
                    // InternalBug347012TestLanguage.g:443:6: ( ( rule__Literal__BoolAssignment_3 ) )
                    {
                    // InternalBug347012TestLanguage.g:443:6: ( ( rule__Literal__BoolAssignment_3 ) )
                    // InternalBug347012TestLanguage.g:444:1: ( rule__Literal__BoolAssignment_3 )
                    {
                     before(grammarAccess.getLiteralAccess().getBoolAssignment_3()); 
                    // InternalBug347012TestLanguage.g:445:1: ( rule__Literal__BoolAssignment_3 )
                    // InternalBug347012TestLanguage.g:445:2: rule__Literal__BoolAssignment_3
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
    // InternalBug347012TestLanguage.g:454:1: rule__MyPrimary__Alternatives : ( ( ruleLiteral ) | ( ruleIdentifier ) );
    public final void rule__MyPrimary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:458:1: ( ( ruleLiteral ) | ( ruleIdentifier ) )
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
                    // InternalBug347012TestLanguage.g:459:1: ( ruleLiteral )
                    {
                    // InternalBug347012TestLanguage.g:459:1: ( ruleLiteral )
                    // InternalBug347012TestLanguage.g:460:1: ruleLiteral
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
                    // InternalBug347012TestLanguage.g:465:6: ( ruleIdentifier )
                    {
                    // InternalBug347012TestLanguage.g:465:6: ( ruleIdentifier )
                    // InternalBug347012TestLanguage.g:466:1: ruleIdentifier
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
    // InternalBug347012TestLanguage.g:476:1: rule__MyAttribute__Alternatives : ( ( ( rule__MyAttribute__PUBLICAssignment_0 ) ) | ( ( rule__MyAttribute__PRIVATEAssignment_1 ) ) );
    public final void rule__MyAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:480:1: ( ( ( rule__MyAttribute__PUBLICAssignment_0 ) ) | ( ( rule__MyAttribute__PRIVATEAssignment_1 ) ) )
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
                    // InternalBug347012TestLanguage.g:481:1: ( ( rule__MyAttribute__PUBLICAssignment_0 ) )
                    {
                    // InternalBug347012TestLanguage.g:481:1: ( ( rule__MyAttribute__PUBLICAssignment_0 ) )
                    // InternalBug347012TestLanguage.g:482:1: ( rule__MyAttribute__PUBLICAssignment_0 )
                    {
                     before(grammarAccess.getMyAttributeAccess().getPUBLICAssignment_0()); 
                    // InternalBug347012TestLanguage.g:483:1: ( rule__MyAttribute__PUBLICAssignment_0 )
                    // InternalBug347012TestLanguage.g:483:2: rule__MyAttribute__PUBLICAssignment_0
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
                    // InternalBug347012TestLanguage.g:487:6: ( ( rule__MyAttribute__PRIVATEAssignment_1 ) )
                    {
                    // InternalBug347012TestLanguage.g:487:6: ( ( rule__MyAttribute__PRIVATEAssignment_1 ) )
                    // InternalBug347012TestLanguage.g:488:1: ( rule__MyAttribute__PRIVATEAssignment_1 )
                    {
                     before(grammarAccess.getMyAttributeAccess().getPRIVATEAssignment_1()); 
                    // InternalBug347012TestLanguage.g:489:1: ( rule__MyAttribute__PRIVATEAssignment_1 )
                    // InternalBug347012TestLanguage.g:489:2: rule__MyAttribute__PRIVATEAssignment_1
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
    // InternalBug347012TestLanguage.g:500:1: rule__MyProgram__Group__0 : rule__MyProgram__Group__0__Impl rule__MyProgram__Group__1 ;
    public final void rule__MyProgram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:504:1: ( rule__MyProgram__Group__0__Impl rule__MyProgram__Group__1 )
            // InternalBug347012TestLanguage.g:505:2: rule__MyProgram__Group__0__Impl rule__MyProgram__Group__1
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
    // InternalBug347012TestLanguage.g:512:1: rule__MyProgram__Group__0__Impl : ( () ) ;
    public final void rule__MyProgram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:516:1: ( ( () ) )
            // InternalBug347012TestLanguage.g:517:1: ( () )
            {
            // InternalBug347012TestLanguage.g:517:1: ( () )
            // InternalBug347012TestLanguage.g:518:1: ()
            {
             before(grammarAccess.getMyProgramAccess().getMyProgramAction_0()); 
            // InternalBug347012TestLanguage.g:519:1: ()
            // InternalBug347012TestLanguage.g:521:1: 
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
    // InternalBug347012TestLanguage.g:531:1: rule__MyProgram__Group__1 : rule__MyProgram__Group__1__Impl rule__MyProgram__Group__2 ;
    public final void rule__MyProgram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:535:1: ( rule__MyProgram__Group__1__Impl rule__MyProgram__Group__2 )
            // InternalBug347012TestLanguage.g:536:2: rule__MyProgram__Group__1__Impl rule__MyProgram__Group__2
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
    // InternalBug347012TestLanguage.g:543:1: rule__MyProgram__Group__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyProgram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:547:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:548:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:548:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:549:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_1()); 
            // InternalBug347012TestLanguage.g:550:1: ( RULE_LT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_LT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:550:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:560:1: rule__MyProgram__Group__2 : rule__MyProgram__Group__2__Impl rule__MyProgram__Group__3 ;
    public final void rule__MyProgram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:564:1: ( rule__MyProgram__Group__2__Impl rule__MyProgram__Group__3 )
            // InternalBug347012TestLanguage.g:565:2: rule__MyProgram__Group__2__Impl rule__MyProgram__Group__3
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
    // InternalBug347012TestLanguage.g:572:1: rule__MyProgram__Group__2__Impl : ( ( rule__MyProgram__PackageAssignment_2 ) ) ;
    public final void rule__MyProgram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:576:1: ( ( ( rule__MyProgram__PackageAssignment_2 ) ) )
            // InternalBug347012TestLanguage.g:577:1: ( ( rule__MyProgram__PackageAssignment_2 ) )
            {
            // InternalBug347012TestLanguage.g:577:1: ( ( rule__MyProgram__PackageAssignment_2 ) )
            // InternalBug347012TestLanguage.g:578:1: ( rule__MyProgram__PackageAssignment_2 )
            {
             before(grammarAccess.getMyProgramAccess().getPackageAssignment_2()); 
            // InternalBug347012TestLanguage.g:579:1: ( rule__MyProgram__PackageAssignment_2 )
            // InternalBug347012TestLanguage.g:579:2: rule__MyProgram__PackageAssignment_2
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
    // InternalBug347012TestLanguage.g:589:1: rule__MyProgram__Group__3 : rule__MyProgram__Group__3__Impl ;
    public final void rule__MyProgram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:593:1: ( rule__MyProgram__Group__3__Impl )
            // InternalBug347012TestLanguage.g:594:2: rule__MyProgram__Group__3__Impl
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
    // InternalBug347012TestLanguage.g:600:1: rule__MyProgram__Group__3__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyProgram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:604:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:605:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:605:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:606:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_3()); 
            // InternalBug347012TestLanguage.g:607:1: ( RULE_LT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_LT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:607:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:625:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:629:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalBug347012TestLanguage.g:630:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
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
    // InternalBug347012TestLanguage.g:637:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:641:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:642:1: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:642:1: ( RULE_ID )
            // InternalBug347012TestLanguage.g:643:1: RULE_ID
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
    // InternalBug347012TestLanguage.g:654:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:658:1: ( rule__FQN__Group__1__Impl )
            // InternalBug347012TestLanguage.g:659:2: rule__FQN__Group__1__Impl
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
    // InternalBug347012TestLanguage.g:665:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:669:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalBug347012TestLanguage.g:670:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalBug347012TestLanguage.g:670:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalBug347012TestLanguage.g:671:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalBug347012TestLanguage.g:672:1: ( rule__FQN__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:672:2: rule__FQN__Group_1__0
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
    // InternalBug347012TestLanguage.g:686:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:690:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalBug347012TestLanguage.g:691:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalBug347012TestLanguage.g:698:1: rule__FQN__Group_1__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:702:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:703:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:703:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:704:1: ( RULE_LT )*
            {
             before(grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_0()); 
            // InternalBug347012TestLanguage.g:705:1: ( RULE_LT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_LT) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:705:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:715:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl rule__FQN__Group_1__2 ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:719:1: ( rule__FQN__Group_1__1__Impl rule__FQN__Group_1__2 )
            // InternalBug347012TestLanguage.g:720:2: rule__FQN__Group_1__1__Impl rule__FQN__Group_1__2
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
    // InternalBug347012TestLanguage.g:727:1: rule__FQN__Group_1__1__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:731:1: ( ( '.' ) )
            // InternalBug347012TestLanguage.g:732:1: ( '.' )
            {
            // InternalBug347012TestLanguage.g:732:1: ( '.' )
            // InternalBug347012TestLanguage.g:733:1: '.'
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
    // InternalBug347012TestLanguage.g:746:1: rule__FQN__Group_1__2 : rule__FQN__Group_1__2__Impl rule__FQN__Group_1__3 ;
    public final void rule__FQN__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:750:1: ( rule__FQN__Group_1__2__Impl rule__FQN__Group_1__3 )
            // InternalBug347012TestLanguage.g:751:2: rule__FQN__Group_1__2__Impl rule__FQN__Group_1__3
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
    // InternalBug347012TestLanguage.g:758:1: rule__FQN__Group_1__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__FQN__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:762:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:763:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:763:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:764:1: ( RULE_LT )*
            {
             before(grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_2()); 
            // InternalBug347012TestLanguage.g:765:1: ( RULE_LT )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_LT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:765:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:775:1: rule__FQN__Group_1__3 : rule__FQN__Group_1__3__Impl ;
    public final void rule__FQN__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:779:1: ( rule__FQN__Group_1__3__Impl )
            // InternalBug347012TestLanguage.g:780:2: rule__FQN__Group_1__3__Impl
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
    // InternalBug347012TestLanguage.g:786:1: rule__FQN__Group_1__3__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:790:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:791:1: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:791:1: ( RULE_ID )
            // InternalBug347012TestLanguage.g:792:1: RULE_ID
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
    // InternalBug347012TestLanguage.g:811:1: rule__MyPackage__Group__0 : rule__MyPackage__Group__0__Impl rule__MyPackage__Group__1 ;
    public final void rule__MyPackage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:815:1: ( rule__MyPackage__Group__0__Impl rule__MyPackage__Group__1 )
            // InternalBug347012TestLanguage.g:816:2: rule__MyPackage__Group__0__Impl rule__MyPackage__Group__1
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
    // InternalBug347012TestLanguage.g:823:1: rule__MyPackage__Group__0__Impl : ( 'package' ) ;
    public final void rule__MyPackage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:827:1: ( ( 'package' ) )
            // InternalBug347012TestLanguage.g:828:1: ( 'package' )
            {
            // InternalBug347012TestLanguage.g:828:1: ( 'package' )
            // InternalBug347012TestLanguage.g:829:1: 'package'
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
    // InternalBug347012TestLanguage.g:842:1: rule__MyPackage__Group__1 : rule__MyPackage__Group__1__Impl rule__MyPackage__Group__2 ;
    public final void rule__MyPackage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:846:1: ( rule__MyPackage__Group__1__Impl rule__MyPackage__Group__2 )
            // InternalBug347012TestLanguage.g:847:2: rule__MyPackage__Group__1__Impl rule__MyPackage__Group__2
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
    // InternalBug347012TestLanguage.g:854:1: rule__MyPackage__Group__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:858:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:859:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:859:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:860:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_1()); 
            // InternalBug347012TestLanguage.g:861:1: ( RULE_LT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_LT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:861:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:871:1: rule__MyPackage__Group__2 : rule__MyPackage__Group__2__Impl rule__MyPackage__Group__3 ;
    public final void rule__MyPackage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:875:1: ( rule__MyPackage__Group__2__Impl rule__MyPackage__Group__3 )
            // InternalBug347012TestLanguage.g:876:2: rule__MyPackage__Group__2__Impl rule__MyPackage__Group__3
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
    // InternalBug347012TestLanguage.g:883:1: rule__MyPackage__Group__2__Impl : ( ( rule__MyPackage__NameAssignment_2 ) ) ;
    public final void rule__MyPackage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:887:1: ( ( ( rule__MyPackage__NameAssignment_2 ) ) )
            // InternalBug347012TestLanguage.g:888:1: ( ( rule__MyPackage__NameAssignment_2 ) )
            {
            // InternalBug347012TestLanguage.g:888:1: ( ( rule__MyPackage__NameAssignment_2 ) )
            // InternalBug347012TestLanguage.g:889:1: ( rule__MyPackage__NameAssignment_2 )
            {
             before(grammarAccess.getMyPackageAccess().getNameAssignment_2()); 
            // InternalBug347012TestLanguage.g:890:1: ( rule__MyPackage__NameAssignment_2 )
            // InternalBug347012TestLanguage.g:890:2: rule__MyPackage__NameAssignment_2
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
    // InternalBug347012TestLanguage.g:900:1: rule__MyPackage__Group__3 : rule__MyPackage__Group__3__Impl rule__MyPackage__Group__4 ;
    public final void rule__MyPackage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:904:1: ( rule__MyPackage__Group__3__Impl rule__MyPackage__Group__4 )
            // InternalBug347012TestLanguage.g:905:2: rule__MyPackage__Group__3__Impl rule__MyPackage__Group__4
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
    // InternalBug347012TestLanguage.g:912:1: rule__MyPackage__Group__3__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:916:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:917:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:917:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:918:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_3()); 
            // InternalBug347012TestLanguage.g:919:1: ( RULE_LT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_LT) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:919:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:929:1: rule__MyPackage__Group__4 : rule__MyPackage__Group__4__Impl rule__MyPackage__Group__5 ;
    public final void rule__MyPackage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:933:1: ( rule__MyPackage__Group__4__Impl rule__MyPackage__Group__5 )
            // InternalBug347012TestLanguage.g:934:2: rule__MyPackage__Group__4__Impl rule__MyPackage__Group__5
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
    // InternalBug347012TestLanguage.g:941:1: rule__MyPackage__Group__4__Impl : ( '{' ) ;
    public final void rule__MyPackage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:945:1: ( ( '{' ) )
            // InternalBug347012TestLanguage.g:946:1: ( '{' )
            {
            // InternalBug347012TestLanguage.g:946:1: ( '{' )
            // InternalBug347012TestLanguage.g:947:1: '{'
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
    // InternalBug347012TestLanguage.g:960:1: rule__MyPackage__Group__5 : rule__MyPackage__Group__5__Impl rule__MyPackage__Group__6 ;
    public final void rule__MyPackage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:964:1: ( rule__MyPackage__Group__5__Impl rule__MyPackage__Group__6 )
            // InternalBug347012TestLanguage.g:965:2: rule__MyPackage__Group__5__Impl rule__MyPackage__Group__6
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
    // InternalBug347012TestLanguage.g:972:1: rule__MyPackage__Group__5__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:976:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:977:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:977:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:978:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_5()); 
            // InternalBug347012TestLanguage.g:979:1: ( RULE_LT )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_LT) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:979:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:989:1: rule__MyPackage__Group__6 : rule__MyPackage__Group__6__Impl rule__MyPackage__Group__7 ;
    public final void rule__MyPackage__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:993:1: ( rule__MyPackage__Group__6__Impl rule__MyPackage__Group__7 )
            // InternalBug347012TestLanguage.g:994:2: rule__MyPackage__Group__6__Impl rule__MyPackage__Group__7
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
    // InternalBug347012TestLanguage.g:1001:1: rule__MyPackage__Group__6__Impl : ( ( rule__MyPackage__Group_6__0 )* ) ;
    public final void rule__MyPackage__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1005:1: ( ( ( rule__MyPackage__Group_6__0 )* ) )
            // InternalBug347012TestLanguage.g:1006:1: ( ( rule__MyPackage__Group_6__0 )* )
            {
            // InternalBug347012TestLanguage.g:1006:1: ( ( rule__MyPackage__Group_6__0 )* )
            // InternalBug347012TestLanguage.g:1007:1: ( rule__MyPackage__Group_6__0 )*
            {
             before(grammarAccess.getMyPackageAccess().getGroup_6()); 
            // InternalBug347012TestLanguage.g:1008:1: ( rule__MyPackage__Group_6__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=18 && LA13_0<=19)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1008:2: rule__MyPackage__Group_6__0
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
    // InternalBug347012TestLanguage.g:1018:1: rule__MyPackage__Group__7 : rule__MyPackage__Group__7__Impl ;
    public final void rule__MyPackage__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1022:1: ( rule__MyPackage__Group__7__Impl )
            // InternalBug347012TestLanguage.g:1023:2: rule__MyPackage__Group__7__Impl
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
    // InternalBug347012TestLanguage.g:1029:1: rule__MyPackage__Group__7__Impl : ( '}' ) ;
    public final void rule__MyPackage__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1033:1: ( ( '}' ) )
            // InternalBug347012TestLanguage.g:1034:1: ( '}' )
            {
            // InternalBug347012TestLanguage.g:1034:1: ( '}' )
            // InternalBug347012TestLanguage.g:1035:1: '}'
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
    // InternalBug347012TestLanguage.g:1064:1: rule__MyPackage__Group_6__0 : rule__MyPackage__Group_6__0__Impl rule__MyPackage__Group_6__1 ;
    public final void rule__MyPackage__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1068:1: ( rule__MyPackage__Group_6__0__Impl rule__MyPackage__Group_6__1 )
            // InternalBug347012TestLanguage.g:1069:2: rule__MyPackage__Group_6__0__Impl rule__MyPackage__Group_6__1
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
    // InternalBug347012TestLanguage.g:1076:1: rule__MyPackage__Group_6__0__Impl : ( ( rule__MyPackage__DirectivesAssignment_6_0 ) ) ;
    public final void rule__MyPackage__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1080:1: ( ( ( rule__MyPackage__DirectivesAssignment_6_0 ) ) )
            // InternalBug347012TestLanguage.g:1081:1: ( ( rule__MyPackage__DirectivesAssignment_6_0 ) )
            {
            // InternalBug347012TestLanguage.g:1081:1: ( ( rule__MyPackage__DirectivesAssignment_6_0 ) )
            // InternalBug347012TestLanguage.g:1082:1: ( rule__MyPackage__DirectivesAssignment_6_0 )
            {
             before(grammarAccess.getMyPackageAccess().getDirectivesAssignment_6_0()); 
            // InternalBug347012TestLanguage.g:1083:1: ( rule__MyPackage__DirectivesAssignment_6_0 )
            // InternalBug347012TestLanguage.g:1083:2: rule__MyPackage__DirectivesAssignment_6_0
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
    // InternalBug347012TestLanguage.g:1093:1: rule__MyPackage__Group_6__1 : rule__MyPackage__Group_6__1__Impl ;
    public final void rule__MyPackage__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1097:1: ( rule__MyPackage__Group_6__1__Impl )
            // InternalBug347012TestLanguage.g:1098:2: rule__MyPackage__Group_6__1__Impl
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
    // InternalBug347012TestLanguage.g:1104:1: rule__MyPackage__Group_6__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyPackage__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1108:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1109:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1109:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1110:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_6_1()); 
            // InternalBug347012TestLanguage.g:1111:1: ( RULE_LT )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_LT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1111:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:1125:1: rule__MyClass__Group__0 : rule__MyClass__Group__0__Impl rule__MyClass__Group__1 ;
    public final void rule__MyClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1129:1: ( rule__MyClass__Group__0__Impl rule__MyClass__Group__1 )
            // InternalBug347012TestLanguage.g:1130:2: rule__MyClass__Group__0__Impl rule__MyClass__Group__1
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
    // InternalBug347012TestLanguage.g:1137:1: rule__MyClass__Group__0__Impl : ( ( 'public' )? ) ;
    public final void rule__MyClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1141:1: ( ( ( 'public' )? ) )
            // InternalBug347012TestLanguage.g:1142:1: ( ( 'public' )? )
            {
            // InternalBug347012TestLanguage.g:1142:1: ( ( 'public' )? )
            // InternalBug347012TestLanguage.g:1143:1: ( 'public' )?
            {
             before(grammarAccess.getMyClassAccess().getPublicKeyword_0()); 
            // InternalBug347012TestLanguage.g:1144:1: ( 'public' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBug347012TestLanguage.g:1145:2: 'public'
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
    // InternalBug347012TestLanguage.g:1156:1: rule__MyClass__Group__1 : rule__MyClass__Group__1__Impl rule__MyClass__Group__2 ;
    public final void rule__MyClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1160:1: ( rule__MyClass__Group__1__Impl rule__MyClass__Group__2 )
            // InternalBug347012TestLanguage.g:1161:2: rule__MyClass__Group__1__Impl rule__MyClass__Group__2
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
    // InternalBug347012TestLanguage.g:1168:1: rule__MyClass__Group__1__Impl : ( 'class' ) ;
    public final void rule__MyClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1172:1: ( ( 'class' ) )
            // InternalBug347012TestLanguage.g:1173:1: ( 'class' )
            {
            // InternalBug347012TestLanguage.g:1173:1: ( 'class' )
            // InternalBug347012TestLanguage.g:1174:1: 'class'
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
    // InternalBug347012TestLanguage.g:1187:1: rule__MyClass__Group__2 : rule__MyClass__Group__2__Impl rule__MyClass__Group__3 ;
    public final void rule__MyClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1191:1: ( rule__MyClass__Group__2__Impl rule__MyClass__Group__3 )
            // InternalBug347012TestLanguage.g:1192:2: rule__MyClass__Group__2__Impl rule__MyClass__Group__3
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
    // InternalBug347012TestLanguage.g:1199:1: rule__MyClass__Group__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1203:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1204:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1204:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1205:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_2()); 
            // InternalBug347012TestLanguage.g:1206:1: ( RULE_LT )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_LT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1206:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:1216:1: rule__MyClass__Group__3 : rule__MyClass__Group__3__Impl rule__MyClass__Group__4 ;
    public final void rule__MyClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1220:1: ( rule__MyClass__Group__3__Impl rule__MyClass__Group__4 )
            // InternalBug347012TestLanguage.g:1221:2: rule__MyClass__Group__3__Impl rule__MyClass__Group__4
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
    // InternalBug347012TestLanguage.g:1228:1: rule__MyClass__Group__3__Impl : ( ( rule__MyClass__NameAssignment_3 ) ) ;
    public final void rule__MyClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1232:1: ( ( ( rule__MyClass__NameAssignment_3 ) ) )
            // InternalBug347012TestLanguage.g:1233:1: ( ( rule__MyClass__NameAssignment_3 ) )
            {
            // InternalBug347012TestLanguage.g:1233:1: ( ( rule__MyClass__NameAssignment_3 ) )
            // InternalBug347012TestLanguage.g:1234:1: ( rule__MyClass__NameAssignment_3 )
            {
             before(grammarAccess.getMyClassAccess().getNameAssignment_3()); 
            // InternalBug347012TestLanguage.g:1235:1: ( rule__MyClass__NameAssignment_3 )
            // InternalBug347012TestLanguage.g:1235:2: rule__MyClass__NameAssignment_3
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
    // InternalBug347012TestLanguage.g:1245:1: rule__MyClass__Group__4 : rule__MyClass__Group__4__Impl rule__MyClass__Group__5 ;
    public final void rule__MyClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1249:1: ( rule__MyClass__Group__4__Impl rule__MyClass__Group__5 )
            // InternalBug347012TestLanguage.g:1250:2: rule__MyClass__Group__4__Impl rule__MyClass__Group__5
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
    // InternalBug347012TestLanguage.g:1257:1: rule__MyClass__Group__4__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1261:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1262:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1262:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1263:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_4()); 
            // InternalBug347012TestLanguage.g:1264:1: ( RULE_LT )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_LT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1264:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:1274:1: rule__MyClass__Group__5 : rule__MyClass__Group__5__Impl rule__MyClass__Group__6 ;
    public final void rule__MyClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1278:1: ( rule__MyClass__Group__5__Impl rule__MyClass__Group__6 )
            // InternalBug347012TestLanguage.g:1279:2: rule__MyClass__Group__5__Impl rule__MyClass__Group__6
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
    // InternalBug347012TestLanguage.g:1286:1: rule__MyClass__Group__5__Impl : ( '{' ) ;
    public final void rule__MyClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1290:1: ( ( '{' ) )
            // InternalBug347012TestLanguage.g:1291:1: ( '{' )
            {
            // InternalBug347012TestLanguage.g:1291:1: ( '{' )
            // InternalBug347012TestLanguage.g:1292:1: '{'
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
    // InternalBug347012TestLanguage.g:1305:1: rule__MyClass__Group__6 : rule__MyClass__Group__6__Impl rule__MyClass__Group__7 ;
    public final void rule__MyClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1309:1: ( rule__MyClass__Group__6__Impl rule__MyClass__Group__7 )
            // InternalBug347012TestLanguage.g:1310:2: rule__MyClass__Group__6__Impl rule__MyClass__Group__7
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
    // InternalBug347012TestLanguage.g:1317:1: rule__MyClass__Group__6__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1321:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1322:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1322:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1323:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_6()); 
            // InternalBug347012TestLanguage.g:1324:1: ( RULE_LT )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_LT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1324:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:1334:1: rule__MyClass__Group__7 : rule__MyClass__Group__7__Impl rule__MyClass__Group__8 ;
    public final void rule__MyClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1338:1: ( rule__MyClass__Group__7__Impl rule__MyClass__Group__8 )
            // InternalBug347012TestLanguage.g:1339:2: rule__MyClass__Group__7__Impl rule__MyClass__Group__8
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
    // InternalBug347012TestLanguage.g:1346:1: rule__MyClass__Group__7__Impl : ( ( rule__MyClass__Group_7__0 )* ) ;
    public final void rule__MyClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1350:1: ( ( ( rule__MyClass__Group_7__0 )* ) )
            // InternalBug347012TestLanguage.g:1351:1: ( ( rule__MyClass__Group_7__0 )* )
            {
            // InternalBug347012TestLanguage.g:1351:1: ( ( rule__MyClass__Group_7__0 )* )
            // InternalBug347012TestLanguage.g:1352:1: ( rule__MyClass__Group_7__0 )*
            {
             before(grammarAccess.getMyClassAccess().getGroup_7()); 
            // InternalBug347012TestLanguage.g:1353:1: ( rule__MyClass__Group_7__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==EOF||LA19_0==18||LA19_0==20||LA19_0==26) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1353:2: rule__MyClass__Group_7__0
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
    // InternalBug347012TestLanguage.g:1363:1: rule__MyClass__Group__8 : rule__MyClass__Group__8__Impl ;
    public final void rule__MyClass__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1367:1: ( rule__MyClass__Group__8__Impl )
            // InternalBug347012TestLanguage.g:1368:2: rule__MyClass__Group__8__Impl
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
    // InternalBug347012TestLanguage.g:1374:1: rule__MyClass__Group__8__Impl : ( '}' ) ;
    public final void rule__MyClass__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1378:1: ( ( '}' ) )
            // InternalBug347012TestLanguage.g:1379:1: ( '}' )
            {
            // InternalBug347012TestLanguage.g:1379:1: ( '}' )
            // InternalBug347012TestLanguage.g:1380:1: '}'
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
    // InternalBug347012TestLanguage.g:1411:1: rule__MyClass__Group_7__0 : rule__MyClass__Group_7__0__Impl rule__MyClass__Group_7__1 ;
    public final void rule__MyClass__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1415:1: ( rule__MyClass__Group_7__0__Impl rule__MyClass__Group_7__1 )
            // InternalBug347012TestLanguage.g:1416:2: rule__MyClass__Group_7__0__Impl rule__MyClass__Group_7__1
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
    // InternalBug347012TestLanguage.g:1423:1: rule__MyClass__Group_7__0__Impl : ( ( rule__MyClass__DirectivesAssignment_7_0 ) ) ;
    public final void rule__MyClass__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1427:1: ( ( ( rule__MyClass__DirectivesAssignment_7_0 ) ) )
            // InternalBug347012TestLanguage.g:1428:1: ( ( rule__MyClass__DirectivesAssignment_7_0 ) )
            {
            // InternalBug347012TestLanguage.g:1428:1: ( ( rule__MyClass__DirectivesAssignment_7_0 ) )
            // InternalBug347012TestLanguage.g:1429:1: ( rule__MyClass__DirectivesAssignment_7_0 )
            {
             before(grammarAccess.getMyClassAccess().getDirectivesAssignment_7_0()); 
            // InternalBug347012TestLanguage.g:1430:1: ( rule__MyClass__DirectivesAssignment_7_0 )
            // InternalBug347012TestLanguage.g:1430:2: rule__MyClass__DirectivesAssignment_7_0
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
    // InternalBug347012TestLanguage.g:1440:1: rule__MyClass__Group_7__1 : rule__MyClass__Group_7__1__Impl ;
    public final void rule__MyClass__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1444:1: ( rule__MyClass__Group_7__1__Impl )
            // InternalBug347012TestLanguage.g:1445:2: rule__MyClass__Group_7__1__Impl
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
    // InternalBug347012TestLanguage.g:1451:1: rule__MyClass__Group_7__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyClass__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1455:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1456:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1456:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1457:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyClassAccess().getLTTerminalRuleCall_7_1()); 
            // InternalBug347012TestLanguage.g:1458:1: ( RULE_LT )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_LT) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1458:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:1472:1: rule__MyAttributes__Group__0 : rule__MyAttributes__Group__0__Impl rule__MyAttributes__Group__1 ;
    public final void rule__MyAttributes__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1476:1: ( rule__MyAttributes__Group__0__Impl rule__MyAttributes__Group__1 )
            // InternalBug347012TestLanguage.g:1477:2: rule__MyAttributes__Group__0__Impl rule__MyAttributes__Group__1
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
    // InternalBug347012TestLanguage.g:1484:1: rule__MyAttributes__Group__0__Impl : ( () ) ;
    public final void rule__MyAttributes__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1488:1: ( ( () ) )
            // InternalBug347012TestLanguage.g:1489:1: ( () )
            {
            // InternalBug347012TestLanguage.g:1489:1: ( () )
            // InternalBug347012TestLanguage.g:1490:1: ()
            {
             before(grammarAccess.getMyAttributesAccess().getMyAttributesAction_0()); 
            // InternalBug347012TestLanguage.g:1491:1: ()
            // InternalBug347012TestLanguage.g:1493:1: 
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
    // InternalBug347012TestLanguage.g:1503:1: rule__MyAttributes__Group__1 : rule__MyAttributes__Group__1__Impl ;
    public final void rule__MyAttributes__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1507:1: ( rule__MyAttributes__Group__1__Impl )
            // InternalBug347012TestLanguage.g:1508:2: rule__MyAttributes__Group__1__Impl
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
    // InternalBug347012TestLanguage.g:1514:1: rule__MyAttributes__Group__1__Impl : ( ( rule__MyAttributes__AttributesAssignment_1 )* ) ;
    public final void rule__MyAttributes__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1518:1: ( ( ( rule__MyAttributes__AttributesAssignment_1 )* ) )
            // InternalBug347012TestLanguage.g:1519:1: ( ( rule__MyAttributes__AttributesAssignment_1 )* )
            {
            // InternalBug347012TestLanguage.g:1519:1: ( ( rule__MyAttributes__AttributesAssignment_1 )* )
            // InternalBug347012TestLanguage.g:1520:1: ( rule__MyAttributes__AttributesAssignment_1 )*
            {
             before(grammarAccess.getMyAttributesAccess().getAttributesAssignment_1()); 
            // InternalBug347012TestLanguage.g:1521:1: ( rule__MyAttributes__AttributesAssignment_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==18||LA21_0==26) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1521:2: rule__MyAttributes__AttributesAssignment_1
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
    // InternalBug347012TestLanguage.g:1535:1: rule__MyField__Group__0 : rule__MyField__Group__0__Impl rule__MyField__Group__1 ;
    public final void rule__MyField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1539:1: ( rule__MyField__Group__0__Impl rule__MyField__Group__1 )
            // InternalBug347012TestLanguage.g:1540:2: rule__MyField__Group__0__Impl rule__MyField__Group__1
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
    // InternalBug347012TestLanguage.g:1547:1: rule__MyField__Group__0__Impl : ( ( rule__MyField__AttrAssignment_0 ) ) ;
    public final void rule__MyField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1551:1: ( ( ( rule__MyField__AttrAssignment_0 ) ) )
            // InternalBug347012TestLanguage.g:1552:1: ( ( rule__MyField__AttrAssignment_0 ) )
            {
            // InternalBug347012TestLanguage.g:1552:1: ( ( rule__MyField__AttrAssignment_0 ) )
            // InternalBug347012TestLanguage.g:1553:1: ( rule__MyField__AttrAssignment_0 )
            {
             before(grammarAccess.getMyFieldAccess().getAttrAssignment_0()); 
            // InternalBug347012TestLanguage.g:1554:1: ( rule__MyField__AttrAssignment_0 )
            // InternalBug347012TestLanguage.g:1554:2: rule__MyField__AttrAssignment_0
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
    // InternalBug347012TestLanguage.g:1564:1: rule__MyField__Group__1 : rule__MyField__Group__1__Impl rule__MyField__Group__2 ;
    public final void rule__MyField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1568:1: ( rule__MyField__Group__1__Impl rule__MyField__Group__2 )
            // InternalBug347012TestLanguage.g:1569:2: rule__MyField__Group__1__Impl rule__MyField__Group__2
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
    // InternalBug347012TestLanguage.g:1576:1: rule__MyField__Group__1__Impl : ( 'var' ) ;
    public final void rule__MyField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1580:1: ( ( 'var' ) )
            // InternalBug347012TestLanguage.g:1581:1: ( 'var' )
            {
            // InternalBug347012TestLanguage.g:1581:1: ( 'var' )
            // InternalBug347012TestLanguage.g:1582:1: 'var'
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
    // InternalBug347012TestLanguage.g:1595:1: rule__MyField__Group__2 : rule__MyField__Group__2__Impl rule__MyField__Group__3 ;
    public final void rule__MyField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1599:1: ( rule__MyField__Group__2__Impl rule__MyField__Group__3 )
            // InternalBug347012TestLanguage.g:1600:2: rule__MyField__Group__2__Impl rule__MyField__Group__3
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
    // InternalBug347012TestLanguage.g:1607:1: rule__MyField__Group__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1611:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1612:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1612:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1613:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_2()); 
            // InternalBug347012TestLanguage.g:1614:1: ( RULE_LT )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_LT) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1614:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:1624:1: rule__MyField__Group__3 : rule__MyField__Group__3__Impl rule__MyField__Group__4 ;
    public final void rule__MyField__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1628:1: ( rule__MyField__Group__3__Impl rule__MyField__Group__4 )
            // InternalBug347012TestLanguage.g:1629:2: rule__MyField__Group__3__Impl rule__MyField__Group__4
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
    // InternalBug347012TestLanguage.g:1636:1: rule__MyField__Group__3__Impl : ( ( rule__MyField__BindingsAssignment_3 ) ) ;
    public final void rule__MyField__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1640:1: ( ( ( rule__MyField__BindingsAssignment_3 ) ) )
            // InternalBug347012TestLanguage.g:1641:1: ( ( rule__MyField__BindingsAssignment_3 ) )
            {
            // InternalBug347012TestLanguage.g:1641:1: ( ( rule__MyField__BindingsAssignment_3 ) )
            // InternalBug347012TestLanguage.g:1642:1: ( rule__MyField__BindingsAssignment_3 )
            {
             before(grammarAccess.getMyFieldAccess().getBindingsAssignment_3()); 
            // InternalBug347012TestLanguage.g:1643:1: ( rule__MyField__BindingsAssignment_3 )
            // InternalBug347012TestLanguage.g:1643:2: rule__MyField__BindingsAssignment_3
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
    // InternalBug347012TestLanguage.g:1653:1: rule__MyField__Group__4 : rule__MyField__Group__4__Impl rule__MyField__Group__5 ;
    public final void rule__MyField__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1657:1: ( rule__MyField__Group__4__Impl rule__MyField__Group__5 )
            // InternalBug347012TestLanguage.g:1658:2: rule__MyField__Group__4__Impl rule__MyField__Group__5
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
    // InternalBug347012TestLanguage.g:1665:1: rule__MyField__Group__4__Impl : ( ( rule__MyField__Group_4__0 )* ) ;
    public final void rule__MyField__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1669:1: ( ( ( rule__MyField__Group_4__0 )* ) )
            // InternalBug347012TestLanguage.g:1670:1: ( ( rule__MyField__Group_4__0 )* )
            {
            // InternalBug347012TestLanguage.g:1670:1: ( ( rule__MyField__Group_4__0 )* )
            // InternalBug347012TestLanguage.g:1671:1: ( rule__MyField__Group_4__0 )*
            {
             before(grammarAccess.getMyFieldAccess().getGroup_4()); 
            // InternalBug347012TestLanguage.g:1672:1: ( rule__MyField__Group_4__0 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1672:2: rule__MyField__Group_4__0
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
    // InternalBug347012TestLanguage.g:1682:1: rule__MyField__Group__5 : rule__MyField__Group__5__Impl ;
    public final void rule__MyField__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1686:1: ( rule__MyField__Group__5__Impl )
            // InternalBug347012TestLanguage.g:1687:2: rule__MyField__Group__5__Impl
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
    // InternalBug347012TestLanguage.g:1693:1: rule__MyField__Group__5__Impl : ( ruleVirtualSemi ) ;
    public final void rule__MyField__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1697:1: ( ( ruleVirtualSemi ) )
            // InternalBug347012TestLanguage.g:1698:1: ( ruleVirtualSemi )
            {
            // InternalBug347012TestLanguage.g:1698:1: ( ruleVirtualSemi )
            // InternalBug347012TestLanguage.g:1699:1: ruleVirtualSemi
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
    // InternalBug347012TestLanguage.g:1722:1: rule__MyField__Group_4__0 : rule__MyField__Group_4__0__Impl rule__MyField__Group_4__1 ;
    public final void rule__MyField__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1726:1: ( rule__MyField__Group_4__0__Impl rule__MyField__Group_4__1 )
            // InternalBug347012TestLanguage.g:1727:2: rule__MyField__Group_4__0__Impl rule__MyField__Group_4__1
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
    // InternalBug347012TestLanguage.g:1734:1: rule__MyField__Group_4__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyField__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1738:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1739:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1739:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1740:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_0()); 
            // InternalBug347012TestLanguage.g:1741:1: ( RULE_LT )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_LT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1741:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:1751:1: rule__MyField__Group_4__1 : rule__MyField__Group_4__1__Impl rule__MyField__Group_4__2 ;
    public final void rule__MyField__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1755:1: ( rule__MyField__Group_4__1__Impl rule__MyField__Group_4__2 )
            // InternalBug347012TestLanguage.g:1756:2: rule__MyField__Group_4__1__Impl rule__MyField__Group_4__2
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
    // InternalBug347012TestLanguage.g:1763:1: rule__MyField__Group_4__1__Impl : ( ',' ) ;
    public final void rule__MyField__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1767:1: ( ( ',' ) )
            // InternalBug347012TestLanguage.g:1768:1: ( ',' )
            {
            // InternalBug347012TestLanguage.g:1768:1: ( ',' )
            // InternalBug347012TestLanguage.g:1769:1: ','
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
    // InternalBug347012TestLanguage.g:1782:1: rule__MyField__Group_4__2 : rule__MyField__Group_4__2__Impl rule__MyField__Group_4__3 ;
    public final void rule__MyField__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1786:1: ( rule__MyField__Group_4__2__Impl rule__MyField__Group_4__3 )
            // InternalBug347012TestLanguage.g:1787:2: rule__MyField__Group_4__2__Impl rule__MyField__Group_4__3
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
    // InternalBug347012TestLanguage.g:1794:1: rule__MyField__Group_4__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyField__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1798:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1799:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1799:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1800:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_2()); 
            // InternalBug347012TestLanguage.g:1801:1: ( RULE_LT )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_LT) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1801:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:1811:1: rule__MyField__Group_4__3 : rule__MyField__Group_4__3__Impl ;
    public final void rule__MyField__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1815:1: ( rule__MyField__Group_4__3__Impl )
            // InternalBug347012TestLanguage.g:1816:2: rule__MyField__Group_4__3__Impl
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
    // InternalBug347012TestLanguage.g:1822:1: rule__MyField__Group_4__3__Impl : ( ( rule__MyField__BindingsAssignment_4_3 ) ) ;
    public final void rule__MyField__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1826:1: ( ( ( rule__MyField__BindingsAssignment_4_3 ) ) )
            // InternalBug347012TestLanguage.g:1827:1: ( ( rule__MyField__BindingsAssignment_4_3 ) )
            {
            // InternalBug347012TestLanguage.g:1827:1: ( ( rule__MyField__BindingsAssignment_4_3 ) )
            // InternalBug347012TestLanguage.g:1828:1: ( rule__MyField__BindingsAssignment_4_3 )
            {
             before(grammarAccess.getMyFieldAccess().getBindingsAssignment_4_3()); 
            // InternalBug347012TestLanguage.g:1829:1: ( rule__MyField__BindingsAssignment_4_3 )
            // InternalBug347012TestLanguage.g:1829:2: rule__MyField__BindingsAssignment_4_3
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
    // InternalBug347012TestLanguage.g:1847:1: rule__MyBinding__Group__0 : rule__MyBinding__Group__0__Impl rule__MyBinding__Group__1 ;
    public final void rule__MyBinding__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1851:1: ( rule__MyBinding__Group__0__Impl rule__MyBinding__Group__1 )
            // InternalBug347012TestLanguage.g:1852:2: rule__MyBinding__Group__0__Impl rule__MyBinding__Group__1
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
    // InternalBug347012TestLanguage.g:1859:1: rule__MyBinding__Group__0__Impl : ( ( rule__MyBinding__NameAssignment_0 ) ) ;
    public final void rule__MyBinding__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1863:1: ( ( ( rule__MyBinding__NameAssignment_0 ) ) )
            // InternalBug347012TestLanguage.g:1864:1: ( ( rule__MyBinding__NameAssignment_0 ) )
            {
            // InternalBug347012TestLanguage.g:1864:1: ( ( rule__MyBinding__NameAssignment_0 ) )
            // InternalBug347012TestLanguage.g:1865:1: ( rule__MyBinding__NameAssignment_0 )
            {
             before(grammarAccess.getMyBindingAccess().getNameAssignment_0()); 
            // InternalBug347012TestLanguage.g:1866:1: ( rule__MyBinding__NameAssignment_0 )
            // InternalBug347012TestLanguage.g:1866:2: rule__MyBinding__NameAssignment_0
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
    // InternalBug347012TestLanguage.g:1876:1: rule__MyBinding__Group__1 : rule__MyBinding__Group__1__Impl rule__MyBinding__Group__2 ;
    public final void rule__MyBinding__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1880:1: ( rule__MyBinding__Group__1__Impl rule__MyBinding__Group__2 )
            // InternalBug347012TestLanguage.g:1881:2: rule__MyBinding__Group__1__Impl rule__MyBinding__Group__2
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
    // InternalBug347012TestLanguage.g:1888:1: rule__MyBinding__Group__1__Impl : ( ( rule__MyBinding__Group_1__0 )? ) ;
    public final void rule__MyBinding__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1892:1: ( ( ( rule__MyBinding__Group_1__0 )? ) )
            // InternalBug347012TestLanguage.g:1893:1: ( ( rule__MyBinding__Group_1__0 )? )
            {
            // InternalBug347012TestLanguage.g:1893:1: ( ( rule__MyBinding__Group_1__0 )? )
            // InternalBug347012TestLanguage.g:1894:1: ( rule__MyBinding__Group_1__0 )?
            {
             before(grammarAccess.getMyBindingAccess().getGroup_1()); 
            // InternalBug347012TestLanguage.g:1895:1: ( rule__MyBinding__Group_1__0 )?
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalBug347012TestLanguage.g:1895:2: rule__MyBinding__Group_1__0
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
    // InternalBug347012TestLanguage.g:1905:1: rule__MyBinding__Group__2 : rule__MyBinding__Group__2__Impl ;
    public final void rule__MyBinding__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1909:1: ( rule__MyBinding__Group__2__Impl )
            // InternalBug347012TestLanguage.g:1910:2: rule__MyBinding__Group__2__Impl
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
    // InternalBug347012TestLanguage.g:1916:1: rule__MyBinding__Group__2__Impl : ( ( rule__MyBinding__Group_2__0 )? ) ;
    public final void rule__MyBinding__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1920:1: ( ( ( rule__MyBinding__Group_2__0 )? ) )
            // InternalBug347012TestLanguage.g:1921:1: ( ( rule__MyBinding__Group_2__0 )? )
            {
            // InternalBug347012TestLanguage.g:1921:1: ( ( rule__MyBinding__Group_2__0 )? )
            // InternalBug347012TestLanguage.g:1922:1: ( rule__MyBinding__Group_2__0 )?
            {
             before(grammarAccess.getMyBindingAccess().getGroup_2()); 
            // InternalBug347012TestLanguage.g:1923:1: ( rule__MyBinding__Group_2__0 )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalBug347012TestLanguage.g:1923:2: rule__MyBinding__Group_2__0
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
    // InternalBug347012TestLanguage.g:1939:1: rule__MyBinding__Group_1__0 : rule__MyBinding__Group_1__0__Impl rule__MyBinding__Group_1__1 ;
    public final void rule__MyBinding__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1943:1: ( rule__MyBinding__Group_1__0__Impl rule__MyBinding__Group_1__1 )
            // InternalBug347012TestLanguage.g:1944:2: rule__MyBinding__Group_1__0__Impl rule__MyBinding__Group_1__1
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
    // InternalBug347012TestLanguage.g:1951:1: rule__MyBinding__Group_1__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1955:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:1956:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:1956:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:1957:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_0()); 
            // InternalBug347012TestLanguage.g:1958:1: ( RULE_LT )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_LT) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:1958:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:1968:1: rule__MyBinding__Group_1__1 : rule__MyBinding__Group_1__1__Impl rule__MyBinding__Group_1__2 ;
    public final void rule__MyBinding__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1972:1: ( rule__MyBinding__Group_1__1__Impl rule__MyBinding__Group_1__2 )
            // InternalBug347012TestLanguage.g:1973:2: rule__MyBinding__Group_1__1__Impl rule__MyBinding__Group_1__2
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
    // InternalBug347012TestLanguage.g:1980:1: rule__MyBinding__Group_1__1__Impl : ( ':' ) ;
    public final void rule__MyBinding__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:1984:1: ( ( ':' ) )
            // InternalBug347012TestLanguage.g:1985:1: ( ':' )
            {
            // InternalBug347012TestLanguage.g:1985:1: ( ':' )
            // InternalBug347012TestLanguage.g:1986:1: ':'
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
    // InternalBug347012TestLanguage.g:1999:1: rule__MyBinding__Group_1__2 : rule__MyBinding__Group_1__2__Impl rule__MyBinding__Group_1__3 ;
    public final void rule__MyBinding__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2003:1: ( rule__MyBinding__Group_1__2__Impl rule__MyBinding__Group_1__3 )
            // InternalBug347012TestLanguage.g:2004:2: rule__MyBinding__Group_1__2__Impl rule__MyBinding__Group_1__3
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
    // InternalBug347012TestLanguage.g:2011:1: rule__MyBinding__Group_1__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2015:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:2016:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:2016:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:2017:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_2()); 
            // InternalBug347012TestLanguage.g:2018:1: ( RULE_LT )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_LT) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:2018:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:2028:1: rule__MyBinding__Group_1__3 : rule__MyBinding__Group_1__3__Impl ;
    public final void rule__MyBinding__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2032:1: ( rule__MyBinding__Group_1__3__Impl )
            // InternalBug347012TestLanguage.g:2033:2: rule__MyBinding__Group_1__3__Impl
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
    // InternalBug347012TestLanguage.g:2039:1: rule__MyBinding__Group_1__3__Impl : ( ( rule__MyBinding__TypeAssignment_1_3 ) ) ;
    public final void rule__MyBinding__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2043:1: ( ( ( rule__MyBinding__TypeAssignment_1_3 ) ) )
            // InternalBug347012TestLanguage.g:2044:1: ( ( rule__MyBinding__TypeAssignment_1_3 ) )
            {
            // InternalBug347012TestLanguage.g:2044:1: ( ( rule__MyBinding__TypeAssignment_1_3 ) )
            // InternalBug347012TestLanguage.g:2045:1: ( rule__MyBinding__TypeAssignment_1_3 )
            {
             before(grammarAccess.getMyBindingAccess().getTypeAssignment_1_3()); 
            // InternalBug347012TestLanguage.g:2046:1: ( rule__MyBinding__TypeAssignment_1_3 )
            // InternalBug347012TestLanguage.g:2046:2: rule__MyBinding__TypeAssignment_1_3
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
    // InternalBug347012TestLanguage.g:2064:1: rule__MyBinding__Group_2__0 : rule__MyBinding__Group_2__0__Impl rule__MyBinding__Group_2__1 ;
    public final void rule__MyBinding__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2068:1: ( rule__MyBinding__Group_2__0__Impl rule__MyBinding__Group_2__1 )
            // InternalBug347012TestLanguage.g:2069:2: rule__MyBinding__Group_2__0__Impl rule__MyBinding__Group_2__1
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
    // InternalBug347012TestLanguage.g:2076:1: rule__MyBinding__Group_2__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2080:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:2081:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:2081:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:2082:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_0()); 
            // InternalBug347012TestLanguage.g:2083:1: ( RULE_LT )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_LT) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:2083:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:2093:1: rule__MyBinding__Group_2__1 : rule__MyBinding__Group_2__1__Impl rule__MyBinding__Group_2__2 ;
    public final void rule__MyBinding__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2097:1: ( rule__MyBinding__Group_2__1__Impl rule__MyBinding__Group_2__2 )
            // InternalBug347012TestLanguage.g:2098:2: rule__MyBinding__Group_2__1__Impl rule__MyBinding__Group_2__2
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
    // InternalBug347012TestLanguage.g:2105:1: rule__MyBinding__Group_2__1__Impl : ( '=' ) ;
    public final void rule__MyBinding__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2109:1: ( ( '=' ) )
            // InternalBug347012TestLanguage.g:2110:1: ( '=' )
            {
            // InternalBug347012TestLanguage.g:2110:1: ( '=' )
            // InternalBug347012TestLanguage.g:2111:1: '='
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
    // InternalBug347012TestLanguage.g:2124:1: rule__MyBinding__Group_2__2 : rule__MyBinding__Group_2__2__Impl rule__MyBinding__Group_2__3 ;
    public final void rule__MyBinding__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2128:1: ( rule__MyBinding__Group_2__2__Impl rule__MyBinding__Group_2__3 )
            // InternalBug347012TestLanguage.g:2129:2: rule__MyBinding__Group_2__2__Impl rule__MyBinding__Group_2__3
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
    // InternalBug347012TestLanguage.g:2136:1: rule__MyBinding__Group_2__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__MyBinding__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2140:1: ( ( ( RULE_LT )* ) )
            // InternalBug347012TestLanguage.g:2141:1: ( ( RULE_LT )* )
            {
            // InternalBug347012TestLanguage.g:2141:1: ( ( RULE_LT )* )
            // InternalBug347012TestLanguage.g:2142:1: ( RULE_LT )*
            {
             before(grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_2()); 
            // InternalBug347012TestLanguage.g:2143:1: ( RULE_LT )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_LT) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBug347012TestLanguage.g:2143:3: RULE_LT
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
    // InternalBug347012TestLanguage.g:2153:1: rule__MyBinding__Group_2__3 : rule__MyBinding__Group_2__3__Impl ;
    public final void rule__MyBinding__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2157:1: ( rule__MyBinding__Group_2__3__Impl )
            // InternalBug347012TestLanguage.g:2158:2: rule__MyBinding__Group_2__3__Impl
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
    // InternalBug347012TestLanguage.g:2164:1: rule__MyBinding__Group_2__3__Impl : ( ( rule__MyBinding__ExpressionAssignment_2_3 ) ) ;
    public final void rule__MyBinding__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2168:1: ( ( ( rule__MyBinding__ExpressionAssignment_2_3 ) ) )
            // InternalBug347012TestLanguage.g:2169:1: ( ( rule__MyBinding__ExpressionAssignment_2_3 ) )
            {
            // InternalBug347012TestLanguage.g:2169:1: ( ( rule__MyBinding__ExpressionAssignment_2_3 ) )
            // InternalBug347012TestLanguage.g:2170:1: ( rule__MyBinding__ExpressionAssignment_2_3 )
            {
             before(grammarAccess.getMyBindingAccess().getExpressionAssignment_2_3()); 
            // InternalBug347012TestLanguage.g:2171:1: ( rule__MyBinding__ExpressionAssignment_2_3 )
            // InternalBug347012TestLanguage.g:2171:2: rule__MyBinding__ExpressionAssignment_2_3
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
    // InternalBug347012TestLanguage.g:2190:1: rule__MyProgram__PackageAssignment_2 : ( ruleMyPackage ) ;
    public final void rule__MyProgram__PackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2194:1: ( ( ruleMyPackage ) )
            // InternalBug347012TestLanguage.g:2195:1: ( ruleMyPackage )
            {
            // InternalBug347012TestLanguage.g:2195:1: ( ruleMyPackage )
            // InternalBug347012TestLanguage.g:2196:1: ruleMyPackage
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
    // InternalBug347012TestLanguage.g:2205:1: rule__Identifier__NameAssignment : ( RULE_ID ) ;
    public final void rule__Identifier__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2209:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:2210:1: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:2210:1: ( RULE_ID )
            // InternalBug347012TestLanguage.g:2211:1: RULE_ID
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
    // InternalBug347012TestLanguage.g:2220:1: rule__Literal__NumAssignment_0 : ( RULE_NUMBER ) ;
    public final void rule__Literal__NumAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2224:1: ( ( RULE_NUMBER ) )
            // InternalBug347012TestLanguage.g:2225:1: ( RULE_NUMBER )
            {
            // InternalBug347012TestLanguage.g:2225:1: ( RULE_NUMBER )
            // InternalBug347012TestLanguage.g:2226:1: RULE_NUMBER
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
    // InternalBug347012TestLanguage.g:2235:1: rule__Literal__StrAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Literal__StrAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2239:1: ( ( RULE_STRING ) )
            // InternalBug347012TestLanguage.g:2240:1: ( RULE_STRING )
            {
            // InternalBug347012TestLanguage.g:2240:1: ( RULE_STRING )
            // InternalBug347012TestLanguage.g:2241:1: RULE_STRING
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
    // InternalBug347012TestLanguage.g:2250:1: rule__Literal__BoolAssignment_2 : ( ( 'true' ) ) ;
    public final void rule__Literal__BoolAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2254:1: ( ( ( 'true' ) ) )
            // InternalBug347012TestLanguage.g:2255:1: ( ( 'true' ) )
            {
            // InternalBug347012TestLanguage.g:2255:1: ( ( 'true' ) )
            // InternalBug347012TestLanguage.g:2256:1: ( 'true' )
            {
             before(grammarAccess.getLiteralAccess().getBoolTrueKeyword_2_0()); 
            // InternalBug347012TestLanguage.g:2257:1: ( 'true' )
            // InternalBug347012TestLanguage.g:2258:1: 'true'
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
    // InternalBug347012TestLanguage.g:2273:1: rule__Literal__BoolAssignment_3 : ( ( 'false' ) ) ;
    public final void rule__Literal__BoolAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2277:1: ( ( ( 'false' ) ) )
            // InternalBug347012TestLanguage.g:2278:1: ( ( 'false' ) )
            {
            // InternalBug347012TestLanguage.g:2278:1: ( ( 'false' ) )
            // InternalBug347012TestLanguage.g:2279:1: ( 'false' )
            {
             before(grammarAccess.getLiteralAccess().getBoolFalseKeyword_3_0()); 
            // InternalBug347012TestLanguage.g:2280:1: ( 'false' )
            // InternalBug347012TestLanguage.g:2281:1: 'false'
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
    // InternalBug347012TestLanguage.g:2296:1: rule__MyPackage__NameAssignment_2 : ( ruleFQN ) ;
    public final void rule__MyPackage__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2300:1: ( ( ruleFQN ) )
            // InternalBug347012TestLanguage.g:2301:1: ( ruleFQN )
            {
            // InternalBug347012TestLanguage.g:2301:1: ( ruleFQN )
            // InternalBug347012TestLanguage.g:2302:1: ruleFQN
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
    // InternalBug347012TestLanguage.g:2311:1: rule__MyPackage__DirectivesAssignment_6_0 : ( ruleMyClass ) ;
    public final void rule__MyPackage__DirectivesAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2315:1: ( ( ruleMyClass ) )
            // InternalBug347012TestLanguage.g:2316:1: ( ruleMyClass )
            {
            // InternalBug347012TestLanguage.g:2316:1: ( ruleMyClass )
            // InternalBug347012TestLanguage.g:2317:1: ruleMyClass
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
    // InternalBug347012TestLanguage.g:2326:1: rule__MyClass__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__MyClass__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2330:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:2331:1: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:2331:1: ( RULE_ID )
            // InternalBug347012TestLanguage.g:2332:1: RULE_ID
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
    // InternalBug347012TestLanguage.g:2341:1: rule__MyClass__DirectivesAssignment_7_0 : ( ruleMyField ) ;
    public final void rule__MyClass__DirectivesAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2345:1: ( ( ruleMyField ) )
            // InternalBug347012TestLanguage.g:2346:1: ( ruleMyField )
            {
            // InternalBug347012TestLanguage.g:2346:1: ( ruleMyField )
            // InternalBug347012TestLanguage.g:2347:1: ruleMyField
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
    // InternalBug347012TestLanguage.g:2356:1: rule__MyAttribute__PUBLICAssignment_0 : ( ( 'public' ) ) ;
    public final void rule__MyAttribute__PUBLICAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2360:1: ( ( ( 'public' ) ) )
            // InternalBug347012TestLanguage.g:2361:1: ( ( 'public' ) )
            {
            // InternalBug347012TestLanguage.g:2361:1: ( ( 'public' ) )
            // InternalBug347012TestLanguage.g:2362:1: ( 'public' )
            {
             before(grammarAccess.getMyAttributeAccess().getPUBLICPublicKeyword_0_0()); 
            // InternalBug347012TestLanguage.g:2363:1: ( 'public' )
            // InternalBug347012TestLanguage.g:2364:1: 'public'
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
    // InternalBug347012TestLanguage.g:2379:1: rule__MyAttribute__PRIVATEAssignment_1 : ( ( 'private' ) ) ;
    public final void rule__MyAttribute__PRIVATEAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2383:1: ( ( ( 'private' ) ) )
            // InternalBug347012TestLanguage.g:2384:1: ( ( 'private' ) )
            {
            // InternalBug347012TestLanguage.g:2384:1: ( ( 'private' ) )
            // InternalBug347012TestLanguage.g:2385:1: ( 'private' )
            {
             before(grammarAccess.getMyAttributeAccess().getPRIVATEPrivateKeyword_1_0()); 
            // InternalBug347012TestLanguage.g:2386:1: ( 'private' )
            // InternalBug347012TestLanguage.g:2387:1: 'private'
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
    // InternalBug347012TestLanguage.g:2402:1: rule__MyAttributes__AttributesAssignment_1 : ( ruleMyAttribute ) ;
    public final void rule__MyAttributes__AttributesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2406:1: ( ( ruleMyAttribute ) )
            // InternalBug347012TestLanguage.g:2407:1: ( ruleMyAttribute )
            {
            // InternalBug347012TestLanguage.g:2407:1: ( ruleMyAttribute )
            // InternalBug347012TestLanguage.g:2408:1: ruleMyAttribute
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
    // InternalBug347012TestLanguage.g:2417:1: rule__MyField__AttrAssignment_0 : ( ruleMyAttributes ) ;
    public final void rule__MyField__AttrAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2421:1: ( ( ruleMyAttributes ) )
            // InternalBug347012TestLanguage.g:2422:1: ( ruleMyAttributes )
            {
            // InternalBug347012TestLanguage.g:2422:1: ( ruleMyAttributes )
            // InternalBug347012TestLanguage.g:2423:1: ruleMyAttributes
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
    // InternalBug347012TestLanguage.g:2432:1: rule__MyField__BindingsAssignment_3 : ( ruleMyBinding ) ;
    public final void rule__MyField__BindingsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2436:1: ( ( ruleMyBinding ) )
            // InternalBug347012TestLanguage.g:2437:1: ( ruleMyBinding )
            {
            // InternalBug347012TestLanguage.g:2437:1: ( ruleMyBinding )
            // InternalBug347012TestLanguage.g:2438:1: ruleMyBinding
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
    // InternalBug347012TestLanguage.g:2447:1: rule__MyField__BindingsAssignment_4_3 : ( ruleMyBinding ) ;
    public final void rule__MyField__BindingsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2451:1: ( ( ruleMyBinding ) )
            // InternalBug347012TestLanguage.g:2452:1: ( ruleMyBinding )
            {
            // InternalBug347012TestLanguage.g:2452:1: ( ruleMyBinding )
            // InternalBug347012TestLanguage.g:2453:1: ruleMyBinding
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
    // InternalBug347012TestLanguage.g:2462:1: rule__MyBinding__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__MyBinding__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2466:1: ( ( RULE_ID ) )
            // InternalBug347012TestLanguage.g:2467:1: ( RULE_ID )
            {
            // InternalBug347012TestLanguage.g:2467:1: ( RULE_ID )
            // InternalBug347012TestLanguage.g:2468:1: RULE_ID
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
    // InternalBug347012TestLanguage.g:2477:1: rule__MyBinding__TypeAssignment_1_3 : ( ruleFQN ) ;
    public final void rule__MyBinding__TypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2481:1: ( ( ruleFQN ) )
            // InternalBug347012TestLanguage.g:2482:1: ( ruleFQN )
            {
            // InternalBug347012TestLanguage.g:2482:1: ( ruleFQN )
            // InternalBug347012TestLanguage.g:2483:1: ruleFQN
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
    // InternalBug347012TestLanguage.g:2492:1: rule__MyBinding__ExpressionAssignment_2_3 : ( ruleMyPrimary ) ;
    public final void rule__MyBinding__ExpressionAssignment_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug347012TestLanguage.g:2496:1: ( ( ruleMyPrimary ) )
            // InternalBug347012TestLanguage.g:2497:1: ( ruleMyPrimary )
            {
            // InternalBug347012TestLanguage.g:2497:1: ( ruleMyPrimary )
            // InternalBug347012TestLanguage.g:2498:1: ruleMyPrimary
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
    static final String DFA7_eotS =
        "\5\uffff";
    static final String DFA7_eofS =
        "\1\1\1\uffff\1\1\2\uffff";
    static final String DFA7_minS =
        "\1\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA7_maxS =
        "\1\27\1\uffff\1\32\1\uffff\1\32";
    static final String DFA7_acceptS =
        "\1\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA7_specialS =
        "\5\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\2\10\uffff\1\1\1\3\1\uffff\1\1\4\uffff\1\1\1\uffff\1\1",
            "",
            "\1\4\11\uffff\1\3\1\uffff\3\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1",
            "",
            "\1\4\11\uffff\1\3\1\uffff\3\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "()* loopback of 672:1: ( rule__FQN__Group_1__0 )*";
        }
    }
    static final String DFA23_eotS =
        "\5\uffff";
    static final String DFA23_eofS =
        "\2\uffff\1\1\2\uffff";
    static final String DFA23_minS =
        "\1\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA23_maxS =
        "\1\25\1\uffff\1\32\1\uffff\1\32";
    static final String DFA23_acceptS =
        "\1\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA23_specialS =
        "\5\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\2\10\uffff\1\1\7\uffff\1\3",
            "",
            "\1\4\14\uffff\2\1\1\uffff\1\1\1\3\4\uffff\1\1",
            "",
            "\1\4\14\uffff\2\1\1\uffff\1\1\1\3\4\uffff\1\1"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "()* loopback of 1672:1: ( rule__MyField__Group_4__0 )*";
        }
    }
    static final String DFA26_eotS =
        "\5\uffff";
    static final String DFA26_eofS =
        "\2\3\3\uffff";
    static final String DFA26_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA26_maxS =
        "\1\27\1\32\2\uffff\1\32";
    static final String DFA26_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA26_specialS =
        "\5\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\1\10\uffff\1\3\7\uffff\1\3\1\2\1\3",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\2\1\3\2\uffff\1\3",
            "",
            "",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\2\1\3\2\uffff\1\3"
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1895:1: ( rule__MyBinding__Group_1__0 )?";
        }
    }
    static final String DFA27_eotS =
        "\5\uffff";
    static final String DFA27_eofS =
        "\2\3\3\uffff";
    static final String DFA27_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA27_maxS =
        "\1\27\1\32\2\uffff\1\32";
    static final String DFA27_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA27_specialS =
        "\5\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\1\10\uffff\1\3\7\uffff\1\3\1\uffff\1\2",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\uffff\1\2\2\uffff\1\3",
            "",
            "",
            "\1\4\14\uffff\2\3\1\uffff\2\3\1\uffff\1\2\2\uffff\1\3"
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1923:1: ( rule__MyBinding__Group_2__0 )?";
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
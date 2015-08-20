package org.eclipse.xtext.ui.codetemplates.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

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
import org.eclipse.xtext.ui.codetemplates.services.CodetemplatesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCodetemplatesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Templates", "ReverseSolidusLessThanSignLessThanSign", "For", "DollarSignDollarSign", "DollarSignLeftCurlyBracket", "LessThanSignLessThanSign", "GreaterThanSignGreaterThanSign", "DollarSign", "LeftParenthesis", "RightParenthesis", "Comma", "FullStop", "Colon", "RightCurlyBracket", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=18;
    public static final int DollarSign=11;
    public static final int ReverseSolidusLessThanSignLessThanSign=5;
    public static final int RightParenthesis=13;
    public static final int LessThanSignLessThanSign=9;
    public static final int RULE_ANY_OTHER=21;
    public static final int LeftParenthesis=12;
    public static final int Colon=16;
    public static final int EOF=-1;
    public static final int For=6;
    public static final int FullStop=15;
    public static final int DollarSignLeftCurlyBracket=8;
    public static final int RULE_STRING=19;
    public static final int DollarSignDollarSign=7;
    public static final int Templates=4;
    public static final int RULE_WS=20;
    public static final int Comma=14;
    public static final int GreaterThanSignGreaterThanSign=10;
    public static final int RightCurlyBracket=17;

    // delegates
    // delegators


        public InternalCodetemplatesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCodetemplatesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCodetemplatesParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCodetemplatesParser.g"; }


     
     	private CodetemplatesGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("DollarSign", "'\u0024'");
    		tokenNameToValue.put("LeftParenthesis", "'('");
    		tokenNameToValue.put("RightParenthesis", "')'");
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("RightCurlyBracket", "'}'");
    		tokenNameToValue.put("DollarSignDollarSign", "'\u0024\u0024'");
    		tokenNameToValue.put("DollarSignLeftCurlyBracket", "'\u0024{'");
    		tokenNameToValue.put("LessThanSignLessThanSign", "'<<'");
    		tokenNameToValue.put("GreaterThanSignGreaterThanSign", "'>>'");
    		tokenNameToValue.put("ReverseSolidusLessThanSignLessThanSign", "'\\<<'");
    		tokenNameToValue.put("For", "'for'");
    		tokenNameToValue.put("Templates", "'templates'");
     	}
     	
        public void setGrammarAccess(CodetemplatesGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }

    	@Override
        protected String getValueForTokenName(String tokenName) {
        	String result = tokenNameToValue.get(tokenName);
        	if (result == null)
        		result = tokenName;
        	return result;
        }



    // $ANTLR start "entryRuleCodetemplates"
    // InternalCodetemplatesParser.g:77:1: entryRuleCodetemplates : ruleCodetemplates EOF ;
    public final void entryRuleCodetemplates() throws RecognitionException {
        try {
            // InternalCodetemplatesParser.g:78:1: ( ruleCodetemplates EOF )
            // InternalCodetemplatesParser.g:79:1: ruleCodetemplates EOF
            {
             before(grammarAccess.getCodetemplatesRule()); 
            pushFollow(FOLLOW_1);
            ruleCodetemplates();

            state._fsp--;

             after(grammarAccess.getCodetemplatesRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCodetemplates"


    // $ANTLR start "ruleCodetemplates"
    // InternalCodetemplatesParser.g:86:1: ruleCodetemplates : ( ( rule__Codetemplates__Group__0 ) ) ;
    public final void ruleCodetemplates() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:90:5: ( ( ( rule__Codetemplates__Group__0 ) ) )
            // InternalCodetemplatesParser.g:91:1: ( ( rule__Codetemplates__Group__0 ) )
            {
            // InternalCodetemplatesParser.g:91:1: ( ( rule__Codetemplates__Group__0 ) )
            // InternalCodetemplatesParser.g:92:1: ( rule__Codetemplates__Group__0 )
            {
             before(grammarAccess.getCodetemplatesAccess().getGroup()); 
            // InternalCodetemplatesParser.g:93:1: ( rule__Codetemplates__Group__0 )
            // InternalCodetemplatesParser.g:93:2: rule__Codetemplates__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplates__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplatesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCodetemplates"


    // $ANTLR start "entryRuleCodetemplate"
    // InternalCodetemplatesParser.g:105:1: entryRuleCodetemplate : ruleCodetemplate EOF ;
    public final void entryRuleCodetemplate() throws RecognitionException {
        try {
            // InternalCodetemplatesParser.g:106:1: ( ruleCodetemplate EOF )
            // InternalCodetemplatesParser.g:107:1: ruleCodetemplate EOF
            {
             before(grammarAccess.getCodetemplateRule()); 
            pushFollow(FOLLOW_1);
            ruleCodetemplate();

            state._fsp--;

             after(grammarAccess.getCodetemplateRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCodetemplate"


    // $ANTLR start "ruleCodetemplate"
    // InternalCodetemplatesParser.g:114:1: ruleCodetemplate : ( ( rule__Codetemplate__Group__0 ) ) ;
    public final void ruleCodetemplate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:118:5: ( ( ( rule__Codetemplate__Group__0 ) ) )
            // InternalCodetemplatesParser.g:119:1: ( ( rule__Codetemplate__Group__0 ) )
            {
            // InternalCodetemplatesParser.g:119:1: ( ( rule__Codetemplate__Group__0 ) )
            // InternalCodetemplatesParser.g:120:1: ( rule__Codetemplate__Group__0 )
            {
             before(grammarAccess.getCodetemplateAccess().getGroup()); 
            // InternalCodetemplatesParser.g:121:1: ( rule__Codetemplate__Group__0 )
            // InternalCodetemplatesParser.g:121:2: rule__Codetemplate__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCodetemplate"


    // $ANTLR start "entryRuleTemplateBodyWithQuotes"
    // InternalCodetemplatesParser.g:133:1: entryRuleTemplateBodyWithQuotes : ruleTemplateBodyWithQuotes EOF ;
    public final void entryRuleTemplateBodyWithQuotes() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:137:1: ( ruleTemplateBodyWithQuotes EOF )
            // InternalCodetemplatesParser.g:138:1: ruleTemplateBodyWithQuotes EOF
            {
             before(grammarAccess.getTemplateBodyWithQuotesRule()); 
            pushFollow(FOLLOW_1);
            ruleTemplateBodyWithQuotes();

            state._fsp--;

             after(grammarAccess.getTemplateBodyWithQuotesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleTemplateBodyWithQuotes"


    // $ANTLR start "ruleTemplateBodyWithQuotes"
    // InternalCodetemplatesParser.g:148:1: ruleTemplateBodyWithQuotes : ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) ;
    public final void ruleTemplateBodyWithQuotes() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:153:5: ( ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) )
            // InternalCodetemplatesParser.g:154:1: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            {
            // InternalCodetemplatesParser.g:154:1: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            // InternalCodetemplatesParser.g:155:1: ( rule__TemplateBodyWithQuotes__Group__0 )
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getGroup()); 
            // InternalCodetemplatesParser.g:156:1: ( rule__TemplateBodyWithQuotes__Group__0 )
            // InternalCodetemplatesParser.g:156:2: rule__TemplateBodyWithQuotes__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TemplateBodyWithQuotes__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTemplateBodyWithQuotesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleTemplateBodyWithQuotes"


    // $ANTLR start "entryRuleTemplateBody"
    // InternalCodetemplatesParser.g:169:1: entryRuleTemplateBody : ruleTemplateBody EOF ;
    public final void entryRuleTemplateBody() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:173:1: ( ruleTemplateBody EOF )
            // InternalCodetemplatesParser.g:174:1: ruleTemplateBody EOF
            {
             before(grammarAccess.getTemplateBodyRule()); 
            pushFollow(FOLLOW_1);
            ruleTemplateBody();

            state._fsp--;

             after(grammarAccess.getTemplateBodyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleTemplateBody"


    // $ANTLR start "ruleTemplateBody"
    // InternalCodetemplatesParser.g:184:1: ruleTemplateBody : ( ( rule__TemplateBody__Group__0 ) ) ;
    public final void ruleTemplateBody() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:189:5: ( ( ( rule__TemplateBody__Group__0 ) ) )
            // InternalCodetemplatesParser.g:190:1: ( ( rule__TemplateBody__Group__0 ) )
            {
            // InternalCodetemplatesParser.g:190:1: ( ( rule__TemplateBody__Group__0 ) )
            // InternalCodetemplatesParser.g:191:1: ( rule__TemplateBody__Group__0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup()); 
            // InternalCodetemplatesParser.g:192:1: ( rule__TemplateBody__Group__0 )
            // InternalCodetemplatesParser.g:192:2: rule__TemplateBody__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TemplateBody__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTemplateBodyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleTemplateBody"


    // $ANTLR start "entryRuleVariableOrDollar"
    // InternalCodetemplatesParser.g:207:1: entryRuleVariableOrDollar : ruleVariableOrDollar EOF ;
    public final void entryRuleVariableOrDollar() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:211:1: ( ruleVariableOrDollar EOF )
            // InternalCodetemplatesParser.g:212:1: ruleVariableOrDollar EOF
            {
             before(grammarAccess.getVariableOrDollarRule()); 
            pushFollow(FOLLOW_1);
            ruleVariableOrDollar();

            state._fsp--;

             after(grammarAccess.getVariableOrDollarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleVariableOrDollar"


    // $ANTLR start "ruleVariableOrDollar"
    // InternalCodetemplatesParser.g:222:1: ruleVariableOrDollar : ( ( rule__VariableOrDollar__Alternatives ) ) ;
    public final void ruleVariableOrDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:227:5: ( ( ( rule__VariableOrDollar__Alternatives ) ) )
            // InternalCodetemplatesParser.g:228:1: ( ( rule__VariableOrDollar__Alternatives ) )
            {
            // InternalCodetemplatesParser.g:228:1: ( ( rule__VariableOrDollar__Alternatives ) )
            // InternalCodetemplatesParser.g:229:1: ( rule__VariableOrDollar__Alternatives )
            {
             before(grammarAccess.getVariableOrDollarAccess().getAlternatives()); 
            // InternalCodetemplatesParser.g:230:1: ( rule__VariableOrDollar__Alternatives )
            // InternalCodetemplatesParser.g:230:2: rule__VariableOrDollar__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__VariableOrDollar__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVariableOrDollarAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleVariableOrDollar"


    // $ANTLR start "entryRuleVariable"
    // InternalCodetemplatesParser.g:243:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:247:1: ( ruleVariable EOF )
            // InternalCodetemplatesParser.g:248:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalCodetemplatesParser.g:258:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:263:5: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalCodetemplatesParser.g:264:1: ( ( rule__Variable__Group__0 ) )
            {
            // InternalCodetemplatesParser.g:264:1: ( ( rule__Variable__Group__0 ) )
            // InternalCodetemplatesParser.g:265:1: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalCodetemplatesParser.g:266:1: ( rule__Variable__Group__0 )
            // InternalCodetemplatesParser.g:266:2: rule__Variable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleValidID"
    // InternalCodetemplatesParser.g:279:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:283:1: ( ruleValidID EOF )
            // InternalCodetemplatesParser.g:284:1: ruleValidID EOF
            {
             before(grammarAccess.getValidIDRule()); 
            pushFollow(FOLLOW_1);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getValidIDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalCodetemplatesParser.g:294:1: ruleValidID : ( ( rule__ValidID__Alternatives ) ) ;
    public final void ruleValidID() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:299:5: ( ( ( rule__ValidID__Alternatives ) ) )
            // InternalCodetemplatesParser.g:300:1: ( ( rule__ValidID__Alternatives ) )
            {
            // InternalCodetemplatesParser.g:300:1: ( ( rule__ValidID__Alternatives ) )
            // InternalCodetemplatesParser.g:301:1: ( rule__ValidID__Alternatives )
            {
             before(grammarAccess.getValidIDAccess().getAlternatives()); 
            // InternalCodetemplatesParser.g:302:1: ( rule__ValidID__Alternatives )
            // InternalCodetemplatesParser.g:302:2: rule__ValidID__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ValidID__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValidIDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleFQN"
    // InternalCodetemplatesParser.g:315:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:319:1: ( ruleFQN EOF )
            // InternalCodetemplatesParser.g:320:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalCodetemplatesParser.g:330:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:335:5: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalCodetemplatesParser.g:336:1: ( ( rule__FQN__Group__0 ) )
            {
            // InternalCodetemplatesParser.g:336:1: ( ( rule__FQN__Group__0 ) )
            // InternalCodetemplatesParser.g:337:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalCodetemplatesParser.g:338:1: ( rule__FQN__Group__0 )
            // InternalCodetemplatesParser.g:338:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_2);
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
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleLiteral"
    // InternalCodetemplatesParser.g:351:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:355:1: ( ruleLiteral EOF )
            // InternalCodetemplatesParser.g:356:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalCodetemplatesParser.g:366:1: ruleLiteral : ( ( rule__Literal__ValueAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:371:5: ( ( ( rule__Literal__ValueAssignment ) ) )
            // InternalCodetemplatesParser.g:372:1: ( ( rule__Literal__ValueAssignment ) )
            {
            // InternalCodetemplatesParser.g:372:1: ( ( rule__Literal__ValueAssignment ) )
            // InternalCodetemplatesParser.g:373:1: ( rule__Literal__ValueAssignment )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment()); 
            // InternalCodetemplatesParser.g:374:1: ( rule__Literal__ValueAssignment )
            // InternalCodetemplatesParser.g:374:2: rule__Literal__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Literal__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleLiteralValue"
    // InternalCodetemplatesParser.g:387:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:391:1: ( ruleLiteralValue EOF )
            // InternalCodetemplatesParser.g:392:1: ruleLiteralValue EOF
            {
             before(grammarAccess.getLiteralValueRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteralValue();

            state._fsp--;

             after(grammarAccess.getLiteralValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralValue"


    // $ANTLR start "ruleLiteralValue"
    // InternalCodetemplatesParser.g:402:1: ruleLiteralValue : ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) ;
    public final void ruleLiteralValue() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:407:5: ( ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) )
            // InternalCodetemplatesParser.g:408:1: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            {
            // InternalCodetemplatesParser.g:408:1: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            // InternalCodetemplatesParser.g:409:1: ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* )
            {
            // InternalCodetemplatesParser.g:409:1: ( ( rule__LiteralValue__Alternatives ) )
            // InternalCodetemplatesParser.g:410:1: ( rule__LiteralValue__Alternatives )
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalCodetemplatesParser.g:411:1: ( rule__LiteralValue__Alternatives )
            // InternalCodetemplatesParser.g:411:2: rule__LiteralValue__Alternatives
            {
            pushFollow(FOLLOW_3);
            rule__LiteralValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralValueAccess().getAlternatives()); 

            }

            // InternalCodetemplatesParser.g:414:1: ( ( rule__LiteralValue__Alternatives )* )
            // InternalCodetemplatesParser.g:415:1: ( rule__LiteralValue__Alternatives )*
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalCodetemplatesParser.g:416:1: ( rule__LiteralValue__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ReverseSolidusLessThanSignLessThanSign||LA1_0==RULE_ID||(LA1_0>=RULE_WS && LA1_0<=RULE_ANY_OTHER)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:416:2: rule__LiteralValue__Alternatives
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__LiteralValue__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getLiteralValueAccess().getAlternatives()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleDollar"
    // InternalCodetemplatesParser.g:430:1: entryRuleDollar : ruleDollar EOF ;
    public final void entryRuleDollar() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:434:1: ( ruleDollar EOF )
            // InternalCodetemplatesParser.g:435:1: ruleDollar EOF
            {
             before(grammarAccess.getDollarRule()); 
            pushFollow(FOLLOW_1);
            ruleDollar();

            state._fsp--;

             after(grammarAccess.getDollarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleDollar"


    // $ANTLR start "ruleDollar"
    // InternalCodetemplatesParser.g:445:1: ruleDollar : ( ( rule__Dollar__Group__0 ) ) ;
    public final void ruleDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:450:5: ( ( ( rule__Dollar__Group__0 ) ) )
            // InternalCodetemplatesParser.g:451:1: ( ( rule__Dollar__Group__0 ) )
            {
            // InternalCodetemplatesParser.g:451:1: ( ( rule__Dollar__Group__0 ) )
            // InternalCodetemplatesParser.g:452:1: ( rule__Dollar__Group__0 )
            {
             before(grammarAccess.getDollarAccess().getGroup()); 
            // InternalCodetemplatesParser.g:453:1: ( rule__Dollar__Group__0 )
            // InternalCodetemplatesParser.g:453:2: rule__Dollar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Dollar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDollarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleDollar"


    // $ANTLR start "rule__Codetemplate__Alternatives_7"
    // InternalCodetemplatesParser.g:466:1: rule__Codetemplate__Alternatives_7 : ( ( ( rule__Codetemplate__ContextAssignment_7_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_7_1 ) ) );
    public final void rule__Codetemplate__Alternatives_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:470:1: ( ( ( rule__Codetemplate__ContextAssignment_7_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_7_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Templates||LA2_0==For||LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_STRING) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalCodetemplatesParser.g:471:1: ( ( rule__Codetemplate__ContextAssignment_7_0 ) )
                    {
                    // InternalCodetemplatesParser.g:471:1: ( ( rule__Codetemplate__ContextAssignment_7_0 ) )
                    // InternalCodetemplatesParser.g:472:1: ( rule__Codetemplate__ContextAssignment_7_0 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getContextAssignment_7_0()); 
                    // InternalCodetemplatesParser.g:473:1: ( rule__Codetemplate__ContextAssignment_7_0 )
                    // InternalCodetemplatesParser.g:473:2: rule__Codetemplate__ContextAssignment_7_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Codetemplate__ContextAssignment_7_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCodetemplateAccess().getContextAssignment_7_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:477:6: ( ( rule__Codetemplate__KeywordContextAssignment_7_1 ) )
                    {
                    // InternalCodetemplatesParser.g:477:6: ( ( rule__Codetemplate__KeywordContextAssignment_7_1 ) )
                    // InternalCodetemplatesParser.g:478:1: ( rule__Codetemplate__KeywordContextAssignment_7_1 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getKeywordContextAssignment_7_1()); 
                    // InternalCodetemplatesParser.g:479:1: ( rule__Codetemplate__KeywordContextAssignment_7_1 )
                    // InternalCodetemplatesParser.g:479:2: rule__Codetemplate__KeywordContextAssignment_7_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Codetemplate__KeywordContextAssignment_7_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getCodetemplateAccess().getKeywordContextAssignment_7_1()); 

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
    // $ANTLR end "rule__Codetemplate__Alternatives_7"


    // $ANTLR start "rule__VariableOrDollar__Alternatives"
    // InternalCodetemplatesParser.g:489:1: rule__VariableOrDollar__Alternatives : ( ( ruleVariable ) | ( ruleDollar ) );
    public final void rule__VariableOrDollar__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:493:1: ( ( ruleVariable ) | ( ruleDollar ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DollarSignLeftCurlyBracket) ) {
                alt3=1;
            }
            else if ( (LA3_0==DollarSignDollarSign||LA3_0==DollarSign) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalCodetemplatesParser.g:494:1: ( ruleVariable )
                    {
                    // InternalCodetemplatesParser.g:494:1: ( ruleVariable )
                    // InternalCodetemplatesParser.g:495:1: ruleVariable
                    {
                     before(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:500:6: ( ruleDollar )
                    {
                    // InternalCodetemplatesParser.g:500:6: ( ruleDollar )
                    // InternalCodetemplatesParser.g:501:1: ruleDollar
                    {
                     before(grammarAccess.getVariableOrDollarAccess().getDollarParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleDollar();

                    state._fsp--;

                     after(grammarAccess.getVariableOrDollarAccess().getDollarParserRuleCall_1()); 

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
    // $ANTLR end "rule__VariableOrDollar__Alternatives"


    // $ANTLR start "rule__Variable__Alternatives_2"
    // InternalCodetemplatesParser.g:511:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );
    public final void rule__Variable__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:515:1: ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalCodetemplatesParser.g:516:1: ( ( rule__Variable__NameAssignment_2_0 ) )
                    {
                    // InternalCodetemplatesParser.g:516:1: ( ( rule__Variable__NameAssignment_2_0 ) )
                    // InternalCodetemplatesParser.g:517:1: ( rule__Variable__NameAssignment_2_0 )
                    {
                     before(grammarAccess.getVariableAccess().getNameAssignment_2_0()); 
                    // InternalCodetemplatesParser.g:518:1: ( rule__Variable__NameAssignment_2_0 )
                    // InternalCodetemplatesParser.g:518:2: rule__Variable__NameAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Variable__NameAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVariableAccess().getNameAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:522:6: ( ( rule__Variable__Group_2_1__0 ) )
                    {
                    // InternalCodetemplatesParser.g:522:6: ( ( rule__Variable__Group_2_1__0 ) )
                    // InternalCodetemplatesParser.g:523:1: ( rule__Variable__Group_2_1__0 )
                    {
                     before(grammarAccess.getVariableAccess().getGroup_2_1()); 
                    // InternalCodetemplatesParser.g:524:1: ( rule__Variable__Group_2_1__0 )
                    // InternalCodetemplatesParser.g:524:2: rule__Variable__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Variable__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVariableAccess().getGroup_2_1()); 

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
    // $ANTLR end "rule__Variable__Alternatives_2"


    // $ANTLR start "rule__Variable__ParametersAlternatives_2_1_4_3_0_0"
    // InternalCodetemplatesParser.g:533:1: rule__Variable__ParametersAlternatives_2_1_4_3_0_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_3_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:537:1: ( ( RULE_STRING ) | ( ruleFQN ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==Templates||LA5_0==For||LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalCodetemplatesParser.g:538:1: ( RULE_STRING )
                    {
                    // InternalCodetemplatesParser.g:538:1: ( RULE_STRING )
                    // InternalCodetemplatesParser.g:539:1: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:544:6: ( ruleFQN )
                    {
                    // InternalCodetemplatesParser.g:544:6: ( ruleFQN )
                    // InternalCodetemplatesParser.g:545:1: ruleFQN
                    {
                     before(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFQN();

                    state._fsp--;

                     after(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_0_1()); 

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
    // $ANTLR end "rule__Variable__ParametersAlternatives_2_1_4_3_0_0"


    // $ANTLR start "rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0"
    // InternalCodetemplatesParser.g:555:1: rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:559:1: ( ( RULE_STRING ) | ( ruleFQN ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==Templates||LA6_0==For||LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalCodetemplatesParser.g:560:1: ( RULE_STRING )
                    {
                    // InternalCodetemplatesParser.g:560:1: ( RULE_STRING )
                    // InternalCodetemplatesParser.g:561:1: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:566:6: ( ruleFQN )
                    {
                    // InternalCodetemplatesParser.g:566:6: ( ruleFQN )
                    // InternalCodetemplatesParser.g:567:1: ruleFQN
                    {
                     before(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_1_3_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFQN();

                    state._fsp--;

                     after(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_1_3_0_1()); 

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
    // $ANTLR end "rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0"


    // $ANTLR start "rule__ValidID__Alternatives"
    // InternalCodetemplatesParser.g:577:1: rule__ValidID__Alternatives : ( ( RULE_ID ) | ( For ) | ( Templates ) );
    public final void rule__ValidID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:581:1: ( ( RULE_ID ) | ( For ) | ( Templates ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt7=1;
                }
                break;
            case For:
                {
                alt7=2;
                }
                break;
            case Templates:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalCodetemplatesParser.g:582:1: ( RULE_ID )
                    {
                    // InternalCodetemplatesParser.g:582:1: ( RULE_ID )
                    // InternalCodetemplatesParser.g:583:1: RULE_ID
                    {
                     before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:588:6: ( For )
                    {
                    // InternalCodetemplatesParser.g:588:6: ( For )
                    // InternalCodetemplatesParser.g:589:1: For
                    {
                     before(grammarAccess.getValidIDAccess().getForKeyword_1()); 
                    match(input,For,FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getForKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalCodetemplatesParser.g:596:6: ( Templates )
                    {
                    // InternalCodetemplatesParser.g:596:6: ( Templates )
                    // InternalCodetemplatesParser.g:597:1: Templates
                    {
                     before(grammarAccess.getValidIDAccess().getTemplatesKeyword_2()); 
                    match(input,Templates,FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getTemplatesKeyword_2()); 

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
    // $ANTLR end "rule__ValidID__Alternatives"


    // $ANTLR start "rule__LiteralValue__Alternatives"
    // InternalCodetemplatesParser.g:609:1: rule__LiteralValue__Alternatives : ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) | ( ReverseSolidusLessThanSignLessThanSign ) );
    public final void rule__LiteralValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:613:1: ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) | ( ReverseSolidusLessThanSignLessThanSign ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_WS:
                {
                alt8=1;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt8=2;
                }
                break;
            case RULE_ID:
                {
                alt8=3;
                }
                break;
            case ReverseSolidusLessThanSignLessThanSign:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalCodetemplatesParser.g:614:1: ( RULE_WS )
                    {
                    // InternalCodetemplatesParser.g:614:1: ( RULE_WS )
                    // InternalCodetemplatesParser.g:615:1: RULE_WS
                    {
                     before(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 
                    match(input,RULE_WS,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:620:6: ( RULE_ANY_OTHER )
                    {
                    // InternalCodetemplatesParser.g:620:6: ( RULE_ANY_OTHER )
                    // InternalCodetemplatesParser.g:621:1: RULE_ANY_OTHER
                    {
                     before(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 
                    match(input,RULE_ANY_OTHER,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalCodetemplatesParser.g:626:6: ( RULE_ID )
                    {
                    // InternalCodetemplatesParser.g:626:6: ( RULE_ID )
                    // InternalCodetemplatesParser.g:627:1: RULE_ID
                    {
                     before(grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalCodetemplatesParser.g:632:6: ( ReverseSolidusLessThanSignLessThanSign )
                    {
                    // InternalCodetemplatesParser.g:632:6: ( ReverseSolidusLessThanSignLessThanSign )
                    // InternalCodetemplatesParser.g:633:1: ReverseSolidusLessThanSignLessThanSign
                    {
                     before(grammarAccess.getLiteralValueAccess().getReverseSolidusLessThanSignLessThanSignKeyword_3()); 
                    match(input,ReverseSolidusLessThanSignLessThanSign,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getReverseSolidusLessThanSignLessThanSignKeyword_3()); 

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
    // $ANTLR end "rule__LiteralValue__Alternatives"


    // $ANTLR start "rule__Dollar__Alternatives_1"
    // InternalCodetemplatesParser.g:645:1: rule__Dollar__Alternatives_1 : ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( DollarSign ) );
    public final void rule__Dollar__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:649:1: ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( DollarSign ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==DollarSignDollarSign) ) {
                alt9=1;
            }
            else if ( (LA9_0==DollarSign) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalCodetemplatesParser.g:650:1: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    {
                    // InternalCodetemplatesParser.g:650:1: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    // InternalCodetemplatesParser.g:651:1: ( rule__Dollar__EscapedAssignment_1_0 )
                    {
                     before(grammarAccess.getDollarAccess().getEscapedAssignment_1_0()); 
                    // InternalCodetemplatesParser.g:652:1: ( rule__Dollar__EscapedAssignment_1_0 )
                    // InternalCodetemplatesParser.g:652:2: rule__Dollar__EscapedAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Dollar__EscapedAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDollarAccess().getEscapedAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:656:6: ( DollarSign )
                    {
                    // InternalCodetemplatesParser.g:656:6: ( DollarSign )
                    // InternalCodetemplatesParser.g:657:1: DollarSign
                    {
                     before(grammarAccess.getDollarAccess().getDollarSignKeyword_1_1()); 
                    match(input,DollarSign,FOLLOW_2); 
                     after(grammarAccess.getDollarAccess().getDollarSignKeyword_1_1()); 

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
    // $ANTLR end "rule__Dollar__Alternatives_1"


    // $ANTLR start "rule__Codetemplates__Group__0"
    // InternalCodetemplatesParser.g:671:1: rule__Codetemplates__Group__0 : rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 ;
    public final void rule__Codetemplates__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:675:1: ( rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 )
            // InternalCodetemplatesParser.g:676:2: rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Codetemplates__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplates__Group__1();

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
    // $ANTLR end "rule__Codetemplates__Group__0"


    // $ANTLR start "rule__Codetemplates__Group__0__Impl"
    // InternalCodetemplatesParser.g:683:1: rule__Codetemplates__Group__0__Impl : ( Templates ) ;
    public final void rule__Codetemplates__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:687:1: ( ( Templates ) )
            // InternalCodetemplatesParser.g:688:1: ( Templates )
            {
            // InternalCodetemplatesParser.g:688:1: ( Templates )
            // InternalCodetemplatesParser.g:689:1: Templates
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesKeyword_0()); 
            match(input,Templates,FOLLOW_2); 
             after(grammarAccess.getCodetemplatesAccess().getTemplatesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplates__Group__0__Impl"


    // $ANTLR start "rule__Codetemplates__Group__1"
    // InternalCodetemplatesParser.g:702:1: rule__Codetemplates__Group__1 : rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 ;
    public final void rule__Codetemplates__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:706:1: ( rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 )
            // InternalCodetemplatesParser.g:707:2: rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Codetemplates__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplates__Group__2();

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
    // $ANTLR end "rule__Codetemplates__Group__1"


    // $ANTLR start "rule__Codetemplates__Group__1__Impl"
    // InternalCodetemplatesParser.g:714:1: rule__Codetemplates__Group__1__Impl : ( For ) ;
    public final void rule__Codetemplates__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:718:1: ( ( For ) )
            // InternalCodetemplatesParser.g:719:1: ( For )
            {
            // InternalCodetemplatesParser.g:719:1: ( For )
            // InternalCodetemplatesParser.g:720:1: For
            {
             before(grammarAccess.getCodetemplatesAccess().getForKeyword_1()); 
            match(input,For,FOLLOW_2); 
             after(grammarAccess.getCodetemplatesAccess().getForKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplates__Group__1__Impl"


    // $ANTLR start "rule__Codetemplates__Group__2"
    // InternalCodetemplatesParser.g:733:1: rule__Codetemplates__Group__2 : rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 ;
    public final void rule__Codetemplates__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:737:1: ( rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 )
            // InternalCodetemplatesParser.g:738:2: rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Codetemplates__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplates__Group__3();

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
    // $ANTLR end "rule__Codetemplates__Group__2"


    // $ANTLR start "rule__Codetemplates__Group__2__Impl"
    // InternalCodetemplatesParser.g:745:1: rule__Codetemplates__Group__2__Impl : ( ( rule__Codetemplates__LanguageAssignment_2 ) ) ;
    public final void rule__Codetemplates__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:749:1: ( ( ( rule__Codetemplates__LanguageAssignment_2 ) ) )
            // InternalCodetemplatesParser.g:750:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            {
            // InternalCodetemplatesParser.g:750:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            // InternalCodetemplatesParser.g:751:1: ( rule__Codetemplates__LanguageAssignment_2 )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageAssignment_2()); 
            // InternalCodetemplatesParser.g:752:1: ( rule__Codetemplates__LanguageAssignment_2 )
            // InternalCodetemplatesParser.g:752:2: rule__Codetemplates__LanguageAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplates__LanguageAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplatesAccess().getLanguageAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplates__Group__2__Impl"


    // $ANTLR start "rule__Codetemplates__Group__3"
    // InternalCodetemplatesParser.g:762:1: rule__Codetemplates__Group__3 : rule__Codetemplates__Group__3__Impl rule__Codetemplates__Group__4 ;
    public final void rule__Codetemplates__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:766:1: ( rule__Codetemplates__Group__3__Impl rule__Codetemplates__Group__4 )
            // InternalCodetemplatesParser.g:767:2: rule__Codetemplates__Group__3__Impl rule__Codetemplates__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Codetemplates__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplates__Group__4();

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
    // $ANTLR end "rule__Codetemplates__Group__3"


    // $ANTLR start "rule__Codetemplates__Group__3__Impl"
    // InternalCodetemplatesParser.g:774:1: rule__Codetemplates__Group__3__Impl : ( Colon ) ;
    public final void rule__Codetemplates__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:778:1: ( ( Colon ) )
            // InternalCodetemplatesParser.g:779:1: ( Colon )
            {
            // InternalCodetemplatesParser.g:779:1: ( Colon )
            // InternalCodetemplatesParser.g:780:1: Colon
            {
             before(grammarAccess.getCodetemplatesAccess().getColonKeyword_3()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getCodetemplatesAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplates__Group__3__Impl"


    // $ANTLR start "rule__Codetemplates__Group__4"
    // InternalCodetemplatesParser.g:793:1: rule__Codetemplates__Group__4 : rule__Codetemplates__Group__4__Impl ;
    public final void rule__Codetemplates__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:797:1: ( rule__Codetemplates__Group__4__Impl )
            // InternalCodetemplatesParser.g:798:2: rule__Codetemplates__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplates__Group__4__Impl();

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
    // $ANTLR end "rule__Codetemplates__Group__4"


    // $ANTLR start "rule__Codetemplates__Group__4__Impl"
    // InternalCodetemplatesParser.g:804:1: rule__Codetemplates__Group__4__Impl : ( ( rule__Codetemplates__TemplatesAssignment_4 )* ) ;
    public final void rule__Codetemplates__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:808:1: ( ( ( rule__Codetemplates__TemplatesAssignment_4 )* ) )
            // InternalCodetemplatesParser.g:809:1: ( ( rule__Codetemplates__TemplatesAssignment_4 )* )
            {
            // InternalCodetemplatesParser.g:809:1: ( ( rule__Codetemplates__TemplatesAssignment_4 )* )
            // InternalCodetemplatesParser.g:810:1: ( rule__Codetemplates__TemplatesAssignment_4 )*
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesAssignment_4()); 
            // InternalCodetemplatesParser.g:811:1: ( rule__Codetemplates__TemplatesAssignment_4 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Templates||LA10_0==For||LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:811:2: rule__Codetemplates__TemplatesAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Codetemplates__TemplatesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getCodetemplatesAccess().getTemplatesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplates__Group__4__Impl"


    // $ANTLR start "rule__Codetemplate__Group__0"
    // InternalCodetemplatesParser.g:831:1: rule__Codetemplate__Group__0 : rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 ;
    public final void rule__Codetemplate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:835:1: ( rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 )
            // InternalCodetemplatesParser.g:836:2: rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Codetemplate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__1();

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
    // $ANTLR end "rule__Codetemplate__Group__0"


    // $ANTLR start "rule__Codetemplate__Group__0__Impl"
    // InternalCodetemplatesParser.g:843:1: rule__Codetemplate__Group__0__Impl : ( ( rule__Codetemplate__NameAssignment_0 ) ) ;
    public final void rule__Codetemplate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:847:1: ( ( ( rule__Codetemplate__NameAssignment_0 ) ) )
            // InternalCodetemplatesParser.g:848:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            {
            // InternalCodetemplatesParser.g:848:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            // InternalCodetemplatesParser.g:849:1: ( rule__Codetemplate__NameAssignment_0 )
            {
             before(grammarAccess.getCodetemplateAccess().getNameAssignment_0()); 
            // InternalCodetemplatesParser.g:850:1: ( rule__Codetemplate__NameAssignment_0 )
            // InternalCodetemplatesParser.g:850:2: rule__Codetemplate__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplate__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplateAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__Group__0__Impl"


    // $ANTLR start "rule__Codetemplate__Group__1"
    // InternalCodetemplatesParser.g:860:1: rule__Codetemplate__Group__1 : rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 ;
    public final void rule__Codetemplate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:864:1: ( rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 )
            // InternalCodetemplatesParser.g:865:2: rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__Codetemplate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__2();

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
    // $ANTLR end "rule__Codetemplate__Group__1"


    // $ANTLR start "rule__Codetemplate__Group__1__Impl"
    // InternalCodetemplatesParser.g:872:1: rule__Codetemplate__Group__1__Impl : ( LeftParenthesis ) ;
    public final void rule__Codetemplate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:876:1: ( ( LeftParenthesis ) )
            // InternalCodetemplatesParser.g:877:1: ( LeftParenthesis )
            {
            // InternalCodetemplatesParser.g:877:1: ( LeftParenthesis )
            // InternalCodetemplatesParser.g:878:1: LeftParenthesis
            {
             before(grammarAccess.getCodetemplateAccess().getLeftParenthesisKeyword_1()); 
            match(input,LeftParenthesis,FOLLOW_2); 
             after(grammarAccess.getCodetemplateAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__Group__1__Impl"


    // $ANTLR start "rule__Codetemplate__Group__2"
    // InternalCodetemplatesParser.g:891:1: rule__Codetemplate__Group__2 : rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 ;
    public final void rule__Codetemplate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:895:1: ( rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 )
            // InternalCodetemplatesParser.g:896:2: rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__Codetemplate__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__3();

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
    // $ANTLR end "rule__Codetemplate__Group__2"


    // $ANTLR start "rule__Codetemplate__Group__2__Impl"
    // InternalCodetemplatesParser.g:903:1: rule__Codetemplate__Group__2__Impl : ( ( rule__Codetemplate__IdAssignment_2 ) ) ;
    public final void rule__Codetemplate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:907:1: ( ( ( rule__Codetemplate__IdAssignment_2 ) ) )
            // InternalCodetemplatesParser.g:908:1: ( ( rule__Codetemplate__IdAssignment_2 ) )
            {
            // InternalCodetemplatesParser.g:908:1: ( ( rule__Codetemplate__IdAssignment_2 ) )
            // InternalCodetemplatesParser.g:909:1: ( rule__Codetemplate__IdAssignment_2 )
            {
             before(grammarAccess.getCodetemplateAccess().getIdAssignment_2()); 
            // InternalCodetemplatesParser.g:910:1: ( rule__Codetemplate__IdAssignment_2 )
            // InternalCodetemplatesParser.g:910:2: rule__Codetemplate__IdAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplate__IdAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplateAccess().getIdAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__Group__2__Impl"


    // $ANTLR start "rule__Codetemplate__Group__3"
    // InternalCodetemplatesParser.g:920:1: rule__Codetemplate__Group__3 : rule__Codetemplate__Group__3__Impl rule__Codetemplate__Group__4 ;
    public final void rule__Codetemplate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:924:1: ( rule__Codetemplate__Group__3__Impl rule__Codetemplate__Group__4 )
            // InternalCodetemplatesParser.g:925:2: rule__Codetemplate__Group__3__Impl rule__Codetemplate__Group__4
            {
            pushFollow(FOLLOW_11);
            rule__Codetemplate__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__4();

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
    // $ANTLR end "rule__Codetemplate__Group__3"


    // $ANTLR start "rule__Codetemplate__Group__3__Impl"
    // InternalCodetemplatesParser.g:932:1: rule__Codetemplate__Group__3__Impl : ( Comma ) ;
    public final void rule__Codetemplate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:936:1: ( ( Comma ) )
            // InternalCodetemplatesParser.g:937:1: ( Comma )
            {
            // InternalCodetemplatesParser.g:937:1: ( Comma )
            // InternalCodetemplatesParser.g:938:1: Comma
            {
             before(grammarAccess.getCodetemplateAccess().getCommaKeyword_3()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getCodetemplateAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__Group__3__Impl"


    // $ANTLR start "rule__Codetemplate__Group__4"
    // InternalCodetemplatesParser.g:951:1: rule__Codetemplate__Group__4 : rule__Codetemplate__Group__4__Impl rule__Codetemplate__Group__5 ;
    public final void rule__Codetemplate__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:955:1: ( rule__Codetemplate__Group__4__Impl rule__Codetemplate__Group__5 )
            // InternalCodetemplatesParser.g:956:2: rule__Codetemplate__Group__4__Impl rule__Codetemplate__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__Codetemplate__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__5();

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
    // $ANTLR end "rule__Codetemplate__Group__4"


    // $ANTLR start "rule__Codetemplate__Group__4__Impl"
    // InternalCodetemplatesParser.g:963:1: rule__Codetemplate__Group__4__Impl : ( ( rule__Codetemplate__DescriptionAssignment_4 ) ) ;
    public final void rule__Codetemplate__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:967:1: ( ( ( rule__Codetemplate__DescriptionAssignment_4 ) ) )
            // InternalCodetemplatesParser.g:968:1: ( ( rule__Codetemplate__DescriptionAssignment_4 ) )
            {
            // InternalCodetemplatesParser.g:968:1: ( ( rule__Codetemplate__DescriptionAssignment_4 ) )
            // InternalCodetemplatesParser.g:969:1: ( rule__Codetemplate__DescriptionAssignment_4 )
            {
             before(grammarAccess.getCodetemplateAccess().getDescriptionAssignment_4()); 
            // InternalCodetemplatesParser.g:970:1: ( rule__Codetemplate__DescriptionAssignment_4 )
            // InternalCodetemplatesParser.g:970:2: rule__Codetemplate__DescriptionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplate__DescriptionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplateAccess().getDescriptionAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__Group__4__Impl"


    // $ANTLR start "rule__Codetemplate__Group__5"
    // InternalCodetemplatesParser.g:980:1: rule__Codetemplate__Group__5 : rule__Codetemplate__Group__5__Impl rule__Codetemplate__Group__6 ;
    public final void rule__Codetemplate__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:984:1: ( rule__Codetemplate__Group__5__Impl rule__Codetemplate__Group__6 )
            // InternalCodetemplatesParser.g:985:2: rule__Codetemplate__Group__5__Impl rule__Codetemplate__Group__6
            {
            pushFollow(FOLLOW_4);
            rule__Codetemplate__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__6();

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
    // $ANTLR end "rule__Codetemplate__Group__5"


    // $ANTLR start "rule__Codetemplate__Group__5__Impl"
    // InternalCodetemplatesParser.g:992:1: rule__Codetemplate__Group__5__Impl : ( RightParenthesis ) ;
    public final void rule__Codetemplate__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:996:1: ( ( RightParenthesis ) )
            // InternalCodetemplatesParser.g:997:1: ( RightParenthesis )
            {
            // InternalCodetemplatesParser.g:997:1: ( RightParenthesis )
            // InternalCodetemplatesParser.g:998:1: RightParenthesis
            {
             before(grammarAccess.getCodetemplateAccess().getRightParenthesisKeyword_5()); 
            match(input,RightParenthesis,FOLLOW_2); 
             after(grammarAccess.getCodetemplateAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__Group__5__Impl"


    // $ANTLR start "rule__Codetemplate__Group__6"
    // InternalCodetemplatesParser.g:1011:1: rule__Codetemplate__Group__6 : rule__Codetemplate__Group__6__Impl rule__Codetemplate__Group__7 ;
    public final void rule__Codetemplate__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1015:1: ( rule__Codetemplate__Group__6__Impl rule__Codetemplate__Group__7 )
            // InternalCodetemplatesParser.g:1016:2: rule__Codetemplate__Group__6__Impl rule__Codetemplate__Group__7
            {
            pushFollow(FOLLOW_13);
            rule__Codetemplate__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__7();

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
    // $ANTLR end "rule__Codetemplate__Group__6"


    // $ANTLR start "rule__Codetemplate__Group__6__Impl"
    // InternalCodetemplatesParser.g:1023:1: rule__Codetemplate__Group__6__Impl : ( For ) ;
    public final void rule__Codetemplate__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1027:1: ( ( For ) )
            // InternalCodetemplatesParser.g:1028:1: ( For )
            {
            // InternalCodetemplatesParser.g:1028:1: ( For )
            // InternalCodetemplatesParser.g:1029:1: For
            {
             before(grammarAccess.getCodetemplateAccess().getForKeyword_6()); 
            match(input,For,FOLLOW_2); 
             after(grammarAccess.getCodetemplateAccess().getForKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__Group__6__Impl"


    // $ANTLR start "rule__Codetemplate__Group__7"
    // InternalCodetemplatesParser.g:1042:1: rule__Codetemplate__Group__7 : rule__Codetemplate__Group__7__Impl rule__Codetemplate__Group__8 ;
    public final void rule__Codetemplate__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1046:1: ( rule__Codetemplate__Group__7__Impl rule__Codetemplate__Group__8 )
            // InternalCodetemplatesParser.g:1047:2: rule__Codetemplate__Group__7__Impl rule__Codetemplate__Group__8
            {
            pushFollow(FOLLOW_14);
            rule__Codetemplate__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__8();

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
    // $ANTLR end "rule__Codetemplate__Group__7"


    // $ANTLR start "rule__Codetemplate__Group__7__Impl"
    // InternalCodetemplatesParser.g:1054:1: rule__Codetemplate__Group__7__Impl : ( ( rule__Codetemplate__Alternatives_7 ) ) ;
    public final void rule__Codetemplate__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1058:1: ( ( ( rule__Codetemplate__Alternatives_7 ) ) )
            // InternalCodetemplatesParser.g:1059:1: ( ( rule__Codetemplate__Alternatives_7 ) )
            {
            // InternalCodetemplatesParser.g:1059:1: ( ( rule__Codetemplate__Alternatives_7 ) )
            // InternalCodetemplatesParser.g:1060:1: ( rule__Codetemplate__Alternatives_7 )
            {
             before(grammarAccess.getCodetemplateAccess().getAlternatives_7()); 
            // InternalCodetemplatesParser.g:1061:1: ( rule__Codetemplate__Alternatives_7 )
            // InternalCodetemplatesParser.g:1061:2: rule__Codetemplate__Alternatives_7
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplate__Alternatives_7();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplateAccess().getAlternatives_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__Group__7__Impl"


    // $ANTLR start "rule__Codetemplate__Group__8"
    // InternalCodetemplatesParser.g:1071:1: rule__Codetemplate__Group__8 : rule__Codetemplate__Group__8__Impl ;
    public final void rule__Codetemplate__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1075:1: ( rule__Codetemplate__Group__8__Impl )
            // InternalCodetemplatesParser.g:1076:2: rule__Codetemplate__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__8__Impl();

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
    // $ANTLR end "rule__Codetemplate__Group__8"


    // $ANTLR start "rule__Codetemplate__Group__8__Impl"
    // InternalCodetemplatesParser.g:1082:1: rule__Codetemplate__Group__8__Impl : ( ( rule__Codetemplate__BodyAssignment_8 ) ) ;
    public final void rule__Codetemplate__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1086:1: ( ( ( rule__Codetemplate__BodyAssignment_8 ) ) )
            // InternalCodetemplatesParser.g:1087:1: ( ( rule__Codetemplate__BodyAssignment_8 ) )
            {
            // InternalCodetemplatesParser.g:1087:1: ( ( rule__Codetemplate__BodyAssignment_8 ) )
            // InternalCodetemplatesParser.g:1088:1: ( rule__Codetemplate__BodyAssignment_8 )
            {
             before(grammarAccess.getCodetemplateAccess().getBodyAssignment_8()); 
            // InternalCodetemplatesParser.g:1089:1: ( rule__Codetemplate__BodyAssignment_8 )
            // InternalCodetemplatesParser.g:1089:2: rule__Codetemplate__BodyAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplate__BodyAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplateAccess().getBodyAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__Group__8__Impl"


    // $ANTLR start "rule__TemplateBodyWithQuotes__Group__0"
    // InternalCodetemplatesParser.g:1117:1: rule__TemplateBodyWithQuotes__Group__0 : rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 ;
    public final void rule__TemplateBodyWithQuotes__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1121:1: ( rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 )
            // InternalCodetemplatesParser.g:1122:2: rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__TemplateBodyWithQuotes__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemplateBodyWithQuotes__Group__1();

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
    // $ANTLR end "rule__TemplateBodyWithQuotes__Group__0"


    // $ANTLR start "rule__TemplateBodyWithQuotes__Group__0__Impl"
    // InternalCodetemplatesParser.g:1129:1: rule__TemplateBodyWithQuotes__Group__0__Impl : ( ( RULE_WS )? ) ;
    public final void rule__TemplateBodyWithQuotes__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1133:1: ( ( ( RULE_WS )? ) )
            // InternalCodetemplatesParser.g:1134:1: ( ( RULE_WS )? )
            {
            // InternalCodetemplatesParser.g:1134:1: ( ( RULE_WS )? )
            // InternalCodetemplatesParser.g:1135:1: ( RULE_WS )?
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getWSTerminalRuleCall_0()); 
            // InternalCodetemplatesParser.g:1136:1: ( RULE_WS )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_WS) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalCodetemplatesParser.g:1136:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getTemplateBodyWithQuotesAccess().getWSTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBodyWithQuotes__Group__0__Impl"


    // $ANTLR start "rule__TemplateBodyWithQuotes__Group__1"
    // InternalCodetemplatesParser.g:1146:1: rule__TemplateBodyWithQuotes__Group__1 : rule__TemplateBodyWithQuotes__Group__1__Impl rule__TemplateBodyWithQuotes__Group__2 ;
    public final void rule__TemplateBodyWithQuotes__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1150:1: ( rule__TemplateBodyWithQuotes__Group__1__Impl rule__TemplateBodyWithQuotes__Group__2 )
            // InternalCodetemplatesParser.g:1151:2: rule__TemplateBodyWithQuotes__Group__1__Impl rule__TemplateBodyWithQuotes__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__TemplateBodyWithQuotes__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemplateBodyWithQuotes__Group__2();

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
    // $ANTLR end "rule__TemplateBodyWithQuotes__Group__1"


    // $ANTLR start "rule__TemplateBodyWithQuotes__Group__1__Impl"
    // InternalCodetemplatesParser.g:1158:1: rule__TemplateBodyWithQuotes__Group__1__Impl : ( GreaterThanSignGreaterThanSign ) ;
    public final void rule__TemplateBodyWithQuotes__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1162:1: ( ( GreaterThanSignGreaterThanSign ) )
            // InternalCodetemplatesParser.g:1163:1: ( GreaterThanSignGreaterThanSign )
            {
            // InternalCodetemplatesParser.g:1163:1: ( GreaterThanSignGreaterThanSign )
            // InternalCodetemplatesParser.g:1164:1: GreaterThanSignGreaterThanSign
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_1()); 
            match(input,GreaterThanSignGreaterThanSign,FOLLOW_2); 
             after(grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBodyWithQuotes__Group__1__Impl"


    // $ANTLR start "rule__TemplateBodyWithQuotes__Group__2"
    // InternalCodetemplatesParser.g:1177:1: rule__TemplateBodyWithQuotes__Group__2 : rule__TemplateBodyWithQuotes__Group__2__Impl rule__TemplateBodyWithQuotes__Group__3 ;
    public final void rule__TemplateBodyWithQuotes__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1181:1: ( rule__TemplateBodyWithQuotes__Group__2__Impl rule__TemplateBodyWithQuotes__Group__3 )
            // InternalCodetemplatesParser.g:1182:2: rule__TemplateBodyWithQuotes__Group__2__Impl rule__TemplateBodyWithQuotes__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__TemplateBodyWithQuotes__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemplateBodyWithQuotes__Group__3();

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
    // $ANTLR end "rule__TemplateBodyWithQuotes__Group__2"


    // $ANTLR start "rule__TemplateBodyWithQuotes__Group__2__Impl"
    // InternalCodetemplatesParser.g:1189:1: rule__TemplateBodyWithQuotes__Group__2__Impl : ( ruleTemplateBody ) ;
    public final void rule__TemplateBodyWithQuotes__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1193:1: ( ( ruleTemplateBody ) )
            // InternalCodetemplatesParser.g:1194:1: ( ruleTemplateBody )
            {
            // InternalCodetemplatesParser.g:1194:1: ( ruleTemplateBody )
            // InternalCodetemplatesParser.g:1195:1: ruleTemplateBody
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_2()); 
            pushFollow(FOLLOW_2);
            ruleTemplateBody();

            state._fsp--;

             after(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBodyWithQuotes__Group__2__Impl"


    // $ANTLR start "rule__TemplateBodyWithQuotes__Group__3"
    // InternalCodetemplatesParser.g:1206:1: rule__TemplateBodyWithQuotes__Group__3 : rule__TemplateBodyWithQuotes__Group__3__Impl ;
    public final void rule__TemplateBodyWithQuotes__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1210:1: ( rule__TemplateBodyWithQuotes__Group__3__Impl )
            // InternalCodetemplatesParser.g:1211:2: rule__TemplateBodyWithQuotes__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TemplateBodyWithQuotes__Group__3__Impl();

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
    // $ANTLR end "rule__TemplateBodyWithQuotes__Group__3"


    // $ANTLR start "rule__TemplateBodyWithQuotes__Group__3__Impl"
    // InternalCodetemplatesParser.g:1217:1: rule__TemplateBodyWithQuotes__Group__3__Impl : ( LessThanSignLessThanSign ) ;
    public final void rule__TemplateBodyWithQuotes__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1221:1: ( ( LessThanSignLessThanSign ) )
            // InternalCodetemplatesParser.g:1222:1: ( LessThanSignLessThanSign )
            {
            // InternalCodetemplatesParser.g:1222:1: ( LessThanSignLessThanSign )
            // InternalCodetemplatesParser.g:1223:1: LessThanSignLessThanSign
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getLessThanSignLessThanSignKeyword_3()); 
            match(input,LessThanSignLessThanSign,FOLLOW_2); 
             after(grammarAccess.getTemplateBodyWithQuotesAccess().getLessThanSignLessThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBodyWithQuotes__Group__3__Impl"


    // $ANTLR start "rule__TemplateBody__Group__0"
    // InternalCodetemplatesParser.g:1244:1: rule__TemplateBody__Group__0 : rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 ;
    public final void rule__TemplateBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1248:1: ( rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 )
            // InternalCodetemplatesParser.g:1249:2: rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__TemplateBody__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemplateBody__Group__1();

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
    // $ANTLR end "rule__TemplateBody__Group__0"


    // $ANTLR start "rule__TemplateBody__Group__0__Impl"
    // InternalCodetemplatesParser.g:1256:1: rule__TemplateBody__Group__0__Impl : ( () ) ;
    public final void rule__TemplateBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1260:1: ( ( () ) )
            // InternalCodetemplatesParser.g:1261:1: ( () )
            {
            // InternalCodetemplatesParser.g:1261:1: ( () )
            // InternalCodetemplatesParser.g:1262:1: ()
            {
             before(grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0()); 
            // InternalCodetemplatesParser.g:1263:1: ()
            // InternalCodetemplatesParser.g:1265:1: 
            {
            }

             after(grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBody__Group__0__Impl"


    // $ANTLR start "rule__TemplateBody__Group__1"
    // InternalCodetemplatesParser.g:1275:1: rule__TemplateBody__Group__1 : rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 ;
    public final void rule__TemplateBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1279:1: ( rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 )
            // InternalCodetemplatesParser.g:1280:2: rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__TemplateBody__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemplateBody__Group__2();

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
    // $ANTLR end "rule__TemplateBody__Group__1"


    // $ANTLR start "rule__TemplateBody__Group__1__Impl"
    // InternalCodetemplatesParser.g:1287:1: rule__TemplateBody__Group__1__Impl : ( ( rule__TemplateBody__PartsAssignment_1 )? ) ;
    public final void rule__TemplateBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1291:1: ( ( ( rule__TemplateBody__PartsAssignment_1 )? ) )
            // InternalCodetemplatesParser.g:1292:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            {
            // InternalCodetemplatesParser.g:1292:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            // InternalCodetemplatesParser.g:1293:1: ( rule__TemplateBody__PartsAssignment_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_1()); 
            // InternalCodetemplatesParser.g:1294:1: ( rule__TemplateBody__PartsAssignment_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ReverseSolidusLessThanSignLessThanSign||LA12_0==RULE_ID||(LA12_0>=RULE_WS && LA12_0<=RULE_ANY_OTHER)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalCodetemplatesParser.g:1294:2: rule__TemplateBody__PartsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__TemplateBody__PartsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTemplateBodyAccess().getPartsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBody__Group__1__Impl"


    // $ANTLR start "rule__TemplateBody__Group__2"
    // InternalCodetemplatesParser.g:1304:1: rule__TemplateBody__Group__2 : rule__TemplateBody__Group__2__Impl ;
    public final void rule__TemplateBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1308:1: ( rule__TemplateBody__Group__2__Impl )
            // InternalCodetemplatesParser.g:1309:2: rule__TemplateBody__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TemplateBody__Group__2__Impl();

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
    // $ANTLR end "rule__TemplateBody__Group__2"


    // $ANTLR start "rule__TemplateBody__Group__2__Impl"
    // InternalCodetemplatesParser.g:1315:1: rule__TemplateBody__Group__2__Impl : ( ( rule__TemplateBody__Group_2__0 )* ) ;
    public final void rule__TemplateBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1319:1: ( ( ( rule__TemplateBody__Group_2__0 )* ) )
            // InternalCodetemplatesParser.g:1320:1: ( ( rule__TemplateBody__Group_2__0 )* )
            {
            // InternalCodetemplatesParser.g:1320:1: ( ( rule__TemplateBody__Group_2__0 )* )
            // InternalCodetemplatesParser.g:1321:1: ( rule__TemplateBody__Group_2__0 )*
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup_2()); 
            // InternalCodetemplatesParser.g:1322:1: ( rule__TemplateBody__Group_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=DollarSignDollarSign && LA13_0<=DollarSignLeftCurlyBracket)||LA13_0==DollarSign) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:1322:2: rule__TemplateBody__Group_2__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__TemplateBody__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getTemplateBodyAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBody__Group__2__Impl"


    // $ANTLR start "rule__TemplateBody__Group_2__0"
    // InternalCodetemplatesParser.g:1338:1: rule__TemplateBody__Group_2__0 : rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 ;
    public final void rule__TemplateBody__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1342:1: ( rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 )
            // InternalCodetemplatesParser.g:1343:2: rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1
            {
            pushFollow(FOLLOW_18);
            rule__TemplateBody__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemplateBody__Group_2__1();

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
    // $ANTLR end "rule__TemplateBody__Group_2__0"


    // $ANTLR start "rule__TemplateBody__Group_2__0__Impl"
    // InternalCodetemplatesParser.g:1350:1: rule__TemplateBody__Group_2__0__Impl : ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) ;
    public final void rule__TemplateBody__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1354:1: ( ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) )
            // InternalCodetemplatesParser.g:1355:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            {
            // InternalCodetemplatesParser.g:1355:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            // InternalCodetemplatesParser.g:1356:1: ( rule__TemplateBody__PartsAssignment_2_0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_0()); 
            // InternalCodetemplatesParser.g:1357:1: ( rule__TemplateBody__PartsAssignment_2_0 )
            // InternalCodetemplatesParser.g:1357:2: rule__TemplateBody__PartsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__TemplateBody__PartsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBody__Group_2__0__Impl"


    // $ANTLR start "rule__TemplateBody__Group_2__1"
    // InternalCodetemplatesParser.g:1367:1: rule__TemplateBody__Group_2__1 : rule__TemplateBody__Group_2__1__Impl ;
    public final void rule__TemplateBody__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1371:1: ( rule__TemplateBody__Group_2__1__Impl )
            // InternalCodetemplatesParser.g:1372:2: rule__TemplateBody__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TemplateBody__Group_2__1__Impl();

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
    // $ANTLR end "rule__TemplateBody__Group_2__1"


    // $ANTLR start "rule__TemplateBody__Group_2__1__Impl"
    // InternalCodetemplatesParser.g:1378:1: rule__TemplateBody__Group_2__1__Impl : ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) ;
    public final void rule__TemplateBody__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1382:1: ( ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) )
            // InternalCodetemplatesParser.g:1383:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            {
            // InternalCodetemplatesParser.g:1383:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            // InternalCodetemplatesParser.g:1384:1: ( rule__TemplateBody__PartsAssignment_2_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_1()); 
            // InternalCodetemplatesParser.g:1385:1: ( rule__TemplateBody__PartsAssignment_2_1 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ReverseSolidusLessThanSignLessThanSign||LA14_0==RULE_ID||(LA14_0>=RULE_WS && LA14_0<=RULE_ANY_OTHER)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalCodetemplatesParser.g:1385:2: rule__TemplateBody__PartsAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__TemplateBody__PartsAssignment_2_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBody__Group_2__1__Impl"


    // $ANTLR start "rule__Variable__Group__0"
    // InternalCodetemplatesParser.g:1399:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1403:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalCodetemplatesParser.g:1404:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Variable__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__1();

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
    // $ANTLR end "rule__Variable__Group__0"


    // $ANTLR start "rule__Variable__Group__0__Impl"
    // InternalCodetemplatesParser.g:1411:1: rule__Variable__Group__0__Impl : ( DollarSignLeftCurlyBracket ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1415:1: ( ( DollarSignLeftCurlyBracket ) )
            // InternalCodetemplatesParser.g:1416:1: ( DollarSignLeftCurlyBracket )
            {
            // InternalCodetemplatesParser.g:1416:1: ( DollarSignLeftCurlyBracket )
            // InternalCodetemplatesParser.g:1417:1: DollarSignLeftCurlyBracket
            {
             before(grammarAccess.getVariableAccess().getDollarSignLeftCurlyBracketKeyword_0()); 
            match(input,DollarSignLeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getDollarSignLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0__Impl"


    // $ANTLR start "rule__Variable__Group__1"
    // InternalCodetemplatesParser.g:1430:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1434:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalCodetemplatesParser.g:1435:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__Variable__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__2();

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
    // $ANTLR end "rule__Variable__Group__1"


    // $ANTLR start "rule__Variable__Group__1__Impl"
    // InternalCodetemplatesParser.g:1442:1: rule__Variable__Group__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1446:1: ( ( ( RULE_WS )* ) )
            // InternalCodetemplatesParser.g:1447:1: ( ( RULE_WS )* )
            {
            // InternalCodetemplatesParser.g:1447:1: ( ( RULE_WS )* )
            // InternalCodetemplatesParser.g:1448:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_1()); 
            // InternalCodetemplatesParser.g:1449:1: ( RULE_WS )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_WS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:1449:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_20); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1__Impl"


    // $ANTLR start "rule__Variable__Group__2"
    // InternalCodetemplatesParser.g:1459:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1463:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalCodetemplatesParser.g:1464:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__Variable__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__3();

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
    // $ANTLR end "rule__Variable__Group__2"


    // $ANTLR start "rule__Variable__Group__2__Impl"
    // InternalCodetemplatesParser.g:1471:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Alternatives_2 ) ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1475:1: ( ( ( rule__Variable__Alternatives_2 ) ) )
            // InternalCodetemplatesParser.g:1476:1: ( ( rule__Variable__Alternatives_2 ) )
            {
            // InternalCodetemplatesParser.g:1476:1: ( ( rule__Variable__Alternatives_2 ) )
            // InternalCodetemplatesParser.g:1477:1: ( rule__Variable__Alternatives_2 )
            {
             before(grammarAccess.getVariableAccess().getAlternatives_2()); 
            // InternalCodetemplatesParser.g:1478:1: ( rule__Variable__Alternatives_2 )
            // InternalCodetemplatesParser.g:1478:2: rule__Variable__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__2__Impl"


    // $ANTLR start "rule__Variable__Group__3"
    // InternalCodetemplatesParser.g:1488:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl rule__Variable__Group__4 ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1492:1: ( rule__Variable__Group__3__Impl rule__Variable__Group__4 )
            // InternalCodetemplatesParser.g:1493:2: rule__Variable__Group__3__Impl rule__Variable__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__Variable__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__4();

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
    // $ANTLR end "rule__Variable__Group__3"


    // $ANTLR start "rule__Variable__Group__3__Impl"
    // InternalCodetemplatesParser.g:1500:1: rule__Variable__Group__3__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1504:1: ( ( ( RULE_WS )* ) )
            // InternalCodetemplatesParser.g:1505:1: ( ( RULE_WS )* )
            {
            // InternalCodetemplatesParser.g:1505:1: ( ( RULE_WS )* )
            // InternalCodetemplatesParser.g:1506:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_3()); 
            // InternalCodetemplatesParser.g:1507:1: ( RULE_WS )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_WS) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:1507:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_20); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__3__Impl"


    // $ANTLR start "rule__Variable__Group__4"
    // InternalCodetemplatesParser.g:1517:1: rule__Variable__Group__4 : rule__Variable__Group__4__Impl ;
    public final void rule__Variable__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1521:1: ( rule__Variable__Group__4__Impl )
            // InternalCodetemplatesParser.g:1522:2: rule__Variable__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__4__Impl();

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
    // $ANTLR end "rule__Variable__Group__4"


    // $ANTLR start "rule__Variable__Group__4__Impl"
    // InternalCodetemplatesParser.g:1528:1: rule__Variable__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__Variable__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1532:1: ( ( RightCurlyBracket ) )
            // InternalCodetemplatesParser.g:1533:1: ( RightCurlyBracket )
            {
            // InternalCodetemplatesParser.g:1533:1: ( RightCurlyBracket )
            // InternalCodetemplatesParser.g:1534:1: RightCurlyBracket
            {
             before(grammarAccess.getVariableAccess().getRightCurlyBracketKeyword_4()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__4__Impl"


    // $ANTLR start "rule__Variable__Group_2_1__0"
    // InternalCodetemplatesParser.g:1557:1: rule__Variable__Group_2_1__0 : rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 ;
    public final void rule__Variable__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1561:1: ( rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 )
            // InternalCodetemplatesParser.g:1562:2: rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1
            {
            pushFollow(FOLLOW_19);
            rule__Variable__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1__1();

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
    // $ANTLR end "rule__Variable__Group_2_1__0"


    // $ANTLR start "rule__Variable__Group_2_1__0__Impl"
    // InternalCodetemplatesParser.g:1569:1: rule__Variable__Group_2_1__0__Impl : ( ( rule__Variable__Group_2_1_0__0 )? ) ;
    public final void rule__Variable__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1573:1: ( ( ( rule__Variable__Group_2_1_0__0 )? ) )
            // InternalCodetemplatesParser.g:1574:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            {
            // InternalCodetemplatesParser.g:1574:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            // InternalCodetemplatesParser.g:1575:1: ( rule__Variable__Group_2_1_0__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_0()); 
            // InternalCodetemplatesParser.g:1576:1: ( rule__Variable__Group_2_1_0__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Templates||LA17_0==For||LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalCodetemplatesParser.g:1576:2: rule__Variable__Group_2_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Variable__Group_2_1_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableAccess().getGroup_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1__0__Impl"


    // $ANTLR start "rule__Variable__Group_2_1__1"
    // InternalCodetemplatesParser.g:1586:1: rule__Variable__Group_2_1__1 : rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 ;
    public final void rule__Variable__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1590:1: ( rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 )
            // InternalCodetemplatesParser.g:1591:2: rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2
            {
            pushFollow(FOLLOW_22);
            rule__Variable__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1__2();

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
    // $ANTLR end "rule__Variable__Group_2_1__1"


    // $ANTLR start "rule__Variable__Group_2_1__1__Impl"
    // InternalCodetemplatesParser.g:1598:1: rule__Variable__Group_2_1__1__Impl : ( Colon ) ;
    public final void rule__Variable__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1602:1: ( ( Colon ) )
            // InternalCodetemplatesParser.g:1603:1: ( Colon )
            {
            // InternalCodetemplatesParser.g:1603:1: ( Colon )
            // InternalCodetemplatesParser.g:1604:1: Colon
            {
             before(grammarAccess.getVariableAccess().getColonKeyword_2_1_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getColonKeyword_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1__1__Impl"


    // $ANTLR start "rule__Variable__Group_2_1__2"
    // InternalCodetemplatesParser.g:1617:1: rule__Variable__Group_2_1__2 : rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 ;
    public final void rule__Variable__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1621:1: ( rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 )
            // InternalCodetemplatesParser.g:1622:2: rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3
            {
            pushFollow(FOLLOW_22);
            rule__Variable__Group_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1__3();

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
    // $ANTLR end "rule__Variable__Group_2_1__2"


    // $ANTLR start "rule__Variable__Group_2_1__2__Impl"
    // InternalCodetemplatesParser.g:1629:1: rule__Variable__Group_2_1__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1633:1: ( ( ( RULE_WS )* ) )
            // InternalCodetemplatesParser.g:1634:1: ( ( RULE_WS )* )
            {
            // InternalCodetemplatesParser.g:1634:1: ( ( RULE_WS )* )
            // InternalCodetemplatesParser.g:1635:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2()); 
            // InternalCodetemplatesParser.g:1636:1: ( RULE_WS )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_WS) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:1636:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_20); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1__2__Impl"


    // $ANTLR start "rule__Variable__Group_2_1__3"
    // InternalCodetemplatesParser.g:1646:1: rule__Variable__Group_2_1__3 : rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 ;
    public final void rule__Variable__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1650:1: ( rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 )
            // InternalCodetemplatesParser.g:1651:2: rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4
            {
            pushFollow(FOLLOW_23);
            rule__Variable__Group_2_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1__4();

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
    // $ANTLR end "rule__Variable__Group_2_1__3"


    // $ANTLR start "rule__Variable__Group_2_1__3__Impl"
    // InternalCodetemplatesParser.g:1658:1: rule__Variable__Group_2_1__3__Impl : ( ( rule__Variable__TypeAssignment_2_1_3 ) ) ;
    public final void rule__Variable__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1662:1: ( ( ( rule__Variable__TypeAssignment_2_1_3 ) ) )
            // InternalCodetemplatesParser.g:1663:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            {
            // InternalCodetemplatesParser.g:1663:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            // InternalCodetemplatesParser.g:1664:1: ( rule__Variable__TypeAssignment_2_1_3 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_2_1_3()); 
            // InternalCodetemplatesParser.g:1665:1: ( rule__Variable__TypeAssignment_2_1_3 )
            // InternalCodetemplatesParser.g:1665:2: rule__Variable__TypeAssignment_2_1_3
            {
            pushFollow(FOLLOW_2);
            rule__Variable__TypeAssignment_2_1_3();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getTypeAssignment_2_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1__3__Impl"


    // $ANTLR start "rule__Variable__Group_2_1__4"
    // InternalCodetemplatesParser.g:1675:1: rule__Variable__Group_2_1__4 : rule__Variable__Group_2_1__4__Impl ;
    public final void rule__Variable__Group_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1679:1: ( rule__Variable__Group_2_1__4__Impl )
            // InternalCodetemplatesParser.g:1680:2: rule__Variable__Group_2_1__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1__4__Impl();

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
    // $ANTLR end "rule__Variable__Group_2_1__4"


    // $ANTLR start "rule__Variable__Group_2_1__4__Impl"
    // InternalCodetemplatesParser.g:1686:1: rule__Variable__Group_2_1__4__Impl : ( ( rule__Variable__Group_2_1_4__0 )? ) ;
    public final void rule__Variable__Group_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1690:1: ( ( ( rule__Variable__Group_2_1_4__0 )? ) )
            // InternalCodetemplatesParser.g:1691:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            {
            // InternalCodetemplatesParser.g:1691:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            // InternalCodetemplatesParser.g:1692:1: ( rule__Variable__Group_2_1_4__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4()); 
            // InternalCodetemplatesParser.g:1693:1: ( rule__Variable__Group_2_1_4__0 )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalCodetemplatesParser.g:1693:2: rule__Variable__Group_2_1_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Variable__Group_2_1_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableAccess().getGroup_2_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1__4__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_0__0"
    // InternalCodetemplatesParser.g:1713:1: rule__Variable__Group_2_1_0__0 : rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 ;
    public final void rule__Variable__Group_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1717:1: ( rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 )
            // InternalCodetemplatesParser.g:1718:2: rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1
            {
            pushFollow(FOLLOW_24);
            rule__Variable__Group_2_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_0__1();

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
    // $ANTLR end "rule__Variable__Group_2_1_0__0"


    // $ANTLR start "rule__Variable__Group_2_1_0__0__Impl"
    // InternalCodetemplatesParser.g:1725:1: rule__Variable__Group_2_1_0__0__Impl : ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) ;
    public final void rule__Variable__Group_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1729:1: ( ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) )
            // InternalCodetemplatesParser.g:1730:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            {
            // InternalCodetemplatesParser.g:1730:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            // InternalCodetemplatesParser.g:1731:1: ( rule__Variable__NameAssignment_2_1_0_0 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_2_1_0_0()); 
            // InternalCodetemplatesParser.g:1732:1: ( rule__Variable__NameAssignment_2_1_0_0 )
            // InternalCodetemplatesParser.g:1732:2: rule__Variable__NameAssignment_2_1_0_0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__NameAssignment_2_1_0_0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getNameAssignment_2_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_0__0__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_0__1"
    // InternalCodetemplatesParser.g:1742:1: rule__Variable__Group_2_1_0__1 : rule__Variable__Group_2_1_0__1__Impl ;
    public final void rule__Variable__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1746:1: ( rule__Variable__Group_2_1_0__1__Impl )
            // InternalCodetemplatesParser.g:1747:2: rule__Variable__Group_2_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_0__1__Impl();

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
    // $ANTLR end "rule__Variable__Group_2_1_0__1"


    // $ANTLR start "rule__Variable__Group_2_1_0__1__Impl"
    // InternalCodetemplatesParser.g:1753:1: rule__Variable__Group_2_1_0__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1757:1: ( ( ( RULE_WS )* ) )
            // InternalCodetemplatesParser.g:1758:1: ( ( RULE_WS )* )
            {
            // InternalCodetemplatesParser.g:1758:1: ( ( RULE_WS )* )
            // InternalCodetemplatesParser.g:1759:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1()); 
            // InternalCodetemplatesParser.g:1760:1: ( RULE_WS )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_WS) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:1760:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_20); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_0__1__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4__0"
    // InternalCodetemplatesParser.g:1774:1: rule__Variable__Group_2_1_4__0 : rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 ;
    public final void rule__Variable__Group_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1778:1: ( rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 )
            // InternalCodetemplatesParser.g:1779:2: rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1
            {
            pushFollow(FOLLOW_23);
            rule__Variable__Group_2_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4__1();

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
    // $ANTLR end "rule__Variable__Group_2_1_4__0"


    // $ANTLR start "rule__Variable__Group_2_1_4__0__Impl"
    // InternalCodetemplatesParser.g:1786:1: rule__Variable__Group_2_1_4__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1790:1: ( ( ( RULE_WS )* ) )
            // InternalCodetemplatesParser.g:1791:1: ( ( RULE_WS )* )
            {
            // InternalCodetemplatesParser.g:1791:1: ( ( RULE_WS )* )
            // InternalCodetemplatesParser.g:1792:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0()); 
            // InternalCodetemplatesParser.g:1793:1: ( RULE_WS )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_WS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:1793:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_20); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4__0__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4__1"
    // InternalCodetemplatesParser.g:1803:1: rule__Variable__Group_2_1_4__1 : rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 ;
    public final void rule__Variable__Group_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1807:1: ( rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 )
            // InternalCodetemplatesParser.g:1808:2: rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2
            {
            pushFollow(FOLLOW_25);
            rule__Variable__Group_2_1_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4__2();

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
    // $ANTLR end "rule__Variable__Group_2_1_4__1"


    // $ANTLR start "rule__Variable__Group_2_1_4__1__Impl"
    // InternalCodetemplatesParser.g:1815:1: rule__Variable__Group_2_1_4__1__Impl : ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) ) ;
    public final void rule__Variable__Group_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1819:1: ( ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) ) )
            // InternalCodetemplatesParser.g:1820:1: ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) )
            {
            // InternalCodetemplatesParser.g:1820:1: ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) )
            // InternalCodetemplatesParser.g:1821:1: ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 )
            {
             before(grammarAccess.getVariableAccess().getExpectingParametersAssignment_2_1_4_1()); 
            // InternalCodetemplatesParser.g:1822:1: ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 )
            // InternalCodetemplatesParser.g:1822:2: rule__Variable__ExpectingParametersAssignment_2_1_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Variable__ExpectingParametersAssignment_2_1_4_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getExpectingParametersAssignment_2_1_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4__1__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4__2"
    // InternalCodetemplatesParser.g:1832:1: rule__Variable__Group_2_1_4__2 : rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 ;
    public final void rule__Variable__Group_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1836:1: ( rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 )
            // InternalCodetemplatesParser.g:1837:2: rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3
            {
            pushFollow(FOLLOW_25);
            rule__Variable__Group_2_1_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4__3();

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
    // $ANTLR end "rule__Variable__Group_2_1_4__2"


    // $ANTLR start "rule__Variable__Group_2_1_4__2__Impl"
    // InternalCodetemplatesParser.g:1844:1: rule__Variable__Group_2_1_4__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1848:1: ( ( ( RULE_WS )* ) )
            // InternalCodetemplatesParser.g:1849:1: ( ( RULE_WS )* )
            {
            // InternalCodetemplatesParser.g:1849:1: ( ( RULE_WS )* )
            // InternalCodetemplatesParser.g:1850:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2()); 
            // InternalCodetemplatesParser.g:1851:1: ( RULE_WS )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_WS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:1851:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_20); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4__2__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4__3"
    // InternalCodetemplatesParser.g:1861:1: rule__Variable__Group_2_1_4__3 : rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 ;
    public final void rule__Variable__Group_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1865:1: ( rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 )
            // InternalCodetemplatesParser.g:1866:2: rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4
            {
            pushFollow(FOLLOW_25);
            rule__Variable__Group_2_1_4__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4__4();

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
    // $ANTLR end "rule__Variable__Group_2_1_4__3"


    // $ANTLR start "rule__Variable__Group_2_1_4__3__Impl"
    // InternalCodetemplatesParser.g:1873:1: rule__Variable__Group_2_1_4__3__Impl : ( ( rule__Variable__Group_2_1_4_3__0 )? ) ;
    public final void rule__Variable__Group_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1877:1: ( ( ( rule__Variable__Group_2_1_4_3__0 )? ) )
            // InternalCodetemplatesParser.g:1878:1: ( ( rule__Variable__Group_2_1_4_3__0 )? )
            {
            // InternalCodetemplatesParser.g:1878:1: ( ( rule__Variable__Group_2_1_4_3__0 )? )
            // InternalCodetemplatesParser.g:1879:1: ( rule__Variable__Group_2_1_4_3__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4_3()); 
            // InternalCodetemplatesParser.g:1880:1: ( rule__Variable__Group_2_1_4_3__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Templates||LA23_0==For||(LA23_0>=RULE_ID && LA23_0<=RULE_STRING)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalCodetemplatesParser.g:1880:2: rule__Variable__Group_2_1_4_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Variable__Group_2_1_4_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableAccess().getGroup_2_1_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4__3__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4__4"
    // InternalCodetemplatesParser.g:1890:1: rule__Variable__Group_2_1_4__4 : rule__Variable__Group_2_1_4__4__Impl ;
    public final void rule__Variable__Group_2_1_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1894:1: ( rule__Variable__Group_2_1_4__4__Impl )
            // InternalCodetemplatesParser.g:1895:2: rule__Variable__Group_2_1_4__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4__4__Impl();

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
    // $ANTLR end "rule__Variable__Group_2_1_4__4"


    // $ANTLR start "rule__Variable__Group_2_1_4__4__Impl"
    // InternalCodetemplatesParser.g:1901:1: rule__Variable__Group_2_1_4__4__Impl : ( RightParenthesis ) ;
    public final void rule__Variable__Group_2_1_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1905:1: ( ( RightParenthesis ) )
            // InternalCodetemplatesParser.g:1906:1: ( RightParenthesis )
            {
            // InternalCodetemplatesParser.g:1906:1: ( RightParenthesis )
            // InternalCodetemplatesParser.g:1907:1: RightParenthesis
            {
             before(grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_4()); 
            match(input,RightParenthesis,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4__4__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_3__0"
    // InternalCodetemplatesParser.g:1930:1: rule__Variable__Group_2_1_4_3__0 : rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1 ;
    public final void rule__Variable__Group_2_1_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1934:1: ( rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1 )
            // InternalCodetemplatesParser.g:1935:2: rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1
            {
            pushFollow(FOLLOW_26);
            rule__Variable__Group_2_1_4_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4_3__1();

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
    // $ANTLR end "rule__Variable__Group_2_1_4_3__0"


    // $ANTLR start "rule__Variable__Group_2_1_4_3__0__Impl"
    // InternalCodetemplatesParser.g:1942:1: rule__Variable__Group_2_1_4_3__0__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) ) ;
    public final void rule__Variable__Group_2_1_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1946:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) ) )
            // InternalCodetemplatesParser.g:1947:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) )
            {
            // InternalCodetemplatesParser.g:1947:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) )
            // InternalCodetemplatesParser.g:1948:1: ( rule__Variable__ParametersAssignment_2_1_4_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_0()); 
            // InternalCodetemplatesParser.g:1949:1: ( rule__Variable__ParametersAssignment_2_1_4_3_0 )
            // InternalCodetemplatesParser.g:1949:2: rule__Variable__ParametersAssignment_2_1_4_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__ParametersAssignment_2_1_4_3_0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_3__0__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_3__1"
    // InternalCodetemplatesParser.g:1959:1: rule__Variable__Group_2_1_4_3__1 : rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2 ;
    public final void rule__Variable__Group_2_1_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1963:1: ( rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2 )
            // InternalCodetemplatesParser.g:1964:2: rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2
            {
            pushFollow(FOLLOW_26);
            rule__Variable__Group_2_1_4_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4_3__2();

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
    // $ANTLR end "rule__Variable__Group_2_1_4_3__1"


    // $ANTLR start "rule__Variable__Group_2_1_4_3__1__Impl"
    // InternalCodetemplatesParser.g:1971:1: rule__Variable__Group_2_1_4_3__1__Impl : ( ( rule__Variable__Group_2_1_4_3_1__0 )* ) ;
    public final void rule__Variable__Group_2_1_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1975:1: ( ( ( rule__Variable__Group_2_1_4_3_1__0 )* ) )
            // InternalCodetemplatesParser.g:1976:1: ( ( rule__Variable__Group_2_1_4_3_1__0 )* )
            {
            // InternalCodetemplatesParser.g:1976:1: ( ( rule__Variable__Group_2_1_4_3_1__0 )* )
            // InternalCodetemplatesParser.g:1977:1: ( rule__Variable__Group_2_1_4_3_1__0 )*
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4_3_1()); 
            // InternalCodetemplatesParser.g:1978:1: ( rule__Variable__Group_2_1_4_3_1__0 )*
            loop24:
            do {
                int alt24=2;
                alt24 = dfa24.predict(input);
                switch (alt24) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:1978:2: rule__Variable__Group_2_1_4_3_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__Variable__Group_2_1_4_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getGroup_2_1_4_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_3__1__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_3__2"
    // InternalCodetemplatesParser.g:1988:1: rule__Variable__Group_2_1_4_3__2 : rule__Variable__Group_2_1_4_3__2__Impl ;
    public final void rule__Variable__Group_2_1_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:1992:1: ( rule__Variable__Group_2_1_4_3__2__Impl )
            // InternalCodetemplatesParser.g:1993:2: rule__Variable__Group_2_1_4_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4_3__2__Impl();

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
    // $ANTLR end "rule__Variable__Group_2_1_4_3__2"


    // $ANTLR start "rule__Variable__Group_2_1_4_3__2__Impl"
    // InternalCodetemplatesParser.g:1999:1: rule__Variable__Group_2_1_4_3__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2003:1: ( ( ( RULE_WS )* ) )
            // InternalCodetemplatesParser.g:2004:1: ( ( RULE_WS )* )
            {
            // InternalCodetemplatesParser.g:2004:1: ( ( RULE_WS )* )
            // InternalCodetemplatesParser.g:2005:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_2()); 
            // InternalCodetemplatesParser.g:2006:1: ( RULE_WS )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_WS) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:2006:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_20); 

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_3__2__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_3_1__0"
    // InternalCodetemplatesParser.g:2022:1: rule__Variable__Group_2_1_4_3_1__0 : rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1 ;
    public final void rule__Variable__Group_2_1_4_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2026:1: ( rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1 )
            // InternalCodetemplatesParser.g:2027:2: rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1
            {
            pushFollow(FOLLOW_26);
            rule__Variable__Group_2_1_4_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4_3_1__1();

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
    // $ANTLR end "rule__Variable__Group_2_1_4_3_1__0"


    // $ANTLR start "rule__Variable__Group_2_1_4_3_1__0__Impl"
    // InternalCodetemplatesParser.g:2034:1: rule__Variable__Group_2_1_4_3_1__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2038:1: ( ( ( RULE_WS )* ) )
            // InternalCodetemplatesParser.g:2039:1: ( ( RULE_WS )* )
            {
            // InternalCodetemplatesParser.g:2039:1: ( ( RULE_WS )* )
            // InternalCodetemplatesParser.g:2040:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_0()); 
            // InternalCodetemplatesParser.g:2041:1: ( RULE_WS )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_WS) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:2041:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_20); 

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_3_1__0__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_3_1__1"
    // InternalCodetemplatesParser.g:2051:1: rule__Variable__Group_2_1_4_3_1__1 : rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2 ;
    public final void rule__Variable__Group_2_1_4_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2055:1: ( rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2 )
            // InternalCodetemplatesParser.g:2056:2: rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2
            {
            pushFollow(FOLLOW_28);
            rule__Variable__Group_2_1_4_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4_3_1__2();

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
    // $ANTLR end "rule__Variable__Group_2_1_4_3_1__1"


    // $ANTLR start "rule__Variable__Group_2_1_4_3_1__1__Impl"
    // InternalCodetemplatesParser.g:2063:1: rule__Variable__Group_2_1_4_3_1__1__Impl : ( Comma ) ;
    public final void rule__Variable__Group_2_1_4_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2067:1: ( ( Comma ) )
            // InternalCodetemplatesParser.g:2068:1: ( Comma )
            {
            // InternalCodetemplatesParser.g:2068:1: ( Comma )
            // InternalCodetemplatesParser.g:2069:1: Comma
            {
             before(grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_3_1_1()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_3_1__1__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_3_1__2"
    // InternalCodetemplatesParser.g:2082:1: rule__Variable__Group_2_1_4_3_1__2 : rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3 ;
    public final void rule__Variable__Group_2_1_4_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2086:1: ( rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3 )
            // InternalCodetemplatesParser.g:2087:2: rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3
            {
            pushFollow(FOLLOW_28);
            rule__Variable__Group_2_1_4_3_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4_3_1__3();

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
    // $ANTLR end "rule__Variable__Group_2_1_4_3_1__2"


    // $ANTLR start "rule__Variable__Group_2_1_4_3_1__2__Impl"
    // InternalCodetemplatesParser.g:2094:1: rule__Variable__Group_2_1_4_3_1__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2098:1: ( ( ( RULE_WS )* ) )
            // InternalCodetemplatesParser.g:2099:1: ( ( RULE_WS )* )
            {
            // InternalCodetemplatesParser.g:2099:1: ( ( RULE_WS )* )
            // InternalCodetemplatesParser.g:2100:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_2()); 
            // InternalCodetemplatesParser.g:2101:1: ( RULE_WS )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_WS) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:2101:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_20); 

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_3_1__2__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_3_1__3"
    // InternalCodetemplatesParser.g:2111:1: rule__Variable__Group_2_1_4_3_1__3 : rule__Variable__Group_2_1_4_3_1__3__Impl ;
    public final void rule__Variable__Group_2_1_4_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2115:1: ( rule__Variable__Group_2_1_4_3_1__3__Impl )
            // InternalCodetemplatesParser.g:2116:2: rule__Variable__Group_2_1_4_3_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group_2_1_4_3_1__3__Impl();

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
    // $ANTLR end "rule__Variable__Group_2_1_4_3_1__3"


    // $ANTLR start "rule__Variable__Group_2_1_4_3_1__3__Impl"
    // InternalCodetemplatesParser.g:2122:1: rule__Variable__Group_2_1_4_3_1__3__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) ) ;
    public final void rule__Variable__Group_2_1_4_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2126:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) ) )
            // InternalCodetemplatesParser.g:2127:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) )
            {
            // InternalCodetemplatesParser.g:2127:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) )
            // InternalCodetemplatesParser.g:2128:1: ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_1_3()); 
            // InternalCodetemplatesParser.g:2129:1: ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 )
            // InternalCodetemplatesParser.g:2129:2: rule__Variable__ParametersAssignment_2_1_4_3_1_3
            {
            pushFollow(FOLLOW_2);
            rule__Variable__ParametersAssignment_2_1_4_3_1_3();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_3_1__3__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalCodetemplatesParser.g:2147:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2151:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalCodetemplatesParser.g:2152:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalCodetemplatesParser.g:2159:1: rule__FQN__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2163:1: ( ( ruleValidID ) )
            // InternalCodetemplatesParser.g:2164:1: ( ruleValidID )
            {
            // InternalCodetemplatesParser.g:2164:1: ( ruleValidID )
            // InternalCodetemplatesParser.g:2165:1: ruleValidID
            {
             before(grammarAccess.getFQNAccess().getValidIDParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getFQNAccess().getValidIDParserRuleCall_0()); 

            }


            }

        }
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
    // InternalCodetemplatesParser.g:2176:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2180:1: ( rule__FQN__Group__1__Impl )
            // InternalCodetemplatesParser.g:2181:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalCodetemplatesParser.g:2187:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2191:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalCodetemplatesParser.g:2192:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalCodetemplatesParser.g:2192:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalCodetemplatesParser.g:2193:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalCodetemplatesParser.g:2194:1: ( rule__FQN__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==FullStop) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:2194:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalCodetemplatesParser.g:2208:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2212:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalCodetemplatesParser.g:2213:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalCodetemplatesParser.g:2220:1: rule__FQN__Group_1__0__Impl : ( FullStop ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2224:1: ( ( FullStop ) )
            // InternalCodetemplatesParser.g:2225:1: ( FullStop )
            {
            // InternalCodetemplatesParser.g:2225:1: ( FullStop )
            // InternalCodetemplatesParser.g:2226:1: FullStop
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,FullStop,FOLLOW_2); 
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
    // InternalCodetemplatesParser.g:2239:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2243:1: ( rule__FQN__Group_1__1__Impl )
            // InternalCodetemplatesParser.g:2244:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalCodetemplatesParser.g:2250:1: rule__FQN__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2254:1: ( ( ruleValidID ) )
            // InternalCodetemplatesParser.g:2255:1: ( ruleValidID )
            {
            // InternalCodetemplatesParser.g:2255:1: ( ruleValidID )
            // InternalCodetemplatesParser.g:2256:1: ruleValidID
            {
             before(grammarAccess.getFQNAccess().getValidIDParserRuleCall_1_1()); 
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getFQNAccess().getValidIDParserRuleCall_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Dollar__Group__0"
    // InternalCodetemplatesParser.g:2271:1: rule__Dollar__Group__0 : rule__Dollar__Group__0__Impl rule__Dollar__Group__1 ;
    public final void rule__Dollar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2275:1: ( rule__Dollar__Group__0__Impl rule__Dollar__Group__1 )
            // InternalCodetemplatesParser.g:2276:2: rule__Dollar__Group__0__Impl rule__Dollar__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__Dollar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Dollar__Group__1();

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
    // $ANTLR end "rule__Dollar__Group__0"


    // $ANTLR start "rule__Dollar__Group__0__Impl"
    // InternalCodetemplatesParser.g:2283:1: rule__Dollar__Group__0__Impl : ( () ) ;
    public final void rule__Dollar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2287:1: ( ( () ) )
            // InternalCodetemplatesParser.g:2288:1: ( () )
            {
            // InternalCodetemplatesParser.g:2288:1: ( () )
            // InternalCodetemplatesParser.g:2289:1: ()
            {
             before(grammarAccess.getDollarAccess().getDollarAction_0()); 
            // InternalCodetemplatesParser.g:2290:1: ()
            // InternalCodetemplatesParser.g:2292:1: 
            {
            }

             after(grammarAccess.getDollarAccess().getDollarAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dollar__Group__0__Impl"


    // $ANTLR start "rule__Dollar__Group__1"
    // InternalCodetemplatesParser.g:2302:1: rule__Dollar__Group__1 : rule__Dollar__Group__1__Impl ;
    public final void rule__Dollar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2306:1: ( rule__Dollar__Group__1__Impl )
            // InternalCodetemplatesParser.g:2307:2: rule__Dollar__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Dollar__Group__1__Impl();

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
    // $ANTLR end "rule__Dollar__Group__1"


    // $ANTLR start "rule__Dollar__Group__1__Impl"
    // InternalCodetemplatesParser.g:2313:1: rule__Dollar__Group__1__Impl : ( ( rule__Dollar__Alternatives_1 ) ) ;
    public final void rule__Dollar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2317:1: ( ( ( rule__Dollar__Alternatives_1 ) ) )
            // InternalCodetemplatesParser.g:2318:1: ( ( rule__Dollar__Alternatives_1 ) )
            {
            // InternalCodetemplatesParser.g:2318:1: ( ( rule__Dollar__Alternatives_1 ) )
            // InternalCodetemplatesParser.g:2319:1: ( rule__Dollar__Alternatives_1 )
            {
             before(grammarAccess.getDollarAccess().getAlternatives_1()); 
            // InternalCodetemplatesParser.g:2320:1: ( rule__Dollar__Alternatives_1 )
            // InternalCodetemplatesParser.g:2320:2: rule__Dollar__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__Dollar__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getDollarAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dollar__Group__1__Impl"


    // $ANTLR start "rule__Codetemplates__LanguageAssignment_2"
    // InternalCodetemplatesParser.g:2335:1: rule__Codetemplates__LanguageAssignment_2 : ( ( ruleFQN ) ) ;
    public final void rule__Codetemplates__LanguageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2339:1: ( ( ( ruleFQN ) ) )
            // InternalCodetemplatesParser.g:2340:1: ( ( ruleFQN ) )
            {
            // InternalCodetemplatesParser.g:2340:1: ( ( ruleFQN ) )
            // InternalCodetemplatesParser.g:2341:1: ( ruleFQN )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0()); 
            // InternalCodetemplatesParser.g:2342:1: ( ruleFQN )
            // InternalCodetemplatesParser.g:2343:1: ruleFQN
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageGrammarFQNParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getCodetemplatesAccess().getLanguageGrammarFQNParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplates__LanguageAssignment_2"


    // $ANTLR start "rule__Codetemplates__TemplatesAssignment_4"
    // InternalCodetemplatesParser.g:2354:1: rule__Codetemplates__TemplatesAssignment_4 : ( ruleCodetemplate ) ;
    public final void rule__Codetemplates__TemplatesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2358:1: ( ( ruleCodetemplate ) )
            // InternalCodetemplatesParser.g:2359:1: ( ruleCodetemplate )
            {
            // InternalCodetemplatesParser.g:2359:1: ( ruleCodetemplate )
            // InternalCodetemplatesParser.g:2360:1: ruleCodetemplate
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleCodetemplate();

            state._fsp--;

             after(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplates__TemplatesAssignment_4"


    // $ANTLR start "rule__Codetemplate__NameAssignment_0"
    // InternalCodetemplatesParser.g:2369:1: rule__Codetemplate__NameAssignment_0 : ( ruleValidID ) ;
    public final void rule__Codetemplate__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2373:1: ( ( ruleValidID ) )
            // InternalCodetemplatesParser.g:2374:1: ( ruleValidID )
            {
            // InternalCodetemplatesParser.g:2374:1: ( ruleValidID )
            // InternalCodetemplatesParser.g:2375:1: ruleValidID
            {
             before(grammarAccess.getCodetemplateAccess().getNameValidIDParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getCodetemplateAccess().getNameValidIDParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__NameAssignment_0"


    // $ANTLR start "rule__Codetemplate__IdAssignment_2"
    // InternalCodetemplatesParser.g:2384:1: rule__Codetemplate__IdAssignment_2 : ( RULE_ID ) ;
    public final void rule__Codetemplate__IdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2388:1: ( ( RULE_ID ) )
            // InternalCodetemplatesParser.g:2389:1: ( RULE_ID )
            {
            // InternalCodetemplatesParser.g:2389:1: ( RULE_ID )
            // InternalCodetemplatesParser.g:2390:1: RULE_ID
            {
             before(grammarAccess.getCodetemplateAccess().getIdIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCodetemplateAccess().getIdIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__IdAssignment_2"


    // $ANTLR start "rule__Codetemplate__DescriptionAssignment_4"
    // InternalCodetemplatesParser.g:2399:1: rule__Codetemplate__DescriptionAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__DescriptionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2403:1: ( ( RULE_STRING ) )
            // InternalCodetemplatesParser.g:2404:1: ( RULE_STRING )
            {
            // InternalCodetemplatesParser.g:2404:1: ( RULE_STRING )
            // InternalCodetemplatesParser.g:2405:1: RULE_STRING
            {
             before(grammarAccess.getCodetemplateAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getCodetemplateAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__DescriptionAssignment_4"


    // $ANTLR start "rule__Codetemplate__ContextAssignment_7_0"
    // InternalCodetemplatesParser.g:2414:1: rule__Codetemplate__ContextAssignment_7_0 : ( ( ruleValidID ) ) ;
    public final void rule__Codetemplate__ContextAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2418:1: ( ( ( ruleValidID ) ) )
            // InternalCodetemplatesParser.g:2419:1: ( ( ruleValidID ) )
            {
            // InternalCodetemplatesParser.g:2419:1: ( ( ruleValidID ) )
            // InternalCodetemplatesParser.g:2420:1: ( ruleValidID )
            {
             before(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_7_0_0()); 
            // InternalCodetemplatesParser.g:2421:1: ( ruleValidID )
            // InternalCodetemplatesParser.g:2422:1: ruleValidID
            {
             before(grammarAccess.getCodetemplateAccess().getContextAbstractRuleValidIDParserRuleCall_7_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getCodetemplateAccess().getContextAbstractRuleValidIDParserRuleCall_7_0_0_1()); 

            }

             after(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_7_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__ContextAssignment_7_0"


    // $ANTLR start "rule__Codetemplate__KeywordContextAssignment_7_1"
    // InternalCodetemplatesParser.g:2433:1: rule__Codetemplate__KeywordContextAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__KeywordContextAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2437:1: ( ( RULE_STRING ) )
            // InternalCodetemplatesParser.g:2438:1: ( RULE_STRING )
            {
            // InternalCodetemplatesParser.g:2438:1: ( RULE_STRING )
            // InternalCodetemplatesParser.g:2439:1: RULE_STRING
            {
             before(grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_7_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__KeywordContextAssignment_7_1"


    // $ANTLR start "rule__Codetemplate__BodyAssignment_8"
    // InternalCodetemplatesParser.g:2448:1: rule__Codetemplate__BodyAssignment_8 : ( ruleTemplateBodyWithQuotes ) ;
    public final void rule__Codetemplate__BodyAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2452:1: ( ( ruleTemplateBodyWithQuotes ) )
            // InternalCodetemplatesParser.g:2453:1: ( ruleTemplateBodyWithQuotes )
            {
            // InternalCodetemplatesParser.g:2453:1: ( ruleTemplateBodyWithQuotes )
            // InternalCodetemplatesParser.g:2454:1: ruleTemplateBodyWithQuotes
            {
             before(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleTemplateBodyWithQuotes();

            state._fsp--;

             after(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__BodyAssignment_8"


    // $ANTLR start "rule__TemplateBody__PartsAssignment_1"
    // InternalCodetemplatesParser.g:2463:1: rule__TemplateBody__PartsAssignment_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2467:1: ( ( ruleLiteral ) )
            // InternalCodetemplatesParser.g:2468:1: ( ruleLiteral )
            {
            // InternalCodetemplatesParser.g:2468:1: ( ruleLiteral )
            // InternalCodetemplatesParser.g:2469:1: ruleLiteral
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBody__PartsAssignment_1"


    // $ANTLR start "rule__TemplateBody__PartsAssignment_2_0"
    // InternalCodetemplatesParser.g:2478:1: rule__TemplateBody__PartsAssignment_2_0 : ( ruleVariableOrDollar ) ;
    public final void rule__TemplateBody__PartsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2482:1: ( ( ruleVariableOrDollar ) )
            // InternalCodetemplatesParser.g:2483:1: ( ruleVariableOrDollar )
            {
            // InternalCodetemplatesParser.g:2483:1: ( ruleVariableOrDollar )
            // InternalCodetemplatesParser.g:2484:1: ruleVariableOrDollar
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsVariableOrDollarParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleVariableOrDollar();

            state._fsp--;

             after(grammarAccess.getTemplateBodyAccess().getPartsVariableOrDollarParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBody__PartsAssignment_2_0"


    // $ANTLR start "rule__TemplateBody__PartsAssignment_2_1"
    // InternalCodetemplatesParser.g:2493:1: rule__TemplateBody__PartsAssignment_2_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2497:1: ( ( ruleLiteral ) )
            // InternalCodetemplatesParser.g:2498:1: ( ruleLiteral )
            {
            // InternalCodetemplatesParser.g:2498:1: ( ruleLiteral )
            // InternalCodetemplatesParser.g:2499:1: ruleLiteral
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBody__PartsAssignment_2_1"


    // $ANTLR start "rule__Variable__NameAssignment_2_0"
    // InternalCodetemplatesParser.g:2508:1: rule__Variable__NameAssignment_2_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2512:1: ( ( ruleValidID ) )
            // InternalCodetemplatesParser.g:2513:1: ( ruleValidID )
            {
            // InternalCodetemplatesParser.g:2513:1: ( ruleValidID )
            // InternalCodetemplatesParser.g:2514:1: ruleValidID
            {
             before(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__NameAssignment_2_0"


    // $ANTLR start "rule__Variable__NameAssignment_2_1_0_0"
    // InternalCodetemplatesParser.g:2523:1: rule__Variable__NameAssignment_2_1_0_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2527:1: ( ( ruleValidID ) )
            // InternalCodetemplatesParser.g:2528:1: ( ruleValidID )
            {
            // InternalCodetemplatesParser.g:2528:1: ( ruleValidID )
            // InternalCodetemplatesParser.g:2529:1: ruleValidID
            {
             before(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_1_0_0_0()); 
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_1_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__NameAssignment_2_1_0_0"


    // $ANTLR start "rule__Variable__TypeAssignment_2_1_3"
    // InternalCodetemplatesParser.g:2538:1: rule__Variable__TypeAssignment_2_1_3 : ( ruleValidID ) ;
    public final void rule__Variable__TypeAssignment_2_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2542:1: ( ( ruleValidID ) )
            // InternalCodetemplatesParser.g:2543:1: ( ruleValidID )
            {
            // InternalCodetemplatesParser.g:2543:1: ( ruleValidID )
            // InternalCodetemplatesParser.g:2544:1: ruleValidID
            {
             before(grammarAccess.getVariableAccess().getTypeValidIDParserRuleCall_2_1_3_0()); 
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getVariableAccess().getTypeValidIDParserRuleCall_2_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__TypeAssignment_2_1_3"


    // $ANTLR start "rule__Variable__ExpectingParametersAssignment_2_1_4_1"
    // InternalCodetemplatesParser.g:2553:1: rule__Variable__ExpectingParametersAssignment_2_1_4_1 : ( ( LeftParenthesis ) ) ;
    public final void rule__Variable__ExpectingParametersAssignment_2_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2557:1: ( ( ( LeftParenthesis ) ) )
            // InternalCodetemplatesParser.g:2558:1: ( ( LeftParenthesis ) )
            {
            // InternalCodetemplatesParser.g:2558:1: ( ( LeftParenthesis ) )
            // InternalCodetemplatesParser.g:2559:1: ( LeftParenthesis )
            {
             before(grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0()); 
            // InternalCodetemplatesParser.g:2560:1: ( LeftParenthesis )
            // InternalCodetemplatesParser.g:2561:1: LeftParenthesis
            {
             before(grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0()); 
            match(input,LeftParenthesis,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0()); 

            }

             after(grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__ExpectingParametersAssignment_2_1_4_1"


    // $ANTLR start "rule__Variable__ParametersAssignment_2_1_4_3_0"
    // InternalCodetemplatesParser.g:2576:1: rule__Variable__ParametersAssignment_2_1_4_3_0 : ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2580:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) ) )
            // InternalCodetemplatesParser.g:2581:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) )
            {
            // InternalCodetemplatesParser.g:2581:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) )
            // InternalCodetemplatesParser.g:2582:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_0_0()); 
            // InternalCodetemplatesParser.g:2583:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 )
            // InternalCodetemplatesParser.g:2583:2: rule__Variable__ParametersAlternatives_2_1_4_3_0_0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__ParametersAlternatives_2_1_4_3_0_0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__ParametersAssignment_2_1_4_3_0"


    // $ANTLR start "rule__Variable__ParametersAssignment_2_1_4_3_1_3"
    // InternalCodetemplatesParser.g:2592:1: rule__Variable__ParametersAssignment_2_1_4_3_1_3 : ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_3_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2596:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) ) )
            // InternalCodetemplatesParser.g:2597:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) )
            {
            // InternalCodetemplatesParser.g:2597:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) )
            // InternalCodetemplatesParser.g:2598:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_1_3_0()); 
            // InternalCodetemplatesParser.g:2599:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 )
            // InternalCodetemplatesParser.g:2599:2: rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__ParametersAssignment_2_1_4_3_1_3"


    // $ANTLR start "rule__Literal__ValueAssignment"
    // InternalCodetemplatesParser.g:2608:1: rule__Literal__ValueAssignment : ( ruleLiteralValue ) ;
    public final void rule__Literal__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2612:1: ( ( ruleLiteralValue ) )
            // InternalCodetemplatesParser.g:2613:1: ( ruleLiteralValue )
            {
            // InternalCodetemplatesParser.g:2613:1: ( ruleLiteralValue )
            // InternalCodetemplatesParser.g:2614:1: ruleLiteralValue
            {
             before(grammarAccess.getLiteralAccess().getValueLiteralValueParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleLiteralValue();

            state._fsp--;

             after(grammarAccess.getLiteralAccess().getValueLiteralValueParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__ValueAssignment"


    // $ANTLR start "rule__Dollar__EscapedAssignment_1_0"
    // InternalCodetemplatesParser.g:2623:1: rule__Dollar__EscapedAssignment_1_0 : ( ( DollarSignDollarSign ) ) ;
    public final void rule__Dollar__EscapedAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCodetemplatesParser.g:2627:1: ( ( ( DollarSignDollarSign ) ) )
            // InternalCodetemplatesParser.g:2628:1: ( ( DollarSignDollarSign ) )
            {
            // InternalCodetemplatesParser.g:2628:1: ( ( DollarSignDollarSign ) )
            // InternalCodetemplatesParser.g:2629:1: ( DollarSignDollarSign )
            {
             before(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 
            // InternalCodetemplatesParser.g:2630:1: ( DollarSignDollarSign )
            // InternalCodetemplatesParser.g:2631:1: DollarSignDollarSign
            {
             before(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 
            match(input,DollarSignDollarSign,FOLLOW_2); 
             after(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 

            }

             after(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dollar__EscapedAssignment_1_0"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA4_eotS =
        "\7\uffff";
    static final String DFA4_eofS =
        "\7\uffff";
    static final String DFA4_minS =
        "\1\4\3\20\1\uffff\1\20\1\uffff";
    static final String DFA4_maxS =
        "\1\22\3\24\1\uffff\1\24\1\uffff";
    static final String DFA4_acceptS =
        "\4\uffff\1\2\1\uffff\1\1";
    static final String DFA4_specialS =
        "\7\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\3\1\uffff\1\2\11\uffff\1\4\1\uffff\1\1",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "",
            "\1\4\1\6\2\uffff\1\5",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "511:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );";
        }
    }
    static final String DFA19_eotS =
        "\4\uffff";
    static final String DFA19_eofS =
        "\4\uffff";
    static final String DFA19_minS =
        "\2\14\2\uffff";
    static final String DFA19_maxS =
        "\2\24\2\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA19_specialS =
        "\4\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1693:1: ( rule__Variable__Group_2_1_4__0 )?";
        }
    }
    static final String DFA24_eotS =
        "\4\uffff";
    static final String DFA24_eofS =
        "\4\uffff";
    static final String DFA24_minS =
        "\2\15\2\uffff";
    static final String DFA24_maxS =
        "\2\24\2\uffff";
    static final String DFA24_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA24_specialS =
        "\4\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\2\1\3\5\uffff\1\1",
            "\1\2\1\3\5\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "()* loopback of 1978:1: ( rule__Variable__Group_2_1_4_3_1__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000040050L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040052L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000000C0050L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000000003409A0L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000982L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000340020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000150050L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000140050L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000101000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000000001C2050L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000104002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000980L});

}
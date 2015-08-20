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
import org.eclipse.xtext.ui.codetemplates.services.SingleCodetemplateGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSingleCodetemplateParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Templates", "For", "DollarSignDollarSign", "DollarSignLeftCurlyBracket", "GreaterThanSignGreaterThanSign", "DollarSign", "LeftParenthesis", "RightParenthesis", "Comma", "FullStop", "Colon", "RightCurlyBracket", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=16;
    public static final int DollarSign=9;
    public static final int RightParenthesis=11;
    public static final int RULE_ANY_OTHER=19;
    public static final int LeftParenthesis=10;
    public static final int Colon=14;
    public static final int EOF=-1;
    public static final int For=5;
    public static final int FullStop=13;
    public static final int DollarSignLeftCurlyBracket=7;
    public static final int RULE_STRING=17;
    public static final int DollarSignDollarSign=6;
    public static final int Templates=4;
    public static final int RULE_WS=18;
    public static final int Comma=12;
    public static final int GreaterThanSignGreaterThanSign=8;
    public static final int RightCurlyBracket=15;

    // delegates
    // delegators


        public InternalSingleCodetemplateParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSingleCodetemplateParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSingleCodetemplateParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSingleCodetemplateParser.g"; }


     
     	private SingleCodetemplateGrammarAccess grammarAccess;
     	
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
    		tokenNameToValue.put("GreaterThanSignGreaterThanSign", "'>>'");
    		tokenNameToValue.put("For", "'for'");
    		tokenNameToValue.put("Templates", "'templates'");
     	}
     	
        public void setGrammarAccess(SingleCodetemplateGrammarAccess grammarAccess) {
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
    // InternalSingleCodetemplateParser.g:75:1: entryRuleCodetemplates : ruleCodetemplates EOF ;
    public final void entryRuleCodetemplates() throws RecognitionException {
        try {
            // InternalSingleCodetemplateParser.g:76:1: ( ruleCodetemplates EOF )
            // InternalSingleCodetemplateParser.g:77:1: ruleCodetemplates EOF
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
    // InternalSingleCodetemplateParser.g:84:1: ruleCodetemplates : ( ( rule__Codetemplates__Group__0 ) ) ;
    public final void ruleCodetemplates() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:88:5: ( ( ( rule__Codetemplates__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:89:1: ( ( rule__Codetemplates__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:89:1: ( ( rule__Codetemplates__Group__0 ) )
            // InternalSingleCodetemplateParser.g:90:1: ( rule__Codetemplates__Group__0 )
            {
             before(grammarAccess.getCodetemplatesAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:91:1: ( rule__Codetemplates__Group__0 )
            // InternalSingleCodetemplateParser.g:91:2: rule__Codetemplates__Group__0
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
    // InternalSingleCodetemplateParser.g:103:1: entryRuleCodetemplate : ruleCodetemplate EOF ;
    public final void entryRuleCodetemplate() throws RecognitionException {
        try {
            // InternalSingleCodetemplateParser.g:104:1: ( ruleCodetemplate EOF )
            // InternalSingleCodetemplateParser.g:105:1: ruleCodetemplate EOF
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
    // InternalSingleCodetemplateParser.g:112:1: ruleCodetemplate : ( ( rule__Codetemplate__Group__0 ) ) ;
    public final void ruleCodetemplate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:116:5: ( ( ( rule__Codetemplate__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:117:1: ( ( rule__Codetemplate__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:117:1: ( ( rule__Codetemplate__Group__0 ) )
            // InternalSingleCodetemplateParser.g:118:1: ( rule__Codetemplate__Group__0 )
            {
             before(grammarAccess.getCodetemplateAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:119:1: ( rule__Codetemplate__Group__0 )
            // InternalSingleCodetemplateParser.g:119:2: rule__Codetemplate__Group__0
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
    // InternalSingleCodetemplateParser.g:131:1: entryRuleTemplateBodyWithQuotes : ruleTemplateBodyWithQuotes EOF ;
    public final void entryRuleTemplateBodyWithQuotes() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:135:1: ( ruleTemplateBodyWithQuotes EOF )
            // InternalSingleCodetemplateParser.g:136:1: ruleTemplateBodyWithQuotes EOF
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
    // InternalSingleCodetemplateParser.g:146:1: ruleTemplateBodyWithQuotes : ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) ;
    public final void ruleTemplateBodyWithQuotes() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:151:5: ( ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:152:1: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:152:1: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            // InternalSingleCodetemplateParser.g:153:1: ( rule__TemplateBodyWithQuotes__Group__0 )
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:154:1: ( rule__TemplateBodyWithQuotes__Group__0 )
            // InternalSingleCodetemplateParser.g:154:2: rule__TemplateBodyWithQuotes__Group__0
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


    // $ANTLR start "entryRuleLiteralValue"
    // InternalSingleCodetemplateParser.g:167:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:171:1: ( ruleLiteralValue EOF )
            // InternalSingleCodetemplateParser.g:172:1: ruleLiteralValue EOF
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
    // InternalSingleCodetemplateParser.g:182:1: ruleLiteralValue : ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) ;
    public final void ruleLiteralValue() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:187:5: ( ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) )
            // InternalSingleCodetemplateParser.g:188:1: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            {
            // InternalSingleCodetemplateParser.g:188:1: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            // InternalSingleCodetemplateParser.g:189:1: ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* )
            {
            // InternalSingleCodetemplateParser.g:189:1: ( ( rule__LiteralValue__Alternatives ) )
            // InternalSingleCodetemplateParser.g:190:1: ( rule__LiteralValue__Alternatives )
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:191:1: ( rule__LiteralValue__Alternatives )
            // InternalSingleCodetemplateParser.g:191:2: rule__LiteralValue__Alternatives
            {
            pushFollow(FOLLOW_3);
            rule__LiteralValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralValueAccess().getAlternatives()); 

            }

            // InternalSingleCodetemplateParser.g:194:1: ( ( rule__LiteralValue__Alternatives )* )
            // InternalSingleCodetemplateParser.g:195:1: ( rule__LiteralValue__Alternatives )*
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:196:1: ( rule__LiteralValue__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=RULE_WS && LA1_0<=RULE_ANY_OTHER)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:196:2: rule__LiteralValue__Alternatives
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


    // $ANTLR start "entryRuleTemplateBody"
    // InternalSingleCodetemplateParser.g:210:1: entryRuleTemplateBody : ruleTemplateBody EOF ;
    public final void entryRuleTemplateBody() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:214:1: ( ruleTemplateBody EOF )
            // InternalSingleCodetemplateParser.g:215:1: ruleTemplateBody EOF
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
    // InternalSingleCodetemplateParser.g:225:1: ruleTemplateBody : ( ( rule__TemplateBody__Group__0 ) ) ;
    public final void ruleTemplateBody() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:230:5: ( ( ( rule__TemplateBody__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:231:1: ( ( rule__TemplateBody__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:231:1: ( ( rule__TemplateBody__Group__0 ) )
            // InternalSingleCodetemplateParser.g:232:1: ( rule__TemplateBody__Group__0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:233:1: ( rule__TemplateBody__Group__0 )
            // InternalSingleCodetemplateParser.g:233:2: rule__TemplateBody__Group__0
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
    // InternalSingleCodetemplateParser.g:248:1: entryRuleVariableOrDollar : ruleVariableOrDollar EOF ;
    public final void entryRuleVariableOrDollar() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:252:1: ( ruleVariableOrDollar EOF )
            // InternalSingleCodetemplateParser.g:253:1: ruleVariableOrDollar EOF
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
    // InternalSingleCodetemplateParser.g:263:1: ruleVariableOrDollar : ( ( rule__VariableOrDollar__Alternatives ) ) ;
    public final void ruleVariableOrDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:268:5: ( ( ( rule__VariableOrDollar__Alternatives ) ) )
            // InternalSingleCodetemplateParser.g:269:1: ( ( rule__VariableOrDollar__Alternatives ) )
            {
            // InternalSingleCodetemplateParser.g:269:1: ( ( rule__VariableOrDollar__Alternatives ) )
            // InternalSingleCodetemplateParser.g:270:1: ( rule__VariableOrDollar__Alternatives )
            {
             before(grammarAccess.getVariableOrDollarAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:271:1: ( rule__VariableOrDollar__Alternatives )
            // InternalSingleCodetemplateParser.g:271:2: rule__VariableOrDollar__Alternatives
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
    // InternalSingleCodetemplateParser.g:284:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:288:1: ( ruleVariable EOF )
            // InternalSingleCodetemplateParser.g:289:1: ruleVariable EOF
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
    // InternalSingleCodetemplateParser.g:299:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:304:5: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:305:1: ( ( rule__Variable__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:305:1: ( ( rule__Variable__Group__0 ) )
            // InternalSingleCodetemplateParser.g:306:1: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:307:1: ( rule__Variable__Group__0 )
            // InternalSingleCodetemplateParser.g:307:2: rule__Variable__Group__0
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
    // InternalSingleCodetemplateParser.g:320:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:324:1: ( ruleValidID EOF )
            // InternalSingleCodetemplateParser.g:325:1: ruleValidID EOF
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
    // InternalSingleCodetemplateParser.g:335:1: ruleValidID : ( ( rule__ValidID__Alternatives ) ) ;
    public final void ruleValidID() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:340:5: ( ( ( rule__ValidID__Alternatives ) ) )
            // InternalSingleCodetemplateParser.g:341:1: ( ( rule__ValidID__Alternatives ) )
            {
            // InternalSingleCodetemplateParser.g:341:1: ( ( rule__ValidID__Alternatives ) )
            // InternalSingleCodetemplateParser.g:342:1: ( rule__ValidID__Alternatives )
            {
             before(grammarAccess.getValidIDAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:343:1: ( rule__ValidID__Alternatives )
            // InternalSingleCodetemplateParser.g:343:2: rule__ValidID__Alternatives
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
    // InternalSingleCodetemplateParser.g:356:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:360:1: ( ruleFQN EOF )
            // InternalSingleCodetemplateParser.g:361:1: ruleFQN EOF
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
    // InternalSingleCodetemplateParser.g:371:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:376:5: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:377:1: ( ( rule__FQN__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:377:1: ( ( rule__FQN__Group__0 ) )
            // InternalSingleCodetemplateParser.g:378:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:379:1: ( rule__FQN__Group__0 )
            // InternalSingleCodetemplateParser.g:379:2: rule__FQN__Group__0
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
    // InternalSingleCodetemplateParser.g:392:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:396:1: ( ruleLiteral EOF )
            // InternalSingleCodetemplateParser.g:397:1: ruleLiteral EOF
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
    // InternalSingleCodetemplateParser.g:407:1: ruleLiteral : ( ( rule__Literal__ValueAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:412:5: ( ( ( rule__Literal__ValueAssignment ) ) )
            // InternalSingleCodetemplateParser.g:413:1: ( ( rule__Literal__ValueAssignment ) )
            {
            // InternalSingleCodetemplateParser.g:413:1: ( ( rule__Literal__ValueAssignment ) )
            // InternalSingleCodetemplateParser.g:414:1: ( rule__Literal__ValueAssignment )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment()); 
            // InternalSingleCodetemplateParser.g:415:1: ( rule__Literal__ValueAssignment )
            // InternalSingleCodetemplateParser.g:415:2: rule__Literal__ValueAssignment
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


    // $ANTLR start "entryRuleDollar"
    // InternalSingleCodetemplateParser.g:428:1: entryRuleDollar : ruleDollar EOF ;
    public final void entryRuleDollar() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:432:1: ( ruleDollar EOF )
            // InternalSingleCodetemplateParser.g:433:1: ruleDollar EOF
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
    // InternalSingleCodetemplateParser.g:443:1: ruleDollar : ( ( rule__Dollar__Group__0 ) ) ;
    public final void ruleDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:448:5: ( ( ( rule__Dollar__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:449:1: ( ( rule__Dollar__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:449:1: ( ( rule__Dollar__Group__0 ) )
            // InternalSingleCodetemplateParser.g:450:1: ( rule__Dollar__Group__0 )
            {
             before(grammarAccess.getDollarAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:451:1: ( rule__Dollar__Group__0 )
            // InternalSingleCodetemplateParser.g:451:2: rule__Dollar__Group__0
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


    // $ANTLR start "rule__Codetemplate__Alternatives_2"
    // InternalSingleCodetemplateParser.g:464:1: rule__Codetemplate__Alternatives_2 : ( ( ( rule__Codetemplate__ContextAssignment_2_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) ) );
    public final void rule__Codetemplate__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:468:1: ( ( ( rule__Codetemplate__ContextAssignment_2_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=Templates && LA2_0<=For)||LA2_0==RULE_ID) ) {
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
                    // InternalSingleCodetemplateParser.g:469:1: ( ( rule__Codetemplate__ContextAssignment_2_0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:469:1: ( ( rule__Codetemplate__ContextAssignment_2_0 ) )
                    // InternalSingleCodetemplateParser.g:470:1: ( rule__Codetemplate__ContextAssignment_2_0 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getContextAssignment_2_0()); 
                    // InternalSingleCodetemplateParser.g:471:1: ( rule__Codetemplate__ContextAssignment_2_0 )
                    // InternalSingleCodetemplateParser.g:471:2: rule__Codetemplate__ContextAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Codetemplate__ContextAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCodetemplateAccess().getContextAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:475:6: ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) )
                    {
                    // InternalSingleCodetemplateParser.g:475:6: ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) )
                    // InternalSingleCodetemplateParser.g:476:1: ( rule__Codetemplate__KeywordContextAssignment_2_1 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getKeywordContextAssignment_2_1()); 
                    // InternalSingleCodetemplateParser.g:477:1: ( rule__Codetemplate__KeywordContextAssignment_2_1 )
                    // InternalSingleCodetemplateParser.g:477:2: rule__Codetemplate__KeywordContextAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Codetemplate__KeywordContextAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getCodetemplateAccess().getKeywordContextAssignment_2_1()); 

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
    // $ANTLR end "rule__Codetemplate__Alternatives_2"


    // $ANTLR start "rule__LiteralValue__Alternatives"
    // InternalSingleCodetemplateParser.g:486:1: rule__LiteralValue__Alternatives : ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) );
    public final void rule__LiteralValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:490:1: ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_WS:
                {
                alt3=1;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt3=2;
                }
                break;
            case RULE_ID:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:491:1: ( RULE_WS )
                    {
                    // InternalSingleCodetemplateParser.g:491:1: ( RULE_WS )
                    // InternalSingleCodetemplateParser.g:492:1: RULE_WS
                    {
                     before(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 
                    match(input,RULE_WS,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:497:6: ( RULE_ANY_OTHER )
                    {
                    // InternalSingleCodetemplateParser.g:497:6: ( RULE_ANY_OTHER )
                    // InternalSingleCodetemplateParser.g:498:1: RULE_ANY_OTHER
                    {
                     before(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 
                    match(input,RULE_ANY_OTHER,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSingleCodetemplateParser.g:503:6: ( RULE_ID )
                    {
                    // InternalSingleCodetemplateParser.g:503:6: ( RULE_ID )
                    // InternalSingleCodetemplateParser.g:504:1: RULE_ID
                    {
                     before(grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2()); 

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


    // $ANTLR start "rule__VariableOrDollar__Alternatives"
    // InternalSingleCodetemplateParser.g:515:1: rule__VariableOrDollar__Alternatives : ( ( ruleVariable ) | ( ruleDollar ) );
    public final void rule__VariableOrDollar__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:519:1: ( ( ruleVariable ) | ( ruleDollar ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DollarSignLeftCurlyBracket) ) {
                alt4=1;
            }
            else if ( (LA4_0==DollarSignDollarSign||LA4_0==DollarSign) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:520:1: ( ruleVariable )
                    {
                    // InternalSingleCodetemplateParser.g:520:1: ( ruleVariable )
                    // InternalSingleCodetemplateParser.g:521:1: ruleVariable
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
                    // InternalSingleCodetemplateParser.g:526:6: ( ruleDollar )
                    {
                    // InternalSingleCodetemplateParser.g:526:6: ( ruleDollar )
                    // InternalSingleCodetemplateParser.g:527:1: ruleDollar
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
    // InternalSingleCodetemplateParser.g:537:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );
    public final void rule__Variable__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:541:1: ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:542:1: ( ( rule__Variable__NameAssignment_2_0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:542:1: ( ( rule__Variable__NameAssignment_2_0 ) )
                    // InternalSingleCodetemplateParser.g:543:1: ( rule__Variable__NameAssignment_2_0 )
                    {
                     before(grammarAccess.getVariableAccess().getNameAssignment_2_0()); 
                    // InternalSingleCodetemplateParser.g:544:1: ( rule__Variable__NameAssignment_2_0 )
                    // InternalSingleCodetemplateParser.g:544:2: rule__Variable__NameAssignment_2_0
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
                    // InternalSingleCodetemplateParser.g:548:6: ( ( rule__Variable__Group_2_1__0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:548:6: ( ( rule__Variable__Group_2_1__0 ) )
                    // InternalSingleCodetemplateParser.g:549:1: ( rule__Variable__Group_2_1__0 )
                    {
                     before(grammarAccess.getVariableAccess().getGroup_2_1()); 
                    // InternalSingleCodetemplateParser.g:550:1: ( rule__Variable__Group_2_1__0 )
                    // InternalSingleCodetemplateParser.g:550:2: rule__Variable__Group_2_1__0
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
    // InternalSingleCodetemplateParser.g:559:1: rule__Variable__ParametersAlternatives_2_1_4_3_0_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_3_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:563:1: ( ( RULE_STRING ) | ( ruleFQN ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=Templates && LA6_0<=For)||LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:564:1: ( RULE_STRING )
                    {
                    // InternalSingleCodetemplateParser.g:564:1: ( RULE_STRING )
                    // InternalSingleCodetemplateParser.g:565:1: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:570:6: ( ruleFQN )
                    {
                    // InternalSingleCodetemplateParser.g:570:6: ( ruleFQN )
                    // InternalSingleCodetemplateParser.g:571:1: ruleFQN
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
    // InternalSingleCodetemplateParser.g:581:1: rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:585:1: ( ( RULE_STRING ) | ( ruleFQN ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=Templates && LA7_0<=For)||LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:586:1: ( RULE_STRING )
                    {
                    // InternalSingleCodetemplateParser.g:586:1: ( RULE_STRING )
                    // InternalSingleCodetemplateParser.g:587:1: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:592:6: ( ruleFQN )
                    {
                    // InternalSingleCodetemplateParser.g:592:6: ( ruleFQN )
                    // InternalSingleCodetemplateParser.g:593:1: ruleFQN
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
    // InternalSingleCodetemplateParser.g:603:1: rule__ValidID__Alternatives : ( ( RULE_ID ) | ( For ) | ( Templates ) );
    public final void rule__ValidID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:607:1: ( ( RULE_ID ) | ( For ) | ( Templates ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt8=1;
                }
                break;
            case For:
                {
                alt8=2;
                }
                break;
            case Templates:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:608:1: ( RULE_ID )
                    {
                    // InternalSingleCodetemplateParser.g:608:1: ( RULE_ID )
                    // InternalSingleCodetemplateParser.g:609:1: RULE_ID
                    {
                     before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:614:6: ( For )
                    {
                    // InternalSingleCodetemplateParser.g:614:6: ( For )
                    // InternalSingleCodetemplateParser.g:615:1: For
                    {
                     before(grammarAccess.getValidIDAccess().getForKeyword_1()); 
                    match(input,For,FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getForKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSingleCodetemplateParser.g:622:6: ( Templates )
                    {
                    // InternalSingleCodetemplateParser.g:622:6: ( Templates )
                    // InternalSingleCodetemplateParser.g:623:1: Templates
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


    // $ANTLR start "rule__Dollar__Alternatives_1"
    // InternalSingleCodetemplateParser.g:635:1: rule__Dollar__Alternatives_1 : ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( DollarSign ) );
    public final void rule__Dollar__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:639:1: ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( DollarSign ) )
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
                    // InternalSingleCodetemplateParser.g:640:1: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:640:1: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    // InternalSingleCodetemplateParser.g:641:1: ( rule__Dollar__EscapedAssignment_1_0 )
                    {
                     before(grammarAccess.getDollarAccess().getEscapedAssignment_1_0()); 
                    // InternalSingleCodetemplateParser.g:642:1: ( rule__Dollar__EscapedAssignment_1_0 )
                    // InternalSingleCodetemplateParser.g:642:2: rule__Dollar__EscapedAssignment_1_0
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
                    // InternalSingleCodetemplateParser.g:646:6: ( DollarSign )
                    {
                    // InternalSingleCodetemplateParser.g:646:6: ( DollarSign )
                    // InternalSingleCodetemplateParser.g:647:1: DollarSign
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
    // InternalSingleCodetemplateParser.g:661:1: rule__Codetemplates__Group__0 : rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 ;
    public final void rule__Codetemplates__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:665:1: ( rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 )
            // InternalSingleCodetemplateParser.g:666:2: rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1
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
    // InternalSingleCodetemplateParser.g:673:1: rule__Codetemplates__Group__0__Impl : ( Templates ) ;
    public final void rule__Codetemplates__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:677:1: ( ( Templates ) )
            // InternalSingleCodetemplateParser.g:678:1: ( Templates )
            {
            // InternalSingleCodetemplateParser.g:678:1: ( Templates )
            // InternalSingleCodetemplateParser.g:679:1: Templates
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
    // InternalSingleCodetemplateParser.g:692:1: rule__Codetemplates__Group__1 : rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 ;
    public final void rule__Codetemplates__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:696:1: ( rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 )
            // InternalSingleCodetemplateParser.g:697:2: rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2
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
    // InternalSingleCodetemplateParser.g:704:1: rule__Codetemplates__Group__1__Impl : ( For ) ;
    public final void rule__Codetemplates__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:708:1: ( ( For ) )
            // InternalSingleCodetemplateParser.g:709:1: ( For )
            {
            // InternalSingleCodetemplateParser.g:709:1: ( For )
            // InternalSingleCodetemplateParser.g:710:1: For
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
    // InternalSingleCodetemplateParser.g:723:1: rule__Codetemplates__Group__2 : rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 ;
    public final void rule__Codetemplates__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:727:1: ( rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 )
            // InternalSingleCodetemplateParser.g:728:2: rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3
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
    // InternalSingleCodetemplateParser.g:735:1: rule__Codetemplates__Group__2__Impl : ( ( rule__Codetemplates__LanguageAssignment_2 ) ) ;
    public final void rule__Codetemplates__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:739:1: ( ( ( rule__Codetemplates__LanguageAssignment_2 ) ) )
            // InternalSingleCodetemplateParser.g:740:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            {
            // InternalSingleCodetemplateParser.g:740:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            // InternalSingleCodetemplateParser.g:741:1: ( rule__Codetemplates__LanguageAssignment_2 )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageAssignment_2()); 
            // InternalSingleCodetemplateParser.g:742:1: ( rule__Codetemplates__LanguageAssignment_2 )
            // InternalSingleCodetemplateParser.g:742:2: rule__Codetemplates__LanguageAssignment_2
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
    // InternalSingleCodetemplateParser.g:752:1: rule__Codetemplates__Group__3 : rule__Codetemplates__Group__3__Impl ;
    public final void rule__Codetemplates__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:756:1: ( rule__Codetemplates__Group__3__Impl )
            // InternalSingleCodetemplateParser.g:757:2: rule__Codetemplates__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplates__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // InternalSingleCodetemplateParser.g:763:1: rule__Codetemplates__Group__3__Impl : ( ( rule__Codetemplates__TemplatesAssignment_3 ) ) ;
    public final void rule__Codetemplates__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:767:1: ( ( ( rule__Codetemplates__TemplatesAssignment_3 ) ) )
            // InternalSingleCodetemplateParser.g:768:1: ( ( rule__Codetemplates__TemplatesAssignment_3 ) )
            {
            // InternalSingleCodetemplateParser.g:768:1: ( ( rule__Codetemplates__TemplatesAssignment_3 ) )
            // InternalSingleCodetemplateParser.g:769:1: ( rule__Codetemplates__TemplatesAssignment_3 )
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesAssignment_3()); 
            // InternalSingleCodetemplateParser.g:770:1: ( rule__Codetemplates__TemplatesAssignment_3 )
            // InternalSingleCodetemplateParser.g:770:2: rule__Codetemplates__TemplatesAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplates__TemplatesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplatesAccess().getTemplatesAssignment_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Codetemplate__Group__0"
    // InternalSingleCodetemplateParser.g:788:1: rule__Codetemplate__Group__0 : rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 ;
    public final void rule__Codetemplate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:792:1: ( rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 )
            // InternalSingleCodetemplateParser.g:793:2: rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalSingleCodetemplateParser.g:800:1: rule__Codetemplate__Group__0__Impl : ( ( rule__Codetemplate__NameAssignment_0 ) ) ;
    public final void rule__Codetemplate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:804:1: ( ( ( rule__Codetemplate__NameAssignment_0 ) ) )
            // InternalSingleCodetemplateParser.g:805:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            {
            // InternalSingleCodetemplateParser.g:805:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            // InternalSingleCodetemplateParser.g:806:1: ( rule__Codetemplate__NameAssignment_0 )
            {
             before(grammarAccess.getCodetemplateAccess().getNameAssignment_0()); 
            // InternalSingleCodetemplateParser.g:807:1: ( rule__Codetemplate__NameAssignment_0 )
            // InternalSingleCodetemplateParser.g:807:2: rule__Codetemplate__NameAssignment_0
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
    // InternalSingleCodetemplateParser.g:817:1: rule__Codetemplate__Group__1 : rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 ;
    public final void rule__Codetemplate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:821:1: ( rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 )
            // InternalSingleCodetemplateParser.g:822:2: rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalSingleCodetemplateParser.g:829:1: rule__Codetemplate__Group__1__Impl : ( For ) ;
    public final void rule__Codetemplate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:833:1: ( ( For ) )
            // InternalSingleCodetemplateParser.g:834:1: ( For )
            {
            // InternalSingleCodetemplateParser.g:834:1: ( For )
            // InternalSingleCodetemplateParser.g:835:1: For
            {
             before(grammarAccess.getCodetemplateAccess().getForKeyword_1()); 
            match(input,For,FOLLOW_2); 
             after(grammarAccess.getCodetemplateAccess().getForKeyword_1()); 

            }


            }

        }
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
    // InternalSingleCodetemplateParser.g:848:1: rule__Codetemplate__Group__2 : rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 ;
    public final void rule__Codetemplate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:852:1: ( rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 )
            // InternalSingleCodetemplateParser.g:853:2: rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3
            {
            pushFollow(FOLLOW_8);
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
    // InternalSingleCodetemplateParser.g:860:1: rule__Codetemplate__Group__2__Impl : ( ( rule__Codetemplate__Alternatives_2 ) ) ;
    public final void rule__Codetemplate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:864:1: ( ( ( rule__Codetemplate__Alternatives_2 ) ) )
            // InternalSingleCodetemplateParser.g:865:1: ( ( rule__Codetemplate__Alternatives_2 ) )
            {
            // InternalSingleCodetemplateParser.g:865:1: ( ( rule__Codetemplate__Alternatives_2 ) )
            // InternalSingleCodetemplateParser.g:866:1: ( rule__Codetemplate__Alternatives_2 )
            {
             before(grammarAccess.getCodetemplateAccess().getAlternatives_2()); 
            // InternalSingleCodetemplateParser.g:867:1: ( rule__Codetemplate__Alternatives_2 )
            // InternalSingleCodetemplateParser.g:867:2: rule__Codetemplate__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplate__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplateAccess().getAlternatives_2()); 

            }


            }

        }
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
    // InternalSingleCodetemplateParser.g:877:1: rule__Codetemplate__Group__3 : rule__Codetemplate__Group__3__Impl ;
    public final void rule__Codetemplate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:881:1: ( rule__Codetemplate__Group__3__Impl )
            // InternalSingleCodetemplateParser.g:882:2: rule__Codetemplate__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplate__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // InternalSingleCodetemplateParser.g:888:1: rule__Codetemplate__Group__3__Impl : ( ( rule__Codetemplate__BodyAssignment_3 ) ) ;
    public final void rule__Codetemplate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:892:1: ( ( ( rule__Codetemplate__BodyAssignment_3 ) ) )
            // InternalSingleCodetemplateParser.g:893:1: ( ( rule__Codetemplate__BodyAssignment_3 ) )
            {
            // InternalSingleCodetemplateParser.g:893:1: ( ( rule__Codetemplate__BodyAssignment_3 ) )
            // InternalSingleCodetemplateParser.g:894:1: ( rule__Codetemplate__BodyAssignment_3 )
            {
             before(grammarAccess.getCodetemplateAccess().getBodyAssignment_3()); 
            // InternalSingleCodetemplateParser.g:895:1: ( rule__Codetemplate__BodyAssignment_3 )
            // InternalSingleCodetemplateParser.g:895:2: rule__Codetemplate__BodyAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Codetemplate__BodyAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCodetemplateAccess().getBodyAssignment_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__TemplateBodyWithQuotes__Group__0"
    // InternalSingleCodetemplateParser.g:913:1: rule__TemplateBodyWithQuotes__Group__0 : rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 ;
    public final void rule__TemplateBodyWithQuotes__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:917:1: ( rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 )
            // InternalSingleCodetemplateParser.g:918:2: rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalSingleCodetemplateParser.g:925:1: rule__TemplateBodyWithQuotes__Group__0__Impl : ( GreaterThanSignGreaterThanSign ) ;
    public final void rule__TemplateBodyWithQuotes__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:929:1: ( ( GreaterThanSignGreaterThanSign ) )
            // InternalSingleCodetemplateParser.g:930:1: ( GreaterThanSignGreaterThanSign )
            {
            // InternalSingleCodetemplateParser.g:930:1: ( GreaterThanSignGreaterThanSign )
            // InternalSingleCodetemplateParser.g:931:1: GreaterThanSignGreaterThanSign
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_0()); 
            match(input,GreaterThanSignGreaterThanSign,FOLLOW_2); 
             after(grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_0()); 

            }


            }

        }
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
    // InternalSingleCodetemplateParser.g:944:1: rule__TemplateBodyWithQuotes__Group__1 : rule__TemplateBodyWithQuotes__Group__1__Impl ;
    public final void rule__TemplateBodyWithQuotes__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:948:1: ( rule__TemplateBodyWithQuotes__Group__1__Impl )
            // InternalSingleCodetemplateParser.g:949:2: rule__TemplateBodyWithQuotes__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TemplateBodyWithQuotes__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalSingleCodetemplateParser.g:955:1: rule__TemplateBodyWithQuotes__Group__1__Impl : ( ruleTemplateBody ) ;
    public final void rule__TemplateBodyWithQuotes__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:959:1: ( ( ruleTemplateBody ) )
            // InternalSingleCodetemplateParser.g:960:1: ( ruleTemplateBody )
            {
            // InternalSingleCodetemplateParser.g:960:1: ( ruleTemplateBody )
            // InternalSingleCodetemplateParser.g:961:1: ruleTemplateBody
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
            ruleTemplateBody();

            state._fsp--;

             after(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__TemplateBody__Group__0"
    // InternalSingleCodetemplateParser.g:976:1: rule__TemplateBody__Group__0 : rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 ;
    public final void rule__TemplateBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:980:1: ( rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 )
            // InternalSingleCodetemplateParser.g:981:2: rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalSingleCodetemplateParser.g:988:1: rule__TemplateBody__Group__0__Impl : ( () ) ;
    public final void rule__TemplateBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:992:1: ( ( () ) )
            // InternalSingleCodetemplateParser.g:993:1: ( () )
            {
            // InternalSingleCodetemplateParser.g:993:1: ( () )
            // InternalSingleCodetemplateParser.g:994:1: ()
            {
             before(grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0()); 
            // InternalSingleCodetemplateParser.g:995:1: ()
            // InternalSingleCodetemplateParser.g:997:1: 
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
    // InternalSingleCodetemplateParser.g:1007:1: rule__TemplateBody__Group__1 : rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 ;
    public final void rule__TemplateBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1011:1: ( rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 )
            // InternalSingleCodetemplateParser.g:1012:2: rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalSingleCodetemplateParser.g:1019:1: rule__TemplateBody__Group__1__Impl : ( ( rule__TemplateBody__PartsAssignment_1 )? ) ;
    public final void rule__TemplateBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1023:1: ( ( ( rule__TemplateBody__PartsAssignment_1 )? ) )
            // InternalSingleCodetemplateParser.g:1024:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            {
            // InternalSingleCodetemplateParser.g:1024:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            // InternalSingleCodetemplateParser.g:1025:1: ( rule__TemplateBody__PartsAssignment_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_1()); 
            // InternalSingleCodetemplateParser.g:1026:1: ( rule__TemplateBody__PartsAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||(LA10_0>=RULE_WS && LA10_0<=RULE_ANY_OTHER)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1026:2: rule__TemplateBody__PartsAssignment_1
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
    // InternalSingleCodetemplateParser.g:1036:1: rule__TemplateBody__Group__2 : rule__TemplateBody__Group__2__Impl ;
    public final void rule__TemplateBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1040:1: ( rule__TemplateBody__Group__2__Impl )
            // InternalSingleCodetemplateParser.g:1041:2: rule__TemplateBody__Group__2__Impl
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
    // InternalSingleCodetemplateParser.g:1047:1: rule__TemplateBody__Group__2__Impl : ( ( rule__TemplateBody__Group_2__0 )* ) ;
    public final void rule__TemplateBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1051:1: ( ( ( rule__TemplateBody__Group_2__0 )* ) )
            // InternalSingleCodetemplateParser.g:1052:1: ( ( rule__TemplateBody__Group_2__0 )* )
            {
            // InternalSingleCodetemplateParser.g:1052:1: ( ( rule__TemplateBody__Group_2__0 )* )
            // InternalSingleCodetemplateParser.g:1053:1: ( rule__TemplateBody__Group_2__0 )*
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup_2()); 
            // InternalSingleCodetemplateParser.g:1054:1: ( rule__TemplateBody__Group_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=DollarSignDollarSign && LA11_0<=DollarSignLeftCurlyBracket)||LA11_0==DollarSign) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1054:2: rule__TemplateBody__Group_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__TemplateBody__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalSingleCodetemplateParser.g:1070:1: rule__TemplateBody__Group_2__0 : rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 ;
    public final void rule__TemplateBody__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1074:1: ( rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 )
            // InternalSingleCodetemplateParser.g:1075:2: rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalSingleCodetemplateParser.g:1082:1: rule__TemplateBody__Group_2__0__Impl : ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) ;
    public final void rule__TemplateBody__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1086:1: ( ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) )
            // InternalSingleCodetemplateParser.g:1087:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            {
            // InternalSingleCodetemplateParser.g:1087:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            // InternalSingleCodetemplateParser.g:1088:1: ( rule__TemplateBody__PartsAssignment_2_0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_0()); 
            // InternalSingleCodetemplateParser.g:1089:1: ( rule__TemplateBody__PartsAssignment_2_0 )
            // InternalSingleCodetemplateParser.g:1089:2: rule__TemplateBody__PartsAssignment_2_0
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
    // InternalSingleCodetemplateParser.g:1099:1: rule__TemplateBody__Group_2__1 : rule__TemplateBody__Group_2__1__Impl ;
    public final void rule__TemplateBody__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1103:1: ( rule__TemplateBody__Group_2__1__Impl )
            // InternalSingleCodetemplateParser.g:1104:2: rule__TemplateBody__Group_2__1__Impl
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
    // InternalSingleCodetemplateParser.g:1110:1: rule__TemplateBody__Group_2__1__Impl : ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) ;
    public final void rule__TemplateBody__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1114:1: ( ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) )
            // InternalSingleCodetemplateParser.g:1115:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            {
            // InternalSingleCodetemplateParser.g:1115:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            // InternalSingleCodetemplateParser.g:1116:1: ( rule__TemplateBody__PartsAssignment_2_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_1()); 
            // InternalSingleCodetemplateParser.g:1117:1: ( rule__TemplateBody__PartsAssignment_2_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||(LA12_0>=RULE_WS && LA12_0<=RULE_ANY_OTHER)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1117:2: rule__TemplateBody__PartsAssignment_2_1
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
    // InternalSingleCodetemplateParser.g:1131:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1135:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalSingleCodetemplateParser.g:1136:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalSingleCodetemplateParser.g:1143:1: rule__Variable__Group__0__Impl : ( DollarSignLeftCurlyBracket ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1147:1: ( ( DollarSignLeftCurlyBracket ) )
            // InternalSingleCodetemplateParser.g:1148:1: ( DollarSignLeftCurlyBracket )
            {
            // InternalSingleCodetemplateParser.g:1148:1: ( DollarSignLeftCurlyBracket )
            // InternalSingleCodetemplateParser.g:1149:1: DollarSignLeftCurlyBracket
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
    // InternalSingleCodetemplateParser.g:1162:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1166:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalSingleCodetemplateParser.g:1167:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_12);
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
    // InternalSingleCodetemplateParser.g:1174:1: rule__Variable__Group__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1178:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1179:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1179:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1180:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_1()); 
            // InternalSingleCodetemplateParser.g:1181:1: ( RULE_WS )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1181:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_13); 

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalSingleCodetemplateParser.g:1191:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1195:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalSingleCodetemplateParser.g:1196:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
            {
            pushFollow(FOLLOW_14);
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
    // InternalSingleCodetemplateParser.g:1203:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Alternatives_2 ) ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1207:1: ( ( ( rule__Variable__Alternatives_2 ) ) )
            // InternalSingleCodetemplateParser.g:1208:1: ( ( rule__Variable__Alternatives_2 ) )
            {
            // InternalSingleCodetemplateParser.g:1208:1: ( ( rule__Variable__Alternatives_2 ) )
            // InternalSingleCodetemplateParser.g:1209:1: ( rule__Variable__Alternatives_2 )
            {
             before(grammarAccess.getVariableAccess().getAlternatives_2()); 
            // InternalSingleCodetemplateParser.g:1210:1: ( rule__Variable__Alternatives_2 )
            // InternalSingleCodetemplateParser.g:1210:2: rule__Variable__Alternatives_2
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
    // InternalSingleCodetemplateParser.g:1220:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl rule__Variable__Group__4 ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1224:1: ( rule__Variable__Group__3__Impl rule__Variable__Group__4 )
            // InternalSingleCodetemplateParser.g:1225:2: rule__Variable__Group__3__Impl rule__Variable__Group__4
            {
            pushFollow(FOLLOW_14);
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
    // InternalSingleCodetemplateParser.g:1232:1: rule__Variable__Group__3__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1236:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1237:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1237:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1238:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_3()); 
            // InternalSingleCodetemplateParser.g:1239:1: ( RULE_WS )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_WS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1239:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_13); 

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalSingleCodetemplateParser.g:1249:1: rule__Variable__Group__4 : rule__Variable__Group__4__Impl ;
    public final void rule__Variable__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1253:1: ( rule__Variable__Group__4__Impl )
            // InternalSingleCodetemplateParser.g:1254:2: rule__Variable__Group__4__Impl
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
    // InternalSingleCodetemplateParser.g:1260:1: rule__Variable__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__Variable__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1264:1: ( ( RightCurlyBracket ) )
            // InternalSingleCodetemplateParser.g:1265:1: ( RightCurlyBracket )
            {
            // InternalSingleCodetemplateParser.g:1265:1: ( RightCurlyBracket )
            // InternalSingleCodetemplateParser.g:1266:1: RightCurlyBracket
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
    // InternalSingleCodetemplateParser.g:1289:1: rule__Variable__Group_2_1__0 : rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 ;
    public final void rule__Variable__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1293:1: ( rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 )
            // InternalSingleCodetemplateParser.g:1294:2: rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalSingleCodetemplateParser.g:1301:1: rule__Variable__Group_2_1__0__Impl : ( ( rule__Variable__Group_2_1_0__0 )? ) ;
    public final void rule__Variable__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1305:1: ( ( ( rule__Variable__Group_2_1_0__0 )? ) )
            // InternalSingleCodetemplateParser.g:1306:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            {
            // InternalSingleCodetemplateParser.g:1306:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            // InternalSingleCodetemplateParser.g:1307:1: ( rule__Variable__Group_2_1_0__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_0()); 
            // InternalSingleCodetemplateParser.g:1308:1: ( rule__Variable__Group_2_1_0__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=Templates && LA15_0<=For)||LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1308:2: rule__Variable__Group_2_1_0__0
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
    // InternalSingleCodetemplateParser.g:1318:1: rule__Variable__Group_2_1__1 : rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 ;
    public final void rule__Variable__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1322:1: ( rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 )
            // InternalSingleCodetemplateParser.g:1323:2: rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2
            {
            pushFollow(FOLLOW_15);
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
    // InternalSingleCodetemplateParser.g:1330:1: rule__Variable__Group_2_1__1__Impl : ( Colon ) ;
    public final void rule__Variable__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1334:1: ( ( Colon ) )
            // InternalSingleCodetemplateParser.g:1335:1: ( Colon )
            {
            // InternalSingleCodetemplateParser.g:1335:1: ( Colon )
            // InternalSingleCodetemplateParser.g:1336:1: Colon
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
    // InternalSingleCodetemplateParser.g:1349:1: rule__Variable__Group_2_1__2 : rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 ;
    public final void rule__Variable__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1353:1: ( rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 )
            // InternalSingleCodetemplateParser.g:1354:2: rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3
            {
            pushFollow(FOLLOW_15);
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
    // InternalSingleCodetemplateParser.g:1361:1: rule__Variable__Group_2_1__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1365:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1366:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1366:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1367:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2()); 
            // InternalSingleCodetemplateParser.g:1368:1: ( RULE_WS )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_WS) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1368:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_13); 

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalSingleCodetemplateParser.g:1378:1: rule__Variable__Group_2_1__3 : rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 ;
    public final void rule__Variable__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1382:1: ( rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 )
            // InternalSingleCodetemplateParser.g:1383:2: rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4
            {
            pushFollow(FOLLOW_16);
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
    // InternalSingleCodetemplateParser.g:1390:1: rule__Variable__Group_2_1__3__Impl : ( ( rule__Variable__TypeAssignment_2_1_3 ) ) ;
    public final void rule__Variable__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1394:1: ( ( ( rule__Variable__TypeAssignment_2_1_3 ) ) )
            // InternalSingleCodetemplateParser.g:1395:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            {
            // InternalSingleCodetemplateParser.g:1395:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            // InternalSingleCodetemplateParser.g:1396:1: ( rule__Variable__TypeAssignment_2_1_3 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_2_1_3()); 
            // InternalSingleCodetemplateParser.g:1397:1: ( rule__Variable__TypeAssignment_2_1_3 )
            // InternalSingleCodetemplateParser.g:1397:2: rule__Variable__TypeAssignment_2_1_3
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
    // InternalSingleCodetemplateParser.g:1407:1: rule__Variable__Group_2_1__4 : rule__Variable__Group_2_1__4__Impl ;
    public final void rule__Variable__Group_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1411:1: ( rule__Variable__Group_2_1__4__Impl )
            // InternalSingleCodetemplateParser.g:1412:2: rule__Variable__Group_2_1__4__Impl
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
    // InternalSingleCodetemplateParser.g:1418:1: rule__Variable__Group_2_1__4__Impl : ( ( rule__Variable__Group_2_1_4__0 )? ) ;
    public final void rule__Variable__Group_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1422:1: ( ( ( rule__Variable__Group_2_1_4__0 )? ) )
            // InternalSingleCodetemplateParser.g:1423:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            {
            // InternalSingleCodetemplateParser.g:1423:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            // InternalSingleCodetemplateParser.g:1424:1: ( rule__Variable__Group_2_1_4__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4()); 
            // InternalSingleCodetemplateParser.g:1425:1: ( rule__Variable__Group_2_1_4__0 )?
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1425:2: rule__Variable__Group_2_1_4__0
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
    // InternalSingleCodetemplateParser.g:1445:1: rule__Variable__Group_2_1_0__0 : rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 ;
    public final void rule__Variable__Group_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1449:1: ( rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 )
            // InternalSingleCodetemplateParser.g:1450:2: rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalSingleCodetemplateParser.g:1457:1: rule__Variable__Group_2_1_0__0__Impl : ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) ;
    public final void rule__Variable__Group_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1461:1: ( ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) )
            // InternalSingleCodetemplateParser.g:1462:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            {
            // InternalSingleCodetemplateParser.g:1462:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            // InternalSingleCodetemplateParser.g:1463:1: ( rule__Variable__NameAssignment_2_1_0_0 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_2_1_0_0()); 
            // InternalSingleCodetemplateParser.g:1464:1: ( rule__Variable__NameAssignment_2_1_0_0 )
            // InternalSingleCodetemplateParser.g:1464:2: rule__Variable__NameAssignment_2_1_0_0
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
    // InternalSingleCodetemplateParser.g:1474:1: rule__Variable__Group_2_1_0__1 : rule__Variable__Group_2_1_0__1__Impl ;
    public final void rule__Variable__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1478:1: ( rule__Variable__Group_2_1_0__1__Impl )
            // InternalSingleCodetemplateParser.g:1479:2: rule__Variable__Group_2_1_0__1__Impl
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
    // InternalSingleCodetemplateParser.g:1485:1: rule__Variable__Group_2_1_0__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1489:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1490:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1490:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1491:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1()); 
            // InternalSingleCodetemplateParser.g:1492:1: ( RULE_WS )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_WS) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1492:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_13); 

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalSingleCodetemplateParser.g:1506:1: rule__Variable__Group_2_1_4__0 : rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 ;
    public final void rule__Variable__Group_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1510:1: ( rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 )
            // InternalSingleCodetemplateParser.g:1511:2: rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalSingleCodetemplateParser.g:1518:1: rule__Variable__Group_2_1_4__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1522:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1523:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1523:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1524:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0()); 
            // InternalSingleCodetemplateParser.g:1525:1: ( RULE_WS )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_WS) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1525:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_13); 

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalSingleCodetemplateParser.g:1535:1: rule__Variable__Group_2_1_4__1 : rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 ;
    public final void rule__Variable__Group_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1539:1: ( rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 )
            // InternalSingleCodetemplateParser.g:1540:2: rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalSingleCodetemplateParser.g:1547:1: rule__Variable__Group_2_1_4__1__Impl : ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) ) ;
    public final void rule__Variable__Group_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1551:1: ( ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) ) )
            // InternalSingleCodetemplateParser.g:1552:1: ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) )
            {
            // InternalSingleCodetemplateParser.g:1552:1: ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) )
            // InternalSingleCodetemplateParser.g:1553:1: ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 )
            {
             before(grammarAccess.getVariableAccess().getExpectingParametersAssignment_2_1_4_1()); 
            // InternalSingleCodetemplateParser.g:1554:1: ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 )
            // InternalSingleCodetemplateParser.g:1554:2: rule__Variable__ExpectingParametersAssignment_2_1_4_1
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
    // InternalSingleCodetemplateParser.g:1564:1: rule__Variable__Group_2_1_4__2 : rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 ;
    public final void rule__Variable__Group_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1568:1: ( rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 )
            // InternalSingleCodetemplateParser.g:1569:2: rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3
            {
            pushFollow(FOLLOW_18);
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
    // InternalSingleCodetemplateParser.g:1576:1: rule__Variable__Group_2_1_4__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1580:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1581:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1581:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1582:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2()); 
            // InternalSingleCodetemplateParser.g:1583:1: ( RULE_WS )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_WS) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1583:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_13); 

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalSingleCodetemplateParser.g:1593:1: rule__Variable__Group_2_1_4__3 : rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 ;
    public final void rule__Variable__Group_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1597:1: ( rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 )
            // InternalSingleCodetemplateParser.g:1598:2: rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4
            {
            pushFollow(FOLLOW_18);
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
    // InternalSingleCodetemplateParser.g:1605:1: rule__Variable__Group_2_1_4__3__Impl : ( ( rule__Variable__Group_2_1_4_3__0 )? ) ;
    public final void rule__Variable__Group_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1609:1: ( ( ( rule__Variable__Group_2_1_4_3__0 )? ) )
            // InternalSingleCodetemplateParser.g:1610:1: ( ( rule__Variable__Group_2_1_4_3__0 )? )
            {
            // InternalSingleCodetemplateParser.g:1610:1: ( ( rule__Variable__Group_2_1_4_3__0 )? )
            // InternalSingleCodetemplateParser.g:1611:1: ( rule__Variable__Group_2_1_4_3__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4_3()); 
            // InternalSingleCodetemplateParser.g:1612:1: ( rule__Variable__Group_2_1_4_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=Templates && LA21_0<=For)||(LA21_0>=RULE_ID && LA21_0<=RULE_STRING)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1612:2: rule__Variable__Group_2_1_4_3__0
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
    // InternalSingleCodetemplateParser.g:1622:1: rule__Variable__Group_2_1_4__4 : rule__Variable__Group_2_1_4__4__Impl ;
    public final void rule__Variable__Group_2_1_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1626:1: ( rule__Variable__Group_2_1_4__4__Impl )
            // InternalSingleCodetemplateParser.g:1627:2: rule__Variable__Group_2_1_4__4__Impl
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
    // InternalSingleCodetemplateParser.g:1633:1: rule__Variable__Group_2_1_4__4__Impl : ( RightParenthesis ) ;
    public final void rule__Variable__Group_2_1_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1637:1: ( ( RightParenthesis ) )
            // InternalSingleCodetemplateParser.g:1638:1: ( RightParenthesis )
            {
            // InternalSingleCodetemplateParser.g:1638:1: ( RightParenthesis )
            // InternalSingleCodetemplateParser.g:1639:1: RightParenthesis
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
    // InternalSingleCodetemplateParser.g:1662:1: rule__Variable__Group_2_1_4_3__0 : rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1 ;
    public final void rule__Variable__Group_2_1_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1666:1: ( rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1 )
            // InternalSingleCodetemplateParser.g:1667:2: rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalSingleCodetemplateParser.g:1674:1: rule__Variable__Group_2_1_4_3__0__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) ) ;
    public final void rule__Variable__Group_2_1_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1678:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) ) )
            // InternalSingleCodetemplateParser.g:1679:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) )
            {
            // InternalSingleCodetemplateParser.g:1679:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) )
            // InternalSingleCodetemplateParser.g:1680:1: ( rule__Variable__ParametersAssignment_2_1_4_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_0()); 
            // InternalSingleCodetemplateParser.g:1681:1: ( rule__Variable__ParametersAssignment_2_1_4_3_0 )
            // InternalSingleCodetemplateParser.g:1681:2: rule__Variable__ParametersAssignment_2_1_4_3_0
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
    // InternalSingleCodetemplateParser.g:1691:1: rule__Variable__Group_2_1_4_3__1 : rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2 ;
    public final void rule__Variable__Group_2_1_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1695:1: ( rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2 )
            // InternalSingleCodetemplateParser.g:1696:2: rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2
            {
            pushFollow(FOLLOW_19);
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
    // InternalSingleCodetemplateParser.g:1703:1: rule__Variable__Group_2_1_4_3__1__Impl : ( ( rule__Variable__Group_2_1_4_3_1__0 )* ) ;
    public final void rule__Variable__Group_2_1_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1707:1: ( ( ( rule__Variable__Group_2_1_4_3_1__0 )* ) )
            // InternalSingleCodetemplateParser.g:1708:1: ( ( rule__Variable__Group_2_1_4_3_1__0 )* )
            {
            // InternalSingleCodetemplateParser.g:1708:1: ( ( rule__Variable__Group_2_1_4_3_1__0 )* )
            // InternalSingleCodetemplateParser.g:1709:1: ( rule__Variable__Group_2_1_4_3_1__0 )*
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4_3_1()); 
            // InternalSingleCodetemplateParser.g:1710:1: ( rule__Variable__Group_2_1_4_3_1__0 )*
            loop22:
            do {
                int alt22=2;
                alt22 = dfa22.predict(input);
                switch (alt22) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1710:2: rule__Variable__Group_2_1_4_3_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__Variable__Group_2_1_4_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalSingleCodetemplateParser.g:1720:1: rule__Variable__Group_2_1_4_3__2 : rule__Variable__Group_2_1_4_3__2__Impl ;
    public final void rule__Variable__Group_2_1_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1724:1: ( rule__Variable__Group_2_1_4_3__2__Impl )
            // InternalSingleCodetemplateParser.g:1725:2: rule__Variable__Group_2_1_4_3__2__Impl
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
    // InternalSingleCodetemplateParser.g:1731:1: rule__Variable__Group_2_1_4_3__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1735:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1736:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1736:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1737:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_2()); 
            // InternalSingleCodetemplateParser.g:1738:1: ( RULE_WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1738:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_13); 

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalSingleCodetemplateParser.g:1754:1: rule__Variable__Group_2_1_4_3_1__0 : rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1 ;
    public final void rule__Variable__Group_2_1_4_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1758:1: ( rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1 )
            // InternalSingleCodetemplateParser.g:1759:2: rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalSingleCodetemplateParser.g:1766:1: rule__Variable__Group_2_1_4_3_1__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1770:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1771:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1771:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1772:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_0()); 
            // InternalSingleCodetemplateParser.g:1773:1: ( RULE_WS )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_WS) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1773:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_13); 

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalSingleCodetemplateParser.g:1783:1: rule__Variable__Group_2_1_4_3_1__1 : rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2 ;
    public final void rule__Variable__Group_2_1_4_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1787:1: ( rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2 )
            // InternalSingleCodetemplateParser.g:1788:2: rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2
            {
            pushFollow(FOLLOW_21);
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
    // InternalSingleCodetemplateParser.g:1795:1: rule__Variable__Group_2_1_4_3_1__1__Impl : ( Comma ) ;
    public final void rule__Variable__Group_2_1_4_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1799:1: ( ( Comma ) )
            // InternalSingleCodetemplateParser.g:1800:1: ( Comma )
            {
            // InternalSingleCodetemplateParser.g:1800:1: ( Comma )
            // InternalSingleCodetemplateParser.g:1801:1: Comma
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
    // InternalSingleCodetemplateParser.g:1814:1: rule__Variable__Group_2_1_4_3_1__2 : rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3 ;
    public final void rule__Variable__Group_2_1_4_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1818:1: ( rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3 )
            // InternalSingleCodetemplateParser.g:1819:2: rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3
            {
            pushFollow(FOLLOW_21);
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
    // InternalSingleCodetemplateParser.g:1826:1: rule__Variable__Group_2_1_4_3_1__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1830:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1831:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1831:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1832:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_2()); 
            // InternalSingleCodetemplateParser.g:1833:1: ( RULE_WS )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_WS) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1833:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_13); 

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalSingleCodetemplateParser.g:1843:1: rule__Variable__Group_2_1_4_3_1__3 : rule__Variable__Group_2_1_4_3_1__3__Impl ;
    public final void rule__Variable__Group_2_1_4_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1847:1: ( rule__Variable__Group_2_1_4_3_1__3__Impl )
            // InternalSingleCodetemplateParser.g:1848:2: rule__Variable__Group_2_1_4_3_1__3__Impl
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
    // InternalSingleCodetemplateParser.g:1854:1: rule__Variable__Group_2_1_4_3_1__3__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) ) ;
    public final void rule__Variable__Group_2_1_4_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1858:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) ) )
            // InternalSingleCodetemplateParser.g:1859:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) )
            {
            // InternalSingleCodetemplateParser.g:1859:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) )
            // InternalSingleCodetemplateParser.g:1860:1: ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_1_3()); 
            // InternalSingleCodetemplateParser.g:1861:1: ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 )
            // InternalSingleCodetemplateParser.g:1861:2: rule__Variable__ParametersAssignment_2_1_4_3_1_3
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
    // InternalSingleCodetemplateParser.g:1879:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1883:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalSingleCodetemplateParser.g:1884:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalSingleCodetemplateParser.g:1891:1: rule__FQN__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1895:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1896:1: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1896:1: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1897:1: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1908:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1912:1: ( rule__FQN__Group__1__Impl )
            // InternalSingleCodetemplateParser.g:1913:2: rule__FQN__Group__1__Impl
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
    // InternalSingleCodetemplateParser.g:1919:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1923:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalSingleCodetemplateParser.g:1924:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalSingleCodetemplateParser.g:1924:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalSingleCodetemplateParser.g:1925:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalSingleCodetemplateParser.g:1926:1: ( rule__FQN__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==FullStop) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1926:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalSingleCodetemplateParser.g:1940:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1944:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalSingleCodetemplateParser.g:1945:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalSingleCodetemplateParser.g:1952:1: rule__FQN__Group_1__0__Impl : ( FullStop ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1956:1: ( ( FullStop ) )
            // InternalSingleCodetemplateParser.g:1957:1: ( FullStop )
            {
            // InternalSingleCodetemplateParser.g:1957:1: ( FullStop )
            // InternalSingleCodetemplateParser.g:1958:1: FullStop
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
    // InternalSingleCodetemplateParser.g:1971:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1975:1: ( rule__FQN__Group_1__1__Impl )
            // InternalSingleCodetemplateParser.g:1976:2: rule__FQN__Group_1__1__Impl
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
    // InternalSingleCodetemplateParser.g:1982:1: rule__FQN__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:1986:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1987:1: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1987:1: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1988:1: ruleValidID
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
    // InternalSingleCodetemplateParser.g:2003:1: rule__Dollar__Group__0 : rule__Dollar__Group__0__Impl rule__Dollar__Group__1 ;
    public final void rule__Dollar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2007:1: ( rule__Dollar__Group__0__Impl rule__Dollar__Group__1 )
            // InternalSingleCodetemplateParser.g:2008:2: rule__Dollar__Group__0__Impl rule__Dollar__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalSingleCodetemplateParser.g:2015:1: rule__Dollar__Group__0__Impl : ( () ) ;
    public final void rule__Dollar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2019:1: ( ( () ) )
            // InternalSingleCodetemplateParser.g:2020:1: ( () )
            {
            // InternalSingleCodetemplateParser.g:2020:1: ( () )
            // InternalSingleCodetemplateParser.g:2021:1: ()
            {
             before(grammarAccess.getDollarAccess().getDollarAction_0()); 
            // InternalSingleCodetemplateParser.g:2022:1: ()
            // InternalSingleCodetemplateParser.g:2024:1: 
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
    // InternalSingleCodetemplateParser.g:2034:1: rule__Dollar__Group__1 : rule__Dollar__Group__1__Impl ;
    public final void rule__Dollar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2038:1: ( rule__Dollar__Group__1__Impl )
            // InternalSingleCodetemplateParser.g:2039:2: rule__Dollar__Group__1__Impl
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
    // InternalSingleCodetemplateParser.g:2045:1: rule__Dollar__Group__1__Impl : ( ( rule__Dollar__Alternatives_1 ) ) ;
    public final void rule__Dollar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2049:1: ( ( ( rule__Dollar__Alternatives_1 ) ) )
            // InternalSingleCodetemplateParser.g:2050:1: ( ( rule__Dollar__Alternatives_1 ) )
            {
            // InternalSingleCodetemplateParser.g:2050:1: ( ( rule__Dollar__Alternatives_1 ) )
            // InternalSingleCodetemplateParser.g:2051:1: ( rule__Dollar__Alternatives_1 )
            {
             before(grammarAccess.getDollarAccess().getAlternatives_1()); 
            // InternalSingleCodetemplateParser.g:2052:1: ( rule__Dollar__Alternatives_1 )
            // InternalSingleCodetemplateParser.g:2052:2: rule__Dollar__Alternatives_1
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
    // InternalSingleCodetemplateParser.g:2067:1: rule__Codetemplates__LanguageAssignment_2 : ( ( ruleFQN ) ) ;
    public final void rule__Codetemplates__LanguageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2071:1: ( ( ( ruleFQN ) ) )
            // InternalSingleCodetemplateParser.g:2072:1: ( ( ruleFQN ) )
            {
            // InternalSingleCodetemplateParser.g:2072:1: ( ( ruleFQN ) )
            // InternalSingleCodetemplateParser.g:2073:1: ( ruleFQN )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0()); 
            // InternalSingleCodetemplateParser.g:2074:1: ( ruleFQN )
            // InternalSingleCodetemplateParser.g:2075:1: ruleFQN
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


    // $ANTLR start "rule__Codetemplates__TemplatesAssignment_3"
    // InternalSingleCodetemplateParser.g:2086:1: rule__Codetemplates__TemplatesAssignment_3 : ( ruleCodetemplate ) ;
    public final void rule__Codetemplates__TemplatesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2090:1: ( ( ruleCodetemplate ) )
            // InternalSingleCodetemplateParser.g:2091:1: ( ruleCodetemplate )
            {
            // InternalSingleCodetemplateParser.g:2091:1: ( ruleCodetemplate )
            // InternalSingleCodetemplateParser.g:2092:1: ruleCodetemplate
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCodetemplate();

            state._fsp--;

             after(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplates__TemplatesAssignment_3"


    // $ANTLR start "rule__Codetemplate__NameAssignment_0"
    // InternalSingleCodetemplateParser.g:2101:1: rule__Codetemplate__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2105:1: ( ( RULE_STRING ) )
            // InternalSingleCodetemplateParser.g:2106:1: ( RULE_STRING )
            {
            // InternalSingleCodetemplateParser.g:2106:1: ( RULE_STRING )
            // InternalSingleCodetemplateParser.g:2107:1: RULE_STRING
            {
             before(grammarAccess.getCodetemplateAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getCodetemplateAccess().getNameSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__Codetemplate__ContextAssignment_2_0"
    // InternalSingleCodetemplateParser.g:2116:1: rule__Codetemplate__ContextAssignment_2_0 : ( ( ruleValidID ) ) ;
    public final void rule__Codetemplate__ContextAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2120:1: ( ( ( ruleValidID ) ) )
            // InternalSingleCodetemplateParser.g:2121:1: ( ( ruleValidID ) )
            {
            // InternalSingleCodetemplateParser.g:2121:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:2122:1: ( ruleValidID )
            {
             before(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_2_0_0()); 
            // InternalSingleCodetemplateParser.g:2123:1: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:2124:1: ruleValidID
            {
             before(grammarAccess.getCodetemplateAccess().getContextAbstractRuleValidIDParserRuleCall_2_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getCodetemplateAccess().getContextAbstractRuleValidIDParserRuleCall_2_0_0_1()); 

            }

             after(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__ContextAssignment_2_0"


    // $ANTLR start "rule__Codetemplate__KeywordContextAssignment_2_1"
    // InternalSingleCodetemplateParser.g:2135:1: rule__Codetemplate__KeywordContextAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__KeywordContextAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2139:1: ( ( RULE_STRING ) )
            // InternalSingleCodetemplateParser.g:2140:1: ( RULE_STRING )
            {
            // InternalSingleCodetemplateParser.g:2140:1: ( RULE_STRING )
            // InternalSingleCodetemplateParser.g:2141:1: RULE_STRING
            {
             before(grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__KeywordContextAssignment_2_1"


    // $ANTLR start "rule__Codetemplate__BodyAssignment_3"
    // InternalSingleCodetemplateParser.g:2150:1: rule__Codetemplate__BodyAssignment_3 : ( ruleTemplateBodyWithQuotes ) ;
    public final void rule__Codetemplate__BodyAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2154:1: ( ( ruleTemplateBodyWithQuotes ) )
            // InternalSingleCodetemplateParser.g:2155:1: ( ruleTemplateBodyWithQuotes )
            {
            // InternalSingleCodetemplateParser.g:2155:1: ( ruleTemplateBodyWithQuotes )
            // InternalSingleCodetemplateParser.g:2156:1: ruleTemplateBodyWithQuotes
            {
             before(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTemplateBodyWithQuotes();

            state._fsp--;

             after(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codetemplate__BodyAssignment_3"


    // $ANTLR start "rule__TemplateBody__PartsAssignment_1"
    // InternalSingleCodetemplateParser.g:2165:1: rule__TemplateBody__PartsAssignment_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2169:1: ( ( ruleLiteral ) )
            // InternalSingleCodetemplateParser.g:2170:1: ( ruleLiteral )
            {
            // InternalSingleCodetemplateParser.g:2170:1: ( ruleLiteral )
            // InternalSingleCodetemplateParser.g:2171:1: ruleLiteral
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
    // InternalSingleCodetemplateParser.g:2180:1: rule__TemplateBody__PartsAssignment_2_0 : ( ruleVariableOrDollar ) ;
    public final void rule__TemplateBody__PartsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2184:1: ( ( ruleVariableOrDollar ) )
            // InternalSingleCodetemplateParser.g:2185:1: ( ruleVariableOrDollar )
            {
            // InternalSingleCodetemplateParser.g:2185:1: ( ruleVariableOrDollar )
            // InternalSingleCodetemplateParser.g:2186:1: ruleVariableOrDollar
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
    // InternalSingleCodetemplateParser.g:2195:1: rule__TemplateBody__PartsAssignment_2_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2199:1: ( ( ruleLiteral ) )
            // InternalSingleCodetemplateParser.g:2200:1: ( ruleLiteral )
            {
            // InternalSingleCodetemplateParser.g:2200:1: ( ruleLiteral )
            // InternalSingleCodetemplateParser.g:2201:1: ruleLiteral
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
    // InternalSingleCodetemplateParser.g:2210:1: rule__Variable__NameAssignment_2_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2214:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:2215:1: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:2215:1: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:2216:1: ruleValidID
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
    // InternalSingleCodetemplateParser.g:2225:1: rule__Variable__NameAssignment_2_1_0_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2229:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:2230:1: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:2230:1: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:2231:1: ruleValidID
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
    // InternalSingleCodetemplateParser.g:2240:1: rule__Variable__TypeAssignment_2_1_3 : ( ruleValidID ) ;
    public final void rule__Variable__TypeAssignment_2_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2244:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:2245:1: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:2245:1: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:2246:1: ruleValidID
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
    // InternalSingleCodetemplateParser.g:2255:1: rule__Variable__ExpectingParametersAssignment_2_1_4_1 : ( ( LeftParenthesis ) ) ;
    public final void rule__Variable__ExpectingParametersAssignment_2_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2259:1: ( ( ( LeftParenthesis ) ) )
            // InternalSingleCodetemplateParser.g:2260:1: ( ( LeftParenthesis ) )
            {
            // InternalSingleCodetemplateParser.g:2260:1: ( ( LeftParenthesis ) )
            // InternalSingleCodetemplateParser.g:2261:1: ( LeftParenthesis )
            {
             before(grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0()); 
            // InternalSingleCodetemplateParser.g:2262:1: ( LeftParenthesis )
            // InternalSingleCodetemplateParser.g:2263:1: LeftParenthesis
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
    // InternalSingleCodetemplateParser.g:2278:1: rule__Variable__ParametersAssignment_2_1_4_3_0 : ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2282:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) ) )
            // InternalSingleCodetemplateParser.g:2283:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) )
            {
            // InternalSingleCodetemplateParser.g:2283:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) )
            // InternalSingleCodetemplateParser.g:2284:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_0_0()); 
            // InternalSingleCodetemplateParser.g:2285:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 )
            // InternalSingleCodetemplateParser.g:2285:2: rule__Variable__ParametersAlternatives_2_1_4_3_0_0
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
    // InternalSingleCodetemplateParser.g:2294:1: rule__Variable__ParametersAssignment_2_1_4_3_1_3 : ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_3_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2298:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) ) )
            // InternalSingleCodetemplateParser.g:2299:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) )
            {
            // InternalSingleCodetemplateParser.g:2299:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) )
            // InternalSingleCodetemplateParser.g:2300:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_1_3_0()); 
            // InternalSingleCodetemplateParser.g:2301:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 )
            // InternalSingleCodetemplateParser.g:2301:2: rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0
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
    // InternalSingleCodetemplateParser.g:2310:1: rule__Literal__ValueAssignment : ( ruleLiteralValue ) ;
    public final void rule__Literal__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2314:1: ( ( ruleLiteralValue ) )
            // InternalSingleCodetemplateParser.g:2315:1: ( ruleLiteralValue )
            {
            // InternalSingleCodetemplateParser.g:2315:1: ( ruleLiteralValue )
            // InternalSingleCodetemplateParser.g:2316:1: ruleLiteralValue
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
    // InternalSingleCodetemplateParser.g:2325:1: rule__Dollar__EscapedAssignment_1_0 : ( ( DollarSignDollarSign ) ) ;
    public final void rule__Dollar__EscapedAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalSingleCodetemplateParser.g:2329:1: ( ( ( DollarSignDollarSign ) ) )
            // InternalSingleCodetemplateParser.g:2330:1: ( ( DollarSignDollarSign ) )
            {
            // InternalSingleCodetemplateParser.g:2330:1: ( ( DollarSignDollarSign ) )
            // InternalSingleCodetemplateParser.g:2331:1: ( DollarSignDollarSign )
            {
             before(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 
            // InternalSingleCodetemplateParser.g:2332:1: ( DollarSignDollarSign )
            // InternalSingleCodetemplateParser.g:2333:1: DollarSignDollarSign
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


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA5_eotS =
        "\7\uffff";
    static final String DFA5_eofS =
        "\7\uffff";
    static final String DFA5_minS =
        "\1\4\3\16\1\uffff\1\16\1\uffff";
    static final String DFA5_maxS =
        "\1\20\3\22\1\uffff\1\22\1\uffff";
    static final String DFA5_acceptS =
        "\4\uffff\1\2\1\uffff\1\1";
    static final String DFA5_specialS =
        "\7\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\3\1\2\10\uffff\1\4\1\uffff\1\1",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "",
            "\1\4\1\6\2\uffff\1\5",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "537:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );";
        }
    }
    static final String DFA17_eotS =
        "\4\uffff";
    static final String DFA17_eofS =
        "\4\uffff";
    static final String DFA17_minS =
        "\2\12\2\uffff";
    static final String DFA17_maxS =
        "\2\22\2\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA17_specialS =
        "\4\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1425:1: ( rule__Variable__Group_2_1_4__0 )?";
        }
    }
    static final String DFA22_eotS =
        "\4\uffff";
    static final String DFA22_eofS =
        "\4\uffff";
    static final String DFA22_minS =
        "\2\13\2\uffff";
    static final String DFA22_maxS =
        "\2\22\2\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA22_specialS =
        "\4\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\2\1\3\5\uffff\1\1",
            "\1\2\1\3\5\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "()* loopback of 1710:1: ( rule__Variable__Group_2_1_4_3_1__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000D0002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000D02C0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000D0000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000054030L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000050030L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000070830L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000041002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000000000002C0L});

}
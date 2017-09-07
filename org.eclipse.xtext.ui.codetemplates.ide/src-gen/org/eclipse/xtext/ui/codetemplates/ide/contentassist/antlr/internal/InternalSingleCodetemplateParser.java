package org.eclipse.xtext.ui.codetemplates.ide.contentassist.antlr.internal;
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
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
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
    public static final int DollarSignDollarSign=6;
    public static final int DollarSignLeftCurlyBracket=7;
    public static final int Templates=4;
    public static final int RULE_STRING=17;
    public static final int Comma=12;
    public static final int LeftParenthesis=10;
    public static final int Colon=14;
    public static final int RightCurlyBracket=15;
    public static final int EOF=-1;
    public static final int FullStop=13;
    public static final int RULE_ID=16;
    public static final int RULE_WS=18;
    public static final int For=5;
    public static final int RightParenthesis=11;
    public static final int RULE_ANY_OTHER=19;
    public static final int GreaterThanSignGreaterThanSign=8;
    public static final int DollarSign=9;

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
    		tokenNameToValue.put("DollarSign", "'\\u0024'");
    		tokenNameToValue.put("LeftParenthesis", "'('");
    		tokenNameToValue.put("RightParenthesis", "')'");
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("RightCurlyBracket", "'}'");
    		tokenNameToValue.put("DollarSignDollarSign", "'\\u0024\\u0024'");
    		tokenNameToValue.put("DollarSignLeftCurlyBracket", "'\\u0024{'");
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
    // InternalSingleCodetemplateParser.g:67:1: entryRuleCodetemplates : ruleCodetemplates EOF ;
    public final void entryRuleCodetemplates() throws RecognitionException {
        try {
            // InternalSingleCodetemplateParser.g:68:1: ( ruleCodetemplates EOF )
            // InternalSingleCodetemplateParser.g:69:1: ruleCodetemplates EOF
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
    // InternalSingleCodetemplateParser.g:76:1: ruleCodetemplates : ( ( rule__Codetemplates__Group__0 ) ) ;
    public final void ruleCodetemplates() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:80:2: ( ( ( rule__Codetemplates__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:81:2: ( ( rule__Codetemplates__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:81:2: ( ( rule__Codetemplates__Group__0 ) )
            // InternalSingleCodetemplateParser.g:82:3: ( rule__Codetemplates__Group__0 )
            {
             before(grammarAccess.getCodetemplatesAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:83:3: ( rule__Codetemplates__Group__0 )
            // InternalSingleCodetemplateParser.g:83:4: rule__Codetemplates__Group__0
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
    // InternalSingleCodetemplateParser.g:92:1: entryRuleCodetemplate : ruleCodetemplate EOF ;
    public final void entryRuleCodetemplate() throws RecognitionException {
        try {
            // InternalSingleCodetemplateParser.g:93:1: ( ruleCodetemplate EOF )
            // InternalSingleCodetemplateParser.g:94:1: ruleCodetemplate EOF
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
    // InternalSingleCodetemplateParser.g:101:1: ruleCodetemplate : ( ( rule__Codetemplate__Group__0 ) ) ;
    public final void ruleCodetemplate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:105:2: ( ( ( rule__Codetemplate__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:106:2: ( ( rule__Codetemplate__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:106:2: ( ( rule__Codetemplate__Group__0 ) )
            // InternalSingleCodetemplateParser.g:107:3: ( rule__Codetemplate__Group__0 )
            {
             before(grammarAccess.getCodetemplateAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:108:3: ( rule__Codetemplate__Group__0 )
            // InternalSingleCodetemplateParser.g:108:4: rule__Codetemplate__Group__0
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
    // InternalSingleCodetemplateParser.g:117:1: entryRuleTemplateBodyWithQuotes : ruleTemplateBodyWithQuotes EOF ;
    public final void entryRuleTemplateBodyWithQuotes() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:121:1: ( ruleTemplateBodyWithQuotes EOF )
            // InternalSingleCodetemplateParser.g:122:1: ruleTemplateBodyWithQuotes EOF
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
    // InternalSingleCodetemplateParser.g:132:1: ruleTemplateBodyWithQuotes : ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) ;
    public final void ruleTemplateBodyWithQuotes() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:137:2: ( ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:138:2: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:138:2: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            // InternalSingleCodetemplateParser.g:139:3: ( rule__TemplateBodyWithQuotes__Group__0 )
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:140:3: ( rule__TemplateBodyWithQuotes__Group__0 )
            // InternalSingleCodetemplateParser.g:140:4: rule__TemplateBodyWithQuotes__Group__0
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
    // InternalSingleCodetemplateParser.g:150:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:154:1: ( ruleLiteralValue EOF )
            // InternalSingleCodetemplateParser.g:155:1: ruleLiteralValue EOF
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
    // InternalSingleCodetemplateParser.g:165:1: ruleLiteralValue : ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) ;
    public final void ruleLiteralValue() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:170:2: ( ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) )
            // InternalSingleCodetemplateParser.g:171:2: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            {
            // InternalSingleCodetemplateParser.g:171:2: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            // InternalSingleCodetemplateParser.g:172:3: ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* )
            {
            // InternalSingleCodetemplateParser.g:172:3: ( ( rule__LiteralValue__Alternatives ) )
            // InternalSingleCodetemplateParser.g:173:4: ( rule__LiteralValue__Alternatives )
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:174:4: ( rule__LiteralValue__Alternatives )
            // InternalSingleCodetemplateParser.g:174:5: rule__LiteralValue__Alternatives
            {
            pushFollow(FOLLOW_3);
            rule__LiteralValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralValueAccess().getAlternatives()); 

            }

            // InternalSingleCodetemplateParser.g:177:3: ( ( rule__LiteralValue__Alternatives )* )
            // InternalSingleCodetemplateParser.g:178:4: ( rule__LiteralValue__Alternatives )*
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:179:4: ( rule__LiteralValue__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=RULE_WS && LA1_0<=RULE_ANY_OTHER)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:179:5: rule__LiteralValue__Alternatives
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
    // InternalSingleCodetemplateParser.g:190:1: entryRuleTemplateBody : ruleTemplateBody EOF ;
    public final void entryRuleTemplateBody() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:194:1: ( ruleTemplateBody EOF )
            // InternalSingleCodetemplateParser.g:195:1: ruleTemplateBody EOF
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
    // InternalSingleCodetemplateParser.g:205:1: ruleTemplateBody : ( ( rule__TemplateBody__Group__0 ) ) ;
    public final void ruleTemplateBody() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:210:2: ( ( ( rule__TemplateBody__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:211:2: ( ( rule__TemplateBody__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:211:2: ( ( rule__TemplateBody__Group__0 ) )
            // InternalSingleCodetemplateParser.g:212:3: ( rule__TemplateBody__Group__0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:213:3: ( rule__TemplateBody__Group__0 )
            // InternalSingleCodetemplateParser.g:213:4: rule__TemplateBody__Group__0
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
    // InternalSingleCodetemplateParser.g:223:1: entryRuleVariableOrDollar : ruleVariableOrDollar EOF ;
    public final void entryRuleVariableOrDollar() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:227:1: ( ruleVariableOrDollar EOF )
            // InternalSingleCodetemplateParser.g:228:1: ruleVariableOrDollar EOF
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
    // InternalSingleCodetemplateParser.g:238:1: ruleVariableOrDollar : ( ( rule__VariableOrDollar__Alternatives ) ) ;
    public final void ruleVariableOrDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:243:2: ( ( ( rule__VariableOrDollar__Alternatives ) ) )
            // InternalSingleCodetemplateParser.g:244:2: ( ( rule__VariableOrDollar__Alternatives ) )
            {
            // InternalSingleCodetemplateParser.g:244:2: ( ( rule__VariableOrDollar__Alternatives ) )
            // InternalSingleCodetemplateParser.g:245:3: ( rule__VariableOrDollar__Alternatives )
            {
             before(grammarAccess.getVariableOrDollarAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:246:3: ( rule__VariableOrDollar__Alternatives )
            // InternalSingleCodetemplateParser.g:246:4: rule__VariableOrDollar__Alternatives
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
    // InternalSingleCodetemplateParser.g:256:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:260:1: ( ruleVariable EOF )
            // InternalSingleCodetemplateParser.g:261:1: ruleVariable EOF
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
    // InternalSingleCodetemplateParser.g:271:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:276:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:277:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:277:2: ( ( rule__Variable__Group__0 ) )
            // InternalSingleCodetemplateParser.g:278:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:279:3: ( rule__Variable__Group__0 )
            // InternalSingleCodetemplateParser.g:279:4: rule__Variable__Group__0
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
    // InternalSingleCodetemplateParser.g:289:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:293:1: ( ruleValidID EOF )
            // InternalSingleCodetemplateParser.g:294:1: ruleValidID EOF
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
    // InternalSingleCodetemplateParser.g:304:1: ruleValidID : ( ( rule__ValidID__Alternatives ) ) ;
    public final void ruleValidID() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:309:2: ( ( ( rule__ValidID__Alternatives ) ) )
            // InternalSingleCodetemplateParser.g:310:2: ( ( rule__ValidID__Alternatives ) )
            {
            // InternalSingleCodetemplateParser.g:310:2: ( ( rule__ValidID__Alternatives ) )
            // InternalSingleCodetemplateParser.g:311:3: ( rule__ValidID__Alternatives )
            {
             before(grammarAccess.getValidIDAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:312:3: ( rule__ValidID__Alternatives )
            // InternalSingleCodetemplateParser.g:312:4: rule__ValidID__Alternatives
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
    // InternalSingleCodetemplateParser.g:322:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:326:1: ( ruleFQN EOF )
            // InternalSingleCodetemplateParser.g:327:1: ruleFQN EOF
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
    // InternalSingleCodetemplateParser.g:337:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:342:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:343:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:343:2: ( ( rule__FQN__Group__0 ) )
            // InternalSingleCodetemplateParser.g:344:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:345:3: ( rule__FQN__Group__0 )
            // InternalSingleCodetemplateParser.g:345:4: rule__FQN__Group__0
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
    // InternalSingleCodetemplateParser.g:355:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:359:1: ( ruleLiteral EOF )
            // InternalSingleCodetemplateParser.g:360:1: ruleLiteral EOF
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
    // InternalSingleCodetemplateParser.g:370:1: ruleLiteral : ( ( rule__Literal__ValueAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:375:2: ( ( ( rule__Literal__ValueAssignment ) ) )
            // InternalSingleCodetemplateParser.g:376:2: ( ( rule__Literal__ValueAssignment ) )
            {
            // InternalSingleCodetemplateParser.g:376:2: ( ( rule__Literal__ValueAssignment ) )
            // InternalSingleCodetemplateParser.g:377:3: ( rule__Literal__ValueAssignment )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment()); 
            // InternalSingleCodetemplateParser.g:378:3: ( rule__Literal__ValueAssignment )
            // InternalSingleCodetemplateParser.g:378:4: rule__Literal__ValueAssignment
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
    // InternalSingleCodetemplateParser.g:388:1: entryRuleDollar : ruleDollar EOF ;
    public final void entryRuleDollar() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:392:1: ( ruleDollar EOF )
            // InternalSingleCodetemplateParser.g:393:1: ruleDollar EOF
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
    // InternalSingleCodetemplateParser.g:403:1: ruleDollar : ( ( rule__Dollar__Group__0 ) ) ;
    public final void ruleDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:408:2: ( ( ( rule__Dollar__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:409:2: ( ( rule__Dollar__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:409:2: ( ( rule__Dollar__Group__0 ) )
            // InternalSingleCodetemplateParser.g:410:3: ( rule__Dollar__Group__0 )
            {
             before(grammarAccess.getDollarAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:411:3: ( rule__Dollar__Group__0 )
            // InternalSingleCodetemplateParser.g:411:4: rule__Dollar__Group__0
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
    // InternalSingleCodetemplateParser.g:420:1: rule__Codetemplate__Alternatives_2 : ( ( ( rule__Codetemplate__ContextAssignment_2_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) ) );
    public final void rule__Codetemplate__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:424:1: ( ( ( rule__Codetemplate__ContextAssignment_2_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) ) )
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
                    // InternalSingleCodetemplateParser.g:425:2: ( ( rule__Codetemplate__ContextAssignment_2_0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:425:2: ( ( rule__Codetemplate__ContextAssignment_2_0 ) )
                    // InternalSingleCodetemplateParser.g:426:3: ( rule__Codetemplate__ContextAssignment_2_0 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getContextAssignment_2_0()); 
                    // InternalSingleCodetemplateParser.g:427:3: ( rule__Codetemplate__ContextAssignment_2_0 )
                    // InternalSingleCodetemplateParser.g:427:4: rule__Codetemplate__ContextAssignment_2_0
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
                    // InternalSingleCodetemplateParser.g:431:2: ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) )
                    {
                    // InternalSingleCodetemplateParser.g:431:2: ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) )
                    // InternalSingleCodetemplateParser.g:432:3: ( rule__Codetemplate__KeywordContextAssignment_2_1 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getKeywordContextAssignment_2_1()); 
                    // InternalSingleCodetemplateParser.g:433:3: ( rule__Codetemplate__KeywordContextAssignment_2_1 )
                    // InternalSingleCodetemplateParser.g:433:4: rule__Codetemplate__KeywordContextAssignment_2_1
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
    // InternalSingleCodetemplateParser.g:441:1: rule__LiteralValue__Alternatives : ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) );
    public final void rule__LiteralValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:445:1: ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) )
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
                    // InternalSingleCodetemplateParser.g:446:2: ( RULE_WS )
                    {
                    // InternalSingleCodetemplateParser.g:446:2: ( RULE_WS )
                    // InternalSingleCodetemplateParser.g:447:3: RULE_WS
                    {
                     before(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 
                    match(input,RULE_WS,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:452:2: ( RULE_ANY_OTHER )
                    {
                    // InternalSingleCodetemplateParser.g:452:2: ( RULE_ANY_OTHER )
                    // InternalSingleCodetemplateParser.g:453:3: RULE_ANY_OTHER
                    {
                     before(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 
                    match(input,RULE_ANY_OTHER,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSingleCodetemplateParser.g:458:2: ( RULE_ID )
                    {
                    // InternalSingleCodetemplateParser.g:458:2: ( RULE_ID )
                    // InternalSingleCodetemplateParser.g:459:3: RULE_ID
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
    // InternalSingleCodetemplateParser.g:468:1: rule__VariableOrDollar__Alternatives : ( ( ruleVariable ) | ( ruleDollar ) );
    public final void rule__VariableOrDollar__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:472:1: ( ( ruleVariable ) | ( ruleDollar ) )
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
                    // InternalSingleCodetemplateParser.g:473:2: ( ruleVariable )
                    {
                    // InternalSingleCodetemplateParser.g:473:2: ( ruleVariable )
                    // InternalSingleCodetemplateParser.g:474:3: ruleVariable
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
                    // InternalSingleCodetemplateParser.g:479:2: ( ruleDollar )
                    {
                    // InternalSingleCodetemplateParser.g:479:2: ( ruleDollar )
                    // InternalSingleCodetemplateParser.g:480:3: ruleDollar
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
    // InternalSingleCodetemplateParser.g:489:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );
    public final void rule__Variable__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:493:1: ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:494:2: ( ( rule__Variable__NameAssignment_2_0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:494:2: ( ( rule__Variable__NameAssignment_2_0 ) )
                    // InternalSingleCodetemplateParser.g:495:3: ( rule__Variable__NameAssignment_2_0 )
                    {
                     before(grammarAccess.getVariableAccess().getNameAssignment_2_0()); 
                    // InternalSingleCodetemplateParser.g:496:3: ( rule__Variable__NameAssignment_2_0 )
                    // InternalSingleCodetemplateParser.g:496:4: rule__Variable__NameAssignment_2_0
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
                    // InternalSingleCodetemplateParser.g:500:2: ( ( rule__Variable__Group_2_1__0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:500:2: ( ( rule__Variable__Group_2_1__0 ) )
                    // InternalSingleCodetemplateParser.g:501:3: ( rule__Variable__Group_2_1__0 )
                    {
                     before(grammarAccess.getVariableAccess().getGroup_2_1()); 
                    // InternalSingleCodetemplateParser.g:502:3: ( rule__Variable__Group_2_1__0 )
                    // InternalSingleCodetemplateParser.g:502:4: rule__Variable__Group_2_1__0
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
    // InternalSingleCodetemplateParser.g:510:1: rule__Variable__ParametersAlternatives_2_1_4_3_0_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_3_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:514:1: ( ( RULE_STRING ) | ( ruleFQN ) )
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
                    // InternalSingleCodetemplateParser.g:515:2: ( RULE_STRING )
                    {
                    // InternalSingleCodetemplateParser.g:515:2: ( RULE_STRING )
                    // InternalSingleCodetemplateParser.g:516:3: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:521:2: ( ruleFQN )
                    {
                    // InternalSingleCodetemplateParser.g:521:2: ( ruleFQN )
                    // InternalSingleCodetemplateParser.g:522:3: ruleFQN
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
    // InternalSingleCodetemplateParser.g:531:1: rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:535:1: ( ( RULE_STRING ) | ( ruleFQN ) )
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
                    // InternalSingleCodetemplateParser.g:536:2: ( RULE_STRING )
                    {
                    // InternalSingleCodetemplateParser.g:536:2: ( RULE_STRING )
                    // InternalSingleCodetemplateParser.g:537:3: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:542:2: ( ruleFQN )
                    {
                    // InternalSingleCodetemplateParser.g:542:2: ( ruleFQN )
                    // InternalSingleCodetemplateParser.g:543:3: ruleFQN
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
    // InternalSingleCodetemplateParser.g:552:1: rule__ValidID__Alternatives : ( ( RULE_ID ) | ( For ) | ( Templates ) );
    public final void rule__ValidID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:556:1: ( ( RULE_ID ) | ( For ) | ( Templates ) )
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
                    // InternalSingleCodetemplateParser.g:557:2: ( RULE_ID )
                    {
                    // InternalSingleCodetemplateParser.g:557:2: ( RULE_ID )
                    // InternalSingleCodetemplateParser.g:558:3: RULE_ID
                    {
                     before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:563:2: ( For )
                    {
                    // InternalSingleCodetemplateParser.g:563:2: ( For )
                    // InternalSingleCodetemplateParser.g:564:3: For
                    {
                     before(grammarAccess.getValidIDAccess().getForKeyword_1()); 
                    match(input,For,FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getForKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSingleCodetemplateParser.g:569:2: ( Templates )
                    {
                    // InternalSingleCodetemplateParser.g:569:2: ( Templates )
                    // InternalSingleCodetemplateParser.g:570:3: Templates
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
    // InternalSingleCodetemplateParser.g:579:1: rule__Dollar__Alternatives_1 : ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( DollarSign ) );
    public final void rule__Dollar__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:583:1: ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( DollarSign ) )
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
                    // InternalSingleCodetemplateParser.g:584:2: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:584:2: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    // InternalSingleCodetemplateParser.g:585:3: ( rule__Dollar__EscapedAssignment_1_0 )
                    {
                     before(grammarAccess.getDollarAccess().getEscapedAssignment_1_0()); 
                    // InternalSingleCodetemplateParser.g:586:3: ( rule__Dollar__EscapedAssignment_1_0 )
                    // InternalSingleCodetemplateParser.g:586:4: rule__Dollar__EscapedAssignment_1_0
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
                    // InternalSingleCodetemplateParser.g:590:2: ( DollarSign )
                    {
                    // InternalSingleCodetemplateParser.g:590:2: ( DollarSign )
                    // InternalSingleCodetemplateParser.g:591:3: DollarSign
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
    // InternalSingleCodetemplateParser.g:600:1: rule__Codetemplates__Group__0 : rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 ;
    public final void rule__Codetemplates__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:604:1: ( rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 )
            // InternalSingleCodetemplateParser.g:605:2: rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1
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
    // InternalSingleCodetemplateParser.g:612:1: rule__Codetemplates__Group__0__Impl : ( Templates ) ;
    public final void rule__Codetemplates__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:616:1: ( ( Templates ) )
            // InternalSingleCodetemplateParser.g:617:1: ( Templates )
            {
            // InternalSingleCodetemplateParser.g:617:1: ( Templates )
            // InternalSingleCodetemplateParser.g:618:2: Templates
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
    // InternalSingleCodetemplateParser.g:627:1: rule__Codetemplates__Group__1 : rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 ;
    public final void rule__Codetemplates__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:631:1: ( rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 )
            // InternalSingleCodetemplateParser.g:632:2: rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2
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
    // InternalSingleCodetemplateParser.g:639:1: rule__Codetemplates__Group__1__Impl : ( For ) ;
    public final void rule__Codetemplates__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:643:1: ( ( For ) )
            // InternalSingleCodetemplateParser.g:644:1: ( For )
            {
            // InternalSingleCodetemplateParser.g:644:1: ( For )
            // InternalSingleCodetemplateParser.g:645:2: For
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
    // InternalSingleCodetemplateParser.g:654:1: rule__Codetemplates__Group__2 : rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 ;
    public final void rule__Codetemplates__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:658:1: ( rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 )
            // InternalSingleCodetemplateParser.g:659:2: rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3
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
    // InternalSingleCodetemplateParser.g:666:1: rule__Codetemplates__Group__2__Impl : ( ( rule__Codetemplates__LanguageAssignment_2 ) ) ;
    public final void rule__Codetemplates__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:670:1: ( ( ( rule__Codetemplates__LanguageAssignment_2 ) ) )
            // InternalSingleCodetemplateParser.g:671:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            {
            // InternalSingleCodetemplateParser.g:671:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            // InternalSingleCodetemplateParser.g:672:2: ( rule__Codetemplates__LanguageAssignment_2 )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageAssignment_2()); 
            // InternalSingleCodetemplateParser.g:673:2: ( rule__Codetemplates__LanguageAssignment_2 )
            // InternalSingleCodetemplateParser.g:673:3: rule__Codetemplates__LanguageAssignment_2
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
    // InternalSingleCodetemplateParser.g:681:1: rule__Codetemplates__Group__3 : rule__Codetemplates__Group__3__Impl ;
    public final void rule__Codetemplates__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:685:1: ( rule__Codetemplates__Group__3__Impl )
            // InternalSingleCodetemplateParser.g:686:2: rule__Codetemplates__Group__3__Impl
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
    // InternalSingleCodetemplateParser.g:692:1: rule__Codetemplates__Group__3__Impl : ( ( rule__Codetemplates__TemplatesAssignment_3 ) ) ;
    public final void rule__Codetemplates__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:696:1: ( ( ( rule__Codetemplates__TemplatesAssignment_3 ) ) )
            // InternalSingleCodetemplateParser.g:697:1: ( ( rule__Codetemplates__TemplatesAssignment_3 ) )
            {
            // InternalSingleCodetemplateParser.g:697:1: ( ( rule__Codetemplates__TemplatesAssignment_3 ) )
            // InternalSingleCodetemplateParser.g:698:2: ( rule__Codetemplates__TemplatesAssignment_3 )
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesAssignment_3()); 
            // InternalSingleCodetemplateParser.g:699:2: ( rule__Codetemplates__TemplatesAssignment_3 )
            // InternalSingleCodetemplateParser.g:699:3: rule__Codetemplates__TemplatesAssignment_3
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
    // InternalSingleCodetemplateParser.g:708:1: rule__Codetemplate__Group__0 : rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 ;
    public final void rule__Codetemplate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:712:1: ( rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 )
            // InternalSingleCodetemplateParser.g:713:2: rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1
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
    // InternalSingleCodetemplateParser.g:720:1: rule__Codetemplate__Group__0__Impl : ( ( rule__Codetemplate__NameAssignment_0 ) ) ;
    public final void rule__Codetemplate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:724:1: ( ( ( rule__Codetemplate__NameAssignment_0 ) ) )
            // InternalSingleCodetemplateParser.g:725:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            {
            // InternalSingleCodetemplateParser.g:725:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            // InternalSingleCodetemplateParser.g:726:2: ( rule__Codetemplate__NameAssignment_0 )
            {
             before(grammarAccess.getCodetemplateAccess().getNameAssignment_0()); 
            // InternalSingleCodetemplateParser.g:727:2: ( rule__Codetemplate__NameAssignment_0 )
            // InternalSingleCodetemplateParser.g:727:3: rule__Codetemplate__NameAssignment_0
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
    // InternalSingleCodetemplateParser.g:735:1: rule__Codetemplate__Group__1 : rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 ;
    public final void rule__Codetemplate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:739:1: ( rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 )
            // InternalSingleCodetemplateParser.g:740:2: rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2
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
    // InternalSingleCodetemplateParser.g:747:1: rule__Codetemplate__Group__1__Impl : ( For ) ;
    public final void rule__Codetemplate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:751:1: ( ( For ) )
            // InternalSingleCodetemplateParser.g:752:1: ( For )
            {
            // InternalSingleCodetemplateParser.g:752:1: ( For )
            // InternalSingleCodetemplateParser.g:753:2: For
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
    // InternalSingleCodetemplateParser.g:762:1: rule__Codetemplate__Group__2 : rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 ;
    public final void rule__Codetemplate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:766:1: ( rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 )
            // InternalSingleCodetemplateParser.g:767:2: rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3
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
    // InternalSingleCodetemplateParser.g:774:1: rule__Codetemplate__Group__2__Impl : ( ( rule__Codetemplate__Alternatives_2 ) ) ;
    public final void rule__Codetemplate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:778:1: ( ( ( rule__Codetemplate__Alternatives_2 ) ) )
            // InternalSingleCodetemplateParser.g:779:1: ( ( rule__Codetemplate__Alternatives_2 ) )
            {
            // InternalSingleCodetemplateParser.g:779:1: ( ( rule__Codetemplate__Alternatives_2 ) )
            // InternalSingleCodetemplateParser.g:780:2: ( rule__Codetemplate__Alternatives_2 )
            {
             before(grammarAccess.getCodetemplateAccess().getAlternatives_2()); 
            // InternalSingleCodetemplateParser.g:781:2: ( rule__Codetemplate__Alternatives_2 )
            // InternalSingleCodetemplateParser.g:781:3: rule__Codetemplate__Alternatives_2
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
    // InternalSingleCodetemplateParser.g:789:1: rule__Codetemplate__Group__3 : rule__Codetemplate__Group__3__Impl ;
    public final void rule__Codetemplate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:793:1: ( rule__Codetemplate__Group__3__Impl )
            // InternalSingleCodetemplateParser.g:794:2: rule__Codetemplate__Group__3__Impl
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
    // InternalSingleCodetemplateParser.g:800:1: rule__Codetemplate__Group__3__Impl : ( ( rule__Codetemplate__BodyAssignment_3 ) ) ;
    public final void rule__Codetemplate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:804:1: ( ( ( rule__Codetemplate__BodyAssignment_3 ) ) )
            // InternalSingleCodetemplateParser.g:805:1: ( ( rule__Codetemplate__BodyAssignment_3 ) )
            {
            // InternalSingleCodetemplateParser.g:805:1: ( ( rule__Codetemplate__BodyAssignment_3 ) )
            // InternalSingleCodetemplateParser.g:806:2: ( rule__Codetemplate__BodyAssignment_3 )
            {
             before(grammarAccess.getCodetemplateAccess().getBodyAssignment_3()); 
            // InternalSingleCodetemplateParser.g:807:2: ( rule__Codetemplate__BodyAssignment_3 )
            // InternalSingleCodetemplateParser.g:807:3: rule__Codetemplate__BodyAssignment_3
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
    // InternalSingleCodetemplateParser.g:816:1: rule__TemplateBodyWithQuotes__Group__0 : rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 ;
    public final void rule__TemplateBodyWithQuotes__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:820:1: ( rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 )
            // InternalSingleCodetemplateParser.g:821:2: rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1
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
    // InternalSingleCodetemplateParser.g:828:1: rule__TemplateBodyWithQuotes__Group__0__Impl : ( GreaterThanSignGreaterThanSign ) ;
    public final void rule__TemplateBodyWithQuotes__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:832:1: ( ( GreaterThanSignGreaterThanSign ) )
            // InternalSingleCodetemplateParser.g:833:1: ( GreaterThanSignGreaterThanSign )
            {
            // InternalSingleCodetemplateParser.g:833:1: ( GreaterThanSignGreaterThanSign )
            // InternalSingleCodetemplateParser.g:834:2: GreaterThanSignGreaterThanSign
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
    // InternalSingleCodetemplateParser.g:843:1: rule__TemplateBodyWithQuotes__Group__1 : rule__TemplateBodyWithQuotes__Group__1__Impl ;
    public final void rule__TemplateBodyWithQuotes__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:847:1: ( rule__TemplateBodyWithQuotes__Group__1__Impl )
            // InternalSingleCodetemplateParser.g:848:2: rule__TemplateBodyWithQuotes__Group__1__Impl
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
    // InternalSingleCodetemplateParser.g:854:1: rule__TemplateBodyWithQuotes__Group__1__Impl : ( ruleTemplateBody ) ;
    public final void rule__TemplateBodyWithQuotes__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:858:1: ( ( ruleTemplateBody ) )
            // InternalSingleCodetemplateParser.g:859:1: ( ruleTemplateBody )
            {
            // InternalSingleCodetemplateParser.g:859:1: ( ruleTemplateBody )
            // InternalSingleCodetemplateParser.g:860:2: ruleTemplateBody
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
    // InternalSingleCodetemplateParser.g:870:1: rule__TemplateBody__Group__0 : rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 ;
    public final void rule__TemplateBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:874:1: ( rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 )
            // InternalSingleCodetemplateParser.g:875:2: rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1
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
    // InternalSingleCodetemplateParser.g:882:1: rule__TemplateBody__Group__0__Impl : ( () ) ;
    public final void rule__TemplateBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:886:1: ( ( () ) )
            // InternalSingleCodetemplateParser.g:887:1: ( () )
            {
            // InternalSingleCodetemplateParser.g:887:1: ( () )
            // InternalSingleCodetemplateParser.g:888:2: ()
            {
             before(grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0()); 
            // InternalSingleCodetemplateParser.g:889:2: ()
            // InternalSingleCodetemplateParser.g:889:3: 
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
    // InternalSingleCodetemplateParser.g:897:1: rule__TemplateBody__Group__1 : rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 ;
    public final void rule__TemplateBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:901:1: ( rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 )
            // InternalSingleCodetemplateParser.g:902:2: rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2
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
    // InternalSingleCodetemplateParser.g:909:1: rule__TemplateBody__Group__1__Impl : ( ( rule__TemplateBody__PartsAssignment_1 )? ) ;
    public final void rule__TemplateBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:913:1: ( ( ( rule__TemplateBody__PartsAssignment_1 )? ) )
            // InternalSingleCodetemplateParser.g:914:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            {
            // InternalSingleCodetemplateParser.g:914:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            // InternalSingleCodetemplateParser.g:915:2: ( rule__TemplateBody__PartsAssignment_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_1()); 
            // InternalSingleCodetemplateParser.g:916:2: ( rule__TemplateBody__PartsAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||(LA10_0>=RULE_WS && LA10_0<=RULE_ANY_OTHER)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:916:3: rule__TemplateBody__PartsAssignment_1
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
    // InternalSingleCodetemplateParser.g:924:1: rule__TemplateBody__Group__2 : rule__TemplateBody__Group__2__Impl ;
    public final void rule__TemplateBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:928:1: ( rule__TemplateBody__Group__2__Impl )
            // InternalSingleCodetemplateParser.g:929:2: rule__TemplateBody__Group__2__Impl
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
    // InternalSingleCodetemplateParser.g:935:1: rule__TemplateBody__Group__2__Impl : ( ( rule__TemplateBody__Group_2__0 )* ) ;
    public final void rule__TemplateBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:939:1: ( ( ( rule__TemplateBody__Group_2__0 )* ) )
            // InternalSingleCodetemplateParser.g:940:1: ( ( rule__TemplateBody__Group_2__0 )* )
            {
            // InternalSingleCodetemplateParser.g:940:1: ( ( rule__TemplateBody__Group_2__0 )* )
            // InternalSingleCodetemplateParser.g:941:2: ( rule__TemplateBody__Group_2__0 )*
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup_2()); 
            // InternalSingleCodetemplateParser.g:942:2: ( rule__TemplateBody__Group_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=DollarSignDollarSign && LA11_0<=DollarSignLeftCurlyBracket)||LA11_0==DollarSign) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:942:3: rule__TemplateBody__Group_2__0
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
    // InternalSingleCodetemplateParser.g:951:1: rule__TemplateBody__Group_2__0 : rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 ;
    public final void rule__TemplateBody__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:955:1: ( rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 )
            // InternalSingleCodetemplateParser.g:956:2: rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1
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
    // InternalSingleCodetemplateParser.g:963:1: rule__TemplateBody__Group_2__0__Impl : ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) ;
    public final void rule__TemplateBody__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:967:1: ( ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) )
            // InternalSingleCodetemplateParser.g:968:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            {
            // InternalSingleCodetemplateParser.g:968:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            // InternalSingleCodetemplateParser.g:969:2: ( rule__TemplateBody__PartsAssignment_2_0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_0()); 
            // InternalSingleCodetemplateParser.g:970:2: ( rule__TemplateBody__PartsAssignment_2_0 )
            // InternalSingleCodetemplateParser.g:970:3: rule__TemplateBody__PartsAssignment_2_0
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
    // InternalSingleCodetemplateParser.g:978:1: rule__TemplateBody__Group_2__1 : rule__TemplateBody__Group_2__1__Impl ;
    public final void rule__TemplateBody__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:982:1: ( rule__TemplateBody__Group_2__1__Impl )
            // InternalSingleCodetemplateParser.g:983:2: rule__TemplateBody__Group_2__1__Impl
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
    // InternalSingleCodetemplateParser.g:989:1: rule__TemplateBody__Group_2__1__Impl : ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) ;
    public final void rule__TemplateBody__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:993:1: ( ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) )
            // InternalSingleCodetemplateParser.g:994:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            {
            // InternalSingleCodetemplateParser.g:994:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            // InternalSingleCodetemplateParser.g:995:2: ( rule__TemplateBody__PartsAssignment_2_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_1()); 
            // InternalSingleCodetemplateParser.g:996:2: ( rule__TemplateBody__PartsAssignment_2_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||(LA12_0>=RULE_WS && LA12_0<=RULE_ANY_OTHER)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:996:3: rule__TemplateBody__PartsAssignment_2_1
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
    // InternalSingleCodetemplateParser.g:1005:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1009:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalSingleCodetemplateParser.g:1010:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
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
    // InternalSingleCodetemplateParser.g:1017:1: rule__Variable__Group__0__Impl : ( DollarSignLeftCurlyBracket ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1021:1: ( ( DollarSignLeftCurlyBracket ) )
            // InternalSingleCodetemplateParser.g:1022:1: ( DollarSignLeftCurlyBracket )
            {
            // InternalSingleCodetemplateParser.g:1022:1: ( DollarSignLeftCurlyBracket )
            // InternalSingleCodetemplateParser.g:1023:2: DollarSignLeftCurlyBracket
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
    // InternalSingleCodetemplateParser.g:1032:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1036:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalSingleCodetemplateParser.g:1037:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
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
    // InternalSingleCodetemplateParser.g:1044:1: rule__Variable__Group__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1048:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1049:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1049:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1050:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_1()); 
            // InternalSingleCodetemplateParser.g:1051:2: ( RULE_WS )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1051:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1059:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1063:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalSingleCodetemplateParser.g:1064:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
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
    // InternalSingleCodetemplateParser.g:1071:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Alternatives_2 ) ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1075:1: ( ( ( rule__Variable__Alternatives_2 ) ) )
            // InternalSingleCodetemplateParser.g:1076:1: ( ( rule__Variable__Alternatives_2 ) )
            {
            // InternalSingleCodetemplateParser.g:1076:1: ( ( rule__Variable__Alternatives_2 ) )
            // InternalSingleCodetemplateParser.g:1077:2: ( rule__Variable__Alternatives_2 )
            {
             before(grammarAccess.getVariableAccess().getAlternatives_2()); 
            // InternalSingleCodetemplateParser.g:1078:2: ( rule__Variable__Alternatives_2 )
            // InternalSingleCodetemplateParser.g:1078:3: rule__Variable__Alternatives_2
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
    // InternalSingleCodetemplateParser.g:1086:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl rule__Variable__Group__4 ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1090:1: ( rule__Variable__Group__3__Impl rule__Variable__Group__4 )
            // InternalSingleCodetemplateParser.g:1091:2: rule__Variable__Group__3__Impl rule__Variable__Group__4
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
    // InternalSingleCodetemplateParser.g:1098:1: rule__Variable__Group__3__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1102:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1103:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1103:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1104:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_3()); 
            // InternalSingleCodetemplateParser.g:1105:2: ( RULE_WS )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_WS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1105:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1113:1: rule__Variable__Group__4 : rule__Variable__Group__4__Impl ;
    public final void rule__Variable__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1117:1: ( rule__Variable__Group__4__Impl )
            // InternalSingleCodetemplateParser.g:1118:2: rule__Variable__Group__4__Impl
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
    // InternalSingleCodetemplateParser.g:1124:1: rule__Variable__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__Variable__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1128:1: ( ( RightCurlyBracket ) )
            // InternalSingleCodetemplateParser.g:1129:1: ( RightCurlyBracket )
            {
            // InternalSingleCodetemplateParser.g:1129:1: ( RightCurlyBracket )
            // InternalSingleCodetemplateParser.g:1130:2: RightCurlyBracket
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
    // InternalSingleCodetemplateParser.g:1140:1: rule__Variable__Group_2_1__0 : rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 ;
    public final void rule__Variable__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1144:1: ( rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 )
            // InternalSingleCodetemplateParser.g:1145:2: rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1
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
    // InternalSingleCodetemplateParser.g:1152:1: rule__Variable__Group_2_1__0__Impl : ( ( rule__Variable__Group_2_1_0__0 )? ) ;
    public final void rule__Variable__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1156:1: ( ( ( rule__Variable__Group_2_1_0__0 )? ) )
            // InternalSingleCodetemplateParser.g:1157:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            {
            // InternalSingleCodetemplateParser.g:1157:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            // InternalSingleCodetemplateParser.g:1158:2: ( rule__Variable__Group_2_1_0__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_0()); 
            // InternalSingleCodetemplateParser.g:1159:2: ( rule__Variable__Group_2_1_0__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=Templates && LA15_0<=For)||LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1159:3: rule__Variable__Group_2_1_0__0
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
    // InternalSingleCodetemplateParser.g:1167:1: rule__Variable__Group_2_1__1 : rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 ;
    public final void rule__Variable__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1171:1: ( rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 )
            // InternalSingleCodetemplateParser.g:1172:2: rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2
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
    // InternalSingleCodetemplateParser.g:1179:1: rule__Variable__Group_2_1__1__Impl : ( Colon ) ;
    public final void rule__Variable__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1183:1: ( ( Colon ) )
            // InternalSingleCodetemplateParser.g:1184:1: ( Colon )
            {
            // InternalSingleCodetemplateParser.g:1184:1: ( Colon )
            // InternalSingleCodetemplateParser.g:1185:2: Colon
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
    // InternalSingleCodetemplateParser.g:1194:1: rule__Variable__Group_2_1__2 : rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 ;
    public final void rule__Variable__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1198:1: ( rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 )
            // InternalSingleCodetemplateParser.g:1199:2: rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3
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
    // InternalSingleCodetemplateParser.g:1206:1: rule__Variable__Group_2_1__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1210:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1211:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1211:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1212:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2()); 
            // InternalSingleCodetemplateParser.g:1213:2: ( RULE_WS )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_WS) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1213:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1221:1: rule__Variable__Group_2_1__3 : rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 ;
    public final void rule__Variable__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1225:1: ( rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 )
            // InternalSingleCodetemplateParser.g:1226:2: rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4
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
    // InternalSingleCodetemplateParser.g:1233:1: rule__Variable__Group_2_1__3__Impl : ( ( rule__Variable__TypeAssignment_2_1_3 ) ) ;
    public final void rule__Variable__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1237:1: ( ( ( rule__Variable__TypeAssignment_2_1_3 ) ) )
            // InternalSingleCodetemplateParser.g:1238:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            {
            // InternalSingleCodetemplateParser.g:1238:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            // InternalSingleCodetemplateParser.g:1239:2: ( rule__Variable__TypeAssignment_2_1_3 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_2_1_3()); 
            // InternalSingleCodetemplateParser.g:1240:2: ( rule__Variable__TypeAssignment_2_1_3 )
            // InternalSingleCodetemplateParser.g:1240:3: rule__Variable__TypeAssignment_2_1_3
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
    // InternalSingleCodetemplateParser.g:1248:1: rule__Variable__Group_2_1__4 : rule__Variable__Group_2_1__4__Impl ;
    public final void rule__Variable__Group_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1252:1: ( rule__Variable__Group_2_1__4__Impl )
            // InternalSingleCodetemplateParser.g:1253:2: rule__Variable__Group_2_1__4__Impl
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
    // InternalSingleCodetemplateParser.g:1259:1: rule__Variable__Group_2_1__4__Impl : ( ( rule__Variable__Group_2_1_4__0 )? ) ;
    public final void rule__Variable__Group_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1263:1: ( ( ( rule__Variable__Group_2_1_4__0 )? ) )
            // InternalSingleCodetemplateParser.g:1264:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            {
            // InternalSingleCodetemplateParser.g:1264:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            // InternalSingleCodetemplateParser.g:1265:2: ( rule__Variable__Group_2_1_4__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4()); 
            // InternalSingleCodetemplateParser.g:1266:2: ( rule__Variable__Group_2_1_4__0 )?
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1266:3: rule__Variable__Group_2_1_4__0
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
    // InternalSingleCodetemplateParser.g:1275:1: rule__Variable__Group_2_1_0__0 : rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 ;
    public final void rule__Variable__Group_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1279:1: ( rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 )
            // InternalSingleCodetemplateParser.g:1280:2: rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1
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
    // InternalSingleCodetemplateParser.g:1287:1: rule__Variable__Group_2_1_0__0__Impl : ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) ;
    public final void rule__Variable__Group_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1291:1: ( ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) )
            // InternalSingleCodetemplateParser.g:1292:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            {
            // InternalSingleCodetemplateParser.g:1292:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            // InternalSingleCodetemplateParser.g:1293:2: ( rule__Variable__NameAssignment_2_1_0_0 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_2_1_0_0()); 
            // InternalSingleCodetemplateParser.g:1294:2: ( rule__Variable__NameAssignment_2_1_0_0 )
            // InternalSingleCodetemplateParser.g:1294:3: rule__Variable__NameAssignment_2_1_0_0
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
    // InternalSingleCodetemplateParser.g:1302:1: rule__Variable__Group_2_1_0__1 : rule__Variable__Group_2_1_0__1__Impl ;
    public final void rule__Variable__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1306:1: ( rule__Variable__Group_2_1_0__1__Impl )
            // InternalSingleCodetemplateParser.g:1307:2: rule__Variable__Group_2_1_0__1__Impl
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
    // InternalSingleCodetemplateParser.g:1313:1: rule__Variable__Group_2_1_0__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1317:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1318:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1318:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1319:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1()); 
            // InternalSingleCodetemplateParser.g:1320:2: ( RULE_WS )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_WS) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1320:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1329:1: rule__Variable__Group_2_1_4__0 : rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 ;
    public final void rule__Variable__Group_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1333:1: ( rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 )
            // InternalSingleCodetemplateParser.g:1334:2: rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1
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
    // InternalSingleCodetemplateParser.g:1341:1: rule__Variable__Group_2_1_4__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1345:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1346:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1346:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1347:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0()); 
            // InternalSingleCodetemplateParser.g:1348:2: ( RULE_WS )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_WS) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1348:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1356:1: rule__Variable__Group_2_1_4__1 : rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 ;
    public final void rule__Variable__Group_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1360:1: ( rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 )
            // InternalSingleCodetemplateParser.g:1361:2: rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2
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
    // InternalSingleCodetemplateParser.g:1368:1: rule__Variable__Group_2_1_4__1__Impl : ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) ) ;
    public final void rule__Variable__Group_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1372:1: ( ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) ) )
            // InternalSingleCodetemplateParser.g:1373:1: ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) )
            {
            // InternalSingleCodetemplateParser.g:1373:1: ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) )
            // InternalSingleCodetemplateParser.g:1374:2: ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 )
            {
             before(grammarAccess.getVariableAccess().getExpectingParametersAssignment_2_1_4_1()); 
            // InternalSingleCodetemplateParser.g:1375:2: ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 )
            // InternalSingleCodetemplateParser.g:1375:3: rule__Variable__ExpectingParametersAssignment_2_1_4_1
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
    // InternalSingleCodetemplateParser.g:1383:1: rule__Variable__Group_2_1_4__2 : rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 ;
    public final void rule__Variable__Group_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1387:1: ( rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 )
            // InternalSingleCodetemplateParser.g:1388:2: rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3
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
    // InternalSingleCodetemplateParser.g:1395:1: rule__Variable__Group_2_1_4__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1399:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1400:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1400:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1401:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2()); 
            // InternalSingleCodetemplateParser.g:1402:2: ( RULE_WS )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_WS) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1402:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1410:1: rule__Variable__Group_2_1_4__3 : rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 ;
    public final void rule__Variable__Group_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1414:1: ( rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 )
            // InternalSingleCodetemplateParser.g:1415:2: rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4
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
    // InternalSingleCodetemplateParser.g:1422:1: rule__Variable__Group_2_1_4__3__Impl : ( ( rule__Variable__Group_2_1_4_3__0 )? ) ;
    public final void rule__Variable__Group_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1426:1: ( ( ( rule__Variable__Group_2_1_4_3__0 )? ) )
            // InternalSingleCodetemplateParser.g:1427:1: ( ( rule__Variable__Group_2_1_4_3__0 )? )
            {
            // InternalSingleCodetemplateParser.g:1427:1: ( ( rule__Variable__Group_2_1_4_3__0 )? )
            // InternalSingleCodetemplateParser.g:1428:2: ( rule__Variable__Group_2_1_4_3__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4_3()); 
            // InternalSingleCodetemplateParser.g:1429:2: ( rule__Variable__Group_2_1_4_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=Templates && LA21_0<=For)||(LA21_0>=RULE_ID && LA21_0<=RULE_STRING)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1429:3: rule__Variable__Group_2_1_4_3__0
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
    // InternalSingleCodetemplateParser.g:1437:1: rule__Variable__Group_2_1_4__4 : rule__Variable__Group_2_1_4__4__Impl ;
    public final void rule__Variable__Group_2_1_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1441:1: ( rule__Variable__Group_2_1_4__4__Impl )
            // InternalSingleCodetemplateParser.g:1442:2: rule__Variable__Group_2_1_4__4__Impl
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
    // InternalSingleCodetemplateParser.g:1448:1: rule__Variable__Group_2_1_4__4__Impl : ( RightParenthesis ) ;
    public final void rule__Variable__Group_2_1_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1452:1: ( ( RightParenthesis ) )
            // InternalSingleCodetemplateParser.g:1453:1: ( RightParenthesis )
            {
            // InternalSingleCodetemplateParser.g:1453:1: ( RightParenthesis )
            // InternalSingleCodetemplateParser.g:1454:2: RightParenthesis
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
    // InternalSingleCodetemplateParser.g:1464:1: rule__Variable__Group_2_1_4_3__0 : rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1 ;
    public final void rule__Variable__Group_2_1_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1468:1: ( rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1 )
            // InternalSingleCodetemplateParser.g:1469:2: rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1
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
    // InternalSingleCodetemplateParser.g:1476:1: rule__Variable__Group_2_1_4_3__0__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) ) ;
    public final void rule__Variable__Group_2_1_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1480:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) ) )
            // InternalSingleCodetemplateParser.g:1481:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) )
            {
            // InternalSingleCodetemplateParser.g:1481:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) )
            // InternalSingleCodetemplateParser.g:1482:2: ( rule__Variable__ParametersAssignment_2_1_4_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_0()); 
            // InternalSingleCodetemplateParser.g:1483:2: ( rule__Variable__ParametersAssignment_2_1_4_3_0 )
            // InternalSingleCodetemplateParser.g:1483:3: rule__Variable__ParametersAssignment_2_1_4_3_0
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
    // InternalSingleCodetemplateParser.g:1491:1: rule__Variable__Group_2_1_4_3__1 : rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2 ;
    public final void rule__Variable__Group_2_1_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1495:1: ( rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2 )
            // InternalSingleCodetemplateParser.g:1496:2: rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2
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
    // InternalSingleCodetemplateParser.g:1503:1: rule__Variable__Group_2_1_4_3__1__Impl : ( ( rule__Variable__Group_2_1_4_3_1__0 )* ) ;
    public final void rule__Variable__Group_2_1_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1507:1: ( ( ( rule__Variable__Group_2_1_4_3_1__0 )* ) )
            // InternalSingleCodetemplateParser.g:1508:1: ( ( rule__Variable__Group_2_1_4_3_1__0 )* )
            {
            // InternalSingleCodetemplateParser.g:1508:1: ( ( rule__Variable__Group_2_1_4_3_1__0 )* )
            // InternalSingleCodetemplateParser.g:1509:2: ( rule__Variable__Group_2_1_4_3_1__0 )*
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4_3_1()); 
            // InternalSingleCodetemplateParser.g:1510:2: ( rule__Variable__Group_2_1_4_3_1__0 )*
            loop22:
            do {
                int alt22=2;
                alt22 = dfa22.predict(input);
                switch (alt22) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1510:3: rule__Variable__Group_2_1_4_3_1__0
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
    // InternalSingleCodetemplateParser.g:1518:1: rule__Variable__Group_2_1_4_3__2 : rule__Variable__Group_2_1_4_3__2__Impl ;
    public final void rule__Variable__Group_2_1_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1522:1: ( rule__Variable__Group_2_1_4_3__2__Impl )
            // InternalSingleCodetemplateParser.g:1523:2: rule__Variable__Group_2_1_4_3__2__Impl
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
    // InternalSingleCodetemplateParser.g:1529:1: rule__Variable__Group_2_1_4_3__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1533:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1534:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1534:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1535:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_2()); 
            // InternalSingleCodetemplateParser.g:1536:2: ( RULE_WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1536:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1545:1: rule__Variable__Group_2_1_4_3_1__0 : rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1 ;
    public final void rule__Variable__Group_2_1_4_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1549:1: ( rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1 )
            // InternalSingleCodetemplateParser.g:1550:2: rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1
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
    // InternalSingleCodetemplateParser.g:1557:1: rule__Variable__Group_2_1_4_3_1__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1561:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1562:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1562:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1563:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_0()); 
            // InternalSingleCodetemplateParser.g:1564:2: ( RULE_WS )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_WS) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1564:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1572:1: rule__Variable__Group_2_1_4_3_1__1 : rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2 ;
    public final void rule__Variable__Group_2_1_4_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1576:1: ( rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2 )
            // InternalSingleCodetemplateParser.g:1577:2: rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2
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
    // InternalSingleCodetemplateParser.g:1584:1: rule__Variable__Group_2_1_4_3_1__1__Impl : ( Comma ) ;
    public final void rule__Variable__Group_2_1_4_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1588:1: ( ( Comma ) )
            // InternalSingleCodetemplateParser.g:1589:1: ( Comma )
            {
            // InternalSingleCodetemplateParser.g:1589:1: ( Comma )
            // InternalSingleCodetemplateParser.g:1590:2: Comma
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
    // InternalSingleCodetemplateParser.g:1599:1: rule__Variable__Group_2_1_4_3_1__2 : rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3 ;
    public final void rule__Variable__Group_2_1_4_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1603:1: ( rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3 )
            // InternalSingleCodetemplateParser.g:1604:2: rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3
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
    // InternalSingleCodetemplateParser.g:1611:1: rule__Variable__Group_2_1_4_3_1__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1615:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1616:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1616:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1617:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_2()); 
            // InternalSingleCodetemplateParser.g:1618:2: ( RULE_WS )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_WS) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1618:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1626:1: rule__Variable__Group_2_1_4_3_1__3 : rule__Variable__Group_2_1_4_3_1__3__Impl ;
    public final void rule__Variable__Group_2_1_4_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1630:1: ( rule__Variable__Group_2_1_4_3_1__3__Impl )
            // InternalSingleCodetemplateParser.g:1631:2: rule__Variable__Group_2_1_4_3_1__3__Impl
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
    // InternalSingleCodetemplateParser.g:1637:1: rule__Variable__Group_2_1_4_3_1__3__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) ) ;
    public final void rule__Variable__Group_2_1_4_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1641:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) ) )
            // InternalSingleCodetemplateParser.g:1642:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) )
            {
            // InternalSingleCodetemplateParser.g:1642:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) )
            // InternalSingleCodetemplateParser.g:1643:2: ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_1_3()); 
            // InternalSingleCodetemplateParser.g:1644:2: ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 )
            // InternalSingleCodetemplateParser.g:1644:3: rule__Variable__ParametersAssignment_2_1_4_3_1_3
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
    // InternalSingleCodetemplateParser.g:1653:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1657:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalSingleCodetemplateParser.g:1658:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
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
    // InternalSingleCodetemplateParser.g:1665:1: rule__FQN__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1669:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1670:1: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1670:1: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1671:2: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1680:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1684:1: ( rule__FQN__Group__1__Impl )
            // InternalSingleCodetemplateParser.g:1685:2: rule__FQN__Group__1__Impl
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
    // InternalSingleCodetemplateParser.g:1691:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1695:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalSingleCodetemplateParser.g:1696:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalSingleCodetemplateParser.g:1696:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalSingleCodetemplateParser.g:1697:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalSingleCodetemplateParser.g:1698:2: ( rule__FQN__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==FullStop) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1698:3: rule__FQN__Group_1__0
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
    // InternalSingleCodetemplateParser.g:1707:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1711:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalSingleCodetemplateParser.g:1712:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalSingleCodetemplateParser.g:1719:1: rule__FQN__Group_1__0__Impl : ( FullStop ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1723:1: ( ( FullStop ) )
            // InternalSingleCodetemplateParser.g:1724:1: ( FullStop )
            {
            // InternalSingleCodetemplateParser.g:1724:1: ( FullStop )
            // InternalSingleCodetemplateParser.g:1725:2: FullStop
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
    // InternalSingleCodetemplateParser.g:1734:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1738:1: ( rule__FQN__Group_1__1__Impl )
            // InternalSingleCodetemplateParser.g:1739:2: rule__FQN__Group_1__1__Impl
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
    // InternalSingleCodetemplateParser.g:1745:1: rule__FQN__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1749:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1750:1: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1750:1: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1751:2: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1761:1: rule__Dollar__Group__0 : rule__Dollar__Group__0__Impl rule__Dollar__Group__1 ;
    public final void rule__Dollar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1765:1: ( rule__Dollar__Group__0__Impl rule__Dollar__Group__1 )
            // InternalSingleCodetemplateParser.g:1766:2: rule__Dollar__Group__0__Impl rule__Dollar__Group__1
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
    // InternalSingleCodetemplateParser.g:1773:1: rule__Dollar__Group__0__Impl : ( () ) ;
    public final void rule__Dollar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1777:1: ( ( () ) )
            // InternalSingleCodetemplateParser.g:1778:1: ( () )
            {
            // InternalSingleCodetemplateParser.g:1778:1: ( () )
            // InternalSingleCodetemplateParser.g:1779:2: ()
            {
             before(grammarAccess.getDollarAccess().getDollarAction_0()); 
            // InternalSingleCodetemplateParser.g:1780:2: ()
            // InternalSingleCodetemplateParser.g:1780:3: 
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
    // InternalSingleCodetemplateParser.g:1788:1: rule__Dollar__Group__1 : rule__Dollar__Group__1__Impl ;
    public final void rule__Dollar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1792:1: ( rule__Dollar__Group__1__Impl )
            // InternalSingleCodetemplateParser.g:1793:2: rule__Dollar__Group__1__Impl
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
    // InternalSingleCodetemplateParser.g:1799:1: rule__Dollar__Group__1__Impl : ( ( rule__Dollar__Alternatives_1 ) ) ;
    public final void rule__Dollar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1803:1: ( ( ( rule__Dollar__Alternatives_1 ) ) )
            // InternalSingleCodetemplateParser.g:1804:1: ( ( rule__Dollar__Alternatives_1 ) )
            {
            // InternalSingleCodetemplateParser.g:1804:1: ( ( rule__Dollar__Alternatives_1 ) )
            // InternalSingleCodetemplateParser.g:1805:2: ( rule__Dollar__Alternatives_1 )
            {
             before(grammarAccess.getDollarAccess().getAlternatives_1()); 
            // InternalSingleCodetemplateParser.g:1806:2: ( rule__Dollar__Alternatives_1 )
            // InternalSingleCodetemplateParser.g:1806:3: rule__Dollar__Alternatives_1
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
    // InternalSingleCodetemplateParser.g:1815:1: rule__Codetemplates__LanguageAssignment_2 : ( ( ruleFQN ) ) ;
    public final void rule__Codetemplates__LanguageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1819:1: ( ( ( ruleFQN ) ) )
            // InternalSingleCodetemplateParser.g:1820:2: ( ( ruleFQN ) )
            {
            // InternalSingleCodetemplateParser.g:1820:2: ( ( ruleFQN ) )
            // InternalSingleCodetemplateParser.g:1821:3: ( ruleFQN )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0()); 
            // InternalSingleCodetemplateParser.g:1822:3: ( ruleFQN )
            // InternalSingleCodetemplateParser.g:1823:4: ruleFQN
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
    // InternalSingleCodetemplateParser.g:1834:1: rule__Codetemplates__TemplatesAssignment_3 : ( ruleCodetemplate ) ;
    public final void rule__Codetemplates__TemplatesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1838:1: ( ( ruleCodetemplate ) )
            // InternalSingleCodetemplateParser.g:1839:2: ( ruleCodetemplate )
            {
            // InternalSingleCodetemplateParser.g:1839:2: ( ruleCodetemplate )
            // InternalSingleCodetemplateParser.g:1840:3: ruleCodetemplate
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
    // InternalSingleCodetemplateParser.g:1849:1: rule__Codetemplate__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1853:1: ( ( RULE_STRING ) )
            // InternalSingleCodetemplateParser.g:1854:2: ( RULE_STRING )
            {
            // InternalSingleCodetemplateParser.g:1854:2: ( RULE_STRING )
            // InternalSingleCodetemplateParser.g:1855:3: RULE_STRING
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
    // InternalSingleCodetemplateParser.g:1864:1: rule__Codetemplate__ContextAssignment_2_0 : ( ( ruleValidID ) ) ;
    public final void rule__Codetemplate__ContextAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1868:1: ( ( ( ruleValidID ) ) )
            // InternalSingleCodetemplateParser.g:1869:2: ( ( ruleValidID ) )
            {
            // InternalSingleCodetemplateParser.g:1869:2: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1870:3: ( ruleValidID )
            {
             before(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_2_0_0()); 
            // InternalSingleCodetemplateParser.g:1871:3: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1872:4: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1883:1: rule__Codetemplate__KeywordContextAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__KeywordContextAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1887:1: ( ( RULE_STRING ) )
            // InternalSingleCodetemplateParser.g:1888:2: ( RULE_STRING )
            {
            // InternalSingleCodetemplateParser.g:1888:2: ( RULE_STRING )
            // InternalSingleCodetemplateParser.g:1889:3: RULE_STRING
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
    // InternalSingleCodetemplateParser.g:1898:1: rule__Codetemplate__BodyAssignment_3 : ( ruleTemplateBodyWithQuotes ) ;
    public final void rule__Codetemplate__BodyAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1902:1: ( ( ruleTemplateBodyWithQuotes ) )
            // InternalSingleCodetemplateParser.g:1903:2: ( ruleTemplateBodyWithQuotes )
            {
            // InternalSingleCodetemplateParser.g:1903:2: ( ruleTemplateBodyWithQuotes )
            // InternalSingleCodetemplateParser.g:1904:3: ruleTemplateBodyWithQuotes
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
    // InternalSingleCodetemplateParser.g:1913:1: rule__TemplateBody__PartsAssignment_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1917:1: ( ( ruleLiteral ) )
            // InternalSingleCodetemplateParser.g:1918:2: ( ruleLiteral )
            {
            // InternalSingleCodetemplateParser.g:1918:2: ( ruleLiteral )
            // InternalSingleCodetemplateParser.g:1919:3: ruleLiteral
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
    // InternalSingleCodetemplateParser.g:1928:1: rule__TemplateBody__PartsAssignment_2_0 : ( ruleVariableOrDollar ) ;
    public final void rule__TemplateBody__PartsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1932:1: ( ( ruleVariableOrDollar ) )
            // InternalSingleCodetemplateParser.g:1933:2: ( ruleVariableOrDollar )
            {
            // InternalSingleCodetemplateParser.g:1933:2: ( ruleVariableOrDollar )
            // InternalSingleCodetemplateParser.g:1934:3: ruleVariableOrDollar
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
    // InternalSingleCodetemplateParser.g:1943:1: rule__TemplateBody__PartsAssignment_2_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1947:1: ( ( ruleLiteral ) )
            // InternalSingleCodetemplateParser.g:1948:2: ( ruleLiteral )
            {
            // InternalSingleCodetemplateParser.g:1948:2: ( ruleLiteral )
            // InternalSingleCodetemplateParser.g:1949:3: ruleLiteral
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
    // InternalSingleCodetemplateParser.g:1958:1: rule__Variable__NameAssignment_2_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1962:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1963:2: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1963:2: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1964:3: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1973:1: rule__Variable__NameAssignment_2_1_0_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1977:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1978:2: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1978:2: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1979:3: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1988:1: rule__Variable__TypeAssignment_2_1_3 : ( ruleValidID ) ;
    public final void rule__Variable__TypeAssignment_2_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1992:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1993:2: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1993:2: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1994:3: ruleValidID
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
    // InternalSingleCodetemplateParser.g:2003:1: rule__Variable__ExpectingParametersAssignment_2_1_4_1 : ( ( LeftParenthesis ) ) ;
    public final void rule__Variable__ExpectingParametersAssignment_2_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:2007:1: ( ( ( LeftParenthesis ) ) )
            // InternalSingleCodetemplateParser.g:2008:2: ( ( LeftParenthesis ) )
            {
            // InternalSingleCodetemplateParser.g:2008:2: ( ( LeftParenthesis ) )
            // InternalSingleCodetemplateParser.g:2009:3: ( LeftParenthesis )
            {
             before(grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0()); 
            // InternalSingleCodetemplateParser.g:2010:3: ( LeftParenthesis )
            // InternalSingleCodetemplateParser.g:2011:4: LeftParenthesis
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
    // InternalSingleCodetemplateParser.g:2022:1: rule__Variable__ParametersAssignment_2_1_4_3_0 : ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:2026:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) ) )
            // InternalSingleCodetemplateParser.g:2027:2: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) )
            {
            // InternalSingleCodetemplateParser.g:2027:2: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) )
            // InternalSingleCodetemplateParser.g:2028:3: ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_0_0()); 
            // InternalSingleCodetemplateParser.g:2029:3: ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 )
            // InternalSingleCodetemplateParser.g:2029:4: rule__Variable__ParametersAlternatives_2_1_4_3_0_0
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
    // InternalSingleCodetemplateParser.g:2037:1: rule__Variable__ParametersAssignment_2_1_4_3_1_3 : ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_3_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:2041:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) ) )
            // InternalSingleCodetemplateParser.g:2042:2: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) )
            {
            // InternalSingleCodetemplateParser.g:2042:2: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) )
            // InternalSingleCodetemplateParser.g:2043:3: ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_1_3_0()); 
            // InternalSingleCodetemplateParser.g:2044:3: ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 )
            // InternalSingleCodetemplateParser.g:2044:4: rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0
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
    // InternalSingleCodetemplateParser.g:2052:1: rule__Literal__ValueAssignment : ( ruleLiteralValue ) ;
    public final void rule__Literal__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:2056:1: ( ( ruleLiteralValue ) )
            // InternalSingleCodetemplateParser.g:2057:2: ( ruleLiteralValue )
            {
            // InternalSingleCodetemplateParser.g:2057:2: ( ruleLiteralValue )
            // InternalSingleCodetemplateParser.g:2058:3: ruleLiteralValue
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
    // InternalSingleCodetemplateParser.g:2067:1: rule__Dollar__EscapedAssignment_1_0 : ( ( DollarSignDollarSign ) ) ;
    public final void rule__Dollar__EscapedAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:2071:1: ( ( ( DollarSignDollarSign ) ) )
            // InternalSingleCodetemplateParser.g:2072:2: ( ( DollarSignDollarSign ) )
            {
            // InternalSingleCodetemplateParser.g:2072:2: ( ( DollarSignDollarSign ) )
            // InternalSingleCodetemplateParser.g:2073:3: ( DollarSignDollarSign )
            {
             before(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 
            // InternalSingleCodetemplateParser.g:2074:3: ( DollarSignDollarSign )
            // InternalSingleCodetemplateParser.g:2075:4: DollarSignDollarSign
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
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\4\3\16\1\uffff\1\16\1\uffff";
    static final String dfa_3s = "\1\20\3\22\1\uffff\1\22\1\uffff";
    static final String dfa_4s = "\4\uffff\1\2\1\uffff\1\1";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\3\1\2\10\uffff\1\4\1\uffff\1\1",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "",
            "\1\4\1\6\2\uffff\1\5",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "489:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );";
        }
    }
    static final String dfa_7s = "\4\uffff";
    static final String dfa_8s = "\2\12\2\uffff";
    static final String dfa_9s = "\2\22\2\uffff";
    static final String dfa_10s = "\2\uffff\1\1\1\2";
    static final String dfa_11s = "\4\uffff}>";
    static final String[] dfa_12s = {
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1266:2: ( rule__Variable__Group_2_1_4__0 )?";
        }
    }
    static final String dfa_13s = "\2\13\2\uffff";
    static final String dfa_14s = "\2\uffff\1\2\1\1";
    static final String[] dfa_15s = {
            "\1\2\1\3\5\uffff\1\1",
            "\1\2\1\3\5\uffff\1\1",
            "",
            ""
    };
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[][] dfa_15 = unpackEncodedStringArray(dfa_15s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_13;
            this.max = dfa_9;
            this.accept = dfa_14;
            this.special = dfa_11;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "()* loopback of 1510:2: ( rule__Variable__Group_2_1_4_3_1__0 )*";
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
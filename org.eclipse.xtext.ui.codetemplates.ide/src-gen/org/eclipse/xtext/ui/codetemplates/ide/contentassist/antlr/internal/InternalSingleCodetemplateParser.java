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

/*******************************************************************************
 * Copyright (c) 2015, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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
    // InternalSingleCodetemplateParser.g:72:1: entryRuleCodetemplates : ruleCodetemplates EOF ;
    public final void entryRuleCodetemplates() throws RecognitionException {
        try {
            // InternalSingleCodetemplateParser.g:73:1: ( ruleCodetemplates EOF )
            // InternalSingleCodetemplateParser.g:74:1: ruleCodetemplates EOF
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
    // InternalSingleCodetemplateParser.g:81:1: ruleCodetemplates : ( ( rule__Codetemplates__Group__0 ) ) ;
    public final void ruleCodetemplates() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:85:2: ( ( ( rule__Codetemplates__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:86:2: ( ( rule__Codetemplates__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:86:2: ( ( rule__Codetemplates__Group__0 ) )
            // InternalSingleCodetemplateParser.g:87:3: ( rule__Codetemplates__Group__0 )
            {
             before(grammarAccess.getCodetemplatesAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:88:3: ( rule__Codetemplates__Group__0 )
            // InternalSingleCodetemplateParser.g:88:4: rule__Codetemplates__Group__0
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
    // InternalSingleCodetemplateParser.g:97:1: entryRuleCodetemplate : ruleCodetemplate EOF ;
    public final void entryRuleCodetemplate() throws RecognitionException {
        try {
            // InternalSingleCodetemplateParser.g:98:1: ( ruleCodetemplate EOF )
            // InternalSingleCodetemplateParser.g:99:1: ruleCodetemplate EOF
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
    // InternalSingleCodetemplateParser.g:106:1: ruleCodetemplate : ( ( rule__Codetemplate__Group__0 ) ) ;
    public final void ruleCodetemplate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:110:2: ( ( ( rule__Codetemplate__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:111:2: ( ( rule__Codetemplate__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:111:2: ( ( rule__Codetemplate__Group__0 ) )
            // InternalSingleCodetemplateParser.g:112:3: ( rule__Codetemplate__Group__0 )
            {
             before(grammarAccess.getCodetemplateAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:113:3: ( rule__Codetemplate__Group__0 )
            // InternalSingleCodetemplateParser.g:113:4: rule__Codetemplate__Group__0
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
    // InternalSingleCodetemplateParser.g:122:1: entryRuleTemplateBodyWithQuotes : ruleTemplateBodyWithQuotes EOF ;
    public final void entryRuleTemplateBodyWithQuotes() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:126:1: ( ruleTemplateBodyWithQuotes EOF )
            // InternalSingleCodetemplateParser.g:127:1: ruleTemplateBodyWithQuotes EOF
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
    // InternalSingleCodetemplateParser.g:137:1: ruleTemplateBodyWithQuotes : ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) ;
    public final void ruleTemplateBodyWithQuotes() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:142:2: ( ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:143:2: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:143:2: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            // InternalSingleCodetemplateParser.g:144:3: ( rule__TemplateBodyWithQuotes__Group__0 )
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:145:3: ( rule__TemplateBodyWithQuotes__Group__0 )
            // InternalSingleCodetemplateParser.g:145:4: rule__TemplateBodyWithQuotes__Group__0
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
    // InternalSingleCodetemplateParser.g:155:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:159:1: ( ruleLiteralValue EOF )
            // InternalSingleCodetemplateParser.g:160:1: ruleLiteralValue EOF
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
    // InternalSingleCodetemplateParser.g:170:1: ruleLiteralValue : ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) ;
    public final void ruleLiteralValue() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:175:2: ( ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) )
            // InternalSingleCodetemplateParser.g:176:2: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            {
            // InternalSingleCodetemplateParser.g:176:2: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            // InternalSingleCodetemplateParser.g:177:3: ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* )
            {
            // InternalSingleCodetemplateParser.g:177:3: ( ( rule__LiteralValue__Alternatives ) )
            // InternalSingleCodetemplateParser.g:178:4: ( rule__LiteralValue__Alternatives )
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:179:4: ( rule__LiteralValue__Alternatives )
            // InternalSingleCodetemplateParser.g:179:5: rule__LiteralValue__Alternatives
            {
            pushFollow(FOLLOW_3);
            rule__LiteralValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralValueAccess().getAlternatives()); 

            }

            // InternalSingleCodetemplateParser.g:182:3: ( ( rule__LiteralValue__Alternatives )* )
            // InternalSingleCodetemplateParser.g:183:4: ( rule__LiteralValue__Alternatives )*
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:184:4: ( rule__LiteralValue__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=RULE_WS && LA1_0<=RULE_ANY_OTHER)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:184:5: rule__LiteralValue__Alternatives
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
    // InternalSingleCodetemplateParser.g:195:1: entryRuleTemplateBody : ruleTemplateBody EOF ;
    public final void entryRuleTemplateBody() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:199:1: ( ruleTemplateBody EOF )
            // InternalSingleCodetemplateParser.g:200:1: ruleTemplateBody EOF
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
    // InternalSingleCodetemplateParser.g:210:1: ruleTemplateBody : ( ( rule__TemplateBody__Group__0 ) ) ;
    public final void ruleTemplateBody() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:215:2: ( ( ( rule__TemplateBody__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:216:2: ( ( rule__TemplateBody__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:216:2: ( ( rule__TemplateBody__Group__0 ) )
            // InternalSingleCodetemplateParser.g:217:3: ( rule__TemplateBody__Group__0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:218:3: ( rule__TemplateBody__Group__0 )
            // InternalSingleCodetemplateParser.g:218:4: rule__TemplateBody__Group__0
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
    // InternalSingleCodetemplateParser.g:228:1: entryRuleVariableOrDollar : ruleVariableOrDollar EOF ;
    public final void entryRuleVariableOrDollar() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:232:1: ( ruleVariableOrDollar EOF )
            // InternalSingleCodetemplateParser.g:233:1: ruleVariableOrDollar EOF
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
    // InternalSingleCodetemplateParser.g:243:1: ruleVariableOrDollar : ( ( rule__VariableOrDollar__Alternatives ) ) ;
    public final void ruleVariableOrDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:248:2: ( ( ( rule__VariableOrDollar__Alternatives ) ) )
            // InternalSingleCodetemplateParser.g:249:2: ( ( rule__VariableOrDollar__Alternatives ) )
            {
            // InternalSingleCodetemplateParser.g:249:2: ( ( rule__VariableOrDollar__Alternatives ) )
            // InternalSingleCodetemplateParser.g:250:3: ( rule__VariableOrDollar__Alternatives )
            {
             before(grammarAccess.getVariableOrDollarAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:251:3: ( rule__VariableOrDollar__Alternatives )
            // InternalSingleCodetemplateParser.g:251:4: rule__VariableOrDollar__Alternatives
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
    // InternalSingleCodetemplateParser.g:261:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:265:1: ( ruleVariable EOF )
            // InternalSingleCodetemplateParser.g:266:1: ruleVariable EOF
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
    // InternalSingleCodetemplateParser.g:276:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:281:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:282:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:282:2: ( ( rule__Variable__Group__0 ) )
            // InternalSingleCodetemplateParser.g:283:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:284:3: ( rule__Variable__Group__0 )
            // InternalSingleCodetemplateParser.g:284:4: rule__Variable__Group__0
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
    // InternalSingleCodetemplateParser.g:294:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:298:1: ( ruleValidID EOF )
            // InternalSingleCodetemplateParser.g:299:1: ruleValidID EOF
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
    // InternalSingleCodetemplateParser.g:309:1: ruleValidID : ( ( rule__ValidID__Alternatives ) ) ;
    public final void ruleValidID() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:314:2: ( ( ( rule__ValidID__Alternatives ) ) )
            // InternalSingleCodetemplateParser.g:315:2: ( ( rule__ValidID__Alternatives ) )
            {
            // InternalSingleCodetemplateParser.g:315:2: ( ( rule__ValidID__Alternatives ) )
            // InternalSingleCodetemplateParser.g:316:3: ( rule__ValidID__Alternatives )
            {
             before(grammarAccess.getValidIDAccess().getAlternatives()); 
            // InternalSingleCodetemplateParser.g:317:3: ( rule__ValidID__Alternatives )
            // InternalSingleCodetemplateParser.g:317:4: rule__ValidID__Alternatives
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
    // InternalSingleCodetemplateParser.g:327:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:331:1: ( ruleFQN EOF )
            // InternalSingleCodetemplateParser.g:332:1: ruleFQN EOF
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
    // InternalSingleCodetemplateParser.g:342:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:347:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:348:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:348:2: ( ( rule__FQN__Group__0 ) )
            // InternalSingleCodetemplateParser.g:349:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:350:3: ( rule__FQN__Group__0 )
            // InternalSingleCodetemplateParser.g:350:4: rule__FQN__Group__0
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
    // InternalSingleCodetemplateParser.g:360:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:364:1: ( ruleLiteral EOF )
            // InternalSingleCodetemplateParser.g:365:1: ruleLiteral EOF
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
    // InternalSingleCodetemplateParser.g:375:1: ruleLiteral : ( ( rule__Literal__ValueAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:380:2: ( ( ( rule__Literal__ValueAssignment ) ) )
            // InternalSingleCodetemplateParser.g:381:2: ( ( rule__Literal__ValueAssignment ) )
            {
            // InternalSingleCodetemplateParser.g:381:2: ( ( rule__Literal__ValueAssignment ) )
            // InternalSingleCodetemplateParser.g:382:3: ( rule__Literal__ValueAssignment )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment()); 
            // InternalSingleCodetemplateParser.g:383:3: ( rule__Literal__ValueAssignment )
            // InternalSingleCodetemplateParser.g:383:4: rule__Literal__ValueAssignment
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
    // InternalSingleCodetemplateParser.g:393:1: entryRuleDollar : ruleDollar EOF ;
    public final void entryRuleDollar() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:397:1: ( ruleDollar EOF )
            // InternalSingleCodetemplateParser.g:398:1: ruleDollar EOF
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
    // InternalSingleCodetemplateParser.g:408:1: ruleDollar : ( ( rule__Dollar__Group__0 ) ) ;
    public final void ruleDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:413:2: ( ( ( rule__Dollar__Group__0 ) ) )
            // InternalSingleCodetemplateParser.g:414:2: ( ( rule__Dollar__Group__0 ) )
            {
            // InternalSingleCodetemplateParser.g:414:2: ( ( rule__Dollar__Group__0 ) )
            // InternalSingleCodetemplateParser.g:415:3: ( rule__Dollar__Group__0 )
            {
             before(grammarAccess.getDollarAccess().getGroup()); 
            // InternalSingleCodetemplateParser.g:416:3: ( rule__Dollar__Group__0 )
            // InternalSingleCodetemplateParser.g:416:4: rule__Dollar__Group__0
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
    // InternalSingleCodetemplateParser.g:425:1: rule__Codetemplate__Alternatives_2 : ( ( ( rule__Codetemplate__ContextAssignment_2_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) ) );
    public final void rule__Codetemplate__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:429:1: ( ( ( rule__Codetemplate__ContextAssignment_2_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) ) )
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
                    // InternalSingleCodetemplateParser.g:430:2: ( ( rule__Codetemplate__ContextAssignment_2_0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:430:2: ( ( rule__Codetemplate__ContextAssignment_2_0 ) )
                    // InternalSingleCodetemplateParser.g:431:3: ( rule__Codetemplate__ContextAssignment_2_0 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getContextAssignment_2_0()); 
                    // InternalSingleCodetemplateParser.g:432:3: ( rule__Codetemplate__ContextAssignment_2_0 )
                    // InternalSingleCodetemplateParser.g:432:4: rule__Codetemplate__ContextAssignment_2_0
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
                    // InternalSingleCodetemplateParser.g:436:2: ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) )
                    {
                    // InternalSingleCodetemplateParser.g:436:2: ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) )
                    // InternalSingleCodetemplateParser.g:437:3: ( rule__Codetemplate__KeywordContextAssignment_2_1 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getKeywordContextAssignment_2_1()); 
                    // InternalSingleCodetemplateParser.g:438:3: ( rule__Codetemplate__KeywordContextAssignment_2_1 )
                    // InternalSingleCodetemplateParser.g:438:4: rule__Codetemplate__KeywordContextAssignment_2_1
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
    // InternalSingleCodetemplateParser.g:446:1: rule__LiteralValue__Alternatives : ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) );
    public final void rule__LiteralValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:450:1: ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) )
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
                    // InternalSingleCodetemplateParser.g:451:2: ( RULE_WS )
                    {
                    // InternalSingleCodetemplateParser.g:451:2: ( RULE_WS )
                    // InternalSingleCodetemplateParser.g:452:3: RULE_WS
                    {
                     before(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 
                    match(input,RULE_WS,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:457:2: ( RULE_ANY_OTHER )
                    {
                    // InternalSingleCodetemplateParser.g:457:2: ( RULE_ANY_OTHER )
                    // InternalSingleCodetemplateParser.g:458:3: RULE_ANY_OTHER
                    {
                     before(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 
                    match(input,RULE_ANY_OTHER,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSingleCodetemplateParser.g:463:2: ( RULE_ID )
                    {
                    // InternalSingleCodetemplateParser.g:463:2: ( RULE_ID )
                    // InternalSingleCodetemplateParser.g:464:3: RULE_ID
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
    // InternalSingleCodetemplateParser.g:473:1: rule__VariableOrDollar__Alternatives : ( ( ruleVariable ) | ( ruleDollar ) );
    public final void rule__VariableOrDollar__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:477:1: ( ( ruleVariable ) | ( ruleDollar ) )
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
                    // InternalSingleCodetemplateParser.g:478:2: ( ruleVariable )
                    {
                    // InternalSingleCodetemplateParser.g:478:2: ( ruleVariable )
                    // InternalSingleCodetemplateParser.g:479:3: ruleVariable
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
                    // InternalSingleCodetemplateParser.g:484:2: ( ruleDollar )
                    {
                    // InternalSingleCodetemplateParser.g:484:2: ( ruleDollar )
                    // InternalSingleCodetemplateParser.g:485:3: ruleDollar
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
    // InternalSingleCodetemplateParser.g:494:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );
    public final void rule__Variable__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:498:1: ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:499:2: ( ( rule__Variable__NameAssignment_2_0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:499:2: ( ( rule__Variable__NameAssignment_2_0 ) )
                    // InternalSingleCodetemplateParser.g:500:3: ( rule__Variable__NameAssignment_2_0 )
                    {
                     before(grammarAccess.getVariableAccess().getNameAssignment_2_0()); 
                    // InternalSingleCodetemplateParser.g:501:3: ( rule__Variable__NameAssignment_2_0 )
                    // InternalSingleCodetemplateParser.g:501:4: rule__Variable__NameAssignment_2_0
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
                    // InternalSingleCodetemplateParser.g:505:2: ( ( rule__Variable__Group_2_1__0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:505:2: ( ( rule__Variable__Group_2_1__0 ) )
                    // InternalSingleCodetemplateParser.g:506:3: ( rule__Variable__Group_2_1__0 )
                    {
                     before(grammarAccess.getVariableAccess().getGroup_2_1()); 
                    // InternalSingleCodetemplateParser.g:507:3: ( rule__Variable__Group_2_1__0 )
                    // InternalSingleCodetemplateParser.g:507:4: rule__Variable__Group_2_1__0
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
    // InternalSingleCodetemplateParser.g:515:1: rule__Variable__ParametersAlternatives_2_1_4_3_0_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_3_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:519:1: ( ( RULE_STRING ) | ( ruleFQN ) )
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
                    // InternalSingleCodetemplateParser.g:520:2: ( RULE_STRING )
                    {
                    // InternalSingleCodetemplateParser.g:520:2: ( RULE_STRING )
                    // InternalSingleCodetemplateParser.g:521:3: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:526:2: ( ruleFQN )
                    {
                    // InternalSingleCodetemplateParser.g:526:2: ( ruleFQN )
                    // InternalSingleCodetemplateParser.g:527:3: ruleFQN
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
    // InternalSingleCodetemplateParser.g:536:1: rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:540:1: ( ( RULE_STRING ) | ( ruleFQN ) )
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
                    // InternalSingleCodetemplateParser.g:541:2: ( RULE_STRING )
                    {
                    // InternalSingleCodetemplateParser.g:541:2: ( RULE_STRING )
                    // InternalSingleCodetemplateParser.g:542:3: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:547:2: ( ruleFQN )
                    {
                    // InternalSingleCodetemplateParser.g:547:2: ( ruleFQN )
                    // InternalSingleCodetemplateParser.g:548:3: ruleFQN
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
    // InternalSingleCodetemplateParser.g:557:1: rule__ValidID__Alternatives : ( ( RULE_ID ) | ( For ) | ( Templates ) );
    public final void rule__ValidID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:561:1: ( ( RULE_ID ) | ( For ) | ( Templates ) )
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
                    // InternalSingleCodetemplateParser.g:562:2: ( RULE_ID )
                    {
                    // InternalSingleCodetemplateParser.g:562:2: ( RULE_ID )
                    // InternalSingleCodetemplateParser.g:563:3: RULE_ID
                    {
                     before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:568:2: ( For )
                    {
                    // InternalSingleCodetemplateParser.g:568:2: ( For )
                    // InternalSingleCodetemplateParser.g:569:3: For
                    {
                     before(grammarAccess.getValidIDAccess().getForKeyword_1()); 
                    match(input,For,FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getForKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSingleCodetemplateParser.g:574:2: ( Templates )
                    {
                    // InternalSingleCodetemplateParser.g:574:2: ( Templates )
                    // InternalSingleCodetemplateParser.g:575:3: Templates
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
    // InternalSingleCodetemplateParser.g:584:1: rule__Dollar__Alternatives_1 : ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( DollarSign ) );
    public final void rule__Dollar__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:588:1: ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( DollarSign ) )
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
                    // InternalSingleCodetemplateParser.g:589:2: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    {
                    // InternalSingleCodetemplateParser.g:589:2: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    // InternalSingleCodetemplateParser.g:590:3: ( rule__Dollar__EscapedAssignment_1_0 )
                    {
                     before(grammarAccess.getDollarAccess().getEscapedAssignment_1_0()); 
                    // InternalSingleCodetemplateParser.g:591:3: ( rule__Dollar__EscapedAssignment_1_0 )
                    // InternalSingleCodetemplateParser.g:591:4: rule__Dollar__EscapedAssignment_1_0
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
                    // InternalSingleCodetemplateParser.g:595:2: ( DollarSign )
                    {
                    // InternalSingleCodetemplateParser.g:595:2: ( DollarSign )
                    // InternalSingleCodetemplateParser.g:596:3: DollarSign
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
    // InternalSingleCodetemplateParser.g:605:1: rule__Codetemplates__Group__0 : rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 ;
    public final void rule__Codetemplates__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:609:1: ( rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 )
            // InternalSingleCodetemplateParser.g:610:2: rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1
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
    // InternalSingleCodetemplateParser.g:617:1: rule__Codetemplates__Group__0__Impl : ( Templates ) ;
    public final void rule__Codetemplates__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:621:1: ( ( Templates ) )
            // InternalSingleCodetemplateParser.g:622:1: ( Templates )
            {
            // InternalSingleCodetemplateParser.g:622:1: ( Templates )
            // InternalSingleCodetemplateParser.g:623:2: Templates
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
    // InternalSingleCodetemplateParser.g:632:1: rule__Codetemplates__Group__1 : rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 ;
    public final void rule__Codetemplates__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:636:1: ( rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 )
            // InternalSingleCodetemplateParser.g:637:2: rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2
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
    // InternalSingleCodetemplateParser.g:644:1: rule__Codetemplates__Group__1__Impl : ( For ) ;
    public final void rule__Codetemplates__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:648:1: ( ( For ) )
            // InternalSingleCodetemplateParser.g:649:1: ( For )
            {
            // InternalSingleCodetemplateParser.g:649:1: ( For )
            // InternalSingleCodetemplateParser.g:650:2: For
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
    // InternalSingleCodetemplateParser.g:659:1: rule__Codetemplates__Group__2 : rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 ;
    public final void rule__Codetemplates__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:663:1: ( rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 )
            // InternalSingleCodetemplateParser.g:664:2: rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3
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
    // InternalSingleCodetemplateParser.g:671:1: rule__Codetemplates__Group__2__Impl : ( ( rule__Codetemplates__LanguageAssignment_2 ) ) ;
    public final void rule__Codetemplates__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:675:1: ( ( ( rule__Codetemplates__LanguageAssignment_2 ) ) )
            // InternalSingleCodetemplateParser.g:676:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            {
            // InternalSingleCodetemplateParser.g:676:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            // InternalSingleCodetemplateParser.g:677:2: ( rule__Codetemplates__LanguageAssignment_2 )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageAssignment_2()); 
            // InternalSingleCodetemplateParser.g:678:2: ( rule__Codetemplates__LanguageAssignment_2 )
            // InternalSingleCodetemplateParser.g:678:3: rule__Codetemplates__LanguageAssignment_2
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
    // InternalSingleCodetemplateParser.g:686:1: rule__Codetemplates__Group__3 : rule__Codetemplates__Group__3__Impl ;
    public final void rule__Codetemplates__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:690:1: ( rule__Codetemplates__Group__3__Impl )
            // InternalSingleCodetemplateParser.g:691:2: rule__Codetemplates__Group__3__Impl
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
    // InternalSingleCodetemplateParser.g:697:1: rule__Codetemplates__Group__3__Impl : ( ( rule__Codetemplates__TemplatesAssignment_3 ) ) ;
    public final void rule__Codetemplates__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:701:1: ( ( ( rule__Codetemplates__TemplatesAssignment_3 ) ) )
            // InternalSingleCodetemplateParser.g:702:1: ( ( rule__Codetemplates__TemplatesAssignment_3 ) )
            {
            // InternalSingleCodetemplateParser.g:702:1: ( ( rule__Codetemplates__TemplatesAssignment_3 ) )
            // InternalSingleCodetemplateParser.g:703:2: ( rule__Codetemplates__TemplatesAssignment_3 )
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesAssignment_3()); 
            // InternalSingleCodetemplateParser.g:704:2: ( rule__Codetemplates__TemplatesAssignment_3 )
            // InternalSingleCodetemplateParser.g:704:3: rule__Codetemplates__TemplatesAssignment_3
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
    // InternalSingleCodetemplateParser.g:713:1: rule__Codetemplate__Group__0 : rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 ;
    public final void rule__Codetemplate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:717:1: ( rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 )
            // InternalSingleCodetemplateParser.g:718:2: rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1
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
    // InternalSingleCodetemplateParser.g:725:1: rule__Codetemplate__Group__0__Impl : ( ( rule__Codetemplate__NameAssignment_0 ) ) ;
    public final void rule__Codetemplate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:729:1: ( ( ( rule__Codetemplate__NameAssignment_0 ) ) )
            // InternalSingleCodetemplateParser.g:730:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            {
            // InternalSingleCodetemplateParser.g:730:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            // InternalSingleCodetemplateParser.g:731:2: ( rule__Codetemplate__NameAssignment_0 )
            {
             before(grammarAccess.getCodetemplateAccess().getNameAssignment_0()); 
            // InternalSingleCodetemplateParser.g:732:2: ( rule__Codetemplate__NameAssignment_0 )
            // InternalSingleCodetemplateParser.g:732:3: rule__Codetemplate__NameAssignment_0
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
    // InternalSingleCodetemplateParser.g:740:1: rule__Codetemplate__Group__1 : rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 ;
    public final void rule__Codetemplate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:744:1: ( rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 )
            // InternalSingleCodetemplateParser.g:745:2: rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2
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
    // InternalSingleCodetemplateParser.g:752:1: rule__Codetemplate__Group__1__Impl : ( For ) ;
    public final void rule__Codetemplate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:756:1: ( ( For ) )
            // InternalSingleCodetemplateParser.g:757:1: ( For )
            {
            // InternalSingleCodetemplateParser.g:757:1: ( For )
            // InternalSingleCodetemplateParser.g:758:2: For
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
    // InternalSingleCodetemplateParser.g:767:1: rule__Codetemplate__Group__2 : rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 ;
    public final void rule__Codetemplate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:771:1: ( rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 )
            // InternalSingleCodetemplateParser.g:772:2: rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3
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
    // InternalSingleCodetemplateParser.g:779:1: rule__Codetemplate__Group__2__Impl : ( ( rule__Codetemplate__Alternatives_2 ) ) ;
    public final void rule__Codetemplate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:783:1: ( ( ( rule__Codetemplate__Alternatives_2 ) ) )
            // InternalSingleCodetemplateParser.g:784:1: ( ( rule__Codetemplate__Alternatives_2 ) )
            {
            // InternalSingleCodetemplateParser.g:784:1: ( ( rule__Codetemplate__Alternatives_2 ) )
            // InternalSingleCodetemplateParser.g:785:2: ( rule__Codetemplate__Alternatives_2 )
            {
             before(grammarAccess.getCodetemplateAccess().getAlternatives_2()); 
            // InternalSingleCodetemplateParser.g:786:2: ( rule__Codetemplate__Alternatives_2 )
            // InternalSingleCodetemplateParser.g:786:3: rule__Codetemplate__Alternatives_2
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
    // InternalSingleCodetemplateParser.g:794:1: rule__Codetemplate__Group__3 : rule__Codetemplate__Group__3__Impl ;
    public final void rule__Codetemplate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:798:1: ( rule__Codetemplate__Group__3__Impl )
            // InternalSingleCodetemplateParser.g:799:2: rule__Codetemplate__Group__3__Impl
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
    // InternalSingleCodetemplateParser.g:805:1: rule__Codetemplate__Group__3__Impl : ( ( rule__Codetemplate__BodyAssignment_3 ) ) ;
    public final void rule__Codetemplate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:809:1: ( ( ( rule__Codetemplate__BodyAssignment_3 ) ) )
            // InternalSingleCodetemplateParser.g:810:1: ( ( rule__Codetemplate__BodyAssignment_3 ) )
            {
            // InternalSingleCodetemplateParser.g:810:1: ( ( rule__Codetemplate__BodyAssignment_3 ) )
            // InternalSingleCodetemplateParser.g:811:2: ( rule__Codetemplate__BodyAssignment_3 )
            {
             before(grammarAccess.getCodetemplateAccess().getBodyAssignment_3()); 
            // InternalSingleCodetemplateParser.g:812:2: ( rule__Codetemplate__BodyAssignment_3 )
            // InternalSingleCodetemplateParser.g:812:3: rule__Codetemplate__BodyAssignment_3
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
    // InternalSingleCodetemplateParser.g:821:1: rule__TemplateBodyWithQuotes__Group__0 : rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 ;
    public final void rule__TemplateBodyWithQuotes__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:825:1: ( rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 )
            // InternalSingleCodetemplateParser.g:826:2: rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1
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
    // InternalSingleCodetemplateParser.g:833:1: rule__TemplateBodyWithQuotes__Group__0__Impl : ( GreaterThanSignGreaterThanSign ) ;
    public final void rule__TemplateBodyWithQuotes__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:837:1: ( ( GreaterThanSignGreaterThanSign ) )
            // InternalSingleCodetemplateParser.g:838:1: ( GreaterThanSignGreaterThanSign )
            {
            // InternalSingleCodetemplateParser.g:838:1: ( GreaterThanSignGreaterThanSign )
            // InternalSingleCodetemplateParser.g:839:2: GreaterThanSignGreaterThanSign
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
    // InternalSingleCodetemplateParser.g:848:1: rule__TemplateBodyWithQuotes__Group__1 : rule__TemplateBodyWithQuotes__Group__1__Impl ;
    public final void rule__TemplateBodyWithQuotes__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:852:1: ( rule__TemplateBodyWithQuotes__Group__1__Impl )
            // InternalSingleCodetemplateParser.g:853:2: rule__TemplateBodyWithQuotes__Group__1__Impl
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
    // InternalSingleCodetemplateParser.g:859:1: rule__TemplateBodyWithQuotes__Group__1__Impl : ( ruleTemplateBody ) ;
    public final void rule__TemplateBodyWithQuotes__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:863:1: ( ( ruleTemplateBody ) )
            // InternalSingleCodetemplateParser.g:864:1: ( ruleTemplateBody )
            {
            // InternalSingleCodetemplateParser.g:864:1: ( ruleTemplateBody )
            // InternalSingleCodetemplateParser.g:865:2: ruleTemplateBody
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
    // InternalSingleCodetemplateParser.g:875:1: rule__TemplateBody__Group__0 : rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 ;
    public final void rule__TemplateBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:879:1: ( rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 )
            // InternalSingleCodetemplateParser.g:880:2: rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1
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
    // InternalSingleCodetemplateParser.g:887:1: rule__TemplateBody__Group__0__Impl : ( () ) ;
    public final void rule__TemplateBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:891:1: ( ( () ) )
            // InternalSingleCodetemplateParser.g:892:1: ( () )
            {
            // InternalSingleCodetemplateParser.g:892:1: ( () )
            // InternalSingleCodetemplateParser.g:893:2: ()
            {
             before(grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0()); 
            // InternalSingleCodetemplateParser.g:894:2: ()
            // InternalSingleCodetemplateParser.g:894:3: 
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
    // InternalSingleCodetemplateParser.g:902:1: rule__TemplateBody__Group__1 : rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 ;
    public final void rule__TemplateBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:906:1: ( rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 )
            // InternalSingleCodetemplateParser.g:907:2: rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2
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
    // InternalSingleCodetemplateParser.g:914:1: rule__TemplateBody__Group__1__Impl : ( ( rule__TemplateBody__PartsAssignment_1 )? ) ;
    public final void rule__TemplateBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:918:1: ( ( ( rule__TemplateBody__PartsAssignment_1 )? ) )
            // InternalSingleCodetemplateParser.g:919:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            {
            // InternalSingleCodetemplateParser.g:919:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            // InternalSingleCodetemplateParser.g:920:2: ( rule__TemplateBody__PartsAssignment_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_1()); 
            // InternalSingleCodetemplateParser.g:921:2: ( rule__TemplateBody__PartsAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||(LA10_0>=RULE_WS && LA10_0<=RULE_ANY_OTHER)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:921:3: rule__TemplateBody__PartsAssignment_1
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
    // InternalSingleCodetemplateParser.g:929:1: rule__TemplateBody__Group__2 : rule__TemplateBody__Group__2__Impl ;
    public final void rule__TemplateBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:933:1: ( rule__TemplateBody__Group__2__Impl )
            // InternalSingleCodetemplateParser.g:934:2: rule__TemplateBody__Group__2__Impl
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
    // InternalSingleCodetemplateParser.g:940:1: rule__TemplateBody__Group__2__Impl : ( ( rule__TemplateBody__Group_2__0 )* ) ;
    public final void rule__TemplateBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:944:1: ( ( ( rule__TemplateBody__Group_2__0 )* ) )
            // InternalSingleCodetemplateParser.g:945:1: ( ( rule__TemplateBody__Group_2__0 )* )
            {
            // InternalSingleCodetemplateParser.g:945:1: ( ( rule__TemplateBody__Group_2__0 )* )
            // InternalSingleCodetemplateParser.g:946:2: ( rule__TemplateBody__Group_2__0 )*
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup_2()); 
            // InternalSingleCodetemplateParser.g:947:2: ( rule__TemplateBody__Group_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=DollarSignDollarSign && LA11_0<=DollarSignLeftCurlyBracket)||LA11_0==DollarSign) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:947:3: rule__TemplateBody__Group_2__0
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
    // InternalSingleCodetemplateParser.g:956:1: rule__TemplateBody__Group_2__0 : rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 ;
    public final void rule__TemplateBody__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:960:1: ( rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 )
            // InternalSingleCodetemplateParser.g:961:2: rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1
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
    // InternalSingleCodetemplateParser.g:968:1: rule__TemplateBody__Group_2__0__Impl : ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) ;
    public final void rule__TemplateBody__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:972:1: ( ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) )
            // InternalSingleCodetemplateParser.g:973:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            {
            // InternalSingleCodetemplateParser.g:973:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            // InternalSingleCodetemplateParser.g:974:2: ( rule__TemplateBody__PartsAssignment_2_0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_0()); 
            // InternalSingleCodetemplateParser.g:975:2: ( rule__TemplateBody__PartsAssignment_2_0 )
            // InternalSingleCodetemplateParser.g:975:3: rule__TemplateBody__PartsAssignment_2_0
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
    // InternalSingleCodetemplateParser.g:983:1: rule__TemplateBody__Group_2__1 : rule__TemplateBody__Group_2__1__Impl ;
    public final void rule__TemplateBody__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:987:1: ( rule__TemplateBody__Group_2__1__Impl )
            // InternalSingleCodetemplateParser.g:988:2: rule__TemplateBody__Group_2__1__Impl
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
    // InternalSingleCodetemplateParser.g:994:1: rule__TemplateBody__Group_2__1__Impl : ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) ;
    public final void rule__TemplateBody__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:998:1: ( ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) )
            // InternalSingleCodetemplateParser.g:999:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            {
            // InternalSingleCodetemplateParser.g:999:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            // InternalSingleCodetemplateParser.g:1000:2: ( rule__TemplateBody__PartsAssignment_2_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_1()); 
            // InternalSingleCodetemplateParser.g:1001:2: ( rule__TemplateBody__PartsAssignment_2_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||(LA12_0>=RULE_WS && LA12_0<=RULE_ANY_OTHER)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1001:3: rule__TemplateBody__PartsAssignment_2_1
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
    // InternalSingleCodetemplateParser.g:1010:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1014:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalSingleCodetemplateParser.g:1015:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
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
    // InternalSingleCodetemplateParser.g:1022:1: rule__Variable__Group__0__Impl : ( DollarSignLeftCurlyBracket ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1026:1: ( ( DollarSignLeftCurlyBracket ) )
            // InternalSingleCodetemplateParser.g:1027:1: ( DollarSignLeftCurlyBracket )
            {
            // InternalSingleCodetemplateParser.g:1027:1: ( DollarSignLeftCurlyBracket )
            // InternalSingleCodetemplateParser.g:1028:2: DollarSignLeftCurlyBracket
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
    // InternalSingleCodetemplateParser.g:1037:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1041:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalSingleCodetemplateParser.g:1042:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
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
    // InternalSingleCodetemplateParser.g:1049:1: rule__Variable__Group__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1053:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1054:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1054:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1055:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_1()); 
            // InternalSingleCodetemplateParser.g:1056:2: ( RULE_WS )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1056:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1064:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1068:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalSingleCodetemplateParser.g:1069:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
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
    // InternalSingleCodetemplateParser.g:1076:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Alternatives_2 ) ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1080:1: ( ( ( rule__Variable__Alternatives_2 ) ) )
            // InternalSingleCodetemplateParser.g:1081:1: ( ( rule__Variable__Alternatives_2 ) )
            {
            // InternalSingleCodetemplateParser.g:1081:1: ( ( rule__Variable__Alternatives_2 ) )
            // InternalSingleCodetemplateParser.g:1082:2: ( rule__Variable__Alternatives_2 )
            {
             before(grammarAccess.getVariableAccess().getAlternatives_2()); 
            // InternalSingleCodetemplateParser.g:1083:2: ( rule__Variable__Alternatives_2 )
            // InternalSingleCodetemplateParser.g:1083:3: rule__Variable__Alternatives_2
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
    // InternalSingleCodetemplateParser.g:1091:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl rule__Variable__Group__4 ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1095:1: ( rule__Variable__Group__3__Impl rule__Variable__Group__4 )
            // InternalSingleCodetemplateParser.g:1096:2: rule__Variable__Group__3__Impl rule__Variable__Group__4
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
    // InternalSingleCodetemplateParser.g:1103:1: rule__Variable__Group__3__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1107:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1108:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1108:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1109:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_3()); 
            // InternalSingleCodetemplateParser.g:1110:2: ( RULE_WS )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_WS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1110:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1118:1: rule__Variable__Group__4 : rule__Variable__Group__4__Impl ;
    public final void rule__Variable__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1122:1: ( rule__Variable__Group__4__Impl )
            // InternalSingleCodetemplateParser.g:1123:2: rule__Variable__Group__4__Impl
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
    // InternalSingleCodetemplateParser.g:1129:1: rule__Variable__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__Variable__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1133:1: ( ( RightCurlyBracket ) )
            // InternalSingleCodetemplateParser.g:1134:1: ( RightCurlyBracket )
            {
            // InternalSingleCodetemplateParser.g:1134:1: ( RightCurlyBracket )
            // InternalSingleCodetemplateParser.g:1135:2: RightCurlyBracket
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
    // InternalSingleCodetemplateParser.g:1145:1: rule__Variable__Group_2_1__0 : rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 ;
    public final void rule__Variable__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1149:1: ( rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 )
            // InternalSingleCodetemplateParser.g:1150:2: rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1
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
    // InternalSingleCodetemplateParser.g:1157:1: rule__Variable__Group_2_1__0__Impl : ( ( rule__Variable__Group_2_1_0__0 )? ) ;
    public final void rule__Variable__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1161:1: ( ( ( rule__Variable__Group_2_1_0__0 )? ) )
            // InternalSingleCodetemplateParser.g:1162:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            {
            // InternalSingleCodetemplateParser.g:1162:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            // InternalSingleCodetemplateParser.g:1163:2: ( rule__Variable__Group_2_1_0__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_0()); 
            // InternalSingleCodetemplateParser.g:1164:2: ( rule__Variable__Group_2_1_0__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=Templates && LA15_0<=For)||LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1164:3: rule__Variable__Group_2_1_0__0
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
    // InternalSingleCodetemplateParser.g:1172:1: rule__Variable__Group_2_1__1 : rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 ;
    public final void rule__Variable__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1176:1: ( rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 )
            // InternalSingleCodetemplateParser.g:1177:2: rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2
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
    // InternalSingleCodetemplateParser.g:1184:1: rule__Variable__Group_2_1__1__Impl : ( Colon ) ;
    public final void rule__Variable__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1188:1: ( ( Colon ) )
            // InternalSingleCodetemplateParser.g:1189:1: ( Colon )
            {
            // InternalSingleCodetemplateParser.g:1189:1: ( Colon )
            // InternalSingleCodetemplateParser.g:1190:2: Colon
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
    // InternalSingleCodetemplateParser.g:1199:1: rule__Variable__Group_2_1__2 : rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 ;
    public final void rule__Variable__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1203:1: ( rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 )
            // InternalSingleCodetemplateParser.g:1204:2: rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3
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
    // InternalSingleCodetemplateParser.g:1211:1: rule__Variable__Group_2_1__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1215:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1216:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1216:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1217:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2()); 
            // InternalSingleCodetemplateParser.g:1218:2: ( RULE_WS )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_WS) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1218:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1226:1: rule__Variable__Group_2_1__3 : rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 ;
    public final void rule__Variable__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1230:1: ( rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 )
            // InternalSingleCodetemplateParser.g:1231:2: rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4
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
    // InternalSingleCodetemplateParser.g:1238:1: rule__Variable__Group_2_1__3__Impl : ( ( rule__Variable__TypeAssignment_2_1_3 ) ) ;
    public final void rule__Variable__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1242:1: ( ( ( rule__Variable__TypeAssignment_2_1_3 ) ) )
            // InternalSingleCodetemplateParser.g:1243:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            {
            // InternalSingleCodetemplateParser.g:1243:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            // InternalSingleCodetemplateParser.g:1244:2: ( rule__Variable__TypeAssignment_2_1_3 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_2_1_3()); 
            // InternalSingleCodetemplateParser.g:1245:2: ( rule__Variable__TypeAssignment_2_1_3 )
            // InternalSingleCodetemplateParser.g:1245:3: rule__Variable__TypeAssignment_2_1_3
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
    // InternalSingleCodetemplateParser.g:1253:1: rule__Variable__Group_2_1__4 : rule__Variable__Group_2_1__4__Impl ;
    public final void rule__Variable__Group_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1257:1: ( rule__Variable__Group_2_1__4__Impl )
            // InternalSingleCodetemplateParser.g:1258:2: rule__Variable__Group_2_1__4__Impl
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
    // InternalSingleCodetemplateParser.g:1264:1: rule__Variable__Group_2_1__4__Impl : ( ( rule__Variable__Group_2_1_4__0 )? ) ;
    public final void rule__Variable__Group_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1268:1: ( ( ( rule__Variable__Group_2_1_4__0 )? ) )
            // InternalSingleCodetemplateParser.g:1269:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            {
            // InternalSingleCodetemplateParser.g:1269:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            // InternalSingleCodetemplateParser.g:1270:2: ( rule__Variable__Group_2_1_4__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4()); 
            // InternalSingleCodetemplateParser.g:1271:2: ( rule__Variable__Group_2_1_4__0 )?
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1271:3: rule__Variable__Group_2_1_4__0
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
    // InternalSingleCodetemplateParser.g:1280:1: rule__Variable__Group_2_1_0__0 : rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 ;
    public final void rule__Variable__Group_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1284:1: ( rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 )
            // InternalSingleCodetemplateParser.g:1285:2: rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1
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
    // InternalSingleCodetemplateParser.g:1292:1: rule__Variable__Group_2_1_0__0__Impl : ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) ;
    public final void rule__Variable__Group_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1296:1: ( ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) )
            // InternalSingleCodetemplateParser.g:1297:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            {
            // InternalSingleCodetemplateParser.g:1297:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            // InternalSingleCodetemplateParser.g:1298:2: ( rule__Variable__NameAssignment_2_1_0_0 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_2_1_0_0()); 
            // InternalSingleCodetemplateParser.g:1299:2: ( rule__Variable__NameAssignment_2_1_0_0 )
            // InternalSingleCodetemplateParser.g:1299:3: rule__Variable__NameAssignment_2_1_0_0
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
    // InternalSingleCodetemplateParser.g:1307:1: rule__Variable__Group_2_1_0__1 : rule__Variable__Group_2_1_0__1__Impl ;
    public final void rule__Variable__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1311:1: ( rule__Variable__Group_2_1_0__1__Impl )
            // InternalSingleCodetemplateParser.g:1312:2: rule__Variable__Group_2_1_0__1__Impl
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
    // InternalSingleCodetemplateParser.g:1318:1: rule__Variable__Group_2_1_0__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1322:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1323:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1323:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1324:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1()); 
            // InternalSingleCodetemplateParser.g:1325:2: ( RULE_WS )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_WS) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1325:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1334:1: rule__Variable__Group_2_1_4__0 : rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 ;
    public final void rule__Variable__Group_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1338:1: ( rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 )
            // InternalSingleCodetemplateParser.g:1339:2: rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1
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
    // InternalSingleCodetemplateParser.g:1346:1: rule__Variable__Group_2_1_4__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1350:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1351:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1351:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1352:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0()); 
            // InternalSingleCodetemplateParser.g:1353:2: ( RULE_WS )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_WS) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1353:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1361:1: rule__Variable__Group_2_1_4__1 : rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 ;
    public final void rule__Variable__Group_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1365:1: ( rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 )
            // InternalSingleCodetemplateParser.g:1366:2: rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2
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
    // InternalSingleCodetemplateParser.g:1373:1: rule__Variable__Group_2_1_4__1__Impl : ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) ) ;
    public final void rule__Variable__Group_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1377:1: ( ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) ) )
            // InternalSingleCodetemplateParser.g:1378:1: ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) )
            {
            // InternalSingleCodetemplateParser.g:1378:1: ( ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 ) )
            // InternalSingleCodetemplateParser.g:1379:2: ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 )
            {
             before(grammarAccess.getVariableAccess().getExpectingParametersAssignment_2_1_4_1()); 
            // InternalSingleCodetemplateParser.g:1380:2: ( rule__Variable__ExpectingParametersAssignment_2_1_4_1 )
            // InternalSingleCodetemplateParser.g:1380:3: rule__Variable__ExpectingParametersAssignment_2_1_4_1
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
    // InternalSingleCodetemplateParser.g:1388:1: rule__Variable__Group_2_1_4__2 : rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 ;
    public final void rule__Variable__Group_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1392:1: ( rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 )
            // InternalSingleCodetemplateParser.g:1393:2: rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3
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
    // InternalSingleCodetemplateParser.g:1400:1: rule__Variable__Group_2_1_4__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1404:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1405:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1405:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1406:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2()); 
            // InternalSingleCodetemplateParser.g:1407:2: ( RULE_WS )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_WS) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1407:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1415:1: rule__Variable__Group_2_1_4__3 : rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 ;
    public final void rule__Variable__Group_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1419:1: ( rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 )
            // InternalSingleCodetemplateParser.g:1420:2: rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4
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
    // InternalSingleCodetemplateParser.g:1427:1: rule__Variable__Group_2_1_4__3__Impl : ( ( rule__Variable__Group_2_1_4_3__0 )? ) ;
    public final void rule__Variable__Group_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1431:1: ( ( ( rule__Variable__Group_2_1_4_3__0 )? ) )
            // InternalSingleCodetemplateParser.g:1432:1: ( ( rule__Variable__Group_2_1_4_3__0 )? )
            {
            // InternalSingleCodetemplateParser.g:1432:1: ( ( rule__Variable__Group_2_1_4_3__0 )? )
            // InternalSingleCodetemplateParser.g:1433:2: ( rule__Variable__Group_2_1_4_3__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4_3()); 
            // InternalSingleCodetemplateParser.g:1434:2: ( rule__Variable__Group_2_1_4_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=Templates && LA21_0<=For)||(LA21_0>=RULE_ID && LA21_0<=RULE_STRING)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:1434:3: rule__Variable__Group_2_1_4_3__0
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
    // InternalSingleCodetemplateParser.g:1442:1: rule__Variable__Group_2_1_4__4 : rule__Variable__Group_2_1_4__4__Impl ;
    public final void rule__Variable__Group_2_1_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1446:1: ( rule__Variable__Group_2_1_4__4__Impl )
            // InternalSingleCodetemplateParser.g:1447:2: rule__Variable__Group_2_1_4__4__Impl
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
    // InternalSingleCodetemplateParser.g:1453:1: rule__Variable__Group_2_1_4__4__Impl : ( RightParenthesis ) ;
    public final void rule__Variable__Group_2_1_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1457:1: ( ( RightParenthesis ) )
            // InternalSingleCodetemplateParser.g:1458:1: ( RightParenthesis )
            {
            // InternalSingleCodetemplateParser.g:1458:1: ( RightParenthesis )
            // InternalSingleCodetemplateParser.g:1459:2: RightParenthesis
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
    // InternalSingleCodetemplateParser.g:1469:1: rule__Variable__Group_2_1_4_3__0 : rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1 ;
    public final void rule__Variable__Group_2_1_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1473:1: ( rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1 )
            // InternalSingleCodetemplateParser.g:1474:2: rule__Variable__Group_2_1_4_3__0__Impl rule__Variable__Group_2_1_4_3__1
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
    // InternalSingleCodetemplateParser.g:1481:1: rule__Variable__Group_2_1_4_3__0__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) ) ;
    public final void rule__Variable__Group_2_1_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1485:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) ) )
            // InternalSingleCodetemplateParser.g:1486:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) )
            {
            // InternalSingleCodetemplateParser.g:1486:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_0 ) )
            // InternalSingleCodetemplateParser.g:1487:2: ( rule__Variable__ParametersAssignment_2_1_4_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_0()); 
            // InternalSingleCodetemplateParser.g:1488:2: ( rule__Variable__ParametersAssignment_2_1_4_3_0 )
            // InternalSingleCodetemplateParser.g:1488:3: rule__Variable__ParametersAssignment_2_1_4_3_0
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
    // InternalSingleCodetemplateParser.g:1496:1: rule__Variable__Group_2_1_4_3__1 : rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2 ;
    public final void rule__Variable__Group_2_1_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1500:1: ( rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2 )
            // InternalSingleCodetemplateParser.g:1501:2: rule__Variable__Group_2_1_4_3__1__Impl rule__Variable__Group_2_1_4_3__2
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
    // InternalSingleCodetemplateParser.g:1508:1: rule__Variable__Group_2_1_4_3__1__Impl : ( ( rule__Variable__Group_2_1_4_3_1__0 )* ) ;
    public final void rule__Variable__Group_2_1_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1512:1: ( ( ( rule__Variable__Group_2_1_4_3_1__0 )* ) )
            // InternalSingleCodetemplateParser.g:1513:1: ( ( rule__Variable__Group_2_1_4_3_1__0 )* )
            {
            // InternalSingleCodetemplateParser.g:1513:1: ( ( rule__Variable__Group_2_1_4_3_1__0 )* )
            // InternalSingleCodetemplateParser.g:1514:2: ( rule__Variable__Group_2_1_4_3_1__0 )*
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4_3_1()); 
            // InternalSingleCodetemplateParser.g:1515:2: ( rule__Variable__Group_2_1_4_3_1__0 )*
            loop22:
            do {
                int alt22=2;
                alt22 = dfa22.predict(input);
                switch (alt22) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1515:3: rule__Variable__Group_2_1_4_3_1__0
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
    // InternalSingleCodetemplateParser.g:1523:1: rule__Variable__Group_2_1_4_3__2 : rule__Variable__Group_2_1_4_3__2__Impl ;
    public final void rule__Variable__Group_2_1_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1527:1: ( rule__Variable__Group_2_1_4_3__2__Impl )
            // InternalSingleCodetemplateParser.g:1528:2: rule__Variable__Group_2_1_4_3__2__Impl
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
    // InternalSingleCodetemplateParser.g:1534:1: rule__Variable__Group_2_1_4_3__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1538:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1539:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1539:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1540:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_2()); 
            // InternalSingleCodetemplateParser.g:1541:2: ( RULE_WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1541:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1550:1: rule__Variable__Group_2_1_4_3_1__0 : rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1 ;
    public final void rule__Variable__Group_2_1_4_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1554:1: ( rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1 )
            // InternalSingleCodetemplateParser.g:1555:2: rule__Variable__Group_2_1_4_3_1__0__Impl rule__Variable__Group_2_1_4_3_1__1
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
    // InternalSingleCodetemplateParser.g:1562:1: rule__Variable__Group_2_1_4_3_1__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1566:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1567:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1567:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1568:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_0()); 
            // InternalSingleCodetemplateParser.g:1569:2: ( RULE_WS )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_WS) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1569:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1577:1: rule__Variable__Group_2_1_4_3_1__1 : rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2 ;
    public final void rule__Variable__Group_2_1_4_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1581:1: ( rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2 )
            // InternalSingleCodetemplateParser.g:1582:2: rule__Variable__Group_2_1_4_3_1__1__Impl rule__Variable__Group_2_1_4_3_1__2
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
    // InternalSingleCodetemplateParser.g:1589:1: rule__Variable__Group_2_1_4_3_1__1__Impl : ( Comma ) ;
    public final void rule__Variable__Group_2_1_4_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1593:1: ( ( Comma ) )
            // InternalSingleCodetemplateParser.g:1594:1: ( Comma )
            {
            // InternalSingleCodetemplateParser.g:1594:1: ( Comma )
            // InternalSingleCodetemplateParser.g:1595:2: Comma
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
    // InternalSingleCodetemplateParser.g:1604:1: rule__Variable__Group_2_1_4_3_1__2 : rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3 ;
    public final void rule__Variable__Group_2_1_4_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1608:1: ( rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3 )
            // InternalSingleCodetemplateParser.g:1609:2: rule__Variable__Group_2_1_4_3_1__2__Impl rule__Variable__Group_2_1_4_3_1__3
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
    // InternalSingleCodetemplateParser.g:1616:1: rule__Variable__Group_2_1_4_3_1__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1620:1: ( ( ( RULE_WS )* ) )
            // InternalSingleCodetemplateParser.g:1621:1: ( ( RULE_WS )* )
            {
            // InternalSingleCodetemplateParser.g:1621:1: ( ( RULE_WS )* )
            // InternalSingleCodetemplateParser.g:1622:2: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_2()); 
            // InternalSingleCodetemplateParser.g:1623:2: ( RULE_WS )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_WS) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1623:3: RULE_WS
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
    // InternalSingleCodetemplateParser.g:1631:1: rule__Variable__Group_2_1_4_3_1__3 : rule__Variable__Group_2_1_4_3_1__3__Impl ;
    public final void rule__Variable__Group_2_1_4_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1635:1: ( rule__Variable__Group_2_1_4_3_1__3__Impl )
            // InternalSingleCodetemplateParser.g:1636:2: rule__Variable__Group_2_1_4_3_1__3__Impl
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
    // InternalSingleCodetemplateParser.g:1642:1: rule__Variable__Group_2_1_4_3_1__3__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) ) ;
    public final void rule__Variable__Group_2_1_4_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1646:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) ) )
            // InternalSingleCodetemplateParser.g:1647:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) )
            {
            // InternalSingleCodetemplateParser.g:1647:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 ) )
            // InternalSingleCodetemplateParser.g:1648:2: ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_1_3()); 
            // InternalSingleCodetemplateParser.g:1649:2: ( rule__Variable__ParametersAssignment_2_1_4_3_1_3 )
            // InternalSingleCodetemplateParser.g:1649:3: rule__Variable__ParametersAssignment_2_1_4_3_1_3
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
    // InternalSingleCodetemplateParser.g:1658:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1662:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalSingleCodetemplateParser.g:1663:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
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
    // InternalSingleCodetemplateParser.g:1670:1: rule__FQN__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1674:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1675:1: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1675:1: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1676:2: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1685:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1689:1: ( rule__FQN__Group__1__Impl )
            // InternalSingleCodetemplateParser.g:1690:2: rule__FQN__Group__1__Impl
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
    // InternalSingleCodetemplateParser.g:1696:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1700:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalSingleCodetemplateParser.g:1701:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalSingleCodetemplateParser.g:1701:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalSingleCodetemplateParser.g:1702:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalSingleCodetemplateParser.g:1703:2: ( rule__FQN__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==FullStop) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:1703:3: rule__FQN__Group_1__0
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
    // InternalSingleCodetemplateParser.g:1712:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1716:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalSingleCodetemplateParser.g:1717:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalSingleCodetemplateParser.g:1724:1: rule__FQN__Group_1__0__Impl : ( FullStop ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1728:1: ( ( FullStop ) )
            // InternalSingleCodetemplateParser.g:1729:1: ( FullStop )
            {
            // InternalSingleCodetemplateParser.g:1729:1: ( FullStop )
            // InternalSingleCodetemplateParser.g:1730:2: FullStop
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
    // InternalSingleCodetemplateParser.g:1739:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1743:1: ( rule__FQN__Group_1__1__Impl )
            // InternalSingleCodetemplateParser.g:1744:2: rule__FQN__Group_1__1__Impl
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
    // InternalSingleCodetemplateParser.g:1750:1: rule__FQN__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1754:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1755:1: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1755:1: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1756:2: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1766:1: rule__Dollar__Group__0 : rule__Dollar__Group__0__Impl rule__Dollar__Group__1 ;
    public final void rule__Dollar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1770:1: ( rule__Dollar__Group__0__Impl rule__Dollar__Group__1 )
            // InternalSingleCodetemplateParser.g:1771:2: rule__Dollar__Group__0__Impl rule__Dollar__Group__1
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
    // InternalSingleCodetemplateParser.g:1778:1: rule__Dollar__Group__0__Impl : ( () ) ;
    public final void rule__Dollar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1782:1: ( ( () ) )
            // InternalSingleCodetemplateParser.g:1783:1: ( () )
            {
            // InternalSingleCodetemplateParser.g:1783:1: ( () )
            // InternalSingleCodetemplateParser.g:1784:2: ()
            {
             before(grammarAccess.getDollarAccess().getDollarAction_0()); 
            // InternalSingleCodetemplateParser.g:1785:2: ()
            // InternalSingleCodetemplateParser.g:1785:3: 
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
    // InternalSingleCodetemplateParser.g:1793:1: rule__Dollar__Group__1 : rule__Dollar__Group__1__Impl ;
    public final void rule__Dollar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1797:1: ( rule__Dollar__Group__1__Impl )
            // InternalSingleCodetemplateParser.g:1798:2: rule__Dollar__Group__1__Impl
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
    // InternalSingleCodetemplateParser.g:1804:1: rule__Dollar__Group__1__Impl : ( ( rule__Dollar__Alternatives_1 ) ) ;
    public final void rule__Dollar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1808:1: ( ( ( rule__Dollar__Alternatives_1 ) ) )
            // InternalSingleCodetemplateParser.g:1809:1: ( ( rule__Dollar__Alternatives_1 ) )
            {
            // InternalSingleCodetemplateParser.g:1809:1: ( ( rule__Dollar__Alternatives_1 ) )
            // InternalSingleCodetemplateParser.g:1810:2: ( rule__Dollar__Alternatives_1 )
            {
             before(grammarAccess.getDollarAccess().getAlternatives_1()); 
            // InternalSingleCodetemplateParser.g:1811:2: ( rule__Dollar__Alternatives_1 )
            // InternalSingleCodetemplateParser.g:1811:3: rule__Dollar__Alternatives_1
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
    // InternalSingleCodetemplateParser.g:1820:1: rule__Codetemplates__LanguageAssignment_2 : ( ( ruleFQN ) ) ;
    public final void rule__Codetemplates__LanguageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1824:1: ( ( ( ruleFQN ) ) )
            // InternalSingleCodetemplateParser.g:1825:2: ( ( ruleFQN ) )
            {
            // InternalSingleCodetemplateParser.g:1825:2: ( ( ruleFQN ) )
            // InternalSingleCodetemplateParser.g:1826:3: ( ruleFQN )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0()); 
            // InternalSingleCodetemplateParser.g:1827:3: ( ruleFQN )
            // InternalSingleCodetemplateParser.g:1828:4: ruleFQN
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
    // InternalSingleCodetemplateParser.g:1839:1: rule__Codetemplates__TemplatesAssignment_3 : ( ruleCodetemplate ) ;
    public final void rule__Codetemplates__TemplatesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1843:1: ( ( ruleCodetemplate ) )
            // InternalSingleCodetemplateParser.g:1844:2: ( ruleCodetemplate )
            {
            // InternalSingleCodetemplateParser.g:1844:2: ( ruleCodetemplate )
            // InternalSingleCodetemplateParser.g:1845:3: ruleCodetemplate
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
    // InternalSingleCodetemplateParser.g:1854:1: rule__Codetemplate__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1858:1: ( ( RULE_STRING ) )
            // InternalSingleCodetemplateParser.g:1859:2: ( RULE_STRING )
            {
            // InternalSingleCodetemplateParser.g:1859:2: ( RULE_STRING )
            // InternalSingleCodetemplateParser.g:1860:3: RULE_STRING
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
    // InternalSingleCodetemplateParser.g:1869:1: rule__Codetemplate__ContextAssignment_2_0 : ( ( ruleValidID ) ) ;
    public final void rule__Codetemplate__ContextAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1873:1: ( ( ( ruleValidID ) ) )
            // InternalSingleCodetemplateParser.g:1874:2: ( ( ruleValidID ) )
            {
            // InternalSingleCodetemplateParser.g:1874:2: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1875:3: ( ruleValidID )
            {
             before(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_2_0_0()); 
            // InternalSingleCodetemplateParser.g:1876:3: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1877:4: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1888:1: rule__Codetemplate__KeywordContextAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__KeywordContextAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1892:1: ( ( RULE_STRING ) )
            // InternalSingleCodetemplateParser.g:1893:2: ( RULE_STRING )
            {
            // InternalSingleCodetemplateParser.g:1893:2: ( RULE_STRING )
            // InternalSingleCodetemplateParser.g:1894:3: RULE_STRING
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
    // InternalSingleCodetemplateParser.g:1903:1: rule__Codetemplate__BodyAssignment_3 : ( ruleTemplateBodyWithQuotes ) ;
    public final void rule__Codetemplate__BodyAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1907:1: ( ( ruleTemplateBodyWithQuotes ) )
            // InternalSingleCodetemplateParser.g:1908:2: ( ruleTemplateBodyWithQuotes )
            {
            // InternalSingleCodetemplateParser.g:1908:2: ( ruleTemplateBodyWithQuotes )
            // InternalSingleCodetemplateParser.g:1909:3: ruleTemplateBodyWithQuotes
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
    // InternalSingleCodetemplateParser.g:1918:1: rule__TemplateBody__PartsAssignment_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1922:1: ( ( ruleLiteral ) )
            // InternalSingleCodetemplateParser.g:1923:2: ( ruleLiteral )
            {
            // InternalSingleCodetemplateParser.g:1923:2: ( ruleLiteral )
            // InternalSingleCodetemplateParser.g:1924:3: ruleLiteral
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
    // InternalSingleCodetemplateParser.g:1933:1: rule__TemplateBody__PartsAssignment_2_0 : ( ruleVariableOrDollar ) ;
    public final void rule__TemplateBody__PartsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1937:1: ( ( ruleVariableOrDollar ) )
            // InternalSingleCodetemplateParser.g:1938:2: ( ruleVariableOrDollar )
            {
            // InternalSingleCodetemplateParser.g:1938:2: ( ruleVariableOrDollar )
            // InternalSingleCodetemplateParser.g:1939:3: ruleVariableOrDollar
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
    // InternalSingleCodetemplateParser.g:1948:1: rule__TemplateBody__PartsAssignment_2_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1952:1: ( ( ruleLiteral ) )
            // InternalSingleCodetemplateParser.g:1953:2: ( ruleLiteral )
            {
            // InternalSingleCodetemplateParser.g:1953:2: ( ruleLiteral )
            // InternalSingleCodetemplateParser.g:1954:3: ruleLiteral
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
    // InternalSingleCodetemplateParser.g:1963:1: rule__Variable__NameAssignment_2_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1967:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1968:2: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1968:2: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1969:3: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1978:1: rule__Variable__NameAssignment_2_1_0_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1982:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1983:2: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1983:2: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1984:3: ruleValidID
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
    // InternalSingleCodetemplateParser.g:1993:1: rule__Variable__TypeAssignment_2_1_3 : ( ruleValidID ) ;
    public final void rule__Variable__TypeAssignment_2_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:1997:1: ( ( ruleValidID ) )
            // InternalSingleCodetemplateParser.g:1998:2: ( ruleValidID )
            {
            // InternalSingleCodetemplateParser.g:1998:2: ( ruleValidID )
            // InternalSingleCodetemplateParser.g:1999:3: ruleValidID
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
    // InternalSingleCodetemplateParser.g:2008:1: rule__Variable__ExpectingParametersAssignment_2_1_4_1 : ( ( LeftParenthesis ) ) ;
    public final void rule__Variable__ExpectingParametersAssignment_2_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:2012:1: ( ( ( LeftParenthesis ) ) )
            // InternalSingleCodetemplateParser.g:2013:2: ( ( LeftParenthesis ) )
            {
            // InternalSingleCodetemplateParser.g:2013:2: ( ( LeftParenthesis ) )
            // InternalSingleCodetemplateParser.g:2014:3: ( LeftParenthesis )
            {
             before(grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0()); 
            // InternalSingleCodetemplateParser.g:2015:3: ( LeftParenthesis )
            // InternalSingleCodetemplateParser.g:2016:4: LeftParenthesis
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
    // InternalSingleCodetemplateParser.g:2027:1: rule__Variable__ParametersAssignment_2_1_4_3_0 : ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:2031:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) ) )
            // InternalSingleCodetemplateParser.g:2032:2: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) )
            {
            // InternalSingleCodetemplateParser.g:2032:2: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 ) )
            // InternalSingleCodetemplateParser.g:2033:3: ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_0_0()); 
            // InternalSingleCodetemplateParser.g:2034:3: ( rule__Variable__ParametersAlternatives_2_1_4_3_0_0 )
            // InternalSingleCodetemplateParser.g:2034:4: rule__Variable__ParametersAlternatives_2_1_4_3_0_0
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
    // InternalSingleCodetemplateParser.g:2042:1: rule__Variable__ParametersAssignment_2_1_4_3_1_3 : ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_3_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:2046:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) ) )
            // InternalSingleCodetemplateParser.g:2047:2: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) )
            {
            // InternalSingleCodetemplateParser.g:2047:2: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 ) )
            // InternalSingleCodetemplateParser.g:2048:3: ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_1_3_0()); 
            // InternalSingleCodetemplateParser.g:2049:3: ( rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0 )
            // InternalSingleCodetemplateParser.g:2049:4: rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0
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
    // InternalSingleCodetemplateParser.g:2057:1: rule__Literal__ValueAssignment : ( ruleLiteralValue ) ;
    public final void rule__Literal__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:2061:1: ( ( ruleLiteralValue ) )
            // InternalSingleCodetemplateParser.g:2062:2: ( ruleLiteralValue )
            {
            // InternalSingleCodetemplateParser.g:2062:2: ( ruleLiteralValue )
            // InternalSingleCodetemplateParser.g:2063:3: ruleLiteralValue
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
    // InternalSingleCodetemplateParser.g:2072:1: rule__Dollar__EscapedAssignment_1_0 : ( ( DollarSignDollarSign ) ) ;
    public final void rule__Dollar__EscapedAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSingleCodetemplateParser.g:2076:1: ( ( ( DollarSignDollarSign ) ) )
            // InternalSingleCodetemplateParser.g:2077:2: ( ( DollarSignDollarSign ) )
            {
            // InternalSingleCodetemplateParser.g:2077:2: ( ( DollarSignDollarSign ) )
            // InternalSingleCodetemplateParser.g:2078:3: ( DollarSignDollarSign )
            {
             before(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 
            // InternalSingleCodetemplateParser.g:2079:3: ( DollarSignDollarSign )
            // InternalSingleCodetemplateParser.g:2080:4: DollarSignDollarSign
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
            return "494:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );";
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
            return "1271:2: ( rule__Variable__Group_2_1_4__0 )?";
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
            return "()* loopback of 1515:2: ( rule__Variable__Group_2_1_4_3_1__0 )*";
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
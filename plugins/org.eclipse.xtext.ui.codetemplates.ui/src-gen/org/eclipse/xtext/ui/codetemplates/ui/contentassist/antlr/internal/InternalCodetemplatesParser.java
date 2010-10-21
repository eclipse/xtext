package org.eclipse.xtext.ui.codetemplates.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

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
import org.eclipse.xtext.ui.codetemplates.services.CodetemplatesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCodetemplatesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_14", "KEYWORD_12", "KEYWORD_13", "KEYWORD_8", "KEYWORD_9", "KEYWORD_10", "KEYWORD_11", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int KEYWORD_7=17;
    public static final int RULE_ID=18;
    public static final int KEYWORD_10=9;
    public static final int KEYWORD_1=11;
    public static final int RULE_STRING=19;
    public static final int KEYWORD_9=8;
    public static final int KEYWORD_2=12;
    public static final int KEYWORD_11=10;
    public static final int KEYWORD_4=14;
    public static final int RULE_WS=20;
    public static final int EOF=-1;
    public static final int KEYWORD_13=6;
    public static final int KEYWORD_14=4;
    public static final int KEYWORD_5=15;
    public static final int KEYWORD_6=16;
    public static final int RULE_ANY_OTHER=21;
    public static final int KEYWORD_12=5;
    public static final int KEYWORD_8=7;
    public static final int KEYWORD_3=13;

    // delegates
    // delegators


        public InternalCodetemplatesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCodetemplatesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCodetemplatesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g"; }


     
     	private CodetemplatesGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("KEYWORD_1", "'\u0024'");
    		tokenNameToValue.put("KEYWORD_2", "'('");
    		tokenNameToValue.put("KEYWORD_3", "')'");
    		tokenNameToValue.put("KEYWORD_4", "','");
    		tokenNameToValue.put("KEYWORD_5", "'.'");
    		tokenNameToValue.put("KEYWORD_6", "':'");
    		tokenNameToValue.put("KEYWORD_7", "'}'");
    		tokenNameToValue.put("KEYWORD_8", "'\u0024\u0024'");
    		tokenNameToValue.put("KEYWORD_9", "'\u0024{'");
    		tokenNameToValue.put("KEYWORD_10", "'<<'");
    		tokenNameToValue.put("KEYWORD_11", "'>>'");
    		tokenNameToValue.put("KEYWORD_12", "'\\<<'");
    		tokenNameToValue.put("KEYWORD_13", "'for'");
    		tokenNameToValue.put("KEYWORD_14", "'templates'");
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:78:1: entryRuleCodetemplates : ruleCodetemplates EOF ;
    public final void entryRuleCodetemplates() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:79:1: ( ruleCodetemplates EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:80:1: ruleCodetemplates EOF
            {
             before(grammarAccess.getCodetemplatesRule()); 
            pushFollow(FOLLOW_ruleCodetemplates_in_entryRuleCodetemplates54);
            ruleCodetemplates();

            state._fsp--;

             after(grammarAccess.getCodetemplatesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodetemplates61); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:87:1: ruleCodetemplates : ( ( rule__Codetemplates__Group__0 ) ) ;
    public final void ruleCodetemplates() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:91:5: ( ( ( rule__Codetemplates__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:92:1: ( ( rule__Codetemplates__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:92:1: ( ( rule__Codetemplates__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:93:1: ( rule__Codetemplates__Group__0 )
            {
             before(grammarAccess.getCodetemplatesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:94:1: ( rule__Codetemplates__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:94:2: rule__Codetemplates__Group__0
            {
            pushFollow(FOLLOW_rule__Codetemplates__Group__0_in_ruleCodetemplates91);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:106:1: entryRuleCodetemplate : ruleCodetemplate EOF ;
    public final void entryRuleCodetemplate() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:107:1: ( ruleCodetemplate EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:108:1: ruleCodetemplate EOF
            {
             before(grammarAccess.getCodetemplateRule()); 
            pushFollow(FOLLOW_ruleCodetemplate_in_entryRuleCodetemplate118);
            ruleCodetemplate();

            state._fsp--;

             after(grammarAccess.getCodetemplateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodetemplate125); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:115:1: ruleCodetemplate : ( ( rule__Codetemplate__Group__0 ) ) ;
    public final void ruleCodetemplate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:119:5: ( ( ( rule__Codetemplate__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:120:1: ( ( rule__Codetemplate__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:120:1: ( ( rule__Codetemplate__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:121:1: ( rule__Codetemplate__Group__0 )
            {
             before(grammarAccess.getCodetemplateAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:122:1: ( rule__Codetemplate__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:122:2: rule__Codetemplate__Group__0
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__0_in_ruleCodetemplate155);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:134:1: entryRuleTemplateBodyWithQuotes : ruleTemplateBodyWithQuotes EOF ;
    public final void entryRuleTemplateBodyWithQuotes() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:138:1: ( ruleTemplateBodyWithQuotes EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:139:1: ruleTemplateBodyWithQuotes EOF
            {
             before(grammarAccess.getTemplateBodyWithQuotesRule()); 
            pushFollow(FOLLOW_ruleTemplateBodyWithQuotes_in_entryRuleTemplateBodyWithQuotes187);
            ruleTemplateBodyWithQuotes();

            state._fsp--;

             after(grammarAccess.getTemplateBodyWithQuotesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTemplateBodyWithQuotes194); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:149:1: ruleTemplateBodyWithQuotes : ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) ;
    public final void ruleTemplateBodyWithQuotes() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:154:5: ( ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:155:1: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:155:1: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:156:1: ( rule__TemplateBodyWithQuotes__Group__0 )
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:157:1: ( rule__TemplateBodyWithQuotes__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:157:2: rule__TemplateBodyWithQuotes__Group__0
            {
            pushFollow(FOLLOW_rule__TemplateBodyWithQuotes__Group__0_in_ruleTemplateBodyWithQuotes228);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:170:1: entryRuleTemplateBody : ruleTemplateBody EOF ;
    public final void entryRuleTemplateBody() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:174:1: ( ruleTemplateBody EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:175:1: ruleTemplateBody EOF
            {
             before(grammarAccess.getTemplateBodyRule()); 
            pushFollow(FOLLOW_ruleTemplateBody_in_entryRuleTemplateBody260);
            ruleTemplateBody();

            state._fsp--;

             after(grammarAccess.getTemplateBodyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTemplateBody267); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:185:1: ruleTemplateBody : ( ( rule__TemplateBody__Group__0 ) ) ;
    public final void ruleTemplateBody() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:190:5: ( ( ( rule__TemplateBody__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:191:1: ( ( rule__TemplateBody__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:191:1: ( ( rule__TemplateBody__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:192:1: ( rule__TemplateBody__Group__0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:193:1: ( rule__TemplateBody__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:193:2: rule__TemplateBody__Group__0
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group__0_in_ruleTemplateBody301);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:208:1: entryRuleVariableOrDollar : ruleVariableOrDollar EOF ;
    public final void entryRuleVariableOrDollar() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:212:1: ( ruleVariableOrDollar EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:213:1: ruleVariableOrDollar EOF
            {
             before(grammarAccess.getVariableOrDollarRule()); 
            pushFollow(FOLLOW_ruleVariableOrDollar_in_entryRuleVariableOrDollar335);
            ruleVariableOrDollar();

            state._fsp--;

             after(grammarAccess.getVariableOrDollarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableOrDollar342); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:223:1: ruleVariableOrDollar : ( ( rule__VariableOrDollar__Alternatives ) ) ;
    public final void ruleVariableOrDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:228:5: ( ( ( rule__VariableOrDollar__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:229:1: ( ( rule__VariableOrDollar__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:229:1: ( ( rule__VariableOrDollar__Alternatives ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:230:1: ( rule__VariableOrDollar__Alternatives )
            {
             before(grammarAccess.getVariableOrDollarAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:231:1: ( rule__VariableOrDollar__Alternatives )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:231:2: rule__VariableOrDollar__Alternatives
            {
            pushFollow(FOLLOW_rule__VariableOrDollar__Alternatives_in_ruleVariableOrDollar376);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:244:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:248:1: ( ruleVariable EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:249:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable408);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable415); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:259:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:264:5: ( ( ( rule__Variable__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:265:1: ( ( rule__Variable__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:265:1: ( ( rule__Variable__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:266:1: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:267:1: ( rule__Variable__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:267:2: rule__Variable__Group__0
            {
            pushFollow(FOLLOW_rule__Variable__Group__0_in_ruleVariable449);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:280:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:284:1: ( ruleValidID EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:285:1: ruleValidID EOF
            {
             before(grammarAccess.getValidIDRule()); 
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID481);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getValidIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID488); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:295:1: ruleValidID : ( ( rule__ValidID__Alternatives ) ) ;
    public final void ruleValidID() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:300:5: ( ( ( rule__ValidID__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:301:1: ( ( rule__ValidID__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:301:1: ( ( rule__ValidID__Alternatives ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:302:1: ( rule__ValidID__Alternatives )
            {
             before(grammarAccess.getValidIDAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:303:1: ( rule__ValidID__Alternatives )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:303:2: rule__ValidID__Alternatives
            {
            pushFollow(FOLLOW_rule__ValidID__Alternatives_in_ruleValidID522);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:316:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:320:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:321:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN554);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN561); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:331:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:336:5: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:337:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:337:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:338:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:339:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:339:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN595);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:352:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:356:1: ( ruleLiteral EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:357:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral627);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral634); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:367:1: ruleLiteral : ( ( rule__Literal__ValueAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:372:5: ( ( ( rule__Literal__ValueAssignment ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:373:1: ( ( rule__Literal__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:373:1: ( ( rule__Literal__ValueAssignment ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:374:1: ( rule__Literal__ValueAssignment )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:375:1: ( rule__Literal__ValueAssignment )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:375:2: rule__Literal__ValueAssignment
            {
            pushFollow(FOLLOW_rule__Literal__ValueAssignment_in_ruleLiteral668);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:388:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:392:1: ( ruleLiteralValue EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:393:1: ruleLiteralValue EOF
            {
             before(grammarAccess.getLiteralValueRule()); 
            pushFollow(FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue700);
            ruleLiteralValue();

            state._fsp--;

             after(grammarAccess.getLiteralValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralValue707); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:403:1: ruleLiteralValue : ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) ;
    public final void ruleLiteralValue() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:408:5: ( ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:409:1: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:409:1: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:410:1: ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:410:1: ( ( rule__LiteralValue__Alternatives ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:411:1: ( rule__LiteralValue__Alternatives )
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:412:1: ( rule__LiteralValue__Alternatives )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:412:2: rule__LiteralValue__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralValue__Alternatives_in_ruleLiteralValue743);
            rule__LiteralValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralValueAccess().getAlternatives()); 

            }

            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:415:1: ( ( rule__LiteralValue__Alternatives )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:416:1: ( rule__LiteralValue__Alternatives )*
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:417:1: ( rule__LiteralValue__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==KEYWORD_12||LA1_0==RULE_ID||(LA1_0>=RULE_WS && LA1_0<=RULE_ANY_OTHER)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:417:2: rule__LiteralValue__Alternatives
            	    {
            	    pushFollow(FOLLOW_rule__LiteralValue__Alternatives_in_ruleLiteralValue755);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:431:1: entryRuleDollar : ruleDollar EOF ;
    public final void entryRuleDollar() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:435:1: ( ruleDollar EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:436:1: ruleDollar EOF
            {
             before(grammarAccess.getDollarRule()); 
            pushFollow(FOLLOW_ruleDollar_in_entryRuleDollar790);
            ruleDollar();

            state._fsp--;

             after(grammarAccess.getDollarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDollar797); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:446:1: ruleDollar : ( ( rule__Dollar__Group__0 ) ) ;
    public final void ruleDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:451:5: ( ( ( rule__Dollar__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:452:1: ( ( rule__Dollar__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:452:1: ( ( rule__Dollar__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:453:1: ( rule__Dollar__Group__0 )
            {
             before(grammarAccess.getDollarAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:454:1: ( rule__Dollar__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:454:2: rule__Dollar__Group__0
            {
            pushFollow(FOLLOW_rule__Dollar__Group__0_in_ruleDollar831);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:467:1: rule__Codetemplate__Alternatives_7 : ( ( ( rule__Codetemplate__ContextAssignment_7_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_7_1 ) ) );
    public final void rule__Codetemplate__Alternatives_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:471:1: ( ( ( rule__Codetemplate__ContextAssignment_7_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_7_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==KEYWORD_14||LA2_0==KEYWORD_13||LA2_0==RULE_ID) ) {
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
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:472:1: ( ( rule__Codetemplate__ContextAssignment_7_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:472:1: ( ( rule__Codetemplate__ContextAssignment_7_0 ) )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:473:1: ( rule__Codetemplate__ContextAssignment_7_0 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getContextAssignment_7_0()); 
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:474:1: ( rule__Codetemplate__ContextAssignment_7_0 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:474:2: rule__Codetemplate__ContextAssignment_7_0
                    {
                    pushFollow(FOLLOW_rule__Codetemplate__ContextAssignment_7_0_in_rule__Codetemplate__Alternatives_7867);
                    rule__Codetemplate__ContextAssignment_7_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCodetemplateAccess().getContextAssignment_7_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:478:6: ( ( rule__Codetemplate__KeywordContextAssignment_7_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:478:6: ( ( rule__Codetemplate__KeywordContextAssignment_7_1 ) )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:479:1: ( rule__Codetemplate__KeywordContextAssignment_7_1 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getKeywordContextAssignment_7_1()); 
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:480:1: ( rule__Codetemplate__KeywordContextAssignment_7_1 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:480:2: rule__Codetemplate__KeywordContextAssignment_7_1
                    {
                    pushFollow(FOLLOW_rule__Codetemplate__KeywordContextAssignment_7_1_in_rule__Codetemplate__Alternatives_7885);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:490:1: rule__VariableOrDollar__Alternatives : ( ( ruleVariable ) | ( ruleDollar ) );
    public final void rule__VariableOrDollar__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:494:1: ( ( ruleVariable ) | ( ruleDollar ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==KEYWORD_9) ) {
                alt3=1;
            }
            else if ( (LA3_0==KEYWORD_8||LA3_0==KEYWORD_1) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:495:1: ( ruleVariable )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:495:1: ( ruleVariable )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:496:1: ruleVariable
                    {
                     before(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleVariable_in_rule__VariableOrDollar__Alternatives919);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:501:6: ( ruleDollar )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:501:6: ( ruleDollar )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:502:1: ruleDollar
                    {
                     before(grammarAccess.getVariableOrDollarAccess().getDollarParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDollar_in_rule__VariableOrDollar__Alternatives936);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:512:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );
    public final void rule__Variable__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:516:1: ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:517:1: ( ( rule__Variable__NameAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:517:1: ( ( rule__Variable__NameAssignment_2_0 ) )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:518:1: ( rule__Variable__NameAssignment_2_0 )
                    {
                     before(grammarAccess.getVariableAccess().getNameAssignment_2_0()); 
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:519:1: ( rule__Variable__NameAssignment_2_0 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:519:2: rule__Variable__NameAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__Variable__NameAssignment_2_0_in_rule__Variable__Alternatives_2968);
                    rule__Variable__NameAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVariableAccess().getNameAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:523:6: ( ( rule__Variable__Group_2_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:523:6: ( ( rule__Variable__Group_2_1__0 ) )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:524:1: ( rule__Variable__Group_2_1__0 )
                    {
                     before(grammarAccess.getVariableAccess().getGroup_2_1()); 
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:525:1: ( rule__Variable__Group_2_1__0 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:525:2: rule__Variable__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Variable__Group_2_1__0_in_rule__Variable__Alternatives_2986);
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


    // $ANTLR start "rule__Variable__ParametersAlternatives_2_1_4_3_0"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:534:1: rule__Variable__ParametersAlternatives_2_1_4_3_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:538:1: ( ( RULE_STRING ) | ( ruleFQN ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==KEYWORD_14||LA5_0==KEYWORD_13||LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:539:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:539:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:540:1: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Variable__ParametersAlternatives_2_1_4_3_01019); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:545:6: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:545:6: ( ruleFQN )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:546:1: ruleFQN
                    {
                     before(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_1()); 
                    pushFollow(FOLLOW_ruleFQN_in_rule__Variable__ParametersAlternatives_2_1_4_3_01036);
                    ruleFQN();

                    state._fsp--;

                     after(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_1()); 

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
    // $ANTLR end "rule__Variable__ParametersAlternatives_2_1_4_3_0"


    // $ANTLR start "rule__Variable__ParametersAlternatives_2_1_4_4_3_0"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:556:1: rule__Variable__ParametersAlternatives_2_1_4_4_3_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:560:1: ( ( RULE_STRING ) | ( ruleFQN ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==KEYWORD_14||LA6_0==KEYWORD_13||LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:561:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:561:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:562:1: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_4_3_0_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Variable__ParametersAlternatives_2_1_4_4_3_01068); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_4_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:567:6: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:567:6: ( ruleFQN )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:568:1: ruleFQN
                    {
                     before(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_4_3_0_1()); 
                    pushFollow(FOLLOW_ruleFQN_in_rule__Variable__ParametersAlternatives_2_1_4_4_3_01085);
                    ruleFQN();

                    state._fsp--;

                     after(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_4_3_0_1()); 

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
    // $ANTLR end "rule__Variable__ParametersAlternatives_2_1_4_4_3_0"


    // $ANTLR start "rule__ValidID__Alternatives"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:578:1: rule__ValidID__Alternatives : ( ( RULE_ID ) | ( KEYWORD_13 ) | ( KEYWORD_14 ) );
    public final void rule__ValidID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:582:1: ( ( RULE_ID ) | ( KEYWORD_13 ) | ( KEYWORD_14 ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt7=1;
                }
                break;
            case KEYWORD_13:
                {
                alt7=2;
                }
                break;
            case KEYWORD_14:
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
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:583:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:583:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:584:1: RULE_ID
                    {
                     before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ValidID__Alternatives1117); 
                     after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:589:6: ( KEYWORD_13 )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:589:6: ( KEYWORD_13 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:590:1: KEYWORD_13
                    {
                     before(grammarAccess.getValidIDAccess().getForKeyword_1()); 
                    match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_rule__ValidID__Alternatives1135); 
                     after(grammarAccess.getValidIDAccess().getForKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:597:6: ( KEYWORD_14 )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:597:6: ( KEYWORD_14 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:598:1: KEYWORD_14
                    {
                     before(grammarAccess.getValidIDAccess().getTemplatesKeyword_2()); 
                    match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_rule__ValidID__Alternatives1155); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:610:1: rule__LiteralValue__Alternatives : ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) | ( KEYWORD_12 ) );
    public final void rule__LiteralValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:614:1: ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) | ( KEYWORD_12 ) )
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
            case KEYWORD_12:
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
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:615:1: ( RULE_WS )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:615:1: ( RULE_WS )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:616:1: RULE_WS
                    {
                     before(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 
                    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__LiteralValue__Alternatives1189); 
                     after(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:621:6: ( RULE_ANY_OTHER )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:621:6: ( RULE_ANY_OTHER )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:622:1: RULE_ANY_OTHER
                    {
                     before(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 
                    match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_rule__LiteralValue__Alternatives1206); 
                     after(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:627:6: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:627:6: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:628:1: RULE_ID
                    {
                     before(grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LiteralValue__Alternatives1223); 
                     after(grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:633:6: ( KEYWORD_12 )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:633:6: ( KEYWORD_12 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:634:1: KEYWORD_12
                    {
                     before(grammarAccess.getLiteralValueAccess().getReverseSolidusLessThanSignLessThanSignKeyword_3()); 
                    match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_rule__LiteralValue__Alternatives1241); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:646:1: rule__Dollar__Alternatives_1 : ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( KEYWORD_1 ) );
    public final void rule__Dollar__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:650:1: ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( KEYWORD_1 ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==KEYWORD_8) ) {
                alt9=1;
            }
            else if ( (LA9_0==KEYWORD_1) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:651:1: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:651:1: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:652:1: ( rule__Dollar__EscapedAssignment_1_0 )
                    {
                     before(grammarAccess.getDollarAccess().getEscapedAssignment_1_0()); 
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:653:1: ( rule__Dollar__EscapedAssignment_1_0 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:653:2: rule__Dollar__EscapedAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__Dollar__EscapedAssignment_1_0_in_rule__Dollar__Alternatives_11275);
                    rule__Dollar__EscapedAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDollarAccess().getEscapedAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:657:6: ( KEYWORD_1 )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:657:6: ( KEYWORD_1 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:658:1: KEYWORD_1
                    {
                     before(grammarAccess.getDollarAccess().getDollarSignKeyword_1_1()); 
                    match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_rule__Dollar__Alternatives_11294); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:672:1: rule__Codetemplates__Group__0 : rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 ;
    public final void rule__Codetemplates__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:676:1: ( rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:677:2: rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1
            {
            pushFollow(FOLLOW_rule__Codetemplates__Group__0__Impl_in_rule__Codetemplates__Group__01326);
            rule__Codetemplates__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplates__Group__1_in_rule__Codetemplates__Group__01329);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:684:1: rule__Codetemplates__Group__0__Impl : ( KEYWORD_14 ) ;
    public final void rule__Codetemplates__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:688:1: ( ( KEYWORD_14 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:689:1: ( KEYWORD_14 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:689:1: ( KEYWORD_14 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:690:1: KEYWORD_14
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesKeyword_0()); 
            match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_rule__Codetemplates__Group__0__Impl1357); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:703:1: rule__Codetemplates__Group__1 : rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 ;
    public final void rule__Codetemplates__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:707:1: ( rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:708:2: rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2
            {
            pushFollow(FOLLOW_rule__Codetemplates__Group__1__Impl_in_rule__Codetemplates__Group__11388);
            rule__Codetemplates__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplates__Group__2_in_rule__Codetemplates__Group__11391);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:715:1: rule__Codetemplates__Group__1__Impl : ( KEYWORD_13 ) ;
    public final void rule__Codetemplates__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:719:1: ( ( KEYWORD_13 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:720:1: ( KEYWORD_13 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:720:1: ( KEYWORD_13 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:721:1: KEYWORD_13
            {
             before(grammarAccess.getCodetemplatesAccess().getForKeyword_1()); 
            match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_rule__Codetemplates__Group__1__Impl1419); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:734:1: rule__Codetemplates__Group__2 : rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 ;
    public final void rule__Codetemplates__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:738:1: ( rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:739:2: rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3
            {
            pushFollow(FOLLOW_rule__Codetemplates__Group__2__Impl_in_rule__Codetemplates__Group__21450);
            rule__Codetemplates__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplates__Group__3_in_rule__Codetemplates__Group__21453);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:746:1: rule__Codetemplates__Group__2__Impl : ( ( rule__Codetemplates__LanguageAssignment_2 ) ) ;
    public final void rule__Codetemplates__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:750:1: ( ( ( rule__Codetemplates__LanguageAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:751:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:751:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:752:1: ( rule__Codetemplates__LanguageAssignment_2 )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageAssignment_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:753:1: ( rule__Codetemplates__LanguageAssignment_2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:753:2: rule__Codetemplates__LanguageAssignment_2
            {
            pushFollow(FOLLOW_rule__Codetemplates__LanguageAssignment_2_in_rule__Codetemplates__Group__2__Impl1480);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:763:1: rule__Codetemplates__Group__3 : rule__Codetemplates__Group__3__Impl rule__Codetemplates__Group__4 ;
    public final void rule__Codetemplates__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:767:1: ( rule__Codetemplates__Group__3__Impl rule__Codetemplates__Group__4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:768:2: rule__Codetemplates__Group__3__Impl rule__Codetemplates__Group__4
            {
            pushFollow(FOLLOW_rule__Codetemplates__Group__3__Impl_in_rule__Codetemplates__Group__31510);
            rule__Codetemplates__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplates__Group__4_in_rule__Codetemplates__Group__31513);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:775:1: rule__Codetemplates__Group__3__Impl : ( KEYWORD_6 ) ;
    public final void rule__Codetemplates__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:779:1: ( ( KEYWORD_6 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:780:1: ( KEYWORD_6 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:780:1: ( KEYWORD_6 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:781:1: KEYWORD_6
            {
             before(grammarAccess.getCodetemplatesAccess().getColonKeyword_3()); 
            match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_rule__Codetemplates__Group__3__Impl1541); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:794:1: rule__Codetemplates__Group__4 : rule__Codetemplates__Group__4__Impl ;
    public final void rule__Codetemplates__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:798:1: ( rule__Codetemplates__Group__4__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:799:2: rule__Codetemplates__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Codetemplates__Group__4__Impl_in_rule__Codetemplates__Group__41572);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:805:1: rule__Codetemplates__Group__4__Impl : ( ( rule__Codetemplates__TemplatesAssignment_4 )* ) ;
    public final void rule__Codetemplates__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:809:1: ( ( ( rule__Codetemplates__TemplatesAssignment_4 )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:810:1: ( ( rule__Codetemplates__TemplatesAssignment_4 )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:810:1: ( ( rule__Codetemplates__TemplatesAssignment_4 )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:811:1: ( rule__Codetemplates__TemplatesAssignment_4 )*
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesAssignment_4()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:812:1: ( rule__Codetemplates__TemplatesAssignment_4 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==KEYWORD_14||LA10_0==KEYWORD_13||LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:812:2: rule__Codetemplates__TemplatesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Codetemplates__TemplatesAssignment_4_in_rule__Codetemplates__Group__4__Impl1599);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:832:1: rule__Codetemplate__Group__0 : rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 ;
    public final void rule__Codetemplate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:836:1: ( rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:837:2: rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__0__Impl_in_rule__Codetemplate__Group__01640);
            rule__Codetemplate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__1_in_rule__Codetemplate__Group__01643);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:844:1: rule__Codetemplate__Group__0__Impl : ( ( rule__Codetemplate__NameAssignment_0 ) ) ;
    public final void rule__Codetemplate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:848:1: ( ( ( rule__Codetemplate__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:849:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:849:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:850:1: ( rule__Codetemplate__NameAssignment_0 )
            {
             before(grammarAccess.getCodetemplateAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:851:1: ( rule__Codetemplate__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:851:2: rule__Codetemplate__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Codetemplate__NameAssignment_0_in_rule__Codetemplate__Group__0__Impl1670);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:861:1: rule__Codetemplate__Group__1 : rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 ;
    public final void rule__Codetemplate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:865:1: ( rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:866:2: rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__1__Impl_in_rule__Codetemplate__Group__11700);
            rule__Codetemplate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__2_in_rule__Codetemplate__Group__11703);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:873:1: rule__Codetemplate__Group__1__Impl : ( KEYWORD_2 ) ;
    public final void rule__Codetemplate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:877:1: ( ( KEYWORD_2 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:878:1: ( KEYWORD_2 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:878:1: ( KEYWORD_2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:879:1: KEYWORD_2
            {
             before(grammarAccess.getCodetemplateAccess().getLeftParenthesisKeyword_1()); 
            match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_rule__Codetemplate__Group__1__Impl1731); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:892:1: rule__Codetemplate__Group__2 : rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 ;
    public final void rule__Codetemplate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:896:1: ( rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:897:2: rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__2__Impl_in_rule__Codetemplate__Group__21762);
            rule__Codetemplate__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__3_in_rule__Codetemplate__Group__21765);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:904:1: rule__Codetemplate__Group__2__Impl : ( ( rule__Codetemplate__IdAssignment_2 ) ) ;
    public final void rule__Codetemplate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:908:1: ( ( ( rule__Codetemplate__IdAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:909:1: ( ( rule__Codetemplate__IdAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:909:1: ( ( rule__Codetemplate__IdAssignment_2 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:910:1: ( rule__Codetemplate__IdAssignment_2 )
            {
             before(grammarAccess.getCodetemplateAccess().getIdAssignment_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:911:1: ( rule__Codetemplate__IdAssignment_2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:911:2: rule__Codetemplate__IdAssignment_2
            {
            pushFollow(FOLLOW_rule__Codetemplate__IdAssignment_2_in_rule__Codetemplate__Group__2__Impl1792);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:921:1: rule__Codetemplate__Group__3 : rule__Codetemplate__Group__3__Impl rule__Codetemplate__Group__4 ;
    public final void rule__Codetemplate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:925:1: ( rule__Codetemplate__Group__3__Impl rule__Codetemplate__Group__4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:926:2: rule__Codetemplate__Group__3__Impl rule__Codetemplate__Group__4
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__3__Impl_in_rule__Codetemplate__Group__31822);
            rule__Codetemplate__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__4_in_rule__Codetemplate__Group__31825);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:933:1: rule__Codetemplate__Group__3__Impl : ( KEYWORD_4 ) ;
    public final void rule__Codetemplate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:937:1: ( ( KEYWORD_4 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:938:1: ( KEYWORD_4 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:938:1: ( KEYWORD_4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:939:1: KEYWORD_4
            {
             before(grammarAccess.getCodetemplateAccess().getCommaKeyword_3()); 
            match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_rule__Codetemplate__Group__3__Impl1853); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:952:1: rule__Codetemplate__Group__4 : rule__Codetemplate__Group__4__Impl rule__Codetemplate__Group__5 ;
    public final void rule__Codetemplate__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:956:1: ( rule__Codetemplate__Group__4__Impl rule__Codetemplate__Group__5 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:957:2: rule__Codetemplate__Group__4__Impl rule__Codetemplate__Group__5
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__4__Impl_in_rule__Codetemplate__Group__41884);
            rule__Codetemplate__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__5_in_rule__Codetemplate__Group__41887);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:964:1: rule__Codetemplate__Group__4__Impl : ( ( rule__Codetemplate__DescriptionAssignment_4 ) ) ;
    public final void rule__Codetemplate__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:968:1: ( ( ( rule__Codetemplate__DescriptionAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:969:1: ( ( rule__Codetemplate__DescriptionAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:969:1: ( ( rule__Codetemplate__DescriptionAssignment_4 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:970:1: ( rule__Codetemplate__DescriptionAssignment_4 )
            {
             before(grammarAccess.getCodetemplateAccess().getDescriptionAssignment_4()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:971:1: ( rule__Codetemplate__DescriptionAssignment_4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:971:2: rule__Codetemplate__DescriptionAssignment_4
            {
            pushFollow(FOLLOW_rule__Codetemplate__DescriptionAssignment_4_in_rule__Codetemplate__Group__4__Impl1914);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:981:1: rule__Codetemplate__Group__5 : rule__Codetemplate__Group__5__Impl rule__Codetemplate__Group__6 ;
    public final void rule__Codetemplate__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:985:1: ( rule__Codetemplate__Group__5__Impl rule__Codetemplate__Group__6 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:986:2: rule__Codetemplate__Group__5__Impl rule__Codetemplate__Group__6
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__5__Impl_in_rule__Codetemplate__Group__51944);
            rule__Codetemplate__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__6_in_rule__Codetemplate__Group__51947);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:993:1: rule__Codetemplate__Group__5__Impl : ( KEYWORD_3 ) ;
    public final void rule__Codetemplate__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:997:1: ( ( KEYWORD_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:998:1: ( KEYWORD_3 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:998:1: ( KEYWORD_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:999:1: KEYWORD_3
            {
             before(grammarAccess.getCodetemplateAccess().getRightParenthesisKeyword_5()); 
            match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_rule__Codetemplate__Group__5__Impl1975); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1012:1: rule__Codetemplate__Group__6 : rule__Codetemplate__Group__6__Impl rule__Codetemplate__Group__7 ;
    public final void rule__Codetemplate__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1016:1: ( rule__Codetemplate__Group__6__Impl rule__Codetemplate__Group__7 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1017:2: rule__Codetemplate__Group__6__Impl rule__Codetemplate__Group__7
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__6__Impl_in_rule__Codetemplate__Group__62006);
            rule__Codetemplate__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__7_in_rule__Codetemplate__Group__62009);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1024:1: rule__Codetemplate__Group__6__Impl : ( KEYWORD_13 ) ;
    public final void rule__Codetemplate__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1028:1: ( ( KEYWORD_13 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1029:1: ( KEYWORD_13 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1029:1: ( KEYWORD_13 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1030:1: KEYWORD_13
            {
             before(grammarAccess.getCodetemplateAccess().getForKeyword_6()); 
            match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_rule__Codetemplate__Group__6__Impl2037); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1043:1: rule__Codetemplate__Group__7 : rule__Codetemplate__Group__7__Impl rule__Codetemplate__Group__8 ;
    public final void rule__Codetemplate__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1047:1: ( rule__Codetemplate__Group__7__Impl rule__Codetemplate__Group__8 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1048:2: rule__Codetemplate__Group__7__Impl rule__Codetemplate__Group__8
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__7__Impl_in_rule__Codetemplate__Group__72068);
            rule__Codetemplate__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__8_in_rule__Codetemplate__Group__72071);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1055:1: rule__Codetemplate__Group__7__Impl : ( ( rule__Codetemplate__Alternatives_7 ) ) ;
    public final void rule__Codetemplate__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1059:1: ( ( ( rule__Codetemplate__Alternatives_7 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1060:1: ( ( rule__Codetemplate__Alternatives_7 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1060:1: ( ( rule__Codetemplate__Alternatives_7 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1061:1: ( rule__Codetemplate__Alternatives_7 )
            {
             before(grammarAccess.getCodetemplateAccess().getAlternatives_7()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1062:1: ( rule__Codetemplate__Alternatives_7 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1062:2: rule__Codetemplate__Alternatives_7
            {
            pushFollow(FOLLOW_rule__Codetemplate__Alternatives_7_in_rule__Codetemplate__Group__7__Impl2098);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1072:1: rule__Codetemplate__Group__8 : rule__Codetemplate__Group__8__Impl ;
    public final void rule__Codetemplate__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1076:1: ( rule__Codetemplate__Group__8__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1077:2: rule__Codetemplate__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__8__Impl_in_rule__Codetemplate__Group__82128);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1083:1: rule__Codetemplate__Group__8__Impl : ( ( rule__Codetemplate__BodyAssignment_8 ) ) ;
    public final void rule__Codetemplate__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1087:1: ( ( ( rule__Codetemplate__BodyAssignment_8 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1088:1: ( ( rule__Codetemplate__BodyAssignment_8 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1088:1: ( ( rule__Codetemplate__BodyAssignment_8 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1089:1: ( rule__Codetemplate__BodyAssignment_8 )
            {
             before(grammarAccess.getCodetemplateAccess().getBodyAssignment_8()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1090:1: ( rule__Codetemplate__BodyAssignment_8 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1090:2: rule__Codetemplate__BodyAssignment_8
            {
            pushFollow(FOLLOW_rule__Codetemplate__BodyAssignment_8_in_rule__Codetemplate__Group__8__Impl2155);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1118:1: rule__TemplateBodyWithQuotes__Group__0 : rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 ;
    public final void rule__TemplateBodyWithQuotes__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1122:1: ( rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1123:2: rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1
            {
            pushFollow(FOLLOW_rule__TemplateBodyWithQuotes__Group__0__Impl_in_rule__TemplateBodyWithQuotes__Group__02203);
            rule__TemplateBodyWithQuotes__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TemplateBodyWithQuotes__Group__1_in_rule__TemplateBodyWithQuotes__Group__02206);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1130:1: rule__TemplateBodyWithQuotes__Group__0__Impl : ( KEYWORD_11 ) ;
    public final void rule__TemplateBodyWithQuotes__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1134:1: ( ( KEYWORD_11 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1135:1: ( KEYWORD_11 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1135:1: ( KEYWORD_11 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1136:1: KEYWORD_11
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_0()); 
            match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_rule__TemplateBodyWithQuotes__Group__0__Impl2234); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1149:1: rule__TemplateBodyWithQuotes__Group__1 : rule__TemplateBodyWithQuotes__Group__1__Impl rule__TemplateBodyWithQuotes__Group__2 ;
    public final void rule__TemplateBodyWithQuotes__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1153:1: ( rule__TemplateBodyWithQuotes__Group__1__Impl rule__TemplateBodyWithQuotes__Group__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1154:2: rule__TemplateBodyWithQuotes__Group__1__Impl rule__TemplateBodyWithQuotes__Group__2
            {
            pushFollow(FOLLOW_rule__TemplateBodyWithQuotes__Group__1__Impl_in_rule__TemplateBodyWithQuotes__Group__12265);
            rule__TemplateBodyWithQuotes__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TemplateBodyWithQuotes__Group__2_in_rule__TemplateBodyWithQuotes__Group__12268);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1161:1: rule__TemplateBodyWithQuotes__Group__1__Impl : ( ruleTemplateBody ) ;
    public final void rule__TemplateBodyWithQuotes__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1165:1: ( ( ruleTemplateBody ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1166:1: ( ruleTemplateBody )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1166:1: ( ruleTemplateBody )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1167:1: ruleTemplateBody
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleTemplateBody_in_rule__TemplateBodyWithQuotes__Group__1__Impl2295);
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


    // $ANTLR start "rule__TemplateBodyWithQuotes__Group__2"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1178:1: rule__TemplateBodyWithQuotes__Group__2 : rule__TemplateBodyWithQuotes__Group__2__Impl ;
    public final void rule__TemplateBodyWithQuotes__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1182:1: ( rule__TemplateBodyWithQuotes__Group__2__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1183:2: rule__TemplateBodyWithQuotes__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TemplateBodyWithQuotes__Group__2__Impl_in_rule__TemplateBodyWithQuotes__Group__22324);
            rule__TemplateBodyWithQuotes__Group__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1189:1: rule__TemplateBodyWithQuotes__Group__2__Impl : ( KEYWORD_10 ) ;
    public final void rule__TemplateBodyWithQuotes__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1193:1: ( ( KEYWORD_10 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1194:1: ( KEYWORD_10 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1194:1: ( KEYWORD_10 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1195:1: KEYWORD_10
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getLessThanSignLessThanSignKeyword_2()); 
            match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_rule__TemplateBodyWithQuotes__Group__2__Impl2352); 
             after(grammarAccess.getTemplateBodyWithQuotesAccess().getLessThanSignLessThanSignKeyword_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__TemplateBody__Group__0"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1214:1: rule__TemplateBody__Group__0 : rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 ;
    public final void rule__TemplateBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1218:1: ( rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1219:2: rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group__0__Impl_in_rule__TemplateBody__Group__02389);
            rule__TemplateBody__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TemplateBody__Group__1_in_rule__TemplateBody__Group__02392);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1226:1: rule__TemplateBody__Group__0__Impl : ( () ) ;
    public final void rule__TemplateBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1230:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1231:1: ( () )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1231:1: ( () )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1232:1: ()
            {
             before(grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1233:1: ()
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1235:1: 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1245:1: rule__TemplateBody__Group__1 : rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 ;
    public final void rule__TemplateBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1249:1: ( rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1250:2: rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group__1__Impl_in_rule__TemplateBody__Group__12450);
            rule__TemplateBody__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TemplateBody__Group__2_in_rule__TemplateBody__Group__12453);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1257:1: rule__TemplateBody__Group__1__Impl : ( ( rule__TemplateBody__PartsAssignment_1 )? ) ;
    public final void rule__TemplateBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1261:1: ( ( ( rule__TemplateBody__PartsAssignment_1 )? ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1262:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1262:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1263:1: ( rule__TemplateBody__PartsAssignment_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1264:1: ( rule__TemplateBody__PartsAssignment_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==KEYWORD_12||LA11_0==RULE_ID||(LA11_0>=RULE_WS && LA11_0<=RULE_ANY_OTHER)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1264:2: rule__TemplateBody__PartsAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TemplateBody__PartsAssignment_1_in_rule__TemplateBody__Group__1__Impl2480);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1274:1: rule__TemplateBody__Group__2 : rule__TemplateBody__Group__2__Impl ;
    public final void rule__TemplateBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1278:1: ( rule__TemplateBody__Group__2__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1279:2: rule__TemplateBody__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group__2__Impl_in_rule__TemplateBody__Group__22511);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1285:1: rule__TemplateBody__Group__2__Impl : ( ( rule__TemplateBody__Group_2__0 )* ) ;
    public final void rule__TemplateBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1289:1: ( ( ( rule__TemplateBody__Group_2__0 )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1290:1: ( ( rule__TemplateBody__Group_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1290:1: ( ( rule__TemplateBody__Group_2__0 )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1291:1: ( rule__TemplateBody__Group_2__0 )*
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1292:1: ( rule__TemplateBody__Group_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=KEYWORD_8 && LA12_0<=KEYWORD_9)||LA12_0==KEYWORD_1) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1292:2: rule__TemplateBody__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__TemplateBody__Group_2__0_in_rule__TemplateBody__Group__2__Impl2538);
            	    rule__TemplateBody__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1308:1: rule__TemplateBody__Group_2__0 : rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 ;
    public final void rule__TemplateBody__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1312:1: ( rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1313:2: rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group_2__0__Impl_in_rule__TemplateBody__Group_2__02575);
            rule__TemplateBody__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TemplateBody__Group_2__1_in_rule__TemplateBody__Group_2__02578);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1320:1: rule__TemplateBody__Group_2__0__Impl : ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) ;
    public final void rule__TemplateBody__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1324:1: ( ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1325:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1325:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1326:1: ( rule__TemplateBody__PartsAssignment_2_0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1327:1: ( rule__TemplateBody__PartsAssignment_2_0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1327:2: rule__TemplateBody__PartsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__TemplateBody__PartsAssignment_2_0_in_rule__TemplateBody__Group_2__0__Impl2605);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1337:1: rule__TemplateBody__Group_2__1 : rule__TemplateBody__Group_2__1__Impl ;
    public final void rule__TemplateBody__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1341:1: ( rule__TemplateBody__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1342:2: rule__TemplateBody__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group_2__1__Impl_in_rule__TemplateBody__Group_2__12635);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1348:1: rule__TemplateBody__Group_2__1__Impl : ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) ;
    public final void rule__TemplateBody__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1352:1: ( ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1353:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1353:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1354:1: ( rule__TemplateBody__PartsAssignment_2_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1355:1: ( rule__TemplateBody__PartsAssignment_2_1 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==KEYWORD_12||LA13_0==RULE_ID||(LA13_0>=RULE_WS && LA13_0<=RULE_ANY_OTHER)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1355:2: rule__TemplateBody__PartsAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__TemplateBody__PartsAssignment_2_1_in_rule__TemplateBody__Group_2__1__Impl2662);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1369:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1373:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1374:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__02697);
            rule__Variable__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__02700);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1381:1: rule__Variable__Group__0__Impl : ( KEYWORD_9 ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1385:1: ( ( KEYWORD_9 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1386:1: ( KEYWORD_9 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1386:1: ( KEYWORD_9 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1387:1: KEYWORD_9
            {
             before(grammarAccess.getVariableAccess().getDollarSignLeftCurlyBracketKeyword_0()); 
            match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_rule__Variable__Group__0__Impl2728); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1400:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1404:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1405:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__12759);
            rule__Variable__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__12762);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1412:1: rule__Variable__Group__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1416:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1417:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1417:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1418:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1419:1: ( RULE_WS )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_WS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1419:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group__1__Impl2790); 

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1429:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1433:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1434:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
            {
            pushFollow(FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__22821);
            rule__Variable__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group__3_in_rule__Variable__Group__22824);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1441:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Alternatives_2 ) ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1445:1: ( ( ( rule__Variable__Alternatives_2 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1446:1: ( ( rule__Variable__Alternatives_2 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1446:1: ( ( rule__Variable__Alternatives_2 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1447:1: ( rule__Variable__Alternatives_2 )
            {
             before(grammarAccess.getVariableAccess().getAlternatives_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1448:1: ( rule__Variable__Alternatives_2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1448:2: rule__Variable__Alternatives_2
            {
            pushFollow(FOLLOW_rule__Variable__Alternatives_2_in_rule__Variable__Group__2__Impl2851);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1458:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl rule__Variable__Group__4 ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1462:1: ( rule__Variable__Group__3__Impl rule__Variable__Group__4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1463:2: rule__Variable__Group__3__Impl rule__Variable__Group__4
            {
            pushFollow(FOLLOW_rule__Variable__Group__3__Impl_in_rule__Variable__Group__32881);
            rule__Variable__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group__4_in_rule__Variable__Group__32884);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1470:1: rule__Variable__Group__3__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1474:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1475:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1475:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1476:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_3()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1477:1: ( RULE_WS )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_WS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1477:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group__3__Impl2912); 

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1487:1: rule__Variable__Group__4 : rule__Variable__Group__4__Impl ;
    public final void rule__Variable__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1491:1: ( rule__Variable__Group__4__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1492:2: rule__Variable__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group__4__Impl_in_rule__Variable__Group__42943);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1498:1: rule__Variable__Group__4__Impl : ( KEYWORD_7 ) ;
    public final void rule__Variable__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1502:1: ( ( KEYWORD_7 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1503:1: ( KEYWORD_7 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1503:1: ( KEYWORD_7 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1504:1: KEYWORD_7
            {
             before(grammarAccess.getVariableAccess().getRightCurlyBracketKeyword_4()); 
            match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_rule__Variable__Group__4__Impl2971); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1527:1: rule__Variable__Group_2_1__0 : rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 ;
    public final void rule__Variable__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1531:1: ( rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1532:2: rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1__0__Impl_in_rule__Variable__Group_2_1__03012);
            rule__Variable__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1__1_in_rule__Variable__Group_2_1__03015);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1539:1: rule__Variable__Group_2_1__0__Impl : ( ( rule__Variable__Group_2_1_0__0 )? ) ;
    public final void rule__Variable__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1543:1: ( ( ( rule__Variable__Group_2_1_0__0 )? ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1544:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1544:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1545:1: ( rule__Variable__Group_2_1_0__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1546:1: ( rule__Variable__Group_2_1_0__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==KEYWORD_14||LA16_0==KEYWORD_13||LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1546:2: rule__Variable__Group_2_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Variable__Group_2_1_0__0_in_rule__Variable__Group_2_1__0__Impl3042);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1556:1: rule__Variable__Group_2_1__1 : rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 ;
    public final void rule__Variable__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1560:1: ( rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1561:2: rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1__1__Impl_in_rule__Variable__Group_2_1__13073);
            rule__Variable__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1__2_in_rule__Variable__Group_2_1__13076);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1568:1: rule__Variable__Group_2_1__1__Impl : ( KEYWORD_6 ) ;
    public final void rule__Variable__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1572:1: ( ( KEYWORD_6 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1573:1: ( KEYWORD_6 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1573:1: ( KEYWORD_6 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1574:1: KEYWORD_6
            {
             before(grammarAccess.getVariableAccess().getColonKeyword_2_1_1()); 
            match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_rule__Variable__Group_2_1__1__Impl3104); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1587:1: rule__Variable__Group_2_1__2 : rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 ;
    public final void rule__Variable__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1591:1: ( rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1592:2: rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1__2__Impl_in_rule__Variable__Group_2_1__23135);
            rule__Variable__Group_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1__3_in_rule__Variable__Group_2_1__23138);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1599:1: rule__Variable__Group_2_1__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1603:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1604:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1604:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1605:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1606:1: ( RULE_WS )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_WS) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1606:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1__2__Impl3166); 

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1616:1: rule__Variable__Group_2_1__3 : rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 ;
    public final void rule__Variable__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1620:1: ( rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1621:2: rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1__3__Impl_in_rule__Variable__Group_2_1__33197);
            rule__Variable__Group_2_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1__4_in_rule__Variable__Group_2_1__33200);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1628:1: rule__Variable__Group_2_1__3__Impl : ( ( rule__Variable__TypeAssignment_2_1_3 ) ) ;
    public final void rule__Variable__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1632:1: ( ( ( rule__Variable__TypeAssignment_2_1_3 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1633:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1633:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1634:1: ( rule__Variable__TypeAssignment_2_1_3 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_2_1_3()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1635:1: ( rule__Variable__TypeAssignment_2_1_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1635:2: rule__Variable__TypeAssignment_2_1_3
            {
            pushFollow(FOLLOW_rule__Variable__TypeAssignment_2_1_3_in_rule__Variable__Group_2_1__3__Impl3227);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1645:1: rule__Variable__Group_2_1__4 : rule__Variable__Group_2_1__4__Impl ;
    public final void rule__Variable__Group_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1649:1: ( rule__Variable__Group_2_1__4__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1650:2: rule__Variable__Group_2_1__4__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1__4__Impl_in_rule__Variable__Group_2_1__43257);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1656:1: rule__Variable__Group_2_1__4__Impl : ( ( rule__Variable__Group_2_1_4__0 )? ) ;
    public final void rule__Variable__Group_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1660:1: ( ( ( rule__Variable__Group_2_1_4__0 )? ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1661:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1661:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1662:1: ( rule__Variable__Group_2_1_4__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1663:1: ( rule__Variable__Group_2_1_4__0 )?
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1663:2: rule__Variable__Group_2_1_4__0
                    {
                    pushFollow(FOLLOW_rule__Variable__Group_2_1_4__0_in_rule__Variable__Group_2_1__4__Impl3284);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1683:1: rule__Variable__Group_2_1_0__0 : rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 ;
    public final void rule__Variable__Group_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1687:1: ( rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1688:2: rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_0__0__Impl_in_rule__Variable__Group_2_1_0__03325);
            rule__Variable__Group_2_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_0__1_in_rule__Variable__Group_2_1_0__03328);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1695:1: rule__Variable__Group_2_1_0__0__Impl : ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) ;
    public final void rule__Variable__Group_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1699:1: ( ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1700:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1700:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1701:1: ( rule__Variable__NameAssignment_2_1_0_0 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_2_1_0_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1702:1: ( rule__Variable__NameAssignment_2_1_0_0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1702:2: rule__Variable__NameAssignment_2_1_0_0
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_2_1_0_0_in_rule__Variable__Group_2_1_0__0__Impl3355);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1712:1: rule__Variable__Group_2_1_0__1 : rule__Variable__Group_2_1_0__1__Impl ;
    public final void rule__Variable__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1716:1: ( rule__Variable__Group_2_1_0__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1717:2: rule__Variable__Group_2_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_0__1__Impl_in_rule__Variable__Group_2_1_0__13385);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1723:1: rule__Variable__Group_2_1_0__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1727:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1728:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1728:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1729:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1730:1: ( RULE_WS )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_WS) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1730:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_0__1__Impl3413); 

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1744:1: rule__Variable__Group_2_1_4__0 : rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 ;
    public final void rule__Variable__Group_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1748:1: ( rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1749:2: rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__0__Impl_in_rule__Variable__Group_2_1_4__03448);
            rule__Variable__Group_2_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__1_in_rule__Variable__Group_2_1_4__03451);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1756:1: rule__Variable__Group_2_1_4__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1760:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1761:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1761:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1762:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1763:1: ( RULE_WS )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_WS) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1763:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__0__Impl3479); 

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1773:1: rule__Variable__Group_2_1_4__1 : rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 ;
    public final void rule__Variable__Group_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1777:1: ( rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1778:2: rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__1__Impl_in_rule__Variable__Group_2_1_4__13510);
            rule__Variable__Group_2_1_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__2_in_rule__Variable__Group_2_1_4__13513);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1785:1: rule__Variable__Group_2_1_4__1__Impl : ( KEYWORD_2 ) ;
    public final void rule__Variable__Group_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1789:1: ( ( KEYWORD_2 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1790:1: ( KEYWORD_2 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1790:1: ( KEYWORD_2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1791:1: KEYWORD_2
            {
             before(grammarAccess.getVariableAccess().getLeftParenthesisKeyword_2_1_4_1()); 
            match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_rule__Variable__Group_2_1_4__1__Impl3541); 
             after(grammarAccess.getVariableAccess().getLeftParenthesisKeyword_2_1_4_1()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1804:1: rule__Variable__Group_2_1_4__2 : rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 ;
    public final void rule__Variable__Group_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1808:1: ( rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1809:2: rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__2__Impl_in_rule__Variable__Group_2_1_4__23572);
            rule__Variable__Group_2_1_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__3_in_rule__Variable__Group_2_1_4__23575);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1816:1: rule__Variable__Group_2_1_4__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1820:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1821:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1821:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1822:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1823:1: ( RULE_WS )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_WS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1823:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__2__Impl3603); 

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1833:1: rule__Variable__Group_2_1_4__3 : rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 ;
    public final void rule__Variable__Group_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1837:1: ( rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1838:2: rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__3__Impl_in_rule__Variable__Group_2_1_4__33634);
            rule__Variable__Group_2_1_4__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__4_in_rule__Variable__Group_2_1_4__33637);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1845:1: rule__Variable__Group_2_1_4__3__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_3 ) ) ;
    public final void rule__Variable__Group_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1849:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_3 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1850:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1850:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1851:1: ( rule__Variable__ParametersAssignment_2_1_4_3 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1852:1: ( rule__Variable__ParametersAssignment_2_1_4_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1852:2: rule__Variable__ParametersAssignment_2_1_4_3
            {
            pushFollow(FOLLOW_rule__Variable__ParametersAssignment_2_1_4_3_in_rule__Variable__Group_2_1_4__3__Impl3664);
            rule__Variable__ParametersAssignment_2_1_4_3();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1862:1: rule__Variable__Group_2_1_4__4 : rule__Variable__Group_2_1_4__4__Impl rule__Variable__Group_2_1_4__5 ;
    public final void rule__Variable__Group_2_1_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1866:1: ( rule__Variable__Group_2_1_4__4__Impl rule__Variable__Group_2_1_4__5 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1867:2: rule__Variable__Group_2_1_4__4__Impl rule__Variable__Group_2_1_4__5
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__4__Impl_in_rule__Variable__Group_2_1_4__43694);
            rule__Variable__Group_2_1_4__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__5_in_rule__Variable__Group_2_1_4__43697);
            rule__Variable__Group_2_1_4__5();

            state._fsp--;


            }

        }
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1874:1: rule__Variable__Group_2_1_4__4__Impl : ( ( rule__Variable__Group_2_1_4_4__0 )* ) ;
    public final void rule__Variable__Group_2_1_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1878:1: ( ( ( rule__Variable__Group_2_1_4_4__0 )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1879:1: ( ( rule__Variable__Group_2_1_4_4__0 )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1879:1: ( ( rule__Variable__Group_2_1_4_4__0 )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1880:1: ( rule__Variable__Group_2_1_4_4__0 )*
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4_4()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1881:1: ( rule__Variable__Group_2_1_4_4__0 )*
            loop22:
            do {
                int alt22=2;
                alt22 = dfa22.predict(input);
                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1881:2: rule__Variable__Group_2_1_4_4__0
            	    {
            	    pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__0_in_rule__Variable__Group_2_1_4__4__Impl3724);
            	    rule__Variable__Group_2_1_4_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getGroup_2_1_4_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__Variable__Group_2_1_4__5"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1891:1: rule__Variable__Group_2_1_4__5 : rule__Variable__Group_2_1_4__5__Impl rule__Variable__Group_2_1_4__6 ;
    public final void rule__Variable__Group_2_1_4__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1895:1: ( rule__Variable__Group_2_1_4__5__Impl rule__Variable__Group_2_1_4__6 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1896:2: rule__Variable__Group_2_1_4__5__Impl rule__Variable__Group_2_1_4__6
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__5__Impl_in_rule__Variable__Group_2_1_4__53755);
            rule__Variable__Group_2_1_4__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__6_in_rule__Variable__Group_2_1_4__53758);
            rule__Variable__Group_2_1_4__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4__5"


    // $ANTLR start "rule__Variable__Group_2_1_4__5__Impl"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1903:1: rule__Variable__Group_2_1_4__5__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1907:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1908:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1908:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1909:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_5()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1910:1: ( RULE_WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1910:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__5__Impl3786); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4__5__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4__6"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1920:1: rule__Variable__Group_2_1_4__6 : rule__Variable__Group_2_1_4__6__Impl ;
    public final void rule__Variable__Group_2_1_4__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1924:1: ( rule__Variable__Group_2_1_4__6__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1925:2: rule__Variable__Group_2_1_4__6__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__6__Impl_in_rule__Variable__Group_2_1_4__63817);
            rule__Variable__Group_2_1_4__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4__6"


    // $ANTLR start "rule__Variable__Group_2_1_4__6__Impl"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1931:1: rule__Variable__Group_2_1_4__6__Impl : ( KEYWORD_3 ) ;
    public final void rule__Variable__Group_2_1_4__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1935:1: ( ( KEYWORD_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1936:1: ( KEYWORD_3 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1936:1: ( KEYWORD_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1937:1: KEYWORD_3
            {
             before(grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_6()); 
            match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_rule__Variable__Group_2_1_4__6__Impl3845); 
             after(grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4__6__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_4__0"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1964:1: rule__Variable__Group_2_1_4_4__0 : rule__Variable__Group_2_1_4_4__0__Impl rule__Variable__Group_2_1_4_4__1 ;
    public final void rule__Variable__Group_2_1_4_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1968:1: ( rule__Variable__Group_2_1_4_4__0__Impl rule__Variable__Group_2_1_4_4__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1969:2: rule__Variable__Group_2_1_4_4__0__Impl rule__Variable__Group_2_1_4_4__1
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__0__Impl_in_rule__Variable__Group_2_1_4_4__03890);
            rule__Variable__Group_2_1_4_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__1_in_rule__Variable__Group_2_1_4_4__03893);
            rule__Variable__Group_2_1_4_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_4__0"


    // $ANTLR start "rule__Variable__Group_2_1_4_4__0__Impl"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1976:1: rule__Variable__Group_2_1_4_4__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1980:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1981:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1981:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1982:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_4_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1983:1: ( RULE_WS )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_WS) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1983:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4_4__0__Impl3921); 

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_4__0__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_4__1"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1993:1: rule__Variable__Group_2_1_4_4__1 : rule__Variable__Group_2_1_4_4__1__Impl rule__Variable__Group_2_1_4_4__2 ;
    public final void rule__Variable__Group_2_1_4_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1997:1: ( rule__Variable__Group_2_1_4_4__1__Impl rule__Variable__Group_2_1_4_4__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:1998:2: rule__Variable__Group_2_1_4_4__1__Impl rule__Variable__Group_2_1_4_4__2
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__1__Impl_in_rule__Variable__Group_2_1_4_4__13952);
            rule__Variable__Group_2_1_4_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__2_in_rule__Variable__Group_2_1_4_4__13955);
            rule__Variable__Group_2_1_4_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_4__1"


    // $ANTLR start "rule__Variable__Group_2_1_4_4__1__Impl"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2005:1: rule__Variable__Group_2_1_4_4__1__Impl : ( KEYWORD_4 ) ;
    public final void rule__Variable__Group_2_1_4_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2009:1: ( ( KEYWORD_4 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2010:1: ( KEYWORD_4 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2010:1: ( KEYWORD_4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2011:1: KEYWORD_4
            {
             before(grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_4_1()); 
            match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_rule__Variable__Group_2_1_4_4__1__Impl3983); 
             after(grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_4__1__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_4__2"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2024:1: rule__Variable__Group_2_1_4_4__2 : rule__Variable__Group_2_1_4_4__2__Impl rule__Variable__Group_2_1_4_4__3 ;
    public final void rule__Variable__Group_2_1_4_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2028:1: ( rule__Variable__Group_2_1_4_4__2__Impl rule__Variable__Group_2_1_4_4__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2029:2: rule__Variable__Group_2_1_4_4__2__Impl rule__Variable__Group_2_1_4_4__3
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__2__Impl_in_rule__Variable__Group_2_1_4_4__24014);
            rule__Variable__Group_2_1_4_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__3_in_rule__Variable__Group_2_1_4_4__24017);
            rule__Variable__Group_2_1_4_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_4__2"


    // $ANTLR start "rule__Variable__Group_2_1_4_4__2__Impl"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2036:1: rule__Variable__Group_2_1_4_4__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2040:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2041:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2041:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2042:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_4_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2043:1: ( RULE_WS )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_WS) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2043:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4_4__2__Impl4045); 

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_4__2__Impl"


    // $ANTLR start "rule__Variable__Group_2_1_4_4__3"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2053:1: rule__Variable__Group_2_1_4_4__3 : rule__Variable__Group_2_1_4_4__3__Impl ;
    public final void rule__Variable__Group_2_1_4_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2057:1: ( rule__Variable__Group_2_1_4_4__3__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2058:2: rule__Variable__Group_2_1_4_4__3__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__3__Impl_in_rule__Variable__Group_2_1_4_4__34076);
            rule__Variable__Group_2_1_4_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_4__3"


    // $ANTLR start "rule__Variable__Group_2_1_4_4__3__Impl"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2064:1: rule__Variable__Group_2_1_4_4__3__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_4_3 ) ) ;
    public final void rule__Variable__Group_2_1_4_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2068:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_4_3 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2069:1: ( ( rule__Variable__ParametersAssignment_2_1_4_4_3 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2069:1: ( ( rule__Variable__ParametersAssignment_2_1_4_4_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2070:1: ( rule__Variable__ParametersAssignment_2_1_4_4_3 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_4_3()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2071:1: ( rule__Variable__ParametersAssignment_2_1_4_4_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2071:2: rule__Variable__ParametersAssignment_2_1_4_4_3
            {
            pushFollow(FOLLOW_rule__Variable__ParametersAssignment_2_1_4_4_3_in_rule__Variable__Group_2_1_4_4__3__Impl4103);
            rule__Variable__ParametersAssignment_2_1_4_4_3();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2_1_4_4__3__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2089:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2093:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2094:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__04141);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__04144);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2101:1: rule__FQN__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2105:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2106:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2106:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2107:1: ruleValidID
            {
             before(grammarAccess.getFQNAccess().getValidIDParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__FQN__Group__0__Impl4171);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2118:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2122:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2123:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__14200);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2129:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2133:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2134:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2134:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2135:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2136:1: ( rule__FQN__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==KEYWORD_5) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2136:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl4227);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2150:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2154:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2155:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__04262);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__04265);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2162:1: rule__FQN__Group_1__0__Impl : ( KEYWORD_5 ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2166:1: ( ( KEYWORD_5 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2167:1: ( KEYWORD_5 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2167:1: ( KEYWORD_5 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2168:1: KEYWORD_5
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_rule__FQN__Group_1__0__Impl4293); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2181:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2185:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2186:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__14324);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2192:1: rule__FQN__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2196:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2197:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2197:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2198:1: ruleValidID
            {
             before(grammarAccess.getFQNAccess().getValidIDParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__FQN__Group_1__1__Impl4351);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2213:1: rule__Dollar__Group__0 : rule__Dollar__Group__0__Impl rule__Dollar__Group__1 ;
    public final void rule__Dollar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2217:1: ( rule__Dollar__Group__0__Impl rule__Dollar__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2218:2: rule__Dollar__Group__0__Impl rule__Dollar__Group__1
            {
            pushFollow(FOLLOW_rule__Dollar__Group__0__Impl_in_rule__Dollar__Group__04384);
            rule__Dollar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Dollar__Group__1_in_rule__Dollar__Group__04387);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2225:1: rule__Dollar__Group__0__Impl : ( () ) ;
    public final void rule__Dollar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2229:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2230:1: ( () )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2230:1: ( () )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2231:1: ()
            {
             before(grammarAccess.getDollarAccess().getDollarAction_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2232:1: ()
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2234:1: 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2244:1: rule__Dollar__Group__1 : rule__Dollar__Group__1__Impl ;
    public final void rule__Dollar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2248:1: ( rule__Dollar__Group__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2249:2: rule__Dollar__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Dollar__Group__1__Impl_in_rule__Dollar__Group__14445);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2255:1: rule__Dollar__Group__1__Impl : ( ( rule__Dollar__Alternatives_1 ) ) ;
    public final void rule__Dollar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2259:1: ( ( ( rule__Dollar__Alternatives_1 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2260:1: ( ( rule__Dollar__Alternatives_1 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2260:1: ( ( rule__Dollar__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2261:1: ( rule__Dollar__Alternatives_1 )
            {
             before(grammarAccess.getDollarAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2262:1: ( rule__Dollar__Alternatives_1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2262:2: rule__Dollar__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Dollar__Alternatives_1_in_rule__Dollar__Group__1__Impl4472);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2277:1: rule__Codetemplates__LanguageAssignment_2 : ( ( ruleFQN ) ) ;
    public final void rule__Codetemplates__LanguageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2281:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2282:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2282:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2283:1: ( ruleFQN )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2284:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2285:1: ruleFQN
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageGrammarFQNParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Codetemplates__LanguageAssignment_24515);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2296:1: rule__Codetemplates__TemplatesAssignment_4 : ( ruleCodetemplate ) ;
    public final void rule__Codetemplates__TemplatesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2300:1: ( ( ruleCodetemplate ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2301:1: ( ruleCodetemplate )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2301:1: ( ruleCodetemplate )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2302:1: ruleCodetemplate
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleCodetemplate_in_rule__Codetemplates__TemplatesAssignment_44550);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2311:1: rule__Codetemplate__NameAssignment_0 : ( ruleValidID ) ;
    public final void rule__Codetemplate__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2315:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2316:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2316:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2317:1: ruleValidID
            {
             before(grammarAccess.getCodetemplateAccess().getNameValidIDParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__Codetemplate__NameAssignment_04581);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2326:1: rule__Codetemplate__IdAssignment_2 : ( RULE_ID ) ;
    public final void rule__Codetemplate__IdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2330:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2331:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2331:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2332:1: RULE_ID
            {
             before(grammarAccess.getCodetemplateAccess().getIdIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Codetemplate__IdAssignment_24612); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2341:1: rule__Codetemplate__DescriptionAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__DescriptionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2345:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2346:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2346:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2347:1: RULE_STRING
            {
             before(grammarAccess.getCodetemplateAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Codetemplate__DescriptionAssignment_44643); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2356:1: rule__Codetemplate__ContextAssignment_7_0 : ( ( ruleValidID ) ) ;
    public final void rule__Codetemplate__ContextAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2360:1: ( ( ( ruleValidID ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2361:1: ( ( ruleValidID ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2361:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2362:1: ( ruleValidID )
            {
             before(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_7_0_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2363:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2364:1: ruleValidID
            {
             before(grammarAccess.getCodetemplateAccess().getContextAbstractRuleValidIDParserRuleCall_7_0_0_1()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__Codetemplate__ContextAssignment_7_04678);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2375:1: rule__Codetemplate__KeywordContextAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__KeywordContextAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2379:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2380:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2380:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2381:1: RULE_STRING
            {
             before(grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_7_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Codetemplate__KeywordContextAssignment_7_14713); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2390:1: rule__Codetemplate__BodyAssignment_8 : ( ruleTemplateBodyWithQuotes ) ;
    public final void rule__Codetemplate__BodyAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2394:1: ( ( ruleTemplateBodyWithQuotes ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2395:1: ( ruleTemplateBodyWithQuotes )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2395:1: ( ruleTemplateBodyWithQuotes )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2396:1: ruleTemplateBodyWithQuotes
            {
             before(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleTemplateBodyWithQuotes_in_rule__Codetemplate__BodyAssignment_84744);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2405:1: rule__TemplateBody__PartsAssignment_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2409:1: ( ( ruleLiteral ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2410:1: ( ruleLiteral )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2410:1: ( ruleLiteral )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2411:1: ruleLiteral
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__TemplateBody__PartsAssignment_14775);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2420:1: rule__TemplateBody__PartsAssignment_2_0 : ( ruleVariableOrDollar ) ;
    public final void rule__TemplateBody__PartsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2424:1: ( ( ruleVariableOrDollar ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2425:1: ( ruleVariableOrDollar )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2425:1: ( ruleVariableOrDollar )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2426:1: ruleVariableOrDollar
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsVariableOrDollarParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleVariableOrDollar_in_rule__TemplateBody__PartsAssignment_2_04806);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2435:1: rule__TemplateBody__PartsAssignment_2_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2439:1: ( ( ruleLiteral ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2440:1: ( ruleLiteral )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2440:1: ( ruleLiteral )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2441:1: ruleLiteral
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__TemplateBody__PartsAssignment_2_14837);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2450:1: rule__Variable__NameAssignment_2_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2454:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2455:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2455:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2456:1: ruleValidID
            {
             before(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__Variable__NameAssignment_2_04868);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2465:1: rule__Variable__NameAssignment_2_1_0_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2469:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2470:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2470:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2471:1: ruleValidID
            {
             before(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_1_0_0_0()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__Variable__NameAssignment_2_1_0_04899);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2480:1: rule__Variable__TypeAssignment_2_1_3 : ( ruleValidID ) ;
    public final void rule__Variable__TypeAssignment_2_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2484:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2485:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2485:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2486:1: ruleValidID
            {
             before(grammarAccess.getVariableAccess().getTypeValidIDParserRuleCall_2_1_3_0()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__Variable__TypeAssignment_2_1_34930);
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


    // $ANTLR start "rule__Variable__ParametersAssignment_2_1_4_3"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2495:1: rule__Variable__ParametersAssignment_2_1_4_3 : ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2499:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2500:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2500:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2501:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2502:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2502:2: rule__Variable__ParametersAlternatives_2_1_4_3_0
            {
            pushFollow(FOLLOW_rule__Variable__ParametersAlternatives_2_1_4_3_0_in_rule__Variable__ParametersAssignment_2_1_4_34961);
            rule__Variable__ParametersAlternatives_2_1_4_3_0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__ParametersAssignment_2_1_4_3"


    // $ANTLR start "rule__Variable__ParametersAssignment_2_1_4_4_3"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2511:1: rule__Variable__ParametersAssignment_2_1_4_4_3 : ( ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2515:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2516:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2516:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2517:1: ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_4_3_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2518:1: ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2518:2: rule__Variable__ParametersAlternatives_2_1_4_4_3_0
            {
            pushFollow(FOLLOW_rule__Variable__ParametersAlternatives_2_1_4_4_3_0_in_rule__Variable__ParametersAssignment_2_1_4_4_34994);
            rule__Variable__ParametersAlternatives_2_1_4_4_3_0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__ParametersAssignment_2_1_4_4_3"


    // $ANTLR start "rule__Literal__ValueAssignment"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2527:1: rule__Literal__ValueAssignment : ( ruleLiteralValue ) ;
    public final void rule__Literal__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2531:1: ( ( ruleLiteralValue ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2532:1: ( ruleLiteralValue )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2532:1: ( ruleLiteralValue )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2533:1: ruleLiteralValue
            {
             before(grammarAccess.getLiteralAccess().getValueLiteralValueParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleLiteralValue_in_rule__Literal__ValueAssignment5027);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2542:1: rule__Dollar__EscapedAssignment_1_0 : ( ( KEYWORD_8 ) ) ;
    public final void rule__Dollar__EscapedAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2546:1: ( ( ( KEYWORD_8 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2547:1: ( ( KEYWORD_8 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2547:1: ( ( KEYWORD_8 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2548:1: ( KEYWORD_8 )
            {
             before(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2549:1: ( KEYWORD_8 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalCodetemplatesParser.g:2550:1: KEYWORD_8
            {
             before(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 
            match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_rule__Dollar__EscapedAssignment_1_05063); 
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
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA22 dfa22 = new DFA22(this);
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
            return "512:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );";
        }
    }
    static final String DFA18_eotS =
        "\4\uffff";
    static final String DFA18_eofS =
        "\4\uffff";
    static final String DFA18_minS =
        "\2\14\2\uffff";
    static final String DFA18_maxS =
        "\2\24\2\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA18_specialS =
        "\4\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1663:1: ( rule__Variable__Group_2_1_4__0 )?";
        }
    }
    static final String DFA22_eotS =
        "\4\uffff";
    static final String DFA22_eofS =
        "\4\uffff";
    static final String DFA22_minS =
        "\2\15\2\uffff";
    static final String DFA22_maxS =
        "\2\24\2\uffff";
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
            return "()* loopback of 1881:1: ( rule__Variable__Group_2_1_4_4__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleCodetemplates_in_entryRuleCodetemplates54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodetemplates61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__0_in_ruleCodetemplates91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodetemplate_in_entryRuleCodetemplate118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodetemplate125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__0_in_ruleCodetemplate155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBodyWithQuotes_in_entryRuleTemplateBodyWithQuotes187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBodyWithQuotes194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBodyWithQuotes__Group__0_in_ruleTemplateBodyWithQuotes228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBody_in_entryRuleTemplateBody260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBody267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__0_in_ruleTemplateBody301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableOrDollar_in_entryRuleVariableOrDollar335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableOrDollar342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableOrDollar__Alternatives_in_ruleVariableOrDollar376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__0_in_ruleVariable449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValidID__Alternatives_in_ruleValidID522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__ValueAssignment_in_ruleLiteral668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralValue707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralValue__Alternatives_in_ruleLiteralValue743 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_rule__LiteralValue__Alternatives_in_ruleLiteralValue755 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_ruleDollar_in_entryRuleDollar790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDollar797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dollar__Group__0_in_ruleDollar831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__ContextAssignment_7_0_in_rule__Codetemplate__Alternatives_7867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__KeywordContextAssignment_7_1_in_rule__Codetemplate__Alternatives_7885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__VariableOrDollar__Alternatives919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDollar_in_rule__VariableOrDollar__Alternatives936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_2_0_in_rule__Variable__Alternatives_2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__0_in_rule__Variable__Alternatives_2986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Variable__ParametersAlternatives_2_1_4_3_01019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Variable__ParametersAlternatives_2_1_4_3_01036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Variable__ParametersAlternatives_2_1_4_4_3_01068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Variable__ParametersAlternatives_2_1_4_4_3_01085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ValidID__Alternatives1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_13_in_rule__ValidID__Alternatives1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_14_in_rule__ValidID__Alternatives1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__LiteralValue__Alternatives1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_rule__LiteralValue__Alternatives1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LiteralValue__Alternatives1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_12_in_rule__LiteralValue__Alternatives1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dollar__EscapedAssignment_1_0_in_rule__Dollar__Alternatives_11275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_rule__Dollar__Alternatives_11294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__0__Impl_in_rule__Codetemplates__Group__01326 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__1_in_rule__Codetemplates__Group__01329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_14_in_rule__Codetemplates__Group__0__Impl1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__1__Impl_in_rule__Codetemplates__Group__11388 = new BitSet(new long[]{0x0000000000040050L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__2_in_rule__Codetemplates__Group__11391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_13_in_rule__Codetemplates__Group__1__Impl1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__2__Impl_in_rule__Codetemplates__Group__21450 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__3_in_rule__Codetemplates__Group__21453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__LanguageAssignment_2_in_rule__Codetemplates__Group__2__Impl1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__3__Impl_in_rule__Codetemplates__Group__31510 = new BitSet(new long[]{0x0000000000040050L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__4_in_rule__Codetemplates__Group__31513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_rule__Codetemplates__Group__3__Impl1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__4__Impl_in_rule__Codetemplates__Group__41572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__TemplatesAssignment_4_in_rule__Codetemplates__Group__4__Impl1599 = new BitSet(new long[]{0x0000000000040052L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__0__Impl_in_rule__Codetemplate__Group__01640 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__1_in_rule__Codetemplate__Group__01643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__NameAssignment_0_in_rule__Codetemplate__Group__0__Impl1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__1__Impl_in_rule__Codetemplate__Group__11700 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__2_in_rule__Codetemplate__Group__11703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_rule__Codetemplate__Group__1__Impl1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__2__Impl_in_rule__Codetemplate__Group__21762 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__3_in_rule__Codetemplate__Group__21765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__IdAssignment_2_in_rule__Codetemplate__Group__2__Impl1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__3__Impl_in_rule__Codetemplate__Group__31822 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__4_in_rule__Codetemplate__Group__31825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_rule__Codetemplate__Group__3__Impl1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__4__Impl_in_rule__Codetemplate__Group__41884 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__5_in_rule__Codetemplate__Group__41887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__DescriptionAssignment_4_in_rule__Codetemplate__Group__4__Impl1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__5__Impl_in_rule__Codetemplate__Group__51944 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__6_in_rule__Codetemplate__Group__51947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_3_in_rule__Codetemplate__Group__5__Impl1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__6__Impl_in_rule__Codetemplate__Group__62006 = new BitSet(new long[]{0x00000000000C0050L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__7_in_rule__Codetemplate__Group__62009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_13_in_rule__Codetemplate__Group__6__Impl2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__7__Impl_in_rule__Codetemplate__Group__72068 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__8_in_rule__Codetemplate__Group__72071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Alternatives_7_in_rule__Codetemplate__Group__7__Impl2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__8__Impl_in_rule__Codetemplate__Group__82128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__BodyAssignment_8_in_rule__Codetemplate__Group__8__Impl2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBodyWithQuotes__Group__0__Impl_in_rule__TemplateBodyWithQuotes__Group__02203 = new BitSet(new long[]{0x00000000003409A0L});
    public static final BitSet FOLLOW_rule__TemplateBodyWithQuotes__Group__1_in_rule__TemplateBodyWithQuotes__Group__02206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_rule__TemplateBodyWithQuotes__Group__0__Impl2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBodyWithQuotes__Group__1__Impl_in_rule__TemplateBodyWithQuotes__Group__12265 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__TemplateBodyWithQuotes__Group__2_in_rule__TemplateBodyWithQuotes__Group__12268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBody_in_rule__TemplateBodyWithQuotes__Group__1__Impl2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBodyWithQuotes__Group__2__Impl_in_rule__TemplateBodyWithQuotes__Group__22324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_10_in_rule__TemplateBodyWithQuotes__Group__2__Impl2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__0__Impl_in_rule__TemplateBody__Group__02389 = new BitSet(new long[]{0x00000000003409A0L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__1_in_rule__TemplateBody__Group__02392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__1__Impl_in_rule__TemplateBody__Group__12450 = new BitSet(new long[]{0x00000000003409A0L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__2_in_rule__TemplateBody__Group__12453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__PartsAssignment_1_in_rule__TemplateBody__Group__1__Impl2480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__2__Impl_in_rule__TemplateBody__Group__22511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group_2__0_in_rule__TemplateBody__Group__2__Impl2538 = new BitSet(new long[]{0x0000000000000982L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group_2__0__Impl_in_rule__TemplateBody__Group_2__02575 = new BitSet(new long[]{0x0000000000340020L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group_2__1_in_rule__TemplateBody__Group_2__02578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__PartsAssignment_2_0_in_rule__TemplateBody__Group_2__0__Impl2605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group_2__1__Impl_in_rule__TemplateBody__Group_2__12635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__PartsAssignment_2_1_in_rule__TemplateBody__Group_2__1__Impl2662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__02697 = new BitSet(new long[]{0x0000000000150050L});
    public static final BitSet FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__02700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_9_in_rule__Variable__Group__0__Impl2728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__12759 = new BitSet(new long[]{0x0000000000150050L});
    public static final BitSet FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__12762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group__1__Impl2790 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__22821 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_rule__Variable__Group__3_in_rule__Variable__Group__22824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Alternatives_2_in_rule__Variable__Group__2__Impl2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__3__Impl_in_rule__Variable__Group__32881 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_rule__Variable__Group__4_in_rule__Variable__Group__32884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group__3__Impl2912 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Variable__Group__4__Impl_in_rule__Variable__Group__42943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_7_in_rule__Variable__Group__4__Impl2971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__0__Impl_in_rule__Variable__Group_2_1__03012 = new BitSet(new long[]{0x0000000000150050L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__1_in_rule__Variable__Group_2_1__03015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_0__0_in_rule__Variable__Group_2_1__0__Impl3042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__1__Impl_in_rule__Variable__Group_2_1__13073 = new BitSet(new long[]{0x0000000000140050L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__2_in_rule__Variable__Group_2_1__13076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_rule__Variable__Group_2_1__1__Impl3104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__2__Impl_in_rule__Variable__Group_2_1__23135 = new BitSet(new long[]{0x0000000000140050L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__3_in_rule__Variable__Group_2_1__23138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1__2__Impl3166 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__3__Impl_in_rule__Variable__Group_2_1__33197 = new BitSet(new long[]{0x0000000000101000L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__4_in_rule__Variable__Group_2_1__33200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__TypeAssignment_2_1_3_in_rule__Variable__Group_2_1__3__Impl3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__4__Impl_in_rule__Variable__Group_2_1__43257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__0_in_rule__Variable__Group_2_1__4__Impl3284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_0__0__Impl_in_rule__Variable__Group_2_1_0__03325 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_0__1_in_rule__Variable__Group_2_1_0__03328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_2_1_0_0_in_rule__Variable__Group_2_1_0__0__Impl3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_0__1__Impl_in_rule__Variable__Group_2_1_0__13385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_0__1__Impl3413 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__0__Impl_in_rule__Variable__Group_2_1_4__03448 = new BitSet(new long[]{0x0000000000101000L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__1_in_rule__Variable__Group_2_1_4__03451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__0__Impl3479 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__1__Impl_in_rule__Variable__Group_2_1_4__13510 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__2_in_rule__Variable__Group_2_1_4__13513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_rule__Variable__Group_2_1_4__1__Impl3541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__2__Impl_in_rule__Variable__Group_2_1_4__23572 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__3_in_rule__Variable__Group_2_1_4__23575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__2__Impl3603 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__3__Impl_in_rule__Variable__Group_2_1_4__33634 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__4_in_rule__Variable__Group_2_1_4__33637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ParametersAssignment_2_1_4_3_in_rule__Variable__Group_2_1_4__3__Impl3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__4__Impl_in_rule__Variable__Group_2_1_4__43694 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__5_in_rule__Variable__Group_2_1_4__43697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__0_in_rule__Variable__Group_2_1_4__4__Impl3724 = new BitSet(new long[]{0x0000000000104002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__5__Impl_in_rule__Variable__Group_2_1_4__53755 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__6_in_rule__Variable__Group_2_1_4__53758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__5__Impl3786 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__6__Impl_in_rule__Variable__Group_2_1_4__63817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_3_in_rule__Variable__Group_2_1_4__6__Impl3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__0__Impl_in_rule__Variable__Group_2_1_4_4__03890 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__1_in_rule__Variable__Group_2_1_4_4__03893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4_4__0__Impl3921 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__1__Impl_in_rule__Variable__Group_2_1_4_4__13952 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__2_in_rule__Variable__Group_2_1_4_4__13955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_rule__Variable__Group_2_1_4_4__1__Impl3983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__2__Impl_in_rule__Variable__Group_2_1_4_4__24014 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__3_in_rule__Variable__Group_2_1_4_4__24017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4_4__2__Impl4045 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__3__Impl_in_rule__Variable__Group_2_1_4_4__34076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ParametersAssignment_2_1_4_4_3_in_rule__Variable__Group_2_1_4_4__3__Impl4103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__04141 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__04144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__FQN__Group__0__Impl4171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__14200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl4227 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__04262 = new BitSet(new long[]{0x0000000000040050L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__04265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_rule__FQN__Group_1__0__Impl4293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__14324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__FQN__Group_1__1__Impl4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dollar__Group__0__Impl_in_rule__Dollar__Group__04384 = new BitSet(new long[]{0x0000000000000980L});
    public static final BitSet FOLLOW_rule__Dollar__Group__1_in_rule__Dollar__Group__04387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dollar__Group__1__Impl_in_rule__Dollar__Group__14445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dollar__Alternatives_1_in_rule__Dollar__Group__1__Impl4472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Codetemplates__LanguageAssignment_24515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodetemplate_in_rule__Codetemplates__TemplatesAssignment_44550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__Codetemplate__NameAssignment_04581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Codetemplate__IdAssignment_24612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Codetemplate__DescriptionAssignment_44643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__Codetemplate__ContextAssignment_7_04678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Codetemplate__KeywordContextAssignment_7_14713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBodyWithQuotes_in_rule__Codetemplate__BodyAssignment_84744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__TemplateBody__PartsAssignment_14775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableOrDollar_in_rule__TemplateBody__PartsAssignment_2_04806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__TemplateBody__PartsAssignment_2_14837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__Variable__NameAssignment_2_04868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__Variable__NameAssignment_2_1_0_04899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__Variable__TypeAssignment_2_1_34930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ParametersAlternatives_2_1_4_3_0_in_rule__Variable__ParametersAssignment_2_1_4_34961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ParametersAlternatives_2_1_4_4_3_0_in_rule__Variable__ParametersAssignment_2_1_4_4_34994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_rule__Literal__ValueAssignment5027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_rule__Dollar__EscapedAssignment_1_05063 = new BitSet(new long[]{0x0000000000000002L});

}
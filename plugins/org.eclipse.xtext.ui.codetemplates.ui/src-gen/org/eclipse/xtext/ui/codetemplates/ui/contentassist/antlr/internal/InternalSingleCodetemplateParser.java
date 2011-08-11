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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_12", "KEYWORD_11", "KEYWORD_8", "KEYWORD_9", "KEYWORD_10", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=16;
    public static final int RULE_ANY_OTHER=19;
    public static final int KEYWORD_1=9;
    public static final int KEYWORD_5=13;
    public static final int KEYWORD_4=12;
    public static final int KEYWORD_3=11;
    public static final int KEYWORD_2=10;
    public static final int KEYWORD_11=5;
    public static final int EOF=-1;
    public static final int KEYWORD_12=4;
    public static final int KEYWORD_10=8;
    public static final int RULE_STRING=17;
    public static final int KEYWORD_6=14;
    public static final int KEYWORD_7=15;
    public static final int KEYWORD_8=6;
    public static final int KEYWORD_9=7;
    public static final int RULE_WS=18;

    // delegates
    // delegators


        public InternalSingleCodetemplateParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSingleCodetemplateParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSingleCodetemplateParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g"; }


     
     	private SingleCodetemplateGrammarAccess grammarAccess;
     	
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
    		tokenNameToValue.put("KEYWORD_10", "'>>'");
    		tokenNameToValue.put("KEYWORD_11", "'for'");
    		tokenNameToValue.put("KEYWORD_12", "'templates'");
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:75:1: entryRuleCodetemplates : ruleCodetemplates EOF ;
    public final void entryRuleCodetemplates() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:76:1: ( ruleCodetemplates EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:77:1: ruleCodetemplates EOF
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:84:1: ruleCodetemplates : ( ( rule__Codetemplates__Group__0 ) ) ;
    public final void ruleCodetemplates() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:88:5: ( ( ( rule__Codetemplates__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:89:1: ( ( rule__Codetemplates__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:89:1: ( ( rule__Codetemplates__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:90:1: ( rule__Codetemplates__Group__0 )
            {
             before(grammarAccess.getCodetemplatesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:91:1: ( rule__Codetemplates__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:91:2: rule__Codetemplates__Group__0
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:103:1: entryRuleCodetemplate : ruleCodetemplate EOF ;
    public final void entryRuleCodetemplate() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:104:1: ( ruleCodetemplate EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:105:1: ruleCodetemplate EOF
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:112:1: ruleCodetemplate : ( ( rule__Codetemplate__Group__0 ) ) ;
    public final void ruleCodetemplate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:116:5: ( ( ( rule__Codetemplate__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:117:1: ( ( rule__Codetemplate__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:117:1: ( ( rule__Codetemplate__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:118:1: ( rule__Codetemplate__Group__0 )
            {
             before(grammarAccess.getCodetemplateAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:119:1: ( rule__Codetemplate__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:119:2: rule__Codetemplate__Group__0
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:131:1: entryRuleTemplateBodyWithQuotes : ruleTemplateBodyWithQuotes EOF ;
    public final void entryRuleTemplateBodyWithQuotes() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:135:1: ( ruleTemplateBodyWithQuotes EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:136:1: ruleTemplateBodyWithQuotes EOF
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:146:1: ruleTemplateBodyWithQuotes : ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) ;
    public final void ruleTemplateBodyWithQuotes() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:151:5: ( ( ( rule__TemplateBodyWithQuotes__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:152:1: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:152:1: ( ( rule__TemplateBodyWithQuotes__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:153:1: ( rule__TemplateBodyWithQuotes__Group__0 )
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:154:1: ( rule__TemplateBodyWithQuotes__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:154:2: rule__TemplateBodyWithQuotes__Group__0
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


    // $ANTLR start "entryRuleLiteralValue"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:167:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:171:1: ( ruleLiteralValue EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:172:1: ruleLiteralValue EOF
            {
             before(grammarAccess.getLiteralValueRule()); 
            pushFollow(FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue260);
            ruleLiteralValue();

            state._fsp--;

             after(grammarAccess.getLiteralValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralValue267); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:182:1: ruleLiteralValue : ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) ;
    public final void ruleLiteralValue() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:187:5: ( ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:188:1: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:188:1: ( ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:189:1: ( ( rule__LiteralValue__Alternatives ) ) ( ( rule__LiteralValue__Alternatives )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:189:1: ( ( rule__LiteralValue__Alternatives ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:190:1: ( rule__LiteralValue__Alternatives )
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:191:1: ( rule__LiteralValue__Alternatives )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:191:2: rule__LiteralValue__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralValue__Alternatives_in_ruleLiteralValue303);
            rule__LiteralValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralValueAccess().getAlternatives()); 

            }

            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:194:1: ( ( rule__LiteralValue__Alternatives )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:195:1: ( rule__LiteralValue__Alternatives )*
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:196:1: ( rule__LiteralValue__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=RULE_WS && LA1_0<=RULE_ANY_OTHER)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:196:2: rule__LiteralValue__Alternatives
            	    {
            	    pushFollow(FOLLOW_rule__LiteralValue__Alternatives_in_ruleLiteralValue315);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:210:1: entryRuleTemplateBody : ruleTemplateBody EOF ;
    public final void entryRuleTemplateBody() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:214:1: ( ruleTemplateBody EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:215:1: ruleTemplateBody EOF
            {
             before(grammarAccess.getTemplateBodyRule()); 
            pushFollow(FOLLOW_ruleTemplateBody_in_entryRuleTemplateBody350);
            ruleTemplateBody();

            state._fsp--;

             after(grammarAccess.getTemplateBodyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTemplateBody357); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:225:1: ruleTemplateBody : ( ( rule__TemplateBody__Group__0 ) ) ;
    public final void ruleTemplateBody() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:230:5: ( ( ( rule__TemplateBody__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:231:1: ( ( rule__TemplateBody__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:231:1: ( ( rule__TemplateBody__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:232:1: ( rule__TemplateBody__Group__0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:233:1: ( rule__TemplateBody__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:233:2: rule__TemplateBody__Group__0
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group__0_in_ruleTemplateBody391);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:248:1: entryRuleVariableOrDollar : ruleVariableOrDollar EOF ;
    public final void entryRuleVariableOrDollar() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:252:1: ( ruleVariableOrDollar EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:253:1: ruleVariableOrDollar EOF
            {
             before(grammarAccess.getVariableOrDollarRule()); 
            pushFollow(FOLLOW_ruleVariableOrDollar_in_entryRuleVariableOrDollar425);
            ruleVariableOrDollar();

            state._fsp--;

             after(grammarAccess.getVariableOrDollarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableOrDollar432); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:263:1: ruleVariableOrDollar : ( ( rule__VariableOrDollar__Alternatives ) ) ;
    public final void ruleVariableOrDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:268:5: ( ( ( rule__VariableOrDollar__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:269:1: ( ( rule__VariableOrDollar__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:269:1: ( ( rule__VariableOrDollar__Alternatives ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:270:1: ( rule__VariableOrDollar__Alternatives )
            {
             before(grammarAccess.getVariableOrDollarAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:271:1: ( rule__VariableOrDollar__Alternatives )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:271:2: rule__VariableOrDollar__Alternatives
            {
            pushFollow(FOLLOW_rule__VariableOrDollar__Alternatives_in_ruleVariableOrDollar466);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:284:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:288:1: ( ruleVariable EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:289:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable498);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable505); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:299:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:304:5: ( ( ( rule__Variable__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:305:1: ( ( rule__Variable__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:305:1: ( ( rule__Variable__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:306:1: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:307:1: ( rule__Variable__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:307:2: rule__Variable__Group__0
            {
            pushFollow(FOLLOW_rule__Variable__Group__0_in_ruleVariable539);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:320:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:324:1: ( ruleValidID EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:325:1: ruleValidID EOF
            {
             before(grammarAccess.getValidIDRule()); 
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID571);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getValidIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID578); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:335:1: ruleValidID : ( ( rule__ValidID__Alternatives ) ) ;
    public final void ruleValidID() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:340:5: ( ( ( rule__ValidID__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:341:1: ( ( rule__ValidID__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:341:1: ( ( rule__ValidID__Alternatives ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:342:1: ( rule__ValidID__Alternatives )
            {
             before(grammarAccess.getValidIDAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:343:1: ( rule__ValidID__Alternatives )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:343:2: rule__ValidID__Alternatives
            {
            pushFollow(FOLLOW_rule__ValidID__Alternatives_in_ruleValidID612);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:356:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:360:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:361:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN644);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN651); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:371:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:376:5: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:377:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:377:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:378:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:379:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:379:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN685);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:392:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:396:1: ( ruleLiteral EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:397:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral717);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral724); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:407:1: ruleLiteral : ( ( rule__Literal__ValueAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:412:5: ( ( ( rule__Literal__ValueAssignment ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:413:1: ( ( rule__Literal__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:413:1: ( ( rule__Literal__ValueAssignment ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:414:1: ( rule__Literal__ValueAssignment )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:415:1: ( rule__Literal__ValueAssignment )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:415:2: rule__Literal__ValueAssignment
            {
            pushFollow(FOLLOW_rule__Literal__ValueAssignment_in_ruleLiteral758);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:428:1: entryRuleDollar : ruleDollar EOF ;
    public final void entryRuleDollar() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:432:1: ( ruleDollar EOF )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:433:1: ruleDollar EOF
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:443:1: ruleDollar : ( ( rule__Dollar__Group__0 ) ) ;
    public final void ruleDollar() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:448:5: ( ( ( rule__Dollar__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:449:1: ( ( rule__Dollar__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:449:1: ( ( rule__Dollar__Group__0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:450:1: ( rule__Dollar__Group__0 )
            {
             before(grammarAccess.getDollarAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:451:1: ( rule__Dollar__Group__0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:451:2: rule__Dollar__Group__0
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


    // $ANTLR start "rule__Codetemplate__Alternatives_2"
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:464:1: rule__Codetemplate__Alternatives_2 : ( ( ( rule__Codetemplate__ContextAssignment_2_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) ) );
    public final void rule__Codetemplate__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:468:1: ( ( ( rule__Codetemplate__ContextAssignment_2_0 ) ) | ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=KEYWORD_12 && LA2_0<=KEYWORD_11)||LA2_0==RULE_ID) ) {
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
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:469:1: ( ( rule__Codetemplate__ContextAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:469:1: ( ( rule__Codetemplate__ContextAssignment_2_0 ) )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:470:1: ( rule__Codetemplate__ContextAssignment_2_0 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getContextAssignment_2_0()); 
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:471:1: ( rule__Codetemplate__ContextAssignment_2_0 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:471:2: rule__Codetemplate__ContextAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__Codetemplate__ContextAssignment_2_0_in_rule__Codetemplate__Alternatives_2867);
                    rule__Codetemplate__ContextAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCodetemplateAccess().getContextAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:475:6: ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:475:6: ( ( rule__Codetemplate__KeywordContextAssignment_2_1 ) )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:476:1: ( rule__Codetemplate__KeywordContextAssignment_2_1 )
                    {
                     before(grammarAccess.getCodetemplateAccess().getKeywordContextAssignment_2_1()); 
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:477:1: ( rule__Codetemplate__KeywordContextAssignment_2_1 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:477:2: rule__Codetemplate__KeywordContextAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__Codetemplate__KeywordContextAssignment_2_1_in_rule__Codetemplate__Alternatives_2885);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:486:1: rule__LiteralValue__Alternatives : ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) );
    public final void rule__LiteralValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:490:1: ( ( RULE_WS ) | ( RULE_ANY_OTHER ) | ( RULE_ID ) )
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
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:491:1: ( RULE_WS )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:491:1: ( RULE_WS )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:492:1: RULE_WS
                    {
                     before(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 
                    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__LiteralValue__Alternatives918); 
                     after(grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:497:6: ( RULE_ANY_OTHER )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:497:6: ( RULE_ANY_OTHER )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:498:1: RULE_ANY_OTHER
                    {
                     before(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 
                    match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_rule__LiteralValue__Alternatives935); 
                     after(grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:503:6: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:503:6: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:504:1: RULE_ID
                    {
                     before(grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LiteralValue__Alternatives952); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:515:1: rule__VariableOrDollar__Alternatives : ( ( ruleVariable ) | ( ruleDollar ) );
    public final void rule__VariableOrDollar__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:519:1: ( ( ruleVariable ) | ( ruleDollar ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==KEYWORD_9) ) {
                alt4=1;
            }
            else if ( (LA4_0==KEYWORD_8||LA4_0==KEYWORD_1) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:520:1: ( ruleVariable )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:520:1: ( ruleVariable )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:521:1: ruleVariable
                    {
                     before(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleVariable_in_rule__VariableOrDollar__Alternatives985);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:526:6: ( ruleDollar )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:526:6: ( ruleDollar )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:527:1: ruleDollar
                    {
                     before(grammarAccess.getVariableOrDollarAccess().getDollarParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDollar_in_rule__VariableOrDollar__Alternatives1002);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:537:1: rule__Variable__Alternatives_2 : ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) );
    public final void rule__Variable__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:541:1: ( ( ( rule__Variable__NameAssignment_2_0 ) ) | ( ( rule__Variable__Group_2_1__0 ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:542:1: ( ( rule__Variable__NameAssignment_2_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:542:1: ( ( rule__Variable__NameAssignment_2_0 ) )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:543:1: ( rule__Variable__NameAssignment_2_0 )
                    {
                     before(grammarAccess.getVariableAccess().getNameAssignment_2_0()); 
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:544:1: ( rule__Variable__NameAssignment_2_0 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:544:2: rule__Variable__NameAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__Variable__NameAssignment_2_0_in_rule__Variable__Alternatives_21034);
                    rule__Variable__NameAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVariableAccess().getNameAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:548:6: ( ( rule__Variable__Group_2_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:548:6: ( ( rule__Variable__Group_2_1__0 ) )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:549:1: ( rule__Variable__Group_2_1__0 )
                    {
                     before(grammarAccess.getVariableAccess().getGroup_2_1()); 
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:550:1: ( rule__Variable__Group_2_1__0 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:550:2: rule__Variable__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Variable__Group_2_1__0_in_rule__Variable__Alternatives_21052);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:559:1: rule__Variable__ParametersAlternatives_2_1_4_3_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:563:1: ( ( RULE_STRING ) | ( ruleFQN ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=KEYWORD_12 && LA6_0<=KEYWORD_11)||LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:564:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:564:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:565:1: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Variable__ParametersAlternatives_2_1_4_3_01085); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:570:6: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:570:6: ( ruleFQN )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:571:1: ruleFQN
                    {
                     before(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_1()); 
                    pushFollow(FOLLOW_ruleFQN_in_rule__Variable__ParametersAlternatives_2_1_4_3_01102);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:581:1: rule__Variable__ParametersAlternatives_2_1_4_4_3_0 : ( ( RULE_STRING ) | ( ruleFQN ) );
    public final void rule__Variable__ParametersAlternatives_2_1_4_4_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:585:1: ( ( RULE_STRING ) | ( ruleFQN ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=KEYWORD_12 && LA7_0<=KEYWORD_11)||LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:586:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:586:1: ( RULE_STRING )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:587:1: RULE_STRING
                    {
                     before(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_4_3_0_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Variable__ParametersAlternatives_2_1_4_4_3_01134); 
                     after(grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_4_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:592:6: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:592:6: ( ruleFQN )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:593:1: ruleFQN
                    {
                     before(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_4_3_0_1()); 
                    pushFollow(FOLLOW_ruleFQN_in_rule__Variable__ParametersAlternatives_2_1_4_4_3_01151);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:603:1: rule__ValidID__Alternatives : ( ( RULE_ID ) | ( KEYWORD_11 ) | ( KEYWORD_12 ) );
    public final void rule__ValidID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:607:1: ( ( RULE_ID ) | ( KEYWORD_11 ) | ( KEYWORD_12 ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt8=1;
                }
                break;
            case KEYWORD_11:
                {
                alt8=2;
                }
                break;
            case KEYWORD_12:
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
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:608:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:608:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:609:1: RULE_ID
                    {
                     before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ValidID__Alternatives1183); 
                     after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:614:6: ( KEYWORD_11 )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:614:6: ( KEYWORD_11 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:615:1: KEYWORD_11
                    {
                     before(grammarAccess.getValidIDAccess().getForKeyword_1()); 
                    match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_rule__ValidID__Alternatives1201); 
                     after(grammarAccess.getValidIDAccess().getForKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:622:6: ( KEYWORD_12 )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:622:6: ( KEYWORD_12 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:623:1: KEYWORD_12
                    {
                     before(grammarAccess.getValidIDAccess().getTemplatesKeyword_2()); 
                    match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_rule__ValidID__Alternatives1221); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:635:1: rule__Dollar__Alternatives_1 : ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( KEYWORD_1 ) );
    public final void rule__Dollar__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:639:1: ( ( ( rule__Dollar__EscapedAssignment_1_0 ) ) | ( KEYWORD_1 ) )
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
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:640:1: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:640:1: ( ( rule__Dollar__EscapedAssignment_1_0 ) )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:641:1: ( rule__Dollar__EscapedAssignment_1_0 )
                    {
                     before(grammarAccess.getDollarAccess().getEscapedAssignment_1_0()); 
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:642:1: ( rule__Dollar__EscapedAssignment_1_0 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:642:2: rule__Dollar__EscapedAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__Dollar__EscapedAssignment_1_0_in_rule__Dollar__Alternatives_11255);
                    rule__Dollar__EscapedAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDollarAccess().getEscapedAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:646:6: ( KEYWORD_1 )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:646:6: ( KEYWORD_1 )
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:647:1: KEYWORD_1
                    {
                     before(grammarAccess.getDollarAccess().getDollarSignKeyword_1_1()); 
                    match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_rule__Dollar__Alternatives_11274); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:661:1: rule__Codetemplates__Group__0 : rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 ;
    public final void rule__Codetemplates__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:665:1: ( rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:666:2: rule__Codetemplates__Group__0__Impl rule__Codetemplates__Group__1
            {
            pushFollow(FOLLOW_rule__Codetemplates__Group__0__Impl_in_rule__Codetemplates__Group__01306);
            rule__Codetemplates__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplates__Group__1_in_rule__Codetemplates__Group__01309);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:673:1: rule__Codetemplates__Group__0__Impl : ( KEYWORD_12 ) ;
    public final void rule__Codetemplates__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:677:1: ( ( KEYWORD_12 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:678:1: ( KEYWORD_12 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:678:1: ( KEYWORD_12 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:679:1: KEYWORD_12
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesKeyword_0()); 
            match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_rule__Codetemplates__Group__0__Impl1337); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:692:1: rule__Codetemplates__Group__1 : rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 ;
    public final void rule__Codetemplates__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:696:1: ( rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:697:2: rule__Codetemplates__Group__1__Impl rule__Codetemplates__Group__2
            {
            pushFollow(FOLLOW_rule__Codetemplates__Group__1__Impl_in_rule__Codetemplates__Group__11368);
            rule__Codetemplates__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplates__Group__2_in_rule__Codetemplates__Group__11371);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:704:1: rule__Codetemplates__Group__1__Impl : ( KEYWORD_11 ) ;
    public final void rule__Codetemplates__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:708:1: ( ( KEYWORD_11 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:709:1: ( KEYWORD_11 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:709:1: ( KEYWORD_11 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:710:1: KEYWORD_11
            {
             before(grammarAccess.getCodetemplatesAccess().getForKeyword_1()); 
            match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_rule__Codetemplates__Group__1__Impl1399); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:723:1: rule__Codetemplates__Group__2 : rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 ;
    public final void rule__Codetemplates__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:727:1: ( rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:728:2: rule__Codetemplates__Group__2__Impl rule__Codetemplates__Group__3
            {
            pushFollow(FOLLOW_rule__Codetemplates__Group__2__Impl_in_rule__Codetemplates__Group__21430);
            rule__Codetemplates__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplates__Group__3_in_rule__Codetemplates__Group__21433);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:735:1: rule__Codetemplates__Group__2__Impl : ( ( rule__Codetemplates__LanguageAssignment_2 ) ) ;
    public final void rule__Codetemplates__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:739:1: ( ( ( rule__Codetemplates__LanguageAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:740:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:740:1: ( ( rule__Codetemplates__LanguageAssignment_2 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:741:1: ( rule__Codetemplates__LanguageAssignment_2 )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageAssignment_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:742:1: ( rule__Codetemplates__LanguageAssignment_2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:742:2: rule__Codetemplates__LanguageAssignment_2
            {
            pushFollow(FOLLOW_rule__Codetemplates__LanguageAssignment_2_in_rule__Codetemplates__Group__2__Impl1460);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:752:1: rule__Codetemplates__Group__3 : rule__Codetemplates__Group__3__Impl ;
    public final void rule__Codetemplates__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:756:1: ( rule__Codetemplates__Group__3__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:757:2: rule__Codetemplates__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Codetemplates__Group__3__Impl_in_rule__Codetemplates__Group__31490);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:763:1: rule__Codetemplates__Group__3__Impl : ( ( rule__Codetemplates__TemplatesAssignment_3 ) ) ;
    public final void rule__Codetemplates__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:767:1: ( ( ( rule__Codetemplates__TemplatesAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:768:1: ( ( rule__Codetemplates__TemplatesAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:768:1: ( ( rule__Codetemplates__TemplatesAssignment_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:769:1: ( rule__Codetemplates__TemplatesAssignment_3 )
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesAssignment_3()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:770:1: ( rule__Codetemplates__TemplatesAssignment_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:770:2: rule__Codetemplates__TemplatesAssignment_3
            {
            pushFollow(FOLLOW_rule__Codetemplates__TemplatesAssignment_3_in_rule__Codetemplates__Group__3__Impl1517);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:788:1: rule__Codetemplate__Group__0 : rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 ;
    public final void rule__Codetemplate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:792:1: ( rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:793:2: rule__Codetemplate__Group__0__Impl rule__Codetemplate__Group__1
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__0__Impl_in_rule__Codetemplate__Group__01555);
            rule__Codetemplate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__1_in_rule__Codetemplate__Group__01558);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:800:1: rule__Codetemplate__Group__0__Impl : ( ( rule__Codetemplate__NameAssignment_0 ) ) ;
    public final void rule__Codetemplate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:804:1: ( ( ( rule__Codetemplate__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:805:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:805:1: ( ( rule__Codetemplate__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:806:1: ( rule__Codetemplate__NameAssignment_0 )
            {
             before(grammarAccess.getCodetemplateAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:807:1: ( rule__Codetemplate__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:807:2: rule__Codetemplate__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Codetemplate__NameAssignment_0_in_rule__Codetemplate__Group__0__Impl1585);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:817:1: rule__Codetemplate__Group__1 : rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 ;
    public final void rule__Codetemplate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:821:1: ( rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:822:2: rule__Codetemplate__Group__1__Impl rule__Codetemplate__Group__2
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__1__Impl_in_rule__Codetemplate__Group__11615);
            rule__Codetemplate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__2_in_rule__Codetemplate__Group__11618);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:829:1: rule__Codetemplate__Group__1__Impl : ( KEYWORD_11 ) ;
    public final void rule__Codetemplate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:833:1: ( ( KEYWORD_11 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:834:1: ( KEYWORD_11 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:834:1: ( KEYWORD_11 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:835:1: KEYWORD_11
            {
             before(grammarAccess.getCodetemplateAccess().getForKeyword_1()); 
            match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_rule__Codetemplate__Group__1__Impl1646); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:848:1: rule__Codetemplate__Group__2 : rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 ;
    public final void rule__Codetemplate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:852:1: ( rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:853:2: rule__Codetemplate__Group__2__Impl rule__Codetemplate__Group__3
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__2__Impl_in_rule__Codetemplate__Group__21677);
            rule__Codetemplate__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Codetemplate__Group__3_in_rule__Codetemplate__Group__21680);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:860:1: rule__Codetemplate__Group__2__Impl : ( ( rule__Codetemplate__Alternatives_2 ) ) ;
    public final void rule__Codetemplate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:864:1: ( ( ( rule__Codetemplate__Alternatives_2 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:865:1: ( ( rule__Codetemplate__Alternatives_2 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:865:1: ( ( rule__Codetemplate__Alternatives_2 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:866:1: ( rule__Codetemplate__Alternatives_2 )
            {
             before(grammarAccess.getCodetemplateAccess().getAlternatives_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:867:1: ( rule__Codetemplate__Alternatives_2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:867:2: rule__Codetemplate__Alternatives_2
            {
            pushFollow(FOLLOW_rule__Codetemplate__Alternatives_2_in_rule__Codetemplate__Group__2__Impl1707);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:877:1: rule__Codetemplate__Group__3 : rule__Codetemplate__Group__3__Impl ;
    public final void rule__Codetemplate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:881:1: ( rule__Codetemplate__Group__3__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:882:2: rule__Codetemplate__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Codetemplate__Group__3__Impl_in_rule__Codetemplate__Group__31737);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:888:1: rule__Codetemplate__Group__3__Impl : ( ( rule__Codetemplate__BodyAssignment_3 ) ) ;
    public final void rule__Codetemplate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:892:1: ( ( ( rule__Codetemplate__BodyAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:893:1: ( ( rule__Codetemplate__BodyAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:893:1: ( ( rule__Codetemplate__BodyAssignment_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:894:1: ( rule__Codetemplate__BodyAssignment_3 )
            {
             before(grammarAccess.getCodetemplateAccess().getBodyAssignment_3()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:895:1: ( rule__Codetemplate__BodyAssignment_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:895:2: rule__Codetemplate__BodyAssignment_3
            {
            pushFollow(FOLLOW_rule__Codetemplate__BodyAssignment_3_in_rule__Codetemplate__Group__3__Impl1764);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:913:1: rule__TemplateBodyWithQuotes__Group__0 : rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 ;
    public final void rule__TemplateBodyWithQuotes__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:917:1: ( rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:918:2: rule__TemplateBodyWithQuotes__Group__0__Impl rule__TemplateBodyWithQuotes__Group__1
            {
            pushFollow(FOLLOW_rule__TemplateBodyWithQuotes__Group__0__Impl_in_rule__TemplateBodyWithQuotes__Group__01802);
            rule__TemplateBodyWithQuotes__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TemplateBodyWithQuotes__Group__1_in_rule__TemplateBodyWithQuotes__Group__01805);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:925:1: rule__TemplateBodyWithQuotes__Group__0__Impl : ( KEYWORD_10 ) ;
    public final void rule__TemplateBodyWithQuotes__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:929:1: ( ( KEYWORD_10 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:930:1: ( KEYWORD_10 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:930:1: ( KEYWORD_10 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:931:1: KEYWORD_10
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_0()); 
            match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_rule__TemplateBodyWithQuotes__Group__0__Impl1833); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:944:1: rule__TemplateBodyWithQuotes__Group__1 : rule__TemplateBodyWithQuotes__Group__1__Impl ;
    public final void rule__TemplateBodyWithQuotes__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:948:1: ( rule__TemplateBodyWithQuotes__Group__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:949:2: rule__TemplateBodyWithQuotes__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TemplateBodyWithQuotes__Group__1__Impl_in_rule__TemplateBodyWithQuotes__Group__11864);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:955:1: rule__TemplateBodyWithQuotes__Group__1__Impl : ( ruleTemplateBody ) ;
    public final void rule__TemplateBodyWithQuotes__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:959:1: ( ( ruleTemplateBody ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:960:1: ( ruleTemplateBody )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:960:1: ( ruleTemplateBody )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:961:1: ruleTemplateBody
            {
             before(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleTemplateBody_in_rule__TemplateBodyWithQuotes__Group__1__Impl1891);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:976:1: rule__TemplateBody__Group__0 : rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 ;
    public final void rule__TemplateBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:980:1: ( rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:981:2: rule__TemplateBody__Group__0__Impl rule__TemplateBody__Group__1
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group__0__Impl_in_rule__TemplateBody__Group__01924);
            rule__TemplateBody__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TemplateBody__Group__1_in_rule__TemplateBody__Group__01927);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:988:1: rule__TemplateBody__Group__0__Impl : ( () ) ;
    public final void rule__TemplateBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:992:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:993:1: ( () )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:993:1: ( () )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:994:1: ()
            {
             before(grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:995:1: ()
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:997:1: 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1007:1: rule__TemplateBody__Group__1 : rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 ;
    public final void rule__TemplateBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1011:1: ( rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1012:2: rule__TemplateBody__Group__1__Impl rule__TemplateBody__Group__2
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group__1__Impl_in_rule__TemplateBody__Group__11985);
            rule__TemplateBody__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TemplateBody__Group__2_in_rule__TemplateBody__Group__11988);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1019:1: rule__TemplateBody__Group__1__Impl : ( ( rule__TemplateBody__PartsAssignment_1 )? ) ;
    public final void rule__TemplateBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1023:1: ( ( ( rule__TemplateBody__PartsAssignment_1 )? ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1024:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1024:1: ( ( rule__TemplateBody__PartsAssignment_1 )? )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1025:1: ( rule__TemplateBody__PartsAssignment_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1026:1: ( rule__TemplateBody__PartsAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||(LA10_0>=RULE_WS && LA10_0<=RULE_ANY_OTHER)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1026:2: rule__TemplateBody__PartsAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TemplateBody__PartsAssignment_1_in_rule__TemplateBody__Group__1__Impl2015);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1036:1: rule__TemplateBody__Group__2 : rule__TemplateBody__Group__2__Impl ;
    public final void rule__TemplateBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1040:1: ( rule__TemplateBody__Group__2__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1041:2: rule__TemplateBody__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group__2__Impl_in_rule__TemplateBody__Group__22046);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1047:1: rule__TemplateBody__Group__2__Impl : ( ( rule__TemplateBody__Group_2__0 )* ) ;
    public final void rule__TemplateBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1051:1: ( ( ( rule__TemplateBody__Group_2__0 )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1052:1: ( ( rule__TemplateBody__Group_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1052:1: ( ( rule__TemplateBody__Group_2__0 )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1053:1: ( rule__TemplateBody__Group_2__0 )*
            {
             before(grammarAccess.getTemplateBodyAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1054:1: ( rule__TemplateBody__Group_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=KEYWORD_8 && LA11_0<=KEYWORD_9)||LA11_0==KEYWORD_1) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1054:2: rule__TemplateBody__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__TemplateBody__Group_2__0_in_rule__TemplateBody__Group__2__Impl2073);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1070:1: rule__TemplateBody__Group_2__0 : rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 ;
    public final void rule__TemplateBody__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1074:1: ( rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1075:2: rule__TemplateBody__Group_2__0__Impl rule__TemplateBody__Group_2__1
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group_2__0__Impl_in_rule__TemplateBody__Group_2__02110);
            rule__TemplateBody__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TemplateBody__Group_2__1_in_rule__TemplateBody__Group_2__02113);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1082:1: rule__TemplateBody__Group_2__0__Impl : ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) ;
    public final void rule__TemplateBody__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1086:1: ( ( ( rule__TemplateBody__PartsAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1087:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1087:1: ( ( rule__TemplateBody__PartsAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1088:1: ( rule__TemplateBody__PartsAssignment_2_0 )
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1089:1: ( rule__TemplateBody__PartsAssignment_2_0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1089:2: rule__TemplateBody__PartsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__TemplateBody__PartsAssignment_2_0_in_rule__TemplateBody__Group_2__0__Impl2140);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1099:1: rule__TemplateBody__Group_2__1 : rule__TemplateBody__Group_2__1__Impl ;
    public final void rule__TemplateBody__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1103:1: ( rule__TemplateBody__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1104:2: rule__TemplateBody__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TemplateBody__Group_2__1__Impl_in_rule__TemplateBody__Group_2__12170);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1110:1: rule__TemplateBody__Group_2__1__Impl : ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) ;
    public final void rule__TemplateBody__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1114:1: ( ( ( rule__TemplateBody__PartsAssignment_2_1 )? ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1115:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1115:1: ( ( rule__TemplateBody__PartsAssignment_2_1 )? )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1116:1: ( rule__TemplateBody__PartsAssignment_2_1 )?
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1117:1: ( rule__TemplateBody__PartsAssignment_2_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||(LA12_0>=RULE_WS && LA12_0<=RULE_ANY_OTHER)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1117:2: rule__TemplateBody__PartsAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__TemplateBody__PartsAssignment_2_1_in_rule__TemplateBody__Group_2__1__Impl2197);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1131:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1135:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1136:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__02232);
            rule__Variable__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__02235);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1143:1: rule__Variable__Group__0__Impl : ( KEYWORD_9 ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1147:1: ( ( KEYWORD_9 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1148:1: ( KEYWORD_9 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1148:1: ( KEYWORD_9 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1149:1: KEYWORD_9
            {
             before(grammarAccess.getVariableAccess().getDollarSignLeftCurlyBracketKeyword_0()); 
            match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_rule__Variable__Group__0__Impl2263); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1162:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1166:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1167:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__12294);
            rule__Variable__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__12297);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1174:1: rule__Variable__Group__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1178:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1179:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1179:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1180:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1181:1: ( RULE_WS )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1181:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group__1__Impl2325); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1191:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1195:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1196:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
            {
            pushFollow(FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__22356);
            rule__Variable__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group__3_in_rule__Variable__Group__22359);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1203:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Alternatives_2 ) ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1207:1: ( ( ( rule__Variable__Alternatives_2 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1208:1: ( ( rule__Variable__Alternatives_2 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1208:1: ( ( rule__Variable__Alternatives_2 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1209:1: ( rule__Variable__Alternatives_2 )
            {
             before(grammarAccess.getVariableAccess().getAlternatives_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1210:1: ( rule__Variable__Alternatives_2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1210:2: rule__Variable__Alternatives_2
            {
            pushFollow(FOLLOW_rule__Variable__Alternatives_2_in_rule__Variable__Group__2__Impl2386);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1220:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl rule__Variable__Group__4 ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1224:1: ( rule__Variable__Group__3__Impl rule__Variable__Group__4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1225:2: rule__Variable__Group__3__Impl rule__Variable__Group__4
            {
            pushFollow(FOLLOW_rule__Variable__Group__3__Impl_in_rule__Variable__Group__32416);
            rule__Variable__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group__4_in_rule__Variable__Group__32419);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1232:1: rule__Variable__Group__3__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1236:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1237:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1237:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1238:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_3()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1239:1: ( RULE_WS )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_WS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1239:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group__3__Impl2447); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1249:1: rule__Variable__Group__4 : rule__Variable__Group__4__Impl ;
    public final void rule__Variable__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1253:1: ( rule__Variable__Group__4__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1254:2: rule__Variable__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group__4__Impl_in_rule__Variable__Group__42478);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1260:1: rule__Variable__Group__4__Impl : ( KEYWORD_7 ) ;
    public final void rule__Variable__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1264:1: ( ( KEYWORD_7 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1265:1: ( KEYWORD_7 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1265:1: ( KEYWORD_7 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1266:1: KEYWORD_7
            {
             before(grammarAccess.getVariableAccess().getRightCurlyBracketKeyword_4()); 
            match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_rule__Variable__Group__4__Impl2506); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1289:1: rule__Variable__Group_2_1__0 : rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 ;
    public final void rule__Variable__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1293:1: ( rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1294:2: rule__Variable__Group_2_1__0__Impl rule__Variable__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1__0__Impl_in_rule__Variable__Group_2_1__02547);
            rule__Variable__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1__1_in_rule__Variable__Group_2_1__02550);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1301:1: rule__Variable__Group_2_1__0__Impl : ( ( rule__Variable__Group_2_1_0__0 )? ) ;
    public final void rule__Variable__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1305:1: ( ( ( rule__Variable__Group_2_1_0__0 )? ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1306:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1306:1: ( ( rule__Variable__Group_2_1_0__0 )? )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1307:1: ( rule__Variable__Group_2_1_0__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1308:1: ( rule__Variable__Group_2_1_0__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=KEYWORD_12 && LA15_0<=KEYWORD_11)||LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1308:2: rule__Variable__Group_2_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Variable__Group_2_1_0__0_in_rule__Variable__Group_2_1__0__Impl2577);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1318:1: rule__Variable__Group_2_1__1 : rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 ;
    public final void rule__Variable__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1322:1: ( rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1323:2: rule__Variable__Group_2_1__1__Impl rule__Variable__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1__1__Impl_in_rule__Variable__Group_2_1__12608);
            rule__Variable__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1__2_in_rule__Variable__Group_2_1__12611);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1330:1: rule__Variable__Group_2_1__1__Impl : ( KEYWORD_6 ) ;
    public final void rule__Variable__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1334:1: ( ( KEYWORD_6 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1335:1: ( KEYWORD_6 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1335:1: ( KEYWORD_6 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1336:1: KEYWORD_6
            {
             before(grammarAccess.getVariableAccess().getColonKeyword_2_1_1()); 
            match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_rule__Variable__Group_2_1__1__Impl2639); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1349:1: rule__Variable__Group_2_1__2 : rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 ;
    public final void rule__Variable__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1353:1: ( rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1354:2: rule__Variable__Group_2_1__2__Impl rule__Variable__Group_2_1__3
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1__2__Impl_in_rule__Variable__Group_2_1__22670);
            rule__Variable__Group_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1__3_in_rule__Variable__Group_2_1__22673);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1361:1: rule__Variable__Group_2_1__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1365:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1366:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1366:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1367:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1368:1: ( RULE_WS )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_WS) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1368:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1__2__Impl2701); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1378:1: rule__Variable__Group_2_1__3 : rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 ;
    public final void rule__Variable__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1382:1: ( rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1383:2: rule__Variable__Group_2_1__3__Impl rule__Variable__Group_2_1__4
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1__3__Impl_in_rule__Variable__Group_2_1__32732);
            rule__Variable__Group_2_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1__4_in_rule__Variable__Group_2_1__32735);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1390:1: rule__Variable__Group_2_1__3__Impl : ( ( rule__Variable__TypeAssignment_2_1_3 ) ) ;
    public final void rule__Variable__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1394:1: ( ( ( rule__Variable__TypeAssignment_2_1_3 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1395:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1395:1: ( ( rule__Variable__TypeAssignment_2_1_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1396:1: ( rule__Variable__TypeAssignment_2_1_3 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_2_1_3()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1397:1: ( rule__Variable__TypeAssignment_2_1_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1397:2: rule__Variable__TypeAssignment_2_1_3
            {
            pushFollow(FOLLOW_rule__Variable__TypeAssignment_2_1_3_in_rule__Variable__Group_2_1__3__Impl2762);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1407:1: rule__Variable__Group_2_1__4 : rule__Variable__Group_2_1__4__Impl ;
    public final void rule__Variable__Group_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1411:1: ( rule__Variable__Group_2_1__4__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1412:2: rule__Variable__Group_2_1__4__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1__4__Impl_in_rule__Variable__Group_2_1__42792);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1418:1: rule__Variable__Group_2_1__4__Impl : ( ( rule__Variable__Group_2_1_4__0 )? ) ;
    public final void rule__Variable__Group_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1422:1: ( ( ( rule__Variable__Group_2_1_4__0 )? ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1423:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1423:1: ( ( rule__Variable__Group_2_1_4__0 )? )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1424:1: ( rule__Variable__Group_2_1_4__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1425:1: ( rule__Variable__Group_2_1_4__0 )?
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1425:2: rule__Variable__Group_2_1_4__0
                    {
                    pushFollow(FOLLOW_rule__Variable__Group_2_1_4__0_in_rule__Variable__Group_2_1__4__Impl2819);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1445:1: rule__Variable__Group_2_1_0__0 : rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 ;
    public final void rule__Variable__Group_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1449:1: ( rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1450:2: rule__Variable__Group_2_1_0__0__Impl rule__Variable__Group_2_1_0__1
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_0__0__Impl_in_rule__Variable__Group_2_1_0__02860);
            rule__Variable__Group_2_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_0__1_in_rule__Variable__Group_2_1_0__02863);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1457:1: rule__Variable__Group_2_1_0__0__Impl : ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) ;
    public final void rule__Variable__Group_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1461:1: ( ( ( rule__Variable__NameAssignment_2_1_0_0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1462:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1462:1: ( ( rule__Variable__NameAssignment_2_1_0_0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1463:1: ( rule__Variable__NameAssignment_2_1_0_0 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_2_1_0_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1464:1: ( rule__Variable__NameAssignment_2_1_0_0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1464:2: rule__Variable__NameAssignment_2_1_0_0
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_2_1_0_0_in_rule__Variable__Group_2_1_0__0__Impl2890);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1474:1: rule__Variable__Group_2_1_0__1 : rule__Variable__Group_2_1_0__1__Impl ;
    public final void rule__Variable__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1478:1: ( rule__Variable__Group_2_1_0__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1479:2: rule__Variable__Group_2_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_0__1__Impl_in_rule__Variable__Group_2_1_0__12920);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1485:1: rule__Variable__Group_2_1_0__1__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1489:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1490:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1490:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1491:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1492:1: ( RULE_WS )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_WS) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1492:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_0__1__Impl2948); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1506:1: rule__Variable__Group_2_1_4__0 : rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 ;
    public final void rule__Variable__Group_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1510:1: ( rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1511:2: rule__Variable__Group_2_1_4__0__Impl rule__Variable__Group_2_1_4__1
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__0__Impl_in_rule__Variable__Group_2_1_4__02983);
            rule__Variable__Group_2_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__1_in_rule__Variable__Group_2_1_4__02986);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1518:1: rule__Variable__Group_2_1_4__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1522:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1523:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1523:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1524:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1525:1: ( RULE_WS )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_WS) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1525:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__0__Impl3014); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1535:1: rule__Variable__Group_2_1_4__1 : rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 ;
    public final void rule__Variable__Group_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1539:1: ( rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1540:2: rule__Variable__Group_2_1_4__1__Impl rule__Variable__Group_2_1_4__2
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__1__Impl_in_rule__Variable__Group_2_1_4__13045);
            rule__Variable__Group_2_1_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__2_in_rule__Variable__Group_2_1_4__13048);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1547:1: rule__Variable__Group_2_1_4__1__Impl : ( KEYWORD_2 ) ;
    public final void rule__Variable__Group_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1551:1: ( ( KEYWORD_2 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1552:1: ( KEYWORD_2 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1552:1: ( KEYWORD_2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1553:1: KEYWORD_2
            {
             before(grammarAccess.getVariableAccess().getLeftParenthesisKeyword_2_1_4_1()); 
            match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_rule__Variable__Group_2_1_4__1__Impl3076); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1566:1: rule__Variable__Group_2_1_4__2 : rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 ;
    public final void rule__Variable__Group_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1570:1: ( rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1571:2: rule__Variable__Group_2_1_4__2__Impl rule__Variable__Group_2_1_4__3
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__2__Impl_in_rule__Variable__Group_2_1_4__23107);
            rule__Variable__Group_2_1_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__3_in_rule__Variable__Group_2_1_4__23110);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1578:1: rule__Variable__Group_2_1_4__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1582:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1583:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1583:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1584:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1585:1: ( RULE_WS )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_WS) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1585:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__2__Impl3138); 

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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1595:1: rule__Variable__Group_2_1_4__3 : rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 ;
    public final void rule__Variable__Group_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1599:1: ( rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1600:2: rule__Variable__Group_2_1_4__3__Impl rule__Variable__Group_2_1_4__4
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__3__Impl_in_rule__Variable__Group_2_1_4__33169);
            rule__Variable__Group_2_1_4__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__4_in_rule__Variable__Group_2_1_4__33172);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1607:1: rule__Variable__Group_2_1_4__3__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_3 ) ) ;
    public final void rule__Variable__Group_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1611:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_3 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1612:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1612:1: ( ( rule__Variable__ParametersAssignment_2_1_4_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1613:1: ( rule__Variable__ParametersAssignment_2_1_4_3 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1614:1: ( rule__Variable__ParametersAssignment_2_1_4_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1614:2: rule__Variable__ParametersAssignment_2_1_4_3
            {
            pushFollow(FOLLOW_rule__Variable__ParametersAssignment_2_1_4_3_in_rule__Variable__Group_2_1_4__3__Impl3199);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1624:1: rule__Variable__Group_2_1_4__4 : rule__Variable__Group_2_1_4__4__Impl rule__Variable__Group_2_1_4__5 ;
    public final void rule__Variable__Group_2_1_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1628:1: ( rule__Variable__Group_2_1_4__4__Impl rule__Variable__Group_2_1_4__5 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1629:2: rule__Variable__Group_2_1_4__4__Impl rule__Variable__Group_2_1_4__5
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__4__Impl_in_rule__Variable__Group_2_1_4__43229);
            rule__Variable__Group_2_1_4__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__5_in_rule__Variable__Group_2_1_4__43232);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1636:1: rule__Variable__Group_2_1_4__4__Impl : ( ( rule__Variable__Group_2_1_4_4__0 )* ) ;
    public final void rule__Variable__Group_2_1_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1640:1: ( ( ( rule__Variable__Group_2_1_4_4__0 )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1641:1: ( ( rule__Variable__Group_2_1_4_4__0 )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1641:1: ( ( rule__Variable__Group_2_1_4_4__0 )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1642:1: ( rule__Variable__Group_2_1_4_4__0 )*
            {
             before(grammarAccess.getVariableAccess().getGroup_2_1_4_4()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1643:1: ( rule__Variable__Group_2_1_4_4__0 )*
            loop21:
            do {
                int alt21=2;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1643:2: rule__Variable__Group_2_1_4_4__0
            	    {
            	    pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__0_in_rule__Variable__Group_2_1_4__4__Impl3259);
            	    rule__Variable__Group_2_1_4_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1653:1: rule__Variable__Group_2_1_4__5 : rule__Variable__Group_2_1_4__5__Impl rule__Variable__Group_2_1_4__6 ;
    public final void rule__Variable__Group_2_1_4__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1657:1: ( rule__Variable__Group_2_1_4__5__Impl rule__Variable__Group_2_1_4__6 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1658:2: rule__Variable__Group_2_1_4__5__Impl rule__Variable__Group_2_1_4__6
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__5__Impl_in_rule__Variable__Group_2_1_4__53290);
            rule__Variable__Group_2_1_4__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__6_in_rule__Variable__Group_2_1_4__53293);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1665:1: rule__Variable__Group_2_1_4__5__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1669:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1670:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1670:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1671:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_5()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1672:1: ( RULE_WS )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_WS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1672:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__5__Impl3321); 

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1682:1: rule__Variable__Group_2_1_4__6 : rule__Variable__Group_2_1_4__6__Impl ;
    public final void rule__Variable__Group_2_1_4__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1686:1: ( rule__Variable__Group_2_1_4__6__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1687:2: rule__Variable__Group_2_1_4__6__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4__6__Impl_in_rule__Variable__Group_2_1_4__63352);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1693:1: rule__Variable__Group_2_1_4__6__Impl : ( KEYWORD_3 ) ;
    public final void rule__Variable__Group_2_1_4__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1697:1: ( ( KEYWORD_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1698:1: ( KEYWORD_3 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1698:1: ( KEYWORD_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1699:1: KEYWORD_3
            {
             before(grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_6()); 
            match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_rule__Variable__Group_2_1_4__6__Impl3380); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1726:1: rule__Variable__Group_2_1_4_4__0 : rule__Variable__Group_2_1_4_4__0__Impl rule__Variable__Group_2_1_4_4__1 ;
    public final void rule__Variable__Group_2_1_4_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1730:1: ( rule__Variable__Group_2_1_4_4__0__Impl rule__Variable__Group_2_1_4_4__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1731:2: rule__Variable__Group_2_1_4_4__0__Impl rule__Variable__Group_2_1_4_4__1
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__0__Impl_in_rule__Variable__Group_2_1_4_4__03425);
            rule__Variable__Group_2_1_4_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__1_in_rule__Variable__Group_2_1_4_4__03428);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1738:1: rule__Variable__Group_2_1_4_4__0__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1742:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1743:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1743:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1744:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_4_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1745:1: ( RULE_WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1745:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4_4__0__Impl3456); 

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1755:1: rule__Variable__Group_2_1_4_4__1 : rule__Variable__Group_2_1_4_4__1__Impl rule__Variable__Group_2_1_4_4__2 ;
    public final void rule__Variable__Group_2_1_4_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1759:1: ( rule__Variable__Group_2_1_4_4__1__Impl rule__Variable__Group_2_1_4_4__2 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1760:2: rule__Variable__Group_2_1_4_4__1__Impl rule__Variable__Group_2_1_4_4__2
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__1__Impl_in_rule__Variable__Group_2_1_4_4__13487);
            rule__Variable__Group_2_1_4_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__2_in_rule__Variable__Group_2_1_4_4__13490);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1767:1: rule__Variable__Group_2_1_4_4__1__Impl : ( KEYWORD_4 ) ;
    public final void rule__Variable__Group_2_1_4_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1771:1: ( ( KEYWORD_4 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1772:1: ( KEYWORD_4 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1772:1: ( KEYWORD_4 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1773:1: KEYWORD_4
            {
             before(grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_4_1()); 
            match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_rule__Variable__Group_2_1_4_4__1__Impl3518); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1786:1: rule__Variable__Group_2_1_4_4__2 : rule__Variable__Group_2_1_4_4__2__Impl rule__Variable__Group_2_1_4_4__3 ;
    public final void rule__Variable__Group_2_1_4_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1790:1: ( rule__Variable__Group_2_1_4_4__2__Impl rule__Variable__Group_2_1_4_4__3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1791:2: rule__Variable__Group_2_1_4_4__2__Impl rule__Variable__Group_2_1_4_4__3
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__2__Impl_in_rule__Variable__Group_2_1_4_4__23549);
            rule__Variable__Group_2_1_4_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__3_in_rule__Variable__Group_2_1_4_4__23552);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1798:1: rule__Variable__Group_2_1_4_4__2__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Variable__Group_2_1_4_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1802:1: ( ( ( RULE_WS )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1803:1: ( ( RULE_WS )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1803:1: ( ( RULE_WS )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1804:1: ( RULE_WS )*
            {
             before(grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_4_2()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1805:1: ( RULE_WS )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_WS) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1805:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4_4__2__Impl3580); 

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1815:1: rule__Variable__Group_2_1_4_4__3 : rule__Variable__Group_2_1_4_4__3__Impl ;
    public final void rule__Variable__Group_2_1_4_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1819:1: ( rule__Variable__Group_2_1_4_4__3__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1820:2: rule__Variable__Group_2_1_4_4__3__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group_2_1_4_4__3__Impl_in_rule__Variable__Group_2_1_4_4__33611);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1826:1: rule__Variable__Group_2_1_4_4__3__Impl : ( ( rule__Variable__ParametersAssignment_2_1_4_4_3 ) ) ;
    public final void rule__Variable__Group_2_1_4_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1830:1: ( ( ( rule__Variable__ParametersAssignment_2_1_4_4_3 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1831:1: ( ( rule__Variable__ParametersAssignment_2_1_4_4_3 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1831:1: ( ( rule__Variable__ParametersAssignment_2_1_4_4_3 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1832:1: ( rule__Variable__ParametersAssignment_2_1_4_4_3 )
            {
             before(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_4_3()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1833:1: ( rule__Variable__ParametersAssignment_2_1_4_4_3 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1833:2: rule__Variable__ParametersAssignment_2_1_4_4_3
            {
            pushFollow(FOLLOW_rule__Variable__ParametersAssignment_2_1_4_4_3_in_rule__Variable__Group_2_1_4_4__3__Impl3638);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1851:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1855:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1856:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__03676);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__03679);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1863:1: rule__FQN__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1867:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1868:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1868:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1869:1: ruleValidID
            {
             before(grammarAccess.getFQNAccess().getValidIDParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__FQN__Group__0__Impl3706);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1880:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1884:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1885:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__13735);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1891:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1895:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1896:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1896:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1897:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1898:1: ( rule__FQN__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==KEYWORD_5) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1898:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl3762);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1912:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1916:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1917:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__03797);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__03800);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1924:1: rule__FQN__Group_1__0__Impl : ( KEYWORD_5 ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1928:1: ( ( KEYWORD_5 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1929:1: ( KEYWORD_5 )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1929:1: ( KEYWORD_5 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1930:1: KEYWORD_5
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_rule__FQN__Group_1__0__Impl3828); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1943:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1947:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1948:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__13859);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1954:1: rule__FQN__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1958:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1959:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1959:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1960:1: ruleValidID
            {
             before(grammarAccess.getFQNAccess().getValidIDParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__FQN__Group_1__1__Impl3886);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1975:1: rule__Dollar__Group__0 : rule__Dollar__Group__0__Impl rule__Dollar__Group__1 ;
    public final void rule__Dollar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1979:1: ( rule__Dollar__Group__0__Impl rule__Dollar__Group__1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1980:2: rule__Dollar__Group__0__Impl rule__Dollar__Group__1
            {
            pushFollow(FOLLOW_rule__Dollar__Group__0__Impl_in_rule__Dollar__Group__03919);
            rule__Dollar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Dollar__Group__1_in_rule__Dollar__Group__03922);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1987:1: rule__Dollar__Group__0__Impl : ( () ) ;
    public final void rule__Dollar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1991:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1992:1: ( () )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1992:1: ( () )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1993:1: ()
            {
             before(grammarAccess.getDollarAccess().getDollarAction_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1994:1: ()
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:1996:1: 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2006:1: rule__Dollar__Group__1 : rule__Dollar__Group__1__Impl ;
    public final void rule__Dollar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2010:1: ( rule__Dollar__Group__1__Impl )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2011:2: rule__Dollar__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Dollar__Group__1__Impl_in_rule__Dollar__Group__13980);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2017:1: rule__Dollar__Group__1__Impl : ( ( rule__Dollar__Alternatives_1 ) ) ;
    public final void rule__Dollar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2021:1: ( ( ( rule__Dollar__Alternatives_1 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2022:1: ( ( rule__Dollar__Alternatives_1 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2022:1: ( ( rule__Dollar__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2023:1: ( rule__Dollar__Alternatives_1 )
            {
             before(grammarAccess.getDollarAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2024:1: ( rule__Dollar__Alternatives_1 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2024:2: rule__Dollar__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Dollar__Alternatives_1_in_rule__Dollar__Group__1__Impl4007);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2039:1: rule__Codetemplates__LanguageAssignment_2 : ( ( ruleFQN ) ) ;
    public final void rule__Codetemplates__LanguageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2043:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2044:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2044:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2045:1: ( ruleFQN )
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2046:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2047:1: ruleFQN
            {
             before(grammarAccess.getCodetemplatesAccess().getLanguageGrammarFQNParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Codetemplates__LanguageAssignment_24050);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2058:1: rule__Codetemplates__TemplatesAssignment_3 : ( ruleCodetemplate ) ;
    public final void rule__Codetemplates__TemplatesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2062:1: ( ( ruleCodetemplate ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2063:1: ( ruleCodetemplate )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2063:1: ( ruleCodetemplate )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2064:1: ruleCodetemplate
            {
             before(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCodetemplate_in_rule__Codetemplates__TemplatesAssignment_34085);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2073:1: rule__Codetemplate__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2077:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2078:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2078:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2079:1: RULE_STRING
            {
             before(grammarAccess.getCodetemplateAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Codetemplate__NameAssignment_04116); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2088:1: rule__Codetemplate__ContextAssignment_2_0 : ( ( ruleValidID ) ) ;
    public final void rule__Codetemplate__ContextAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2092:1: ( ( ( ruleValidID ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2093:1: ( ( ruleValidID ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2093:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2094:1: ( ruleValidID )
            {
             before(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_2_0_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2095:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2096:1: ruleValidID
            {
             before(grammarAccess.getCodetemplateAccess().getContextAbstractRuleValidIDParserRuleCall_2_0_0_1()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__Codetemplate__ContextAssignment_2_04151);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2107:1: rule__Codetemplate__KeywordContextAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__Codetemplate__KeywordContextAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2111:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2112:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2112:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2113:1: RULE_STRING
            {
             before(grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Codetemplate__KeywordContextAssignment_2_14186); 
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2122:1: rule__Codetemplate__BodyAssignment_3 : ( ruleTemplateBodyWithQuotes ) ;
    public final void rule__Codetemplate__BodyAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2126:1: ( ( ruleTemplateBodyWithQuotes ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2127:1: ( ruleTemplateBodyWithQuotes )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2127:1: ( ruleTemplateBodyWithQuotes )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2128:1: ruleTemplateBodyWithQuotes
            {
             before(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleTemplateBodyWithQuotes_in_rule__Codetemplate__BodyAssignment_34217);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2137:1: rule__TemplateBody__PartsAssignment_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2141:1: ( ( ruleLiteral ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2142:1: ( ruleLiteral )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2142:1: ( ruleLiteral )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2143:1: ruleLiteral
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__TemplateBody__PartsAssignment_14248);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2152:1: rule__TemplateBody__PartsAssignment_2_0 : ( ruleVariableOrDollar ) ;
    public final void rule__TemplateBody__PartsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2156:1: ( ( ruleVariableOrDollar ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2157:1: ( ruleVariableOrDollar )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2157:1: ( ruleVariableOrDollar )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2158:1: ruleVariableOrDollar
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsVariableOrDollarParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleVariableOrDollar_in_rule__TemplateBody__PartsAssignment_2_04279);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2167:1: rule__TemplateBody__PartsAssignment_2_1 : ( ruleLiteral ) ;
    public final void rule__TemplateBody__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2171:1: ( ( ruleLiteral ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2172:1: ( ruleLiteral )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2172:1: ( ruleLiteral )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2173:1: ruleLiteral
            {
             before(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__TemplateBody__PartsAssignment_2_14310);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2182:1: rule__Variable__NameAssignment_2_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2186:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2187:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2187:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2188:1: ruleValidID
            {
             before(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__Variable__NameAssignment_2_04341);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2197:1: rule__Variable__NameAssignment_2_1_0_0 : ( ruleValidID ) ;
    public final void rule__Variable__NameAssignment_2_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2201:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2202:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2202:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2203:1: ruleValidID
            {
             before(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_1_0_0_0()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__Variable__NameAssignment_2_1_0_04372);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2212:1: rule__Variable__TypeAssignment_2_1_3 : ( ruleValidID ) ;
    public final void rule__Variable__TypeAssignment_2_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2216:1: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2217:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2217:1: ( ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2218:1: ruleValidID
            {
             before(grammarAccess.getVariableAccess().getTypeValidIDParserRuleCall_2_1_3_0()); 
            pushFollow(FOLLOW_ruleValidID_in_rule__Variable__TypeAssignment_2_1_34403);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2227:1: rule__Variable__ParametersAssignment_2_1_4_3 : ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2231:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2232:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2232:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_3_0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2233:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2234:1: ( rule__Variable__ParametersAlternatives_2_1_4_3_0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2234:2: rule__Variable__ParametersAlternatives_2_1_4_3_0
            {
            pushFollow(FOLLOW_rule__Variable__ParametersAlternatives_2_1_4_3_0_in_rule__Variable__ParametersAssignment_2_1_4_34434);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2243:1: rule__Variable__ParametersAssignment_2_1_4_4_3 : ( ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 ) ) ;
    public final void rule__Variable__ParametersAssignment_2_1_4_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2247:1: ( ( ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2248:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2248:1: ( ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2249:1: ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 )
            {
             before(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_4_3_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2250:1: ( rule__Variable__ParametersAlternatives_2_1_4_4_3_0 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2250:2: rule__Variable__ParametersAlternatives_2_1_4_4_3_0
            {
            pushFollow(FOLLOW_rule__Variable__ParametersAlternatives_2_1_4_4_3_0_in_rule__Variable__ParametersAssignment_2_1_4_4_34467);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2259:1: rule__Literal__ValueAssignment : ( ruleLiteralValue ) ;
    public final void rule__Literal__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2263:1: ( ( ruleLiteralValue ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2264:1: ( ruleLiteralValue )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2264:1: ( ruleLiteralValue )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2265:1: ruleLiteralValue
            {
             before(grammarAccess.getLiteralAccess().getValueLiteralValueParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleLiteralValue_in_rule__Literal__ValueAssignment4500);
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
    // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2274:1: rule__Dollar__EscapedAssignment_1_0 : ( ( KEYWORD_8 ) ) ;
    public final void rule__Dollar__EscapedAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2278:1: ( ( ( KEYWORD_8 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2279:1: ( ( KEYWORD_8 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2279:1: ( ( KEYWORD_8 ) )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2280:1: ( KEYWORD_8 )
            {
             before(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2281:1: ( KEYWORD_8 )
            // ../org.eclipse.xtext.ui.codetemplates.ui/src-gen/org/eclipse/xtext/ui/codetemplates/ui/contentassist/antlr/internal/InternalSingleCodetemplateParser.g:2282:1: KEYWORD_8
            {
             before(grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0()); 
            match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_rule__Dollar__EscapedAssignment_1_04536); 
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
    protected DFA21 dfa21 = new DFA21(this);
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
    static final String DFA21_eotS =
        "\4\uffff";
    static final String DFA21_eofS =
        "\4\uffff";
    static final String DFA21_minS =
        "\2\13\2\uffff";
    static final String DFA21_maxS =
        "\2\22\2\uffff";
    static final String DFA21_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA21_specialS =
        "\4\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\2\1\3\5\uffff\1\1",
            "\1\2\1\3\5\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "()* loopback of 1643:1: ( rule__Variable__Group_2_1_4_4__0 )*";
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
    public static final BitSet FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralValue267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralValue__Alternatives_in_ruleLiteralValue303 = new BitSet(new long[]{0x00000000000D0002L});
    public static final BitSet FOLLOW_rule__LiteralValue__Alternatives_in_ruleLiteralValue315 = new BitSet(new long[]{0x00000000000D0002L});
    public static final BitSet FOLLOW_ruleTemplateBody_in_entryRuleTemplateBody350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBody357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__0_in_ruleTemplateBody391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableOrDollar_in_entryRuleVariableOrDollar425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableOrDollar432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableOrDollar__Alternatives_in_ruleVariableOrDollar466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable498 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__0_in_ruleVariable539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValidID__Alternatives_in_ruleValidID612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral717 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__ValueAssignment_in_ruleLiteral758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDollar_in_entryRuleDollar790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDollar797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dollar__Group__0_in_ruleDollar831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__ContextAssignment_2_0_in_rule__Codetemplate__Alternatives_2867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__KeywordContextAssignment_2_1_in_rule__Codetemplate__Alternatives_2885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__LiteralValue__Alternatives918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_rule__LiteralValue__Alternatives935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LiteralValue__Alternatives952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__VariableOrDollar__Alternatives985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDollar_in_rule__VariableOrDollar__Alternatives1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_2_0_in_rule__Variable__Alternatives_21034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__0_in_rule__Variable__Alternatives_21052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Variable__ParametersAlternatives_2_1_4_3_01085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Variable__ParametersAlternatives_2_1_4_3_01102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Variable__ParametersAlternatives_2_1_4_4_3_01134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Variable__ParametersAlternatives_2_1_4_4_3_01151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ValidID__Alternatives1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_rule__ValidID__Alternatives1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_12_in_rule__ValidID__Alternatives1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dollar__EscapedAssignment_1_0_in_rule__Dollar__Alternatives_11255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_rule__Dollar__Alternatives_11274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__0__Impl_in_rule__Codetemplates__Group__01306 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__1_in_rule__Codetemplates__Group__01309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_12_in_rule__Codetemplates__Group__0__Impl1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__1__Impl_in_rule__Codetemplates__Group__11368 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__2_in_rule__Codetemplates__Group__11371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_rule__Codetemplates__Group__1__Impl1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__2__Impl_in_rule__Codetemplates__Group__21430 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__3_in_rule__Codetemplates__Group__21433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__LanguageAssignment_2_in_rule__Codetemplates__Group__2__Impl1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__Group__3__Impl_in_rule__Codetemplates__Group__31490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplates__TemplatesAssignment_3_in_rule__Codetemplates__Group__3__Impl1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__0__Impl_in_rule__Codetemplate__Group__01555 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__1_in_rule__Codetemplate__Group__01558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__NameAssignment_0_in_rule__Codetemplate__Group__0__Impl1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__1__Impl_in_rule__Codetemplate__Group__11615 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__2_in_rule__Codetemplate__Group__11618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_rule__Codetemplate__Group__1__Impl1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__2__Impl_in_rule__Codetemplate__Group__21677 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__3_in_rule__Codetemplate__Group__21680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Alternatives_2_in_rule__Codetemplate__Group__2__Impl1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__Group__3__Impl_in_rule__Codetemplate__Group__31737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Codetemplate__BodyAssignment_3_in_rule__Codetemplate__Group__3__Impl1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBodyWithQuotes__Group__0__Impl_in_rule__TemplateBodyWithQuotes__Group__01802 = new BitSet(new long[]{0x00000000000D02C0L});
    public static final BitSet FOLLOW_rule__TemplateBodyWithQuotes__Group__1_in_rule__TemplateBodyWithQuotes__Group__01805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_10_in_rule__TemplateBodyWithQuotes__Group__0__Impl1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBodyWithQuotes__Group__1__Impl_in_rule__TemplateBodyWithQuotes__Group__11864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBody_in_rule__TemplateBodyWithQuotes__Group__1__Impl1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__0__Impl_in_rule__TemplateBody__Group__01924 = new BitSet(new long[]{0x00000000000D02C0L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__1_in_rule__TemplateBody__Group__01927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__1__Impl_in_rule__TemplateBody__Group__11985 = new BitSet(new long[]{0x00000000000D02C0L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__2_in_rule__TemplateBody__Group__11988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__PartsAssignment_1_in_rule__TemplateBody__Group__1__Impl2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group__2__Impl_in_rule__TemplateBody__Group__22046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group_2__0_in_rule__TemplateBody__Group__2__Impl2073 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group_2__0__Impl_in_rule__TemplateBody__Group_2__02110 = new BitSet(new long[]{0x00000000000D0000L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group_2__1_in_rule__TemplateBody__Group_2__02113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__PartsAssignment_2_0_in_rule__TemplateBody__Group_2__0__Impl2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__Group_2__1__Impl_in_rule__TemplateBody__Group_2__12170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TemplateBody__PartsAssignment_2_1_in_rule__TemplateBody__Group_2__1__Impl2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__02232 = new BitSet(new long[]{0x0000000000054030L});
    public static final BitSet FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__02235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_9_in_rule__Variable__Group__0__Impl2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__12294 = new BitSet(new long[]{0x0000000000054030L});
    public static final BitSet FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__12297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group__1__Impl2325 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__22356 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_rule__Variable__Group__3_in_rule__Variable__Group__22359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Alternatives_2_in_rule__Variable__Group__2__Impl2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__3__Impl_in_rule__Variable__Group__32416 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_rule__Variable__Group__4_in_rule__Variable__Group__32419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group__3__Impl2447 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Variable__Group__4__Impl_in_rule__Variable__Group__42478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_7_in_rule__Variable__Group__4__Impl2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__0__Impl_in_rule__Variable__Group_2_1__02547 = new BitSet(new long[]{0x0000000000054030L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__1_in_rule__Variable__Group_2_1__02550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_0__0_in_rule__Variable__Group_2_1__0__Impl2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__1__Impl_in_rule__Variable__Group_2_1__12608 = new BitSet(new long[]{0x0000000000050030L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__2_in_rule__Variable__Group_2_1__12611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_rule__Variable__Group_2_1__1__Impl2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__2__Impl_in_rule__Variable__Group_2_1__22670 = new BitSet(new long[]{0x0000000000050030L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__3_in_rule__Variable__Group_2_1__22673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1__2__Impl2701 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__3__Impl_in_rule__Variable__Group_2_1__32732 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__4_in_rule__Variable__Group_2_1__32735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__TypeAssignment_2_1_3_in_rule__Variable__Group_2_1__3__Impl2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1__4__Impl_in_rule__Variable__Group_2_1__42792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__0_in_rule__Variable__Group_2_1__4__Impl2819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_0__0__Impl_in_rule__Variable__Group_2_1_0__02860 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_0__1_in_rule__Variable__Group_2_1_0__02863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_2_1_0_0_in_rule__Variable__Group_2_1_0__0__Impl2890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_0__1__Impl_in_rule__Variable__Group_2_1_0__12920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_0__1__Impl2948 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__0__Impl_in_rule__Variable__Group_2_1_4__02983 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__1_in_rule__Variable__Group_2_1_4__02986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__0__Impl3014 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__1__Impl_in_rule__Variable__Group_2_1_4__13045 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__2_in_rule__Variable__Group_2_1_4__13048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_rule__Variable__Group_2_1_4__1__Impl3076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__2__Impl_in_rule__Variable__Group_2_1_4__23107 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__3_in_rule__Variable__Group_2_1_4__23110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__2__Impl3138 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__3__Impl_in_rule__Variable__Group_2_1_4__33169 = new BitSet(new long[]{0x0000000000041800L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__4_in_rule__Variable__Group_2_1_4__33172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ParametersAssignment_2_1_4_3_in_rule__Variable__Group_2_1_4__3__Impl3199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__4__Impl_in_rule__Variable__Group_2_1_4__43229 = new BitSet(new long[]{0x0000000000041800L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__5_in_rule__Variable__Group_2_1_4__43232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__0_in_rule__Variable__Group_2_1_4__4__Impl3259 = new BitSet(new long[]{0x0000000000041002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__5__Impl_in_rule__Variable__Group_2_1_4__53290 = new BitSet(new long[]{0x0000000000041800L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__6_in_rule__Variable__Group_2_1_4__53293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4__5__Impl3321 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4__6__Impl_in_rule__Variable__Group_2_1_4__63352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_3_in_rule__Variable__Group_2_1_4__6__Impl3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__0__Impl_in_rule__Variable__Group_2_1_4_4__03425 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__1_in_rule__Variable__Group_2_1_4_4__03428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4_4__0__Impl3456 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__1__Impl_in_rule__Variable__Group_2_1_4_4__13487 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__2_in_rule__Variable__Group_2_1_4_4__13490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_rule__Variable__Group_2_1_4_4__1__Impl3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__2__Impl_in_rule__Variable__Group_2_1_4_4__23549 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__3_in_rule__Variable__Group_2_1_4_4__23552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_rule__Variable__Group_2_1_4_4__2__Impl3580 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Variable__Group_2_1_4_4__3__Impl_in_rule__Variable__Group_2_1_4_4__33611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ParametersAssignment_2_1_4_4_3_in_rule__Variable__Group_2_1_4_4__3__Impl3638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__03676 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__03679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__FQN__Group__0__Impl3706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__13735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl3762 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__03797 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__03800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_rule__FQN__Group_1__0__Impl3828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__13859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__FQN__Group_1__1__Impl3886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dollar__Group__0__Impl_in_rule__Dollar__Group__03919 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_rule__Dollar__Group__1_in_rule__Dollar__Group__03922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dollar__Group__1__Impl_in_rule__Dollar__Group__13980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dollar__Alternatives_1_in_rule__Dollar__Group__1__Impl4007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Codetemplates__LanguageAssignment_24050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodetemplate_in_rule__Codetemplates__TemplatesAssignment_34085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Codetemplate__NameAssignment_04116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__Codetemplate__ContextAssignment_2_04151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Codetemplate__KeywordContextAssignment_2_14186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBodyWithQuotes_in_rule__Codetemplate__BodyAssignment_34217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__TemplateBody__PartsAssignment_14248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableOrDollar_in_rule__TemplateBody__PartsAssignment_2_04279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__TemplateBody__PartsAssignment_2_14310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__Variable__NameAssignment_2_04341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__Variable__NameAssignment_2_1_0_04372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__Variable__TypeAssignment_2_1_34403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ParametersAlternatives_2_1_4_3_0_in_rule__Variable__ParametersAssignment_2_1_4_34434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ParametersAlternatives_2_1_4_4_3_0_in_rule__Variable__ParametersAssignment_2_1_4_4_34467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_rule__Literal__ValueAssignment4500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_rule__Dollar__EscapedAssignment_1_04536 = new BitSet(new long[]{0x0000000000000002L});

}
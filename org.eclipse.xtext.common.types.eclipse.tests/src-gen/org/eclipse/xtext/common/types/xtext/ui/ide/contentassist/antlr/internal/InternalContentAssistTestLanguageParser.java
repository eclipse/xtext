package org.eclipse.xtext.common.types.xtext.ui.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.common.types.xtext.ui.services.ContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'default'", "'custom'", "'subtype'", "'generate'", "'import'", "'.*'", "'$'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalContentAssistTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistTestLanguage.g"; }


    	private ContentAssistTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(ContentAssistTestLanguageGrammarAccess grammarAccess) {
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
    // InternalContentAssistTestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:54:1: ( ruleModel EOF )
            // InternalContentAssistTestLanguage.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalContentAssistTestLanguage.g:62:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:66:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:67:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:67:2: ( ( rule__Model__Group__0 ) )
            // InternalContentAssistTestLanguage.g:68:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:69:3: ( rule__Model__Group__0 )
            // InternalContentAssistTestLanguage.g:69:4: rule__Model__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleReferenceHolder"
    // InternalContentAssistTestLanguage.g:78:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:79:1: ( ruleReferenceHolder EOF )
            // InternalContentAssistTestLanguage.g:80:1: ruleReferenceHolder EOF
            {
             before(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FOLLOW_1);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getReferenceHolderRule()); 
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
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // InternalContentAssistTestLanguage.g:87:1: ruleReferenceHolder : ( ( rule__ReferenceHolder__Alternatives ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:91:2: ( ( ( rule__ReferenceHolder__Alternatives ) ) )
            // InternalContentAssistTestLanguage.g:92:2: ( ( rule__ReferenceHolder__Alternatives ) )
            {
            // InternalContentAssistTestLanguage.g:92:2: ( ( rule__ReferenceHolder__Alternatives ) )
            // InternalContentAssistTestLanguage.g:93:3: ( rule__ReferenceHolder__Alternatives )
            {
             before(grammarAccess.getReferenceHolderAccess().getAlternatives()); 
            // InternalContentAssistTestLanguage.g:94:3: ( rule__ReferenceHolder__Alternatives )
            // InternalContentAssistTestLanguage.g:94:4: rule__ReferenceHolder__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReferenceHolder"


    // $ANTLR start "entryRuleGenerateDirective"
    // InternalContentAssistTestLanguage.g:103:1: entryRuleGenerateDirective : ruleGenerateDirective EOF ;
    public final void entryRuleGenerateDirective() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:104:1: ( ruleGenerateDirective EOF )
            // InternalContentAssistTestLanguage.g:105:1: ruleGenerateDirective EOF
            {
             before(grammarAccess.getGenerateDirectiveRule()); 
            pushFollow(FOLLOW_1);
            ruleGenerateDirective();

            state._fsp--;

             after(grammarAccess.getGenerateDirectiveRule()); 
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
    // $ANTLR end "entryRuleGenerateDirective"


    // $ANTLR start "ruleGenerateDirective"
    // InternalContentAssistTestLanguage.g:112:1: ruleGenerateDirective : ( ( rule__GenerateDirective__Group__0 ) ) ;
    public final void ruleGenerateDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:116:2: ( ( ( rule__GenerateDirective__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:117:2: ( ( rule__GenerateDirective__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:117:2: ( ( rule__GenerateDirective__Group__0 ) )
            // InternalContentAssistTestLanguage.g:118:3: ( rule__GenerateDirective__Group__0 )
            {
             before(grammarAccess.getGenerateDirectiveAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:119:3: ( rule__GenerateDirective__Group__0 )
            // InternalContentAssistTestLanguage.g:119:4: rule__GenerateDirective__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GenerateDirective__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGenerateDirectiveAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGenerateDirective"


    // $ANTLR start "entryRuleImport"
    // InternalContentAssistTestLanguage.g:128:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:129:1: ( ruleImport EOF )
            // InternalContentAssistTestLanguage.g:130:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalContentAssistTestLanguage.g:137:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:141:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:142:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:142:2: ( ( rule__Import__Group__0 ) )
            // InternalContentAssistTestLanguage.g:143:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:144:3: ( rule__Import__Group__0 )
            // InternalContentAssistTestLanguage.g:144:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // InternalContentAssistTestLanguage.g:153:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:154:1: ( ruleImportedFQN EOF )
            // InternalContentAssistTestLanguage.g:155:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
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
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // InternalContentAssistTestLanguage.g:162:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:166:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:167:2: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:167:2: ( ( rule__ImportedFQN__Group__0 ) )
            // InternalContentAssistTestLanguage.g:168:3: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:169:3: ( rule__ImportedFQN__Group__0 )
            // InternalContentAssistTestLanguage.g:169:4: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportedFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleFQN"
    // InternalContentAssistTestLanguage.g:178:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:179:1: ( ruleFQN EOF )
            // InternalContentAssistTestLanguage.g:180:1: ruleFQN EOF
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
        }
        return ;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalContentAssistTestLanguage.g:187:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:191:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:192:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:192:2: ( ( rule__FQN__Group__0 ) )
            // InternalContentAssistTestLanguage.g:193:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:194:3: ( rule__FQN__Group__0 )
            // InternalContentAssistTestLanguage.g:194:4: rule__FQN__Group__0
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

        }
        return ;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleQN"
    // InternalContentAssistTestLanguage.g:203:1: entryRuleQN : ruleQN EOF ;
    public final void entryRuleQN() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:204:1: ( ruleQN EOF )
            // InternalContentAssistTestLanguage.g:205:1: ruleQN EOF
            {
             before(grammarAccess.getQNRule()); 
            pushFollow(FOLLOW_1);
            ruleQN();

            state._fsp--;

             after(grammarAccess.getQNRule()); 
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
    // $ANTLR end "entryRuleQN"


    // $ANTLR start "ruleQN"
    // InternalContentAssistTestLanguage.g:212:1: ruleQN : ( ( rule__QN__Group__0 ) ) ;
    public final void ruleQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:216:2: ( ( ( rule__QN__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:217:2: ( ( rule__QN__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:217:2: ( ( rule__QN__Group__0 ) )
            // InternalContentAssistTestLanguage.g:218:3: ( rule__QN__Group__0 )
            {
             before(grammarAccess.getQNAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:219:3: ( rule__QN__Group__0 )
            // InternalContentAssistTestLanguage.g:219:4: rule__QN__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQN"


    // $ANTLR start "rule__ReferenceHolder__Alternatives"
    // InternalContentAssistTestLanguage.g:227:1: rule__ReferenceHolder__Alternatives : ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) );
    public final void rule__ReferenceHolder__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:231:1: ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:232:2: ( ( rule__ReferenceHolder__Group_0__0 ) )
                    {
                    // InternalContentAssistTestLanguage.g:232:2: ( ( rule__ReferenceHolder__Group_0__0 ) )
                    // InternalContentAssistTestLanguage.g:233:3: ( rule__ReferenceHolder__Group_0__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_0()); 
                    // InternalContentAssistTestLanguage.g:234:3: ( rule__ReferenceHolder__Group_0__0 )
                    // InternalContentAssistTestLanguage.g:234:4: rule__ReferenceHolder__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ReferenceHolder__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalContentAssistTestLanguage.g:238:2: ( ( rule__ReferenceHolder__Group_1__0 ) )
                    {
                    // InternalContentAssistTestLanguage.g:238:2: ( ( rule__ReferenceHolder__Group_1__0 ) )
                    // InternalContentAssistTestLanguage.g:239:3: ( rule__ReferenceHolder__Group_1__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_1()); 
                    // InternalContentAssistTestLanguage.g:240:3: ( rule__ReferenceHolder__Group_1__0 )
                    // InternalContentAssistTestLanguage.g:240:4: rule__ReferenceHolder__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ReferenceHolder__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalContentAssistTestLanguage.g:244:2: ( ( rule__ReferenceHolder__Group_2__0 ) )
                    {
                    // InternalContentAssistTestLanguage.g:244:2: ( ( rule__ReferenceHolder__Group_2__0 ) )
                    // InternalContentAssistTestLanguage.g:245:3: ( rule__ReferenceHolder__Group_2__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_2()); 
                    // InternalContentAssistTestLanguage.g:246:3: ( rule__ReferenceHolder__Group_2__0 )
                    // InternalContentAssistTestLanguage.g:246:4: rule__ReferenceHolder__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ReferenceHolder__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_2()); 

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
    // $ANTLR end "rule__ReferenceHolder__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // InternalContentAssistTestLanguage.g:254:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:258:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalContentAssistTestLanguage.g:259:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:266:1: rule__Model__Group__0__Impl : ( ( rule__Model__ImportsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:270:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) )
            // InternalContentAssistTestLanguage.g:271:1: ( ( rule__Model__ImportsAssignment_0 )* )
            {
            // InternalContentAssistTestLanguage.g:271:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // InternalContentAssistTestLanguage.g:272:2: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // InternalContentAssistTestLanguage.g:273:2: ( rule__Model__ImportsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:273:3: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Model__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalContentAssistTestLanguage.g:281:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:285:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalContentAssistTestLanguage.g:286:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:293:1: rule__Model__Group__1__Impl : ( ( rule__Model__GenerateDirectiveAssignment_1 )? ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:297:1: ( ( ( rule__Model__GenerateDirectiveAssignment_1 )? ) )
            // InternalContentAssistTestLanguage.g:298:1: ( ( rule__Model__GenerateDirectiveAssignment_1 )? )
            {
            // InternalContentAssistTestLanguage.g:298:1: ( ( rule__Model__GenerateDirectiveAssignment_1 )? )
            // InternalContentAssistTestLanguage.g:299:2: ( rule__Model__GenerateDirectiveAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getGenerateDirectiveAssignment_1()); 
            // InternalContentAssistTestLanguage.g:300:2: ( rule__Model__GenerateDirectiveAssignment_1 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:300:3: rule__Model__GenerateDirectiveAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__GenerateDirectiveAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGenerateDirectiveAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // InternalContentAssistTestLanguage.g:308:1: rule__Model__Group__2 : rule__Model__Group__2__Impl ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:312:1: ( rule__Model__Group__2__Impl )
            // InternalContentAssistTestLanguage.g:313:2: rule__Model__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // InternalContentAssistTestLanguage.g:319:1: rule__Model__Group__2__Impl : ( ( rule__Model__ReferenceHolderAssignment_2 )? ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:323:1: ( ( ( rule__Model__ReferenceHolderAssignment_2 )? ) )
            // InternalContentAssistTestLanguage.g:324:1: ( ( rule__Model__ReferenceHolderAssignment_2 )? )
            {
            // InternalContentAssistTestLanguage.g:324:1: ( ( rule__Model__ReferenceHolderAssignment_2 )? )
            // InternalContentAssistTestLanguage.g:325:2: ( rule__Model__ReferenceHolderAssignment_2 )?
            {
             before(grammarAccess.getModelAccess().getReferenceHolderAssignment_2()); 
            // InternalContentAssistTestLanguage.g:326:2: ( rule__Model__ReferenceHolderAssignment_2 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=11 && LA4_0<=13)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:326:3: rule__Model__ReferenceHolderAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__ReferenceHolderAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getReferenceHolderAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_0__0"
    // InternalContentAssistTestLanguage.g:335:1: rule__ReferenceHolder__Group_0__0 : rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1 ;
    public final void rule__ReferenceHolder__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:339:1: ( rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1 )
            // InternalContentAssistTestLanguage.g:340:2: rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1
            {
            pushFollow(FOLLOW_5);
            rule__ReferenceHolder__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_0__0"


    // $ANTLR start "rule__ReferenceHolder__Group_0__0__Impl"
    // InternalContentAssistTestLanguage.g:347:1: rule__ReferenceHolder__Group_0__0__Impl : ( 'default' ) ;
    public final void rule__ReferenceHolder__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:351:1: ( ( 'default' ) )
            // InternalContentAssistTestLanguage.g:352:1: ( 'default' )
            {
            // InternalContentAssistTestLanguage.g:352:1: ( 'default' )
            // InternalContentAssistTestLanguage.g:353:2: 'default'
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultKeyword_0_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getReferenceHolderAccess().getDefaultKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_0__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_0__1"
    // InternalContentAssistTestLanguage.g:362:1: rule__ReferenceHolder__Group_0__1 : rule__ReferenceHolder__Group_0__1__Impl ;
    public final void rule__ReferenceHolder__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:366:1: ( rule__ReferenceHolder__Group_0__1__Impl )
            // InternalContentAssistTestLanguage.g:367:2: rule__ReferenceHolder__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_0__1"


    // $ANTLR start "rule__ReferenceHolder__Group_0__1__Impl"
    // InternalContentAssistTestLanguage.g:373:1: rule__ReferenceHolder__Group_0__1__Impl : ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) ) ;
    public final void rule__ReferenceHolder__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:377:1: ( ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) ) )
            // InternalContentAssistTestLanguage.g:378:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) )
            {
            // InternalContentAssistTestLanguage.g:378:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) )
            // InternalContentAssistTestLanguage.g:379:2: ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_0_1()); 
            // InternalContentAssistTestLanguage.g:380:2: ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 )
            // InternalContentAssistTestLanguage.g:380:3: rule__ReferenceHolder__DefaultReferenceAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__DefaultReferenceAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_0__1__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_1__0"
    // InternalContentAssistTestLanguage.g:389:1: rule__ReferenceHolder__Group_1__0 : rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1 ;
    public final void rule__ReferenceHolder__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:393:1: ( rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1 )
            // InternalContentAssistTestLanguage.g:394:2: rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__ReferenceHolder__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_1__0"


    // $ANTLR start "rule__ReferenceHolder__Group_1__0__Impl"
    // InternalContentAssistTestLanguage.g:401:1: rule__ReferenceHolder__Group_1__0__Impl : ( 'custom' ) ;
    public final void rule__ReferenceHolder__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:405:1: ( ( 'custom' ) )
            // InternalContentAssistTestLanguage.g:406:1: ( 'custom' )
            {
            // InternalContentAssistTestLanguage.g:406:1: ( 'custom' )
            // InternalContentAssistTestLanguage.g:407:2: 'custom'
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomKeyword_1_0()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getReferenceHolderAccess().getCustomKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_1__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_1__1"
    // InternalContentAssistTestLanguage.g:416:1: rule__ReferenceHolder__Group_1__1 : rule__ReferenceHolder__Group_1__1__Impl ;
    public final void rule__ReferenceHolder__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:420:1: ( rule__ReferenceHolder__Group_1__1__Impl )
            // InternalContentAssistTestLanguage.g:421:2: rule__ReferenceHolder__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_1__1"


    // $ANTLR start "rule__ReferenceHolder__Group_1__1__Impl"
    // InternalContentAssistTestLanguage.g:427:1: rule__ReferenceHolder__Group_1__1__Impl : ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) ) ;
    public final void rule__ReferenceHolder__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:431:1: ( ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) ) )
            // InternalContentAssistTestLanguage.g:432:1: ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) )
            {
            // InternalContentAssistTestLanguage.g:432:1: ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) )
            // InternalContentAssistTestLanguage.g:433:2: ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceAssignment_1_1()); 
            // InternalContentAssistTestLanguage.g:434:2: ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 )
            // InternalContentAssistTestLanguage.g:434:3: rule__ReferenceHolder__CustomizedReferenceAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__CustomizedReferenceAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_1__1__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_2__0"
    // InternalContentAssistTestLanguage.g:443:1: rule__ReferenceHolder__Group_2__0 : rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1 ;
    public final void rule__ReferenceHolder__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:447:1: ( rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1 )
            // InternalContentAssistTestLanguage.g:448:2: rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__ReferenceHolder__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_2__0"


    // $ANTLR start "rule__ReferenceHolder__Group_2__0__Impl"
    // InternalContentAssistTestLanguage.g:455:1: rule__ReferenceHolder__Group_2__0__Impl : ( 'subtype' ) ;
    public final void rule__ReferenceHolder__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:459:1: ( ( 'subtype' ) )
            // InternalContentAssistTestLanguage.g:460:1: ( 'subtype' )
            {
            // InternalContentAssistTestLanguage.g:460:1: ( 'subtype' )
            // InternalContentAssistTestLanguage.g:461:2: 'subtype'
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeKeyword_2_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getReferenceHolderAccess().getSubtypeKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_2__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group_2__1"
    // InternalContentAssistTestLanguage.g:470:1: rule__ReferenceHolder__Group_2__1 : rule__ReferenceHolder__Group_2__1__Impl ;
    public final void rule__ReferenceHolder__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:474:1: ( rule__ReferenceHolder__Group_2__1__Impl )
            // InternalContentAssistTestLanguage.g:475:2: rule__ReferenceHolder__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_2__1"


    // $ANTLR start "rule__ReferenceHolder__Group_2__1__Impl"
    // InternalContentAssistTestLanguage.g:481:1: rule__ReferenceHolder__Group_2__1__Impl : ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) ) ;
    public final void rule__ReferenceHolder__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:485:1: ( ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) ) )
            // InternalContentAssistTestLanguage.g:486:1: ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) )
            {
            // InternalContentAssistTestLanguage.g:486:1: ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) )
            // InternalContentAssistTestLanguage.g:487:2: ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceAssignment_2_1()); 
            // InternalContentAssistTestLanguage.g:488:2: ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 )
            // InternalContentAssistTestLanguage.g:488:3: rule__ReferenceHolder__SubtypeReferenceAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceHolder__SubtypeReferenceAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__Group_2__1__Impl"


    // $ANTLR start "rule__GenerateDirective__Group__0"
    // InternalContentAssistTestLanguage.g:497:1: rule__GenerateDirective__Group__0 : rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1 ;
    public final void rule__GenerateDirective__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:501:1: ( rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1 )
            // InternalContentAssistTestLanguage.g:502:2: rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__GenerateDirective__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GenerateDirective__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerateDirective__Group__0"


    // $ANTLR start "rule__GenerateDirective__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:509:1: rule__GenerateDirective__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GenerateDirective__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:513:1: ( ( 'generate' ) )
            // InternalContentAssistTestLanguage.g:514:1: ( 'generate' )
            {
            // InternalContentAssistTestLanguage.g:514:1: ( 'generate' )
            // InternalContentAssistTestLanguage.g:515:2: 'generate'
            {
             before(grammarAccess.getGenerateDirectiveAccess().getGenerateKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getGenerateDirectiveAccess().getGenerateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerateDirective__Group__0__Impl"


    // $ANTLR start "rule__GenerateDirective__Group__1"
    // InternalContentAssistTestLanguage.g:524:1: rule__GenerateDirective__Group__1 : rule__GenerateDirective__Group__1__Impl ;
    public final void rule__GenerateDirective__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:528:1: ( rule__GenerateDirective__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:529:2: rule__GenerateDirective__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GenerateDirective__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerateDirective__Group__1"


    // $ANTLR start "rule__GenerateDirective__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:535:1: rule__GenerateDirective__Group__1__Impl : ( ( rule__GenerateDirective__TypeNameAssignment_1 ) ) ;
    public final void rule__GenerateDirective__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:539:1: ( ( ( rule__GenerateDirective__TypeNameAssignment_1 ) ) )
            // InternalContentAssistTestLanguage.g:540:1: ( ( rule__GenerateDirective__TypeNameAssignment_1 ) )
            {
            // InternalContentAssistTestLanguage.g:540:1: ( ( rule__GenerateDirective__TypeNameAssignment_1 ) )
            // InternalContentAssistTestLanguage.g:541:2: ( rule__GenerateDirective__TypeNameAssignment_1 )
            {
             before(grammarAccess.getGenerateDirectiveAccess().getTypeNameAssignment_1()); 
            // InternalContentAssistTestLanguage.g:542:2: ( rule__GenerateDirective__TypeNameAssignment_1 )
            // InternalContentAssistTestLanguage.g:542:3: rule__GenerateDirective__TypeNameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GenerateDirective__TypeNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGenerateDirectiveAccess().getTypeNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerateDirective__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalContentAssistTestLanguage.g:551:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:555:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalContentAssistTestLanguage.g:556:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:563:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:567:1: ( ( 'import' ) )
            // InternalContentAssistTestLanguage.g:568:1: ( 'import' )
            {
            // InternalContentAssistTestLanguage.g:568:1: ( 'import' )
            // InternalContentAssistTestLanguage.g:569:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalContentAssistTestLanguage.g:578:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:582:1: ( rule__Import__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:583:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:589:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:593:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalContentAssistTestLanguage.g:594:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalContentAssistTestLanguage.g:594:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalContentAssistTestLanguage.g:595:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalContentAssistTestLanguage.g:596:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalContentAssistTestLanguage.g:596:3: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__0"
    // InternalContentAssistTestLanguage.g:605:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:609:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // InternalContentAssistTestLanguage.g:610:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__0"


    // $ANTLR start "rule__ImportedFQN__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:617:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:621:1: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:622:1: ( ruleFQN )
            {
            // InternalContentAssistTestLanguage.g:622:1: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:623:2: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__0__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__1"
    // InternalContentAssistTestLanguage.g:632:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:636:1: ( rule__ImportedFQN__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:637:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__1"


    // $ANTLR start "rule__ImportedFQN__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:643:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:647:1: ( ( ( '.*' )? ) )
            // InternalContentAssistTestLanguage.g:648:1: ( ( '.*' )? )
            {
            // InternalContentAssistTestLanguage.g:648:1: ( ( '.*' )? )
            // InternalContentAssistTestLanguage.g:649:2: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // InternalContentAssistTestLanguage.g:650:2: ( '.*' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:650:3: '.*'
                    {
                    match(input,16,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalContentAssistTestLanguage.g:659:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:663:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalContentAssistTestLanguage.g:664:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalContentAssistTestLanguage.g:671:1: rule__FQN__Group__0__Impl : ( ruleQN ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:675:1: ( ( ruleQN ) )
            // InternalContentAssistTestLanguage.g:676:1: ( ruleQN )
            {
            // InternalContentAssistTestLanguage.g:676:1: ( ruleQN )
            // InternalContentAssistTestLanguage.g:677:2: ruleQN
            {
             before(grammarAccess.getFQNAccess().getQNParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleQN();

            state._fsp--;

             after(grammarAccess.getFQNAccess().getQNParserRuleCall_0()); 

            }


            }

        }
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
    // InternalContentAssistTestLanguage.g:686:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:690:1: ( rule__FQN__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:691:2: rule__FQN__Group__1__Impl
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
    // InternalContentAssistTestLanguage.g:697:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:701:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalContentAssistTestLanguage.g:702:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalContentAssistTestLanguage.g:702:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalContentAssistTestLanguage.g:703:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalContentAssistTestLanguage.g:704:2: ( rule__FQN__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:704:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // InternalContentAssistTestLanguage.g:713:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:717:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalContentAssistTestLanguage.g:718:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalContentAssistTestLanguage.g:725:1: rule__FQN__Group_1__0__Impl : ( '$' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:729:1: ( ( '$' ) )
            // InternalContentAssistTestLanguage.g:730:1: ( '$' )
            {
            // InternalContentAssistTestLanguage.g:730:1: ( '$' )
            // InternalContentAssistTestLanguage.g:731:2: '$'
            {
             before(grammarAccess.getFQNAccess().getDollarSignKeyword_1_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getDollarSignKeyword_1_0()); 

            }


            }

        }
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
    // InternalContentAssistTestLanguage.g:740:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:744:1: ( rule__FQN__Group_1__1__Impl )
            // InternalContentAssistTestLanguage.g:745:2: rule__FQN__Group_1__1__Impl
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
    // InternalContentAssistTestLanguage.g:751:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:755:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:756:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:756:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:757:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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


    // $ANTLR start "rule__QN__Group__0"
    // InternalContentAssistTestLanguage.g:767:1: rule__QN__Group__0 : rule__QN__Group__0__Impl rule__QN__Group__1 ;
    public final void rule__QN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:771:1: ( rule__QN__Group__0__Impl rule__QN__Group__1 )
            // InternalContentAssistTestLanguage.g:772:2: rule__QN__Group__0__Impl rule__QN__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__QN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group__0"


    // $ANTLR start "rule__QN__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:779:1: rule__QN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:783:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:784:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:784:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:785:2: RULE_ID
            {
             before(grammarAccess.getQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group__0__Impl"


    // $ANTLR start "rule__QN__Group__1"
    // InternalContentAssistTestLanguage.g:794:1: rule__QN__Group__1 : rule__QN__Group__1__Impl ;
    public final void rule__QN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:798:1: ( rule__QN__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:799:2: rule__QN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group__1"


    // $ANTLR start "rule__QN__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:805:1: rule__QN__Group__1__Impl : ( ( rule__QN__Group_1__0 )* ) ;
    public final void rule__QN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:809:1: ( ( ( rule__QN__Group_1__0 )* ) )
            // InternalContentAssistTestLanguage.g:810:1: ( ( rule__QN__Group_1__0 )* )
            {
            // InternalContentAssistTestLanguage.g:810:1: ( ( rule__QN__Group_1__0 )* )
            // InternalContentAssistTestLanguage.g:811:2: ( rule__QN__Group_1__0 )*
            {
             before(grammarAccess.getQNAccess().getGroup_1()); 
            // InternalContentAssistTestLanguage.g:812:2: ( rule__QN__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:812:3: rule__QN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__QN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group__1__Impl"


    // $ANTLR start "rule__QN__Group_1__0"
    // InternalContentAssistTestLanguage.g:821:1: rule__QN__Group_1__0 : rule__QN__Group_1__0__Impl rule__QN__Group_1__1 ;
    public final void rule__QN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:825:1: ( rule__QN__Group_1__0__Impl rule__QN__Group_1__1 )
            // InternalContentAssistTestLanguage.g:826:2: rule__QN__Group_1__0__Impl rule__QN__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__QN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QN__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group_1__0"


    // $ANTLR start "rule__QN__Group_1__0__Impl"
    // InternalContentAssistTestLanguage.g:833:1: rule__QN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:837:1: ( ( '.' ) )
            // InternalContentAssistTestLanguage.g:838:1: ( '.' )
            {
            // InternalContentAssistTestLanguage.g:838:1: ( '.' )
            // InternalContentAssistTestLanguage.g:839:2: '.'
            {
             before(grammarAccess.getQNAccess().getFullStopKeyword_1_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group_1__0__Impl"


    // $ANTLR start "rule__QN__Group_1__1"
    // InternalContentAssistTestLanguage.g:848:1: rule__QN__Group_1__1 : rule__QN__Group_1__1__Impl ;
    public final void rule__QN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:852:1: ( rule__QN__Group_1__1__Impl )
            // InternalContentAssistTestLanguage.g:853:2: rule__QN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QN__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group_1__1"


    // $ANTLR start "rule__QN__Group_1__1__Impl"
    // InternalContentAssistTestLanguage.g:859:1: rule__QN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:863:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:864:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:864:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:865:2: RULE_ID
            {
             before(grammarAccess.getQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQNAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QN__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ImportsAssignment_0"
    // InternalContentAssistTestLanguage.g:875:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:879:1: ( ( ruleImport ) )
            // InternalContentAssistTestLanguage.g:880:2: ( ruleImport )
            {
            // InternalContentAssistTestLanguage.g:880:2: ( ruleImport )
            // InternalContentAssistTestLanguage.g:881:3: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ImportsAssignment_0"


    // $ANTLR start "rule__Model__GenerateDirectiveAssignment_1"
    // InternalContentAssistTestLanguage.g:890:1: rule__Model__GenerateDirectiveAssignment_1 : ( ruleGenerateDirective ) ;
    public final void rule__Model__GenerateDirectiveAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:894:1: ( ( ruleGenerateDirective ) )
            // InternalContentAssistTestLanguage.g:895:2: ( ruleGenerateDirective )
            {
            // InternalContentAssistTestLanguage.g:895:2: ( ruleGenerateDirective )
            // InternalContentAssistTestLanguage.g:896:3: ruleGenerateDirective
            {
             before(grammarAccess.getModelAccess().getGenerateDirectiveGenerateDirectiveParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGenerateDirective();

            state._fsp--;

             after(grammarAccess.getModelAccess().getGenerateDirectiveGenerateDirectiveParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__GenerateDirectiveAssignment_1"


    // $ANTLR start "rule__Model__ReferenceHolderAssignment_2"
    // InternalContentAssistTestLanguage.g:905:1: rule__Model__ReferenceHolderAssignment_2 : ( ruleReferenceHolder ) ;
    public final void rule__Model__ReferenceHolderAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:909:1: ( ( ruleReferenceHolder ) )
            // InternalContentAssistTestLanguage.g:910:2: ( ruleReferenceHolder )
            {
            // InternalContentAssistTestLanguage.g:910:2: ( ruleReferenceHolder )
            // InternalContentAssistTestLanguage.g:911:3: ruleReferenceHolder
            {
             before(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ReferenceHolderAssignment_2"


    // $ANTLR start "rule__ReferenceHolder__DefaultReferenceAssignment_0_1"
    // InternalContentAssistTestLanguage.g:920:1: rule__ReferenceHolder__DefaultReferenceAssignment_0_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__DefaultReferenceAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:924:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistTestLanguage.g:925:2: ( ( ruleFQN ) )
            {
            // InternalContentAssistTestLanguage.g:925:2: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:926:3: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_0_1_0()); 
            // InternalContentAssistTestLanguage.g:927:3: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:928:4: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_0_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_0_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__DefaultReferenceAssignment_0_1"


    // $ANTLR start "rule__ReferenceHolder__CustomizedReferenceAssignment_1_1"
    // InternalContentAssistTestLanguage.g:939:1: rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__CustomizedReferenceAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:943:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistTestLanguage.g:944:2: ( ( ruleFQN ) )
            {
            // InternalContentAssistTestLanguage.g:944:2: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:945:3: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeCrossReference_1_1_0()); 
            // InternalContentAssistTestLanguage.g:946:3: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:947:4: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeFQNParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeFQNParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__CustomizedReferenceAssignment_1_1"


    // $ANTLR start "rule__ReferenceHolder__SubtypeReferenceAssignment_2_1"
    // InternalContentAssistTestLanguage.g:958:1: rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__SubtypeReferenceAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:962:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistTestLanguage.g:963:2: ( ( ruleFQN ) )
            {
            // InternalContentAssistTestLanguage.g:963:2: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:964:3: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeCrossReference_2_1_0()); 
            // InternalContentAssistTestLanguage.g:965:3: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:966:4: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeFQNParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeFQNParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceHolder__SubtypeReferenceAssignment_2_1"


    // $ANTLR start "rule__GenerateDirective__TypeNameAssignment_1"
    // InternalContentAssistTestLanguage.g:977:1: rule__GenerateDirective__TypeNameAssignment_1 : ( ruleQN ) ;
    public final void rule__GenerateDirective__TypeNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:981:1: ( ( ruleQN ) )
            // InternalContentAssistTestLanguage.g:982:2: ( ruleQN )
            {
            // InternalContentAssistTestLanguage.g:982:2: ( ruleQN )
            // InternalContentAssistTestLanguage.g:983:3: ruleQN
            {
             before(grammarAccess.getGenerateDirectiveAccess().getTypeNameQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQN();

            state._fsp--;

             after(grammarAccess.getGenerateDirectiveAccess().getTypeNameQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenerateDirective__TypeNameAssignment_1"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // InternalContentAssistTestLanguage.g:992:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistTestLanguage.g:996:1: ( ( ruleImportedFQN ) )
            // InternalContentAssistTestLanguage.g:997:2: ( ruleImportedFQN )
            {
            // InternalContentAssistTestLanguage.g:997:2: ( ruleImportedFQN )
            // InternalContentAssistTestLanguage.g:998:3: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040002L});

}
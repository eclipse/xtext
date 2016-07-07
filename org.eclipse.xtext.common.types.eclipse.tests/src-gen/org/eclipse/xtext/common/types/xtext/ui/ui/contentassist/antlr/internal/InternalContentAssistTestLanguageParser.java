package org.eclipse.xtext.common.types.xtext.ui.ui.contentassist.antlr.internal; 

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
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

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
    // InternalContentAssistTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:61:1: ( ruleModel EOF )
            // InternalContentAssistTestLanguage.g:62:1: ruleModel EOF
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
    // InternalContentAssistTestLanguage.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:74:1: ( ( rule__Model__Group__0 ) )
            // InternalContentAssistTestLanguage.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:76:1: ( rule__Model__Group__0 )
            // InternalContentAssistTestLanguage.g:76:2: rule__Model__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:88:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:89:1: ( ruleReferenceHolder EOF )
            // InternalContentAssistTestLanguage.g:90:1: ruleReferenceHolder EOF
            {
             before(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getReferenceHolderRule()); 
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
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // InternalContentAssistTestLanguage.g:97:1: ruleReferenceHolder : ( ( rule__ReferenceHolder__Alternatives ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:101:2: ( ( ( rule__ReferenceHolder__Alternatives ) ) )
            // InternalContentAssistTestLanguage.g:102:1: ( ( rule__ReferenceHolder__Alternatives ) )
            {
            // InternalContentAssistTestLanguage.g:102:1: ( ( rule__ReferenceHolder__Alternatives ) )
            // InternalContentAssistTestLanguage.g:103:1: ( rule__ReferenceHolder__Alternatives )
            {
             before(grammarAccess.getReferenceHolderAccess().getAlternatives()); 
            // InternalContentAssistTestLanguage.g:104:1: ( rule__ReferenceHolder__Alternatives )
            // InternalContentAssistTestLanguage.g:104:2: rule__ReferenceHolder__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:116:1: entryRuleGenerateDirective : ruleGenerateDirective EOF ;
    public final void entryRuleGenerateDirective() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:117:1: ( ruleGenerateDirective EOF )
            // InternalContentAssistTestLanguage.g:118:1: ruleGenerateDirective EOF
            {
             before(grammarAccess.getGenerateDirectiveRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGenerateDirective();

            state._fsp--;

             after(grammarAccess.getGenerateDirectiveRule()); 
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
    // $ANTLR end "entryRuleGenerateDirective"


    // $ANTLR start "ruleGenerateDirective"
    // InternalContentAssistTestLanguage.g:125:1: ruleGenerateDirective : ( ( rule__GenerateDirective__Group__0 ) ) ;
    public final void ruleGenerateDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:129:2: ( ( ( rule__GenerateDirective__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:130:1: ( ( rule__GenerateDirective__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:130:1: ( ( rule__GenerateDirective__Group__0 ) )
            // InternalContentAssistTestLanguage.g:131:1: ( rule__GenerateDirective__Group__0 )
            {
             before(grammarAccess.getGenerateDirectiveAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:132:1: ( rule__GenerateDirective__Group__0 )
            // InternalContentAssistTestLanguage.g:132:2: rule__GenerateDirective__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:144:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:145:1: ( ruleImport EOF )
            // InternalContentAssistTestLanguage.g:146:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalContentAssistTestLanguage.g:153:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:157:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:158:1: ( ( rule__Import__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:158:1: ( ( rule__Import__Group__0 ) )
            // InternalContentAssistTestLanguage.g:159:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:160:1: ( rule__Import__Group__0 )
            // InternalContentAssistTestLanguage.g:160:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:172:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:173:1: ( ruleImportedFQN EOF )
            // InternalContentAssistTestLanguage.g:174:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
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
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // InternalContentAssistTestLanguage.g:181:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:185:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:186:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:186:1: ( ( rule__ImportedFQN__Group__0 ) )
            // InternalContentAssistTestLanguage.g:187:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:188:1: ( rule__ImportedFQN__Group__0 )
            // InternalContentAssistTestLanguage.g:188:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:200:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:201:1: ( ruleFQN EOF )
            // InternalContentAssistTestLanguage.g:202:1: ruleFQN EOF
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
    // InternalContentAssistTestLanguage.g:209:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:213:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:214:1: ( ( rule__FQN__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:214:1: ( ( rule__FQN__Group__0 ) )
            // InternalContentAssistTestLanguage.g:215:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:216:1: ( rule__FQN__Group__0 )
            // InternalContentAssistTestLanguage.g:216:2: rule__FQN__Group__0
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


    // $ANTLR start "entryRuleQN"
    // InternalContentAssistTestLanguage.g:228:1: entryRuleQN : ruleQN EOF ;
    public final void entryRuleQN() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:229:1: ( ruleQN EOF )
            // InternalContentAssistTestLanguage.g:230:1: ruleQN EOF
            {
             before(grammarAccess.getQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQN();

            state._fsp--;

             after(grammarAccess.getQNRule()); 
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
    // $ANTLR end "entryRuleQN"


    // $ANTLR start "ruleQN"
    // InternalContentAssistTestLanguage.g:237:1: ruleQN : ( ( rule__QN__Group__0 ) ) ;
    public final void ruleQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:241:2: ( ( ( rule__QN__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:242:1: ( ( rule__QN__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:242:1: ( ( rule__QN__Group__0 ) )
            // InternalContentAssistTestLanguage.g:243:1: ( rule__QN__Group__0 )
            {
             before(grammarAccess.getQNAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:244:1: ( rule__QN__Group__0 )
            // InternalContentAssistTestLanguage.g:244:2: rule__QN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:256:1: rule__ReferenceHolder__Alternatives : ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) );
    public final void rule__ReferenceHolder__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:260:1: ( ( ( rule__ReferenceHolder__Group_0__0 ) ) | ( ( rule__ReferenceHolder__Group_1__0 ) ) | ( ( rule__ReferenceHolder__Group_2__0 ) ) )
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
                    // InternalContentAssistTestLanguage.g:261:1: ( ( rule__ReferenceHolder__Group_0__0 ) )
                    {
                    // InternalContentAssistTestLanguage.g:261:1: ( ( rule__ReferenceHolder__Group_0__0 ) )
                    // InternalContentAssistTestLanguage.g:262:1: ( rule__ReferenceHolder__Group_0__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_0()); 
                    // InternalContentAssistTestLanguage.g:263:1: ( rule__ReferenceHolder__Group_0__0 )
                    // InternalContentAssistTestLanguage.g:263:2: rule__ReferenceHolder__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ReferenceHolder__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalContentAssistTestLanguage.g:267:6: ( ( rule__ReferenceHolder__Group_1__0 ) )
                    {
                    // InternalContentAssistTestLanguage.g:267:6: ( ( rule__ReferenceHolder__Group_1__0 ) )
                    // InternalContentAssistTestLanguage.g:268:1: ( rule__ReferenceHolder__Group_1__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_1()); 
                    // InternalContentAssistTestLanguage.g:269:1: ( rule__ReferenceHolder__Group_1__0 )
                    // InternalContentAssistTestLanguage.g:269:2: rule__ReferenceHolder__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ReferenceHolder__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceHolderAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalContentAssistTestLanguage.g:273:6: ( ( rule__ReferenceHolder__Group_2__0 ) )
                    {
                    // InternalContentAssistTestLanguage.g:273:6: ( ( rule__ReferenceHolder__Group_2__0 ) )
                    // InternalContentAssistTestLanguage.g:274:1: ( rule__ReferenceHolder__Group_2__0 )
                    {
                     before(grammarAccess.getReferenceHolderAccess().getGroup_2()); 
                    // InternalContentAssistTestLanguage.g:275:1: ( rule__ReferenceHolder__Group_2__0 )
                    // InternalContentAssistTestLanguage.g:275:2: rule__ReferenceHolder__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:286:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:290:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalContentAssistTestLanguage.g:291:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:298:1: rule__Model__Group__0__Impl : ( ( rule__Model__ImportsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:302:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) )
            // InternalContentAssistTestLanguage.g:303:1: ( ( rule__Model__ImportsAssignment_0 )* )
            {
            // InternalContentAssistTestLanguage.g:303:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // InternalContentAssistTestLanguage.g:304:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // InternalContentAssistTestLanguage.g:305:1: ( rule__Model__ImportsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:305:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
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
    // InternalContentAssistTestLanguage.g:315:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:319:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalContentAssistTestLanguage.g:320:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:327:1: rule__Model__Group__1__Impl : ( ( rule__Model__GenerateDirectiveAssignment_1 )? ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:331:1: ( ( ( rule__Model__GenerateDirectiveAssignment_1 )? ) )
            // InternalContentAssistTestLanguage.g:332:1: ( ( rule__Model__GenerateDirectiveAssignment_1 )? )
            {
            // InternalContentAssistTestLanguage.g:332:1: ( ( rule__Model__GenerateDirectiveAssignment_1 )? )
            // InternalContentAssistTestLanguage.g:333:1: ( rule__Model__GenerateDirectiveAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getGenerateDirectiveAssignment_1()); 
            // InternalContentAssistTestLanguage.g:334:1: ( rule__Model__GenerateDirectiveAssignment_1 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:334:2: rule__Model__GenerateDirectiveAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:344:1: rule__Model__Group__2 : rule__Model__Group__2__Impl ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:348:1: ( rule__Model__Group__2__Impl )
            // InternalContentAssistTestLanguage.g:349:2: rule__Model__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:355:1: rule__Model__Group__2__Impl : ( ( rule__Model__ReferenceHolderAssignment_2 )? ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:359:1: ( ( ( rule__Model__ReferenceHolderAssignment_2 )? ) )
            // InternalContentAssistTestLanguage.g:360:1: ( ( rule__Model__ReferenceHolderAssignment_2 )? )
            {
            // InternalContentAssistTestLanguage.g:360:1: ( ( rule__Model__ReferenceHolderAssignment_2 )? )
            // InternalContentAssistTestLanguage.g:361:1: ( rule__Model__ReferenceHolderAssignment_2 )?
            {
             before(grammarAccess.getModelAccess().getReferenceHolderAssignment_2()); 
            // InternalContentAssistTestLanguage.g:362:1: ( rule__Model__ReferenceHolderAssignment_2 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=11 && LA4_0<=13)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:362:2: rule__Model__ReferenceHolderAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:378:1: rule__ReferenceHolder__Group_0__0 : rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1 ;
    public final void rule__ReferenceHolder__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:382:1: ( rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1 )
            // InternalContentAssistTestLanguage.g:383:2: rule__ReferenceHolder__Group_0__0__Impl rule__ReferenceHolder__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ReferenceHolder__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:390:1: rule__ReferenceHolder__Group_0__0__Impl : ( 'default' ) ;
    public final void rule__ReferenceHolder__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:394:1: ( ( 'default' ) )
            // InternalContentAssistTestLanguage.g:395:1: ( 'default' )
            {
            // InternalContentAssistTestLanguage.g:395:1: ( 'default' )
            // InternalContentAssistTestLanguage.g:396:1: 'default'
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultKeyword_0_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
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
    // InternalContentAssistTestLanguage.g:409:1: rule__ReferenceHolder__Group_0__1 : rule__ReferenceHolder__Group_0__1__Impl ;
    public final void rule__ReferenceHolder__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:413:1: ( rule__ReferenceHolder__Group_0__1__Impl )
            // InternalContentAssistTestLanguage.g:414:2: rule__ReferenceHolder__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:420:1: rule__ReferenceHolder__Group_0__1__Impl : ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) ) ;
    public final void rule__ReferenceHolder__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:424:1: ( ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) ) )
            // InternalContentAssistTestLanguage.g:425:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) )
            {
            // InternalContentAssistTestLanguage.g:425:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 ) )
            // InternalContentAssistTestLanguage.g:426:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_0_1()); 
            // InternalContentAssistTestLanguage.g:427:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_0_1 )
            // InternalContentAssistTestLanguage.g:427:2: rule__ReferenceHolder__DefaultReferenceAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:441:1: rule__ReferenceHolder__Group_1__0 : rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1 ;
    public final void rule__ReferenceHolder__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:445:1: ( rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1 )
            // InternalContentAssistTestLanguage.g:446:2: rule__ReferenceHolder__Group_1__0__Impl rule__ReferenceHolder__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ReferenceHolder__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:453:1: rule__ReferenceHolder__Group_1__0__Impl : ( 'custom' ) ;
    public final void rule__ReferenceHolder__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:457:1: ( ( 'custom' ) )
            // InternalContentAssistTestLanguage.g:458:1: ( 'custom' )
            {
            // InternalContentAssistTestLanguage.g:458:1: ( 'custom' )
            // InternalContentAssistTestLanguage.g:459:1: 'custom'
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
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
    // InternalContentAssistTestLanguage.g:472:1: rule__ReferenceHolder__Group_1__1 : rule__ReferenceHolder__Group_1__1__Impl ;
    public final void rule__ReferenceHolder__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:476:1: ( rule__ReferenceHolder__Group_1__1__Impl )
            // InternalContentAssistTestLanguage.g:477:2: rule__ReferenceHolder__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:483:1: rule__ReferenceHolder__Group_1__1__Impl : ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) ) ;
    public final void rule__ReferenceHolder__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:487:1: ( ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) ) )
            // InternalContentAssistTestLanguage.g:488:1: ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) )
            {
            // InternalContentAssistTestLanguage.g:488:1: ( ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 ) )
            // InternalContentAssistTestLanguage.g:489:1: ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceAssignment_1_1()); 
            // InternalContentAssistTestLanguage.g:490:1: ( rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 )
            // InternalContentAssistTestLanguage.g:490:2: rule__ReferenceHolder__CustomizedReferenceAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:504:1: rule__ReferenceHolder__Group_2__0 : rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1 ;
    public final void rule__ReferenceHolder__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:508:1: ( rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1 )
            // InternalContentAssistTestLanguage.g:509:2: rule__ReferenceHolder__Group_2__0__Impl rule__ReferenceHolder__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ReferenceHolder__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:516:1: rule__ReferenceHolder__Group_2__0__Impl : ( 'subtype' ) ;
    public final void rule__ReferenceHolder__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:520:1: ( ( 'subtype' ) )
            // InternalContentAssistTestLanguage.g:521:1: ( 'subtype' )
            {
            // InternalContentAssistTestLanguage.g:521:1: ( 'subtype' )
            // InternalContentAssistTestLanguage.g:522:1: 'subtype'
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeKeyword_2_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
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
    // InternalContentAssistTestLanguage.g:535:1: rule__ReferenceHolder__Group_2__1 : rule__ReferenceHolder__Group_2__1__Impl ;
    public final void rule__ReferenceHolder__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:539:1: ( rule__ReferenceHolder__Group_2__1__Impl )
            // InternalContentAssistTestLanguage.g:540:2: rule__ReferenceHolder__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:546:1: rule__ReferenceHolder__Group_2__1__Impl : ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) ) ;
    public final void rule__ReferenceHolder__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:550:1: ( ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) ) )
            // InternalContentAssistTestLanguage.g:551:1: ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) )
            {
            // InternalContentAssistTestLanguage.g:551:1: ( ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 ) )
            // InternalContentAssistTestLanguage.g:552:1: ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceAssignment_2_1()); 
            // InternalContentAssistTestLanguage.g:553:1: ( rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 )
            // InternalContentAssistTestLanguage.g:553:2: rule__ReferenceHolder__SubtypeReferenceAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:567:1: rule__GenerateDirective__Group__0 : rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1 ;
    public final void rule__GenerateDirective__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:571:1: ( rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1 )
            // InternalContentAssistTestLanguage.g:572:2: rule__GenerateDirective__Group__0__Impl rule__GenerateDirective__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__GenerateDirective__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:579:1: rule__GenerateDirective__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GenerateDirective__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:583:1: ( ( 'generate' ) )
            // InternalContentAssistTestLanguage.g:584:1: ( 'generate' )
            {
            // InternalContentAssistTestLanguage.g:584:1: ( 'generate' )
            // InternalContentAssistTestLanguage.g:585:1: 'generate'
            {
             before(grammarAccess.getGenerateDirectiveAccess().getGenerateKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
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
    // InternalContentAssistTestLanguage.g:598:1: rule__GenerateDirective__Group__1 : rule__GenerateDirective__Group__1__Impl ;
    public final void rule__GenerateDirective__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:602:1: ( rule__GenerateDirective__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:603:2: rule__GenerateDirective__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:609:1: rule__GenerateDirective__Group__1__Impl : ( ( rule__GenerateDirective__TypeNameAssignment_1 ) ) ;
    public final void rule__GenerateDirective__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:613:1: ( ( ( rule__GenerateDirective__TypeNameAssignment_1 ) ) )
            // InternalContentAssistTestLanguage.g:614:1: ( ( rule__GenerateDirective__TypeNameAssignment_1 ) )
            {
            // InternalContentAssistTestLanguage.g:614:1: ( ( rule__GenerateDirective__TypeNameAssignment_1 ) )
            // InternalContentAssistTestLanguage.g:615:1: ( rule__GenerateDirective__TypeNameAssignment_1 )
            {
             before(grammarAccess.getGenerateDirectiveAccess().getTypeNameAssignment_1()); 
            // InternalContentAssistTestLanguage.g:616:1: ( rule__GenerateDirective__TypeNameAssignment_1 )
            // InternalContentAssistTestLanguage.g:616:2: rule__GenerateDirective__TypeNameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:630:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:634:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalContentAssistTestLanguage.g:635:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:642:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:646:1: ( ( 'import' ) )
            // InternalContentAssistTestLanguage.g:647:1: ( 'import' )
            {
            // InternalContentAssistTestLanguage.g:647:1: ( 'import' )
            // InternalContentAssistTestLanguage.g:648:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
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
    // InternalContentAssistTestLanguage.g:661:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:665:1: ( rule__Import__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:666:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:672:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:676:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalContentAssistTestLanguage.g:677:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalContentAssistTestLanguage.g:677:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalContentAssistTestLanguage.g:678:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalContentAssistTestLanguage.g:679:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalContentAssistTestLanguage.g:679:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:693:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:697:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // InternalContentAssistTestLanguage.g:698:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:705:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:709:1: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:710:1: ( ruleFQN )
            {
            // InternalContentAssistTestLanguage.g:710:1: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:711:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:722:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:726:1: ( rule__ImportedFQN__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:727:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:733:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:737:1: ( ( ( '.*' )? ) )
            // InternalContentAssistTestLanguage.g:738:1: ( ( '.*' )? )
            {
            // InternalContentAssistTestLanguage.g:738:1: ( ( '.*' )? )
            // InternalContentAssistTestLanguage.g:739:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // InternalContentAssistTestLanguage.g:740:1: ( '.*' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:741:2: '.*'
                    {
                    match(input,16,FollowSets000.FOLLOW_2); 

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
    // InternalContentAssistTestLanguage.g:756:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:760:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalContentAssistTestLanguage.g:761:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
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
    // InternalContentAssistTestLanguage.g:768:1: rule__FQN__Group__0__Impl : ( ruleQN ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:772:1: ( ( ruleQN ) )
            // InternalContentAssistTestLanguage.g:773:1: ( ruleQN )
            {
            // InternalContentAssistTestLanguage.g:773:1: ( ruleQN )
            // InternalContentAssistTestLanguage.g:774:1: ruleQN
            {
             before(grammarAccess.getFQNAccess().getQNParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:785:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:789:1: ( rule__FQN__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:790:2: rule__FQN__Group__1__Impl
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
    // InternalContentAssistTestLanguage.g:796:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:800:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalContentAssistTestLanguage.g:801:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalContentAssistTestLanguage.g:801:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalContentAssistTestLanguage.g:802:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalContentAssistTestLanguage.g:803:1: ( rule__FQN__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:803:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
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
    // InternalContentAssistTestLanguage.g:817:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:821:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalContentAssistTestLanguage.g:822:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
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
    // InternalContentAssistTestLanguage.g:829:1: rule__FQN__Group_1__0__Impl : ( '$' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:833:1: ( ( '$' ) )
            // InternalContentAssistTestLanguage.g:834:1: ( '$' )
            {
            // InternalContentAssistTestLanguage.g:834:1: ( '$' )
            // InternalContentAssistTestLanguage.g:835:1: '$'
            {
             before(grammarAccess.getFQNAccess().getDollarSignKeyword_1_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
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
    // InternalContentAssistTestLanguage.g:848:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:852:1: ( rule__FQN__Group_1__1__Impl )
            // InternalContentAssistTestLanguage.g:853:2: rule__FQN__Group_1__1__Impl
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
    // InternalContentAssistTestLanguage.g:859:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:863:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:864:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:864:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:865:1: RULE_ID
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


    // $ANTLR start "rule__QN__Group__0"
    // InternalContentAssistTestLanguage.g:880:1: rule__QN__Group__0 : rule__QN__Group__0__Impl rule__QN__Group__1 ;
    public final void rule__QN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:884:1: ( rule__QN__Group__0__Impl rule__QN__Group__1 )
            // InternalContentAssistTestLanguage.g:885:2: rule__QN__Group__0__Impl rule__QN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__QN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:892:1: rule__QN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:896:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:897:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:897:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:898:1: RULE_ID
            {
             before(grammarAccess.getQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalContentAssistTestLanguage.g:909:1: rule__QN__Group__1 : rule__QN__Group__1__Impl ;
    public final void rule__QN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:913:1: ( rule__QN__Group__1__Impl )
            // InternalContentAssistTestLanguage.g:914:2: rule__QN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:920:1: rule__QN__Group__1__Impl : ( ( rule__QN__Group_1__0 )* ) ;
    public final void rule__QN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:924:1: ( ( ( rule__QN__Group_1__0 )* ) )
            // InternalContentAssistTestLanguage.g:925:1: ( ( rule__QN__Group_1__0 )* )
            {
            // InternalContentAssistTestLanguage.g:925:1: ( ( rule__QN__Group_1__0 )* )
            // InternalContentAssistTestLanguage.g:926:1: ( rule__QN__Group_1__0 )*
            {
             before(grammarAccess.getQNAccess().getGroup_1()); 
            // InternalContentAssistTestLanguage.g:927:1: ( rule__QN__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:927:2: rule__QN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_10);
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
    // InternalContentAssistTestLanguage.g:941:1: rule__QN__Group_1__0 : rule__QN__Group_1__0__Impl rule__QN__Group_1__1 ;
    public final void rule__QN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:945:1: ( rule__QN__Group_1__0__Impl rule__QN__Group_1__1 )
            // InternalContentAssistTestLanguage.g:946:2: rule__QN__Group_1__0__Impl rule__QN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__QN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:953:1: rule__QN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:957:1: ( ( '.' ) )
            // InternalContentAssistTestLanguage.g:958:1: ( '.' )
            {
            // InternalContentAssistTestLanguage.g:958:1: ( '.' )
            // InternalContentAssistTestLanguage.g:959:1: '.'
            {
             before(grammarAccess.getQNAccess().getFullStopKeyword_1_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
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
    // InternalContentAssistTestLanguage.g:972:1: rule__QN__Group_1__1 : rule__QN__Group_1__1__Impl ;
    public final void rule__QN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:976:1: ( rule__QN__Group_1__1__Impl )
            // InternalContentAssistTestLanguage.g:977:2: rule__QN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:983:1: rule__QN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:987:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:988:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:988:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:989:1: RULE_ID
            {
             before(grammarAccess.getQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalContentAssistTestLanguage.g:1005:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:1009:1: ( ( ruleImport ) )
            // InternalContentAssistTestLanguage.g:1010:1: ( ruleImport )
            {
            // InternalContentAssistTestLanguage.g:1010:1: ( ruleImport )
            // InternalContentAssistTestLanguage.g:1011:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:1020:1: rule__Model__GenerateDirectiveAssignment_1 : ( ruleGenerateDirective ) ;
    public final void rule__Model__GenerateDirectiveAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:1024:1: ( ( ruleGenerateDirective ) )
            // InternalContentAssistTestLanguage.g:1025:1: ( ruleGenerateDirective )
            {
            // InternalContentAssistTestLanguage.g:1025:1: ( ruleGenerateDirective )
            // InternalContentAssistTestLanguage.g:1026:1: ruleGenerateDirective
            {
             before(grammarAccess.getModelAccess().getGenerateDirectiveGenerateDirectiveParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:1035:1: rule__Model__ReferenceHolderAssignment_2 : ( ruleReferenceHolder ) ;
    public final void rule__Model__ReferenceHolderAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:1039:1: ( ( ruleReferenceHolder ) )
            // InternalContentAssistTestLanguage.g:1040:1: ( ruleReferenceHolder )
            {
            // InternalContentAssistTestLanguage.g:1040:1: ( ruleReferenceHolder )
            // InternalContentAssistTestLanguage.g:1041:1: ruleReferenceHolder
            {
             before(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:1050:1: rule__ReferenceHolder__DefaultReferenceAssignment_0_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__DefaultReferenceAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:1054:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistTestLanguage.g:1055:1: ( ( ruleFQN ) )
            {
            // InternalContentAssistTestLanguage.g:1055:1: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:1056:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_0_1_0()); 
            // InternalContentAssistTestLanguage.g:1057:1: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:1058:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_0_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:1069:1: rule__ReferenceHolder__CustomizedReferenceAssignment_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__CustomizedReferenceAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:1073:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistTestLanguage.g:1074:1: ( ( ruleFQN ) )
            {
            // InternalContentAssistTestLanguage.g:1074:1: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:1075:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeCrossReference_1_1_0()); 
            // InternalContentAssistTestLanguage.g:1076:1: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:1077:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getCustomizedReferenceJvmTypeFQNParserRuleCall_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:1088:1: rule__ReferenceHolder__SubtypeReferenceAssignment_2_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__SubtypeReferenceAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:1092:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistTestLanguage.g:1093:1: ( ( ruleFQN ) )
            {
            // InternalContentAssistTestLanguage.g:1093:1: ( ( ruleFQN ) )
            // InternalContentAssistTestLanguage.g:1094:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeCrossReference_2_1_0()); 
            // InternalContentAssistTestLanguage.g:1095:1: ( ruleFQN )
            // InternalContentAssistTestLanguage.g:1096:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getSubtypeReferenceJvmTypeFQNParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:1107:1: rule__GenerateDirective__TypeNameAssignment_1 : ( ruleQN ) ;
    public final void rule__GenerateDirective__TypeNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:1111:1: ( ( ruleQN ) )
            // InternalContentAssistTestLanguage.g:1112:1: ( ruleQN )
            {
            // InternalContentAssistTestLanguage.g:1112:1: ( ruleQN )
            // InternalContentAssistTestLanguage.g:1113:1: ruleQN
            {
             before(grammarAccess.getGenerateDirectiveAccess().getTypeNameQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalContentAssistTestLanguage.g:1122:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:1126:1: ( ( ruleImportedFQN ) )
            // InternalContentAssistTestLanguage.g:1127:1: ( ruleImportedFQN )
            {
            // InternalContentAssistTestLanguage.g:1127:1: ( ruleImportedFQN )
            // InternalContentAssistTestLanguage.g:1128:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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


 

    
    private static class FollowSets000 {
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


}
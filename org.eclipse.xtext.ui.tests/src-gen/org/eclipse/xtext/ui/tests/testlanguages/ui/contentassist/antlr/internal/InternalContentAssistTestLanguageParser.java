package org.eclipse.xtext.ui.tests.testlanguages.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.testlanguages.services.ContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract rules'", "'end'", "'('", "')'", "';'", "'rule'", "':'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
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




    // $ANTLR start "entryRuleStart"
    // InternalContentAssistTestLanguage.g:60:1: entryRuleStart : ruleStart EOF ;
    public final void entryRuleStart() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:61:1: ( ruleStart EOF )
            // InternalContentAssistTestLanguage.g:62:1: ruleStart EOF
            {
             before(grammarAccess.getStartRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleStart();

            state._fsp--;

             after(grammarAccess.getStartRule()); 
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
    // $ANTLR end "entryRuleStart"


    // $ANTLR start "ruleStart"
    // InternalContentAssistTestLanguage.g:69:1: ruleStart : ( ( rule__Start__Group__0 ) ) ;
    public final void ruleStart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:73:2: ( ( ( rule__Start__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:74:1: ( ( rule__Start__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:74:1: ( ( rule__Start__Group__0 ) )
            // InternalContentAssistTestLanguage.g:75:1: ( rule__Start__Group__0 )
            {
             before(grammarAccess.getStartAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:76:1: ( rule__Start__Group__0 )
            // InternalContentAssistTestLanguage.g:76:2: rule__Start__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Start__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStart"


    // $ANTLR start "entryRuleAbstractRule"
    // InternalContentAssistTestLanguage.g:88:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:89:1: ( ruleAbstractRule EOF )
            // InternalContentAssistTestLanguage.g:90:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractRule();

            state._fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // InternalContentAssistTestLanguage.g:97:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:101:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // InternalContentAssistTestLanguage.g:102:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // InternalContentAssistTestLanguage.g:102:1: ( ( rule__AbstractRule__Alternatives ) )
            // InternalContentAssistTestLanguage.g:103:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // InternalContentAssistTestLanguage.g:104:1: ( rule__AbstractRule__Alternatives )
            // InternalContentAssistTestLanguage.g:104:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleFirstAbstractRuleChild"
    // InternalContentAssistTestLanguage.g:116:1: entryRuleFirstAbstractRuleChild : ruleFirstAbstractRuleChild EOF ;
    public final void entryRuleFirstAbstractRuleChild() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:117:1: ( ruleFirstAbstractRuleChild EOF )
            // InternalContentAssistTestLanguage.g:118:1: ruleFirstAbstractRuleChild EOF
            {
             before(grammarAccess.getFirstAbstractRuleChildRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFirstAbstractRuleChild();

            state._fsp--;

             after(grammarAccess.getFirstAbstractRuleChildRule()); 
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
    // $ANTLR end "entryRuleFirstAbstractRuleChild"


    // $ANTLR start "ruleFirstAbstractRuleChild"
    // InternalContentAssistTestLanguage.g:125:1: ruleFirstAbstractRuleChild : ( ( rule__FirstAbstractRuleChild__Group__0 ) ) ;
    public final void ruleFirstAbstractRuleChild() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:129:2: ( ( ( rule__FirstAbstractRuleChild__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:130:1: ( ( rule__FirstAbstractRuleChild__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:130:1: ( ( rule__FirstAbstractRuleChild__Group__0 ) )
            // InternalContentAssistTestLanguage.g:131:1: ( rule__FirstAbstractRuleChild__Group__0 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:132:1: ( rule__FirstAbstractRuleChild__Group__0 )
            // InternalContentAssistTestLanguage.g:132:2: rule__FirstAbstractRuleChild__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstAbstractRuleChild__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFirstAbstractRuleChild"


    // $ANTLR start "entryRuleSecondAbstractRuleChild"
    // InternalContentAssistTestLanguage.g:144:1: entryRuleSecondAbstractRuleChild : ruleSecondAbstractRuleChild EOF ;
    public final void entryRuleSecondAbstractRuleChild() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:145:1: ( ruleSecondAbstractRuleChild EOF )
            // InternalContentAssistTestLanguage.g:146:1: ruleSecondAbstractRuleChild EOF
            {
             before(grammarAccess.getSecondAbstractRuleChildRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSecondAbstractRuleChild();

            state._fsp--;

             after(grammarAccess.getSecondAbstractRuleChildRule()); 
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
    // $ANTLR end "entryRuleSecondAbstractRuleChild"


    // $ANTLR start "ruleSecondAbstractRuleChild"
    // InternalContentAssistTestLanguage.g:153:1: ruleSecondAbstractRuleChild : ( ( rule__SecondAbstractRuleChild__Group__0 ) ) ;
    public final void ruleSecondAbstractRuleChild() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:157:2: ( ( ( rule__SecondAbstractRuleChild__Group__0 ) ) )
            // InternalContentAssistTestLanguage.g:158:1: ( ( rule__SecondAbstractRuleChild__Group__0 ) )
            {
            // InternalContentAssistTestLanguage.g:158:1: ( ( rule__SecondAbstractRuleChild__Group__0 ) )
            // InternalContentAssistTestLanguage.g:159:1: ( rule__SecondAbstractRuleChild__Group__0 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getGroup()); 
            // InternalContentAssistTestLanguage.g:160:1: ( rule__SecondAbstractRuleChild__Group__0 )
            // InternalContentAssistTestLanguage.g:160:2: rule__SecondAbstractRuleChild__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondAbstractRuleChild__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSecondAbstractRuleChild"


    // $ANTLR start "entryRuleAbstractRuleCall"
    // InternalContentAssistTestLanguage.g:172:1: entryRuleAbstractRuleCall : ruleAbstractRuleCall EOF ;
    public final void entryRuleAbstractRuleCall() throws RecognitionException {
        try {
            // InternalContentAssistTestLanguage.g:173:1: ( ruleAbstractRuleCall EOF )
            // InternalContentAssistTestLanguage.g:174:1: ruleAbstractRuleCall EOF
            {
             before(grammarAccess.getAbstractRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractRuleCall();

            state._fsp--;

             after(grammarAccess.getAbstractRuleCallRule()); 
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
    // $ANTLR end "entryRuleAbstractRuleCall"


    // $ANTLR start "ruleAbstractRuleCall"
    // InternalContentAssistTestLanguage.g:181:1: ruleAbstractRuleCall : ( ( rule__AbstractRuleCall__RuleAssignment ) ) ;
    public final void ruleAbstractRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:185:2: ( ( ( rule__AbstractRuleCall__RuleAssignment ) ) )
            // InternalContentAssistTestLanguage.g:186:1: ( ( rule__AbstractRuleCall__RuleAssignment ) )
            {
            // InternalContentAssistTestLanguage.g:186:1: ( ( rule__AbstractRuleCall__RuleAssignment ) )
            // InternalContentAssistTestLanguage.g:187:1: ( rule__AbstractRuleCall__RuleAssignment )
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAssignment()); 
            // InternalContentAssistTestLanguage.g:188:1: ( rule__AbstractRuleCall__RuleAssignment )
            // InternalContentAssistTestLanguage.g:188:2: rule__AbstractRuleCall__RuleAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractRuleCall__RuleAssignment();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleCallAccess().getRuleAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractRuleCall"


    // $ANTLR start "rule__AbstractRule__Alternatives"
    // InternalContentAssistTestLanguage.g:200:1: rule__AbstractRule__Alternatives : ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:204:1: ( ( ruleFirstAbstractRuleChild ) | ( ruleSecondAbstractRuleChild ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==16) ) {
                    alt1=2;
                }
                else if ( (LA1_1==13) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:205:1: ( ruleFirstAbstractRuleChild )
                    {
                    // InternalContentAssistTestLanguage.g:205:1: ( ruleFirstAbstractRuleChild )
                    // InternalContentAssistTestLanguage.g:206:1: ruleFirstAbstractRuleChild
                    {
                     before(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleFirstAbstractRuleChild();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalContentAssistTestLanguage.g:211:6: ( ruleSecondAbstractRuleChild )
                    {
                    // InternalContentAssistTestLanguage.g:211:6: ( ruleSecondAbstractRuleChild )
                    // InternalContentAssistTestLanguage.g:212:1: ruleSecondAbstractRuleChild
                    {
                     before(grammarAccess.getAbstractRuleAccess().getSecondAbstractRuleChildParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSecondAbstractRuleChild();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getSecondAbstractRuleChildParserRuleCall_1()); 

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
    // $ANTLR end "rule__AbstractRule__Alternatives"


    // $ANTLR start "rule__Start__Group__0"
    // InternalContentAssistTestLanguage.g:224:1: rule__Start__Group__0 : rule__Start__Group__0__Impl rule__Start__Group__1 ;
    public final void rule__Start__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:228:1: ( rule__Start__Group__0__Impl rule__Start__Group__1 )
            // InternalContentAssistTestLanguage.g:229:2: rule__Start__Group__0__Impl rule__Start__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Start__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Start__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Start__Group__0"


    // $ANTLR start "rule__Start__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:236:1: rule__Start__Group__0__Impl : ( 'abstract rules' ) ;
    public final void rule__Start__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:240:1: ( ( 'abstract rules' ) )
            // InternalContentAssistTestLanguage.g:241:1: ( 'abstract rules' )
            {
            // InternalContentAssistTestLanguage.g:241:1: ( 'abstract rules' )
            // InternalContentAssistTestLanguage.g:242:1: 'abstract rules'
            {
             before(grammarAccess.getStartAccess().getAbstractRulesKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStartAccess().getAbstractRulesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Start__Group__0__Impl"


    // $ANTLR start "rule__Start__Group__1"
    // InternalContentAssistTestLanguage.g:255:1: rule__Start__Group__1 : rule__Start__Group__1__Impl rule__Start__Group__2 ;
    public final void rule__Start__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:259:1: ( rule__Start__Group__1__Impl rule__Start__Group__2 )
            // InternalContentAssistTestLanguage.g:260:2: rule__Start__Group__1__Impl rule__Start__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Start__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Start__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Start__Group__1"


    // $ANTLR start "rule__Start__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:267:1: rule__Start__Group__1__Impl : ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) ) ;
    public final void rule__Start__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:271:1: ( ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) ) )
            // InternalContentAssistTestLanguage.g:272:1: ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) )
            {
            // InternalContentAssistTestLanguage.g:272:1: ( ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* ) )
            // InternalContentAssistTestLanguage.g:273:1: ( ( rule__Start__RulesAssignment_1 ) ) ( ( rule__Start__RulesAssignment_1 )* )
            {
            // InternalContentAssistTestLanguage.g:273:1: ( ( rule__Start__RulesAssignment_1 ) )
            // InternalContentAssistTestLanguage.g:274:1: ( rule__Start__RulesAssignment_1 )
            {
             before(grammarAccess.getStartAccess().getRulesAssignment_1()); 
            // InternalContentAssistTestLanguage.g:275:1: ( rule__Start__RulesAssignment_1 )
            // InternalContentAssistTestLanguage.g:275:2: rule__Start__RulesAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Start__RulesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStartAccess().getRulesAssignment_1()); 

            }

            // InternalContentAssistTestLanguage.g:278:1: ( ( rule__Start__RulesAssignment_1 )* )
            // InternalContentAssistTestLanguage.g:279:1: ( rule__Start__RulesAssignment_1 )*
            {
             before(grammarAccess.getStartAccess().getRulesAssignment_1()); 
            // InternalContentAssistTestLanguage.g:280:1: ( rule__Start__RulesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:280:2: rule__Start__RulesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Start__RulesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getStartAccess().getRulesAssignment_1()); 

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

        }
        return ;
    }
    // $ANTLR end "rule__Start__Group__1__Impl"


    // $ANTLR start "rule__Start__Group__2"
    // InternalContentAssistTestLanguage.g:291:1: rule__Start__Group__2 : rule__Start__Group__2__Impl ;
    public final void rule__Start__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:295:1: ( rule__Start__Group__2__Impl )
            // InternalContentAssistTestLanguage.g:296:2: rule__Start__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Start__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Start__Group__2"


    // $ANTLR start "rule__Start__Group__2__Impl"
    // InternalContentAssistTestLanguage.g:302:1: rule__Start__Group__2__Impl : ( 'end' ) ;
    public final void rule__Start__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:306:1: ( ( 'end' ) )
            // InternalContentAssistTestLanguage.g:307:1: ( 'end' )
            {
            // InternalContentAssistTestLanguage.g:307:1: ( 'end' )
            // InternalContentAssistTestLanguage.g:308:1: 'end'
            {
             before(grammarAccess.getStartAccess().getEndKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStartAccess().getEndKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Start__Group__2__Impl"


    // $ANTLR start "rule__FirstAbstractRuleChild__Group__0"
    // InternalContentAssistTestLanguage.g:327:1: rule__FirstAbstractRuleChild__Group__0 : rule__FirstAbstractRuleChild__Group__0__Impl rule__FirstAbstractRuleChild__Group__1 ;
    public final void rule__FirstAbstractRuleChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:331:1: ( rule__FirstAbstractRuleChild__Group__0__Impl rule__FirstAbstractRuleChild__Group__1 )
            // InternalContentAssistTestLanguage.g:332:2: rule__FirstAbstractRuleChild__Group__0__Impl rule__FirstAbstractRuleChild__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__FirstAbstractRuleChild__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstAbstractRuleChild__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__Group__0"


    // $ANTLR start "rule__FirstAbstractRuleChild__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:339:1: rule__FirstAbstractRuleChild__Group__0__Impl : ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) ) ;
    public final void rule__FirstAbstractRuleChild__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:343:1: ( ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) ) )
            // InternalContentAssistTestLanguage.g:344:1: ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) )
            {
            // InternalContentAssistTestLanguage.g:344:1: ( ( rule__FirstAbstractRuleChild__NameAssignment_0 ) )
            // InternalContentAssistTestLanguage.g:345:1: ( rule__FirstAbstractRuleChild__NameAssignment_0 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0()); 
            // InternalContentAssistTestLanguage.g:346:1: ( rule__FirstAbstractRuleChild__NameAssignment_0 )
            // InternalContentAssistTestLanguage.g:346:2: rule__FirstAbstractRuleChild__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstAbstractRuleChild__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__Group__0__Impl"


    // $ANTLR start "rule__FirstAbstractRuleChild__Group__1"
    // InternalContentAssistTestLanguage.g:356:1: rule__FirstAbstractRuleChild__Group__1 : rule__FirstAbstractRuleChild__Group__1__Impl rule__FirstAbstractRuleChild__Group__2 ;
    public final void rule__FirstAbstractRuleChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:360:1: ( rule__FirstAbstractRuleChild__Group__1__Impl rule__FirstAbstractRuleChild__Group__2 )
            // InternalContentAssistTestLanguage.g:361:2: rule__FirstAbstractRuleChild__Group__1__Impl rule__FirstAbstractRuleChild__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__FirstAbstractRuleChild__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstAbstractRuleChild__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__Group__1"


    // $ANTLR start "rule__FirstAbstractRuleChild__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:368:1: rule__FirstAbstractRuleChild__Group__1__Impl : ( '(' ) ;
    public final void rule__FirstAbstractRuleChild__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:372:1: ( ( '(' ) )
            // InternalContentAssistTestLanguage.g:373:1: ( '(' )
            {
            // InternalContentAssistTestLanguage.g:373:1: ( '(' )
            // InternalContentAssistTestLanguage.g:374:1: '('
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__Group__1__Impl"


    // $ANTLR start "rule__FirstAbstractRuleChild__Group__2"
    // InternalContentAssistTestLanguage.g:387:1: rule__FirstAbstractRuleChild__Group__2 : rule__FirstAbstractRuleChild__Group__2__Impl rule__FirstAbstractRuleChild__Group__3 ;
    public final void rule__FirstAbstractRuleChild__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:391:1: ( rule__FirstAbstractRuleChild__Group__2__Impl rule__FirstAbstractRuleChild__Group__3 )
            // InternalContentAssistTestLanguage.g:392:2: rule__FirstAbstractRuleChild__Group__2__Impl rule__FirstAbstractRuleChild__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__FirstAbstractRuleChild__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstAbstractRuleChild__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__Group__2"


    // $ANTLR start "rule__FirstAbstractRuleChild__Group__2__Impl"
    // InternalContentAssistTestLanguage.g:399:1: rule__FirstAbstractRuleChild__Group__2__Impl : ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) ) ;
    public final void rule__FirstAbstractRuleChild__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:403:1: ( ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) ) )
            // InternalContentAssistTestLanguage.g:404:1: ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) )
            {
            // InternalContentAssistTestLanguage.g:404:1: ( ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* ) )
            // InternalContentAssistTestLanguage.g:405:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) ) ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* )
            {
            // InternalContentAssistTestLanguage.g:405:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 ) )
            // InternalContentAssistTestLanguage.g:406:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 
            // InternalContentAssistTestLanguage.g:407:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )
            // InternalContentAssistTestLanguage.g:407:2: rule__FirstAbstractRuleChild__ElementsAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__FirstAbstractRuleChild__ElementsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 

            }

            // InternalContentAssistTestLanguage.g:410:1: ( ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )* )
            // InternalContentAssistTestLanguage.g:411:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )*
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 
            // InternalContentAssistTestLanguage.g:412:1: ( rule__FirstAbstractRuleChild__ElementsAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:412:2: rule__FirstAbstractRuleChild__ElementsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__FirstAbstractRuleChild__ElementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAssignment_2()); 

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

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__Group__2__Impl"


    // $ANTLR start "rule__FirstAbstractRuleChild__Group__3"
    // InternalContentAssistTestLanguage.g:423:1: rule__FirstAbstractRuleChild__Group__3 : rule__FirstAbstractRuleChild__Group__3__Impl rule__FirstAbstractRuleChild__Group__4 ;
    public final void rule__FirstAbstractRuleChild__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:427:1: ( rule__FirstAbstractRuleChild__Group__3__Impl rule__FirstAbstractRuleChild__Group__4 )
            // InternalContentAssistTestLanguage.g:428:2: rule__FirstAbstractRuleChild__Group__3__Impl rule__FirstAbstractRuleChild__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__FirstAbstractRuleChild__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstAbstractRuleChild__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__Group__3"


    // $ANTLR start "rule__FirstAbstractRuleChild__Group__3__Impl"
    // InternalContentAssistTestLanguage.g:435:1: rule__FirstAbstractRuleChild__Group__3__Impl : ( ')' ) ;
    public final void rule__FirstAbstractRuleChild__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:439:1: ( ( ')' ) )
            // InternalContentAssistTestLanguage.g:440:1: ( ')' )
            {
            // InternalContentAssistTestLanguage.g:440:1: ( ')' )
            // InternalContentAssistTestLanguage.g:441:1: ')'
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__Group__3__Impl"


    // $ANTLR start "rule__FirstAbstractRuleChild__Group__4"
    // InternalContentAssistTestLanguage.g:454:1: rule__FirstAbstractRuleChild__Group__4 : rule__FirstAbstractRuleChild__Group__4__Impl ;
    public final void rule__FirstAbstractRuleChild__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:458:1: ( rule__FirstAbstractRuleChild__Group__4__Impl )
            // InternalContentAssistTestLanguage.g:459:2: rule__FirstAbstractRuleChild__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstAbstractRuleChild__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__Group__4"


    // $ANTLR start "rule__FirstAbstractRuleChild__Group__4__Impl"
    // InternalContentAssistTestLanguage.g:465:1: rule__FirstAbstractRuleChild__Group__4__Impl : ( ';' ) ;
    public final void rule__FirstAbstractRuleChild__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:469:1: ( ( ';' ) )
            // InternalContentAssistTestLanguage.g:470:1: ( ';' )
            {
            // InternalContentAssistTestLanguage.g:470:1: ( ';' )
            // InternalContentAssistTestLanguage.g:471:1: ';'
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getSemicolonKeyword_4()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__Group__4__Impl"


    // $ANTLR start "rule__SecondAbstractRuleChild__Group__0"
    // InternalContentAssistTestLanguage.g:494:1: rule__SecondAbstractRuleChild__Group__0 : rule__SecondAbstractRuleChild__Group__0__Impl rule__SecondAbstractRuleChild__Group__1 ;
    public final void rule__SecondAbstractRuleChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:498:1: ( rule__SecondAbstractRuleChild__Group__0__Impl rule__SecondAbstractRuleChild__Group__1 )
            // InternalContentAssistTestLanguage.g:499:2: rule__SecondAbstractRuleChild__Group__0__Impl rule__SecondAbstractRuleChild__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__SecondAbstractRuleChild__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondAbstractRuleChild__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__Group__0"


    // $ANTLR start "rule__SecondAbstractRuleChild__Group__0__Impl"
    // InternalContentAssistTestLanguage.g:506:1: rule__SecondAbstractRuleChild__Group__0__Impl : ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) ) ;
    public final void rule__SecondAbstractRuleChild__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:510:1: ( ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) ) )
            // InternalContentAssistTestLanguage.g:511:1: ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) )
            {
            // InternalContentAssistTestLanguage.g:511:1: ( ( rule__SecondAbstractRuleChild__NameAssignment_0 ) )
            // InternalContentAssistTestLanguage.g:512:1: ( rule__SecondAbstractRuleChild__NameAssignment_0 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0()); 
            // InternalContentAssistTestLanguage.g:513:1: ( rule__SecondAbstractRuleChild__NameAssignment_0 )
            // InternalContentAssistTestLanguage.g:513:2: rule__SecondAbstractRuleChild__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondAbstractRuleChild__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__Group__0__Impl"


    // $ANTLR start "rule__SecondAbstractRuleChild__Group__1"
    // InternalContentAssistTestLanguage.g:523:1: rule__SecondAbstractRuleChild__Group__1 : rule__SecondAbstractRuleChild__Group__1__Impl rule__SecondAbstractRuleChild__Group__2 ;
    public final void rule__SecondAbstractRuleChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:527:1: ( rule__SecondAbstractRuleChild__Group__1__Impl rule__SecondAbstractRuleChild__Group__2 )
            // InternalContentAssistTestLanguage.g:528:2: rule__SecondAbstractRuleChild__Group__1__Impl rule__SecondAbstractRuleChild__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__SecondAbstractRuleChild__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondAbstractRuleChild__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__Group__1"


    // $ANTLR start "rule__SecondAbstractRuleChild__Group__1__Impl"
    // InternalContentAssistTestLanguage.g:535:1: rule__SecondAbstractRuleChild__Group__1__Impl : ( 'rule' ) ;
    public final void rule__SecondAbstractRuleChild__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:539:1: ( ( 'rule' ) )
            // InternalContentAssistTestLanguage.g:540:1: ( 'rule' )
            {
            // InternalContentAssistTestLanguage.g:540:1: ( 'rule' )
            // InternalContentAssistTestLanguage.g:541:1: 'rule'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__Group__1__Impl"


    // $ANTLR start "rule__SecondAbstractRuleChild__Group__2"
    // InternalContentAssistTestLanguage.g:554:1: rule__SecondAbstractRuleChild__Group__2 : rule__SecondAbstractRuleChild__Group__2__Impl rule__SecondAbstractRuleChild__Group__3 ;
    public final void rule__SecondAbstractRuleChild__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:558:1: ( rule__SecondAbstractRuleChild__Group__2__Impl rule__SecondAbstractRuleChild__Group__3 )
            // InternalContentAssistTestLanguage.g:559:2: rule__SecondAbstractRuleChild__Group__2__Impl rule__SecondAbstractRuleChild__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__SecondAbstractRuleChild__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondAbstractRuleChild__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__Group__2"


    // $ANTLR start "rule__SecondAbstractRuleChild__Group__2__Impl"
    // InternalContentAssistTestLanguage.g:566:1: rule__SecondAbstractRuleChild__Group__2__Impl : ( ':' ) ;
    public final void rule__SecondAbstractRuleChild__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:570:1: ( ( ':' ) )
            // InternalContentAssistTestLanguage.g:571:1: ( ':' )
            {
            // InternalContentAssistTestLanguage.g:571:1: ( ':' )
            // InternalContentAssistTestLanguage.g:572:1: ':'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__Group__2__Impl"


    // $ANTLR start "rule__SecondAbstractRuleChild__Group__3"
    // InternalContentAssistTestLanguage.g:585:1: rule__SecondAbstractRuleChild__Group__3 : rule__SecondAbstractRuleChild__Group__3__Impl rule__SecondAbstractRuleChild__Group__4 ;
    public final void rule__SecondAbstractRuleChild__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:589:1: ( rule__SecondAbstractRuleChild__Group__3__Impl rule__SecondAbstractRuleChild__Group__4 )
            // InternalContentAssistTestLanguage.g:590:2: rule__SecondAbstractRuleChild__Group__3__Impl rule__SecondAbstractRuleChild__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__SecondAbstractRuleChild__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondAbstractRuleChild__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__Group__3"


    // $ANTLR start "rule__SecondAbstractRuleChild__Group__3__Impl"
    // InternalContentAssistTestLanguage.g:597:1: rule__SecondAbstractRuleChild__Group__3__Impl : ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) ) ;
    public final void rule__SecondAbstractRuleChild__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:601:1: ( ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) ) )
            // InternalContentAssistTestLanguage.g:602:1: ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) )
            {
            // InternalContentAssistTestLanguage.g:602:1: ( ( rule__SecondAbstractRuleChild__RuleAssignment_3 ) )
            // InternalContentAssistTestLanguage.g:603:1: ( rule__SecondAbstractRuleChild__RuleAssignment_3 )
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3()); 
            // InternalContentAssistTestLanguage.g:604:1: ( rule__SecondAbstractRuleChild__RuleAssignment_3 )
            // InternalContentAssistTestLanguage.g:604:2: rule__SecondAbstractRuleChild__RuleAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondAbstractRuleChild__RuleAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__Group__3__Impl"


    // $ANTLR start "rule__SecondAbstractRuleChild__Group__4"
    // InternalContentAssistTestLanguage.g:614:1: rule__SecondAbstractRuleChild__Group__4 : rule__SecondAbstractRuleChild__Group__4__Impl ;
    public final void rule__SecondAbstractRuleChild__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:618:1: ( rule__SecondAbstractRuleChild__Group__4__Impl )
            // InternalContentAssistTestLanguage.g:619:2: rule__SecondAbstractRuleChild__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondAbstractRuleChild__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__Group__4"


    // $ANTLR start "rule__SecondAbstractRuleChild__Group__4__Impl"
    // InternalContentAssistTestLanguage.g:625:1: rule__SecondAbstractRuleChild__Group__4__Impl : ( ';' ) ;
    public final void rule__SecondAbstractRuleChild__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:629:1: ( ( ';' ) )
            // InternalContentAssistTestLanguage.g:630:1: ( ';' )
            {
            // InternalContentAssistTestLanguage.g:630:1: ( ';' )
            // InternalContentAssistTestLanguage.g:631:1: ';'
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getSemicolonKeyword_4()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__Group__4__Impl"


    // $ANTLR start "rule__Start__RulesAssignment_1"
    // InternalContentAssistTestLanguage.g:655:1: rule__Start__RulesAssignment_1 : ( ruleAbstractRule ) ;
    public final void rule__Start__RulesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:659:1: ( ( ruleAbstractRule ) )
            // InternalContentAssistTestLanguage.g:660:1: ( ruleAbstractRule )
            {
            // InternalContentAssistTestLanguage.g:660:1: ( ruleAbstractRule )
            // InternalContentAssistTestLanguage.g:661:1: ruleAbstractRule
            {
             before(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractRule();

            state._fsp--;

             after(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Start__RulesAssignment_1"


    // $ANTLR start "rule__FirstAbstractRuleChild__NameAssignment_0"
    // InternalContentAssistTestLanguage.g:670:1: rule__FirstAbstractRuleChild__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__FirstAbstractRuleChild__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:674:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:675:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:675:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:676:1: RULE_ID
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__NameAssignment_0"


    // $ANTLR start "rule__FirstAbstractRuleChild__ElementsAssignment_2"
    // InternalContentAssistTestLanguage.g:685:1: rule__FirstAbstractRuleChild__ElementsAssignment_2 : ( ruleAbstractRule ) ;
    public final void rule__FirstAbstractRuleChild__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:689:1: ( ( ruleAbstractRule ) )
            // InternalContentAssistTestLanguage.g:690:1: ( ruleAbstractRule )
            {
            // InternalContentAssistTestLanguage.g:690:1: ( ruleAbstractRule )
            // InternalContentAssistTestLanguage.g:691:1: ruleAbstractRule
            {
             before(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractRule();

            state._fsp--;

             after(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstAbstractRuleChild__ElementsAssignment_2"


    // $ANTLR start "rule__SecondAbstractRuleChild__NameAssignment_0"
    // InternalContentAssistTestLanguage.g:700:1: rule__SecondAbstractRuleChild__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SecondAbstractRuleChild__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:704:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:705:1: ( RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:705:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:706:1: RULE_ID
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__NameAssignment_0"


    // $ANTLR start "rule__SecondAbstractRuleChild__RuleAssignment_3"
    // InternalContentAssistTestLanguage.g:715:1: rule__SecondAbstractRuleChild__RuleAssignment_3 : ( ruleAbstractRuleCall ) ;
    public final void rule__SecondAbstractRuleChild__RuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:719:1: ( ( ruleAbstractRuleCall ) )
            // InternalContentAssistTestLanguage.g:720:1: ( ruleAbstractRuleCall )
            {
            // InternalContentAssistTestLanguage.g:720:1: ( ruleAbstractRuleCall )
            // InternalContentAssistTestLanguage.g:721:1: ruleAbstractRuleCall
            {
             before(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractRuleCall();

            state._fsp--;

             after(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondAbstractRuleChild__RuleAssignment_3"


    // $ANTLR start "rule__AbstractRuleCall__RuleAssignment"
    // InternalContentAssistTestLanguage.g:730:1: rule__AbstractRuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__AbstractRuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistTestLanguage.g:734:1: ( ( ( RULE_ID ) ) )
            // InternalContentAssistTestLanguage.g:735:1: ( ( RULE_ID ) )
            {
            // InternalContentAssistTestLanguage.g:735:1: ( ( RULE_ID ) )
            // InternalContentAssistTestLanguage.g:736:1: ( RULE_ID )
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // InternalContentAssistTestLanguage.g:737:1: ( RULE_ID )
            // InternalContentAssistTestLanguage.g:738:1: RULE_ID
            {
             before(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractRuleCall__RuleAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    }


}
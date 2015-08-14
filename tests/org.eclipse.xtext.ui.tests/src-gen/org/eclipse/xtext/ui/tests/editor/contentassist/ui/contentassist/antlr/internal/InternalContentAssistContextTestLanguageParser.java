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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistContextTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistContextTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'A1'", "'A2'", "'B1'", "'B2'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
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


        public InternalContentAssistContextTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistContextTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistContextTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistContextTestLanguage.g"; }


     
     	private ContentAssistContextTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ContentAssistContextTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleFirstLevel"
    // InternalContentAssistContextTestLanguage.g:60:1: entryRuleFirstLevel : ruleFirstLevel EOF ;
    public final void entryRuleFirstLevel() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:61:1: ( ruleFirstLevel EOF )
            // InternalContentAssistContextTestLanguage.g:62:1: ruleFirstLevel EOF
            {
             before(grammarAccess.getFirstLevelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFirstLevel();

            state._fsp--;

             after(grammarAccess.getFirstLevelRule()); 
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
    // $ANTLR end "entryRuleFirstLevel"


    // $ANTLR start "ruleFirstLevel"
    // InternalContentAssistContextTestLanguage.g:69:1: ruleFirstLevel : ( ( rule__FirstLevel__Group__0 ) ) ;
    public final void ruleFirstLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:73:2: ( ( ( rule__FirstLevel__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:74:1: ( ( rule__FirstLevel__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:74:1: ( ( rule__FirstLevel__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:75:1: ( rule__FirstLevel__Group__0 )
            {
             before(grammarAccess.getFirstLevelAccess().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:76:1: ( rule__FirstLevel__Group__0 )
            // InternalContentAssistContextTestLanguage.g:76:2: rule__FirstLevel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstLevel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFirstLevelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFirstLevel"


    // $ANTLR start "entryRuleSecondLevelA"
    // InternalContentAssistContextTestLanguage.g:88:1: entryRuleSecondLevelA : ruleSecondLevelA EOF ;
    public final void entryRuleSecondLevelA() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:89:1: ( ruleSecondLevelA EOF )
            // InternalContentAssistContextTestLanguage.g:90:1: ruleSecondLevelA EOF
            {
             before(grammarAccess.getSecondLevelARule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSecondLevelA();

            state._fsp--;

             after(grammarAccess.getSecondLevelARule()); 
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
    // $ANTLR end "entryRuleSecondLevelA"


    // $ANTLR start "ruleSecondLevelA"
    // InternalContentAssistContextTestLanguage.g:97:1: ruleSecondLevelA : ( ( rule__SecondLevelA__Group__0 ) ) ;
    public final void ruleSecondLevelA() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:101:2: ( ( ( rule__SecondLevelA__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:102:1: ( ( rule__SecondLevelA__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:102:1: ( ( rule__SecondLevelA__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:103:1: ( rule__SecondLevelA__Group__0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:104:1: ( rule__SecondLevelA__Group__0 )
            // InternalContentAssistContextTestLanguage.g:104:2: rule__SecondLevelA__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelA__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSecondLevelA"


    // $ANTLR start "entryRuleSecondLevelB"
    // InternalContentAssistContextTestLanguage.g:116:1: entryRuleSecondLevelB : ruleSecondLevelB EOF ;
    public final void entryRuleSecondLevelB() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:117:1: ( ruleSecondLevelB EOF )
            // InternalContentAssistContextTestLanguage.g:118:1: ruleSecondLevelB EOF
            {
             before(grammarAccess.getSecondLevelBRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSecondLevelB();

            state._fsp--;

             after(grammarAccess.getSecondLevelBRule()); 
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
    // $ANTLR end "entryRuleSecondLevelB"


    // $ANTLR start "ruleSecondLevelB"
    // InternalContentAssistContextTestLanguage.g:125:1: ruleSecondLevelB : ( ( rule__SecondLevelB__Group__0 ) ) ;
    public final void ruleSecondLevelB() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:129:2: ( ( ( rule__SecondLevelB__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:130:1: ( ( rule__SecondLevelB__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:130:1: ( ( rule__SecondLevelB__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:131:1: ( rule__SecondLevelB__Group__0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:132:1: ( rule__SecondLevelB__Group__0 )
            // InternalContentAssistContextTestLanguage.g:132:2: rule__SecondLevelB__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelB__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSecondLevelB"


    // $ANTLR start "entryRuleThirdLevelA1"
    // InternalContentAssistContextTestLanguage.g:144:1: entryRuleThirdLevelA1 : ruleThirdLevelA1 EOF ;
    public final void entryRuleThirdLevelA1() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:145:1: ( ruleThirdLevelA1 EOF )
            // InternalContentAssistContextTestLanguage.g:146:1: ruleThirdLevelA1 EOF
            {
             before(grammarAccess.getThirdLevelA1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleThirdLevelA1();

            state._fsp--;

             after(grammarAccess.getThirdLevelA1Rule()); 
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
    // $ANTLR end "entryRuleThirdLevelA1"


    // $ANTLR start "ruleThirdLevelA1"
    // InternalContentAssistContextTestLanguage.g:153:1: ruleThirdLevelA1 : ( ( rule__ThirdLevelA1__Group__0 ) ) ;
    public final void ruleThirdLevelA1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:157:2: ( ( ( rule__ThirdLevelA1__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:158:1: ( ( rule__ThirdLevelA1__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:158:1: ( ( rule__ThirdLevelA1__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:159:1: ( rule__ThirdLevelA1__Group__0 )
            {
             before(grammarAccess.getThirdLevelA1Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:160:1: ( rule__ThirdLevelA1__Group__0 )
            // InternalContentAssistContextTestLanguage.g:160:2: rule__ThirdLevelA1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThirdLevelA1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleThirdLevelA1"


    // $ANTLR start "entryRuleThirdLevelA2"
    // InternalContentAssistContextTestLanguage.g:172:1: entryRuleThirdLevelA2 : ruleThirdLevelA2 EOF ;
    public final void entryRuleThirdLevelA2() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:173:1: ( ruleThirdLevelA2 EOF )
            // InternalContentAssistContextTestLanguage.g:174:1: ruleThirdLevelA2 EOF
            {
             before(grammarAccess.getThirdLevelA2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleThirdLevelA2();

            state._fsp--;

             after(grammarAccess.getThirdLevelA2Rule()); 
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
    // $ANTLR end "entryRuleThirdLevelA2"


    // $ANTLR start "ruleThirdLevelA2"
    // InternalContentAssistContextTestLanguage.g:181:1: ruleThirdLevelA2 : ( ( rule__ThirdLevelA2__Group__0 ) ) ;
    public final void ruleThirdLevelA2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:185:2: ( ( ( rule__ThirdLevelA2__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:186:1: ( ( rule__ThirdLevelA2__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:186:1: ( ( rule__ThirdLevelA2__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:187:1: ( rule__ThirdLevelA2__Group__0 )
            {
             before(grammarAccess.getThirdLevelA2Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:188:1: ( rule__ThirdLevelA2__Group__0 )
            // InternalContentAssistContextTestLanguage.g:188:2: rule__ThirdLevelA2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThirdLevelA2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleThirdLevelA2"


    // $ANTLR start "entryRuleThirdLevelB1"
    // InternalContentAssistContextTestLanguage.g:200:1: entryRuleThirdLevelB1 : ruleThirdLevelB1 EOF ;
    public final void entryRuleThirdLevelB1() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:201:1: ( ruleThirdLevelB1 EOF )
            // InternalContentAssistContextTestLanguage.g:202:1: ruleThirdLevelB1 EOF
            {
             before(grammarAccess.getThirdLevelB1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleThirdLevelB1();

            state._fsp--;

             after(grammarAccess.getThirdLevelB1Rule()); 
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
    // $ANTLR end "entryRuleThirdLevelB1"


    // $ANTLR start "ruleThirdLevelB1"
    // InternalContentAssistContextTestLanguage.g:209:1: ruleThirdLevelB1 : ( ( rule__ThirdLevelB1__Group__0 ) ) ;
    public final void ruleThirdLevelB1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:213:2: ( ( ( rule__ThirdLevelB1__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:214:1: ( ( rule__ThirdLevelB1__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:214:1: ( ( rule__ThirdLevelB1__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:215:1: ( rule__ThirdLevelB1__Group__0 )
            {
             before(grammarAccess.getThirdLevelB1Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:216:1: ( rule__ThirdLevelB1__Group__0 )
            // InternalContentAssistContextTestLanguage.g:216:2: rule__ThirdLevelB1__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThirdLevelB1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleThirdLevelB1"


    // $ANTLR start "entryRuleThirdLevelB2"
    // InternalContentAssistContextTestLanguage.g:228:1: entryRuleThirdLevelB2 : ruleThirdLevelB2 EOF ;
    public final void entryRuleThirdLevelB2() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:229:1: ( ruleThirdLevelB2 EOF )
            // InternalContentAssistContextTestLanguage.g:230:1: ruleThirdLevelB2 EOF
            {
             before(grammarAccess.getThirdLevelB2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleThirdLevelB2();

            state._fsp--;

             after(grammarAccess.getThirdLevelB2Rule()); 
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
    // $ANTLR end "entryRuleThirdLevelB2"


    // $ANTLR start "ruleThirdLevelB2"
    // InternalContentAssistContextTestLanguage.g:237:1: ruleThirdLevelB2 : ( ( rule__ThirdLevelB2__Group__0 ) ) ;
    public final void ruleThirdLevelB2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:241:2: ( ( ( rule__ThirdLevelB2__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:242:1: ( ( rule__ThirdLevelB2__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:242:1: ( ( rule__ThirdLevelB2__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:243:1: ( rule__ThirdLevelB2__Group__0 )
            {
             before(grammarAccess.getThirdLevelB2Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:244:1: ( rule__ThirdLevelB2__Group__0 )
            // InternalContentAssistContextTestLanguage.g:244:2: rule__ThirdLevelB2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThirdLevelB2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleThirdLevelB2"


    // $ANTLR start "rule__FirstLevel__Group__0"
    // InternalContentAssistContextTestLanguage.g:258:1: rule__FirstLevel__Group__0 : rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1 ;
    public final void rule__FirstLevel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:262:1: ( rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1 )
            // InternalContentAssistContextTestLanguage.g:263:2: rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__FirstLevel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstLevel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstLevel__Group__0"


    // $ANTLR start "rule__FirstLevel__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:270:1: rule__FirstLevel__Group__0__Impl : ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) ;
    public final void rule__FirstLevel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:274:1: ( ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) )
            // InternalContentAssistContextTestLanguage.g:275:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* )
            {
            // InternalContentAssistContextTestLanguage.g:275:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* )
            // InternalContentAssistContextTestLanguage.g:276:1: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 
            // InternalContentAssistContextTestLanguage.g:277:1: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:277:2: rule__FirstLevel__SecondLevelAAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__FirstLevel__SecondLevelAAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstLevel__Group__0__Impl"


    // $ANTLR start "rule__FirstLevel__Group__1"
    // InternalContentAssistContextTestLanguage.g:287:1: rule__FirstLevel__Group__1 : rule__FirstLevel__Group__1__Impl ;
    public final void rule__FirstLevel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:291:1: ( rule__FirstLevel__Group__1__Impl )
            // InternalContentAssistContextTestLanguage.g:292:2: rule__FirstLevel__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstLevel__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstLevel__Group__1"


    // $ANTLR start "rule__FirstLevel__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:298:1: rule__FirstLevel__Group__1__Impl : ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) ;
    public final void rule__FirstLevel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:302:1: ( ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) )
            // InternalContentAssistContextTestLanguage.g:303:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            {
            // InternalContentAssistContextTestLanguage.g:303:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            // InternalContentAssistContextTestLanguage.g:304:1: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1()); 
            // InternalContentAssistContextTestLanguage.g:305:1: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:305:2: rule__FirstLevel__SecondLevelBAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__FirstLevel__SecondLevelBAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstLevel__Group__1__Impl"


    // $ANTLR start "rule__SecondLevelA__Group__0"
    // InternalContentAssistContextTestLanguage.g:319:1: rule__SecondLevelA__Group__0 : rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1 ;
    public final void rule__SecondLevelA__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:323:1: ( rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1 )
            // InternalContentAssistContextTestLanguage.g:324:2: rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__SecondLevelA__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelA__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondLevelA__Group__0"


    // $ANTLR start "rule__SecondLevelA__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:331:1: rule__SecondLevelA__Group__0__Impl : ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) ;
    public final void rule__SecondLevelA__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:335:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:336:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:336:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) )
            // InternalContentAssistContextTestLanguage.g:337:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            {
            // InternalContentAssistContextTestLanguage.g:337:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) )
            // InternalContentAssistContextTestLanguage.g:338:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:339:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            // InternalContentAssistContextTestLanguage.g:339:2: rule__SecondLevelA__ThirdLevelA1Assignment_0
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__SecondLevelA__ThirdLevelA1Assignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 

            }

            // InternalContentAssistContextTestLanguage.g:342:1: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            // InternalContentAssistContextTestLanguage.g:343:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:344:1: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:344:2: rule__SecondLevelA__ThirdLevelA1Assignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__SecondLevelA__ThirdLevelA1Assignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 

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
    // $ANTLR end "rule__SecondLevelA__Group__0__Impl"


    // $ANTLR start "rule__SecondLevelA__Group__1"
    // InternalContentAssistContextTestLanguage.g:355:1: rule__SecondLevelA__Group__1 : rule__SecondLevelA__Group__1__Impl ;
    public final void rule__SecondLevelA__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:359:1: ( rule__SecondLevelA__Group__1__Impl )
            // InternalContentAssistContextTestLanguage.g:360:2: rule__SecondLevelA__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelA__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondLevelA__Group__1"


    // $ANTLR start "rule__SecondLevelA__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:366:1: rule__SecondLevelA__Group__1__Impl : ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelA__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:370:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:371:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:371:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            // InternalContentAssistContextTestLanguage.g:372:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            {
            // InternalContentAssistContextTestLanguage.g:372:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) )
            // InternalContentAssistContextTestLanguage.g:373:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:374:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            // InternalContentAssistContextTestLanguage.g:374:2: rule__SecondLevelA__ThirdLevelA2Assignment_1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__SecondLevelA__ThirdLevelA2Assignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 

            }

            // InternalContentAssistContextTestLanguage.g:377:1: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            // InternalContentAssistContextTestLanguage.g:378:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:379:1: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:379:2: rule__SecondLevelA__ThirdLevelA2Assignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__SecondLevelA__ThirdLevelA2Assignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 

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
    // $ANTLR end "rule__SecondLevelA__Group__1__Impl"


    // $ANTLR start "rule__SecondLevelB__Group__0"
    // InternalContentAssistContextTestLanguage.g:394:1: rule__SecondLevelB__Group__0 : rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1 ;
    public final void rule__SecondLevelB__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:398:1: ( rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1 )
            // InternalContentAssistContextTestLanguage.g:399:2: rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__SecondLevelB__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelB__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondLevelB__Group__0"


    // $ANTLR start "rule__SecondLevelB__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:406:1: rule__SecondLevelB__Group__0__Impl : ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) ;
    public final void rule__SecondLevelB__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:410:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:411:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:411:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) )
            // InternalContentAssistContextTestLanguage.g:412:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            {
            // InternalContentAssistContextTestLanguage.g:412:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) )
            // InternalContentAssistContextTestLanguage.g:413:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:414:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            // InternalContentAssistContextTestLanguage.g:414:2: rule__SecondLevelB__ThirdLevelB1Assignment_0
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__SecondLevelB__ThirdLevelB1Assignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 

            }

            // InternalContentAssistContextTestLanguage.g:417:1: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            // InternalContentAssistContextTestLanguage.g:418:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:419:1: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:419:2: rule__SecondLevelB__ThirdLevelB1Assignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__SecondLevelB__ThirdLevelB1Assignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 

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
    // $ANTLR end "rule__SecondLevelB__Group__0__Impl"


    // $ANTLR start "rule__SecondLevelB__Group__1"
    // InternalContentAssistContextTestLanguage.g:430:1: rule__SecondLevelB__Group__1 : rule__SecondLevelB__Group__1__Impl ;
    public final void rule__SecondLevelB__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:434:1: ( rule__SecondLevelB__Group__1__Impl )
            // InternalContentAssistContextTestLanguage.g:435:2: rule__SecondLevelB__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SecondLevelB__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondLevelB__Group__1"


    // $ANTLR start "rule__SecondLevelB__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:441:1: rule__SecondLevelB__Group__1__Impl : ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelB__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:445:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:446:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:446:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            // InternalContentAssistContextTestLanguage.g:447:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            {
            // InternalContentAssistContextTestLanguage.g:447:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) )
            // InternalContentAssistContextTestLanguage.g:448:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:449:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            // InternalContentAssistContextTestLanguage.g:449:2: rule__SecondLevelB__ThirdLevelB2Assignment_1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__SecondLevelB__ThirdLevelB2Assignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 

            }

            // InternalContentAssistContextTestLanguage.g:452:1: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            // InternalContentAssistContextTestLanguage.g:453:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:454:1: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:454:2: rule__SecondLevelB__ThirdLevelB2Assignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    rule__SecondLevelB__ThirdLevelB2Assignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 

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
    // $ANTLR end "rule__SecondLevelB__Group__1__Impl"


    // $ANTLR start "rule__ThirdLevelA1__Group__0"
    // InternalContentAssistContextTestLanguage.g:469:1: rule__ThirdLevelA1__Group__0 : rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1 ;
    public final void rule__ThirdLevelA1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:473:1: ( rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1 )
            // InternalContentAssistContextTestLanguage.g:474:2: rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelA1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA1__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA1__Group__0"


    // $ANTLR start "rule__ThirdLevelA1__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:481:1: rule__ThirdLevelA1__Group__0__Impl : ( 'A1' ) ;
    public final void rule__ThirdLevelA1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:485:1: ( ( 'A1' ) )
            // InternalContentAssistContextTestLanguage.g:486:1: ( 'A1' )
            {
            // InternalContentAssistContextTestLanguage.g:486:1: ( 'A1' )
            // InternalContentAssistContextTestLanguage.g:487:1: 'A1'
            {
             before(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelA1Access().getA1Keyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA1__Group__0__Impl"


    // $ANTLR start "rule__ThirdLevelA1__Group__1"
    // InternalContentAssistContextTestLanguage.g:500:1: rule__ThirdLevelA1__Group__1 : rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2 ;
    public final void rule__ThirdLevelA1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:504:1: ( rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2 )
            // InternalContentAssistContextTestLanguage.g:505:2: rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelA1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA1__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA1__Group__1"


    // $ANTLR start "rule__ThirdLevelA1__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:512:1: rule__ThirdLevelA1__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelA1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:516:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:517:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:517:1: ( () )
            // InternalContentAssistContextTestLanguage.g:518:1: ()
            {
             before(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 
            // InternalContentAssistContextTestLanguage.g:519:1: ()
            // InternalContentAssistContextTestLanguage.g:521:1: 
            {
            }

             after(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA1__Group__1__Impl"


    // $ANTLR start "rule__ThirdLevelA1__Group__2"
    // InternalContentAssistContextTestLanguage.g:531:1: rule__ThirdLevelA1__Group__2 : rule__ThirdLevelA1__Group__2__Impl ;
    public final void rule__ThirdLevelA1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:535:1: ( rule__ThirdLevelA1__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:536:2: rule__ThirdLevelA1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA1__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA1__Group__2"


    // $ANTLR start "rule__ThirdLevelA1__Group__2__Impl"
    // InternalContentAssistContextTestLanguage.g:542:1: rule__ThirdLevelA1__Group__2__Impl : ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:546:1: ( ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:547:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:547:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:548:1: ( rule__ThirdLevelA1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA1Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:549:1: ( rule__ThirdLevelA1__NameAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:549:2: rule__ThirdLevelA1__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ThirdLevelA1__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelA1Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA1__Group__2__Impl"


    // $ANTLR start "rule__ThirdLevelA2__Group__0"
    // InternalContentAssistContextTestLanguage.g:565:1: rule__ThirdLevelA2__Group__0 : rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1 ;
    public final void rule__ThirdLevelA2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:569:1: ( rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1 )
            // InternalContentAssistContextTestLanguage.g:570:2: rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelA2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA2__Group__0"


    // $ANTLR start "rule__ThirdLevelA2__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:577:1: rule__ThirdLevelA2__Group__0__Impl : ( 'A2' ) ;
    public final void rule__ThirdLevelA2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:581:1: ( ( 'A2' ) )
            // InternalContentAssistContextTestLanguage.g:582:1: ( 'A2' )
            {
            // InternalContentAssistContextTestLanguage.g:582:1: ( 'A2' )
            // InternalContentAssistContextTestLanguage.g:583:1: 'A2'
            {
             before(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelA2Access().getA2Keyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA2__Group__0__Impl"


    // $ANTLR start "rule__ThirdLevelA2__Group__1"
    // InternalContentAssistContextTestLanguage.g:596:1: rule__ThirdLevelA2__Group__1 : rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2 ;
    public final void rule__ThirdLevelA2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:600:1: ( rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2 )
            // InternalContentAssistContextTestLanguage.g:601:2: rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelA2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA2__Group__1"


    // $ANTLR start "rule__ThirdLevelA2__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:608:1: rule__ThirdLevelA2__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelA2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:612:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:613:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:613:1: ( () )
            // InternalContentAssistContextTestLanguage.g:614:1: ()
            {
             before(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 
            // InternalContentAssistContextTestLanguage.g:615:1: ()
            // InternalContentAssistContextTestLanguage.g:617:1: 
            {
            }

             after(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA2__Group__1__Impl"


    // $ANTLR start "rule__ThirdLevelA2__Group__2"
    // InternalContentAssistContextTestLanguage.g:627:1: rule__ThirdLevelA2__Group__2 : rule__ThirdLevelA2__Group__2__Impl ;
    public final void rule__ThirdLevelA2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:631:1: ( rule__ThirdLevelA2__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:632:2: rule__ThirdLevelA2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelA2__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA2__Group__2"


    // $ANTLR start "rule__ThirdLevelA2__Group__2__Impl"
    // InternalContentAssistContextTestLanguage.g:638:1: rule__ThirdLevelA2__Group__2__Impl : ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:642:1: ( ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:643:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:643:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:644:1: ( rule__ThirdLevelA2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA2Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:645:1: ( rule__ThirdLevelA2__NameAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:645:2: rule__ThirdLevelA2__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ThirdLevelA2__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelA2Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA2__Group__2__Impl"


    // $ANTLR start "rule__ThirdLevelB1__Group__0"
    // InternalContentAssistContextTestLanguage.g:661:1: rule__ThirdLevelB1__Group__0 : rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1 ;
    public final void rule__ThirdLevelB1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:665:1: ( rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1 )
            // InternalContentAssistContextTestLanguage.g:666:2: rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelB1__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB1__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB1__Group__0"


    // $ANTLR start "rule__ThirdLevelB1__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:673:1: rule__ThirdLevelB1__Group__0__Impl : ( 'B1' ) ;
    public final void rule__ThirdLevelB1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:677:1: ( ( 'B1' ) )
            // InternalContentAssistContextTestLanguage.g:678:1: ( 'B1' )
            {
            // InternalContentAssistContextTestLanguage.g:678:1: ( 'B1' )
            // InternalContentAssistContextTestLanguage.g:679:1: 'B1'
            {
             before(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelB1Access().getB1Keyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB1__Group__0__Impl"


    // $ANTLR start "rule__ThirdLevelB1__Group__1"
    // InternalContentAssistContextTestLanguage.g:692:1: rule__ThirdLevelB1__Group__1 : rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2 ;
    public final void rule__ThirdLevelB1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:696:1: ( rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2 )
            // InternalContentAssistContextTestLanguage.g:697:2: rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelB1__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB1__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB1__Group__1"


    // $ANTLR start "rule__ThirdLevelB1__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:704:1: rule__ThirdLevelB1__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelB1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:708:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:709:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:709:1: ( () )
            // InternalContentAssistContextTestLanguage.g:710:1: ()
            {
             before(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 
            // InternalContentAssistContextTestLanguage.g:711:1: ()
            // InternalContentAssistContextTestLanguage.g:713:1: 
            {
            }

             after(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB1__Group__1__Impl"


    // $ANTLR start "rule__ThirdLevelB1__Group__2"
    // InternalContentAssistContextTestLanguage.g:723:1: rule__ThirdLevelB1__Group__2 : rule__ThirdLevelB1__Group__2__Impl ;
    public final void rule__ThirdLevelB1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:727:1: ( rule__ThirdLevelB1__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:728:2: rule__ThirdLevelB1__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB1__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB1__Group__2"


    // $ANTLR start "rule__ThirdLevelB1__Group__2__Impl"
    // InternalContentAssistContextTestLanguage.g:734:1: rule__ThirdLevelB1__Group__2__Impl : ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:738:1: ( ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:739:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:739:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:740:1: ( rule__ThirdLevelB1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB1Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:741:1: ( rule__ThirdLevelB1__NameAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:741:2: rule__ThirdLevelB1__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ThirdLevelB1__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelB1Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB1__Group__2__Impl"


    // $ANTLR start "rule__ThirdLevelB2__Group__0"
    // InternalContentAssistContextTestLanguage.g:757:1: rule__ThirdLevelB2__Group__0 : rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1 ;
    public final void rule__ThirdLevelB2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:761:1: ( rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1 )
            // InternalContentAssistContextTestLanguage.g:762:2: rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelB2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB2__Group__0"


    // $ANTLR start "rule__ThirdLevelB2__Group__0__Impl"
    // InternalContentAssistContextTestLanguage.g:769:1: rule__ThirdLevelB2__Group__0__Impl : ( 'B2' ) ;
    public final void rule__ThirdLevelB2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:773:1: ( ( 'B2' ) )
            // InternalContentAssistContextTestLanguage.g:774:1: ( 'B2' )
            {
            // InternalContentAssistContextTestLanguage.g:774:1: ( 'B2' )
            // InternalContentAssistContextTestLanguage.g:775:1: 'B2'
            {
             before(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelB2Access().getB2Keyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB2__Group__0__Impl"


    // $ANTLR start "rule__ThirdLevelB2__Group__1"
    // InternalContentAssistContextTestLanguage.g:788:1: rule__ThirdLevelB2__Group__1 : rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2 ;
    public final void rule__ThirdLevelB2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:792:1: ( rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2 )
            // InternalContentAssistContextTestLanguage.g:793:2: rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ThirdLevelB2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB2__Group__1"


    // $ANTLR start "rule__ThirdLevelB2__Group__1__Impl"
    // InternalContentAssistContextTestLanguage.g:800:1: rule__ThirdLevelB2__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelB2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:804:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:805:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:805:1: ( () )
            // InternalContentAssistContextTestLanguage.g:806:1: ()
            {
             before(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 
            // InternalContentAssistContextTestLanguage.g:807:1: ()
            // InternalContentAssistContextTestLanguage.g:809:1: 
            {
            }

             after(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB2__Group__1__Impl"


    // $ANTLR start "rule__ThirdLevelB2__Group__2"
    // InternalContentAssistContextTestLanguage.g:819:1: rule__ThirdLevelB2__Group__2 : rule__ThirdLevelB2__Group__2__Impl ;
    public final void rule__ThirdLevelB2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:823:1: ( rule__ThirdLevelB2__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:824:2: rule__ThirdLevelB2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ThirdLevelB2__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB2__Group__2"


    // $ANTLR start "rule__ThirdLevelB2__Group__2__Impl"
    // InternalContentAssistContextTestLanguage.g:830:1: rule__ThirdLevelB2__Group__2__Impl : ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:834:1: ( ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:835:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:835:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:836:1: ( rule__ThirdLevelB2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB2Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:837:1: ( rule__ThirdLevelB2__NameAssignment_2 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:837:2: rule__ThirdLevelB2__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ThirdLevelB2__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThirdLevelB2Access().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB2__Group__2__Impl"


    // $ANTLR start "rule__FirstLevel__SecondLevelAAssignment_0"
    // InternalContentAssistContextTestLanguage.g:854:1: rule__FirstLevel__SecondLevelAAssignment_0 : ( ruleSecondLevelA ) ;
    public final void rule__FirstLevel__SecondLevelAAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:858:1: ( ( ruleSecondLevelA ) )
            // InternalContentAssistContextTestLanguage.g:859:1: ( ruleSecondLevelA )
            {
            // InternalContentAssistContextTestLanguage.g:859:1: ( ruleSecondLevelA )
            // InternalContentAssistContextTestLanguage.g:860:1: ruleSecondLevelA
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSecondLevelA();

            state._fsp--;

             after(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstLevel__SecondLevelAAssignment_0"


    // $ANTLR start "rule__FirstLevel__SecondLevelBAssignment_1"
    // InternalContentAssistContextTestLanguage.g:869:1: rule__FirstLevel__SecondLevelBAssignment_1 : ( ruleSecondLevelB ) ;
    public final void rule__FirstLevel__SecondLevelBAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:873:1: ( ( ruleSecondLevelB ) )
            // InternalContentAssistContextTestLanguage.g:874:1: ( ruleSecondLevelB )
            {
            // InternalContentAssistContextTestLanguage.g:874:1: ( ruleSecondLevelB )
            // InternalContentAssistContextTestLanguage.g:875:1: ruleSecondLevelB
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSecondLevelB();

            state._fsp--;

             after(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstLevel__SecondLevelBAssignment_1"


    // $ANTLR start "rule__SecondLevelA__ThirdLevelA1Assignment_0"
    // InternalContentAssistContextTestLanguage.g:884:1: rule__SecondLevelA__ThirdLevelA1Assignment_0 : ( ruleThirdLevelA1 ) ;
    public final void rule__SecondLevelA__ThirdLevelA1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:888:1: ( ( ruleThirdLevelA1 ) )
            // InternalContentAssistContextTestLanguage.g:889:1: ( ruleThirdLevelA1 )
            {
            // InternalContentAssistContextTestLanguage.g:889:1: ( ruleThirdLevelA1 )
            // InternalContentAssistContextTestLanguage.g:890:1: ruleThirdLevelA1
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleThirdLevelA1();

            state._fsp--;

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondLevelA__ThirdLevelA1Assignment_0"


    // $ANTLR start "rule__SecondLevelA__ThirdLevelA2Assignment_1"
    // InternalContentAssistContextTestLanguage.g:899:1: rule__SecondLevelA__ThirdLevelA2Assignment_1 : ( ruleThirdLevelA2 ) ;
    public final void rule__SecondLevelA__ThirdLevelA2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:903:1: ( ( ruleThirdLevelA2 ) )
            // InternalContentAssistContextTestLanguage.g:904:1: ( ruleThirdLevelA2 )
            {
            // InternalContentAssistContextTestLanguage.g:904:1: ( ruleThirdLevelA2 )
            // InternalContentAssistContextTestLanguage.g:905:1: ruleThirdLevelA2
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleThirdLevelA2();

            state._fsp--;

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondLevelA__ThirdLevelA2Assignment_1"


    // $ANTLR start "rule__SecondLevelB__ThirdLevelB1Assignment_0"
    // InternalContentAssistContextTestLanguage.g:914:1: rule__SecondLevelB__ThirdLevelB1Assignment_0 : ( ruleThirdLevelB1 ) ;
    public final void rule__SecondLevelB__ThirdLevelB1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:918:1: ( ( ruleThirdLevelB1 ) )
            // InternalContentAssistContextTestLanguage.g:919:1: ( ruleThirdLevelB1 )
            {
            // InternalContentAssistContextTestLanguage.g:919:1: ( ruleThirdLevelB1 )
            // InternalContentAssistContextTestLanguage.g:920:1: ruleThirdLevelB1
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleThirdLevelB1();

            state._fsp--;

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondLevelB__ThirdLevelB1Assignment_0"


    // $ANTLR start "rule__SecondLevelB__ThirdLevelB2Assignment_1"
    // InternalContentAssistContextTestLanguage.g:929:1: rule__SecondLevelB__ThirdLevelB2Assignment_1 : ( ruleThirdLevelB2 ) ;
    public final void rule__SecondLevelB__ThirdLevelB2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:933:1: ( ( ruleThirdLevelB2 ) )
            // InternalContentAssistContextTestLanguage.g:934:1: ( ruleThirdLevelB2 )
            {
            // InternalContentAssistContextTestLanguage.g:934:1: ( ruleThirdLevelB2 )
            // InternalContentAssistContextTestLanguage.g:935:1: ruleThirdLevelB2
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleThirdLevelB2();

            state._fsp--;

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecondLevelB__ThirdLevelB2Assignment_1"


    // $ANTLR start "rule__ThirdLevelA1__NameAssignment_2"
    // InternalContentAssistContextTestLanguage.g:944:1: rule__ThirdLevelA1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:948:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:949:1: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:949:1: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:950:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA1__NameAssignment_2"


    // $ANTLR start "rule__ThirdLevelA2__NameAssignment_2"
    // InternalContentAssistContextTestLanguage.g:959:1: rule__ThirdLevelA2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:963:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:964:1: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:964:1: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:965:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelA2__NameAssignment_2"


    // $ANTLR start "rule__ThirdLevelB1__NameAssignment_2"
    // InternalContentAssistContextTestLanguage.g:974:1: rule__ThirdLevelB1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:978:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:979:1: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:979:1: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:980:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB1__NameAssignment_2"


    // $ANTLR start "rule__ThirdLevelB2__NameAssignment_2"
    // InternalContentAssistContextTestLanguage.g:989:1: rule__ThirdLevelB2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalContentAssistContextTestLanguage.g:993:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:994:1: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:994:1: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:995:1: RULE_ID
            {
             before(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThirdLevelB2__NameAssignment_2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000010L});
    }


}
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

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
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

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
    // InternalContentAssistContextTestLanguage.g:53:1: entryRuleFirstLevel : ruleFirstLevel EOF ;
    public final void entryRuleFirstLevel() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:54:1: ( ruleFirstLevel EOF )
            // InternalContentAssistContextTestLanguage.g:55:1: ruleFirstLevel EOF
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
    // InternalContentAssistContextTestLanguage.g:62:1: ruleFirstLevel : ( ( rule__FirstLevel__Group__0 ) ) ;
    public final void ruleFirstLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:66:2: ( ( ( rule__FirstLevel__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:67:2: ( ( rule__FirstLevel__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:67:2: ( ( rule__FirstLevel__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:68:3: ( rule__FirstLevel__Group__0 )
            {
             before(grammarAccess.getFirstLevelAccess().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:69:3: ( rule__FirstLevel__Group__0 )
            // InternalContentAssistContextTestLanguage.g:69:4: rule__FirstLevel__Group__0
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
    // InternalContentAssistContextTestLanguage.g:78:1: entryRuleSecondLevelA : ruleSecondLevelA EOF ;
    public final void entryRuleSecondLevelA() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:79:1: ( ruleSecondLevelA EOF )
            // InternalContentAssistContextTestLanguage.g:80:1: ruleSecondLevelA EOF
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
    // InternalContentAssistContextTestLanguage.g:87:1: ruleSecondLevelA : ( ( rule__SecondLevelA__Group__0 ) ) ;
    public final void ruleSecondLevelA() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:91:2: ( ( ( rule__SecondLevelA__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:92:2: ( ( rule__SecondLevelA__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:92:2: ( ( rule__SecondLevelA__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:93:3: ( rule__SecondLevelA__Group__0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:94:3: ( rule__SecondLevelA__Group__0 )
            // InternalContentAssistContextTestLanguage.g:94:4: rule__SecondLevelA__Group__0
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
    // InternalContentAssistContextTestLanguage.g:103:1: entryRuleSecondLevelB : ruleSecondLevelB EOF ;
    public final void entryRuleSecondLevelB() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:104:1: ( ruleSecondLevelB EOF )
            // InternalContentAssistContextTestLanguage.g:105:1: ruleSecondLevelB EOF
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
    // InternalContentAssistContextTestLanguage.g:112:1: ruleSecondLevelB : ( ( rule__SecondLevelB__Group__0 ) ) ;
    public final void ruleSecondLevelB() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:116:2: ( ( ( rule__SecondLevelB__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:117:2: ( ( rule__SecondLevelB__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:117:2: ( ( rule__SecondLevelB__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:118:3: ( rule__SecondLevelB__Group__0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:119:3: ( rule__SecondLevelB__Group__0 )
            // InternalContentAssistContextTestLanguage.g:119:4: rule__SecondLevelB__Group__0
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
    // InternalContentAssistContextTestLanguage.g:128:1: entryRuleThirdLevelA1 : ruleThirdLevelA1 EOF ;
    public final void entryRuleThirdLevelA1() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:129:1: ( ruleThirdLevelA1 EOF )
            // InternalContentAssistContextTestLanguage.g:130:1: ruleThirdLevelA1 EOF
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
    // InternalContentAssistContextTestLanguage.g:137:1: ruleThirdLevelA1 : ( ( rule__ThirdLevelA1__Group__0 ) ) ;
    public final void ruleThirdLevelA1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:141:2: ( ( ( rule__ThirdLevelA1__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:142:2: ( ( rule__ThirdLevelA1__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:142:2: ( ( rule__ThirdLevelA1__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:143:3: ( rule__ThirdLevelA1__Group__0 )
            {
             before(grammarAccess.getThirdLevelA1Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:144:3: ( rule__ThirdLevelA1__Group__0 )
            // InternalContentAssistContextTestLanguage.g:144:4: rule__ThirdLevelA1__Group__0
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
    // InternalContentAssistContextTestLanguage.g:153:1: entryRuleThirdLevelA2 : ruleThirdLevelA2 EOF ;
    public final void entryRuleThirdLevelA2() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:154:1: ( ruleThirdLevelA2 EOF )
            // InternalContentAssistContextTestLanguage.g:155:1: ruleThirdLevelA2 EOF
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
    // InternalContentAssistContextTestLanguage.g:162:1: ruleThirdLevelA2 : ( ( rule__ThirdLevelA2__Group__0 ) ) ;
    public final void ruleThirdLevelA2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:166:2: ( ( ( rule__ThirdLevelA2__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:167:2: ( ( rule__ThirdLevelA2__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:167:2: ( ( rule__ThirdLevelA2__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:168:3: ( rule__ThirdLevelA2__Group__0 )
            {
             before(grammarAccess.getThirdLevelA2Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:169:3: ( rule__ThirdLevelA2__Group__0 )
            // InternalContentAssistContextTestLanguage.g:169:4: rule__ThirdLevelA2__Group__0
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
    // InternalContentAssistContextTestLanguage.g:178:1: entryRuleThirdLevelB1 : ruleThirdLevelB1 EOF ;
    public final void entryRuleThirdLevelB1() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:179:1: ( ruleThirdLevelB1 EOF )
            // InternalContentAssistContextTestLanguage.g:180:1: ruleThirdLevelB1 EOF
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
    // InternalContentAssistContextTestLanguage.g:187:1: ruleThirdLevelB1 : ( ( rule__ThirdLevelB1__Group__0 ) ) ;
    public final void ruleThirdLevelB1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:191:2: ( ( ( rule__ThirdLevelB1__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:192:2: ( ( rule__ThirdLevelB1__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:192:2: ( ( rule__ThirdLevelB1__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:193:3: ( rule__ThirdLevelB1__Group__0 )
            {
             before(grammarAccess.getThirdLevelB1Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:194:3: ( rule__ThirdLevelB1__Group__0 )
            // InternalContentAssistContextTestLanguage.g:194:4: rule__ThirdLevelB1__Group__0
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
    // InternalContentAssistContextTestLanguage.g:203:1: entryRuleThirdLevelB2 : ruleThirdLevelB2 EOF ;
    public final void entryRuleThirdLevelB2() throws RecognitionException {
        try {
            // InternalContentAssistContextTestLanguage.g:204:1: ( ruleThirdLevelB2 EOF )
            // InternalContentAssistContextTestLanguage.g:205:1: ruleThirdLevelB2 EOF
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
    // InternalContentAssistContextTestLanguage.g:212:1: ruleThirdLevelB2 : ( ( rule__ThirdLevelB2__Group__0 ) ) ;
    public final void ruleThirdLevelB2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:216:2: ( ( ( rule__ThirdLevelB2__Group__0 ) ) )
            // InternalContentAssistContextTestLanguage.g:217:2: ( ( rule__ThirdLevelB2__Group__0 ) )
            {
            // InternalContentAssistContextTestLanguage.g:217:2: ( ( rule__ThirdLevelB2__Group__0 ) )
            // InternalContentAssistContextTestLanguage.g:218:3: ( rule__ThirdLevelB2__Group__0 )
            {
             before(grammarAccess.getThirdLevelB2Access().getGroup()); 
            // InternalContentAssistContextTestLanguage.g:219:3: ( rule__ThirdLevelB2__Group__0 )
            // InternalContentAssistContextTestLanguage.g:219:4: rule__ThirdLevelB2__Group__0
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
    // InternalContentAssistContextTestLanguage.g:227:1: rule__FirstLevel__Group__0 : rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1 ;
    public final void rule__FirstLevel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:231:1: ( rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1 )
            // InternalContentAssistContextTestLanguage.g:232:2: rule__FirstLevel__Group__0__Impl rule__FirstLevel__Group__1
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
    // InternalContentAssistContextTestLanguage.g:239:1: rule__FirstLevel__Group__0__Impl : ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) ;
    public final void rule__FirstLevel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:243:1: ( ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* ) )
            // InternalContentAssistContextTestLanguage.g:244:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* )
            {
            // InternalContentAssistContextTestLanguage.g:244:1: ( ( rule__FirstLevel__SecondLevelAAssignment_0 )* )
            // InternalContentAssistContextTestLanguage.g:245:2: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelAAssignment_0()); 
            // InternalContentAssistContextTestLanguage.g:246:2: ( rule__FirstLevel__SecondLevelAAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:246:3: rule__FirstLevel__SecondLevelAAssignment_0
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
    // InternalContentAssistContextTestLanguage.g:254:1: rule__FirstLevel__Group__1 : rule__FirstLevel__Group__1__Impl ;
    public final void rule__FirstLevel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:258:1: ( rule__FirstLevel__Group__1__Impl )
            // InternalContentAssistContextTestLanguage.g:259:2: rule__FirstLevel__Group__1__Impl
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
    // InternalContentAssistContextTestLanguage.g:265:1: rule__FirstLevel__Group__1__Impl : ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) ;
    public final void rule__FirstLevel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:269:1: ( ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* ) )
            // InternalContentAssistContextTestLanguage.g:270:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            {
            // InternalContentAssistContextTestLanguage.g:270:1: ( ( rule__FirstLevel__SecondLevelBAssignment_1 )* )
            // InternalContentAssistContextTestLanguage.g:271:2: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            {
             before(grammarAccess.getFirstLevelAccess().getSecondLevelBAssignment_1()); 
            // InternalContentAssistContextTestLanguage.g:272:2: ( rule__FirstLevel__SecondLevelBAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:272:3: rule__FirstLevel__SecondLevelBAssignment_1
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
    // InternalContentAssistContextTestLanguage.g:281:1: rule__SecondLevelA__Group__0 : rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1 ;
    public final void rule__SecondLevelA__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:285:1: ( rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1 )
            // InternalContentAssistContextTestLanguage.g:286:2: rule__SecondLevelA__Group__0__Impl rule__SecondLevelA__Group__1
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
    // InternalContentAssistContextTestLanguage.g:293:1: rule__SecondLevelA__Group__0__Impl : ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) ;
    public final void rule__SecondLevelA__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:297:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:298:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:298:1: ( ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* ) )
            // InternalContentAssistContextTestLanguage.g:299:2: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) ) ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            {
            // InternalContentAssistContextTestLanguage.g:299:2: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 ) )
            // InternalContentAssistContextTestLanguage.g:300:3: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:301:3: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )
            // InternalContentAssistContextTestLanguage.g:301:4: rule__SecondLevelA__ThirdLevelA1Assignment_0
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__SecondLevelA__ThirdLevelA1Assignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 

            }

            // InternalContentAssistContextTestLanguage.g:304:2: ( ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )* )
            // InternalContentAssistContextTestLanguage.g:305:3: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:306:3: ( rule__SecondLevelA__ThirdLevelA1Assignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:306:4: rule__SecondLevelA__ThirdLevelA1Assignment_0
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
    // InternalContentAssistContextTestLanguage.g:315:1: rule__SecondLevelA__Group__1 : rule__SecondLevelA__Group__1__Impl ;
    public final void rule__SecondLevelA__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:319:1: ( rule__SecondLevelA__Group__1__Impl )
            // InternalContentAssistContextTestLanguage.g:320:2: rule__SecondLevelA__Group__1__Impl
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
    // InternalContentAssistContextTestLanguage.g:326:1: rule__SecondLevelA__Group__1__Impl : ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelA__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:330:1: ( ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:331:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:331:1: ( ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* ) )
            // InternalContentAssistContextTestLanguage.g:332:2: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) ) ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            {
            // InternalContentAssistContextTestLanguage.g:332:2: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 ) )
            // InternalContentAssistContextTestLanguage.g:333:3: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:334:3: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )
            // InternalContentAssistContextTestLanguage.g:334:4: rule__SecondLevelA__ThirdLevelA2Assignment_1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__SecondLevelA__ThirdLevelA2Assignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 

            }

            // InternalContentAssistContextTestLanguage.g:337:2: ( ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )* )
            // InternalContentAssistContextTestLanguage.g:338:3: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelAAccess().getThirdLevelA2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:339:3: ( rule__SecondLevelA__ThirdLevelA2Assignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:339:4: rule__SecondLevelA__ThirdLevelA2Assignment_1
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
    // InternalContentAssistContextTestLanguage.g:349:1: rule__SecondLevelB__Group__0 : rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1 ;
    public final void rule__SecondLevelB__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:353:1: ( rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1 )
            // InternalContentAssistContextTestLanguage.g:354:2: rule__SecondLevelB__Group__0__Impl rule__SecondLevelB__Group__1
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
    // InternalContentAssistContextTestLanguage.g:361:1: rule__SecondLevelB__Group__0__Impl : ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) ;
    public final void rule__SecondLevelB__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:365:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:366:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:366:1: ( ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* ) )
            // InternalContentAssistContextTestLanguage.g:367:2: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) ) ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            {
            // InternalContentAssistContextTestLanguage.g:367:2: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 ) )
            // InternalContentAssistContextTestLanguage.g:368:3: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:369:3: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )
            // InternalContentAssistContextTestLanguage.g:369:4: rule__SecondLevelB__ThirdLevelB1Assignment_0
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__SecondLevelB__ThirdLevelB1Assignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 

            }

            // InternalContentAssistContextTestLanguage.g:372:2: ( ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )* )
            // InternalContentAssistContextTestLanguage.g:373:3: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB1Assignment_0()); 
            // InternalContentAssistContextTestLanguage.g:374:3: ( rule__SecondLevelB__ThirdLevelB1Assignment_0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:374:4: rule__SecondLevelB__ThirdLevelB1Assignment_0
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
    // InternalContentAssistContextTestLanguage.g:383:1: rule__SecondLevelB__Group__1 : rule__SecondLevelB__Group__1__Impl ;
    public final void rule__SecondLevelB__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:387:1: ( rule__SecondLevelB__Group__1__Impl )
            // InternalContentAssistContextTestLanguage.g:388:2: rule__SecondLevelB__Group__1__Impl
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
    // InternalContentAssistContextTestLanguage.g:394:1: rule__SecondLevelB__Group__1__Impl : ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) ;
    public final void rule__SecondLevelB__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:398:1: ( ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) ) )
            // InternalContentAssistContextTestLanguage.g:399:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            {
            // InternalContentAssistContextTestLanguage.g:399:1: ( ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* ) )
            // InternalContentAssistContextTestLanguage.g:400:2: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) ) ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            {
            // InternalContentAssistContextTestLanguage.g:400:2: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 ) )
            // InternalContentAssistContextTestLanguage.g:401:3: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:402:3: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )
            // InternalContentAssistContextTestLanguage.g:402:4: rule__SecondLevelB__ThirdLevelB2Assignment_1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__SecondLevelB__ThirdLevelB2Assignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 

            }

            // InternalContentAssistContextTestLanguage.g:405:2: ( ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )* )
            // InternalContentAssistContextTestLanguage.g:406:3: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            {
             before(grammarAccess.getSecondLevelBAccess().getThirdLevelB2Assignment_1()); 
            // InternalContentAssistContextTestLanguage.g:407:3: ( rule__SecondLevelB__ThirdLevelB2Assignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:407:4: rule__SecondLevelB__ThirdLevelB2Assignment_1
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
    // InternalContentAssistContextTestLanguage.g:417:1: rule__ThirdLevelA1__Group__0 : rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1 ;
    public final void rule__ThirdLevelA1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:421:1: ( rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1 )
            // InternalContentAssistContextTestLanguage.g:422:2: rule__ThirdLevelA1__Group__0__Impl rule__ThirdLevelA1__Group__1
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
    // InternalContentAssistContextTestLanguage.g:429:1: rule__ThirdLevelA1__Group__0__Impl : ( 'A1' ) ;
    public final void rule__ThirdLevelA1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:433:1: ( ( 'A1' ) )
            // InternalContentAssistContextTestLanguage.g:434:1: ( 'A1' )
            {
            // InternalContentAssistContextTestLanguage.g:434:1: ( 'A1' )
            // InternalContentAssistContextTestLanguage.g:435:2: 'A1'
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
    // InternalContentAssistContextTestLanguage.g:444:1: rule__ThirdLevelA1__Group__1 : rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2 ;
    public final void rule__ThirdLevelA1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:448:1: ( rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2 )
            // InternalContentAssistContextTestLanguage.g:449:2: rule__ThirdLevelA1__Group__1__Impl rule__ThirdLevelA1__Group__2
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
    // InternalContentAssistContextTestLanguage.g:456:1: rule__ThirdLevelA1__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelA1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:460:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:461:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:461:1: ( () )
            // InternalContentAssistContextTestLanguage.g:462:2: ()
            {
             before(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1()); 
            // InternalContentAssistContextTestLanguage.g:463:2: ()
            // InternalContentAssistContextTestLanguage.g:463:3: 
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
    // InternalContentAssistContextTestLanguage.g:471:1: rule__ThirdLevelA1__Group__2 : rule__ThirdLevelA1__Group__2__Impl ;
    public final void rule__ThirdLevelA1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:475:1: ( rule__ThirdLevelA1__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:476:2: rule__ThirdLevelA1__Group__2__Impl
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
    // InternalContentAssistContextTestLanguage.g:482:1: rule__ThirdLevelA1__Group__2__Impl : ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:486:1: ( ( ( rule__ThirdLevelA1__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:487:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:487:1: ( ( rule__ThirdLevelA1__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:488:2: ( rule__ThirdLevelA1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA1Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:489:2: ( rule__ThirdLevelA1__NameAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:489:3: rule__ThirdLevelA1__NameAssignment_2
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
    // InternalContentAssistContextTestLanguage.g:498:1: rule__ThirdLevelA2__Group__0 : rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1 ;
    public final void rule__ThirdLevelA2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:502:1: ( rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1 )
            // InternalContentAssistContextTestLanguage.g:503:2: rule__ThirdLevelA2__Group__0__Impl rule__ThirdLevelA2__Group__1
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
    // InternalContentAssistContextTestLanguage.g:510:1: rule__ThirdLevelA2__Group__0__Impl : ( 'A2' ) ;
    public final void rule__ThirdLevelA2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:514:1: ( ( 'A2' ) )
            // InternalContentAssistContextTestLanguage.g:515:1: ( 'A2' )
            {
            // InternalContentAssistContextTestLanguage.g:515:1: ( 'A2' )
            // InternalContentAssistContextTestLanguage.g:516:2: 'A2'
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
    // InternalContentAssistContextTestLanguage.g:525:1: rule__ThirdLevelA2__Group__1 : rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2 ;
    public final void rule__ThirdLevelA2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:529:1: ( rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2 )
            // InternalContentAssistContextTestLanguage.g:530:2: rule__ThirdLevelA2__Group__1__Impl rule__ThirdLevelA2__Group__2
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
    // InternalContentAssistContextTestLanguage.g:537:1: rule__ThirdLevelA2__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelA2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:541:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:542:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:542:1: ( () )
            // InternalContentAssistContextTestLanguage.g:543:2: ()
            {
             before(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1()); 
            // InternalContentAssistContextTestLanguage.g:544:2: ()
            // InternalContentAssistContextTestLanguage.g:544:3: 
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
    // InternalContentAssistContextTestLanguage.g:552:1: rule__ThirdLevelA2__Group__2 : rule__ThirdLevelA2__Group__2__Impl ;
    public final void rule__ThirdLevelA2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:556:1: ( rule__ThirdLevelA2__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:557:2: rule__ThirdLevelA2__Group__2__Impl
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
    // InternalContentAssistContextTestLanguage.g:563:1: rule__ThirdLevelA2__Group__2__Impl : ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelA2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:567:1: ( ( ( rule__ThirdLevelA2__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:568:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:568:1: ( ( rule__ThirdLevelA2__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:569:2: ( rule__ThirdLevelA2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelA2Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:570:2: ( rule__ThirdLevelA2__NameAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:570:3: rule__ThirdLevelA2__NameAssignment_2
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
    // InternalContentAssistContextTestLanguage.g:579:1: rule__ThirdLevelB1__Group__0 : rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1 ;
    public final void rule__ThirdLevelB1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:583:1: ( rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1 )
            // InternalContentAssistContextTestLanguage.g:584:2: rule__ThirdLevelB1__Group__0__Impl rule__ThirdLevelB1__Group__1
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
    // InternalContentAssistContextTestLanguage.g:591:1: rule__ThirdLevelB1__Group__0__Impl : ( 'B1' ) ;
    public final void rule__ThirdLevelB1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:595:1: ( ( 'B1' ) )
            // InternalContentAssistContextTestLanguage.g:596:1: ( 'B1' )
            {
            // InternalContentAssistContextTestLanguage.g:596:1: ( 'B1' )
            // InternalContentAssistContextTestLanguage.g:597:2: 'B1'
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
    // InternalContentAssistContextTestLanguage.g:606:1: rule__ThirdLevelB1__Group__1 : rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2 ;
    public final void rule__ThirdLevelB1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:610:1: ( rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2 )
            // InternalContentAssistContextTestLanguage.g:611:2: rule__ThirdLevelB1__Group__1__Impl rule__ThirdLevelB1__Group__2
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
    // InternalContentAssistContextTestLanguage.g:618:1: rule__ThirdLevelB1__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelB1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:622:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:623:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:623:1: ( () )
            // InternalContentAssistContextTestLanguage.g:624:2: ()
            {
             before(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1()); 
            // InternalContentAssistContextTestLanguage.g:625:2: ()
            // InternalContentAssistContextTestLanguage.g:625:3: 
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
    // InternalContentAssistContextTestLanguage.g:633:1: rule__ThirdLevelB1__Group__2 : rule__ThirdLevelB1__Group__2__Impl ;
    public final void rule__ThirdLevelB1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:637:1: ( rule__ThirdLevelB1__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:638:2: rule__ThirdLevelB1__Group__2__Impl
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
    // InternalContentAssistContextTestLanguage.g:644:1: rule__ThirdLevelB1__Group__2__Impl : ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:648:1: ( ( ( rule__ThirdLevelB1__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:649:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:649:1: ( ( rule__ThirdLevelB1__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:650:2: ( rule__ThirdLevelB1__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB1Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:651:2: ( rule__ThirdLevelB1__NameAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:651:3: rule__ThirdLevelB1__NameAssignment_2
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
    // InternalContentAssistContextTestLanguage.g:660:1: rule__ThirdLevelB2__Group__0 : rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1 ;
    public final void rule__ThirdLevelB2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:664:1: ( rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1 )
            // InternalContentAssistContextTestLanguage.g:665:2: rule__ThirdLevelB2__Group__0__Impl rule__ThirdLevelB2__Group__1
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
    // InternalContentAssistContextTestLanguage.g:672:1: rule__ThirdLevelB2__Group__0__Impl : ( 'B2' ) ;
    public final void rule__ThirdLevelB2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:676:1: ( ( 'B2' ) )
            // InternalContentAssistContextTestLanguage.g:677:1: ( 'B2' )
            {
            // InternalContentAssistContextTestLanguage.g:677:1: ( 'B2' )
            // InternalContentAssistContextTestLanguage.g:678:2: 'B2'
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
    // InternalContentAssistContextTestLanguage.g:687:1: rule__ThirdLevelB2__Group__1 : rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2 ;
    public final void rule__ThirdLevelB2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:691:1: ( rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2 )
            // InternalContentAssistContextTestLanguage.g:692:2: rule__ThirdLevelB2__Group__1__Impl rule__ThirdLevelB2__Group__2
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
    // InternalContentAssistContextTestLanguage.g:699:1: rule__ThirdLevelB2__Group__1__Impl : ( () ) ;
    public final void rule__ThirdLevelB2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:703:1: ( ( () ) )
            // InternalContentAssistContextTestLanguage.g:704:1: ( () )
            {
            // InternalContentAssistContextTestLanguage.g:704:1: ( () )
            // InternalContentAssistContextTestLanguage.g:705:2: ()
            {
             before(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1()); 
            // InternalContentAssistContextTestLanguage.g:706:2: ()
            // InternalContentAssistContextTestLanguage.g:706:3: 
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
    // InternalContentAssistContextTestLanguage.g:714:1: rule__ThirdLevelB2__Group__2 : rule__ThirdLevelB2__Group__2__Impl ;
    public final void rule__ThirdLevelB2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:718:1: ( rule__ThirdLevelB2__Group__2__Impl )
            // InternalContentAssistContextTestLanguage.g:719:2: rule__ThirdLevelB2__Group__2__Impl
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
    // InternalContentAssistContextTestLanguage.g:725:1: rule__ThirdLevelB2__Group__2__Impl : ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) ;
    public final void rule__ThirdLevelB2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:729:1: ( ( ( rule__ThirdLevelB2__NameAssignment_2 )? ) )
            // InternalContentAssistContextTestLanguage.g:730:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            {
            // InternalContentAssistContextTestLanguage.g:730:1: ( ( rule__ThirdLevelB2__NameAssignment_2 )? )
            // InternalContentAssistContextTestLanguage.g:731:2: ( rule__ThirdLevelB2__NameAssignment_2 )?
            {
             before(grammarAccess.getThirdLevelB2Access().getNameAssignment_2()); 
            // InternalContentAssistContextTestLanguage.g:732:2: ( rule__ThirdLevelB2__NameAssignment_2 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:732:3: rule__ThirdLevelB2__NameAssignment_2
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
    // InternalContentAssistContextTestLanguage.g:741:1: rule__FirstLevel__SecondLevelAAssignment_0 : ( ruleSecondLevelA ) ;
    public final void rule__FirstLevel__SecondLevelAAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:745:1: ( ( ruleSecondLevelA ) )
            // InternalContentAssistContextTestLanguage.g:746:2: ( ruleSecondLevelA )
            {
            // InternalContentAssistContextTestLanguage.g:746:2: ( ruleSecondLevelA )
            // InternalContentAssistContextTestLanguage.g:747:3: ruleSecondLevelA
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
    // InternalContentAssistContextTestLanguage.g:756:1: rule__FirstLevel__SecondLevelBAssignment_1 : ( ruleSecondLevelB ) ;
    public final void rule__FirstLevel__SecondLevelBAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:760:1: ( ( ruleSecondLevelB ) )
            // InternalContentAssistContextTestLanguage.g:761:2: ( ruleSecondLevelB )
            {
            // InternalContentAssistContextTestLanguage.g:761:2: ( ruleSecondLevelB )
            // InternalContentAssistContextTestLanguage.g:762:3: ruleSecondLevelB
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
    // InternalContentAssistContextTestLanguage.g:771:1: rule__SecondLevelA__ThirdLevelA1Assignment_0 : ( ruleThirdLevelA1 ) ;
    public final void rule__SecondLevelA__ThirdLevelA1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:775:1: ( ( ruleThirdLevelA1 ) )
            // InternalContentAssistContextTestLanguage.g:776:2: ( ruleThirdLevelA1 )
            {
            // InternalContentAssistContextTestLanguage.g:776:2: ( ruleThirdLevelA1 )
            // InternalContentAssistContextTestLanguage.g:777:3: ruleThirdLevelA1
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
    // InternalContentAssistContextTestLanguage.g:786:1: rule__SecondLevelA__ThirdLevelA2Assignment_1 : ( ruleThirdLevelA2 ) ;
    public final void rule__SecondLevelA__ThirdLevelA2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:790:1: ( ( ruleThirdLevelA2 ) )
            // InternalContentAssistContextTestLanguage.g:791:2: ( ruleThirdLevelA2 )
            {
            // InternalContentAssistContextTestLanguage.g:791:2: ( ruleThirdLevelA2 )
            // InternalContentAssistContextTestLanguage.g:792:3: ruleThirdLevelA2
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
    // InternalContentAssistContextTestLanguage.g:801:1: rule__SecondLevelB__ThirdLevelB1Assignment_0 : ( ruleThirdLevelB1 ) ;
    public final void rule__SecondLevelB__ThirdLevelB1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:805:1: ( ( ruleThirdLevelB1 ) )
            // InternalContentAssistContextTestLanguage.g:806:2: ( ruleThirdLevelB1 )
            {
            // InternalContentAssistContextTestLanguage.g:806:2: ( ruleThirdLevelB1 )
            // InternalContentAssistContextTestLanguage.g:807:3: ruleThirdLevelB1
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
    // InternalContentAssistContextTestLanguage.g:816:1: rule__SecondLevelB__ThirdLevelB2Assignment_1 : ( ruleThirdLevelB2 ) ;
    public final void rule__SecondLevelB__ThirdLevelB2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:820:1: ( ( ruleThirdLevelB2 ) )
            // InternalContentAssistContextTestLanguage.g:821:2: ( ruleThirdLevelB2 )
            {
            // InternalContentAssistContextTestLanguage.g:821:2: ( ruleThirdLevelB2 )
            // InternalContentAssistContextTestLanguage.g:822:3: ruleThirdLevelB2
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
    // InternalContentAssistContextTestLanguage.g:831:1: rule__ThirdLevelA1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:835:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:836:2: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:836:2: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:837:3: RULE_ID
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
    // InternalContentAssistContextTestLanguage.g:846:1: rule__ThirdLevelA2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelA2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:850:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:851:2: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:851:2: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:852:3: RULE_ID
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
    // InternalContentAssistContextTestLanguage.g:861:1: rule__ThirdLevelB1__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB1__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:865:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:866:2: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:866:2: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:867:3: RULE_ID
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
    // InternalContentAssistContextTestLanguage.g:876:1: rule__ThirdLevelB2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ThirdLevelB2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistContextTestLanguage.g:880:1: ( ( RULE_ID ) )
            // InternalContentAssistContextTestLanguage.g:881:2: ( RULE_ID )
            {
            // InternalContentAssistContextTestLanguage.g:881:2: ( RULE_ID )
            // InternalContentAssistContextTestLanguage.g:882:3: RULE_ID
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
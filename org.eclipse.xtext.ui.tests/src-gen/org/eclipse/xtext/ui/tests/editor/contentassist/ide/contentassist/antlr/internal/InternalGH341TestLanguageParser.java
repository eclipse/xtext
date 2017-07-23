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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.GH341TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGH341TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'stream'", "'define'", "'works'", "';'", "'.'", "'X'", "'broken'"
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
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalGH341TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGH341TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGH341TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGH341TestLanguage.g"; }


    	private GH341TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(GH341TestLanguageGrammarAccess grammarAccess) {
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
    // InternalGH341TestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalGH341TestLanguage.g:54:1: ( ruleModel EOF )
            // InternalGH341TestLanguage.g:55:1: ruleModel EOF
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
    // InternalGH341TestLanguage.g:62:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:66:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalGH341TestLanguage.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalGH341TestLanguage.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            // InternalGH341TestLanguage.g:68:3: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalGH341TestLanguage.g:69:3: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)||LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:69:4: rule__Model__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Model__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleWorks"
    // InternalGH341TestLanguage.g:78:1: entryRuleWorks : ruleWorks EOF ;
    public final void entryRuleWorks() throws RecognitionException {
        try {
            // InternalGH341TestLanguage.g:79:1: ( ruleWorks EOF )
            // InternalGH341TestLanguage.g:80:1: ruleWorks EOF
            {
             before(grammarAccess.getWorksRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWorks();

            state._fsp--;

             after(grammarAccess.getWorksRule()); 
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
    // $ANTLR end "entryRuleWorks"


    // $ANTLR start "ruleWorks"
    // InternalGH341TestLanguage.g:87:1: ruleWorks : ( ( rule__Works__Group__0 ) ) ;
    public final void ruleWorks() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:91:2: ( ( ( rule__Works__Group__0 ) ) )
            // InternalGH341TestLanguage.g:92:2: ( ( rule__Works__Group__0 ) )
            {
            // InternalGH341TestLanguage.g:92:2: ( ( rule__Works__Group__0 ) )
            // InternalGH341TestLanguage.g:93:3: ( rule__Works__Group__0 )
            {
             before(grammarAccess.getWorksAccess().getGroup()); 
            // InternalGH341TestLanguage.g:94:3: ( rule__Works__Group__0 )
            // InternalGH341TestLanguage.g:94:4: rule__Works__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorks"


    // $ANTLR start "entryRuleBroken"
    // InternalGH341TestLanguage.g:103:1: entryRuleBroken : ruleBroken EOF ;
    public final void entryRuleBroken() throws RecognitionException {
        try {
            // InternalGH341TestLanguage.g:104:1: ( ruleBroken EOF )
            // InternalGH341TestLanguage.g:105:1: ruleBroken EOF
            {
             before(grammarAccess.getBrokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBroken();

            state._fsp--;

             after(grammarAccess.getBrokenRule()); 
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
    // $ANTLR end "entryRuleBroken"


    // $ANTLR start "ruleBroken"
    // InternalGH341TestLanguage.g:112:1: ruleBroken : ( ( rule__Broken__Group__0 ) ) ;
    public final void ruleBroken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:116:2: ( ( ( rule__Broken__Group__0 ) ) )
            // InternalGH341TestLanguage.g:117:2: ( ( rule__Broken__Group__0 ) )
            {
            // InternalGH341TestLanguage.g:117:2: ( ( rule__Broken__Group__0 ) )
            // InternalGH341TestLanguage.g:118:3: ( rule__Broken__Group__0 )
            {
             before(grammarAccess.getBrokenAccess().getGroup()); 
            // InternalGH341TestLanguage.g:119:3: ( rule__Broken__Group__0 )
            // InternalGH341TestLanguage.g:119:4: rule__Broken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBrokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBroken"


    // $ANTLR start "entryRuleThird"
    // InternalGH341TestLanguage.g:128:1: entryRuleThird : ruleThird EOF ;
    public final void entryRuleThird() throws RecognitionException {
        try {
            // InternalGH341TestLanguage.g:129:1: ( ruleThird EOF )
            // InternalGH341TestLanguage.g:130:1: ruleThird EOF
            {
             before(grammarAccess.getThirdRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleThird();

            state._fsp--;

             after(grammarAccess.getThirdRule()); 
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
    // $ANTLR end "entryRuleThird"


    // $ANTLR start "ruleThird"
    // InternalGH341TestLanguage.g:137:1: ruleThird : ( ( rule__Third__Group__0 ) ) ;
    public final void ruleThird() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:141:2: ( ( ( rule__Third__Group__0 ) ) )
            // InternalGH341TestLanguage.g:142:2: ( ( rule__Third__Group__0 ) )
            {
            // InternalGH341TestLanguage.g:142:2: ( ( rule__Third__Group__0 ) )
            // InternalGH341TestLanguage.g:143:3: ( rule__Third__Group__0 )
            {
             before(grammarAccess.getThirdAccess().getGroup()); 
            // InternalGH341TestLanguage.g:144:3: ( rule__Third__Group__0 )
            // InternalGH341TestLanguage.g:144:4: rule__Third__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Third__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThirdAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleThird"


    // $ANTLR start "ruleSTREAM"
    // InternalGH341TestLanguage.g:154:1: ruleSTREAM : ( 'stream' ) ;
    public final void ruleSTREAM() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:158:2: ( ( 'stream' ) )
            // InternalGH341TestLanguage.g:159:2: ( 'stream' )
            {
            // InternalGH341TestLanguage.g:159:2: ( 'stream' )
            // InternalGH341TestLanguage.g:160:3: 'stream'
            {
             before(grammarAccess.getSTREAMAccess().getStreamKeyword()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSTREAMAccess().getStreamKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSTREAM"


    // $ANTLR start "ruleDEFINE"
    // InternalGH341TestLanguage.g:171:1: ruleDEFINE : ( 'define' ) ;
    public final void ruleDEFINE() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:175:2: ( ( 'define' ) )
            // InternalGH341TestLanguage.g:176:2: ( 'define' )
            {
            // InternalGH341TestLanguage.g:176:2: ( 'define' )
            // InternalGH341TestLanguage.g:177:3: 'define'
            {
             before(grammarAccess.getDEFINEAccess().getDefineKeyword()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getDEFINEAccess().getDefineKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDEFINE"


    // $ANTLR start "ruleFragment"
    // InternalGH341TestLanguage.g:188:1: ruleFragment : ( ( rule__Fragment__Group__0 )* ) ;
    public final void ruleFragment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:192:2: ( ( ( rule__Fragment__Group__0 )* ) )
            // InternalGH341TestLanguage.g:193:2: ( ( rule__Fragment__Group__0 )* )
            {
            // InternalGH341TestLanguage.g:193:2: ( ( rule__Fragment__Group__0 )* )
            // InternalGH341TestLanguage.g:194:3: ( rule__Fragment__Group__0 )*
            {
             before(grammarAccess.getFragmentAccess().getGroup()); 
            // InternalGH341TestLanguage.g:195:3: ( rule__Fragment__Group__0 )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:195:4: rule__Fragment__Group__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Fragment__Group__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getFragmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFragment"


    // $ANTLR start "rule__Model__ElementsAlternatives_0"
    // InternalGH341TestLanguage.g:203:1: rule__Model__ElementsAlternatives_0 : ( ( ruleWorks ) | ( ruleBroken ) | ( ruleThird ) );
    public final void rule__Model__ElementsAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:207:1: ( ( ruleWorks ) | ( ruleBroken ) | ( ruleThird ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 17:
                {
                alt3=2;
                }
                break;
            case 12:
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
                    // InternalGH341TestLanguage.g:208:2: ( ruleWorks )
                    {
                    // InternalGH341TestLanguage.g:208:2: ( ruleWorks )
                    // InternalGH341TestLanguage.g:209:3: ruleWorks
                    {
                     before(grammarAccess.getModelAccess().getElementsWorksParserRuleCall_0_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWorks();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsWorksParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGH341TestLanguage.g:214:2: ( ruleBroken )
                    {
                    // InternalGH341TestLanguage.g:214:2: ( ruleBroken )
                    // InternalGH341TestLanguage.g:215:3: ruleBroken
                    {
                     before(grammarAccess.getModelAccess().getElementsBrokenParserRuleCall_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleBroken();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsBrokenParserRuleCall_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGH341TestLanguage.g:220:2: ( ruleThird )
                    {
                    // InternalGH341TestLanguage.g:220:2: ( ruleThird )
                    // InternalGH341TestLanguage.g:221:3: ruleThird
                    {
                     before(grammarAccess.getModelAccess().getElementsThirdParserRuleCall_0_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleThird();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsThirdParserRuleCall_0_2()); 

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
    // $ANTLR end "rule__Model__ElementsAlternatives_0"


    // $ANTLR start "rule__Works__Group__0"
    // InternalGH341TestLanguage.g:230:1: rule__Works__Group__0 : rule__Works__Group__0__Impl rule__Works__Group__1 ;
    public final void rule__Works__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:234:1: ( rule__Works__Group__0__Impl rule__Works__Group__1 )
            // InternalGH341TestLanguage.g:235:2: rule__Works__Group__0__Impl rule__Works__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Works__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group__0"


    // $ANTLR start "rule__Works__Group__0__Impl"
    // InternalGH341TestLanguage.g:242:1: rule__Works__Group__0__Impl : ( 'works' ) ;
    public final void rule__Works__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:246:1: ( ( 'works' ) )
            // InternalGH341TestLanguage.g:247:1: ( 'works' )
            {
            // InternalGH341TestLanguage.g:247:1: ( 'works' )
            // InternalGH341TestLanguage.g:248:2: 'works'
            {
             before(grammarAccess.getWorksAccess().getWorksKeyword_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getWorksKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group__0__Impl"


    // $ANTLR start "rule__Works__Group__1"
    // InternalGH341TestLanguage.g:257:1: rule__Works__Group__1 : rule__Works__Group__1__Impl rule__Works__Group__2 ;
    public final void rule__Works__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:261:1: ( rule__Works__Group__1__Impl rule__Works__Group__2 )
            // InternalGH341TestLanguage.g:262:2: rule__Works__Group__1__Impl rule__Works__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Works__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group__1"


    // $ANTLR start "rule__Works__Group__1__Impl"
    // InternalGH341TestLanguage.g:269:1: rule__Works__Group__1__Impl : ( ( rule__Works__NameAssignment_1 ) ) ;
    public final void rule__Works__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:273:1: ( ( ( rule__Works__NameAssignment_1 ) ) )
            // InternalGH341TestLanguage.g:274:1: ( ( rule__Works__NameAssignment_1 ) )
            {
            // InternalGH341TestLanguage.g:274:1: ( ( rule__Works__NameAssignment_1 ) )
            // InternalGH341TestLanguage.g:275:2: ( rule__Works__NameAssignment_1 )
            {
             before(grammarAccess.getWorksAccess().getNameAssignment_1()); 
            // InternalGH341TestLanguage.g:276:2: ( rule__Works__NameAssignment_1 )
            // InternalGH341TestLanguage.g:276:3: rule__Works__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group__1__Impl"


    // $ANTLR start "rule__Works__Group__2"
    // InternalGH341TestLanguage.g:284:1: rule__Works__Group__2 : rule__Works__Group__2__Impl rule__Works__Group__3 ;
    public final void rule__Works__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:288:1: ( rule__Works__Group__2__Impl rule__Works__Group__3 )
            // InternalGH341TestLanguage.g:289:2: rule__Works__Group__2__Impl rule__Works__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Works__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group__2"


    // $ANTLR start "rule__Works__Group__2__Impl"
    // InternalGH341TestLanguage.g:296:1: rule__Works__Group__2__Impl : ( ( rule__Works__Group_2__0 )* ) ;
    public final void rule__Works__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:300:1: ( ( ( rule__Works__Group_2__0 )* ) )
            // InternalGH341TestLanguage.g:301:1: ( ( rule__Works__Group_2__0 )* )
            {
            // InternalGH341TestLanguage.g:301:1: ( ( rule__Works__Group_2__0 )* )
            // InternalGH341TestLanguage.g:302:2: ( rule__Works__Group_2__0 )*
            {
             before(grammarAccess.getWorksAccess().getGroup_2()); 
            // InternalGH341TestLanguage.g:303:2: ( rule__Works__Group_2__0 )*
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:303:3: rule__Works__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Works__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getWorksAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group__2__Impl"


    // $ANTLR start "rule__Works__Group__3"
    // InternalGH341TestLanguage.g:311:1: rule__Works__Group__3 : rule__Works__Group__3__Impl ;
    public final void rule__Works__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:315:1: ( rule__Works__Group__3__Impl )
            // InternalGH341TestLanguage.g:316:2: rule__Works__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group__3"


    // $ANTLR start "rule__Works__Group__3__Impl"
    // InternalGH341TestLanguage.g:322:1: rule__Works__Group__3__Impl : ( ( rule__Works__Group_3__0 )* ) ;
    public final void rule__Works__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:326:1: ( ( ( rule__Works__Group_3__0 )* ) )
            // InternalGH341TestLanguage.g:327:1: ( ( rule__Works__Group_3__0 )* )
            {
            // InternalGH341TestLanguage.g:327:1: ( ( rule__Works__Group_3__0 )* )
            // InternalGH341TestLanguage.g:328:2: ( rule__Works__Group_3__0 )*
            {
             before(grammarAccess.getWorksAccess().getGroup_3()); 
            // InternalGH341TestLanguage.g:329:2: ( rule__Works__Group_3__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:329:3: rule__Works__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Works__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getWorksAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group__3__Impl"


    // $ANTLR start "rule__Works__Group_2__0"
    // InternalGH341TestLanguage.g:338:1: rule__Works__Group_2__0 : rule__Works__Group_2__0__Impl rule__Works__Group_2__1 ;
    public final void rule__Works__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:342:1: ( rule__Works__Group_2__0__Impl rule__Works__Group_2__1 )
            // InternalGH341TestLanguage.g:343:2: rule__Works__Group_2__0__Impl rule__Works__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Works__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_2__0"


    // $ANTLR start "rule__Works__Group_2__0__Impl"
    // InternalGH341TestLanguage.g:350:1: rule__Works__Group_2__0__Impl : ( ( rule__Works__IdsAssignment_2_0 ) ) ;
    public final void rule__Works__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:354:1: ( ( ( rule__Works__IdsAssignment_2_0 ) ) )
            // InternalGH341TestLanguage.g:355:1: ( ( rule__Works__IdsAssignment_2_0 ) )
            {
            // InternalGH341TestLanguage.g:355:1: ( ( rule__Works__IdsAssignment_2_0 ) )
            // InternalGH341TestLanguage.g:356:2: ( rule__Works__IdsAssignment_2_0 )
            {
             before(grammarAccess.getWorksAccess().getIdsAssignment_2_0()); 
            // InternalGH341TestLanguage.g:357:2: ( rule__Works__IdsAssignment_2_0 )
            // InternalGH341TestLanguage.g:357:3: rule__Works__IdsAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__IdsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getIdsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_2__0__Impl"


    // $ANTLR start "rule__Works__Group_2__1"
    // InternalGH341TestLanguage.g:365:1: rule__Works__Group_2__1 : rule__Works__Group_2__1__Impl rule__Works__Group_2__2 ;
    public final void rule__Works__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:369:1: ( rule__Works__Group_2__1__Impl rule__Works__Group_2__2 )
            // InternalGH341TestLanguage.g:370:2: rule__Works__Group_2__1__Impl rule__Works__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Works__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_2__1"


    // $ANTLR start "rule__Works__Group_2__1__Impl"
    // InternalGH341TestLanguage.g:377:1: rule__Works__Group_2__1__Impl : ( ( rule__Works__Group_2_1__0 )* ) ;
    public final void rule__Works__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:381:1: ( ( ( rule__Works__Group_2_1__0 )* ) )
            // InternalGH341TestLanguage.g:382:1: ( ( rule__Works__Group_2_1__0 )* )
            {
            // InternalGH341TestLanguage.g:382:1: ( ( rule__Works__Group_2_1__0 )* )
            // InternalGH341TestLanguage.g:383:2: ( rule__Works__Group_2_1__0 )*
            {
             before(grammarAccess.getWorksAccess().getGroup_2_1()); 
            // InternalGH341TestLanguage.g:384:2: ( rule__Works__Group_2_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:384:3: rule__Works__Group_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Works__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getWorksAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_2__1__Impl"


    // $ANTLR start "rule__Works__Group_2__2"
    // InternalGH341TestLanguage.g:392:1: rule__Works__Group_2__2 : rule__Works__Group_2__2__Impl ;
    public final void rule__Works__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:396:1: ( rule__Works__Group_2__2__Impl )
            // InternalGH341TestLanguage.g:397:2: rule__Works__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_2__2"


    // $ANTLR start "rule__Works__Group_2__2__Impl"
    // InternalGH341TestLanguage.g:403:1: rule__Works__Group_2__2__Impl : ( ';' ) ;
    public final void rule__Works__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:407:1: ( ( ';' ) )
            // InternalGH341TestLanguage.g:408:1: ( ';' )
            {
            // InternalGH341TestLanguage.g:408:1: ( ';' )
            // InternalGH341TestLanguage.g:409:2: ';'
            {
             before(grammarAccess.getWorksAccess().getSemicolonKeyword_2_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getSemicolonKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_2__2__Impl"


    // $ANTLR start "rule__Works__Group_2_1__0"
    // InternalGH341TestLanguage.g:419:1: rule__Works__Group_2_1__0 : rule__Works__Group_2_1__0__Impl rule__Works__Group_2_1__1 ;
    public final void rule__Works__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:423:1: ( rule__Works__Group_2_1__0__Impl rule__Works__Group_2_1__1 )
            // InternalGH341TestLanguage.g:424:2: rule__Works__Group_2_1__0__Impl rule__Works__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Works__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_2_1__0"


    // $ANTLR start "rule__Works__Group_2_1__0__Impl"
    // InternalGH341TestLanguage.g:431:1: rule__Works__Group_2_1__0__Impl : ( '.' ) ;
    public final void rule__Works__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:435:1: ( ( '.' ) )
            // InternalGH341TestLanguage.g:436:1: ( '.' )
            {
            // InternalGH341TestLanguage.g:436:1: ( '.' )
            // InternalGH341TestLanguage.g:437:2: '.'
            {
             before(grammarAccess.getWorksAccess().getFullStopKeyword_2_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getFullStopKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_2_1__0__Impl"


    // $ANTLR start "rule__Works__Group_2_1__1"
    // InternalGH341TestLanguage.g:446:1: rule__Works__Group_2_1__1 : rule__Works__Group_2_1__1__Impl ;
    public final void rule__Works__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:450:1: ( rule__Works__Group_2_1__1__Impl )
            // InternalGH341TestLanguage.g:451:2: rule__Works__Group_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_2_1__1"


    // $ANTLR start "rule__Works__Group_2_1__1__Impl"
    // InternalGH341TestLanguage.g:457:1: rule__Works__Group_2_1__1__Impl : ( ( rule__Works__IdsAssignment_2_1_1 ) ) ;
    public final void rule__Works__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:461:1: ( ( ( rule__Works__IdsAssignment_2_1_1 ) ) )
            // InternalGH341TestLanguage.g:462:1: ( ( rule__Works__IdsAssignment_2_1_1 ) )
            {
            // InternalGH341TestLanguage.g:462:1: ( ( rule__Works__IdsAssignment_2_1_1 ) )
            // InternalGH341TestLanguage.g:463:2: ( rule__Works__IdsAssignment_2_1_1 )
            {
             before(grammarAccess.getWorksAccess().getIdsAssignment_2_1_1()); 
            // InternalGH341TestLanguage.g:464:2: ( rule__Works__IdsAssignment_2_1_1 )
            // InternalGH341TestLanguage.g:464:3: rule__Works__IdsAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__IdsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getIdsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_2_1__1__Impl"


    // $ANTLR start "rule__Works__Group_3__0"
    // InternalGH341TestLanguage.g:473:1: rule__Works__Group_3__0 : rule__Works__Group_3__0__Impl rule__Works__Group_3__1 ;
    public final void rule__Works__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:477:1: ( rule__Works__Group_3__0__Impl rule__Works__Group_3__1 )
            // InternalGH341TestLanguage.g:478:2: rule__Works__Group_3__0__Impl rule__Works__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Works__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3__0"


    // $ANTLR start "rule__Works__Group_3__0__Impl"
    // InternalGH341TestLanguage.g:485:1: rule__Works__Group_3__0__Impl : ( ( rule__Works__RefsAssignment_3_0 ) ) ;
    public final void rule__Works__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:489:1: ( ( ( rule__Works__RefsAssignment_3_0 ) ) )
            // InternalGH341TestLanguage.g:490:1: ( ( rule__Works__RefsAssignment_3_0 ) )
            {
            // InternalGH341TestLanguage.g:490:1: ( ( rule__Works__RefsAssignment_3_0 ) )
            // InternalGH341TestLanguage.g:491:2: ( rule__Works__RefsAssignment_3_0 )
            {
             before(grammarAccess.getWorksAccess().getRefsAssignment_3_0()); 
            // InternalGH341TestLanguage.g:492:2: ( rule__Works__RefsAssignment_3_0 )
            // InternalGH341TestLanguage.g:492:3: rule__Works__RefsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__RefsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getRefsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3__0__Impl"


    // $ANTLR start "rule__Works__Group_3__1"
    // InternalGH341TestLanguage.g:500:1: rule__Works__Group_3__1 : rule__Works__Group_3__1__Impl rule__Works__Group_3__2 ;
    public final void rule__Works__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:504:1: ( rule__Works__Group_3__1__Impl rule__Works__Group_3__2 )
            // InternalGH341TestLanguage.g:505:2: rule__Works__Group_3__1__Impl rule__Works__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Works__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3__1"


    // $ANTLR start "rule__Works__Group_3__1__Impl"
    // InternalGH341TestLanguage.g:512:1: rule__Works__Group_3__1__Impl : ( ( rule__Works__Group_3_1__0 )* ) ;
    public final void rule__Works__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:516:1: ( ( ( rule__Works__Group_3_1__0 )* ) )
            // InternalGH341TestLanguage.g:517:1: ( ( rule__Works__Group_3_1__0 )* )
            {
            // InternalGH341TestLanguage.g:517:1: ( ( rule__Works__Group_3_1__0 )* )
            // InternalGH341TestLanguage.g:518:2: ( rule__Works__Group_3_1__0 )*
            {
             before(grammarAccess.getWorksAccess().getGroup_3_1()); 
            // InternalGH341TestLanguage.g:519:2: ( rule__Works__Group_3_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==15) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:519:3: rule__Works__Group_3_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Works__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getWorksAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3__1__Impl"


    // $ANTLR start "rule__Works__Group_3__2"
    // InternalGH341TestLanguage.g:527:1: rule__Works__Group_3__2 : rule__Works__Group_3__2__Impl rule__Works__Group_3__3 ;
    public final void rule__Works__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:531:1: ( rule__Works__Group_3__2__Impl rule__Works__Group_3__3 )
            // InternalGH341TestLanguage.g:532:2: rule__Works__Group_3__2__Impl rule__Works__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Works__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3__2"


    // $ANTLR start "rule__Works__Group_3__2__Impl"
    // InternalGH341TestLanguage.g:539:1: rule__Works__Group_3__2__Impl : ( 'X' ) ;
    public final void rule__Works__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:543:1: ( ( 'X' ) )
            // InternalGH341TestLanguage.g:544:1: ( 'X' )
            {
            // InternalGH341TestLanguage.g:544:1: ( 'X' )
            // InternalGH341TestLanguage.g:545:2: 'X'
            {
             before(grammarAccess.getWorksAccess().getXKeyword_3_2()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getXKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3__2__Impl"


    // $ANTLR start "rule__Works__Group_3__3"
    // InternalGH341TestLanguage.g:554:1: rule__Works__Group_3__3 : rule__Works__Group_3__3__Impl ;
    public final void rule__Works__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:558:1: ( rule__Works__Group_3__3__Impl )
            // InternalGH341TestLanguage.g:559:2: rule__Works__Group_3__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3__3"


    // $ANTLR start "rule__Works__Group_3__3__Impl"
    // InternalGH341TestLanguage.g:565:1: rule__Works__Group_3__3__Impl : ( ';' ) ;
    public final void rule__Works__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:569:1: ( ( ';' ) )
            // InternalGH341TestLanguage.g:570:1: ( ';' )
            {
            // InternalGH341TestLanguage.g:570:1: ( ';' )
            // InternalGH341TestLanguage.g:571:2: ';'
            {
             before(grammarAccess.getWorksAccess().getSemicolonKeyword_3_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getSemicolonKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3__3__Impl"


    // $ANTLR start "rule__Works__Group_3_1__0"
    // InternalGH341TestLanguage.g:581:1: rule__Works__Group_3_1__0 : rule__Works__Group_3_1__0__Impl rule__Works__Group_3_1__1 ;
    public final void rule__Works__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:585:1: ( rule__Works__Group_3_1__0__Impl rule__Works__Group_3_1__1 )
            // InternalGH341TestLanguage.g:586:2: rule__Works__Group_3_1__0__Impl rule__Works__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Works__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3_1__0"


    // $ANTLR start "rule__Works__Group_3_1__0__Impl"
    // InternalGH341TestLanguage.g:593:1: rule__Works__Group_3_1__0__Impl : ( '.' ) ;
    public final void rule__Works__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:597:1: ( ( '.' ) )
            // InternalGH341TestLanguage.g:598:1: ( '.' )
            {
            // InternalGH341TestLanguage.g:598:1: ( '.' )
            // InternalGH341TestLanguage.g:599:2: '.'
            {
             before(grammarAccess.getWorksAccess().getFullStopKeyword_3_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getFullStopKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3_1__0__Impl"


    // $ANTLR start "rule__Works__Group_3_1__1"
    // InternalGH341TestLanguage.g:608:1: rule__Works__Group_3_1__1 : rule__Works__Group_3_1__1__Impl ;
    public final void rule__Works__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:612:1: ( rule__Works__Group_3_1__1__Impl )
            // InternalGH341TestLanguage.g:613:2: rule__Works__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3_1__1"


    // $ANTLR start "rule__Works__Group_3_1__1__Impl"
    // InternalGH341TestLanguage.g:619:1: rule__Works__Group_3_1__1__Impl : ( ( rule__Works__RefsAssignment_3_1_1 ) ) ;
    public final void rule__Works__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:623:1: ( ( ( rule__Works__RefsAssignment_3_1_1 ) ) )
            // InternalGH341TestLanguage.g:624:1: ( ( rule__Works__RefsAssignment_3_1_1 ) )
            {
            // InternalGH341TestLanguage.g:624:1: ( ( rule__Works__RefsAssignment_3_1_1 ) )
            // InternalGH341TestLanguage.g:625:2: ( rule__Works__RefsAssignment_3_1_1 )
            {
             before(grammarAccess.getWorksAccess().getRefsAssignment_3_1_1()); 
            // InternalGH341TestLanguage.g:626:2: ( rule__Works__RefsAssignment_3_1_1 )
            // InternalGH341TestLanguage.g:626:3: rule__Works__RefsAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Works__RefsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getWorksAccess().getRefsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__Group_3_1__1__Impl"


    // $ANTLR start "rule__Broken__Group__0"
    // InternalGH341TestLanguage.g:635:1: rule__Broken__Group__0 : rule__Broken__Group__0__Impl rule__Broken__Group__1 ;
    public final void rule__Broken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:639:1: ( rule__Broken__Group__0__Impl rule__Broken__Group__1 )
            // InternalGH341TestLanguage.g:640:2: rule__Broken__Group__0__Impl rule__Broken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Broken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group__0"


    // $ANTLR start "rule__Broken__Group__0__Impl"
    // InternalGH341TestLanguage.g:647:1: rule__Broken__Group__0__Impl : ( 'broken' ) ;
    public final void rule__Broken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:651:1: ( ( 'broken' ) )
            // InternalGH341TestLanguage.g:652:1: ( 'broken' )
            {
            // InternalGH341TestLanguage.g:652:1: ( 'broken' )
            // InternalGH341TestLanguage.g:653:2: 'broken'
            {
             before(grammarAccess.getBrokenAccess().getBrokenKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getBrokenKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group__0__Impl"


    // $ANTLR start "rule__Broken__Group__1"
    // InternalGH341TestLanguage.g:662:1: rule__Broken__Group__1 : rule__Broken__Group__1__Impl rule__Broken__Group__2 ;
    public final void rule__Broken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:666:1: ( rule__Broken__Group__1__Impl rule__Broken__Group__2 )
            // InternalGH341TestLanguage.g:667:2: rule__Broken__Group__1__Impl rule__Broken__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Broken__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group__1"


    // $ANTLR start "rule__Broken__Group__1__Impl"
    // InternalGH341TestLanguage.g:674:1: rule__Broken__Group__1__Impl : ( ( rule__Broken__NameAssignment_1 ) ) ;
    public final void rule__Broken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:678:1: ( ( ( rule__Broken__NameAssignment_1 ) ) )
            // InternalGH341TestLanguage.g:679:1: ( ( rule__Broken__NameAssignment_1 ) )
            {
            // InternalGH341TestLanguage.g:679:1: ( ( rule__Broken__NameAssignment_1 ) )
            // InternalGH341TestLanguage.g:680:2: ( rule__Broken__NameAssignment_1 )
            {
             before(grammarAccess.getBrokenAccess().getNameAssignment_1()); 
            // InternalGH341TestLanguage.g:681:2: ( rule__Broken__NameAssignment_1 )
            // InternalGH341TestLanguage.g:681:3: rule__Broken__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBrokenAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group__1__Impl"


    // $ANTLR start "rule__Broken__Group__2"
    // InternalGH341TestLanguage.g:689:1: rule__Broken__Group__2 : rule__Broken__Group__2__Impl rule__Broken__Group__3 ;
    public final void rule__Broken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:693:1: ( rule__Broken__Group__2__Impl rule__Broken__Group__3 )
            // InternalGH341TestLanguage.g:694:2: rule__Broken__Group__2__Impl rule__Broken__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Broken__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group__2"


    // $ANTLR start "rule__Broken__Group__2__Impl"
    // InternalGH341TestLanguage.g:701:1: rule__Broken__Group__2__Impl : ( ruleFragment ) ;
    public final void rule__Broken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:705:1: ( ( ruleFragment ) )
            // InternalGH341TestLanguage.g:706:1: ( ruleFragment )
            {
            // InternalGH341TestLanguage.g:706:1: ( ruleFragment )
            // InternalGH341TestLanguage.g:707:2: ruleFragment
            {
             before(grammarAccess.getBrokenAccess().getFragmentParserRuleCall_2()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFragment();

            state._fsp--;

             after(grammarAccess.getBrokenAccess().getFragmentParserRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group__2__Impl"


    // $ANTLR start "rule__Broken__Group__3"
    // InternalGH341TestLanguage.g:716:1: rule__Broken__Group__3 : rule__Broken__Group__3__Impl ;
    public final void rule__Broken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:720:1: ( rule__Broken__Group__3__Impl )
            // InternalGH341TestLanguage.g:721:2: rule__Broken__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group__3"


    // $ANTLR start "rule__Broken__Group__3__Impl"
    // InternalGH341TestLanguage.g:727:1: rule__Broken__Group__3__Impl : ( ( rule__Broken__Group_3__0 )* ) ;
    public final void rule__Broken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:731:1: ( ( ( rule__Broken__Group_3__0 )* ) )
            // InternalGH341TestLanguage.g:732:1: ( ( rule__Broken__Group_3__0 )* )
            {
            // InternalGH341TestLanguage.g:732:1: ( ( rule__Broken__Group_3__0 )* )
            // InternalGH341TestLanguage.g:733:2: ( rule__Broken__Group_3__0 )*
            {
             before(grammarAccess.getBrokenAccess().getGroup_3()); 
            // InternalGH341TestLanguage.g:734:2: ( rule__Broken__Group_3__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:734:3: rule__Broken__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Broken__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getBrokenAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group__3__Impl"


    // $ANTLR start "rule__Broken__Group_3__0"
    // InternalGH341TestLanguage.g:743:1: rule__Broken__Group_3__0 : rule__Broken__Group_3__0__Impl rule__Broken__Group_3__1 ;
    public final void rule__Broken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:747:1: ( rule__Broken__Group_3__0__Impl rule__Broken__Group_3__1 )
            // InternalGH341TestLanguage.g:748:2: rule__Broken__Group_3__0__Impl rule__Broken__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Broken__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3__0"


    // $ANTLR start "rule__Broken__Group_3__0__Impl"
    // InternalGH341TestLanguage.g:755:1: rule__Broken__Group_3__0__Impl : ( ( rule__Broken__RefsAssignment_3_0 ) ) ;
    public final void rule__Broken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:759:1: ( ( ( rule__Broken__RefsAssignment_3_0 ) ) )
            // InternalGH341TestLanguage.g:760:1: ( ( rule__Broken__RefsAssignment_3_0 ) )
            {
            // InternalGH341TestLanguage.g:760:1: ( ( rule__Broken__RefsAssignment_3_0 ) )
            // InternalGH341TestLanguage.g:761:2: ( rule__Broken__RefsAssignment_3_0 )
            {
             before(grammarAccess.getBrokenAccess().getRefsAssignment_3_0()); 
            // InternalGH341TestLanguage.g:762:2: ( rule__Broken__RefsAssignment_3_0 )
            // InternalGH341TestLanguage.g:762:3: rule__Broken__RefsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__RefsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getBrokenAccess().getRefsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3__0__Impl"


    // $ANTLR start "rule__Broken__Group_3__1"
    // InternalGH341TestLanguage.g:770:1: rule__Broken__Group_3__1 : rule__Broken__Group_3__1__Impl rule__Broken__Group_3__2 ;
    public final void rule__Broken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:774:1: ( rule__Broken__Group_3__1__Impl rule__Broken__Group_3__2 )
            // InternalGH341TestLanguage.g:775:2: rule__Broken__Group_3__1__Impl rule__Broken__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Broken__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3__1"


    // $ANTLR start "rule__Broken__Group_3__1__Impl"
    // InternalGH341TestLanguage.g:782:1: rule__Broken__Group_3__1__Impl : ( ( rule__Broken__Group_3_1__0 )* ) ;
    public final void rule__Broken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:786:1: ( ( ( rule__Broken__Group_3_1__0 )* ) )
            // InternalGH341TestLanguage.g:787:1: ( ( rule__Broken__Group_3_1__0 )* )
            {
            // InternalGH341TestLanguage.g:787:1: ( ( rule__Broken__Group_3_1__0 )* )
            // InternalGH341TestLanguage.g:788:2: ( rule__Broken__Group_3_1__0 )*
            {
             before(grammarAccess.getBrokenAccess().getGroup_3_1()); 
            // InternalGH341TestLanguage.g:789:2: ( rule__Broken__Group_3_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:789:3: rule__Broken__Group_3_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Broken__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getBrokenAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3__1__Impl"


    // $ANTLR start "rule__Broken__Group_3__2"
    // InternalGH341TestLanguage.g:797:1: rule__Broken__Group_3__2 : rule__Broken__Group_3__2__Impl rule__Broken__Group_3__3 ;
    public final void rule__Broken__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:801:1: ( rule__Broken__Group_3__2__Impl rule__Broken__Group_3__3 )
            // InternalGH341TestLanguage.g:802:2: rule__Broken__Group_3__2__Impl rule__Broken__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Broken__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3__2"


    // $ANTLR start "rule__Broken__Group_3__2__Impl"
    // InternalGH341TestLanguage.g:809:1: rule__Broken__Group_3__2__Impl : ( 'X' ) ;
    public final void rule__Broken__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:813:1: ( ( 'X' ) )
            // InternalGH341TestLanguage.g:814:1: ( 'X' )
            {
            // InternalGH341TestLanguage.g:814:1: ( 'X' )
            // InternalGH341TestLanguage.g:815:2: 'X'
            {
             before(grammarAccess.getBrokenAccess().getXKeyword_3_2()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getXKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3__2__Impl"


    // $ANTLR start "rule__Broken__Group_3__3"
    // InternalGH341TestLanguage.g:824:1: rule__Broken__Group_3__3 : rule__Broken__Group_3__3__Impl ;
    public final void rule__Broken__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:828:1: ( rule__Broken__Group_3__3__Impl )
            // InternalGH341TestLanguage.g:829:2: rule__Broken__Group_3__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3__3"


    // $ANTLR start "rule__Broken__Group_3__3__Impl"
    // InternalGH341TestLanguage.g:835:1: rule__Broken__Group_3__3__Impl : ( ';' ) ;
    public final void rule__Broken__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:839:1: ( ( ';' ) )
            // InternalGH341TestLanguage.g:840:1: ( ';' )
            {
            // InternalGH341TestLanguage.g:840:1: ( ';' )
            // InternalGH341TestLanguage.g:841:2: ';'
            {
             before(grammarAccess.getBrokenAccess().getSemicolonKeyword_3_3()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getSemicolonKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3__3__Impl"


    // $ANTLR start "rule__Broken__Group_3_1__0"
    // InternalGH341TestLanguage.g:851:1: rule__Broken__Group_3_1__0 : rule__Broken__Group_3_1__0__Impl rule__Broken__Group_3_1__1 ;
    public final void rule__Broken__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:855:1: ( rule__Broken__Group_3_1__0__Impl rule__Broken__Group_3_1__1 )
            // InternalGH341TestLanguage.g:856:2: rule__Broken__Group_3_1__0__Impl rule__Broken__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Broken__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3_1__0"


    // $ANTLR start "rule__Broken__Group_3_1__0__Impl"
    // InternalGH341TestLanguage.g:863:1: rule__Broken__Group_3_1__0__Impl : ( '.' ) ;
    public final void rule__Broken__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:867:1: ( ( '.' ) )
            // InternalGH341TestLanguage.g:868:1: ( '.' )
            {
            // InternalGH341TestLanguage.g:868:1: ( '.' )
            // InternalGH341TestLanguage.g:869:2: '.'
            {
             before(grammarAccess.getBrokenAccess().getFullStopKeyword_3_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getFullStopKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3_1__0__Impl"


    // $ANTLR start "rule__Broken__Group_3_1__1"
    // InternalGH341TestLanguage.g:878:1: rule__Broken__Group_3_1__1 : rule__Broken__Group_3_1__1__Impl ;
    public final void rule__Broken__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:882:1: ( rule__Broken__Group_3_1__1__Impl )
            // InternalGH341TestLanguage.g:883:2: rule__Broken__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3_1__1"


    // $ANTLR start "rule__Broken__Group_3_1__1__Impl"
    // InternalGH341TestLanguage.g:889:1: rule__Broken__Group_3_1__1__Impl : ( ( rule__Broken__RefsAssignment_3_1_1 ) ) ;
    public final void rule__Broken__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:893:1: ( ( ( rule__Broken__RefsAssignment_3_1_1 ) ) )
            // InternalGH341TestLanguage.g:894:1: ( ( rule__Broken__RefsAssignment_3_1_1 ) )
            {
            // InternalGH341TestLanguage.g:894:1: ( ( rule__Broken__RefsAssignment_3_1_1 ) )
            // InternalGH341TestLanguage.g:895:2: ( rule__Broken__RefsAssignment_3_1_1 )
            {
             before(grammarAccess.getBrokenAccess().getRefsAssignment_3_1_1()); 
            // InternalGH341TestLanguage.g:896:2: ( rule__Broken__RefsAssignment_3_1_1 )
            // InternalGH341TestLanguage.g:896:3: rule__Broken__RefsAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Broken__RefsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getBrokenAccess().getRefsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__Group_3_1__1__Impl"


    // $ANTLR start "rule__Third__Group__0"
    // InternalGH341TestLanguage.g:905:1: rule__Third__Group__0 : rule__Third__Group__0__Impl rule__Third__Group__1 ;
    public final void rule__Third__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:909:1: ( rule__Third__Group__0__Impl rule__Third__Group__1 )
            // InternalGH341TestLanguage.g:910:2: rule__Third__Group__0__Impl rule__Third__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Third__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Third__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Third__Group__0"


    // $ANTLR start "rule__Third__Group__0__Impl"
    // InternalGH341TestLanguage.g:917:1: rule__Third__Group__0__Impl : ( ruleDEFINE ) ;
    public final void rule__Third__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:921:1: ( ( ruleDEFINE ) )
            // InternalGH341TestLanguage.g:922:1: ( ruleDEFINE )
            {
            // InternalGH341TestLanguage.g:922:1: ( ruleDEFINE )
            // InternalGH341TestLanguage.g:923:2: ruleDEFINE
            {
             before(grammarAccess.getThirdAccess().getDEFINEParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDEFINE();

            state._fsp--;

             after(grammarAccess.getThirdAccess().getDEFINEParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Third__Group__0__Impl"


    // $ANTLR start "rule__Third__Group__1"
    // InternalGH341TestLanguage.g:932:1: rule__Third__Group__1 : rule__Third__Group__1__Impl rule__Third__Group__2 ;
    public final void rule__Third__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:936:1: ( rule__Third__Group__1__Impl rule__Third__Group__2 )
            // InternalGH341TestLanguage.g:937:2: rule__Third__Group__1__Impl rule__Third__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Third__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Third__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Third__Group__1"


    // $ANTLR start "rule__Third__Group__1__Impl"
    // InternalGH341TestLanguage.g:944:1: rule__Third__Group__1__Impl : ( ruleSTREAM ) ;
    public final void rule__Third__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:948:1: ( ( ruleSTREAM ) )
            // InternalGH341TestLanguage.g:949:1: ( ruleSTREAM )
            {
            // InternalGH341TestLanguage.g:949:1: ( ruleSTREAM )
            // InternalGH341TestLanguage.g:950:2: ruleSTREAM
            {
             before(grammarAccess.getThirdAccess().getSTREAMParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleSTREAM();

            state._fsp--;

             after(grammarAccess.getThirdAccess().getSTREAMParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Third__Group__1__Impl"


    // $ANTLR start "rule__Third__Group__2"
    // InternalGH341TestLanguage.g:959:1: rule__Third__Group__2 : rule__Third__Group__2__Impl ;
    public final void rule__Third__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:963:1: ( rule__Third__Group__2__Impl )
            // InternalGH341TestLanguage.g:964:2: rule__Third__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Third__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Third__Group__2"


    // $ANTLR start "rule__Third__Group__2__Impl"
    // InternalGH341TestLanguage.g:970:1: rule__Third__Group__2__Impl : ( ( rule__Third__NameAssignment_2 ) ) ;
    public final void rule__Third__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:974:1: ( ( ( rule__Third__NameAssignment_2 ) ) )
            // InternalGH341TestLanguage.g:975:1: ( ( rule__Third__NameAssignment_2 ) )
            {
            // InternalGH341TestLanguage.g:975:1: ( ( rule__Third__NameAssignment_2 ) )
            // InternalGH341TestLanguage.g:976:2: ( rule__Third__NameAssignment_2 )
            {
             before(grammarAccess.getThirdAccess().getNameAssignment_2()); 
            // InternalGH341TestLanguage.g:977:2: ( rule__Third__NameAssignment_2 )
            // InternalGH341TestLanguage.g:977:3: rule__Third__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Third__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getThirdAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Third__Group__2__Impl"


    // $ANTLR start "rule__Fragment__Group__0"
    // InternalGH341TestLanguage.g:986:1: rule__Fragment__Group__0 : rule__Fragment__Group__0__Impl rule__Fragment__Group__1 ;
    public final void rule__Fragment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:990:1: ( rule__Fragment__Group__0__Impl rule__Fragment__Group__1 )
            // InternalGH341TestLanguage.g:991:2: rule__Fragment__Group__0__Impl rule__Fragment__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Fragment__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__Group__0"


    // $ANTLR start "rule__Fragment__Group__0__Impl"
    // InternalGH341TestLanguage.g:998:1: rule__Fragment__Group__0__Impl : ( ( rule__Fragment__IdsAssignment_0 ) ) ;
    public final void rule__Fragment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1002:1: ( ( ( rule__Fragment__IdsAssignment_0 ) ) )
            // InternalGH341TestLanguage.g:1003:1: ( ( rule__Fragment__IdsAssignment_0 ) )
            {
            // InternalGH341TestLanguage.g:1003:1: ( ( rule__Fragment__IdsAssignment_0 ) )
            // InternalGH341TestLanguage.g:1004:2: ( rule__Fragment__IdsAssignment_0 )
            {
             before(grammarAccess.getFragmentAccess().getIdsAssignment_0()); 
            // InternalGH341TestLanguage.g:1005:2: ( rule__Fragment__IdsAssignment_0 )
            // InternalGH341TestLanguage.g:1005:3: rule__Fragment__IdsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__IdsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFragmentAccess().getIdsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__Group__0__Impl"


    // $ANTLR start "rule__Fragment__Group__1"
    // InternalGH341TestLanguage.g:1013:1: rule__Fragment__Group__1 : rule__Fragment__Group__1__Impl rule__Fragment__Group__2 ;
    public final void rule__Fragment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1017:1: ( rule__Fragment__Group__1__Impl rule__Fragment__Group__2 )
            // InternalGH341TestLanguage.g:1018:2: rule__Fragment__Group__1__Impl rule__Fragment__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Fragment__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__Group__1"


    // $ANTLR start "rule__Fragment__Group__1__Impl"
    // InternalGH341TestLanguage.g:1025:1: rule__Fragment__Group__1__Impl : ( ( rule__Fragment__Group_1__0 )* ) ;
    public final void rule__Fragment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1029:1: ( ( ( rule__Fragment__Group_1__0 )* ) )
            // InternalGH341TestLanguage.g:1030:1: ( ( rule__Fragment__Group_1__0 )* )
            {
            // InternalGH341TestLanguage.g:1030:1: ( ( rule__Fragment__Group_1__0 )* )
            // InternalGH341TestLanguage.g:1031:2: ( rule__Fragment__Group_1__0 )*
            {
             before(grammarAccess.getFragmentAccess().getGroup_1()); 
            // InternalGH341TestLanguage.g:1032:2: ( rule__Fragment__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:1032:3: rule__Fragment__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Fragment__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getFragmentAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__Group__1__Impl"


    // $ANTLR start "rule__Fragment__Group__2"
    // InternalGH341TestLanguage.g:1040:1: rule__Fragment__Group__2 : rule__Fragment__Group__2__Impl ;
    public final void rule__Fragment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1044:1: ( rule__Fragment__Group__2__Impl )
            // InternalGH341TestLanguage.g:1045:2: rule__Fragment__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__Group__2"


    // $ANTLR start "rule__Fragment__Group__2__Impl"
    // InternalGH341TestLanguage.g:1051:1: rule__Fragment__Group__2__Impl : ( ';' ) ;
    public final void rule__Fragment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1055:1: ( ( ';' ) )
            // InternalGH341TestLanguage.g:1056:1: ( ';' )
            {
            // InternalGH341TestLanguage.g:1056:1: ( ';' )
            // InternalGH341TestLanguage.g:1057:2: ';'
            {
             before(grammarAccess.getFragmentAccess().getSemicolonKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFragmentAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__Group__2__Impl"


    // $ANTLR start "rule__Fragment__Group_1__0"
    // InternalGH341TestLanguage.g:1067:1: rule__Fragment__Group_1__0 : rule__Fragment__Group_1__0__Impl rule__Fragment__Group_1__1 ;
    public final void rule__Fragment__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1071:1: ( rule__Fragment__Group_1__0__Impl rule__Fragment__Group_1__1 )
            // InternalGH341TestLanguage.g:1072:2: rule__Fragment__Group_1__0__Impl rule__Fragment__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Fragment__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__Group_1__0"


    // $ANTLR start "rule__Fragment__Group_1__0__Impl"
    // InternalGH341TestLanguage.g:1079:1: rule__Fragment__Group_1__0__Impl : ( '.' ) ;
    public final void rule__Fragment__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1083:1: ( ( '.' ) )
            // InternalGH341TestLanguage.g:1084:1: ( '.' )
            {
            // InternalGH341TestLanguage.g:1084:1: ( '.' )
            // InternalGH341TestLanguage.g:1085:2: '.'
            {
             before(grammarAccess.getFragmentAccess().getFullStopKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFragmentAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__Group_1__0__Impl"


    // $ANTLR start "rule__Fragment__Group_1__1"
    // InternalGH341TestLanguage.g:1094:1: rule__Fragment__Group_1__1 : rule__Fragment__Group_1__1__Impl ;
    public final void rule__Fragment__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1098:1: ( rule__Fragment__Group_1__1__Impl )
            // InternalGH341TestLanguage.g:1099:2: rule__Fragment__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__Group_1__1"


    // $ANTLR start "rule__Fragment__Group_1__1__Impl"
    // InternalGH341TestLanguage.g:1105:1: rule__Fragment__Group_1__1__Impl : ( ( rule__Fragment__IdsAssignment_1_1 ) ) ;
    public final void rule__Fragment__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1109:1: ( ( ( rule__Fragment__IdsAssignment_1_1 ) ) )
            // InternalGH341TestLanguage.g:1110:1: ( ( rule__Fragment__IdsAssignment_1_1 ) )
            {
            // InternalGH341TestLanguage.g:1110:1: ( ( rule__Fragment__IdsAssignment_1_1 ) )
            // InternalGH341TestLanguage.g:1111:2: ( rule__Fragment__IdsAssignment_1_1 )
            {
             before(grammarAccess.getFragmentAccess().getIdsAssignment_1_1()); 
            // InternalGH341TestLanguage.g:1112:2: ( rule__Fragment__IdsAssignment_1_1 )
            // InternalGH341TestLanguage.g:1112:3: rule__Fragment__IdsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Fragment__IdsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFragmentAccess().getIdsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalGH341TestLanguage.g:1121:1: rule__Model__ElementsAssignment : ( ( rule__Model__ElementsAlternatives_0 ) ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1125:1: ( ( ( rule__Model__ElementsAlternatives_0 ) ) )
            // InternalGH341TestLanguage.g:1126:2: ( ( rule__Model__ElementsAlternatives_0 ) )
            {
            // InternalGH341TestLanguage.g:1126:2: ( ( rule__Model__ElementsAlternatives_0 ) )
            // InternalGH341TestLanguage.g:1127:3: ( rule__Model__ElementsAlternatives_0 )
            {
             before(grammarAccess.getModelAccess().getElementsAlternatives_0()); 
            // InternalGH341TestLanguage.g:1128:3: ( rule__Model__ElementsAlternatives_0 )
            // InternalGH341TestLanguage.g:1128:4: rule__Model__ElementsAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__ElementsAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getElementsAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementsAssignment"


    // $ANTLR start "rule__Works__NameAssignment_1"
    // InternalGH341TestLanguage.g:1136:1: rule__Works__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Works__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1140:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1141:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1141:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1142:3: RULE_ID
            {
             before(grammarAccess.getWorksAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__NameAssignment_1"


    // $ANTLR start "rule__Works__IdsAssignment_2_0"
    // InternalGH341TestLanguage.g:1151:1: rule__Works__IdsAssignment_2_0 : ( RULE_ID ) ;
    public final void rule__Works__IdsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1155:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1156:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1156:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1157:3: RULE_ID
            {
             before(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__IdsAssignment_2_0"


    // $ANTLR start "rule__Works__IdsAssignment_2_1_1"
    // InternalGH341TestLanguage.g:1166:1: rule__Works__IdsAssignment_2_1_1 : ( RULE_ID ) ;
    public final void rule__Works__IdsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1170:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1171:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1171:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1172:3: RULE_ID
            {
             before(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__IdsAssignment_2_1_1"


    // $ANTLR start "rule__Works__RefsAssignment_3_0"
    // InternalGH341TestLanguage.g:1181:1: rule__Works__RefsAssignment_3_0 : ( ( RULE_ID ) ) ;
    public final void rule__Works__RefsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1185:1: ( ( ( RULE_ID ) ) )
            // InternalGH341TestLanguage.g:1186:2: ( ( RULE_ID ) )
            {
            // InternalGH341TestLanguage.g:1186:2: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1187:3: ( RULE_ID )
            {
             before(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_0_0()); 
            // InternalGH341TestLanguage.g:1188:3: ( RULE_ID )
            // InternalGH341TestLanguage.g:1189:4: RULE_ID
            {
             before(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_0_0_1()); 

            }

             after(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__RefsAssignment_3_0"


    // $ANTLR start "rule__Works__RefsAssignment_3_1_1"
    // InternalGH341TestLanguage.g:1200:1: rule__Works__RefsAssignment_3_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Works__RefsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1204:1: ( ( ( RULE_ID ) ) )
            // InternalGH341TestLanguage.g:1205:2: ( ( RULE_ID ) )
            {
            // InternalGH341TestLanguage.g:1205:2: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1206:3: ( RULE_ID )
            {
             before(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_1_1_0()); 
            // InternalGH341TestLanguage.g:1207:3: ( RULE_ID )
            // InternalGH341TestLanguage.g:1208:4: RULE_ID
            {
             before(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_1_1_0_1()); 

            }

             after(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Works__RefsAssignment_3_1_1"


    // $ANTLR start "rule__Broken__NameAssignment_1"
    // InternalGH341TestLanguage.g:1219:1: rule__Broken__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Broken__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1223:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1224:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1224:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1225:3: RULE_ID
            {
             before(grammarAccess.getBrokenAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__NameAssignment_1"


    // $ANTLR start "rule__Broken__RefsAssignment_3_0"
    // InternalGH341TestLanguage.g:1234:1: rule__Broken__RefsAssignment_3_0 : ( ( RULE_ID ) ) ;
    public final void rule__Broken__RefsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1238:1: ( ( ( RULE_ID ) ) )
            // InternalGH341TestLanguage.g:1239:2: ( ( RULE_ID ) )
            {
            // InternalGH341TestLanguage.g:1239:2: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1240:3: ( RULE_ID )
            {
             before(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_0_0()); 
            // InternalGH341TestLanguage.g:1241:3: ( RULE_ID )
            // InternalGH341TestLanguage.g:1242:4: RULE_ID
            {
             before(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_0_0_1()); 

            }

             after(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__RefsAssignment_3_0"


    // $ANTLR start "rule__Broken__RefsAssignment_3_1_1"
    // InternalGH341TestLanguage.g:1253:1: rule__Broken__RefsAssignment_3_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Broken__RefsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1257:1: ( ( ( RULE_ID ) ) )
            // InternalGH341TestLanguage.g:1258:2: ( ( RULE_ID ) )
            {
            // InternalGH341TestLanguage.g:1258:2: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1259:3: ( RULE_ID )
            {
             before(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_1_1_0()); 
            // InternalGH341TestLanguage.g:1260:3: ( RULE_ID )
            // InternalGH341TestLanguage.g:1261:4: RULE_ID
            {
             before(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_1_1_0_1()); 

            }

             after(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Broken__RefsAssignment_3_1_1"


    // $ANTLR start "rule__Third__NameAssignment_2"
    // InternalGH341TestLanguage.g:1272:1: rule__Third__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Third__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1276:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1277:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1277:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1278:3: RULE_ID
            {
             before(grammarAccess.getThirdAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getThirdAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Third__NameAssignment_2"


    // $ANTLR start "rule__Fragment__IdsAssignment_0"
    // InternalGH341TestLanguage.g:1287:1: rule__Fragment__IdsAssignment_0 : ( RULE_ID ) ;
    public final void rule__Fragment__IdsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1291:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1292:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1292:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1293:3: RULE_ID
            {
             before(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__IdsAssignment_0"


    // $ANTLR start "rule__Fragment__IdsAssignment_1_1"
    // InternalGH341TestLanguage.g:1302:1: rule__Fragment__IdsAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Fragment__IdsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGH341TestLanguage.g:1306:1: ( ( RULE_ID ) )
            // InternalGH341TestLanguage.g:1307:2: ( RULE_ID )
            {
            // InternalGH341TestLanguage.g:1307:2: ( RULE_ID )
            // InternalGH341TestLanguage.g:1308:3: RULE_ID
            {
             before(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fragment__IdsAssignment_1_1"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    static final String dfa_1s = "\6\uffff";
    static final String dfa_2s = "\1\2\5\uffff";
    static final String dfa_3s = "\1\4\1\16\1\uffff\1\4\1\uffff\1\16";
    static final String dfa_4s = "\1\21\1\20\1\uffff\1\4\1\uffff\1\20";
    static final String dfa_5s = "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String dfa_6s = "\6\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\7\uffff\2\2\3\uffff\1\2",
            "\1\4\1\3\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\3\1\2"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 195:3: ( rule__Fragment__Group__0 )*";
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 303:2: ( rule__Works__Group_2__0 )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000023002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000800L});
    }


}
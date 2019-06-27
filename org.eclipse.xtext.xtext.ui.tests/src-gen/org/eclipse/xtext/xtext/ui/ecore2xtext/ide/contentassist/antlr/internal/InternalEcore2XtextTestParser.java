package org.eclipse.xtext.xtext.ui.ecore2xtext.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.xtext.ui.ecore2xtext.services.Ecore2XtextTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEcore2XtextTestParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'INT'", "'Root'", "'{'", "'}'", "'classes'", "','", "'concrete0'", "'Concrete0'", "'Concrete1'", "'DiamondInheritance'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;

    // delegates
    // delegators


        public InternalEcore2XtextTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEcore2XtextTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEcore2XtextTestParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEcore2XtextTest.g"; }


    	private Ecore2XtextTestGrammarAccess grammarAccess;

    	public void setGrammarAccess(Ecore2XtextTestGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleRoot"
    // InternalEcore2XtextTest.g:53:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:54:1: ( ruleRoot EOF )
            // InternalEcore2XtextTest.g:55:1: ruleRoot EOF
            {
             before(grammarAccess.getRootRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRoot();

            state._fsp--;

             after(grammarAccess.getRootRule()); 
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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // InternalEcore2XtextTest.g:62:1: ruleRoot : ( ( rule__Root__Group__0 ) ) ;
    public final void ruleRoot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:66:2: ( ( ( rule__Root__Group__0 ) ) )
            // InternalEcore2XtextTest.g:67:2: ( ( rule__Root__Group__0 ) )
            {
            // InternalEcore2XtextTest.g:67:2: ( ( rule__Root__Group__0 ) )
            // InternalEcore2XtextTest.g:68:3: ( rule__Root__Group__0 )
            {
             before(grammarAccess.getRootAccess().getGroup()); 
            // InternalEcore2XtextTest.g:69:3: ( rule__Root__Group__0 )
            // InternalEcore2XtextTest.g:69:4: rule__Root__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleAbstract"
    // InternalEcore2XtextTest.g:78:1: entryRuleAbstract : ruleAbstract EOF ;
    public final void entryRuleAbstract() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:79:1: ( ruleAbstract EOF )
            // InternalEcore2XtextTest.g:80:1: ruleAbstract EOF
            {
             before(grammarAccess.getAbstractRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstract();

            state._fsp--;

             after(grammarAccess.getAbstractRule()); 
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
    // $ANTLR end "entryRuleAbstract"


    // $ANTLR start "ruleAbstract"
    // InternalEcore2XtextTest.g:87:1: ruleAbstract : ( ( rule__Abstract__Alternatives ) ) ;
    public final void ruleAbstract() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:91:2: ( ( ( rule__Abstract__Alternatives ) ) )
            // InternalEcore2XtextTest.g:92:2: ( ( rule__Abstract__Alternatives ) )
            {
            // InternalEcore2XtextTest.g:92:2: ( ( rule__Abstract__Alternatives ) )
            // InternalEcore2XtextTest.g:93:3: ( rule__Abstract__Alternatives )
            {
             before(grammarAccess.getAbstractAccess().getAlternatives()); 
            // InternalEcore2XtextTest.g:94:3: ( rule__Abstract__Alternatives )
            // InternalEcore2XtextTest.g:94:4: rule__Abstract__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Abstract__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstract"


    // $ANTLR start "entryRuleConcrete0"
    // InternalEcore2XtextTest.g:103:1: entryRuleConcrete0 : ruleConcrete0 EOF ;
    public final void entryRuleConcrete0() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:104:1: ( ruleConcrete0 EOF )
            // InternalEcore2XtextTest.g:105:1: ruleConcrete0 EOF
            {
             before(grammarAccess.getConcrete0Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConcrete0();

            state._fsp--;

             after(grammarAccess.getConcrete0Rule()); 
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
    // $ANTLR end "entryRuleConcrete0"


    // $ANTLR start "ruleConcrete0"
    // InternalEcore2XtextTest.g:112:1: ruleConcrete0 : ( ( rule__Concrete0__Alternatives ) ) ;
    public final void ruleConcrete0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:116:2: ( ( ( rule__Concrete0__Alternatives ) ) )
            // InternalEcore2XtextTest.g:117:2: ( ( rule__Concrete0__Alternatives ) )
            {
            // InternalEcore2XtextTest.g:117:2: ( ( rule__Concrete0__Alternatives ) )
            // InternalEcore2XtextTest.g:118:3: ( rule__Concrete0__Alternatives )
            {
             before(grammarAccess.getConcrete0Access().getAlternatives()); 
            // InternalEcore2XtextTest.g:119:3: ( rule__Concrete0__Alternatives )
            // InternalEcore2XtextTest.g:119:4: rule__Concrete0__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConcrete0Access().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConcrete0"


    // $ANTLR start "entryRuleINT0"
    // InternalEcore2XtextTest.g:128:1: entryRuleINT0 : ruleINT0 EOF ;
    public final void entryRuleINT0() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:129:1: ( ruleINT0 EOF )
            // InternalEcore2XtextTest.g:130:1: ruleINT0 EOF
            {
             before(grammarAccess.getINT0Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleINT0();

            state._fsp--;

             after(grammarAccess.getINT0Rule()); 
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
    // $ANTLR end "entryRuleINT0"


    // $ANTLR start "ruleINT0"
    // InternalEcore2XtextTest.g:137:1: ruleINT0 : ( 'INT' ) ;
    public final void ruleINT0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:141:2: ( ( 'INT' ) )
            // InternalEcore2XtextTest.g:142:2: ( 'INT' )
            {
            // InternalEcore2XtextTest.g:142:2: ( 'INT' )
            // InternalEcore2XtextTest.g:143:3: 'INT'
            {
             before(grammarAccess.getINT0Access().getINTKeyword()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getINT0Access().getINTKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleINT0"


    // $ANTLR start "entryRuleConcrete0_Impl"
    // InternalEcore2XtextTest.g:153:1: entryRuleConcrete0_Impl : ruleConcrete0_Impl EOF ;
    public final void entryRuleConcrete0_Impl() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:154:1: ( ruleConcrete0_Impl EOF )
            // InternalEcore2XtextTest.g:155:1: ruleConcrete0_Impl EOF
            {
             before(grammarAccess.getConcrete0_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConcrete0_Impl();

            state._fsp--;

             after(grammarAccess.getConcrete0_ImplRule()); 
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
    // $ANTLR end "entryRuleConcrete0_Impl"


    // $ANTLR start "ruleConcrete0_Impl"
    // InternalEcore2XtextTest.g:162:1: ruleConcrete0_Impl : ( ( rule__Concrete0_Impl__Group__0 ) ) ;
    public final void ruleConcrete0_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:166:2: ( ( ( rule__Concrete0_Impl__Group__0 ) ) )
            // InternalEcore2XtextTest.g:167:2: ( ( rule__Concrete0_Impl__Group__0 ) )
            {
            // InternalEcore2XtextTest.g:167:2: ( ( rule__Concrete0_Impl__Group__0 ) )
            // InternalEcore2XtextTest.g:168:3: ( rule__Concrete0_Impl__Group__0 )
            {
             before(grammarAccess.getConcrete0_ImplAccess().getGroup()); 
            // InternalEcore2XtextTest.g:169:3: ( rule__Concrete0_Impl__Group__0 )
            // InternalEcore2XtextTest.g:169:4: rule__Concrete0_Impl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0_Impl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConcrete0_ImplAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConcrete0_Impl"


    // $ANTLR start "entryRuleEString"
    // InternalEcore2XtextTest.g:178:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:179:1: ( ruleEString EOF )
            // InternalEcore2XtextTest.g:180:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalEcore2XtextTest.g:187:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:191:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalEcore2XtextTest.g:192:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalEcore2XtextTest.g:192:2: ( ( rule__EString__Alternatives ) )
            // InternalEcore2XtextTest.g:193:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalEcore2XtextTest.g:194:3: ( rule__EString__Alternatives )
            // InternalEcore2XtextTest.g:194:4: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleConcrete1_Impl"
    // InternalEcore2XtextTest.g:203:1: entryRuleConcrete1_Impl : ruleConcrete1_Impl EOF ;
    public final void entryRuleConcrete1_Impl() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:204:1: ( ruleConcrete1_Impl EOF )
            // InternalEcore2XtextTest.g:205:1: ruleConcrete1_Impl EOF
            {
             before(grammarAccess.getConcrete1_ImplRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConcrete1_Impl();

            state._fsp--;

             after(grammarAccess.getConcrete1_ImplRule()); 
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
    // $ANTLR end "entryRuleConcrete1_Impl"


    // $ANTLR start "ruleConcrete1_Impl"
    // InternalEcore2XtextTest.g:212:1: ruleConcrete1_Impl : ( ( rule__Concrete1_Impl__Group__0 ) ) ;
    public final void ruleConcrete1_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:216:2: ( ( ( rule__Concrete1_Impl__Group__0 ) ) )
            // InternalEcore2XtextTest.g:217:2: ( ( rule__Concrete1_Impl__Group__0 ) )
            {
            // InternalEcore2XtextTest.g:217:2: ( ( rule__Concrete1_Impl__Group__0 ) )
            // InternalEcore2XtextTest.g:218:3: ( rule__Concrete1_Impl__Group__0 )
            {
             before(grammarAccess.getConcrete1_ImplAccess().getGroup()); 
            // InternalEcore2XtextTest.g:219:3: ( rule__Concrete1_Impl__Group__0 )
            // InternalEcore2XtextTest.g:219:4: rule__Concrete1_Impl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete1_Impl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConcrete1_ImplAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConcrete1_Impl"


    // $ANTLR start "entryRuleDiamondInheritance"
    // InternalEcore2XtextTest.g:228:1: entryRuleDiamondInheritance : ruleDiamondInheritance EOF ;
    public final void entryRuleDiamondInheritance() throws RecognitionException {
        try {
            // InternalEcore2XtextTest.g:229:1: ( ruleDiamondInheritance EOF )
            // InternalEcore2XtextTest.g:230:1: ruleDiamondInheritance EOF
            {
             before(grammarAccess.getDiamondInheritanceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDiamondInheritance();

            state._fsp--;

             after(grammarAccess.getDiamondInheritanceRule()); 
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
    // $ANTLR end "entryRuleDiamondInheritance"


    // $ANTLR start "ruleDiamondInheritance"
    // InternalEcore2XtextTest.g:237:1: ruleDiamondInheritance : ( ( rule__DiamondInheritance__Group__0 ) ) ;
    public final void ruleDiamondInheritance() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:241:2: ( ( ( rule__DiamondInheritance__Group__0 ) ) )
            // InternalEcore2XtextTest.g:242:2: ( ( rule__DiamondInheritance__Group__0 ) )
            {
            // InternalEcore2XtextTest.g:242:2: ( ( rule__DiamondInheritance__Group__0 ) )
            // InternalEcore2XtextTest.g:243:3: ( rule__DiamondInheritance__Group__0 )
            {
             before(grammarAccess.getDiamondInheritanceAccess().getGroup()); 
            // InternalEcore2XtextTest.g:244:3: ( rule__DiamondInheritance__Group__0 )
            // InternalEcore2XtextTest.g:244:4: rule__DiamondInheritance__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DiamondInheritance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDiamondInheritanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDiamondInheritance"


    // $ANTLR start "rule__Abstract__Alternatives"
    // InternalEcore2XtextTest.g:252:1: rule__Abstract__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleConcrete1_Impl ) | ( ruleDiamondInheritance ) );
    public final void rule__Abstract__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:256:1: ( ( ruleConcrete0_Impl ) | ( ruleConcrete1_Impl ) | ( ruleDiamondInheritance ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt1=1;
                }
                break;
            case 19:
                {
                alt1=2;
                }
                break;
            case 20:
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
                    // InternalEcore2XtextTest.g:257:2: ( ruleConcrete0_Impl )
                    {
                    // InternalEcore2XtextTest.g:257:2: ( ruleConcrete0_Impl )
                    // InternalEcore2XtextTest.g:258:3: ruleConcrete0_Impl
                    {
                     before(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleConcrete0_Impl();

                    state._fsp--;

                     after(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEcore2XtextTest.g:263:2: ( ruleConcrete1_Impl )
                    {
                    // InternalEcore2XtextTest.g:263:2: ( ruleConcrete1_Impl )
                    // InternalEcore2XtextTest.g:264:3: ruleConcrete1_Impl
                    {
                     before(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleConcrete1_Impl();

                    state._fsp--;

                     after(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalEcore2XtextTest.g:269:2: ( ruleDiamondInheritance )
                    {
                    // InternalEcore2XtextTest.g:269:2: ( ruleDiamondInheritance )
                    // InternalEcore2XtextTest.g:270:3: ruleDiamondInheritance
                    {
                     before(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDiamondInheritance();

                    state._fsp--;

                     after(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2()); 

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
    // $ANTLR end "rule__Abstract__Alternatives"


    // $ANTLR start "rule__Concrete0__Alternatives"
    // InternalEcore2XtextTest.g:279:1: rule__Concrete0__Alternatives : ( ( ruleConcrete0_Impl ) | ( ruleDiamondInheritance ) );
    public final void rule__Concrete0__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:283:1: ( ( ruleConcrete0_Impl ) | ( ruleDiamondInheritance ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            else if ( (LA2_0==20) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalEcore2XtextTest.g:284:2: ( ruleConcrete0_Impl )
                    {
                    // InternalEcore2XtextTest.g:284:2: ( ruleConcrete0_Impl )
                    // InternalEcore2XtextTest.g:285:3: ruleConcrete0_Impl
                    {
                     before(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleConcrete0_Impl();

                    state._fsp--;

                     after(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEcore2XtextTest.g:290:2: ( ruleDiamondInheritance )
                    {
                    // InternalEcore2XtextTest.g:290:2: ( ruleDiamondInheritance )
                    // InternalEcore2XtextTest.g:291:3: ruleDiamondInheritance
                    {
                     before(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDiamondInheritance();

                    state._fsp--;

                     after(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1()); 

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
    // $ANTLR end "rule__Concrete0__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalEcore2XtextTest.g:300:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:304:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalEcore2XtextTest.g:305:2: ( RULE_STRING )
                    {
                    // InternalEcore2XtextTest.g:305:2: ( RULE_STRING )
                    // InternalEcore2XtextTest.g:306:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEcore2XtextTest.g:311:2: ( RULE_ID )
                    {
                    // InternalEcore2XtextTest.g:311:2: ( RULE_ID )
                    // InternalEcore2XtextTest.g:312:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__Root__Group__0"
    // InternalEcore2XtextTest.g:321:1: rule__Root__Group__0 : rule__Root__Group__0__Impl rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:325:1: ( rule__Root__Group__0__Impl rule__Root__Group__1 )
            // InternalEcore2XtextTest.g:326:2: rule__Root__Group__0__Impl rule__Root__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Root__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__0"


    // $ANTLR start "rule__Root__Group__0__Impl"
    // InternalEcore2XtextTest.g:333:1: rule__Root__Group__0__Impl : ( () ) ;
    public final void rule__Root__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:337:1: ( ( () ) )
            // InternalEcore2XtextTest.g:338:1: ( () )
            {
            // InternalEcore2XtextTest.g:338:1: ( () )
            // InternalEcore2XtextTest.g:339:2: ()
            {
             before(grammarAccess.getRootAccess().getRootAction_0()); 
            // InternalEcore2XtextTest.g:340:2: ()
            // InternalEcore2XtextTest.g:340:3: 
            {
            }

             after(grammarAccess.getRootAccess().getRootAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__0__Impl"


    // $ANTLR start "rule__Root__Group__1"
    // InternalEcore2XtextTest.g:348:1: rule__Root__Group__1 : rule__Root__Group__1__Impl rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:352:1: ( rule__Root__Group__1__Impl rule__Root__Group__2 )
            // InternalEcore2XtextTest.g:353:2: rule__Root__Group__1__Impl rule__Root__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Root__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__1"


    // $ANTLR start "rule__Root__Group__1__Impl"
    // InternalEcore2XtextTest.g:360:1: rule__Root__Group__1__Impl : ( 'Root' ) ;
    public final void rule__Root__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:364:1: ( ( 'Root' ) )
            // InternalEcore2XtextTest.g:365:1: ( 'Root' )
            {
            // InternalEcore2XtextTest.g:365:1: ( 'Root' )
            // InternalEcore2XtextTest.g:366:2: 'Root'
            {
             before(grammarAccess.getRootAccess().getRootKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getRootKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__1__Impl"


    // $ANTLR start "rule__Root__Group__2"
    // InternalEcore2XtextTest.g:375:1: rule__Root__Group__2 : rule__Root__Group__2__Impl rule__Root__Group__3 ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:379:1: ( rule__Root__Group__2__Impl rule__Root__Group__3 )
            // InternalEcore2XtextTest.g:380:2: rule__Root__Group__2__Impl rule__Root__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Root__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__2"


    // $ANTLR start "rule__Root__Group__2__Impl"
    // InternalEcore2XtextTest.g:387:1: rule__Root__Group__2__Impl : ( ( rule__Root__NameAssignment_2 ) ) ;
    public final void rule__Root__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:391:1: ( ( ( rule__Root__NameAssignment_2 ) ) )
            // InternalEcore2XtextTest.g:392:1: ( ( rule__Root__NameAssignment_2 ) )
            {
            // InternalEcore2XtextTest.g:392:1: ( ( rule__Root__NameAssignment_2 ) )
            // InternalEcore2XtextTest.g:393:2: ( rule__Root__NameAssignment_2 )
            {
             before(grammarAccess.getRootAccess().getNameAssignment_2()); 
            // InternalEcore2XtextTest.g:394:2: ( rule__Root__NameAssignment_2 )
            // InternalEcore2XtextTest.g:394:3: rule__Root__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__2__Impl"


    // $ANTLR start "rule__Root__Group__3"
    // InternalEcore2XtextTest.g:402:1: rule__Root__Group__3 : rule__Root__Group__3__Impl rule__Root__Group__4 ;
    public final void rule__Root__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:406:1: ( rule__Root__Group__3__Impl rule__Root__Group__4 )
            // InternalEcore2XtextTest.g:407:2: rule__Root__Group__3__Impl rule__Root__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Root__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__3"


    // $ANTLR start "rule__Root__Group__3__Impl"
    // InternalEcore2XtextTest.g:414:1: rule__Root__Group__3__Impl : ( '{' ) ;
    public final void rule__Root__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:418:1: ( ( '{' ) )
            // InternalEcore2XtextTest.g:419:1: ( '{' )
            {
            // InternalEcore2XtextTest.g:419:1: ( '{' )
            // InternalEcore2XtextTest.g:420:2: '{'
            {
             before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__3__Impl"


    // $ANTLR start "rule__Root__Group__4"
    // InternalEcore2XtextTest.g:429:1: rule__Root__Group__4 : rule__Root__Group__4__Impl rule__Root__Group__5 ;
    public final void rule__Root__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:433:1: ( rule__Root__Group__4__Impl rule__Root__Group__5 )
            // InternalEcore2XtextTest.g:434:2: rule__Root__Group__4__Impl rule__Root__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Root__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__4"


    // $ANTLR start "rule__Root__Group__4__Impl"
    // InternalEcore2XtextTest.g:441:1: rule__Root__Group__4__Impl : ( ( rule__Root__Group_4__0 )? ) ;
    public final void rule__Root__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:445:1: ( ( ( rule__Root__Group_4__0 )? ) )
            // InternalEcore2XtextTest.g:446:1: ( ( rule__Root__Group_4__0 )? )
            {
            // InternalEcore2XtextTest.g:446:1: ( ( rule__Root__Group_4__0 )? )
            // InternalEcore2XtextTest.g:447:2: ( rule__Root__Group_4__0 )?
            {
             before(grammarAccess.getRootAccess().getGroup_4()); 
            // InternalEcore2XtextTest.g:448:2: ( rule__Root__Group_4__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalEcore2XtextTest.g:448:3: rule__Root__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Root__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__4__Impl"


    // $ANTLR start "rule__Root__Group__5"
    // InternalEcore2XtextTest.g:456:1: rule__Root__Group__5 : rule__Root__Group__5__Impl rule__Root__Group__6 ;
    public final void rule__Root__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:460:1: ( rule__Root__Group__5__Impl rule__Root__Group__6 )
            // InternalEcore2XtextTest.g:461:2: rule__Root__Group__5__Impl rule__Root__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Root__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__5"


    // $ANTLR start "rule__Root__Group__5__Impl"
    // InternalEcore2XtextTest.g:468:1: rule__Root__Group__5__Impl : ( ( rule__Root__Group_5__0 )? ) ;
    public final void rule__Root__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:472:1: ( ( ( rule__Root__Group_5__0 )? ) )
            // InternalEcore2XtextTest.g:473:1: ( ( rule__Root__Group_5__0 )? )
            {
            // InternalEcore2XtextTest.g:473:1: ( ( rule__Root__Group_5__0 )? )
            // InternalEcore2XtextTest.g:474:2: ( rule__Root__Group_5__0 )?
            {
             before(grammarAccess.getRootAccess().getGroup_5()); 
            // InternalEcore2XtextTest.g:475:2: ( rule__Root__Group_5__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalEcore2XtextTest.g:475:3: rule__Root__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Root__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__5__Impl"


    // $ANTLR start "rule__Root__Group__6"
    // InternalEcore2XtextTest.g:483:1: rule__Root__Group__6 : rule__Root__Group__6__Impl ;
    public final void rule__Root__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:487:1: ( rule__Root__Group__6__Impl )
            // InternalEcore2XtextTest.g:488:2: rule__Root__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__6"


    // $ANTLR start "rule__Root__Group__6__Impl"
    // InternalEcore2XtextTest.g:494:1: rule__Root__Group__6__Impl : ( '}' ) ;
    public final void rule__Root__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:498:1: ( ( '}' ) )
            // InternalEcore2XtextTest.g:499:1: ( '}' )
            {
            // InternalEcore2XtextTest.g:499:1: ( '}' )
            // InternalEcore2XtextTest.g:500:2: '}'
            {
             before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__6__Impl"


    // $ANTLR start "rule__Root__Group_4__0"
    // InternalEcore2XtextTest.g:510:1: rule__Root__Group_4__0 : rule__Root__Group_4__0__Impl rule__Root__Group_4__1 ;
    public final void rule__Root__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:514:1: ( rule__Root__Group_4__0__Impl rule__Root__Group_4__1 )
            // InternalEcore2XtextTest.g:515:2: rule__Root__Group_4__0__Impl rule__Root__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Root__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4__0"


    // $ANTLR start "rule__Root__Group_4__0__Impl"
    // InternalEcore2XtextTest.g:522:1: rule__Root__Group_4__0__Impl : ( 'classes' ) ;
    public final void rule__Root__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:526:1: ( ( 'classes' ) )
            // InternalEcore2XtextTest.g:527:1: ( 'classes' )
            {
            // InternalEcore2XtextTest.g:527:1: ( 'classes' )
            // InternalEcore2XtextTest.g:528:2: 'classes'
            {
             before(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getClassesKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4__0__Impl"


    // $ANTLR start "rule__Root__Group_4__1"
    // InternalEcore2XtextTest.g:537:1: rule__Root__Group_4__1 : rule__Root__Group_4__1__Impl rule__Root__Group_4__2 ;
    public final void rule__Root__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:541:1: ( rule__Root__Group_4__1__Impl rule__Root__Group_4__2 )
            // InternalEcore2XtextTest.g:542:2: rule__Root__Group_4__1__Impl rule__Root__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Root__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4__1"


    // $ANTLR start "rule__Root__Group_4__1__Impl"
    // InternalEcore2XtextTest.g:549:1: rule__Root__Group_4__1__Impl : ( '{' ) ;
    public final void rule__Root__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:553:1: ( ( '{' ) )
            // InternalEcore2XtextTest.g:554:1: ( '{' )
            {
            // InternalEcore2XtextTest.g:554:1: ( '{' )
            // InternalEcore2XtextTest.g:555:2: '{'
            {
             before(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4__1__Impl"


    // $ANTLR start "rule__Root__Group_4__2"
    // InternalEcore2XtextTest.g:564:1: rule__Root__Group_4__2 : rule__Root__Group_4__2__Impl rule__Root__Group_4__3 ;
    public final void rule__Root__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:568:1: ( rule__Root__Group_4__2__Impl rule__Root__Group_4__3 )
            // InternalEcore2XtextTest.g:569:2: rule__Root__Group_4__2__Impl rule__Root__Group_4__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Root__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4__2"


    // $ANTLR start "rule__Root__Group_4__2__Impl"
    // InternalEcore2XtextTest.g:576:1: rule__Root__Group_4__2__Impl : ( ( rule__Root__ClassesAssignment_4_2 ) ) ;
    public final void rule__Root__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:580:1: ( ( ( rule__Root__ClassesAssignment_4_2 ) ) )
            // InternalEcore2XtextTest.g:581:1: ( ( rule__Root__ClassesAssignment_4_2 ) )
            {
            // InternalEcore2XtextTest.g:581:1: ( ( rule__Root__ClassesAssignment_4_2 ) )
            // InternalEcore2XtextTest.g:582:2: ( rule__Root__ClassesAssignment_4_2 )
            {
             before(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 
            // InternalEcore2XtextTest.g:583:2: ( rule__Root__ClassesAssignment_4_2 )
            // InternalEcore2XtextTest.g:583:3: rule__Root__ClassesAssignment_4_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__ClassesAssignment_4_2();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getClassesAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4__2__Impl"


    // $ANTLR start "rule__Root__Group_4__3"
    // InternalEcore2XtextTest.g:591:1: rule__Root__Group_4__3 : rule__Root__Group_4__3__Impl rule__Root__Group_4__4 ;
    public final void rule__Root__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:595:1: ( rule__Root__Group_4__3__Impl rule__Root__Group_4__4 )
            // InternalEcore2XtextTest.g:596:2: rule__Root__Group_4__3__Impl rule__Root__Group_4__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Root__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4__3"


    // $ANTLR start "rule__Root__Group_4__3__Impl"
    // InternalEcore2XtextTest.g:603:1: rule__Root__Group_4__3__Impl : ( ( rule__Root__Group_4_3__0 )* ) ;
    public final void rule__Root__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:607:1: ( ( ( rule__Root__Group_4_3__0 )* ) )
            // InternalEcore2XtextTest.g:608:1: ( ( rule__Root__Group_4_3__0 )* )
            {
            // InternalEcore2XtextTest.g:608:1: ( ( rule__Root__Group_4_3__0 )* )
            // InternalEcore2XtextTest.g:609:2: ( rule__Root__Group_4_3__0 )*
            {
             before(grammarAccess.getRootAccess().getGroup_4_3()); 
            // InternalEcore2XtextTest.g:610:2: ( rule__Root__Group_4_3__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==16) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalEcore2XtextTest.g:610:3: rule__Root__Group_4_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__Root__Group_4_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRootAccess().getGroup_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4__3__Impl"


    // $ANTLR start "rule__Root__Group_4__4"
    // InternalEcore2XtextTest.g:618:1: rule__Root__Group_4__4 : rule__Root__Group_4__4__Impl ;
    public final void rule__Root__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:622:1: ( rule__Root__Group_4__4__Impl )
            // InternalEcore2XtextTest.g:623:2: rule__Root__Group_4__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4__4"


    // $ANTLR start "rule__Root__Group_4__4__Impl"
    // InternalEcore2XtextTest.g:629:1: rule__Root__Group_4__4__Impl : ( '}' ) ;
    public final void rule__Root__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:633:1: ( ( '}' ) )
            // InternalEcore2XtextTest.g:634:1: ( '}' )
            {
            // InternalEcore2XtextTest.g:634:1: ( '}' )
            // InternalEcore2XtextTest.g:635:2: '}'
            {
             before(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4__4__Impl"


    // $ANTLR start "rule__Root__Group_4_3__0"
    // InternalEcore2XtextTest.g:645:1: rule__Root__Group_4_3__0 : rule__Root__Group_4_3__0__Impl rule__Root__Group_4_3__1 ;
    public final void rule__Root__Group_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:649:1: ( rule__Root__Group_4_3__0__Impl rule__Root__Group_4_3__1 )
            // InternalEcore2XtextTest.g:650:2: rule__Root__Group_4_3__0__Impl rule__Root__Group_4_3__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Root__Group_4_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4_3__0"


    // $ANTLR start "rule__Root__Group_4_3__0__Impl"
    // InternalEcore2XtextTest.g:657:1: rule__Root__Group_4_3__0__Impl : ( ',' ) ;
    public final void rule__Root__Group_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:661:1: ( ( ',' ) )
            // InternalEcore2XtextTest.g:662:1: ( ',' )
            {
            // InternalEcore2XtextTest.g:662:1: ( ',' )
            // InternalEcore2XtextTest.g:663:2: ','
            {
             before(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getCommaKeyword_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4_3__0__Impl"


    // $ANTLR start "rule__Root__Group_4_3__1"
    // InternalEcore2XtextTest.g:672:1: rule__Root__Group_4_3__1 : rule__Root__Group_4_3__1__Impl ;
    public final void rule__Root__Group_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:676:1: ( rule__Root__Group_4_3__1__Impl )
            // InternalEcore2XtextTest.g:677:2: rule__Root__Group_4_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_4_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4_3__1"


    // $ANTLR start "rule__Root__Group_4_3__1__Impl"
    // InternalEcore2XtextTest.g:683:1: rule__Root__Group_4_3__1__Impl : ( ( rule__Root__ClassesAssignment_4_3_1 ) ) ;
    public final void rule__Root__Group_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:687:1: ( ( ( rule__Root__ClassesAssignment_4_3_1 ) ) )
            // InternalEcore2XtextTest.g:688:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            {
            // InternalEcore2XtextTest.g:688:1: ( ( rule__Root__ClassesAssignment_4_3_1 ) )
            // InternalEcore2XtextTest.g:689:2: ( rule__Root__ClassesAssignment_4_3_1 )
            {
             before(grammarAccess.getRootAccess().getClassesAssignment_4_3_1()); 
            // InternalEcore2XtextTest.g:690:2: ( rule__Root__ClassesAssignment_4_3_1 )
            // InternalEcore2XtextTest.g:690:3: rule__Root__ClassesAssignment_4_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__ClassesAssignment_4_3_1();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getClassesAssignment_4_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_4_3__1__Impl"


    // $ANTLR start "rule__Root__Group_5__0"
    // InternalEcore2XtextTest.g:699:1: rule__Root__Group_5__0 : rule__Root__Group_5__0__Impl rule__Root__Group_5__1 ;
    public final void rule__Root__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:703:1: ( rule__Root__Group_5__0__Impl rule__Root__Group_5__1 )
            // InternalEcore2XtextTest.g:704:2: rule__Root__Group_5__0__Impl rule__Root__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Root__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_5__0"


    // $ANTLR start "rule__Root__Group_5__0__Impl"
    // InternalEcore2XtextTest.g:711:1: rule__Root__Group_5__0__Impl : ( 'concrete0' ) ;
    public final void rule__Root__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:715:1: ( ( 'concrete0' ) )
            // InternalEcore2XtextTest.g:716:1: ( 'concrete0' )
            {
            // InternalEcore2XtextTest.g:716:1: ( 'concrete0' )
            // InternalEcore2XtextTest.g:717:2: 'concrete0'
            {
             before(grammarAccess.getRootAccess().getConcrete0Keyword_5_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRootAccess().getConcrete0Keyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_5__0__Impl"


    // $ANTLR start "rule__Root__Group_5__1"
    // InternalEcore2XtextTest.g:726:1: rule__Root__Group_5__1 : rule__Root__Group_5__1__Impl ;
    public final void rule__Root__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:730:1: ( rule__Root__Group_5__1__Impl )
            // InternalEcore2XtextTest.g:731:2: rule__Root__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_5__1"


    // $ANTLR start "rule__Root__Group_5__1__Impl"
    // InternalEcore2XtextTest.g:737:1: rule__Root__Group_5__1__Impl : ( ( rule__Root__Concrete0Assignment_5_1 ) ) ;
    public final void rule__Root__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:741:1: ( ( ( rule__Root__Concrete0Assignment_5_1 ) ) )
            // InternalEcore2XtextTest.g:742:1: ( ( rule__Root__Concrete0Assignment_5_1 ) )
            {
            // InternalEcore2XtextTest.g:742:1: ( ( rule__Root__Concrete0Assignment_5_1 ) )
            // InternalEcore2XtextTest.g:743:2: ( rule__Root__Concrete0Assignment_5_1 )
            {
             before(grammarAccess.getRootAccess().getConcrete0Assignment_5_1()); 
            // InternalEcore2XtextTest.g:744:2: ( rule__Root__Concrete0Assignment_5_1 )
            // InternalEcore2XtextTest.g:744:3: rule__Root__Concrete0Assignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Root__Concrete0Assignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getConcrete0Assignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group_5__1__Impl"


    // $ANTLR start "rule__Concrete0_Impl__Group__0"
    // InternalEcore2XtextTest.g:753:1: rule__Concrete0_Impl__Group__0 : rule__Concrete0_Impl__Group__0__Impl rule__Concrete0_Impl__Group__1 ;
    public final void rule__Concrete0_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:757:1: ( rule__Concrete0_Impl__Group__0__Impl rule__Concrete0_Impl__Group__1 )
            // InternalEcore2XtextTest.g:758:2: rule__Concrete0_Impl__Group__0__Impl rule__Concrete0_Impl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Concrete0_Impl__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0_Impl__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete0_Impl__Group__0"


    // $ANTLR start "rule__Concrete0_Impl__Group__0__Impl"
    // InternalEcore2XtextTest.g:765:1: rule__Concrete0_Impl__Group__0__Impl : ( () ) ;
    public final void rule__Concrete0_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:769:1: ( ( () ) )
            // InternalEcore2XtextTest.g:770:1: ( () )
            {
            // InternalEcore2XtextTest.g:770:1: ( () )
            // InternalEcore2XtextTest.g:771:2: ()
            {
             before(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0()); 
            // InternalEcore2XtextTest.g:772:2: ()
            // InternalEcore2XtextTest.g:772:3: 
            {
            }

             after(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete0_Impl__Group__0__Impl"


    // $ANTLR start "rule__Concrete0_Impl__Group__1"
    // InternalEcore2XtextTest.g:780:1: rule__Concrete0_Impl__Group__1 : rule__Concrete0_Impl__Group__1__Impl rule__Concrete0_Impl__Group__2 ;
    public final void rule__Concrete0_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:784:1: ( rule__Concrete0_Impl__Group__1__Impl rule__Concrete0_Impl__Group__2 )
            // InternalEcore2XtextTest.g:785:2: rule__Concrete0_Impl__Group__1__Impl rule__Concrete0_Impl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Concrete0_Impl__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0_Impl__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete0_Impl__Group__1"


    // $ANTLR start "rule__Concrete0_Impl__Group__1__Impl"
    // InternalEcore2XtextTest.g:792:1: rule__Concrete0_Impl__Group__1__Impl : ( 'Concrete0' ) ;
    public final void rule__Concrete0_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:796:1: ( ( 'Concrete0' ) )
            // InternalEcore2XtextTest.g:797:1: ( 'Concrete0' )
            {
            // InternalEcore2XtextTest.g:797:1: ( 'Concrete0' )
            // InternalEcore2XtextTest.g:798:2: 'Concrete0'
            {
             before(grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete0_Impl__Group__1__Impl"


    // $ANTLR start "rule__Concrete0_Impl__Group__2"
    // InternalEcore2XtextTest.g:807:1: rule__Concrete0_Impl__Group__2 : rule__Concrete0_Impl__Group__2__Impl ;
    public final void rule__Concrete0_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:811:1: ( rule__Concrete0_Impl__Group__2__Impl )
            // InternalEcore2XtextTest.g:812:2: rule__Concrete0_Impl__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0_Impl__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete0_Impl__Group__2"


    // $ANTLR start "rule__Concrete0_Impl__Group__2__Impl"
    // InternalEcore2XtextTest.g:818:1: rule__Concrete0_Impl__Group__2__Impl : ( ( rule__Concrete0_Impl__NameAssignment_2 ) ) ;
    public final void rule__Concrete0_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:822:1: ( ( ( rule__Concrete0_Impl__NameAssignment_2 ) ) )
            // InternalEcore2XtextTest.g:823:1: ( ( rule__Concrete0_Impl__NameAssignment_2 ) )
            {
            // InternalEcore2XtextTest.g:823:1: ( ( rule__Concrete0_Impl__NameAssignment_2 ) )
            // InternalEcore2XtextTest.g:824:2: ( rule__Concrete0_Impl__NameAssignment_2 )
            {
             before(grammarAccess.getConcrete0_ImplAccess().getNameAssignment_2()); 
            // InternalEcore2XtextTest.g:825:2: ( rule__Concrete0_Impl__NameAssignment_2 )
            // InternalEcore2XtextTest.g:825:3: rule__Concrete0_Impl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete0_Impl__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConcrete0_ImplAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete0_Impl__Group__2__Impl"


    // $ANTLR start "rule__Concrete1_Impl__Group__0"
    // InternalEcore2XtextTest.g:834:1: rule__Concrete1_Impl__Group__0 : rule__Concrete1_Impl__Group__0__Impl rule__Concrete1_Impl__Group__1 ;
    public final void rule__Concrete1_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:838:1: ( rule__Concrete1_Impl__Group__0__Impl rule__Concrete1_Impl__Group__1 )
            // InternalEcore2XtextTest.g:839:2: rule__Concrete1_Impl__Group__0__Impl rule__Concrete1_Impl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Concrete1_Impl__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete1_Impl__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete1_Impl__Group__0"


    // $ANTLR start "rule__Concrete1_Impl__Group__0__Impl"
    // InternalEcore2XtextTest.g:846:1: rule__Concrete1_Impl__Group__0__Impl : ( () ) ;
    public final void rule__Concrete1_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:850:1: ( ( () ) )
            // InternalEcore2XtextTest.g:851:1: ( () )
            {
            // InternalEcore2XtextTest.g:851:1: ( () )
            // InternalEcore2XtextTest.g:852:2: ()
            {
             before(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0()); 
            // InternalEcore2XtextTest.g:853:2: ()
            // InternalEcore2XtextTest.g:853:3: 
            {
            }

             after(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete1_Impl__Group__0__Impl"


    // $ANTLR start "rule__Concrete1_Impl__Group__1"
    // InternalEcore2XtextTest.g:861:1: rule__Concrete1_Impl__Group__1 : rule__Concrete1_Impl__Group__1__Impl rule__Concrete1_Impl__Group__2 ;
    public final void rule__Concrete1_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:865:1: ( rule__Concrete1_Impl__Group__1__Impl rule__Concrete1_Impl__Group__2 )
            // InternalEcore2XtextTest.g:866:2: rule__Concrete1_Impl__Group__1__Impl rule__Concrete1_Impl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Concrete1_Impl__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete1_Impl__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete1_Impl__Group__1"


    // $ANTLR start "rule__Concrete1_Impl__Group__1__Impl"
    // InternalEcore2XtextTest.g:873:1: rule__Concrete1_Impl__Group__1__Impl : ( 'Concrete1' ) ;
    public final void rule__Concrete1_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:877:1: ( ( 'Concrete1' ) )
            // InternalEcore2XtextTest.g:878:1: ( 'Concrete1' )
            {
            // InternalEcore2XtextTest.g:878:1: ( 'Concrete1' )
            // InternalEcore2XtextTest.g:879:2: 'Concrete1'
            {
             before(grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete1_Impl__Group__1__Impl"


    // $ANTLR start "rule__Concrete1_Impl__Group__2"
    // InternalEcore2XtextTest.g:888:1: rule__Concrete1_Impl__Group__2 : rule__Concrete1_Impl__Group__2__Impl ;
    public final void rule__Concrete1_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:892:1: ( rule__Concrete1_Impl__Group__2__Impl )
            // InternalEcore2XtextTest.g:893:2: rule__Concrete1_Impl__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete1_Impl__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete1_Impl__Group__2"


    // $ANTLR start "rule__Concrete1_Impl__Group__2__Impl"
    // InternalEcore2XtextTest.g:899:1: rule__Concrete1_Impl__Group__2__Impl : ( ( rule__Concrete1_Impl__NameAssignment_2 ) ) ;
    public final void rule__Concrete1_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:903:1: ( ( ( rule__Concrete1_Impl__NameAssignment_2 ) ) )
            // InternalEcore2XtextTest.g:904:1: ( ( rule__Concrete1_Impl__NameAssignment_2 ) )
            {
            // InternalEcore2XtextTest.g:904:1: ( ( rule__Concrete1_Impl__NameAssignment_2 ) )
            // InternalEcore2XtextTest.g:905:2: ( rule__Concrete1_Impl__NameAssignment_2 )
            {
             before(grammarAccess.getConcrete1_ImplAccess().getNameAssignment_2()); 
            // InternalEcore2XtextTest.g:906:2: ( rule__Concrete1_Impl__NameAssignment_2 )
            // InternalEcore2XtextTest.g:906:3: rule__Concrete1_Impl__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Concrete1_Impl__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConcrete1_ImplAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete1_Impl__Group__2__Impl"


    // $ANTLR start "rule__DiamondInheritance__Group__0"
    // InternalEcore2XtextTest.g:915:1: rule__DiamondInheritance__Group__0 : rule__DiamondInheritance__Group__0__Impl rule__DiamondInheritance__Group__1 ;
    public final void rule__DiamondInheritance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:919:1: ( rule__DiamondInheritance__Group__0__Impl rule__DiamondInheritance__Group__1 )
            // InternalEcore2XtextTest.g:920:2: rule__DiamondInheritance__Group__0__Impl rule__DiamondInheritance__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__DiamondInheritance__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__DiamondInheritance__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DiamondInheritance__Group__0"


    // $ANTLR start "rule__DiamondInheritance__Group__0__Impl"
    // InternalEcore2XtextTest.g:927:1: rule__DiamondInheritance__Group__0__Impl : ( () ) ;
    public final void rule__DiamondInheritance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:931:1: ( ( () ) )
            // InternalEcore2XtextTest.g:932:1: ( () )
            {
            // InternalEcore2XtextTest.g:932:1: ( () )
            // InternalEcore2XtextTest.g:933:2: ()
            {
             before(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0()); 
            // InternalEcore2XtextTest.g:934:2: ()
            // InternalEcore2XtextTest.g:934:3: 
            {
            }

             after(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DiamondInheritance__Group__0__Impl"


    // $ANTLR start "rule__DiamondInheritance__Group__1"
    // InternalEcore2XtextTest.g:942:1: rule__DiamondInheritance__Group__1 : rule__DiamondInheritance__Group__1__Impl rule__DiamondInheritance__Group__2 ;
    public final void rule__DiamondInheritance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:946:1: ( rule__DiamondInheritance__Group__1__Impl rule__DiamondInheritance__Group__2 )
            // InternalEcore2XtextTest.g:947:2: rule__DiamondInheritance__Group__1__Impl rule__DiamondInheritance__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__DiamondInheritance__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__DiamondInheritance__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DiamondInheritance__Group__1"


    // $ANTLR start "rule__DiamondInheritance__Group__1__Impl"
    // InternalEcore2XtextTest.g:954:1: rule__DiamondInheritance__Group__1__Impl : ( 'DiamondInheritance' ) ;
    public final void rule__DiamondInheritance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:958:1: ( ( 'DiamondInheritance' ) )
            // InternalEcore2XtextTest.g:959:1: ( 'DiamondInheritance' )
            {
            // InternalEcore2XtextTest.g:959:1: ( 'DiamondInheritance' )
            // InternalEcore2XtextTest.g:960:2: 'DiamondInheritance'
            {
             before(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DiamondInheritance__Group__1__Impl"


    // $ANTLR start "rule__DiamondInheritance__Group__2"
    // InternalEcore2XtextTest.g:969:1: rule__DiamondInheritance__Group__2 : rule__DiamondInheritance__Group__2__Impl ;
    public final void rule__DiamondInheritance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:973:1: ( rule__DiamondInheritance__Group__2__Impl )
            // InternalEcore2XtextTest.g:974:2: rule__DiamondInheritance__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DiamondInheritance__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DiamondInheritance__Group__2"


    // $ANTLR start "rule__DiamondInheritance__Group__2__Impl"
    // InternalEcore2XtextTest.g:980:1: rule__DiamondInheritance__Group__2__Impl : ( ( rule__DiamondInheritance__NameAssignment_2 ) ) ;
    public final void rule__DiamondInheritance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:984:1: ( ( ( rule__DiamondInheritance__NameAssignment_2 ) ) )
            // InternalEcore2XtextTest.g:985:1: ( ( rule__DiamondInheritance__NameAssignment_2 ) )
            {
            // InternalEcore2XtextTest.g:985:1: ( ( rule__DiamondInheritance__NameAssignment_2 ) )
            // InternalEcore2XtextTest.g:986:2: ( rule__DiamondInheritance__NameAssignment_2 )
            {
             before(grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2()); 
            // InternalEcore2XtextTest.g:987:2: ( rule__DiamondInheritance__NameAssignment_2 )
            // InternalEcore2XtextTest.g:987:3: rule__DiamondInheritance__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DiamondInheritance__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DiamondInheritance__Group__2__Impl"


    // $ANTLR start "rule__Root__NameAssignment_2"
    // InternalEcore2XtextTest.g:996:1: rule__Root__NameAssignment_2 : ( ruleINT0 ) ;
    public final void rule__Root__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1000:1: ( ( ruleINT0 ) )
            // InternalEcore2XtextTest.g:1001:2: ( ruleINT0 )
            {
            // InternalEcore2XtextTest.g:1001:2: ( ruleINT0 )
            // InternalEcore2XtextTest.g:1002:3: ruleINT0
            {
             before(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleINT0();

            state._fsp--;

             after(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__NameAssignment_2"


    // $ANTLR start "rule__Root__ClassesAssignment_4_2"
    // InternalEcore2XtextTest.g:1011:1: rule__Root__ClassesAssignment_4_2 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1015:1: ( ( ruleAbstract ) )
            // InternalEcore2XtextTest.g:1016:2: ( ruleAbstract )
            {
            // InternalEcore2XtextTest.g:1016:2: ( ruleAbstract )
            // InternalEcore2XtextTest.g:1017:3: ruleAbstract
            {
             before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstract();

            state._fsp--;

             after(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__ClassesAssignment_4_2"


    // $ANTLR start "rule__Root__ClassesAssignment_4_3_1"
    // InternalEcore2XtextTest.g:1026:1: rule__Root__ClassesAssignment_4_3_1 : ( ruleAbstract ) ;
    public final void rule__Root__ClassesAssignment_4_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1030:1: ( ( ruleAbstract ) )
            // InternalEcore2XtextTest.g:1031:2: ( ruleAbstract )
            {
            // InternalEcore2XtextTest.g:1031:2: ( ruleAbstract )
            // InternalEcore2XtextTest.g:1032:3: ruleAbstract
            {
             before(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstract();

            state._fsp--;

             after(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__ClassesAssignment_4_3_1"


    // $ANTLR start "rule__Root__Concrete0Assignment_5_1"
    // InternalEcore2XtextTest.g:1041:1: rule__Root__Concrete0Assignment_5_1 : ( ruleConcrete0 ) ;
    public final void rule__Root__Concrete0Assignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1045:1: ( ( ruleConcrete0 ) )
            // InternalEcore2XtextTest.g:1046:2: ( ruleConcrete0 )
            {
            // InternalEcore2XtextTest.g:1046:2: ( ruleConcrete0 )
            // InternalEcore2XtextTest.g:1047:3: ruleConcrete0
            {
             before(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConcrete0();

            state._fsp--;

             after(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Concrete0Assignment_5_1"


    // $ANTLR start "rule__Concrete0_Impl__NameAssignment_2"
    // InternalEcore2XtextTest.g:1056:1: rule__Concrete0_Impl__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Concrete0_Impl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1060:1: ( ( ruleEString ) )
            // InternalEcore2XtextTest.g:1061:2: ( ruleEString )
            {
            // InternalEcore2XtextTest.g:1061:2: ( ruleEString )
            // InternalEcore2XtextTest.g:1062:3: ruleEString
            {
             before(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete0_Impl__NameAssignment_2"


    // $ANTLR start "rule__Concrete1_Impl__NameAssignment_2"
    // InternalEcore2XtextTest.g:1071:1: rule__Concrete1_Impl__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Concrete1_Impl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1075:1: ( ( ruleEString ) )
            // InternalEcore2XtextTest.g:1076:2: ( ruleEString )
            {
            // InternalEcore2XtextTest.g:1076:2: ( ruleEString )
            // InternalEcore2XtextTest.g:1077:3: ruleEString
            {
             before(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concrete1_Impl__NameAssignment_2"


    // $ANTLR start "rule__DiamondInheritance__NameAssignment_2"
    // InternalEcore2XtextTest.g:1086:1: rule__DiamondInheritance__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__DiamondInheritance__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEcore2XtextTest.g:1090:1: ( ( ruleEString ) )
            // InternalEcore2XtextTest.g:1091:2: ( ruleEString )
            {
            // InternalEcore2XtextTest.g:1091:2: ( ruleEString )
            // InternalEcore2XtextTest.g:1092:3: ruleEString
            {
             before(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DiamondInheritance__NameAssignment_2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000002C000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    }


}
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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug286935TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug286935TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'NORMAL'", "'cond'", "'reference'", "'textual'", "'state'", "'init'", "'final'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug286935TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug286935TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug286935TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug286935TestLanguage.g"; }


    	private Bug286935TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug286935TestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleState"
    // InternalBug286935TestLanguage.g:53:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // InternalBug286935TestLanguage.g:54:1: ( ruleState EOF )
            // InternalBug286935TestLanguage.g:55:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStateRule()); 
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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalBug286935TestLanguage.g:62:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:66:2: ( ( ( rule__State__Group__0 ) ) )
            // InternalBug286935TestLanguage.g:67:2: ( ( rule__State__Group__0 ) )
            {
            // InternalBug286935TestLanguage.g:67:2: ( ( rule__State__Group__0 ) )
            // InternalBug286935TestLanguage.g:68:3: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // InternalBug286935TestLanguage.g:69:3: ( rule__State__Group__0 )
            // InternalBug286935TestLanguage.g:69:4: rule__State__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "ruleStateType"
    // InternalBug286935TestLanguage.g:78:1: ruleStateType : ( ( rule__StateType__Alternatives ) ) ;
    public final void ruleStateType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:82:1: ( ( ( rule__StateType__Alternatives ) ) )
            // InternalBug286935TestLanguage.g:83:2: ( ( rule__StateType__Alternatives ) )
            {
            // InternalBug286935TestLanguage.g:83:2: ( ( rule__StateType__Alternatives ) )
            // InternalBug286935TestLanguage.g:84:3: ( rule__StateType__Alternatives )
            {
             before(grammarAccess.getStateTypeAccess().getAlternatives()); 
            // InternalBug286935TestLanguage.g:85:3: ( rule__StateType__Alternatives )
            // InternalBug286935TestLanguage.g:85:4: rule__StateType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__StateType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStateTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStateType"


    // $ANTLR start "rule__State__Alternatives_1"
    // InternalBug286935TestLanguage.g:93:1: rule__State__Alternatives_1 : ( ( ( rule__State__IsInitialAssignment_1_0 ) ) | ( ( rule__State__IsFinalAssignment_1_1 ) ) | ( ( rule__State__StateKindAssignment_1_2 ) ) | ( ( rule__State__Group_1_3__0 ) ) | ( ( rule__State__Group_1_4__0 ) ) );
    public final void rule__State__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:97:1: ( ( ( rule__State__IsInitialAssignment_1_0 ) ) | ( ( rule__State__IsFinalAssignment_1_1 ) ) | ( ( rule__State__StateKindAssignment_1_2 ) ) | ( ( rule__State__Group_1_3__0 ) ) | ( ( rule__State__Group_1_4__0 ) ) )
            int alt1=5;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalBug286935TestLanguage.g:98:2: ( ( rule__State__IsInitialAssignment_1_0 ) )
                    {
                    // InternalBug286935TestLanguage.g:98:2: ( ( rule__State__IsInitialAssignment_1_0 ) )
                    // InternalBug286935TestLanguage.g:99:3: ( rule__State__IsInitialAssignment_1_0 )
                    {
                     before(grammarAccess.getStateAccess().getIsInitialAssignment_1_0()); 
                    // InternalBug286935TestLanguage.g:100:3: ( rule__State__IsInitialAssignment_1_0 )
                    // InternalBug286935TestLanguage.g:100:4: rule__State__IsInitialAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__State__IsInitialAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStateAccess().getIsInitialAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug286935TestLanguage.g:104:2: ( ( rule__State__IsFinalAssignment_1_1 ) )
                    {
                    // InternalBug286935TestLanguage.g:104:2: ( ( rule__State__IsFinalAssignment_1_1 ) )
                    // InternalBug286935TestLanguage.g:105:3: ( rule__State__IsFinalAssignment_1_1 )
                    {
                     before(grammarAccess.getStateAccess().getIsFinalAssignment_1_1()); 
                    // InternalBug286935TestLanguage.g:106:3: ( rule__State__IsFinalAssignment_1_1 )
                    // InternalBug286935TestLanguage.g:106:4: rule__State__IsFinalAssignment_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__State__IsFinalAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getStateAccess().getIsFinalAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug286935TestLanguage.g:110:2: ( ( rule__State__StateKindAssignment_1_2 ) )
                    {
                    // InternalBug286935TestLanguage.g:110:2: ( ( rule__State__StateKindAssignment_1_2 ) )
                    // InternalBug286935TestLanguage.g:111:3: ( rule__State__StateKindAssignment_1_2 )
                    {
                     before(grammarAccess.getStateAccess().getStateKindAssignment_1_2()); 
                    // InternalBug286935TestLanguage.g:112:3: ( rule__State__StateKindAssignment_1_2 )
                    // InternalBug286935TestLanguage.g:112:4: rule__State__StateKindAssignment_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__State__StateKindAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getStateAccess().getStateKindAssignment_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBug286935TestLanguage.g:116:2: ( ( rule__State__Group_1_3__0 ) )
                    {
                    // InternalBug286935TestLanguage.g:116:2: ( ( rule__State__Group_1_3__0 ) )
                    // InternalBug286935TestLanguage.g:117:3: ( rule__State__Group_1_3__0 )
                    {
                     before(grammarAccess.getStateAccess().getGroup_1_3()); 
                    // InternalBug286935TestLanguage.g:118:3: ( rule__State__Group_1_3__0 )
                    // InternalBug286935TestLanguage.g:118:4: rule__State__Group_1_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__State__Group_1_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStateAccess().getGroup_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBug286935TestLanguage.g:122:2: ( ( rule__State__Group_1_4__0 ) )
                    {
                    // InternalBug286935TestLanguage.g:122:2: ( ( rule__State__Group_1_4__0 ) )
                    // InternalBug286935TestLanguage.g:123:3: ( rule__State__Group_1_4__0 )
                    {
                     before(grammarAccess.getStateAccess().getGroup_1_4()); 
                    // InternalBug286935TestLanguage.g:124:3: ( rule__State__Group_1_4__0 )
                    // InternalBug286935TestLanguage.g:124:4: rule__State__Group_1_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__State__Group_1_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStateAccess().getGroup_1_4()); 

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
    // $ANTLR end "rule__State__Alternatives_1"


    // $ANTLR start "rule__StateType__Alternatives"
    // InternalBug286935TestLanguage.g:132:1: rule__StateType__Alternatives : ( ( ( 'NORMAL' ) ) | ( ( 'cond' ) ) | ( ( 'reference' ) ) | ( ( 'textual' ) ) );
    public final void rule__StateType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:136:1: ( ( ( 'NORMAL' ) ) | ( ( 'cond' ) ) | ( ( 'reference' ) ) | ( ( 'textual' ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalBug286935TestLanguage.g:137:2: ( ( 'NORMAL' ) )
                    {
                    // InternalBug286935TestLanguage.g:137:2: ( ( 'NORMAL' ) )
                    // InternalBug286935TestLanguage.g:138:3: ( 'NORMAL' )
                    {
                     before(grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0()); 
                    // InternalBug286935TestLanguage.g:139:3: ( 'NORMAL' )
                    // InternalBug286935TestLanguage.g:139:4: 'NORMAL'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug286935TestLanguage.g:143:2: ( ( 'cond' ) )
                    {
                    // InternalBug286935TestLanguage.g:143:2: ( ( 'cond' ) )
                    // InternalBug286935TestLanguage.g:144:3: ( 'cond' )
                    {
                     before(grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1()); 
                    // InternalBug286935TestLanguage.g:145:3: ( 'cond' )
                    // InternalBug286935TestLanguage.g:145:4: 'cond'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug286935TestLanguage.g:149:2: ( ( 'reference' ) )
                    {
                    // InternalBug286935TestLanguage.g:149:2: ( ( 'reference' ) )
                    // InternalBug286935TestLanguage.g:150:3: ( 'reference' )
                    {
                     before(grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2()); 
                    // InternalBug286935TestLanguage.g:151:3: ( 'reference' )
                    // InternalBug286935TestLanguage.g:151:4: 'reference'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBug286935TestLanguage.g:155:2: ( ( 'textual' ) )
                    {
                    // InternalBug286935TestLanguage.g:155:2: ( ( 'textual' ) )
                    // InternalBug286935TestLanguage.g:156:3: ( 'textual' )
                    {
                     before(grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3()); 
                    // InternalBug286935TestLanguage.g:157:3: ( 'textual' )
                    // InternalBug286935TestLanguage.g:157:4: 'textual'
                    {
                    match(input,14,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__StateType__Alternatives"


    // $ANTLR start "rule__State__Group__0"
    // InternalBug286935TestLanguage.g:165:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:169:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // InternalBug286935TestLanguage.g:170:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__State__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0"


    // $ANTLR start "rule__State__Group__0__Impl"
    // InternalBug286935TestLanguage.g:177:1: rule__State__Group__0__Impl : ( () ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:181:1: ( ( () ) )
            // InternalBug286935TestLanguage.g:182:1: ( () )
            {
            // InternalBug286935TestLanguage.g:182:1: ( () )
            // InternalBug286935TestLanguage.g:183:2: ()
            {
             before(grammarAccess.getStateAccess().getStateAction_0()); 
            // InternalBug286935TestLanguage.g:184:2: ()
            // InternalBug286935TestLanguage.g:184:3: 
            {
            }

             after(grammarAccess.getStateAccess().getStateAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0__Impl"


    // $ANTLR start "rule__State__Group__1"
    // InternalBug286935TestLanguage.g:192:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:196:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // InternalBug286935TestLanguage.g:197:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__State__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1"


    // $ANTLR start "rule__State__Group__1__Impl"
    // InternalBug286935TestLanguage.g:204:1: rule__State__Group__1__Impl : ( ( rule__State__Alternatives_1 )? ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:208:1: ( ( ( rule__State__Alternatives_1 )? ) )
            // InternalBug286935TestLanguage.g:209:1: ( ( rule__State__Alternatives_1 )? )
            {
            // InternalBug286935TestLanguage.g:209:1: ( ( rule__State__Alternatives_1 )? )
            // InternalBug286935TestLanguage.g:210:2: ( rule__State__Alternatives_1 )?
            {
             before(grammarAccess.getStateAccess().getAlternatives_1()); 
            // InternalBug286935TestLanguage.g:211:2: ( rule__State__Alternatives_1 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=11 && LA3_0<=14)||(LA3_0>=16 && LA3_0<=17)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug286935TestLanguage.g:211:3: rule__State__Alternatives_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__State__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1__Impl"


    // $ANTLR start "rule__State__Group__2"
    // InternalBug286935TestLanguage.g:219:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:223:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // InternalBug286935TestLanguage.g:224:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__State__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2"


    // $ANTLR start "rule__State__Group__2__Impl"
    // InternalBug286935TestLanguage.g:231:1: rule__State__Group__2__Impl : ( ( 'state' )? ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:235:1: ( ( ( 'state' )? ) )
            // InternalBug286935TestLanguage.g:236:1: ( ( 'state' )? )
            {
            // InternalBug286935TestLanguage.g:236:1: ( ( 'state' )? )
            // InternalBug286935TestLanguage.g:237:2: ( 'state' )?
            {
             before(grammarAccess.getStateAccess().getStateKeyword_2()); 
            // InternalBug286935TestLanguage.g:238:2: ( 'state' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug286935TestLanguage.g:238:3: 'state'
                    {
                    match(input,15,FollowSets000.FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getStateKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2__Impl"


    // $ANTLR start "rule__State__Group__3"
    // InternalBug286935TestLanguage.g:246:1: rule__State__Group__3 : rule__State__Group__3__Impl rule__State__Group__4 ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:250:1: ( rule__State__Group__3__Impl rule__State__Group__4 )
            // InternalBug286935TestLanguage.g:251:2: rule__State__Group__3__Impl rule__State__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__State__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3"


    // $ANTLR start "rule__State__Group__3__Impl"
    // InternalBug286935TestLanguage.g:258:1: rule__State__Group__3__Impl : ( ( rule__State__StateNameAssignment_3 )? ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:262:1: ( ( ( rule__State__StateNameAssignment_3 )? ) )
            // InternalBug286935TestLanguage.g:263:1: ( ( rule__State__StateNameAssignment_3 )? )
            {
            // InternalBug286935TestLanguage.g:263:1: ( ( rule__State__StateNameAssignment_3 )? )
            // InternalBug286935TestLanguage.g:264:2: ( rule__State__StateNameAssignment_3 )?
            {
             before(grammarAccess.getStateAccess().getStateNameAssignment_3()); 
            // InternalBug286935TestLanguage.g:265:2: ( rule__State__StateNameAssignment_3 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBug286935TestLanguage.g:265:3: rule__State__StateNameAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__State__StateNameAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getStateNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3__Impl"


    // $ANTLR start "rule__State__Group__4"
    // InternalBug286935TestLanguage.g:273:1: rule__State__Group__4 : rule__State__Group__4__Impl ;
    public final void rule__State__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:277:1: ( rule__State__Group__4__Impl )
            // InternalBug286935TestLanguage.g:278:2: rule__State__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__4"


    // $ANTLR start "rule__State__Group__4__Impl"
    // InternalBug286935TestLanguage.g:284:1: rule__State__Group__4__Impl : ( ( rule__State__LabelAssignment_4 )? ) ;
    public final void rule__State__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:288:1: ( ( ( rule__State__LabelAssignment_4 )? ) )
            // InternalBug286935TestLanguage.g:289:1: ( ( rule__State__LabelAssignment_4 )? )
            {
            // InternalBug286935TestLanguage.g:289:1: ( ( rule__State__LabelAssignment_4 )? )
            // InternalBug286935TestLanguage.g:290:2: ( rule__State__LabelAssignment_4 )?
            {
             before(grammarAccess.getStateAccess().getLabelAssignment_4()); 
            // InternalBug286935TestLanguage.g:291:2: ( rule__State__LabelAssignment_4 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalBug286935TestLanguage.g:291:3: rule__State__LabelAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__State__LabelAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getLabelAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__4__Impl"


    // $ANTLR start "rule__State__Group_1_3__0"
    // InternalBug286935TestLanguage.g:300:1: rule__State__Group_1_3__0 : rule__State__Group_1_3__0__Impl rule__State__Group_1_3__1 ;
    public final void rule__State__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:304:1: ( rule__State__Group_1_3__0__Impl rule__State__Group_1_3__1 )
            // InternalBug286935TestLanguage.g:305:2: rule__State__Group_1_3__0__Impl rule__State__Group_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__State__Group_1_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group_1_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_1_3__0"


    // $ANTLR start "rule__State__Group_1_3__0__Impl"
    // InternalBug286935TestLanguage.g:312:1: rule__State__Group_1_3__0__Impl : ( ( rule__State__IsInitialAssignment_1_3_0 ) ) ;
    public final void rule__State__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:316:1: ( ( ( rule__State__IsInitialAssignment_1_3_0 ) ) )
            // InternalBug286935TestLanguage.g:317:1: ( ( rule__State__IsInitialAssignment_1_3_0 ) )
            {
            // InternalBug286935TestLanguage.g:317:1: ( ( rule__State__IsInitialAssignment_1_3_0 ) )
            // InternalBug286935TestLanguage.g:318:2: ( rule__State__IsInitialAssignment_1_3_0 )
            {
             before(grammarAccess.getStateAccess().getIsInitialAssignment_1_3_0()); 
            // InternalBug286935TestLanguage.g:319:2: ( rule__State__IsInitialAssignment_1_3_0 )
            // InternalBug286935TestLanguage.g:319:3: rule__State__IsInitialAssignment_1_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__IsInitialAssignment_1_3_0();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getIsInitialAssignment_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_1_3__0__Impl"


    // $ANTLR start "rule__State__Group_1_3__1"
    // InternalBug286935TestLanguage.g:327:1: rule__State__Group_1_3__1 : rule__State__Group_1_3__1__Impl ;
    public final void rule__State__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:331:1: ( rule__State__Group_1_3__1__Impl )
            // InternalBug286935TestLanguage.g:332:2: rule__State__Group_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group_1_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_1_3__1"


    // $ANTLR start "rule__State__Group_1_3__1__Impl"
    // InternalBug286935TestLanguage.g:338:1: rule__State__Group_1_3__1__Impl : ( ( rule__State__StateKindAssignment_1_3_1 ) ) ;
    public final void rule__State__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:342:1: ( ( ( rule__State__StateKindAssignment_1_3_1 ) ) )
            // InternalBug286935TestLanguage.g:343:1: ( ( rule__State__StateKindAssignment_1_3_1 ) )
            {
            // InternalBug286935TestLanguage.g:343:1: ( ( rule__State__StateKindAssignment_1_3_1 ) )
            // InternalBug286935TestLanguage.g:344:2: ( rule__State__StateKindAssignment_1_3_1 )
            {
             before(grammarAccess.getStateAccess().getStateKindAssignment_1_3_1()); 
            // InternalBug286935TestLanguage.g:345:2: ( rule__State__StateKindAssignment_1_3_1 )
            // InternalBug286935TestLanguage.g:345:3: rule__State__StateKindAssignment_1_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__StateKindAssignment_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getStateKindAssignment_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_1_3__1__Impl"


    // $ANTLR start "rule__State__Group_1_4__0"
    // InternalBug286935TestLanguage.g:354:1: rule__State__Group_1_4__0 : rule__State__Group_1_4__0__Impl rule__State__Group_1_4__1 ;
    public final void rule__State__Group_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:358:1: ( rule__State__Group_1_4__0__Impl rule__State__Group_1_4__1 )
            // InternalBug286935TestLanguage.g:359:2: rule__State__Group_1_4__0__Impl rule__State__Group_1_4__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__State__Group_1_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group_1_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_1_4__0"


    // $ANTLR start "rule__State__Group_1_4__0__Impl"
    // InternalBug286935TestLanguage.g:366:1: rule__State__Group_1_4__0__Impl : ( ( rule__State__IsInitialAssignment_1_4_0 ) ) ;
    public final void rule__State__Group_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:370:1: ( ( ( rule__State__IsInitialAssignment_1_4_0 ) ) )
            // InternalBug286935TestLanguage.g:371:1: ( ( rule__State__IsInitialAssignment_1_4_0 ) )
            {
            // InternalBug286935TestLanguage.g:371:1: ( ( rule__State__IsInitialAssignment_1_4_0 ) )
            // InternalBug286935TestLanguage.g:372:2: ( rule__State__IsInitialAssignment_1_4_0 )
            {
             before(grammarAccess.getStateAccess().getIsInitialAssignment_1_4_0()); 
            // InternalBug286935TestLanguage.g:373:2: ( rule__State__IsInitialAssignment_1_4_0 )
            // InternalBug286935TestLanguage.g:373:3: rule__State__IsInitialAssignment_1_4_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__IsInitialAssignment_1_4_0();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getIsInitialAssignment_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_1_4__0__Impl"


    // $ANTLR start "rule__State__Group_1_4__1"
    // InternalBug286935TestLanguage.g:381:1: rule__State__Group_1_4__1 : rule__State__Group_1_4__1__Impl rule__State__Group_1_4__2 ;
    public final void rule__State__Group_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:385:1: ( rule__State__Group_1_4__1__Impl rule__State__Group_1_4__2 )
            // InternalBug286935TestLanguage.g:386:2: rule__State__Group_1_4__1__Impl rule__State__Group_1_4__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__State__Group_1_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group_1_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_1_4__1"


    // $ANTLR start "rule__State__Group_1_4__1__Impl"
    // InternalBug286935TestLanguage.g:393:1: rule__State__Group_1_4__1__Impl : ( ( rule__State__StateKindAssignment_1_4_1 ) ) ;
    public final void rule__State__Group_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:397:1: ( ( ( rule__State__StateKindAssignment_1_4_1 ) ) )
            // InternalBug286935TestLanguage.g:398:1: ( ( rule__State__StateKindAssignment_1_4_1 ) )
            {
            // InternalBug286935TestLanguage.g:398:1: ( ( rule__State__StateKindAssignment_1_4_1 ) )
            // InternalBug286935TestLanguage.g:399:2: ( rule__State__StateKindAssignment_1_4_1 )
            {
             before(grammarAccess.getStateAccess().getStateKindAssignment_1_4_1()); 
            // InternalBug286935TestLanguage.g:400:2: ( rule__State__StateKindAssignment_1_4_1 )
            // InternalBug286935TestLanguage.g:400:3: rule__State__StateKindAssignment_1_4_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__StateKindAssignment_1_4_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getStateKindAssignment_1_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_1_4__1__Impl"


    // $ANTLR start "rule__State__Group_1_4__2"
    // InternalBug286935TestLanguage.g:408:1: rule__State__Group_1_4__2 : rule__State__Group_1_4__2__Impl ;
    public final void rule__State__Group_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:412:1: ( rule__State__Group_1_4__2__Impl )
            // InternalBug286935TestLanguage.g:413:2: rule__State__Group_1_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__Group_1_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_1_4__2"


    // $ANTLR start "rule__State__Group_1_4__2__Impl"
    // InternalBug286935TestLanguage.g:419:1: rule__State__Group_1_4__2__Impl : ( ( rule__State__IsFinalAssignment_1_4_2 ) ) ;
    public final void rule__State__Group_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:423:1: ( ( ( rule__State__IsFinalAssignment_1_4_2 ) ) )
            // InternalBug286935TestLanguage.g:424:1: ( ( rule__State__IsFinalAssignment_1_4_2 ) )
            {
            // InternalBug286935TestLanguage.g:424:1: ( ( rule__State__IsFinalAssignment_1_4_2 ) )
            // InternalBug286935TestLanguage.g:425:2: ( rule__State__IsFinalAssignment_1_4_2 )
            {
             before(grammarAccess.getStateAccess().getIsFinalAssignment_1_4_2()); 
            // InternalBug286935TestLanguage.g:426:2: ( rule__State__IsFinalAssignment_1_4_2 )
            // InternalBug286935TestLanguage.g:426:3: rule__State__IsFinalAssignment_1_4_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__State__IsFinalAssignment_1_4_2();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getIsFinalAssignment_1_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_1_4__2__Impl"


    // $ANTLR start "rule__State__IsInitialAssignment_1_0"
    // InternalBug286935TestLanguage.g:435:1: rule__State__IsInitialAssignment_1_0 : ( ( 'init' ) ) ;
    public final void rule__State__IsInitialAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:439:1: ( ( ( 'init' ) ) )
            // InternalBug286935TestLanguage.g:440:2: ( ( 'init' ) )
            {
            // InternalBug286935TestLanguage.g:440:2: ( ( 'init' ) )
            // InternalBug286935TestLanguage.g:441:3: ( 'init' )
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_0_0()); 
            // InternalBug286935TestLanguage.g:442:3: ( 'init' )
            // InternalBug286935TestLanguage.g:443:4: 'init'
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_0_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_0_0()); 

            }

             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__IsInitialAssignment_1_0"


    // $ANTLR start "rule__State__IsFinalAssignment_1_1"
    // InternalBug286935TestLanguage.g:454:1: rule__State__IsFinalAssignment_1_1 : ( ( 'final' ) ) ;
    public final void rule__State__IsFinalAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:458:1: ( ( ( 'final' ) ) )
            // InternalBug286935TestLanguage.g:459:2: ( ( 'final' ) )
            {
            // InternalBug286935TestLanguage.g:459:2: ( ( 'final' ) )
            // InternalBug286935TestLanguage.g:460:3: ( 'final' )
            {
             before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_1_0()); 
            // InternalBug286935TestLanguage.g:461:3: ( 'final' )
            // InternalBug286935TestLanguage.g:462:4: 'final'
            {
             before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_1_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_1_0()); 

            }

             after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__IsFinalAssignment_1_1"


    // $ANTLR start "rule__State__StateKindAssignment_1_2"
    // InternalBug286935TestLanguage.g:473:1: rule__State__StateKindAssignment_1_2 : ( ruleStateType ) ;
    public final void rule__State__StateKindAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:477:1: ( ( ruleStateType ) )
            // InternalBug286935TestLanguage.g:478:2: ( ruleStateType )
            {
            // InternalBug286935TestLanguage.g:478:2: ( ruleStateType )
            // InternalBug286935TestLanguage.g:479:3: ruleStateType
            {
             before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleStateType();

            state._fsp--;

             after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__StateKindAssignment_1_2"


    // $ANTLR start "rule__State__IsInitialAssignment_1_3_0"
    // InternalBug286935TestLanguage.g:488:1: rule__State__IsInitialAssignment_1_3_0 : ( ( 'init' ) ) ;
    public final void rule__State__IsInitialAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:492:1: ( ( ( 'init' ) ) )
            // InternalBug286935TestLanguage.g:493:2: ( ( 'init' ) )
            {
            // InternalBug286935TestLanguage.g:493:2: ( ( 'init' ) )
            // InternalBug286935TestLanguage.g:494:3: ( 'init' )
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_3_0_0()); 
            // InternalBug286935TestLanguage.g:495:3: ( 'init' )
            // InternalBug286935TestLanguage.g:496:4: 'init'
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_3_0_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_3_0_0()); 

            }

             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__IsInitialAssignment_1_3_0"


    // $ANTLR start "rule__State__StateKindAssignment_1_3_1"
    // InternalBug286935TestLanguage.g:507:1: rule__State__StateKindAssignment_1_3_1 : ( ruleStateType ) ;
    public final void rule__State__StateKindAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:511:1: ( ( ruleStateType ) )
            // InternalBug286935TestLanguage.g:512:2: ( ruleStateType )
            {
            // InternalBug286935TestLanguage.g:512:2: ( ruleStateType )
            // InternalBug286935TestLanguage.g:513:3: ruleStateType
            {
             before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_1_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleStateType();

            state._fsp--;

             after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__StateKindAssignment_1_3_1"


    // $ANTLR start "rule__State__IsInitialAssignment_1_4_0"
    // InternalBug286935TestLanguage.g:522:1: rule__State__IsInitialAssignment_1_4_0 : ( ( 'init' ) ) ;
    public final void rule__State__IsInitialAssignment_1_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:526:1: ( ( ( 'init' ) ) )
            // InternalBug286935TestLanguage.g:527:2: ( ( 'init' ) )
            {
            // InternalBug286935TestLanguage.g:527:2: ( ( 'init' ) )
            // InternalBug286935TestLanguage.g:528:3: ( 'init' )
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_4_0_0()); 
            // InternalBug286935TestLanguage.g:529:3: ( 'init' )
            // InternalBug286935TestLanguage.g:530:4: 'init'
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_4_0_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_4_0_0()); 

            }

             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__IsInitialAssignment_1_4_0"


    // $ANTLR start "rule__State__StateKindAssignment_1_4_1"
    // InternalBug286935TestLanguage.g:541:1: rule__State__StateKindAssignment_1_4_1 : ( ruleStateType ) ;
    public final void rule__State__StateKindAssignment_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:545:1: ( ( ruleStateType ) )
            // InternalBug286935TestLanguage.g:546:2: ( ruleStateType )
            {
            // InternalBug286935TestLanguage.g:546:2: ( ruleStateType )
            // InternalBug286935TestLanguage.g:547:3: ruleStateType
            {
             before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_1_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleStateType();

            state._fsp--;

             after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_1_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__StateKindAssignment_1_4_1"


    // $ANTLR start "rule__State__IsFinalAssignment_1_4_2"
    // InternalBug286935TestLanguage.g:556:1: rule__State__IsFinalAssignment_1_4_2 : ( ( 'final' ) ) ;
    public final void rule__State__IsFinalAssignment_1_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:560:1: ( ( ( 'final' ) ) )
            // InternalBug286935TestLanguage.g:561:2: ( ( 'final' ) )
            {
            // InternalBug286935TestLanguage.g:561:2: ( ( 'final' ) )
            // InternalBug286935TestLanguage.g:562:3: ( 'final' )
            {
             before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_4_2_0()); 
            // InternalBug286935TestLanguage.g:563:3: ( 'final' )
            // InternalBug286935TestLanguage.g:564:4: 'final'
            {
             before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_4_2_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_4_2_0()); 

            }

             after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__IsFinalAssignment_1_4_2"


    // $ANTLR start "rule__State__StateNameAssignment_3"
    // InternalBug286935TestLanguage.g:575:1: rule__State__StateNameAssignment_3 : ( RULE_ID ) ;
    public final void rule__State__StateNameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:579:1: ( ( RULE_ID ) )
            // InternalBug286935TestLanguage.g:580:2: ( RULE_ID )
            {
            // InternalBug286935TestLanguage.g:580:2: ( RULE_ID )
            // InternalBug286935TestLanguage.g:581:3: RULE_ID
            {
             before(grammarAccess.getStateAccess().getStateNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStateAccess().getStateNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__StateNameAssignment_3"


    // $ANTLR start "rule__State__LabelAssignment_4"
    // InternalBug286935TestLanguage.g:590:1: rule__State__LabelAssignment_4 : ( RULE_STRING ) ;
    public final void rule__State__LabelAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug286935TestLanguage.g:594:1: ( ( RULE_STRING ) )
            // InternalBug286935TestLanguage.g:595:2: ( RULE_STRING )
            {
            // InternalBug286935TestLanguage.g:595:2: ( RULE_STRING )
            // InternalBug286935TestLanguage.g:596:3: RULE_STRING
            {
             before(grammarAccess.getStateAccess().getLabelSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStateAccess().getLabelSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__LabelAssignment_4"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\uffff\1\10\2\uffff\4\12\3\uffff";
    static final String dfa_3s = "\1\13\1\4\2\uffff\4\4\3\uffff";
    static final String dfa_4s = "\1\21\1\17\2\uffff\4\21\3\uffff";
    static final String dfa_5s = "\2\uffff\1\2\1\3\4\uffff\1\1\1\5\1\4";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\4\3\1\uffff\1\1\1\2",
            "\2\10\5\uffff\1\4\1\5\1\6\1\7\1\10",
            "",
            "",
            "\2\12\11\uffff\1\12\1\uffff\1\11",
            "\2\12\11\uffff\1\12\1\uffff\1\11",
            "\2\12\11\uffff\1\12\1\uffff\1\11",
            "\2\12\11\uffff\1\12\1\uffff\1\11",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "93:1: rule__State__Alternatives_1 : ( ( ( rule__State__IsInitialAssignment_1_0 ) ) | ( ( rule__State__IsFinalAssignment_1_1 ) ) | ( ( rule__State__StateKindAssignment_1_2 ) ) | ( ( rule__State__Group_1_3__0 ) ) | ( ( rule__State__Group_1_4__0 ) ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000003F830L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000020000L});
    }


}
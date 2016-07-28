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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug307519TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug307519TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'T1'", "'T2'", "'foo'", "'%'", "'$'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug307519TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug307519TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug307519TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug307519TestLanguage.g"; }


    	private Bug307519TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug307519TestLanguageGrammarAccess grammarAccess) {
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
    // InternalBug307519TestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug307519TestLanguage.g:54:1: ( ruleModel EOF )
            // InternalBug307519TestLanguage.g:55:1: ruleModel EOF
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
    // InternalBug307519TestLanguage.g:62:1: ruleModel : ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:66:2: ( ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) ) )
            // InternalBug307519TestLanguage.g:67:2: ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) )
            {
            // InternalBug307519TestLanguage.g:67:2: ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) )
            // InternalBug307519TestLanguage.g:68:3: ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* )
            {
            // InternalBug307519TestLanguage.g:68:3: ( ( rule__Model__Alternatives ) )
            // InternalBug307519TestLanguage.g:69:4: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalBug307519TestLanguage.g:70:4: ( rule__Model__Alternatives )
            // InternalBug307519TestLanguage.g:70:5: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

            }

            // InternalBug307519TestLanguage.g:73:3: ( ( rule__Model__Alternatives )* )
            // InternalBug307519TestLanguage.g:74:4: ( rule__Model__Alternatives )*
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalBug307519TestLanguage.g:75:4: ( rule__Model__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug307519TestLanguage.g:75:5: rule__Model__Alternatives
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Model__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAlternatives()); 

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleElem1"
    // InternalBug307519TestLanguage.g:85:1: entryRuleElem1 : ruleElem1 EOF ;
    public final void entryRuleElem1() throws RecognitionException {
        try {
            // InternalBug307519TestLanguage.g:86:1: ( ruleElem1 EOF )
            // InternalBug307519TestLanguage.g:87:1: ruleElem1 EOF
            {
             before(grammarAccess.getElem1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElem1();

            state._fsp--;

             after(grammarAccess.getElem1Rule()); 
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
    // $ANTLR end "entryRuleElem1"


    // $ANTLR start "ruleElem1"
    // InternalBug307519TestLanguage.g:94:1: ruleElem1 : ( ( rule__Elem1__ValueAssignment ) ) ;
    public final void ruleElem1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:98:2: ( ( ( rule__Elem1__ValueAssignment ) ) )
            // InternalBug307519TestLanguage.g:99:2: ( ( rule__Elem1__ValueAssignment ) )
            {
            // InternalBug307519TestLanguage.g:99:2: ( ( rule__Elem1__ValueAssignment ) )
            // InternalBug307519TestLanguage.g:100:3: ( rule__Elem1__ValueAssignment )
            {
             before(grammarAccess.getElem1Access().getValueAssignment()); 
            // InternalBug307519TestLanguage.g:101:3: ( rule__Elem1__ValueAssignment )
            // InternalBug307519TestLanguage.g:101:4: rule__Elem1__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem1__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getElem1Access().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElem1"


    // $ANTLR start "entryRuleElem2"
    // InternalBug307519TestLanguage.g:110:1: entryRuleElem2 : ruleElem2 EOF ;
    public final void entryRuleElem2() throws RecognitionException {
        try {
            // InternalBug307519TestLanguage.g:111:1: ( ruleElem2 EOF )
            // InternalBug307519TestLanguage.g:112:1: ruleElem2 EOF
            {
             before(grammarAccess.getElem2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElem2();

            state._fsp--;

             after(grammarAccess.getElem2Rule()); 
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
    // $ANTLR end "entryRuleElem2"


    // $ANTLR start "ruleElem2"
    // InternalBug307519TestLanguage.g:119:1: ruleElem2 : ( ( rule__Elem2__Group__0 ) ) ;
    public final void ruleElem2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:123:2: ( ( ( rule__Elem2__Group__0 ) ) )
            // InternalBug307519TestLanguage.g:124:2: ( ( rule__Elem2__Group__0 ) )
            {
            // InternalBug307519TestLanguage.g:124:2: ( ( rule__Elem2__Group__0 ) )
            // InternalBug307519TestLanguage.g:125:3: ( rule__Elem2__Group__0 )
            {
             before(grammarAccess.getElem2Access().getGroup()); 
            // InternalBug307519TestLanguage.g:126:3: ( rule__Elem2__Group__0 )
            // InternalBug307519TestLanguage.g:126:4: rule__Elem2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getElem2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElem2"


    // $ANTLR start "ruleEnumT"
    // InternalBug307519TestLanguage.g:135:1: ruleEnumT : ( ( rule__EnumT__Alternatives ) ) ;
    public final void ruleEnumT() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:139:1: ( ( ( rule__EnumT__Alternatives ) ) )
            // InternalBug307519TestLanguage.g:140:2: ( ( rule__EnumT__Alternatives ) )
            {
            // InternalBug307519TestLanguage.g:140:2: ( ( rule__EnumT__Alternatives ) )
            // InternalBug307519TestLanguage.g:141:3: ( rule__EnumT__Alternatives )
            {
             before(grammarAccess.getEnumTAccess().getAlternatives()); 
            // InternalBug307519TestLanguage.g:142:3: ( rule__EnumT__Alternatives )
            // InternalBug307519TestLanguage.g:142:4: rule__EnumT__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumT__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEnumTAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumT"


    // $ANTLR start "rule__Model__Alternatives"
    // InternalBug307519TestLanguage.g:150:1: rule__Model__Alternatives : ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:154:1: ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==13) ) {
                    alt2=2;
                }
                else if ( (LA2_1==EOF||(LA2_1>=11 && LA2_1<=12)) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==12) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==13) ) {
                    alt2=2;
                }
                else if ( (LA2_2==EOF||(LA2_2>=11 && LA2_2<=12)) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug307519TestLanguage.g:155:2: ( ( rule__Model__E1Assignment_0 ) )
                    {
                    // InternalBug307519TestLanguage.g:155:2: ( ( rule__Model__E1Assignment_0 ) )
                    // InternalBug307519TestLanguage.g:156:3: ( rule__Model__E1Assignment_0 )
                    {
                     before(grammarAccess.getModelAccess().getE1Assignment_0()); 
                    // InternalBug307519TestLanguage.g:157:3: ( rule__Model__E1Assignment_0 )
                    // InternalBug307519TestLanguage.g:157:4: rule__Model__E1Assignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__E1Assignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getE1Assignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug307519TestLanguage.g:161:2: ( ( rule__Model__E2Assignment_1 ) )
                    {
                    // InternalBug307519TestLanguage.g:161:2: ( ( rule__Model__E2Assignment_1 ) )
                    // InternalBug307519TestLanguage.g:162:3: ( rule__Model__E2Assignment_1 )
                    {
                     before(grammarAccess.getModelAccess().getE2Assignment_1()); 
                    // InternalBug307519TestLanguage.g:163:3: ( rule__Model__E2Assignment_1 )
                    // InternalBug307519TestLanguage.g:163:4: rule__Model__E2Assignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__E2Assignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getE2Assignment_1()); 

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
    // $ANTLR end "rule__Model__Alternatives"


    // $ANTLR start "rule__EnumT__Alternatives"
    // InternalBug307519TestLanguage.g:171:1: rule__EnumT__Alternatives : ( ( ( 'T1' ) ) | ( ( 'T2' ) ) );
    public final void rule__EnumT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:175:1: ( ( ( 'T1' ) ) | ( ( 'T2' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug307519TestLanguage.g:176:2: ( ( 'T1' ) )
                    {
                    // InternalBug307519TestLanguage.g:176:2: ( ( 'T1' ) )
                    // InternalBug307519TestLanguage.g:177:3: ( 'T1' )
                    {
                     before(grammarAccess.getEnumTAccess().getT1EnumLiteralDeclaration_0()); 
                    // InternalBug307519TestLanguage.g:178:3: ( 'T1' )
                    // InternalBug307519TestLanguage.g:178:4: 'T1'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEnumTAccess().getT1EnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug307519TestLanguage.g:182:2: ( ( 'T2' ) )
                    {
                    // InternalBug307519TestLanguage.g:182:2: ( ( 'T2' ) )
                    // InternalBug307519TestLanguage.g:183:3: ( 'T2' )
                    {
                     before(grammarAccess.getEnumTAccess().getT2EnumLiteralDeclaration_1()); 
                    // InternalBug307519TestLanguage.g:184:3: ( 'T2' )
                    // InternalBug307519TestLanguage.g:184:4: 'T2'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEnumTAccess().getT2EnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__EnumT__Alternatives"


    // $ANTLR start "rule__Elem2__Group__0"
    // InternalBug307519TestLanguage.g:192:1: rule__Elem2__Group__0 : rule__Elem2__Group__0__Impl rule__Elem2__Group__1 ;
    public final void rule__Elem2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:196:1: ( rule__Elem2__Group__0__Impl rule__Elem2__Group__1 )
            // InternalBug307519TestLanguage.g:197:2: rule__Elem2__Group__0__Impl rule__Elem2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Elem2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__0"


    // $ANTLR start "rule__Elem2__Group__0__Impl"
    // InternalBug307519TestLanguage.g:204:1: rule__Elem2__Group__0__Impl : ( ( rule__Elem2__ValueAssignment_0 ) ) ;
    public final void rule__Elem2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:208:1: ( ( ( rule__Elem2__ValueAssignment_0 ) ) )
            // InternalBug307519TestLanguage.g:209:1: ( ( rule__Elem2__ValueAssignment_0 ) )
            {
            // InternalBug307519TestLanguage.g:209:1: ( ( rule__Elem2__ValueAssignment_0 ) )
            // InternalBug307519TestLanguage.g:210:2: ( rule__Elem2__ValueAssignment_0 )
            {
             before(grammarAccess.getElem2Access().getValueAssignment_0()); 
            // InternalBug307519TestLanguage.g:211:2: ( rule__Elem2__ValueAssignment_0 )
            // InternalBug307519TestLanguage.g:211:3: rule__Elem2__ValueAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__ValueAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getElem2Access().getValueAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__0__Impl"


    // $ANTLR start "rule__Elem2__Group__1"
    // InternalBug307519TestLanguage.g:219:1: rule__Elem2__Group__1 : rule__Elem2__Group__1__Impl rule__Elem2__Group__2 ;
    public final void rule__Elem2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:223:1: ( rule__Elem2__Group__1__Impl rule__Elem2__Group__2 )
            // InternalBug307519TestLanguage.g:224:2: rule__Elem2__Group__1__Impl rule__Elem2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Elem2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__1"


    // $ANTLR start "rule__Elem2__Group__1__Impl"
    // InternalBug307519TestLanguage.g:231:1: rule__Elem2__Group__1__Impl : ( 'foo' ) ;
    public final void rule__Elem2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:235:1: ( ( 'foo' ) )
            // InternalBug307519TestLanguage.g:236:1: ( 'foo' )
            {
            // InternalBug307519TestLanguage.g:236:1: ( 'foo' )
            // InternalBug307519TestLanguage.g:237:2: 'foo'
            {
             before(grammarAccess.getElem2Access().getFooKeyword_1()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElem2Access().getFooKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__1__Impl"


    // $ANTLR start "rule__Elem2__Group__2"
    // InternalBug307519TestLanguage.g:246:1: rule__Elem2__Group__2 : rule__Elem2__Group__2__Impl rule__Elem2__Group__3 ;
    public final void rule__Elem2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:250:1: ( rule__Elem2__Group__2__Impl rule__Elem2__Group__3 )
            // InternalBug307519TestLanguage.g:251:2: rule__Elem2__Group__2__Impl rule__Elem2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Elem2__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__2"


    // $ANTLR start "rule__Elem2__Group__2__Impl"
    // InternalBug307519TestLanguage.g:258:1: rule__Elem2__Group__2__Impl : ( '%' ) ;
    public final void rule__Elem2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:262:1: ( ( '%' ) )
            // InternalBug307519TestLanguage.g:263:1: ( '%' )
            {
            // InternalBug307519TestLanguage.g:263:1: ( '%' )
            // InternalBug307519TestLanguage.g:264:2: '%'
            {
             before(grammarAccess.getElem2Access().getPercentSignKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElem2Access().getPercentSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__2__Impl"


    // $ANTLR start "rule__Elem2__Group__3"
    // InternalBug307519TestLanguage.g:273:1: rule__Elem2__Group__3 : rule__Elem2__Group__3__Impl ;
    public final void rule__Elem2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:277:1: ( rule__Elem2__Group__3__Impl )
            // InternalBug307519TestLanguage.g:278:2: rule__Elem2__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__3"


    // $ANTLR start "rule__Elem2__Group__3__Impl"
    // InternalBug307519TestLanguage.g:284:1: rule__Elem2__Group__3__Impl : ( '$' ) ;
    public final void rule__Elem2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:288:1: ( ( '$' ) )
            // InternalBug307519TestLanguage.g:289:1: ( '$' )
            {
            // InternalBug307519TestLanguage.g:289:1: ( '$' )
            // InternalBug307519TestLanguage.g:290:2: '$'
            {
             before(grammarAccess.getElem2Access().getDollarSignKeyword_3()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElem2Access().getDollarSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__3__Impl"


    // $ANTLR start "rule__Model__E1Assignment_0"
    // InternalBug307519TestLanguage.g:300:1: rule__Model__E1Assignment_0 : ( ruleElem1 ) ;
    public final void rule__Model__E1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:304:1: ( ( ruleElem1 ) )
            // InternalBug307519TestLanguage.g:305:2: ( ruleElem1 )
            {
            // InternalBug307519TestLanguage.g:305:2: ( ruleElem1 )
            // InternalBug307519TestLanguage.g:306:3: ruleElem1
            {
             before(grammarAccess.getModelAccess().getE1Elem1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleElem1();

            state._fsp--;

             after(grammarAccess.getModelAccess().getE1Elem1ParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__E1Assignment_0"


    // $ANTLR start "rule__Model__E2Assignment_1"
    // InternalBug307519TestLanguage.g:315:1: rule__Model__E2Assignment_1 : ( ruleElem2 ) ;
    public final void rule__Model__E2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:319:1: ( ( ruleElem2 ) )
            // InternalBug307519TestLanguage.g:320:2: ( ruleElem2 )
            {
            // InternalBug307519TestLanguage.g:320:2: ( ruleElem2 )
            // InternalBug307519TestLanguage.g:321:3: ruleElem2
            {
             before(grammarAccess.getModelAccess().getE2Elem2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleElem2();

            state._fsp--;

             after(grammarAccess.getModelAccess().getE2Elem2ParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__E2Assignment_1"


    // $ANTLR start "rule__Elem1__ValueAssignment"
    // InternalBug307519TestLanguage.g:330:1: rule__Elem1__ValueAssignment : ( ruleEnumT ) ;
    public final void rule__Elem1__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:334:1: ( ( ruleEnumT ) )
            // InternalBug307519TestLanguage.g:335:2: ( ruleEnumT )
            {
            // InternalBug307519TestLanguage.g:335:2: ( ruleEnumT )
            // InternalBug307519TestLanguage.g:336:3: ruleEnumT
            {
             before(grammarAccess.getElem1Access().getValueEnumTEnumRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumT();

            state._fsp--;

             after(grammarAccess.getElem1Access().getValueEnumTEnumRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem1__ValueAssignment"


    // $ANTLR start "rule__Elem2__ValueAssignment_0"
    // InternalBug307519TestLanguage.g:345:1: rule__Elem2__ValueAssignment_0 : ( ruleEnumT ) ;
    public final void rule__Elem2__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug307519TestLanguage.g:349:1: ( ( ruleEnumT ) )
            // InternalBug307519TestLanguage.g:350:2: ( ruleEnumT )
            {
            // InternalBug307519TestLanguage.g:350:2: ( ruleEnumT )
            // InternalBug307519TestLanguage.g:351:3: ruleEnumT
            {
             before(grammarAccess.getElem2Access().getValueEnumTEnumRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumT();

            state._fsp--;

             after(grammarAccess.getElem2Access().getValueEnumTEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__ValueAssignment_0"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    }


}
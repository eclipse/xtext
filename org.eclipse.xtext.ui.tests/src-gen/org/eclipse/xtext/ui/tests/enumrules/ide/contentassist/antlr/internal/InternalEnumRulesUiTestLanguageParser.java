package org.eclipse.xtext.ui.tests.enumrules.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.enumrules.services.EnumRulesUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEnumRulesUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'SameName'", "'overridden'", "'DifferentLiteral'", "'existing'", "'generated'"
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


        public InternalEnumRulesUiTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEnumRulesUiTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEnumRulesUiTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEnumRulesUiTestLanguage.g"; }


    	private EnumRulesUiTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(EnumRulesUiTestLanguageGrammarAccess grammarAccess) {
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
    // InternalEnumRulesUiTestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalEnumRulesUiTestLanguage.g:54:1: ( ruleModel EOF )
            // InternalEnumRulesUiTestLanguage.g:55:1: ruleModel EOF
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
    // InternalEnumRulesUiTestLanguage.g:62:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:66:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalEnumRulesUiTestLanguage.g:67:2: ( ( rule__Model__Alternatives ) )
            {
            // InternalEnumRulesUiTestLanguage.g:67:2: ( ( rule__Model__Alternatives ) )
            // InternalEnumRulesUiTestLanguage.g:68:3: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalEnumRulesUiTestLanguage.g:69:3: ( rule__Model__Alternatives )
            // InternalEnumRulesUiTestLanguage.g:69:4: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "ruleExistingEnum"
    // InternalEnumRulesUiTestLanguage.g:78:1: ruleExistingEnum : ( ( rule__ExistingEnum__Alternatives ) ) ;
    public final void ruleExistingEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:82:1: ( ( ( rule__ExistingEnum__Alternatives ) ) )
            // InternalEnumRulesUiTestLanguage.g:83:2: ( ( rule__ExistingEnum__Alternatives ) )
            {
            // InternalEnumRulesUiTestLanguage.g:83:2: ( ( rule__ExistingEnum__Alternatives ) )
            // InternalEnumRulesUiTestLanguage.g:84:3: ( rule__ExistingEnum__Alternatives )
            {
             before(grammarAccess.getExistingEnumAccess().getAlternatives()); 
            // InternalEnumRulesUiTestLanguage.g:85:3: ( rule__ExistingEnum__Alternatives )
            // InternalEnumRulesUiTestLanguage.g:85:4: rule__ExistingEnum__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ExistingEnum__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExistingEnumAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExistingEnum"


    // $ANTLR start "ruleGeneratedEnum"
    // InternalEnumRulesUiTestLanguage.g:94:1: ruleGeneratedEnum : ( ( rule__GeneratedEnum__Alternatives ) ) ;
    public final void ruleGeneratedEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:98:1: ( ( ( rule__GeneratedEnum__Alternatives ) ) )
            // InternalEnumRulesUiTestLanguage.g:99:2: ( ( rule__GeneratedEnum__Alternatives ) )
            {
            // InternalEnumRulesUiTestLanguage.g:99:2: ( ( rule__GeneratedEnum__Alternatives ) )
            // InternalEnumRulesUiTestLanguage.g:100:3: ( rule__GeneratedEnum__Alternatives )
            {
             before(grammarAccess.getGeneratedEnumAccess().getAlternatives()); 
            // InternalEnumRulesUiTestLanguage.g:101:3: ( rule__GeneratedEnum__Alternatives )
            // InternalEnumRulesUiTestLanguage.g:101:4: rule__GeneratedEnum__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedEnum__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getGeneratedEnumAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGeneratedEnum"


    // $ANTLR start "rule__Model__Alternatives"
    // InternalEnumRulesUiTestLanguage.g:109:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:113:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalEnumRulesUiTestLanguage.g:114:2: ( ( rule__Model__Group_0__0 ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:114:2: ( ( rule__Model__Group_0__0 ) )
                    // InternalEnumRulesUiTestLanguage.g:115:3: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // InternalEnumRulesUiTestLanguage.g:116:3: ( rule__Model__Group_0__0 )
                    // InternalEnumRulesUiTestLanguage.g:116:4: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEnumRulesUiTestLanguage.g:120:2: ( ( rule__Model__Group_1__0 ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:120:2: ( ( rule__Model__Group_1__0 ) )
                    // InternalEnumRulesUiTestLanguage.g:121:3: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // InternalEnumRulesUiTestLanguage.g:122:3: ( rule__Model__Group_1__0 )
                    // InternalEnumRulesUiTestLanguage.g:122:4: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

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


    // $ANTLR start "rule__ExistingEnum__Alternatives"
    // InternalEnumRulesUiTestLanguage.g:130:1: rule__ExistingEnum__Alternatives : ( ( ( 'SameName' ) ) | ( ( 'overridden' ) ) | ( ( 'DifferentLiteral' ) ) );
    public final void rule__ExistingEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:134:1: ( ( ( 'SameName' ) ) | ( ( 'overridden' ) ) | ( ( 'DifferentLiteral' ) ) )
            int alt2=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalEnumRulesUiTestLanguage.g:135:2: ( ( 'SameName' ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:135:2: ( ( 'SameName' ) )
                    // InternalEnumRulesUiTestLanguage.g:136:3: ( 'SameName' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0()); 
                    // InternalEnumRulesUiTestLanguage.g:137:3: ( 'SameName' )
                    // InternalEnumRulesUiTestLanguage.g:137:4: 'SameName'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEnumRulesUiTestLanguage.g:141:2: ( ( 'overridden' ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:141:2: ( ( 'overridden' ) )
                    // InternalEnumRulesUiTestLanguage.g:142:3: ( 'overridden' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1()); 
                    // InternalEnumRulesUiTestLanguage.g:143:3: ( 'overridden' )
                    // InternalEnumRulesUiTestLanguage.g:143:4: 'overridden'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalEnumRulesUiTestLanguage.g:147:2: ( ( 'DifferentLiteral' ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:147:2: ( ( 'DifferentLiteral' ) )
                    // InternalEnumRulesUiTestLanguage.g:148:3: ( 'DifferentLiteral' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2()); 
                    // InternalEnumRulesUiTestLanguage.g:149:3: ( 'DifferentLiteral' )
                    // InternalEnumRulesUiTestLanguage.g:149:4: 'DifferentLiteral'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__ExistingEnum__Alternatives"


    // $ANTLR start "rule__GeneratedEnum__Alternatives"
    // InternalEnumRulesUiTestLanguage.g:157:1: rule__GeneratedEnum__Alternatives : ( ( ( 'SameName' ) ) | ( ( 'DifferentLiteral' ) ) );
    public final void rule__GeneratedEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:161:1: ( ( ( 'SameName' ) ) | ( ( 'DifferentLiteral' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalEnumRulesUiTestLanguage.g:162:2: ( ( 'SameName' ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:162:2: ( ( 'SameName' ) )
                    // InternalEnumRulesUiTestLanguage.g:163:3: ( 'SameName' )
                    {
                     before(grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0()); 
                    // InternalEnumRulesUiTestLanguage.g:164:3: ( 'SameName' )
                    // InternalEnumRulesUiTestLanguage.g:164:4: 'SameName'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEnumRulesUiTestLanguage.g:168:2: ( ( 'DifferentLiteral' ) )
                    {
                    // InternalEnumRulesUiTestLanguage.g:168:2: ( ( 'DifferentLiteral' ) )
                    // InternalEnumRulesUiTestLanguage.g:169:3: ( 'DifferentLiteral' )
                    {
                     before(grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1()); 
                    // InternalEnumRulesUiTestLanguage.g:170:3: ( 'DifferentLiteral' )
                    // InternalEnumRulesUiTestLanguage.g:170:4: 'DifferentLiteral'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__GeneratedEnum__Alternatives"


    // $ANTLR start "rule__Model__Group_0__0"
    // InternalEnumRulesUiTestLanguage.g:178:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:182:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // InternalEnumRulesUiTestLanguage.g:183:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__1();

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
    // $ANTLR end "rule__Model__Group_0__0"


    // $ANTLR start "rule__Model__Group_0__0__Impl"
    // InternalEnumRulesUiTestLanguage.g:190:1: rule__Model__Group_0__0__Impl : ( 'existing' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:194:1: ( ( 'existing' ) )
            // InternalEnumRulesUiTestLanguage.g:195:1: ( 'existing' )
            {
            // InternalEnumRulesUiTestLanguage.g:195:1: ( 'existing' )
            // InternalEnumRulesUiTestLanguage.g:196:2: 'existing'
            {
             before(grammarAccess.getModelAccess().getExistingKeyword_0_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelAccess().getExistingKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0__0__Impl"


    // $ANTLR start "rule__Model__Group_0__1"
    // InternalEnumRulesUiTestLanguage.g:205:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl rule__Model__Group_0__2 ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:209:1: ( rule__Model__Group_0__1__Impl rule__Model__Group_0__2 )
            // InternalEnumRulesUiTestLanguage.g:210:2: rule__Model__Group_0__1__Impl rule__Model__Group_0__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Model__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__2();

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
    // $ANTLR end "rule__Model__Group_0__1"


    // $ANTLR start "rule__Model__Group_0__1__Impl"
    // InternalEnumRulesUiTestLanguage.g:217:1: rule__Model__Group_0__1__Impl : ( ( rule__Model__ExistingAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:221:1: ( ( ( rule__Model__ExistingAssignment_0_1 ) ) )
            // InternalEnumRulesUiTestLanguage.g:222:1: ( ( rule__Model__ExistingAssignment_0_1 ) )
            {
            // InternalEnumRulesUiTestLanguage.g:222:1: ( ( rule__Model__ExistingAssignment_0_1 ) )
            // InternalEnumRulesUiTestLanguage.g:223:2: ( rule__Model__ExistingAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getExistingAssignment_0_1()); 
            // InternalEnumRulesUiTestLanguage.g:224:2: ( rule__Model__ExistingAssignment_0_1 )
            // InternalEnumRulesUiTestLanguage.g:224:3: rule__Model__ExistingAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__ExistingAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getExistingAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0__1__Impl"


    // $ANTLR start "rule__Model__Group_0__2"
    // InternalEnumRulesUiTestLanguage.g:232:1: rule__Model__Group_0__2 : rule__Model__Group_0__2__Impl ;
    public final void rule__Model__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:236:1: ( rule__Model__Group_0__2__Impl )
            // InternalEnumRulesUiTestLanguage.g:237:2: rule__Model__Group_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__2__Impl();

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
    // $ANTLR end "rule__Model__Group_0__2"


    // $ANTLR start "rule__Model__Group_0__2__Impl"
    // InternalEnumRulesUiTestLanguage.g:243:1: rule__Model__Group_0__2__Impl : ( ( rule__Model__Group_0_2__0 )? ) ;
    public final void rule__Model__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:247:1: ( ( ( rule__Model__Group_0_2__0 )? ) )
            // InternalEnumRulesUiTestLanguage.g:248:1: ( ( rule__Model__Group_0_2__0 )? )
            {
            // InternalEnumRulesUiTestLanguage.g:248:1: ( ( rule__Model__Group_0_2__0 )? )
            // InternalEnumRulesUiTestLanguage.g:249:2: ( rule__Model__Group_0_2__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_0_2()); 
            // InternalEnumRulesUiTestLanguage.g:250:2: ( rule__Model__Group_0_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalEnumRulesUiTestLanguage.g:250:3: rule__Model__Group_0_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_0_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0__2__Impl"


    // $ANTLR start "rule__Model__Group_0_2__0"
    // InternalEnumRulesUiTestLanguage.g:259:1: rule__Model__Group_0_2__0 : rule__Model__Group_0_2__0__Impl rule__Model__Group_0_2__1 ;
    public final void rule__Model__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:263:1: ( rule__Model__Group_0_2__0__Impl rule__Model__Group_0_2__1 )
            // InternalEnumRulesUiTestLanguage.g:264:2: rule__Model__Group_0_2__0__Impl rule__Model__Group_0_2__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Model__Group_0_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0_2__1();

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
    // $ANTLR end "rule__Model__Group_0_2__0"


    // $ANTLR start "rule__Model__Group_0_2__0__Impl"
    // InternalEnumRulesUiTestLanguage.g:271:1: rule__Model__Group_0_2__0__Impl : ( 'generated' ) ;
    public final void rule__Model__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:275:1: ( ( 'generated' ) )
            // InternalEnumRulesUiTestLanguage.g:276:1: ( 'generated' )
            {
            // InternalEnumRulesUiTestLanguage.g:276:1: ( 'generated' )
            // InternalEnumRulesUiTestLanguage.g:277:2: 'generated'
            {
             before(grammarAccess.getModelAccess().getGeneratedKeyword_0_2_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelAccess().getGeneratedKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0_2__0__Impl"


    // $ANTLR start "rule__Model__Group_0_2__1"
    // InternalEnumRulesUiTestLanguage.g:286:1: rule__Model__Group_0_2__1 : rule__Model__Group_0_2__1__Impl ;
    public final void rule__Model__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:290:1: ( rule__Model__Group_0_2__1__Impl )
            // InternalEnumRulesUiTestLanguage.g:291:2: rule__Model__Group_0_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0_2__1__Impl();

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
    // $ANTLR end "rule__Model__Group_0_2__1"


    // $ANTLR start "rule__Model__Group_0_2__1__Impl"
    // InternalEnumRulesUiTestLanguage.g:297:1: rule__Model__Group_0_2__1__Impl : ( ( rule__Model__GeneratedAssignment_0_2_1 ) ) ;
    public final void rule__Model__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:301:1: ( ( ( rule__Model__GeneratedAssignment_0_2_1 ) ) )
            // InternalEnumRulesUiTestLanguage.g:302:1: ( ( rule__Model__GeneratedAssignment_0_2_1 ) )
            {
            // InternalEnumRulesUiTestLanguage.g:302:1: ( ( rule__Model__GeneratedAssignment_0_2_1 ) )
            // InternalEnumRulesUiTestLanguage.g:303:2: ( rule__Model__GeneratedAssignment_0_2_1 )
            {
             before(grammarAccess.getModelAccess().getGeneratedAssignment_0_2_1()); 
            // InternalEnumRulesUiTestLanguage.g:304:2: ( rule__Model__GeneratedAssignment_0_2_1 )
            // InternalEnumRulesUiTestLanguage.g:304:3: rule__Model__GeneratedAssignment_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__GeneratedAssignment_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGeneratedAssignment_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0_2__1__Impl"


    // $ANTLR start "rule__Model__Group_1__0"
    // InternalEnumRulesUiTestLanguage.g:313:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:317:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // InternalEnumRulesUiTestLanguage.g:318:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_1__1();

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
    // $ANTLR end "rule__Model__Group_1__0"


    // $ANTLR start "rule__Model__Group_1__0__Impl"
    // InternalEnumRulesUiTestLanguage.g:325:1: rule__Model__Group_1__0__Impl : ( 'generated' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:329:1: ( ( 'generated' ) )
            // InternalEnumRulesUiTestLanguage.g:330:1: ( 'generated' )
            {
            // InternalEnumRulesUiTestLanguage.g:330:1: ( 'generated' )
            // InternalEnumRulesUiTestLanguage.g:331:2: 'generated'
            {
             before(grammarAccess.getModelAccess().getGeneratedKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getModelAccess().getGeneratedKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1__1"
    // InternalEnumRulesUiTestLanguage.g:340:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:344:1: ( rule__Model__Group_1__1__Impl )
            // InternalEnumRulesUiTestLanguage.g:345:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_1__1__Impl();

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
    // $ANTLR end "rule__Model__Group_1__1"


    // $ANTLR start "rule__Model__Group_1__1__Impl"
    // InternalEnumRulesUiTestLanguage.g:351:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__GeneratedAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:355:1: ( ( ( rule__Model__GeneratedAssignment_1_1 ) ) )
            // InternalEnumRulesUiTestLanguage.g:356:1: ( ( rule__Model__GeneratedAssignment_1_1 ) )
            {
            // InternalEnumRulesUiTestLanguage.g:356:1: ( ( rule__Model__GeneratedAssignment_1_1 ) )
            // InternalEnumRulesUiTestLanguage.g:357:2: ( rule__Model__GeneratedAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getGeneratedAssignment_1_1()); 
            // InternalEnumRulesUiTestLanguage.g:358:2: ( rule__Model__GeneratedAssignment_1_1 )
            // InternalEnumRulesUiTestLanguage.g:358:3: rule__Model__GeneratedAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__GeneratedAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGeneratedAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ExistingAssignment_0_1"
    // InternalEnumRulesUiTestLanguage.g:367:1: rule__Model__ExistingAssignment_0_1 : ( ruleExistingEnum ) ;
    public final void rule__Model__ExistingAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:371:1: ( ( ruleExistingEnum ) )
            // InternalEnumRulesUiTestLanguage.g:372:2: ( ruleExistingEnum )
            {
            // InternalEnumRulesUiTestLanguage.g:372:2: ( ruleExistingEnum )
            // InternalEnumRulesUiTestLanguage.g:373:3: ruleExistingEnum
            {
             before(grammarAccess.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleExistingEnum();

            state._fsp--;

             after(grammarAccess.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ExistingAssignment_0_1"


    // $ANTLR start "rule__Model__GeneratedAssignment_0_2_1"
    // InternalEnumRulesUiTestLanguage.g:382:1: rule__Model__GeneratedAssignment_0_2_1 : ( ruleGeneratedEnum ) ;
    public final void rule__Model__GeneratedAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:386:1: ( ( ruleGeneratedEnum ) )
            // InternalEnumRulesUiTestLanguage.g:387:2: ( ruleGeneratedEnum )
            {
            // InternalEnumRulesUiTestLanguage.g:387:2: ( ruleGeneratedEnum )
            // InternalEnumRulesUiTestLanguage.g:388:3: ruleGeneratedEnum
            {
             before(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_0_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGeneratedEnum();

            state._fsp--;

             after(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__GeneratedAssignment_0_2_1"


    // $ANTLR start "rule__Model__GeneratedAssignment_1_1"
    // InternalEnumRulesUiTestLanguage.g:397:1: rule__Model__GeneratedAssignment_1_1 : ( ruleGeneratedEnum ) ;
    public final void rule__Model__GeneratedAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEnumRulesUiTestLanguage.g:401:1: ( ( ruleGeneratedEnum ) )
            // InternalEnumRulesUiTestLanguage.g:402:2: ( ruleGeneratedEnum )
            {
            // InternalEnumRulesUiTestLanguage.g:402:2: ( ruleGeneratedEnum )
            // InternalEnumRulesUiTestLanguage.g:403:3: ruleGeneratedEnum
            {
             before(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGeneratedEnum();

            state._fsp--;

             after(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__GeneratedAssignment_1_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002800L});
    }


}
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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistCustomizingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistCustomizingTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'extends'", "'.'", "'FQN'"
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


        public InternalContentAssistCustomizingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistCustomizingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistCustomizingTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistCustomizingTestLanguage.g"; }


    	private ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess) {
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
    // InternalContentAssistCustomizingTestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalContentAssistCustomizingTestLanguage.g:54:1: ( ruleModel EOF )
            // InternalContentAssistCustomizingTestLanguage.g:55:1: ruleModel EOF
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
    // InternalContentAssistCustomizingTestLanguage.g:62:1: ruleModel : ( ( rule__Model__TypesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:66:2: ( ( ( rule__Model__TypesAssignment )* ) )
            // InternalContentAssistCustomizingTestLanguage.g:67:2: ( ( rule__Model__TypesAssignment )* )
            {
            // InternalContentAssistCustomizingTestLanguage.g:67:2: ( ( rule__Model__TypesAssignment )* )
            // InternalContentAssistCustomizingTestLanguage.g:68:3: ( rule__Model__TypesAssignment )*
            {
             before(grammarAccess.getModelAccess().getTypesAssignment()); 
            // InternalContentAssistCustomizingTestLanguage.g:69:3: ( rule__Model__TypesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContentAssistCustomizingTestLanguage.g:69:4: rule__Model__TypesAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Model__TypesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getTypesAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleType"
    // InternalContentAssistCustomizingTestLanguage.g:78:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalContentAssistCustomizingTestLanguage.g:79:1: ( ruleType EOF )
            // InternalContentAssistCustomizingTestLanguage.g:80:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalContentAssistCustomizingTestLanguage.g:87:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:91:2: ( ( ( rule__Type__Group__0 ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:92:2: ( ( rule__Type__Group__0 ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:92:2: ( ( rule__Type__Group__0 ) )
            // InternalContentAssistCustomizingTestLanguage.g:93:3: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // InternalContentAssistCustomizingTestLanguage.g:94:3: ( rule__Type__Group__0 )
            // InternalContentAssistCustomizingTestLanguage.g:94:4: rule__Type__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTypeRef"
    // InternalContentAssistCustomizingTestLanguage.g:103:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalContentAssistCustomizingTestLanguage.g:104:1: ( ruleTypeRef EOF )
            // InternalContentAssistCustomizingTestLanguage.g:105:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTypeRefRule()); 
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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalContentAssistCustomizingTestLanguage.g:112:1: ruleTypeRef : ( ( rule__TypeRef__TypeAssignment ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:116:2: ( ( ( rule__TypeRef__TypeAssignment ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:117:2: ( ( rule__TypeRef__TypeAssignment ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:117:2: ( ( rule__TypeRef__TypeAssignment ) )
            // InternalContentAssistCustomizingTestLanguage.g:118:3: ( rule__TypeRef__TypeAssignment )
            {
             before(grammarAccess.getTypeRefAccess().getTypeAssignment()); 
            // InternalContentAssistCustomizingTestLanguage.g:119:3: ( rule__TypeRef__TypeAssignment )
            // InternalContentAssistCustomizingTestLanguage.g:119:4: rule__TypeRef__TypeAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__TypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleFQN"
    // InternalContentAssistCustomizingTestLanguage.g:128:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalContentAssistCustomizingTestLanguage.g:129:1: ( ruleFQN EOF )
            // InternalContentAssistCustomizingTestLanguage.g:130:1: ruleFQN EOF
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
    // InternalContentAssistCustomizingTestLanguage.g:137:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:141:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:142:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:142:2: ( ( rule__FQN__Group__0 ) )
            // InternalContentAssistCustomizingTestLanguage.g:143:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalContentAssistCustomizingTestLanguage.g:144:3: ( rule__FQN__Group__0 )
            // InternalContentAssistCustomizingTestLanguage.g:144:4: rule__FQN__Group__0
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


    // $ANTLR start "rule__Type__Alternatives_0"
    // InternalContentAssistCustomizingTestLanguage.g:152:1: rule__Type__Alternatives_0 : ( ( ( rule__Type__NameAssignment_0_0 ) ) | ( ( rule__Type__NameAssignment_0_1 ) ) );
    public final void rule__Type__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:156:1: ( ( ( rule__Type__NameAssignment_0_0 ) ) | ( ( rule__Type__NameAssignment_0_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalContentAssistCustomizingTestLanguage.g:157:2: ( ( rule__Type__NameAssignment_0_0 ) )
                    {
                    // InternalContentAssistCustomizingTestLanguage.g:157:2: ( ( rule__Type__NameAssignment_0_0 ) )
                    // InternalContentAssistCustomizingTestLanguage.g:158:3: ( rule__Type__NameAssignment_0_0 )
                    {
                     before(grammarAccess.getTypeAccess().getNameAssignment_0_0()); 
                    // InternalContentAssistCustomizingTestLanguage.g:159:3: ( rule__Type__NameAssignment_0_0 )
                    // InternalContentAssistCustomizingTestLanguage.g:159:4: rule__Type__NameAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Type__NameAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeAccess().getNameAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalContentAssistCustomizingTestLanguage.g:163:2: ( ( rule__Type__NameAssignment_0_1 ) )
                    {
                    // InternalContentAssistCustomizingTestLanguage.g:163:2: ( ( rule__Type__NameAssignment_0_1 ) )
                    // InternalContentAssistCustomizingTestLanguage.g:164:3: ( rule__Type__NameAssignment_0_1 )
                    {
                     before(grammarAccess.getTypeAccess().getNameAssignment_0_1()); 
                    // InternalContentAssistCustomizingTestLanguage.g:165:3: ( rule__Type__NameAssignment_0_1 )
                    // InternalContentAssistCustomizingTestLanguage.g:165:4: rule__Type__NameAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Type__NameAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeAccess().getNameAssignment_0_1()); 

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
    // $ANTLR end "rule__Type__Alternatives_0"


    // $ANTLR start "rule__Type__Group__0"
    // InternalContentAssistCustomizingTestLanguage.g:173:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:177:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // InternalContentAssistCustomizingTestLanguage.g:178:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Type__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__1();

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
    // $ANTLR end "rule__Type__Group__0"


    // $ANTLR start "rule__Type__Group__0__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:185:1: rule__Type__Group__0__Impl : ( ( rule__Type__Alternatives_0 ) ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:189:1: ( ( ( rule__Type__Alternatives_0 ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:190:1: ( ( rule__Type__Alternatives_0 ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:190:1: ( ( rule__Type__Alternatives_0 ) )
            // InternalContentAssistCustomizingTestLanguage.g:191:2: ( rule__Type__Alternatives_0 )
            {
             before(grammarAccess.getTypeAccess().getAlternatives_0()); 
            // InternalContentAssistCustomizingTestLanguage.g:192:2: ( rule__Type__Alternatives_0 )
            // InternalContentAssistCustomizingTestLanguage.g:192:3: rule__Type__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group__0__Impl"


    // $ANTLR start "rule__Type__Group__1"
    // InternalContentAssistCustomizingTestLanguage.g:200:1: rule__Type__Group__1 : rule__Type__Group__1__Impl rule__Type__Group__2 ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:204:1: ( rule__Type__Group__1__Impl rule__Type__Group__2 )
            // InternalContentAssistCustomizingTestLanguage.g:205:2: rule__Type__Group__1__Impl rule__Type__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Type__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__2();

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
    // $ANTLR end "rule__Type__Group__1"


    // $ANTLR start "rule__Type__Group__1__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:212:1: rule__Type__Group__1__Impl : ( ( rule__Type__Group_1__0 )? ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:216:1: ( ( ( rule__Type__Group_1__0 )? ) )
            // InternalContentAssistCustomizingTestLanguage.g:217:1: ( ( rule__Type__Group_1__0 )? )
            {
            // InternalContentAssistCustomizingTestLanguage.g:217:1: ( ( rule__Type__Group_1__0 )? )
            // InternalContentAssistCustomizingTestLanguage.g:218:2: ( rule__Type__Group_1__0 )?
            {
             before(grammarAccess.getTypeAccess().getGroup_1()); 
            // InternalContentAssistCustomizingTestLanguage.g:219:2: ( rule__Type__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalContentAssistCustomizingTestLanguage.g:219:3: rule__Type__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Type__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group__1__Impl"


    // $ANTLR start "rule__Type__Group__2"
    // InternalContentAssistCustomizingTestLanguage.g:227:1: rule__Type__Group__2 : rule__Type__Group__2__Impl ;
    public final void rule__Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:231:1: ( rule__Type__Group__2__Impl )
            // InternalContentAssistCustomizingTestLanguage.g:232:2: rule__Type__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__2__Impl();

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
    // $ANTLR end "rule__Type__Group__2"


    // $ANTLR start "rule__Type__Group__2__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:238:1: rule__Type__Group__2__Impl : ( ';' ) ;
    public final void rule__Type__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:242:1: ( ( ';' ) )
            // InternalContentAssistCustomizingTestLanguage.g:243:1: ( ';' )
            {
            // InternalContentAssistCustomizingTestLanguage.g:243:1: ( ';' )
            // InternalContentAssistCustomizingTestLanguage.g:244:2: ';'
            {
             before(grammarAccess.getTypeAccess().getSemicolonKeyword_2()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group__2__Impl"


    // $ANTLR start "rule__Type__Group_1__0"
    // InternalContentAssistCustomizingTestLanguage.g:254:1: rule__Type__Group_1__0 : rule__Type__Group_1__0__Impl rule__Type__Group_1__1 ;
    public final void rule__Type__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:258:1: ( rule__Type__Group_1__0__Impl rule__Type__Group_1__1 )
            // InternalContentAssistCustomizingTestLanguage.g:259:2: rule__Type__Group_1__0__Impl rule__Type__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Type__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group_1__1();

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
    // $ANTLR end "rule__Type__Group_1__0"


    // $ANTLR start "rule__Type__Group_1__0__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:266:1: rule__Type__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__Type__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:270:1: ( ( 'extends' ) )
            // InternalContentAssistCustomizingTestLanguage.g:271:1: ( 'extends' )
            {
            // InternalContentAssistCustomizingTestLanguage.g:271:1: ( 'extends' )
            // InternalContentAssistCustomizingTestLanguage.g:272:2: 'extends'
            {
             before(grammarAccess.getTypeAccess().getExtendsKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getExtendsKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_1__0__Impl"


    // $ANTLR start "rule__Type__Group_1__1"
    // InternalContentAssistCustomizingTestLanguage.g:281:1: rule__Type__Group_1__1 : rule__Type__Group_1__1__Impl ;
    public final void rule__Type__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:285:1: ( rule__Type__Group_1__1__Impl )
            // InternalContentAssistCustomizingTestLanguage.g:286:2: rule__Type__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group_1__1__Impl();

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
    // $ANTLR end "rule__Type__Group_1__1"


    // $ANTLR start "rule__Type__Group_1__1__Impl"
    // InternalContentAssistCustomizingTestLanguage.g:292:1: rule__Type__Group_1__1__Impl : ( ( rule__Type__SuperTypeAssignment_1_1 ) ) ;
    public final void rule__Type__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:296:1: ( ( ( rule__Type__SuperTypeAssignment_1_1 ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:297:1: ( ( rule__Type__SuperTypeAssignment_1_1 ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:297:1: ( ( rule__Type__SuperTypeAssignment_1_1 ) )
            // InternalContentAssistCustomizingTestLanguage.g:298:2: ( rule__Type__SuperTypeAssignment_1_1 )
            {
             before(grammarAccess.getTypeAccess().getSuperTypeAssignment_1_1()); 
            // InternalContentAssistCustomizingTestLanguage.g:299:2: ( rule__Type__SuperTypeAssignment_1_1 )
            // InternalContentAssistCustomizingTestLanguage.g:299:3: rule__Type__SuperTypeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__SuperTypeAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getSuperTypeAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_1__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalContentAssistCustomizingTestLanguage.g:308:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:312:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalContentAssistCustomizingTestLanguage.g:313:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
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
    // InternalContentAssistCustomizingTestLanguage.g:320:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:324:1: ( ( RULE_ID ) )
            // InternalContentAssistCustomizingTestLanguage.g:325:1: ( RULE_ID )
            {
            // InternalContentAssistCustomizingTestLanguage.g:325:1: ( RULE_ID )
            // InternalContentAssistCustomizingTestLanguage.g:326:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
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
    // InternalContentAssistCustomizingTestLanguage.g:335:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:339:1: ( rule__FQN__Group__1__Impl )
            // InternalContentAssistCustomizingTestLanguage.g:340:2: rule__FQN__Group__1__Impl
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
    // InternalContentAssistCustomizingTestLanguage.g:346:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:350:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalContentAssistCustomizingTestLanguage.g:351:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalContentAssistCustomizingTestLanguage.g:351:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalContentAssistCustomizingTestLanguage.g:352:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalContentAssistCustomizingTestLanguage.g:353:2: ( rule__FQN__Group_1__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalContentAssistCustomizingTestLanguage.g:353:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // InternalContentAssistCustomizingTestLanguage.g:362:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:366:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalContentAssistCustomizingTestLanguage.g:367:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalContentAssistCustomizingTestLanguage.g:374:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:378:1: ( ( '.' ) )
            // InternalContentAssistCustomizingTestLanguage.g:379:1: ( '.' )
            {
            // InternalContentAssistCustomizingTestLanguage.g:379:1: ( '.' )
            // InternalContentAssistCustomizingTestLanguage.g:380:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
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
    // InternalContentAssistCustomizingTestLanguage.g:389:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:393:1: ( rule__FQN__Group_1__1__Impl )
            // InternalContentAssistCustomizingTestLanguage.g:394:2: rule__FQN__Group_1__1__Impl
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
    // InternalContentAssistCustomizingTestLanguage.g:400:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:404:1: ( ( RULE_ID ) )
            // InternalContentAssistCustomizingTestLanguage.g:405:1: ( RULE_ID )
            {
            // InternalContentAssistCustomizingTestLanguage.g:405:1: ( RULE_ID )
            // InternalContentAssistCustomizingTestLanguage.g:406:2: RULE_ID
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


    // $ANTLR start "rule__Model__TypesAssignment"
    // InternalContentAssistCustomizingTestLanguage.g:416:1: rule__Model__TypesAssignment : ( ruleType ) ;
    public final void rule__Model__TypesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:420:1: ( ( ruleType ) )
            // InternalContentAssistCustomizingTestLanguage.g:421:2: ( ruleType )
            {
            // InternalContentAssistCustomizingTestLanguage.g:421:2: ( ruleType )
            // InternalContentAssistCustomizingTestLanguage.g:422:3: ruleType
            {
             before(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__TypesAssignment"


    // $ANTLR start "rule__Type__NameAssignment_0_0"
    // InternalContentAssistCustomizingTestLanguage.g:431:1: rule__Type__NameAssignment_0_0 : ( ruleFQN ) ;
    public final void rule__Type__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:435:1: ( ( ruleFQN ) )
            // InternalContentAssistCustomizingTestLanguage.g:436:2: ( ruleFQN )
            {
            // InternalContentAssistCustomizingTestLanguage.g:436:2: ( ruleFQN )
            // InternalContentAssistCustomizingTestLanguage.g:437:3: ruleFQN
            {
             before(grammarAccess.getTypeAccess().getNameFQNParserRuleCall_0_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getNameFQNParserRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__NameAssignment_0_0"


    // $ANTLR start "rule__Type__NameAssignment_0_1"
    // InternalContentAssistCustomizingTestLanguage.g:446:1: rule__Type__NameAssignment_0_1 : ( ( 'FQN' ) ) ;
    public final void rule__Type__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:450:1: ( ( ( 'FQN' ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:451:2: ( ( 'FQN' ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:451:2: ( ( 'FQN' ) )
            // InternalContentAssistCustomizingTestLanguage.g:452:3: ( 'FQN' )
            {
             before(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 
            // InternalContentAssistCustomizingTestLanguage.g:453:3: ( 'FQN' )
            // InternalContentAssistCustomizingTestLanguage.g:454:4: 'FQN'
            {
             before(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 

            }

             after(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__NameAssignment_0_1"


    // $ANTLR start "rule__Type__SuperTypeAssignment_1_1"
    // InternalContentAssistCustomizingTestLanguage.g:465:1: rule__Type__SuperTypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__Type__SuperTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:469:1: ( ( ruleTypeRef ) )
            // InternalContentAssistCustomizingTestLanguage.g:470:2: ( ruleTypeRef )
            {
            // InternalContentAssistCustomizingTestLanguage.g:470:2: ( ruleTypeRef )
            // InternalContentAssistCustomizingTestLanguage.g:471:3: ruleTypeRef
            {
             before(grammarAccess.getTypeAccess().getSuperTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getSuperTypeTypeRefParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__SuperTypeAssignment_1_1"


    // $ANTLR start "rule__TypeRef__TypeAssignment"
    // InternalContentAssistCustomizingTestLanguage.g:480:1: rule__TypeRef__TypeAssignment : ( ( ruleFQN ) ) ;
    public final void rule__TypeRef__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistCustomizingTestLanguage.g:484:1: ( ( ( ruleFQN ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:485:2: ( ( ruleFQN ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:485:2: ( ( ruleFQN ) )
            // InternalContentAssistCustomizingTestLanguage.g:486:3: ( ruleFQN )
            {
             before(grammarAccess.getTypeRefAccess().getTypeTypeCrossReference_0()); 
            // InternalContentAssistCustomizingTestLanguage.g:487:3: ( ruleFQN )
            // InternalContentAssistCustomizingTestLanguage.g:488:4: ruleFQN
            {
             before(grammarAccess.getTypeRefAccess().getTypeTypeFQNParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getTypeRefAccess().getTypeTypeFQNParserRuleCall_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getTypeTypeCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__TypeAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002002L});
    }


}
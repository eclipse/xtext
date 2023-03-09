package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPartialContentAssistTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'int'", "'bool'", "'type'", "'{'", "'}'", "'extends'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalPartialContentAssistTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPartialContentAssistTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPartialContentAssistTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPartialContentAssistTestLanguage.g"; }


    	private PartialContentAssistTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(PartialContentAssistTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleTypeDeclaration"
    // InternalPartialContentAssistTestLanguage.g:58:1: entryRuleTypeDeclaration : ruleTypeDeclaration EOF ;
    public final void entryRuleTypeDeclaration() throws RecognitionException {
        try {
            // InternalPartialContentAssistTestLanguage.g:59:1: ( ruleTypeDeclaration EOF )
            // InternalPartialContentAssistTestLanguage.g:60:1: ruleTypeDeclaration EOF
            {
             before(grammarAccess.getTypeDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeDeclaration();

            state._fsp--;

             after(grammarAccess.getTypeDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTypeDeclaration"


    // $ANTLR start "ruleTypeDeclaration"
    // InternalPartialContentAssistTestLanguage.g:67:1: ruleTypeDeclaration : ( ( rule__TypeDeclaration__Group__0 ) ) ;
    public final void ruleTypeDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:71:2: ( ( ( rule__TypeDeclaration__Group__0 ) ) )
            // InternalPartialContentAssistTestLanguage.g:72:2: ( ( rule__TypeDeclaration__Group__0 ) )
            {
            // InternalPartialContentAssistTestLanguage.g:72:2: ( ( rule__TypeDeclaration__Group__0 ) )
            // InternalPartialContentAssistTestLanguage.g:73:3: ( rule__TypeDeclaration__Group__0 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getGroup()); 
            // InternalPartialContentAssistTestLanguage.g:74:3: ( rule__TypeDeclaration__Group__0 )
            // InternalPartialContentAssistTestLanguage.g:74:4: rule__TypeDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeDeclaration"


    // $ANTLR start "entryRuleProperty"
    // InternalPartialContentAssistTestLanguage.g:83:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // InternalPartialContentAssistTestLanguage.g:84:1: ( ruleProperty EOF )
            // InternalPartialContentAssistTestLanguage.g:85:1: ruleProperty EOF
            {
             before(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleProperty();

            state._fsp--;

             after(grammarAccess.getPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalPartialContentAssistTestLanguage.g:92:1: ruleProperty : ( ( rule__Property__Group__0 ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:96:2: ( ( ( rule__Property__Group__0 ) ) )
            // InternalPartialContentAssistTestLanguage.g:97:2: ( ( rule__Property__Group__0 ) )
            {
            // InternalPartialContentAssistTestLanguage.g:97:2: ( ( rule__Property__Group__0 ) )
            // InternalPartialContentAssistTestLanguage.g:98:3: ( rule__Property__Group__0 )
            {
             before(grammarAccess.getPropertyAccess().getGroup()); 
            // InternalPartialContentAssistTestLanguage.g:99:3: ( rule__Property__Group__0 )
            // InternalPartialContentAssistTestLanguage.g:99:4: rule__Property__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Property__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProperty"


    // $ANTLR start "rule__Property__TypeAlternatives_0_0"
    // InternalPartialContentAssistTestLanguage.g:107:1: rule__Property__TypeAlternatives_0_0 : ( ( 'int' ) | ( 'bool' ) );
    public final void rule__Property__TypeAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:111:1: ( ( 'int' ) | ( 'bool' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalPartialContentAssistTestLanguage.g:112:2: ( 'int' )
                    {
                    // InternalPartialContentAssistTestLanguage.g:112:2: ( 'int' )
                    // InternalPartialContentAssistTestLanguage.g:113:3: 'int'
                    {
                     before(grammarAccess.getPropertyAccess().getTypeIntKeyword_0_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getPropertyAccess().getTypeIntKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPartialContentAssistTestLanguage.g:118:2: ( 'bool' )
                    {
                    // InternalPartialContentAssistTestLanguage.g:118:2: ( 'bool' )
                    // InternalPartialContentAssistTestLanguage.g:119:3: 'bool'
                    {
                     before(grammarAccess.getPropertyAccess().getTypeBoolKeyword_0_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getPropertyAccess().getTypeBoolKeyword_0_0_1()); 

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
    // $ANTLR end "rule__Property__TypeAlternatives_0_0"


    // $ANTLR start "rule__TypeDeclaration__Group__0"
    // InternalPartialContentAssistTestLanguage.g:128:1: rule__TypeDeclaration__Group__0 : rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1 ;
    public final void rule__TypeDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:132:1: ( rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1 )
            // InternalPartialContentAssistTestLanguage.g:133:2: rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__TypeDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__1();

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
    // $ANTLR end "rule__TypeDeclaration__Group__0"


    // $ANTLR start "rule__TypeDeclaration__Group__0__Impl"
    // InternalPartialContentAssistTestLanguage.g:140:1: rule__TypeDeclaration__Group__0__Impl : ( 'type' ) ;
    public final void rule__TypeDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:144:1: ( ( 'type' ) )
            // InternalPartialContentAssistTestLanguage.g:145:1: ( 'type' )
            {
            // InternalPartialContentAssistTestLanguage.g:145:1: ( 'type' )
            // InternalPartialContentAssistTestLanguage.g:146:2: 'type'
            {
             before(grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__Group__0__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__1"
    // InternalPartialContentAssistTestLanguage.g:155:1: rule__TypeDeclaration__Group__1 : rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2 ;
    public final void rule__TypeDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:159:1: ( rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2 )
            // InternalPartialContentAssistTestLanguage.g:160:2: rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__TypeDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__2();

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
    // $ANTLR end "rule__TypeDeclaration__Group__1"


    // $ANTLR start "rule__TypeDeclaration__Group__1__Impl"
    // InternalPartialContentAssistTestLanguage.g:167:1: rule__TypeDeclaration__Group__1__Impl : ( ( rule__TypeDeclaration__NameAssignment_1 ) ) ;
    public final void rule__TypeDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:171:1: ( ( ( rule__TypeDeclaration__NameAssignment_1 ) ) )
            // InternalPartialContentAssistTestLanguage.g:172:1: ( ( rule__TypeDeclaration__NameAssignment_1 ) )
            {
            // InternalPartialContentAssistTestLanguage.g:172:1: ( ( rule__TypeDeclaration__NameAssignment_1 ) )
            // InternalPartialContentAssistTestLanguage.g:173:2: ( rule__TypeDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1()); 
            // InternalPartialContentAssistTestLanguage.g:174:2: ( rule__TypeDeclaration__NameAssignment_1 )
            // InternalPartialContentAssistTestLanguage.g:174:3: rule__TypeDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__Group__1__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__2"
    // InternalPartialContentAssistTestLanguage.g:182:1: rule__TypeDeclaration__Group__2 : rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3 ;
    public final void rule__TypeDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:186:1: ( rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3 )
            // InternalPartialContentAssistTestLanguage.g:187:2: rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__TypeDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__3();

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
    // $ANTLR end "rule__TypeDeclaration__Group__2"


    // $ANTLR start "rule__TypeDeclaration__Group__2__Impl"
    // InternalPartialContentAssistTestLanguage.g:194:1: rule__TypeDeclaration__Group__2__Impl : ( ( rule__TypeDeclaration__Group_2__0 )? ) ;
    public final void rule__TypeDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:198:1: ( ( ( rule__TypeDeclaration__Group_2__0 )? ) )
            // InternalPartialContentAssistTestLanguage.g:199:1: ( ( rule__TypeDeclaration__Group_2__0 )? )
            {
            // InternalPartialContentAssistTestLanguage.g:199:1: ( ( rule__TypeDeclaration__Group_2__0 )? )
            // InternalPartialContentAssistTestLanguage.g:200:2: ( rule__TypeDeclaration__Group_2__0 )?
            {
             before(grammarAccess.getTypeDeclarationAccess().getGroup_2()); 
            // InternalPartialContentAssistTestLanguage.g:201:2: ( rule__TypeDeclaration__Group_2__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalPartialContentAssistTestLanguage.g:201:3: rule__TypeDeclaration__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeDeclaration__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeDeclarationAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__Group__2__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__3"
    // InternalPartialContentAssistTestLanguage.g:209:1: rule__TypeDeclaration__Group__3 : rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4 ;
    public final void rule__TypeDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:213:1: ( rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4 )
            // InternalPartialContentAssistTestLanguage.g:214:2: rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__TypeDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__4();

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
    // $ANTLR end "rule__TypeDeclaration__Group__3"


    // $ANTLR start "rule__TypeDeclaration__Group__3__Impl"
    // InternalPartialContentAssistTestLanguage.g:221:1: rule__TypeDeclaration__Group__3__Impl : ( '{' ) ;
    public final void rule__TypeDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:225:1: ( ( '{' ) )
            // InternalPartialContentAssistTestLanguage.g:226:1: ( '{' )
            {
            // InternalPartialContentAssistTestLanguage.g:226:1: ( '{' )
            // InternalPartialContentAssistTestLanguage.g:227:2: '{'
            {
             before(grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__Group__3__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__4"
    // InternalPartialContentAssistTestLanguage.g:236:1: rule__TypeDeclaration__Group__4 : rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5 ;
    public final void rule__TypeDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:240:1: ( rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5 )
            // InternalPartialContentAssistTestLanguage.g:241:2: rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__TypeDeclaration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__5();

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
    // $ANTLR end "rule__TypeDeclaration__Group__4"


    // $ANTLR start "rule__TypeDeclaration__Group__4__Impl"
    // InternalPartialContentAssistTestLanguage.g:248:1: rule__TypeDeclaration__Group__4__Impl : ( ( rule__TypeDeclaration__PropertiesAssignment_4 )* ) ;
    public final void rule__TypeDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:252:1: ( ( ( rule__TypeDeclaration__PropertiesAssignment_4 )* ) )
            // InternalPartialContentAssistTestLanguage.g:253:1: ( ( rule__TypeDeclaration__PropertiesAssignment_4 )* )
            {
            // InternalPartialContentAssistTestLanguage.g:253:1: ( ( rule__TypeDeclaration__PropertiesAssignment_4 )* )
            // InternalPartialContentAssistTestLanguage.g:254:2: ( rule__TypeDeclaration__PropertiesAssignment_4 )*
            {
             before(grammarAccess.getTypeDeclarationAccess().getPropertiesAssignment_4()); 
            // InternalPartialContentAssistTestLanguage.g:255:2: ( rule__TypeDeclaration__PropertiesAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=12)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPartialContentAssistTestLanguage.g:255:3: rule__TypeDeclaration__PropertiesAssignment_4
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__TypeDeclaration__PropertiesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getTypeDeclarationAccess().getPropertiesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__Group__4__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__5"
    // InternalPartialContentAssistTestLanguage.g:263:1: rule__TypeDeclaration__Group__5 : rule__TypeDeclaration__Group__5__Impl ;
    public final void rule__TypeDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:267:1: ( rule__TypeDeclaration__Group__5__Impl )
            // InternalPartialContentAssistTestLanguage.g:268:2: rule__TypeDeclaration__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__5__Impl();

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
    // $ANTLR end "rule__TypeDeclaration__Group__5"


    // $ANTLR start "rule__TypeDeclaration__Group__5__Impl"
    // InternalPartialContentAssistTestLanguage.g:274:1: rule__TypeDeclaration__Group__5__Impl : ( '}' ) ;
    public final void rule__TypeDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:278:1: ( ( '}' ) )
            // InternalPartialContentAssistTestLanguage.g:279:1: ( '}' )
            {
            // InternalPartialContentAssistTestLanguage.g:279:1: ( '}' )
            // InternalPartialContentAssistTestLanguage.g:280:2: '}'
            {
             before(grammarAccess.getTypeDeclarationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__Group__5__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group_2__0"
    // InternalPartialContentAssistTestLanguage.g:290:1: rule__TypeDeclaration__Group_2__0 : rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1 ;
    public final void rule__TypeDeclaration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:294:1: ( rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1 )
            // InternalPartialContentAssistTestLanguage.g:295:2: rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__TypeDeclaration__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group_2__1();

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
    // $ANTLR end "rule__TypeDeclaration__Group_2__0"


    // $ANTLR start "rule__TypeDeclaration__Group_2__0__Impl"
    // InternalPartialContentAssistTestLanguage.g:302:1: rule__TypeDeclaration__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__TypeDeclaration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:306:1: ( ( 'extends' ) )
            // InternalPartialContentAssistTestLanguage.g:307:1: ( 'extends' )
            {
            // InternalPartialContentAssistTestLanguage.g:307:1: ( 'extends' )
            // InternalPartialContentAssistTestLanguage.g:308:2: 'extends'
            {
             before(grammarAccess.getTypeDeclarationAccess().getExtendsKeyword_2_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getExtendsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__Group_2__0__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group_2__1"
    // InternalPartialContentAssistTestLanguage.g:317:1: rule__TypeDeclaration__Group_2__1 : rule__TypeDeclaration__Group_2__1__Impl ;
    public final void rule__TypeDeclaration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:321:1: ( rule__TypeDeclaration__Group_2__1__Impl )
            // InternalPartialContentAssistTestLanguage.g:322:2: rule__TypeDeclaration__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group_2__1__Impl();

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
    // $ANTLR end "rule__TypeDeclaration__Group_2__1"


    // $ANTLR start "rule__TypeDeclaration__Group_2__1__Impl"
    // InternalPartialContentAssistTestLanguage.g:328:1: rule__TypeDeclaration__Group_2__1__Impl : ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) ) ;
    public final void rule__TypeDeclaration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:332:1: ( ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) ) )
            // InternalPartialContentAssistTestLanguage.g:333:1: ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) )
            {
            // InternalPartialContentAssistTestLanguage.g:333:1: ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) )
            // InternalPartialContentAssistTestLanguage.g:334:2: ( rule__TypeDeclaration__SuperTypeAssignment_2_1 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1()); 
            // InternalPartialContentAssistTestLanguage.g:335:2: ( rule__TypeDeclaration__SuperTypeAssignment_2_1 )
            // InternalPartialContentAssistTestLanguage.g:335:3: rule__TypeDeclaration__SuperTypeAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__SuperTypeAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__Group_2__1__Impl"


    // $ANTLR start "rule__Property__Group__0"
    // InternalPartialContentAssistTestLanguage.g:344:1: rule__Property__Group__0 : rule__Property__Group__0__Impl rule__Property__Group__1 ;
    public final void rule__Property__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:348:1: ( rule__Property__Group__0__Impl rule__Property__Group__1 )
            // InternalPartialContentAssistTestLanguage.g:349:2: rule__Property__Group__0__Impl rule__Property__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Property__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Property__Group__1();

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
    // $ANTLR end "rule__Property__Group__0"


    // $ANTLR start "rule__Property__Group__0__Impl"
    // InternalPartialContentAssistTestLanguage.g:356:1: rule__Property__Group__0__Impl : ( ( rule__Property__TypeAssignment_0 ) ) ;
    public final void rule__Property__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:360:1: ( ( ( rule__Property__TypeAssignment_0 ) ) )
            // InternalPartialContentAssistTestLanguage.g:361:1: ( ( rule__Property__TypeAssignment_0 ) )
            {
            // InternalPartialContentAssistTestLanguage.g:361:1: ( ( rule__Property__TypeAssignment_0 ) )
            // InternalPartialContentAssistTestLanguage.g:362:2: ( rule__Property__TypeAssignment_0 )
            {
             before(grammarAccess.getPropertyAccess().getTypeAssignment_0()); 
            // InternalPartialContentAssistTestLanguage.g:363:2: ( rule__Property__TypeAssignment_0 )
            // InternalPartialContentAssistTestLanguage.g:363:3: rule__Property__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Property__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Property__Group__0__Impl"


    // $ANTLR start "rule__Property__Group__1"
    // InternalPartialContentAssistTestLanguage.g:371:1: rule__Property__Group__1 : rule__Property__Group__1__Impl ;
    public final void rule__Property__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:375:1: ( rule__Property__Group__1__Impl )
            // InternalPartialContentAssistTestLanguage.g:376:2: rule__Property__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Property__Group__1__Impl();

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
    // $ANTLR end "rule__Property__Group__1"


    // $ANTLR start "rule__Property__Group__1__Impl"
    // InternalPartialContentAssistTestLanguage.g:382:1: rule__Property__Group__1__Impl : ( ( rule__Property__NameAssignment_1 ) ) ;
    public final void rule__Property__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:386:1: ( ( ( rule__Property__NameAssignment_1 ) ) )
            // InternalPartialContentAssistTestLanguage.g:387:1: ( ( rule__Property__NameAssignment_1 ) )
            {
            // InternalPartialContentAssistTestLanguage.g:387:1: ( ( rule__Property__NameAssignment_1 ) )
            // InternalPartialContentAssistTestLanguage.g:388:2: ( rule__Property__NameAssignment_1 )
            {
             before(grammarAccess.getPropertyAccess().getNameAssignment_1()); 
            // InternalPartialContentAssistTestLanguage.g:389:2: ( rule__Property__NameAssignment_1 )
            // InternalPartialContentAssistTestLanguage.g:389:3: rule__Property__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Property__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Property__Group__1__Impl"


    // $ANTLR start "rule__TypeDeclaration__NameAssignment_1"
    // InternalPartialContentAssistTestLanguage.g:398:1: rule__TypeDeclaration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TypeDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:402:1: ( ( RULE_ID ) )
            // InternalPartialContentAssistTestLanguage.g:403:2: ( RULE_ID )
            {
            // InternalPartialContentAssistTestLanguage.g:403:2: ( RULE_ID )
            // InternalPartialContentAssistTestLanguage.g:404:3: RULE_ID
            {
             before(grammarAccess.getTypeDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__NameAssignment_1"


    // $ANTLR start "rule__TypeDeclaration__SuperTypeAssignment_2_1"
    // InternalPartialContentAssistTestLanguage.g:413:1: rule__TypeDeclaration__SuperTypeAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeDeclaration__SuperTypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:417:1: ( ( ( RULE_ID ) ) )
            // InternalPartialContentAssistTestLanguage.g:418:2: ( ( RULE_ID ) )
            {
            // InternalPartialContentAssistTestLanguage.g:418:2: ( ( RULE_ID ) )
            // InternalPartialContentAssistTestLanguage.g:419:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationCrossReference_2_1_0()); 
            // InternalPartialContentAssistTestLanguage.g:420:3: ( RULE_ID )
            // InternalPartialContentAssistTestLanguage.g:421:4: RULE_ID
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__SuperTypeAssignment_2_1"


    // $ANTLR start "rule__TypeDeclaration__PropertiesAssignment_4"
    // InternalPartialContentAssistTestLanguage.g:432:1: rule__TypeDeclaration__PropertiesAssignment_4 : ( ruleProperty ) ;
    public final void rule__TypeDeclaration__PropertiesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:436:1: ( ( ruleProperty ) )
            // InternalPartialContentAssistTestLanguage.g:437:2: ( ruleProperty )
            {
            // InternalPartialContentAssistTestLanguage.g:437:2: ( ruleProperty )
            // InternalPartialContentAssistTestLanguage.g:438:3: ruleProperty
            {
             before(grammarAccess.getTypeDeclarationAccess().getPropertiesPropertyParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleProperty();

            state._fsp--;

             after(grammarAccess.getTypeDeclarationAccess().getPropertiesPropertyParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDeclaration__PropertiesAssignment_4"


    // $ANTLR start "rule__Property__TypeAssignment_0"
    // InternalPartialContentAssistTestLanguage.g:447:1: rule__Property__TypeAssignment_0 : ( ( rule__Property__TypeAlternatives_0_0 ) ) ;
    public final void rule__Property__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:451:1: ( ( ( rule__Property__TypeAlternatives_0_0 ) ) )
            // InternalPartialContentAssistTestLanguage.g:452:2: ( ( rule__Property__TypeAlternatives_0_0 ) )
            {
            // InternalPartialContentAssistTestLanguage.g:452:2: ( ( rule__Property__TypeAlternatives_0_0 ) )
            // InternalPartialContentAssistTestLanguage.g:453:3: ( rule__Property__TypeAlternatives_0_0 )
            {
             before(grammarAccess.getPropertyAccess().getTypeAlternatives_0_0()); 
            // InternalPartialContentAssistTestLanguage.g:454:3: ( rule__Property__TypeAlternatives_0_0 )
            // InternalPartialContentAssistTestLanguage.g:454:4: rule__Property__TypeAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__Property__TypeAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getTypeAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Property__TypeAssignment_0"


    // $ANTLR start "rule__Property__NameAssignment_1"
    // InternalPartialContentAssistTestLanguage.g:462:1: rule__Property__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Property__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialContentAssistTestLanguage.g:466:1: ( ( RULE_ID ) )
            // InternalPartialContentAssistTestLanguage.g:467:2: ( RULE_ID )
            {
            // InternalPartialContentAssistTestLanguage.g:467:2: ( RULE_ID )
            // InternalPartialContentAssistTestLanguage.g:468:3: RULE_ID
            {
             before(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Property__NameAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001802L});

}
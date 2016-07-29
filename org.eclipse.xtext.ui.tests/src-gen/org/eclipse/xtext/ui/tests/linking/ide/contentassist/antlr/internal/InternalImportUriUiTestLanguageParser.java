package org.eclipse.xtext.ui.tests.linking.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.linking.services.ImportUriUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalImportUriUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'extends'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalImportUriUiTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalImportUriUiTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalImportUriUiTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalImportUriUiTestLanguage.g"; }


    	private ImportUriUiTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(ImportUriUiTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleMain"
    // InternalImportUriUiTestLanguage.g:53:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // InternalImportUriUiTestLanguage.g:54:1: ( ruleMain EOF )
            // InternalImportUriUiTestLanguage.g:55:1: ruleMain EOF
            {
             before(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMain();

            state._fsp--;

             after(grammarAccess.getMainRule()); 
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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // InternalImportUriUiTestLanguage.g:62:1: ruleMain : ( ( rule__Main__Group__0 ) ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:66:2: ( ( ( rule__Main__Group__0 ) ) )
            // InternalImportUriUiTestLanguage.g:67:2: ( ( rule__Main__Group__0 ) )
            {
            // InternalImportUriUiTestLanguage.g:67:2: ( ( rule__Main__Group__0 ) )
            // InternalImportUriUiTestLanguage.g:68:3: ( rule__Main__Group__0 )
            {
             before(grammarAccess.getMainAccess().getGroup()); 
            // InternalImportUriUiTestLanguage.g:69:3: ( rule__Main__Group__0 )
            // InternalImportUriUiTestLanguage.g:69:4: rule__Main__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Main__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMainAccess().getGroup()); 

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
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleImport"
    // InternalImportUriUiTestLanguage.g:78:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalImportUriUiTestLanguage.g:79:1: ( ruleImport EOF )
            // InternalImportUriUiTestLanguage.g:80:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalImportUriUiTestLanguage.g:87:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:91:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalImportUriUiTestLanguage.g:92:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalImportUriUiTestLanguage.g:92:2: ( ( rule__Import__Group__0 ) )
            // InternalImportUriUiTestLanguage.g:93:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalImportUriUiTestLanguage.g:94:3: ( rule__Import__Group__0 )
            // InternalImportUriUiTestLanguage.g:94:4: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleType"
    // InternalImportUriUiTestLanguage.g:103:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalImportUriUiTestLanguage.g:104:1: ( ruleType EOF )
            // InternalImportUriUiTestLanguage.g:105:1: ruleType EOF
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
    // InternalImportUriUiTestLanguage.g:112:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:116:2: ( ( ( rule__Type__Group__0 ) ) )
            // InternalImportUriUiTestLanguage.g:117:2: ( ( rule__Type__Group__0 ) )
            {
            // InternalImportUriUiTestLanguage.g:117:2: ( ( rule__Type__Group__0 ) )
            // InternalImportUriUiTestLanguage.g:118:3: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // InternalImportUriUiTestLanguage.g:119:3: ( rule__Type__Group__0 )
            // InternalImportUriUiTestLanguage.g:119:4: rule__Type__Group__0
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


    // $ANTLR start "rule__Main__Group__0"
    // InternalImportUriUiTestLanguage.g:127:1: rule__Main__Group__0 : rule__Main__Group__0__Impl rule__Main__Group__1 ;
    public final void rule__Main__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:131:1: ( rule__Main__Group__0__Impl rule__Main__Group__1 )
            // InternalImportUriUiTestLanguage.g:132:2: rule__Main__Group__0__Impl rule__Main__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Main__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Main__Group__1();

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
    // $ANTLR end "rule__Main__Group__0"


    // $ANTLR start "rule__Main__Group__0__Impl"
    // InternalImportUriUiTestLanguage.g:139:1: rule__Main__Group__0__Impl : ( ( rule__Main__ImportsAssignment_0 )* ) ;
    public final void rule__Main__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:143:1: ( ( ( rule__Main__ImportsAssignment_0 )* ) )
            // InternalImportUriUiTestLanguage.g:144:1: ( ( rule__Main__ImportsAssignment_0 )* )
            {
            // InternalImportUriUiTestLanguage.g:144:1: ( ( rule__Main__ImportsAssignment_0 )* )
            // InternalImportUriUiTestLanguage.g:145:2: ( rule__Main__ImportsAssignment_0 )*
            {
             before(grammarAccess.getMainAccess().getImportsAssignment_0()); 
            // InternalImportUriUiTestLanguage.g:146:2: ( rule__Main__ImportsAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalImportUriUiTestLanguage.g:146:3: rule__Main__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Main__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getImportsAssignment_0()); 

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
    // $ANTLR end "rule__Main__Group__0__Impl"


    // $ANTLR start "rule__Main__Group__1"
    // InternalImportUriUiTestLanguage.g:154:1: rule__Main__Group__1 : rule__Main__Group__1__Impl ;
    public final void rule__Main__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:158:1: ( rule__Main__Group__1__Impl )
            // InternalImportUriUiTestLanguage.g:159:2: rule__Main__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Main__Group__1__Impl();

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
    // $ANTLR end "rule__Main__Group__1"


    // $ANTLR start "rule__Main__Group__1__Impl"
    // InternalImportUriUiTestLanguage.g:165:1: rule__Main__Group__1__Impl : ( ( rule__Main__TypesAssignment_1 )* ) ;
    public final void rule__Main__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:169:1: ( ( ( rule__Main__TypesAssignment_1 )* ) )
            // InternalImportUriUiTestLanguage.g:170:1: ( ( rule__Main__TypesAssignment_1 )* )
            {
            // InternalImportUriUiTestLanguage.g:170:1: ( ( rule__Main__TypesAssignment_1 )* )
            // InternalImportUriUiTestLanguage.g:171:2: ( rule__Main__TypesAssignment_1 )*
            {
             before(grammarAccess.getMainAccess().getTypesAssignment_1()); 
            // InternalImportUriUiTestLanguage.g:172:2: ( rule__Main__TypesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalImportUriUiTestLanguage.g:172:3: rule__Main__TypesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Main__TypesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getTypesAssignment_1()); 

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
    // $ANTLR end "rule__Main__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalImportUriUiTestLanguage.g:181:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:185:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalImportUriUiTestLanguage.g:186:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__Group__1();

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
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalImportUriUiTestLanguage.g:193:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:197:1: ( ( 'import' ) )
            // InternalImportUriUiTestLanguage.g:198:1: ( 'import' )
            {
            // InternalImportUriUiTestLanguage.g:198:1: ( 'import' )
            // InternalImportUriUiTestLanguage.g:199:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

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
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalImportUriUiTestLanguage.g:208:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:212:1: ( rule__Import__Group__1__Impl )
            // InternalImportUriUiTestLanguage.g:213:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__Group__1__Impl();

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
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalImportUriUiTestLanguage.g:219:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:223:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // InternalImportUriUiTestLanguage.g:224:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // InternalImportUriUiTestLanguage.g:224:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // InternalImportUriUiTestLanguage.g:225:2: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // InternalImportUriUiTestLanguage.g:226:2: ( rule__Import__ImportURIAssignment_1 )
            // InternalImportUriUiTestLanguage.g:226:3: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Import__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

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
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Type__Group__0"
    // InternalImportUriUiTestLanguage.g:235:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:239:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // InternalImportUriUiTestLanguage.g:240:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
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
    // InternalImportUriUiTestLanguage.g:247:1: rule__Type__Group__0__Impl : ( 'type' ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:251:1: ( ( 'type' ) )
            // InternalImportUriUiTestLanguage.g:252:1: ( 'type' )
            {
            // InternalImportUriUiTestLanguage.g:252:1: ( 'type' )
            // InternalImportUriUiTestLanguage.g:253:2: 'type'
            {
             before(grammarAccess.getTypeAccess().getTypeKeyword_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getTypeKeyword_0()); 

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
    // InternalImportUriUiTestLanguage.g:262:1: rule__Type__Group__1 : rule__Type__Group__1__Impl rule__Type__Group__2 ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:266:1: ( rule__Type__Group__1__Impl rule__Type__Group__2 )
            // InternalImportUriUiTestLanguage.g:267:2: rule__Type__Group__1__Impl rule__Type__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
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
    // InternalImportUriUiTestLanguage.g:274:1: rule__Type__Group__1__Impl : ( ( rule__Type__NameAssignment_1 ) ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:278:1: ( ( ( rule__Type__NameAssignment_1 ) ) )
            // InternalImportUriUiTestLanguage.g:279:1: ( ( rule__Type__NameAssignment_1 ) )
            {
            // InternalImportUriUiTestLanguage.g:279:1: ( ( rule__Type__NameAssignment_1 ) )
            // InternalImportUriUiTestLanguage.g:280:2: ( rule__Type__NameAssignment_1 )
            {
             before(grammarAccess.getTypeAccess().getNameAssignment_1()); 
            // InternalImportUriUiTestLanguage.g:281:2: ( rule__Type__NameAssignment_1 )
            // InternalImportUriUiTestLanguage.g:281:3: rule__Type__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getNameAssignment_1()); 

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
    // InternalImportUriUiTestLanguage.g:289:1: rule__Type__Group__2 : rule__Type__Group__2__Impl rule__Type__Group__3 ;
    public final void rule__Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:293:1: ( rule__Type__Group__2__Impl rule__Type__Group__3 )
            // InternalImportUriUiTestLanguage.g:294:2: rule__Type__Group__2__Impl rule__Type__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Type__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__3();

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
    // InternalImportUriUiTestLanguage.g:301:1: rule__Type__Group__2__Impl : ( 'extends' ) ;
    public final void rule__Type__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:305:1: ( ( 'extends' ) )
            // InternalImportUriUiTestLanguage.g:306:1: ( 'extends' )
            {
            // InternalImportUriUiTestLanguage.g:306:1: ( 'extends' )
            // InternalImportUriUiTestLanguage.g:307:2: 'extends'
            {
             before(grammarAccess.getTypeAccess().getExtendsKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getExtendsKeyword_2()); 

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


    // $ANTLR start "rule__Type__Group__3"
    // InternalImportUriUiTestLanguage.g:316:1: rule__Type__Group__3 : rule__Type__Group__3__Impl ;
    public final void rule__Type__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:320:1: ( rule__Type__Group__3__Impl )
            // InternalImportUriUiTestLanguage.g:321:2: rule__Type__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__Group__3__Impl();

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
    // $ANTLR end "rule__Type__Group__3"


    // $ANTLR start "rule__Type__Group__3__Impl"
    // InternalImportUriUiTestLanguage.g:327:1: rule__Type__Group__3__Impl : ( ( rule__Type__ExtendsAssignment_3 ) ) ;
    public final void rule__Type__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:331:1: ( ( ( rule__Type__ExtendsAssignment_3 ) ) )
            // InternalImportUriUiTestLanguage.g:332:1: ( ( rule__Type__ExtendsAssignment_3 ) )
            {
            // InternalImportUriUiTestLanguage.g:332:1: ( ( rule__Type__ExtendsAssignment_3 ) )
            // InternalImportUriUiTestLanguage.g:333:2: ( rule__Type__ExtendsAssignment_3 )
            {
             before(grammarAccess.getTypeAccess().getExtendsAssignment_3()); 
            // InternalImportUriUiTestLanguage.g:334:2: ( rule__Type__ExtendsAssignment_3 )
            // InternalImportUriUiTestLanguage.g:334:3: rule__Type__ExtendsAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Type__ExtendsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getExtendsAssignment_3()); 

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
    // $ANTLR end "rule__Type__Group__3__Impl"


    // $ANTLR start "rule__Main__ImportsAssignment_0"
    // InternalImportUriUiTestLanguage.g:343:1: rule__Main__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Main__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:347:1: ( ( ruleImport ) )
            // InternalImportUriUiTestLanguage.g:348:2: ( ruleImport )
            {
            // InternalImportUriUiTestLanguage.g:348:2: ( ruleImport )
            // InternalImportUriUiTestLanguage.g:349:3: ruleImport
            {
             before(grammarAccess.getMainAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getMainAccess().getImportsImportParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Main__ImportsAssignment_0"


    // $ANTLR start "rule__Main__TypesAssignment_1"
    // InternalImportUriUiTestLanguage.g:358:1: rule__Main__TypesAssignment_1 : ( ruleType ) ;
    public final void rule__Main__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:362:1: ( ( ruleType ) )
            // InternalImportUriUiTestLanguage.g:363:2: ( ruleType )
            {
            // InternalImportUriUiTestLanguage.g:363:2: ( ruleType )
            // InternalImportUriUiTestLanguage.g:364:3: ruleType
            {
             before(grammarAccess.getMainAccess().getTypesTypeParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getMainAccess().getTypesTypeParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Main__TypesAssignment_1"


    // $ANTLR start "rule__Import__ImportURIAssignment_1"
    // InternalImportUriUiTestLanguage.g:373:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:377:1: ( ( RULE_STRING ) )
            // InternalImportUriUiTestLanguage.g:378:2: ( RULE_STRING )
            {
            // InternalImportUriUiTestLanguage.g:378:2: ( RULE_STRING )
            // InternalImportUriUiTestLanguage.g:379:3: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Import__ImportURIAssignment_1"


    // $ANTLR start "rule__Type__NameAssignment_1"
    // InternalImportUriUiTestLanguage.g:388:1: rule__Type__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Type__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:392:1: ( ( RULE_ID ) )
            // InternalImportUriUiTestLanguage.g:393:2: ( RULE_ID )
            {
            // InternalImportUriUiTestLanguage.g:393:2: ( RULE_ID )
            // InternalImportUriUiTestLanguage.g:394:3: RULE_ID
            {
             before(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Type__NameAssignment_1"


    // $ANTLR start "rule__Type__ExtendsAssignment_3"
    // InternalImportUriUiTestLanguage.g:403:1: rule__Type__ExtendsAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Type__ExtendsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalImportUriUiTestLanguage.g:407:1: ( ( ( RULE_ID ) ) )
            // InternalImportUriUiTestLanguage.g:408:2: ( ( RULE_ID ) )
            {
            // InternalImportUriUiTestLanguage.g:408:2: ( ( RULE_ID ) )
            // InternalImportUriUiTestLanguage.g:409:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0()); 
            // InternalImportUriUiTestLanguage.g:410:3: ( RULE_ID )
            // InternalImportUriUiTestLanguage.g:411:4: RULE_ID
            {
             before(grammarAccess.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0()); 

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
    // $ANTLR end "rule__Type__ExtendsAssignment_3"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
    }


}
package org.eclipse.xtext.ui.tests.quickfix.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.quickfix.services.QuickfixCrossrefTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQuickfixCrossrefTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'ref'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalQuickfixCrossrefTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQuickfixCrossrefTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQuickfixCrossrefTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g"; }


     
     	private QuickfixCrossrefTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(QuickfixCrossrefTestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:60:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:61:1: ( ruleMain EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:62:1: ruleMain EOF
            {
             before(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMain_in_entryRuleMain61);
            ruleMain();

            state._fsp--;

             after(grammarAccess.getMainRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMain68); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:69:1: ruleMain : ( ( rule__Main__ElementsAssignment )* ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:73:2: ( ( ( rule__Main__ElementsAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:74:1: ( ( rule__Main__ElementsAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:74:1: ( ( rule__Main__ElementsAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:75:1: ( rule__Main__ElementsAssignment )*
            {
             before(grammarAccess.getMainAccess().getElementsAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:76:1: ( rule__Main__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:76:2: rule__Main__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Main__ElementsAssignment_in_ruleMain94);
            	    rule__Main__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getElementsAssignment()); 

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


    // $ANTLR start "entryRuleElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:88:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:89:1: ( ruleElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:90:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement122);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement129); 

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:97:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:101:2: ( ( ( rule__Element__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:102:1: ( ( rule__Element__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:102:1: ( ( rule__Element__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:103:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:104:1: ( rule__Element__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:104:2: rule__Element__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0_in_ruleElement155);
            rule__Element__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getGroup()); 

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
    // $ANTLR end "ruleElement"


    // $ANTLR start "rule__Element__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:118:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:122:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:123:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__0189);
            rule__Element__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0192);
            rule__Element__Group__1();

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
    // $ANTLR end "rule__Element__Group__0"


    // $ANTLR start "rule__Element__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:130:1: rule__Element__Group__0__Impl : ( ( rule__Element__NameAssignment_0 ) ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:134:1: ( ( ( rule__Element__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:135:1: ( ( rule__Element__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:135:1: ( ( rule__Element__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:136:1: ( rule__Element__NameAssignment_0 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:137:1: ( rule__Element__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:137:2: rule__Element__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__NameAssignment_0_in_rule__Element__Group__0__Impl219);
            rule__Element__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getNameAssignment_0()); 

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
    // $ANTLR end "rule__Element__Group__0__Impl"


    // $ANTLR start "rule__Element__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:147:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:151:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:152:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1249);
            rule__Element__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1252);
            rule__Element__Group__2();

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
    // $ANTLR end "rule__Element__Group__1"


    // $ANTLR start "rule__Element__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:159:1: rule__Element__Group__1__Impl : ( '{' ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:163:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:164:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:164:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:165:1: '{'
            {
             before(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Element__Group__1__Impl280); 
             after(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__Element__Group__1__Impl"


    // $ANTLR start "rule__Element__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:178:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:182:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:183:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__2311);
            rule__Element__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2314);
            rule__Element__Group__3();

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
    // $ANTLR end "rule__Element__Group__2"


    // $ANTLR start "rule__Element__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:190:1: rule__Element__Group__2__Impl : ( ( rule__Element__ContainedAssignment_2 )* ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:194:1: ( ( ( rule__Element__ContainedAssignment_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:195:1: ( ( rule__Element__ContainedAssignment_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:195:1: ( ( rule__Element__ContainedAssignment_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:196:1: ( rule__Element__ContainedAssignment_2 )*
            {
             before(grammarAccess.getElementAccess().getContainedAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:197:1: ( rule__Element__ContainedAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:197:2: rule__Element__ContainedAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__ContainedAssignment_2_in_rule__Element__Group__2__Impl341);
            	    rule__Element__ContainedAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getContainedAssignment_2()); 

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
    // $ANTLR end "rule__Element__Group__2__Impl"


    // $ANTLR start "rule__Element__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:207:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:211:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:212:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3__Impl_in_rule__Element__Group__3372);
            rule__Element__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__4_in_rule__Element__Group__3375);
            rule__Element__Group__4();

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
    // $ANTLR end "rule__Element__Group__3"


    // $ANTLR start "rule__Element__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:219:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )* ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:223:1: ( ( ( rule__Element__Group_3__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:224:1: ( ( rule__Element__Group_3__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:224:1: ( ( rule__Element__Group_3__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:225:1: ( rule__Element__Group_3__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:226:1: ( rule__Element__Group_3__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:226:2: rule__Element__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3__Impl402);
            	    rule__Element__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Element__Group__3__Impl"


    // $ANTLR start "rule__Element__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:236:1: rule__Element__Group__4 : rule__Element__Group__4__Impl ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:240:1: ( rule__Element__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:241:2: rule__Element__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__4__Impl_in_rule__Element__Group__4433);
            rule__Element__Group__4__Impl();

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
    // $ANTLR end "rule__Element__Group__4"


    // $ANTLR start "rule__Element__Group__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:247:1: rule__Element__Group__4__Impl : ( '}' ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:251:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:252:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:252:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:253:1: '}'
            {
             before(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_4()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Element__Group__4__Impl461); 
             after(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__Element__Group__4__Impl"


    // $ANTLR start "rule__Element__Group_3__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:276:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:280:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:281:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0__Impl_in_rule__Element__Group_3__0502);
            rule__Element__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__0505);
            rule__Element__Group_3__1();

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
    // $ANTLR end "rule__Element__Group_3__0"


    // $ANTLR start "rule__Element__Group_3__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:288:1: rule__Element__Group_3__0__Impl : ( 'ref' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:292:1: ( ( 'ref' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:293:1: ( 'ref' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:293:1: ( 'ref' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:294:1: 'ref'
            {
             before(grammarAccess.getElementAccess().getRefKeyword_3_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Element__Group_3__0__Impl533); 
             after(grammarAccess.getElementAccess().getRefKeyword_3_0()); 

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
    // $ANTLR end "rule__Element__Group_3__0__Impl"


    // $ANTLR start "rule__Element__Group_3__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:307:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:311:1: ( rule__Element__Group_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:312:2: rule__Element__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1__Impl_in_rule__Element__Group_3__1564);
            rule__Element__Group_3__1__Impl();

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
    // $ANTLR end "rule__Element__Group_3__1"


    // $ANTLR start "rule__Element__Group_3__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:318:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__ReferencedAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:322:1: ( ( ( rule__Element__ReferencedAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:323:1: ( ( rule__Element__ReferencedAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:323:1: ( ( rule__Element__ReferencedAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:324:1: ( rule__Element__ReferencedAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getReferencedAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:325:1: ( rule__Element__ReferencedAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:325:2: rule__Element__ReferencedAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__ReferencedAssignment_3_1_in_rule__Element__Group_3__1__Impl591);
            rule__Element__ReferencedAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getReferencedAssignment_3_1()); 

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
    // $ANTLR end "rule__Element__Group_3__1__Impl"


    // $ANTLR start "rule__Main__ElementsAssignment"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:340:1: rule__Main__ElementsAssignment : ( ruleElement ) ;
    public final void rule__Main__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:344:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:345:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:345:1: ( ruleElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:346:1: ruleElement
            {
             before(grammarAccess.getMainAccess().getElementsElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__Main__ElementsAssignment630);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getMainAccess().getElementsElementParserRuleCall_0()); 

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
    // $ANTLR end "rule__Main__ElementsAssignment"


    // $ANTLR start "rule__Element__NameAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:355:1: rule__Element__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:359:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:360:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:360:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:361:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__NameAssignment_0661); 
             after(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__Element__NameAssignment_0"


    // $ANTLR start "rule__Element__ContainedAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:370:1: rule__Element__ContainedAssignment_2 : ( ruleElement ) ;
    public final void rule__Element__ContainedAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:374:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:375:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:375:1: ( ruleElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:376:1: ruleElement
            {
             before(grammarAccess.getElementAccess().getContainedElementParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__Element__ContainedAssignment_2692);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementAccess().getContainedElementParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Element__ContainedAssignment_2"


    // $ANTLR start "rule__Element__ReferencedAssignment_3_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:385:1: rule__Element__ReferencedAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__ReferencedAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:389:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:390:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:390:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:391:1: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getReferencedElementCrossReference_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:392:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:393:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getReferencedElementIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__ReferencedAssignment_3_1727); 
             after(grammarAccess.getElementAccess().getReferencedElementIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getReferencedElementCrossReference_3_1_0()); 

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
    // $ANTLR end "rule__Element__ReferencedAssignment_3_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMain_in_entryRuleMain61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMain68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Main__ElementsAssignment_in_ruleMain94 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0_in_ruleElement155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__0189 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__NameAssignment_0_in_rule__Element__Group__0__Impl219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1249 = new BitSet(new long[]{0x0000000000003010L});
        public static final BitSet FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Element__Group__1__Impl280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__2311 = new BitSet(new long[]{0x0000000000003010L});
        public static final BitSet FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__ContainedAssignment_2_in_rule__Element__Group__2__Impl341 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Element__Group__3__Impl_in_rule__Element__Group__3372 = new BitSet(new long[]{0x0000000000003010L});
        public static final BitSet FOLLOW_rule__Element__Group__4_in_rule__Element__Group__3375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3__Impl402 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__Element__Group__4__Impl_in_rule__Element__Group__4433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Element__Group__4__Impl461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__0__Impl_in_rule__Element__Group_3__0502 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__0505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Element__Group_3__0__Impl533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__1__Impl_in_rule__Element__Group_3__1564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__ReferencedAssignment_3_1_in_rule__Element__Group_3__1__Impl591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__Main__ElementsAssignment630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__NameAssignment_0661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__Element__ContainedAssignment_2692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__ReferencedAssignment_3_1727 = new BitSet(new long[]{0x0000000000000002L});
    }


}
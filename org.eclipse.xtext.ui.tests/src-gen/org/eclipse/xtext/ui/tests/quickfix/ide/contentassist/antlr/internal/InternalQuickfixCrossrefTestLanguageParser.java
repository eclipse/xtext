package org.eclipse.xtext.ui.tests.quickfix.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.quickfix.services.QuickfixCrossrefTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalQuickfixCrossrefTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'ref'"
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


        public InternalQuickfixCrossrefTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQuickfixCrossrefTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQuickfixCrossrefTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalQuickfixCrossrefTestLanguage.g"; }


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
    // InternalQuickfixCrossrefTestLanguage.g:58:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // InternalQuickfixCrossrefTestLanguage.g:59:1: ( ruleMain EOF )
            // InternalQuickfixCrossrefTestLanguage.g:60:1: ruleMain EOF
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
    // InternalQuickfixCrossrefTestLanguage.g:67:1: ruleMain : ( ( rule__Main__ElementsAssignment )* ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:71:2: ( ( ( rule__Main__ElementsAssignment )* ) )
            // InternalQuickfixCrossrefTestLanguage.g:72:2: ( ( rule__Main__ElementsAssignment )* )
            {
            // InternalQuickfixCrossrefTestLanguage.g:72:2: ( ( rule__Main__ElementsAssignment )* )
            // InternalQuickfixCrossrefTestLanguage.g:73:3: ( rule__Main__ElementsAssignment )*
            {
             before(grammarAccess.getMainAccess().getElementsAssignment()); 
            // InternalQuickfixCrossrefTestLanguage.g:74:3: ( rule__Main__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalQuickfixCrossrefTestLanguage.g:74:4: rule__Main__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
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
    // InternalQuickfixCrossrefTestLanguage.g:83:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalQuickfixCrossrefTestLanguage.g:84:1: ( ruleElement EOF )
            // InternalQuickfixCrossrefTestLanguage.g:85:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalQuickfixCrossrefTestLanguage.g:92:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:96:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalQuickfixCrossrefTestLanguage.g:97:2: ( ( rule__Element__Group__0 ) )
            {
            // InternalQuickfixCrossrefTestLanguage.g:97:2: ( ( rule__Element__Group__0 ) )
            // InternalQuickfixCrossrefTestLanguage.g:98:3: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalQuickfixCrossrefTestLanguage.g:99:3: ( rule__Element__Group__0 )
            // InternalQuickfixCrossrefTestLanguage.g:99:4: rule__Element__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalQuickfixCrossrefTestLanguage.g:107:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:111:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalQuickfixCrossrefTestLanguage.g:112:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Element__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalQuickfixCrossrefTestLanguage.g:119:1: rule__Element__Group__0__Impl : ( ( rule__Element__DocAssignment_0 )? ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:123:1: ( ( ( rule__Element__DocAssignment_0 )? ) )
            // InternalQuickfixCrossrefTestLanguage.g:124:1: ( ( rule__Element__DocAssignment_0 )? )
            {
            // InternalQuickfixCrossrefTestLanguage.g:124:1: ( ( rule__Element__DocAssignment_0 )? )
            // InternalQuickfixCrossrefTestLanguage.g:125:2: ( rule__Element__DocAssignment_0 )?
            {
             before(grammarAccess.getElementAccess().getDocAssignment_0()); 
            // InternalQuickfixCrossrefTestLanguage.g:126:2: ( rule__Element__DocAssignment_0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalQuickfixCrossrefTestLanguage.g:126:3: rule__Element__DocAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Element__DocAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getDocAssignment_0()); 

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
    // InternalQuickfixCrossrefTestLanguage.g:134:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:138:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalQuickfixCrossrefTestLanguage.g:139:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Element__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalQuickfixCrossrefTestLanguage.g:146:1: rule__Element__Group__1__Impl : ( ( rule__Element__NameAssignment_1 ) ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:150:1: ( ( ( rule__Element__NameAssignment_1 ) ) )
            // InternalQuickfixCrossrefTestLanguage.g:151:1: ( ( rule__Element__NameAssignment_1 ) )
            {
            // InternalQuickfixCrossrefTestLanguage.g:151:1: ( ( rule__Element__NameAssignment_1 ) )
            // InternalQuickfixCrossrefTestLanguage.g:152:2: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // InternalQuickfixCrossrefTestLanguage.g:153:2: ( rule__Element__NameAssignment_1 )
            // InternalQuickfixCrossrefTestLanguage.g:153:3: rule__Element__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getNameAssignment_1()); 

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
    // InternalQuickfixCrossrefTestLanguage.g:161:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:165:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalQuickfixCrossrefTestLanguage.g:166:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Element__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalQuickfixCrossrefTestLanguage.g:173:1: rule__Element__Group__2__Impl : ( '{' ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:177:1: ( ( '{' ) )
            // InternalQuickfixCrossrefTestLanguage.g:178:1: ( '{' )
            {
            // InternalQuickfixCrossrefTestLanguage.g:178:1: ( '{' )
            // InternalQuickfixCrossrefTestLanguage.g:179:2: '{'
            {
             before(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_2()); 

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
    // InternalQuickfixCrossrefTestLanguage.g:188:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:192:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalQuickfixCrossrefTestLanguage.g:193:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Element__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalQuickfixCrossrefTestLanguage.g:200:1: rule__Element__Group__3__Impl : ( ( rule__Element__ContainedAssignment_3 )* ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:204:1: ( ( ( rule__Element__ContainedAssignment_3 )* ) )
            // InternalQuickfixCrossrefTestLanguage.g:205:1: ( ( rule__Element__ContainedAssignment_3 )* )
            {
            // InternalQuickfixCrossrefTestLanguage.g:205:1: ( ( rule__Element__ContainedAssignment_3 )* )
            // InternalQuickfixCrossrefTestLanguage.g:206:2: ( rule__Element__ContainedAssignment_3 )*
            {
             before(grammarAccess.getElementAccess().getContainedAssignment_3()); 
            // InternalQuickfixCrossrefTestLanguage.g:207:2: ( rule__Element__ContainedAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalQuickfixCrossrefTestLanguage.g:207:3: rule__Element__ContainedAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Element__ContainedAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getContainedAssignment_3()); 

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
    // InternalQuickfixCrossrefTestLanguage.g:215:1: rule__Element__Group__4 : rule__Element__Group__4__Impl rule__Element__Group__5 ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:219:1: ( rule__Element__Group__4__Impl rule__Element__Group__5 )
            // InternalQuickfixCrossrefTestLanguage.g:220:2: rule__Element__Group__4__Impl rule__Element__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Element__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group__5();

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
    // InternalQuickfixCrossrefTestLanguage.g:227:1: rule__Element__Group__4__Impl : ( ( rule__Element__Group_4__0 )* ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:231:1: ( ( ( rule__Element__Group_4__0 )* ) )
            // InternalQuickfixCrossrefTestLanguage.g:232:1: ( ( rule__Element__Group_4__0 )* )
            {
            // InternalQuickfixCrossrefTestLanguage.g:232:1: ( ( rule__Element__Group_4__0 )* )
            // InternalQuickfixCrossrefTestLanguage.g:233:2: ( rule__Element__Group_4__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_4()); 
            // InternalQuickfixCrossrefTestLanguage.g:234:2: ( rule__Element__Group_4__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalQuickfixCrossrefTestLanguage.g:234:3: rule__Element__Group_4__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Element__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getGroup_4()); 

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


    // $ANTLR start "rule__Element__Group__5"
    // InternalQuickfixCrossrefTestLanguage.g:242:1: rule__Element__Group__5 : rule__Element__Group__5__Impl ;
    public final void rule__Element__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:246:1: ( rule__Element__Group__5__Impl )
            // InternalQuickfixCrossrefTestLanguage.g:247:2: rule__Element__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group__5__Impl();

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
    // $ANTLR end "rule__Element__Group__5"


    // $ANTLR start "rule__Element__Group__5__Impl"
    // InternalQuickfixCrossrefTestLanguage.g:253:1: rule__Element__Group__5__Impl : ( '}' ) ;
    public final void rule__Element__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:257:1: ( ( '}' ) )
            // InternalQuickfixCrossrefTestLanguage.g:258:1: ( '}' )
            {
            // InternalQuickfixCrossrefTestLanguage.g:258:1: ( '}' )
            // InternalQuickfixCrossrefTestLanguage.g:259:2: '}'
            {
             before(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_5()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_5()); 

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
    // $ANTLR end "rule__Element__Group__5__Impl"


    // $ANTLR start "rule__Element__Group_4__0"
    // InternalQuickfixCrossrefTestLanguage.g:269:1: rule__Element__Group_4__0 : rule__Element__Group_4__0__Impl rule__Element__Group_4__1 ;
    public final void rule__Element__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:273:1: ( rule__Element__Group_4__0__Impl rule__Element__Group_4__1 )
            // InternalQuickfixCrossrefTestLanguage.g:274:2: rule__Element__Group_4__0__Impl rule__Element__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Element__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_4__1();

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
    // $ANTLR end "rule__Element__Group_4__0"


    // $ANTLR start "rule__Element__Group_4__0__Impl"
    // InternalQuickfixCrossrefTestLanguage.g:281:1: rule__Element__Group_4__0__Impl : ( 'ref' ) ;
    public final void rule__Element__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:285:1: ( ( 'ref' ) )
            // InternalQuickfixCrossrefTestLanguage.g:286:1: ( 'ref' )
            {
            // InternalQuickfixCrossrefTestLanguage.g:286:1: ( 'ref' )
            // InternalQuickfixCrossrefTestLanguage.g:287:2: 'ref'
            {
             before(grammarAccess.getElementAccess().getRefKeyword_4_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRefKeyword_4_0()); 

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
    // $ANTLR end "rule__Element__Group_4__0__Impl"


    // $ANTLR start "rule__Element__Group_4__1"
    // InternalQuickfixCrossrefTestLanguage.g:296:1: rule__Element__Group_4__1 : rule__Element__Group_4__1__Impl ;
    public final void rule__Element__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:300:1: ( rule__Element__Group_4__1__Impl )
            // InternalQuickfixCrossrefTestLanguage.g:301:2: rule__Element__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_4__1__Impl();

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
    // $ANTLR end "rule__Element__Group_4__1"


    // $ANTLR start "rule__Element__Group_4__1__Impl"
    // InternalQuickfixCrossrefTestLanguage.g:307:1: rule__Element__Group_4__1__Impl : ( ( rule__Element__ReferencedAssignment_4_1 ) ) ;
    public final void rule__Element__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:311:1: ( ( ( rule__Element__ReferencedAssignment_4_1 ) ) )
            // InternalQuickfixCrossrefTestLanguage.g:312:1: ( ( rule__Element__ReferencedAssignment_4_1 ) )
            {
            // InternalQuickfixCrossrefTestLanguage.g:312:1: ( ( rule__Element__ReferencedAssignment_4_1 ) )
            // InternalQuickfixCrossrefTestLanguage.g:313:2: ( rule__Element__ReferencedAssignment_4_1 )
            {
             before(grammarAccess.getElementAccess().getReferencedAssignment_4_1()); 
            // InternalQuickfixCrossrefTestLanguage.g:314:2: ( rule__Element__ReferencedAssignment_4_1 )
            // InternalQuickfixCrossrefTestLanguage.g:314:3: rule__Element__ReferencedAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__ReferencedAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getReferencedAssignment_4_1()); 

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
    // $ANTLR end "rule__Element__Group_4__1__Impl"


    // $ANTLR start "rule__Main__ElementsAssignment"
    // InternalQuickfixCrossrefTestLanguage.g:323:1: rule__Main__ElementsAssignment : ( ruleElement ) ;
    public final void rule__Main__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:327:1: ( ( ruleElement ) )
            // InternalQuickfixCrossrefTestLanguage.g:328:2: ( ruleElement )
            {
            // InternalQuickfixCrossrefTestLanguage.g:328:2: ( ruleElement )
            // InternalQuickfixCrossrefTestLanguage.g:329:3: ruleElement
            {
             before(grammarAccess.getMainAccess().getElementsElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "rule__Element__DocAssignment_0"
    // InternalQuickfixCrossrefTestLanguage.g:338:1: rule__Element__DocAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Element__DocAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:342:1: ( ( RULE_STRING ) )
            // InternalQuickfixCrossrefTestLanguage.g:343:2: ( RULE_STRING )
            {
            // InternalQuickfixCrossrefTestLanguage.g:343:2: ( RULE_STRING )
            // InternalQuickfixCrossrefTestLanguage.g:344:3: RULE_STRING
            {
             before(grammarAccess.getElementAccess().getDocSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getDocSTRINGTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__Element__DocAssignment_0"


    // $ANTLR start "rule__Element__NameAssignment_1"
    // InternalQuickfixCrossrefTestLanguage.g:353:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:357:1: ( ( RULE_ID ) )
            // InternalQuickfixCrossrefTestLanguage.g:358:2: ( RULE_ID )
            {
            // InternalQuickfixCrossrefTestLanguage.g:358:2: ( RULE_ID )
            // InternalQuickfixCrossrefTestLanguage.g:359:3: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Element__NameAssignment_1"


    // $ANTLR start "rule__Element__ContainedAssignment_3"
    // InternalQuickfixCrossrefTestLanguage.g:368:1: rule__Element__ContainedAssignment_3 : ( ruleElement ) ;
    public final void rule__Element__ContainedAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:372:1: ( ( ruleElement ) )
            // InternalQuickfixCrossrefTestLanguage.g:373:2: ( ruleElement )
            {
            // InternalQuickfixCrossrefTestLanguage.g:373:2: ( ruleElement )
            // InternalQuickfixCrossrefTestLanguage.g:374:3: ruleElement
            {
             before(grammarAccess.getElementAccess().getContainedElementParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementAccess().getContainedElementParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Element__ContainedAssignment_3"


    // $ANTLR start "rule__Element__ReferencedAssignment_4_1"
    // InternalQuickfixCrossrefTestLanguage.g:383:1: rule__Element__ReferencedAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__ReferencedAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuickfixCrossrefTestLanguage.g:387:1: ( ( ( RULE_ID ) ) )
            // InternalQuickfixCrossrefTestLanguage.g:388:2: ( ( RULE_ID ) )
            {
            // InternalQuickfixCrossrefTestLanguage.g:388:2: ( ( RULE_ID ) )
            // InternalQuickfixCrossrefTestLanguage.g:389:3: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getReferencedElementCrossReference_4_1_0()); 
            // InternalQuickfixCrossrefTestLanguage.g:390:3: ( RULE_ID )
            // InternalQuickfixCrossrefTestLanguage.g:391:4: RULE_ID
            {
             before(grammarAccess.getElementAccess().getReferencedElementIDTerminalRuleCall_4_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getReferencedElementIDTerminalRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getReferencedElementCrossReference_4_1_0()); 

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
    // $ANTLR end "rule__Element__ReferencedAssignment_4_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000003030L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    }


}
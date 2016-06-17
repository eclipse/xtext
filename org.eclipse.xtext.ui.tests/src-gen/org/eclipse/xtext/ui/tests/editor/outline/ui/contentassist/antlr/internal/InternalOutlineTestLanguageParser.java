package org.eclipse.xtext.ui.tests.editor.outline.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.outline.services.OutlineTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOutlineTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'('", "')'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalOutlineTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOutlineTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOutlineTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOutlineTestLanguage.g"; }


     
     	private OutlineTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(OutlineTestLanguageGrammarAccess grammarAccess) {
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
    // InternalOutlineTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalOutlineTestLanguage.g:61:1: ( ruleModel EOF )
            // InternalOutlineTestLanguage.g:62:1: ruleModel EOF
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
    // InternalOutlineTestLanguage.g:69:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:73:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalOutlineTestLanguage.g:74:1: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalOutlineTestLanguage.g:74:1: ( ( rule__Model__ElementsAssignment )* )
            // InternalOutlineTestLanguage.g:75:1: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalOutlineTestLanguage.g:76:1: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOutlineTestLanguage.g:76:2: rule__Model__ElementsAssignment
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


    // $ANTLR start "entryRuleElement"
    // InternalOutlineTestLanguage.g:88:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalOutlineTestLanguage.g:89:1: ( ruleElement EOF )
            // InternalOutlineTestLanguage.g:90:1: ruleElement EOF
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
    // InternalOutlineTestLanguage.g:97:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:101:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalOutlineTestLanguage.g:102:1: ( ( rule__Element__Group__0 ) )
            {
            // InternalOutlineTestLanguage.g:102:1: ( ( rule__Element__Group__0 ) )
            // InternalOutlineTestLanguage.g:103:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalOutlineTestLanguage.g:104:1: ( rule__Element__Group__0 )
            // InternalOutlineTestLanguage.g:104:2: rule__Element__Group__0
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
    // InternalOutlineTestLanguage.g:118:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:122:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalOutlineTestLanguage.g:123:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // InternalOutlineTestLanguage.g:130:1: rule__Element__Group__0__Impl : ( ( rule__Element__NameAssignment_0 ) ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:134:1: ( ( ( rule__Element__NameAssignment_0 ) ) )
            // InternalOutlineTestLanguage.g:135:1: ( ( rule__Element__NameAssignment_0 ) )
            {
            // InternalOutlineTestLanguage.g:135:1: ( ( rule__Element__NameAssignment_0 ) )
            // InternalOutlineTestLanguage.g:136:1: ( rule__Element__NameAssignment_0 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_0()); 
            // InternalOutlineTestLanguage.g:137:1: ( rule__Element__NameAssignment_0 )
            // InternalOutlineTestLanguage.g:137:2: rule__Element__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalOutlineTestLanguage.g:147:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:151:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalOutlineTestLanguage.g:152:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
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
    // InternalOutlineTestLanguage.g:159:1: rule__Element__Group__1__Impl : ( ( rule__Element__Group_1__0 )? ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:163:1: ( ( ( rule__Element__Group_1__0 )? ) )
            // InternalOutlineTestLanguage.g:164:1: ( ( rule__Element__Group_1__0 )? )
            {
            // InternalOutlineTestLanguage.g:164:1: ( ( rule__Element__Group_1__0 )? )
            // InternalOutlineTestLanguage.g:165:1: ( rule__Element__Group_1__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_1()); 
            // InternalOutlineTestLanguage.g:166:1: ( rule__Element__Group_1__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalOutlineTestLanguage.g:166:2: rule__Element__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Element__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_1()); 

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
    // InternalOutlineTestLanguage.g:176:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:180:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalOutlineTestLanguage.g:181:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
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
    // InternalOutlineTestLanguage.g:188:1: rule__Element__Group__2__Impl : ( '{' ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:192:1: ( ( '{' ) )
            // InternalOutlineTestLanguage.g:193:1: ( '{' )
            {
            // InternalOutlineTestLanguage.g:193:1: ( '{' )
            // InternalOutlineTestLanguage.g:194:1: '{'
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
    // InternalOutlineTestLanguage.g:207:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:211:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalOutlineTestLanguage.g:212:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_5);
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
    // InternalOutlineTestLanguage.g:219:1: rule__Element__Group__3__Impl : ( ( rule__Element__ChildrenAssignment_3 )* ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:223:1: ( ( ( rule__Element__ChildrenAssignment_3 )* ) )
            // InternalOutlineTestLanguage.g:224:1: ( ( rule__Element__ChildrenAssignment_3 )* )
            {
            // InternalOutlineTestLanguage.g:224:1: ( ( rule__Element__ChildrenAssignment_3 )* )
            // InternalOutlineTestLanguage.g:225:1: ( rule__Element__ChildrenAssignment_3 )*
            {
             before(grammarAccess.getElementAccess().getChildrenAssignment_3()); 
            // InternalOutlineTestLanguage.g:226:1: ( rule__Element__ChildrenAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalOutlineTestLanguage.g:226:2: rule__Element__ChildrenAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Element__ChildrenAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getChildrenAssignment_3()); 

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
    // InternalOutlineTestLanguage.g:236:1: rule__Element__Group__4 : rule__Element__Group__4__Impl ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:240:1: ( rule__Element__Group__4__Impl )
            // InternalOutlineTestLanguage.g:241:2: rule__Element__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalOutlineTestLanguage.g:247:1: rule__Element__Group__4__Impl : ( '}' ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:251:1: ( ( '}' ) )
            // InternalOutlineTestLanguage.g:252:1: ( '}' )
            {
            // InternalOutlineTestLanguage.g:252:1: ( '}' )
            // InternalOutlineTestLanguage.g:253:1: '}'
            {
             before(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_4()); 
            match(input,12,FollowSets000.FOLLOW_2); 
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


    // $ANTLR start "rule__Element__Group_1__0"
    // InternalOutlineTestLanguage.g:276:1: rule__Element__Group_1__0 : rule__Element__Group_1__0__Impl rule__Element__Group_1__1 ;
    public final void rule__Element__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:280:1: ( rule__Element__Group_1__0__Impl rule__Element__Group_1__1 )
            // InternalOutlineTestLanguage.g:281:2: rule__Element__Group_1__0__Impl rule__Element__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Element__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1__1();

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
    // $ANTLR end "rule__Element__Group_1__0"


    // $ANTLR start "rule__Element__Group_1__0__Impl"
    // InternalOutlineTestLanguage.g:288:1: rule__Element__Group_1__0__Impl : ( '(' ) ;
    public final void rule__Element__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:292:1: ( ( '(' ) )
            // InternalOutlineTestLanguage.g:293:1: ( '(' )
            {
            // InternalOutlineTestLanguage.g:293:1: ( '(' )
            // InternalOutlineTestLanguage.g:294:1: '('
            {
             before(grammarAccess.getElementAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getLeftParenthesisKeyword_1_0()); 

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
    // $ANTLR end "rule__Element__Group_1__0__Impl"


    // $ANTLR start "rule__Element__Group_1__1"
    // InternalOutlineTestLanguage.g:307:1: rule__Element__Group_1__1 : rule__Element__Group_1__1__Impl rule__Element__Group_1__2 ;
    public final void rule__Element__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:311:1: ( rule__Element__Group_1__1__Impl rule__Element__Group_1__2 )
            // InternalOutlineTestLanguage.g:312:2: rule__Element__Group_1__1__Impl rule__Element__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Element__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1__2();

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
    // $ANTLR end "rule__Element__Group_1__1"


    // $ANTLR start "rule__Element__Group_1__1__Impl"
    // InternalOutlineTestLanguage.g:319:1: rule__Element__Group_1__1__Impl : ( ( rule__Element__XrefsAssignment_1_1 )* ) ;
    public final void rule__Element__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:323:1: ( ( ( rule__Element__XrefsAssignment_1_1 )* ) )
            // InternalOutlineTestLanguage.g:324:1: ( ( rule__Element__XrefsAssignment_1_1 )* )
            {
            // InternalOutlineTestLanguage.g:324:1: ( ( rule__Element__XrefsAssignment_1_1 )* )
            // InternalOutlineTestLanguage.g:325:1: ( rule__Element__XrefsAssignment_1_1 )*
            {
             before(grammarAccess.getElementAccess().getXrefsAssignment_1_1()); 
            // InternalOutlineTestLanguage.g:326:1: ( rule__Element__XrefsAssignment_1_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOutlineTestLanguage.g:326:2: rule__Element__XrefsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Element__XrefsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getXrefsAssignment_1_1()); 

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
    // $ANTLR end "rule__Element__Group_1__1__Impl"


    // $ANTLR start "rule__Element__Group_1__2"
    // InternalOutlineTestLanguage.g:336:1: rule__Element__Group_1__2 : rule__Element__Group_1__2__Impl ;
    public final void rule__Element__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:340:1: ( rule__Element__Group_1__2__Impl )
            // InternalOutlineTestLanguage.g:341:2: rule__Element__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1__2__Impl();

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
    // $ANTLR end "rule__Element__Group_1__2"


    // $ANTLR start "rule__Element__Group_1__2__Impl"
    // InternalOutlineTestLanguage.g:347:1: rule__Element__Group_1__2__Impl : ( ')' ) ;
    public final void rule__Element__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:351:1: ( ( ')' ) )
            // InternalOutlineTestLanguage.g:352:1: ( ')' )
            {
            // InternalOutlineTestLanguage.g:352:1: ( ')' )
            // InternalOutlineTestLanguage.g:353:1: ')'
            {
             before(grammarAccess.getElementAccess().getRightParenthesisKeyword_1_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRightParenthesisKeyword_1_2()); 

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
    // $ANTLR end "rule__Element__Group_1__2__Impl"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalOutlineTestLanguage.g:373:1: rule__Model__ElementsAssignment : ( ruleElement ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:377:1: ( ( ruleElement ) )
            // InternalOutlineTestLanguage.g:378:1: ( ruleElement )
            {
            // InternalOutlineTestLanguage.g:378:1: ( ruleElement )
            // InternalOutlineTestLanguage.g:379:1: ruleElement
            {
             before(grammarAccess.getModelAccess().getElementsElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsElementParserRuleCall_0()); 

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


    // $ANTLR start "rule__Element__NameAssignment_0"
    // InternalOutlineTestLanguage.g:388:1: rule__Element__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:392:1: ( ( RULE_ID ) )
            // InternalOutlineTestLanguage.g:393:1: ( RULE_ID )
            {
            // InternalOutlineTestLanguage.g:393:1: ( RULE_ID )
            // InternalOutlineTestLanguage.g:394:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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


    // $ANTLR start "rule__Element__XrefsAssignment_1_1"
    // InternalOutlineTestLanguage.g:403:1: rule__Element__XrefsAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__XrefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:407:1: ( ( ( RULE_ID ) ) )
            // InternalOutlineTestLanguage.g:408:1: ( ( RULE_ID ) )
            {
            // InternalOutlineTestLanguage.g:408:1: ( ( RULE_ID ) )
            // InternalOutlineTestLanguage.g:409:1: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getXrefsElementCrossReference_1_1_0()); 
            // InternalOutlineTestLanguage.g:410:1: ( RULE_ID )
            // InternalOutlineTestLanguage.g:411:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getXrefsElementIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getXrefsElementIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getXrefsElementCrossReference_1_1_0()); 

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
    // $ANTLR end "rule__Element__XrefsAssignment_1_1"


    // $ANTLR start "rule__Element__ChildrenAssignment_3"
    // InternalOutlineTestLanguage.g:422:1: rule__Element__ChildrenAssignment_3 : ( ruleElement ) ;
    public final void rule__Element__ChildrenAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalOutlineTestLanguage.g:426:1: ( ( ruleElement ) )
            // InternalOutlineTestLanguage.g:427:1: ( ruleElement )
            {
            // InternalOutlineTestLanguage.g:427:1: ( ruleElement )
            // InternalOutlineTestLanguage.g:428:1: ruleElement
            {
             before(grammarAccess.getElementAccess().getChildrenElementParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementAccess().getChildrenElementParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Element__ChildrenAssignment_3"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004010L});
    }


}
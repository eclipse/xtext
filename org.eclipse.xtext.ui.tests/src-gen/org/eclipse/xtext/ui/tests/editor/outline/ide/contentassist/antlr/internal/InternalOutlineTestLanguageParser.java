package org.eclipse.xtext.ui.tests.editor.outline.ide.contentassist.antlr.internal;

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
    // InternalOutlineTestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalOutlineTestLanguage.g:54:1: ( ruleModel EOF )
            // InternalOutlineTestLanguage.g:55:1: ruleModel EOF
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
    // InternalOutlineTestLanguage.g:62:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:66:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalOutlineTestLanguage.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalOutlineTestLanguage.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            // InternalOutlineTestLanguage.g:68:3: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalOutlineTestLanguage.g:69:3: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOutlineTestLanguage.g:69:4: rule__Model__ElementsAssignment
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
    // InternalOutlineTestLanguage.g:78:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalOutlineTestLanguage.g:79:1: ( ruleElement EOF )
            // InternalOutlineTestLanguage.g:80:1: ruleElement EOF
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
    // InternalOutlineTestLanguage.g:87:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:91:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalOutlineTestLanguage.g:92:2: ( ( rule__Element__Group__0 ) )
            {
            // InternalOutlineTestLanguage.g:92:2: ( ( rule__Element__Group__0 ) )
            // InternalOutlineTestLanguage.g:93:3: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalOutlineTestLanguage.g:94:3: ( rule__Element__Group__0 )
            // InternalOutlineTestLanguage.g:94:4: rule__Element__Group__0
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
    // InternalOutlineTestLanguage.g:102:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:106:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalOutlineTestLanguage.g:107:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // InternalOutlineTestLanguage.g:114:1: rule__Element__Group__0__Impl : ( ( rule__Element__NameAssignment_0 ) ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:118:1: ( ( ( rule__Element__NameAssignment_0 ) ) )
            // InternalOutlineTestLanguage.g:119:1: ( ( rule__Element__NameAssignment_0 ) )
            {
            // InternalOutlineTestLanguage.g:119:1: ( ( rule__Element__NameAssignment_0 ) )
            // InternalOutlineTestLanguage.g:120:2: ( rule__Element__NameAssignment_0 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_0()); 
            // InternalOutlineTestLanguage.g:121:2: ( rule__Element__NameAssignment_0 )
            // InternalOutlineTestLanguage.g:121:3: rule__Element__NameAssignment_0
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
    // InternalOutlineTestLanguage.g:129:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:133:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalOutlineTestLanguage.g:134:2: rule__Element__Group__1__Impl rule__Element__Group__2
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
    // InternalOutlineTestLanguage.g:141:1: rule__Element__Group__1__Impl : ( ( rule__Element__Group_1__0 )? ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:145:1: ( ( ( rule__Element__Group_1__0 )? ) )
            // InternalOutlineTestLanguage.g:146:1: ( ( rule__Element__Group_1__0 )? )
            {
            // InternalOutlineTestLanguage.g:146:1: ( ( rule__Element__Group_1__0 )? )
            // InternalOutlineTestLanguage.g:147:2: ( rule__Element__Group_1__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_1()); 
            // InternalOutlineTestLanguage.g:148:2: ( rule__Element__Group_1__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalOutlineTestLanguage.g:148:3: rule__Element__Group_1__0
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
    // InternalOutlineTestLanguage.g:156:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:160:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalOutlineTestLanguage.g:161:2: rule__Element__Group__2__Impl rule__Element__Group__3
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
    // InternalOutlineTestLanguage.g:168:1: rule__Element__Group__2__Impl : ( '{' ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:172:1: ( ( '{' ) )
            // InternalOutlineTestLanguage.g:173:1: ( '{' )
            {
            // InternalOutlineTestLanguage.g:173:1: ( '{' )
            // InternalOutlineTestLanguage.g:174:2: '{'
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
    // InternalOutlineTestLanguage.g:183:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:187:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalOutlineTestLanguage.g:188:2: rule__Element__Group__3__Impl rule__Element__Group__4
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
    // InternalOutlineTestLanguage.g:195:1: rule__Element__Group__3__Impl : ( ( rule__Element__ChildrenAssignment_3 )* ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:199:1: ( ( ( rule__Element__ChildrenAssignment_3 )* ) )
            // InternalOutlineTestLanguage.g:200:1: ( ( rule__Element__ChildrenAssignment_3 )* )
            {
            // InternalOutlineTestLanguage.g:200:1: ( ( rule__Element__ChildrenAssignment_3 )* )
            // InternalOutlineTestLanguage.g:201:2: ( rule__Element__ChildrenAssignment_3 )*
            {
             before(grammarAccess.getElementAccess().getChildrenAssignment_3()); 
            // InternalOutlineTestLanguage.g:202:2: ( rule__Element__ChildrenAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalOutlineTestLanguage.g:202:3: rule__Element__ChildrenAssignment_3
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
    // InternalOutlineTestLanguage.g:210:1: rule__Element__Group__4 : rule__Element__Group__4__Impl ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:214:1: ( rule__Element__Group__4__Impl )
            // InternalOutlineTestLanguage.g:215:2: rule__Element__Group__4__Impl
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
    // InternalOutlineTestLanguage.g:221:1: rule__Element__Group__4__Impl : ( '}' ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:225:1: ( ( '}' ) )
            // InternalOutlineTestLanguage.g:226:1: ( '}' )
            {
            // InternalOutlineTestLanguage.g:226:1: ( '}' )
            // InternalOutlineTestLanguage.g:227:2: '}'
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
    // InternalOutlineTestLanguage.g:237:1: rule__Element__Group_1__0 : rule__Element__Group_1__0__Impl rule__Element__Group_1__1 ;
    public final void rule__Element__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:241:1: ( rule__Element__Group_1__0__Impl rule__Element__Group_1__1 )
            // InternalOutlineTestLanguage.g:242:2: rule__Element__Group_1__0__Impl rule__Element__Group_1__1
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
    // InternalOutlineTestLanguage.g:249:1: rule__Element__Group_1__0__Impl : ( '(' ) ;
    public final void rule__Element__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:253:1: ( ( '(' ) )
            // InternalOutlineTestLanguage.g:254:1: ( '(' )
            {
            // InternalOutlineTestLanguage.g:254:1: ( '(' )
            // InternalOutlineTestLanguage.g:255:2: '('
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
    // InternalOutlineTestLanguage.g:264:1: rule__Element__Group_1__1 : rule__Element__Group_1__1__Impl rule__Element__Group_1__2 ;
    public final void rule__Element__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:268:1: ( rule__Element__Group_1__1__Impl rule__Element__Group_1__2 )
            // InternalOutlineTestLanguage.g:269:2: rule__Element__Group_1__1__Impl rule__Element__Group_1__2
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
    // InternalOutlineTestLanguage.g:276:1: rule__Element__Group_1__1__Impl : ( ( rule__Element__XrefsAssignment_1_1 )* ) ;
    public final void rule__Element__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:280:1: ( ( ( rule__Element__XrefsAssignment_1_1 )* ) )
            // InternalOutlineTestLanguage.g:281:1: ( ( rule__Element__XrefsAssignment_1_1 )* )
            {
            // InternalOutlineTestLanguage.g:281:1: ( ( rule__Element__XrefsAssignment_1_1 )* )
            // InternalOutlineTestLanguage.g:282:2: ( rule__Element__XrefsAssignment_1_1 )*
            {
             before(grammarAccess.getElementAccess().getXrefsAssignment_1_1()); 
            // InternalOutlineTestLanguage.g:283:2: ( rule__Element__XrefsAssignment_1_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOutlineTestLanguage.g:283:3: rule__Element__XrefsAssignment_1_1
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
    // InternalOutlineTestLanguage.g:291:1: rule__Element__Group_1__2 : rule__Element__Group_1__2__Impl ;
    public final void rule__Element__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:295:1: ( rule__Element__Group_1__2__Impl )
            // InternalOutlineTestLanguage.g:296:2: rule__Element__Group_1__2__Impl
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
    // InternalOutlineTestLanguage.g:302:1: rule__Element__Group_1__2__Impl : ( ')' ) ;
    public final void rule__Element__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:306:1: ( ( ')' ) )
            // InternalOutlineTestLanguage.g:307:1: ( ')' )
            {
            // InternalOutlineTestLanguage.g:307:1: ( ')' )
            // InternalOutlineTestLanguage.g:308:2: ')'
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
    // InternalOutlineTestLanguage.g:318:1: rule__Model__ElementsAssignment : ( ruleElement ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:322:1: ( ( ruleElement ) )
            // InternalOutlineTestLanguage.g:323:2: ( ruleElement )
            {
            // InternalOutlineTestLanguage.g:323:2: ( ruleElement )
            // InternalOutlineTestLanguage.g:324:3: ruleElement
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
    // InternalOutlineTestLanguage.g:333:1: rule__Element__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:337:1: ( ( RULE_ID ) )
            // InternalOutlineTestLanguage.g:338:2: ( RULE_ID )
            {
            // InternalOutlineTestLanguage.g:338:2: ( RULE_ID )
            // InternalOutlineTestLanguage.g:339:3: RULE_ID
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
    // InternalOutlineTestLanguage.g:348:1: rule__Element__XrefsAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__XrefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:352:1: ( ( ( RULE_ID ) ) )
            // InternalOutlineTestLanguage.g:353:2: ( ( RULE_ID ) )
            {
            // InternalOutlineTestLanguage.g:353:2: ( ( RULE_ID ) )
            // InternalOutlineTestLanguage.g:354:3: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getXrefsElementCrossReference_1_1_0()); 
            // InternalOutlineTestLanguage.g:355:3: ( RULE_ID )
            // InternalOutlineTestLanguage.g:356:4: RULE_ID
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
    // InternalOutlineTestLanguage.g:367:1: rule__Element__ChildrenAssignment_3 : ( ruleElement ) ;
    public final void rule__Element__ChildrenAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOutlineTestLanguage.g:371:1: ( ( ruleElement ) )
            // InternalOutlineTestLanguage.g:372:2: ( ruleElement )
            {
            // InternalOutlineTestLanguage.g:372:2: ( ruleElement )
            // InternalOutlineTestLanguage.g:373:3: ruleElement
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
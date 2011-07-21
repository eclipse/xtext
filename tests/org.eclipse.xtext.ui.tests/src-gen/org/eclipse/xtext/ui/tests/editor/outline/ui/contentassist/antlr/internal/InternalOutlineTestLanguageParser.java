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
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalOutlineTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOutlineTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOutlineTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel68); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:69:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:73:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:74:1: ( ( rule__Model__ElementsAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:74:1: ( ( rule__Model__ElementsAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:75:1: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:76:1: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:76:2: rule__Model__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ElementsAssignment_in_ruleModel94);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:88:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:89:1: ( ruleElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:90:1: ruleElement EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:97:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:101:2: ( ( ( rule__Element__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:102:1: ( ( rule__Element__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:102:1: ( ( rule__Element__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:103:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:104:1: ( rule__Element__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:104:2: rule__Element__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:118:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:122:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:123:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:130:1: rule__Element__Group__0__Impl : ( ( rule__Element__NameAssignment_0 ) ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:134:1: ( ( ( rule__Element__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:135:1: ( ( rule__Element__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:135:1: ( ( rule__Element__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:136:1: ( rule__Element__NameAssignment_0 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:137:1: ( rule__Element__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:137:2: rule__Element__NameAssignment_0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:147:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:151:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:152:2: rule__Element__Group__1__Impl rule__Element__Group__2
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:159:1: rule__Element__Group__1__Impl : ( ( rule__Element__Group_1__0 )? ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:163:1: ( ( ( rule__Element__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:164:1: ( ( rule__Element__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:164:1: ( ( rule__Element__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:165:1: ( rule__Element__Group_1__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:166:1: ( rule__Element__Group_1__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:166:2: rule__Element__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__0_in_rule__Element__Group__1__Impl279);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:176:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:180:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:181:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__2310);
            rule__Element__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2313);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:188:1: rule__Element__Group__2__Impl : ( '{' ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:192:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:193:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:193:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:194:1: '{'
            {
             before(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Element__Group__2__Impl341); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:207:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:211:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:212:2: rule__Element__Group__3__Impl rule__Element__Group__4
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:219:1: rule__Element__Group__3__Impl : ( ( rule__Element__ChildrenAssignment_3 )* ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:223:1: ( ( ( rule__Element__ChildrenAssignment_3 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:224:1: ( ( rule__Element__ChildrenAssignment_3 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:224:1: ( ( rule__Element__ChildrenAssignment_3 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:225:1: ( rule__Element__ChildrenAssignment_3 )*
            {
             before(grammarAccess.getElementAccess().getChildrenAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:226:1: ( rule__Element__ChildrenAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:226:2: rule__Element__ChildrenAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__ChildrenAssignment_3_in_rule__Element__Group__3__Impl402);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:236:1: rule__Element__Group__4 : rule__Element__Group__4__Impl ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:240:1: ( rule__Element__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:241:2: rule__Element__Group__4__Impl
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:247:1: rule__Element__Group__4__Impl : ( '}' ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:251:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:252:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:252:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:253:1: '}'
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


    // $ANTLR start "rule__Element__Group_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:276:1: rule__Element__Group_1__0 : rule__Element__Group_1__0__Impl rule__Element__Group_1__1 ;
    public final void rule__Element__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:280:1: ( rule__Element__Group_1__0__Impl rule__Element__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:281:2: rule__Element__Group_1__0__Impl rule__Element__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__0__Impl_in_rule__Element__Group_1__0502);
            rule__Element__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__1_in_rule__Element__Group_1__0505);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:288:1: rule__Element__Group_1__0__Impl : ( '(' ) ;
    public final void rule__Element__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:292:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:293:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:293:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:294:1: '('
            {
             before(grammarAccess.getElementAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Element__Group_1__0__Impl533); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:307:1: rule__Element__Group_1__1 : rule__Element__Group_1__1__Impl rule__Element__Group_1__2 ;
    public final void rule__Element__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:311:1: ( rule__Element__Group_1__1__Impl rule__Element__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:312:2: rule__Element__Group_1__1__Impl rule__Element__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__1__Impl_in_rule__Element__Group_1__1564);
            rule__Element__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__2_in_rule__Element__Group_1__1567);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:319:1: rule__Element__Group_1__1__Impl : ( ( rule__Element__XrefsAssignment_1_1 )* ) ;
    public final void rule__Element__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:323:1: ( ( ( rule__Element__XrefsAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:324:1: ( ( rule__Element__XrefsAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:324:1: ( ( rule__Element__XrefsAssignment_1_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:325:1: ( rule__Element__XrefsAssignment_1_1 )*
            {
             before(grammarAccess.getElementAccess().getXrefsAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:326:1: ( rule__Element__XrefsAssignment_1_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:326:2: rule__Element__XrefsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__XrefsAssignment_1_1_in_rule__Element__Group_1__1__Impl594);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:336:1: rule__Element__Group_1__2 : rule__Element__Group_1__2__Impl ;
    public final void rule__Element__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:340:1: ( rule__Element__Group_1__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:341:2: rule__Element__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__2__Impl_in_rule__Element__Group_1__2625);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:347:1: rule__Element__Group_1__2__Impl : ( ')' ) ;
    public final void rule__Element__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:351:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:352:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:352:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:353:1: ')'
            {
             before(grammarAccess.getElementAccess().getRightParenthesisKeyword_1_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Element__Group_1__2__Impl653); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:373:1: rule__Model__ElementsAssignment : ( ruleElement ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:377:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:378:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:378:1: ( ruleElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:379:1: ruleElement
            {
             before(grammarAccess.getModelAccess().getElementsElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__Model__ElementsAssignment695);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:388:1: rule__Element__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:392:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:393:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:393:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:394:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__NameAssignment_0726); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:403:1: rule__Element__XrefsAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__XrefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:407:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:408:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:408:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:409:1: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getXrefsElementCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:410:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:411:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getXrefsElementIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__XrefsAssignment_1_1761); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:422:1: rule__Element__ChildrenAssignment_3 : ( ruleElement ) ;
    public final void rule__Element__ChildrenAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:426:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:427:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:427:1: ( ruleElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/outline/ui/contentassist/antlr/internal/InternalOutlineTestLanguage.g:428:1: ruleElement
            {
             before(grammarAccess.getElementAccess().getChildrenElementParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__Element__ChildrenAssignment_3796);
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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ElementsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0_in_ruleElement155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__0189 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__NameAssignment_0_in_rule__Element__Group__0__Impl219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1249 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_1__0_in_rule__Element__Group__1__Impl279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__2310 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Element__Group__2__Impl341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__3__Impl_in_rule__Element__Group__3372 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__Element__Group__4_in_rule__Element__Group__3375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__ChildrenAssignment_3_in_rule__Element__Group__3__Impl402 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Element__Group__4__Impl_in_rule__Element__Group__4433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Element__Group__4__Impl461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_1__0__Impl_in_rule__Element__Group_1__0502 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Element__Group_1__1_in_rule__Element__Group_1__0505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Element__Group_1__0__Impl533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_1__1__Impl_in_rule__Element__Group_1__1564 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Element__Group_1__2_in_rule__Element__Group_1__1567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__XrefsAssignment_1_1_in_rule__Element__Group_1__1__Impl594 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Element__Group_1__2__Impl_in_rule__Element__Group_1__2625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Element__Group_1__2__Impl653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__Model__ElementsAssignment695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__NameAssignment_0726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__XrefsAssignment_1_1761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__Element__ChildrenAssignment_3796 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.ui.tests.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.services.FoldingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalFoldingTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'", "'end'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalFoldingTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g"; }


     
     	private FoldingTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(FoldingTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleFoldingModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:61:1: entryRuleFoldingModel : ruleFoldingModel EOF ;
    public final void entryRuleFoldingModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:62:1: ( ruleFoldingModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:63:1: ruleFoldingModel EOF
            {
             before(grammarAccess.getFoldingModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFoldingModel_in_entryRuleFoldingModel61);
            ruleFoldingModel();
            _fsp--;

             after(grammarAccess.getFoldingModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoldingModel68); 

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
    // $ANTLR end entryRuleFoldingModel


    // $ANTLR start ruleFoldingModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:70:1: ruleFoldingModel : ( ( rule__FoldingModel__ElementsAssignment )* ) ;
    public final void ruleFoldingModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:74:2: ( ( ( rule__FoldingModel__ElementsAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:75:1: ( ( rule__FoldingModel__ElementsAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:75:1: ( ( rule__FoldingModel__ElementsAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:76:1: ( rule__FoldingModel__ElementsAssignment )*
            {
             before(grammarAccess.getFoldingModelAccess().getElementsAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:77:1: ( rule__FoldingModel__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:77:2: rule__FoldingModel__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FoldingModel__ElementsAssignment_in_ruleFoldingModel94);
            	    rule__FoldingModel__ElementsAssignment();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFoldingModelAccess().getElementsAssignment()); 

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
    // $ANTLR end ruleFoldingModel


    // $ANTLR start entryRuleElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:89:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:90:1: ( ruleElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:91:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement122);
            ruleElement();
            _fsp--;

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
    // $ANTLR end entryRuleElement


    // $ANTLR start ruleElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:98:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:102:2: ( ( ( rule__Element__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:103:1: ( ( rule__Element__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:103:1: ( ( rule__Element__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:104:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:105:1: ( rule__Element__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:105:2: rule__Element__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0_in_ruleElement155);
            rule__Element__Group__0();
            _fsp--;


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
    // $ANTLR end ruleElement


    // $ANTLR start rule__Element__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:119:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:123:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:124:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__0189);
            rule__Element__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0192);
            rule__Element__Group__1();
            _fsp--;


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
    // $ANTLR end rule__Element__Group__0


    // $ANTLR start rule__Element__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:131:1: rule__Element__Group__0__Impl : ( 'element' ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:135:1: ( ( 'element' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:136:1: ( 'element' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:136:1: ( 'element' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:137:1: 'element'
            {
             before(grammarAccess.getElementAccess().getElementKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Element__Group__0__Impl220); 
             after(grammarAccess.getElementAccess().getElementKeyword_0()); 

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
    // $ANTLR end rule__Element__Group__0__Impl


    // $ANTLR start rule__Element__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:150:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:154:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:155:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1251);
            rule__Element__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1254);
            rule__Element__Group__2();
            _fsp--;


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
    // $ANTLR end rule__Element__Group__1


    // $ANTLR start rule__Element__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:162:1: rule__Element__Group__1__Impl : ( ( rule__Element__NameAssignment_1 ) ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:166:1: ( ( ( rule__Element__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:167:1: ( ( rule__Element__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:167:1: ( ( rule__Element__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:168:1: ( rule__Element__NameAssignment_1 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:169:1: ( rule__Element__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:169:2: rule__Element__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__NameAssignment_1_in_rule__Element__Group__1__Impl281);
            rule__Element__NameAssignment_1();
            _fsp--;


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
    // $ANTLR end rule__Element__Group__1__Impl


    // $ANTLR start rule__Element__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:179:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:183:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:184:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__2311);
            rule__Element__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2314);
            rule__Element__Group__3();
            _fsp--;


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
    // $ANTLR end rule__Element__Group__2


    // $ANTLR start rule__Element__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:191:1: rule__Element__Group__2__Impl : ( ( rule__Element__SubelementsAssignment_2 )* ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:195:1: ( ( ( rule__Element__SubelementsAssignment_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:196:1: ( ( rule__Element__SubelementsAssignment_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:196:1: ( ( rule__Element__SubelementsAssignment_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:197:1: ( rule__Element__SubelementsAssignment_2 )*
            {
             before(grammarAccess.getElementAccess().getSubelementsAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:198:1: ( rule__Element__SubelementsAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:198:2: rule__Element__SubelementsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__SubelementsAssignment_2_in_rule__Element__Group__2__Impl341);
            	    rule__Element__SubelementsAssignment_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getSubelementsAssignment_2()); 

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
    // $ANTLR end rule__Element__Group__2__Impl


    // $ANTLR start rule__Element__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:208:1: rule__Element__Group__3 : rule__Element__Group__3__Impl ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:212:1: ( rule__Element__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:213:2: rule__Element__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3__Impl_in_rule__Element__Group__3372);
            rule__Element__Group__3__Impl();
            _fsp--;


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
    // $ANTLR end rule__Element__Group__3


    // $ANTLR start rule__Element__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:219:1: rule__Element__Group__3__Impl : ( 'end' ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:223:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:224:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:224:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:225:1: 'end'
            {
             before(grammarAccess.getElementAccess().getEndKeyword_3()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Element__Group__3__Impl400); 
             after(grammarAccess.getElementAccess().getEndKeyword_3()); 

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
    // $ANTLR end rule__Element__Group__3__Impl


    // $ANTLR start rule__FoldingModel__ElementsAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:247:1: rule__FoldingModel__ElementsAssignment : ( ruleElement ) ;
    public final void rule__FoldingModel__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:251:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:252:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:252:1: ( ruleElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:253:1: ruleElement
            {
             before(grammarAccess.getFoldingModelAccess().getElementsElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__FoldingModel__ElementsAssignment444);
            ruleElement();
            _fsp--;

             after(grammarAccess.getFoldingModelAccess().getElementsElementParserRuleCall_0()); 

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
    // $ANTLR end rule__FoldingModel__ElementsAssignment


    // $ANTLR start rule__Element__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:262:1: rule__Element__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:266:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:267:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:267:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:268:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__NameAssignment_1475); 
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
    // $ANTLR end rule__Element__NameAssignment_1


    // $ANTLR start rule__Element__SubelementsAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:277:1: rule__Element__SubelementsAssignment_2 : ( ruleElement ) ;
    public final void rule__Element__SubelementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:281:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:282:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:282:1: ( ruleElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalFoldingTestLanguage.g:283:1: ruleElement
            {
             before(grammarAccess.getElementAccess().getSubelementsElementParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__Element__SubelementsAssignment_2506);
            ruleElement();
            _fsp--;

             after(grammarAccess.getElementAccess().getSubelementsElementParserRuleCall_2_0()); 

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
    // $ANTLR end rule__Element__SubelementsAssignment_2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFoldingModel_in_entryRuleFoldingModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoldingModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FoldingModel__ElementsAssignment_in_ruleFoldingModel94 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0_in_ruleElement155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__0189 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Element__Group__0__Impl220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1251 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__NameAssignment_1_in_rule__Element__Group__1__Impl281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__2311 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__SubelementsAssignment_2_in_rule__Element__Group__2__Impl341 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_rule__Element__Group__3__Impl_in_rule__Element__Group__3372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Element__Group__3__Impl400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__FoldingModel__ElementsAssignment444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__NameAssignment_1475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__Element__SubelementsAssignment_2506 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.ui.tests.quickfix.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.quickfix.services.QuickfixCrossrefTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalQuickfixCrossrefTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'ref'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalQuickfixCrossrefTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
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




    // $ANTLR start entryRuleMain
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:61:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:62:1: ( ruleMain EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:63:1: ruleMain EOF
            {
             before(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMain_in_entryRuleMain61);
            ruleMain();
            _fsp--;

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
    // $ANTLR end entryRuleMain


    // $ANTLR start ruleMain
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:70:1: ruleMain : ( ( rule__Main__ElementsAssignment )* ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:74:2: ( ( ( rule__Main__ElementsAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:75:1: ( ( rule__Main__ElementsAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:75:1: ( ( rule__Main__ElementsAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:76:1: ( rule__Main__ElementsAssignment )*
            {
             before(grammarAccess.getMainAccess().getElementsAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:77:1: ( rule__Main__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:77:2: rule__Main__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Main__ElementsAssignment_in_ruleMain94);
            	    rule__Main__ElementsAssignment();
            	    _fsp--;


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
    // $ANTLR end ruleMain


    // $ANTLR start entryRuleElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:89:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:90:1: ( ruleElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:91:1: ruleElement EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:98:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:102:2: ( ( ( rule__Element__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:103:1: ( ( rule__Element__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:103:1: ( ( rule__Element__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:104:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:105:1: ( rule__Element__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:105:2: rule__Element__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:119:1: rule__Element__Group__0 : ( ( rule__Element__NameAssignment_0 ) ) rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:123:1: ( ( ( rule__Element__NameAssignment_0 ) ) rule__Element__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:124:1: ( ( rule__Element__NameAssignment_0 ) ) rule__Element__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:124:1: ( ( rule__Element__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:125:1: ( rule__Element__NameAssignment_0 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:126:1: ( rule__Element__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:126:2: rule__Element__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__NameAssignment_0_in_rule__Element__Group__0193);
            rule__Element__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getElementAccess().getNameAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0202);
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


    // $ANTLR start rule__Element__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:137:1: rule__Element__Group__1 : ( '{' ) rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:141:1: ( ( '{' ) rule__Element__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:142:1: ( '{' ) rule__Element__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:142:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:143:1: '{'
            {
             before(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Element__Group__1231); 
             after(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1241);
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


    // $ANTLR start rule__Element__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:157:1: rule__Element__Group__2 : ( ( rule__Element__ContainedAssignment_2 )* ) rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:161:1: ( ( ( rule__Element__ContainedAssignment_2 )* ) rule__Element__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:162:1: ( ( rule__Element__ContainedAssignment_2 )* ) rule__Element__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:162:1: ( ( rule__Element__ContainedAssignment_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:163:1: ( rule__Element__ContainedAssignment_2 )*
            {
             before(grammarAccess.getElementAccess().getContainedAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:164:1: ( rule__Element__ContainedAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:164:2: rule__Element__ContainedAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__ContainedAssignment_2_in_rule__Element__Group__2269);
            	    rule__Element__ContainedAssignment_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getContainedAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2279);
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


    // $ANTLR start rule__Element__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:175:1: rule__Element__Group__3 : ( ( rule__Element__Group_3__0 )* ) rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:179:1: ( ( ( rule__Element__Group_3__0 )* ) rule__Element__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:180:1: ( ( rule__Element__Group_3__0 )* ) rule__Element__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:180:1: ( ( rule__Element__Group_3__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:181:1: ( rule__Element__Group_3__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:182:1: ( rule__Element__Group_3__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:182:2: rule__Element__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3307);
            	    rule__Element__Group_3__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getGroup_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__4_in_rule__Element__Group__3317);
            rule__Element__Group__4();
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


    // $ANTLR start rule__Element__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:193:1: rule__Element__Group__4 : ( '}' ) ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:197:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:198:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:198:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:199:1: '}'
            {
             before(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_4()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Element__Group__4346); 
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
    // $ANTLR end rule__Element__Group__4


    // $ANTLR start rule__Element__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:222:1: rule__Element__Group_3__0 : ( 'ref' ) rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:226:1: ( ( 'ref' ) rule__Element__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:227:1: ( 'ref' ) rule__Element__Group_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:227:1: ( 'ref' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:228:1: 'ref'
            {
             before(grammarAccess.getElementAccess().getRefKeyword_3_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Element__Group_3__0392); 
             after(grammarAccess.getElementAccess().getRefKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__0402);
            rule__Element__Group_3__1();
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
    // $ANTLR end rule__Element__Group_3__0


    // $ANTLR start rule__Element__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:242:1: rule__Element__Group_3__1 : ( ( rule__Element__ReferencedAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:246:1: ( ( ( rule__Element__ReferencedAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:247:1: ( ( rule__Element__ReferencedAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:247:1: ( ( rule__Element__ReferencedAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:248:1: ( rule__Element__ReferencedAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getReferencedAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:249:1: ( rule__Element__ReferencedAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:249:2: rule__Element__ReferencedAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__ReferencedAssignment_3_1_in_rule__Element__Group_3__1430);
            rule__Element__ReferencedAssignment_3_1();
            _fsp--;


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
    // $ANTLR end rule__Element__Group_3__1


    // $ANTLR start rule__Main__ElementsAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:264:1: rule__Main__ElementsAssignment : ( ruleElement ) ;
    public final void rule__Main__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:268:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:269:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:269:1: ( ruleElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:270:1: ruleElement
            {
             before(grammarAccess.getMainAccess().getElementsElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__Main__ElementsAssignment469);
            ruleElement();
            _fsp--;

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
    // $ANTLR end rule__Main__ElementsAssignment


    // $ANTLR start rule__Element__NameAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:279:1: rule__Element__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:283:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:284:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:284:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:285:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__NameAssignment_0500); 
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
    // $ANTLR end rule__Element__NameAssignment_0


    // $ANTLR start rule__Element__ContainedAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:294:1: rule__Element__ContainedAssignment_2 : ( ruleElement ) ;
    public final void rule__Element__ContainedAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:298:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:299:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:299:1: ( ruleElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:300:1: ruleElement
            {
             before(grammarAccess.getElementAccess().getContainedElementParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__Element__ContainedAssignment_2531);
            ruleElement();
            _fsp--;

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
    // $ANTLR end rule__Element__ContainedAssignment_2


    // $ANTLR start rule__Element__ReferencedAssignment_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:309:1: rule__Element__ReferencedAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__ReferencedAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:313:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:314:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:314:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:315:1: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getReferencedElementCrossReference_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:316:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/ui/contentassist/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:317:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getReferencedElementIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__ReferencedAssignment_3_1566); 
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
    // $ANTLR end rule__Element__ReferencedAssignment_3_1


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMain_in_entryRuleMain61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMain68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Main__ElementsAssignment_in_ruleMain94 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0_in_ruleElement155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__NameAssignment_0_in_rule__Element__Group__0193 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Element__Group__1231 = new BitSet(new long[]{0x0000000000003010L});
        public static final BitSet FOLLOW_rule__Element__Group__2_in_rule__Element__Group__1241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__ContainedAssignment_2_in_rule__Element__Group__2269 = new BitSet(new long[]{0x0000000000003010L});
        public static final BitSet FOLLOW_rule__Element__Group__3_in_rule__Element__Group__2279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3307 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_rule__Element__Group__4_in_rule__Element__Group__3317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Element__Group__4346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Element__Group_3__0392 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__0402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__ReferencedAssignment_3_1_in_rule__Element__Group_3__1430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__Main__ElementsAssignment469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__NameAssignment_0500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__Element__ContainedAssignment_2531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__ReferencedAssignment_3_1566 = new BitSet(new long[]{0x0000000000000002L});
    }


}
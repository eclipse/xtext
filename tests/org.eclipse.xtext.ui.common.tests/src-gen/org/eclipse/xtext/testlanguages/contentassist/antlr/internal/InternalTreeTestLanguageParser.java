package org.eclipse.xtext.testlanguages.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTreeTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'{'", "'};'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTreeTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g"; }


     
     	private TreeTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TreeTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:55:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:55:16: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:56:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel60);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel67); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:63:1: ruleModel : ( ( rule__Model__ChildrenAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:67:2: ( ( ( rule__Model__ChildrenAssignment )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:68:1: ( ( rule__Model__ChildrenAssignment )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:68:1: ( ( rule__Model__ChildrenAssignment )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:69:1: ( rule__Model__ChildrenAssignment )*
            {
             before(grammarAccess.getModelAccess().getChildrenAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:70:1: ( rule__Model__ChildrenAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:70:2: rule__Model__ChildrenAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Model__ChildrenAssignment_in_ruleModel94);
            	    rule__Model__ChildrenAssignment();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getChildrenAssignment()); 

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleNode
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:82:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:82:15: ( ruleNode EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:83:1: ruleNode EOF
            {
             before(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode121);
            ruleNode();
            _fsp--;

             after(grammarAccess.getNodeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode128); 

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
    // $ANTLR end entryRuleNode


    // $ANTLR start ruleNode
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:90:1: ruleNode : ( ( rule__Node__Group__0 ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:94:2: ( ( ( rule__Node__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:95:1: ( ( rule__Node__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:95:1: ( ( rule__Node__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:96:1: ( rule__Node__Group__0 )
            {
             before(grammarAccess.getNodeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:97:1: ( rule__Node__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:97:2: rule__Node__Group__0
            {
            pushFollow(FOLLOW_rule__Node__Group__0_in_ruleNode155);
            rule__Node__Group__0();
            _fsp--;


            }

             after(grammarAccess.getNodeAccess().getGroup()); 

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
    // $ANTLR end ruleNode


    // $ANTLR start rule__Node__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:111:1: rule__Node__Group__0 : ( ( rule__Node__NameAssignment_0 ) ) rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:115:1: ( ( ( rule__Node__NameAssignment_0 ) ) rule__Node__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:116:1: ( ( rule__Node__NameAssignment_0 ) ) rule__Node__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:116:1: ( ( rule__Node__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:117:1: ( rule__Node__NameAssignment_0 )
            {
             before(grammarAccess.getNodeAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:118:1: ( rule__Node__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:118:2: rule__Node__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Node__NameAssignment_0_in_rule__Node__Group__0193);
            rule__Node__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getNodeAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Node__Group__1_in_rule__Node__Group__0202);
            rule__Node__Group__1();
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
    // $ANTLR end rule__Node__Group__0


    // $ANTLR start rule__Node__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:129:1: rule__Node__Group__1 : ( '(' ) rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:133:1: ( ( '(' ) rule__Node__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:134:1: ( '(' ) rule__Node__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:134:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:135:1: '('
            {
             before(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_1()); 
            match(input,11,FOLLOW_11_in_rule__Node__Group__1231); 
             after(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__Node__Group__2_in_rule__Node__Group__1241);
            rule__Node__Group__2();
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
    // $ANTLR end rule__Node__Group__1


    // $ANTLR start rule__Node__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:149:1: rule__Node__Group__2 : ( ( rule__Node__AttribAssignment_2 ) ) rule__Node__Group__3 ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:153:1: ( ( ( rule__Node__AttribAssignment_2 ) ) rule__Node__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:154:1: ( ( rule__Node__AttribAssignment_2 ) ) rule__Node__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:154:1: ( ( rule__Node__AttribAssignment_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:155:1: ( rule__Node__AttribAssignment_2 )
            {
             before(grammarAccess.getNodeAccess().getAttribAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:156:1: ( rule__Node__AttribAssignment_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:156:2: rule__Node__AttribAssignment_2
            {
            pushFollow(FOLLOW_rule__Node__AttribAssignment_2_in_rule__Node__Group__2269);
            rule__Node__AttribAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getNodeAccess().getAttribAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__Node__Group__3_in_rule__Node__Group__2278);
            rule__Node__Group__3();
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
    // $ANTLR end rule__Node__Group__2


    // $ANTLR start rule__Node__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:167:1: rule__Node__Group__3 : ( ')' ) rule__Node__Group__4 ;
    public final void rule__Node__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:171:1: ( ( ')' ) rule__Node__Group__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:172:1: ( ')' ) rule__Node__Group__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:172:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:173:1: ')'
            {
             before(grammarAccess.getNodeAccess().getRightParenthesisKeyword_3()); 
            match(input,12,FOLLOW_12_in_rule__Node__Group__3307); 
             after(grammarAccess.getNodeAccess().getRightParenthesisKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__Node__Group__4_in_rule__Node__Group__3317);
            rule__Node__Group__4();
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
    // $ANTLR end rule__Node__Group__3


    // $ANTLR start rule__Node__Group__4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:187:1: rule__Node__Group__4 : ( '{' ) rule__Node__Group__5 ;
    public final void rule__Node__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:191:1: ( ( '{' ) rule__Node__Group__5 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:192:1: ( '{' ) rule__Node__Group__5
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:192:1: ( '{' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:193:1: '{'
            {
             before(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,13,FOLLOW_13_in_rule__Node__Group__4346); 
             after(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4()); 

            }

            pushFollow(FOLLOW_rule__Node__Group__5_in_rule__Node__Group__4356);
            rule__Node__Group__5();
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
    // $ANTLR end rule__Node__Group__4


    // $ANTLR start rule__Node__Group__5
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:207:1: rule__Node__Group__5 : ( ( rule__Node__ChildrenAssignment_5 )* ) rule__Node__Group__6 ;
    public final void rule__Node__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:211:1: ( ( ( rule__Node__ChildrenAssignment_5 )* ) rule__Node__Group__6 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:212:1: ( ( rule__Node__ChildrenAssignment_5 )* ) rule__Node__Group__6
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:212:1: ( ( rule__Node__ChildrenAssignment_5 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:213:1: ( rule__Node__ChildrenAssignment_5 )*
            {
             before(grammarAccess.getNodeAccess().getChildrenAssignment_5()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:214:1: ( rule__Node__ChildrenAssignment_5 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:214:2: rule__Node__ChildrenAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Node__ChildrenAssignment_5_in_rule__Node__Group__5384);
            	    rule__Node__ChildrenAssignment_5();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getNodeAccess().getChildrenAssignment_5()); 

            }

            pushFollow(FOLLOW_rule__Node__Group__6_in_rule__Node__Group__5394);
            rule__Node__Group__6();
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
    // $ANTLR end rule__Node__Group__5


    // $ANTLR start rule__Node__Group__6
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:225:1: rule__Node__Group__6 : ( '};' ) ;
    public final void rule__Node__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:229:1: ( ( '};' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:230:1: ( '};' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:230:1: ( '};' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:231:1: '};'
            {
             before(grammarAccess.getNodeAccess().getRightCurlyBracketSemicolonKeyword_6()); 
            match(input,14,FOLLOW_14_in_rule__Node__Group__6423); 
             after(grammarAccess.getNodeAccess().getRightCurlyBracketSemicolonKeyword_6()); 

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
    // $ANTLR end rule__Node__Group__6


    // $ANTLR start rule__Model__ChildrenAssignment
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:258:1: rule__Model__ChildrenAssignment : ( ruleNode ) ;
    public final void rule__Model__ChildrenAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:262:1: ( ( ruleNode ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:263:1: ( ruleNode )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:263:1: ( ruleNode )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:264:1: ruleNode
            {
             before(grammarAccess.getModelAccess().getChildrenNodeParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Model__ChildrenAssignment472);
            ruleNode();
            _fsp--;

             after(grammarAccess.getModelAccess().getChildrenNodeParserRuleCall_0()); 

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
    // $ANTLR end rule__Model__ChildrenAssignment


    // $ANTLR start rule__Node__NameAssignment_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:273:1: rule__Node__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Node__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:277:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:278:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:278:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:279:1: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Node__NameAssignment_0503); 
             after(grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end rule__Node__NameAssignment_0


    // $ANTLR start rule__Node__AttribAssignment_2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:288:1: rule__Node__AttribAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Node__AttribAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:292:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:293:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:293:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:294:1: RULE_STRING
            {
             before(grammarAccess.getNodeAccess().getAttribSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Node__AttribAssignment_2534); 
             after(grammarAccess.getNodeAccess().getAttribSTRINGTerminalRuleCall_2_0()); 

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
    // $ANTLR end rule__Node__AttribAssignment_2


    // $ANTLR start rule__Node__ChildrenAssignment_5
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:303:1: rule__Node__ChildrenAssignment_5 : ( ruleNode ) ;
    public final void rule__Node__ChildrenAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:307:1: ( ( ruleNode ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:308:1: ( ruleNode )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:308:1: ( ruleNode )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/contentassist/antlr/internal/InternalTreeTestLanguage.g:309:1: ruleNode
            {
             before(grammarAccess.getNodeAccess().getChildrenNodeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleNode_in_rule__Node__ChildrenAssignment_5565);
            ruleNode();
            _fsp--;

             after(grammarAccess.getNodeAccess().getChildrenNodeParserRuleCall_5_0()); 

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
    // $ANTLR end rule__Node__ChildrenAssignment_5


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ChildrenAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__Group__0_in_ruleNode155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__NameAssignment_0_in_rule__Node__Group__0193 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Node__Group__1_in_rule__Node__Group__0202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Node__Group__1231 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Node__Group__2_in_rule__Node__Group__1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__AttribAssignment_2_in_rule__Node__Group__2269 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Node__Group__3_in_rule__Node__Group__2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Node__Group__3307 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Node__Group__4_in_rule__Node__Group__3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Node__Group__4346 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Node__Group__5_in_rule__Node__Group__4356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Node__ChildrenAssignment_5_in_rule__Node__Group__5384 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Node__Group__6_in_rule__Node__Group__5394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Node__Group__6423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Model__ChildrenAssignment472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Node__NameAssignment_0503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Node__AttribAssignment_2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_rule__Node__ChildrenAssignment_5565 = new BitSet(new long[]{0x0000000000000002L});

}
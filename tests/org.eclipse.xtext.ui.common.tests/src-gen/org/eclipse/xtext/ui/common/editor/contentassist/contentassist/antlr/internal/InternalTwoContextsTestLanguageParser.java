package org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.common.editor.contentassist.services.TwoContextsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTwoContextsTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'refersTo'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTwoContextsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g"; }


     
     	private TwoContextsTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TwoContextsTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleMainModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:60:1: entryRuleMainModel : ruleMainModel EOF ;
    public final void entryRuleMainModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:61:1: ( ruleMainModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:62:1: ruleMainModel EOF
            {
             before(grammarAccess.getMainModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMainModel_in_entryRuleMainModel61);
            ruleMainModel();
            _fsp--;

             after(grammarAccess.getMainModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMainModel68); 

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
    // $ANTLR end entryRuleMainModel


    // $ANTLR start ruleMainModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:69:1: ruleMainModel : ( ( rule__MainModel__ElementsAssignment )* ) ;
    public final void ruleMainModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:73:2: ( ( ( rule__MainModel__ElementsAssignment )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:74:1: ( ( rule__MainModel__ElementsAssignment )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:74:1: ( ( rule__MainModel__ElementsAssignment )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:75:1: ( rule__MainModel__ElementsAssignment )*
            {
             before(grammarAccess.getMainModelAccess().getElementsAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:76:1: ( rule__MainModel__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:76:2: rule__MainModel__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MainModel__ElementsAssignment_in_ruleMainModel95);
            	    rule__MainModel__ElementsAssignment();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainModelAccess().getElementsAssignment()); 

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
    // $ANTLR end ruleMainModel


    // $ANTLR start entryRuleAnElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:88:1: entryRuleAnElement : ruleAnElement EOF ;
    public final void entryRuleAnElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:89:1: ( ruleAnElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:90:1: ruleAnElement EOF
            {
             before(grammarAccess.getAnElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnElement_in_entryRuleAnElement123);
            ruleAnElement();
            _fsp--;

             after(grammarAccess.getAnElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnElement130); 

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
    // $ANTLR end entryRuleAnElement


    // $ANTLR start ruleAnElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:97:1: ruleAnElement : ( ( rule__AnElement__Group__0 ) ) ;
    public final void ruleAnElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:101:2: ( ( ( rule__AnElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:102:1: ( ( rule__AnElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:102:1: ( ( rule__AnElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:103:1: ( rule__AnElement__Group__0 )
            {
             before(grammarAccess.getAnElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:104:1: ( rule__AnElement__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:104:2: rule__AnElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AnElement__Group__0_in_ruleAnElement157);
            rule__AnElement__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAnElementAccess().getGroup()); 

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
    // $ANTLR end ruleAnElement


    // $ANTLR start rule__AnElement__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:118:1: rule__AnElement__Group__0 : ( ( rule__AnElement__NameAssignment_0 ) ) rule__AnElement__Group__1 ;
    public final void rule__AnElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:122:1: ( ( ( rule__AnElement__NameAssignment_0 ) ) rule__AnElement__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:123:1: ( ( rule__AnElement__NameAssignment_0 ) ) rule__AnElement__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:123:1: ( ( rule__AnElement__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:124:1: ( rule__AnElement__NameAssignment_0 )
            {
             before(grammarAccess.getAnElementAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:125:1: ( rule__AnElement__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:125:2: rule__AnElement__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AnElement__NameAssignment_0_in_rule__AnElement__Group__0195);
            rule__AnElement__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAnElementAccess().getNameAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AnElement__Group__1_in_rule__AnElement__Group__0204);
            rule__AnElement__Group__1();
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
    // $ANTLR end rule__AnElement__Group__0


    // $ANTLR start rule__AnElement__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:136:1: rule__AnElement__Group__1 : ( ( rule__AnElement__Group_1__0 )? ) rule__AnElement__Group__2 ;
    public final void rule__AnElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:140:1: ( ( ( rule__AnElement__Group_1__0 )? ) rule__AnElement__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:141:1: ( ( rule__AnElement__Group_1__0 )? ) rule__AnElement__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:141:1: ( ( rule__AnElement__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:142:1: ( rule__AnElement__Group_1__0 )?
            {
             before(grammarAccess.getAnElementAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:143:1: ( rule__AnElement__Group_1__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:143:2: rule__AnElement__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AnElement__Group_1__0_in_rule__AnElement__Group__1232);
                    rule__AnElement__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAnElementAccess().getGroup_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AnElement__Group__2_in_rule__AnElement__Group__1242);
            rule__AnElement__Group__2();
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
    // $ANTLR end rule__AnElement__Group__1


    // $ANTLR start rule__AnElement__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:154:1: rule__AnElement__Group__2 : ( ';' ) ;
    public final void rule__AnElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:158:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:159:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:159:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:160:1: ';'
            {
             before(grammarAccess.getAnElementAccess().getSemicolonKeyword_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__AnElement__Group__2271); 
             after(grammarAccess.getAnElementAccess().getSemicolonKeyword_2()); 

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
    // $ANTLR end rule__AnElement__Group__2


    // $ANTLR start rule__AnElement__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:179:1: rule__AnElement__Group_1__0 : ( 'refersTo' ) rule__AnElement__Group_1__1 ;
    public final void rule__AnElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:183:1: ( ( 'refersTo' ) rule__AnElement__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:184:1: ( 'refersTo' ) rule__AnElement__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:184:1: ( 'refersTo' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:185:1: 'refersTo'
            {
             before(grammarAccess.getAnElementAccess().getRefersToKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__AnElement__Group_1__0313); 
             after(grammarAccess.getAnElementAccess().getRefersToKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AnElement__Group_1__1_in_rule__AnElement__Group_1__0323);
            rule__AnElement__Group_1__1();
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
    // $ANTLR end rule__AnElement__Group_1__0


    // $ANTLR start rule__AnElement__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:199:1: rule__AnElement__Group_1__1 : ( ( rule__AnElement__ReferredAssignment_1_1 ) ) ;
    public final void rule__AnElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:203:1: ( ( ( rule__AnElement__ReferredAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:204:1: ( ( rule__AnElement__ReferredAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:204:1: ( ( rule__AnElement__ReferredAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:205:1: ( rule__AnElement__ReferredAssignment_1_1 )
            {
             before(grammarAccess.getAnElementAccess().getReferredAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:206:1: ( rule__AnElement__ReferredAssignment_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:206:2: rule__AnElement__ReferredAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AnElement__ReferredAssignment_1_1_in_rule__AnElement__Group_1__1351);
            rule__AnElement__ReferredAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getAnElementAccess().getReferredAssignment_1_1()); 

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
    // $ANTLR end rule__AnElement__Group_1__1


    // $ANTLR start rule__MainModel__ElementsAssignment
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:220:1: rule__MainModel__ElementsAssignment : ( ruleAnElement ) ;
    public final void rule__MainModel__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:224:1: ( ( ruleAnElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:225:1: ( ruleAnElement )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:225:1: ( ruleAnElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:226:1: ruleAnElement
            {
             before(grammarAccess.getMainModelAccess().getElementsAnElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnElement_in_rule__MainModel__ElementsAssignment389);
            ruleAnElement();
            _fsp--;

             after(grammarAccess.getMainModelAccess().getElementsAnElementParserRuleCall_0()); 

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
    // $ANTLR end rule__MainModel__ElementsAssignment


    // $ANTLR start rule__AnElement__NameAssignment_0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:235:1: rule__AnElement__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__AnElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:239:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:240:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:240:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:241:1: RULE_ID
            {
             before(grammarAccess.getAnElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__AnElement__NameAssignment_0420); 
             after(grammarAccess.getAnElementAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end rule__AnElement__NameAssignment_0


    // $ANTLR start rule__AnElement__ReferredAssignment_1_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:250:1: rule__AnElement__ReferredAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__AnElement__ReferredAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:254:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:255:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:255:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:256:1: ( RULE_ID )
            {
             before(grammarAccess.getAnElementAccess().getReferredAnElementCrossReference_1_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:257:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalTwoContextsTestLanguage.g:258:1: RULE_ID
            {
             before(grammarAccess.getAnElementAccess().getReferredAnElementIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__AnElement__ReferredAssignment_1_1455); 
             after(grammarAccess.getAnElementAccess().getReferredAnElementIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getAnElementAccess().getReferredAnElementCrossReference_1_1_0()); 

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
    // $ANTLR end rule__AnElement__ReferredAssignment_1_1


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMainModel_in_entryRuleMainModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMainModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MainModel__ElementsAssignment_in_ruleMainModel95 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAnElement_in_entryRuleAnElement123 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnElement130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AnElement__Group__0_in_ruleAnElement157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AnElement__NameAssignment_0_in_rule__AnElement__Group__0195 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__AnElement__Group__1_in_rule__AnElement__Group__0204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AnElement__Group_1__0_in_rule__AnElement__Group__1232 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__AnElement__Group__2_in_rule__AnElement__Group__1242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__AnElement__Group__2271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__AnElement__Group_1__0313 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__AnElement__Group_1__1_in_rule__AnElement__Group_1__0323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AnElement__ReferredAssignment_1_1_in_rule__AnElement__Group_1__1351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnElement_in_rule__MainModel__ElementsAssignment389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__AnElement__NameAssignment_0420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__AnElement__ReferredAssignment_1_1455 = new BitSet(new long[]{0x0000000000000002L});
    }


}
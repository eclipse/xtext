package org.eclipse.xtext.ui.tests.editor.contentassist.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.UnorderedGroupsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalUnorderedGroupsTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'public'", "'private'", "'protected'", "'class'", "'{'", "'}'", "'static'", "'synchronized'", "'abstract'", "'final'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalUnorderedGroupsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g"; }


     
     	private UnorderedGroupsTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UnorderedGroupsTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:76:1: ( rule__Model__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:76:2: rule__Model__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__0_in_ruleModel95);
            rule__Model__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

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


    // $ANTLR start rule__Model__VisibilityAlternatives_0_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:88:1: rule__Model__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__Model__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:92:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("88:1: rule__Model__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:93:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:93:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:94:1: 'public'
                    {
                     before(grammarAccess.getModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Model__VisibilityAlternatives_0_0_0132); 
                     after(grammarAccess.getModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:101:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:101:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:102:1: 'private'
                    {
                     before(grammarAccess.getModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__VisibilityAlternatives_0_0_0152); 
                     after(grammarAccess.getModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:109:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:109:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:110:1: 'protected'
                    {
                     before(grammarAccess.getModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__VisibilityAlternatives_0_0_0172); 
                     after(grammarAccess.getModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__Model__VisibilityAlternatives_0_0_0


    // $ANTLR start rule__Model__Alternatives_0_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:122:1: rule__Model__Alternatives_0_3 : ( ( ( rule__Model__AbstractAssignment_0_3_0 ) ) | ( ( rule__Model__FinalAssignment_0_3_1 ) ) );
    public final void rule__Model__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:126:1: ( ( ( rule__Model__AbstractAssignment_0_3_0 ) ) | ( ( rule__Model__FinalAssignment_0_3_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==19) ) {
                alt2=1;
            }
            else if ( (LA2_0==20) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("122:1: rule__Model__Alternatives_0_3 : ( ( ( rule__Model__AbstractAssignment_0_3_0 ) ) | ( ( rule__Model__FinalAssignment_0_3_1 ) ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:127:1: ( ( rule__Model__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:127:1: ( ( rule__Model__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:128:1: ( rule__Model__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:129:1: ( rule__Model__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:129:2: rule__Model__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__AbstractAssignment_0_3_0_in_rule__Model__Alternatives_0_3206);
                    rule__Model__AbstractAssignment_0_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getAbstractAssignment_0_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:133:6: ( ( rule__Model__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:133:6: ( ( rule__Model__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:134:1: ( rule__Model__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:135:1: ( rule__Model__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:135:2: rule__Model__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__FinalAssignment_0_3_1_in_rule__Model__Alternatives_0_3224);
                    rule__Model__FinalAssignment_0_3_1();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getFinalAssignment_0_3_1()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__Model__Alternatives_0_3


    // $ANTLR start rule__Model__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:146:1: rule__Model__Group__0 : ( ( rule__Model__UnorderedGroup_0 ) ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:150:1: ( ( ( rule__Model__UnorderedGroup_0 ) ) rule__Model__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:151:1: ( ( rule__Model__UnorderedGroup_0 ) ) rule__Model__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:151:1: ( ( rule__Model__UnorderedGroup_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:152:1: ( rule__Model__UnorderedGroup_0 )
            {
             before(grammarAccess.getModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:153:1: ( rule__Model__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:153:2: rule__Model__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__UnorderedGroup_0_in_rule__Model__Group__0259);
            rule__Model__UnorderedGroup_0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getUnorderedGroup_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0268);
            rule__Model__Group__1();
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
    // $ANTLR end rule__Model__Group__0


    // $ANTLR start rule__Model__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:164:1: rule__Model__Group__1 : ( 'class' ) rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:168:1: ( ( 'class' ) rule__Model__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:169:1: ( 'class' ) rule__Model__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:169:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:170:1: 'class'
            {
             before(grammarAccess.getModelAccess().getClassKeyword_1()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Model__Group__1297); 
             after(grammarAccess.getModelAccess().getClassKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1307);
            rule__Model__Group__2();
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
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Model__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:184:1: rule__Model__Group__2 : ( ( rule__Model__NameAssignment_2 ) ) rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:188:1: ( ( ( rule__Model__NameAssignment_2 ) ) rule__Model__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:189:1: ( ( rule__Model__NameAssignment_2 ) ) rule__Model__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:189:1: ( ( rule__Model__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:190:1: ( rule__Model__NameAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:191:1: ( rule__Model__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:191:2: rule__Model__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__NameAssignment_2_in_rule__Model__Group__2335);
            rule__Model__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__3_in_rule__Model__Group__2344);
            rule__Model__Group__3();
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
    // $ANTLR end rule__Model__Group__2


    // $ANTLR start rule__Model__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:202:1: rule__Model__Group__3 : ( '{' ) rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:206:1: ( ( '{' ) rule__Model__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:207:1: ( '{' ) rule__Model__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:207:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:208:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__Group__3373); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group__4_in_rule__Model__Group__3383);
            rule__Model__Group__4();
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
    // $ANTLR end rule__Model__Group__3


    // $ANTLR start rule__Model__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:222:1: rule__Model__Group__4 : ( '}' ) ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:226:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:227:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:227:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:228:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Model__Group__4412); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_4()); 

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
    // $ANTLR end rule__Model__Group__4


    // $ANTLR start rule__Model__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:252:1: rule__Model__UnorderedGroup_0 : ( ( ({...}? => ( ( rule__Model__VisibilityAssignment_0_0 ) ) ) | ({...}? => ( ( rule__Model__StaticAssignment_0_1 ) ) ) | ({...}? => ( ( rule__Model__SynchronizedAssignment_0_2 ) ) ) | ({...}? => ( ( rule__Model__Alternatives_0_3 ) ) ) )* ) ;
    public final void rule__Model__UnorderedGroup_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean[] pred_0 = new boolean[4];
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:257:1: ( ( ( ({...}? => ( ( rule__Model__VisibilityAssignment_0_0 ) ) ) | ({...}? => ( ( rule__Model__StaticAssignment_0_1 ) ) ) | ({...}? => ( ( rule__Model__SynchronizedAssignment_0_2 ) ) ) | ({...}? => ( ( rule__Model__Alternatives_0_3 ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:258:2: ( ( ({...}? => ( ( rule__Model__VisibilityAssignment_0_0 ) ) ) | ({...}? => ( ( rule__Model__StaticAssignment_0_1 ) ) ) | ({...}? => ( ( rule__Model__SynchronizedAssignment_0_2 ) ) ) | ({...}? => ( ( rule__Model__Alternatives_0_3 ) ) ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:258:2: ( ( ({...}? => ( ( rule__Model__VisibilityAssignment_0_0 ) ) ) | ({...}? => ( ( rule__Model__StaticAssignment_0_1 ) ) ) | ({...}? => ( ( rule__Model__SynchronizedAssignment_0_2 ) ) ) | ({...}? => ( ( rule__Model__Alternatives_0_3 ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:259:3: ( ({...}? => ( ( rule__Model__VisibilityAssignment_0_0 ) ) ) | ({...}? => ( ( rule__Model__StaticAssignment_0_1 ) ) ) | ({...}? => ( ( rule__Model__SynchronizedAssignment_0_2 ) ) ) | ({...}? => ( ( rule__Model__Alternatives_0_3 ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:259:3: ( ({...}? => ( ( rule__Model__VisibilityAssignment_0_0 ) ) ) | ({...}? => ( ( rule__Model__StaticAssignment_0_1 ) ) ) | ({...}? => ( ( rule__Model__SynchronizedAssignment_0_2 ) ) ) | ({...}? => ( ( rule__Model__Alternatives_0_3 ) ) ) )*
            loop3:
            do {
                int alt3=5;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=13)) && (!pred_0[0])) {
                    alt3=1;
                }
                else if ( (LA3_0==17) && (!pred_0[1])) {
                    alt3=2;
                }
                else if ( (LA3_0==18) && (!pred_0[2])) {
                    alt3=3;
                }
                else if ( ((LA3_0>=19 && LA3_0<=20)) && (!pred_0[3])) {
                    alt3=4;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:261:4: ({...}? => ( ( rule__Model__VisibilityAssignment_0_0 ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:261:4: ({...}? => ( ( rule__Model__VisibilityAssignment_0_0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:262:5: {...}? => ( ( rule__Model__VisibilityAssignment_0_0 ) )
            	    {
            	    if ( !(!pred_0[0]) ) {
            	        throw new FailedPredicateException(input, "rule__Model__UnorderedGroup_0", "!pred_0[0]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:262:20: ( ( rule__Model__VisibilityAssignment_0_0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:263:6: ( rule__Model__VisibilityAssignment_0_0 )
            	    {
            	     
            	    	 				  pred_0[0] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:267:6: ( rule__Model__VisibilityAssignment_0_0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:267:7: rule__Model__VisibilityAssignment_0_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__VisibilityAssignment_0_0_in_rule__Model__UnorderedGroup_0488);
            	    rule__Model__VisibilityAssignment_0_0();
            	    _fsp--;


            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:271:4: ({...}? => ( ( rule__Model__StaticAssignment_0_1 ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:271:4: ({...}? => ( ( rule__Model__StaticAssignment_0_1 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:272:5: {...}? => ( ( rule__Model__StaticAssignment_0_1 ) )
            	    {
            	    if ( !(!pred_0[1]) ) {
            	        throw new FailedPredicateException(input, "rule__Model__UnorderedGroup_0", "!pred_0[1]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:272:20: ( ( rule__Model__StaticAssignment_0_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:273:6: ( rule__Model__StaticAssignment_0_1 )
            	    {
            	     
            	    	 				  pred_0[1] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:277:6: ( rule__Model__StaticAssignment_0_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:277:7: rule__Model__StaticAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__StaticAssignment_0_1_in_rule__Model__UnorderedGroup_0534);
            	    rule__Model__StaticAssignment_0_1();
            	    _fsp--;


            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:281:4: ({...}? => ( ( rule__Model__SynchronizedAssignment_0_2 ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:281:4: ({...}? => ( ( rule__Model__SynchronizedAssignment_0_2 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:282:5: {...}? => ( ( rule__Model__SynchronizedAssignment_0_2 ) )
            	    {
            	    if ( !(!pred_0[2]) ) {
            	        throw new FailedPredicateException(input, "rule__Model__UnorderedGroup_0", "!pred_0[2]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:282:20: ( ( rule__Model__SynchronizedAssignment_0_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:283:6: ( rule__Model__SynchronizedAssignment_0_2 )
            	    {
            	     
            	    	 				  pred_0[2] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:287:6: ( rule__Model__SynchronizedAssignment_0_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:287:7: rule__Model__SynchronizedAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__SynchronizedAssignment_0_2_in_rule__Model__UnorderedGroup_0580);
            	    rule__Model__SynchronizedAssignment_0_2();
            	    _fsp--;


            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:291:4: ({...}? => ( ( rule__Model__Alternatives_0_3 ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:291:4: ({...}? => ( ( rule__Model__Alternatives_0_3 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:292:5: {...}? => ( ( rule__Model__Alternatives_0_3 ) )
            	    {
            	    if ( !(!pred_0[3]) ) {
            	        throw new FailedPredicateException(input, "rule__Model__UnorderedGroup_0", "!pred_0[3]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:292:20: ( ( rule__Model__Alternatives_0_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:293:6: ( rule__Model__Alternatives_0_3 )
            	    {
            	     
            	    	 				  pred_0[3] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:297:6: ( rule__Model__Alternatives_0_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:297:7: rule__Model__Alternatives_0_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_0_3_in_rule__Model__UnorderedGroup_0626);
            	    rule__Model__Alternatives_0_3();
            	    _fsp--;


            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
    // $ANTLR end rule__Model__UnorderedGroup_0


    // $ANTLR start rule__Model__VisibilityAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:310:1: rule__Model__VisibilityAssignment_0_0 : ( ( rule__Model__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__Model__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:314:1: ( ( ( rule__Model__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:315:1: ( ( rule__Model__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:315:1: ( ( rule__Model__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:316:1: ( rule__Model__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:317:1: ( rule__Model__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:317:2: rule__Model__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__VisibilityAlternatives_0_0_0_in_rule__Model__VisibilityAssignment_0_0680);
            rule__Model__VisibilityAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getVisibilityAlternatives_0_0_0()); 

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
    // $ANTLR end rule__Model__VisibilityAssignment_0_0


    // $ANTLR start rule__Model__StaticAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:326:1: rule__Model__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__Model__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:330:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:331:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:331:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:332:1: ( 'static' )
            {
             before(grammarAccess.getModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:333:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:334:1: 'static'
            {
             before(grammarAccess.getModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Model__StaticAssignment_0_1718); 
             after(grammarAccess.getModelAccess().getStaticStaticKeyword_0_1_0()); 

            }

             after(grammarAccess.getModelAccess().getStaticStaticKeyword_0_1_0()); 

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
    // $ANTLR end rule__Model__StaticAssignment_0_1


    // $ANTLR start rule__Model__SynchronizedAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:349:1: rule__Model__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__Model__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:353:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:354:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:354:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:355:1: ( 'synchronized' )
            {
             before(grammarAccess.getModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:356:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:357:1: 'synchronized'
            {
             before(grammarAccess.getModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Model__SynchronizedAssignment_0_2762); 
             after(grammarAccess.getModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }

             after(grammarAccess.getModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

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
    // $ANTLR end rule__Model__SynchronizedAssignment_0_2


    // $ANTLR start rule__Model__AbstractAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:372:1: rule__Model__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__Model__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:376:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:377:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:377:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:378:1: ( 'abstract' )
            {
             before(grammarAccess.getModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:379:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:380:1: 'abstract'
            {
             before(grammarAccess.getModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Model__AbstractAssignment_0_3_0806); 
             after(grammarAccess.getModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

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
    // $ANTLR end rule__Model__AbstractAssignment_0_3_0


    // $ANTLR start rule__Model__FinalAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:395:1: rule__Model__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__Model__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:399:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:400:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:400:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:401:1: ( 'final' )
            {
             before(grammarAccess.getModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:402:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:403:1: 'final'
            {
             before(grammarAccess.getModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Model__FinalAssignment_0_3_1850); 
             after(grammarAccess.getModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }

             after(grammarAccess.getModelAccess().getFinalFinalKeyword_0_3_1_0()); 

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
    // $ANTLR end rule__Model__FinalAssignment_0_3_1


    // $ANTLR start rule__Model__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:418:1: rule__Model__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:422:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:423:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:423:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:424:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Model__NameAssignment_2889); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end rule__Model__NameAssignment_2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel95 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Model__VisibilityAlternatives_0_0_0132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__VisibilityAlternatives_0_0_0152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__VisibilityAlternatives_0_0_0172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__AbstractAssignment_0_3_0_in_rule__Model__Alternatives_0_3206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__FinalAssignment_0_3_1_in_rule__Model__Alternatives_0_3224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__UnorderedGroup_0_in_rule__Model__Group__0259 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Model__Group__1297 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__NameAssignment_2_in_rule__Model__Group__2335 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__2344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__Group__3373 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__3383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Model__Group__4412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__VisibilityAssignment_0_0_in_rule__Model__UnorderedGroup_0488 = new BitSet(new long[]{0x00000000001E3802L});
        public static final BitSet FOLLOW_rule__Model__StaticAssignment_0_1_in_rule__Model__UnorderedGroup_0534 = new BitSet(new long[]{0x00000000001E3802L});
        public static final BitSet FOLLOW_rule__Model__SynchronizedAssignment_0_2_in_rule__Model__UnorderedGroup_0580 = new BitSet(new long[]{0x00000000001E3802L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_0_3_in_rule__Model__UnorderedGroup_0626 = new BitSet(new long[]{0x00000000001E3802L});
        public static final BitSet FOLLOW_rule__Model__VisibilityAlternatives_0_0_0_in_rule__Model__VisibilityAssignment_0_0680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Model__StaticAssignment_0_1718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Model__SynchronizedAssignment_0_2762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Model__AbstractAssignment_0_3_0806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Model__FinalAssignment_0_3_1850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_2889 = new BitSet(new long[]{0x0000000000000002L});
    }


}
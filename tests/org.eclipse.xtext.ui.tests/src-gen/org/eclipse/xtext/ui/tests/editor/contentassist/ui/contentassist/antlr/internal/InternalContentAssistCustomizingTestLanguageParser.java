package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistCustomizingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistCustomizingTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'extends'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalContentAssistCustomizingTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g"; }


     
     	private ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:63:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:70:1: ruleModel : ( ( rule__Model__TypesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:74:2: ( ( ( rule__Model__TypesAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:75:1: ( ( rule__Model__TypesAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:75:1: ( ( rule__Model__TypesAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:76:1: ( rule__Model__TypesAssignment )*
            {
             before(grammarAccess.getModelAccess().getTypesAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:77:1: ( rule__Model__TypesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:77:2: rule__Model__TypesAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__TypesAssignment_in_ruleModel94);
            	    rule__Model__TypesAssignment();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getTypesAssignment()); 

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


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:89:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:90:1: ( ruleType EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:91:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType122);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType129); 

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:98:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:102:2: ( ( ( rule__Type__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:103:1: ( ( rule__Type__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:103:1: ( ( rule__Type__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:104:1: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:105:1: ( rule__Type__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:105:2: rule__Type__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__0_in_ruleType155);
            rule__Type__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getGroup()); 

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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:117:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:118:1: ( ruleTypeRef EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:119:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef182);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getTypeRefRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRef189); 

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
    // $ANTLR end entryRuleTypeRef


    // $ANTLR start ruleTypeRef
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:126:1: ruleTypeRef : ( ( rule__TypeRef__TypeAssignment ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:130:2: ( ( ( rule__TypeRef__TypeAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:131:1: ( ( rule__TypeRef__TypeAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:131:1: ( ( rule__TypeRef__TypeAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:132:1: ( rule__TypeRef__TypeAssignment )
            {
             before(grammarAccess.getTypeRefAccess().getTypeAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:133:1: ( rule__TypeRef__TypeAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:133:2: rule__TypeRef__TypeAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__TypeAssignment_in_ruleTypeRef215);
            rule__TypeRef__TypeAssignment();
            _fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getTypeAssignment()); 

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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:145:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:146:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:147:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN242);
            ruleFQN();
            _fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN249); 

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
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:154:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:158:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:159:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:159:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:160:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:161:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:161:2: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0_in_ruleFQN275);
            rule__FQN__Group__0();
            _fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

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
    // $ANTLR end ruleFQN


    // $ANTLR start rule__Type__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:175:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:179:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:180:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__0309);
            rule__Type__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__1_in_rule__Type__Group__0312);
            rule__Type__Group__1();
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
    // $ANTLR end rule__Type__Group__0


    // $ANTLR start rule__Type__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:187:1: rule__Type__Group__0__Impl : ( ( rule__Type__NameAssignment_0 ) ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:191:1: ( ( ( rule__Type__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:192:1: ( ( rule__Type__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:192:1: ( ( rule__Type__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:193:1: ( rule__Type__NameAssignment_0 )
            {
             before(grammarAccess.getTypeAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:194:1: ( rule__Type__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:194:2: rule__Type__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__NameAssignment_0_in_rule__Type__Group__0__Impl339);
            rule__Type__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getNameAssignment_0()); 

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
    // $ANTLR end rule__Type__Group__0__Impl


    // $ANTLR start rule__Type__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:204:1: rule__Type__Group__1 : rule__Type__Group__1__Impl rule__Type__Group__2 ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:208:1: ( rule__Type__Group__1__Impl rule__Type__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:209:2: rule__Type__Group__1__Impl rule__Type__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__1369);
            rule__Type__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__2_in_rule__Type__Group__1372);
            rule__Type__Group__2();
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
    // $ANTLR end rule__Type__Group__1


    // $ANTLR start rule__Type__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:216:1: rule__Type__Group__1__Impl : ( ( rule__Type__Group_1__0 )? ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:220:1: ( ( ( rule__Type__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:221:1: ( ( rule__Type__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:221:1: ( ( rule__Type__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:222:1: ( rule__Type__Group_1__0 )?
            {
             before(grammarAccess.getTypeAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:223:1: ( rule__Type__Group_1__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:223:2: rule__Type__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Type__Group_1__0_in_rule__Type__Group__1__Impl399);
                    rule__Type__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeAccess().getGroup_1()); 

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
    // $ANTLR end rule__Type__Group__1__Impl


    // $ANTLR start rule__Type__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:233:1: rule__Type__Group__2 : rule__Type__Group__2__Impl ;
    public final void rule__Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:237:1: ( rule__Type__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:238:2: rule__Type__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__2__Impl_in_rule__Type__Group__2430);
            rule__Type__Group__2__Impl();
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
    // $ANTLR end rule__Type__Group__2


    // $ANTLR start rule__Type__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:244:1: rule__Type__Group__2__Impl : ( ';' ) ;
    public final void rule__Type__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:248:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:249:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:249:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:250:1: ';'
            {
             before(grammarAccess.getTypeAccess().getSemicolonKeyword_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Type__Group__2__Impl458); 
             after(grammarAccess.getTypeAccess().getSemicolonKeyword_2()); 

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
    // $ANTLR end rule__Type__Group__2__Impl


    // $ANTLR start rule__Type__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:269:1: rule__Type__Group_1__0 : rule__Type__Group_1__0__Impl rule__Type__Group_1__1 ;
    public final void rule__Type__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:273:1: ( rule__Type__Group_1__0__Impl rule__Type__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:274:2: rule__Type__Group_1__0__Impl rule__Type__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group_1__0__Impl_in_rule__Type__Group_1__0495);
            rule__Type__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group_1__1_in_rule__Type__Group_1__0498);
            rule__Type__Group_1__1();
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
    // $ANTLR end rule__Type__Group_1__0


    // $ANTLR start rule__Type__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:281:1: rule__Type__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__Type__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:285:1: ( ( 'extends' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:286:1: ( 'extends' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:286:1: ( 'extends' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:287:1: 'extends'
            {
             before(grammarAccess.getTypeAccess().getExtendsKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Type__Group_1__0__Impl526); 
             after(grammarAccess.getTypeAccess().getExtendsKeyword_1_0()); 

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
    // $ANTLR end rule__Type__Group_1__0__Impl


    // $ANTLR start rule__Type__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:300:1: rule__Type__Group_1__1 : rule__Type__Group_1__1__Impl ;
    public final void rule__Type__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:304:1: ( rule__Type__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:305:2: rule__Type__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group_1__1__Impl_in_rule__Type__Group_1__1557);
            rule__Type__Group_1__1__Impl();
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
    // $ANTLR end rule__Type__Group_1__1


    // $ANTLR start rule__Type__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:311:1: rule__Type__Group_1__1__Impl : ( ( rule__Type__SuperTypeAssignment_1_1 ) ) ;
    public final void rule__Type__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:315:1: ( ( ( rule__Type__SuperTypeAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:316:1: ( ( rule__Type__SuperTypeAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:316:1: ( ( rule__Type__SuperTypeAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:317:1: ( rule__Type__SuperTypeAssignment_1_1 )
            {
             before(grammarAccess.getTypeAccess().getSuperTypeAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:318:1: ( rule__Type__SuperTypeAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:318:2: rule__Type__SuperTypeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__SuperTypeAssignment_1_1_in_rule__Type__Group_1__1__Impl584);
            rule__Type__SuperTypeAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getSuperTypeAssignment_1_1()); 

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
    // $ANTLR end rule__Type__Group_1__1__Impl


    // $ANTLR start rule__FQN__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:332:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:336:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:337:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0618);
            rule__FQN__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0621);
            rule__FQN__Group__1();
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
    // $ANTLR end rule__FQN__Group__0


    // $ANTLR start rule__FQN__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:344:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:348:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:349:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:349:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:350:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl648); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

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
    // $ANTLR end rule__FQN__Group__0__Impl


    // $ANTLR start rule__FQN__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:361:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:365:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:366:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1677);
            rule__FQN__Group__1__Impl();
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
    // $ANTLR end rule__FQN__Group__1


    // $ANTLR start rule__FQN__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:372:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:376:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:377:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:377:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:378:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:379:1: ( rule__FQN__Group_1__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:379:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl704);
            	    rule__FQN__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

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
    // $ANTLR end rule__FQN__Group__1__Impl


    // $ANTLR start rule__FQN__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:393:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:397:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:398:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0739);
            rule__FQN__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0742);
            rule__FQN__Group_1__1();
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
    // $ANTLR end rule__FQN__Group_1__0


    // $ANTLR start rule__FQN__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:405:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:409:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:410:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:410:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:411:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__FQN__Group_1__0__Impl770); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end rule__FQN__Group_1__0__Impl


    // $ANTLR start rule__FQN__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:424:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:428:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:429:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1801);
            rule__FQN__Group_1__1__Impl();
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
    // $ANTLR end rule__FQN__Group_1__1


    // $ANTLR start rule__FQN__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:435:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:439:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:440:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:440:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:441:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl828); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

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
    // $ANTLR end rule__FQN__Group_1__1__Impl


    // $ANTLR start rule__Model__TypesAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:457:1: rule__Model__TypesAssignment : ( ruleType ) ;
    public final void rule__Model__TypesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:461:1: ( ( ruleType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:462:1: ( ruleType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:462:1: ( ruleType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:463:1: ruleType
            {
             before(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_rule__Model__TypesAssignment866);
            ruleType();
            _fsp--;

             after(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0()); 

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
    // $ANTLR end rule__Model__TypesAssignment


    // $ANTLR start rule__Type__NameAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:472:1: rule__Type__NameAssignment_0 : ( ruleFQN ) ;
    public final void rule__Type__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:476:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:477:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:477:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:478:1: ruleFQN
            {
             before(grammarAccess.getTypeAccess().getNameFQNParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__Type__NameAssignment_0897);
            ruleFQN();
            _fsp--;

             after(grammarAccess.getTypeAccess().getNameFQNParserRuleCall_0_0()); 

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
    // $ANTLR end rule__Type__NameAssignment_0


    // $ANTLR start rule__Type__SuperTypeAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:487:1: rule__Type__SuperTypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__Type__SuperTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:491:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:492:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:492:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:493:1: ruleTypeRef
            {
             before(grammarAccess.getTypeAccess().getSuperTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Type__SuperTypeAssignment_1_1928);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getTypeAccess().getSuperTypeTypeRefParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__Type__SuperTypeAssignment_1_1


    // $ANTLR start rule__TypeRef__TypeAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:502:1: rule__TypeRef__TypeAssignment : ( ( ruleFQN ) ) ;
    public final void rule__TypeRef__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:506:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:507:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:507:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:508:1: ( ruleFQN )
            {
             before(grammarAccess.getTypeRefAccess().getTypeTypeCrossReference_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:509:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:510:1: ruleFQN
            {
             before(grammarAccess.getTypeRefAccess().getTypeTypeFQNParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__TypeRef__TypeAssignment963);
            ruleFQN();
            _fsp--;

             after(grammarAccess.getTypeRefAccess().getTypeTypeFQNParserRuleCall_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getTypeTypeCrossReference_0()); 

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
    // $ANTLR end rule__TypeRef__TypeAssignment


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__TypesAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group__0_in_ruleType155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__TypeAssignment_in_ruleTypeRef215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN242 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__0309 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__Type__Group__1_in_rule__Type__Group__0312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__NameAssignment_0_in_rule__Type__Group__0__Impl339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__1369 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Type__Group__2_in_rule__Type__Group__1372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group_1__0_in_rule__Type__Group__1__Impl399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group__2__Impl_in_rule__Type__Group__2430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Type__Group__2__Impl458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group_1__0__Impl_in_rule__Type__Group_1__0495 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Type__Group_1__1_in_rule__Type__Group_1__0498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Type__Group_1__0__Impl526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group_1__1__Impl_in_rule__Type__Group_1__1557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__SuperTypeAssignment_1_1_in_rule__Type__Group_1__1__Impl584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0618 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl704 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0739 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__FQN__Group_1__0__Impl770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_rule__Model__TypesAssignment866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__Type__NameAssignment_0897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Type__SuperTypeAssignment_1_1928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__TypeRef__TypeAssignment963 = new BitSet(new long[]{0x0000000000000002L});
    }


}
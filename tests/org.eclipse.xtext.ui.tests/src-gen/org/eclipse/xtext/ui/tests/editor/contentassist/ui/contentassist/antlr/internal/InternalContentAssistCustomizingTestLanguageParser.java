package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistCustomizingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistCustomizingTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'extends'", "'.'", "'FQN'"
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


        public InternalContentAssistCustomizingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistCustomizingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistCustomizingTestLanguageParser.tokenNames; }
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




    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:62:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:69:1: ruleModel : ( ( rule__Model__TypesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:73:2: ( ( ( rule__Model__TypesAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:74:1: ( ( rule__Model__TypesAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:74:1: ( ( rule__Model__TypesAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:75:1: ( rule__Model__TypesAssignment )*
            {
             before(grammarAccess.getModelAccess().getTypesAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:76:1: ( rule__Model__TypesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:76:2: rule__Model__TypesAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__TypesAssignment_in_ruleModel94);
            	    rule__Model__TypesAssignment();

            	    state._fsp--;


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleType"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:88:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:89:1: ( ruleType EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:90:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType122);
            ruleType();

            state._fsp--;

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:97:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:101:2: ( ( ( rule__Type__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:102:1: ( ( rule__Type__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:102:1: ( ( rule__Type__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:103:1: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:104:1: ( rule__Type__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:104:2: rule__Type__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__0_in_ruleType155);
            rule__Type__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTypeRef"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:116:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:117:1: ( ruleTypeRef EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:118:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef182);
            ruleTypeRef();

            state._fsp--;

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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:125:1: ruleTypeRef : ( ( rule__TypeRef__TypeAssignment ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:129:2: ( ( ( rule__TypeRef__TypeAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:130:1: ( ( rule__TypeRef__TypeAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:130:1: ( ( rule__TypeRef__TypeAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:131:1: ( rule__TypeRef__TypeAssignment )
            {
             before(grammarAccess.getTypeRefAccess().getTypeAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:132:1: ( rule__TypeRef__TypeAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:132:2: rule__TypeRef__TypeAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__TypeAssignment_in_ruleTypeRef215);
            rule__TypeRef__TypeAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:144:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:145:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:146:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN242);
            ruleFQN();

            state._fsp--;

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:153:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:157:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:158:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:158:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:159:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:160:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:160:2: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0_in_ruleFQN275);
            rule__FQN__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "rule__Type__Alternatives_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:172:1: rule__Type__Alternatives_0 : ( ( ( rule__Type__NameAssignment_0_0 ) ) | ( ( rule__Type__NameAssignment_0_1 ) ) );
    public final void rule__Type__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:176:1: ( ( ( rule__Type__NameAssignment_0_0 ) ) | ( ( rule__Type__NameAssignment_0_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:177:1: ( ( rule__Type__NameAssignment_0_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:177:1: ( ( rule__Type__NameAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:178:1: ( rule__Type__NameAssignment_0_0 )
                    {
                     before(grammarAccess.getTypeAccess().getNameAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:179:1: ( rule__Type__NameAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:179:2: rule__Type__NameAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Type__NameAssignment_0_0_in_rule__Type__Alternatives_0311);
                    rule__Type__NameAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeAccess().getNameAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:183:6: ( ( rule__Type__NameAssignment_0_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:183:6: ( ( rule__Type__NameAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:184:1: ( rule__Type__NameAssignment_0_1 )
                    {
                     before(grammarAccess.getTypeAccess().getNameAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:185:1: ( rule__Type__NameAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:185:2: rule__Type__NameAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Type__NameAssignment_0_1_in_rule__Type__Alternatives_0329);
                    rule__Type__NameAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeAccess().getNameAssignment_0_1()); 

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
    // $ANTLR end "rule__Type__Alternatives_0"


    // $ANTLR start "rule__Type__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:196:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:200:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:201:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__0360);
            rule__Type__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__1_in_rule__Type__Group__0363);
            rule__Type__Group__1();

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
    // $ANTLR end "rule__Type__Group__0"


    // $ANTLR start "rule__Type__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:208:1: rule__Type__Group__0__Impl : ( ( rule__Type__Alternatives_0 ) ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:212:1: ( ( ( rule__Type__Alternatives_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:213:1: ( ( rule__Type__Alternatives_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:213:1: ( ( rule__Type__Alternatives_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:214:1: ( rule__Type__Alternatives_0 )
            {
             before(grammarAccess.getTypeAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:215:1: ( rule__Type__Alternatives_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:215:2: rule__Type__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Alternatives_0_in_rule__Type__Group__0__Impl390);
            rule__Type__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives_0()); 

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
    // $ANTLR end "rule__Type__Group__0__Impl"


    // $ANTLR start "rule__Type__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:225:1: rule__Type__Group__1 : rule__Type__Group__1__Impl rule__Type__Group__2 ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:229:1: ( rule__Type__Group__1__Impl rule__Type__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:230:2: rule__Type__Group__1__Impl rule__Type__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__1420);
            rule__Type__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__2_in_rule__Type__Group__1423);
            rule__Type__Group__2();

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
    // $ANTLR end "rule__Type__Group__1"


    // $ANTLR start "rule__Type__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:237:1: rule__Type__Group__1__Impl : ( ( rule__Type__Group_1__0 )? ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:241:1: ( ( ( rule__Type__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:242:1: ( ( rule__Type__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:242:1: ( ( rule__Type__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:243:1: ( rule__Type__Group_1__0 )?
            {
             before(grammarAccess.getTypeAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:244:1: ( rule__Type__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:244:2: rule__Type__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Type__Group_1__0_in_rule__Type__Group__1__Impl450);
                    rule__Type__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Type__Group__1__Impl"


    // $ANTLR start "rule__Type__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:254:1: rule__Type__Group__2 : rule__Type__Group__2__Impl ;
    public final void rule__Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:258:1: ( rule__Type__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:259:2: rule__Type__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__2__Impl_in_rule__Type__Group__2481);
            rule__Type__Group__2__Impl();

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
    // $ANTLR end "rule__Type__Group__2"


    // $ANTLR start "rule__Type__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:265:1: rule__Type__Group__2__Impl : ( ';' ) ;
    public final void rule__Type__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:269:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:270:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:270:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:271:1: ';'
            {
             before(grammarAccess.getTypeAccess().getSemicolonKeyword_2()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Type__Group__2__Impl509); 
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
    // $ANTLR end "rule__Type__Group__2__Impl"


    // $ANTLR start "rule__Type__Group_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:290:1: rule__Type__Group_1__0 : rule__Type__Group_1__0__Impl rule__Type__Group_1__1 ;
    public final void rule__Type__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:294:1: ( rule__Type__Group_1__0__Impl rule__Type__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:295:2: rule__Type__Group_1__0__Impl rule__Type__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group_1__0__Impl_in_rule__Type__Group_1__0546);
            rule__Type__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group_1__1_in_rule__Type__Group_1__0549);
            rule__Type__Group_1__1();

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
    // $ANTLR end "rule__Type__Group_1__0"


    // $ANTLR start "rule__Type__Group_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:302:1: rule__Type__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__Type__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:306:1: ( ( 'extends' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:307:1: ( 'extends' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:307:1: ( 'extends' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:308:1: 'extends'
            {
             before(grammarAccess.getTypeAccess().getExtendsKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Type__Group_1__0__Impl577); 
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
    // $ANTLR end "rule__Type__Group_1__0__Impl"


    // $ANTLR start "rule__Type__Group_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:321:1: rule__Type__Group_1__1 : rule__Type__Group_1__1__Impl ;
    public final void rule__Type__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:325:1: ( rule__Type__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:326:2: rule__Type__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group_1__1__Impl_in_rule__Type__Group_1__1608);
            rule__Type__Group_1__1__Impl();

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
    // $ANTLR end "rule__Type__Group_1__1"


    // $ANTLR start "rule__Type__Group_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:332:1: rule__Type__Group_1__1__Impl : ( ( rule__Type__SuperTypeAssignment_1_1 ) ) ;
    public final void rule__Type__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:336:1: ( ( ( rule__Type__SuperTypeAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:337:1: ( ( rule__Type__SuperTypeAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:337:1: ( ( rule__Type__SuperTypeAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:338:1: ( rule__Type__SuperTypeAssignment_1_1 )
            {
             before(grammarAccess.getTypeAccess().getSuperTypeAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:339:1: ( rule__Type__SuperTypeAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:339:2: rule__Type__SuperTypeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__SuperTypeAssignment_1_1_in_rule__Type__Group_1__1__Impl635);
            rule__Type__SuperTypeAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__Type__Group_1__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:353:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:357:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:358:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0669);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0672);
            rule__FQN__Group__1();

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
    // $ANTLR end "rule__FQN__Group__0"


    // $ANTLR start "rule__FQN__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:365:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:369:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:370:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:370:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:371:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl699); 
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
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:382:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:386:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:387:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1728);
            rule__FQN__Group__1__Impl();

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
    // $ANTLR end "rule__FQN__Group__1"


    // $ANTLR start "rule__FQN__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:393:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:397:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:398:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:398:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:399:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:400:1: ( rule__FQN__Group_1__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:400:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl755);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "rule__FQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:414:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:418:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:419:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0790);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0793);
            rule__FQN__Group_1__1();

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
    // $ANTLR end "rule__FQN__Group_1__0"


    // $ANTLR start "rule__FQN__Group_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:426:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:430:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:431:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:431:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:432:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__FQN__Group_1__0__Impl821); 
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
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:445:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:449:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:450:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1852);
            rule__FQN__Group_1__1__Impl();

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
    // $ANTLR end "rule__FQN__Group_1__1"


    // $ANTLR start "rule__FQN__Group_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:456:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:460:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:461:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:461:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:462:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl879); 
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
    // $ANTLR end "rule__FQN__Group_1__1__Impl"


    // $ANTLR start "rule__Model__TypesAssignment"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:478:1: rule__Model__TypesAssignment : ( ruleType ) ;
    public final void rule__Model__TypesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:482:1: ( ( ruleType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:483:1: ( ruleType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:483:1: ( ruleType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:484:1: ruleType
            {
             before(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_rule__Model__TypesAssignment917);
            ruleType();

            state._fsp--;

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
    // $ANTLR end "rule__Model__TypesAssignment"


    // $ANTLR start "rule__Type__NameAssignment_0_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:493:1: rule__Type__NameAssignment_0_0 : ( ruleFQN ) ;
    public final void rule__Type__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:497:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:498:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:498:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:499:1: ruleFQN
            {
             before(grammarAccess.getTypeAccess().getNameFQNParserRuleCall_0_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__Type__NameAssignment_0_0948);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getNameFQNParserRuleCall_0_0_0()); 

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
    // $ANTLR end "rule__Type__NameAssignment_0_0"


    // $ANTLR start "rule__Type__NameAssignment_0_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:508:1: rule__Type__NameAssignment_0_1 : ( ( 'FQN' ) ) ;
    public final void rule__Type__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:512:1: ( ( ( 'FQN' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:513:1: ( ( 'FQN' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:513:1: ( ( 'FQN' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:514:1: ( 'FQN' )
            {
             before(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:515:1: ( 'FQN' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:516:1: 'FQN'
            {
             before(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Type__NameAssignment_0_1984); 
             after(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 

            }

             after(grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0()); 

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
    // $ANTLR end "rule__Type__NameAssignment_0_1"


    // $ANTLR start "rule__Type__SuperTypeAssignment_1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:531:1: rule__Type__SuperTypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__Type__SuperTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:535:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:536:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:536:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:537:1: ruleTypeRef
            {
             before(grammarAccess.getTypeAccess().getSuperTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Type__SuperTypeAssignment_1_11023);
            ruleTypeRef();

            state._fsp--;

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
    // $ANTLR end "rule__Type__SuperTypeAssignment_1_1"


    // $ANTLR start "rule__TypeRef__TypeAssignment"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:546:1: rule__TypeRef__TypeAssignment : ( ( ruleFQN ) ) ;
    public final void rule__TypeRef__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:550:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:551:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:551:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:552:1: ( ruleFQN )
            {
             before(grammarAccess.getTypeRefAccess().getTypeTypeCrossReference_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:553:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalContentAssistCustomizingTestLanguage.g:554:1: ruleFQN
            {
             before(grammarAccess.getTypeRefAccess().getTypeTypeFQNParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__TypeRef__TypeAssignment1058);
            ruleFQN();

            state._fsp--;

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
    // $ANTLR end "rule__TypeRef__TypeAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__TypesAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group__0_in_ruleType155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__TypeAssignment_in_ruleTypeRef215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN242 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__NameAssignment_0_0_in_rule__Type__Alternatives_0311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__NameAssignment_0_1_in_rule__Type__Alternatives_0329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__0360 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__Type__Group__1_in_rule__Type__Group__0363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Alternatives_0_in_rule__Type__Group__0__Impl390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__1420 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__Type__Group__2_in_rule__Type__Group__1423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group_1__0_in_rule__Type__Group__1__Impl450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group__2__Impl_in_rule__Type__Group__2481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Type__Group__2__Impl509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group_1__0__Impl_in_rule__Type__Group_1__0546 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Type__Group_1__1_in_rule__Type__Group_1__0549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Type__Group_1__0__Impl577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group_1__1__Impl_in_rule__Type__Group_1__1608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__SuperTypeAssignment_1_1_in_rule__Type__Group_1__1__Impl635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0669 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl755 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0790 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__FQN__Group_1__0__Impl821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_rule__Model__TypesAssignment917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__Type__NameAssignment_0_0948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Type__NameAssignment_0_1984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Type__SuperTypeAssignment_1_11023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__TypeRef__TypeAssignment1058 = new BitSet(new long[]{0x0000000000000002L});
    }


}
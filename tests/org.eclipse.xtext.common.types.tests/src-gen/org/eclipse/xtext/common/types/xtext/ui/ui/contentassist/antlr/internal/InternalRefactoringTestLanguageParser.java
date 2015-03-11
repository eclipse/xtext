package org.eclipse.xtext.common.types.xtext.ui.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.common.types.xtext.ui.services.RefactoringTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRefactoringTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'$'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalRefactoringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRefactoringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRefactoringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g"; }


     
     	private RefactoringTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(RefactoringTestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:62:1: ruleModel EOF
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:69:1: ruleModel : ( ( rule__Model__ReferenceHolderAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:73:2: ( ( ( rule__Model__ReferenceHolderAssignment )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:74:1: ( ( rule__Model__ReferenceHolderAssignment )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:74:1: ( ( rule__Model__ReferenceHolderAssignment )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:75:1: ( rule__Model__ReferenceHolderAssignment )*
            {
             before(grammarAccess.getModelAccess().getReferenceHolderAssignment()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:76:1: ( rule__Model__ReferenceHolderAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:76:2: rule__Model__ReferenceHolderAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ReferenceHolderAssignment_in_ruleModel94);
            	    rule__Model__ReferenceHolderAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getReferenceHolderAssignment()); 

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


    // $ANTLR start "entryRuleReferenceHolder"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:88:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:89:1: ( ruleReferenceHolder EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:90:1: ruleReferenceHolder EOF
            {
             before(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder122);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getReferenceHolderRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceHolder129); 

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
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:97:1: ruleReferenceHolder : ( ( rule__ReferenceHolder__Group__0 ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:101:2: ( ( ( rule__ReferenceHolder__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:102:1: ( ( rule__ReferenceHolder__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:102:1: ( ( rule__ReferenceHolder__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:103:1: ( rule__ReferenceHolder__Group__0 )
            {
             before(grammarAccess.getReferenceHolderAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:104:1: ( rule__ReferenceHolder__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:104:2: rule__ReferenceHolder__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group__0_in_ruleReferenceHolder155);
            rule__ReferenceHolder__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getGroup()); 

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
    // $ANTLR end "ruleReferenceHolder"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:116:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:117:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:118:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN182);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN189); 

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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:125:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:129:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:130:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:130:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:131:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:132:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:132:2: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0_in_ruleFQN215);
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


    // $ANTLR start "rule__ReferenceHolder__Group__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:146:1: rule__ReferenceHolder__Group__0 : rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1 ;
    public final void rule__ReferenceHolder__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:150:1: ( rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:151:2: rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group__0__Impl_in_rule__ReferenceHolder__Group__0249);
            rule__ReferenceHolder__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group__1_in_rule__ReferenceHolder__Group__0252);
            rule__ReferenceHolder__Group__1();

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
    // $ANTLR end "rule__ReferenceHolder__Group__0"


    // $ANTLR start "rule__ReferenceHolder__Group__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:158:1: rule__ReferenceHolder__Group__0__Impl : ( ( rule__ReferenceHolder__NameAssignment_0 ) ) ;
    public final void rule__ReferenceHolder__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:162:1: ( ( ( rule__ReferenceHolder__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:163:1: ( ( rule__ReferenceHolder__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:163:1: ( ( rule__ReferenceHolder__NameAssignment_0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:164:1: ( rule__ReferenceHolder__NameAssignment_0 )
            {
             before(grammarAccess.getReferenceHolderAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:165:1: ( rule__ReferenceHolder__NameAssignment_0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:165:2: rule__ReferenceHolder__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__NameAssignment_0_in_rule__ReferenceHolder__Group__0__Impl279);
            rule__ReferenceHolder__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getNameAssignment_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__Group__0__Impl"


    // $ANTLR start "rule__ReferenceHolder__Group__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:175:1: rule__ReferenceHolder__Group__1 : rule__ReferenceHolder__Group__1__Impl ;
    public final void rule__ReferenceHolder__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:179:1: ( rule__ReferenceHolder__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:180:2: rule__ReferenceHolder__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group__1__Impl_in_rule__ReferenceHolder__Group__1309);
            rule__ReferenceHolder__Group__1__Impl();

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
    // $ANTLR end "rule__ReferenceHolder__Group__1"


    // $ANTLR start "rule__ReferenceHolder__Group__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:186:1: rule__ReferenceHolder__Group__1__Impl : ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) ) ;
    public final void rule__ReferenceHolder__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:190:1: ( ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:191:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:191:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:192:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:193:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:193:2: rule__ReferenceHolder__DefaultReferenceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__DefaultReferenceAssignment_1_in_rule__ReferenceHolder__Group__1__Impl336);
            rule__ReferenceHolder__DefaultReferenceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_1()); 

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
    // $ANTLR end "rule__ReferenceHolder__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:207:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:211:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:212:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0370);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0373);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:219:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:223:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:224:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:224:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:225:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl400); 
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:236:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl rule__FQN__Group__2 ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:240:1: ( rule__FQN__Group__1__Impl rule__FQN__Group__2 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:241:2: rule__FQN__Group__1__Impl rule__FQN__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1429);
            rule__FQN__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__2_in_rule__FQN__Group__1432);
            rule__FQN__Group__2();

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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:248:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:252:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:253:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:253:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:254:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:255:1: ( rule__FQN__Group_1__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:255:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl459);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
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


    // $ANTLR start "rule__FQN__Group__2"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:265:1: rule__FQN__Group__2 : rule__FQN__Group__2__Impl ;
    public final void rule__FQN__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:269:1: ( rule__FQN__Group__2__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:270:2: rule__FQN__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__2__Impl_in_rule__FQN__Group__2490);
            rule__FQN__Group__2__Impl();

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
    // $ANTLR end "rule__FQN__Group__2"


    // $ANTLR start "rule__FQN__Group__2__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:276:1: rule__FQN__Group__2__Impl : ( ( rule__FQN__Group_2__0 )* ) ;
    public final void rule__FQN__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:280:1: ( ( ( rule__FQN__Group_2__0 )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:281:1: ( ( rule__FQN__Group_2__0 )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:281:1: ( ( rule__FQN__Group_2__0 )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:282:1: ( rule__FQN__Group_2__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_2()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:283:1: ( rule__FQN__Group_2__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:283:2: rule__FQN__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_2__0_in_rule__FQN__Group__2__Impl517);
            	    rule__FQN__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_2()); 

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
    // $ANTLR end "rule__FQN__Group__2__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:299:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:303:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:304:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0554);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0557);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:311:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:315:1: ( ( '.' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:316:1: ( '.' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:316:1: ( '.' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:317:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__FQN__Group_1__0__Impl585); 
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:330:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:334:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:335:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1616);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:341:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:345:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:346:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:346:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:347:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl643); 
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


    // $ANTLR start "rule__FQN__Group_2__0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:362:1: rule__FQN__Group_2__0 : rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1 ;
    public final void rule__FQN__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:366:1: ( rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:367:2: rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_2__0__Impl_in_rule__FQN__Group_2__0676);
            rule__FQN__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_2__1_in_rule__FQN__Group_2__0679);
            rule__FQN__Group_2__1();

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
    // $ANTLR end "rule__FQN__Group_2__0"


    // $ANTLR start "rule__FQN__Group_2__0__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:374:1: rule__FQN__Group_2__0__Impl : ( '$' ) ;
    public final void rule__FQN__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:378:1: ( ( '$' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:379:1: ( '$' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:379:1: ( '$' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:380:1: '$'
            {
             before(grammarAccess.getFQNAccess().getDollarSignKeyword_2_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__FQN__Group_2__0__Impl707); 
             after(grammarAccess.getFQNAccess().getDollarSignKeyword_2_0()); 

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
    // $ANTLR end "rule__FQN__Group_2__0__Impl"


    // $ANTLR start "rule__FQN__Group_2__1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:393:1: rule__FQN__Group_2__1 : rule__FQN__Group_2__1__Impl ;
    public final void rule__FQN__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:397:1: ( rule__FQN__Group_2__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:398:2: rule__FQN__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_2__1__Impl_in_rule__FQN__Group_2__1738);
            rule__FQN__Group_2__1__Impl();

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
    // $ANTLR end "rule__FQN__Group_2__1"


    // $ANTLR start "rule__FQN__Group_2__1__Impl"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:404:1: rule__FQN__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:408:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:409:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:409:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:410:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_2__1__Impl765); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_2_1()); 

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
    // $ANTLR end "rule__FQN__Group_2__1__Impl"


    // $ANTLR start "rule__Model__ReferenceHolderAssignment"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:426:1: rule__Model__ReferenceHolderAssignment : ( ruleReferenceHolder ) ;
    public final void rule__Model__ReferenceHolderAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:430:1: ( ( ruleReferenceHolder ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:431:1: ( ruleReferenceHolder )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:431:1: ( ruleReferenceHolder )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:432:1: ruleReferenceHolder
            {
             before(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_rule__Model__ReferenceHolderAssignment803);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__ReferenceHolderAssignment"


    // $ANTLR start "rule__ReferenceHolder__NameAssignment_0"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:441:1: rule__ReferenceHolder__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ReferenceHolder__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:445:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:446:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:446:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:447:1: RULE_ID
            {
             before(grammarAccess.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceHolder__NameAssignment_0834); 
             after(grammarAccess.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__NameAssignment_0"


    // $ANTLR start "rule__ReferenceHolder__DefaultReferenceAssignment_1"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:456:1: rule__ReferenceHolder__DefaultReferenceAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__DefaultReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:460:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:461:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:461:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:462:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:463:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:464:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__ReferenceHolder__DefaultReferenceAssignment_1869);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0()); 

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
    // $ANTLR end "rule__ReferenceHolder__DefaultReferenceAssignment_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ReferenceHolderAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceHolder129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group__0_in_ruleReferenceHolder155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group__0__Impl_in_rule__ReferenceHolder__Group__0249 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group__1_in_rule__ReferenceHolder__Group__0252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__NameAssignment_0_in_rule__ReferenceHolder__Group__0__Impl279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group__1__Impl_in_rule__ReferenceHolder__Group__1309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__DefaultReferenceAssignment_1_in_rule__ReferenceHolder__Group__1__Impl336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0370 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1429 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__FQN__Group__2_in_rule__FQN__Group__1432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl459 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_rule__FQN__Group__2__Impl_in_rule__FQN__Group__2490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_2__0_in_rule__FQN__Group__2__Impl517 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0554 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__FQN__Group_1__0__Impl585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_2__0__Impl_in_rule__FQN__Group_2__0676 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_2__1_in_rule__FQN__Group_2__0679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__FQN__Group_2__0__Impl707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_2__1__Impl_in_rule__FQN__Group_2__1738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_2__1__Impl765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_rule__Model__ReferenceHolderAssignment803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceHolder__NameAssignment_0834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__ReferenceHolder__DefaultReferenceAssignment_1869 = new BitSet(new long[]{0x0000000000000002L});
    }


}
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
import org.eclipse.xtext.common.types.xtext.ui.services.RefactoringTestLanguage2GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRefactoringTestLanguage2Parser extends AbstractInternalContentAssistParser {
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


        public InternalRefactoringTestLanguage2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRefactoringTestLanguage2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRefactoringTestLanguage2Parser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g"; }


     
     	private RefactoringTestLanguage2GrammarAccess grammarAccess;
     	
        public void setGrammarAccess(RefactoringTestLanguage2GrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleEntry"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:60:1: entryRuleEntry : ruleEntry EOF ;
    public final void entryRuleEntry() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:61:1: ( ruleEntry EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:62:1: ruleEntry EOF
            {
             before(grammarAccess.getEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEntry_in_entryRuleEntry61);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getEntryRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntry68); 

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
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:69:1: ruleEntry : ( ruleModel ) ;
    public final void ruleEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:73:2: ( ( ruleModel ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:74:1: ( ruleModel )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:74:1: ( ruleModel )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:75:1: ruleModel
            {
             before(grammarAccess.getEntryAccess().getModelParserRuleCall()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_ruleEntry94);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getEntryAccess().getModelParserRuleCall()); 

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
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:88:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:89:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:90:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel120);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel127); 

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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:97:1: ruleModel : ( ( rule__Model__ReferenceHolderAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:101:2: ( ( ( rule__Model__ReferenceHolderAssignment )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:102:1: ( ( rule__Model__ReferenceHolderAssignment )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:102:1: ( ( rule__Model__ReferenceHolderAssignment )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:103:1: ( rule__Model__ReferenceHolderAssignment )*
            {
             before(grammarAccess.getModelAccess().getReferenceHolderAssignment()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:104:1: ( rule__Model__ReferenceHolderAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:104:2: rule__Model__ReferenceHolderAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ReferenceHolderAssignment_in_ruleModel153);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:116:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:117:1: ( ruleReferenceHolder EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:118:1: ruleReferenceHolder EOF
            {
             before(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder181);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getReferenceHolderRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceHolder188); 

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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:125:1: ruleReferenceHolder : ( ( rule__ReferenceHolder__Group__0 ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:129:2: ( ( ( rule__ReferenceHolder__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:130:1: ( ( rule__ReferenceHolder__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:130:1: ( ( rule__ReferenceHolder__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:131:1: ( rule__ReferenceHolder__Group__0 )
            {
             before(grammarAccess.getReferenceHolderAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:132:1: ( rule__ReferenceHolder__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:132:2: rule__ReferenceHolder__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group__0_in_ruleReferenceHolder214);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:144:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:145:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:146:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN241);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN248); 

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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:153:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:157:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:158:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:158:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:159:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:160:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:160:2: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0_in_ruleFQN274);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:174:1: rule__ReferenceHolder__Group__0 : rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1 ;
    public final void rule__ReferenceHolder__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:178:1: ( rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:179:2: rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group__0__Impl_in_rule__ReferenceHolder__Group__0308);
            rule__ReferenceHolder__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group__1_in_rule__ReferenceHolder__Group__0311);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:186:1: rule__ReferenceHolder__Group__0__Impl : ( ( rule__ReferenceHolder__NameAssignment_0 ) ) ;
    public final void rule__ReferenceHolder__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:190:1: ( ( ( rule__ReferenceHolder__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:191:1: ( ( rule__ReferenceHolder__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:191:1: ( ( rule__ReferenceHolder__NameAssignment_0 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:192:1: ( rule__ReferenceHolder__NameAssignment_0 )
            {
             before(grammarAccess.getReferenceHolderAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:193:1: ( rule__ReferenceHolder__NameAssignment_0 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:193:2: rule__ReferenceHolder__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__NameAssignment_0_in_rule__ReferenceHolder__Group__0__Impl338);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:203:1: rule__ReferenceHolder__Group__1 : rule__ReferenceHolder__Group__1__Impl ;
    public final void rule__ReferenceHolder__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:207:1: ( rule__ReferenceHolder__Group__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:208:2: rule__ReferenceHolder__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__Group__1__Impl_in_rule__ReferenceHolder__Group__1368);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:214:1: rule__ReferenceHolder__Group__1__Impl : ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) ) ;
    public final void rule__ReferenceHolder__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:218:1: ( ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:219:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:219:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:220:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:221:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:221:2: rule__ReferenceHolder__DefaultReferenceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceHolder__DefaultReferenceAssignment_1_in_rule__ReferenceHolder__Group__1__Impl395);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:235:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:239:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:240:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0429);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0432);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:247:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:251:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:252:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:252:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:253:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl459); 
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:264:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl rule__FQN__Group__2 ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:268:1: ( rule__FQN__Group__1__Impl rule__FQN__Group__2 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:269:2: rule__FQN__Group__1__Impl rule__FQN__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1488);
            rule__FQN__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__2_in_rule__FQN__Group__1491);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:276:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:280:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:281:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:281:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:282:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:283:1: ( rule__FQN__Group_1__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:283:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl518);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:293:1: rule__FQN__Group__2 : rule__FQN__Group__2__Impl ;
    public final void rule__FQN__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:297:1: ( rule__FQN__Group__2__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:298:2: rule__FQN__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__2__Impl_in_rule__FQN__Group__2549);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:304:1: rule__FQN__Group__2__Impl : ( ( rule__FQN__Group_2__0 )* ) ;
    public final void rule__FQN__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:308:1: ( ( ( rule__FQN__Group_2__0 )* ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:309:1: ( ( rule__FQN__Group_2__0 )* )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:309:1: ( ( rule__FQN__Group_2__0 )* )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:310:1: ( rule__FQN__Group_2__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_2()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:311:1: ( rule__FQN__Group_2__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:311:2: rule__FQN__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_2__0_in_rule__FQN__Group__2__Impl576);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:327:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:331:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:332:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0613);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0616);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:339:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:343:1: ( ( '.' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:344:1: ( '.' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:344:1: ( '.' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:345:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__FQN__Group_1__0__Impl644); 
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:358:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:362:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:363:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1675);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:369:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:373:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:374:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:374:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:375:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl702); 
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:390:1: rule__FQN__Group_2__0 : rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1 ;
    public final void rule__FQN__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:394:1: ( rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1 )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:395:2: rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_2__0__Impl_in_rule__FQN__Group_2__0735);
            rule__FQN__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_2__1_in_rule__FQN__Group_2__0738);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:402:1: rule__FQN__Group_2__0__Impl : ( '$' ) ;
    public final void rule__FQN__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:406:1: ( ( '$' ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:407:1: ( '$' )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:407:1: ( '$' )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:408:1: '$'
            {
             before(grammarAccess.getFQNAccess().getDollarSignKeyword_2_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__FQN__Group_2__0__Impl766); 
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:421:1: rule__FQN__Group_2__1 : rule__FQN__Group_2__1__Impl ;
    public final void rule__FQN__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:425:1: ( rule__FQN__Group_2__1__Impl )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:426:2: rule__FQN__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_2__1__Impl_in_rule__FQN__Group_2__1797);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:432:1: rule__FQN__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:436:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:437:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:437:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:438:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_2__1__Impl824); 
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:454:1: rule__Model__ReferenceHolderAssignment : ( ruleReferenceHolder ) ;
    public final void rule__Model__ReferenceHolderAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:458:1: ( ( ruleReferenceHolder ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:459:1: ( ruleReferenceHolder )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:459:1: ( ruleReferenceHolder )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:460:1: ruleReferenceHolder
            {
             before(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceHolder_in_rule__Model__ReferenceHolderAssignment862);
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:469:1: rule__ReferenceHolder__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ReferenceHolder__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:473:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:474:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:474:1: ( RULE_ID )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:475:1: RULE_ID
            {
             before(grammarAccess.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceHolder__NameAssignment_0893); 
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
    // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:484:1: rule__ReferenceHolder__DefaultReferenceAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__DefaultReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:488:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:489:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:489:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:490:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0()); 
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:491:1: ( ruleFQN )
            // ../org.eclipse.xtext.common.types.tests/src-gen/org/eclipse/xtext/common/types/xtext/ui/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage2.g:492:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__ReferenceHolder__DefaultReferenceAssignment_1928);
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
        public static final BitSet FOLLOW_ruleEntry_in_entryRuleEntry61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntry68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_ruleEntry94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ReferenceHolderAssignment_in_ruleModel153 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceHolder188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group__0_in_ruleReferenceHolder214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group__0__Impl_in_rule__ReferenceHolder__Group__0308 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group__1_in_rule__ReferenceHolder__Group__0311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__NameAssignment_0_in_rule__ReferenceHolder__Group__0__Impl338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__Group__1__Impl_in_rule__ReferenceHolder__Group__1368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceHolder__DefaultReferenceAssignment_1_in_rule__ReferenceHolder__Group__1__Impl395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0429 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1488 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__FQN__Group__2_in_rule__FQN__Group__1491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl518 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_rule__FQN__Group__2__Impl_in_rule__FQN__Group__2549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_2__0_in_rule__FQN__Group__2__Impl576 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0613 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__FQN__Group_1__0__Impl644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_2__0__Impl_in_rule__FQN__Group_2__0735 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_2__1_in_rule__FQN__Group_2__0738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__FQN__Group_2__0__Impl766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_2__1__Impl_in_rule__FQN__Group_2__1797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_2__1__Impl824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceHolder_in_rule__Model__ReferenceHolderAssignment862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceHolder__NameAssignment_0893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__ReferenceHolder__DefaultReferenceAssignment_1928 = new BitSet(new long[]{0x0000000000000002L});
    }


}
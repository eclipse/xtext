package org.eclipse.xtext.ui.tests.refactoring.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.refactoring.services.ReferringTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReferringTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ref'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalReferringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReferringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReferringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g"; }


     
     	private ReferringTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ReferringTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleMain"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:61:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:62:1: ( ruleMain EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:63:1: ruleMain EOF
            {
             before(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMain_in_entryRuleMain61);
            ruleMain();

            state._fsp--;

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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:70:1: ruleMain : ( ( rule__Main__ReferencedAssignment )* ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:74:2: ( ( ( rule__Main__ReferencedAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:75:1: ( ( rule__Main__ReferencedAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:75:1: ( ( rule__Main__ReferencedAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:76:1: ( rule__Main__ReferencedAssignment )*
            {
             before(grammarAccess.getMainAccess().getReferencedAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:77:1: ( rule__Main__ReferencedAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:77:2: rule__Main__ReferencedAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Main__ReferencedAssignment_in_ruleMain94);
            	    rule__Main__ReferencedAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getReferencedAssignment()); 

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
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleReference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:89:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:90:1: ( ruleReference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:91:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference122);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference129); 

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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:98:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:102:2: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:103:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:103:1: ( ( rule__Reference__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:104:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:105:1: ( rule__Reference__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:105:2: rule__Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__0_in_ruleReference155);
            rule__Reference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

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
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:117:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:118:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:119:1: ruleFQN EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:126:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:130:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:131:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:131:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:132:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:133:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:133:2: rule__FQN__Group__0
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


    // $ANTLR start "rule__Reference__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:147:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:151:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:152:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__0249);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__0252);
            rule__Reference__Group__1();

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
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:159:1: rule__Reference__Group__0__Impl : ( 'ref' ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:163:1: ( ( 'ref' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:164:1: ( 'ref' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:164:1: ( 'ref' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:165:1: 'ref'
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Reference__Group__0__Impl280); 
             after(grammarAccess.getReferenceAccess().getRefKeyword_0()); 

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
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:178:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:182:1: ( rule__Reference__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:183:2: rule__Reference__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__1311);
            rule__Reference__Group__1__Impl();

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
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:189:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__ReferencedAssignment_1 ) ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:193:1: ( ( ( rule__Reference__ReferencedAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:194:1: ( ( rule__Reference__ReferencedAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:194:1: ( ( rule__Reference__ReferencedAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:195:1: ( rule__Reference__ReferencedAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getReferencedAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:196:1: ( rule__Reference__ReferencedAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:196:2: rule__Reference__ReferencedAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Reference__ReferencedAssignment_1_in_rule__Reference__Group__1__Impl338);
            rule__Reference__ReferencedAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getReferencedAssignment_1()); 

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
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:210:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:214:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:215:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0372);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0375);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:222:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:226:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:227:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:227:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:228:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl402); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:239:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:243:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:244:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1431);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:250:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:254:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:255:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:255:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:256:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:257:1: ( rule__FQN__Group_1__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:257:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl458);
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


    // $ANTLR start "rule__FQN__Group_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:271:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:275:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:276:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0493);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0496);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:283:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:287:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:288:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:288:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:289:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__FQN__Group_1__0__Impl524); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:302:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:306:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:307:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1555);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:313:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:317:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:318:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:318:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:319:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl582); 
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


    // $ANTLR start "rule__Main__ReferencedAssignment"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:335:1: rule__Main__ReferencedAssignment : ( ruleReference ) ;
    public final void rule__Main__ReferencedAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:339:1: ( ( ruleReference ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:340:1: ( ruleReference )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:340:1: ( ruleReference )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:341:1: ruleReference
            {
             before(grammarAccess.getMainAccess().getReferencedReferenceParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_rule__Main__ReferencedAssignment620);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getMainAccess().getReferencedReferenceParserRuleCall_0()); 

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
    // $ANTLR end "rule__Main__ReferencedAssignment"


    // $ANTLR start "rule__Reference__ReferencedAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:350:1: rule__Reference__ReferencedAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Reference__ReferencedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:354:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:355:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:355:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:356:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:357:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalReferringTestLanguage.g:358:1: ruleFQN
            {
             before(grammarAccess.getReferenceAccess().getReferencedEObjectFQNParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__Reference__ReferencedAssignment_1655);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getReferencedEObjectFQNParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0()); 

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
    // $ANTLR end "rule__Reference__ReferencedAssignment_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMain_in_entryRuleMain61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMain68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Main__ReferencedAssignment_in_ruleMain94 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__0249 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__0252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Reference__Group__0__Impl280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__1311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Reference__ReferencedAssignment_1_in_rule__Reference__Group__1__Impl338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0372 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl458 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0493 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__FQN__Group_1__0__Impl524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_rule__Main__ReferencedAssignment620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__Reference__ReferencedAssignment_1655 = new BitSet(new long[]{0x0000000000000002L});
    }


}
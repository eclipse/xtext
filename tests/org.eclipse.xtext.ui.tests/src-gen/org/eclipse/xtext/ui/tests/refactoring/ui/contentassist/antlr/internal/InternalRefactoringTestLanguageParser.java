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
import org.eclipse.xtext.ui.tests.refactoring.services.RefactoringTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRefactoringTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'{'", "'}'", "'ref'", "'.'", "'.*'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalRefactoringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRefactoringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRefactoringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g"; }


     
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




    // $ANTLR start "entryRuleMain"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:61:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:62:1: ( ruleMain EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:63:1: ruleMain EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:70:1: ruleMain : ( ( rule__Main__ElementsAssignment )* ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:74:2: ( ( ( rule__Main__ElementsAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:75:1: ( ( rule__Main__ElementsAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:75:1: ( ( rule__Main__ElementsAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:76:1: ( rule__Main__ElementsAssignment )*
            {
             before(grammarAccess.getMainAccess().getElementsAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:77:1: ( rule__Main__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:77:2: rule__Main__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Main__ElementsAssignment_in_ruleMain94);
            	    rule__Main__ElementsAssignment();

            	    state._fsp--;


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
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleAbstractElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:89:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:90:1: ( ruleAbstractElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:91:1: ruleAbstractElement EOF
            {
             before(grammarAccess.getAbstractElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement122);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getAbstractElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractElement129); 

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
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:98:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:102:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:103:1: ( ( rule__AbstractElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:103:1: ( ( rule__AbstractElement__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:104:1: ( rule__AbstractElement__Alternatives )
            {
             before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:105:1: ( rule__AbstractElement__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:105:2: rule__AbstractElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractElement__Alternatives_in_ruleAbstractElement155);
            rule__AbstractElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractElementAccess().getAlternatives()); 

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
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:117:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:118:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:119:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport182);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport189); 

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:126:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:130:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:131:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:131:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:132:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:133:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:133:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0_in_ruleImport215);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:145:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:146:1: ( ruleElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:147:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement242);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement249); 

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:154:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:158:2: ( ( ( rule__Element__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:159:1: ( ( rule__Element__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:159:1: ( ( rule__Element__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:160:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:161:1: ( rule__Element__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:161:2: rule__Element__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0_in_ruleElement275);
            rule__Element__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:173:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:174:1: ( ruleFQN EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:175:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN302);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN309); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:182:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:186:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:187:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:187:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:188:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:189:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:189:2: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0_in_ruleFQN335);
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


    // $ANTLR start "entryRuleFQNWithWC"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:201:1: entryRuleFQNWithWC : ruleFQNWithWC EOF ;
    public final void entryRuleFQNWithWC() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:202:1: ( ruleFQNWithWC EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:203:1: ruleFQNWithWC EOF
            {
             before(grammarAccess.getFQNWithWCRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQNWithWC_in_entryRuleFQNWithWC362);
            ruleFQNWithWC();

            state._fsp--;

             after(grammarAccess.getFQNWithWCRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQNWithWC369); 

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
    // $ANTLR end "entryRuleFQNWithWC"


    // $ANTLR start "ruleFQNWithWC"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:210:1: ruleFQNWithWC : ( ( rule__FQNWithWC__Group__0 ) ) ;
    public final void ruleFQNWithWC() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:214:2: ( ( ( rule__FQNWithWC__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:215:1: ( ( rule__FQNWithWC__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:215:1: ( ( rule__FQNWithWC__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:216:1: ( rule__FQNWithWC__Group__0 )
            {
             before(grammarAccess.getFQNWithWCAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:217:1: ( rule__FQNWithWC__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:217:2: rule__FQNWithWC__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQNWithWC__Group__0_in_ruleFQNWithWC395);
            rule__FQNWithWC__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQNWithWCAccess().getGroup()); 

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
    // $ANTLR end "ruleFQNWithWC"


    // $ANTLR start "rule__AbstractElement__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:229:1: rule__AbstractElement__Alternatives : ( ( ruleElement ) | ( ruleImport ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:233:1: ( ( ruleElement ) | ( ruleImport ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==11) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:234:1: ( ruleElement )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:234:1: ( ruleElement )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:235:1: ruleElement
                    {
                     before(grammarAccess.getAbstractElementAccess().getElementParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__AbstractElement__Alternatives431);
                    ruleElement();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getElementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:240:6: ( ruleImport )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:240:6: ( ruleImport )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:241:1: ruleImport
                    {
                     before(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__AbstractElement__Alternatives448);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_1()); 

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
    // $ANTLR end "rule__AbstractElement__Alternatives"


    // $ANTLR start "rule__Import__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:253:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:257:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:258:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0478);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0481);
            rule__Import__Group__1();

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
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:265:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:269:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:270:1: ( 'import' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:270:1: ( 'import' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:271:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Import__Group__0__Impl509); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

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
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:284:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:288:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:289:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1540);
            rule__Import__Group__1__Impl();

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
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:295:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:299:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:300:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:300:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:301:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:302:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:302:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl567);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 

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
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Element__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:316:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:320:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:321:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__0601);
            rule__Element__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0604);
            rule__Element__Group__1();

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
    // $ANTLR end "rule__Element__Group__0"


    // $ANTLR start "rule__Element__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:328:1: rule__Element__Group__0__Impl : ( ( rule__Element__NameAssignment_0 ) ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:332:1: ( ( ( rule__Element__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:333:1: ( ( rule__Element__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:333:1: ( ( rule__Element__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:334:1: ( rule__Element__NameAssignment_0 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:335:1: ( rule__Element__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:335:2: rule__Element__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__NameAssignment_0_in_rule__Element__Group__0__Impl631);
            rule__Element__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getNameAssignment_0()); 

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
    // $ANTLR end "rule__Element__Group__0__Impl"


    // $ANTLR start "rule__Element__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:345:1: rule__Element__Group__1 : rule__Element__Group__1__Impl ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:349:1: ( rule__Element__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:350:2: rule__Element__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1661);
            rule__Element__Group__1__Impl();

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
    // $ANTLR end "rule__Element__Group__1"


    // $ANTLR start "rule__Element__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:356:1: rule__Element__Group__1__Impl : ( ( rule__Element__Group_1__0 )? ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:360:1: ( ( ( rule__Element__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:361:1: ( ( rule__Element__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:361:1: ( ( rule__Element__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:362:1: ( rule__Element__Group_1__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:363:1: ( rule__Element__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:363:2: rule__Element__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__0_in_rule__Element__Group__1__Impl688);
                    rule__Element__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Element__Group__1__Impl"


    // $ANTLR start "rule__Element__Group_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:377:1: rule__Element__Group_1__0 : rule__Element__Group_1__0__Impl rule__Element__Group_1__1 ;
    public final void rule__Element__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:381:1: ( rule__Element__Group_1__0__Impl rule__Element__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:382:2: rule__Element__Group_1__0__Impl rule__Element__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__0__Impl_in_rule__Element__Group_1__0723);
            rule__Element__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__1_in_rule__Element__Group_1__0726);
            rule__Element__Group_1__1();

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
    // $ANTLR end "rule__Element__Group_1__0"


    // $ANTLR start "rule__Element__Group_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:389:1: rule__Element__Group_1__0__Impl : ( '{' ) ;
    public final void rule__Element__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:393:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:394:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:394:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:395:1: '{'
            {
             before(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Element__Group_1__0__Impl754); 
             after(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1_0()); 

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
    // $ANTLR end "rule__Element__Group_1__0__Impl"


    // $ANTLR start "rule__Element__Group_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:408:1: rule__Element__Group_1__1 : rule__Element__Group_1__1__Impl rule__Element__Group_1__2 ;
    public final void rule__Element__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:412:1: ( rule__Element__Group_1__1__Impl rule__Element__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:413:2: rule__Element__Group_1__1__Impl rule__Element__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__1__Impl_in_rule__Element__Group_1__1785);
            rule__Element__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__2_in_rule__Element__Group_1__1788);
            rule__Element__Group_1__2();

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
    // $ANTLR end "rule__Element__Group_1__1"


    // $ANTLR start "rule__Element__Group_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:420:1: rule__Element__Group_1__1__Impl : ( ( rule__Element__ContainedAssignment_1_1 )* ) ;
    public final void rule__Element__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:424:1: ( ( ( rule__Element__ContainedAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:425:1: ( ( rule__Element__ContainedAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:425:1: ( ( rule__Element__ContainedAssignment_1_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:426:1: ( rule__Element__ContainedAssignment_1_1 )*
            {
             before(grammarAccess.getElementAccess().getContainedAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:427:1: ( rule__Element__ContainedAssignment_1_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:427:2: rule__Element__ContainedAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__ContainedAssignment_1_1_in_rule__Element__Group_1__1__Impl815);
            	    rule__Element__ContainedAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getContainedAssignment_1_1()); 

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
    // $ANTLR end "rule__Element__Group_1__1__Impl"


    // $ANTLR start "rule__Element__Group_1__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:437:1: rule__Element__Group_1__2 : rule__Element__Group_1__2__Impl rule__Element__Group_1__3 ;
    public final void rule__Element__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:441:1: ( rule__Element__Group_1__2__Impl rule__Element__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:442:2: rule__Element__Group_1__2__Impl rule__Element__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__2__Impl_in_rule__Element__Group_1__2846);
            rule__Element__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__3_in_rule__Element__Group_1__2849);
            rule__Element__Group_1__3();

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
    // $ANTLR end "rule__Element__Group_1__2"


    // $ANTLR start "rule__Element__Group_1__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:449:1: rule__Element__Group_1__2__Impl : ( ( rule__Element__Group_1_2__0 )* ) ;
    public final void rule__Element__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:453:1: ( ( ( rule__Element__Group_1_2__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:454:1: ( ( rule__Element__Group_1_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:454:1: ( ( rule__Element__Group_1_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:455:1: ( rule__Element__Group_1_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_1_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:456:1: ( rule__Element__Group_1_2__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:456:2: rule__Element__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1_2__0_in_rule__Element__Group_1__2__Impl876);
            	    rule__Element__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getGroup_1_2()); 

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
    // $ANTLR end "rule__Element__Group_1__2__Impl"


    // $ANTLR start "rule__Element__Group_1__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:466:1: rule__Element__Group_1__3 : rule__Element__Group_1__3__Impl ;
    public final void rule__Element__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:470:1: ( rule__Element__Group_1__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:471:2: rule__Element__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1__3__Impl_in_rule__Element__Group_1__3907);
            rule__Element__Group_1__3__Impl();

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
    // $ANTLR end "rule__Element__Group_1__3"


    // $ANTLR start "rule__Element__Group_1__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:477:1: rule__Element__Group_1__3__Impl : ( '}' ) ;
    public final void rule__Element__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:481:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:482:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:482:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:483:1: '}'
            {
             before(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_1_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Element__Group_1__3__Impl935); 
             after(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_1_3()); 

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
    // $ANTLR end "rule__Element__Group_1__3__Impl"


    // $ANTLR start "rule__Element__Group_1_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:504:1: rule__Element__Group_1_2__0 : rule__Element__Group_1_2__0__Impl rule__Element__Group_1_2__1 ;
    public final void rule__Element__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:508:1: ( rule__Element__Group_1_2__0__Impl rule__Element__Group_1_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:509:2: rule__Element__Group_1_2__0__Impl rule__Element__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1_2__0__Impl_in_rule__Element__Group_1_2__0974);
            rule__Element__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1_2__1_in_rule__Element__Group_1_2__0977);
            rule__Element__Group_1_2__1();

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
    // $ANTLR end "rule__Element__Group_1_2__0"


    // $ANTLR start "rule__Element__Group_1_2__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:516:1: rule__Element__Group_1_2__0__Impl : ( 'ref' ) ;
    public final void rule__Element__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:520:1: ( ( 'ref' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:521:1: ( 'ref' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:521:1: ( 'ref' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:522:1: 'ref'
            {
             before(grammarAccess.getElementAccess().getRefKeyword_1_2_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Element__Group_1_2__0__Impl1005); 
             after(grammarAccess.getElementAccess().getRefKeyword_1_2_0()); 

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
    // $ANTLR end "rule__Element__Group_1_2__0__Impl"


    // $ANTLR start "rule__Element__Group_1_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:535:1: rule__Element__Group_1_2__1 : rule__Element__Group_1_2__1__Impl ;
    public final void rule__Element__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:539:1: ( rule__Element__Group_1_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:540:2: rule__Element__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_1_2__1__Impl_in_rule__Element__Group_1_2__11036);
            rule__Element__Group_1_2__1__Impl();

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
    // $ANTLR end "rule__Element__Group_1_2__1"


    // $ANTLR start "rule__Element__Group_1_2__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:546:1: rule__Element__Group_1_2__1__Impl : ( ( rule__Element__ReferencedAssignment_1_2_1 ) ) ;
    public final void rule__Element__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:550:1: ( ( ( rule__Element__ReferencedAssignment_1_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:551:1: ( ( rule__Element__ReferencedAssignment_1_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:551:1: ( ( rule__Element__ReferencedAssignment_1_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:552:1: ( rule__Element__ReferencedAssignment_1_2_1 )
            {
             before(grammarAccess.getElementAccess().getReferencedAssignment_1_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:553:1: ( rule__Element__ReferencedAssignment_1_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:553:2: rule__Element__ReferencedAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__ReferencedAssignment_1_2_1_in_rule__Element__Group_1_2__1__Impl1063);
            rule__Element__ReferencedAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getReferencedAssignment_1_2_1()); 

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
    // $ANTLR end "rule__Element__Group_1_2__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:567:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:571:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:572:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__01097);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__01100);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:579:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:583:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:584:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:584:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:585:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl1127); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:596:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:600:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:601:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__11156);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:607:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:611:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:612:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:612:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:613:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:614:1: ( rule__FQN__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:614:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl1183);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:628:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:632:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:633:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__01218);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__01221);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:640:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:644:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:645:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:645:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:646:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__FQN__Group_1__0__Impl1249); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:659:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:663:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:664:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__11280);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:670:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:674:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:675:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:675:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:676:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl1307); 
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


    // $ANTLR start "rule__FQNWithWC__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:691:1: rule__FQNWithWC__Group__0 : rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1 ;
    public final void rule__FQNWithWC__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:695:1: ( rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:696:2: rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQNWithWC__Group__0__Impl_in_rule__FQNWithWC__Group__01340);
            rule__FQNWithWC__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__FQNWithWC__Group__1_in_rule__FQNWithWC__Group__01343);
            rule__FQNWithWC__Group__1();

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
    // $ANTLR end "rule__FQNWithWC__Group__0"


    // $ANTLR start "rule__FQNWithWC__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:703:1: rule__FQNWithWC__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__FQNWithWC__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:707:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:708:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:708:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:709:1: ruleFQN
            {
             before(grammarAccess.getFQNWithWCAccess().getFQNParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__FQNWithWC__Group__0__Impl1370);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNWithWCAccess().getFQNParserRuleCall_0()); 

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
    // $ANTLR end "rule__FQNWithWC__Group__0__Impl"


    // $ANTLR start "rule__FQNWithWC__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:720:1: rule__FQNWithWC__Group__1 : rule__FQNWithWC__Group__1__Impl ;
    public final void rule__FQNWithWC__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:724:1: ( rule__FQNWithWC__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:725:2: rule__FQNWithWC__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FQNWithWC__Group__1__Impl_in_rule__FQNWithWC__Group__11399);
            rule__FQNWithWC__Group__1__Impl();

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
    // $ANTLR end "rule__FQNWithWC__Group__1"


    // $ANTLR start "rule__FQNWithWC__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:731:1: rule__FQNWithWC__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__FQNWithWC__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:735:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:736:1: ( ( '.*' )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:736:1: ( ( '.*' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:737:1: ( '.*' )?
            {
             before(grammarAccess.getFQNWithWCAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:738:1: ( '.*' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:739:2: '.*'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__FQNWithWC__Group__1__Impl1428); 

                    }
                    break;

            }

             after(grammarAccess.getFQNWithWCAccess().getFullStopAsteriskKeyword_1()); 

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
    // $ANTLR end "rule__FQNWithWC__Group__1__Impl"


    // $ANTLR start "rule__Main__ElementsAssignment"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:755:1: rule__Main__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__Main__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:759:1: ( ( ruleAbstractElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:760:1: ( ruleAbstractElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:760:1: ( ruleAbstractElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:761:1: ruleAbstractElement
            {
             before(grammarAccess.getMainAccess().getElementsAbstractElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractElement_in_rule__Main__ElementsAssignment1470);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getMainAccess().getElementsAbstractElementParserRuleCall_0()); 

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
    // $ANTLR end "rule__Main__ElementsAssignment"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:770:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleFQNWithWC ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:774:1: ( ( ruleFQNWithWC ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:775:1: ( ruleFQNWithWC )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:775:1: ( ruleFQNWithWC )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:776:1: ruleFQNWithWC
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceFQNWithWCParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQNWithWC_in_rule__Import__ImportedNamespaceAssignment_11501);
            ruleFQNWithWC();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceFQNWithWCParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__Element__NameAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:785:1: rule__Element__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:789:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:790:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:790:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:791:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__NameAssignment_01532); 
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
    // $ANTLR end "rule__Element__NameAssignment_0"


    // $ANTLR start "rule__Element__ContainedAssignment_1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:800:1: rule__Element__ContainedAssignment_1_1 : ( ruleElement ) ;
    public final void rule__Element__ContainedAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:804:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:805:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:805:1: ( ruleElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:806:1: ruleElement
            {
             before(grammarAccess.getElementAccess().getContainedElementParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__Element__ContainedAssignment_1_11563);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementAccess().getContainedElementParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Element__ContainedAssignment_1_1"


    // $ANTLR start "rule__Element__ReferencedAssignment_1_2_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:815:1: rule__Element__ReferencedAssignment_1_2_1 : ( ( ruleFQN ) ) ;
    public final void rule__Element__ReferencedAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:819:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:820:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:820:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:821:1: ( ruleFQN )
            {
             before(grammarAccess.getElementAccess().getReferencedElementCrossReference_1_2_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:822:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/ui/contentassist/antlr/internal/InternalRefactoringTestLanguage.g:823:1: ruleFQN
            {
             before(grammarAccess.getElementAccess().getReferencedElementFQNParserRuleCall_1_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_rule__Element__ReferencedAssignment_1_2_11598);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getElementAccess().getReferencedElementFQNParserRuleCall_1_2_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getReferencedElementCrossReference_1_2_1_0()); 

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
    // $ANTLR end "rule__Element__ReferencedAssignment_1_2_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMain_in_entryRuleMain61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMain68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Main__ElementsAssignment_in_ruleMain94 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractElement129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractElement__Alternatives_in_ruleAbstractElement155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement242 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0_in_ruleElement275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN302 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQNWithWC_in_entryRuleFQNWithWC362 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQNWithWC369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQNWithWC__Group__0_in_ruleFQNWithWC395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__AbstractElement__Alternatives431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__AbstractElement__Alternatives448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0478 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Import__Group__0__Impl509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__0601 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Element__Group__1_in_rule__Element__Group__0604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__NameAssignment_0_in_rule__Element__Group__0__Impl631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__1661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_1__0_in_rule__Element__Group__1__Impl688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_1__0__Impl_in_rule__Element__Group_1__0723 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_rule__Element__Group_1__1_in_rule__Element__Group_1__0726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Element__Group_1__0__Impl754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_1__1__Impl_in_rule__Element__Group_1__1785 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_rule__Element__Group_1__2_in_rule__Element__Group_1__1788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__ContainedAssignment_1_1_in_rule__Element__Group_1__1__Impl815 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Element__Group_1__2__Impl_in_rule__Element__Group_1__2846 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_rule__Element__Group_1__3_in_rule__Element__Group_1__2849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_1_2__0_in_rule__Element__Group_1__2__Impl876 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__Element__Group_1__3__Impl_in_rule__Element__Group_1__3907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Element__Group_1__3__Impl935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_1_2__0__Impl_in_rule__Element__Group_1_2__0974 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Element__Group_1_2__1_in_rule__Element__Group_1_2__0977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Element__Group_1_2__0__Impl1005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_1_2__1__Impl_in_rule__Element__Group_1_2__11036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__ReferencedAssignment_1_2_1_in_rule__Element__Group_1_2__1__Impl1063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__01097 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__01100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl1127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__11156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl1183 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__01218 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__01221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__FQN__Group_1__0__Impl1249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__11280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl1307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQNWithWC__Group__0__Impl_in_rule__FQNWithWC__Group__01340 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__FQNWithWC__Group__1_in_rule__FQNWithWC__Group__01343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__FQNWithWC__Group__0__Impl1370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FQNWithWC__Group__1__Impl_in_rule__FQNWithWC__Group__11399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__FQNWithWC__Group__1__Impl1428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractElement_in_rule__Main__ElementsAssignment1470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQNWithWC_in_rule__Import__ImportedNamespaceAssignment_11501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__NameAssignment_01532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__Element__ContainedAssignment_1_11563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_rule__Element__ReferencedAssignment_1_2_11598 = new BitSet(new long[]{0x0000000000000002L});
    }


}
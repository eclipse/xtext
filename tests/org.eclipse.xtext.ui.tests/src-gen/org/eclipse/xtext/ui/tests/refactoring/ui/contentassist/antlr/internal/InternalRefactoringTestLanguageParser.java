package org.eclipse.xtext.ui.tests.refactoring.ui.contentassist.antlr.internal; 

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
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
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


        public InternalRefactoringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRefactoringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRefactoringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRefactoringTestLanguage.g"; }


     
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
    // InternalRefactoringTestLanguage.g:60:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:61:1: ( ruleMain EOF )
            // InternalRefactoringTestLanguage.g:62:1: ruleMain EOF
            {
             before(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMain();

            state._fsp--;

             after(grammarAccess.getMainRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalRefactoringTestLanguage.g:69:1: ruleMain : ( ( rule__Main__ElementsAssignment )* ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:73:2: ( ( ( rule__Main__ElementsAssignment )* ) )
            // InternalRefactoringTestLanguage.g:74:1: ( ( rule__Main__ElementsAssignment )* )
            {
            // InternalRefactoringTestLanguage.g:74:1: ( ( rule__Main__ElementsAssignment )* )
            // InternalRefactoringTestLanguage.g:75:1: ( rule__Main__ElementsAssignment )*
            {
             before(grammarAccess.getMainAccess().getElementsAssignment()); 
            // InternalRefactoringTestLanguage.g:76:1: ( rule__Main__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:76:2: rule__Main__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
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
    // InternalRefactoringTestLanguage.g:88:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:89:1: ( ruleAbstractElement EOF )
            // InternalRefactoringTestLanguage.g:90:1: ruleAbstractElement EOF
            {
             before(grammarAccess.getAbstractElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getAbstractElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalRefactoringTestLanguage.g:97:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:101:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // InternalRefactoringTestLanguage.g:102:1: ( ( rule__AbstractElement__Alternatives ) )
            {
            // InternalRefactoringTestLanguage.g:102:1: ( ( rule__AbstractElement__Alternatives ) )
            // InternalRefactoringTestLanguage.g:103:1: ( rule__AbstractElement__Alternatives )
            {
             before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            // InternalRefactoringTestLanguage.g:104:1: ( rule__AbstractElement__Alternatives )
            // InternalRefactoringTestLanguage.g:104:2: rule__AbstractElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:116:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:117:1: ( ruleImport EOF )
            // InternalRefactoringTestLanguage.g:118:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalRefactoringTestLanguage.g:125:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:129:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:130:1: ( ( rule__Import__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:130:1: ( ( rule__Import__Group__0 ) )
            // InternalRefactoringTestLanguage.g:131:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:132:1: ( rule__Import__Group__0 )
            // InternalRefactoringTestLanguage.g:132:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:144:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:145:1: ( ruleElement EOF )
            // InternalRefactoringTestLanguage.g:146:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalRefactoringTestLanguage.g:153:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:157:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:158:1: ( ( rule__Element__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:158:1: ( ( rule__Element__Group__0 ) )
            // InternalRefactoringTestLanguage.g:159:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:160:1: ( rule__Element__Group__0 )
            // InternalRefactoringTestLanguage.g:160:2: rule__Element__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:172:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:173:1: ( ruleFQN EOF )
            // InternalRefactoringTestLanguage.g:174:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalRefactoringTestLanguage.g:181:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:185:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:186:1: ( ( rule__FQN__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:186:1: ( ( rule__FQN__Group__0 ) )
            // InternalRefactoringTestLanguage.g:187:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:188:1: ( rule__FQN__Group__0 )
            // InternalRefactoringTestLanguage.g:188:2: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:200:1: entryRuleFQNWithWC : ruleFQNWithWC EOF ;
    public final void entryRuleFQNWithWC() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:201:1: ( ruleFQNWithWC EOF )
            // InternalRefactoringTestLanguage.g:202:1: ruleFQNWithWC EOF
            {
             before(grammarAccess.getFQNWithWCRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQNWithWC();

            state._fsp--;

             after(grammarAccess.getFQNWithWCRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalRefactoringTestLanguage.g:209:1: ruleFQNWithWC : ( ( rule__FQNWithWC__Group__0 ) ) ;
    public final void ruleFQNWithWC() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:213:2: ( ( ( rule__FQNWithWC__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:214:1: ( ( rule__FQNWithWC__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:214:1: ( ( rule__FQNWithWC__Group__0 ) )
            // InternalRefactoringTestLanguage.g:215:1: ( rule__FQNWithWC__Group__0 )
            {
             before(grammarAccess.getFQNWithWCAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:216:1: ( rule__FQNWithWC__Group__0 )
            // InternalRefactoringTestLanguage.g:216:2: rule__FQNWithWC__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:228:1: rule__AbstractElement__Alternatives : ( ( ruleElement ) | ( ruleImport ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:232:1: ( ( ruleElement ) | ( ruleImport ) )
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
                    // InternalRefactoringTestLanguage.g:233:1: ( ruleElement )
                    {
                    // InternalRefactoringTestLanguage.g:233:1: ( ruleElement )
                    // InternalRefactoringTestLanguage.g:234:1: ruleElement
                    {
                     before(grammarAccess.getAbstractElementAccess().getElementParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleElement();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getElementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRefactoringTestLanguage.g:239:6: ( ruleImport )
                    {
                    // InternalRefactoringTestLanguage.g:239:6: ( ruleImport )
                    // InternalRefactoringTestLanguage.g:240:1: ruleImport
                    {
                     before(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "rule__Element__Alternatives_1_1"
    // InternalRefactoringTestLanguage.g:250:1: rule__Element__Alternatives_1_1 : ( ( ( rule__Element__ContainedAssignment_1_1_0 ) ) | ( ( rule__Element__Group_1_1_1__0 ) ) );
    public final void rule__Element__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:254:1: ( ( ( rule__Element__ContainedAssignment_1_1_0 ) ) | ( ( rule__Element__Group_1_1_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalRefactoringTestLanguage.g:255:1: ( ( rule__Element__ContainedAssignment_1_1_0 ) )
                    {
                    // InternalRefactoringTestLanguage.g:255:1: ( ( rule__Element__ContainedAssignment_1_1_0 ) )
                    // InternalRefactoringTestLanguage.g:256:1: ( rule__Element__ContainedAssignment_1_1_0 )
                    {
                     before(grammarAccess.getElementAccess().getContainedAssignment_1_1_0()); 
                    // InternalRefactoringTestLanguage.g:257:1: ( rule__Element__ContainedAssignment_1_1_0 )
                    // InternalRefactoringTestLanguage.g:257:2: rule__Element__ContainedAssignment_1_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Element__ContainedAssignment_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getElementAccess().getContainedAssignment_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRefactoringTestLanguage.g:261:6: ( ( rule__Element__Group_1_1_1__0 ) )
                    {
                    // InternalRefactoringTestLanguage.g:261:6: ( ( rule__Element__Group_1_1_1__0 ) )
                    // InternalRefactoringTestLanguage.g:262:1: ( rule__Element__Group_1_1_1__0 )
                    {
                     before(grammarAccess.getElementAccess().getGroup_1_1_1()); 
                    // InternalRefactoringTestLanguage.g:263:1: ( rule__Element__Group_1_1_1__0 )
                    // InternalRefactoringTestLanguage.g:263:2: rule__Element__Group_1_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Element__Group_1_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getElementAccess().getGroup_1_1_1()); 

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
    // $ANTLR end "rule__Element__Alternatives_1_1"


    // $ANTLR start "rule__Import__Group__0"
    // InternalRefactoringTestLanguage.g:274:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:278:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalRefactoringTestLanguage.g:279:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:286:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:290:1: ( ( 'import' ) )
            // InternalRefactoringTestLanguage.g:291:1: ( 'import' )
            {
            // InternalRefactoringTestLanguage.g:291:1: ( 'import' )
            // InternalRefactoringTestLanguage.g:292:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
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
    // InternalRefactoringTestLanguage.g:305:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:309:1: ( rule__Import__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:310:2: rule__Import__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:316:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:320:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalRefactoringTestLanguage.g:321:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalRefactoringTestLanguage.g:321:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalRefactoringTestLanguage.g:322:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalRefactoringTestLanguage.g:323:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalRefactoringTestLanguage.g:323:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:337:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:341:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalRefactoringTestLanguage.g:342:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Element__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:349:1: rule__Element__Group__0__Impl : ( ( rule__Element__NameAssignment_0 ) ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:353:1: ( ( ( rule__Element__NameAssignment_0 ) ) )
            // InternalRefactoringTestLanguage.g:354:1: ( ( rule__Element__NameAssignment_0 ) )
            {
            // InternalRefactoringTestLanguage.g:354:1: ( ( rule__Element__NameAssignment_0 ) )
            // InternalRefactoringTestLanguage.g:355:1: ( rule__Element__NameAssignment_0 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_0()); 
            // InternalRefactoringTestLanguage.g:356:1: ( rule__Element__NameAssignment_0 )
            // InternalRefactoringTestLanguage.g:356:2: rule__Element__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:366:1: rule__Element__Group__1 : rule__Element__Group__1__Impl ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:370:1: ( rule__Element__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:371:2: rule__Element__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:377:1: rule__Element__Group__1__Impl : ( ( rule__Element__Group_1__0 )? ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:381:1: ( ( ( rule__Element__Group_1__0 )? ) )
            // InternalRefactoringTestLanguage.g:382:1: ( ( rule__Element__Group_1__0 )? )
            {
            // InternalRefactoringTestLanguage.g:382:1: ( ( rule__Element__Group_1__0 )? )
            // InternalRefactoringTestLanguage.g:383:1: ( rule__Element__Group_1__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_1()); 
            // InternalRefactoringTestLanguage.g:384:1: ( rule__Element__Group_1__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRefactoringTestLanguage.g:384:2: rule__Element__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:398:1: rule__Element__Group_1__0 : rule__Element__Group_1__0__Impl rule__Element__Group_1__1 ;
    public final void rule__Element__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:402:1: ( rule__Element__Group_1__0__Impl rule__Element__Group_1__1 )
            // InternalRefactoringTestLanguage.g:403:2: rule__Element__Group_1__0__Impl rule__Element__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Element__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:410:1: rule__Element__Group_1__0__Impl : ( '{' ) ;
    public final void rule__Element__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:414:1: ( ( '{' ) )
            // InternalRefactoringTestLanguage.g:415:1: ( '{' )
            {
            // InternalRefactoringTestLanguage.g:415:1: ( '{' )
            // InternalRefactoringTestLanguage.g:416:1: '{'
            {
             before(grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
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
    // InternalRefactoringTestLanguage.g:429:1: rule__Element__Group_1__1 : rule__Element__Group_1__1__Impl rule__Element__Group_1__2 ;
    public final void rule__Element__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:433:1: ( rule__Element__Group_1__1__Impl rule__Element__Group_1__2 )
            // InternalRefactoringTestLanguage.g:434:2: rule__Element__Group_1__1__Impl rule__Element__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Element__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:441:1: rule__Element__Group_1__1__Impl : ( ( rule__Element__Alternatives_1_1 )* ) ;
    public final void rule__Element__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:445:1: ( ( ( rule__Element__Alternatives_1_1 )* ) )
            // InternalRefactoringTestLanguage.g:446:1: ( ( rule__Element__Alternatives_1_1 )* )
            {
            // InternalRefactoringTestLanguage.g:446:1: ( ( rule__Element__Alternatives_1_1 )* )
            // InternalRefactoringTestLanguage.g:447:1: ( rule__Element__Alternatives_1_1 )*
            {
             before(grammarAccess.getElementAccess().getAlternatives_1_1()); 
            // InternalRefactoringTestLanguage.g:448:1: ( rule__Element__Alternatives_1_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:448:2: rule__Element__Alternatives_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Element__Alternatives_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getAlternatives_1_1()); 

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
    // InternalRefactoringTestLanguage.g:458:1: rule__Element__Group_1__2 : rule__Element__Group_1__2__Impl ;
    public final void rule__Element__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:462:1: ( rule__Element__Group_1__2__Impl )
            // InternalRefactoringTestLanguage.g:463:2: rule__Element__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1__2__Impl();

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
    // InternalRefactoringTestLanguage.g:469:1: rule__Element__Group_1__2__Impl : ( '}' ) ;
    public final void rule__Element__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:473:1: ( ( '}' ) )
            // InternalRefactoringTestLanguage.g:474:1: ( '}' )
            {
            // InternalRefactoringTestLanguage.g:474:1: ( '}' )
            // InternalRefactoringTestLanguage.g:475:1: '}'
            {
             before(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRightCurlyBracketKeyword_1_2()); 

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


    // $ANTLR start "rule__Element__Group_1_1_1__0"
    // InternalRefactoringTestLanguage.g:494:1: rule__Element__Group_1_1_1__0 : rule__Element__Group_1_1_1__0__Impl rule__Element__Group_1_1_1__1 ;
    public final void rule__Element__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:498:1: ( rule__Element__Group_1_1_1__0__Impl rule__Element__Group_1_1_1__1 )
            // InternalRefactoringTestLanguage.g:499:2: rule__Element__Group_1_1_1__0__Impl rule__Element__Group_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Element__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1_1_1__1();

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
    // $ANTLR end "rule__Element__Group_1_1_1__0"


    // $ANTLR start "rule__Element__Group_1_1_1__0__Impl"
    // InternalRefactoringTestLanguage.g:506:1: rule__Element__Group_1_1_1__0__Impl : ( 'ref' ) ;
    public final void rule__Element__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:510:1: ( ( 'ref' ) )
            // InternalRefactoringTestLanguage.g:511:1: ( 'ref' )
            {
            // InternalRefactoringTestLanguage.g:511:1: ( 'ref' )
            // InternalRefactoringTestLanguage.g:512:1: 'ref'
            {
             before(grammarAccess.getElementAccess().getRefKeyword_1_1_1_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRefKeyword_1_1_1_0()); 

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
    // $ANTLR end "rule__Element__Group_1_1_1__0__Impl"


    // $ANTLR start "rule__Element__Group_1_1_1__1"
    // InternalRefactoringTestLanguage.g:525:1: rule__Element__Group_1_1_1__1 : rule__Element__Group_1_1_1__1__Impl ;
    public final void rule__Element__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:529:1: ( rule__Element__Group_1_1_1__1__Impl )
            // InternalRefactoringTestLanguage.g:530:2: rule__Element__Group_1_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__Group_1_1_1__1__Impl();

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
    // $ANTLR end "rule__Element__Group_1_1_1__1"


    // $ANTLR start "rule__Element__Group_1_1_1__1__Impl"
    // InternalRefactoringTestLanguage.g:536:1: rule__Element__Group_1_1_1__1__Impl : ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) ) ;
    public final void rule__Element__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:540:1: ( ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) ) )
            // InternalRefactoringTestLanguage.g:541:1: ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) )
            {
            // InternalRefactoringTestLanguage.g:541:1: ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) )
            // InternalRefactoringTestLanguage.g:542:1: ( rule__Element__ReferencedAssignment_1_1_1_1 )
            {
             before(grammarAccess.getElementAccess().getReferencedAssignment_1_1_1_1()); 
            // InternalRefactoringTestLanguage.g:543:1: ( rule__Element__ReferencedAssignment_1_1_1_1 )
            // InternalRefactoringTestLanguage.g:543:2: rule__Element__ReferencedAssignment_1_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Element__ReferencedAssignment_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getReferencedAssignment_1_1_1_1()); 

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
    // $ANTLR end "rule__Element__Group_1_1_1__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalRefactoringTestLanguage.g:557:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:561:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalRefactoringTestLanguage.g:562:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:569:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:573:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:574:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:574:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:575:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalRefactoringTestLanguage.g:586:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:590:1: ( rule__FQN__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:591:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:597:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:601:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalRefactoringTestLanguage.g:602:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalRefactoringTestLanguage.g:602:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalRefactoringTestLanguage.g:603:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalRefactoringTestLanguage.g:604:1: ( rule__FQN__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:604:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
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
    // InternalRefactoringTestLanguage.g:618:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:622:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalRefactoringTestLanguage.g:623:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:630:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:634:1: ( ( '.' ) )
            // InternalRefactoringTestLanguage.g:635:1: ( '.' )
            {
            // InternalRefactoringTestLanguage.g:635:1: ( '.' )
            // InternalRefactoringTestLanguage.g:636:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
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
    // InternalRefactoringTestLanguage.g:649:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:653:1: ( rule__FQN__Group_1__1__Impl )
            // InternalRefactoringTestLanguage.g:654:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:660:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:664:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:665:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:665:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:666:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalRefactoringTestLanguage.g:681:1: rule__FQNWithWC__Group__0 : rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1 ;
    public final void rule__FQNWithWC__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:685:1: ( rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1 )
            // InternalRefactoringTestLanguage.g:686:2: rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__FQNWithWC__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:693:1: rule__FQNWithWC__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__FQNWithWC__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:697:1: ( ( ruleFQN ) )
            // InternalRefactoringTestLanguage.g:698:1: ( ruleFQN )
            {
            // InternalRefactoringTestLanguage.g:698:1: ( ruleFQN )
            // InternalRefactoringTestLanguage.g:699:1: ruleFQN
            {
             before(grammarAccess.getFQNWithWCAccess().getFQNParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:710:1: rule__FQNWithWC__Group__1 : rule__FQNWithWC__Group__1__Impl ;
    public final void rule__FQNWithWC__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:714:1: ( rule__FQNWithWC__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:715:2: rule__FQNWithWC__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:721:1: rule__FQNWithWC__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__FQNWithWC__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:725:1: ( ( ( '.*' )? ) )
            // InternalRefactoringTestLanguage.g:726:1: ( ( '.*' )? )
            {
            // InternalRefactoringTestLanguage.g:726:1: ( ( '.*' )? )
            // InternalRefactoringTestLanguage.g:727:1: ( '.*' )?
            {
             before(grammarAccess.getFQNWithWCAccess().getFullStopAsteriskKeyword_1()); 
            // InternalRefactoringTestLanguage.g:728:1: ( '.*' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalRefactoringTestLanguage.g:729:2: '.*'
                    {
                    match(input,16,FollowSets000.FOLLOW_2); 

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
    // InternalRefactoringTestLanguage.g:745:1: rule__Main__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__Main__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:749:1: ( ( ruleAbstractElement ) )
            // InternalRefactoringTestLanguage.g:750:1: ( ruleAbstractElement )
            {
            // InternalRefactoringTestLanguage.g:750:1: ( ruleAbstractElement )
            // InternalRefactoringTestLanguage.g:751:1: ruleAbstractElement
            {
             before(grammarAccess.getMainAccess().getElementsAbstractElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:760:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleFQNWithWC ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:764:1: ( ( ruleFQNWithWC ) )
            // InternalRefactoringTestLanguage.g:765:1: ( ruleFQNWithWC )
            {
            // InternalRefactoringTestLanguage.g:765:1: ( ruleFQNWithWC )
            // InternalRefactoringTestLanguage.g:766:1: ruleFQNWithWC
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceFQNWithWCParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:775:1: rule__Element__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:779:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:780:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:780:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:781:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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


    // $ANTLR start "rule__Element__ContainedAssignment_1_1_0"
    // InternalRefactoringTestLanguage.g:790:1: rule__Element__ContainedAssignment_1_1_0 : ( ruleElement ) ;
    public final void rule__Element__ContainedAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:794:1: ( ( ruleElement ) )
            // InternalRefactoringTestLanguage.g:795:1: ( ruleElement )
            {
            // InternalRefactoringTestLanguage.g:795:1: ( ruleElement )
            // InternalRefactoringTestLanguage.g:796:1: ruleElement
            {
             before(grammarAccess.getElementAccess().getContainedElementParserRuleCall_1_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementAccess().getContainedElementParserRuleCall_1_1_0_0()); 

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
    // $ANTLR end "rule__Element__ContainedAssignment_1_1_0"


    // $ANTLR start "rule__Element__ReferencedAssignment_1_1_1_1"
    // InternalRefactoringTestLanguage.g:805:1: rule__Element__ReferencedAssignment_1_1_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__Element__ReferencedAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:809:1: ( ( ( ruleFQN ) ) )
            // InternalRefactoringTestLanguage.g:810:1: ( ( ruleFQN ) )
            {
            // InternalRefactoringTestLanguage.g:810:1: ( ( ruleFQN ) )
            // InternalRefactoringTestLanguage.g:811:1: ( ruleFQN )
            {
             before(grammarAccess.getElementAccess().getReferencedElementCrossReference_1_1_1_1_0()); 
            // InternalRefactoringTestLanguage.g:812:1: ( ruleFQN )
            // InternalRefactoringTestLanguage.g:813:1: ruleFQN
            {
             before(grammarAccess.getElementAccess().getReferencedElementFQNParserRuleCall_1_1_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getElementAccess().getReferencedElementFQNParserRuleCall_1_1_1_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getReferencedElementCrossReference_1_1_1_1_0()); 

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
    // $ANTLR end "rule__Element__ReferencedAssignment_1_1_1_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    }


}
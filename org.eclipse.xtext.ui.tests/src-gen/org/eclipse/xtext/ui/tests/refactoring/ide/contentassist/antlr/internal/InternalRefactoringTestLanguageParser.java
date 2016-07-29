package org.eclipse.xtext.ui.tests.refactoring.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
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
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

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
    // InternalRefactoringTestLanguage.g:53:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:54:1: ( ruleMain EOF )
            // InternalRefactoringTestLanguage.g:55:1: ruleMain EOF
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
    // InternalRefactoringTestLanguage.g:62:1: ruleMain : ( ( rule__Main__ElementsAssignment )* ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:66:2: ( ( ( rule__Main__ElementsAssignment )* ) )
            // InternalRefactoringTestLanguage.g:67:2: ( ( rule__Main__ElementsAssignment )* )
            {
            // InternalRefactoringTestLanguage.g:67:2: ( ( rule__Main__ElementsAssignment )* )
            // InternalRefactoringTestLanguage.g:68:3: ( rule__Main__ElementsAssignment )*
            {
             before(grammarAccess.getMainAccess().getElementsAssignment()); 
            // InternalRefactoringTestLanguage.g:69:3: ( rule__Main__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:69:4: rule__Main__ElementsAssignment
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
    // InternalRefactoringTestLanguage.g:78:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:79:1: ( ruleAbstractElement EOF )
            // InternalRefactoringTestLanguage.g:80:1: ruleAbstractElement EOF
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
    // InternalRefactoringTestLanguage.g:87:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:91:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // InternalRefactoringTestLanguage.g:92:2: ( ( rule__AbstractElement__Alternatives ) )
            {
            // InternalRefactoringTestLanguage.g:92:2: ( ( rule__AbstractElement__Alternatives ) )
            // InternalRefactoringTestLanguage.g:93:3: ( rule__AbstractElement__Alternatives )
            {
             before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            // InternalRefactoringTestLanguage.g:94:3: ( rule__AbstractElement__Alternatives )
            // InternalRefactoringTestLanguage.g:94:4: rule__AbstractElement__Alternatives
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
    // InternalRefactoringTestLanguage.g:103:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:104:1: ( ruleImport EOF )
            // InternalRefactoringTestLanguage.g:105:1: ruleImport EOF
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
    // InternalRefactoringTestLanguage.g:112:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:116:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:117:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:117:2: ( ( rule__Import__Group__0 ) )
            // InternalRefactoringTestLanguage.g:118:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:119:3: ( rule__Import__Group__0 )
            // InternalRefactoringTestLanguage.g:119:4: rule__Import__Group__0
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
    // InternalRefactoringTestLanguage.g:128:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:129:1: ( ruleElement EOF )
            // InternalRefactoringTestLanguage.g:130:1: ruleElement EOF
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
    // InternalRefactoringTestLanguage.g:137:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:141:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:142:2: ( ( rule__Element__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:142:2: ( ( rule__Element__Group__0 ) )
            // InternalRefactoringTestLanguage.g:143:3: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:144:3: ( rule__Element__Group__0 )
            // InternalRefactoringTestLanguage.g:144:4: rule__Element__Group__0
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
    // InternalRefactoringTestLanguage.g:153:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:154:1: ( ruleFQN EOF )
            // InternalRefactoringTestLanguage.g:155:1: ruleFQN EOF
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
    // InternalRefactoringTestLanguage.g:162:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:166:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:167:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:167:2: ( ( rule__FQN__Group__0 ) )
            // InternalRefactoringTestLanguage.g:168:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:169:3: ( rule__FQN__Group__0 )
            // InternalRefactoringTestLanguage.g:169:4: rule__FQN__Group__0
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
    // InternalRefactoringTestLanguage.g:178:1: entryRuleFQNWithWC : ruleFQNWithWC EOF ;
    public final void entryRuleFQNWithWC() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:179:1: ( ruleFQNWithWC EOF )
            // InternalRefactoringTestLanguage.g:180:1: ruleFQNWithWC EOF
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
    // InternalRefactoringTestLanguage.g:187:1: ruleFQNWithWC : ( ( rule__FQNWithWC__Group__0 ) ) ;
    public final void ruleFQNWithWC() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:191:2: ( ( ( rule__FQNWithWC__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:192:2: ( ( rule__FQNWithWC__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:192:2: ( ( rule__FQNWithWC__Group__0 ) )
            // InternalRefactoringTestLanguage.g:193:3: ( rule__FQNWithWC__Group__0 )
            {
             before(grammarAccess.getFQNWithWCAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:194:3: ( rule__FQNWithWC__Group__0 )
            // InternalRefactoringTestLanguage.g:194:4: rule__FQNWithWC__Group__0
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
    // InternalRefactoringTestLanguage.g:202:1: rule__AbstractElement__Alternatives : ( ( ruleElement ) | ( ruleImport ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:206:1: ( ( ruleElement ) | ( ruleImport ) )
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
                    // InternalRefactoringTestLanguage.g:207:2: ( ruleElement )
                    {
                    // InternalRefactoringTestLanguage.g:207:2: ( ruleElement )
                    // InternalRefactoringTestLanguage.g:208:3: ruleElement
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
                    // InternalRefactoringTestLanguage.g:213:2: ( ruleImport )
                    {
                    // InternalRefactoringTestLanguage.g:213:2: ( ruleImport )
                    // InternalRefactoringTestLanguage.g:214:3: ruleImport
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
    // InternalRefactoringTestLanguage.g:223:1: rule__Element__Alternatives_1_1 : ( ( ( rule__Element__ContainedAssignment_1_1_0 ) ) | ( ( rule__Element__Group_1_1_1__0 ) ) );
    public final void rule__Element__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:227:1: ( ( ( rule__Element__ContainedAssignment_1_1_0 ) ) | ( ( rule__Element__Group_1_1_1__0 ) ) )
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
                    // InternalRefactoringTestLanguage.g:228:2: ( ( rule__Element__ContainedAssignment_1_1_0 ) )
                    {
                    // InternalRefactoringTestLanguage.g:228:2: ( ( rule__Element__ContainedAssignment_1_1_0 ) )
                    // InternalRefactoringTestLanguage.g:229:3: ( rule__Element__ContainedAssignment_1_1_0 )
                    {
                     before(grammarAccess.getElementAccess().getContainedAssignment_1_1_0()); 
                    // InternalRefactoringTestLanguage.g:230:3: ( rule__Element__ContainedAssignment_1_1_0 )
                    // InternalRefactoringTestLanguage.g:230:4: rule__Element__ContainedAssignment_1_1_0
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
                    // InternalRefactoringTestLanguage.g:234:2: ( ( rule__Element__Group_1_1_1__0 ) )
                    {
                    // InternalRefactoringTestLanguage.g:234:2: ( ( rule__Element__Group_1_1_1__0 ) )
                    // InternalRefactoringTestLanguage.g:235:3: ( rule__Element__Group_1_1_1__0 )
                    {
                     before(grammarAccess.getElementAccess().getGroup_1_1_1()); 
                    // InternalRefactoringTestLanguage.g:236:3: ( rule__Element__Group_1_1_1__0 )
                    // InternalRefactoringTestLanguage.g:236:4: rule__Element__Group_1_1_1__0
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
    // InternalRefactoringTestLanguage.g:244:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:248:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalRefactoringTestLanguage.g:249:2: rule__Import__Group__0__Impl rule__Import__Group__1
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
    // InternalRefactoringTestLanguage.g:256:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:260:1: ( ( 'import' ) )
            // InternalRefactoringTestLanguage.g:261:1: ( 'import' )
            {
            // InternalRefactoringTestLanguage.g:261:1: ( 'import' )
            // InternalRefactoringTestLanguage.g:262:2: 'import'
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
    // InternalRefactoringTestLanguage.g:271:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:275:1: ( rule__Import__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:276:2: rule__Import__Group__1__Impl
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
    // InternalRefactoringTestLanguage.g:282:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:286:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalRefactoringTestLanguage.g:287:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalRefactoringTestLanguage.g:287:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalRefactoringTestLanguage.g:288:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalRefactoringTestLanguage.g:289:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalRefactoringTestLanguage.g:289:3: rule__Import__ImportedNamespaceAssignment_1
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
    // InternalRefactoringTestLanguage.g:298:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:302:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalRefactoringTestLanguage.g:303:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // InternalRefactoringTestLanguage.g:310:1: rule__Element__Group__0__Impl : ( ( rule__Element__NameAssignment_0 ) ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:314:1: ( ( ( rule__Element__NameAssignment_0 ) ) )
            // InternalRefactoringTestLanguage.g:315:1: ( ( rule__Element__NameAssignment_0 ) )
            {
            // InternalRefactoringTestLanguage.g:315:1: ( ( rule__Element__NameAssignment_0 ) )
            // InternalRefactoringTestLanguage.g:316:2: ( rule__Element__NameAssignment_0 )
            {
             before(grammarAccess.getElementAccess().getNameAssignment_0()); 
            // InternalRefactoringTestLanguage.g:317:2: ( rule__Element__NameAssignment_0 )
            // InternalRefactoringTestLanguage.g:317:3: rule__Element__NameAssignment_0
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
    // InternalRefactoringTestLanguage.g:325:1: rule__Element__Group__1 : rule__Element__Group__1__Impl ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:329:1: ( rule__Element__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:330:2: rule__Element__Group__1__Impl
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
    // InternalRefactoringTestLanguage.g:336:1: rule__Element__Group__1__Impl : ( ( rule__Element__Group_1__0 )? ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:340:1: ( ( ( rule__Element__Group_1__0 )? ) )
            // InternalRefactoringTestLanguage.g:341:1: ( ( rule__Element__Group_1__0 )? )
            {
            // InternalRefactoringTestLanguage.g:341:1: ( ( rule__Element__Group_1__0 )? )
            // InternalRefactoringTestLanguage.g:342:2: ( rule__Element__Group_1__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_1()); 
            // InternalRefactoringTestLanguage.g:343:2: ( rule__Element__Group_1__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRefactoringTestLanguage.g:343:3: rule__Element__Group_1__0
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
    // InternalRefactoringTestLanguage.g:352:1: rule__Element__Group_1__0 : rule__Element__Group_1__0__Impl rule__Element__Group_1__1 ;
    public final void rule__Element__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:356:1: ( rule__Element__Group_1__0__Impl rule__Element__Group_1__1 )
            // InternalRefactoringTestLanguage.g:357:2: rule__Element__Group_1__0__Impl rule__Element__Group_1__1
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
    // InternalRefactoringTestLanguage.g:364:1: rule__Element__Group_1__0__Impl : ( '{' ) ;
    public final void rule__Element__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:368:1: ( ( '{' ) )
            // InternalRefactoringTestLanguage.g:369:1: ( '{' )
            {
            // InternalRefactoringTestLanguage.g:369:1: ( '{' )
            // InternalRefactoringTestLanguage.g:370:2: '{'
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
    // InternalRefactoringTestLanguage.g:379:1: rule__Element__Group_1__1 : rule__Element__Group_1__1__Impl rule__Element__Group_1__2 ;
    public final void rule__Element__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:383:1: ( rule__Element__Group_1__1__Impl rule__Element__Group_1__2 )
            // InternalRefactoringTestLanguage.g:384:2: rule__Element__Group_1__1__Impl rule__Element__Group_1__2
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
    // InternalRefactoringTestLanguage.g:391:1: rule__Element__Group_1__1__Impl : ( ( rule__Element__Alternatives_1_1 )* ) ;
    public final void rule__Element__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:395:1: ( ( ( rule__Element__Alternatives_1_1 )* ) )
            // InternalRefactoringTestLanguage.g:396:1: ( ( rule__Element__Alternatives_1_1 )* )
            {
            // InternalRefactoringTestLanguage.g:396:1: ( ( rule__Element__Alternatives_1_1 )* )
            // InternalRefactoringTestLanguage.g:397:2: ( rule__Element__Alternatives_1_1 )*
            {
             before(grammarAccess.getElementAccess().getAlternatives_1_1()); 
            // InternalRefactoringTestLanguage.g:398:2: ( rule__Element__Alternatives_1_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:398:3: rule__Element__Alternatives_1_1
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
    // InternalRefactoringTestLanguage.g:406:1: rule__Element__Group_1__2 : rule__Element__Group_1__2__Impl ;
    public final void rule__Element__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:410:1: ( rule__Element__Group_1__2__Impl )
            // InternalRefactoringTestLanguage.g:411:2: rule__Element__Group_1__2__Impl
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
    // InternalRefactoringTestLanguage.g:417:1: rule__Element__Group_1__2__Impl : ( '}' ) ;
    public final void rule__Element__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:421:1: ( ( '}' ) )
            // InternalRefactoringTestLanguage.g:422:1: ( '}' )
            {
            // InternalRefactoringTestLanguage.g:422:1: ( '}' )
            // InternalRefactoringTestLanguage.g:423:2: '}'
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
    // InternalRefactoringTestLanguage.g:433:1: rule__Element__Group_1_1_1__0 : rule__Element__Group_1_1_1__0__Impl rule__Element__Group_1_1_1__1 ;
    public final void rule__Element__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:437:1: ( rule__Element__Group_1_1_1__0__Impl rule__Element__Group_1_1_1__1 )
            // InternalRefactoringTestLanguage.g:438:2: rule__Element__Group_1_1_1__0__Impl rule__Element__Group_1_1_1__1
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
    // InternalRefactoringTestLanguage.g:445:1: rule__Element__Group_1_1_1__0__Impl : ( 'ref' ) ;
    public final void rule__Element__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:449:1: ( ( 'ref' ) )
            // InternalRefactoringTestLanguage.g:450:1: ( 'ref' )
            {
            // InternalRefactoringTestLanguage.g:450:1: ( 'ref' )
            // InternalRefactoringTestLanguage.g:451:2: 'ref'
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
    // InternalRefactoringTestLanguage.g:460:1: rule__Element__Group_1_1_1__1 : rule__Element__Group_1_1_1__1__Impl ;
    public final void rule__Element__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:464:1: ( rule__Element__Group_1_1_1__1__Impl )
            // InternalRefactoringTestLanguage.g:465:2: rule__Element__Group_1_1_1__1__Impl
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
    // InternalRefactoringTestLanguage.g:471:1: rule__Element__Group_1_1_1__1__Impl : ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) ) ;
    public final void rule__Element__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:475:1: ( ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) ) )
            // InternalRefactoringTestLanguage.g:476:1: ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) )
            {
            // InternalRefactoringTestLanguage.g:476:1: ( ( rule__Element__ReferencedAssignment_1_1_1_1 ) )
            // InternalRefactoringTestLanguage.g:477:2: ( rule__Element__ReferencedAssignment_1_1_1_1 )
            {
             before(grammarAccess.getElementAccess().getReferencedAssignment_1_1_1_1()); 
            // InternalRefactoringTestLanguage.g:478:2: ( rule__Element__ReferencedAssignment_1_1_1_1 )
            // InternalRefactoringTestLanguage.g:478:3: rule__Element__ReferencedAssignment_1_1_1_1
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
    // InternalRefactoringTestLanguage.g:487:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:491:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalRefactoringTestLanguage.g:492:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
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
    // InternalRefactoringTestLanguage.g:499:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:503:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:504:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:504:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:505:2: RULE_ID
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
    // InternalRefactoringTestLanguage.g:514:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:518:1: ( rule__FQN__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:519:2: rule__FQN__Group__1__Impl
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
    // InternalRefactoringTestLanguage.g:525:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:529:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalRefactoringTestLanguage.g:530:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalRefactoringTestLanguage.g:530:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalRefactoringTestLanguage.g:531:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalRefactoringTestLanguage.g:532:2: ( rule__FQN__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:532:3: rule__FQN__Group_1__0
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
    // InternalRefactoringTestLanguage.g:541:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:545:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalRefactoringTestLanguage.g:546:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalRefactoringTestLanguage.g:553:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:557:1: ( ( '.' ) )
            // InternalRefactoringTestLanguage.g:558:1: ( '.' )
            {
            // InternalRefactoringTestLanguage.g:558:1: ( '.' )
            // InternalRefactoringTestLanguage.g:559:2: '.'
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
    // InternalRefactoringTestLanguage.g:568:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:572:1: ( rule__FQN__Group_1__1__Impl )
            // InternalRefactoringTestLanguage.g:573:2: rule__FQN__Group_1__1__Impl
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
    // InternalRefactoringTestLanguage.g:579:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:583:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:584:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:584:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:585:2: RULE_ID
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
    // InternalRefactoringTestLanguage.g:595:1: rule__FQNWithWC__Group__0 : rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1 ;
    public final void rule__FQNWithWC__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:599:1: ( rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1 )
            // InternalRefactoringTestLanguage.g:600:2: rule__FQNWithWC__Group__0__Impl rule__FQNWithWC__Group__1
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
    // InternalRefactoringTestLanguage.g:607:1: rule__FQNWithWC__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__FQNWithWC__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:611:1: ( ( ruleFQN ) )
            // InternalRefactoringTestLanguage.g:612:1: ( ruleFQN )
            {
            // InternalRefactoringTestLanguage.g:612:1: ( ruleFQN )
            // InternalRefactoringTestLanguage.g:613:2: ruleFQN
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
    // InternalRefactoringTestLanguage.g:622:1: rule__FQNWithWC__Group__1 : rule__FQNWithWC__Group__1__Impl ;
    public final void rule__FQNWithWC__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:626:1: ( rule__FQNWithWC__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:627:2: rule__FQNWithWC__Group__1__Impl
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
    // InternalRefactoringTestLanguage.g:633:1: rule__FQNWithWC__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__FQNWithWC__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:637:1: ( ( ( '.*' )? ) )
            // InternalRefactoringTestLanguage.g:638:1: ( ( '.*' )? )
            {
            // InternalRefactoringTestLanguage.g:638:1: ( ( '.*' )? )
            // InternalRefactoringTestLanguage.g:639:2: ( '.*' )?
            {
             before(grammarAccess.getFQNWithWCAccess().getFullStopAsteriskKeyword_1()); 
            // InternalRefactoringTestLanguage.g:640:2: ( '.*' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalRefactoringTestLanguage.g:640:3: '.*'
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
    // InternalRefactoringTestLanguage.g:649:1: rule__Main__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__Main__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:653:1: ( ( ruleAbstractElement ) )
            // InternalRefactoringTestLanguage.g:654:2: ( ruleAbstractElement )
            {
            // InternalRefactoringTestLanguage.g:654:2: ( ruleAbstractElement )
            // InternalRefactoringTestLanguage.g:655:3: ruleAbstractElement
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
    // InternalRefactoringTestLanguage.g:664:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleFQNWithWC ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:668:1: ( ( ruleFQNWithWC ) )
            // InternalRefactoringTestLanguage.g:669:2: ( ruleFQNWithWC )
            {
            // InternalRefactoringTestLanguage.g:669:2: ( ruleFQNWithWC )
            // InternalRefactoringTestLanguage.g:670:3: ruleFQNWithWC
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
    // InternalRefactoringTestLanguage.g:679:1: rule__Element__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Element__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:683:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:684:2: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:684:2: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:685:3: RULE_ID
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
    // InternalRefactoringTestLanguage.g:694:1: rule__Element__ContainedAssignment_1_1_0 : ( ruleElement ) ;
    public final void rule__Element__ContainedAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:698:1: ( ( ruleElement ) )
            // InternalRefactoringTestLanguage.g:699:2: ( ruleElement )
            {
            // InternalRefactoringTestLanguage.g:699:2: ( ruleElement )
            // InternalRefactoringTestLanguage.g:700:3: ruleElement
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
    // InternalRefactoringTestLanguage.g:709:1: rule__Element__ReferencedAssignment_1_1_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__Element__ReferencedAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage.g:713:1: ( ( ( ruleFQN ) ) )
            // InternalRefactoringTestLanguage.g:714:2: ( ( ruleFQN ) )
            {
            // InternalRefactoringTestLanguage.g:714:2: ( ( ruleFQN ) )
            // InternalRefactoringTestLanguage.g:715:3: ( ruleFQN )
            {
             before(grammarAccess.getElementAccess().getReferencedElementCrossReference_1_1_1_1_0()); 
            // InternalRefactoringTestLanguage.g:716:3: ( ruleFQN )
            // InternalRefactoringTestLanguage.g:717:4: ruleFQN
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
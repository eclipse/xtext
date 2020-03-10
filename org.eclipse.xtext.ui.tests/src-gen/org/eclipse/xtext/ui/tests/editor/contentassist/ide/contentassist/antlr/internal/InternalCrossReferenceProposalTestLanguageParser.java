package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCrossReferenceProposalTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'<-'", "'::'", "'Object'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCrossReferenceProposalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCrossReferenceProposalTestLanguage.g"; }


    	private CrossReferenceProposalTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(CrossReferenceProposalTestLanguageGrammarAccess grammarAccess) {
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
    // InternalCrossReferenceProposalTestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalCrossReferenceProposalTestLanguage.g:54:1: ( ruleModel EOF )
            // InternalCrossReferenceProposalTestLanguage.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalCrossReferenceProposalTestLanguage.g:62:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:66:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalCrossReferenceProposalTestLanguage.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalCrossReferenceProposalTestLanguage.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            // InternalCrossReferenceProposalTestLanguage.g:68:3: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalCrossReferenceProposalTestLanguage.g:69:3: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=14 && LA1_0<=15)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCrossReferenceProposalTestLanguage.g:69:4: rule__Model__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Model__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment()); 

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


    // $ANTLR start "entryRuleClass"
    // InternalCrossReferenceProposalTestLanguage.g:78:1: entryRuleClass : ruleClass EOF ;
    public final void entryRuleClass() throws RecognitionException {
        try {
            // InternalCrossReferenceProposalTestLanguage.g:79:1: ( ruleClass EOF )
            // InternalCrossReferenceProposalTestLanguage.g:80:1: ruleClass EOF
            {
             before(grammarAccess.getClassRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getClassRule()); 
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
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalCrossReferenceProposalTestLanguage.g:87:1: ruleClass : ( ( rule__Class__Group__0 ) ) ;
    public final void ruleClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:91:2: ( ( ( rule__Class__Group__0 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:92:2: ( ( rule__Class__Group__0 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:92:2: ( ( rule__Class__Group__0 ) )
            // InternalCrossReferenceProposalTestLanguage.g:93:3: ( rule__Class__Group__0 )
            {
             before(grammarAccess.getClassAccess().getGroup()); 
            // InternalCrossReferenceProposalTestLanguage.g:94:3: ( rule__Class__Group__0 )
            // InternalCrossReferenceProposalTestLanguage.g:94:4: rule__Class__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getGroup()); 

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
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleComplexName"
    // InternalCrossReferenceProposalTestLanguage.g:103:1: entryRuleComplexName : ruleComplexName EOF ;
    public final void entryRuleComplexName() throws RecognitionException {
        try {
            // InternalCrossReferenceProposalTestLanguage.g:104:1: ( ruleComplexName EOF )
            // InternalCrossReferenceProposalTestLanguage.g:105:1: ruleComplexName EOF
            {
             before(grammarAccess.getComplexNameRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleComplexName();

            state._fsp--;

             after(grammarAccess.getComplexNameRule()); 
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
    // $ANTLR end "entryRuleComplexName"


    // $ANTLR start "ruleComplexName"
    // InternalCrossReferenceProposalTestLanguage.g:112:1: ruleComplexName : ( ( rule__ComplexName__Group__0 ) ) ;
    public final void ruleComplexName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:116:2: ( ( ( rule__ComplexName__Group__0 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:117:2: ( ( rule__ComplexName__Group__0 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:117:2: ( ( rule__ComplexName__Group__0 ) )
            // InternalCrossReferenceProposalTestLanguage.g:118:3: ( rule__ComplexName__Group__0 )
            {
             before(grammarAccess.getComplexNameAccess().getGroup()); 
            // InternalCrossReferenceProposalTestLanguage.g:119:3: ( rule__ComplexName__Group__0 )
            // InternalCrossReferenceProposalTestLanguage.g:119:4: rule__ComplexName__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ComplexName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComplexNameAccess().getGroup()); 

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
    // $ANTLR end "ruleComplexName"


    // $ANTLR start "rule__Class__Alternatives_0_0"
    // InternalCrossReferenceProposalTestLanguage.g:127:1: rule__Class__Alternatives_0_0 : ( ( ( rule__Class__SuperClassAssignment_0_0_0 ) ) | ( ( rule__Class__SuperClassAssignment_0_0_1 ) ) | ( ( rule__Class__SuperClassAssignment_0_0_2 ) ) );
    public final void rule__Class__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:131:1: ( ( ( rule__Class__SuperClassAssignment_0_0_0 ) ) | ( ( rule__Class__SuperClassAssignment_0_0_1 ) ) | ( ( rule__Class__SuperClassAssignment_0_0_2 ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                alt2=2;
                }
                break;
            case 14:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalCrossReferenceProposalTestLanguage.g:132:2: ( ( rule__Class__SuperClassAssignment_0_0_0 ) )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:132:2: ( ( rule__Class__SuperClassAssignment_0_0_0 ) )
                    // InternalCrossReferenceProposalTestLanguage.g:133:3: ( rule__Class__SuperClassAssignment_0_0_0 )
                    {
                     before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_0()); 
                    // InternalCrossReferenceProposalTestLanguage.g:134:3: ( rule__Class__SuperClassAssignment_0_0_0 )
                    // InternalCrossReferenceProposalTestLanguage.g:134:4: rule__Class__SuperClassAssignment_0_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__SuperClassAssignment_0_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCrossReferenceProposalTestLanguage.g:138:2: ( ( rule__Class__SuperClassAssignment_0_0_1 ) )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:138:2: ( ( rule__Class__SuperClassAssignment_0_0_1 ) )
                    // InternalCrossReferenceProposalTestLanguage.g:139:3: ( rule__Class__SuperClassAssignment_0_0_1 )
                    {
                     before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_1()); 
                    // InternalCrossReferenceProposalTestLanguage.g:140:3: ( rule__Class__SuperClassAssignment_0_0_1 )
                    // InternalCrossReferenceProposalTestLanguage.g:140:4: rule__Class__SuperClassAssignment_0_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__SuperClassAssignment_0_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalCrossReferenceProposalTestLanguage.g:144:2: ( ( rule__Class__SuperClassAssignment_0_0_2 ) )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:144:2: ( ( rule__Class__SuperClassAssignment_0_0_2 ) )
                    // InternalCrossReferenceProposalTestLanguage.g:145:3: ( rule__Class__SuperClassAssignment_0_0_2 )
                    {
                     before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_2()); 
                    // InternalCrossReferenceProposalTestLanguage.g:146:3: ( rule__Class__SuperClassAssignment_0_0_2 )
                    // InternalCrossReferenceProposalTestLanguage.g:146:4: rule__Class__SuperClassAssignment_0_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__SuperClassAssignment_0_0_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_2()); 

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
    // $ANTLR end "rule__Class__Alternatives_0_0"


    // $ANTLR start "rule__Class__NameAlternatives_1_0"
    // InternalCrossReferenceProposalTestLanguage.g:154:1: rule__Class__NameAlternatives_1_0 : ( ( RULE_ID ) | ( ruleComplexName ) );
    public final void rule__Class__NameAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:158:1: ( ( RULE_ID ) | ( ruleComplexName ) )
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
                    // InternalCrossReferenceProposalTestLanguage.g:159:2: ( RULE_ID )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:159:2: ( RULE_ID )
                    // InternalCrossReferenceProposalTestLanguage.g:160:3: RULE_ID
                    {
                     before(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0_0()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalCrossReferenceProposalTestLanguage.g:165:2: ( ruleComplexName )
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:165:2: ( ruleComplexName )
                    // InternalCrossReferenceProposalTestLanguage.g:166:3: ruleComplexName
                    {
                     before(grammarAccess.getClassAccess().getNameComplexNameParserRuleCall_1_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleComplexName();

                    state._fsp--;

                     after(grammarAccess.getClassAccess().getNameComplexNameParserRuleCall_1_0_1()); 

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
    // $ANTLR end "rule__Class__NameAlternatives_1_0"


    // $ANTLR start "rule__Class__Group__0"
    // InternalCrossReferenceProposalTestLanguage.g:175:1: rule__Class__Group__0 : rule__Class__Group__0__Impl rule__Class__Group__1 ;
    public final void rule__Class__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:179:1: ( rule__Class__Group__0__Impl rule__Class__Group__1 )
            // InternalCrossReferenceProposalTestLanguage.g:180:2: rule__Class__Group__0__Impl rule__Class__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Class__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__1();

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
    // $ANTLR end "rule__Class__Group__0"


    // $ANTLR start "rule__Class__Group__0__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:187:1: rule__Class__Group__0__Impl : ( ( rule__Class__Group_0__0 )? ) ;
    public final void rule__Class__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:191:1: ( ( ( rule__Class__Group_0__0 )? ) )
            // InternalCrossReferenceProposalTestLanguage.g:192:1: ( ( rule__Class__Group_0__0 )? )
            {
            // InternalCrossReferenceProposalTestLanguage.g:192:1: ( ( rule__Class__Group_0__0 )? )
            // InternalCrossReferenceProposalTestLanguage.g:193:2: ( rule__Class__Group_0__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:194:2: ( rule__Class__Group_0__0 )?
            int alt4=2;
            switch ( input.LA(1) ) {
                case 15:
                    {
                    alt4=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==13) ) {
                        alt4=1;
                    }
                    }
                    break;
                case 14:
                    {
                    int LA4_3 = input.LA(2);

                    if ( (LA4_3==RULE_ID) ) {
                        int LA4_5 = input.LA(3);

                        if ( (LA4_5==13) ) {
                            alt4=1;
                        }
                    }
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // InternalCrossReferenceProposalTestLanguage.g:194:3: rule__Class__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Class__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClassAccess().getGroup_0()); 

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
    // $ANTLR end "rule__Class__Group__0__Impl"


    // $ANTLR start "rule__Class__Group__1"
    // InternalCrossReferenceProposalTestLanguage.g:202:1: rule__Class__Group__1 : rule__Class__Group__1__Impl rule__Class__Group__2 ;
    public final void rule__Class__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:206:1: ( rule__Class__Group__1__Impl rule__Class__Group__2 )
            // InternalCrossReferenceProposalTestLanguage.g:207:2: rule__Class__Group__1__Impl rule__Class__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Class__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__2();

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
    // $ANTLR end "rule__Class__Group__1"


    // $ANTLR start "rule__Class__Group__1__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:214:1: rule__Class__Group__1__Impl : ( ( rule__Class__NameAssignment_1 ) ) ;
    public final void rule__Class__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:218:1: ( ( ( rule__Class__NameAssignment_1 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:219:1: ( ( rule__Class__NameAssignment_1 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:219:1: ( ( rule__Class__NameAssignment_1 ) )
            // InternalCrossReferenceProposalTestLanguage.g:220:2: ( rule__Class__NameAssignment_1 )
            {
             before(grammarAccess.getClassAccess().getNameAssignment_1()); 
            // InternalCrossReferenceProposalTestLanguage.g:221:2: ( rule__Class__NameAssignment_1 )
            // InternalCrossReferenceProposalTestLanguage.g:221:3: rule__Class__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Class__Group__1__Impl"


    // $ANTLR start "rule__Class__Group__2"
    // InternalCrossReferenceProposalTestLanguage.g:229:1: rule__Class__Group__2 : rule__Class__Group__2__Impl rule__Class__Group__3 ;
    public final void rule__Class__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:233:1: ( rule__Class__Group__2__Impl rule__Class__Group__3 )
            // InternalCrossReferenceProposalTestLanguage.g:234:2: rule__Class__Group__2__Impl rule__Class__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Class__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__3();

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
    // $ANTLR end "rule__Class__Group__2"


    // $ANTLR start "rule__Class__Group__2__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:241:1: rule__Class__Group__2__Impl : ( '{' ) ;
    public final void rule__Class__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:245:1: ( ( '{' ) )
            // InternalCrossReferenceProposalTestLanguage.g:246:1: ( '{' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:246:1: ( '{' )
            // InternalCrossReferenceProposalTestLanguage.g:247:2: '{'
            {
             before(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2()); 

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
    // $ANTLR end "rule__Class__Group__2__Impl"


    // $ANTLR start "rule__Class__Group__3"
    // InternalCrossReferenceProposalTestLanguage.g:256:1: rule__Class__Group__3 : rule__Class__Group__3__Impl ;
    public final void rule__Class__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:260:1: ( rule__Class__Group__3__Impl )
            // InternalCrossReferenceProposalTestLanguage.g:261:2: rule__Class__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group__3__Impl();

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
    // $ANTLR end "rule__Class__Group__3"


    // $ANTLR start "rule__Class__Group__3__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:267:1: rule__Class__Group__3__Impl : ( '}' ) ;
    public final void rule__Class__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:271:1: ( ( '}' ) )
            // InternalCrossReferenceProposalTestLanguage.g:272:1: ( '}' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:272:1: ( '}' )
            // InternalCrossReferenceProposalTestLanguage.g:273:2: '}'
            {
             before(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3()); 

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
    // $ANTLR end "rule__Class__Group__3__Impl"


    // $ANTLR start "rule__Class__Group_0__0"
    // InternalCrossReferenceProposalTestLanguage.g:283:1: rule__Class__Group_0__0 : rule__Class__Group_0__0__Impl rule__Class__Group_0__1 ;
    public final void rule__Class__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:287:1: ( rule__Class__Group_0__0__Impl rule__Class__Group_0__1 )
            // InternalCrossReferenceProposalTestLanguage.g:288:2: rule__Class__Group_0__0__Impl rule__Class__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Class__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_0__1();

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
    // $ANTLR end "rule__Class__Group_0__0"


    // $ANTLR start "rule__Class__Group_0__0__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:295:1: rule__Class__Group_0__0__Impl : ( ( rule__Class__Alternatives_0_0 ) ) ;
    public final void rule__Class__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:299:1: ( ( ( rule__Class__Alternatives_0_0 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:300:1: ( ( rule__Class__Alternatives_0_0 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:300:1: ( ( rule__Class__Alternatives_0_0 ) )
            // InternalCrossReferenceProposalTestLanguage.g:301:2: ( rule__Class__Alternatives_0_0 )
            {
             before(grammarAccess.getClassAccess().getAlternatives_0_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:302:2: ( rule__Class__Alternatives_0_0 )
            // InternalCrossReferenceProposalTestLanguage.g:302:3: rule__Class__Alternatives_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Alternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getAlternatives_0_0()); 

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
    // $ANTLR end "rule__Class__Group_0__0__Impl"


    // $ANTLR start "rule__Class__Group_0__1"
    // InternalCrossReferenceProposalTestLanguage.g:310:1: rule__Class__Group_0__1 : rule__Class__Group_0__1__Impl ;
    public final void rule__Class__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:314:1: ( rule__Class__Group_0__1__Impl )
            // InternalCrossReferenceProposalTestLanguage.g:315:2: rule__Class__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__Group_0__1__Impl();

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
    // $ANTLR end "rule__Class__Group_0__1"


    // $ANTLR start "rule__Class__Group_0__1__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:321:1: rule__Class__Group_0__1__Impl : ( '<-' ) ;
    public final void rule__Class__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:325:1: ( ( '<-' ) )
            // InternalCrossReferenceProposalTestLanguage.g:326:1: ( '<-' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:326:1: ( '<-' )
            // InternalCrossReferenceProposalTestLanguage.g:327:2: '<-'
            {
             before(grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1()); 

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
    // $ANTLR end "rule__Class__Group_0__1__Impl"


    // $ANTLR start "rule__ComplexName__Group__0"
    // InternalCrossReferenceProposalTestLanguage.g:337:1: rule__ComplexName__Group__0 : rule__ComplexName__Group__0__Impl rule__ComplexName__Group__1 ;
    public final void rule__ComplexName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:341:1: ( rule__ComplexName__Group__0__Impl rule__ComplexName__Group__1 )
            // InternalCrossReferenceProposalTestLanguage.g:342:2: rule__ComplexName__Group__0__Impl rule__ComplexName__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__ComplexName__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ComplexName__Group__1();

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
    // $ANTLR end "rule__ComplexName__Group__0"


    // $ANTLR start "rule__ComplexName__Group__0__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:349:1: rule__ComplexName__Group__0__Impl : ( '::' ) ;
    public final void rule__ComplexName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:353:1: ( ( '::' ) )
            // InternalCrossReferenceProposalTestLanguage.g:354:1: ( '::' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:354:1: ( '::' )
            // InternalCrossReferenceProposalTestLanguage.g:355:2: '::'
            {
             before(grammarAccess.getComplexNameAccess().getColonColonKeyword_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getComplexNameAccess().getColonColonKeyword_0()); 

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
    // $ANTLR end "rule__ComplexName__Group__0__Impl"


    // $ANTLR start "rule__ComplexName__Group__1"
    // InternalCrossReferenceProposalTestLanguage.g:364:1: rule__ComplexName__Group__1 : rule__ComplexName__Group__1__Impl ;
    public final void rule__ComplexName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:368:1: ( rule__ComplexName__Group__1__Impl )
            // InternalCrossReferenceProposalTestLanguage.g:369:2: rule__ComplexName__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ComplexName__Group__1__Impl();

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
    // $ANTLR end "rule__ComplexName__Group__1"


    // $ANTLR start "rule__ComplexName__Group__1__Impl"
    // InternalCrossReferenceProposalTestLanguage.g:375:1: rule__ComplexName__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__ComplexName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:379:1: ( ( RULE_ID ) )
            // InternalCrossReferenceProposalTestLanguage.g:380:1: ( RULE_ID )
            {
            // InternalCrossReferenceProposalTestLanguage.g:380:1: ( RULE_ID )
            // InternalCrossReferenceProposalTestLanguage.g:381:2: RULE_ID
            {
             before(grammarAccess.getComplexNameAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getComplexNameAccess().getIDTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__ComplexName__Group__1__Impl"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalCrossReferenceProposalTestLanguage.g:391:1: rule__Model__ElementsAssignment : ( ruleClass ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:395:1: ( ( ruleClass ) )
            // InternalCrossReferenceProposalTestLanguage.g:396:2: ( ruleClass )
            {
            // InternalCrossReferenceProposalTestLanguage.g:396:2: ( ruleClass )
            // InternalCrossReferenceProposalTestLanguage.g:397:3: ruleClass
            {
             before(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleClass();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__ElementsAssignment"


    // $ANTLR start "rule__Class__SuperClassAssignment_0_0_0"
    // InternalCrossReferenceProposalTestLanguage.g:406:1: rule__Class__SuperClassAssignment_0_0_0 : ( ( 'Object' ) ) ;
    public final void rule__Class__SuperClassAssignment_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:410:1: ( ( ( 'Object' ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:411:2: ( ( 'Object' ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:411:2: ( ( 'Object' ) )
            // InternalCrossReferenceProposalTestLanguage.g:412:3: ( 'Object' )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:413:3: ( 'Object' )
            // InternalCrossReferenceProposalTestLanguage.g:414:4: 'Object'
            {
             before(grammarAccess.getClassAccess().getSuperClassClassObjectKeyword_0_0_0_0_1()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getSuperClassClassObjectKeyword_0_0_0_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0_0()); 

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
    // $ANTLR end "rule__Class__SuperClassAssignment_0_0_0"


    // $ANTLR start "rule__Class__SuperClassAssignment_0_0_1"
    // InternalCrossReferenceProposalTestLanguage.g:425:1: rule__Class__SuperClassAssignment_0_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Class__SuperClassAssignment_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:429:1: ( ( ( RULE_ID ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:430:2: ( ( RULE_ID ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:430:2: ( ( RULE_ID ) )
            // InternalCrossReferenceProposalTestLanguage.g:431:3: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_1_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:432:3: ( RULE_ID )
            // InternalCrossReferenceProposalTestLanguage.g:433:4: RULE_ID
            {
             before(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_0_0_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_0_0_1_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_1_0()); 

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
    // $ANTLR end "rule__Class__SuperClassAssignment_0_0_1"


    // $ANTLR start "rule__Class__SuperClassAssignment_0_0_2"
    // InternalCrossReferenceProposalTestLanguage.g:444:1: rule__Class__SuperClassAssignment_0_0_2 : ( ( ruleComplexName ) ) ;
    public final void rule__Class__SuperClassAssignment_0_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:448:1: ( ( ( ruleComplexName ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:449:2: ( ( ruleComplexName ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:449:2: ( ( ruleComplexName ) )
            // InternalCrossReferenceProposalTestLanguage.g:450:3: ( ruleComplexName )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_2_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:451:3: ( ruleComplexName )
            // InternalCrossReferenceProposalTestLanguage.g:452:4: ruleComplexName
            {
             before(grammarAccess.getClassAccess().getSuperClassClassComplexNameParserRuleCall_0_0_2_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleComplexName();

            state._fsp--;

             after(grammarAccess.getClassAccess().getSuperClassClassComplexNameParserRuleCall_0_0_2_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_2_0()); 

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
    // $ANTLR end "rule__Class__SuperClassAssignment_0_0_2"


    // $ANTLR start "rule__Class__NameAssignment_1"
    // InternalCrossReferenceProposalTestLanguage.g:463:1: rule__Class__NameAssignment_1 : ( ( rule__Class__NameAlternatives_1_0 ) ) ;
    public final void rule__Class__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:467:1: ( ( ( rule__Class__NameAlternatives_1_0 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:468:2: ( ( rule__Class__NameAlternatives_1_0 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:468:2: ( ( rule__Class__NameAlternatives_1_0 ) )
            // InternalCrossReferenceProposalTestLanguage.g:469:3: ( rule__Class__NameAlternatives_1_0 )
            {
             before(grammarAccess.getClassAccess().getNameAlternatives_1_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:470:3: ( rule__Class__NameAlternatives_1_0 )
            // InternalCrossReferenceProposalTestLanguage.g:470:4: rule__Class__NameAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__NameAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getNameAlternatives_1_0()); 

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
    // $ANTLR end "rule__Class__NameAssignment_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000C012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000C010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    }


}
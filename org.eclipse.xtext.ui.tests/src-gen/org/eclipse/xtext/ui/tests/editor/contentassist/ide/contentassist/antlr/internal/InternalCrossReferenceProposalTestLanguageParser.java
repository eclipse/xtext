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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'<-'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
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

                if ( (LA1_0==RULE_ID) ) {
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


    // $ANTLR start "rule__Class__Group__0"
    // InternalCrossReferenceProposalTestLanguage.g:102:1: rule__Class__Group__0 : rule__Class__Group__0__Impl rule__Class__Group__1 ;
    public final void rule__Class__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:106:1: ( rule__Class__Group__0__Impl rule__Class__Group__1 )
            // InternalCrossReferenceProposalTestLanguage.g:107:2: rule__Class__Group__0__Impl rule__Class__Group__1
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
    // InternalCrossReferenceProposalTestLanguage.g:114:1: rule__Class__Group__0__Impl : ( ( rule__Class__Group_0__0 )? ) ;
    public final void rule__Class__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:118:1: ( ( ( rule__Class__Group_0__0 )? ) )
            // InternalCrossReferenceProposalTestLanguage.g:119:1: ( ( rule__Class__Group_0__0 )? )
            {
            // InternalCrossReferenceProposalTestLanguage.g:119:1: ( ( rule__Class__Group_0__0 )? )
            // InternalCrossReferenceProposalTestLanguage.g:120:2: ( rule__Class__Group_0__0 )?
            {
             before(grammarAccess.getClassAccess().getGroup_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:121:2: ( rule__Class__Group_0__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==13) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // InternalCrossReferenceProposalTestLanguage.g:121:3: rule__Class__Group_0__0
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
    // InternalCrossReferenceProposalTestLanguage.g:129:1: rule__Class__Group__1 : rule__Class__Group__1__Impl rule__Class__Group__2 ;
    public final void rule__Class__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:133:1: ( rule__Class__Group__1__Impl rule__Class__Group__2 )
            // InternalCrossReferenceProposalTestLanguage.g:134:2: rule__Class__Group__1__Impl rule__Class__Group__2
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
    // InternalCrossReferenceProposalTestLanguage.g:141:1: rule__Class__Group__1__Impl : ( ( rule__Class__NameAssignment_1 ) ) ;
    public final void rule__Class__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:145:1: ( ( ( rule__Class__NameAssignment_1 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:146:1: ( ( rule__Class__NameAssignment_1 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:146:1: ( ( rule__Class__NameAssignment_1 ) )
            // InternalCrossReferenceProposalTestLanguage.g:147:2: ( rule__Class__NameAssignment_1 )
            {
             before(grammarAccess.getClassAccess().getNameAssignment_1()); 
            // InternalCrossReferenceProposalTestLanguage.g:148:2: ( rule__Class__NameAssignment_1 )
            // InternalCrossReferenceProposalTestLanguage.g:148:3: rule__Class__NameAssignment_1
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
    // InternalCrossReferenceProposalTestLanguage.g:156:1: rule__Class__Group__2 : rule__Class__Group__2__Impl rule__Class__Group__3 ;
    public final void rule__Class__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:160:1: ( rule__Class__Group__2__Impl rule__Class__Group__3 )
            // InternalCrossReferenceProposalTestLanguage.g:161:2: rule__Class__Group__2__Impl rule__Class__Group__3
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
    // InternalCrossReferenceProposalTestLanguage.g:168:1: rule__Class__Group__2__Impl : ( '{' ) ;
    public final void rule__Class__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:172:1: ( ( '{' ) )
            // InternalCrossReferenceProposalTestLanguage.g:173:1: ( '{' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:173:1: ( '{' )
            // InternalCrossReferenceProposalTestLanguage.g:174:2: '{'
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
    // InternalCrossReferenceProposalTestLanguage.g:183:1: rule__Class__Group__3 : rule__Class__Group__3__Impl ;
    public final void rule__Class__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:187:1: ( rule__Class__Group__3__Impl )
            // InternalCrossReferenceProposalTestLanguage.g:188:2: rule__Class__Group__3__Impl
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
    // InternalCrossReferenceProposalTestLanguage.g:194:1: rule__Class__Group__3__Impl : ( '}' ) ;
    public final void rule__Class__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:198:1: ( ( '}' ) )
            // InternalCrossReferenceProposalTestLanguage.g:199:1: ( '}' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:199:1: ( '}' )
            // InternalCrossReferenceProposalTestLanguage.g:200:2: '}'
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
    // InternalCrossReferenceProposalTestLanguage.g:210:1: rule__Class__Group_0__0 : rule__Class__Group_0__0__Impl rule__Class__Group_0__1 ;
    public final void rule__Class__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:214:1: ( rule__Class__Group_0__0__Impl rule__Class__Group_0__1 )
            // InternalCrossReferenceProposalTestLanguage.g:215:2: rule__Class__Group_0__0__Impl rule__Class__Group_0__1
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
    // InternalCrossReferenceProposalTestLanguage.g:222:1: rule__Class__Group_0__0__Impl : ( ( rule__Class__SuperClassAssignment_0_0 ) ) ;
    public final void rule__Class__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:226:1: ( ( ( rule__Class__SuperClassAssignment_0_0 ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:227:1: ( ( rule__Class__SuperClassAssignment_0_0 ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:227:1: ( ( rule__Class__SuperClassAssignment_0_0 ) )
            // InternalCrossReferenceProposalTestLanguage.g:228:2: ( rule__Class__SuperClassAssignment_0_0 )
            {
             before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:229:2: ( rule__Class__SuperClassAssignment_0_0 )
            // InternalCrossReferenceProposalTestLanguage.g:229:3: rule__Class__SuperClassAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Class__SuperClassAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0()); 

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
    // InternalCrossReferenceProposalTestLanguage.g:237:1: rule__Class__Group_0__1 : rule__Class__Group_0__1__Impl ;
    public final void rule__Class__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:241:1: ( rule__Class__Group_0__1__Impl )
            // InternalCrossReferenceProposalTestLanguage.g:242:2: rule__Class__Group_0__1__Impl
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
    // InternalCrossReferenceProposalTestLanguage.g:248:1: rule__Class__Group_0__1__Impl : ( '<-' ) ;
    public final void rule__Class__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:252:1: ( ( '<-' ) )
            // InternalCrossReferenceProposalTestLanguage.g:253:1: ( '<-' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:253:1: ( '<-' )
            // InternalCrossReferenceProposalTestLanguage.g:254:2: '<-'
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


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalCrossReferenceProposalTestLanguage.g:264:1: rule__Model__ElementsAssignment : ( ruleClass ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:268:1: ( ( ruleClass ) )
            // InternalCrossReferenceProposalTestLanguage.g:269:2: ( ruleClass )
            {
            // InternalCrossReferenceProposalTestLanguage.g:269:2: ( ruleClass )
            // InternalCrossReferenceProposalTestLanguage.g:270:3: ruleClass
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


    // $ANTLR start "rule__Class__SuperClassAssignment_0_0"
    // InternalCrossReferenceProposalTestLanguage.g:279:1: rule__Class__SuperClassAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__Class__SuperClassAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:283:1: ( ( ( RULE_ID ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:284:2: ( ( RULE_ID ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:284:2: ( ( RULE_ID ) )
            // InternalCrossReferenceProposalTestLanguage.g:285:3: ( RULE_ID )
            {
             before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0()); 
            // InternalCrossReferenceProposalTestLanguage.g:286:3: ( RULE_ID )
            // InternalCrossReferenceProposalTestLanguage.g:287:4: RULE_ID
            {
             before(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0()); 

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
    // $ANTLR end "rule__Class__SuperClassAssignment_0_0"


    // $ANTLR start "rule__Class__NameAssignment_1"
    // InternalCrossReferenceProposalTestLanguage.g:298:1: rule__Class__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Class__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCrossReferenceProposalTestLanguage.g:302:1: ( ( RULE_ID ) )
            // InternalCrossReferenceProposalTestLanguage.g:303:2: ( RULE_ID )
            {
            // InternalCrossReferenceProposalTestLanguage.g:303:2: ( RULE_ID )
            // InternalCrossReferenceProposalTestLanguage.g:304:3: RULE_ID
            {
             before(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 

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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    }


}
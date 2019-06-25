package org.eclipse.xtext.common.types.xtext.ui.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.common.types.xtext.ui.services.RefactoringTestLanguage1GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRefactoringTestLanguage1Parser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'$'"
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
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalRefactoringTestLanguage1Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRefactoringTestLanguage1Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRefactoringTestLanguage1Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalRefactoringTestLanguage1.g"; }


    	private RefactoringTestLanguage1GrammarAccess grammarAccess;

    	public void setGrammarAccess(RefactoringTestLanguage1GrammarAccess grammarAccess) {
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
    // InternalRefactoringTestLanguage1.g:53:1: entryRuleEntry : ruleEntry EOF ;
    public final void entryRuleEntry() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage1.g:54:1: ( ruleEntry EOF )
            // InternalRefactoringTestLanguage1.g:55:1: ruleEntry EOF
            {
             before(grammarAccess.getEntryRule()); 
            pushFollow(FOLLOW_1);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getEntryRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRefactoringTestLanguage1.g:62:1: ruleEntry : ( ruleModel ) ;
    public final void ruleEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:66:2: ( ( ruleModel ) )
            // InternalRefactoringTestLanguage1.g:67:2: ( ruleModel )
            {
            // InternalRefactoringTestLanguage1.g:67:2: ( ruleModel )
            // InternalRefactoringTestLanguage1.g:68:3: ruleModel
            {
             before(grammarAccess.getEntryAccess().getModelParserRuleCall()); 
            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:78:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage1.g:79:1: ( ruleModel EOF )
            // InternalRefactoringTestLanguage1.g:80:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRefactoringTestLanguage1.g:87:1: ruleModel : ( ( rule__Model__ReferenceHolderAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:91:2: ( ( ( rule__Model__ReferenceHolderAssignment )* ) )
            // InternalRefactoringTestLanguage1.g:92:2: ( ( rule__Model__ReferenceHolderAssignment )* )
            {
            // InternalRefactoringTestLanguage1.g:92:2: ( ( rule__Model__ReferenceHolderAssignment )* )
            // InternalRefactoringTestLanguage1.g:93:3: ( rule__Model__ReferenceHolderAssignment )*
            {
             before(grammarAccess.getModelAccess().getReferenceHolderAssignment()); 
            // InternalRefactoringTestLanguage1.g:94:3: ( rule__Model__ReferenceHolderAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRefactoringTestLanguage1.g:94:4: rule__Model__ReferenceHolderAssignment
            	    {
            	    pushFollow(FOLLOW_3);
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
    // InternalRefactoringTestLanguage1.g:103:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage1.g:104:1: ( ruleReferenceHolder EOF )
            // InternalRefactoringTestLanguage1.g:105:1: ruleReferenceHolder EOF
            {
             before(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FOLLOW_1);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getReferenceHolderRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRefactoringTestLanguage1.g:112:1: ruleReferenceHolder : ( ( rule__ReferenceHolder__Group__0 ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:116:2: ( ( ( rule__ReferenceHolder__Group__0 ) ) )
            // InternalRefactoringTestLanguage1.g:117:2: ( ( rule__ReferenceHolder__Group__0 ) )
            {
            // InternalRefactoringTestLanguage1.g:117:2: ( ( rule__ReferenceHolder__Group__0 ) )
            // InternalRefactoringTestLanguage1.g:118:3: ( rule__ReferenceHolder__Group__0 )
            {
             before(grammarAccess.getReferenceHolderAccess().getGroup()); 
            // InternalRefactoringTestLanguage1.g:119:3: ( rule__ReferenceHolder__Group__0 )
            // InternalRefactoringTestLanguage1.g:119:4: rule__ReferenceHolder__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:128:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage1.g:129:1: ( ruleFQN EOF )
            // InternalRefactoringTestLanguage1.g:130:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRefactoringTestLanguage1.g:137:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:141:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalRefactoringTestLanguage1.g:142:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalRefactoringTestLanguage1.g:142:2: ( ( rule__FQN__Group__0 ) )
            // InternalRefactoringTestLanguage1.g:143:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalRefactoringTestLanguage1.g:144:3: ( rule__FQN__Group__0 )
            // InternalRefactoringTestLanguage1.g:144:4: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:152:1: rule__ReferenceHolder__Group__0 : rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1 ;
    public final void rule__ReferenceHolder__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:156:1: ( rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1 )
            // InternalRefactoringTestLanguage1.g:157:2: rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__ReferenceHolder__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:164:1: rule__ReferenceHolder__Group__0__Impl : ( ( rule__ReferenceHolder__NameAssignment_0 ) ) ;
    public final void rule__ReferenceHolder__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:168:1: ( ( ( rule__ReferenceHolder__NameAssignment_0 ) ) )
            // InternalRefactoringTestLanguage1.g:169:1: ( ( rule__ReferenceHolder__NameAssignment_0 ) )
            {
            // InternalRefactoringTestLanguage1.g:169:1: ( ( rule__ReferenceHolder__NameAssignment_0 ) )
            // InternalRefactoringTestLanguage1.g:170:2: ( rule__ReferenceHolder__NameAssignment_0 )
            {
             before(grammarAccess.getReferenceHolderAccess().getNameAssignment_0()); 
            // InternalRefactoringTestLanguage1.g:171:2: ( rule__ReferenceHolder__NameAssignment_0 )
            // InternalRefactoringTestLanguage1.g:171:3: rule__ReferenceHolder__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:179:1: rule__ReferenceHolder__Group__1 : rule__ReferenceHolder__Group__1__Impl ;
    public final void rule__ReferenceHolder__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:183:1: ( rule__ReferenceHolder__Group__1__Impl )
            // InternalRefactoringTestLanguage1.g:184:2: rule__ReferenceHolder__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:190:1: rule__ReferenceHolder__Group__1__Impl : ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) ) ;
    public final void rule__ReferenceHolder__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:194:1: ( ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) ) )
            // InternalRefactoringTestLanguage1.g:195:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) )
            {
            // InternalRefactoringTestLanguage1.g:195:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) )
            // InternalRefactoringTestLanguage1.g:196:2: ( rule__ReferenceHolder__DefaultReferenceAssignment_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_1()); 
            // InternalRefactoringTestLanguage1.g:197:2: ( rule__ReferenceHolder__DefaultReferenceAssignment_1 )
            // InternalRefactoringTestLanguage1.g:197:3: rule__ReferenceHolder__DefaultReferenceAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:206:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:210:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalRefactoringTestLanguage1.g:211:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:218:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:222:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage1.g:223:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage1.g:223:1: ( RULE_ID )
            // InternalRefactoringTestLanguage1.g:224:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalRefactoringTestLanguage1.g:233:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl rule__FQN__Group__2 ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:237:1: ( rule__FQN__Group__1__Impl rule__FQN__Group__2 )
            // InternalRefactoringTestLanguage1.g:238:2: rule__FQN__Group__1__Impl rule__FQN__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__FQN__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:245:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:249:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalRefactoringTestLanguage1.g:250:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalRefactoringTestLanguage1.g:250:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalRefactoringTestLanguage1.g:251:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalRefactoringTestLanguage1.g:252:2: ( rule__FQN__Group_1__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRefactoringTestLanguage1.g:252:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_6);
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
    // InternalRefactoringTestLanguage1.g:260:1: rule__FQN__Group__2 : rule__FQN__Group__2__Impl ;
    public final void rule__FQN__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:264:1: ( rule__FQN__Group__2__Impl )
            // InternalRefactoringTestLanguage1.g:265:2: rule__FQN__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:271:1: rule__FQN__Group__2__Impl : ( ( rule__FQN__Group_2__0 )* ) ;
    public final void rule__FQN__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:275:1: ( ( ( rule__FQN__Group_2__0 )* ) )
            // InternalRefactoringTestLanguage1.g:276:1: ( ( rule__FQN__Group_2__0 )* )
            {
            // InternalRefactoringTestLanguage1.g:276:1: ( ( rule__FQN__Group_2__0 )* )
            // InternalRefactoringTestLanguage1.g:277:2: ( rule__FQN__Group_2__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_2()); 
            // InternalRefactoringTestLanguage1.g:278:2: ( rule__FQN__Group_2__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRefactoringTestLanguage1.g:278:3: rule__FQN__Group_2__0
            	    {
            	    pushFollow(FOLLOW_7);
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
    // InternalRefactoringTestLanguage1.g:287:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:291:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalRefactoringTestLanguage1.g:292:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:299:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:303:1: ( ( '.' ) )
            // InternalRefactoringTestLanguage1.g:304:1: ( '.' )
            {
            // InternalRefactoringTestLanguage1.g:304:1: ( '.' )
            // InternalRefactoringTestLanguage1.g:305:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,11,FOLLOW_2); 
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
    // InternalRefactoringTestLanguage1.g:314:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:318:1: ( rule__FQN__Group_1__1__Impl )
            // InternalRefactoringTestLanguage1.g:319:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:325:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:329:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage1.g:330:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage1.g:330:1: ( RULE_ID )
            // InternalRefactoringTestLanguage1.g:331:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalRefactoringTestLanguage1.g:341:1: rule__FQN__Group_2__0 : rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1 ;
    public final void rule__FQN__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:345:1: ( rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1 )
            // InternalRefactoringTestLanguage1.g:346:2: rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__FQN__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:353:1: rule__FQN__Group_2__0__Impl : ( '$' ) ;
    public final void rule__FQN__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:357:1: ( ( '$' ) )
            // InternalRefactoringTestLanguage1.g:358:1: ( '$' )
            {
            // InternalRefactoringTestLanguage1.g:358:1: ( '$' )
            // InternalRefactoringTestLanguage1.g:359:2: '$'
            {
             before(grammarAccess.getFQNAccess().getDollarSignKeyword_2_0()); 
            match(input,12,FOLLOW_2); 
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
    // InternalRefactoringTestLanguage1.g:368:1: rule__FQN__Group_2__1 : rule__FQN__Group_2__1__Impl ;
    public final void rule__FQN__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:372:1: ( rule__FQN__Group_2__1__Impl )
            // InternalRefactoringTestLanguage1.g:373:2: rule__FQN__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:379:1: rule__FQN__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:383:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage1.g:384:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage1.g:384:1: ( RULE_ID )
            // InternalRefactoringTestLanguage1.g:385:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalRefactoringTestLanguage1.g:395:1: rule__Model__ReferenceHolderAssignment : ( ruleReferenceHolder ) ;
    public final void rule__Model__ReferenceHolderAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:399:1: ( ( ruleReferenceHolder ) )
            // InternalRefactoringTestLanguage1.g:400:2: ( ruleReferenceHolder )
            {
            // InternalRefactoringTestLanguage1.g:400:2: ( ruleReferenceHolder )
            // InternalRefactoringTestLanguage1.g:401:3: ruleReferenceHolder
            {
             before(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalRefactoringTestLanguage1.g:410:1: rule__ReferenceHolder__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ReferenceHolder__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:414:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage1.g:415:2: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage1.g:415:2: ( RULE_ID )
            // InternalRefactoringTestLanguage1.g:416:3: RULE_ID
            {
             before(grammarAccess.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalRefactoringTestLanguage1.g:425:1: rule__ReferenceHolder__DefaultReferenceAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__DefaultReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRefactoringTestLanguage1.g:429:1: ( ( ( ruleFQN ) ) )
            // InternalRefactoringTestLanguage1.g:430:2: ( ( ruleFQN ) )
            {
            // InternalRefactoringTestLanguage1.g:430:2: ( ( ruleFQN ) )
            // InternalRefactoringTestLanguage1.g:431:3: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0()); 
            // InternalRefactoringTestLanguage1.g:432:3: ( ruleFQN )
            // InternalRefactoringTestLanguage1.g:433:4: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001002L});

}
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




    // $ANTLR start "entryRuleModel"
    // InternalRefactoringTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:61:1: ( ruleModel EOF )
            // InternalRefactoringTestLanguage.g:62:1: ruleModel EOF
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
    // InternalRefactoringTestLanguage.g:69:1: ruleModel : ( ( rule__Model__ReferenceHolderAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:73:2: ( ( ( rule__Model__ReferenceHolderAssignment )* ) )
            // InternalRefactoringTestLanguage.g:74:1: ( ( rule__Model__ReferenceHolderAssignment )* )
            {
            // InternalRefactoringTestLanguage.g:74:1: ( ( rule__Model__ReferenceHolderAssignment )* )
            // InternalRefactoringTestLanguage.g:75:1: ( rule__Model__ReferenceHolderAssignment )*
            {
             before(grammarAccess.getModelAccess().getReferenceHolderAssignment()); 
            // InternalRefactoringTestLanguage.g:76:1: ( rule__Model__ReferenceHolderAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:76:2: rule__Model__ReferenceHolderAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
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
    // InternalRefactoringTestLanguage.g:88:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:89:1: ( ruleReferenceHolder EOF )
            // InternalRefactoringTestLanguage.g:90:1: ruleReferenceHolder EOF
            {
             before(grammarAccess.getReferenceHolderRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReferenceHolder();

            state._fsp--;

             after(grammarAccess.getReferenceHolderRule()); 
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
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // InternalRefactoringTestLanguage.g:97:1: ruleReferenceHolder : ( ( rule__ReferenceHolder__Group__0 ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:101:2: ( ( ( rule__ReferenceHolder__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:102:1: ( ( rule__ReferenceHolder__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:102:1: ( ( rule__ReferenceHolder__Group__0 ) )
            // InternalRefactoringTestLanguage.g:103:1: ( rule__ReferenceHolder__Group__0 )
            {
             before(grammarAccess.getReferenceHolderAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:104:1: ( rule__ReferenceHolder__Group__0 )
            // InternalRefactoringTestLanguage.g:104:2: rule__ReferenceHolder__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:116:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalRefactoringTestLanguage.g:117:1: ( ruleFQN EOF )
            // InternalRefactoringTestLanguage.g:118:1: ruleFQN EOF
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
    // InternalRefactoringTestLanguage.g:125:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:129:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalRefactoringTestLanguage.g:130:1: ( ( rule__FQN__Group__0 ) )
            {
            // InternalRefactoringTestLanguage.g:130:1: ( ( rule__FQN__Group__0 ) )
            // InternalRefactoringTestLanguage.g:131:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalRefactoringTestLanguage.g:132:1: ( rule__FQN__Group__0 )
            // InternalRefactoringTestLanguage.g:132:2: rule__FQN__Group__0
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


    // $ANTLR start "rule__ReferenceHolder__Group__0"
    // InternalRefactoringTestLanguage.g:146:1: rule__ReferenceHolder__Group__0 : rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1 ;
    public final void rule__ReferenceHolder__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:150:1: ( rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1 )
            // InternalRefactoringTestLanguage.g:151:2: rule__ReferenceHolder__Group__0__Impl rule__ReferenceHolder__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__ReferenceHolder__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:158:1: rule__ReferenceHolder__Group__0__Impl : ( ( rule__ReferenceHolder__NameAssignment_0 ) ) ;
    public final void rule__ReferenceHolder__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:162:1: ( ( ( rule__ReferenceHolder__NameAssignment_0 ) ) )
            // InternalRefactoringTestLanguage.g:163:1: ( ( rule__ReferenceHolder__NameAssignment_0 ) )
            {
            // InternalRefactoringTestLanguage.g:163:1: ( ( rule__ReferenceHolder__NameAssignment_0 ) )
            // InternalRefactoringTestLanguage.g:164:1: ( rule__ReferenceHolder__NameAssignment_0 )
            {
             before(grammarAccess.getReferenceHolderAccess().getNameAssignment_0()); 
            // InternalRefactoringTestLanguage.g:165:1: ( rule__ReferenceHolder__NameAssignment_0 )
            // InternalRefactoringTestLanguage.g:165:2: rule__ReferenceHolder__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:175:1: rule__ReferenceHolder__Group__1 : rule__ReferenceHolder__Group__1__Impl ;
    public final void rule__ReferenceHolder__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:179:1: ( rule__ReferenceHolder__Group__1__Impl )
            // InternalRefactoringTestLanguage.g:180:2: rule__ReferenceHolder__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:186:1: rule__ReferenceHolder__Group__1__Impl : ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) ) ;
    public final void rule__ReferenceHolder__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:190:1: ( ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) ) )
            // InternalRefactoringTestLanguage.g:191:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) )
            {
            // InternalRefactoringTestLanguage.g:191:1: ( ( rule__ReferenceHolder__DefaultReferenceAssignment_1 ) )
            // InternalRefactoringTestLanguage.g:192:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_1 )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_1()); 
            // InternalRefactoringTestLanguage.g:193:1: ( rule__ReferenceHolder__DefaultReferenceAssignment_1 )
            // InternalRefactoringTestLanguage.g:193:2: rule__ReferenceHolder__DefaultReferenceAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:207:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:211:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalRefactoringTestLanguage.g:212:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
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
    // InternalRefactoringTestLanguage.g:219:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:223:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:224:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:224:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:225:1: RULE_ID
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
    // InternalRefactoringTestLanguage.g:236:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl rule__FQN__Group__2 ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:240:1: ( rule__FQN__Group__1__Impl rule__FQN__Group__2 )
            // InternalRefactoringTestLanguage.g:241:2: rule__FQN__Group__1__Impl rule__FQN__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__FQN__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:248:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:252:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalRefactoringTestLanguage.g:253:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalRefactoringTestLanguage.g:253:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalRefactoringTestLanguage.g:254:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalRefactoringTestLanguage.g:255:1: ( rule__FQN__Group_1__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:255:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
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
    // InternalRefactoringTestLanguage.g:265:1: rule__FQN__Group__2 : rule__FQN__Group__2__Impl ;
    public final void rule__FQN__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:269:1: ( rule__FQN__Group__2__Impl )
            // InternalRefactoringTestLanguage.g:270:2: rule__FQN__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:276:1: rule__FQN__Group__2__Impl : ( ( rule__FQN__Group_2__0 )* ) ;
    public final void rule__FQN__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:280:1: ( ( ( rule__FQN__Group_2__0 )* ) )
            // InternalRefactoringTestLanguage.g:281:1: ( ( rule__FQN__Group_2__0 )* )
            {
            // InternalRefactoringTestLanguage.g:281:1: ( ( rule__FQN__Group_2__0 )* )
            // InternalRefactoringTestLanguage.g:282:1: ( rule__FQN__Group_2__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_2()); 
            // InternalRefactoringTestLanguage.g:283:1: ( rule__FQN__Group_2__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRefactoringTestLanguage.g:283:2: rule__FQN__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
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
    // InternalRefactoringTestLanguage.g:299:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:303:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalRefactoringTestLanguage.g:304:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
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
    // InternalRefactoringTestLanguage.g:311:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:315:1: ( ( '.' ) )
            // InternalRefactoringTestLanguage.g:316:1: ( '.' )
            {
            // InternalRefactoringTestLanguage.g:316:1: ( '.' )
            // InternalRefactoringTestLanguage.g:317:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
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
    // InternalRefactoringTestLanguage.g:330:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:334:1: ( rule__FQN__Group_1__1__Impl )
            // InternalRefactoringTestLanguage.g:335:2: rule__FQN__Group_1__1__Impl
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
    // InternalRefactoringTestLanguage.g:341:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:345:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:346:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:346:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:347:1: RULE_ID
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


    // $ANTLR start "rule__FQN__Group_2__0"
    // InternalRefactoringTestLanguage.g:362:1: rule__FQN__Group_2__0 : rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1 ;
    public final void rule__FQN__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:366:1: ( rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1 )
            // InternalRefactoringTestLanguage.g:367:2: rule__FQN__Group_2__0__Impl rule__FQN__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__FQN__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:374:1: rule__FQN__Group_2__0__Impl : ( '$' ) ;
    public final void rule__FQN__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:378:1: ( ( '$' ) )
            // InternalRefactoringTestLanguage.g:379:1: ( '$' )
            {
            // InternalRefactoringTestLanguage.g:379:1: ( '$' )
            // InternalRefactoringTestLanguage.g:380:1: '$'
            {
             before(grammarAccess.getFQNAccess().getDollarSignKeyword_2_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
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
    // InternalRefactoringTestLanguage.g:393:1: rule__FQN__Group_2__1 : rule__FQN__Group_2__1__Impl ;
    public final void rule__FQN__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:397:1: ( rule__FQN__Group_2__1__Impl )
            // InternalRefactoringTestLanguage.g:398:2: rule__FQN__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:404:1: rule__FQN__Group_2__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:408:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:409:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:409:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:410:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_2_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalRefactoringTestLanguage.g:426:1: rule__Model__ReferenceHolderAssignment : ( ruleReferenceHolder ) ;
    public final void rule__Model__ReferenceHolderAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:430:1: ( ( ruleReferenceHolder ) )
            // InternalRefactoringTestLanguage.g:431:1: ( ruleReferenceHolder )
            {
            // InternalRefactoringTestLanguage.g:431:1: ( ruleReferenceHolder )
            // InternalRefactoringTestLanguage.g:432:1: ruleReferenceHolder
            {
             before(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRefactoringTestLanguage.g:441:1: rule__ReferenceHolder__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ReferenceHolder__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:445:1: ( ( RULE_ID ) )
            // InternalRefactoringTestLanguage.g:446:1: ( RULE_ID )
            {
            // InternalRefactoringTestLanguage.g:446:1: ( RULE_ID )
            // InternalRefactoringTestLanguage.g:447:1: RULE_ID
            {
             before(grammarAccess.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // InternalRefactoringTestLanguage.g:456:1: rule__ReferenceHolder__DefaultReferenceAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__ReferenceHolder__DefaultReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRefactoringTestLanguage.g:460:1: ( ( ( ruleFQN ) ) )
            // InternalRefactoringTestLanguage.g:461:1: ( ( ruleFQN ) )
            {
            // InternalRefactoringTestLanguage.g:461:1: ( ( ruleFQN ) )
            // InternalRefactoringTestLanguage.g:462:1: ( ruleFQN )
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0()); 
            // InternalRefactoringTestLanguage.g:463:1: ( ruleFQN )
            // InternalRefactoringTestLanguage.g:464:1: ruleFQN
            {
             before(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001002L});
    }


}
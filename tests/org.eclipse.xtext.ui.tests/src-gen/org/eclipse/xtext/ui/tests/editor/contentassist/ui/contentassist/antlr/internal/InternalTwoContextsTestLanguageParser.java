package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.TwoContextsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTwoContextsTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'refersTo'"
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


        public InternalTwoContextsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTwoContextsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTwoContextsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTwoContextsTestLanguage.g"; }


     
     	private TwoContextsTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TwoContextsTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleMainModel"
    // InternalTwoContextsTestLanguage.g:60:1: entryRuleMainModel : ruleMainModel EOF ;
    public final void entryRuleMainModel() throws RecognitionException {
        try {
            // InternalTwoContextsTestLanguage.g:61:1: ( ruleMainModel EOF )
            // InternalTwoContextsTestLanguage.g:62:1: ruleMainModel EOF
            {
             before(grammarAccess.getMainModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMainModel();

            state._fsp--;

             after(grammarAccess.getMainModelRule()); 
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
    // $ANTLR end "entryRuleMainModel"


    // $ANTLR start "ruleMainModel"
    // InternalTwoContextsTestLanguage.g:69:1: ruleMainModel : ( ( rule__MainModel__ElementsAssignment )* ) ;
    public final void ruleMainModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:73:2: ( ( ( rule__MainModel__ElementsAssignment )* ) )
            // InternalTwoContextsTestLanguage.g:74:1: ( ( rule__MainModel__ElementsAssignment )* )
            {
            // InternalTwoContextsTestLanguage.g:74:1: ( ( rule__MainModel__ElementsAssignment )* )
            // InternalTwoContextsTestLanguage.g:75:1: ( rule__MainModel__ElementsAssignment )*
            {
             before(grammarAccess.getMainModelAccess().getElementsAssignment()); 
            // InternalTwoContextsTestLanguage.g:76:1: ( rule__MainModel__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTwoContextsTestLanguage.g:76:2: rule__MainModel__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__MainModel__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainModelAccess().getElementsAssignment()); 

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
    // $ANTLR end "ruleMainModel"


    // $ANTLR start "entryRuleAnElement"
    // InternalTwoContextsTestLanguage.g:88:1: entryRuleAnElement : ruleAnElement EOF ;
    public final void entryRuleAnElement() throws RecognitionException {
        try {
            // InternalTwoContextsTestLanguage.g:89:1: ( ruleAnElement EOF )
            // InternalTwoContextsTestLanguage.g:90:1: ruleAnElement EOF
            {
             before(grammarAccess.getAnElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAnElement();

            state._fsp--;

             after(grammarAccess.getAnElementRule()); 
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
    // $ANTLR end "entryRuleAnElement"


    // $ANTLR start "ruleAnElement"
    // InternalTwoContextsTestLanguage.g:97:1: ruleAnElement : ( ( rule__AnElement__Group__0 ) ) ;
    public final void ruleAnElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:101:2: ( ( ( rule__AnElement__Group__0 ) ) )
            // InternalTwoContextsTestLanguage.g:102:1: ( ( rule__AnElement__Group__0 ) )
            {
            // InternalTwoContextsTestLanguage.g:102:1: ( ( rule__AnElement__Group__0 ) )
            // InternalTwoContextsTestLanguage.g:103:1: ( rule__AnElement__Group__0 )
            {
             before(grammarAccess.getAnElementAccess().getGroup()); 
            // InternalTwoContextsTestLanguage.g:104:1: ( rule__AnElement__Group__0 )
            // InternalTwoContextsTestLanguage.g:104:2: rule__AnElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AnElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAnElementAccess().getGroup()); 

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
    // $ANTLR end "ruleAnElement"


    // $ANTLR start "rule__AnElement__Group__0"
    // InternalTwoContextsTestLanguage.g:118:1: rule__AnElement__Group__0 : rule__AnElement__Group__0__Impl rule__AnElement__Group__1 ;
    public final void rule__AnElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:122:1: ( rule__AnElement__Group__0__Impl rule__AnElement__Group__1 )
            // InternalTwoContextsTestLanguage.g:123:2: rule__AnElement__Group__0__Impl rule__AnElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__AnElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AnElement__Group__1();

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
    // $ANTLR end "rule__AnElement__Group__0"


    // $ANTLR start "rule__AnElement__Group__0__Impl"
    // InternalTwoContextsTestLanguage.g:130:1: rule__AnElement__Group__0__Impl : ( ( rule__AnElement__NameAssignment_0 ) ) ;
    public final void rule__AnElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:134:1: ( ( ( rule__AnElement__NameAssignment_0 ) ) )
            // InternalTwoContextsTestLanguage.g:135:1: ( ( rule__AnElement__NameAssignment_0 ) )
            {
            // InternalTwoContextsTestLanguage.g:135:1: ( ( rule__AnElement__NameAssignment_0 ) )
            // InternalTwoContextsTestLanguage.g:136:1: ( rule__AnElement__NameAssignment_0 )
            {
             before(grammarAccess.getAnElementAccess().getNameAssignment_0()); 
            // InternalTwoContextsTestLanguage.g:137:1: ( rule__AnElement__NameAssignment_0 )
            // InternalTwoContextsTestLanguage.g:137:2: rule__AnElement__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AnElement__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAnElementAccess().getNameAssignment_0()); 

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
    // $ANTLR end "rule__AnElement__Group__0__Impl"


    // $ANTLR start "rule__AnElement__Group__1"
    // InternalTwoContextsTestLanguage.g:147:1: rule__AnElement__Group__1 : rule__AnElement__Group__1__Impl rule__AnElement__Group__2 ;
    public final void rule__AnElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:151:1: ( rule__AnElement__Group__1__Impl rule__AnElement__Group__2 )
            // InternalTwoContextsTestLanguage.g:152:2: rule__AnElement__Group__1__Impl rule__AnElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__AnElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AnElement__Group__2();

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
    // $ANTLR end "rule__AnElement__Group__1"


    // $ANTLR start "rule__AnElement__Group__1__Impl"
    // InternalTwoContextsTestLanguage.g:159:1: rule__AnElement__Group__1__Impl : ( ( rule__AnElement__Group_1__0 )? ) ;
    public final void rule__AnElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:163:1: ( ( ( rule__AnElement__Group_1__0 )? ) )
            // InternalTwoContextsTestLanguage.g:164:1: ( ( rule__AnElement__Group_1__0 )? )
            {
            // InternalTwoContextsTestLanguage.g:164:1: ( ( rule__AnElement__Group_1__0 )? )
            // InternalTwoContextsTestLanguage.g:165:1: ( rule__AnElement__Group_1__0 )?
            {
             before(grammarAccess.getAnElementAccess().getGroup_1()); 
            // InternalTwoContextsTestLanguage.g:166:1: ( rule__AnElement__Group_1__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTwoContextsTestLanguage.g:166:2: rule__AnElement__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__AnElement__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAnElementAccess().getGroup_1()); 

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
    // $ANTLR end "rule__AnElement__Group__1__Impl"


    // $ANTLR start "rule__AnElement__Group__2"
    // InternalTwoContextsTestLanguage.g:176:1: rule__AnElement__Group__2 : rule__AnElement__Group__2__Impl ;
    public final void rule__AnElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:180:1: ( rule__AnElement__Group__2__Impl )
            // InternalTwoContextsTestLanguage.g:181:2: rule__AnElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AnElement__Group__2__Impl();

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
    // $ANTLR end "rule__AnElement__Group__2"


    // $ANTLR start "rule__AnElement__Group__2__Impl"
    // InternalTwoContextsTestLanguage.g:187:1: rule__AnElement__Group__2__Impl : ( ';' ) ;
    public final void rule__AnElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:191:1: ( ( ';' ) )
            // InternalTwoContextsTestLanguage.g:192:1: ( ';' )
            {
            // InternalTwoContextsTestLanguage.g:192:1: ( ';' )
            // InternalTwoContextsTestLanguage.g:193:1: ';'
            {
             before(grammarAccess.getAnElementAccess().getSemicolonKeyword_2()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAnElementAccess().getSemicolonKeyword_2()); 

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
    // $ANTLR end "rule__AnElement__Group__2__Impl"


    // $ANTLR start "rule__AnElement__Group_1__0"
    // InternalTwoContextsTestLanguage.g:212:1: rule__AnElement__Group_1__0 : rule__AnElement__Group_1__0__Impl rule__AnElement__Group_1__1 ;
    public final void rule__AnElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:216:1: ( rule__AnElement__Group_1__0__Impl rule__AnElement__Group_1__1 )
            // InternalTwoContextsTestLanguage.g:217:2: rule__AnElement__Group_1__0__Impl rule__AnElement__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__AnElement__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AnElement__Group_1__1();

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
    // $ANTLR end "rule__AnElement__Group_1__0"


    // $ANTLR start "rule__AnElement__Group_1__0__Impl"
    // InternalTwoContextsTestLanguage.g:224:1: rule__AnElement__Group_1__0__Impl : ( 'refersTo' ) ;
    public final void rule__AnElement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:228:1: ( ( 'refersTo' ) )
            // InternalTwoContextsTestLanguage.g:229:1: ( 'refersTo' )
            {
            // InternalTwoContextsTestLanguage.g:229:1: ( 'refersTo' )
            // InternalTwoContextsTestLanguage.g:230:1: 'refersTo'
            {
             before(grammarAccess.getAnElementAccess().getRefersToKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAnElementAccess().getRefersToKeyword_1_0()); 

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
    // $ANTLR end "rule__AnElement__Group_1__0__Impl"


    // $ANTLR start "rule__AnElement__Group_1__1"
    // InternalTwoContextsTestLanguage.g:243:1: rule__AnElement__Group_1__1 : rule__AnElement__Group_1__1__Impl ;
    public final void rule__AnElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:247:1: ( rule__AnElement__Group_1__1__Impl )
            // InternalTwoContextsTestLanguage.g:248:2: rule__AnElement__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AnElement__Group_1__1__Impl();

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
    // $ANTLR end "rule__AnElement__Group_1__1"


    // $ANTLR start "rule__AnElement__Group_1__1__Impl"
    // InternalTwoContextsTestLanguage.g:254:1: rule__AnElement__Group_1__1__Impl : ( ( rule__AnElement__ReferredAssignment_1_1 ) ) ;
    public final void rule__AnElement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:258:1: ( ( ( rule__AnElement__ReferredAssignment_1_1 ) ) )
            // InternalTwoContextsTestLanguage.g:259:1: ( ( rule__AnElement__ReferredAssignment_1_1 ) )
            {
            // InternalTwoContextsTestLanguage.g:259:1: ( ( rule__AnElement__ReferredAssignment_1_1 ) )
            // InternalTwoContextsTestLanguage.g:260:1: ( rule__AnElement__ReferredAssignment_1_1 )
            {
             before(grammarAccess.getAnElementAccess().getReferredAssignment_1_1()); 
            // InternalTwoContextsTestLanguage.g:261:1: ( rule__AnElement__ReferredAssignment_1_1 )
            // InternalTwoContextsTestLanguage.g:261:2: rule__AnElement__ReferredAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AnElement__ReferredAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAnElementAccess().getReferredAssignment_1_1()); 

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
    // $ANTLR end "rule__AnElement__Group_1__1__Impl"


    // $ANTLR start "rule__MainModel__ElementsAssignment"
    // InternalTwoContextsTestLanguage.g:276:1: rule__MainModel__ElementsAssignment : ( ruleAnElement ) ;
    public final void rule__MainModel__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:280:1: ( ( ruleAnElement ) )
            // InternalTwoContextsTestLanguage.g:281:1: ( ruleAnElement )
            {
            // InternalTwoContextsTestLanguage.g:281:1: ( ruleAnElement )
            // InternalTwoContextsTestLanguage.g:282:1: ruleAnElement
            {
             before(grammarAccess.getMainModelAccess().getElementsAnElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAnElement();

            state._fsp--;

             after(grammarAccess.getMainModelAccess().getElementsAnElementParserRuleCall_0()); 

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
    // $ANTLR end "rule__MainModel__ElementsAssignment"


    // $ANTLR start "rule__AnElement__NameAssignment_0"
    // InternalTwoContextsTestLanguage.g:291:1: rule__AnElement__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__AnElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:295:1: ( ( RULE_ID ) )
            // InternalTwoContextsTestLanguage.g:296:1: ( RULE_ID )
            {
            // InternalTwoContextsTestLanguage.g:296:1: ( RULE_ID )
            // InternalTwoContextsTestLanguage.g:297:1: RULE_ID
            {
             before(grammarAccess.getAnElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAnElementAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__AnElement__NameAssignment_0"


    // $ANTLR start "rule__AnElement__ReferredAssignment_1_1"
    // InternalTwoContextsTestLanguage.g:306:1: rule__AnElement__ReferredAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__AnElement__ReferredAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTwoContextsTestLanguage.g:310:1: ( ( ( RULE_ID ) ) )
            // InternalTwoContextsTestLanguage.g:311:1: ( ( RULE_ID ) )
            {
            // InternalTwoContextsTestLanguage.g:311:1: ( ( RULE_ID ) )
            // InternalTwoContextsTestLanguage.g:312:1: ( RULE_ID )
            {
             before(grammarAccess.getAnElementAccess().getReferredAnElementCrossReference_1_1_0()); 
            // InternalTwoContextsTestLanguage.g:313:1: ( RULE_ID )
            // InternalTwoContextsTestLanguage.g:314:1: RULE_ID
            {
             before(grammarAccess.getAnElementAccess().getReferredAnElementIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAnElementAccess().getReferredAnElementIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getAnElementAccess().getReferredAnElementCrossReference_1_1_0()); 

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
    // $ANTLR end "rule__AnElement__ReferredAssignment_1_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    }


}
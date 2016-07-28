package org.eclipse.xtext.ui.tests.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.services.TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'stuff'", "'refs'"
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


        public InternalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTestLanguage.g"; }


    	private TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(TestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleFile"
    // InternalTestLanguage.g:53:1: entryRuleFile : ruleFile EOF ;
    public final void entryRuleFile() throws RecognitionException {
        try {
            // InternalTestLanguage.g:54:1: ( ruleFile EOF )
            // InternalTestLanguage.g:55:1: ruleFile EOF
            {
             before(grammarAccess.getFileRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFile();

            state._fsp--;

             after(grammarAccess.getFileRule()); 
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
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // InternalTestLanguage.g:62:1: ruleFile : ( ( rule__File__StuffAssignment )* ) ;
    public final void ruleFile() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:66:2: ( ( ( rule__File__StuffAssignment )* ) )
            // InternalTestLanguage.g:67:2: ( ( rule__File__StuffAssignment )* )
            {
            // InternalTestLanguage.g:67:2: ( ( rule__File__StuffAssignment )* )
            // InternalTestLanguage.g:68:3: ( rule__File__StuffAssignment )*
            {
             before(grammarAccess.getFileAccess().getStuffAssignment()); 
            // InternalTestLanguage.g:69:3: ( rule__File__StuffAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTestLanguage.g:69:4: rule__File__StuffAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__File__StuffAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFileAccess().getStuffAssignment()); 

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
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleStuff"
    // InternalTestLanguage.g:78:1: entryRuleStuff : ruleStuff EOF ;
    public final void entryRuleStuff() throws RecognitionException {
        try {
            // InternalTestLanguage.g:79:1: ( ruleStuff EOF )
            // InternalTestLanguage.g:80:1: ruleStuff EOF
            {
             before(grammarAccess.getStuffRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleStuff();

            state._fsp--;

             after(grammarAccess.getStuffRule()); 
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
    // $ANTLR end "entryRuleStuff"


    // $ANTLR start "ruleStuff"
    // InternalTestLanguage.g:87:1: ruleStuff : ( ( rule__Stuff__Group__0 ) ) ;
    public final void ruleStuff() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:91:2: ( ( ( rule__Stuff__Group__0 ) ) )
            // InternalTestLanguage.g:92:2: ( ( rule__Stuff__Group__0 ) )
            {
            // InternalTestLanguage.g:92:2: ( ( rule__Stuff__Group__0 ) )
            // InternalTestLanguage.g:93:3: ( rule__Stuff__Group__0 )
            {
             before(grammarAccess.getStuffAccess().getGroup()); 
            // InternalTestLanguage.g:94:3: ( rule__Stuff__Group__0 )
            // InternalTestLanguage.g:94:4: rule__Stuff__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Stuff__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStuffAccess().getGroup()); 

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
    // $ANTLR end "ruleStuff"


    // $ANTLR start "rule__Stuff__Group__0"
    // InternalTestLanguage.g:102:1: rule__Stuff__Group__0 : rule__Stuff__Group__0__Impl rule__Stuff__Group__1 ;
    public final void rule__Stuff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:106:1: ( rule__Stuff__Group__0__Impl rule__Stuff__Group__1 )
            // InternalTestLanguage.g:107:2: rule__Stuff__Group__0__Impl rule__Stuff__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Stuff__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Stuff__Group__1();

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
    // $ANTLR end "rule__Stuff__Group__0"


    // $ANTLR start "rule__Stuff__Group__0__Impl"
    // InternalTestLanguage.g:114:1: rule__Stuff__Group__0__Impl : ( 'stuff' ) ;
    public final void rule__Stuff__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:118:1: ( ( 'stuff' ) )
            // InternalTestLanguage.g:119:1: ( 'stuff' )
            {
            // InternalTestLanguage.g:119:1: ( 'stuff' )
            // InternalTestLanguage.g:120:2: 'stuff'
            {
             before(grammarAccess.getStuffAccess().getStuffKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStuffAccess().getStuffKeyword_0()); 

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
    // $ANTLR end "rule__Stuff__Group__0__Impl"


    // $ANTLR start "rule__Stuff__Group__1"
    // InternalTestLanguage.g:129:1: rule__Stuff__Group__1 : rule__Stuff__Group__1__Impl rule__Stuff__Group__2 ;
    public final void rule__Stuff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:133:1: ( rule__Stuff__Group__1__Impl rule__Stuff__Group__2 )
            // InternalTestLanguage.g:134:2: rule__Stuff__Group__1__Impl rule__Stuff__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Stuff__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Stuff__Group__2();

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
    // $ANTLR end "rule__Stuff__Group__1"


    // $ANTLR start "rule__Stuff__Group__1__Impl"
    // InternalTestLanguage.g:141:1: rule__Stuff__Group__1__Impl : ( ( rule__Stuff__NameAssignment_1 ) ) ;
    public final void rule__Stuff__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:145:1: ( ( ( rule__Stuff__NameAssignment_1 ) ) )
            // InternalTestLanguage.g:146:1: ( ( rule__Stuff__NameAssignment_1 ) )
            {
            // InternalTestLanguage.g:146:1: ( ( rule__Stuff__NameAssignment_1 ) )
            // InternalTestLanguage.g:147:2: ( rule__Stuff__NameAssignment_1 )
            {
             before(grammarAccess.getStuffAccess().getNameAssignment_1()); 
            // InternalTestLanguage.g:148:2: ( rule__Stuff__NameAssignment_1 )
            // InternalTestLanguage.g:148:3: rule__Stuff__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Stuff__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStuffAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Stuff__Group__1__Impl"


    // $ANTLR start "rule__Stuff__Group__2"
    // InternalTestLanguage.g:156:1: rule__Stuff__Group__2 : rule__Stuff__Group__2__Impl ;
    public final void rule__Stuff__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:160:1: ( rule__Stuff__Group__2__Impl )
            // InternalTestLanguage.g:161:2: rule__Stuff__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Stuff__Group__2__Impl();

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
    // $ANTLR end "rule__Stuff__Group__2"


    // $ANTLR start "rule__Stuff__Group__2__Impl"
    // InternalTestLanguage.g:167:1: rule__Stuff__Group__2__Impl : ( ( rule__Stuff__Group_2__0 )? ) ;
    public final void rule__Stuff__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:171:1: ( ( ( rule__Stuff__Group_2__0 )? ) )
            // InternalTestLanguage.g:172:1: ( ( rule__Stuff__Group_2__0 )? )
            {
            // InternalTestLanguage.g:172:1: ( ( rule__Stuff__Group_2__0 )? )
            // InternalTestLanguage.g:173:2: ( rule__Stuff__Group_2__0 )?
            {
             before(grammarAccess.getStuffAccess().getGroup_2()); 
            // InternalTestLanguage.g:174:2: ( rule__Stuff__Group_2__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTestLanguage.g:174:3: rule__Stuff__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Stuff__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStuffAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Stuff__Group__2__Impl"


    // $ANTLR start "rule__Stuff__Group_2__0"
    // InternalTestLanguage.g:183:1: rule__Stuff__Group_2__0 : rule__Stuff__Group_2__0__Impl rule__Stuff__Group_2__1 ;
    public final void rule__Stuff__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:187:1: ( rule__Stuff__Group_2__0__Impl rule__Stuff__Group_2__1 )
            // InternalTestLanguage.g:188:2: rule__Stuff__Group_2__0__Impl rule__Stuff__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Stuff__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Stuff__Group_2__1();

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
    // $ANTLR end "rule__Stuff__Group_2__0"


    // $ANTLR start "rule__Stuff__Group_2__0__Impl"
    // InternalTestLanguage.g:195:1: rule__Stuff__Group_2__0__Impl : ( 'refs' ) ;
    public final void rule__Stuff__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:199:1: ( ( 'refs' ) )
            // InternalTestLanguage.g:200:1: ( 'refs' )
            {
            // InternalTestLanguage.g:200:1: ( 'refs' )
            // InternalTestLanguage.g:201:2: 'refs'
            {
             before(grammarAccess.getStuffAccess().getRefsKeyword_2_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStuffAccess().getRefsKeyword_2_0()); 

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
    // $ANTLR end "rule__Stuff__Group_2__0__Impl"


    // $ANTLR start "rule__Stuff__Group_2__1"
    // InternalTestLanguage.g:210:1: rule__Stuff__Group_2__1 : rule__Stuff__Group_2__1__Impl ;
    public final void rule__Stuff__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:214:1: ( rule__Stuff__Group_2__1__Impl )
            // InternalTestLanguage.g:215:2: rule__Stuff__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Stuff__Group_2__1__Impl();

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
    // $ANTLR end "rule__Stuff__Group_2__1"


    // $ANTLR start "rule__Stuff__Group_2__1__Impl"
    // InternalTestLanguage.g:221:1: rule__Stuff__Group_2__1__Impl : ( ( rule__Stuff__RefsAssignment_2_1 ) ) ;
    public final void rule__Stuff__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:225:1: ( ( ( rule__Stuff__RefsAssignment_2_1 ) ) )
            // InternalTestLanguage.g:226:1: ( ( rule__Stuff__RefsAssignment_2_1 ) )
            {
            // InternalTestLanguage.g:226:1: ( ( rule__Stuff__RefsAssignment_2_1 ) )
            // InternalTestLanguage.g:227:2: ( rule__Stuff__RefsAssignment_2_1 )
            {
             before(grammarAccess.getStuffAccess().getRefsAssignment_2_1()); 
            // InternalTestLanguage.g:228:2: ( rule__Stuff__RefsAssignment_2_1 )
            // InternalTestLanguage.g:228:3: rule__Stuff__RefsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Stuff__RefsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getStuffAccess().getRefsAssignment_2_1()); 

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
    // $ANTLR end "rule__Stuff__Group_2__1__Impl"


    // $ANTLR start "rule__File__StuffAssignment"
    // InternalTestLanguage.g:237:1: rule__File__StuffAssignment : ( ruleStuff ) ;
    public final void rule__File__StuffAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:241:1: ( ( ruleStuff ) )
            // InternalTestLanguage.g:242:2: ( ruleStuff )
            {
            // InternalTestLanguage.g:242:2: ( ruleStuff )
            // InternalTestLanguage.g:243:3: ruleStuff
            {
             before(grammarAccess.getFileAccess().getStuffStuffParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleStuff();

            state._fsp--;

             after(grammarAccess.getFileAccess().getStuffStuffParserRuleCall_0()); 

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
    // $ANTLR end "rule__File__StuffAssignment"


    // $ANTLR start "rule__Stuff__NameAssignment_1"
    // InternalTestLanguage.g:252:1: rule__Stuff__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Stuff__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:256:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:257:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:257:2: ( RULE_ID )
            // InternalTestLanguage.g:258:3: RULE_ID
            {
             before(grammarAccess.getStuffAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStuffAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Stuff__NameAssignment_1"


    // $ANTLR start "rule__Stuff__RefsAssignment_2_1"
    // InternalTestLanguage.g:267:1: rule__Stuff__RefsAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Stuff__RefsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:271:1: ( ( ( RULE_ID ) ) )
            // InternalTestLanguage.g:272:2: ( ( RULE_ID ) )
            {
            // InternalTestLanguage.g:272:2: ( ( RULE_ID ) )
            // InternalTestLanguage.g:273:3: ( RULE_ID )
            {
             before(grammarAccess.getStuffAccess().getRefsStuffCrossReference_2_1_0()); 
            // InternalTestLanguage.g:274:3: ( RULE_ID )
            // InternalTestLanguage.g:275:4: RULE_ID
            {
             before(grammarAccess.getStuffAccess().getRefsStuffIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStuffAccess().getRefsStuffIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getStuffAccess().getRefsStuffCrossReference_2_1_0()); 

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
    // $ANTLR end "rule__Stuff__RefsAssignment_2_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    }


}
package org.eclipse.xtext.generator.ecore.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.generator.ecore.services.SuperTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSuperTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'super'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalSuperTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSuperTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSuperTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSuperTestLanguage.g"; }


    	private SuperTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(SuperTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleSuperMain"
    // InternalSuperTestLanguage.g:53:1: entryRuleSuperMain : ruleSuperMain EOF ;
    public final void entryRuleSuperMain() throws RecognitionException {
        try {
            // InternalSuperTestLanguage.g:54:1: ( ruleSuperMain EOF )
            // InternalSuperTestLanguage.g:55:1: ruleSuperMain EOF
            {
             before(grammarAccess.getSuperMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSuperMain();

            state._fsp--;

             after(grammarAccess.getSuperMainRule()); 
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
    // $ANTLR end "entryRuleSuperMain"


    // $ANTLR start "ruleSuperMain"
    // InternalSuperTestLanguage.g:62:1: ruleSuperMain : ( ( rule__SuperMain__Group__0 ) ) ;
    public final void ruleSuperMain() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSuperTestLanguage.g:66:2: ( ( ( rule__SuperMain__Group__0 ) ) )
            // InternalSuperTestLanguage.g:67:2: ( ( rule__SuperMain__Group__0 ) )
            {
            // InternalSuperTestLanguage.g:67:2: ( ( rule__SuperMain__Group__0 ) )
            // InternalSuperTestLanguage.g:68:3: ( rule__SuperMain__Group__0 )
            {
             before(grammarAccess.getSuperMainAccess().getGroup()); 
            // InternalSuperTestLanguage.g:69:3: ( rule__SuperMain__Group__0 )
            // InternalSuperTestLanguage.g:69:4: rule__SuperMain__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SuperMain__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSuperMainAccess().getGroup()); 

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
    // $ANTLR end "ruleSuperMain"


    // $ANTLR start "rule__SuperMain__Group__0"
    // InternalSuperTestLanguage.g:77:1: rule__SuperMain__Group__0 : rule__SuperMain__Group__0__Impl rule__SuperMain__Group__1 ;
    public final void rule__SuperMain__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSuperTestLanguage.g:81:1: ( rule__SuperMain__Group__0__Impl rule__SuperMain__Group__1 )
            // InternalSuperTestLanguage.g:82:2: rule__SuperMain__Group__0__Impl rule__SuperMain__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__SuperMain__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SuperMain__Group__1();

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
    // $ANTLR end "rule__SuperMain__Group__0"


    // $ANTLR start "rule__SuperMain__Group__0__Impl"
    // InternalSuperTestLanguage.g:89:1: rule__SuperMain__Group__0__Impl : ( 'super' ) ;
    public final void rule__SuperMain__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSuperTestLanguage.g:93:1: ( ( 'super' ) )
            // InternalSuperTestLanguage.g:94:1: ( 'super' )
            {
            // InternalSuperTestLanguage.g:94:1: ( 'super' )
            // InternalSuperTestLanguage.g:95:2: 'super'
            {
             before(grammarAccess.getSuperMainAccess().getSuperKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSuperMainAccess().getSuperKeyword_0()); 

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
    // $ANTLR end "rule__SuperMain__Group__0__Impl"


    // $ANTLR start "rule__SuperMain__Group__1"
    // InternalSuperTestLanguage.g:104:1: rule__SuperMain__Group__1 : rule__SuperMain__Group__1__Impl ;
    public final void rule__SuperMain__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSuperTestLanguage.g:108:1: ( rule__SuperMain__Group__1__Impl )
            // InternalSuperTestLanguage.g:109:2: rule__SuperMain__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SuperMain__Group__1__Impl();

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
    // $ANTLR end "rule__SuperMain__Group__1"


    // $ANTLR start "rule__SuperMain__Group__1__Impl"
    // InternalSuperTestLanguage.g:115:1: rule__SuperMain__Group__1__Impl : ( ( rule__SuperMain__NameAssignment_1 ) ) ;
    public final void rule__SuperMain__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSuperTestLanguage.g:119:1: ( ( ( rule__SuperMain__NameAssignment_1 ) ) )
            // InternalSuperTestLanguage.g:120:1: ( ( rule__SuperMain__NameAssignment_1 ) )
            {
            // InternalSuperTestLanguage.g:120:1: ( ( rule__SuperMain__NameAssignment_1 ) )
            // InternalSuperTestLanguage.g:121:2: ( rule__SuperMain__NameAssignment_1 )
            {
             before(grammarAccess.getSuperMainAccess().getNameAssignment_1()); 
            // InternalSuperTestLanguage.g:122:2: ( rule__SuperMain__NameAssignment_1 )
            // InternalSuperTestLanguage.g:122:3: rule__SuperMain__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SuperMain__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSuperMainAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__SuperMain__Group__1__Impl"


    // $ANTLR start "rule__SuperMain__NameAssignment_1"
    // InternalSuperTestLanguage.g:131:1: rule__SuperMain__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SuperMain__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSuperTestLanguage.g:135:1: ( ( RULE_ID ) )
            // InternalSuperTestLanguage.g:136:2: ( RULE_ID )
            {
            // InternalSuperTestLanguage.g:136:2: ( RULE_ID )
            // InternalSuperTestLanguage.g:137:3: RULE_ID
            {
             before(grammarAccess.getSuperMainAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSuperMainAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__SuperMain__NameAssignment_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    }


}
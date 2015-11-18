package org.eclipse.xtext.lexer.ide.contentassist.antlr.internal;
import java.util.Map;
import java.util.HashMap;

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
import org.eclipse.xtext.lexer.services.BacktrackingLexerTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBacktrackingLexerTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Abc", "Efg", "RULE_CHARA", "RULE_CHARB", "RULE_CHARX", "RULE_YC", "RULE_CHARY", "RULE_CHARC", "RULE_WS", "RULE_SL_COMMENT"
    };
    public static final int RULE_CHARX=8;
    public static final int RULE_YC=9;
    public static final int Efg=5;
    public static final int RULE_CHARY=10;
    public static final int Abc=4;
    public static final int RULE_WS=12;
    public static final int RULE_CHARA=6;
    public static final int RULE_SL_COMMENT=13;
    public static final int EOF=-1;
    public static final int RULE_CHARB=7;
    public static final int RULE_CHARC=11;

    // delegates
    // delegators


        public InternalBacktrackingLexerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBacktrackingLexerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[45+1];
             
             
        }
        

    public String[] getTokenNames() { return InternalBacktrackingLexerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBacktrackingLexerTestLanguageParser.g"; }


    	private BacktrackingLexerTestLanguageGrammarAccess grammarAccess;
    	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
    	
    	{
    		tokenNameToValue.put("Abc", "'Abc'");
    		tokenNameToValue.put("Efg", "'Efg'");
    	}

    	public void setGrammarAccess(BacktrackingLexerTestLanguageGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		String result = tokenNameToValue.get(tokenName);
    		if (result == null)
    			result = tokenName;
    		return result;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalBacktrackingLexerTestLanguageParser.g:59:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        int entryRuleModel_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:60:1: ( ruleModel EOF )
            // InternalBacktrackingLexerTestLanguageParser.g:61:1: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleModel_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBacktrackingLexerTestLanguageParser.g:68:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {
        int ruleModel_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:72:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalBacktrackingLexerTestLanguageParser.g:73:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:73:2: ( ( rule__Model__Group__0 ) )
            // InternalBacktrackingLexerTestLanguageParser.g:74:3: ( rule__Model__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getGroup()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:75:3: ( rule__Model__Group__0 )
            // InternalBacktrackingLexerTestLanguageParser.g:75:4: rule__Model__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, ruleModel_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAb"
    // InternalBacktrackingLexerTestLanguageParser.g:84:1: entryRuleAb : ruleAb EOF ;
    public final void entryRuleAb() throws RecognitionException {
        int entryRuleAb_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:85:1: ( ruleAb EOF )
            // InternalBacktrackingLexerTestLanguageParser.g:86:1: ruleAb EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAb();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleAb_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleAb"


    // $ANTLR start "ruleAb"
    // InternalBacktrackingLexerTestLanguageParser.g:93:1: ruleAb : ( ( rule__Ab__Group__0 ) ) ;
    public final void ruleAb() throws RecognitionException {
        int ruleAb_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:97:2: ( ( ( rule__Ab__Group__0 ) ) )
            // InternalBacktrackingLexerTestLanguageParser.g:98:2: ( ( rule__Ab__Group__0 ) )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:98:2: ( ( rule__Ab__Group__0 ) )
            // InternalBacktrackingLexerTestLanguageParser.g:99:3: ( rule__Ab__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbAccess().getGroup()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:100:3: ( rule__Ab__Group__0 )
            // InternalBacktrackingLexerTestLanguageParser.g:100:4: rule__Ab__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Ab__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, ruleAb_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAb"


    // $ANTLR start "entryRuleXb"
    // InternalBacktrackingLexerTestLanguageParser.g:109:1: entryRuleXb : ruleXb EOF ;
    public final void entryRuleXb() throws RecognitionException {
        int entryRuleXb_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:110:1: ( ruleXb EOF )
            // InternalBacktrackingLexerTestLanguageParser.g:111:1: ruleXb EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXbRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXb();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXbRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleXb_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleXb"


    // $ANTLR start "ruleXb"
    // InternalBacktrackingLexerTestLanguageParser.g:118:1: ruleXb : ( ( rule__Xb__Group__0 ) ) ;
    public final void ruleXb() throws RecognitionException {
        int ruleXb_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:122:2: ( ( ( rule__Xb__Group__0 ) ) )
            // InternalBacktrackingLexerTestLanguageParser.g:123:2: ( ( rule__Xb__Group__0 ) )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:123:2: ( ( rule__Xb__Group__0 ) )
            // InternalBacktrackingLexerTestLanguageParser.g:124:3: ( rule__Xb__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXbAccess().getGroup()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:125:3: ( rule__Xb__Group__0 )
            // InternalBacktrackingLexerTestLanguageParser.g:125:4: rule__Xb__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Xb__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXbAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, ruleXb_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXb"


    // $ANTLR start "ruleEnumName"
    // InternalBacktrackingLexerTestLanguageParser.g:134:1: ruleEnumName : ( ( rule__EnumName__Alternatives ) ) ;
    public final void ruleEnumName() throws RecognitionException {
        int ruleEnumName_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:138:1: ( ( ( rule__EnumName__Alternatives ) ) )
            // InternalBacktrackingLexerTestLanguageParser.g:139:2: ( ( rule__EnumName__Alternatives ) )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:139:2: ( ( rule__EnumName__Alternatives ) )
            // InternalBacktrackingLexerTestLanguageParser.g:140:3: ( rule__EnumName__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumNameAccess().getAlternatives()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:141:3: ( rule__EnumName__Alternatives )
            // InternalBacktrackingLexerTestLanguageParser.g:141:4: rule__EnumName__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumName__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumNameAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, ruleEnumName_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumName"


    // $ANTLR start "rule__EnumName__Alternatives"
    // InternalBacktrackingLexerTestLanguageParser.g:149:1: rule__EnumName__Alternatives : ( ( ( Abc ) ) | ( ( Efg ) ) );
    public final void rule__EnumName__Alternatives() throws RecognitionException {
        int rule__EnumName__Alternatives_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:153:1: ( ( ( Abc ) ) | ( ( Efg ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Abc) ) {
                alt1=1;
            }
            else if ( (LA1_0==Efg) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBacktrackingLexerTestLanguageParser.g:154:2: ( ( Abc ) )
                    {
                    // InternalBacktrackingLexerTestLanguageParser.g:154:2: ( ( Abc ) )
                    // InternalBacktrackingLexerTestLanguageParser.g:155:3: ( Abc )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEnumNameAccess().getAbcEnumLiteralDeclaration_0()); 
                    }
                    // InternalBacktrackingLexerTestLanguageParser.g:156:3: ( Abc )
                    // InternalBacktrackingLexerTestLanguageParser.g:156:4: Abc
                    {
                    match(input,Abc,FollowSets000.FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEnumNameAccess().getAbcEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBacktrackingLexerTestLanguageParser.g:160:2: ( ( Efg ) )
                    {
                    // InternalBacktrackingLexerTestLanguageParser.g:160:2: ( ( Efg ) )
                    // InternalBacktrackingLexerTestLanguageParser.g:161:3: ( Efg )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEnumNameAccess().getEfgEnumLiteralDeclaration_1()); 
                    }
                    // InternalBacktrackingLexerTestLanguageParser.g:162:3: ( Efg )
                    // InternalBacktrackingLexerTestLanguageParser.g:162:4: Efg
                    {
                    match(input,Efg,FollowSets000.FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEnumNameAccess().getEfgEnumLiteralDeclaration_1()); 
                    }

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
            if ( state.backtracking>0 ) { memoize(input, 8, rule__EnumName__Alternatives_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumName__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // InternalBacktrackingLexerTestLanguageParser.g:170:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {
        int rule__Model__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:174:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalBacktrackingLexerTestLanguageParser.g:175:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, rule__Model__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalBacktrackingLexerTestLanguageParser.g:182:1: rule__Model__Group__0__Impl : ( ( rule__Model__EnumsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {
        int rule__Model__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:186:1: ( ( ( rule__Model__EnumsAssignment_0 )* ) )
            // InternalBacktrackingLexerTestLanguageParser.g:187:1: ( ( rule__Model__EnumsAssignment_0 )* )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:187:1: ( ( rule__Model__EnumsAssignment_0 )* )
            // InternalBacktrackingLexerTestLanguageParser.g:188:2: ( rule__Model__EnumsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getEnumsAssignment_0()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:189:2: ( rule__Model__EnumsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=Abc && LA2_0<=Efg)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBacktrackingLexerTestLanguageParser.g:189:3: rule__Model__EnumsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__Model__EnumsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getEnumsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, rule__Model__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalBacktrackingLexerTestLanguageParser.g:197:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {
        int rule__Model__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:201:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalBacktrackingLexerTestLanguageParser.g:202:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, rule__Model__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalBacktrackingLexerTestLanguageParser.g:209:1: rule__Model__Group__1__Impl : ( ( rule__Model__YcsAssignment_1 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {
        int rule__Model__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:213:1: ( ( ( rule__Model__YcsAssignment_1 )* ) )
            // InternalBacktrackingLexerTestLanguageParser.g:214:1: ( ( rule__Model__YcsAssignment_1 )* )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:214:1: ( ( rule__Model__YcsAssignment_1 )* )
            // InternalBacktrackingLexerTestLanguageParser.g:215:2: ( rule__Model__YcsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getYcsAssignment_1()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:216:2: ( rule__Model__YcsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_YC) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBacktrackingLexerTestLanguageParser.g:216:3: rule__Model__YcsAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Model__YcsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getYcsAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, rule__Model__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // InternalBacktrackingLexerTestLanguageParser.g:224:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {
        int rule__Model__Group__2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:228:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalBacktrackingLexerTestLanguageParser.g:229:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, rule__Model__Group__2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // InternalBacktrackingLexerTestLanguageParser.g:236:1: rule__Model__Group__2__Impl : ( ( rule__Model__AbsAssignment_2 )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {
        int rule__Model__Group__2__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:240:1: ( ( ( rule__Model__AbsAssignment_2 )* ) )
            // InternalBacktrackingLexerTestLanguageParser.g:241:1: ( ( rule__Model__AbsAssignment_2 )* )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:241:1: ( ( rule__Model__AbsAssignment_2 )* )
            // InternalBacktrackingLexerTestLanguageParser.g:242:2: ( rule__Model__AbsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getAbsAssignment_2()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:243:2: ( rule__Model__AbsAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_CHARA) ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==RULE_CHARB) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // InternalBacktrackingLexerTestLanguageParser.g:243:3: rule__Model__AbsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    rule__Model__AbsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getAbsAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, rule__Model__Group__2__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // InternalBacktrackingLexerTestLanguageParser.g:251:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {
        int rule__Model__Group__3_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:255:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalBacktrackingLexerTestLanguageParser.g:256:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, rule__Model__Group__3_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // InternalBacktrackingLexerTestLanguageParser.g:263:1: rule__Model__Group__3__Impl : ( ( rule__Model__XbsAssignment_3 )* ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {
        int rule__Model__Group__3__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:267:1: ( ( ( rule__Model__XbsAssignment_3 )* ) )
            // InternalBacktrackingLexerTestLanguageParser.g:268:1: ( ( rule__Model__XbsAssignment_3 )* )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:268:1: ( ( rule__Model__XbsAssignment_3 )* )
            // InternalBacktrackingLexerTestLanguageParser.g:269:2: ( rule__Model__XbsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getXbsAssignment_3()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:270:2: ( rule__Model__XbsAssignment_3 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_CHARX) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBacktrackingLexerTestLanguageParser.g:270:3: rule__Model__XbsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Model__XbsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getXbsAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, rule__Model__Group__3__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // InternalBacktrackingLexerTestLanguageParser.g:278:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {
        int rule__Model__Group__4_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:282:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // InternalBacktrackingLexerTestLanguageParser.g:283:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, rule__Model__Group__4_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // InternalBacktrackingLexerTestLanguageParser.g:290:1: rule__Model__Group__4__Impl : ( ( rule__Model__YsAssignment_4 )* ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {
        int rule__Model__Group__4__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:294:1: ( ( ( rule__Model__YsAssignment_4 )* ) )
            // InternalBacktrackingLexerTestLanguageParser.g:295:1: ( ( rule__Model__YsAssignment_4 )* )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:295:1: ( ( rule__Model__YsAssignment_4 )* )
            // InternalBacktrackingLexerTestLanguageParser.g:296:2: ( rule__Model__YsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getYsAssignment_4()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:297:2: ( rule__Model__YsAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_CHARY) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBacktrackingLexerTestLanguageParser.g:297:3: rule__Model__YsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Model__YsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getYsAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, rule__Model__Group__4__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__Model__Group__5"
    // InternalBacktrackingLexerTestLanguageParser.g:305:1: rule__Model__Group__5 : rule__Model__Group__5__Impl ;
    public final void rule__Model__Group__5() throws RecognitionException {
        int rule__Model__Group__5_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:309:1: ( rule__Model__Group__5__Impl )
            // InternalBacktrackingLexerTestLanguageParser.g:310:2: rule__Model__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, rule__Model__Group__5_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5"


    // $ANTLR start "rule__Model__Group__5__Impl"
    // InternalBacktrackingLexerTestLanguageParser.g:316:1: rule__Model__Group__5__Impl : ( ( rule__Model__AsAssignment_5 )* ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {
        int rule__Model__Group__5__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:320:1: ( ( ( rule__Model__AsAssignment_5 )* ) )
            // InternalBacktrackingLexerTestLanguageParser.g:321:1: ( ( rule__Model__AsAssignment_5 )* )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:321:1: ( ( rule__Model__AsAssignment_5 )* )
            // InternalBacktrackingLexerTestLanguageParser.g:322:2: ( rule__Model__AsAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getAsAssignment_5()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:323:2: ( rule__Model__AsAssignment_5 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_CHARA) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBacktrackingLexerTestLanguageParser.g:323:3: rule__Model__AsAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    rule__Model__AsAssignment_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getAsAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, rule__Model__Group__5__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5__Impl"


    // $ANTLR start "rule__Ab__Group__0"
    // InternalBacktrackingLexerTestLanguageParser.g:332:1: rule__Ab__Group__0 : rule__Ab__Group__0__Impl rule__Ab__Group__1 ;
    public final void rule__Ab__Group__0() throws RecognitionException {
        int rule__Ab__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:336:1: ( rule__Ab__Group__0__Impl rule__Ab__Group__1 )
            // InternalBacktrackingLexerTestLanguageParser.g:337:2: rule__Ab__Group__0__Impl rule__Ab__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Ab__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Ab__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, rule__Ab__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ab__Group__0"


    // $ANTLR start "rule__Ab__Group__0__Impl"
    // InternalBacktrackingLexerTestLanguageParser.g:344:1: rule__Ab__Group__0__Impl : ( ( rule__Ab__XAssignment_0 ) ) ;
    public final void rule__Ab__Group__0__Impl() throws RecognitionException {
        int rule__Ab__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:348:1: ( ( ( rule__Ab__XAssignment_0 ) ) )
            // InternalBacktrackingLexerTestLanguageParser.g:349:1: ( ( rule__Ab__XAssignment_0 ) )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:349:1: ( ( rule__Ab__XAssignment_0 ) )
            // InternalBacktrackingLexerTestLanguageParser.g:350:2: ( rule__Ab__XAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbAccess().getXAssignment_0()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:351:2: ( rule__Ab__XAssignment_0 )
            // InternalBacktrackingLexerTestLanguageParser.g:351:3: rule__Ab__XAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Ab__XAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbAccess().getXAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, rule__Ab__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ab__Group__0__Impl"


    // $ANTLR start "rule__Ab__Group__1"
    // InternalBacktrackingLexerTestLanguageParser.g:359:1: rule__Ab__Group__1 : rule__Ab__Group__1__Impl ;
    public final void rule__Ab__Group__1() throws RecognitionException {
        int rule__Ab__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:363:1: ( rule__Ab__Group__1__Impl )
            // InternalBacktrackingLexerTestLanguageParser.g:364:2: rule__Ab__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Ab__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, rule__Ab__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ab__Group__1"


    // $ANTLR start "rule__Ab__Group__1__Impl"
    // InternalBacktrackingLexerTestLanguageParser.g:370:1: rule__Ab__Group__1__Impl : ( ( rule__Ab__YAssignment_1 ) ) ;
    public final void rule__Ab__Group__1__Impl() throws RecognitionException {
        int rule__Ab__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:374:1: ( ( ( rule__Ab__YAssignment_1 ) ) )
            // InternalBacktrackingLexerTestLanguageParser.g:375:1: ( ( rule__Ab__YAssignment_1 ) )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:375:1: ( ( rule__Ab__YAssignment_1 ) )
            // InternalBacktrackingLexerTestLanguageParser.g:376:2: ( rule__Ab__YAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbAccess().getYAssignment_1()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:377:2: ( rule__Ab__YAssignment_1 )
            // InternalBacktrackingLexerTestLanguageParser.g:377:3: rule__Ab__YAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Ab__YAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbAccess().getYAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, rule__Ab__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ab__Group__1__Impl"


    // $ANTLR start "rule__Xb__Group__0"
    // InternalBacktrackingLexerTestLanguageParser.g:386:1: rule__Xb__Group__0 : rule__Xb__Group__0__Impl rule__Xb__Group__1 ;
    public final void rule__Xb__Group__0() throws RecognitionException {
        int rule__Xb__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:390:1: ( rule__Xb__Group__0__Impl rule__Xb__Group__1 )
            // InternalBacktrackingLexerTestLanguageParser.g:391:2: rule__Xb__Group__0__Impl rule__Xb__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Xb__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Xb__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, rule__Xb__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xb__Group__0"


    // $ANTLR start "rule__Xb__Group__0__Impl"
    // InternalBacktrackingLexerTestLanguageParser.g:398:1: rule__Xb__Group__0__Impl : ( ( rule__Xb__XAssignment_0 ) ) ;
    public final void rule__Xb__Group__0__Impl() throws RecognitionException {
        int rule__Xb__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:402:1: ( ( ( rule__Xb__XAssignment_0 ) ) )
            // InternalBacktrackingLexerTestLanguageParser.g:403:1: ( ( rule__Xb__XAssignment_0 ) )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:403:1: ( ( rule__Xb__XAssignment_0 ) )
            // InternalBacktrackingLexerTestLanguageParser.g:404:2: ( rule__Xb__XAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXbAccess().getXAssignment_0()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:405:2: ( rule__Xb__XAssignment_0 )
            // InternalBacktrackingLexerTestLanguageParser.g:405:3: rule__Xb__XAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Xb__XAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXbAccess().getXAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, rule__Xb__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xb__Group__0__Impl"


    // $ANTLR start "rule__Xb__Group__1"
    // InternalBacktrackingLexerTestLanguageParser.g:413:1: rule__Xb__Group__1 : rule__Xb__Group__1__Impl ;
    public final void rule__Xb__Group__1() throws RecognitionException {
        int rule__Xb__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:417:1: ( rule__Xb__Group__1__Impl )
            // InternalBacktrackingLexerTestLanguageParser.g:418:2: rule__Xb__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Xb__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, rule__Xb__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xb__Group__1"


    // $ANTLR start "rule__Xb__Group__1__Impl"
    // InternalBacktrackingLexerTestLanguageParser.g:424:1: rule__Xb__Group__1__Impl : ( ( rule__Xb__YAssignment_1 ) ) ;
    public final void rule__Xb__Group__1__Impl() throws RecognitionException {
        int rule__Xb__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:428:1: ( ( ( rule__Xb__YAssignment_1 ) ) )
            // InternalBacktrackingLexerTestLanguageParser.g:429:1: ( ( rule__Xb__YAssignment_1 ) )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:429:1: ( ( rule__Xb__YAssignment_1 ) )
            // InternalBacktrackingLexerTestLanguageParser.g:430:2: ( rule__Xb__YAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXbAccess().getYAssignment_1()); 
            }
            // InternalBacktrackingLexerTestLanguageParser.g:431:2: ( rule__Xb__YAssignment_1 )
            // InternalBacktrackingLexerTestLanguageParser.g:431:3: rule__Xb__YAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Xb__YAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXbAccess().getYAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, rule__Xb__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xb__Group__1__Impl"


    // $ANTLR start "rule__Model__EnumsAssignment_0"
    // InternalBacktrackingLexerTestLanguageParser.g:440:1: rule__Model__EnumsAssignment_0 : ( ruleEnumName ) ;
    public final void rule__Model__EnumsAssignment_0() throws RecognitionException {
        int rule__Model__EnumsAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:444:1: ( ( ruleEnumName ) )
            // InternalBacktrackingLexerTestLanguageParser.g:445:2: ( ruleEnumName )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:445:2: ( ruleEnumName )
            // InternalBacktrackingLexerTestLanguageParser.g:446:3: ruleEnumName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getEnumsEnumNameEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getEnumsEnumNameEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, rule__Model__EnumsAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__EnumsAssignment_0"


    // $ANTLR start "rule__Model__YcsAssignment_1"
    // InternalBacktrackingLexerTestLanguageParser.g:455:1: rule__Model__YcsAssignment_1 : ( RULE_YC ) ;
    public final void rule__Model__YcsAssignment_1() throws RecognitionException {
        int rule__Model__YcsAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:459:1: ( ( RULE_YC ) )
            // InternalBacktrackingLexerTestLanguageParser.g:460:2: ( RULE_YC )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:460:2: ( RULE_YC )
            // InternalBacktrackingLexerTestLanguageParser.g:461:3: RULE_YC
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getYcsYcTerminalRuleCall_1_0()); 
            }
            match(input,RULE_YC,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getYcsYcTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, rule__Model__YcsAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__YcsAssignment_1"


    // $ANTLR start "rule__Model__AbsAssignment_2"
    // InternalBacktrackingLexerTestLanguageParser.g:470:1: rule__Model__AbsAssignment_2 : ( ruleAb ) ;
    public final void rule__Model__AbsAssignment_2() throws RecognitionException {
        int rule__Model__AbsAssignment_2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:474:1: ( ( ruleAb ) )
            // InternalBacktrackingLexerTestLanguageParser.g:475:2: ( ruleAb )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:475:2: ( ruleAb )
            // InternalBacktrackingLexerTestLanguageParser.g:476:3: ruleAb
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getAbsAbParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAb();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getAbsAbParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, rule__Model__AbsAssignment_2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__AbsAssignment_2"


    // $ANTLR start "rule__Model__XbsAssignment_3"
    // InternalBacktrackingLexerTestLanguageParser.g:485:1: rule__Model__XbsAssignment_3 : ( ruleXb ) ;
    public final void rule__Model__XbsAssignment_3() throws RecognitionException {
        int rule__Model__XbsAssignment_3_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:489:1: ( ( ruleXb ) )
            // InternalBacktrackingLexerTestLanguageParser.g:490:2: ( ruleXb )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:490:2: ( ruleXb )
            // InternalBacktrackingLexerTestLanguageParser.g:491:3: ruleXb
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getXbsXbParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXb();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getXbsXbParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, rule__Model__XbsAssignment_3_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__XbsAssignment_3"


    // $ANTLR start "rule__Model__YsAssignment_4"
    // InternalBacktrackingLexerTestLanguageParser.g:500:1: rule__Model__YsAssignment_4 : ( RULE_CHARY ) ;
    public final void rule__Model__YsAssignment_4() throws RecognitionException {
        int rule__Model__YsAssignment_4_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:504:1: ( ( RULE_CHARY ) )
            // InternalBacktrackingLexerTestLanguageParser.g:505:2: ( RULE_CHARY )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:505:2: ( RULE_CHARY )
            // InternalBacktrackingLexerTestLanguageParser.g:506:3: RULE_CHARY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getYsCharYTerminalRuleCall_4_0()); 
            }
            match(input,RULE_CHARY,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getYsCharYTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, rule__Model__YsAssignment_4_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__YsAssignment_4"


    // $ANTLR start "rule__Model__AsAssignment_5"
    // InternalBacktrackingLexerTestLanguageParser.g:515:1: rule__Model__AsAssignment_5 : ( RULE_CHARA ) ;
    public final void rule__Model__AsAssignment_5() throws RecognitionException {
        int rule__Model__AsAssignment_5_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:519:1: ( ( RULE_CHARA ) )
            // InternalBacktrackingLexerTestLanguageParser.g:520:2: ( RULE_CHARA )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:520:2: ( RULE_CHARA )
            // InternalBacktrackingLexerTestLanguageParser.g:521:3: RULE_CHARA
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getAsCharATerminalRuleCall_5_0()); 
            }
            match(input,RULE_CHARA,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getAsCharATerminalRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, rule__Model__AsAssignment_5_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__AsAssignment_5"


    // $ANTLR start "rule__Ab__XAssignment_0"
    // InternalBacktrackingLexerTestLanguageParser.g:530:1: rule__Ab__XAssignment_0 : ( RULE_CHARA ) ;
    public final void rule__Ab__XAssignment_0() throws RecognitionException {
        int rule__Ab__XAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:534:1: ( ( RULE_CHARA ) )
            // InternalBacktrackingLexerTestLanguageParser.g:535:2: ( RULE_CHARA )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:535:2: ( RULE_CHARA )
            // InternalBacktrackingLexerTestLanguageParser.g:536:3: RULE_CHARA
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbAccess().getXCharATerminalRuleCall_0_0()); 
            }
            match(input,RULE_CHARA,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbAccess().getXCharATerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, rule__Ab__XAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ab__XAssignment_0"


    // $ANTLR start "rule__Ab__YAssignment_1"
    // InternalBacktrackingLexerTestLanguageParser.g:545:1: rule__Ab__YAssignment_1 : ( RULE_CHARB ) ;
    public final void rule__Ab__YAssignment_1() throws RecognitionException {
        int rule__Ab__YAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:549:1: ( ( RULE_CHARB ) )
            // InternalBacktrackingLexerTestLanguageParser.g:550:2: ( RULE_CHARB )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:550:2: ( RULE_CHARB )
            // InternalBacktrackingLexerTestLanguageParser.g:551:3: RULE_CHARB
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbAccess().getYCharbTerminalRuleCall_1_0()); 
            }
            match(input,RULE_CHARB,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbAccess().getYCharbTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, rule__Ab__YAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ab__YAssignment_1"


    // $ANTLR start "rule__Xb__XAssignment_0"
    // InternalBacktrackingLexerTestLanguageParser.g:560:1: rule__Xb__XAssignment_0 : ( RULE_CHARX ) ;
    public final void rule__Xb__XAssignment_0() throws RecognitionException {
        int rule__Xb__XAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:564:1: ( ( RULE_CHARX ) )
            // InternalBacktrackingLexerTestLanguageParser.g:565:2: ( RULE_CHARX )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:565:2: ( RULE_CHARX )
            // InternalBacktrackingLexerTestLanguageParser.g:566:3: RULE_CHARX
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXbAccess().getXCharXTerminalRuleCall_0_0()); 
            }
            match(input,RULE_CHARX,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXbAccess().getXCharXTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, rule__Xb__XAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xb__XAssignment_0"


    // $ANTLR start "rule__Xb__YAssignment_1"
    // InternalBacktrackingLexerTestLanguageParser.g:575:1: rule__Xb__YAssignment_1 : ( RULE_CHARB ) ;
    public final void rule__Xb__YAssignment_1() throws RecognitionException {
        int rule__Xb__YAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }
            // InternalBacktrackingLexerTestLanguageParser.g:579:1: ( ( RULE_CHARB ) )
            // InternalBacktrackingLexerTestLanguageParser.g:580:2: ( RULE_CHARB )
            {
            // InternalBacktrackingLexerTestLanguageParser.g:580:2: ( RULE_CHARB )
            // InternalBacktrackingLexerTestLanguageParser.g:581:3: RULE_CHARB
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXbAccess().getYCharbTerminalRuleCall_1_0()); 
            }
            match(input,RULE_CHARB,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXbAccess().getYCharbTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, rule__Xb__YAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xb__YAssignment_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000740L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000202L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000102L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000402L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000080L});
    }


}
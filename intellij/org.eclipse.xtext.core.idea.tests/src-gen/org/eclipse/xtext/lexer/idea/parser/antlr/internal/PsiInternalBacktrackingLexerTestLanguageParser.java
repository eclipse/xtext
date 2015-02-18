package org.eclipse.xtext.lexer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.lexer.services.BacktrackingLexerTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalBacktrackingLexerTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_YC", "RULE_CHARY", "RULE_CHARA", "RULE_CHARB", "RULE_CHARX", "RULE_CHARC", "RULE_WS", "RULE_SL_COMMENT", "'Abc'", "'Efg'"
    };
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int RULE_CHARX=8;
    public static final int RULE_YC=4;
    public static final int RULE_CHARY=5;
    public static final int RULE_WS=10;
    public static final int RULE_CHARA=6;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_CHARB=7;
    public static final int EOF=-1;
    public static final int RULE_CHARC=9;

    // delegates
    // delegators


        public PsiInternalBacktrackingLexerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBacktrackingLexerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[14+1];
             
             
        }
        

    public String[] getTokenNames() { return PsiInternalBacktrackingLexerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected BacktrackingLexerTestLanguageGrammarAccess grammarAccess;

    	protected BacktrackingLexerTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBacktrackingLexerTestLanguageParser(PsiBuilder builder, TokenStream input, BacktrackingLexerTestLanguageElementTypeProvider elementTypeProvider, BacktrackingLexerTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:57:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        int entryRuleModel_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:57:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:58:2: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel66);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel72); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:66:1: ruleModel : ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* ) ;
    public final void ruleModel() throws RecognitionException {
        int ruleModel_StartIndex = input.index();
        Token lv_ycs_1_0=null;
        Token lv_ys_4_0=null;
        Token lv_as_5_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:66:10: ( ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:67:2: ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:67:2: ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:68:3: ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:68:3: ( (lv_enums_0_0= ruleEnumName ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:69:4: (lv_enums_0_0= ruleEnumName )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:69:4: (lv_enums_0_0= ruleEnumName )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:70:5: lv_enums_0_0= ruleEnumName
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getModel_EnumsEnumNameEnumRuleCall_0_0ElementType());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumName_in_ruleModel108);
            	    ruleEnumName();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:79:3: ( (lv_ycs_1_0= RULE_YC ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_YC) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:80:4: (lv_ycs_1_0= RULE_YC )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:80:4: (lv_ycs_1_0= RULE_YC )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:81:5: lv_ycs_1_0= RULE_YC
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf();
            	      				
            	    }
            	    lv_ycs_1_0=(Token)match(input,RULE_YC,FollowSets000.FOLLOW_RULE_YC_in_ruleModel147); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(lv_ycs_1_0, elementTypeProvider.getModel_YcsYcTerminalRuleCall_1_0ElementType());
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:90:3: ( (lv_abs_2_0= ruleAb ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_CHARA) ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==RULE_CHARB) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:91:4: (lv_abs_2_0= ruleAb )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:91:4: (lv_abs_2_0= ruleAb )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:92:5: lv_abs_2_0= ruleAb
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getModel_AbsAbParserRuleCall_2_0ElementType());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAb_in_ruleModel186);
            	    ruleAb();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:101:3: ( (lv_xbs_3_0= ruleXb ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_CHARX) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:102:4: (lv_xbs_3_0= ruleXb )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:102:4: (lv_xbs_3_0= ruleXb )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:103:5: lv_xbs_3_0= ruleXb
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getModel_XbsXbParserRuleCall_3_0ElementType());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleXb_in_ruleModel225);
            	    ruleXb();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:112:3: ( (lv_ys_4_0= RULE_CHARY ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_CHARY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:113:4: (lv_ys_4_0= RULE_CHARY )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:113:4: (lv_ys_4_0= RULE_CHARY )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:114:5: lv_ys_4_0= RULE_CHARY
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf();
            	      				
            	    }
            	    lv_ys_4_0=(Token)match(input,RULE_CHARY,FollowSets000.FOLLOW_RULE_CHARY_in_ruleModel264); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(lv_ys_4_0, elementTypeProvider.getModel_YsCharYTerminalRuleCall_4_0ElementType());
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:123:3: ( (lv_as_5_0= RULE_CHARA ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_CHARA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:124:4: (lv_as_5_0= RULE_CHARA )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:124:4: (lv_as_5_0= RULE_CHARA )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:125:5: lv_as_5_0= RULE_CHARA
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf();
            	      				
            	    }
            	    lv_as_5_0=(Token)match(input,RULE_CHARA,FollowSets000.FOLLOW_RULE_CHARA_in_ruleModel303); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(lv_as_5_0, elementTypeProvider.getModel_AsCharATerminalRuleCall_5_0ElementType());
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, ruleModel_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAb"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:138:1: entryRuleAb : ruleAb EOF ;
    public final void entryRuleAb() throws RecognitionException {
        int entryRuleAb_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:138:12: ( ruleAb EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:139:2: ruleAb EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAbElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAb_in_entryRuleAb335);
            ruleAb();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAb341); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:147:1: ruleAb : ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) ;
    public final void ruleAb() throws RecognitionException {
        int ruleAb_StartIndex = input.index();
        Token lv_x_0_0=null;
        Token lv_y_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:147:7: ( ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:148:2: ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:148:2: ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:149:3: ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:149:3: ( (lv_x_0_0= RULE_CHARA ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:150:4: (lv_x_0_0= RULE_CHARA )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:150:4: (lv_x_0_0= RULE_CHARA )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:151:5: lv_x_0_0= RULE_CHARA
            {
            if ( state.backtracking==0 ) {

              					markLeaf();
              				
            }
            lv_x_0_0=(Token)match(input,RULE_CHARA,FollowSets000.FOLLOW_RULE_CHARA_in_ruleAb377); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_x_0_0, elementTypeProvider.getAb_XCharATerminalRuleCall_0_0ElementType());
              				
            }

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:160:3: ( (lv_y_1_0= RULE_CHARB ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:161:4: (lv_y_1_0= RULE_CHARB )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:161:4: (lv_y_1_0= RULE_CHARB )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:162:5: lv_y_1_0= RULE_CHARB
            {
            if ( state.backtracking==0 ) {

              					markLeaf();
              				
            }
            lv_y_1_0=(Token)match(input,RULE_CHARB,FollowSets000.FOLLOW_RULE_CHARB_in_ruleAb415); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_y_1_0, elementTypeProvider.getAb_YCharbTerminalRuleCall_1_0ElementType());
              				
            }

            }


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
        }
        return ;
    }
    // $ANTLR end "ruleAb"


    // $ANTLR start "entryRuleXb"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:175:1: entryRuleXb : ruleXb EOF ;
    public final void entryRuleXb() throws RecognitionException {
        int entryRuleXb_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:175:12: ( ruleXb EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:176:2: ruleXb EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXbElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleXb_in_entryRuleXb446);
            ruleXb();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleXb452); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:184:1: ruleXb : ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) ;
    public final void ruleXb() throws RecognitionException {
        int ruleXb_StartIndex = input.index();
        Token lv_x_0_0=null;
        Token lv_y_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:184:7: ( ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:185:2: ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:185:2: ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:186:3: ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:186:3: ( (lv_x_0_0= RULE_CHARX ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:187:4: (lv_x_0_0= RULE_CHARX )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:187:4: (lv_x_0_0= RULE_CHARX )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:188:5: lv_x_0_0= RULE_CHARX
            {
            if ( state.backtracking==0 ) {

              					markLeaf();
              				
            }
            lv_x_0_0=(Token)match(input,RULE_CHARX,FollowSets000.FOLLOW_RULE_CHARX_in_ruleXb488); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_x_0_0, elementTypeProvider.getXb_XCharXTerminalRuleCall_0_0ElementType());
              				
            }

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:197:3: ( (lv_y_1_0= RULE_CHARB ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:198:4: (lv_y_1_0= RULE_CHARB )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:198:4: (lv_y_1_0= RULE_CHARB )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:199:5: lv_y_1_0= RULE_CHARB
            {
            if ( state.backtracking==0 ) {

              					markLeaf();
              				
            }
            lv_y_1_0=(Token)match(input,RULE_CHARB,FollowSets000.FOLLOW_RULE_CHARB_in_ruleXb526); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_y_1_0, elementTypeProvider.getXb_YCharbTerminalRuleCall_1_0ElementType());
              				
            }

            }


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
        }
        return ;
    }
    // $ANTLR end "ruleXb"


    // $ANTLR start "ruleEnumName"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:212:1: ruleEnumName : ( (enumLiteral_0= 'Abc' ) | (enumLiteral_1= 'Efg' ) ) ;
    public final void ruleEnumName() throws RecognitionException {
        int ruleEnumName_StartIndex = input.index();
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:212:13: ( ( (enumLiteral_0= 'Abc' ) | (enumLiteral_1= 'Efg' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:213:2: ( (enumLiteral_0= 'Abc' ) | (enumLiteral_1= 'Efg' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:213:2: ( (enumLiteral_0= 'Abc' ) | (enumLiteral_1= 'Efg' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==12) ) {
                alt7=1;
            }
            else if ( (LA7_0==13) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:214:3: (enumLiteral_0= 'Abc' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:214:3: (enumLiteral_0= 'Abc' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:215:4: enumLiteral_0= 'Abc'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEnumName570); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(enumLiteral_0, elementTypeProvider.getEnumName_AbcEnumLiteralDeclaration_0ElementType());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:224:3: (enumLiteral_1= 'Efg' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:224:3: (enumLiteral_1= 'Efg' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/lexer/idea/parser/antlr/internal/PsiInternalBacktrackingLexerTestLanguage.g:225:4: enumLiteral_1= 'Efg'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    enumLiteral_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleEnumName603); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(enumLiteral_1, elementTypeProvider.getEnumName_EfgEnumLiteralDeclaration_1ElementType());
                      			
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, ruleEnumName_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleEnumName"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel66 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumName_in_ruleModel108 = new BitSet(new long[]{0x0000000000003172L});
        public static final BitSet FOLLOW_RULE_YC_in_ruleModel147 = new BitSet(new long[]{0x0000000000000172L});
        public static final BitSet FOLLOW_ruleAb_in_ruleModel186 = new BitSet(new long[]{0x0000000000000162L});
        public static final BitSet FOLLOW_ruleXb_in_ruleModel225 = new BitSet(new long[]{0x0000000000000162L});
        public static final BitSet FOLLOW_RULE_CHARY_in_ruleModel264 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_RULE_CHARA_in_ruleModel303 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_ruleAb_in_entryRuleAb335 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAb341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_CHARA_in_ruleAb377 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_CHARB_in_ruleAb415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleXb_in_entryRuleXb446 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleXb452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_CHARX_in_ruleXb488 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_CHARB_in_ruleXb526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleEnumName570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleEnumName603 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.lexer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Abc", "Efg", "RULE_CHARA", "RULE_CHARB", "RULE_CHARX", "RULE_YC", "RULE_CHARY", "RULE_CHARC", "RULE_WS", "RULE_SL_COMMENT", "FRAGMENT_RULE_CHARA", "FRAGMENT_RULE_CHARB", "FRAGMENT_RULE_CHARX", "FRAGMENT_RULE_YC", "FRAGMENT_RULE_CHARY", "FRAGMENT_RULE_WS", "FRAGMENT_RULE_SL_COMMENT", "'Abc'", "'Efg'"
    };
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int FRAGMENT_RULE_CHARY=18;
    public static final int FRAGMENT_RULE_CHARA=14;
    public static final int FRAGMENT_RULE_CHARX=16;
    public static final int RULE_CHARY=10;
    public static final int Abc=4;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=13;
    public static final int FRAGMENT_RULE_YC=17;
    public static final int FRAGMENT_RULE_CHARB=15;
    public static final int RULE_CHARX=8;
    public static final int FRAGMENT_RULE_SL_COMMENT=20;
    public static final int Efg=5;
    public static final int RULE_YC=9;
    public static final int FRAGMENT_RULE_WS=19;
    public static final int RULE_CHARA=6;
    public static final int RULE_WS=12;
    public static final int RULE_CHARB=7;
    public static final int RULE_CHARC=11;

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
    public String getGrammarFileName() { return "PsiInternalBacktrackingLexerTestLanguage.g"; }



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
    // PsiInternalBacktrackingLexerTestLanguage.g:71:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;
        int entryRuleModel_StartIndex = input.index();
        Boolean iv_ruleModel = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // PsiInternalBacktrackingLexerTestLanguage.g:71:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBacktrackingLexerTestLanguage.g:72:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalBacktrackingLexerTestLanguage.g:78:1: ruleModel returns [Boolean current=false] : ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;
        int ruleModel_StartIndex = input.index();
        Token lv_ycs_1_0=null;
        Token lv_ys_4_0=null;
        Token lv_as_5_0=null;
        Boolean lv_enums_0_0 = null;

        Boolean lv_abs_2_0 = null;

        Boolean lv_xbs_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // PsiInternalBacktrackingLexerTestLanguage.g:79:1: ( ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* ) )
            // PsiInternalBacktrackingLexerTestLanguage.g:80:2: ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* )
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:80:2: ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* )
            // PsiInternalBacktrackingLexerTestLanguage.g:81:3: ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )*
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:81:3: ( (lv_enums_0_0= ruleEnumName ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=21 && LA1_0<=22)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalBacktrackingLexerTestLanguage.g:82:4: (lv_enums_0_0= ruleEnumName )
            	    {
            	    // PsiInternalBacktrackingLexerTestLanguage.g:82:4: (lv_enums_0_0= ruleEnumName )
            	    // PsiInternalBacktrackingLexerTestLanguage.g:83:5: lv_enums_0_0= ruleEnumName
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getModel_EnumsEnumNameEnumRuleCall_0_0ElementType());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_enums_0_0=ruleEnumName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      					if(!current) {
            	      						associateWithSemanticElement();
            	      						current = true;
            	      					}
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // PsiInternalBacktrackingLexerTestLanguage.g:96:3: ( (lv_ycs_1_0= RULE_YC ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_YC) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalBacktrackingLexerTestLanguage.g:97:4: (lv_ycs_1_0= RULE_YC )
            	    {
            	    // PsiInternalBacktrackingLexerTestLanguage.g:97:4: (lv_ycs_1_0= RULE_YC )
            	    // PsiInternalBacktrackingLexerTestLanguage.g:98:5: lv_ycs_1_0= RULE_YC
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getModel_YcsYcTerminalRuleCall_1_0ElementType());
            	      				
            	    }
            	    lv_ycs_1_0=(Token)match(input,RULE_YC,FollowSets000.FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if(!current) {
            	      						associateWithSemanticElement();
            	      						current = true;
            	      					}
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(lv_ycs_1_0);
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // PsiInternalBacktrackingLexerTestLanguage.g:113:3: ( (lv_abs_2_0= ruleAb ) )*
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
            	    // PsiInternalBacktrackingLexerTestLanguage.g:114:4: (lv_abs_2_0= ruleAb )
            	    {
            	    // PsiInternalBacktrackingLexerTestLanguage.g:114:4: (lv_abs_2_0= ruleAb )
            	    // PsiInternalBacktrackingLexerTestLanguage.g:115:5: lv_abs_2_0= ruleAb
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getModel_AbsAbParserRuleCall_2_0ElementType());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_abs_2_0=ruleAb();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      					if(!current) {
            	      						associateWithSemanticElement();
            	      						current = true;
            	      					}
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // PsiInternalBacktrackingLexerTestLanguage.g:128:3: ( (lv_xbs_3_0= ruleXb ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_CHARX) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalBacktrackingLexerTestLanguage.g:129:4: (lv_xbs_3_0= ruleXb )
            	    {
            	    // PsiInternalBacktrackingLexerTestLanguage.g:129:4: (lv_xbs_3_0= ruleXb )
            	    // PsiInternalBacktrackingLexerTestLanguage.g:130:5: lv_xbs_3_0= ruleXb
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getModel_XbsXbParserRuleCall_3_0ElementType());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_xbs_3_0=ruleXb();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      					if(!current) {
            	      						associateWithSemanticElement();
            	      						current = true;
            	      					}
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // PsiInternalBacktrackingLexerTestLanguage.g:143:3: ( (lv_ys_4_0= RULE_CHARY ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_CHARY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalBacktrackingLexerTestLanguage.g:144:4: (lv_ys_4_0= RULE_CHARY )
            	    {
            	    // PsiInternalBacktrackingLexerTestLanguage.g:144:4: (lv_ys_4_0= RULE_CHARY )
            	    // PsiInternalBacktrackingLexerTestLanguage.g:145:5: lv_ys_4_0= RULE_CHARY
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getModel_YsCharYTerminalRuleCall_4_0ElementType());
            	      				
            	    }
            	    lv_ys_4_0=(Token)match(input,RULE_CHARY,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if(!current) {
            	      						associateWithSemanticElement();
            	      						current = true;
            	      					}
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(lv_ys_4_0);
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // PsiInternalBacktrackingLexerTestLanguage.g:160:3: ( (lv_as_5_0= RULE_CHARA ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_CHARA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalBacktrackingLexerTestLanguage.g:161:4: (lv_as_5_0= RULE_CHARA )
            	    {
            	    // PsiInternalBacktrackingLexerTestLanguage.g:161:4: (lv_as_5_0= RULE_CHARA )
            	    // PsiInternalBacktrackingLexerTestLanguage.g:162:5: lv_as_5_0= RULE_CHARA
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getModel_AsCharATerminalRuleCall_5_0ElementType());
            	      				
            	    }
            	    lv_as_5_0=(Token)match(input,RULE_CHARA,FollowSets000.FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if(!current) {
            	      						associateWithSemanticElement();
            	      						current = true;
            	      					}
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(lv_as_5_0);
            	      				
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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAb"
    // PsiInternalBacktrackingLexerTestLanguage.g:181:1: entryRuleAb returns [Boolean current=false] : iv_ruleAb= ruleAb EOF ;
    public final Boolean entryRuleAb() throws RecognitionException {
        Boolean current = false;
        int entryRuleAb_StartIndex = input.index();
        Boolean iv_ruleAb = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // PsiInternalBacktrackingLexerTestLanguage.g:181:44: (iv_ruleAb= ruleAb EOF )
            // PsiInternalBacktrackingLexerTestLanguage.g:182:2: iv_ruleAb= ruleAb EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAbElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAb=ruleAb();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAb; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleAb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAb"


    // $ANTLR start "ruleAb"
    // PsiInternalBacktrackingLexerTestLanguage.g:188:1: ruleAb returns [Boolean current=false] : ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) ;
    public final Boolean ruleAb() throws RecognitionException {
        Boolean current = false;
        int ruleAb_StartIndex = input.index();
        Token lv_x_0_0=null;
        Token lv_y_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // PsiInternalBacktrackingLexerTestLanguage.g:189:1: ( ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) )
            // PsiInternalBacktrackingLexerTestLanguage.g:190:2: ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:190:2: ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            // PsiInternalBacktrackingLexerTestLanguage.g:191:3: ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) )
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:191:3: ( (lv_x_0_0= RULE_CHARA ) )
            // PsiInternalBacktrackingLexerTestLanguage.g:192:4: (lv_x_0_0= RULE_CHARA )
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:192:4: (lv_x_0_0= RULE_CHARA )
            // PsiInternalBacktrackingLexerTestLanguage.g:193:5: lv_x_0_0= RULE_CHARA
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getAb_XCharATerminalRuleCall_0_0ElementType());
              				
            }
            lv_x_0_0=(Token)match(input,RULE_CHARA,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_x_0_0);
              				
            }

            }


            }

            // PsiInternalBacktrackingLexerTestLanguage.g:208:3: ( (lv_y_1_0= RULE_CHARB ) )
            // PsiInternalBacktrackingLexerTestLanguage.g:209:4: (lv_y_1_0= RULE_CHARB )
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:209:4: (lv_y_1_0= RULE_CHARB )
            // PsiInternalBacktrackingLexerTestLanguage.g:210:5: lv_y_1_0= RULE_CHARB
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getAb_YCharbTerminalRuleCall_1_0ElementType());
              				
            }
            lv_y_1_0=(Token)match(input,RULE_CHARB,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_y_1_0);
              				
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
        return current;
    }
    // $ANTLR end "ruleAb"


    // $ANTLR start "entryRuleXb"
    // PsiInternalBacktrackingLexerTestLanguage.g:229:1: entryRuleXb returns [Boolean current=false] : iv_ruleXb= ruleXb EOF ;
    public final Boolean entryRuleXb() throws RecognitionException {
        Boolean current = false;
        int entryRuleXb_StartIndex = input.index();
        Boolean iv_ruleXb = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // PsiInternalBacktrackingLexerTestLanguage.g:229:44: (iv_ruleXb= ruleXb EOF )
            // PsiInternalBacktrackingLexerTestLanguage.g:230:2: iv_ruleXb= ruleXb EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXbElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXb=ruleXb();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXb; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleXb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXb"


    // $ANTLR start "ruleXb"
    // PsiInternalBacktrackingLexerTestLanguage.g:236:1: ruleXb returns [Boolean current=false] : ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) ;
    public final Boolean ruleXb() throws RecognitionException {
        Boolean current = false;
        int ruleXb_StartIndex = input.index();
        Token lv_x_0_0=null;
        Token lv_y_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // PsiInternalBacktrackingLexerTestLanguage.g:237:1: ( ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) )
            // PsiInternalBacktrackingLexerTestLanguage.g:238:2: ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:238:2: ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            // PsiInternalBacktrackingLexerTestLanguage.g:239:3: ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) )
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:239:3: ( (lv_x_0_0= RULE_CHARX ) )
            // PsiInternalBacktrackingLexerTestLanguage.g:240:4: (lv_x_0_0= RULE_CHARX )
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:240:4: (lv_x_0_0= RULE_CHARX )
            // PsiInternalBacktrackingLexerTestLanguage.g:241:5: lv_x_0_0= RULE_CHARX
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXb_XCharXTerminalRuleCall_0_0ElementType());
              				
            }
            lv_x_0_0=(Token)match(input,RULE_CHARX,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_x_0_0);
              				
            }

            }


            }

            // PsiInternalBacktrackingLexerTestLanguage.g:256:3: ( (lv_y_1_0= RULE_CHARB ) )
            // PsiInternalBacktrackingLexerTestLanguage.g:257:4: (lv_y_1_0= RULE_CHARB )
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:257:4: (lv_y_1_0= RULE_CHARB )
            // PsiInternalBacktrackingLexerTestLanguage.g:258:5: lv_y_1_0= RULE_CHARB
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXb_YCharbTerminalRuleCall_1_0ElementType());
              				
            }
            lv_y_1_0=(Token)match(input,RULE_CHARB,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_y_1_0);
              				
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
        return current;
    }
    // $ANTLR end "ruleXb"


    // $ANTLR start "ruleEnumName"
    // PsiInternalBacktrackingLexerTestLanguage.g:277:1: ruleEnumName returns [Boolean current=false] : ( (enumLiteral_0= 'Abc' ) | (enumLiteral_1= 'Efg' ) ) ;
    public final Boolean ruleEnumName() throws RecognitionException {
        Boolean current = false;
        int ruleEnumName_StartIndex = input.index();
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // PsiInternalBacktrackingLexerTestLanguage.g:278:1: ( ( (enumLiteral_0= 'Abc' ) | (enumLiteral_1= 'Efg' ) ) )
            // PsiInternalBacktrackingLexerTestLanguage.g:279:2: ( (enumLiteral_0= 'Abc' ) | (enumLiteral_1= 'Efg' ) )
            {
            // PsiInternalBacktrackingLexerTestLanguage.g:279:2: ( (enumLiteral_0= 'Abc' ) | (enumLiteral_1= 'Efg' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            else if ( (LA7_0==22) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalBacktrackingLexerTestLanguage.g:280:3: (enumLiteral_0= 'Abc' )
                    {
                    // PsiInternalBacktrackingLexerTestLanguage.g:280:3: (enumLiteral_0= 'Abc' )
                    // PsiInternalBacktrackingLexerTestLanguage.g:281:4: enumLiteral_0= 'Abc'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getEnumName_AbcEnumLiteralDeclaration_0ElementType());
                      			
                    }
                    enumLiteral_0=(Token)match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(enumLiteral_0);
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBacktrackingLexerTestLanguage.g:290:3: (enumLiteral_1= 'Efg' )
                    {
                    // PsiInternalBacktrackingLexerTestLanguage.g:290:3: (enumLiteral_1= 'Efg' )
                    // PsiInternalBacktrackingLexerTestLanguage.g:291:4: enumLiteral_1= 'Efg'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getEnumName_EfgEnumLiteralDeclaration_1ElementType());
                      			
                    }
                    enumLiteral_1=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(enumLiteral_1);
                      			
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
        return current;
    }
    // $ANTLR end "ruleEnumName"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000600742L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000742L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000542L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000442L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000080L});
    }


}
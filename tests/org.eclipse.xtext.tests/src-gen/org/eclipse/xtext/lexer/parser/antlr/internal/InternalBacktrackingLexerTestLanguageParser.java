package org.eclipse.xtext.lexer.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.lexer.services.BacktrackingLexerTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBacktrackingLexerTestLanguageParser extends AbstractInternalAntlrParser {
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
            this.state.ruleMemo = new HashMap[14+1];
             
             
        }
        

    public String[] getTokenNames() { return InternalBacktrackingLexerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

    	private BacktrackingLexerTestLanguageGrammarAccess grammarAccess;
    	 	
    	public InternalBacktrackingLexerTestLanguageParser(TokenStream input, BacktrackingLexerTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Model";	
    	} 
    	   	   	
    	@Override
    	protected BacktrackingLexerTestLanguageGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;
        int entryRuleModel_StartIndex = input.index();
        EObject iv_ruleModel = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:70:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:71:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel80);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel90); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:78:1: ruleModel returns [EObject current=null] : ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;
        int ruleModel_StartIndex = input.index();
        Token lv_ycs_1_0=null;
        Token lv_ys_4_0=null;
        Token lv_as_5_0=null;
        Enumerator lv_enums_0_0 = null;

        EObject lv_abs_2_0 = null;

        EObject lv_xbs_3_0 = null;


         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:81:28: ( ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:82:1: ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:82:1: ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:82:2: ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:82:2: ( (lv_enums_0_0= ruleEnumName ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=Abc && LA1_0<=Efg)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:83:1: (lv_enums_0_0= ruleEnumName )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:83:1: (lv_enums_0_0= ruleEnumName )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:84:3: lv_enums_0_0= ruleEnumName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getEnumsEnumNameEnumRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumName_in_ruleModel136);
            	    lv_enums_0_0=ruleEnumName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"enums",
            	              		lv_enums_0_0, 
            	              		"org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage.EnumName");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:100:3: ( (lv_ycs_1_0= RULE_YC ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_YC) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:101:1: (lv_ycs_1_0= RULE_YC )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:101:1: (lv_ycs_1_0= RULE_YC )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:102:3: lv_ycs_1_0= RULE_YC
            	    {
            	    lv_ycs_1_0=(Token)match(input,RULE_YC,FollowSets000.FOLLOW_RULE_YC_in_ruleModel154); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_ycs_1_0, grammarAccess.getModelAccess().getYcsYcTerminalRuleCall_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getModelRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"ycs",
            	              		lv_ycs_1_0, 
            	              		"org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage.Yc");
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:118:3: ( (lv_abs_2_0= ruleAb ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:119:1: (lv_abs_2_0= ruleAb )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:119:1: (lv_abs_2_0= ruleAb )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:120:3: lv_abs_2_0= ruleAb
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getAbsAbParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAb_in_ruleModel181);
            	    lv_abs_2_0=ruleAb();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"abs",
            	              		lv_abs_2_0, 
            	              		"org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage.Ab");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:136:3: ( (lv_xbs_3_0= ruleXb ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_CHARX) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:137:1: (lv_xbs_3_0= ruleXb )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:137:1: (lv_xbs_3_0= ruleXb )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:138:3: lv_xbs_3_0= ruleXb
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getXbsXbParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleXb_in_ruleModel203);
            	    lv_xbs_3_0=ruleXb();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"xbs",
            	              		lv_xbs_3_0, 
            	              		"org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage.Xb");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:154:3: ( (lv_ys_4_0= RULE_CHARY ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_CHARY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:155:1: (lv_ys_4_0= RULE_CHARY )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:155:1: (lv_ys_4_0= RULE_CHARY )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:156:3: lv_ys_4_0= RULE_CHARY
            	    {
            	    lv_ys_4_0=(Token)match(input,RULE_CHARY,FollowSets000.FOLLOW_RULE_CHARY_in_ruleModel221); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_ys_4_0, grammarAccess.getModelAccess().getYsCharYTerminalRuleCall_4_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getModelRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"ys",
            	              		lv_ys_4_0, 
            	              		"org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage.CharY");
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:172:3: ( (lv_as_5_0= RULE_CHARA ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_CHARA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:173:1: (lv_as_5_0= RULE_CHARA )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:173:1: (lv_as_5_0= RULE_CHARA )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:174:3: lv_as_5_0= RULE_CHARA
            	    {
            	    lv_as_5_0=(Token)match(input,RULE_CHARA,FollowSets000.FOLLOW_RULE_CHARA_in_ruleModel244); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_as_5_0, grammarAccess.getModelAccess().getAsCharATerminalRuleCall_5_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getModelRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"as",
            	              		lv_as_5_0, 
            	              		"org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage.CharA");
            	      	    
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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, ruleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAb"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:198:1: entryRuleAb returns [EObject current=null] : iv_ruleAb= ruleAb EOF ;
    public final EObject entryRuleAb() throws RecognitionException {
        EObject current = null;
        int entryRuleAb_StartIndex = input.index();
        EObject iv_ruleAb = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:199:2: (iv_ruleAb= ruleAb EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:200:2: iv_ruleAb= ruleAb EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAb_in_entryRuleAb285);
            iv_ruleAb=ruleAb();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAb; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAb295); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleAb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAb"


    // $ANTLR start "ruleAb"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:207:1: ruleAb returns [EObject current=null] : ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) ;
    public final EObject ruleAb() throws RecognitionException {
        EObject current = null;
        int ruleAb_StartIndex = input.index();
        Token lv_x_0_0=null;
        Token lv_y_1_0=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:210:28: ( ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:211:1: ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:211:1: ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:211:2: ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:211:2: ( (lv_x_0_0= RULE_CHARA ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:212:1: (lv_x_0_0= RULE_CHARA )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:212:1: (lv_x_0_0= RULE_CHARA )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:213:3: lv_x_0_0= RULE_CHARA
            {
            lv_x_0_0=(Token)match(input,RULE_CHARA,FollowSets000.FOLLOW_RULE_CHARA_in_ruleAb337); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_x_0_0, grammarAccess.getAbAccess().getXCharATerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAbRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"x",
                      		lv_x_0_0, 
                      		"org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage.CharA");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:229:2: ( (lv_y_1_0= RULE_CHARB ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:230:1: (lv_y_1_0= RULE_CHARB )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:230:1: (lv_y_1_0= RULE_CHARB )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:231:3: lv_y_1_0= RULE_CHARB
            {
            lv_y_1_0=(Token)match(input,RULE_CHARB,FollowSets000.FOLLOW_RULE_CHARB_in_ruleAb359); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_y_1_0, grammarAccess.getAbAccess().getYCharbTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAbRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"y",
                      		lv_y_1_0, 
                      		"org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage.Charb");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, ruleAb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAb"


    // $ANTLR start "entryRuleXb"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:255:1: entryRuleXb returns [EObject current=null] : iv_ruleXb= ruleXb EOF ;
    public final EObject entryRuleXb() throws RecognitionException {
        EObject current = null;
        int entryRuleXb_StartIndex = input.index();
        EObject iv_ruleXb = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:256:2: (iv_ruleXb= ruleXb EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:257:2: iv_ruleXb= ruleXb EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXbRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleXb_in_entryRuleXb399);
            iv_ruleXb=ruleXb();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXb; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleXb409); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleXb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXb"


    // $ANTLR start "ruleXb"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:264:1: ruleXb returns [EObject current=null] : ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) ;
    public final EObject ruleXb() throws RecognitionException {
        EObject current = null;
        int ruleXb_StartIndex = input.index();
        Token lv_x_0_0=null;
        Token lv_y_1_0=null;

         enterRule(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:267:28: ( ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:268:1: ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:268:1: ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:268:2: ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:268:2: ( (lv_x_0_0= RULE_CHARX ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:269:1: (lv_x_0_0= RULE_CHARX )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:269:1: (lv_x_0_0= RULE_CHARX )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:270:3: lv_x_0_0= RULE_CHARX
            {
            lv_x_0_0=(Token)match(input,RULE_CHARX,FollowSets000.FOLLOW_RULE_CHARX_in_ruleXb451); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_x_0_0, grammarAccess.getXbAccess().getXCharXTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXbRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"x",
                      		lv_x_0_0, 
                      		"org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage.CharX");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:286:2: ( (lv_y_1_0= RULE_CHARB ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:287:1: (lv_y_1_0= RULE_CHARB )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:287:1: (lv_y_1_0= RULE_CHARB )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:288:3: lv_y_1_0= RULE_CHARB
            {
            lv_y_1_0=(Token)match(input,RULE_CHARB,FollowSets000.FOLLOW_RULE_CHARB_in_ruleXb473); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_y_1_0, grammarAccess.getXbAccess().getYCharbTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXbRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"y",
                      		lv_y_1_0, 
                      		"org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage.Charb");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, ruleXb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXb"


    // $ANTLR start "ruleEnumName"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:312:1: ruleEnumName returns [Enumerator current=null] : ( (enumLiteral_0= Abc ) | (enumLiteral_1= Efg ) ) ;
    public final Enumerator ruleEnumName() throws RecognitionException {
        Enumerator current = null;
        int ruleEnumName_StartIndex = input.index();
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:314:28: ( ( (enumLiteral_0= Abc ) | (enumLiteral_1= Efg ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:315:1: ( (enumLiteral_0= Abc ) | (enumLiteral_1= Efg ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:315:1: ( (enumLiteral_0= Abc ) | (enumLiteral_1= Efg ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Abc) ) {
                alt7=1;
            }
            else if ( (LA7_0==Efg) ) {
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:315:2: (enumLiteral_0= Abc )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:315:2: (enumLiteral_0= Abc )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:315:7: enumLiteral_0= Abc
                    {
                    enumLiteral_0=(Token)match(input,Abc,FollowSets000.FOLLOW_Abc_in_ruleEnumName531); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getEnumNameAccess().getAbcEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getEnumNameAccess().getAbcEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:321:6: (enumLiteral_1= Efg )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:321:6: (enumLiteral_1= Efg )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguageParser.g:321:11: enumLiteral_1= Efg
                    {
                    enumLiteral_1=(Token)match(input,Efg,FollowSets000.FOLLOW_Efg_in_ruleEnumName553); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getEnumNameAccess().getEfgEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getEnumNameAccess().getEfgEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, ruleEnumName_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleEnumName"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel80 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel90 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumName_in_ruleModel136 = new BitSet(new long[]{0x0000000000000772L});
        public static final BitSet FOLLOW_RULE_YC_in_ruleModel154 = new BitSet(new long[]{0x0000000000000742L});
        public static final BitSet FOLLOW_ruleAb_in_ruleModel181 = new BitSet(new long[]{0x0000000000000542L});
        public static final BitSet FOLLOW_ruleXb_in_ruleModel203 = new BitSet(new long[]{0x0000000000000542L});
        public static final BitSet FOLLOW_RULE_CHARY_in_ruleModel221 = new BitSet(new long[]{0x0000000000000442L});
        public static final BitSet FOLLOW_RULE_CHARA_in_ruleModel244 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_ruleAb_in_entryRuleAb285 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAb295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_CHARA_in_ruleAb337 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_CHARB_in_ruleAb359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleXb_in_entryRuleXb399 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleXb409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_CHARX_in_ruleXb451 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_CHARB_in_ruleXb473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_Abc_in_ruleEnumName531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_Efg_in_ruleEnumName553 = new BitSet(new long[]{0x0000000000000002L});
    }


}
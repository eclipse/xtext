package org.eclipse.xtext.lexer.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_1", "KEYWORD_2", "RULE_CHARA", "RULE_CHARB", "RULE_CHARX", "RULE_YC", "RULE_CHARY", "RULE_CHARC", "RULE_WS", "RULE_SL_COMMENT"
    };
    public static final int RULE_CHARX=8;
    public static final int KEYWORD_1=4;
    public static final int RULE_YC=9;
    public static final int RULE_CHARY=10;
    public static final int KEYWORD_2=5;
    public static final int RULE_WS=12;
    public static final int RULE_CHARA=6;
    public static final int RULE_SL_COMMENT=13;
    public static final int EOF=-1;
    public static final int RULE_CHARB=7;
    public static final int RULE_CHARC=11;

        public InternalBacktrackingLexerTestLanguageParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[14+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

     	private BacktrackingLexerTestLanguageGrammarAccess grammarAccess;
     	
        public InternalBacktrackingLexerTestLanguageParser(TokenStream input, IAstFactory factory, BacktrackingLexerTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 
       	   	
       	@Override
       	protected BacktrackingLexerTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:79:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;
        int entryRuleModel_StartIndex = input.index();
        EObject iv_ruleModel = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:80:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:81:2: iv_ruleModel= ruleModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel80);
            iv_ruleModel=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel90); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 1, entryRuleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:88:1: ruleModel returns [EObject current=null] : ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;
        int ruleModel_StartIndex = input.index();
        Token lv_ycs_1_0=null;
        Token lv_ys_4_0=null;
        Token lv_as_5_0=null;
        Enumerator lv_enums_0_0 = null;

        EObject lv_abs_2_0 = null;

        EObject lv_xbs_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:93:6: ( ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:94:1: ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:94:1: ( ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:94:2: ( (lv_enums_0_0= ruleEnumName ) )* ( (lv_ycs_1_0= RULE_YC ) )* ( (lv_abs_2_0= ruleAb ) )* ( (lv_xbs_3_0= ruleXb ) )* ( (lv_ys_4_0= RULE_CHARY ) )* ( (lv_as_5_0= RULE_CHARA ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:94:2: ( (lv_enums_0_0= ruleEnumName ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=KEYWORD_1 && LA1_0<=KEYWORD_2)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:95:1: (lv_enums_0_0= ruleEnumName )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:95:1: (lv_enums_0_0= ruleEnumName )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:96:3: lv_enums_0_0= ruleEnumName
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getEnumsEnumNameEnumRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumName_in_ruleModel136);
            	    lv_enums_0_0=ruleEnumName();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"enums",
            	      	        		lv_enums_0_0, 
            	      	        		"EnumName", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:118:3: ( (lv_ycs_1_0= RULE_YC ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_YC) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:119:1: (lv_ycs_1_0= RULE_YC )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:119:1: (lv_ycs_1_0= RULE_YC )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:120:3: lv_ycs_1_0= RULE_YC
            	    {
            	    lv_ycs_1_0=(Token)input.LT(1);
            	    match(input,RULE_YC,FollowSets000.FOLLOW_RULE_YC_in_ruleModel154); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      			createLeafNode(grammarAccess.getModelAccess().getYcsYcTerminalRuleCall_1_0(), "ycs"); 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"ycs",
            	      	        		lv_ycs_1_0, 
            	      	        		"Yc", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:142:3: ( (lv_abs_2_0= ruleAb ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:143:1: (lv_abs_2_0= ruleAb )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:143:1: (lv_abs_2_0= ruleAb )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:144:3: lv_abs_2_0= ruleAb
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAbsAbParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAb_in_ruleModel181);
            	    lv_abs_2_0=ruleAb();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"abs",
            	      	        		lv_abs_2_0, 
            	      	        		"Ab", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:166:3: ( (lv_xbs_3_0= ruleXb ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_CHARX) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:167:1: (lv_xbs_3_0= ruleXb )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:167:1: (lv_xbs_3_0= ruleXb )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:168:3: lv_xbs_3_0= ruleXb
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getXbsXbParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleXb_in_ruleModel203);
            	    lv_xbs_3_0=ruleXb();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"xbs",
            	      	        		lv_xbs_3_0, 
            	      	        		"Xb", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:190:3: ( (lv_ys_4_0= RULE_CHARY ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_CHARY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:191:1: (lv_ys_4_0= RULE_CHARY )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:191:1: (lv_ys_4_0= RULE_CHARY )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:192:3: lv_ys_4_0= RULE_CHARY
            	    {
            	    lv_ys_4_0=(Token)input.LT(1);
            	    match(input,RULE_CHARY,FollowSets000.FOLLOW_RULE_CHARY_in_ruleModel221); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      			createLeafNode(grammarAccess.getModelAccess().getYsCharYTerminalRuleCall_4_0(), "ys"); 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"ys",
            	      	        		lv_ys_4_0, 
            	      	        		"CharY", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:214:3: ( (lv_as_5_0= RULE_CHARA ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_CHARA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:215:1: (lv_as_5_0= RULE_CHARA )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:215:1: (lv_as_5_0= RULE_CHARA )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:216:3: lv_as_5_0= RULE_CHARA
            	    {
            	    lv_as_5_0=(Token)input.LT(1);
            	    match(input,RULE_CHARA,FollowSets000.FOLLOW_RULE_CHARA_in_ruleModel244); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      			createLeafNode(grammarAccess.getModelAccess().getAsCharATerminalRuleCall_5_0(), "as"); 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"as",
            	      	        		lv_as_5_0, 
            	      	        		"CharA", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
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

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 2, ruleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleAb
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:246:1: entryRuleAb returns [EObject current=null] : iv_ruleAb= ruleAb EOF ;
    public final EObject entryRuleAb() throws RecognitionException {
        EObject current = null;
        int entryRuleAb_StartIndex = input.index();
        EObject iv_ruleAb = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:247:2: (iv_ruleAb= ruleAb EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:248:2: iv_ruleAb= ruleAb EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAbRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAb_in_entryRuleAb285);
            iv_ruleAb=ruleAb();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAb; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAb295); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 3, entryRuleAb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleAb


    // $ANTLR start ruleAb
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:255:1: ruleAb returns [EObject current=null] : ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) ;
    public final EObject ruleAb() throws RecognitionException {
        EObject current = null;
        int ruleAb_StartIndex = input.index();
        Token lv_x_0_0=null;
        Token lv_y_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:260:6: ( ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:261:1: ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:261:1: ( ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:261:2: ( (lv_x_0_0= RULE_CHARA ) ) ( (lv_y_1_0= RULE_CHARB ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:261:2: ( (lv_x_0_0= RULE_CHARA ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:262:1: (lv_x_0_0= RULE_CHARA )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:262:1: (lv_x_0_0= RULE_CHARA )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:263:3: lv_x_0_0= RULE_CHARA
            {
            lv_x_0_0=(Token)input.LT(1);
            match(input,RULE_CHARA,FollowSets000.FOLLOW_RULE_CHARA_in_ruleAb337); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getAbAccess().getXCharATerminalRuleCall_0_0(), "x"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAbRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"x",
              	        		lv_x_0_0, 
              	        		"CharA", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:285:2: ( (lv_y_1_0= RULE_CHARB ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:286:1: (lv_y_1_0= RULE_CHARB )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:286:1: (lv_y_1_0= RULE_CHARB )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:287:3: lv_y_1_0= RULE_CHARB
            {
            lv_y_1_0=(Token)input.LT(1);
            match(input,RULE_CHARB,FollowSets000.FOLLOW_RULE_CHARB_in_ruleAb359); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getAbAccess().getYCharbTerminalRuleCall_1_0(), "y"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAbRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"y",
              	        		lv_y_1_0, 
              	        		"Charb", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 4, ruleAb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleAb


    // $ANTLR start entryRuleXb
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:317:1: entryRuleXb returns [EObject current=null] : iv_ruleXb= ruleXb EOF ;
    public final EObject entryRuleXb() throws RecognitionException {
        EObject current = null;
        int entryRuleXb_StartIndex = input.index();
        EObject iv_ruleXb = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:318:2: (iv_ruleXb= ruleXb EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:319:2: iv_ruleXb= ruleXb EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXbRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleXb_in_entryRuleXb399);
            iv_ruleXb=ruleXb();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXb; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleXb409); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 5, entryRuleXb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end entryRuleXb


    // $ANTLR start ruleXb
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:326:1: ruleXb returns [EObject current=null] : ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) ;
    public final EObject ruleXb() throws RecognitionException {
        EObject current = null;
        int ruleXb_StartIndex = input.index();
        Token lv_x_0_0=null;
        Token lv_y_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:331:6: ( ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:332:1: ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:332:1: ( ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:332:2: ( (lv_x_0_0= RULE_CHARX ) ) ( (lv_y_1_0= RULE_CHARB ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:332:2: ( (lv_x_0_0= RULE_CHARX ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:333:1: (lv_x_0_0= RULE_CHARX )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:333:1: (lv_x_0_0= RULE_CHARX )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:334:3: lv_x_0_0= RULE_CHARX
            {
            lv_x_0_0=(Token)input.LT(1);
            match(input,RULE_CHARX,FollowSets000.FOLLOW_RULE_CHARX_in_ruleXb451); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getXbAccess().getXCharXTerminalRuleCall_0_0(), "x"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXbRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"x",
              	        		lv_x_0_0, 
              	        		"CharX", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:356:2: ( (lv_y_1_0= RULE_CHARB ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:357:1: (lv_y_1_0= RULE_CHARB )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:357:1: (lv_y_1_0= RULE_CHARB )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:358:3: lv_y_1_0= RULE_CHARB
            {
            lv_y_1_0=(Token)input.LT(1);
            match(input,RULE_CHARB,FollowSets000.FOLLOW_RULE_CHARB_in_ruleXb473); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getXbAccess().getYCharbTerminalRuleCall_1_0(), "y"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXbRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"y",
              	        		lv_y_1_0, 
              	        		"Charb", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 6, ruleXb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleXb


    // $ANTLR start ruleEnumName
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:388:1: ruleEnumName returns [Enumerator current=null] : ( ( KEYWORD_1 ) | ( KEYWORD_2 ) ) ;
    public final Enumerator ruleEnumName() throws RecognitionException {
        Enumerator current = null;
        int ruleEnumName_StartIndex = input.index();
         setCurrentLookahead(); resetLookahead(); 
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:392:6: ( ( ( KEYWORD_1 ) | ( KEYWORD_2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:393:1: ( ( KEYWORD_1 ) | ( KEYWORD_2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:393:1: ( ( KEYWORD_1 ) | ( KEYWORD_2 ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==KEYWORD_1) ) {
                alt7=1;
            }
            else if ( (LA7_0==KEYWORD_2) ) {
                alt7=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("393:1: ( ( KEYWORD_1 ) | ( KEYWORD_2 ) )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:393:2: ( KEYWORD_1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:393:2: ( KEYWORD_1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:393:7: KEYWORD_1
                    {
                    match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleEnumName529); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getEnumNameAccess().getAbcEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getEnumNameAccess().getAbcEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:399:6: ( KEYWORD_2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:399:6: ( KEYWORD_2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:399:11: KEYWORD_2
                    {
                    match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleEnumName546); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getEnumNameAccess().getEfgEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getEnumNameAccess().getEfgEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( backtracking>0 ) { memoize(input, 7, ruleEnumName_StartIndex); }
        }
        return current;
    }
    // $ANTLR end ruleEnumName


 

    
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
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleEnumName529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleEnumName546 = new BitSet(new long[]{0x0000000000000002L});
    }


}
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
public class InternalBacktrackingLexerTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FRAGMENT_KEYWORD_1", "FRAGMENT_KEYWORD_2", "FRAGMENT_RULE_CHARA", "FRAGMENT_RULE_CHARB", "FRAGMENT_RULE_CHARX", "FRAGMENT_RULE_WS", "FRAGMENT_RULE_SL_COMMENT", "SYNTHETIC_ALL_KEYWORDS", "KEYWORD_1", "KEYWORD_2", "RULE_CHARA", "RULE_CHARB", "RULE_CHARX", "RULE_WS", "RULE_SL_COMMENT", "Tokens", "' '", "'\t'", "'\r'", "'\n'"
    };
    public static final int FRAGMENT_RULE_CHARA=6;
    public static final int FRAGMENT_RULE_CHARX=8;
    public static final int KEYWORD_1=12;
    public static final int FRAGMENT_RULE_SL_COMMENT=10;
    public static final int KEYWORD_2=13;
    public static final int RULE_CHARA=14;
    public static final int RULE_CHARX=16;
    public static final int FRAGMENT_KEYWORD_2=5;
    public static final int RULE_WS=17;
    public static final int EOF=-1;
    public static final int Tokens=19;
    public static final int SYNTHETIC_ALL_KEYWORDS=11;
    public static final int RULE_SL_COMMENT=18;
    public static final int FRAGMENT_KEYWORD_1=4;
    public static final int FRAGMENT_RULE_CHARB=7;
    public static final int RULE_CHARB=15;
    public static final int FRAGMENT_RULE_WS=9;

        public InternalBacktrackingLexerTestLanguageParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[11+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g"; }


     
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



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;
        int entryRuleModel_StartIndex = input.index();
        EObject iv_ruleModel = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:68:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel79);
            iv_ruleModel=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel89); if (failed) return current;

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_enums_0= ruleEnumName )* (lv_abs_1= ruleAb )* (lv_xbs_2= ruleXb )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;
        int ruleModel_StartIndex = input.index();
        Enumerator lv_enums_0 = null;

        EObject lv_abs_1 = null;

        EObject lv_xbs_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:81:6: ( ( (lv_enums_0= ruleEnumName )* (lv_abs_1= ruleAb )* (lv_xbs_2= ruleXb )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:82:1: ( (lv_enums_0= ruleEnumName )* (lv_abs_1= ruleAb )* (lv_xbs_2= ruleXb )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:82:1: ( (lv_enums_0= ruleEnumName )* (lv_abs_1= ruleAb )* (lv_xbs_2= ruleXb )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:82:2: (lv_enums_0= ruleEnumName )* (lv_abs_1= ruleAb )* (lv_xbs_2= ruleXb )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:82:2: (lv_enums_0= ruleEnumName )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=KEYWORD_1 && LA1_0<=KEYWORD_2)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:85:6: lv_enums_0= ruleEnumName
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getEnumsEnumNameEnumRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEnumName_in_ruleModel148);
            	    lv_enums_0=ruleEnumName();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		add(current, "enums", lv_enums_0, "EnumName", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:104:3: (lv_abs_1= ruleAb )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_CHARA) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:107:6: lv_abs_1= ruleAb
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAbsAbParserRuleCall_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAb_in_ruleModel188);
            	    lv_abs_1=ruleAb();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		add(current, "abs", lv_abs_1, "Ab", currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:126:3: (lv_xbs_2= ruleXb )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_CHARX) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:129:6: lv_xbs_2= ruleXb
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getXbsXbParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXb_in_ruleModel228);
            	    lv_xbs_2=ruleXb();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		add(current, "xbs", lv_xbs_2, "Xb", currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:155:1: entryRuleAb returns [EObject current=null] : iv_ruleAb= ruleAb EOF ;
    public final EObject entryRuleAb() throws RecognitionException {
        EObject current = null;
        int entryRuleAb_StartIndex = input.index();
        EObject iv_ruleAb = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:155:44: (iv_ruleAb= ruleAb EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:156:2: iv_ruleAb= ruleAb EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAbRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAb_in_entryRuleAb267);
            iv_ruleAb=ruleAb();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAb; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAb277); if (failed) return current;

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:163:1: ruleAb returns [EObject current=null] : ( (lv_x_0= RULE_CHARA ) (lv_y_1= RULE_CHARB ) ) ;
    public final EObject ruleAb() throws RecognitionException {
        EObject current = null;
        int ruleAb_StartIndex = input.index();
        Token lv_x_0=null;
        Token lv_y_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:168:6: ( ( (lv_x_0= RULE_CHARA ) (lv_y_1= RULE_CHARB ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:169:1: ( (lv_x_0= RULE_CHARA ) (lv_y_1= RULE_CHARB ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:169:1: ( (lv_x_0= RULE_CHARA ) (lv_y_1= RULE_CHARB ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:169:2: (lv_x_0= RULE_CHARA ) (lv_y_1= RULE_CHARB )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:169:2: (lv_x_0= RULE_CHARA )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:171:6: lv_x_0= RULE_CHARA
            {
            lv_x_0=(Token)input.LT(1);
            match(input,RULE_CHARA,FOLLOW_RULE_CHARA_in_ruleAb323); if (failed) return current;
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getAbAccess().getXCharATerminalRuleCall_0_0(), "x"); 
                  
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAbRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "x", lv_x_0, "CharA", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:190:2: (lv_y_1= RULE_CHARB )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:192:6: lv_y_1= RULE_CHARB
            {
            lv_y_1=(Token)input.LT(1);
            match(input,RULE_CHARB,FOLLOW_RULE_CHARB_in_ruleAb356); if (failed) return current;
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getAbAccess().getYCharbTerminalRuleCall_1_0(), "y"); 
                  
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAbRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "y", lv_y_1, "Charb", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:218:1: entryRuleXb returns [EObject current=null] : iv_ruleXb= ruleXb EOF ;
    public final EObject entryRuleXb() throws RecognitionException {
        EObject current = null;
        int entryRuleXb_StartIndex = input.index();
        EObject iv_ruleXb = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:218:44: (iv_ruleXb= ruleXb EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:219:2: iv_ruleXb= ruleXb EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXbRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXb_in_entryRuleXb401);
            iv_ruleXb=ruleXb();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXb; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXb411); if (failed) return current;

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:226:1: ruleXb returns [EObject current=null] : ( (lv_x_0= RULE_CHARX ) (lv_y_1= RULE_CHARB ) ) ;
    public final EObject ruleXb() throws RecognitionException {
        EObject current = null;
        int ruleXb_StartIndex = input.index();
        Token lv_x_0=null;
        Token lv_y_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:231:6: ( ( (lv_x_0= RULE_CHARX ) (lv_y_1= RULE_CHARB ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:232:1: ( (lv_x_0= RULE_CHARX ) (lv_y_1= RULE_CHARB ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:232:1: ( (lv_x_0= RULE_CHARX ) (lv_y_1= RULE_CHARB ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:232:2: (lv_x_0= RULE_CHARX ) (lv_y_1= RULE_CHARB )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:232:2: (lv_x_0= RULE_CHARX )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:234:6: lv_x_0= RULE_CHARX
            {
            lv_x_0=(Token)input.LT(1);
            match(input,RULE_CHARX,FOLLOW_RULE_CHARX_in_ruleXb457); if (failed) return current;
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getXbAccess().getXCharXTerminalRuleCall_0_0(), "x"); 
                  
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXbRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "x", lv_x_0, "CharX", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:253:2: (lv_y_1= RULE_CHARB )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:255:6: lv_y_1= RULE_CHARB
            {
            lv_y_1=(Token)input.LT(1);
            match(input,RULE_CHARB,FOLLOW_RULE_CHARB_in_ruleXb490); if (failed) return current;
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getXbAccess().getYCharbTerminalRuleCall_1_0(), "y"); 
                  
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXbRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "y", lv_y_1, "Charb", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:281:1: ruleEnumName returns [Enumerator current=null] : ( ( KEYWORD_1 ) | ( KEYWORD_2 ) ) ;
    public final Enumerator ruleEnumName() throws RecognitionException {
        Enumerator current = null;
        int ruleEnumName_StartIndex = input.index();
         setCurrentLookahead(); resetLookahead(); 
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:285:6: ( ( ( KEYWORD_1 ) | ( KEYWORD_2 ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:286:1: ( ( KEYWORD_1 ) | ( KEYWORD_2 ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:286:1: ( ( KEYWORD_1 ) | ( KEYWORD_2 ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==KEYWORD_1) ) {
                alt4=1;
            }
            else if ( (LA4_0==KEYWORD_2) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("286:1: ( ( KEYWORD_1 ) | ( KEYWORD_2 ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:286:2: ( KEYWORD_1 )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:286:2: ( KEYWORD_1 )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:286:7: KEYWORD_1
                    {
                    match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleEnumName552); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getEnumNameAccess().getAbcEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getEnumNameAccess().getAbcEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:292:6: ( KEYWORD_2 )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:292:6: ( KEYWORD_2 )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalBacktrackingLexerTestLanguage.g:292:11: KEYWORD_2
                    {
                    match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleEnumName569); if (failed) return current;
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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel79 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumName_in_ruleModel148 = new BitSet(new long[]{0x0000000000017002L});
    public static final BitSet FOLLOW_ruleAb_in_ruleModel188 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_ruleXb_in_ruleModel228 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleAb_in_entryRuleAb267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAb277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARA_in_ruleAb323 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RULE_CHARB_in_ruleAb356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXb_in_entryRuleXb401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXb411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARX_in_ruleXb457 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RULE_CHARB_in_ruleXb490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleEnumName552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleEnumName569 = new BitSet(new long[]{0x0000000000000002L});

}
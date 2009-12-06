package org.eclipse.xtext.parser.antlr.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.antlr.services.Bug296889ExTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalBug296889ExTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_3", "KEYWORD_2", "KEYWORD_1", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "Tokens"
    };
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_ID=7;
    public static final int RULE_WS=12;
    public static final int KEYWORD_1=6;
    public static final int RULE_INT=8;
    public static final int EOF=-1;
    public static final int RULE_STRING=9;
    public static final int Tokens=14;
    public static final int RULE_ANY_OTHER=13;
    public static final int KEYWORD_2=5;
    public static final int RULE_SL_COMMENT=11;
    public static final int KEYWORD_3=4;

        public InternalBug296889ExTestLanguageParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[25+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

     	private Bug296889ExTestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug296889ExTestLanguageParser(TokenStream input, IAstFactory factory, Bug296889ExTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel72);
            iv_ruleModel=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel82); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( KEYWORD_2 ( (lv_expressions_1_0= ruleExpression ) )* ) | ( KEYWORD_3 ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_1_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:85:6: ( ( ( KEYWORD_2 ( (lv_expressions_1_0= ruleExpression ) )* ) | ( KEYWORD_3 ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:86:1: ( ( KEYWORD_2 ( (lv_expressions_1_0= ruleExpression ) )* ) | ( KEYWORD_3 ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:86:1: ( ( KEYWORD_2 ( (lv_expressions_1_0= ruleExpression ) )* ) | ( KEYWORD_3 ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==KEYWORD_2) ) {
                alt3=1;
            }
            else if ( (LA3_0==KEYWORD_3) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("86:1: ( ( KEYWORD_2 ( (lv_expressions_1_0= ruleExpression ) )* ) | ( KEYWORD_3 ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:86:2: ( KEYWORD_2 ( (lv_expressions_1_0= ruleExpression ) )* )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:86:2: ( KEYWORD_2 ( (lv_expressions_1_0= ruleExpression ) )* )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:87:2: KEYWORD_2 ( (lv_expressions_1_0= ruleExpression ) )*
                    {
                    match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleModel119); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getModelAccess().getModelKeyword_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:91:1: ( (lv_expressions_1_0= ruleExpression ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=KEYWORD_1 && LA1_0<=RULE_ID)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:92:1: (lv_expressions_1_0= ruleExpression )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:92:1: (lv_expressions_1_0= ruleExpression )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:93:3: lv_expressions_1_0= ruleExpression
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getExpressionsExpressionParserRuleCall_0_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleModel140);
                    	    lv_expressions_1_0=ruleExpression();
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
                    	      	       			"expressions",
                    	      	        		lv_expressions_1_0, 
                    	      	        		"Expression", 
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


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:116:6: ( KEYWORD_3 ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:116:6: ( KEYWORD_3 ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:117:2: KEYWORD_3 ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    {
                    match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleModel160); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getModelAccess().getDataTypeKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:121:1: ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=KEYWORD_1 && LA2_0<=RULE_ID)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:122:1: (lv_values_3_0= ruleDataTypeExpression )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:122:1: (lv_values_3_0= ruleDataTypeExpression )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:123:3: lv_values_3_0= ruleDataTypeExpression
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValuesDataTypeExpressionParserRuleCall_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleDataTypeExpression_in_ruleModel181);
                    	    lv_values_3_0=ruleDataTypeExpression();
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
                    	      	       			"values",
                    	      	        		lv_values_3_0, 
                    	      	        		"DataTypeExpression", 
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
                    	    break loop2;
                        }
                    } while (true);


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
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:152:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:152:52: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:153:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression216);
            iv_ruleExpression=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression226); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:160:1: ruleExpression returns [EObject current=null] : (this_Postop_0= rulePostop | this_Preop_1= rulePreop ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Postop_0 = null;

        EObject this_Preop_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:165:6: ( (this_Postop_0= rulePostop | this_Preop_1= rulePreop ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:166:1: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:166:1: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==KEYWORD_1) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("166:1: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:167:2: this_Postop_0= rulePostop
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getPostopParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulePostop_in_ruleExpression276);
                    this_Postop_0=rulePostop();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Postop_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:180:2: this_Preop_1= rulePreop
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getPreopParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulePreop_in_ruleExpression306);
                    this_Preop_1=rulePreop();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Preop_1; 
                              currentNode = currentNode.getParent();
                          
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
        }
        return current;
    }
    // $ANTLR end ruleExpression


    // $ANTLR start entryRulePreop
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:198:1: entryRulePreop returns [EObject current=null] : iv_rulePreop= rulePreop EOF ;
    public final EObject entryRulePreop() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreop = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:198:47: (iv_rulePreop= rulePreop EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:199:2: iv_rulePreop= rulePreop EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPreopRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulePreop_in_entryRulePreop338);
            iv_rulePreop=rulePreop();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePreop; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePreop348); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePreop


    // $ANTLR start rulePreop
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:206:1: rulePreop returns [EObject current=null] : ( () ( (lv_functionName_1_0= KEYWORD_1 ) ) ( (lv_expr_2_0= ruleVariable ) ) ) ;
    public final EObject rulePreop() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_1_0=null;
        EObject lv_expr_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:211:6: ( ( () ( (lv_functionName_1_0= KEYWORD_1 ) ) ( (lv_expr_2_0= ruleVariable ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:212:1: ( () ( (lv_functionName_1_0= KEYWORD_1 ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:212:1: ( () ( (lv_functionName_1_0= KEYWORD_1 ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:212:2: () ( (lv_functionName_1_0= KEYWORD_1 ) ) ( (lv_expr_2_0= ruleVariable ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:212:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:213:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getPreopAccess().getPreopAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getPreopAccess().getPreopAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:226:2: ( (lv_functionName_1_0= KEYWORD_1 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:227:1: (lv_functionName_1_0= KEYWORD_1 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:227:1: (lv_functionName_1_0= KEYWORD_1 )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:228:3: lv_functionName_1_0= KEYWORD_1
            {
            lv_functionName_1_0=(Token)input.LT(1);
            match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_rulePreop404); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPreopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_0(), "functionName"); 
                  
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPreopRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "functionName", lv_functionName_1_0, "--", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:248:2: ( (lv_expr_2_0= ruleVariable ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:249:1: (lv_expr_2_0= ruleVariable )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:249:1: (lv_expr_2_0= ruleVariable )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:250:3: lv_expr_2_0= ruleVariable
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPreopAccess().getExprVariableParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleVariable_in_rulePreop438);
            lv_expr_2_0=ruleVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPreopRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expr",
              	        		lv_expr_2_0, 
              	        		"Variable", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
        }
        return current;
    }
    // $ANTLR end rulePreop


    // $ANTLR start entryRulePostop
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:279:1: entryRulePostop returns [EObject current=null] : iv_rulePostop= rulePostop EOF ;
    public final EObject entryRulePostop() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostop = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:279:48: (iv_rulePostop= rulePostop EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:280:2: iv_rulePostop= rulePostop EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPostopRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulePostop_in_entryRulePostop471);
            iv_rulePostop=rulePostop();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePostop; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostop481); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePostop


    // $ANTLR start rulePostop
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:287:1: rulePostop returns [EObject current=null] : (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= KEYWORD_1 ) ) )? ) ;
    public final EObject rulePostop() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_2_0=null;
        EObject this_Variable_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:292:6: ( (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= KEYWORD_1 ) ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:293:1: (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= KEYWORD_1 ) ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:293:1: (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= KEYWORD_1 ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:294:2: this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= KEYWORD_1 ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getPostopAccess().getVariableParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleVariable_in_rulePostop531);
            this_Variable_0=ruleVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_Variable_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:305:1: ( () ( (lv_functionName_2_0= KEYWORD_1 ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==KEYWORD_1) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_3 = input.LA(3);

                    if ( (synpred5()) ) {
                        alt5=1;
                    }
                }
                else if ( (LA5_1==EOF||LA5_1==KEYWORD_1) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:305:2: () ( (lv_functionName_2_0= KEYWORD_1 ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:305:2: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:306:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getPostopAccess().getPostopExprAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "expr", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getPostopAccess().getPostopExprAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:324:2: ( (lv_functionName_2_0= KEYWORD_1 ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:325:1: (lv_functionName_2_0= KEYWORD_1 )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:325:1: (lv_functionName_2_0= KEYWORD_1 )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:326:3: lv_functionName_2_0= KEYWORD_1
                    {
                    lv_functionName_2_0=(Token)input.LT(1);
                    match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_rulePostop562); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPostopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_1_0(), "functionName"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPostopRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "functionName", lv_functionName_2_0, "--", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

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
        }
        return current;
    }
    // $ANTLR end rulePostop


    // $ANTLR start entryRuleVariable
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:353:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:353:50: (iv_ruleVariable= ruleVariable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:354:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVariableRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable610);
            iv_ruleVariable=ruleVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable620); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVariable


    // $ANTLR start ruleVariable
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:361:1: ruleVariable returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:366:6: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:367:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:367:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:367:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:367:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:368:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getVariableAccess().getVariableAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getVariableAccess().getVariableAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:381:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:382:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:382:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:383:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariable674); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"ID", 
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
        }
        return current;
    }
    // $ANTLR end ruleVariable


    // $ANTLR start entryRuleDataTypeExpression
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:412:1: entryRuleDataTypeExpression returns [String current=null] : iv_ruleDataTypeExpression= ruleDataTypeExpression EOF ;
    public final String entryRuleDataTypeExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeExpression = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:412:59: (iv_ruleDataTypeExpression= ruleDataTypeExpression EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:413:2: iv_ruleDataTypeExpression= ruleDataTypeExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDataTypeExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleDataTypeExpression_in_entryRuleDataTypeExpression713);
            iv_ruleDataTypeExpression=ruleDataTypeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDataTypeExpression.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeExpression724); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDataTypeExpression


    // $ANTLR start ruleDataTypeExpression
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:420:1: ruleDataTypeExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_DataTypePostop_0 = null;

        AntlrDatatypeRuleToken this_DataTypePreop_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:425:6: ( (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:426:1: (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:426:1: (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==KEYWORD_1) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("426:1: (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:427:5: this_DataTypePostop_0= ruleDataTypePostop
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getDataTypeExpressionAccess().getDataTypePostopParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleDataTypePostop_in_ruleDataTypeExpression771);
                    this_DataTypePostop_0=ruleDataTypePostop();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_DataTypePostop_0);
                          
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:439:5: this_DataTypePreop_1= ruleDataTypePreop
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getDataTypeExpressionAccess().getDataTypePreopParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleDataTypePreop_in_ruleDataTypeExpression804);
                    this_DataTypePreop_1=ruleDataTypePreop();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_DataTypePreop_1);
                          
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode = currentNode.getParent();
                          
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
        }
        return current;
    }
    // $ANTLR end ruleDataTypeExpression


    // $ANTLR start entryRuleDataTypePreop
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:457:1: entryRuleDataTypePreop returns [String current=null] : iv_ruleDataTypePreop= ruleDataTypePreop EOF ;
    public final String entryRuleDataTypePreop() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypePreop = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:457:54: (iv_ruleDataTypePreop= ruleDataTypePreop EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:458:2: iv_ruleDataTypePreop= ruleDataTypePreop EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDataTypePreopRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleDataTypePreop_in_entryRuleDataTypePreop848);
            iv_ruleDataTypePreop=ruleDataTypePreop();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDataTypePreop.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypePreop859); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDataTypePreop


    // $ANTLR start ruleDataTypePreop
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:465:1: ruleDataTypePreop returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_1 this_DataTypeVariable_1= ruleDataTypeVariable ) ;
    public final AntlrDatatypeRuleToken ruleDataTypePreop() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_DataTypeVariable_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:470:6: ( (kw= KEYWORD_1 this_DataTypeVariable_1= ruleDataTypeVariable ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:471:1: (kw= KEYWORD_1 this_DataTypeVariable_1= ruleDataTypeVariable )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:471:1: (kw= KEYWORD_1 this_DataTypeVariable_1= ruleDataTypeVariable )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:472:2: kw= KEYWORD_1 this_DataTypeVariable_1= ruleDataTypeVariable
            {
            kw=(Token)input.LT(1);
            match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleDataTypePreop897); if (failed) return current;
            if ( backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(grammarAccess.getDataTypePreopAccess().getHyphenMinusHyphenMinusKeyword_0(), null); 
                  
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getDataTypePreopAccess().getDataTypeVariableParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleDataTypeVariable_in_ruleDataTypePreop919);
            this_DataTypeVariable_1=ruleDataTypeVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_DataTypeVariable_1);
                  
            }
            if ( backtracking==0 ) {
               
                      currentNode = currentNode.getParent();
                  
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
        }
        return current;
    }
    // $ANTLR end ruleDataTypePreop


    // $ANTLR start entryRuleDataTypePostop
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:496:1: entryRuleDataTypePostop returns [String current=null] : iv_ruleDataTypePostop= ruleDataTypePostop EOF ;
    public final String entryRuleDataTypePostop() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypePostop = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:496:55: (iv_ruleDataTypePostop= ruleDataTypePostop EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:497:2: iv_ruleDataTypePostop= ruleDataTypePostop EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDataTypePostopRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleDataTypePostop_in_entryRuleDataTypePostop963);
            iv_ruleDataTypePostop=ruleDataTypePostop();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDataTypePostop.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypePostop974); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDataTypePostop


    // $ANTLR start ruleDataTypePostop
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:504:1: ruleDataTypePostop returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DataTypeVariable_0= ruleDataTypeVariable (kw= KEYWORD_1 )? ) ;
    public final AntlrDatatypeRuleToken ruleDataTypePostop() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_DataTypeVariable_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:509:6: ( (this_DataTypeVariable_0= ruleDataTypeVariable (kw= KEYWORD_1 )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:510:1: (this_DataTypeVariable_0= ruleDataTypeVariable (kw= KEYWORD_1 )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:510:1: (this_DataTypeVariable_0= ruleDataTypeVariable (kw= KEYWORD_1 )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:511:5: this_DataTypeVariable_0= ruleDataTypeVariable (kw= KEYWORD_1 )?
            {
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getDataTypePostopAccess().getDataTypeVariableParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleDataTypeVariable_in_ruleDataTypePostop1021);
            this_DataTypeVariable_0=ruleDataTypeVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_DataTypeVariable_0);
                  
            }
            if ( backtracking==0 ) {
               
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:521:1: (kw= KEYWORD_1 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==KEYWORD_1) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_3 = input.LA(3);

                    if ( (synpred7()) ) {
                        alt7=1;
                    }
                }
                else if ( (LA7_1==EOF||LA7_1==KEYWORD_1) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:522:2: kw= KEYWORD_1
                    {
                    kw=(Token)input.LT(1);
                    match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleDataTypePostop1040); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getDataTypePostopAccess().getHyphenMinusHyphenMinusKeyword_1(), null); 
                          
                    }

                    }
                    break;

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
        }
        return current;
    }
    // $ANTLR end ruleDataTypePostop


    // $ANTLR start entryRuleDataTypeVariable
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:535:1: entryRuleDataTypeVariable returns [String current=null] : iv_ruleDataTypeVariable= ruleDataTypeVariable EOF ;
    public final String entryRuleDataTypeVariable() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeVariable = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:535:57: (iv_ruleDataTypeVariable= ruleDataTypeVariable EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:536:2: iv_ruleDataTypeVariable= ruleDataTypeVariable EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDataTypeVariableRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleDataTypeVariable_in_entryRuleDataTypeVariable1081);
            iv_ruleDataTypeVariable=ruleDataTypeVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDataTypeVariable.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeVariable1092); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDataTypeVariable


    // $ANTLR start ruleDataTypeVariable
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:543:1: ruleDataTypeVariable returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleDataTypeVariable() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:548:6: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:549:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataTypeVariable1131); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getDataTypeVariableAccess().getIDTerminalRuleCall(), null); 
                  
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
        }
        return current;
    }
    // $ANTLR end ruleDataTypeVariable

    // $ANTLR start synpred5
    public final void synpred5_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:305:2: ( () ( ( KEYWORD_1 ) ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:305:2: () ( ( KEYWORD_1 ) )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:305:2: ()
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:306:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:324:2: ( ( KEYWORD_1 ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:325:1: ( KEYWORD_1 )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:325:1: ( KEYWORD_1 )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:326:3: KEYWORD_1
        {
        match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_synpred5562); if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5

    // $ANTLR start synpred7
    public final void synpred7_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:522:2: ( KEYWORD_1 )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889ExTestLanguage.g:522:2: KEYWORD_1
        {
        match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_synpred71040); if (failed) return ;

        }
    }
    // $ANTLR end synpred7

    public final boolean synpred7() {
        backtracking++;
        int start = input.mark();
        try {
            synpred7_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred5() {
        backtracking++;
        int start = input.mark();
        try {
            synpred5_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleModel119 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleModel140 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleModel160 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_ruleDataTypeExpression_in_ruleModel181 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostop_in_ruleExpression276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePreop_in_ruleExpression306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePreop_in_entryRulePreop338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePreop348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_rulePreop404 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleVariable_in_rulePreop438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostop_in_entryRulePostop471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostop481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rulePostop531 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_KEYWORD_1_in_rulePostop562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariable674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeExpression_in_entryRuleDataTypeExpression713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeExpression724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypePostop_in_ruleDataTypeExpression771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypePreop_in_ruleDataTypeExpression804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypePreop_in_entryRuleDataTypePreop848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypePreop859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleDataTypePreop897 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleDataTypeVariable_in_ruleDataTypePreop919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypePostop_in_entryRuleDataTypePostop963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypePostop974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeVariable_in_ruleDataTypePostop1021 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleDataTypePostop1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeVariable_in_entryRuleDataTypeVariable1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeVariable1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeVariable1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_synpred5562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_synpred71040 = new BitSet(new long[]{0x0000000000000002L});

}
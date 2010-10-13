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
import org.eclipse.xtext.parser.antlr.services.Bug296889TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBug296889TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Model'", "'DataType'", "'--'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalBug296889TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug296889TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug296889TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private Bug296889TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug296889TestLanguageParser(TokenStream input, IAstFactory factory, Bug296889TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug296889TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel81);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel91); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:91:6: ( ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:92:1: ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:92:1: ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:92:2: (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:92:2: (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:92:4: otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )*
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:96:1: ( (lv_expressions_1_0= ruleExpression ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID||LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:97:1: (lv_expressions_1_0= ruleExpression )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:97:1: (lv_expressions_1_0= ruleExpression )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:98:3: lv_expressions_1_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getExpressionsExpressionParserRuleCall_0_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleModel150);
                    	    lv_expressions_1_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:121:6: (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:121:6: (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:121:8: otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel171); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_2, grammarAccess.getModelAccess().getDataTypeKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:125:1: ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==13) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:126:1: (lv_values_3_0= ruleDataTypeExpression )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:126:1: (lv_values_3_0= ruleDataTypeExpression )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:127:3: lv_values_3_0= ruleDataTypeExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValuesDataTypeExpressionParserRuleCall_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleDataTypeExpression_in_ruleModel192);
                    	    lv_values_3_0=ruleDataTypeExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:157:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:158:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:159:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression230);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression240); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:166:1: ruleExpression returns [EObject current=null] : (this_Postop_0= rulePostop | this_Preop_1= rulePreop ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Postop_0 = null;

        EObject this_Preop_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:171:6: ( (this_Postop_0= rulePostop | this_Preop_1= rulePreop ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:172:1: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:172:1: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==13) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:173:2: this_Postop_0= rulePostop
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getPostopParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePostop_in_ruleExpression290);
                    this_Postop_0=rulePostop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Postop_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:186:2: this_Preop_1= rulePreop
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getPreopParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePreop_in_ruleExpression320);
                    this_Preop_1=rulePreop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Preop_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePreop"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:205:1: entryRulePreop returns [EObject current=null] : iv_rulePreop= rulePreop EOF ;
    public final EObject entryRulePreop() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreop = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:206:2: (iv_rulePreop= rulePreop EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:207:2: iv_rulePreop= rulePreop EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPreopRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePreop_in_entryRulePreop355);
            iv_rulePreop=rulePreop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePreop; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePreop365); if (state.failed) return current;

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
    // $ANTLR end "entryRulePreop"


    // $ANTLR start "rulePreop"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:214:1: rulePreop returns [EObject current=null] : ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) ) ;
    public final EObject rulePreop() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_1_0=null;
        EObject lv_expr_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:219:6: ( ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:220:1: ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:220:1: ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:220:2: () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:220:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:221:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:234:2: ( (lv_functionName_1_0= '--' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:235:1: (lv_functionName_1_0= '--' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:235:1: (lv_functionName_1_0= '--' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:236:3: lv_functionName_1_0= '--'
            {
            lv_functionName_1_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePreop420); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      createLeafNode(lv_functionName_1_0, grammarAccess.getPreopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_0(), "functionName");
                  
            }
            if ( state.backtracking==0 ) {

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:255:2: ( (lv_expr_2_0= ruleVariable ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:256:1: (lv_expr_2_0= ruleVariable )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:256:1: (lv_expr_2_0= ruleVariable )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:257:3: lv_expr_2_0= ruleVariable
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPreopAccess().getExprVariableParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_rulePreop454);
            lv_expr_2_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "rulePreop"


    // $ANTLR start "entryRulePostop"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:287:1: entryRulePostop returns [EObject current=null] : iv_rulePostop= rulePostop EOF ;
    public final EObject entryRulePostop() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostop = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:288:2: (iv_rulePostop= rulePostop EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:289:2: iv_rulePostop= rulePostop EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPostopRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostop_in_entryRulePostop490);
            iv_rulePostop=rulePostop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostop; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePostop500); if (state.failed) return current;

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
    // $ANTLR end "entryRulePostop"


    // $ANTLR start "rulePostop"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:296:1: rulePostop returns [EObject current=null] : (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? ) ;
    public final EObject rulePostop() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_2_0=null;
        EObject this_Variable_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:301:6: ( (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:302:1: (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:302:1: (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:303:2: this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getPostopAccess().getVariableParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_rulePostop550);
            this_Variable_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Variable_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:314:1: ( () ( (lv_functionName_2_0= '--' ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_3 = input.LA(3);

                    if ( (synpred5_InternalBug296889TestLanguage()) ) {
                        alt5=1;
                    }
                }
                else if ( (LA5_1==EOF||LA5_1==13) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:314:2: () ( (lv_functionName_2_0= '--' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:314:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:315:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:333:2: ( (lv_functionName_2_0= '--' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:334:1: (lv_functionName_2_0= '--' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:334:1: (lv_functionName_2_0= '--' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:335:3: lv_functionName_2_0= '--'
                    {
                    lv_functionName_2_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePostop580); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_functionName_2_0, grammarAccess.getPostopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_1_0(), "functionName");
                          
                    }
                    if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "rulePostop"


    // $ANTLR start "entryRuleVariable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:362:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:363:2: (iv_ruleVariable= ruleVariable EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:364:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVariableRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_entryRuleVariable631);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariable641); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:371:1: ruleVariable returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:376:6: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:377:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:377:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:377:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:377:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:378:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:391:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:392:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:392:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:393:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariable695); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleDataTypeExpression"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:423:1: entryRuleDataTypeExpression returns [String current=null] : iv_ruleDataTypeExpression= ruleDataTypeExpression EOF ;
    public final String entryRuleDataTypeExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeExpression = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:424:2: (iv_ruleDataTypeExpression= ruleDataTypeExpression EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:425:2: iv_ruleDataTypeExpression= ruleDataTypeExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDataTypeExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeExpression_in_entryRuleDataTypeExpression737);
            iv_ruleDataTypeExpression=ruleDataTypeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeExpression.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypeExpression748); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataTypeExpression"


    // $ANTLR start "ruleDataTypeExpression"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:432:1: ruleDataTypeExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_DataTypePostop_0 = null;

        AntlrDatatypeRuleToken this_DataTypePreop_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:437:6: ( (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:438:1: (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:438:1: (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==13) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:439:5: this_DataTypePostop_0= ruleDataTypePostop
                    {
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getDataTypeExpressionAccess().getDataTypePostopParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDataTypePostop_in_ruleDataTypeExpression795);
                    this_DataTypePostop_0=ruleDataTypePostop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DataTypePostop_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:451:5: this_DataTypePreop_1= ruleDataTypePreop
                    {
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getDataTypeExpressionAccess().getDataTypePreopParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDataTypePreop_in_ruleDataTypeExpression828);
                    this_DataTypePreop_1=ruleDataTypePreop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DataTypePreop_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "ruleDataTypeExpression"


    // $ANTLR start "entryRuleDataTypePreop"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:469:1: entryRuleDataTypePreop returns [String current=null] : iv_ruleDataTypePreop= ruleDataTypePreop EOF ;
    public final String entryRuleDataTypePreop() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypePreop = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:470:2: (iv_ruleDataTypePreop= ruleDataTypePreop EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:471:2: iv_ruleDataTypePreop= ruleDataTypePreop EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDataTypePreopRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypePreop_in_entryRuleDataTypePreop874);
            iv_ruleDataTypePreop=ruleDataTypePreop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypePreop.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypePreop885); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataTypePreop"


    // $ANTLR start "ruleDataTypePreop"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:478:1: ruleDataTypePreop returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '--' this_DataTypeVariable_1= ruleDataTypeVariable ) ;
    public final AntlrDatatypeRuleToken ruleDataTypePreop() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_DataTypeVariable_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:483:6: ( (kw= '--' this_DataTypeVariable_1= ruleDataTypeVariable ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:484:1: (kw= '--' this_DataTypeVariable_1= ruleDataTypeVariable )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:484:1: (kw= '--' this_DataTypeVariable_1= ruleDataTypeVariable )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:485:2: kw= '--' this_DataTypeVariable_1= ruleDataTypeVariable
            {
            kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDataTypePreop923); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(kw, grammarAccess.getDataTypePreopAccess().getHyphenMinusHyphenMinusKeyword_0(), null); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getDataTypePreopAccess().getDataTypeVariableParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeVariable_in_ruleDataTypePreop945);
            this_DataTypeVariable_1=ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DataTypeVariable_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                      currentNode = currentNode.getParent();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "ruleDataTypePreop"


    // $ANTLR start "entryRuleDataTypePostop"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:509:1: entryRuleDataTypePostop returns [String current=null] : iv_ruleDataTypePostop= ruleDataTypePostop EOF ;
    public final String entryRuleDataTypePostop() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypePostop = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:510:2: (iv_ruleDataTypePostop= ruleDataTypePostop EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:511:2: iv_ruleDataTypePostop= ruleDataTypePostop EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDataTypePostopRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypePostop_in_entryRuleDataTypePostop991);
            iv_ruleDataTypePostop=ruleDataTypePostop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypePostop.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypePostop1002); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataTypePostop"


    // $ANTLR start "ruleDataTypePostop"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:518:1: ruleDataTypePostop returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DataTypeVariable_0= ruleDataTypeVariable (kw= '--' )? ) ;
    public final AntlrDatatypeRuleToken ruleDataTypePostop() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_DataTypeVariable_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:523:6: ( (this_DataTypeVariable_0= ruleDataTypeVariable (kw= '--' )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:524:1: (this_DataTypeVariable_0= ruleDataTypeVariable (kw= '--' )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:524:1: (this_DataTypeVariable_0= ruleDataTypeVariable (kw= '--' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:525:5: this_DataTypeVariable_0= ruleDataTypeVariable (kw= '--' )?
            {
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getDataTypePostopAccess().getDataTypeVariableParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeVariable_in_ruleDataTypePostop1049);
            this_DataTypeVariable_0=ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DataTypeVariable_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:535:1: (kw= '--' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==EOF||LA7_1==13) ) {
                    alt7=1;
                }
                else if ( (LA7_1==RULE_ID) ) {
                    int LA7_4 = input.LA(3);

                    if ( (synpred7_InternalBug296889TestLanguage()) ) {
                        alt7=1;
                    }
                }
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:536:2: kw= '--'
                    {
                    kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDataTypePostop1068); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getDataTypePostopAccess().getHyphenMinusHyphenMinusKeyword_1(), null); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "ruleDataTypePostop"


    // $ANTLR start "entryRuleDataTypeVariable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:549:1: entryRuleDataTypeVariable returns [String current=null] : iv_ruleDataTypeVariable= ruleDataTypeVariable EOF ;
    public final String entryRuleDataTypeVariable() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeVariable = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:550:2: (iv_ruleDataTypeVariable= ruleDataTypeVariable EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:551:2: iv_ruleDataTypeVariable= ruleDataTypeVariable EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDataTypeVariableRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeVariable_in_entryRuleDataTypeVariable1111);
            iv_ruleDataTypeVariable=ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeVariable.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypeVariable1122); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataTypeVariable"


    // $ANTLR start "ruleDataTypeVariable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:558:1: ruleDataTypeVariable returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleDataTypeVariable() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:563:6: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:564:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDataTypeVariable1161); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  createLeafNode(this_ID_0, grammarAccess.getDataTypeVariableAccess().getIDTerminalRuleCall(), null); 
                  
            }

            }

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "ruleDataTypeVariable"

    // $ANTLR start synpred5_InternalBug296889TestLanguage
    public final void synpred5_InternalBug296889TestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;

        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:314:2: ( () ( (lv_functionName_2_0= '--' ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:314:2: () ( (lv_functionName_2_0= '--' ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:314:2: ()
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:315:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:333:2: ( (lv_functionName_2_0= '--' ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:334:1: (lv_functionName_2_0= '--' )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:334:1: (lv_functionName_2_0= '--' )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:335:3: lv_functionName_2_0= '--'
        {
        lv_functionName_2_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_synpred5_InternalBug296889TestLanguage580); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5_InternalBug296889TestLanguage

    // $ANTLR start synpred7_InternalBug296889TestLanguage
    public final void synpred7_InternalBug296889TestLanguage_fragment() throws RecognitionException {   
        Token kw=null;

        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:536:2: (kw= '--' )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug296889TestLanguage.g:536:2: kw= '--'
        {
        kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_synpred7_InternalBug296889TestLanguage1068); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalBug296889TestLanguage

    // Delegated rules

    public final boolean synpred7_InternalBug296889TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalBug296889TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalBug296889TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalBug296889TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel129 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleModel150 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_12_in_ruleModel171 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleDataTypeExpression_in_ruleModel192 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression230 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostop_in_ruleExpression290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePreop_in_ruleExpression320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePreop_in_entryRulePreop355 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePreop365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rulePreop420 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleVariable_in_rulePreop454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostop_in_entryRulePostop490 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePostop500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_rulePostop550 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_rulePostop580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable631 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariable641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariable695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypeExpression_in_entryRuleDataTypeExpression737 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeExpression748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypePostop_in_ruleDataTypeExpression795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypePreop_in_ruleDataTypeExpression828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypePreop_in_entryRuleDataTypePreop874 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypePreop885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleDataTypePreop923 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDataTypeVariable_in_ruleDataTypePreop945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypePostop_in_entryRuleDataTypePostop991 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypePostop1002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypeVariable_in_ruleDataTypePostop1049 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleDataTypePostop1068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypeVariable_in_entryRuleDataTypeVariable1111 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeVariable1122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeVariable1161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_synpred5_InternalBug296889TestLanguage580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_synpred7_InternalBug296889TestLanguage1068 = new BitSet(new long[]{0x0000000000000002L});
    }


}